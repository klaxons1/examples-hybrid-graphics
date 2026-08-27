package p001a.p002a.p003a.p004a;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Array;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Gauge;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;
import javax.microedition.midlet.MIDlet;
import javax.microedition.rms.RecordStore;
import p000.RunnableC0000a;

/* JADX INFO: renamed from: a.a.a.a.b */
/* JADX INFO: loaded from: C:\Temp\jadx-6965330237357844059\classes.dex */
public class C0002b extends MIDlet implements CommandListener {

    /* JADX INFO: renamed from: L */
    public static final int f393L = 6;

    /* JADX INFO: renamed from: O */
    public static final int f394O = 9;

    /* JADX INFO: renamed from: Y */
    public static final int f395Y = 1;

    /* JADX INFO: renamed from: ab */
    public static final int f396ab = 1;

    /* JADX INFO: renamed from: ad */
    public static final int f397ad = 4;

    /* JADX INFO: renamed from: ak */
    public static final int f398ak = 3;

    /* JADX INFO: renamed from: ap */
    public static int f399ap = 3;

    /* JADX INFO: renamed from: aq */
    public static final int f400aq = 10;

    /* JADX INFO: renamed from: as */
    public static final int f401as = 2;

    /* JADX INFO: renamed from: byte, reason: not valid java name */
    public static final int f484byte = 8;

    /* JADX INFO: renamed from: e */
    public static final int f402e = 5;

    /* JADX INFO: renamed from: f */
    public static final int f403f = 7;

    /* JADX INFO: renamed from: i */
    public static final int f404i = 3;

    /* JADX INFO: renamed from: l */
    public static final int f405l = 2;

    /* JADX INFO: renamed from: q */
    public static final int f406q = 1;

    /* JADX INFO: renamed from: u */
    public static final int f407u = 11;

    /* JADX INFO: renamed from: x */
    public static final int f408x = 2;

    /* JADX INFO: renamed from: A */
    public int f409A;

    /* JADX INFO: renamed from: B */
    public Object f410B;

    /* JADX INFO: renamed from: C */
    public Image[] f411C;

    /* JADX INFO: renamed from: E */
    public Image f413E;

    /* JADX INFO: renamed from: G */
    public int f415G;

    /* JADX INFO: renamed from: H */
    public int f416H;

    /* JADX INFO: renamed from: I */
    public int f417I;

    /* JADX INFO: renamed from: P */
    public char f422P;

    /* JADX INFO: renamed from: Q */
    public boolean f423Q;

    /* JADX INFO: renamed from: R */
    public String[] f424R;

    /* JADX INFO: renamed from: S */
    public int f425S;

    /* JADX INFO: renamed from: U */
    public char f427U;

    /* JADX INFO: renamed from: V */
    public int f428V;

    /* JADX INFO: renamed from: W */
    public String[] f429W;

    /* JADX INFO: renamed from: Z */
    public byte f431Z;

    /* JADX INFO: renamed from: ae */
    public String[] f435ae;

    /* JADX INFO: renamed from: af */
    public boolean f436af;

    /* JADX INFO: renamed from: ah */
    public Image[] f438ah;

    /* JADX INFO: renamed from: ai */
    public int f439ai;

    /* JADX INFO: renamed from: aj */
    public byte f440aj;

    /* JADX INFO: renamed from: al */
    public int[] f441al;

    /* JADX INFO: renamed from: am */
    public byte f442am;

    /* JADX INFO: renamed from: ao */
    public byte f444ao;

    /* JADX INFO: renamed from: au */
    public int f447au;

    /* JADX INFO: renamed from: av */
    public int f448av;

    /* JADX INFO: renamed from: aw */
    public RunnableC0001a f449aw;

    /* JADX INFO: renamed from: ax */
    public String[] f450ax;

    /* JADX INFO: renamed from: c */
    public String f453c;

    /* JADX INFO: renamed from: case, reason: not valid java name */
    public int f485case;

    /* JADX INFO: renamed from: char, reason: not valid java name */
    public int f486char;

    /* JADX INFO: renamed from: d */
    public Image[] f454d;

    /* JADX INFO: renamed from: else, reason: not valid java name */
    public int f487else;

    /* JADX INFO: renamed from: for, reason: not valid java name */
    public String[] f488for;

    /* JADX INFO: renamed from: g */
    public String[] f456g;

    /* JADX INFO: renamed from: h */
    public boolean f457h;

    /* JADX INFO: renamed from: int, reason: not valid java name */
    public String f490int;

    /* JADX INFO: renamed from: j */
    public Image f459j;

    /* JADX INFO: renamed from: long, reason: not valid java name */
    public String f491long;

    /* JADX INFO: renamed from: m */
    public char[] f461m;

    /* JADX INFO: renamed from: new, reason: not valid java name */
    public int[] f492new;

    /* JADX INFO: renamed from: o */
    public int f463o;

    /* JADX INFO: renamed from: r */
    public String[] f465r;

    /* JADX INFO: renamed from: t */
    public String[] f467t;

    /* JADX INFO: renamed from: try, reason: not valid java name */
    public int f494try;

    /* JADX INFO: renamed from: v */
    public Image[][] f468v;

    /* JADX INFO: renamed from: void, reason: not valid java name */
    public byte f495void;

    /* JADX INFO: renamed from: w */
    public Image f469w;

    /* JADX INFO: renamed from: y */
    public String[] f470y;

    /* JADX INFO: renamed from: z */
    public int f471z;

    /* JADX INFO: renamed from: do */
    public Display f455do = Display.getDisplay(this);

    /* JADX INFO: renamed from: k */
    public int f460k = 3;

    /* JADX INFO: renamed from: N */
    public int f421N = 5;

    /* JADX INFO: renamed from: D */
    public int f412D = -1;

    /* JADX INFO: renamed from: n */
    public String[] f462n = {"/bsg", "/title"};

    /* JADX INFO: renamed from: aa */
    public Command f433aa = new Command("", 1, 0);

    /* JADX INFO: renamed from: K */
    public Command f419K = new Command("", 1, 0);

    /* JADX INFO: renamed from: if */
    public Command f458if = new Command("", 1, 0);

    /* JADX INFO: renamed from: ay */
    public Command f451ay = new Command("", 1, 0);

    /* JADX INFO: renamed from: ar */
    public Command f445ar = new Command("", 1, 0);

    /* JADX INFO: renamed from: at */
    public Command f446at = new Command("", 1, 0);

    /* JADX INFO: renamed from: goto, reason: not valid java name */
    public Command f489goto = new Command("", 1, 0);

    /* JADX INFO: renamed from: s */
    public Command f466s = new Command("", 1, 0);

    /* JADX INFO: renamed from: X */
    public Command f430X = new Command("", 1, 0);

    /* JADX INFO: renamed from: F */
    public Command f414F = new Command("", 1, 0);

    /* JADX INFO: renamed from: null, reason: not valid java name */
    public Command f493null = new Command("", 1, 0);

    /* JADX INFO: renamed from: J */
    public Command f418J = new Command("", 1, 0);

    /* JADX INFO: renamed from: b */
    public Command f452b = new Command("", 1, 0);

    /* JADX INFO: renamed from: T */
    public Command f426T = new Command("", 1, 0);

    /* JADX INFO: renamed from: a */
    public Command f432a = new Command("", 1, 0);

    /* JADX INFO: renamed from: an */
    public Command f443an = new Command("", 1, 0);

    /* JADX INFO: renamed from: p */
    public boolean f464p = false;

    /* JADX INFO: renamed from: ac */
    public char f434ac = 65535;

    /* JADX INFO: renamed from: M */
    public char f420M = 65534;

    /* JADX INFO: renamed from: ag */
    public Font f437ag = Font.getDefaultFont();

    public C0002b(RunnableC0001a runnableC0001a, boolean z, boolean z2, int[] iArr) {
        this.f449aw = runnableC0001a;
        RunnableC0001a.f357A = this;
        runnableC0001a.m124null();
        runnableC0001a.setFullScreenMode(true);
        runnableC0001a.m124null();
        runnableC0001a.f392y = this;
        this.f457h = z;
        this.f423Q = z2;
        this.f492new = iArr;
        this.f428V = 7;
        this.f494try = 8;
        this.f439ai = 10;
        m82a();
    }

    /* JADX INFO: renamed from: a */
    public int m80a(String[] strArr, String str) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equals(str)) {
                return i;
            }
        }
        return -1;
    }

    /* JADX INFO: renamed from: a */
    public Object m81a(Image image, String[] strArr, int i, Object[][] objArr) {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, strArr.length, 4);
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr[i2][1] = this.f449aw.m60a(strArr[i2]);
            iArr[i2][2] = (this.f449aw.getWidth() - iArr[i2][1]) / 2;
            if (this.f425S == 1 && iArr[i2][2] < this.f454d[0].getWidth()) {
                iArr[i2][2] = this.f454d[0].getWidth();
                iArr[i2][3] = -1;
            }
            if (this.f425S == 2 && iArr[i2][2] < 0) {
                iArr[i2][2] = 0;
                iArr[i2][3] = -1;
            }
        }
        return new Object[]{image, strArr, new int[]{i}, objArr, iArr};
    }

    /* JADX INFO: renamed from: a */
    public void m82a() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        if (this.f428V == 1) {
            if (this.f448av != 9) {
                m92do();
            }
            this.f471z = 1;
            this.f449aw.f377H = 9;
            this.f449aw.f385l = m81a(this.f413E, this.f450ax, 0, new Object[][]{m89a(this.f488for[38], this.f433aa)});
            this.f449aw.showNotify();
        }
        if (this.f428V == 2) {
            this.f471z = 2;
            this.f449aw.hideNotify();
            this.f449aw.f385l = m81a(this.f469w, this.f465r, 0, new Object[][]{m89a(this.f488for[38], this.f418J), m96if(this.f488for[0], this.f452b)});
            this.f449aw.f377H = 9;
            this.f449aw.showNotify();
        }
        if (this.f428V == 4 || this.f428V == 8) {
            int iM60a = this.f449aw.m60a(this.f488for[31]);
            int width = (this.f449aw.getWidth() - iM60a) / 2;
            if (width < 0) {
                i = -1;
                i2 = 0;
            } else {
                i = 0;
                i2 = width;
            }
            if (this.f410B == null) {
                try {
                    this.f410B = Manager.createPlayer(getClass().getResourceAsStream("/TopScoreMelody.mid"), "audio/midi");
                    ((Player) this.f410B).realize();
                    ((Player) this.f410B).addPlayerListener(this.f449aw);
                } catch (Exception e) {
                }
            }
            this.f449aw.f377H = 3;
            if (this.f428V == 8) {
                this.f449aw.m67a(this.f410B);
                this.f449aw.f385l = new Object[]{this.f469w, this.f488for[31], new int[]{0, iM60a, i2, i}, new Object[][]{m89a(this.f488for[41], this.f446at)}};
            } else {
                this.f449aw.f385l = new Object[]{this.f469w, this.f488for[31], new int[]{0, iM60a, i2, i}, new Object[][]{m96if(this.f488for[0], this.f445ar)}};
            }
            this.f449aw.showNotify();
        }
        if (this.f428V == 6) {
            int iM60a2 = this.f449aw.m60a(this.f488for[6]);
            int width2 = (this.f449aw.getWidth() - iM60a2) / 2;
            if (width2 < 0) {
                i5 = -1;
                width2 = 0;
            } else {
                i5 = 0;
            }
            Object[] objArrM89a = this.f447au < this.f467t.length + (-1) ? m89a(this.f488for[8], this.f489goto) : m89a(this.f488for[10], this.f430X);
            this.f449aw.f377H = 10;
            this.f449aw.f385l = new Object[]{this.f469w, this.f488for[6], this.f467t[this.f447au], new Object[][]{m96if(this.f488for[0], this.f466s), objArrM89a}, new int[]{0, this.f449aw.m76if(this.f467t[this.f447au]), 0, iM60a2, width2, i5}};
            this.f449aw.showNotify();
        }
        if (this.f428V == 5) {
            int iM60a3 = this.f449aw.m60a(this.f453c);
            int width3 = (this.f449aw.getWidth() - iM60a3) / 2;
            if (width3 < 0) {
                i4 = -1;
                width3 = 0;
            } else {
                i4 = 0;
            }
            this.f449aw.f377H = 10;
            this.f449aw.f385l = new Object[]{this.f469w, this.f453c, this.f490int, new Object[][]{m96if(this.f488for[0], this.f426T)}, new int[]{0, this.f449aw.m76if(this.f490int), 0, iM60a3, width3, i4}};
            this.f449aw.showNotify();
        }
        if (this.f428V == 3) {
            if (this.f436af && this.f461m == null) {
                this.f461m = new char[36];
                for (char c = 'A'; c < '['; c = (char) (c + 1)) {
                    this.f461m[c - 'A'] = c;
                }
                for (char c2 = '0'; c2 < ':'; c2 = (char) (c2 + 1)) {
                    this.f461m[c2 - 22] = c2;
                }
            }
            int iM60a4 = this.f449aw.m60a(this.f488for[31]);
            int width4 = (this.f449aw.getWidth() - iM60a4) / 2;
            if (width4 < 0) {
                i3 = -1;
                width4 = 0;
            } else {
                i3 = 0;
            }
            this.f449aw.f377H = 11;
            this.f487else = 0;
            this.f449aw.f385l = new Object[]{this.f469w, this.f488for[31], "", new Object[][]{m89a(this.f488for[38], this.f458if), m96if(this.f488for[40], this.f451ay)}, new int[]{0, iM60a4, width4, i3}};
            this.f449aw.showNotify();
        }
        if (this.f428V == 7) {
            this.f449aw.f377H = 12;
            this.f449aw.f385l = new Object[]{new Gauge("", false, 100, 0), new int[]{this.f494try, this.f439ai}};
            if (this.f455do.getCurrent() == this.f449aw) {
                this.f449aw.showNotify();
            } else {
                this.f455do.setCurrent(this.f449aw);
            }
        }
        if (this.f428V == 9) {
            this.f449aw.f377H = 2;
            this.f449aw.repaint();
            this.f449aw.showNotify();
        }
        if (this.f428V == 10) {
            if (this.f468v != null) {
                this.f449aw.f377H = 1;
                this.f449aw.f385l = new Object[]{this.f468v, this.f492new, new int[]{0, RunnableC0000a.f84dU, 0, 0}};
                if (f399ap == 3) {
                    this.f449aw.f479goto = this.f449aw.getWidth();
                    this.f449aw.f483void = this.f449aw.getHeight();
                }
                this.f468v = null;
                this.f449aw.showNotify();
            } else {
                this.f428V = 1;
                m82a();
            }
        }
        if (this.f428V == 11) {
            this.f449aw.f377H = 9;
            this.f449aw.f385l = m81a(this.f413E, this.f424R, this.f417I, new Object[][]{m89a(this.f488for[38], this.f432a)});
            this.f449aw.showNotify();
        }
        this.f428V = 0;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v63, types: [java.lang.StringBuffer] */
    /* JADX WARN: Type inference failed for: r0v79, types: [java.lang.StringBuffer] */
    /* JADX WARN: Type inference failed for: r1v12 */
    /* JADX WARN: Type inference failed for: r1v13, types: [int] */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v18 */
    /* JADX WARN: Type inference failed for: r1v19, types: [int] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v21 */
    /* JADX WARN: Type inference failed for: r1v22 */
    /* JADX WARN: Type inference failed for: r1v23 */
    /* JADX WARN: Type inference failed for: r1v24, types: [int] */
    /* JADX WARN: Type inference failed for: r1v38, types: [int] */
    /* JADX WARN: Type inference failed for: r1v39, types: [int] */
    /* JADX WARN: Type inference failed for: r1v40, types: [int] */
    /* JADX WARN: Type inference failed for: r1v41, types: [java.io.DataInputStream] */
    /* JADX WARN: Type inference failed for: r1v82 */
    /* JADX WARN: Type inference failed for: r1v83 */
    /* JADX WARN: Type inference failed for: r1v84 */
    /* JADX WARN: Type inference failed for: r1v85 */
    /* JADX WARN: Type inference failed for: r1v86 */
    /* JADX WARN: Type inference failed for: r1v87 */
    /* JADX WARN: Type inference failed for: r1v88 */
    /* JADX WARN: Type inference failed for: r1v89 */
    /* JADX WARN: Type inference failed for: r1v90 */
    /* JADX WARN: Type inference failed for: r2v26, types: [int] */
    /* JADX WARN: Type inference failed for: r2v32, types: [java.lang.StringBuffer] */
    /* JADX WARN: Type inference failed for: r2v43, types: [int] */
    /* JADX WARN: Type inference failed for: r2v49, types: [java.lang.StringBuffer] */
    /* JADX INFO: renamed from: a */
    public void m83a(Gauge gauge) {
        ?? dataInputStream;
        Image imageCreateImage;
        ?? r1;
        this.f449aw.m69a(true);
        if (this.f425S == 0) {
            if (this.f449aw.getHeight() > this.f449aw.getWidth()) {
                this.f425S = 2;
                this.f416H = (((32768 * (this.f415G & 255)) >> 16) & 255) | ((((((this.f415G >> 16) & 255) * 32768) >> 16) & 255) << 16) | ((((((this.f415G >> 8) & 255) * 32768) >> 16) & 255) << 8);
            } else {
                this.f425S = 1;
            }
        }
        try {
            DataInputStream dataInputStream2 = new DataInputStream(getClass().getResourceAsStream("/font0.bsf"));
            this.f422P = dataInputStream2.readChar();
            this.f411C = new Image[this.f422P];
            if (this.f425S == 2) {
                this.f438ah = new Image[this.f422P];
            }
            this.f470y = new String[this.f422P];
            this.f440aj = dataInputStream2.readByte();
            this.f442am = dataInputStream2.readByte();
            this.f444ao = dataInputStream2.readByte();
            this.f431Z = dataInputStream2.readByte();
            byte b = dataInputStream2.readBoolean() ? (byte) 195 : (byte) 67;
            byte[] bArr = new byte[dataInputStream2.readByte() * 3];
            for (int i = 0; i < bArr.length; i++) {
                bArr[i] = dataInputStream2.readByte();
            }
            this.f454d = new Image[4];
            for (int i2 = 0; i2 < 5; i2++) {
                byte b2 = dataInputStream2.readByte();
                byte b3 = dataInputStream2.readByte();
                int i3 = b2 * b3;
                byte[] bArr2 = new byte[bArr.length + 8 + i3];
                bArr2[2] = (byte) (b2 >> 8);
                bArr2[3] = b2;
                bArr2[4] = (byte) (b3 >> 8);
                bArr2[5] = b3;
                bArr2[6] = b;
                bArr2[7] = (byte) (bArr.length / 3);
                System.arraycopy(bArr, 0, bArr2, 8, bArr.length);
                for (int i4 = 0; i4 < i3; i4++) {
                    bArr2[bArr.length + 8 + i4] = dataInputStream2.readByte();
                }
                if (i2 < 4) {
                    this.f454d[i2] = RunnableC0001a.m56a(bArr2);
                } else {
                    this.f459j = RunnableC0001a.m56a(bArr2);
                }
            }
            gauge.setValue(10);
            for (int i5 = 0; i5 < this.f422P; i5++) {
                this.f470y[i5] = dataInputStream2.readUTF();
                byte b4 = dataInputStream2.readByte();
                this.f495void = (byte) Math.max((int) this.f495void, (int) b4);
                int i6 = this.f440aj * b4;
                byte[] bArr3 = new byte[bArr.length + 8 + i6];
                bArr3[2] = (byte) (b4 >> 8);
                bArr3[3] = b4;
                bArr3[4] = (byte) (this.f440aj >> 8);
                bArr3[5] = this.f440aj;
                bArr3[6] = b;
                bArr3[7] = (byte) (bArr.length / 3);
                System.arraycopy(bArr, 0, bArr3, 8, bArr.length);
                for (int i7 = 0; i7 < i6; i7++) {
                    bArr3[bArr.length + 8 + i7] = dataInputStream2.readByte();
                }
                this.f411C[i5] = RunnableC0001a.m56a(bArr3);
                if (this.f425S == 2) {
                    this.f438ah[i5] = RunnableC0001a.m56a(RunnableC0001a.m58a(bArr3, -50));
                }
                gauge.setValue(((((i5 << 16) / this.f422P) * 10) >> 16) + 10);
            }
            this.f427U = this.f449aw.m63a("-", this.f470y).charAt(0);
            dataInputStream2.close();
            System.gc();
        } catch (Exception e) {
            this.f436af = true;
        }
        try {
            DataInputStream dataInputStream3 = new DataInputStream(getClass().getResourceAsStream("/mlang"));
            int i8 = dataInputStream3.readByte();
            this.f424R = new String[i8];
            this.f435ae = new String[i8];
            String property = System.getProperty("microedition.locale");
            for (int i9 = 0; i9 < i8; i9++) {
                this.f424R[i9] = dataInputStream3.readUTF();
                this.f435ae[i9] = dataInputStream3.readUTF();
                if (property != null && property.indexOf(this.f435ae[i9]) != -1) {
                    this.f417I = i9;
                }
            }
            for (int i10 = 0; i10 < i8; i10++) {
                this.f424R[i10] = this.f449aw.m63a(this.f424R[i10], this.f470y);
            }
        } catch (Exception e2) {
        }
        this.f449aw.f477char = this.f457h;
        this.f449aw.f376F = this.f423Q;
        try {
            DataInputStream dataInputStream4 = new DataInputStream(new ByteArrayInputStream(m88a("d")));
            this.f417I = dataInputStream4.readByte();
            this.f409A = dataInputStream4.readByte();
            this.f449aw.f477char = dataInputStream4.readBoolean();
            this.f449aw.f376F = dataInputStream4.readBoolean();
            dataInputStream4.close();
        } catch (Exception e3) {
        }
        m93do(gauge);
        if (this.f486char == 0) {
            if (this.f425S == 1) {
                this.f486char = (this.f449aw.getHeight() - (this.f440aj * 2)) - this.f431Z;
            }
            if (this.f425S == 2) {
                this.f486char = (this.f449aw.getHeight() - (this.f440aj * 4)) - (this.f431Z * 3);
            }
        }
        try {
            dataInputStream = new DataInputStream(new ByteArrayInputStream(m88a("d")));
            dataInputStream.readByte();
            dataInputStream.readByte();
            dataInputStream.readBoolean();
            dataInputStream.readBoolean();
            this.f441al = new int[dataInputStream.readByte()];
            this.f429W = new String[this.f441al.length];
            for (int i11 = 0; i11 < this.f441al.length; i11++) {
                this.f441al[i11] = dataInputStream.readInt();
                this.f429W[i11] = dataInputStream.readUTF();
            }
            dataInputStream.close();
        } catch (Exception e4) {
            this.f441al = new int[(this.f449aw.getHeight() - (this.f440aj * 2)) / (this.f440aj + this.f431Z)];
            this.f429W = new String[(this.f449aw.getHeight() - (this.f440aj * 2)) / (this.f440aj + this.f431Z)];
            String strM63a = this.f436af ? "AAA" : this.f449aw.m63a("AAA", this.f470y);
            dataInputStream = 0;
            while (dataInputStream < this.f429W.length) {
                this.f429W[dataInputStream] = strM63a;
                dataInputStream++;
            }
        }
        if (this.f492new != null) {
            try {
                this.f468v = new Image[2][];
                int i12 = 1;
                int i13 = dataInputStream;
                while (true) {
                    try {
                        i13 = i12;
                        InputStream resourceAsStream = getClass().getResourceAsStream(new StringBuffer().append(this.f462n[0]).append("_").append(i13).append(".png").toString());
                        resourceAsStream.read();
                        resourceAsStream.close();
                        i12 = i13 + 1;
                        i13 = i13;
                    } catch (Exception e5) {
                        this.f468v[0] = new Image[i13];
                        if (this.f464p) {
                            for (int i14 = 1; i14 < i13; i14++) {
                                this.f468v[0][i14] = Image.createImage(new StringBuffer().append(this.f462n[0]).append("_").append(i14).append(".png").toString());
                                gauge.setValue(((((i14 << 16) / i13) * 20) >> 16) + 40);
                            }
                        }
                        int i15 = 1;
                        ?? r2 = i13;
                        while (true) {
                            try {
                                r2 = i15;
                                imageCreateImage = Image.createImage(new StringBuffer().append(this.f462n[0]).append(r2).append(".png").toString());
                                Image[][] imageArr = (Image[][]) Array.newInstance((Class<?>) Image.class, this.f468v.length + 1, 1);
                                int[] iArr = new int[this.f492new.length + 1];
                                iArr[r2] = this.f492new[0];
                                iArr[iArr.length - 1] = this.f492new[this.f492new.length - 1];
                                for (int i16 = 0; i16 < r2; i16++) {
                                    imageArr[i16] = this.f468v[i16];
                                    iArr[i16] = this.f492new[i16];
                                }
                                this.f468v = imageArr;
                                this.f492new = iArr;
                                String[] strArr = new String[this.f462n.length + 1];
                                for (int i17 = 0; i17 < r2; i17++) {
                                    strArr[i17] = this.f462n[i17];
                                }
                                strArr[r2] = new StringBuffer().append(this.f462n[0]).append(r2).toString();
                                for (int i18 = r2 + 1; i18 < strArr.length; i18++) {
                                    strArr[i18] = this.f462n[i18 - 1];
                                }
                                this.f462n = strArr;
                                i15 = r2 + 1;
                                r1 = r2;
                            } catch (IOException e6) {
                                imageCreateImage = null;
                                i15 = r2 == true ? 1 : 0;
                                r1 = r2;
                            }
                            if (imageCreateImage == null) {
                                break;
                            } else {
                                r2 = r1;
                            }
                        }
                        gauge.setValue(50);
                        int i19 = 1;
                        int i20 = r1;
                        while (true) {
                            try {
                                i20 = i19;
                                InputStream resourceAsStream2 = getClass().getResourceAsStream(new StringBuffer().append(this.f462n[this.f462n.length - 1]).append("_").append(i20).append(".png").toString());
                                resourceAsStream2.read();
                                resourceAsStream2.close();
                                i19 = i20 + 1;
                                i20 = i20;
                            } catch (Exception e7) {
                                this.f468v[this.f468v.length - 1] = new Image[i20];
                                if (this.f464p) {
                                    for (int i21 = 1; i21 < i20; i21++) {
                                        this.f468v[this.f468v.length - 1][i21] = Image.createImage(new StringBuffer().append(this.f462n[this.f462n.length - 1]).append("_").append(i21).append(".png").toString());
                                        gauge.setValue(((((i21 << 16) / i20) * 20) >> 16) + 40);
                                    }
                                }
                                this.f468v[0][0] = Image.createImage(new StringBuffer().append(this.f462n[0]).append(".png").toString());
                                this.f468v[this.f468v.length - 1][0] = Image.createImage(new StringBuffer().append(this.f462n[this.f462n.length - 1]).append(".png").toString());
                                this.f413E = this.f468v[this.f468v.length - 1][0];
                                this.f463o = this.f492new[this.f468v.length - 1];
                                gauge.setValue(60);
                                m92do();
                                this.f449aw.mo31a(gauge);
                                gauge.setValue(100);
                                this.f449aw.m66a(50, 300, true);
                            }
                        }
                    }
                }
            } catch (IOException e8) {
            }
        }
        m92do();
        this.f449aw.mo31a(gauge);
        gauge.setValue(100);
        this.f449aw.m66a(50, 300, true);
    }

    /* JADX INFO: renamed from: a */
    public void m84a(Graphics graphics) {
        graphics.setColor(this.f463o);
        graphics.fillRect(0, 0, this.f449aw.getWidth(), this.f449aw.getHeight());
        if (((Object[]) this.f449aw.f385l)[0] != null) {
            graphics.drawImage((Image) ((Object[]) this.f449aw.f385l)[0], this.f449aw.getWidth() / 2, this.f449aw.getHeight() / 2, 3);
        }
        this.f449aw.m68a(graphics, (String) ((Object[]) this.f449aw.f385l)[1], this.f411C, this.f449aw.f479goto + ((int[]) ((Object[]) this.f449aw.f385l)[2])[2] + ((int[]) ((Object[]) this.f449aw.f385l)[2])[0], this.f449aw.f483void, 20);
        int height = this.f449aw.f483void + (((this.f449aw.getHeight() - (this.f440aj * this.f441al.length)) - (this.f431Z * (this.f441al.length - 1))) / 2);
        String strM63a = this.f449aw.m63a("0", this.f470y);
        for (int i = 0; i < this.f441al.length; i++) {
            if (i != this.f412D || (this.f449aw.f479goto == 0 && this.f449aw.f483void == 0 && this.f485case == 1)) {
                this.f449aw.m68a(graphics, this.f429W[i], this.f411C, (this.f449aw.getWidth() / 4) + this.f449aw.f479goto, height, 17);
                String strM63a2 = this.f449aw.m63a(new StringBuffer().append("").append(this.f441al[i]).toString(), this.f470y);
                while (strM63a2.length() < this.f421N) {
                    strM63a2 = !this.f436af ? new StringBuffer().append(strM63a).append(strM63a2).toString() : new StringBuffer().append(0).append(strM63a2).toString();
                }
                this.f449aw.m68a(graphics, strM63a2, this.f411C, (this.f449aw.f479goto + this.f449aw.getWidth()) - (this.f449aw.getWidth() / 4), height, 17);
            }
            height += this.f440aj + this.f431Z;
        }
        if (this.f449aw.f479goto == 0 && this.f449aw.f483void == 0) {
            this.f485case ^= 1;
        }
    }

    /* JADX INFO: renamed from: a */
    public void mo0a(Graphics graphics, int i) {
        graphics.setColor(RunnableC0000a.f67cu);
        graphics.fillRect(0, 0, this.f449aw.getWidth(), this.f449aw.getHeight());
        int width = this.f449aw.getWidth() - (this.f449aw.getWidth() / 6);
        int height = this.f449aw.getHeight() / 10;
        graphics.setColor(255);
        graphics.fillRect((this.f449aw.getWidth() - width) / 2, this.f449aw.getHeight() - (height * 2), (((i << 8) / 100) * width) >> 8, height);
        graphics.setColor(0);
        graphics.drawRect((this.f449aw.getWidth() - width) / 2, this.f449aw.getHeight() - (height * 2), width, height);
    }

    /* JADX INFO: renamed from: a */
    public void m85a(boolean z, boolean z2) {
        this.f449aw.f375C = z;
        if (z) {
            m86a(this.f465r, this.f488for[12], this.f488for[22], z2);
        } else {
            m86a(this.f465r, this.f488for[22], this.f488for[12], z2);
        }
    }

    /* JADX INFO: renamed from: a */
    public void m86a(String[] strArr, String str, String str2, boolean z) {
        int iM80a = m80a(strArr, str);
        strArr[iM80a] = str2;
        if (z) {
            ((int[][]) ((Object[]) this.f449aw.f385l)[4])[iM80a][0] = 0;
            ((int[][]) ((Object[]) this.f449aw.f385l)[4])[iM80a][1] = this.f449aw.m60a(strArr[iM80a]);
            ((int[][]) ((Object[]) this.f449aw.f385l)[4])[iM80a][2] = (this.f449aw.getWidth() - ((int[][]) ((Object[]) this.f449aw.f385l)[4])[iM80a][1]) / 2;
            if (this.f425S == 1) {
                if (((int[][]) ((Object[]) this.f449aw.f385l)[4])[iM80a][2] < this.f454d[0].getWidth()) {
                    ((int[][]) ((Object[]) this.f449aw.f385l)[4])[iM80a][2] = this.f454d[0].getWidth();
                    ((int[][]) ((Object[]) this.f449aw.f385l)[4])[iM80a][3] = -1;
                    return;
                }
                return;
            }
            if (this.f425S != 2) {
                ((int[][]) ((Object[]) this.f449aw.f385l)[4])[iM80a][3] = 0;
            } else if (((int[][]) ((Object[]) this.f449aw.f385l)[4])[iM80a][2] < 0) {
                ((int[][]) ((Object[]) this.f449aw.f385l)[4])[iM80a][2] = 0;
                ((int[][]) ((Object[]) this.f449aw.f385l)[4])[iM80a][3] = -1;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    protected boolean m87a(String str, byte[] bArr) {
        RecordStore recordStore;
        try {
            RecordStore.deleteRecordStore(str);
        } catch (Exception e) {
        }
        try {
            RecordStore recordStoreOpenRecordStore = RecordStore.openRecordStore(str, true);
            try {
                recordStoreOpenRecordStore.addRecord(bArr, 0, bArr.length);
                recordStoreOpenRecordStore.closeRecordStore();
                return true;
            } catch (Exception e2) {
                recordStore = recordStoreOpenRecordStore;
                if (recordStore != null) {
                    try {
                        recordStore.closeRecordStore();
                    } catch (Exception e3) {
                    }
                }
                try {
                    RecordStore.deleteRecordStore(str);
                } catch (Exception e4) {
                }
                return false;
            }
        } catch (Exception e5) {
            recordStore = null;
        }
    }

    /* JADX INFO: renamed from: a */
    protected byte[] m88a(String str) {
        byte[] record;
        RecordStore recordStoreOpenRecordStore;
        try {
            recordStoreOpenRecordStore = RecordStore.openRecordStore(str, false);
            try {
                record = recordStoreOpenRecordStore.getRecord(1);
                try {
                    recordStoreOpenRecordStore.closeRecordStore();
                } catch (Exception e) {
                    if (recordStoreOpenRecordStore != null) {
                        try {
                            recordStoreOpenRecordStore.closeRecordStore();
                        } catch (Exception e2) {
                        }
                    }
                    try {
                        RecordStore.deleteRecordStore(str);
                    } catch (Exception e3) {
                    }
                }
            } catch (Exception e4) {
                record = null;
            }
        } catch (Exception e5) {
            record = null;
            recordStoreOpenRecordStore = null;
        }
        return record;
    }

    /* JADX INFO: renamed from: a */
    public Object[] m89a(String str, Command command) {
        Object[] objArr = new Object[3];
        objArr[0] = str;
        int[] iArr = new int[5];
        iArr[0] = -6;
        iArr[1] = 0;
        iArr[2] = this.f449aw.m60a(str);
        iArr[3] = 0;
        iArr[4] = this.f449aw.m60a(str) > (this.f449aw.getWidth() / 7) * 3 ? -1 : 0;
        objArr[1] = iArr;
        objArr[2] = command;
        return objArr;
    }

    /* JADX INFO: renamed from: a */
    public String[] m90a(String[] strArr, int i) {
        boolean z = false;
        String[] strArr2 = new String[strArr.length - 1];
        int i2 = 0;
        while (true) {
            boolean z2 = z;
            if (i2 >= strArr.length) {
                return strArr2;
            }
            if (i2 == i) {
                z = true;
            } else {
                strArr2[z2 ? i2 - 1 : i2] = strArr[i2];
                z = z2;
            }
            i2++;
        }
    }

    /* JADX INFO: renamed from: a */
    public String[] m91a(String[] strArr, String str, int i) {
        boolean z = false;
        String[] strArr2 = new String[strArr.length + 1];
        int i2 = 0;
        while (true) {
            boolean z2 = z;
            if (i2 >= strArr2.length) {
                return strArr2;
            }
            if (i2 == i) {
                z = true;
                strArr2[i2] = str;
            } else {
                strArr2[i2] = strArr[z2 ? i2 - 1 : i2];
                z = z2;
            }
            i2++;
        }
    }

    public void commandAction(Command command, Displayable displayable) {
        if (command == this.f414F) {
            this.f409A = ((int[]) ((Object[]) ((RunnableC0001a) displayable).f385l)[2])[0];
            this.f428V = 7;
            this.f448av = 1;
            this.f494try = 4;
            this.f439ai = 9;
            this.f449aw.f388q = false;
        }
        if (command == this.f493null || command == this.f443an || (command == this.f432a && this.f417I == ((int[]) ((Object[]) ((RunnableC0001a) displayable).f385l)[2])[0])) {
            this.f428V = 1;
            m82a();
        } else if (command == this.f432a) {
            this.f417I = ((int[]) ((Object[]) ((RunnableC0001a) displayable).f385l)[2])[0];
            this.f428V = 7;
            this.f494try = 13;
            this.f439ai = 1;
            this.f449aw.f388q = false;
        }
        if (command == this.f433aa || command == this.f418J) {
            String str = ((String[]) ((Object[]) ((RunnableC0001a) displayable).f385l)[1])[((int[]) ((Object[]) ((RunnableC0001a) displayable).f385l)[2])[0]];
            if (this.f471z == 1) {
                if (str.equals(this.f488for[15])) {
                    if (this.f456g.length > 0) {
                        this.f449aw.f385l = m81a(this.f413E, this.f456g, this.f409A, new Object[][]{m89a(this.f488for[38], this.f414F), m96if(this.f488for[0], this.f493null)});
                    } else {
                        this.f428V = 7;
                        this.f448av = 1;
                        this.f494try = 4;
                        this.f439ai = 9;
                        this.f449aw.f388q = false;
                    }
                }
                if (str.equals(this.f488for[1])) {
                    this.f428V = 7;
                    this.f448av = 1;
                    this.f494try = 6;
                    this.f439ai = 9;
                    this.f449aw.f388q = false;
                }
                if (str.equals(this.f488for[31])) {
                    this.f428V = 4;
                    this.f449aw.f388q = false;
                }
                if (str.equals(this.f488for[2])) {
                    this.f428V = 5;
                    this.f453c = this.f488for[2];
                    this.f490int = this.f491long;
                    this.f449aw.f388q = false;
                }
                if (this.f435ae != null && str.equals(this.f488for[39])) {
                    this.f449aw.f385l = m81a(this.f413E, this.f424R, this.f417I, new Object[][]{m89a(this.f488for[38], this.f432a), m96if(this.f488for[0], this.f443an)});
                }
                if (str.equals(this.f488for[21])) {
                    destroyApp(true);
                }
            }
            if (this.f471z == 2) {
                if (str.equals(this.f488for[12])) {
                    m85a(true, true);
                    this.f448av = 2;
                    this.f449aw.f388q = false;
                }
                if (str.equals(this.f488for[22])) {
                    m85a(false, true);
                    this.f448av = 2;
                    this.f449aw.f388q = false;
                }
                if (str.equals(this.f488for[20])) {
                    if (this.f449aw.f375C) {
                        m85a(false, false);
                    }
                    this.f428V = 7;
                    this.f494try = 7;
                    this.f439ai = 1;
                    this.f449aw.f388q = false;
                }
            }
            if (str.equals(this.f488for[27])) {
                this.f449aw.f477char = true;
                m86a(this.f450ax, this.f488for[27], this.f488for[26], this.f471z == 1);
                m86a(this.f465r, this.f488for[27], this.f488for[26], this.f471z == 2);
            }
            if (str.equals(this.f488for[26])) {
                this.f449aw.f477char = false;
                m86a(this.f450ax, this.f488for[26], this.f488for[27], this.f471z == 1);
                m86a(this.f465r, this.f488for[26], this.f488for[27], this.f471z == 2);
            }
            if (str.equals(this.f488for[34])) {
                this.f449aw.f376F = true;
                m86a(this.f450ax, this.f488for[34], this.f488for[33], this.f471z == 1);
                m86a(this.f465r, this.f488for[34], this.f488for[33], this.f471z == 2);
            }
            if (str.equals(this.f488for[33])) {
                this.f449aw.f376F = false;
                m86a(this.f450ax, this.f488for[33], this.f488for[34], this.f471z == 1);
                m86a(this.f465r, this.f488for[33], this.f488for[34], this.f471z == 2);
            }
            if (str.equals(this.f488for[6])) {
                this.f447au = 0;
                this.f428V = 6;
                this.f449aw.f388q = false;
            }
        }
        if (command == this.f452b) {
            this.f448av = 2;
            this.f449aw.f388q = false;
        }
        if (command == this.f426T) {
            this.f428V = this.f471z;
            this.f449aw.f388q = false;
        }
        if (command == this.f489goto) {
            this.f447au++;
            this.f428V = 6;
            this.f449aw.f388q = false;
        }
        if (command == this.f430X || (command == this.f466s && this.f447au == 0)) {
            this.f428V = this.f471z;
            this.f449aw.f388q = false;
        }
        if (command == this.f466s && this.f447au > 0) {
            this.f447au--;
            this.f428V = 6;
            this.f449aw.f388q = false;
        }
        if (command == this.f445ar || command == this.f446at) {
            this.f412D = -1;
            this.f428V = 1;
            this.f449aw.f388q = false;
        }
        if (command == this.f458if) {
            if (this.f436af) {
                ((Object[]) this.f449aw.f385l)[2] = new StringBuffer().append((String) ((Object[]) this.f449aw.f385l)[2]).append(this.f461m[this.f487else]).toString();
            } else {
                ((Object[]) this.f449aw.f385l)[2] = new StringBuffer().append((String) ((Object[]) this.f449aw.f385l)[2]).append((char) this.f487else).toString();
            }
            if (((String) ((Object[]) this.f449aw.f385l)[2]).length() == this.f460k) {
                ((Object[][]) ((Object[]) this.f449aw.f385l)[3])[0] = m89a(this.f488for[41], this.f419K);
            }
        }
        if (command == this.f451ay && ((String) ((Object[]) this.f449aw.f385l)[2]).length() > 0) {
            ((Object[]) this.f449aw.f385l)[2] = ((String) ((Object[]) this.f449aw.f385l)[2]).substring(0, ((String) ((Object[]) this.f449aw.f385l)[2]).length() - 1);
            if (((String) ((Object[]) this.f449aw.f385l)[2]).length() == this.f460k - 1) {
                ((Object[][]) ((Object[]) this.f449aw.f385l)[3])[0] = m89a(this.f488for[38], this.f458if);
            }
        }
        if (command == this.f419K) {
            int length = this.f441al.length;
            while (true) {
                length--;
                if (length <= this.f412D) {
                    break;
                }
                this.f441al[length] = this.f441al[length - 1];
                this.f429W[length] = this.f429W[length - 1];
            }
            this.f441al[this.f412D] = this.f449aw.f379do;
            this.f429W[this.f412D] = (String) ((Object[]) this.f449aw.f385l)[2];
            this.f428V = 8;
            this.f449aw.f388q = false;
        }
        if (command == this.f449aw.f391w) {
            this.f449aw.hideNotify();
            if (f399ap == 1) {
                this.f449aw.f481long = 0;
                RunnableC0001a runnableC0001a = this.f449aw;
                RunnableC0001a runnableC0001a2 = this.f449aw;
                runnableC0001a.mo32a(RunnableC0001a.f360G);
                RunnableC0001a runnableC0001a3 = this.f449aw;
                Image image = RunnableC0001a.f474new;
                RunnableC0001a runnableC0001a4 = this.f449aw;
                image.getRGB(RunnableC0001a.f362b, 0, this.f449aw.getWidth(), 0, 0, this.f449aw.getWidth(), this.f449aw.getHeight());
                RunnableC0001a runnableC0001a5 = this.f449aw;
                Image image2 = RunnableC0001a.f474new;
                RunnableC0001a runnableC0001a6 = this.f449aw;
                image2.getRGB(RunnableC0001a.f364g, 0, this.f449aw.getWidth(), 0, 0, this.f449aw.getWidth(), this.f449aw.getHeight());
            }
            this.f428V = 7;
            this.f494try = 5;
            this.f439ai = 9;
            m82a();
        }
        if (command == this.f449aw.f386m) {
            this.f449aw.hideNotify();
            try {
                RecordStore.deleteRecordStore("s");
                this.f450ax = m97if(this.f450ax, this.f488for[1]);
            } catch (Exception e) {
            }
            if (this.f449aw.f379do != 0) {
                this.f412D = 0;
                while (this.f412D < this.f441al.length && this.f449aw.f379do < this.f441al[this.f412D]) {
                    this.f412D++;
                }
            }
            this.f448av = 9;
            if (f399ap == 1) {
                this.f449aw.f481long = 0;
                RunnableC0001a runnableC0001a7 = this.f449aw;
                RunnableC0001a runnableC0001a8 = this.f449aw;
                runnableC0001a7.mo32a(RunnableC0001a.f360G);
                RunnableC0001a runnableC0001a9 = this.f449aw;
                Image image3 = RunnableC0001a.f474new;
                RunnableC0001a runnableC0001a10 = this.f449aw;
                image3.getRGB(RunnableC0001a.f362b, 0, this.f449aw.getWidth(), 0, 0, this.f449aw.getWidth(), this.f449aw.getHeight());
                RunnableC0001a runnableC0001a11 = this.f449aw;
                Image image4 = RunnableC0001a.f474new;
                RunnableC0001a runnableC0001a12 = this.f449aw;
                image4.getRGB(RunnableC0001a.f364g, 0, this.f449aw.getWidth(), 0, 0, this.f449aw.getWidth(), this.f449aw.getHeight());
            }
            if (f399ap == 2) {
                this.f449aw.f476byte = 0;
            }
            if (f399ap == 3) {
                this.f449aw.f479goto = this.f449aw.getWidth();
                this.f449aw.f483void = this.f449aw.getHeight();
            }
            if (this.f449aw.f379do == 0 || this.f412D >= this.f441al.length) {
                this.f428V = 1;
                m82a();
            } else {
                this.f428V = 3;
                m82a();
            }
        }
    }

    public void destroyApp(boolean z) {
        this.f449aw.m69a(false);
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeByte(this.f417I);
            dataOutputStream.writeByte(this.f409A);
            dataOutputStream.writeBoolean(this.f449aw.f477char);
            dataOutputStream.writeBoolean(this.f449aw.f376F);
            dataOutputStream.writeByte(this.f441al.length);
            for (int i = 0; i < this.f441al.length; i++) {
                dataOutputStream.writeInt(this.f441al[i]);
                dataOutputStream.writeUTF(this.f429W[i]);
            }
            m87a("d", byteArrayOutputStream.toByteArray());
            dataOutputStream.close();
        } catch (Exception e) {
        }
        notifyDestroyed();
    }

    /* JADX INFO: renamed from: do */
    public void m92do() {
        try {
            if (this.f413E == null) {
                this.f413E = Image.createImage(new StringBuffer().append(this.f462n[this.f462n.length - 1]).append(".png").toString());
            }
            if (this.f469w == null) {
                try {
                    this.f469w = Image.createImage(new StringBuffer().append(this.f462n[this.f462n.length - 1]).append("faded.png").toString());
                } catch (IOException e) {
                    int[] iArr = new int[this.f413E.getWidth() * this.f413E.getHeight()];
                    this.f413E.getRGB(iArr, 0, this.f413E.getWidth(), 0, 0, this.f413E.getWidth(), this.f413E.getHeight());
                    for (int i = 0; i < iArr.length; i++) {
                        int i2 = (iArr[i] >> 16) & 255;
                        int i3 = (iArr[i] >> 8) & 255;
                        int i4 = iArr[i] & 255;
                        iArr[i] = ((i2 + (((-i2) * 52428) >> 16)) << 16) | ((i3 + (((-i3) * 52428) >> 16)) << 8) | ((((-i4) * 52428) >> 16) + i4);
                    }
                    this.f469w = Image.createImage(this.f413E.getWidth(), this.f413E.getHeight());
                    this.f469w.getGraphics().drawRGB(iArr, 0, this.f413E.getWidth(), 0, 0, this.f413E.getWidth(), this.f413E.getHeight(), false);
                }
            }
        } catch (IOException e2) {
        }
    }

    /* JADX INFO: renamed from: do */
    public void m93do(Gauge gauge) {
        try {
            DataInputStream dataInputStream = new DataInputStream(getClass().getResourceAsStream(new StringBuffer().append("/lang").append(this.f417I > 0 ? new StringBuffer().append("").append(this.f417I).toString() : "").toString()));
            this.f449aw.f478for = false;
            byte b = dataInputStream.readByte();
            if (b == 10 || b == 11) {
                this.f449aw.f478for = true;
            }
            this.f488for = new String[dataInputStream.readUnsignedByte()];
            for (int i = 0; i < this.f488for.length; i++) {
                this.f488for[i] = dataInputStream.readUTF();
                this.f449aw.m63a(this.f488for[i], this.f470y);
            }
            for (byte b2 : new byte[]{3, 5, 7, 11, 13, 14, 16, 17, 18, 23, 24, 25, 28, 30, 35, 36, 37}) {
                this.f488for[b2] = "";
            }
            gauge.setValue(20);
            dataInputStream.readByte();
            dataInputStream.readByte();
            dataInputStream.readUnsignedByte();
            dataInputStream.readUTF();
            this.f456g = new String[dataInputStream.readUnsignedByte()];
            for (int i2 = 0; i2 < this.f456g.length; i2++) {
                this.f456g[i2] = dataInputStream.readUTF();
                this.f449aw.m63a(this.f456g[i2], this.f470y);
            }
            this.f491long = dataInputStream.readUTF();
            this.f449aw.m63a(this.f491long, this.f470y);
            dataInputStream.readUTF();
            this.f467t = new String[dataInputStream.readUnsignedByte()];
            for (int i3 = 0; i3 < this.f467t.length; i3++) {
                this.f467t[i3] = dataInputStream.readUTF();
                this.f449aw.m63a(this.f467t[i3], this.f470y);
            }
            gauge.setValue(30);
            this.f449aw.f383if = new String[dataInputStream.readUnsignedByte()];
            for (int i4 = 0; i4 < this.f449aw.f383if.length; i4++) {
                dataInputStream.readByte();
                this.f449aw.f383if[i4] = dataInputStream.readUTF();
                this.f449aw.m63a(this.f449aw.f383if[i4], this.f470y);
            }
            dataInputStream.close();
            if (this.f436af) {
                this.f440aj = (byte) this.f437ag.getHeight();
                this.f495void = (byte) this.f437ag.charWidth('w');
                this.f442am = (byte) this.f437ag.charWidth(' ');
                this.f444ao = (byte) 0;
                this.f431Z = (byte) 0;
                this.f427U = '-';
                this.f434ac = ' ';
                this.f420M = '\n';
                this.f491long = this.f449aw.m61a(this.f491long, this.f449aw.getWidth());
                for (int i5 = 0; i5 < this.f467t.length; i5++) {
                    this.f467t[i5] = this.f449aw.m61a(this.f467t[i5], this.f449aw.getWidth());
                }
            } else {
                for (int i6 = 0; i6 < this.f488for.length; i6++) {
                    this.f488for[i6] = this.f449aw.m63a(this.f488for[i6], this.f470y);
                }
                for (int i7 = 0; i7 < this.f456g.length; i7++) {
                    this.f456g[i7] = this.f449aw.m63a(this.f456g[i7], this.f470y);
                }
                this.f491long = this.f449aw.m61a(this.f449aw.m63a(this.f491long, this.f470y), this.f449aw.getWidth());
                for (int i8 = 0; i8 < this.f467t.length; i8++) {
                    this.f467t[i8] = this.f449aw.m61a(this.f449aw.m63a(this.f467t[i8], this.f470y), this.f449aw.getWidth());
                }
                for (int i9 = 0; i9 < this.f449aw.f383if.length; i9++) {
                    this.f449aw.f383if[i9] = this.f449aw.m63a(this.f449aw.f383if[i9], this.f470y);
                }
            }
            gauge.setValue(40);
            System.gc();
        } catch (Exception e) {
        }
        this.f450ax = new String[]{this.f488for[15], this.f488for[31], this.f488for[6], this.f488for[2], this.f488for[21]};
        this.f465r = new String[]{this.f488for[12], this.f488for[6], this.f488for[20]};
        if (this.f423Q) {
            String str = this.f449aw.f376F ? this.f488for[33] : this.f488for[34];
            this.f450ax = m91a(this.f450ax, str, 1);
            this.f465r = m91a(this.f465r, str, 1);
        }
        if (this.f457h) {
            String str2 = this.f449aw.f477char ? this.f488for[26] : this.f488for[27];
            this.f450ax = m91a(this.f450ax, str2, 1);
            this.f465r = m91a(this.f465r, str2, 1);
        }
        try {
            RecordStore.openRecordStore("s", false).closeRecordStore();
            this.f450ax = m91a(this.f450ax, this.f488for[1], 0);
        } catch (Exception e2) {
        }
        if (this.f435ae != null) {
            this.f450ax = m91a(this.f450ax, this.f488for[39], this.f450ax.length - 1);
        }
        m95if(gauge);
    }

    /* JADX INFO: renamed from: if */
    public void m94if() {
        if (this.f448av == 1) {
            this.f413E = null;
        }
        if (this.f448av == 2) {
            this.f449aw.f377H = 2;
            this.f449aw.repaint();
            this.f449aw.showNotify();
            this.f449aw.f385l = null;
        }
        if (this.f448av == 9) {
            this.f449aw.mo106for();
            this.f449aw.mo24a();
        }
        this.f448av = 0;
    }

    /* JADX INFO: renamed from: if */
    public void m95if(Gauge gauge) {
    }

    /* JADX INFO: renamed from: if */
    public Object[] m96if(String str, Command command) {
        Object[] objArr = new Object[3];
        objArr[0] = str;
        int[] iArr = new int[5];
        iArr[0] = -7;
        iArr[1] = 0;
        iArr[2] = this.f449aw.m60a(str);
        iArr[3] = this.f449aw.getWidth() - (this.f449aw.m60a(str) < (this.f449aw.getWidth() / 7) * 3 ? this.f449aw.m60a(str) : (this.f449aw.getWidth() / 7) * 3);
        iArr[4] = this.f449aw.m60a(str) > (this.f449aw.getWidth() / 7) * 3 ? -1 : 0;
        objArr[1] = iArr;
        objArr[2] = command;
        return objArr;
    }

    /* JADX INFO: renamed from: if */
    public String[] m97if(String[] strArr, String str) {
        int iM80a = m80a(strArr, str);
        return iM80a != -1 ? m90a(strArr, iM80a) : strArr;
    }

    public void pauseApp() {
    }

    public void startApp() {
    }
}
