package p000;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.m3g.Graphics3D;

/* JADX INFO: renamed from: by */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0052by extends GameCanvas {

    /* JADX INFO: renamed from: a */
    private static String f395a = "/content/3d/";

    /* JADX INFO: renamed from: b */
    private static String f396b = "/content/3d/";

    /* JADX INFO: renamed from: a */
    private int f397a;

    /* JADX INFO: renamed from: a */
    private CCMIDlet f398a;

    /* JADX INFO: renamed from: a */
    public boolean f399a;

    /* JADX INFO: renamed from: b */
    private int f400b;

    /* JADX INFO: renamed from: b */
    public boolean f401b;

    public C0052by(CCMIDlet cCMIDlet) {
        super(false);
        this.f398a = cCMIDlet;
        this.f399a = true;
        this.f401b = false;
        C0011ak.m67a();
        C0011ak.f143a = new C0036bi();
        C0011ak.f143a.m139a(C0011ak.f139a);
        C0011ak.f145a = Font.getFont(32, 1, 8);
        setFullScreenMode(true);
    }

    /* JADX INFO: renamed from: a */
    public static int m185a(String str) {
        if (str.equals("c_beach")) {
            return 102;
        }
        if (str.equals("c_beach_village")) {
            return 103;
        }
        if (str.equals("c_hairpin")) {
            return 104;
        }
        if (str.equals("c_mount")) {
            return 105;
        }
        if (str.equals("c_mount_village")) {
            return 106;
        }
        if (str.equals("s_arc")) {
            return 107;
        }
        if (str.equals("s_bend")) {
            return 108;
        }
        if (str.equals("s_downhill")) {
            return 109;
        }
        if (str.equals("s_forest")) {
            return 110;
        }
        if (str.equals("s_harbor_m")) {
            return 111;
        }
        if (str.equals("s_harbor_end")) {
            return 112;
        }
        if (str.equals("s_harbor_start")) {
            return 113;
        }
        if (str.equals("s_jump_jhohn") || str.equals("s_jump")) {
            return 114;
        }
        if (str.equals("s_narrow_01")) {
            return 115;
        }
        if (str.equals("s_narrow_02")) {
            return 116;
        }
        if (str.equals("s_narrow_fountain")) {
            return 117;
        }
        if (str.equals("s_normal")) {
            return 118;
        }
        if (str.equals("s_onhill")) {
            return 119;
        }
        if (str.equals("s_tunnel1")) {
            return 120;
        }
        if (str.equals("s_tunnel2")) {
            return 121;
        }
        if (str.equals("s_uphill")) {
            return 122;
        }
        if (str.equals("s_variation")) {
            return 123;
        }
        if (str.equals("s_village_01")) {
            return 124;
        }
        if (str.equals("s_village_02")) {
            return 125;
        }
        if (str.equals("s_wall_broken")) {
            return 126;
        }
        return str.equals("startziel") ? 127 : -1;
    }

    /* JADX INFO: renamed from: b */
    public static void m186b() {
        C0011ak.f141a.m125b();
    }

    /* JADX INFO: renamed from: c */
    public static void m187c() {
        if (C0011ak.f157b) {
            C0011ak.f142a.m129a();
        }
        C0011ak.m69b();
        C0011ak.f141a.f281a.mo46b();
    }

    /* JADX INFO: renamed from: e */
    private static void m188e() {
        C0089z.m281a(0, new StringBuffer().append(f396b).append("skybox").toString());
        C0089z.m281a(1, new StringBuffer().append(f396b).append("master_car_small").toString());
        C0089z.m281a(2, new StringBuffer().append(f396b).append("master").toString());
        C0089z.m283a(100, new StringBuffer().append(f395a).append("car").toString(), 32000, 1);
        C0089z.m283a(102, new StringBuffer().append(f395a).append("c_beach").toString(), 32000, 2);
        C0089z.m283a(118, new StringBuffer().append(f395a).append("s_normal").toString(), 32000, 2);
        C0089z.m283a(127, new StringBuffer().append(f395a).append("startziel").toString(), 32000, 2);
        C0089z.m283a(103, new StringBuffer().append(f395a).append("c_beach_village").toString(), 32000, 2);
        C0089z.m283a(104, new StringBuffer().append(f395a).append("c_hairpin").toString(), 32000, 2);
        C0089z.m283a(105, new StringBuffer().append(f395a).append("c_mount").toString(), 32000, 2);
        C0089z.m283a(106, new StringBuffer().append(f395a).append("c_mount_village").toString(), 32000, 2);
        C0089z.m283a(107, new StringBuffer().append(f395a).append("s_arc").toString(), 32000, 2);
        C0089z.m283a(108, new StringBuffer().append(f395a).append("s_bend").toString(), 32000, 2);
        C0089z.m283a(109, new StringBuffer().append(f395a).append("s_downhill").toString(), 32000, 2);
        C0089z.m283a(110, new StringBuffer().append(f395a).append("s_forest").toString(), 32000, 2);
        C0089z.m283a(111, new StringBuffer().append(f395a).append("s_harbor").toString(), 32000, 2);
        C0089z.m283a(112, new StringBuffer().append(f395a).append("s_harbor_end").toString(), 32000, 2);
        C0089z.m283a(113, new StringBuffer().append(f395a).append("s_harbor_start").toString(), 32000, 2);
        C0089z.m283a(114, new StringBuffer().append(f395a).append("s_jump").toString(), 32000, 2);
        C0089z.m283a(115, new StringBuffer().append(f395a).append("s_narrow01").toString(), 32000, 2);
        C0089z.m283a(116, new StringBuffer().append(f395a).append("s_narrow02").toString(), 32000, 2);
        C0089z.m283a(117, new StringBuffer().append(f395a).append("s_narrow_fountain").toString(), 32000, 2);
        C0089z.m283a(119, new StringBuffer().append(f395a).append("s_onhill").toString(), 32000, 2);
        C0089z.m283a(120, new StringBuffer().append(f395a).append("s_tunnel01").toString(), 32000, 2);
        C0089z.m283a(121, new StringBuffer().append(f395a).append("s_tunnel02").toString(), 32000, 2);
        C0089z.m283a(122, new StringBuffer().append(f395a).append("s_uphill").toString(), 32000, 2);
        C0089z.m283a(123, new StringBuffer().append(f395a).append("s_variation").toString(), 32000, 2);
        C0089z.m283a(124, new StringBuffer().append(f395a).append("s_village01").toString(), 32000, 2);
        C0089z.m283a(125, new StringBuffer().append(f395a).append("s_village02").toString(), 32000, 2);
        C0089z.m283a(126, new StringBuffer().append(f395a).append("s_wall_broken").toString(), 32000, 2);
        C0089z.m283a(127, new StringBuffer().append(f395a).append("startziel").toString(), 32000, 2);
        C0089z.m282a(101, new StringBuffer().append(f395a).append("skybox").toString(), 0);
    }

    /* JADX INFO: renamed from: a */
    public final synchronized void m189a() {
        if (this.f399a) {
            this.f399a = false;
            flushGraphics();
        } else {
            if (!this.f401b) {
                this.f401b = true;
                C0011ak.f146a = getGraphics();
                C0011ak.f158c = getWidth();
                C0011ak.f160d = getHeight();
                C0011ak.f147a = Graphics3D.getInstance();
                C0011ak.f147a.setViewport(0, 0, C0011ak.f158c, C0011ak.f160d);
                C0011ak.f140a = AbstractC0027b.m120a();
                C0011ak.f149a = new C0086w(C0011ak.f140a);
                C0011ak.f149a.m275b();
                C0011ak.f142a = new C0031bd();
                C0002ab.f10a = C0011ak.f159c;
                C0087x.m277a(C0011ak.f146a, C0011ak.f158c, C0011ak.f160d);
                C0000a.m3a(getWidth(), getHeight());
                C0019as.m86a();
                C0011ak.f146a.setFont(C0011ak.f145a);
                C0011ak.f141a = new C0028ba(this.f398a, this, C0011ak.f158c, C0011ak.f160d, C0011ak.f146a, C0011ak.f143a);
                C0011ak.f153a = new AbstractC0053bz[6];
                C0011ak.f153a[0] = new C0007ag();
                C0011ak.f153a[1] = new C0020at();
                C0011ak.f153a[2] = new C0035bh();
                C0011ak.f153a[5] = new C0088y();
                C0017aq.f201a = C0000a.m6b("/content/interface/soft_scroll.png");
                C0049bv.m177a(C0011ak.f146a);
                C0049bv.m175a("/content/interface/font700.png");
                C0049bv.m175a("/content/interface/font700.png");
                C0049bv.m175a("/content/interface/font700.png");
                C0049bv.m174a(16777215, 0);
                C0049bv.m174a(15538723, 1);
                C0049bv.m174a(11316396, 2);
                C0049bv.m180c(10, 0);
                C0049bv.m180c(10, 1);
                C0049bv.m180c(10, 2);
                C0049bv.m178b(1, 0);
                C0049bv.m178b(1, 1);
                C0049bv.m178b(1, 2);
                m188e();
                C0011ak.f141a.m124a(C0011ak.f153a[5]);
            }
            C0011ak.f141a.m123a(this.f397a);
            flushGraphics();
        }
    }

    /* JADX INFO: renamed from: d */
    public final synchronized void m190d() {
        this.f397a = getKeyStates() | this.f400b;
    }

    public final void hideNotify() {
        C0011ak.f141a.m125b();
    }

    public final void keyPressed(int i) {
        if (C0011ak.f141a.f285a && i == -5) {
            this.f397a = 0;
            C0011ak.f141a.m126c();
            return;
        }
        if (i == -7) {
            this.f400b |= 8192;
        }
        if (i == -6) {
            this.f400b |= 16384;
        }
        if (i == 49) {
            this.f400b |= 32768;
        }
        if (i == 51) {
            this.f400b |= 65536;
        }
        if (i == 48) {
            this.f400b |= 131072;
        }
        if (i == -11) {
            this.f400b |= 262144;
        }
        if (i == -8) {
            this.f400b |= 524288;
        }
    }

    public final void keyReleased(int i) {
        if (i == -7) {
            this.f400b &= -8193;
        }
        if (i == -6) {
            this.f400b &= -16385;
        }
        if (i == 49) {
            this.f400b &= -32769;
        }
        if (i == 51) {
            this.f400b &= -65537;
        }
        if (i == 48) {
            this.f400b &= -131073;
        }
        if (i == -11) {
            this.f400b &= -262145;
        }
        if (i == -8) {
            this.f400b &= -524289;
        }
    }

    public final void keyRepeated(int i) {
        keyPressed(i);
    }

    public final void showNotify() {
    }
}
