# FreeJ2ME M3G Loader vs. Swerve M3G Loader

A technical comparison of the two JSR-184 / M3G resource loaders:

| Side | Artifact | Notes |
|---|---|---|
| **FreeJ2ME** | `src/javax/microedition/m3g/Loader.java` (branch `devel`, commit `40f8c14`, 2026-08-27) | Pure-Java reference-style loader, plus an experimental patch in commit `ca75ec1` for inaccurate file-size headers |
| **Swerve** | `secret.c` — Hex-Rays 9.4 decompilation of the ARM Swerve client (Superscape / ARM, commercial M3G 1.1 engine, ~2004–2005) | `loader_create`, `loader_onData*`, `loader_getRoot*` etc. — native push-based loader |

This document is based on direct inspection of both implementations, and it was validated by parsing real M3G files in this repository (`pallot.m3g`, `GoldenWarrior/resources/BasicScene.m3g`, `GoldenWarrior/resources/Skeleton.m3g`).

> All function names like `sub_2AE6C` and all addresses below come from `secret.c`. They are Hex-Rays auto-generated names for stripped binary code — treat them as descriptive labels, not as original symbols.

---

## 1. Architecture

### FreeJ2ME — pull model, one-shot, Java objects

- `Loader.load(byte[], offset)` and `Loader.load(String)` parse the entire resource synchronously and return `Object3D[]`.
- `DataInputStream` over the whole input (`ByteArrayInputStream` or `BufferedInputStream`).
- Results are **real Java scene-graph objects** (`Mesh`, `Group`, `Texture2D`, …) created as they are parsed.
- The section stream is buffered into a `byte[]` and then parsed by a nested `Loader` on a `ByteArrayInputStream`.

### Swerve — push model, incremental, native handles

```c
loader_create(&loader);                 // 0x35FD0
loader_onDataStart(loader, &res);       // 0x36054  vtable +4
loader_onData(loader, buf, len, &res);  // 0x360D4  vtable +8
loader_onDataEnd(loader, &res);         // 0x36148  vtable +12
loader_onError(loader);                 // 0x361D8  vtable +16
```

- The caller **feeds chunks** (`loader_onData`); the loader keeps a state machine across calls and reports completion via `loader_onDataEnd`.
- Everything is an opaque native object with a reference count (`engine_getRefCount` / `engine_releaseHandle`; `loader_getRoot` increments on hand-out).
- Internally the container parser is a byte-stream state machine: `sub_2AE6C` (section framing) and `sub_2BAC0` (inner object dispatch) over `sub_2A408`-style byte/bool/int/string readers.

| FreeJ2ME | Swerve |
|---|---|
| Pull / random access | Push / streaming, must be fed in order |
| One call returns `Object3D[]` | Two-phase: feed, then `loader_getRootCount` / `loader_getRoot` |
| Java objects ref-counted by GC | Native handles with explicit refcounts |
| Errors thrown as `IOException` | Error codes (e.g. `-1200`, `-1201`, `-9`), mapped by `engine_getLastError` |

---

## 2. File-type detection

| FreeJ2ME (devel) | Swerve |
|---|---|
| `AB "JSR184" BB 0D 0A 1A 0A` (M3G) | `AB "JSR184" BB 0D 0A 1A 0A` (`dword_A56C`, line 1415) |
| `89 "PNG" 0D 0A 1A 0A` (PNG, → `Image2D`) | `BB "SWERVE" AB 0D 0A 1A 0A` (**proprietary variant**, `dword_A5EC`, line 1417) |
| `FF D8` (JPEG, → `Image2D`) | — |

- FreeJ2ME **sniffs** PNG/JPEG and returns a standalone `Image2D`; PNG chunk scanning (IHDR/tRNS/IDAT) picks the `Image2D` format, JPEG SOFn markers similarly.
- Swerve accepts only the two 12-byte M3G-family magics. It contains **no PNG/JPEG sniffing** — images only exist inside M3G `Image2D` sections. Any other identifier → error `-7`.

> Note: all M3G files in this repository use the standard `AB JSR184…` magic. The `BB SWERVE…` magic is the file format of the Swerve engine itself, and is what `loader_getbContainsExtensions` reports on.

---

## 3. Container layout (section frames)

Both implementations follow the same JSR-184 frame structure after the 12-byte magic:

```
[ compressionScheme      : u8  ]   0 = raw, 1 = compressed
[ totalSectionLength     : u32 ]   >= 13; includes data + trailing checksum
[ uncompressedLength     : u32 ]   size after decompression
[ payload                : totalSectionLength - 13 bytes ]
[ checksum               : u32 ]
```

### Difference in frame validation

| Check | FreeJ2ME (devel) | Swerve (`sub_2AE6C`) |
|---|---|---|
| `totalSectionLength >= 13` | **not checked**; `new byte[totalSectionLength - 13]` can throw `NegativeArraySizeException` | checked → error `-1201` (state 6) |
| Extended payload read | `readFully` of `totalSectionLength - 13` | streams the payload and verifies the byte count (state 11, mismatch → `-1201`) |
| Checksum | read, **discarded** | **Adler-32 verified incrementally** (`swvAdler32`); mismatch → `-9` |
| `uncompressedLength == actual output` | checked implicitly via zlib errors, not explicitly | checked via the same byte-count tracking (`-1201` on mismatch) |

Swerve is the strict one: it validates framing *and* integrity; FreeJ2ME trusts the frame and only checks that zlib does not throw.

---

## 4. Compression: zlib vs. BILZ

| FreeJ2ME | Swerve |
|---|---|
| Scheme `0` = raw | Scheme `0` = raw (`sub_A0EC`) |
| Scheme `1` = **zlib** (`java.util.zip.Inflater`) | Scheme `1` = **BILZ** — a proprietary codec selected by fourcc `0x5A4C4942` (`"BILZ"`), passed as `swvDecompressOnDataStart(1514948930, …)` (`sub_A1E4` / `sub_A21C`) |
| Anything else → `IOException("Unknown compression scheme.")` | Anything else → error `-8` |

- `BILZ` is the compression fourcc of the commercial Swerve M3G client (Superscape/ARM, "world's first commercially available JSR-184/M3G engine", then M3G 1.1 in v2.2).
- The BILZ decoder itself is **not in this binary**: `swvDecompress*` are weak/imported symbols — the codec lives in a separate module of the Swerve library. In `secret.c` we can only observe the fourcc-based selection and the push API (`OnDataStart` → `OnData` → `OnDataEnd` → `Error`).
- **No M3G file in this repository uses BILZ.** `pallot.m3g`, `BasicScene.m3g`, `Skeleton.m3g` are all standard magic + scheme `0` (raw). BILZ would appear only in `BB SWERVE…` files with `scheme = 1`.

Practical consequence: a Swerve BILZ file cannot be loaded by FreeJ2ME and vice versa, even though the container layout is identical.

---

## 5. Header section (object type 0)

Layout parsed by both:

```
versionHigh (u8)            FreeJ2ME: read, not validated
versionLow  (u8)            FreeJ2ME: read, not validated
hasExternalReferences (bool)
fileLength    (u32)         ← "totalFileSize" in the file
contentSize   (u32)         ← "approximateContentSize"
authoringField (string, NUL-terminated)
checksum (u32)              FreeJ2ME: read, discarded
```

| Aspect | FreeJ2ME | Swerve |
|---|---|---|
| Version check | none | **only `1.0` accepted**; anything else → error `-1202` (`sub_E1E8`) |
| `totalFileSize` usage | **loop bound** in devel: `while (read < totalFileSize)` | **never used** for parsing; stored in the header object, frame loop runs to end of stream |
| Authoring field | kept in `authoringField` | stored in header object, exposed via `loader_getAuthoringField` |

### The `pallot.m3g` evidence (in this repository)

`pallot.m3g` (27,417 bytes, authoring field `"Hybrid Graphics, Ltd."`) has a header that declares:

```
totalFileSize = 27420
real file size = 27417          (off by 3 bytes)
```

Simulating devel's loop:

```
frame: scheme=0 tlen=27354 ulen=27341  pos=27417
read = 27417 < totalFileSize = 27420
-> EOFException while reading the next frame
-> Loader throws IOException("Invalid M3G data")
```

So **current `devel` cannot load `pallot.m3g`**. The patch in commit `ca75ec1` ("tolerate inaccurate file size headers") changes the loop to `while (true)` and treats a clean EOF before the first byte of a new section as the end of the resource — with that patch the file loads fine. Swerve behaves the same way by construction (never consults `totalFileSize`).

---

## 6. Object-type registry

| FreeJ2ME | Swerve |
|---|---|
| Types `0..22`, plus `255` (external reference) | Types `0..22`, plus **`23`, `24`** (extension objects, serializable), plus `255` |
| Unknown type → **warning, continues** (payload is not skipped → practically desyncs) | Unknown type → **whole load fails** |
| Table driven by `if/else` chain | Vtable table: `sub_394D8` → `sub_3807C` (0–22) + `sub_390C8` (23–24) + `sub_18D24` (255); creation via `sub_18CDC(type)` |

Additionally, Swerve registers non-file types for its API (`25` → stage-set, `26` → RayIntersection, `27` → Transform, `28` → internal), which have nothing to do with the M3G file format.

The effective type range also depends on the magic:

- `BB SWERVE…` magic → types `1..24` accepted (`sub_2B980` allows up to 25 with extensions)
- standard `AB JSR184…` magic → types `1..22`

---

## 7. External references (type 255)

| FreeJ2ME | Swerve (`sub_2B804`) |
|---|---|
| Recursively `new Loader(targetPath, activeRefs).load()` | Pushes the URI onto a native XREF stack (arrays at `loader+38` / `loader+42`, count at `loader+40`) |
| Resolves relative URIs against the parent resource dir, falls back to root-relative | No path resolution inside the engine |
| **Detects cyclic references** via `activeRefs` (throws `IOException("Detected a cyclic reference loop")`) | No cycle detection — resolution is caller's job |
| Bad path → `IOException("Can't load resource: …")` | `loader_getXREFName` + `loader_resolveXREF` hand URI/object to the caller |

---

## 8. Root selection

| FreeJ2ME | Swerve |
|---|---|
| `roots` Vector maintained incrementally; `getObject(index)` removes an index from `roots` | `sub_2AB6C` marks every referenced object; `sub_2BCE8` computes roots at the end (all objects with no reference flag) |
| Index `1` (header) is invalid as a reference (`IllegalArgumentException`) | Same: referencing header → `-1202` |

Semantically equivalent; Swerve does it lazily after the whole stream is consumed.

---

## 9. Error behaviour and strictness

| Scenario | FreeJ2ME (devel) | Swerve |
|---|---|---|
| Malformed frame length | NPE/`NegativeArraySizeException` surfaced as `IOException` | error `-1201` |
| Bad Adler-32 | not checked | error `-9` |
| Wrong version | accepted | error `-1202` |
| Inner object length mismatch | `Mobile.log` warning, parsing **continues** (can desync) | `sub_2BAC0` compares consumed vs. declared length — hard failure |
| Mid-section EOF | `EOFException` → `IOException` | stream sequence error (`-1103` / `-1200`) |
| EOF at section boundary | breaks cleanly (only with `ca75ec1` patch; devel throws if `totalFileSize` was exceeded) | clean end (state machine must be back at boundary in `sub_2B304`) |

---

## 10. Compatibility summary

| Feature | FreeJ2ME (devel) | FreeJ2ME (ca75ec1 patch) | Swerve |
|---|---|---|---|
| Standard `AB JSR184…` raw files | ✔ | ✔ | ✔ |
| `totalFileSize` off by a few bytes | ✘ (`pallot.m3g` fails) | ✔ | ✔ (never checked) |
| zlib-compressed sections | ✔ | ✔ | ✘ |
| BILZ-compressed sections | ✘ | ✘ | ✔ |
| `BB SWERVE…` magic files | ✘ | ✘ | ✔ |
| Types 23/24 extensions | ✘ | ✘ | ✔ |
| PNG/JPEG standalone loading | ✔ | ✔ | ✘ |
| Adler-32 verification | ✘ | ✘ | ✔ |
| Version 1.0 enforcement | ✘ | ✘ | ✔ |
| Cyclic external ref detection | ✔ | ✔ | ✘ |

---

## 11. Bottom line

1. **Container format is the same JSR-184 layout** — the two loaders differ mostly in *how strictly and where* they enforce it.
2. **FreeJ2ME is more permissive structurally but weaker on integrity**: no checksum check, no version check, no frame-length validation, and — critically — it uses the untrustworthy header field `totalFileSize` as a parse bound, which breaks real files (proven by `pallot.m3g` in this repo).
3. **The `ca75ec1` patch is correct and necessary** for such files; it converges FreeJ2ME's behaviour toward what Swerve natively does (stream-driven termination). It does not, however, add Swerve's Adler-32/length/version validation — a deliberately strict loader would add those too.
4. **The real incompatibility is BILZ + `BB SWERVE…`** — proprietary extension points that FreeJ2ME has no decoder for; and conversely Swerve can't read zlib sections. This is the main blocker for running Swerve-produced `.m3g` assets under FreeJ2ME.
