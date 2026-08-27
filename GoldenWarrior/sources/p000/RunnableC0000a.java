package p000;

import com.nokia.mid.sound.Sound;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import javax.microedition.lcdui.Gauge;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.m3g.Appearance;
import javax.microedition.m3g.Background;
import javax.microedition.m3g.Camera;
import javax.microedition.m3g.Graphics3D;
import javax.microedition.m3g.Group;
import javax.microedition.m3g.Image2D;
import javax.microedition.m3g.Light;
import javax.microedition.m3g.Loader;
import javax.microedition.m3g.Material;
import javax.microedition.m3g.Mesh;
import javax.microedition.m3g.MorphingMesh;
import javax.microedition.m3g.Node;
import javax.microedition.m3g.Object3D;
import javax.microedition.m3g.PolygonMode;
import javax.microedition.m3g.RayIntersection;
import javax.microedition.m3g.SkinnedMesh;
import javax.microedition.m3g.Texture2D;
import javax.microedition.m3g.Transform;
import javax.microedition.m3g.TriangleStripArray;
import javax.microedition.m3g.VertexArray;
import javax.microedition.m3g.VertexBuffer;
import javax.microedition.m3g.World;
import p001a.p002a.p003a.p004a.RunnableC0001a;

/* JADX INFO: renamed from: a */
/* JADX INFO: loaded from: C:\Temp\jadx-6965330237357844059\classes.dex */
public class RunnableC0000a extends RunnableC0001a implements Runnable {

    /* JADX INFO: renamed from: K */
    public static final byte f8K = 4;

    /* JADX INFO: renamed from: L */
    public static final float f9L = 9.8f;

    /* JADX INFO: renamed from: M */
    public static final byte f10M = 3;

    /* JADX INFO: renamed from: Q */
    public static final byte f11Q = 4;

    /* JADX INFO: renamed from: R */
    public static final int f12R = 0;

    /* JADX INFO: renamed from: U */
    public static final byte f15U = 3;

    /* JADX INFO: renamed from: a1 */
    public static final int f16a1 = 66;

    /* JADX INFO: renamed from: aG */
    public static final double f17aG = 0.17453292519943295d;

    /* JADX INFO: renamed from: aK */
    public static final int f18aK = 14736912;

    /* JADX INFO: renamed from: aP */
    public static final byte f19aP = 6;

    /* JADX INFO: renamed from: aS */
    public static final byte f20aS = 0;

    /* JADX INFO: renamed from: aT */
    private static final int f21aT = 75;

    /* JADX INFO: renamed from: aV */
    public static final byte f22aV = 8;

    /* JADX INFO: renamed from: aZ */
    public static final byte f23aZ = 2;

    /* JADX INFO: renamed from: ab */
    public static final int f24ab = 0;

    /* JADX INFO: renamed from: ac */
    public static final int f25ac = 7820595;

    /* JADX INFO: renamed from: ae */
    public static final byte f26ae = 0;

    /* JADX INFO: renamed from: ah */
    public static final byte f27ah = 8;

    /* JADX INFO: renamed from: an */
    public static final int f28an = 4;

    /* JADX INFO: renamed from: ar */
    public static final byte f29ar = 9;

    /* JADX INFO: renamed from: as */
    public static final int f30as = 0;

    /* JADX INFO: renamed from: at */
    private static final int f31at = 1000;

    /* JADX INFO: renamed from: ax */
    public static final byte f32ax = 2;

    /* JADX INFO: renamed from: b2 */
    public static final byte f33b2 = 1;

    /* JADX INFO: renamed from: b4 */
    public static final int f34b4 = 36;

    /* JADX INFO: renamed from: bA */
    public static final int f35bA = 7330159;

    /* JADX INFO: renamed from: bB */
    public static final int f36bB = 109;

    /* JADX INFO: renamed from: bF */
    public static final int f37bF = 8;

    /* JADX INFO: renamed from: bI */
    public static final float f38bI = 5.5f;

    /* JADX INFO: renamed from: bK */
    public static final int f39bK = 6;

    /* JADX INFO: renamed from: bO */
    public static final byte f40bO = 0;

    /* JADX INFO: renamed from: bQ */
    private static final int f41bQ = -45;

    /* JADX INFO: renamed from: bR */
    public static final byte f42bR = 3;

    /* JADX INFO: renamed from: bT */
    public static final byte f43bT = 5;

    /* JADX INFO: renamed from: ba */
    public static final int f44ba = -2;

    /* JADX INFO: renamed from: be */
    public static final int f45be = 1;

    /* JADX INFO: renamed from: bi */
    private static final int f46bi = 450;

    /* JADX INFO: renamed from: bm */
    public static final int f47bm = -5;

    /* JADX INFO: renamed from: bp */
    private static final int f48bp = 250;

    /* JADX INFO: renamed from: bq */
    public static final int f49bq = 500;

    /* JADX INFO: renamed from: bs */
    public static final byte f50bs = 7;

    /* JADX INFO: renamed from: c0 */
    public static final int f51c0 = -1;

    /* JADX INFO: renamed from: c1 */
    public static final byte f52c1 = 0;

    /* JADX INFO: renamed from: c6 */
    public static final byte f53c6 = 5;

    /* JADX INFO: renamed from: cG */
    public static final int f54cG = 2;

    /* JADX INFO: renamed from: cH */
    public static final int f55cH = 16;

    /* JADX INFO: renamed from: cI */
    public static final int f56cI = 165;

    /* JADX INFO: renamed from: cN */
    public static final byte f57cN = 0;

    /* JADX INFO: renamed from: cW */
    public static final int f58cW = 4;

    /* JADX INFO: renamed from: cX */
    public static final int f59cX = 19;

    /* JADX INFO: renamed from: cb */
    public static final int f60cb = 1;

    /* JADX INFO: renamed from: ce */
    public static final byte f61ce = 6;

    /* JADX INFO: renamed from: cg */
    public static final int f62cg = 3;

    /* JADX INFO: renamed from: ci */
    public static final int f63ci = 33;

    /* JADX INFO: renamed from: cm */
    public static final int f64cm = 175;

    /* JADX INFO: renamed from: cn */
    public static final byte f65cn = 4;

    /* JADX INFO: renamed from: cs */
    public static final byte f66cs = 1;

    /* JADX INFO: renamed from: cu */
    public static final int f67cu = 16777215;

    /* JADX INFO: renamed from: cv */
    public static final int f68cv = 1;

    /* JADX INFO: renamed from: cw */
    public static final byte f69cw = 0;

    /* JADX INFO: renamed from: cz */
    public static final int f70cz = 3;

    /* JADX INFO: renamed from: d1 */
    private static final int f71d1 = 55;

    /* JADX INFO: renamed from: d2 */
    public static final int f72d2 = 4210943;

    /* JADX INFO: renamed from: d3 */
    public static final byte f73d3 = 3;

    /* JADX INFO: renamed from: d4 */
    public static final byte f74d4 = 1;

    /* JADX INFO: renamed from: d6 */
    public static final int f75d6 = 4;

    /* JADX INFO: renamed from: d8 */
    public static final int f76d8 = 41;

    /* JADX INFO: renamed from: d9 */
    public static final byte f77d9 = 1;

    /* JADX INFO: renamed from: dG */
    public static final int f78dG = 49;

    /* JADX INFO: renamed from: dK */
    public static final byte f79dK = 1;

    /* JADX INFO: renamed from: dL */
    public static final int f80dL = -3;

    /* JADX INFO: renamed from: dM */
    public static final int f81dM = 35;

    /* JADX INFO: renamed from: dO */
    public static final byte f82dO = 0;

    /* JADX INFO: renamed from: dR */
    public static final int f83dR = 2;

    /* JADX INFO: renamed from: dU */
    public static final int f84dU = 2500;

    /* JADX INFO: renamed from: dV */
    public static final int f85dV = 7;

    /* JADX INFO: renamed from: dW */
    public static final int f86dW = 50;

    /* JADX INFO: renamed from: da */
    public static final int f87da = 2;

    /* JADX INFO: renamed from: db */
    public static final int f88db = 13;

    /* JADX INFO: renamed from: df */
    public static final int f89df = 17;

    /* JADX INFO: renamed from: dk */
    public static final int f90dk = 250;

    /* JADX INFO: renamed from: dl */
    public static final int f91dl = 11075584;

    /* JADX INFO: renamed from: dr */
    public static final byte f92dr = 2;

    /* JADX INFO: renamed from: dv */
    public static final int f93dv = -4;

    /* JADX INFO: renamed from: e3 */
    public static final int f94e3 = 0;

    /* JADX INFO: renamed from: e4 */
    public static final byte f95e4 = 1;

    /* JADX INFO: renamed from: e5 */
    public static final byte f96e5 = 5;

    /* JADX INFO: renamed from: eB */
    public static final byte f97eB = 2;

    /* JADX INFO: renamed from: eI */
    public static final int f98eI = 12;

    /* JADX INFO: renamed from: eK */
    public static final byte f99eK = 1;

    /* JADX INFO: renamed from: eL */
    public static final int f100eL = 92;

    /* JADX INFO: renamed from: eM */
    public static final int f101eM = 1500;

    /* JADX INFO: renamed from: eO */
    private static final int f102eO = 64;

    /* JADX INFO: renamed from: eP */
    private static final int f103eP = 5;

    /* JADX INFO: renamed from: eV */
    public static final int f104eV = 4;

    /* JADX INFO: renamed from: eW */
    public static final int f105eW = 63;

    /* JADX INFO: renamed from: eX */
    public static final int f106eX = 12632256;

    /* JADX INFO: renamed from: ef */
    public static final byte f107ef = 2;

    /* JADX INFO: renamed from: ei */
    public static final int f108ei = 6;

    /* JADX INFO: renamed from: el */
    public static final byte f109el = 7;

    /* JADX INFO: renamed from: ep */
    public static final int f110ep = 10442247;

    /* JADX INFO: renamed from: fa */
    public static final int f112fa = 56;

    /* JADX INFO: renamed from: fh */
    public static final byte f113fh = 6;

    /* JADX INFO: renamed from: fi */
    public static final byte f114fi = 4;

    /* JADX INFO: renamed from: fn */
    public static final int f116fn = 22;

    /* JADX INFO: renamed from: fo */
    private static final int f117fo = 75;

    /* JADX INFO: renamed from: fp */
    private static final int f118fp = -100;

    /* JADX INFO: renamed from: I */
    public float[] f119I;

    /* JADX INFO: renamed from: J */
    private Image f120J;

    /* JADX INFO: renamed from: N */
    public World f121N;

    /* JADX INFO: renamed from: O */
    public World f122O;

    /* JADX INFO: renamed from: P */
    private int[] f123P;

    /* JADX INFO: renamed from: V */
    private int f124V;

    /* JADX INFO: renamed from: X */
    public int f126X;

    /* JADX INFO: renamed from: Y */
    public byte f127Y;

    /* JADX INFO: renamed from: Z */
    public int f128Z;

    /* JADX INFO: renamed from: a0 */
    Mesh f129a0;

    /* JADX INFO: renamed from: a2 */
    private byte[] f130a2;

    /* JADX INFO: renamed from: a3 */
    private byte[] f131a3;

    /* JADX INFO: renamed from: a4 */
    private int[] f132a4;

    /* JADX INFO: renamed from: a5 */
    Light f133a5;

    /* JADX INFO: renamed from: a6 */
    Mesh f134a6;

    /* JADX INFO: renamed from: a7 */
    private boolean f135a7;

    /* JADX INFO: renamed from: aA */
    public int[] f138aA;

    /* JADX INFO: renamed from: aB */
    public int[] f139aB;

    /* JADX INFO: renamed from: aC */
    public byte[][] f140aC;

    /* JADX INFO: renamed from: aD */
    private boolean f141aD;

    /* JADX INFO: renamed from: aE */
    public Texture2D f142aE;

    /* JADX INFO: renamed from: aF */
    public World f143aF;

    /* JADX INFO: renamed from: aI */
    private boolean f145aI;

    /* JADX INFO: renamed from: aJ */
    public int f146aJ;

    /* JADX INFO: renamed from: aL */
    public byte[] f147aL;

    /* JADX INFO: renamed from: aM */
    private int[] f148aM;

    /* JADX INFO: renamed from: aN */
    private boolean f149aN;

    /* JADX INFO: renamed from: aO */
    public World f150aO;

    /* JADX INFO: renamed from: aQ */
    public byte[] f151aQ;

    /* JADX INFO: renamed from: aR */
    private Image f152aR;

    /* JADX INFO: renamed from: aU */
    private byte[][] f153aU;

    /* JADX INFO: renamed from: aW */
    public byte[] f154aW;

    /* JADX INFO: renamed from: aX */
    public boolean f155aX;

    /* JADX INFO: renamed from: aY */
    public Image f156aY;

    /* JADX INFO: renamed from: ad */
    public boolean[] f158ad;

    /* JADX INFO: renamed from: af */
    public byte[] f159af;

    /* JADX INFO: renamed from: ag */
    public byte[] f160ag;

    /* JADX INFO: renamed from: ai */
    public int[] f161ai;

    /* JADX INFO: renamed from: ak */
    public byte f163ak;

    /* JADX INFO: renamed from: al */
    public boolean f164al;

    /* JADX INFO: renamed from: am */
    public int f165am;

    /* JADX INFO: renamed from: ap */
    public int f167ap;

    /* JADX INFO: renamed from: aq */
    Camera f168aq;

    /* JADX INFO: renamed from: au */
    boolean f169au;

    /* JADX INFO: renamed from: av */
    public boolean f170av;

    /* JADX INFO: renamed from: aw */
    public Image f171aw;

    /* JADX INFO: renamed from: ay */
    public byte[] f172ay;

    /* JADX INFO: renamed from: az */
    public World f173az;

    /* JADX INFO: renamed from: b0 */
    public Image f174b0;

    /* JADX INFO: renamed from: b1 */
    public int[] f175b1;

    /* JADX INFO: renamed from: b5 */
    public byte[] f177b5;

    /* JADX INFO: renamed from: b6 */
    public byte[] f178b6;

    /* JADX INFO: renamed from: b7 */
    public byte[] f179b7;

    /* JADX INFO: renamed from: b8 */
    public byte[] f180b8;

    /* JADX INFO: renamed from: b9 */
    public byte[] f181b9;

    /* JADX INFO: renamed from: bC */
    public int f182bC;

    /* JADX INFO: renamed from: bD */
    public int[] f183bD;

    /* JADX INFO: renamed from: bE */
    private boolean f184bE;

    /* JADX INFO: renamed from: bG */
    public int f185bG;

    /* JADX INFO: renamed from: bH */
    private float f186bH;

    /* JADX INFO: renamed from: bJ */
    private boolean f187bJ;

    /* JADX INFO: renamed from: bL */
    private Image f188bL;

    /* JADX INFO: renamed from: bM */
    private int f189bM;

    /* JADX INFO: renamed from: bN */
    private boolean f190bN;

    /* JADX INFO: renamed from: bP */
    public boolean f191bP;

    /* JADX INFO: renamed from: bS */
    private byte f192bS;

    /* JADX INFO: renamed from: bU */
    public byte[] f193bU;

    /* JADX INFO: renamed from: bV */
    private World f194bV;

    /* JADX INFO: renamed from: bW */
    public byte[] f195bW;

    /* JADX INFO: renamed from: bZ */
    public int f198bZ;

    /* JADX INFO: renamed from: bc */
    private float[] f200bc;

    /* JADX INFO: renamed from: bf */
    Camera f202bf;

    /* JADX INFO: renamed from: bg */
    public int f203bg;

    /* JADX INFO: renamed from: bh */
    private boolean f204bh;

    /* JADX INFO: renamed from: bj */
    public Texture2D f205bj;

    /* JADX INFO: renamed from: bk */
    public float[] f206bk;

    /* JADX INFO: renamed from: bl */
    boolean f207bl;

    /* JADX INFO: renamed from: bn */
    public byte[] f208bn;

    /* JADX INFO: renamed from: bo */
    public byte[] f209bo;

    /* JADX INFO: renamed from: br */
    private Image f210br;

    /* JADX INFO: renamed from: bt */
    private Image f211bt;

    /* JADX INFO: renamed from: bu */
    Mesh f212bu;

    /* JADX INFO: renamed from: bv */
    public int f213bv;

    /* JADX INFO: renamed from: bw */
    private boolean f214bw;

    /* JADX INFO: renamed from: bx */
    private int[] f215bx;

    /* JADX INFO: renamed from: by */
    public Image f216by;

    /* JADX INFO: renamed from: bz */
    public int f217bz;

    /* JADX INFO: renamed from: c2 */
    private byte[] f218c2;

    /* JADX INFO: renamed from: c3 */
    public int[] f219c3;

    /* JADX INFO: renamed from: c4 */
    private byte[] f220c4;

    /* JADX INFO: renamed from: c5 */
    private boolean[] f221c5;

    /* JADX INFO: renamed from: c7 */
    public boolean f222c7;

    /* JADX INFO: renamed from: c8 */
    int f223c8;

    /* JADX INFO: renamed from: c9 */
    public World f224c9;

    /* JADX INFO: renamed from: cA */
    public World f225cA;

    /* JADX INFO: renamed from: cC */
    public int f227cC;

    /* JADX INFO: renamed from: cD */
    Mesh f228cD;

    /* JADX INFO: renamed from: cE */
    public boolean f229cE;

    /* JADX INFO: renamed from: cJ */
    public World f231cJ;

    /* JADX INFO: renamed from: cK */
    public int[] f232cK;

    /* JADX INFO: renamed from: cL */
    int f233cL;

    /* JADX INFO: renamed from: cM */
    private boolean f234cM;

    /* JADX INFO: renamed from: cQ */
    public World f237cQ;

    /* JADX INFO: renamed from: cR */
    public byte[] f238cR;

    /* JADX INFO: renamed from: cS */
    private float f239cS;

    /* JADX INFO: renamed from: cT */
    public byte[] f240cT;

    /* JADX INFO: renamed from: cU */
    public int f241cU;

    /* JADX INFO: renamed from: cV */
    public World f242cV;

    /* JADX INFO: renamed from: cY */
    private boolean f243cY;

    /* JADX INFO: renamed from: cZ */
    SkinnedMesh f244cZ;

    /* JADX INFO: renamed from: ca */
    public byte[] f245ca;

    /* JADX INFO: renamed from: cd */
    private boolean f247cd;

    /* JADX INFO: renamed from: cf */
    public boolean f248cf;

    /* JADX INFO: renamed from: ch */
    public String f249ch;

    /* JADX INFO: renamed from: cj */
    private int[] f250cj;

    /* JADX INFO: renamed from: cl */
    public int f252cl;

    /* JADX INFO: renamed from: co */
    public int[][] f253co;

    /* JADX INFO: renamed from: cp */
    public int[][] f254cp;

    /* JADX INFO: renamed from: cq */
    private boolean f255cq;

    /* JADX INFO: renamed from: cr */
    private boolean f256cr;

    /* JADX INFO: renamed from: ct */
    private World f257ct;

    /* JADX INFO: renamed from: cx */
    public float[] f258cx;

    /* JADX INFO: renamed from: cy */
    public int f259cy;

    /* JADX INFO: renamed from: d0 */
    public byte[] f260d0;

    /* JADX INFO: renamed from: d5 */
    boolean f261d5;

    /* JADX INFO: renamed from: dA */
    public World f263dA;

    /* JADX INFO: renamed from: dB */
    public int[] f264dB;

    /* JADX INFO: renamed from: dC */
    long f265dC;

    /* JADX INFO: renamed from: dD */
    Group f266dD;

    /* JADX INFO: renamed from: dE */
    private boolean[] f267dE;

    /* JADX INFO: renamed from: dF */
    private int f268dF;

    /* JADX INFO: renamed from: dH */
    private byte f269dH;

    /* JADX INFO: renamed from: dI */
    public boolean f270dI;

    /* JADX INFO: renamed from: dN */
    public Image[] f272dN;

    /* JADX INFO: renamed from: dP */
    private float f273dP;

    /* JADX INFO: renamed from: dQ */
    private boolean f274dQ;

    /* JADX INFO: renamed from: dS */
    public int f275dS;

    /* JADX INFO: renamed from: dT */
    Camera f276dT;

    /* JADX INFO: renamed from: dX */
    public World f277dX;

    /* JADX INFO: renamed from: dY */
    public boolean[] f278dY;

    /* JADX INFO: renamed from: dZ */
    int[] f279dZ;

    /* JADX INFO: renamed from: dc */
    private boolean f280dc;

    /* JADX INFO: renamed from: dd */
    public boolean f281dd;

    /* JADX INFO: renamed from: de */
    private boolean[] f282de;

    /* JADX INFO: renamed from: dh */
    public boolean f284dh;

    /* JADX INFO: renamed from: di */
    private int[][] f285di;

    /* JADX INFO: renamed from: dj */
    public boolean f286dj;

    /* JADX INFO: renamed from: dm */
    public int f287dm;

    /* JADX INFO: renamed from: dn */
    int f288dn;

    /* JADX INFO: renamed from: dp */
    public byte f289dp;

    /* JADX INFO: renamed from: dq */
    public Image[] f290dq;

    /* JADX INFO: renamed from: ds */
    public int f291ds;

    /* JADX INFO: renamed from: dt */
    private int[] f292dt;

    /* JADX INFO: renamed from: du */
    public int f293du;

    /* JADX INFO: renamed from: dw */
    SkinnedMesh f294dw;

    /* JADX INFO: renamed from: dx */
    public int f295dx;

    /* JADX INFO: renamed from: dy */
    private float f296dy;

    /* JADX INFO: renamed from: dz */
    public boolean f297dz;

    /* JADX INFO: renamed from: e0 */
    public byte[] f298e0;

    /* JADX INFO: renamed from: e1 */
    public byte[] f299e1;

    /* JADX INFO: renamed from: e6 */
    public boolean f301e6;

    /* JADX INFO: renamed from: e8 */
    private byte[][] f303e8;

    /* JADX INFO: renamed from: e9 */
    public boolean f304e9;

    /* JADX INFO: renamed from: eA */
    public boolean[] f305eA;

    /* JADX INFO: renamed from: eC */
    private boolean f306eC;

    /* JADX INFO: renamed from: eD */
    public int f307eD;

    /* JADX INFO: renamed from: eE */
    public World f308eE;

    /* JADX INFO: renamed from: eF */
    Image f309eF;

    /* JADX INFO: renamed from: eG */
    public int f310eG;

    /* JADX INFO: renamed from: eH */
    public boolean[] f311eH;

    /* JADX INFO: renamed from: eJ */
    public int f312eJ;

    /* JADX INFO: renamed from: eN */
    public byte f313eN;

    /* JADX INFO: renamed from: eQ */
    private boolean f314eQ;

    /* JADX INFO: renamed from: eR */
    private int f315eR;

    /* JADX INFO: renamed from: eT */
    public int f317eT;

    /* JADX INFO: renamed from: eU */
    Sound[] f318eU;

    /* JADX INFO: renamed from: eY */
    float f319eY;

    /* JADX INFO: renamed from: eZ */
    Camera f320eZ;

    /* JADX INFO: renamed from: ea */
    public float f321ea;

    /* JADX INFO: renamed from: eb */
    public float f322eb;

    /* JADX INFO: renamed from: ec */
    public float f323ec;

    /* JADX INFO: renamed from: eg */
    private Image f326eg;

    /* JADX INFO: renamed from: eh */
    long f327eh;

    /* JADX INFO: renamed from: ej */
    public Image f328ej;

    /* JADX INFO: renamed from: ek */
    private boolean f329ek;

    /* JADX INFO: renamed from: em */
    public boolean f330em;

    /* JADX INFO: renamed from: en */
    private boolean[] f331en;

    /* JADX INFO: renamed from: eo */
    private int[] f332eo;

    /* JADX INFO: renamed from: eq */
    public boolean f333eq;

    /* JADX INFO: renamed from: er */
    private int f334er;

    /* JADX INFO: renamed from: et */
    public World f335et;

    /* JADX INFO: renamed from: eu */
    public int f336eu;

    /* JADX INFO: renamed from: ev */
    private boolean f337ev;

    /* JADX INFO: renamed from: ez */
    private float[] f341ez;

    /* JADX INFO: renamed from: fc */
    private float f343fc;

    /* JADX INFO: renamed from: fd */
    boolean f344fd;

    /* JADX INFO: renamed from: fe */
    private float f345fe;

    /* JADX INFO: renamed from: ff */
    private boolean f346ff;

    /* JADX INFO: renamed from: fj */
    private int f348fj;

    /* JADX INFO: renamed from: fk */
    private int f349fk;

    /* JADX INFO: renamed from: fm */
    public int f350fm;

    /* JADX INFO: renamed from: fq */
    private float f351fq;

    /* JADX INFO: renamed from: fr */
    private int f352fr;

    /* JADX INFO: renamed from: fs */
    private int f353fs;

    /* JADX INFO: renamed from: ft */
    public float[] f354ft;

    /* JADX INFO: renamed from: h */
    private boolean f355h;

    /* JADX INFO: renamed from: u */
    private Thread f356u;

    /* JADX INFO: renamed from: fl */
    public static final int[][] f115fl = {new int[]{100, 100, 100, 200, 150, 150}, new int[]{100, 100, 100, 50, 150, 150}, new int[]{50, 50, 100, 100, 100, 100}, new int[]{100, 100, 100, 100, 150, 150}, new int[]{50, 50, 100, 100, 100, 100}};

    /* JADX INFO: renamed from: T */
    public static float[] f14T = {0.4f, 0.6f, 0.4f, 0.6f, 0.5f};

    /* JADX INFO: renamed from: S */
    public static float[] f13S = {0.4f, 0.6f, 0.6f, 0.4f, 0.5f};

    /* JADX INFO: renamed from: es */
    static long f111es = 0;

    /* JADX INFO: renamed from: a8 */
    private String f136a8 = "";

    /* JADX INFO: renamed from: aa */
    private float f157aa = 0.0f;

    /* JADX INFO: renamed from: fb */
    private float f342fb = 0.0f;

    /* JADX INFO: renamed from: e2 */
    private int f300e2 = 5;

    /* JADX INFO: renamed from: bd */
    private boolean f201bd = false;

    /* JADX INFO: renamed from: cF */
    public boolean f230cF = false;

    /* JADX INFO: renamed from: cB */
    public boolean f226cB = false;

    /* JADX INFO: renamed from: W */
    private boolean f125W = false;

    /* JADX INFO: renamed from: b3 */
    private int f176b3 = 100;

    /* JADX INFO: renamed from: ck */
    private int f251ck = 100;

    /* JADX INFO: renamed from: cc */
    private int f246cc = 50;

    /* JADX INFO: renamed from: dg */
    public String f283dg = "";

    /* JADX INFO: renamed from: a9 */
    public String f137a9 = "";

    /* JADX INFO: renamed from: dJ */
    boolean f271dJ = true;

    /* JADX INFO: renamed from: d7 */
    Graphics3D f262d7 = Graphics3D.getInstance();

    /* JADX INFO: renamed from: ew */
    Background f338ew = new Background();

    /* JADX INFO: renamed from: aH */
    public boolean f144aH = false;

    /* JADX INFO: renamed from: bb */
    public boolean f199bb = false;

    /* JADX INFO: renamed from: bY */
    boolean f197bY = false;

    /* JADX INFO: renamed from: ee */
    public int[] f325ee = new int[4];

    /* JADX INFO: renamed from: ed */
    public int[] f324ed = new int[4];

    /* JADX INFO: renamed from: cP */
    public int f236cP = 0;

    /* JADX INFO: renamed from: ey */
    int[] f340ey = new int[4];

    /* JADX INFO: renamed from: ex */
    int[] f339ex = new int[4];

    /* JADX INFO: renamed from: cO */
    public boolean f235cO = true;

    /* JADX INFO: renamed from: ao */
    Transform f166ao = new Transform();

    /* JADX INFO: renamed from: eS */
    float f316eS = 0.0f;

    /* JADX INFO: renamed from: e7 */
    boolean f302e7 = false;

    /* JADX INFO: renamed from: fg */
    int f347fg = 4;

    /* JADX INFO: renamed from: bX */
    String f196bX = "p";

    /* JADX INFO: renamed from: aj */
    private int f162aj = -1;

    public RunnableC0000a() {
        m74do("quiver");
        m74do("immortal");
        m74do("rich");
        m74do("goldkey");
        m74do("silverkey");
        m74do("bronzekey");
        m74do("doomed");
        m74do("allkeys");
        m74do("patrick");
        m74do("heromode");
        m74do("fullhealth");
        m74do("patcombo");
    }

    /* JADX INFO: renamed from: a */
    public static final float m1a(float f) {
        float fM98for;
        int i = f < 0.0f ? -1 : 1;
        float fAbs = Math.abs(f);
        if (fAbs <= 0.4375f) {
            fM98for = m98for(fAbs);
        } else if (fAbs <= 0.6875f) {
            fM98for = m98for((fAbs - 0.5f) / ((fAbs / 2.0f) + 1.0f)) + 0.4636476f;
        } else if (fAbs <= 1.1875f) {
            fM98for = m98for((fAbs - 1.0f) / (fAbs + 1.0f)) + 0.7853982f;
        } else {
            fM98for = fAbs <= 2.4375f ? m98for((fAbs - 1.5f) / ((fAbs * 1.5f) + 1.0f)) + 0.98279375f : m98for((-1.0f) / fAbs) + 1.5707964f;
        }
        return i * fM98for;
    }

    /* JADX INFO: renamed from: a */
    public static final float m2a(float[] fArr) {
        float f = fArr[0];
        if (fArr.length != 1) {
            for (int i = 1; i < fArr.length; i++) {
                if (fArr[i] > f) {
                    f = fArr[i];
                }
            }
        }
        return f;
    }

    /* JADX INFO: renamed from: a */
    private static final byte[] m3a(byte[] bArr, byte b) {
        byte[] bArr2 = new byte[bArr.length + 1];
        bArr2[bArr.length] = b;
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    /* JADX INFO: renamed from: a */
    private float[] m4a(float f, int i, int i2, int i3) {
        double radians = Math.toRadians(f) / 2.0d;
        return new float[]{((float) Math.sin(radians)) * i, ((float) Math.sin(radians)) * i2, ((float) Math.sin(radians)) * i3, (float) Math.cos(radians)};
    }

    /* JADX INFO: renamed from: a */
    public static final float[] m5a(float[] fArr, float f) {
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = fArr[i] + f;
        }
        return fArr;
    }

    /* JADX INFO: renamed from: a */
    public static final float[] m6a(float[] fArr, int i) {
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = fArr[i2] / i;
        }
        return fArr;
    }

    /* JADX INFO: renamed from: a */
    private float[] m7a(float[] fArr, float[] fArr2) {
        return new float[]{(((fArr[3] * fArr2[0]) + (fArr[0] * fArr2[3])) + (fArr[1] * fArr2[2])) - (fArr[2] * fArr2[1]), (((fArr[3] * fArr2[1]) + (fArr[1] * fArr2[3])) + (fArr[2] * fArr2[0])) - (fArr[0] * fArr2[2]), (((fArr[3] * fArr2[2]) + (fArr[2] * fArr2[3])) + (fArr[0] * fArr2[1])) - (fArr[1] * fArr2[0]), (((fArr[3] * fArr2[3]) - (fArr[0] * fArr2[0])) - (fArr[1] * fArr2[1])) - (fArr[2] * fArr2[2])};
    }

    /* JADX INFO: renamed from: a */
    public static final int[] m8a(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = iArr[i2] / i;
        }
        return iArr;
    }

    /* JADX INFO: renamed from: a */
    public static final synchronized byte[][] m9a(byte[][] bArr, int i) {
        byte[][] bArr2;
        bArr[i] = null;
        int length = bArr.length - 1;
        if (length == 0) {
            bArr2 = new byte[0][];
        } else {
            bArr2 = new byte[length][];
            if (i == bArr.length - 1) {
                System.arraycopy(bArr, 0, bArr2, 0, bArr.length - 1);
            } else if (i == 0) {
                System.arraycopy(bArr, 1, bArr2, 0, bArr.length - 1);
            } else {
                System.arraycopy(bArr, 0, bArr2, 0, i);
                System.arraycopy(bArr, i + 1, bArr2, i, (bArr.length - 1) - i);
            }
        }
        return bArr2;
    }

    /* JADX INFO: renamed from: a */
    private static final byte[][] m10a(byte[][] bArr, byte[] bArr2) {
        byte[][] bArr3 = new byte[bArr.length + 1][];
        bArr3[bArr.length] = bArr2;
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        return bArr3;
    }

    /* JADX INFO: renamed from: a */
    public static final synchronized int[][] m11a(int[][] iArr, int i) {
        int[][] iArr2;
        iArr[i] = null;
        int length = iArr.length - 1;
        if (length == 0) {
            iArr2 = new int[0][];
        } else {
            iArr2 = new int[length][];
            if (i == iArr.length - 1) {
                System.arraycopy(iArr, 0, iArr2, 0, iArr.length - 1);
            } else if (i == 0) {
                System.arraycopy(iArr, 1, iArr2, 0, iArr.length - 1);
            } else {
                System.arraycopy(iArr, 0, iArr2, 0, i);
                System.arraycopy(iArr, i + 1, iArr2, i, (iArr.length - 1) - i);
            }
        }
        return iArr2;
    }

    /* JADX INFO: renamed from: a */
    private static final int[][] m12a(int[][] iArr, int[] iArr2) {
        int[][] iArr3 = new int[iArr.length + 1][];
        iArr3[iArr.length] = iArr2;
        System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
        return iArr3;
    }

    /* JADX INFO: renamed from: do */
    private final int m13do(float f) {
        return ((int) f) / this.f227cC;
    }

    /* JADX INFO: renamed from: do */
    public static final int m14do(int[] iArr) {
        int i = iArr[0];
        if (iArr.length != 1) {
            for (int i2 = 1; i2 < iArr.length; i2++) {
                if (iArr[i2] < i) {
                    i = iArr[i2];
                }
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: do */
    public static final float[] m15do(float[] fArr, float f) {
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = fArr[i] * f;
        }
        return fArr;
    }

    /* JADX INFO: renamed from: do */
    public static final float[] m16do(float[] fArr, int i) {
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = fArr[i2] - i;
        }
        return fArr;
    }

    /* JADX INFO: renamed from: do */
    public static final int[] m17do(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = iArr[i2] - i;
        }
        return iArr;
    }

    /* JADX INFO: renamed from: for, reason: not valid java name */
    public static final float m98for(float f) {
        float f2 = f * f;
        int i = 1;
        boolean z = false;
        float f3 = f;
        float f4 = f;
        while (i < 4) {
            float f5 = f3 * f2;
            f4 = z ? (f5 / ((i * 2) + 1)) + f4 : f4 - (f5 / ((i * 2) + 1));
            i++;
            z = !z;
            f3 = f5;
        }
        return f4;
    }

    /* JADX INFO: renamed from: for, reason: not valid java name */
    private final int m99for(int i) {
        return i / this.f336eu;
    }

    /* JADX INFO: renamed from: for, reason: not valid java name */
    public static final int m100for(int i, int i2) {
        int iMax = Math.max(i, i2);
        int i3 = (i2 * i2) + (i * i);
        boolean z = true;
        while (z) {
            if (iMax * iMax >= i3) {
                z = false;
                i3 = iMax;
            }
            iMax++;
        }
        return i3;
    }

    /* JADX INFO: renamed from: for, reason: not valid java name */
    public static final float[] m101for(float[] fArr, float f) {
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = fArr[i] / f;
        }
        return fArr;
    }

    /* JADX INFO: renamed from: for, reason: not valid java name */
    public static final float[] m102for(float[] fArr, int i) {
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = fArr[i2] * i;
        }
        return fArr;
    }

    /* JADX INFO: renamed from: for, reason: not valid java name */
    public static final int[] m103for(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = iArr[i2] * i;
        }
        return iArr;
    }

    /* JADX INFO: renamed from: if */
    public static final float m18if(float[] fArr) {
        float f = fArr[0];
        if (fArr.length != 1) {
            for (int i = 1; i < fArr.length; i++) {
                if (fArr[i] < f) {
                    f = fArr[i];
                }
            }
        }
        return f;
    }

    /* JADX INFO: renamed from: if */
    private final int m19if(float f) {
        return ((int) f) / this.f336eu;
    }

    /* JADX INFO: renamed from: if */
    public static final int m20if(int[] iArr) {
        int i = iArr[0];
        if (iArr.length != 1) {
            for (int i2 = 1; i2 < iArr.length; i2++) {
                if (iArr[i2] > i) {
                    i = iArr[i2];
                }
            }
        }
        return i;
    }

    /* JADX INFO: renamed from: if */
    public static final float[] m21if(float[] fArr, float f) {
        for (int i = 0; i < fArr.length; i++) {
            fArr[i] = fArr[i] - f;
        }
        return fArr;
    }

    /* JADX INFO: renamed from: if */
    public static final float[] m22if(float[] fArr, int i) {
        for (int i2 = 0; i2 < fArr.length; i2++) {
            fArr[i2] = fArr[i2] + i;
        }
        return fArr;
    }

    /* JADX INFO: renamed from: if */
    public static final int[] m23if(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2] = iArr[i2] + i;
        }
        return iArr;
    }

    /* JADX INFO: renamed from: int, reason: not valid java name */
    private static final int[] m104int(int[] iArr, int i) {
        int[] iArr2 = new int[iArr.length + 1];
        iArr2[iArr.length] = i;
        System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
        return iArr2;
    }

    /* JADX INFO: renamed from: new, reason: not valid java name */
    private final int m105new(int i) {
        return i / this.f227cC;
    }

    @Override // p001a.p002a.p003a.p004a.RunnableC0001a
    /* JADX INFO: renamed from: a */
    public void mo24a() {
        m39d();
        if (this.f153aU != null) {
            for (int i = 0; i < this.f153aU.length; i++) {
                if (this.f153aU[i] != null) {
                    this.f153aU[i] = null;
                }
            }
        }
        if (this.f303e8 != null) {
            for (int i2 = 0; i2 < this.f303e8.length; i2++) {
                if (this.f303e8[i2] != null) {
                    this.f303e8[i2] = null;
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public void m25a(byte b, byte b2, byte b3, int i, int i2, World world) {
        MorphingMesh morphingMeshDuplicate = world.find(i).duplicate();
        morphingMeshDuplicate.translate(this.f176b3 * b, this.f251ck * b2, this.f246cc * b3);
        if (i2 != -1) {
            morphingMeshDuplicate.setUserID(i2);
        }
        this.f257ct.addChild(morphingMeshDuplicate);
    }

    /* JADX INFO: renamed from: a */
    public void m26a(byte b, byte b2, byte b3, int i, int i2, World world, int i3, int i4, int i5) {
        Mesh meshDuplicate = world.find(i).duplicate();
        meshDuplicate.setPickingEnable(false);
        try {
            Appearance appearance = meshDuplicate.getAppearance(0);
            PolygonMode polygonMode = appearance.getPolygonMode();
            polygonMode.setPerspectiveCorrectionEnable(true);
            polygonMode.setShading(f56cI);
            polygonMode.setCulling(162);
            appearance.setPolygonMode(polygonMode);
            meshDuplicate.setAppearance(0, appearance);
        } catch (Exception e) {
            System.out.println(new StringBuffer().append("no app=").append(e).toString());
        }
        meshDuplicate.translate((this.f176b3 * b) + i3, (this.f251ck * b2) + i4, (this.f246cc * b3) + i5);
        if (i2 != -1) {
            meshDuplicate.setUserID(i2);
        }
        if (i == f71d1 || i == 67 || i == 61) {
            meshDuplicate.scale(2.0f, 2.0f, 2.0f);
            meshDuplicate.translate(-50.0f, -50.0f, 0.0f);
        }
        this.f257ct.addChild(meshDuplicate);
    }

    /* JADX INFO: renamed from: a */
    public void m27a(int i, byte b, byte b2, byte b3, int i2, int i3, World world, int i4, int i5, int i6) {
        int i7 = 0;
        while (true) {
            int i8 = i7;
            if (i8 >= this.f161ai.length) {
                return;
            }
            if (((this.f154aW[i8] == this.f213bv) & (this.f161ai[i8] == i3)) && !this.f158ad[i8]) {
                m26a(b, b2, b3, i, i2 + 1400, world, i4, i5, i6);
                this.f219c3 = m104int(this.f219c3, i3);
                this.f183bD = m104int(this.f183bD, i2 + 1400);
            }
            i7 = i8 + 1;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m28a(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, byte b, World world) {
        boolean z2 = true;
        int i8 = 0;
        for (int i9 = 0; i9 < this.f209bo.length && z2; i9++) {
            if (this.f209bo[i9] == m115try(this.f213bv)[0] && this.f208bn[i9] == m115try(this.f213bv)[1] && this.f245ca[i9] == i && this.f181b9[i9] == i2) {
                z2 = false;
                i8 = i9;
            }
        }
        int i10 = -1;
        switch (this.f172ay[i8]) {
            case 0:
                if (!this.f274dQ) {
                    i10 = 13;
                }
                break;
            case 1:
                if (!this.f314eQ) {
                    i10 = 35;
                }
                break;
            case 2:
                if (!this.f149aN) {
                    i10 = 24;
                }
                break;
        }
        if (i10 != -1) {
            m50if(i, i2, i3, i4, i5, i6, i10, z, b, this.f263dA);
        }
    }

    @Override // p001a.p002a.p003a.p004a.RunnableC0001a
    /* JADX INFO: renamed from: a */
    public void mo29a(int i, Gauge gauge) {
        if (i == 0) {
            this.f165am = 1;
        } else if (i == 1) {
            this.f165am = 2;
        } else if (i == 2) {
            this.f165am = 3;
        }
        m44e();
        this.f330em = true;
        this.f144aH = true;
        this.f349fk = f31at;
        this.f334er = 0;
        this.f157aa = 180.0f;
        this.f342fb = 0.0f;
        this.f192bS = (byte) 1;
        this.f163ak = (byte) 0;
        m108for(gauge);
        if (this.f302e7) {
            for (int i2 = 0; i2 < this.f347fg; i2++) {
                for (byte b = 0; b < this.f148aM.length; b = (byte) (b + 1)) {
                    m51if(this.f148aM[b], gauge);
                    this.f197bY = false;
                }
            }
        }
        m51if(0, gauge);
        gauge.setValue(100);
    }

    /* JADX INFO: renamed from: a */
    public void m30a(DataInputStream dataInputStream, int i) {
        try {
            this.f264dB[i] = dataInputStream.readByte();
            this.f254cp[i] = new int[this.f264dB[i]];
            this.f253co[i] = new int[this.f264dB[i]];
            for (int i2 = 0; i2 < this.f264dB[i]; i2++) {
                this.f254cp[i][i2] = dataInputStream.readInt();
                this.f253co[i][i2] = dataInputStream.readInt();
            }
            this.f123P[i] = dataInputStream.readByte();
            this.f119I[i] = this.f254cp[i][0];
            this.f354ft[i] = this.f253co[i][0];
            this.f311eH[i] = dataInputStream.readBoolean();
            this.f139aB[i] = dataInputStream.readByte();
            this.f332eo[i] = this.f165am * dataInputStream.readInt();
            this.f138aA[i] = dataInputStream.readInt();
            this.f151aQ[i] = dataInputStream.readByte();
            this.f131a3[i] = dataInputStream.readByte();
            this.f220c4[i] = dataInputStream.readByte();
            this.f130a2[i] = dataInputStream.readByte();
            this.f218c2[i] = dataInputStream.readByte();
            this.f267dE[i] = false;
            this.f331en[i] = dataInputStream.readBoolean();
            this.f240cT[i] = dataInputStream.readByte();
            if (this.f240cT[i] == 1) {
                int[] iArr = this.f139aB;
                iArr[i] = iArr[i] + this.f139aB[i];
            }
        } catch (Exception e) {
            System.out.println(new StringBuffer().append("exception in monster creation=").append(e).toString());
        }
    }

    @Override // p001a.p002a.p003a.p004a.RunnableC0001a
    /* JADX INFO: renamed from: a */
    public void mo31a(Gauge gauge) {
        try {
            this.f216by = Image.createImage("/smallOptions.png");
            this.f174b0 = Image.createImage("/statusBarTop.png");
            this.f156aY = Image.createImage("/statusBarBottom.png");
            this.f210br = Image.createImage("/healthBar.png");
            this.f120J = Image.createImage("/GoldKey.png");
            this.f326eg = Image.createImage("/BronzeKey.png");
            this.f152aR = Image.createImage("/SilverKey.png");
            this.f188bL = Image.createImage("/GoldSword.png");
            this.f211bt = Image.createImage("/goldHelmet.png");
            this.f225cA = Loader.load("/intro.m3g")[0];
            gauge.setValue(67);
            this.f173az = Loader.load("/BasicScene.m3g")[0];
            gauge.setValue(75);
            this.f224c9 = Loader.load("/Collectables.m3g")[0];
            gauge.setValue(79);
            this.f231cJ = Loader.load("/Skeleton.m3g")[0];
            gauge.setValue(82);
            this.f308eE = Loader.load("/InEyesCamera.m3g")[0];
            this.f150aO = Loader.load("/WarriorArm.m3g")[0];
            gauge.setValue(83);
            this.f143aF = Loader.load("/bat.m3g")[0];
            gauge.setValue(86);
            this.f122O = Loader.load("/scenery.m3g")[0];
            gauge.setValue(90);
            this.f263dA = Loader.load("/doorlocks.m3g")[0];
            gauge.setValue(92);
            this.f242cV = Loader.load("/crossbow.m3g")[0];
            gauge.setValue(94);
            this.f121N = Loader.load("/armour.m3g")[0];
            gauge.setValue(95);
            this.f277dX = Loader.load("/fountain.m3g")[0];
            gauge.setValue(98);
            this.f335et = Loader.load("/scroll.m3g")[0];
            this.f237cQ = Loader.load("/ghost.m3g")[0];
            byte[] bArr = {2, 74, 58, 64, 4, 0, -91, 30, 70, 10, 35, 2, 16, 35, 4, -111, -126, -120, -63, 36, 96, -94, 48, 73, 22, 40, -116, 18, 69, -118, 35, 4, -111, 97, 88, 40, -84, 8, 64, -84, 18, 86, 10, 43, 4, -107, -126, -118, -63, 37, 88, -94, -80, 73, 86, 40, -84, 18, 85, -122, 24, 66, 5, 96, 70, 5, -96, 78, 6, 32, 86, 6, -96, 90, 4, 24, 90, 4, -32, 98, 5, 96, 106, 5, -96, 114, 6, 32, 65, -121, 32, -125, -112, 73, -88, 32, -44, 18, 114, 8, 57, 5, 17, 65, 6, 17, 96, 0};
            byte[] bArr2 = {2, 74, 58, 64, 4, 0, 29, 42, 114, 5, 96, 106, 5, -96, 114, 5, -96, 86, 6, 32, 114, 4, -32, -125, -112, 45, 0, 0};
            byte[] bArr3 = {2, 74, 58, 64, 4, 0, 71, 42, -125, 80, 57, 3, 80, 73, 24, 32, -44, 18, 78, 8, 53, 4, -107, -126, 13, 65, 37, -96, -125, 80, 73, -120, 32, -44, 18, 106, 8, 53, 4, -100, -126, 13, 65, 68, 96, 0};
            byte[] bArr4 = {2, 74, 58, 64, 4, 0, 23, 28, -126, 48, 43, 3, 16, 73, 24, -96, -76, 82, 69, 0, 0};
            this.f318eU = new Sound[4];
            this.f318eU[0] = new Sound(bArr3, 1);
            this.f318eU[0].init(bArr3, 1);
            this.f318eU[1] = new Sound(bArr2, 1);
            this.f318eU[1].init(bArr2, 1);
            this.f318eU[2] = new Sound(bArr4, 1);
            this.f318eU[2].init(bArr4, 1);
            this.f318eU[3] = new Sound(bArr, 1);
            this.f318eU[3].init(bArr, 1);
            this.f268dF = getWidth();
            this.f315eR = getHeight();
            RunnableC0001a.f357A.f410B = this.f318eU[2];
            this.f309eF = Image.createImage("/ghostTexture.png");
            this.f205bj = new Texture2D(new Image2D(99, this.f309eF));
            this.f205bj.setFiltering(210, 210);
            this.f205bj.setWrapping(241, 241);
            this.f205bj.setBlending(227);
            this.f142aE = this.f237cQ.find(39).getAppearance(0).getTexture(0).duplicate();
        } catch (Exception e) {
            this.f196bX = new StringBuffer().append(this.f196bX).append(m61a(m63a(new StringBuffer().append("m ").append(e.toString()).toString(), RunnableC0001a.f357A.f470y), this.f268dF - 5)).toString();
            System.out.println(new StringBuffer().append("error loading files=").append(e).toString());
        }
    }

    @Override // p001a.p002a.p003a.p004a.RunnableC0001a
    /* JADX INFO: renamed from: a */
    public void mo32a(Graphics graphics) {
        m113int(graphics);
        this.f355h = false;
    }

    /* JADX INFO: renamed from: a */
    public void m33a(Group group) {
        int references;
        if (group == null || (references = group.getReferences((Object3D[]) null)) <= 0) {
            return;
        }
        Node[] nodeArr = new Object3D[references];
        group.getReferences(nodeArr);
        for (int i = 0; i < references; i++) {
            try {
                if (nodeArr[i] instanceof Group) {
                    m33a((Group) nodeArr[i]);
                }
                group.removeChild(nodeArr[i]);
            } catch (Exception e) {
                System.out.println("upset");
            }
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:35:0x0454  */
    /* JADX INFO: renamed from: a */
    public void m34a(boolean z, Gauge gauge) {
        int i;
        SkinnedMesh skinnedMeshFind;
        Object3D object3D;
        Object3D object3D2;
        int i2;
        mo106for();
        this.f312eJ = 0;
        try {
            m39d();
            this.f257ct = null;
            System.gc();
            this.f257ct = new World();
            int i3 = 0;
            this.f219c3 = new int[0];
            this.f183bD = new int[0];
            for (int i4 = 0; i4 < this.f303e8.length; i4++) {
                if (this.f303e8[i4] != null) {
                    int i5 = 0;
                    while (i5 < this.f303e8[i4].length) {
                        byte b = (byte) (i4 / (this.f295dx * this.f198bZ));
                        byte b2 = (byte) ((i4 - ((this.f295dx * b) * this.f198bZ)) / this.f295dx);
                        byte b3 = (byte) ((i4 - ((this.f295dx * b) * this.f198bZ)) - (this.f295dx * b2));
                        gauge.setValue(Math.min(i4, 75));
                        switch (this.f303e8[i4][i5]) {
                            case 0:
                                m50if(b3, b2, b, this.f176b3, this.f251ck / 2, 90, 66, true, (byte) 0, this.f173az);
                                i2 = i3;
                                break;
                            case 1:
                                m50if(b3, b2, b, this.f176b3, this.f251ck / 2, 90, 111, true, (byte) 0, this.f173az);
                                i2 = i3;
                                break;
                            case 2:
                                m50if(b3, b2, b, this.f176b3, this.f251ck / 2, 90, 133, true, (byte) 0, this.f173az);
                                i2 = i3;
                                break;
                            case 3:
                                m50if(b3, b2, b, this.f176b3, this.f251ck / 2, 90, 89, true, (byte) 0, this.f173az);
                                i2 = i3;
                                break;
                            case 4:
                                m50if(b3, b2, b, this.f176b3, this.f251ck / 2, 90, 77, true, (byte) 4, this.f173az);
                                i2 = i3;
                                break;
                            case 5:
                                m50if(b3, b2, b, this.f176b3, this.f251ck / 2, 90, 122, true, (byte) 0, this.f173az);
                                i2 = i3;
                                break;
                            case 6:
                                m50if(b3, b2, b, this.f176b3, this.f251ck / 2, 90, 100, true, (byte) 0, this.f173az);
                                i2 = i3;
                                break;
                            case 7:
                                m50if(b3, b2, b, this.f176b3, this.f251ck / 2, 90, 83, true, (byte) 7, this.f173az);
                                i2 = i3;
                                break;
                            case 8:
                                m50if(b3, b2, b, this.f176b3 / 2, this.f251ck, 180, 66, true, (byte) 8, this.f173az);
                                i2 = i3;
                                break;
                            case 9:
                                m50if(b3 + 1, b2, b, this.f176b3 / 2, this.f251ck, 180, 111, true, (byte) 8, this.f173az);
                                i2 = i3;
                                break;
                            case 10:
                                m50if(b3 + 2, b2, b, this.f176b3 / 2, this.f251ck, 180, 133, true, (byte) 8, this.f173az);
                                i2 = i3;
                                break;
                            case 11:
                                m50if(b3, b2, b, this.f176b3 / 2, this.f251ck, 180, 89, true, (byte) 8, this.f173az);
                                i2 = i3;
                                break;
                            case 12:
                                m50if(b3, b2, b, this.f176b3 / 2, this.f251ck, 180, 77, true, (byte) 12, this.f173az);
                                i2 = i3;
                                break;
                            case 13:
                                m50if(b3 + 1, b2, b, this.f176b3 / 2, this.f251ck, 180, 122, true, (byte) 8, this.f173az);
                                i2 = i3;
                                break;
                            case 14:
                                m50if(b3 + 2, b2, b, this.f176b3 / 2, this.f251ck, 180, 100, true, (byte) 8, this.f173az);
                                i2 = i3;
                                break;
                            case 15:
                                m50if(b3, b2, b, this.f176b3 / 2, this.f251ck, 180, 83, true, (byte) 12, this.f173az);
                                i2 = i3;
                                break;
                            case f55cH /* 16 */:
                                m50if(b3, b2, b, 0, this.f251ck / 2, 270, 66, true, (byte) 16, this.f173az);
                                i2 = i3;
                                break;
                            case f89df /* 17 */:
                                m50if(b3, b2 + 1, b, 0, this.f251ck / 2, 270, 111, true, (byte) 16, this.f173az);
                                i2 = i3;
                                break;
                            case 18:
                                m50if(b3, b2 + 2, b, 0, this.f251ck / 2, 270, 133, true, (byte) 16, this.f173az);
                                i2 = i3;
                                break;
                            case f59cX /* 19 */:
                                m50if(b3, b2, b, 0, this.f251ck / 2, 270, 89, true, (byte) 16, this.f173az);
                                i2 = i3;
                                break;
                            case 20:
                                m50if(b3, b2, b, 0, this.f251ck / 2, 270, 77, true, (byte) 20, this.f173az);
                                i2 = i3;
                                break;
                            case 21:
                                m50if(b3, b2 + 1, b, 0, this.f251ck / 2, 270, 122, true, (byte) 16, this.f173az);
                                i2 = i3;
                                break;
                            case f116fn /* 22 */:
                                m50if(b3, b2 + 2, b, 0, this.f251ck / 2, 270, 100, true, (byte) 16, this.f173az);
                                i2 = i3;
                                break;
                            case 23:
                                m50if(b3, b2, b, 0, this.f251ck / 2, 270, 83, true, (byte) 20, this.f173az);
                                i2 = i3;
                                break;
                            case 24:
                                m50if(b3, b2, b, this.f176b3 / 2, 0, 0, 66, true, (byte) 24, this.f173az);
                                this.f312eJ++;
                                i2 = i3;
                                break;
                            case 25:
                                m50if(b3, b2, b, this.f176b3 / 2, 0, 0, 111, true, (byte) 24, this.f173az);
                                this.f312eJ++;
                                i2 = i3;
                                break;
                            case 26:
                                m50if(b3, b2, b, this.f176b3 / 2, 0, 0, 133, true, (byte) 24, this.f173az);
                                i2 = i3;
                                break;
                            case 27:
                                m50if(b3, b2, b, this.f176b3 / 2, 0, 0, 89, true, (byte) 24, this.f173az);
                                i2 = i3;
                                break;
                            case 28:
                                m50if(b3, b2, b, this.f176b3 / 2, 0, 0, 77, true, (byte) 24, this.f173az);
                                i2 = i3;
                                break;
                            case 29:
                                m50if(b3, b2, b, this.f176b3 / 2, 0, 0, 122, true, (byte) 24, this.f173az);
                                i2 = i3;
                                break;
                            case 30:
                                m50if(b3, b2, b, this.f176b3 / 2, 0, 0, 100, true, (byte) 24, this.f173az);
                                i2 = i3;
                                break;
                            case 31:
                                m50if(b3, b2, b, this.f176b3 / 2, 0, 0, 83, true, (byte) 24, this.f173az);
                                i2 = i3;
                                break;
                            case 32:
                                m26a(b3, b2, b, 156, this.f312eJ, this.f173az, 0, 0, 0);
                                this.f312eJ++;
                                i2 = i3;
                                break;
                            case f63ci /* 33 */:
                                this.f133a5 = new Light();
                                this.f133a5.translate(b3 * this.f176b3, b2 * this.f251ck, 0.0f);
                                this.f133a5.setMode(128);
                                this.f133a5.setIntensity(0.9f);
                                this.f133a5.setUserID(f31at);
                                this.f257ct.addChild(this.f133a5);
                                if (this.f235cO) {
                                    this.f235cO = false;
                                    Light lightDuplicate = this.f133a5.duplicate();
                                    lightDuplicate.setIntensity(1.2f);
                                    this.f335et.addChild(lightDuplicate);
                                    i2 = i3;
                                } else {
                                    i2 = i3;
                                }
                                break;
                            case 34:
                                m26a(b3, b2, b, 13, this.f312eJ, this.f122O, 0, 0, 0);
                                this.f312eJ++;
                                i2 = i3;
                                break;
                            case f81dM /* 35 */:
                            default:
                                i2 = i3;
                                break;
                            case f34b4 /* 36 */:
                                m26a(b3, b2, b, 19, this.f312eJ, this.f122O, 0, 0, 0);
                                this.f312eJ++;
                                i2 = i3;
                                break;
                            case 37:
                                m26a(b3, b2, b, 27, this.f312eJ, this.f173az, 0, 0, 0);
                                this.f312eJ++;
                                i2 = i3;
                                break;
                            case 38:
                                m26a(b3, b2, b, 139, this.f312eJ, this.f173az, 0, 0, 0);
                                this.f312eJ++;
                                i2 = i3;
                                break;
                            case 39:
                                m26a(b3, b2, b, 145, this.f312eJ, this.f173az, 0, 0, 0);
                                this.f312eJ++;
                                i2 = i3;
                                break;
                            case 40:
                                m26a(b3, b2, (byte) (b + 1), 49, this.f312eJ, this.f173az, 0, 0, 0);
                                this.f312eJ++;
                                i2 = i3;
                                break;
                            case f76d8 /* 41 */:
                                m50if(b3, b2, b, this.f176b3 / 2, 0, 0, f71d1, false, (byte) 41, this.f173az);
                                i2 = i3;
                                break;
                            case 42:
                                m50if(b3, b2, b, this.f176b3 / 2, this.f251ck, 180, f71d1, false, (byte) 42, this.f173az);
                                i2 = i3;
                                break;
                            case 43:
                                m50if(b3, b2, b, 0, this.f251ck / 2, 270, f71d1, false, (byte) 43, this.f173az);
                                i2 = i3;
                                break;
                            case 44:
                                m50if(b3 + 1, b2, b, 0, this.f251ck / 2, 270, f71d1, false, (byte) 44, this.f173az);
                                i2 = i3;
                                break;
                            case 45:
                                m50if(b3, b2, b, this.f176b3, (this.f336eu / 2) + (this.f251ck / 2), 0, 16, false, (byte) 0, this.f173az);
                                m28a((int) b3, (int) b2, (int) b, this.f176b3, (this.f336eu / 2) + (this.f251ck / 2), 0, 16, false, (byte) 0, this.f263dA);
                                i2 = i3;
                                break;
                            case 46:
                                m50if(b3, b2, b, 0, this.f251ck, 90, 16, false, (byte) 1, this.f173az);
                                m28a((int) b3, (int) b2, (int) b, (this.f176b3 / 2) - 10, this.f251ck / 2, 90, 0, false, (byte) 0, this.f263dA);
                                i2 = i3;
                                break;
                            case 47:
                                m50if(b3, b2, b, 0, 0, 180, 16, false, (byte) 2, this.f173az);
                                m28a((int) b3, (int) b2, (int) b, this.f176b3, -10, 180, 16, false, (byte) 0, this.f263dA);
                                i2 = i3;
                                break;
                            case 48:
                                m50if(b3, b2, b, this.f176b3, 0, 270, 16, false, (byte) 3, this.f173az);
                                m28a((int) b3, (int) b2, (int) b, ((this.f176b3 * 3) / 2) + 10, this.f336eu / 2, 270, 0, false, (byte) 0, this.f263dA);
                                i2 = i3;
                                break;
                            case f78dG /* 49 */:
                                m27a(19, b3, b2, b, i3, i4, this.f224c9, 0, 0, 0);
                                i2 = i3 + 1;
                                break;
                            case f86dW /* 50 */:
                                m27a(25, b3, b2, b, i3, i4, this.f224c9, 0, 0, 0);
                                i2 = i3 + 1;
                                break;
                            case 51:
                                m27a(49, b3, b2, b, i3, i4, this.f224c9, 0, 0, 0);
                                i2 = i3 + 1;
                                break;
                            case 52:
                                m27a(43, b3, b2, b, i3, i4, this.f224c9, 0, 0, 0);
                                i2 = i3 + 1;
                                break;
                            case 53:
                                m27a(37, b3, b2, b, i3, i4, this.f224c9, 0, 0, 0);
                                i2 = i3 + 1;
                                break;
                            case 54:
                                m27a(13, b3, b2, b, i3, i4, this.f224c9, 0, 0, 0);
                                i2 = i3 + 1;
                                break;
                            case f71d1 /* 55 */:
                                m26a(b3, b2, b, 13, this.f312eJ, this.f277dX, 0, 0, 0);
                                this.f312eJ++;
                                m25a(b3, b2, b, 27, 2600, this.f277dX);
                                this.f285di = m12a(this.f285di, new int[]{2600, 0, 0, 1900, 0, 0, 1});
                                i2 = i3;
                                break;
                            case f112fa /* 56 */:
                                m26a(b3, b2, b, 30, this.f312eJ, this.f122O, 0, 0, 0);
                                this.f312eJ++;
                                i2 = i3;
                                break;
                            case 57:
                                m50if(b3, b2, b, this.f227cC / 2, 0, 180, 38, true, (byte) 60, this.f173az);
                                i2 = i3;
                                break;
                            case 58:
                                m50if(b3, b2 + 1, b, this.f227cC / 2, 0, 0, 38, true, (byte) 60, this.f173az);
                                i2 = i3;
                                break;
                            case 59:
                                m50if(b3 + 1, b2, b, 0, this.f251ck / 2, 270, 38, true, (byte) 60, this.f173az);
                                i2 = i3;
                                break;
                            case 60:
                                m50if(b3, b2, b, 0, this.f251ck / 2, 90, 38, false, (byte) 60, this.f173az);
                                i2 = i3;
                                break;
                            case 61:
                                m27a(f71d1, b3, b2, b, i3, i4, this.f224c9, 0, 0, 0);
                                i2 = i3 + 1;
                                break;
                            case 62:
                                m27a(61, b3, b2, b, i3, i4, this.f224c9, 0, 0, 0);
                                i2 = i3 + 1;
                                break;
                            case f105eW /* 63 */:
                                m27a(67, b3, b2, b, i3, i4, this.f224c9, 0, 0, 0);
                                i2 = i3 + 1;
                                break;
                            case f102eO /* 64 */:
                                m27a(56, b3, (byte) (b2 + 1), b, i3, i4, this.f242cV, this.f176b3 / 2, this.f251ck / 2, 5);
                                i2 = i3 + 1;
                                break;
                            case 65:
                                m27a(78, b3, b2, b, i3, i4, this.f224c9, 0, 0, 0);
                                i2 = i3 + 1;
                                break;
                        }
                        i5++;
                        i3 = i2;
                    }
                }
            }
            int i6 = 69;
            if (this.f337ev) {
                i6 = 13;
                i = 63;
            } else {
                i = 41;
            }
            this.f228cD = this.f150aO.find(i6).duplicate();
            this.f228cD.setTranslation(0.0f, 0.0f, 100000.0f);
            this.f228cD.setPickingEnable(false);
            this.f257ct.addChild(this.f228cD);
            this.f244cZ = this.f150aO.find(i).duplicate();
            this.f244cZ.setTranslation(0.0f, 0.0f, 100000.0f);
            this.f244cZ.setPickingEnable(false);
            this.f244cZ.setUserID(2004);
            this.f257ct.addChild(this.f244cZ);
            this.f134a6 = this.f242cV.find(48).duplicate();
            this.f134a6.setTranslation(0.0f, 0.0f, 100000.0f);
            this.f134a6.setUserID(2000);
            this.f134a6.setPickingEnable(false);
            this.f129a0 = this.f134a6.find(46);
            this.f129a0.setUserID(2001);
            this.f266dD = this.f134a6.find(47);
            this.f266dD.setUserID(2002);
            this.f257ct.addChild(this.f134a6);
            this.f212bu = this.f242cV.find(56).duplicate();
            this.f212bu.setPickingEnable(false);
            this.f212bu.setUserID(2003);
            this.f212bu.setTranslation(0.0f, 0.0f, 100000.0f);
            this.f257ct.addChild(this.f212bu);
            this.f285di = m12a(this.f285di, new int[]{2004, 0, 0, f31at, 0, 0, 1});
            this.f285di = m12a(this.f285di, new int[]{2000, 2, 0, 0, 0, 0, 1});
            if (this.f163ak == 1) {
                m107for(2000, 1600, 1601);
                m107for(2004, 6801, 6801);
            }
            this.f276dT = this.f308eE.find(8).duplicate();
            this.f276dT.setUserID(2700);
            this.f257ct.addChild(this.f276dT);
            this.f257ct.setActiveCamera(this.f276dT);
            int i7 = 0;
            int i8 = 0;
            int i9 = 0;
            if (z && this.f151aQ != null) {
                int i10 = 0;
                while (i10 < this.f151aQ.length) {
                    int i11 = 0;
                    for (int i12 = 0; i12 < this.f305eA.length; i12++) {
                        if ((this.f160ag[i12] == i10) & (this.f260d0[i12] == this.f213bv)) {
                            i11 = i12;
                        }
                    }
                    if (this.f305eA[i11]) {
                        this.f267dE[i10] = true;
                    } else {
                        if (this.f240cT[i10] == 3) {
                            if (i8 != 0) {
                                skinnedMeshFind = (SkinnedMesh) this.f143aF.find(39);
                                Object3D object3D3 = (Mesh) this.f143aF.find(59);
                                Object3D object3D4 = (Mesh) this.f143aF.find(52);
                                this.f285di = m12a(this.f285di, new int[]{i10 + f49bq, 0, 0, 1100, 0, 0, 1});
                                this.f240cT[i10] = 1;
                                object3D = object3D3;
                                object3D2 = object3D4;
                            } else {
                                i8++;
                                skinnedMeshFind = this.f231cJ.find(61);
                                Object3D object3D5 = (Mesh) this.f231cJ.find(74);
                                Object3D object3D6 = (Mesh) this.f231cJ.find(81);
                                this.f285di = m12a(this.f285di, new int[]{i10 + f49bq, 0, 0, 2000, 0, 0, 1});
                                object3D = object3D6;
                                object3D2 = object3D5;
                            }
                        } else if (this.f240cT[i10] == 0) {
                            if (i7 != 0) {
                                this.f237cQ = Loader.load("/ghost.m3g")[0];
                            }
                            i7++;
                            skinnedMeshFind = this.f237cQ.find(39);
                            Object3D object3D7 = (Mesh) this.f231cJ.find(81);
                            this.f285di = m12a(this.f285di, new int[]{i10 + f49bq, 0, 0, 3000, 0, 0, 1});
                            object3D = object3D7;
                            object3D2 = null;
                        } else {
                            if (i9 != 0) {
                                this.f143aF = Loader.load("/bat.m3g")[0];
                            }
                            i9++;
                            skinnedMeshFind = this.f143aF.find(39);
                            Object3D object3D8 = (Mesh) this.f143aF.find(59);
                            Object3D object3D9 = (Mesh) this.f143aF.find(52);
                            this.f285di = m12a(this.f285di, new int[]{i10 + f49bq, 0, 0, 1100, 0, 0, 1});
                            object3D = object3D8;
                            object3D2 = object3D9;
                        }
                        Group group = new Group();
                        group.setUserID(i10 + 1300);
                        SkinnedMesh skinnedMeshDuplicate = skinnedMeshFind.duplicate();
                        skinnedMeshDuplicate.setPickingEnable(false);
                        Mesh meshDuplicate = object3D.duplicate();
                        meshDuplicate.setUserID(i10 + 2100);
                        this.f304e9 = false;
                        skinnedMeshDuplicate.setUserID(i10 + f49bq);
                        group.addChild(skinnedMeshDuplicate);
                        group.addChild(meshDuplicate);
                        if (object3D2 != null) {
                            Mesh meshDuplicate2 = object3D2.duplicate();
                            meshDuplicate2.setUserID(i10 + 1200);
                            group.addChild(meshDuplicate2);
                            meshDuplicate2.setPickingEnable(false);
                        }
                        this.f279dZ[i10] = this.f285di.length - 1;
                        group.setTranslation(this.f119I[i10], this.f354ft[i10], (this.f123P[i10] + 1) * this.f246cc);
                        this.f257ct.addChild(group);
                    }
                    i10++;
                    i9 = i9;
                    i8 = i8;
                    i7 = i7;
                }
            }
            if (this.f144aH) {
                this.f320eZ = this.f225cA.find(61).duplicate();
                this.f320eZ.setUserID(1700);
                SkinnedMesh skinnedMeshDuplicate2 = this.f225cA.find(56).duplicate();
                skinnedMeshDuplicate2.setUserID(1900);
                Group group2 = new Group();
                group2.setUserID(1800);
                group2.addChild(skinnedMeshDuplicate2);
                group2.addChild(this.f320eZ);
                group2.setOrientation(90.0f, 0.0f, 0.0f, 1.0f);
                this.f257ct.addChild(group2);
                this.f257ct.setActiveCamera(this.f320eZ);
                this.f285di = m12a(this.f285di, new int[]{1900, 0, 0, 7100, f31at, 0, 0});
                this.f285di = m12a(this.f285di, new int[]{1700, 0, 0, 7100, f31at, 0, 0});
                group2.scale(0.33f, 0.33f, 0.33f);
            }
            if (this.f199bb) {
                this.f127Y = (byte) 0;
                m26a((byte) 6, (byte) 2, (byte) 0, 38, this.f312eJ, this.f121N, 0, 0, 0);
                this.f312eJ++;
                m26a((byte) 6, (byte) 2, (byte) 0, 13, 2207, this.f121N, 0, 0, 7);
                m26a((byte) 6, (byte) 2, (byte) 0, 27, 2208, this.f121N, 0, 0, 7);
                this.f168aq = this.f121N.find(103).duplicate();
                this.f168aq.setUserID(2200);
                Group group3 = new Group();
                group3.addChild(this.f168aq);
                group3.setUserID(2201);
                group3.setOrientation(90.0f, 0.0f, 0.0f, 1.0f);
                SkinnedMesh skinnedMeshDuplicate3 = this.f225cA.find(56).duplicate();
                skinnedMeshDuplicate3.setUserID(2202);
                Group group4 = new Group();
                group4.setUserID(2203);
                group4.addChild(skinnedMeshDuplicate3);
                group4.setOrientation(90.0f, 0.0f, 0.0f, 1.0f);
                group4.setTranslation(0.0f, 0.0f, 100000.0f);
                this.f285di = m12a(this.f285di, new int[]{2202, 0, 0, 0, 0, 0, 0});
                SkinnedMesh skinnedMeshDuplicate4 = this.f121N.find(98).duplicate();
                skinnedMeshDuplicate4.setUserID(2204);
                Group group5 = new Group();
                group5.setTranslation(0.0f, 0.0f, 100000.0f);
                group5.setUserID(2205);
                group5.addChild(skinnedMeshDuplicate4);
                group5.setOrientation(90.0f, 0.0f, 0.0f, 1.0f);
                Mesh meshDuplicate3 = this.f121N.find(53).duplicate();
                meshDuplicate3.setUserID(2206);
                meshDuplicate3.setTranslation(500.0f, 350.0f, 0.0f);
                this.f257ct.addChild(group4);
                this.f257ct.addChild(group5);
                this.f257ct.addChild(group3);
                this.f257ct.addChild(meshDuplicate3);
                this.f271dJ = true;
                this.f257ct.setActiveCamera(this.f168aq);
            }
            this.f271dJ = true;
            this.f125W = true;
            this.f273dP = 10.0f;
            this.f197bY = true;
        } catch (Exception e) {
            System.out.println(new StringBuffer().append("Exception=").append(e).toString());
            m34a(true, gauge);
        }
    }

    @Override // p001a.p002a.p003a.p004a.RunnableC0001a
    /* JADX INFO: renamed from: a */
    public void mo35a(byte[] bArr, Gauge gauge) {
        m44e();
        this.f144aH = false;
        m108for(gauge);
        try {
            DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(bArr));
            this.f192bS = dataInputStream.readByte();
            this.f157aa = dataInputStream.readFloat();
            this.f342fb = dataInputStream.readFloat();
            this.f353fs = dataInputStream.readInt();
            this.f352fr = dataInputStream.readInt();
            this.f351fq = dataInputStream.readFloat();
            this.f348fj = dataInputStream.readInt();
            this.f337ev = dataInputStream.readBoolean();
            this.f274dQ = dataInputStream.readBoolean();
            this.f314eQ = dataInputStream.readBoolean();
            this.f149aN = dataInputStream.readBoolean();
            this.f349fk = dataInputStream.readInt();
            this.f334er = dataInputStream.readInt();
            this.f239cS = dataInputStream.readFloat();
            this.f145aI = dataInputStream.readBoolean();
            this.f163ak = dataInputStream.readByte();
            this.f187bJ = dataInputStream.readBoolean();
            this.f165am = dataInputStream.readInt();
            this.f213bv = dataInputStream.readInt();
            for (int i = 0; i < this.f158ad.length; i++) {
                this.f158ad[i] = dataInputStream.readBoolean();
            }
            for (int i2 = 0; i2 < this.f305eA.length; i2++) {
                this.f305eA[i2] = dataInputStream.readBoolean();
            }
            m51if(this.f213bv, gauge);
            if (dataInputStream.readBoolean()) {
                for (int i3 = 0; i3 < this.f119I.length; i3++) {
                    this.f119I[i3] = dataInputStream.readFloat();
                    this.f354ft[i3] = dataInputStream.readFloat();
                    this.f159af[i3] = dataInputStream.readByte();
                    this.f138aA[i3] = dataInputStream.readInt();
                    this.f206bk[i3] = dataInputStream.readFloat();
                }
            }
        } catch (Exception e) {
            System.out.println("loading error");
        }
        gauge.setValue(100);
    }

    /* JADX WARN: Code duplicated, block: B:89:0x0111  */
    /* JADX INFO: renamed from: a */
    public final boolean m36a(int i, int i2, int i3, int i4) {
        boolean z;
        this.f340ey[0] = i;
        this.f340ey[1] = i2;
        this.f340ey[2] = i2;
        this.f340ey[3] = i;
        this.f339ex[0] = i3;
        this.f339ex[1] = i4;
        this.f339ex[2] = i3;
        this.f339ex[3] = i4;
        boolean z2 = true;
        for (int i5 = 0; i5 < this.f325ee.length && z2; i5++) {
            if ((this.f325ee[i5] <= i) & (this.f325ee[i5] >= i2)) {
                if ((this.f324ed[i5] <= i3) & (this.f324ed[i5] >= i4)) {
                    z2 = false;
                }
            }
            if ((this.f340ey[i5] <= m20if(this.f325ee)) & (this.f340ey[i5] >= m14do(this.f325ee))) {
                if ((this.f339ex[i5] <= m20if(this.f324ed)) & (this.f339ex[i5] >= m14do(this.f324ed))) {
                    z2 = false;
                }
            }
        }
        if (z2) {
            if ((i4 >= m14do(this.f324ed)) && (((i2 <= m14do(this.f325ee)) & (i >= m20if(this.f325ee))) && (i3 <= m20if(this.f324ed)))) {
                z = false;
            } else {
                z = z2;
            }
        } else {
            z = z2;
        }
        if (z) {
            if ((m20if(this.f324ed) <= i3) & (m14do(this.f325ee) <= i2) & (m20if(this.f325ee) >= i) & (m14do(this.f324ed) >= i4)) {
                return false;
            }
        }
        return z;
    }

    /* JADX INFO: renamed from: b */
    public void m37b() {
        this.f257ct = null;
    }

    /* JADX INFO: renamed from: c */
    public void m38c() {
        for (int i = 0; i < this.f282de.length; i++) {
            this.f333eq = true;
            for (int i2 = 0; i2 < 10; i2++) {
                m111int(i);
            }
            this.f270dI = true;
            for (int i3 = 0; i3 < 10; i3++) {
                m111int(i);
            }
        }
    }

    /* JADX INFO: renamed from: d */
    public void m39d() {
        if (this.f285di != null) {
            for (int i = 0; i < this.f285di.length; i++) {
                if (this.f285di[i] != null) {
                    this.f285di[i] = null;
                }
            }
        }
        if (this.f140aC != null) {
            for (int i2 = 0; i2 < this.f140aC.length; i2++) {
                if (this.f140aC[i2] != null) {
                    this.f140aC[i2] = null;
                }
            }
        }
        this.f285di = new int[0][];
        this.f140aC = new byte[0][];
    }

    /* JADX WARN: Code duplicated, block: B:229:0x043c  */
    /* JADX INFO: renamed from: do */
    public synchronized void m40do(int i, int i2) {
        int i3;
        boolean z = false;
        if (this.f155aX) {
            this.f236cP = (int) (this.f236cP + this.f273dP);
            if (this.f236cP >= 500) {
                if (this.f337ev) {
                    this.f349fk -= 25;
                } else if (this.f213bv == 16) {
                    this.f349fk -= 200;
                } else {
                    this.f349fk -= 50;
                }
                this.f230cF = true;
                if (this.f349fk > 0) {
                    m67a(this.f318eU[1]);
                }
                this.f236cP = 0;
            }
        } else {
            this.f236cP = 0;
        }
        if (this.f301e6) {
            this.f146aJ = (int) (this.f146aJ + this.f273dP);
            if (this.f146aJ >= 1500) {
                boolean z2 = this.f349fk < f31at;
                this.f349fk += 100;
                if (this.f349fk > f31at) {
                    this.f349fk = f31at;
                }
                if (z2) {
                    this.f226cB = true;
                    this.f185bG = f67cu;
                }
                this.f146aJ = 0;
            }
        } else {
            this.f146aJ = 0;
        }
        this.f248cf = false;
        this.f169au = false;
        this.f261d5 = false;
        this.f191bP = false;
        this.f155aX = false;
        this.f301e6 = false;
        int i4 = (int) (this.f351fq / 20.0f);
        this.f348fj = i4;
        this.f325ee[0] = this.f353fs - 37;
        this.f325ee[1] = this.f353fs - 37;
        this.f325ee[2] = this.f353fs + 37;
        this.f325ee[3] = this.f353fs + 37;
        this.f324ed[0] = this.f352fr - 37;
        this.f324ed[1] = this.f352fr + 37;
        this.f324ed[2] = this.f352fr - 37;
        this.f324ed[3] = this.f352fr + 37;
        boolean z3 = true;
        int i5 = 0;
        int i6 = i > 0 ? 1 : i < 0 ? -1 : 0;
        if (i != 0) {
            int i7 = 0;
            while (true) {
                if (!(i7 < Math.abs(i)) || !z3) {
                    break;
                }
                m23if(this.f325ee, i6);
                int i8 = 0;
                boolean zM42do = z3;
                while (true) {
                    if (!(i8 < this.f325ee.length) || !zM42do) {
                        break;
                    }
                    zM42do = m42do(m105new(this.f325ee[i8]), m99for(this.f324ed[i8]), i4);
                    i8++;
                }
                if (this.f151aQ != null) {
                    for (int i9 = 0; i9 < this.f151aQ.length && zM42do; i9++) {
                        if (((this.f240cT[i9] != 0) & (!this.f267dE[i9])) && (this.f348fj == this.f123P[i9] || this.f348fj == this.f123P[i9] + 1 || this.f348fj == this.f123P[i9] - 1 || this.f348fj == this.f123P[i9] + 2 || this.f348fj == this.f123P[i9] + 3)) {
                            int i10 = f115fl[this.f240cT[i9]][1];
                            int i11 = f115fl[this.f240cT[i9]][0];
                            if (!m36a(((int) this.f119I[i9]) + (i11 / 2), ((int) this.f119I[i9]) - (i11 / 2), ((int) this.f354ft[i9]) + (i10 / 2), ((int) this.f354ft[i9]) - (i10 / 2))) {
                                if (this.f348fj == this.f123P[i9] + 3) {
                                    this.f191bP = true;
                                } else {
                                    zM42do = false;
                                }
                            }
                        }
                    }
                }
                boolean z4 = zM42do;
                if (!z4) {
                    i3 = i5;
                } else if (i > 0) {
                    i3 = i5 + 1;
                    z = true;
                } else if (i < 0) {
                    i3 = i5 - 1;
                    z = true;
                } else {
                    i3 = i5;
                }
                i7++;
                i5 = i3;
                z3 = z4;
            }
            this.f353fs += i5;
        }
        boolean z5 = z;
        boolean z6 = true;
        int i12 = 0;
        int i13 = i2 > 0 ? 1 : i2 < 0 ? -1 : 0;
        if (i2 != 0) {
            int i14 = 0;
            while (true) {
                if (!(i14 < Math.abs(i2)) || !z6) {
                    break;
                }
                m23if(this.f324ed, i13);
                int i15 = 0;
                boolean z7 = z6;
                while (true) {
                    if (!(i15 < this.f324ed.length) || !z7) {
                        break;
                    }
                    boolean zM42do2 = m42do(m105new(this.f325ee[i15]), m99for(this.f324ed[i15]), i4);
                    i15++;
                    z7 = zM42do2;
                }
                if (this.f151aQ != null) {
                    for (int i16 = 0; i16 < this.f151aQ.length; i16++) {
                        if (((this.f240cT[i16] != 0) & (!this.f267dE[i16])) && (this.f348fj == this.f123P[i16] || this.f348fj == this.f123P[i16] + 1 || this.f348fj == this.f123P[i16] + 1 || this.f348fj == this.f123P[i16] - 1 || this.f348fj == this.f123P[i16] + 2 || this.f348fj == this.f123P[i16] + 3)) {
                            int i17 = f115fl[this.f240cT[i16]][1];
                            int i18 = f115fl[this.f240cT[i16]][0];
                            if (!m36a(((int) this.f119I[i16]) + (i18 / 2), ((int) this.f119I[i16]) - (i18 / 2), ((int) this.f354ft[i16]) + (i17 / 2), ((int) this.f354ft[i16]) - (i17 / 2)) && this.f348fj == this.f123P[i16] + 3) {
                                this.f191bP = true;
                            }
                        }
                    }
                }
                if (z7) {
                    if (i2 > 0) {
                        i12++;
                        z5 = true;
                    } else if (i2 < 0) {
                        i12--;
                        z5 = true;
                    }
                }
                i14++;
                z6 = z7;
            }
            this.f352fr = i12 + this.f352fr;
        }
        for (int i19 = 0; i19 < this.f324ed.length; i19++) {
            m42do(m105new(this.f325ee[i19]), m99for(this.f324ed[i19]), i4);
        }
        if (this.f151aQ != null) {
            for (int i20 = 0; i20 < this.f151aQ.length; i20++) {
                if (((this.f240cT[i20] != 0) & (!this.f267dE[i20])) && this.f348fj == this.f123P[i20] + 3) {
                    int i21 = f115fl[this.f240cT[i20]][1];
                    int i22 = f115fl[this.f240cT[i20]][0];
                    if (!m36a(((int) this.f119I[i20]) + (i22 / 2), ((int) this.f119I[i20]) - (i22 / 2), ((int) this.f354ft[i20]) + (i21 / 2), ((int) this.f354ft[i20]) - (i21 / 2))) {
                        this.f191bP = true;
                    }
                }
            }
        }
        if (this.f191bP) {
            this.f145aI = false;
            if (this.f248cf && this.f351fq - (this.f348fj * 20) > 5.0f) {
                this.f239cS = 0.0f;
            }
            this.f239cS = Math.max(0.0f, this.f239cS);
            if ((this.f239cS == 0.0f) & (!this.f145aI)) {
                if (this.f261d5) {
                    this.f351fq += 20.0f;
                } else {
                    this.f351fq = ((int) (this.f351fq / 20.0f)) * 20;
                }
            }
        } else {
            this.f239cS -= 9.8f * (this.f319eY / 15.0f);
        }
        float f = this.f239cS * this.f319eY;
        this.f351fq = (f > 0.0f ? Math.min(19.0f, f) : Math.max(-19.0f, f)) + this.f351fq;
        if (!z5) {
            if ((!this.f187bJ) & (!this.f201bd)) {
                m107for(2004, f31at, 0);
            }
        }
    }

    /* JADX INFO: renamed from: do */
    void m41do(Graphics graphics) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = jCurrentTimeMillis - f111es;
        if (j > 0) {
            graphics.setColor(16711680);
            graphics.drawString(new StringBuffer().append("").append(1000 / j).toString(), 50, 50, 20);
        }
        f111es = jCurrentTimeMillis;
    }

    /* JADX INFO: renamed from: do */
    public final boolean m42do(int i, int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        boolean zM36a = true;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = (this.f295dx * i3 * this.f198bZ) + (this.f295dx * i2) + i;
        if (this.f153aU[i14] != null) {
            for (int i15 = 0; i15 < this.f153aU[i14].length && zM36a; i15++) {
                boolean z = false;
                boolean z2 = false;
                switch (this.f153aU[i14][i15]) {
                    case 0:
                        i4 = this.f227cC;
                        int i16 = this.f336eu;
                        int i17 = this.f336eu - 4;
                        this.f289dp = (byte) 0;
                        z2 = true;
                        i5 = i17;
                        i6 = i16;
                        i7 = 0;
                        break;
                    case 1:
                        i4 = 4;
                        int i18 = this.f336eu;
                        this.f289dp = (byte) 1;
                        z2 = true;
                        i5 = 0;
                        i6 = i18;
                        i7 = 0;
                        break;
                    case 2:
                        i4 = this.f227cC;
                        this.f289dp = (byte) 2;
                        z2 = true;
                        i5 = 0;
                        i6 = 4;
                        i7 = 0;
                        break;
                    case 3:
                        i4 = this.f227cC;
                        int i19 = this.f227cC - 4;
                        int i20 = this.f336eu;
                        this.f289dp = (byte) 3;
                        z2 = true;
                        i5 = 0;
                        i6 = i20;
                        i7 = i19;
                        break;
                    case 4:
                        this.f191bP = true;
                        z = true;
                        i5 = i13;
                        i6 = i12;
                        i7 = i11;
                        i4 = i10;
                        break;
                    case 5:
                        int i21 = this.f227cC;
                        int i22 = this.f227cC - 4;
                        i5 = 0;
                        i6 = this.f336eu;
                        i7 = i22;
                        i4 = i21;
                        break;
                    case 6:
                        i5 = 0;
                        i6 = this.f336eu;
                        i7 = 0;
                        i4 = 4;
                        break;
                    case 7:
                        int i23 = this.f227cC;
                        int i24 = this.f336eu;
                        i5 = this.f336eu - 4;
                        i6 = i24;
                        i7 = 0;
                        i4 = i23;
                        break;
                    case 8:
                        i5 = 0;
                        i6 = 4;
                        i7 = 0;
                        i4 = this.f227cC;
                        break;
                    case 9:
                        int i25 = (this.f227cC * 2) / 3;
                        int i26 = (this.f227cC * 1) / 3;
                        int i27 = (this.f336eu * 2) / 3;
                        i5 = (this.f336eu * 1) / 3;
                        i6 = i27;
                        i7 = i26;
                        i4 = i25;
                        break;
                    case 10:
                        this.f248cf = true;
                        z = true;
                        i5 = i13;
                        i6 = i12;
                        i7 = i11;
                        i4 = i10;
                        break;
                    case 11:
                        this.f191bP = true;
                        this.f261d5 = true;
                        z = true;
                        i5 = i13;
                        i6 = i12;
                        i7 = i11;
                        i4 = i10;
                        break;
                    case 12:
                    default:
                        z = true;
                        i5 = i13;
                        i6 = i12;
                        i7 = i11;
                        i4 = i10;
                        break;
                    case 13:
                        z = true;
                        this.f155aX = true;
                        i5 = i13;
                        i6 = i12;
                        i7 = i11;
                        i4 = i10;
                        break;
                    case 14:
                        this.f301e6 = true;
                        z = true;
                        i5 = i13;
                        i6 = i12;
                        i7 = i11;
                        i4 = i10;
                        break;
                    case 15:
                        i4 = (this.f227cC * 2) / 3;
                        int i28 = this.f227cC / 3;
                        int i29 = (this.f336eu * 2) / 3;
                        int i30 = this.f227cC / 3;
                        m114new(i14, 15);
                        z = true;
                        i5 = i30;
                        i6 = i29;
                        i7 = i28;
                        break;
                    case f55cH /* 16 */:
                        i4 = (this.f227cC * 2) / 3;
                        int i31 = this.f227cC / 3;
                        int i32 = (this.f336eu * 2) / 3;
                        int i33 = this.f227cC / 3;
                        m114new(i14, 16);
                        z = true;
                        i5 = i33;
                        i6 = i32;
                        i7 = i31;
                        break;
                    case f89df /* 17 */:
                        i4 = (this.f227cC * 2) / 3;
                        int i34 = this.f227cC / 3;
                        int i35 = (this.f336eu * 2) / 3;
                        int i36 = this.f227cC / 3;
                        m114new(i14, 17);
                        z = true;
                        i5 = i36;
                        i6 = i35;
                        i7 = i34;
                        break;
                    case 18:
                        i4 = (this.f227cC * 2) / 3;
                        int i37 = this.f227cC / 3;
                        int i38 = (this.f336eu * 2) / 3;
                        int i39 = this.f227cC / 3;
                        m114new(i14, 18);
                        z = true;
                        i5 = i39;
                        i6 = i38;
                        i7 = i37;
                        break;
                    case f59cX /* 19 */:
                        i4 = (this.f227cC * 2) / 3;
                        int i40 = this.f227cC / 3;
                        int i41 = (this.f336eu * 2) / 3;
                        int i42 = this.f227cC / 3;
                        m114new(i14, 19);
                        z = true;
                        i5 = i42;
                        i6 = i41;
                        i7 = i40;
                        break;
                    case 20:
                        i4 = (this.f227cC * 2) / 3;
                        int i43 = this.f227cC / 3;
                        int i44 = (this.f336eu * 2) / 3;
                        int i45 = this.f227cC / 3;
                        m114new(i14, 20);
                        z = true;
                        i5 = i45;
                        i6 = i44;
                        i7 = i43;
                        break;
                    case 21:
                        i4 = (this.f227cC * 2) / 3;
                        int i46 = this.f227cC / 3;
                        int i47 = (this.f336eu * 2) / 3;
                        int i48 = this.f227cC / 3;
                        m114new(i14, 21);
                        z = true;
                        i5 = i48;
                        i6 = i47;
                        i7 = i46;
                        break;
                    case f116fn /* 22 */:
                        i4 = (this.f227cC * 2) / 3;
                        int i49 = this.f227cC / 3;
                        int i50 = (this.f336eu * 2) / 3;
                        int i51 = this.f227cC / 3;
                        m114new(i14, 22);
                        z = true;
                        i5 = i51;
                        i6 = i50;
                        i7 = i49;
                        break;
                    case 23:
                        i4 = (this.f227cC * 2) / 3;
                        int i52 = this.f227cC / 3;
                        int i53 = (this.f336eu * 2) / 3;
                        int i54 = this.f227cC / 3;
                        m114new(i14, 23);
                        z = true;
                        i5 = i54;
                        i6 = i53;
                        i7 = i52;
                        break;
                    case 24:
                        i4 = (this.f227cC * 2) / 3;
                        int i55 = this.f227cC / 3;
                        int i56 = (this.f336eu * 2) / 3;
                        int i57 = this.f227cC / 3;
                        m114new(i14, 24);
                        z = true;
                        i5 = i57;
                        i6 = i56;
                        i7 = i55;
                        break;
                    case 25:
                        z = true;
                        m114new(i14, 25);
                        i5 = i13;
                        i6 = i12;
                        i7 = i11;
                        i4 = i10;
                        break;
                    case 26:
                        i4 = 4;
                        int i58 = this.f336eu;
                        this.f289dp = (byte) 26;
                        z2 = true;
                        i5 = 0;
                        i6 = i58;
                        i7 = 0;
                        break;
                    case 27:
                        i4 = this.f227cC;
                        int i59 = this.f227cC - 4;
                        int i60 = this.f336eu;
                        this.f289dp = (byte) 27;
                        z2 = true;
                        i5 = 0;
                        i6 = i60;
                        i7 = i59;
                        break;
                }
                if ((!this.f204bh) & z2) {
                    boolean z3 = true;
                    int i61 = 0;
                    for (int i62 = 0; i62 < this.f209bo.length && z3; i62++) {
                        if (this.f209bo[i62] == m115try(this.f213bv)[0] && this.f208bn[i62] == m115try(this.f213bv)[1] && this.f245ca[i62] == i && this.f181b9[i62] == i2) {
                            z3 = false;
                            i61 = i62;
                        }
                    }
                    boolean z4 = true;
                    switch (this.f172ay[i61]) {
                        case 0:
                            if (!this.f274dQ) {
                                z4 = false;
                            }
                            break;
                        case 1:
                            if (!this.f314eQ) {
                                z4 = false;
                            }
                            break;
                        case 2:
                            if (!this.f149aN) {
                                z4 = false;
                            }
                            break;
                    }
                    if ((this.f289dp == 26) & this.f337ev) {
                        z4 = false;
                    }
                    if (z4) {
                        m64a(50, 250);
                        this.f234cM = true;
                        this.f204bh = true;
                        if (this.f289dp == 0) {
                            i8 = 0;
                            i9 = f31at;
                        } else if (this.f289dp == 2) {
                            i8 = 2200;
                            i9 = 3200;
                        } else if (this.f289dp == 1 || this.f289dp == 26) {
                            i8 = 1200;
                            i9 = 2200;
                        } else {
                            i8 = 3600;
                            i9 = 4600;
                        }
                        this.f285di = m12a(this.f285di, new int[]{m49if(i, i2), 0, 0, i9, i8, 0, 0});
                        this.f140aC = m10a(this.f140aC, new byte[]{0, (byte) i, (byte) i2, 0});
                    }
                    z = false;
                }
                i10 = i4 + (this.f227cC * i);
                i11 = i7 + (this.f227cC * i);
                i12 = i6 + (this.f336eu * i2);
                i13 = (this.f336eu * i2) + i5;
                if (!z) {
                    zM36a = m36a(i10, i11, i12, i13);
                }
            }
        } else {
            this.f169au = true;
        }
        return zM36a;
    }

    @Override // p001a.p002a.p003a.p004a.RunnableC0001a
    /* JADX INFO: renamed from: do */
    public byte[] mo43do(Gauge gauge) {
        m37b();
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeByte(this.f192bS);
            dataOutputStream.writeFloat(this.f157aa);
            dataOutputStream.writeFloat(this.f342fb);
            dataOutputStream.writeInt(this.f353fs);
            dataOutputStream.writeInt(this.f352fr);
            dataOutputStream.writeFloat(this.f351fq);
            dataOutputStream.writeInt(this.f348fj);
            dataOutputStream.writeBoolean(this.f337ev);
            dataOutputStream.writeBoolean(this.f274dQ);
            dataOutputStream.writeBoolean(this.f314eQ);
            dataOutputStream.writeBoolean(this.f149aN);
            dataOutputStream.writeInt(this.f349fk);
            dataOutputStream.writeInt(this.f334er);
            dataOutputStream.writeFloat(this.f239cS);
            dataOutputStream.writeBoolean(this.f145aI);
            dataOutputStream.writeByte(this.f163ak);
            dataOutputStream.writeBoolean(this.f187bJ);
            dataOutputStream.writeInt(this.f165am);
            dataOutputStream.writeInt(this.f213bv);
            for (int i = 0; i < this.f158ad.length; i++) {
                dataOutputStream.writeBoolean(this.f158ad[i]);
            }
            for (int i2 = 0; i2 < this.f305eA.length; i2++) {
                dataOutputStream.writeBoolean(this.f305eA[i2]);
            }
            if (this.f119I != null) {
                dataOutputStream.writeBoolean(true);
                for (int i3 = 0; i3 < this.f119I.length; i3++) {
                    dataOutputStream.writeFloat(this.f119I[i3]);
                    dataOutputStream.writeFloat(this.f354ft[i3]);
                    dataOutputStream.writeByte(this.f159af[i3]);
                    dataOutputStream.writeInt(this.f138aA[i3]);
                    dataOutputStream.writeFloat(this.f206bk[i3]);
                }
            } else {
                dataOutputStream.writeBoolean(false);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (Exception e) {
            System.out.println("saving error");
            return null;
        }
    }

    /* JADX INFO: renamed from: e */
    public void m44e() {
        this.f170av = false;
        this.f297dz = false;
        this.f229cE = false;
        m48i();
        this.f313eN = (byte) 0;
        this.f128Z = 6;
        this.f222c7 = false;
        this.f310eG = 0;
        this.f199bb = false;
        this.f284dh = false;
        m39d();
        this.f187bJ = false;
        this.f201bd = false;
        this.f164al = false;
        this.f204bh = false;
        this.f286dj = false;
        this.f344fd = true;
        this.f207bl = true;
        this.f337ev = false;
        this.f274dQ = false;
        this.f314eQ = false;
        this.f149aN = false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX INFO: renamed from: f */
    public void m45f() {
        if (this.f140aC == null) {
            return;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.f140aC.length) {
                return;
            }
            if (this.f140aC[i2] != null && this.f140aC[i2][3] == 1) {
                switch (this.f140aC[i2][0]) {
                    case 0:
                        boolean z = true;
                        int i3 = 0;
                        for (int i4 = 0; i4 < this.f209bo.length && z; i4++) {
                            if (this.f209bo[i4] == m115try(this.f213bv)[0] && this.f208bn[i4] == m115try(this.f213bv)[1] && this.f245ca[i4] == this.f140aC[i2][1] && this.f181b9[i4] == this.f140aC[i2][2]) {
                                z = false;
                                i3 = i4;
                            }
                        }
                        int i5 = i3 / 2 == (i3 + 1) / 2 ? 1 : -1;
                        switch (this.f147aL[i3 + i5]) {
                            case 0:
                                this.f157aa = 1.5707964f;
                                this.f353fs = (this.f245ca[i3 + i5] * this.f227cC) + ((this.f227cC - 75) / 2) + 37;
                                this.f352fr = (this.f181b9[i3 + i5] * this.f336eu) + ((this.f336eu - 75) / 2) + 37 + this.f336eu;
                                break;
                            case 1:
                                this.f353fs = ((this.f245ca[i3 + i5] * this.f227cC) - ((this.f227cC - 75) / 2)) - 37;
                                this.f352fr = (this.f181b9[i3 + i5] * this.f336eu) + ((this.f336eu - 75) / 2) + 37;
                                this.f157aa = 3.1415927f;
                                break;
                            case 2:
                                this.f157aa = 4.712389f;
                                this.f353fs = (this.f245ca[i3 + i5] * this.f227cC) + ((this.f227cC - 75) / 2) + 37;
                                this.f352fr = ((this.f181b9[i3 + i5] * this.f336eu) - ((this.f336eu - 75) / 2)) - 37;
                                break;
                            case 3:
                                this.f353fs = (this.f245ca[i3 + i5] * this.f227cC) + ((this.f227cC - 75) / 2) + 37 + this.f227cC;
                                this.f352fr = (this.f181b9[i3 + i5] * this.f336eu) + ((this.f336eu - 75) / 2) + 37;
                                this.f157aa = 0.0f;
                                break;
                            case 26:
                                this.f199bb = false;
                                this.f337ev = true;
                                this.f353fs = ((this.f245ca[i3 + i5] * this.f227cC) - ((this.f227cC - 75) / 2)) - 37;
                                this.f352fr = (this.f181b9[i3 + i5] * this.f336eu) + ((this.f336eu - 75) / 2) + 37;
                                this.f157aa = 3.1415927f;
                                break;
                            case 27:
                                this.f199bb = true;
                                this.f163ak = (byte) 0;
                                this.f164al = false;
                                this.f353fs = (this.f245ca[i3 + i5] * this.f227cC) + ((this.f227cC - 75) / 2) + 37 + this.f227cC;
                                this.f352fr = (this.f181b9[i3 + i5] * this.f336eu) + ((this.f336eu - 75) / 2) + 37;
                                this.f157aa = 0.0f;
                                this.f353fs = (this.f245ca[i3 + i5] * this.f227cC) + ((this.f227cC - 75) / 2) + 37 + this.f227cC;
                                this.f352fr = (this.f181b9[i3 + i5] * this.f336eu) + ((this.f336eu - 75) / 2) + 37;
                                this.f157aa = 0.0f;
                                break;
                        }
                        this.f125W = false;
                        m39d();
                        this.f223c8 = (this.f208bn[i3 + i5] * this.f291ds) + this.f209bo[i3 + i5];
                        this.f392y.commandAction(this.f391w, this);
                        this.f348fj = this.f180b8[i5 + i3];
                        this.f351fq = this.f348fj * 20;
                        if (!this.f199bb) {
                            this.f234cM = false;
                        }
                        this.f204bh = false;
                        break;
                    case 2:
                        float[] fArr = new float[6];
                        RayIntersection rayIntersection = new RayIntersection();
                        float f = (this.f157aa / 6.2831855f) * 360.0f;
                        boolean z2 = true;
                        int i6 = 0;
                        while (true) {
                            int i7 = i6;
                            boolean z3 = z2;
                            if (i7 < f14T.length && z3) {
                                if (this.f257ct.pick(-1, f14T[i7], f13S[i7], this.f276dT, rayIntersection)) {
                                    rayIntersection.getRay(fArr);
                                    Mesh intersected = rayIntersection.getIntersected();
                                    if ((intersected instanceof Mesh) && this.f151aQ != null) {
                                        int i8 = 0;
                                        while (true) {
                                            int i9 = i8;
                                            if (i9 >= this.f151aQ.length) {
                                            }
                                            if (!this.f267dE[i9] && intersected.getUserID() == i9 + 2100) {
                                                z3 = false;
                                                float distance = fArr[0] + (fArr[3] * rayIntersection.getDistance());
                                                float distance2 = fArr[1] + (fArr[4] * rayIntersection.getDistance());
                                                float distance3 = fArr[2] + (fArr[5] * rayIntersection.getDistance());
                                                float f2 = distance - this.f353fs;
                                                float f3 = distance2 - this.f352fr;
                                                float f4 = distance3 - ((150.0f + ((this.f246cc * this.f351fq) / 20.0f)) + this.f351fq);
                                                if (Math.sqrt((f2 * f2) + (f3 * f3) + (f4 * f4)) < 250.0d) {
                                                    m111int(i9);
                                                }
                                            }
                                            i8 = i9 + 1;
                                            break;
                                        }
                                    }
                                }
                                z2 = z3;
                                i6 = i7 + 1;
                            }
                        }
                        m107for(2004, 2300, 2000);
                        if (this.f140aC != null) {
                            this.f140aC = m9a(this.f140aC, i2);
                        }
                        break;
                    case 3:
                        float[] fArr2 = new float[6];
                        RayIntersection rayIntersection2 = new RayIntersection();
                        float f5 = (this.f157aa / 6.2831855f) * 360.0f;
                        int i10 = 0;
                        while (true) {
                            int i11 = i10;
                            if (i11 >= f14T.length) {
                                m107for(2004, 3300, 2800);
                                if (this.f140aC != null) {
                                    this.f140aC = m9a(this.f140aC, i2);
                                }
                            } else {
                                if (this.f257ct.pick(-1, f14T[i11], f13S[i11], this.f276dT, rayIntersection2)) {
                                    rayIntersection2.getRay(fArr2);
                                    Mesh intersected2 = rayIntersection2.getIntersected();
                                    if ((intersected2 instanceof Mesh) && this.f151aQ != null) {
                                        int i12 = 0;
                                        while (true) {
                                            int i13 = i12;
                                            if (i13 >= this.f151aQ.length) {
                                            }
                                            if (!this.f267dE[i13] && intersected2.getUserID() == i13 + 2100) {
                                                float distance4 = fArr2[0] + (fArr2[3] * rayIntersection2.getDistance());
                                                float distance5 = fArr2[1] + (fArr2[4] * rayIntersection2.getDistance());
                                                float distance6 = fArr2[2] + (fArr2[5] * rayIntersection2.getDistance());
                                                float f6 = distance4 - this.f353fs;
                                                float f7 = distance5 - this.f352fr;
                                                float f8 = distance6 - ((150.0f + ((this.f246cc * this.f351fq) / 20.0f)) + this.f351fq);
                                                if (Math.sqrt((f6 * f6) + (f7 * f7) + (f8 * f8)) < 250.0d) {
                                                    m111int(i13);
                                                }
                                            }
                                            i12 = i13 + 1;
                                            break;
                                        }
                                    }
                                }
                                i10 = i11 + 1;
                            }
                            break;
                        }
                        break;
                }
            }
            i = i2 + 1;
        }
    }

    @Override // p001a.p002a.p003a.p004a.RunnableC0001a
    /* JADX INFO: renamed from: for, reason: not valid java name */
    public void mo106for() {
        try {
            this.f262d7.releaseTarget();
        } catch (Exception e) {
            System.out.println(new StringBuffer().append("target exists prob=").append(e).toString());
        }
        this.f262d7.setCamera((Camera) null, (Transform) null);
        this.f262d7.resetLights();
        m33a((Group) this.f257ct);
        this.f134a6 = null;
        this.f129a0 = null;
        this.f212bu = null;
        this.f266dD = null;
        this.f244cZ = null;
        this.f294dw = null;
        this.f228cD = null;
        this.f276dT = null;
        this.f320eZ = null;
        this.f168aq = null;
        this.f202bf = null;
        this.f133a5 = null;
        this.f257ct = null;
        System.gc();
    }

    /* JADX INFO: renamed from: for, reason: not valid java name */
    public void m107for(int i, int i2, int i3) {
        boolean z = true;
        for (int i4 = 0; i4 < this.f285di.length && z; i4++) {
            if (this.f285di[i4][0] == i) {
                this.f285di[i4][2] = i3;
                this.f285di[i4][4] = i3;
                this.f285di[i4][3] = i2;
                this.f285di[i4][1] = 0;
                z = false;
            }
        }
    }

    /* JADX INFO: renamed from: for, reason: not valid java name */
    public void m108for(Gauge gauge) {
        this.f157aa = 0.0f;
        try {
            this.f265dC = System.currentTimeMillis();
            this.f350fm = this.f156aY.getHeight() - 1;
            this.f167ap = (this.f315eR - this.f174b0.getHeight()) - this.f350fm;
            DataInputStream dataInputStream = new DataInputStream(getClass().getResourceAsStream("/Dungeon.dat"));
            this.f291ds = dataInputStream.readByte();
            this.f203bg = dataInputStream.readByte();
            this.f259cy = dataInputStream.readByte();
            this.f307eD = dataInputStream.readByte();
            this.f241cU = dataInputStream.readByte();
            this.f353fs = dataInputStream.readInt() + 37 + ((this.f176b3 - 75) / 2);
            this.f352fr = dataInputStream.readInt() + 37 + ((this.f251ck - 75) / 2);
            this.f348fj = dataInputStream.readByte();
            this.f351fq = this.f348fj * 20;
            int i = dataInputStream.readByte();
            this.f209bo = new byte[i];
            this.f208bn = new byte[i];
            this.f245ca = new byte[i];
            this.f181b9 = new byte[i];
            this.f180b8 = new byte[i];
            this.f147aL = new byte[i];
            this.f172ay = new byte[i];
            for (int i2 = 0; i2 < i; i2++) {
                this.f209bo[i2] = dataInputStream.readByte();
                this.f208bn[i2] = dataInputStream.readByte();
                this.f245ca[i2] = dataInputStream.readByte();
                this.f181b9[i2] = dataInputStream.readByte();
                this.f180b8[i2] = dataInputStream.readByte();
                this.f147aL[i2] = dataInputStream.readByte();
                this.f172ay[i2] = dataInputStream.readByte();
            }
            int i3 = dataInputStream.readByte();
            this.f195bW = new byte[i3];
            this.f193bU = new byte[i3];
            this.f179b7 = new byte[i3];
            this.f178b6 = new byte[i3];
            this.f177b5 = new byte[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                this.f195bW[i4] = dataInputStream.readByte();
                this.f193bU[i4] = dataInputStream.readByte();
                this.f179b7[i4] = dataInputStream.readByte();
                this.f178b6[i4] = dataInputStream.readByte();
                this.f177b5[i4] = dataInputStream.readByte();
            }
            this.f241cU = dataInputStream.readByte();
            this.f250cj = new int[this.f241cU];
            this.f148aM = new int[this.f241cU];
            int i5 = 0;
            for (int i6 = 0; i6 < this.f241cU; i6++) {
                this.f250cj[i6] = dataInputStream.readInt();
                i5 += this.f250cj[i6];
                this.f148aM[i6] = dataInputStream.readByte();
            }
            int i7 = dataInputStream.readInt();
            this.f154aW = new byte[i7];
            this.f161ai = new int[i7];
            this.f158ad = new boolean[i7];
            for (int i8 = 0; i8 < i7; i8++) {
                this.f158ad[i8] = false;
                this.f154aW[i8] = dataInputStream.readByte();
                this.f161ai[i8] = dataInputStream.readInt();
            }
            int i9 = dataInputStream.readInt();
            this.f260d0 = new byte[i9];
            this.f160ag = new byte[i9];
            this.f305eA = new boolean[i9];
            for (int i10 = 0; i10 < i9; i10++) {
                this.f305eA[i10] = false;
                this.f260d0[i10] = dataInputStream.readByte();
                this.f160ag[i10] = dataInputStream.readByte();
            }
            dataInputStream.close();
            DataInputStream dataInputStream2 = new DataInputStream(getClass().getResourceAsStream("/Rooms.dat"));
            this.f238cR = new byte[i5];
            dataInputStream2.readFully(this.f238cR);
            this.f124V = 0;
        } catch (Exception e) {
            System.out.println(new StringBuffer().append("loading dungeon failed - ").append(e).toString());
        }
    }

    /* JADX INFO: renamed from: for, reason: not valid java name */
    public void m109for(Graphics graphics) {
        if (this.f344fd) {
            this.f171aw = Image.createImage(this.f268dF, this.f174b0.getHeight());
            Graphics graphics2 = this.f171aw.getGraphics();
            graphics2.drawImage(this.f174b0, 0, 0, 20);
            if (this.f274dQ) {
                graphics2.drawImage(this.f120J, 19, 4, 20);
            }
            if (this.f149aN) {
                graphics2.drawImage(this.f326eg, 63, 4, 20);
            }
            if (this.f314eQ) {
                graphics2.drawImage(this.f152aR, 41, 4, 20);
            }
            m53if(graphics2, m63a(new StringBuffer().append("").append((int) this.f192bS).toString(), RunnableC0001a.f357A.f470y), RunnableC0001a.f357A.f411C, f64cm, 8, 20);
            this.f344fd = false;
        }
        graphics.drawImage(this.f171aw, 0, 0, 20);
        if (this.f207bl) {
            this.f328ej = Image.createImage(this.f268dF, this.f156aY.getHeight());
            Graphics graphics3 = this.f328ej.getGraphics();
            graphics3.drawImage(this.f156aY, 0, 0, 20);
            m53if(graphics3, m63a(new StringBuffer().append("").append(Integer.toString((this.f334er / f31at) % 10)).append(Integer.toString((this.f334er / 100) % 10)).append(Integer.toString((this.f334er / 10) % 10)).append(Integer.toString(this.f334er % 10)).toString(), RunnableC0001a.f357A.f470y), RunnableC0001a.f357A.f411C, f36bB, 13, 20);
            if (this.f337ev) {
                graphics3.drawImage(this.f188bL, f56cI, 16, 20);
                graphics3.drawImage(this.f211bt, 92, 12, 20);
            }
            graphics3.setClip(0, 0, ((this.f349fk * this.f210br.getWidth()) / f31at) + 36, 100);
            graphics3.drawImage(this.f210br, 36, 17, 20);
            graphics3.setClip(0, 0, this.f268dF, this.f315eR);
            graphics3.drawImage(this.f216by, this.f380e == -7 ? (this.f268dF - this.f216by.getWidth()) - 4 : 6, this.f328ej.getHeight() - this.f216by.getHeight(), 20);
            this.f207bl = false;
        }
        graphics.drawImage(this.f328ej, 0, this.f315eR, 36);
        graphics.setClip(0, 0, this.f268dF, this.f315eR);
    }

    /* JADX INFO: renamed from: g */
    public void m46g() {
        int i;
        float f;
        boolean zM36a;
        boolean z;
        int i2;
        int i3;
        try {
            if (this.f151aQ != null) {
                int i4 = 0;
                while (i4 < this.f151aQ.length) {
                    if (!this.f267dE[i4]) {
                        switch (this.f151aQ[i4]) {
                            case 0:
                                int[] iArr = this.f132a4;
                                iArr[i4] = (int) (iArr[i4] + this.f273dP);
                                int i5 = f115fl[this.f240cT[i4]][1] + f115fl[this.f240cT[i4]][4];
                                int i6 = f115fl[this.f240cT[i4]][0] + f115fl[this.f240cT[i4]][5];
                                if (this.f240cT[i4] == 0) {
                                    i = 1500;
                                } else {
                                    if (this.f240cT[i4] != 1 && this.f240cT[i4] != 2 && this.f240cT[i4] == 4) {
                                    }
                                    i = 2500;
                                }
                                if ((this.f285di[this.f279dZ[i4]][2] > i) && (((float) this.f285di[this.f279dZ[i4]][2]) - this.f273dP < ((float) i))) {
                                    int i7 = f115fl[this.f240cT[i4]][4];
                                    int iM100for = ((int) (((double) m100for(i7, i7)) * Math.cos(this.f206bk[i4]))) + ((int) this.f119I[i4]);
                                    int iM100for2 = ((int) (((double) m100for(i7, i7)) * Math.sin(this.f206bk[i4]))) + ((int) this.f354ft[i4]);
                                    if (!m36a((int) Math.max(iM100for, this.f119I[i4]), (int) Math.min(iM100for, this.f119I[i4]), (int) Math.max(iM100for2, this.f354ft[i4]), (int) Math.min(iM100for2, this.f354ft[i4]))) {
                                        if (this.f337ev) {
                                            this.f349fk -= f115fl[this.f240cT[i4]][3] / 2;
                                        } else {
                                            this.f349fk -= f115fl[this.f240cT[i4]][3];
                                        }
                                        if (this.f349fk > 0) {
                                            m67a(this.f318eU[1]);
                                        }
                                        this.f230cF = true;
                                    } else if (this.f132a4[i4] <= f31at) {
                                        this.f282de[i4] = true;
                                        int i8 = this.f353fs - ((int) this.f119I[i4]);
                                        int i9 = this.f352fr - ((int) this.f354ft[i4]);
                                        if (i8 != 0) {
                                            this.f258cx[i4] = m1a(i9 / i8);
                                        } else {
                                            this.f258cx[i4] = 4.712389f;
                                        }
                                        if (((i9 < 0) & (i8 < 0)) | ((i8 < 0) & (i9 >= 0))) {
                                            float[] fArr = this.f258cx;
                                            fArr[i4] = (float) (((double) fArr[i4]) + 3.141592653589793d);
                                        }
                                        this.f151aQ[i4] = 6;
                                    } else {
                                        this.f282de[i4] = false;
                                        this.f151aQ[i4] = 1;
                                        this.f151aQ[i4] = 2;
                                        int i10 = 0;
                                        int i11 = 2000;
                                        if (this.f240cT[i4] == 0) {
                                            i10 = 0;
                                            i11 = 3000;
                                        } else if (this.f240cT[i4] == 1) {
                                            i10 = 0;
                                            i11 = 1100;
                                        } else if (this.f240cT[i4] == 2 || this.f240cT[i4] == 4) {
                                        }
                                        m107for(i4 + f49bq, i11, i10);
                                    }
                                }
                                break;
                            case 1:
                                if (this.f200bc[i4] < this.f215bx[i4]) {
                                    if (this.f348fj == this.f123P[i4] || this.f348fj == this.f123P[i4] + 1 || this.f348fj == this.f123P[i4] + 2 || this.f348fj == this.f123P[i4] - 1) {
                                        int i12 = f115fl[this.f240cT[i4]][1] + f115fl[this.f240cT[i4]][4];
                                        int i13 = f115fl[this.f240cT[i4]][5] + f115fl[this.f240cT[i4]][0];
                                        boolean zM36a2 = m36a(((int) this.f119I[i4]) + (i13 / 2), ((int) this.f119I[i4]) - (i13 / 2), ((int) this.f354ft[i4]) + (i12 / 2), ((int) this.f354ft[i4]) - (i12 / 2));
                                        zM36a = m36a((int) (this.f119I[i4] + (this.f232cK[i4] * this.f319eY) + (i13 / 2)), (int) ((this.f119I[i4] + (this.f232cK[i4] * this.f319eY)) - (i13 / 2)), (int) (this.f354ft[i4] + (this.f175b1[i4] * this.f319eY) + (i12 / 2)), (int) ((this.f354ft[i4] + (this.f175b1[i4] * this.f319eY)) - (i12 / 2)));
                                        z = zM36a2;
                                    } else {
                                        zM36a = true;
                                        z = true;
                                    }
                                    if ((this.f240cT[i4] == 0) & (!z)) {
                                        if (this.f337ev) {
                                            this.f349fk -= f115fl[this.f240cT[i4]][3] / 2;
                                        } else {
                                            this.f349fk -= f115fl[this.f240cT[i4]][3];
                                        }
                                        this.f230cF = true;
                                    }
                                    if ((!(!this.f282de[i4]) || !z) || !zM36a) {
                                        this.f282de[i4] = true;
                                        this.f132a4[i4] = 0;
                                        int i14 = this.f353fs - ((int) this.f119I[i4]);
                                        int i15 = this.f352fr - ((int) this.f354ft[i4]);
                                        if (i14 != 0) {
                                            this.f258cx[i4] = m1a(i15 / i14);
                                        } else {
                                            this.f258cx[i4] = 4.712389f;
                                        }
                                        if (((i15 < 0) & (i14 < 0)) | ((i14 < 0) & (i15 >= 0))) {
                                            float[] fArr2 = this.f258cx;
                                            fArr2[i4] = (float) (((double) fArr2[i4]) + 3.141592653589793d);
                                        }
                                        this.f151aQ[i4] = 6;
                                    } else if (this.f200bc[i4] + this.f319eY > this.f215bx[i4]) {
                                        float f2 = this.f215bx[i4] - this.f200bc[i4];
                                        float[] fArr3 = this.f119I;
                                        fArr3[i4] = fArr3[i4] + (this.f232cK[i4] * f2);
                                        float[] fArr4 = this.f354ft;
                                        fArr4[i4] = fArr4[i4] + (this.f175b1[i4] * f2);
                                        float[] fArr5 = this.f200bc;
                                        fArr5[i4] = f2 + fArr5[i4];
                                    } else {
                                        float[] fArr6 = this.f119I;
                                        fArr6[i4] = fArr6[i4] + (this.f232cK[i4] * this.f319eY);
                                        float[] fArr7 = this.f354ft;
                                        fArr7[i4] = fArr7[i4] + (this.f175b1[i4] * this.f319eY);
                                        float[] fArr8 = this.f200bc;
                                        fArr8[i4] = fArr8[i4] + this.f319eY;
                                    }
                                } else if (this.f159af[i4] + this.f138aA[i4] < this.f254cp[i4].length - 1 && this.f159af[i4] + this.f138aA[i4] > 0) {
                                    byte[] bArr = this.f159af;
                                    bArr[i4] = (byte) (bArr[i4] + this.f138aA[i4]);
                                    this.f151aQ[i4] = 2;
                                } else if (!this.f311eH[i4]) {
                                    this.f151aQ[i4] = 4;
                                } else {
                                    byte[] bArr2 = this.f159af;
                                    bArr2[i4] = (byte) (bArr2[i4] + this.f138aA[i4]);
                                    this.f138aA[i4] = -this.f138aA[i4];
                                    this.f151aQ[i4] = 2;
                                }
                                break;
                            case 2:
                                this.f278dY[i4] = true;
                                if (!(this.f331en[i4] ? false : m36a(this.f131a3[i4] * this.f227cC, this.f220c4[i4] * this.f227cC, this.f130a2[i4] * this.f336eu, this.f218c2[i4] * this.f336eu))) {
                                    if (this.f331en[i4]) {
                                        i2 = this.f254cp[i4][this.f159af[i4] + this.f138aA[i4]];
                                        i3 = this.f253co[i4][this.f159af[i4] + this.f138aA[i4]];
                                    } else {
                                        this.f264dB[i4] = 1;
                                        this.f159af[i4] = 0;
                                        this.f200bc[i4] = 0.0f;
                                        this.f138aA[i4] = 1;
                                        i2 = this.f353fs;
                                        i3 = this.f352fr;
                                        if ((this.f354ft[i4] == ((float) this.f352fr)) & (this.f119I[i4] == ((float) this.f353fs))) {
                                            this.f278dY[i4] = false;
                                        }
                                    }
                                    int i16 = i2 - ((int) this.f119I[i4]);
                                    int i17 = i3 - ((int) this.f354ft[i4]);
                                    this.f215bx[i4] = m100for(i16, i17) / this.f139aB[i4];
                                    if (this.f215bx[i4] != 0) {
                                        this.f232cK[i4] = i16 / this.f215bx[i4];
                                        this.f175b1[i4] = i17 / this.f215bx[i4];
                                    } else {
                                        this.f232cK[i4] = 0;
                                        this.f175b1[i4] = 0;
                                    }
                                    if (i16 != 0) {
                                        this.f258cx[i4] = m1a(i17 / i16);
                                    } else if (i17 <= 0) {
                                        this.f258cx[i4] = 4.712389f;
                                    } else {
                                        this.f258cx[i4] = 1.5707964f;
                                    }
                                    if (((i17 < 0) & (i16 < 0)) | ((i16 < 0) & (i17 >= 0))) {
                                        float[] fArr9 = this.f258cx;
                                        fArr9[i4] = (float) (((double) fArr9[i4]) + 3.141592653589793d);
                                    }
                                    this.f200bc[i4] = 0.0f;
                                    this.f151aQ[i4] = 6;
                                } else {
                                    this.f278dY[i4] = false;
                                }
                                break;
                            case 5:
                                if (this.f341ez[i4] < this.f292dt[i4]) {
                                    if (this.f221c5[i4]) {
                                        float[] fArr10 = this.f206bk;
                                        fArr10[i4] = fArr10[i4] - (0.17453294f * this.f319eY);
                                    } else {
                                        float[] fArr11 = this.f206bk;
                                        fArr11[i4] = fArr11[i4] + (0.17453294f * this.f319eY);
                                    }
                                    float[] fArr12 = this.f341ez;
                                    fArr12[i4] = fArr12[i4] + this.f319eY;
                                } else if (!this.f282de[i4]) {
                                    this.f206bk[i4] = this.f258cx[i4];
                                    this.f151aQ[i4] = 1;
                                } else {
                                    this.f151aQ[i4] = 0;
                                    int i18 = 2130;
                                    int i19 = 3000;
                                    if (this.f240cT[i4] == 0) {
                                        i18 = 0;
                                        i19 = 3000;
                                    } else if (this.f240cT[i4] == 1) {
                                        i18 = 1700;
                                        i19 = 2650;
                                    } else if (this.f240cT[i4] == 2 || this.f240cT[i4] == 4) {
                                    }
                                    m107for(i4 + f49bq, i19, i18);
                                }
                                break;
                            case 6:
                                if (this.f206bk[i4] == this.f258cx[i4]) {
                                    this.f151aQ[i4] = 1;
                                } else {
                                    if (this.f258cx[i4] > this.f206bk[i4]) {
                                        if (this.f258cx[i4] - this.f206bk[i4] < 3.141592653589793d) {
                                            this.f221c5[i4] = false;
                                        } else {
                                            this.f221c5[i4] = true;
                                        }
                                        f = this.f258cx[i4] - this.f206bk[i4];
                                    } else {
                                        if (this.f206bk[i4] - this.f258cx[i4] < 3.141592653589793d) {
                                            this.f221c5[i4] = true;
                                        } else {
                                            this.f221c5[i4] = false;
                                        }
                                        f = this.f206bk[i4] - this.f258cx[i4];
                                    }
                                    if ((this.f258cx[i4] > this.f206bk[i4]) && this.f221c5[i4]) {
                                        f = this.f206bk[i4] + (6.2831855f - this.f258cx[i4]);
                                    } else {
                                        if ((this.f258cx[i4] < this.f206bk[i4]) & (!this.f221c5[i4])) {
                                            f = this.f258cx[i4] + (6.2831855f - this.f206bk[i4]);
                                        }
                                    }
                                    this.f292dt[i4] = (int) (((double) f) / 0.17453292519943295d);
                                    this.f341ez[i4] = 0.0f;
                                    this.f151aQ[i4] = 5;
                                }
                                break;
                        }
                    }
                    i4++;
                }
            }
        } catch (Exception e) {
            System.out.println(new StringBuffer().append("monster monster ex=").append(e).toString());
        }
    }

    @Override // p001a.p002a.p003a.p004a.RunnableC0001a
    /* JADX INFO: renamed from: goto, reason: not valid java name */
    public boolean mo110goto() {
        return (!this.f330em) & (this.f234cM ? false : true);
    }

    /* JADX INFO: renamed from: h */
    public synchronized void m47h() {
        int iM100for;
        int iM100for2;
        int i;
        synchronized (this) {
            if (this.f273dP != 0.0f) {
                this.f300e2 = (int) (10.0f * this.f319eY);
                if (this.f300e2 > 75) {
                    this.f300e2 = 75;
                }
                if (!this.f234cM) {
                    float f = this.f163ak == 1 ? 0.3f : 1.0f;
                    if (this.f346ff) {
                        this.f157aa = (float) (((double) this.f157aa) - (((((double) (2.0f * f)) * 3.141592653589793d) * ((double) this.f319eY)) / 64.0d));
                    }
                    if (this.f243cY) {
                        this.f157aa = (float) (((double) this.f157aa) + (((((double) (2.0f * f)) * 3.141592653589793d) * ((double) this.f319eY)) / 64.0d));
                    }
                    if (this.f306eC) {
                        float f2 = 2.0f * f * 5.0f * this.f319eY;
                        if (this.f342fb + f2 < 55.0f) {
                            this.f342fb = f2 + this.f342fb;
                        } else {
                            this.f342fb = 55.0f;
                        }
                    }
                    if (this.f255cq) {
                        float f3 = (-f) * 2.0f * 5.0f * this.f319eY;
                        if (this.f342fb + f3 > -45.0f) {
                            this.f342fb = f3 + this.f342fb;
                        } else {
                            this.f342fb = -45.0f;
                        }
                    }
                    int iCos = (int) (((double) this.f300e2) * Math.cos(this.f157aa));
                    int iSin = (int) (((double) this.f300e2) * Math.sin(this.f157aa));
                    if (this.f135a7) {
                        iM100for2 = (int) ((((double) iCos) * Math.cos(1.5707963267948966d)) - (((double) iSin) * Math.sin(1.5707963267948966d)));
                        iM100for = (int) ((((double) iCos) * Math.sin(1.5707963267948966d)) + (((double) iSin) * Math.cos(1.5707963267948966d)));
                    } else {
                        iM100for = 0;
                        iM100for2 = 0;
                    }
                    if (this.f329ek) {
                        iM100for2 = (int) ((((double) iCos) * Math.cos(-1.5707963267948966d)) - (((double) iSin) * Math.sin(-1.5707963267948966d)));
                        iM100for = (int) ((((double) iCos) * Math.sin(-1.5707963267948966d)) + (((double) iSin) * Math.cos(-1.5707963267948966d)));
                    }
                    if (this.f256cr) {
                        i = this.f300e2;
                        iM100for2 = -((int) (((double) m100for(0, i)) * Math.cos(this.f157aa)));
                        iM100for = -((int) (((double) m100for(0, i)) * Math.sin(this.f157aa)));
                    } else {
                        i = 0;
                    }
                    if (this.f214bw) {
                        i = -this.f300e2;
                        iM100for2 = (int) (((double) m100for(0, i)) * Math.cos(this.f157aa));
                        iM100for = (int) (((double) m100for(0, i)) * Math.sin(this.f157aa));
                    }
                    if (this.f141aD) {
                        this.f145aI = true;
                    }
                    if (this.f145aI & this.f191bP) {
                        this.f239cS = 5.5f;
                        this.f345fe = (int) (((double) m100for(0, this.f300e2 * 2)) * Math.cos(this.f157aa));
                        this.f343fc = (int) (((double) m100for(i, this.f300e2 * 2)) * Math.sin(this.f157aa));
                    }
                    if (!this.f145aI) {
                        this.f345fe = 0.0f;
                        this.f343fc = 0.0f;
                    }
                    if ((!this.f201bd) & this.f184bE) {
                        if (this.f163ak == 0) {
                            this.f201bd = true;
                            this.f270dI = true;
                            this.f333eq = false;
                            this.f281dd = false;
                            m107for(2004, 2800, 2310);
                            this.f140aC = m10a(this.f140aC, new byte[]{3, 0, 0, 0});
                        } else {
                            m107for(2000, 7100, 6400);
                            this.f201bd = true;
                            this.f163ak = (byte) 0;
                        }
                    }
                    if ((!this.f201bd) & this.f190bN) {
                        if (this.f163ak == 0) {
                            this.f201bd = true;
                            this.f270dI = false;
                            this.f333eq = true;
                            this.f281dd = false;
                            m107for(2004, 2000, f31at);
                            this.f140aC = m10a(this.f140aC, new byte[]{2, 0, 0, 0});
                        } else {
                            m107for(2000, 7100, 6400);
                            this.f201bd = true;
                            this.f163ak = (byte) 0;
                        }
                    }
                    if ((this.f201bd ? false : true) && this.f280dc) {
                        this.f270dI = false;
                        this.f333eq = false;
                        this.f281dd = true;
                        if (this.f163ak == 1) {
                            if ((this.f233cL >> 2) <= 100) {
                                if (this.f233cL == 0) {
                                    m107for(2000, 5500, 3200);
                                }
                                this.f233cL += 24;
                            }
                        } else if (this.f192bS > 0) {
                            this.f187bJ = true;
                            this.f201bd = true;
                            m107for(2004, 6800, 5600);
                            this.f163ak = (byte) 1;
                        }
                    } else {
                        if (this.f163ak == 1 && !this.f201bd) {
                            m107for(2000, 1600, 1601);
                        }
                        if (!this.f280dc && this.f233cL >= 400) {
                            this.f201bd = true;
                            m64a(100, 200);
                            m107for(2000, 5900, 5601);
                        }
                        this.f233cL = 0;
                    }
                    int i2 = ((int) this.f345fe) + iM100for2;
                    int i3 = iM100for + ((int) this.f343fc);
                    m40do(i2 < 0 ? Math.max(-19, i2) : Math.min(19, i2), i3 < 0 ? Math.max(-19, i3) : Math.min(19, i3));
                }
            }
        }
    }

    @Override // p001a.p002a.p003a.p004a.RunnableC0001a
    public void hideNotify() {
        super.hideNotify();
        this.f247cd = false;
        m48i();
    }

    /* JADX INFO: renamed from: i */
    public void m48i() {
        this.f256cr = false;
        this.f214bw = false;
        this.f329ek = false;
        this.f135a7 = false;
        this.f346ff = false;
        this.f243cY = false;
        this.f306eC = false;
        this.f255cq = false;
        this.f141aD = false;
        this.f184bE = false;
        this.f190bN = false;
        this.f214bw = false;
        this.f256cr = false;
        this.f243cY = false;
        this.f346ff = false;
        this.f190bN = false;
    }

    /* JADX INFO: renamed from: if */
    public int m49if(int i, int i2) {
        for (int i3 = 0; i3 < this.f299e1.length; i3++) {
            if (this.f299e1[i3] == i && this.f298e0[i3] == i2) {
                return i3 + 600;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: if */
    public void m50if(int i, int i2, int i3, int i4, int i5, int i6, int i7, boolean z, byte b, World world) {
        try {
            Mesh meshDuplicate = world.find(i7).duplicate();
            meshDuplicate.setPickingEnable(false);
            if (i6 != 0) {
                meshDuplicate.preRotate(i6, 0.0f, 0.0f, 1.0f);
            }
            meshDuplicate.translate(i4, i5, 100.0f);
            if (world.equals(this.f173az) && i7 == 16) {
                meshDuplicate.setUserID(this.f269dH + 600);
                byte b2 = (byte) i;
                byte b3 = (byte) i2;
                if (this.f269dH == 0) {
                    this.f299e1 = new byte[]{b2};
                    this.f298e0 = new byte[]{b3};
                } else {
                    this.f299e1 = m3a(this.f299e1, b2);
                    this.f298e0 = m3a(this.f298e0, b3);
                }
                this.f269dH = (byte) (this.f269dH + 1);
                meshDuplicate.translate(this.f176b3 * i, this.f251ck * i2, this.f246cc * i3);
            } else {
                meshDuplicate.translate(this.f176b3 * i, this.f251ck * i2, this.f246cc * i3);
            }
            if (world.equals(this.f173az) && i7 == f71d1) {
                meshDuplicate.translate(0.0f, 0.0f, (-this.f246cc) * 2);
            }
            if (world.equals(this.f263dA)) {
            }
            this.f257ct.addChild(meshDuplicate);
        } catch (Exception e) {
            System.out.println(new StringBuffer().append("exception plane=").append(e).append(" tileType=").append((int) b).toString());
        }
    }

    /* JADX INFO: renamed from: if */
    public synchronized void m51if(int i, Gauge gauge) {
        int i2;
        synchronized (this) {
            try {
                if (this.f199bb || this.f144aH) {
                    this.f234cM = true;
                } else {
                    this.f234cM = false;
                }
                this.f213bv = i;
                DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(this.f238cR));
                boolean z = true;
                int i3 = 0;
                for (int i4 = 0; i4 < this.f148aM.length && z; i4++) {
                    if (this.f148aM[i4] == i) {
                        z = false;
                    } else {
                        i3++;
                    }
                }
                if (i3 != 0) {
                    i2 = 0;
                    for (int i5 = 0; i5 < i3; i5++) {
                        i2 += this.f250cj[i5];
                    }
                } else {
                    i2 = 0;
                }
                dataInputStream.skipBytes(i2);
                this.f295dx = dataInputStream.readByte();
                this.f198bZ = dataInputStream.readByte();
                this.f182bC = dataInputStream.readByte();
                this.f227cC = dataInputStream.readByte();
                this.f336eu = dataInputStream.readByte();
                int i6 = dataInputStream.readInt();
                this.f288dn = dataInputStream.readInt();
                if (this.f153aU != null) {
                    for (int i7 = 0; i7 < this.f153aU.length; i7++) {
                        if (this.f153aU[i7] != null) {
                            this.f153aU[i7] = null;
                        }
                    }
                }
                if (this.f303e8 != null) {
                    for (int i8 = 0; i8 < this.f303e8.length; i8++) {
                        if (this.f303e8[i8] != null) {
                            this.f303e8[i8] = null;
                        }
                    }
                }
                this.f153aU = new byte[this.f295dx * this.f198bZ * this.f182bC][];
                this.f303e8 = new byte[this.f295dx * this.f198bZ * this.f182bC][];
                for (int i9 = 0; i9 < i6; i9++) {
                    int i10 = dataInputStream.readInt();
                    int i11 = dataInputStream.readByte();
                    this.f153aU[i10] = new byte[i11];
                    for (int i12 = 0; i12 < i11; i12++) {
                        this.f153aU[i10][i12] = dataInputStream.readByte();
                    }
                }
                for (int i13 = 0; i13 < this.f288dn; i13++) {
                    int i14 = dataInputStream.readInt();
                    int i15 = dataInputStream.readByte();
                    this.f303e8[i14] = new byte[i15];
                    for (int i16 = 0; i16 < i15; i16++) {
                        this.f303e8[i14][i16] = dataInputStream.readByte();
                    }
                }
                this.f136a8 = dataInputStream.readUTF();
                int i17 = dataInputStream.readInt();
                if (i17 != -1) {
                    this.f264dB = new int[i17];
                    this.f254cp = new int[i17][];
                    this.f253co = new int[i17][];
                    this.f311eH = new boolean[i17];
                    this.f278dY = new boolean[i17];
                    this.f151aQ = new byte[i17];
                    this.f131a3 = new byte[i17];
                    this.f220c4 = new byte[i17];
                    this.f130a2 = new byte[i17];
                    this.f218c2 = new byte[i17];
                    this.f331en = new boolean[i17];
                    this.f267dE = new boolean[i17];
                    this.f215bx = new int[i17];
                    this.f123P = new int[i17];
                    this.f292dt = new int[i17];
                    this.f341ez = new float[i17];
                    this.f221c5 = new boolean[i17];
                    this.f282de = new boolean[i17];
                    this.f139aB = new int[i17];
                    this.f232cK = new int[i17];
                    this.f175b1 = new int[i17];
                    this.f332eo = new int[i17];
                    this.f206bk = new float[i17];
                    this.f258cx = new float[i17];
                    this.f119I = new float[i17];
                    this.f354ft = new float[i17];
                    this.f159af = new byte[i17];
                    this.f200bc = new float[i17];
                    this.f138aA = new int[i17];
                    this.f240cT = new byte[i17];
                    this.f132a4 = new int[i17];
                    this.f279dZ = new int[i17 * 2];
                    for (int i18 = 0; i18 < i17; i18++) {
                        m30a(dataInputStream, i18);
                    }
                } else {
                    this.f151aQ = null;
                    this.f264dB = null;
                    this.f254cp = null;
                    this.f253co = null;
                    this.f311eH = null;
                    this.f278dY = null;
                    this.f151aQ = null;
                    this.f131a3 = null;
                    this.f220c4 = null;
                    this.f130a2 = null;
                    this.f218c2 = null;
                    this.f331en = null;
                    this.f267dE = null;
                    this.f215bx = null;
                    this.f123P = null;
                    this.f292dt = null;
                    this.f341ez = null;
                    this.f221c5 = null;
                    this.f282de = null;
                    this.f139aB = null;
                    this.f232cK = null;
                    this.f175b1 = null;
                    this.f332eo = null;
                    this.f206bk = null;
                    this.f258cx = null;
                    this.f119I = null;
                    this.f354ft = null;
                    this.f159af = null;
                    this.f200bc = null;
                    this.f138aA = null;
                    this.f240cT = null;
                    this.f132a4 = null;
                    this.f279dZ = null;
                }
                this.f201bd = false;
                if (this.f163ak == 1) {
                    this.f164al = true;
                    this.f233cL = 0;
                } else {
                    this.f164al = false;
                }
            } catch (Exception e) {
                System.out.println(new StringBuffer().append("room loading failed on room").append(i).append(" with error ").append(e).toString());
            }
            this.f269dH = (byte) 0;
            this.f327eh = System.currentTimeMillis();
            while (!this.f197bY) {
                m34a(true, gauge);
            }
            this.f191bP = true;
        }
    }

    @Override // p001a.p002a.p003a.p004a.RunnableC0001a
    /* JADX INFO: renamed from: if */
    public void mo52if(Gauge gauge) {
        m51if(this.f223c8, gauge);
        gauge.setValue(100);
    }

    /* JADX INFO: renamed from: if */
    public void m53if(Graphics graphics, String str, Image[] imageArr, int i, int i2, int i3) {
        int iM60a;
        int iM60a2;
        int iM60a3;
        int iM60a4;
        if ((i3 & 32) > 0) {
            i2 -= m76if(str) - RunnableC0001a.f357A.f440aj;
        }
        while (i2 < graphics.getClipY() && RunnableC0001a.f357A.f440aj + i2 < graphics.getClipY()) {
            str = str.indexOf(65534) != -1 ? str.substring(str.indexOf(65534) + 1) : "";
            i2 += RunnableC0001a.f357A.f440aj + RunnableC0001a.f357A.f431Z;
        }
        if ((i3 & 8) > 0) {
            iM60a = i - (str.indexOf(65534) == -1 ? m60a(str) : m60a(str.substring(0, str.indexOf(65534))));
        } else {
            iM60a = i;
        }
        if ((i3 & 1) > 0) {
            iM60a2 = iM60a - (str.indexOf(65534) == -1 ? m60a(str) / 2 : m60a(str.substring(0, str.indexOf(65534))) / 2);
        } else {
            iM60a2 = iM60a;
        }
        int i4 = 0;
        int i5 = iM60a2;
        while (i4 < str.length()) {
            char cCharAt = str.charAt(i4);
            int i6 = i4;
            int i7 = i5;
            while (cCharAt == 65535) {
                i7 += RunnableC0001a.f357A.f442am;
                i6++;
                if (i6 >= str.length()) {
                    return;
                } else {
                    cCharAt = str.charAt(i6);
                }
            }
            char cCharAt2 = cCharAt;
            int i8 = i6;
            while (cCharAt2 == 65534) {
                if ((i3 & 8) > 0) {
                    iM60a3 = i - (str.substring(i8 + 1).indexOf(65534) == -1 ? m60a(str.substring(i8 + 1)) : m60a(str.substring(i8 + 1, (i8 + 1) + str.substring(i8 + 1).indexOf(65534))));
                } else {
                    iM60a3 = i;
                }
                if ((i3 & 1) > 0) {
                    iM60a4 = iM60a3 - (str.substring(i8 + 1).indexOf(65534) == -1 ? m60a(str.substring(i8 + 1)) / 2 : m60a(str.substring(i8 + 1, (i8 + 1) + str.substring(i8 + 1).indexOf(65534))) / 2);
                } else {
                    iM60a4 = iM60a3;
                }
                i2 += RunnableC0001a.f357A.f440aj + RunnableC0001a.f357A.f431Z;
                if (i2 > graphics.getClipY() + graphics.getClipHeight()) {
                    str.length();
                    return;
                }
                int i9 = i8 + 1;
                if (i9 >= str.length()) {
                    return;
                }
                cCharAt2 = str.charAt(i9);
                i8 = i9;
                i7 = iM60a4;
            }
            if ((i7 > graphics.getClipX() && i7 < graphics.getClipX() + graphics.getClipWidth()) || (imageArr[cCharAt2].getWidth() + i7 > graphics.getClipX() && imageArr[cCharAt2].getWidth() + i7 < graphics.getClipX() + graphics.getClipWidth())) {
                graphics.drawImage(imageArr[cCharAt2], i7, i2, (i3 & 50) | 4);
            }
            int width = i7 + imageArr[cCharAt2].getWidth() + RunnableC0001a.f357A.f444ao;
            i4 = i8 + 1;
            i5 = width;
        }
    }

    /* JADX INFO: renamed from: int, reason: not valid java name */
    public void m111int(int i) {
        int i2;
        int i3 = this.f337ev ? 3 : 1;
        this.f282de[i] = true;
        switch (this.f240cT[i]) {
            case 0:
                if (this.f337ev) {
                    if (this.f270dI) {
                        int[] iArr = this.f332eo;
                        iArr[i] = iArr[i] - 40;
                    } else if (this.f333eq) {
                        int[] iArr2 = this.f332eo;
                        iArr2[i] = iArr2[i] - 40;
                    }
                    if (!this.f281dd) {
                        this.f257ct.find(i + f49bq).getAppearance(0).setTexture(0, this.f205bj);
                        this.f287dm = 0;
                        this.f170av = true;
                    }
                }
                break;
            case 1:
                this.f285di = m12a(this.f285di, new int[]{i + 1200, 0, 0, 1100, 0, 0, 0});
                if (this.f270dI) {
                    int[] iArr3 = this.f332eo;
                    iArr3[i] = iArr3[i] - (i3 * 50);
                } else if (this.f333eq) {
                    int[] iArr4 = this.f332eo;
                    iArr4[i] = iArr4[i] - (i3 * 40);
                } else if (this.f281dd) {
                    int[] iArr5 = this.f332eo;
                    iArr5[i] = iArr5[i] - 2000;
                }
                break;
            case 3:
                this.f285di = m12a(this.f285di, new int[]{i + 1200, 0, 0, 1100, 0, 0, 0});
                if (this.f270dI) {
                    int[] iArr6 = this.f332eo;
                    iArr6[i] = iArr6[i] - (i3 * 60);
                } else if (this.f333eq) {
                    int[] iArr7 = this.f332eo;
                    iArr7[i] = iArr7[i] - (i3 * 120);
                } else if (this.f281dd) {
                    int[] iArr8 = this.f332eo;
                    iArr8[i] = iArr8[i] - 2000;
                }
                break;
        }
        if (this.f332eo[i] < 0) {
            this.f278dY[i] = true;
            this.f267dE[i] = true;
            int i4 = 40;
            int i5 = 4900;
            if (this.f240cT[i] == 0) {
                i5 = 10000;
                i2 = 8500;
                i4 = 80;
            } else if (this.f240cT[i] == 1) {
                i4 = 50;
                i5 = 4500;
                i2 = 3200;
            } else if (this.f240cT[i] == 2) {
                i5 = 4900;
                i2 = 3200;
            } else {
                i2 = 3200;
            }
            m107for(i + f49bq, i5, i2);
            int i6 = 0;
            for (int i7 = 0; i7 < this.f305eA.length; i7++) {
                if ((this.f260d0[i7] == this.f213bv) & (this.f160ag[i7] == i)) {
                    i6 = i7;
                }
            }
            this.f334er += i4;
            this.f207bl = true;
            this.f305eA[i6] = true;
            m64a(100, 200);
        }
    }

    /* JADX INFO: renamed from: int, reason: not valid java name */
    public void m112int(int i, int i2) {
        short[] sArr = {100, 100, 0, 0, 100, 0, 100, 0, 0, 0, 0, 0};
        VertexArray vertexArray = new VertexArray(sArr.length / 3, 3, 2);
        vertexArray.set(0, sArr.length / 3, sArr);
        byte[] bArr = {0, 0, 127, 0, 0, 127, 0, 0, 127, 0, 0, 127};
        VertexArray vertexArray2 = new VertexArray(bArr.length / 3, 3, 1);
        vertexArray2.set(0, bArr.length / 3, bArr);
        short[] sArr2 = {1, 0, 0, 0, 1, 1, 0, 1};
        VertexArray vertexArray3 = new VertexArray(sArr2.length / 2, 2, 2);
        vertexArray3.set(0, sArr2.length / 2, sArr2);
        VertexBuffer vertexBuffer = new VertexBuffer();
        vertexBuffer.setPositions(vertexArray, 1.0f, (float[]) null);
        vertexBuffer.setNormals(vertexArray2);
        vertexBuffer.setTexCoords(0, vertexArray3, this.f295dx * 1.0f, (float[]) null);
        TriangleStripArray triangleStripArray = new TriangleStripArray(0, new int[]{4});
        Texture2D texture2D = new Texture2D(new Image2D(99, this.f309eF));
        texture2D.setFiltering(210, 210);
        texture2D.setWrapping(241, 241);
        texture2D.setBlending(227);
        PolygonMode polygonMode = new PolygonMode();
        polygonMode.setCulling(160);
        polygonMode.setPerspectiveCorrectionEnable(true);
        Appearance appearance = new Appearance();
        appearance.setPolygonMode(polygonMode);
        appearance.setTexture(0, texture2D);
        Material material = new Material();
        material.setColor(1024, -1);
        material.setColor(8192, -1);
        material.setShininess(128.0f);
        appearance.setMaterial(material);
        Mesh mesh = new Mesh(vertexBuffer, triangleStripArray, appearance);
        mesh.scale(this.f295dx, this.f198bZ, 1.0f);
        mesh.setTranslation(0.0f, 0.0f, 0.0f);
        this.f257ct.addChild(mesh);
    }

    /* JADX INFO: renamed from: int, reason: not valid java name */
    public synchronized void m113int(Graphics graphics) {
        synchronized (this) {
            if (graphics == null) {
                try {
                    if (this.f230cF) {
                        this.f230cF = false;
                    } else if (this.f226cB) {
                        this.f226cB = false;
                    } else if (this.f125W) {
                        this.f124V = (int) (this.f124V + this.f273dP);
                        this.f319eY = this.f273dP / 66.0f;
                        if (!this.f330em) {
                            if ((!this.f229cE) & (this.f349fk < 0)) {
                                if (!this.f234cM) {
                                    this.f228cD.setRenderingEnable(false);
                                    this.f244cZ.setRenderingEnable(false);
                                    this.f134a6.setRenderingEnable(false);
                                    this.f129a0.setRenderingEnable(false);
                                    this.f342fb = 0.0f;
                                    this.f283dg = m61a(this.f383if[1], this.f268dF);
                                    this.f297dz = true;
                                    this.f285di = m12a(this.f285di, new int[]{2700, 0, 0, 12000, 8000, 0, 0});
                                    m64a(10, f31at);
                                }
                                this.f234cM = true;
                            }
                            m47h();
                            m45f();
                            m46g();
                            m116void();
                            if (this.f286dj) {
                                this.f252cl = (int) (this.f252cl + (this.f319eY * 20.0f));
                                this.f166ao.postTranslate(0.0f, 0.0f, -this.f252cl);
                                this.f212bu.setTransform(this.f166ao);
                            }
                            if ((!this.f375C) & this.f297dz & (!this.f330em)) {
                                this.f275dS = (int) (this.f275dS + this.f273dP);
                                if (this.f275dS > 2500) {
                                    this.f297dz = false;
                                }
                            }
                            if (this.f170av & (this.f330em ? false : true)) {
                                this.f287dm = (int) (this.f287dm + this.f273dP);
                                if (this.f287dm > 250) {
                                    this.f170av = false;
                                    for (int i = 0; i < this.f151aQ.length; i++) {
                                        if (this.f240cT[i] == 0) {
                                            this.f257ct.find(i + f49bq).getAppearance(0).setTexture(0, this.f142aE);
                                        }
                                    }
                                }
                            }
                            if (this.f199bb) {
                                switch (this.f127Y) {
                                    case 0:
                                        float f = (this.f157aa / 6.2831855f) * 360.0f;
                                        new Transform();
                                        Transform transform = new Transform();
                                        float[] fArr = new float[4];
                                        float[] fArr2 = new float[4];
                                        float[] fArr3 = new float[4];
                                        float[] fArr4 = new float[4];
                                        float[] fArrM7a = m7a(m4a(f + 90.0f, 0, 0, 1), m4a(-this.f342fb, 1, 0, 0));
                                        transform.postRotateQuat(fArrM7a[0], fArrM7a[1], fArrM7a[2], fArrM7a[3]);
                                        transform.postTranslate(0.0f, 0.0f, 35.0f);
                                        this.f244cZ.setTransform(transform);
                                        this.f244cZ.setTranslation(this.f353fs, this.f352fr, ((this.f246cc * this.f351fq) / 20.0f) + 150.0f);
                                        int iM100for = (int) (((double) m100for(0, (int) (5.0f * this.f319eY))) * Math.cos(this.f157aa));
                                        if (this.f353fs + iM100for < f46bi) {
                                            m40do(iM100for, 0);
                                        } else {
                                            this.f353fs = f46bi;
                                            this.f127Y = (byte) 1;
                                        }
                                        break;
                                    case 1:
                                        this.f257ct.find(2203).setTranslation(this.f353fs, this.f352fr, (150.0f + this.f351fq) - 121.0f);
                                        this.f285di = m12a(this.f285di, new int[]{2201, 0, 0, f101eM, 0, 0, 0});
                                        this.f127Y = (byte) 2;
                                        break;
                                    case 2:
                                        m107for(2202, 7100, f31at);
                                        break;
                                    case 4:
                                        this.f285di = m12a(this.f285di, new int[]{2206, 0, 0, 3200, 0, 0, 0});
                                        this.f127Y = (byte) 5;
                                        break;
                                    case 6:
                                        Group groupFind = this.f257ct.find(2205);
                                        this.f257ct.find(2203).setTranslation(100000.0f, 0.0f, 0.0f);
                                        groupFind.setTranslation(this.f353fs, this.f352fr, (150.0f + this.f351fq) - 121.0f);
                                        this.f257ct.removeChild(this.f257ct.find(2207));
                                        this.f257ct.removeChild(this.f257ct.find(2208));
                                        this.f127Y = (byte) 7;
                                        break;
                                    case 8:
                                        this.f257ct.find(2205).setTranslation(100000.0f, 0.0f, 0.0f);
                                        this.f257ct.removeChild(this.f244cZ);
                                        this.f244cZ = this.f150aO.find(63).duplicate();
                                        this.f244cZ.setTranslation(0.0f, 0.0f, 100000.0f);
                                        this.f157aa -= 3.1415927f;
                                        this.f244cZ.setPickingEnable(false);
                                        this.f244cZ.setUserID(2004);
                                        this.f257ct.addChild(this.f244cZ);
                                        this.f127Y = (byte) 9;
                                        this.f257ct.setActiveCamera(this.f276dT);
                                        break;
                                    case 9:
                                        SkinnedMesh skinnedMeshFind = this.f257ct.find(2004);
                                        float f2 = (this.f157aa / 6.2831855f) * 360.0f;
                                        Transform transform2 = new Transform();
                                        float[] fArr5 = new float[4];
                                        float[] fArr6 = new float[4];
                                        float[] fArr7 = new float[4];
                                        float[] fArr8 = new float[4];
                                        float[] fArrM7a2 = m7a(m4a(f2 + 90.0f, 0, 0, 1), m4a(-this.f342fb, 1, 0, 0));
                                        transform2.postRotateQuat(fArrM7a2[0], fArrM7a2[1], fArrM7a2[2], fArrM7a2[3]);
                                        skinnedMeshFind.setTransform(transform2);
                                        skinnedMeshFind.setTranslation(this.f353fs, this.f352fr, ((this.f246cc * this.f351fq) / 20.0f) + 150.0f);
                                        int iM100for2 = (int) (((double) m100for(0, (int) (5.0f * this.f319eY))) * Math.cos(this.f157aa));
                                        if (this.f353fs + iM100for2 > f118fp) {
                                            m40do(iM100for2, 0);
                                        } else {
                                            this.f353fs = f118fp;
                                        }
                                        break;
                                }
                            }
                        } else {
                            switch (this.f313eN) {
                                case 0:
                                    if (this.f128Z == 6) {
                                        this.f189bM = 8000;
                                    } else {
                                        this.f189bM = 6400;
                                    }
                                    if (this.f213bv == 36) {
                                        m67a(this.f318eU[3]);
                                    }
                                    this.f126X = 0;
                                    this.f310eG = 56;
                                    this.f222c7 = false;
                                    this.f335et.animate(this.f126X);
                                    this.f137a9 = m61a(new StringBuffer().append(this.f383if[this.f128Z]).append(RunnableC0001a.f357A.f420M).append(RunnableC0001a.f357A.f420M).append(this.f383if[5]).toString(), this.f268dF - 57);
                                    this.f217bz = (-m76if(this.f137a9)) + ((this.f315eR - 56) - 49) + 56;
                                    this.f313eN = (byte) 1;
                                    break;
                                case 1:
                                    this.f222c7 = false;
                                    if (this.f126X + this.f273dP < 1600.0f) {
                                        this.f126X = (int) (this.f126X + this.f273dP);
                                    } else {
                                        this.f126X = 1600;
                                        this.f313eN = (byte) 2;
                                    }
                                    this.f335et.animate(this.f126X);
                                    float f3 = this.f126X / 1600;
                                    int i2 = (this.f315eR - 56) - 49;
                                    this.f317eT = ((i2 / 2) + 56) - ((int) ((i2 * f3) / 2.0f));
                                    this.f293du = (int) (f3 * i2);
                                    break;
                                case 2:
                                    this.f222c7 = true;
                                    if (this.f214bw && this.f310eG < 56) {
                                        this.f310eG = (int) (this.f310eG + (10.0f * this.f319eY));
                                        this.f126X = (int) (this.f126X - this.f273dP);
                                        if (this.f126X <= 1750) {
                                            this.f126X = 3025;
                                        }
                                    } else if (this.f256cr && this.f310eG >= this.f217bz) {
                                        this.f310eG = (int) (this.f310eG - (10.0f * this.f319eY));
                                        this.f126X = (int) (this.f126X + this.f273dP);
                                        if (this.f126X >= 3025) {
                                            this.f126X = 1750;
                                        }
                                    } else if (this.f280dc || this.f184bE || this.f190bN) {
                                        this.f313eN = (byte) 3;
                                        this.f126X = 4950;
                                    }
                                    this.f335et.animate(this.f126X);
                                    break;
                                case 3:
                                    this.f222c7 = false;
                                    if (this.f126X + this.f273dP < this.f189bM) {
                                        this.f126X = (int) (this.f126X + this.f273dP);
                                    } else {
                                        this.f126X = 8000;
                                        this.f313eN = (byte) 4;
                                        this.f222c7 = false;
                                    }
                                    this.f335et.animate(this.f126X);
                                    float f4 = 1.0f - ((this.f126X - 4950) / (this.f189bM - 4950));
                                    int i3 = (this.f315eR - 56) - 49;
                                    this.f317eT = ((i3 / 2) + 56) - ((int) ((i3 * f4) / 2.0f));
                                    this.f293du = (int) (f4 * i3);
                                    break;
                                case 4:
                                    if (this.f213bv == 36) {
                                        this.f379do = this.f334er;
                                        this.f392y.commandAction(this.f386m, this);
                                    } else {
                                        this.f330em = false;
                                    }
                                    if (this.f128Z == 6) {
                                    }
                                    this.f313eN = (byte) 0;
                                    break;
                            }
                        }
                        if (this.f162aj != -1) {
                            switch (this.f162aj) {
                                case 0:
                                    this.f192bS = (byte) 49;
                                    break;
                                case 1:
                                    this.f229cE = true;
                                    break;
                                case 2:
                                    this.f334er = 9999;
                                    break;
                                case 3:
                                    this.f274dQ = true;
                                    break;
                                case 4:
                                    this.f314eQ = true;
                                    break;
                                case 5:
                                    this.f149aN = true;
                                    break;
                                case 6:
                                    this.f349fk = -1;
                                    break;
                                case 7:
                                    this.f274dQ = true;
                                    this.f314eQ = true;
                                    this.f149aN = true;
                                    break;
                                case 8:
                                    this.f192bS = (byte) 49;
                                    this.f334er = 9999;
                                    this.f274dQ = true;
                                    this.f314eQ = true;
                                    this.f149aN = true;
                                    break;
                                case 9:
                                    this.f337ev = true;
                                    break;
                                case 10:
                                    this.f349fk = f31at;
                                    break;
                                case 11:
                                    this.f229cE = true;
                                    this.f192bS = (byte) 49;
                                    this.f334er = 9999;
                                    this.f274dQ = true;
                                    this.f314eQ = true;
                                    this.f149aN = true;
                                    this.f337ev = true;
                                    this.f349fk = f31at;
                                    break;
                            }
                            this.f344fd = true;
                            this.f226cB = true;
                            this.f162aj = -1;
                        }
                    }
                } catch (Exception e) {
                }
            } else {
                try {
                    if (this.f125W) {
                        if (this.f330em) {
                            this.f262d7.bindTarget(graphics);
                            this.f338ew.setColor(16711680);
                            this.f262d7.clear(this.f338ew);
                            this.f262d7.setViewport(0, 0, this.f268dF, this.f315eR);
                            this.f262d7.render(this.f335et);
                            this.f262d7.releaseTarget();
                            if (this.f222c7) {
                                if (this.f313eN == 1 || this.f313eN == 3) {
                                    graphics.setClip(35, this.f317eT, (this.f268dF - 35) - 22, this.f293du);
                                } else {
                                    graphics.setClip(35, 56, (this.f268dF - 35) - 22, (this.f315eR - 56) - 49);
                                }
                                m68a(graphics, this.f137a9, RunnableC0001a.f357A.f411C, 35, this.f310eG, 20);
                            }
                        } else {
                            float f5 = 360.0f * (this.f157aa / 6.2831855f);
                            this.f262d7.bindTarget(graphics);
                            this.f338ew.setColor(16711680);
                            this.f262d7.clear(this.f338ew);
                            if (this.f271dJ) {
                                float[] fArr9 = {0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f};
                                Camera activeCamera = this.f257ct.getActiveCamera();
                                activeCamera.getProjection(fArr9);
                                for (int i4 = 0; i4 < fArr9.length; i4++) {
                                }
                                this.f271dJ = false;
                                fArr9[0] = 60.0f;
                                fArr9[2] = 0.1f;
                                fArr9[3] = 50000.0f;
                                activeCamera.setPerspective(fArr9[0], fArr9[1], fArr9[2], fArr9[3]);
                            }
                            if (this.f144aH) {
                                this.f262d7.setViewport(0, this.f350fm, this.f268dF, this.f167ap);
                                this.f257ct.find(1800).setTranslation(this.f353fs + this.f336eu, this.f352fr - (this.f176b3 / 2), 150.0f + ((this.f246cc * this.f351fq) / 20.0f));
                            } else if (this.f199bb) {
                                this.f262d7.setViewport(0, this.f350fm, this.f268dF, this.f167ap);
                                this.f257ct.find(2201).setTranslation(this.f353fs, this.f352fr, 150.0f + ((this.f246cc * this.f351fq) / 20.0f));
                                Transform transform3 = new Transform();
                                new Transform();
                                float[] fArr10 = new float[4];
                                float[] fArr11 = new float[4];
                                float[] fArr12 = new float[4];
                                float[] fArr13 = new float[4];
                                float[] fArrM7a3 = m7a(m4a(f5 + 90.0f, 0, 1, 0), m4a(this.f342fb, 1, 0, 0));
                                transform3.postRotateQuat(fArrM7a3[0], fArrM7a3[1], fArrM7a3[2], fArrM7a3[3]);
                                this.f276dT.setTransform(transform3);
                                this.f276dT.setTranslation(this.f353fs, this.f352fr, 150.0f + ((this.f246cc * this.f351fq) / 20.0f));
                            } else {
                                this.f262d7.setViewport(0, this.f350fm, this.f268dF, this.f167ap);
                                Transform transform4 = new Transform();
                                Transform transform5 = new Transform();
                                float[] fArr14 = new float[4];
                                float[] fArr15 = new float[4];
                                float[] fArr16 = new float[4];
                                float[] fArr17 = new float[4];
                                float[] fArrM7a4 = m7a(m4a(90.0f + f5, 0, 1, 0), m4a(this.f342fb, 1, 0, 0));
                                transform4.postRotateQuat(fArrM7a4[0], fArrM7a4[1], fArrM7a4[2], fArrM7a4[3]);
                                this.f276dT.setTransform(transform4);
                                this.f276dT.setTranslation(this.f353fs, this.f352fr, 150.0f + ((this.f246cc * this.f351fq) / 20.0f));
                                float[] fArrM7a5 = m7a(m4a(90.0f + f5, 0, 0, 1), m4a(-this.f342fb, 1, 0, 0));
                                transform5.postRotateQuat(fArrM7a5[0], fArrM7a5[1], fArrM7a5[2], fArrM7a5[3]);
                                this.f244cZ.setTransform(transform5);
                                this.f244cZ.setTranslation(this.f353fs, this.f352fr, ((this.f246cc * this.f351fq) / 20.0f) + 150.0f);
                                Transform transform6 = new Transform();
                                transform6.postRotate(f5 + 90.0f, 0.0f, 0.0f, 1.0f);
                                this.f228cD.setTransform(transform6);
                                this.f228cD.setTranslation(this.f353fs, this.f352fr, ((this.f246cc * this.f351fq) / 20.0f) + 47.0f);
                                transform5.postTranslate(0.0f, 0.0f, -40.0f);
                                this.f134a6.setTransform(transform5);
                                this.f134a6.setTranslation(this.f353fs, this.f352fr, ((this.f246cc * this.f351fq) / 20.0f) + 150.0f);
                            }
                            if (this.f151aQ != null) {
                                for (int i5 = 0; i5 < this.f311eH.length; i5++) {
                                    if (!this.f267dE[i5]) {
                                        Group groupFind2 = this.f257ct.find(i5 + 1300);
                                        Transform transform7 = new Transform();
                                        float f6 = this.f119I[i5];
                                        float f7 = this.f354ft[i5];
                                        transform7.postRotate((((this.f206bk[i5] / 6.2831855f) * 360.0f) + 180.0f) - 90.0f, 0.0f, 0.0f, 1.0f);
                                        groupFind2.setTransform(transform7);
                                        groupFind2.setTranslation(f6, f7, this.f123P[i5] * this.f246cc);
                                    }
                                }
                            }
                            if (!this.f230cF && !this.f226cB) {
                                this.f262d7.render(this.f257ct);
                            }
                            if (this.f230cF) {
                                this.f207bl = true;
                                Background background = new Background();
                                background.setColor(f91dl);
                                this.f262d7.clear(background);
                            } else if (this.f226cB) {
                                this.f207bl = true;
                                Background background2 = new Background();
                                background2.setColor(this.f185bG);
                                this.f262d7.clear(background2);
                            }
                            this.f262d7.releaseTarget();
                            graphics.setColor(f67cu);
                            if (this.f164al) {
                                int i6 = (this.f268dF / 2) - 3;
                                int i7 = (this.f268dF / 2) + 3;
                                int i8 = this.f268dF / 2;
                                int i9 = (this.f315eR / 2) - 3;
                                int i10 = (this.f315eR / 2) + 3;
                                int i11 = this.f315eR / 2;
                                graphics.drawLine(i6, i11, i7, i11);
                                graphics.drawLine(i8, i9, i8, i10);
                            }
                            m109for(graphics);
                            if (!this.f280dc || this.f201bd || this.f163ak == 1) {
                            }
                        }
                        if ((!this.f375C) & this.f297dz & (!this.f330em)) {
                            m68a(graphics, this.f283dg, RunnableC0001a.f357A.f411C, this.f268dF / 2, this.f315eR / 2, 17);
                        }
                        if (this.f375C) {
                            m61a(m63a(RunnableC0001a.f357A.f488for[5], RunnableC0001a.f357A.f470y), this.f268dF);
                            m68a(graphics, this.f383if[0], RunnableC0001a.f357A.f411C, this.f268dF / 2, this.f315eR / 2, 17);
                        }
                    }
                } catch (Exception e2) {
                    System.out.println(new StringBuffer().append("common ").append(e2).toString());
                    this.f262d7.releaseTarget();
                }
            }
        }
    }

    /* JADX INFO: renamed from: j */
    public synchronized void m54j() {
        this.f323ec = this.f353fs;
        this.f322eb = this.f352fr;
        this.f321ea = 200.0f;
        this.f276dT.getTransform(this.f166ao);
        this.f212bu.setTransform(this.f166ao);
        this.f212bu.setTranslation(this.f353fs, this.f352fr, 150.0f + ((this.f246cc * this.f351fq) / 20.0f));
        this.f286dj = true;
        this.f252cl = 0;
        this.f316eS = 0.0f;
        float[] fArr = new float[6];
        RayIntersection rayIntersection = new RayIntersection();
        float f = (this.f157aa / 6.2831855f) * 360.0f;
        for (int i = 0; i < f14T.length; i++) {
            if (this.f257ct.pick(-1, f14T[i], f13S[i], this.f276dT, rayIntersection)) {
                rayIntersection.getRay(fArr);
                Mesh intersected = rayIntersection.getIntersected();
                if ((intersected instanceof Mesh) && this.f151aQ != null) {
                    for (int i2 = 0; i2 < this.f151aQ.length; i2++) {
                        if (!this.f267dE[i2] && intersected.getUserID() == i2 + 2100) {
                            m111int(i2);
                        }
                    }
                }
            }
        }
    }

    @Override // p001a.p002a.p003a.p004a.RunnableC0001a
    public void keyPressed(int i) {
        super.keyPressed(i);
        if (this.f377H == 2) {
            switch (i) {
                case f47bm /* -5 */:
                    this.f190bN = true;
                    break;
                case f93dv /* -4 */:
                    this.f346ff = true;
                    break;
                case f80dL /* -3 */:
                    this.f243cY = true;
                    break;
                case f44ba /* -2 */:
                    this.f256cr = true;
                    break;
                case f51c0 /* -1 */:
                    this.f214bw = true;
                    break;
                case f81dM /* 35 */:
                    this.f255cq = true;
                    break;
                case 42:
                    this.f306eC = true;
                    break;
                case 48:
                    this.f141aD = true;
                    break;
                case f78dG /* 49 */:
                    this.f280dc = true;
                    break;
                case f86dW /* 50 */:
                    this.f184bE = true;
                    break;
                case 51:
                    this.f190bN = true;
                    break;
                case 52:
                    this.f243cY = true;
                    break;
                case 53:
                    this.f214bw = true;
                    break;
                case 54:
                    this.f346ff = true;
                    break;
                case f71d1 /* 55 */:
                    this.f135a7 = true;
                    break;
                case f112fa /* 56 */:
                    this.f256cr = true;
                    break;
                case 57:
                    this.f329ek = true;
                    break;
            }
            if (this.f125W) {
                this.f162aj = m72do(i);
            }
        }
    }

    public void keyReleased(int i) {
        switch (i) {
            case f47bm /* -5 */:
                this.f190bN = false;
                break;
            case f93dv /* -4 */:
                this.f346ff = false;
                break;
            case f80dL /* -3 */:
                this.f243cY = false;
                break;
            case f44ba /* -2 */:
                this.f256cr = false;
                break;
            case f51c0 /* -1 */:
                this.f214bw = false;
                break;
            case f81dM /* 35 */:
                this.f255cq = false;
                break;
            case 42:
                this.f306eC = false;
                break;
            case 48:
                this.f141aD = false;
                break;
            case f78dG /* 49 */:
                this.f280dc = false;
                break;
            case f86dW /* 50 */:
                this.f184bE = false;
                break;
            case 51:
                this.f190bN = false;
                break;
            case 52:
                this.f243cY = false;
                break;
            case 53:
                this.f214bw = false;
                break;
            case 54:
                this.f346ff = false;
                break;
            case f71d1 /* 55 */:
                this.f135a7 = false;
                break;
            case f112fa /* 56 */:
                this.f256cr = false;
                break;
            case 57:
                this.f329ek = false;
                break;
        }
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code duplicated, block: B:13:0x0027  */
    /* JADX INFO: renamed from: new, reason: not valid java name */
    public void m114new(int i, int i2) {
        boolean z;
        for (int i3 = 0; i3 < this.f161ai.length; i3++) {
            if (this.f154aW[i3] == this.f213bv && this.f161ai[i3] == i && !this.f158ad[i3]) {
                switch (i2) {
                    case 15:
                        if (this.f349fk < f31at) {
                            this.f349fk += 400;
                            if (this.f349fk > f31at) {
                                this.f349fk = f31at;
                            }
                            this.f185bG = f67cu;
                            z = true;
                        } else {
                            z = false;
                        }
                        break;
                    case f55cH /* 16 */:
                        this.f334er += 10;
                        this.f185bG = f25ac;
                        z = true;
                        break;
                    case f89df /* 17 */:
                        this.f334er += 30;
                        this.f185bG = f18aK;
                        z = true;
                        break;
                    case 18:
                        this.f334er += 40;
                        this.f185bG = f67cu;
                        z = true;
                        break;
                    case f59cX /* 19 */:
                        this.f334er += 50;
                        this.f185bG = f35bA;
                        z = true;
                        break;
                    case 20:
                        this.f185bG = f72d2;
                        this.f334er += 20;
                        z = true;
                        break;
                    case 21:
                        this.f185bG = f18aK;
                        this.f283dg = m61a(this.f383if[4], this.f268dF);
                        this.f274dQ = true;
                        this.f297dz = true;
                        this.f275dS = 0;
                        this.f344fd = true;
                        z = true;
                        break;
                    case f116fn /* 22 */:
                        System.out.println("silver!");
                        this.f185bG = f106eX;
                        this.f283dg = m61a(this.f383if[3], this.f268dF);
                        this.f314eQ = true;
                        this.f297dz = true;
                        this.f275dS = 0;
                        this.f344fd = true;
                        z = true;
                        break;
                    case 23:
                        this.f185bG = f25ac;
                        this.f283dg = m61a(this.f383if[2], this.f268dF);
                        this.f297dz = true;
                        this.f149aN = true;
                        this.f275dS = 0;
                        this.f344fd = true;
                        z = true;
                        break;
                    case 24:
                        if (this.f192bS == 0) {
                            this.f129a0.setRenderingEnable(true);
                        }
                        this.f185bG = f67cu;
                        this.f192bS = (byte) (this.f192bS + 1);
                        this.f275dS = 0;
                        this.f344fd = true;
                        z = true;
                        break;
                    case 25:
                        this.f330em = true;
                        byte b = (byte) (i / (this.f295dx * this.f198bZ));
                        byte b2 = (byte) ((i - ((this.f295dx * b) * this.f198bZ)) / this.f295dx);
                        byte b3 = (byte) ((i - ((this.f295dx * b) * this.f198bZ)) - (this.f295dx * b2));
                        boolean z2 = true;
                        for (int i4 = 0; i4 < this.f195bW.length && z2; i4++) {
                            if (this.f195bW[i4] == m115try(this.f213bv)[0] && this.f193bU[i4] == m115try(this.f213bv)[1] && this.f179b7[i4] == b3 && this.f178b6[i4] == b2 && this.f177b5[i4] == b) {
                                this.f128Z = i4 + 7;
                                z2 = false;
                            }
                        }
                        if (this.f128Z > 15) {
                            this.f128Z = 15;
                        }
                        this.f313eN = (byte) 0;
                        this.f207bl = true;
                        this.f344fd = true;
                        z = true;
                        break;
                    default:
                        z = false;
                        break;
                }
                if (z) {
                    if (i2 != 25) {
                        m67a(this.f318eU[0]);
                        m64a(100, 200);
                    }
                    this.f158ad[i3] = true;
                    this.f226cB = true;
                    int i5 = 0;
                    boolean z3 = true;
                    while (true) {
                        if (!(i5 < this.f219c3.length) || !z3) {
                            break;
                        }
                        if (this.f219c3[i5] == i) {
                            this.f257ct.removeChild(this.f257ct.find(this.f183bD[i5]));
                            z3 = false;
                        }
                        i5++;
                    }
                }
            }
        }
    }

    @Override // p001a.p002a.p003a.p004a.RunnableC0001a
    public void paint(Graphics graphics) {
        if (this.f377H != 2) {
            super.paint(graphics);
        } else {
            mo32a(graphics);
        }
    }

    @Override // p001a.p002a.p003a.p004a.RunnableC0001a, java.lang.Runnable
    public void run() {
        if (this.f377H != 2) {
            super.run();
            return;
        }
        while (this.f247cd) {
            this.f196bX = new StringBuffer().append("").append(Runtime.getRuntime().freeMemory()).toString();
            try {
                long jCurrentTimeMillis = System.currentTimeMillis();
                m113int((Graphics) null);
                this.f186bH = System.currentTimeMillis() - jCurrentTimeMillis;
                this.f355h = true;
                repaint();
                while (this.f355h && this.f247cd) {
                    Thread thread = this.f356u;
                    Thread.yield();
                }
                this.f296dy = (System.currentTimeMillis() - jCurrentTimeMillis) + this.f186bH;
                if (this.f197bY) {
                    this.f273dP = 10.0f;
                    this.f197bY = false;
                } else {
                    this.f273dP = System.currentTimeMillis() - jCurrentTimeMillis;
                }
            } catch (Exception e) {
                System.out.println(new StringBuffer().append("exception=").append(e).toString());
            }
        }
    }

    @Override // p001a.p002a.p003a.p004a.RunnableC0001a
    public void showNotify() {
        if (this.f377H != 2) {
            super.showNotify();
            return;
        }
        if (this.f356u == null || !(this.f247cd || this.f375C || this.f356u.isAlive())) {
            this.f356u = new Thread(this);
            this.f247cd = true;
            this.f356u.start();
        } else if (this.f356u.isAlive()) {
            this.f247cd = true;
        }
    }

    /* JADX INFO: renamed from: try, reason: not valid java name */
    public int[] m115try(int i) {
        int i2 = i / this.f291ds;
        return new int[]{i - (this.f291ds * i2), i2};
    }

    /* JADX INFO: renamed from: void, reason: not valid java name */
    public void m116void() {
        if (this.f285di != null) {
            int i = 0;
            while (i < this.f285di.length) {
                if (this.f285di[i] != null) {
                    switch (this.f285di[i][1]) {
                        case 0:
                            this.f285di[i][1] = 1;
                            this.f285di[i][2] = this.f285di[i][4];
                            this.f257ct.find(this.f285di[i][0]).animate(this.f285di[i][2]);
                            break;
                        case 1:
                            int[] iArr = this.f285di[i];
                            iArr[2] = (int) (iArr[2] + this.f273dP);
                            if (this.f285di[i][2] >= this.f285di[i][3]) {
                                this.f285di[i][1] = 2;
                            }
                            Object3D object3DFind = this.f257ct.find(this.f285di[i][0]);
                            if (this.f285di[i][0] < 500 || this.f285di[i][0] >= 600) {
                                object3DFind.animate(this.f285di[i][2]);
                            } else if (this.f278dY[this.f285di[i][0] - 500]) {
                                object3DFind.animate(this.f285di[i][2]);
                            }
                            break;
                        case 2:
                            this.f285di[i][2] = this.f285di[i][3];
                            if (this.f285di[i][0] >= 500 && this.f285di[i][0] < 600) {
                                int i2 = 0;
                                for (int i3 = 0; i3 < this.f279dZ.length; i3++) {
                                    if (this.f279dZ[i3] == i) {
                                        i2 = i3;
                                    }
                                }
                                int i4 = 3200;
                                if (this.f240cT[i2] == 0) {
                                    i4 = 8500;
                                } else if (this.f240cT[i2] == 1) {
                                    i4 = 3200;
                                } else if (this.f240cT[i2] == 2 || this.f240cT[i2] == 4) {
                                }
                                this.f285di[i][1] = 1;
                                if ((this.f285di[i][4] != i4) && (this.f285di[i][6] == 1)) {
                                    this.f285di[i][2] = this.f285di[i][4];
                                } else {
                                    this.f285di[i][6] = 0;
                                }
                                break;
                            } else if (this.f285di[i][0] >= 600 && this.f285di[i][0] <= 700) {
                                this.f140aC[this.f285di[i][5]][3] = 1;
                                this.f285di = m11a(this.f285di, i);
                                break;
                            } else if (this.f285di[i][0] != 2004) {
                                if (this.f285di[i][0] >= 1200 && this.f285di[i][0] < 1300) {
                                    this.f285di = m11a(this.f285di, i);
                                    break;
                                } else if (this.f285di[i][0] != 1700) {
                                    if (this.f285di[i][0] != 2000) {
                                        if (this.f285di[i][0] != 2003) {
                                            if (this.f285di[i][0] != 2201) {
                                                if (this.f285di[i][0] != 2202) {
                                                    if (this.f285di[i][0] != 2206) {
                                                        if (this.f285di[i][0] == 2204) {
                                                            switch (this.f285di[i][4]) {
                                                                case 0:
                                                                    this.f285di = m12a(this.f285di, new int[]{2201, 0, 0, 12200, 8800, 0, 0});
                                                                    m107for(2204, 6500, 2700);
                                                            }
                                                        } else if (this.f285di[i][0] == 2700) {
                                                            if (this.f285di[i][4] == 8000) {
                                                                this.f379do = this.f334er;
                                                                this.f392y.commandAction(this.f386m, this);
                                                            }
                                                        } else if (this.f285di[i][6] == 1) {
                                                            this.f285di[i][1] = 1;
                                                            this.f285di[i][2] = 0;
                                                        }
                                                        break;
                                                    } else {
                                                        switch (this.f285di[i][4]) {
                                                            case 0:
                                                                this.f127Y = (byte) 6;
                                                                m107for(2206, 6400, 3200);
                                                                break;
                                                            case 3200:
                                                                this.f285di = m11a(this.f285di, i);
                                                                this.f285di = m12a(this.f285di, new int[]{2204, 0, 0, 2700, 0, 0, 0});
                                                                break;
                                                        }
                                                    }
                                                } else {
                                                    switch (this.f285di[i][4]) {
                                                        case f31at /* 1000 */:
                                                            this.f127Y = (byte) 4;
                                                            this.f285di = m11a(this.f285di, i);
                                                            break;
                                                    }
                                                }
                                            } else {
                                                switch (this.f285di[i][4]) {
                                                    case 0:
                                                        m107for(2201, 8000, f101eM);
                                                        this.f257ct.find(2004).setTranslation(100000.0f, this.f352fr, (150.0f + this.f351fq) - 121.0f);
                                                        break;
                                                    case f101eM /* 1500 */:
                                                        this.f127Y = (byte) 3;
                                                        this.f285di = m11a(this.f285di, i);
                                                        break;
                                                    case 8800:
                                                        this.f285di = m11a(this.f285di, i);
                                                        this.f127Y = (byte) 8;
                                                        break;
                                                }
                                            }
                                        } else {
                                            this.f285di = m11a(this.f285di, i);
                                            break;
                                        }
                                    } else {
                                        switch (this.f285di[i][4]) {
                                            case 700:
                                                this.f164al = true;
                                                this.f201bd = false;
                                                m107for(2000, 1600, 1601);
                                                break;
                                            case 3200:
                                                this.f233cL = 400;
                                                break;
                                            case 5601:
                                                m107for(2000, 6400, 5901);
                                                m54j();
                                                try {
                                                    this.f129a0.setRenderingEnable(false);
                                                    this.f192bS = (byte) (this.f192bS - 1);
                                                    this.f344fd = true;
                                                } catch (Exception e) {
                                                    System.out.println(new StringBuffer().append("who cares").append(e).toString());
                                                }
                                                break;
                                            case 5901:
                                                m107for(2000, 7100, 6400);
                                                break;
                                            case 6400:
                                                if (this.f163ak != 1 || this.f192bS <= 0) {
                                                    m107for(2000, 0, 0);
                                                    this.f163ak = (byte) 0;
                                                    this.f164al = false;
                                                    m107for(2004, 8000, 7600);
                                                } else {
                                                    m107for(2000, 1600, 700);
                                                    this.f129a0.setRenderingEnable(true);
                                                }
                                                break;
                                        }
                                    }
                                } else {
                                    this.f285di = m11a(this.f285di, i);
                                    this.f257ct.removeChild(this.f257ct.find(1800));
                                    this.f257ct.setActiveCamera(this.f276dT);
                                    this.f144aH = false;
                                    this.f234cM = false;
                                    break;
                                }
                            } else {
                                switch (this.f285di[i][4]) {
                                    case 0:
                                        this.f285di[i][1] = 1;
                                        if (this.f285di[i][6] == 1) {
                                            this.f285di[i][2] = 0;
                                        }
                                        break;
                                    case f31at /* 1000 */:
                                        this.f140aC[this.f285di[i][5]][3] = 1;
                                        break;
                                    case 2000:
                                        this.f201bd = false;
                                        break;
                                    case 2310:
                                        this.f140aC[this.f285di[i][5]][3] = 1;
                                        break;
                                    case 2800:
                                        this.f201bd = false;
                                        break;
                                    case 5600:
                                        m107for(2004, 6801, 6801);
                                        m107for(2000, 1600, 700);
                                        break;
                                    case 7600:
                                        this.f187bJ = false;
                                        this.f201bd = false;
                                        break;
                                }
                            }
                            break;
                    }
                }
                i++;
            }
        }
    }
}
