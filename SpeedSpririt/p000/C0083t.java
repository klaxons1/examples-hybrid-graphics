package p000;

import java.io.InputStream;
import java.lang.reflect.Array;

/* JADX INFO: renamed from: t */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0083t {

    /* JADX INFO: renamed from: a */
    private static AbstractC0038bk f527a;

    /* JADX INFO: renamed from: a */
    public static Class f528a;

    /* JADX INFO: renamed from: a */
    public static C0074k f529a;

    /* JADX INFO: renamed from: a */
    public static float[] f530a;

    /* JADX INFO: renamed from: a */
    public static int[] f531a;

    /* JADX INFO: renamed from: a */
    private static AbstractC0023aw[] f532a;

    /* JADX INFO: renamed from: a */
    private static AbstractC0038bk[] f533a;

    /* JADX INFO: renamed from: a */
    private static C0054c[] f534a;

    /* JADX INFO: renamed from: a */
    private static String[] f535a;

    /* JADX INFO: renamed from: a */
    private static boolean[] f536a;

    /* JADX INFO: renamed from: a */
    private static int[][] f537a;

    /* JADX INFO: renamed from: a */
    private static InterfaceC0059ce[][] f538a;

    /* JADX INFO: renamed from: b */
    private static int[] f539b;

    /* JADX INFO: renamed from: c */
    private static int[] f540c;

    /* JADX INFO: renamed from: d */
    private static int[] f541d;

    /* JADX INFO: renamed from: a */
    public static AbstractC0038bk m262a(int i, int i2) {
        int i3 = (i + 2048) >> 12;
        int i4 = (i2 + 2048) >> 12;
        f534a[Math.min((f539b[0] * i4) + i3, f533a.length)].mo21a(false);
        return f533a[Math.min(i3 + (i4 * f539b[0]), f533a.length)];
    }

    /* JADX INFO: renamed from: a */
    private static Class m263a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m264a() {
        m267c();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:240:0x09ce A[PHI: r21 r24
  0x09ce: PHI (r21v4 float) = (r21v1 float), (r21v1 float), (r21v1 float), (r21v3 float), (r21v1 float) binds: [B:239:0x09cb, B:261:0x0b7d, B:262:0x0b7f, B:256:0x0ad3, B:248:0x0a11] A[DONT_GENERATE, DONT_INLINE]
  0x09ce: PHI (r24v5 int) = (r24v1 int), (r24v1 int), (r24v1 int), (r24v1 int), (r24v3 int) binds: [B:239:0x09cb, B:261:0x0b7d, B:262:0x0b7f, B:256:0x0ad3, B:248:0x0a11] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX INFO: renamed from: a */
    public static void m265a(String str) {
        Class clsM263a;
        int i;
        int i2;
        int i3;
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        int i4;
        char c;
        float[] fArr;
        float[] fArr2;
        m267c();
        try {
            if (f528a == null) {
                clsM263a = m263a("java.lang.Class");
                f528a = clsM263a;
            } else {
                clsM263a = f528a;
            }
            InputStream resourceAsStream = clsM263a.getResourceAsStream(str);
            byte[] bArr = new byte[resourceAsStream.available()];
            resourceAsStream.read(bArr, 0, resourceAsStream.available());
            resourceAsStream.close();
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            float f6 = 0.0f;
            float f7 = 0.0f;
            float f8 = 0.0f;
            float f9 = 0.0f;
            float f10 = 0.0f;
            int i8 = 0;
            float[] fArr3 = null;
            int i9 = -1;
            int i10 = -1;
            int i11 = -1;
            char c2 = 0;
            int i12 = 0;
            String string = "";
            int i13 = 0;
            while (i13 < bArr.length) {
                char c3 = (char) bArr[i13];
                switch (c3) {
                    case '\t':
                    case '\n':
                    case '\r':
                    case ' ':
                        i = i11;
                        i2 = i10;
                        i3 = i9;
                        f = f10;
                        f2 = f9;
                        f3 = f8;
                        f4 = f7;
                        f5 = f6;
                        break;
                    default:
                        string = new StringBuffer().append(string).append(c3).toString();
                        if (c3 == '[') {
                            string = "[";
                            c = 0;
                            i4 = 0;
                        } else {
                            i4 = i12;
                            c = c2;
                        }
                        switch (c) {
                            case 0:
                                if (string.equals("[map_size]")) {
                                    string = "";
                                    c2 = 1;
                                } else {
                                    c2 = c;
                                }
                                if (string.equals("[graphic_sets]")) {
                                    string = "";
                                    c2 = 4;
                                }
                                if (string.equals("[graphics]")) {
                                    string = "";
                                    c2 = 5;
                                }
                                if (string.equals("[collision_set]")) {
                                    string = "";
                                    c2 = 6;
                                    if (f538a == null) {
                                        f538a = new InterfaceC0059ce[1][];
                                        f538a[0] = null;
                                    } else {
                                        InterfaceC0059ce[][] interfaceC0059ceArr = new InterfaceC0059ce[f538a.length + 1][];
                                        System.arraycopy(f538a, 0, interfaceC0059ceArr, 0, f538a.length);
                                        interfaceC0059ceArr[f538a.length] = null;
                                        f538a = interfaceC0059ceArr;
                                    }
                                }
                                if (string.equals("[collisions]")) {
                                    if (f539b != null) {
                                        f541d = new int[f539b[0] * f539b[1]];
                                        for (int i14 = 0; i14 < f541d.length; i14++) {
                                            f541d[i14] = f538a.length;
                                        }
                                        InterfaceC0059ce[][] interfaceC0059ceArr2 = new InterfaceC0059ce[f538a.length + 1][];
                                        System.arraycopy(f538a, 0, interfaceC0059ceArr2, 0, f538a.length);
                                        interfaceC0059ceArr2[f538a.length] = new InterfaceC0059ce[1];
                                        interfaceC0059ceArr2[f538a.length][0] = new C0075l(-2048.0f, 2048.0f, -2048.0f, 2048.0f, 0.0f);
                                        f538a = interfaceC0059ceArr2;
                                    }
                                    string = "";
                                    c2 = 7;
                                }
                                if (string.equals("[starting_point]")) {
                                    string = "";
                                    c2 = '\b';
                                    f530a = new float[4];
                                }
                                if (string.equals("[check_points]")) {
                                    string = "";
                                    c2 = '\t';
                                }
                                if (string.equals("[cameras]")) {
                                    f527a = AbstractC0038bk.m141a(C0011ak.f158c, C0011ak.f160d, 796, 5, 8192);
                                    f533a = new AbstractC0038bk[f539b[0] * f539b[1]];
                                    f534a = new C0054c[f539b[0] * f539b[1]];
                                    for (int i15 = 0; i15 < f533a.length; i15++) {
                                        f533a[i15] = f527a;
                                        f534a[i15] = new C0054c(new StringBuffer().append("replay ").append(i15).toString());
                                        f534a[i15].m19a(f533a[i15]);
                                        f534a[i15].m191a(new C0069f(C0010aj.f137b, f527a, new C0005ae(-700, 250, -120)));
                                    }
                                    string = "";
                                    c2 = '\n';
                                    i12 = i4;
                                    i = i11;
                                    i2 = i10;
                                    i3 = i9;
                                    f = f10;
                                    f2 = f9;
                                    f3 = f8;
                                    f4 = f7;
                                    f5 = f6;
                                    continue;
                                } else {
                                    i12 = i4;
                                    i = i11;
                                    i2 = i10;
                                    i3 = i9;
                                    f = f10;
                                    f2 = f9;
                                    f3 = f8;
                                    f4 = f7;
                                    f5 = f6;
                                }
                                break;
                            case 1:
                                if (c3 == ',') {
                                    f539b = new int[2];
                                    f539b[0] = Integer.parseInt(string.substring(0, string.length() - 1));
                                    string = "";
                                }
                                if (c3 == ';') {
                                    f539b[1] = Integer.parseInt(string.substring(0, string.length() - 1));
                                    string = "";
                                    i12 = i4;
                                    c2 = c;
                                    i = i11;
                                    i2 = i10;
                                    i3 = i9;
                                    f = f10;
                                    f2 = f9;
                                    f3 = f8;
                                    f4 = f7;
                                    f5 = f6;
                                }
                                break;
                            case 4:
                                if (c3 == ',' || c3 == ';') {
                                    String strSubstring = string.substring(0, string.length() - 1);
                                    switch (i4) {
                                        case 0:
                                            if (f535a == null) {
                                                f535a = new String[1];
                                                f535a[0] = strSubstring;
                                            } else {
                                                String[] strArr = new String[f535a.length + 1];
                                                System.arraycopy(f535a, 0, strArr, 0, f535a.length);
                                                strArr[f535a.length] = strSubstring;
                                                f535a = strArr;
                                            }
                                            i12 = i4 + 1;
                                            break;
                                        case 1:
                                            if (f536a == null) {
                                                f536a = new boolean[1];
                                                if (Integer.parseInt(strSubstring) == 0) {
                                                    f536a[0] = false;
                                                } else {
                                                    f536a[0] = true;
                                                }
                                            } else {
                                                boolean[] zArr = new boolean[f536a.length + 1];
                                                System.arraycopy(f536a, 0, zArr, 0, f536a.length);
                                                if (Integer.parseInt(strSubstring) == 0) {
                                                    zArr[f536a.length] = false;
                                                } else {
                                                    zArr[f536a.length] = true;
                                                }
                                                f536a = zArr;
                                            }
                                            i12 = i4 + 1;
                                            break;
                                        case 2:
                                            if (f537a != null) {
                                                if (f537a.length < f535a.length) {
                                                    int[][] iArr = new int[f537a.length + 1][];
                                                    System.arraycopy(f537a, 0, iArr, 0, f537a.length);
                                                    iArr[f537a.length] = new int[1];
                                                    iArr[f537a.length][0] = Integer.parseInt(strSubstring);
                                                    f537a = iArr;
                                                    i12 = i4;
                                                } else {
                                                    int[] iArr2 = new int[f537a[f537a.length - 1].length + 1];
                                                    System.arraycopy(f537a[f537a.length - 1], 0, iArr2, 0, f537a[f537a.length - 1].length);
                                                    iArr2[f537a[f537a.length - 1].length] = Integer.parseInt(strSubstring);
                                                    f537a[f537a.length - 1] = iArr2;
                                                }
                                                break;
                                            } else {
                                                f537a = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, 1, 1);
                                                f537a[0][0] = Integer.parseInt(strSubstring);
                                                i12 = i4;
                                                break;
                                            }
                                        default:
                                            i12 = i4;
                                            break;
                                    }
                                    if (c3 == ';') {
                                        i12 = 0;
                                    }
                                    string = "";
                                    c2 = c;
                                    i = i11;
                                    i2 = i10;
                                    i3 = i9;
                                    f = f10;
                                    f2 = f9;
                                    f3 = f8;
                                    f4 = f7;
                                    f5 = f6;
                                }
                                break;
                            case 5:
                                if (c3 == ',' || c3 == ';') {
                                    String strSubstring2 = string.substring(0, string.length() - 1);
                                    switch (i4) {
                                        case 0:
                                            if (f540c == null) {
                                                f540c = new int[4];
                                            } else {
                                                int[] iArr3 = new int[f540c.length + 4];
                                                System.arraycopy(f540c, 0, iArr3, 0, f540c.length);
                                                f540c = iArr3;
                                            }
                                            f540c[f540c.length - 4] = Integer.parseInt(strSubstring2);
                                            break;
                                        case 1:
                                            f540c[f540c.length - 3] = Integer.parseInt(strSubstring2);
                                            break;
                                        case 2:
                                            f540c[f540c.length - 2] = Integer.parseInt(strSubstring2);
                                            break;
                                        case 3:
                                            f540c[f540c.length - 1] = Integer.parseInt(strSubstring2);
                                            break;
                                    }
                                    i12 = i4 + 1;
                                    if (c3 == ';') {
                                        i12 = 0;
                                    }
                                    string = "";
                                    c2 = c;
                                    i = i11;
                                    i2 = i10;
                                    i3 = i9;
                                    f = f10;
                                    f2 = f9;
                                    f3 = f8;
                                    f4 = f7;
                                    f5 = f6;
                                }
                                break;
                            case 6:
                                if (c3 == ',' || c3 == ';') {
                                    String strSubstring3 = string.substring(0, string.length() - 1);
                                    switch (i4) {
                                        case 0:
                                            i8 = Integer.parseInt(strSubstring3);
                                            i12 = i4 + 1;
                                            fArr = fArr3;
                                            break;
                                        case 1:
                                            if (fArr3 == null) {
                                                i12 = i4;
                                                fArr = new float[]{Float.parseFloat(strSubstring3)};
                                            } else {
                                                fArr = new float[fArr3.length + 1];
                                                System.arraycopy(fArr3, 0, fArr, 0, fArr3.length);
                                                fArr[fArr3.length] = Float.parseFloat(strSubstring3);
                                                i12 = i4;
                                            }
                                            break;
                                        default:
                                            i12 = i4;
                                            fArr = fArr3;
                                            break;
                                    }
                                    if (c3 == ';') {
                                        if (f538a[f538a.length - 1] == null) {
                                            f538a[f538a.length - 1] = new InterfaceC0059ce[1];
                                        } else {
                                            InterfaceC0059ce[] interfaceC0059ceArr3 = new InterfaceC0059ce[f538a[f538a.length - 1].length + 1];
                                            System.arraycopy(f538a[f538a.length - 1], 0, interfaceC0059ceArr3, 0, f538a[f538a.length - 1].length);
                                            f538a[f538a.length - 1] = interfaceC0059ceArr3;
                                        }
                                        switch (i8) {
                                            case 1:
                                                if (fArr.length == 4) {
                                                    f538a[f538a.length - 1][f538a[f538a.length - 1].length - 1] = new C0062ch(fArr[0], fArr[1], fArr[2], fArr[3]);
                                                }
                                                break;
                                            case 2:
                                                if (fArr.length == 4) {
                                                    f538a[f538a.length - 1][f538a[f538a.length - 1].length - 1] = new C0058cd(fArr[0], fArr[1], fArr[2], fArr[3], (short) 2);
                                                }
                                                break;
                                            case 3:
                                                if (fArr.length == 4) {
                                                    f538a[f538a.length - 1][f538a[f538a.length - 1].length - 1] = new C0058cd(fArr[0], fArr[1], fArr[2], fArr[3], (short) 3);
                                                }
                                                break;
                                            case 4:
                                                if (fArr.length == 4) {
                                                    f538a[f538a.length - 1][f538a[f538a.length - 1].length - 1] = new C0058cd(fArr[0], fArr[1], fArr[2], fArr[3], (short) 0);
                                                }
                                                break;
                                            case 5:
                                                if (fArr.length == 4) {
                                                    f538a[f538a.length - 1][f538a[f538a.length - 1].length - 1] = new C0058cd(fArr[0], fArr[1], fArr[2], fArr[3], (short) 1);
                                                }
                                                break;
                                            case 6:
                                                if (fArr.length == 4) {
                                                    f538a[f538a.length - 1][f538a[f538a.length - 1].length - 1] = new C0012al(fArr[0], fArr[1], fArr[2], fArr[3], (short) 0);
                                                }
                                                break;
                                            case 7:
                                                if (fArr.length == 4) {
                                                    f538a[f538a.length - 1][f538a[f538a.length - 1].length - 1] = new C0012al(fArr[0], fArr[1], fArr[2], fArr[3], (short) 2);
                                                }
                                                break;
                                            case 8:
                                                if (fArr.length == 4) {
                                                    f538a[f538a.length - 1][f538a[f538a.length - 1].length - 1] = new C0012al(fArr[0], fArr[1], fArr[2], fArr[3], (short) 3);
                                                }
                                                break;
                                            case 9:
                                                if (fArr.length == 4) {
                                                    f538a[f538a.length - 1][f538a[f538a.length - 1].length - 1] = new C0012al(fArr[0], fArr[1], fArr[2], fArr[3], (short) 1);
                                                }
                                                break;
                                            case 10:
                                                if (fArr.length == 7) {
                                                    f538a[f538a.length - 1][f538a[f538a.length - 1].length - 1] = new C0014an(fArr[0], fArr[1], fArr[2], fArr[3], fArr[6], fArr[4], fArr[5], true);
                                                }
                                                break;
                                            case 11:
                                                if (fArr.length == 7) {
                                                    f538a[f538a.length - 1][f538a[f538a.length - 1].length - 1] = new C0014an(fArr[0], fArr[1], fArr[2], fArr[3], fArr[6], fArr[4], fArr[5], false);
                                                }
                                                break;
                                            case 12:
                                                if (fArr.length == 5) {
                                                    f538a[f538a.length - 1][f538a[f538a.length - 1].length - 1] = new C0075l(fArr[0], fArr[1], fArr[2], fArr[3], fArr[4]);
                                                }
                                                break;
                                            case 13:
                                                if (fArr.length == 6) {
                                                    f538a[f538a.length - 1][f538a[f538a.length - 1].length - 1] = new C0063ci(fArr[0], fArr[1], fArr[2], fArr[3], fArr[0], fArr[4], fArr[3], fArr[0], fArr[5], fArr[2], fArr[1], fArr[5], fArr[2]);
                                                }
                                                break;
                                            case 14:
                                                if (fArr.length == 6) {
                                                    f538a[f538a.length - 1][f538a[f538a.length - 1].length - 1] = new C0063ci(fArr[0], fArr[1], fArr[2], fArr[3], fArr[0], fArr[5], fArr[3], fArr[0], fArr[4], fArr[2], fArr[1], fArr[4], fArr[2]);
                                                }
                                                break;
                                            case 15:
                                                if (fArr.length == 6) {
                                                    f538a[f538a.length - 1][f538a[f538a.length - 1].length - 1] = new C0063ci(fArr[0], fArr[1], fArr[2], fArr[3], fArr[0], fArr[5], fArr[3], fArr[0], fArr[5], fArr[2], fArr[1], fArr[4], fArr[2]);
                                                }
                                                break;
                                            case 16:
                                                if (fArr.length == 6) {
                                                    f538a[f538a.length - 1][f538a[f538a.length - 1].length - 1] = new C0063ci(fArr[0], fArr[1], fArr[2], fArr[3], fArr[0], fArr[4], fArr[3], fArr[0], fArr[4], fArr[2], fArr[1], fArr[5], fArr[2]);
                                                }
                                                break;
                                        }
                                        i8 = 0;
                                        fArr2 = null;
                                        i12 = 0;
                                    } else {
                                        fArr2 = fArr;
                                    }
                                    string = "";
                                    c2 = c;
                                    i = i11;
                                    i2 = i10;
                                    i3 = i9;
                                    fArr3 = fArr2;
                                    f = f10;
                                    f2 = f9;
                                    f3 = f8;
                                    f4 = f7;
                                    f5 = f6;
                                }
                                break;
                            case 7:
                                if (c3 == ',' || c3 == ';') {
                                    String strSubstring4 = string.substring(0, string.length() - 1);
                                    switch (i4) {
                                        case 0:
                                            i = Integer.parseInt(strSubstring4);
                                            i2 = i10;
                                            i3 = i9;
                                            break;
                                        case 1:
                                            i = i11;
                                            i2 = i10;
                                            i3 = Integer.parseInt(strSubstring4);
                                            break;
                                        case 2:
                                            i = i11;
                                            i2 = Integer.parseInt(strSubstring4);
                                            i3 = i9;
                                            break;
                                        default:
                                            i = i11;
                                            i2 = i10;
                                            i3 = i9;
                                            break;
                                    }
                                    i12 = i4 + 1;
                                    if (c3 == ';') {
                                        if (i >= 0) {
                                            f541d[(f539b[0] * i2) + i3] = i;
                                        }
                                        i12 = 0;
                                        i = -1;
                                        i2 = -1;
                                        i3 = -1;
                                    }
                                    string = "";
                                    c2 = c;
                                    f = f10;
                                    f2 = f9;
                                    f3 = f8;
                                    f4 = f7;
                                    f5 = f6;
                                }
                                break;
                            case '\b':
                                if (c3 == ',' || c3 == ';') {
                                    String strSubstring5 = string.substring(0, string.length() - 1);
                                    switch (i4) {
                                        case 0:
                                            f530a[0] = Float.parseFloat(strSubstring5) - 2048.0f;
                                            break;
                                        case 1:
                                            f530a[1] = Float.parseFloat(strSubstring5);
                                            break;
                                        case 2:
                                            f530a[2] = Float.parseFloat(strSubstring5) - 2048.0f;
                                            break;
                                        case 3:
                                            f530a[3] = Float.parseFloat(strSubstring5) + 180.0f;
                                            break;
                                    }
                                    i12 = i4 + 1;
                                    if (c3 == ';') {
                                        i12 = 0;
                                    }
                                    string = "";
                                    c2 = c;
                                    i = i11;
                                    i2 = i10;
                                    i3 = i9;
                                    f = f10;
                                    f2 = f9;
                                    f3 = f8;
                                    f4 = f7;
                                    f5 = f6;
                                }
                                break;
                            case '\t':
                                if (c3 == ',' || c3 == ';') {
                                    String strSubstring6 = string.substring(0, string.length() - 1);
                                    switch (i4) {
                                        case 0:
                                            if (f531a == null) {
                                                f531a = new int[2];
                                            } else {
                                                int[] iArr4 = new int[f531a.length + 2];
                                                System.arraycopy(f531a, 0, iArr4, 0, f531a.length);
                                                f531a = iArr4;
                                            }
                                            f531a[f531a.length - 2] = Integer.parseInt(strSubstring6) * 4096;
                                            break;
                                        case 1:
                                            f531a[f531a.length - 1] = Integer.parseInt(strSubstring6) * 4096;
                                            break;
                                    }
                                    i12 = i4 + 1;
                                    if (c3 == ';') {
                                        i12 = 0;
                                    }
                                    string = "";
                                    c2 = c;
                                    i = i11;
                                    i2 = i10;
                                    i3 = i9;
                                    f = f10;
                                    f2 = f9;
                                    f3 = f8;
                                    f4 = f7;
                                    f5 = f6;
                                }
                                break;
                            case '\n':
                                if (c3 == ',' || c3 == ';') {
                                    String strSubstring7 = string.substring(0, string.length() - 1);
                                    switch (i4) {
                                        case 0:
                                            i5 = Integer.parseInt(strSubstring7);
                                            f = f10;
                                            f2 = f9;
                                            f3 = f8;
                                            f4 = f7;
                                            f5 = f6;
                                            break;
                                        case 1:
                                            i6 = Integer.parseInt(strSubstring7);
                                            f = f10;
                                            f2 = f9;
                                            f3 = f8;
                                            f4 = f7;
                                            f5 = f6;
                                            break;
                                        case 2:
                                            i7 = Integer.parseInt(strSubstring7);
                                            if (i5 == 2) {
                                                f533a[(f539b[0] * i7) + i6] = C0010aj.f138b;
                                                f = f10;
                                                f2 = f9;
                                                f3 = f8;
                                                f4 = f7;
                                                f5 = f6;
                                            } else {
                                                f = f10;
                                                f2 = f9;
                                                f3 = f8;
                                                f4 = f7;
                                                f5 = f6;
                                            }
                                            break;
                                        case 3:
                                            f = f10;
                                            f2 = f9;
                                            f3 = f8;
                                            f4 = f7;
                                            f5 = Float.parseFloat(strSubstring7) - 2048.0f;
                                            break;
                                        case 4:
                                            f = f10;
                                            f2 = f9;
                                            f3 = f8;
                                            f4 = Float.parseFloat(strSubstring7);
                                            f5 = f6;
                                            break;
                                        case 5:
                                            f8 = Float.parseFloat(strSubstring7) - 2048.0f;
                                            if (i5 == 3) {
                                                f533a[(f539b[0] * i7) + i6] = AbstractC0038bk.m141a(C0011ak.f158c, C0011ak.f160d, 796, 5, 8192);
                                                f534a[(f539b[0] * i7) + i6].m19a(f533a[(f539b[0] * i7) + i6]);
                                                f533a[(f539b[0] * i7) + i6].m106b((int) f6, (int) f7, (int) f8);
                                                f534a[(f539b[0] * i7) + i6].m191a(new C0084u(C0010aj.f137b, f533a[(f539b[0] * i7) + i6]));
                                            }
                                            if (i5 == 5) {
                                                f533a[(f539b[0] * i7) + i6] = AbstractC0038bk.m141a(C0011ak.f158c, C0011ak.f160d, 796, 5, 8192);
                                                f534a[(f539b[0] * i7) + i6].m19a(f533a[(f539b[0] * i7) + i6]);
                                                f534a[(f539b[0] * i7) + i6].m191a(new C0069f(C0010aj.f137b, f533a[(f539b[0] * i7) + i6], new C0005ae((int) (2048.0f + f6), -((int) f7), (int) (2048.0f + f8))));
                                                f = f10;
                                                f2 = f9;
                                                f3 = f8;
                                                f4 = f7;
                                                f5 = f6;
                                            } else {
                                                f = f10;
                                                f2 = f9;
                                                f3 = f8;
                                                f4 = f7;
                                                f5 = f6;
                                            }
                                            break;
                                        case 6:
                                            f = f10;
                                            f2 = Float.parseFloat(strSubstring7) - 2048.0f;
                                            f3 = f8;
                                            f4 = f7;
                                            f5 = f6;
                                            break;
                                        case 7:
                                            f = Float.parseFloat(strSubstring7);
                                            f2 = f9;
                                            f3 = f8;
                                            f4 = f7;
                                            f5 = f6;
                                            break;
                                        case 8:
                                            float f11 = Float.parseFloat(strSubstring7) - 2048.0f;
                                            if (i5 == 4) {
                                                f533a[(f539b[0] * i7) + i6] = AbstractC0038bk.m141a(C0011ak.f158c, C0011ak.f160d, 796, 5, 8192);
                                                f533a[(f539b[0] * i7) + i6].m106b((int) f6, (int) f7, (int) f8);
                                                f534a[(f539b[0] * i7) + i6].m19a(f533a[(f539b[0] * i7) + i6]);
                                                C0003ac c0003ac = new C0003ac();
                                                c0003ac.m106b((int) f9, (int) f10, (int) f11);
                                                f534a[(f539b[0] * i7) + i6].m191a(new C0084u(c0003ac, f533a[(f539b[0] * i7) + i6]));
                                            }
                                            f = f10;
                                            f2 = f9;
                                            f3 = f8;
                                            f4 = f7;
                                            f5 = f6;
                                            break;
                                        default:
                                            f = f10;
                                            f2 = f9;
                                            f3 = f8;
                                            f4 = f7;
                                            f5 = f6;
                                            break;
                                    }
                                    i12 = i4 + 1;
                                    if (c3 == ';') {
                                        i12 = 0;
                                    }
                                    string = "";
                                    c2 = c;
                                    i = i11;
                                    i2 = i10;
                                    i3 = i9;
                                }
                                break;
                        }
                        i12 = i4;
                        c2 = c;
                        i = i11;
                        i2 = i10;
                        i3 = i9;
                        f = f10;
                        f2 = f9;
                        f3 = f8;
                        f4 = f7;
                        f5 = f6;
                        break;
                }
                i13++;
                i11 = i;
                i10 = i2;
                i9 = i3;
                f10 = f;
                f9 = f2;
                f8 = f3;
                f7 = f4;
                f6 = f5;
            }
            f532a = new AbstractC0023aw[f539b[0] * f539b[1]];
            for (int i16 = 0; i16 < f532a.length; i16++) {
                f532a[i16] = null;
            }
            for (int i17 = 0; i17 < f532a.length; i17++) {
                for (int i18 = 0; i18 < f540c.length; i18 += 4) {
                    if (i17 == f540c[i18 + 1] + (f540c[i18 + 2] * f539b[0])) {
                        if (f532a[i17] == null && C0052by.m185a(f535a[f540c[i18]]) != -1) {
                            f532a[i17] = C0089z.m279a(C0052by.m185a(f535a[f540c[i18]]));
                            ((AbstractC0048bu) f532a[i17]).m110d(0, (-f540c[i18 + 3]) * 1024, 0);
                            ((AbstractC0048bu) f532a[i17]).m106b(f540c[i18 + 1] * 4096, 0, f540c[i18 + 2] * 4096);
                        } else if (C0052by.m185a(f535a[f540c[i18]]) != -1) {
                            AbstractC0023aw abstractC0023aw = f532a[i17];
                            f532a[i17] = new C0003ac();
                            ((C0003ac) f532a[i17]).m19a(abstractC0023aw);
                            AbstractC0048bu abstractC0048buM279a = C0089z.m279a(C0052by.m185a(f535a[f540c[i18]]));
                            abstractC0048buM279a.m110d(0, (-f540c[i18 + 3]) * 1024, 0);
                            abstractC0048buM279a.m106b(f540c[i18 + 1] * 4096, 0, f540c[i18 + 2] * 4096);
                            ((C0003ac) f532a[i17]).m19a(abstractC0048buM279a);
                        }
                    }
                }
            }
            f529a = new C0074k(f532a, f541d, f538a, f539b[0], f539b[1], 2);
            m266b();
            System.gc();
        } catch (Exception e) {
            m267c();
            System.gc();
            e.printStackTrace();
        }
    }

    /* JADX INFO: renamed from: b */
    private static void m266b() {
        f535a = null;
        f536a = null;
        f537a = (int[][]) null;
        f540c = null;
    }

    /* JADX INFO: renamed from: c */
    private static void m267c() {
        m266b();
        f538a = (InterfaceC0059ce[][]) null;
        f541d = null;
        f529a = null;
        f539b = null;
        f530a = null;
        f531a = null;
        if (f533a != null) {
            for (int i = 0; i < f533a.length; i++) {
                f533a[i] = null;
            }
        }
        f533a = null;
        f527a = null;
        if (f534a != null) {
            for (int i2 = 0; i2 < f534a.length; i2++) {
                f534a[i2] = null;
            }
        }
        f534a = null;
        if (f532a != null) {
            for (int i3 = 0; i3 < f532a.length; i3++) {
                f532a[i3] = null;
            }
            f532a = null;
        }
        System.gc();
    }
}
