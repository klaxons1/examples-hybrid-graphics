package p000;

import javax.microedition.lcdui.Image;

/* JADX INFO: renamed from: at */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0020at extends AbstractC0053bz {

    /* JADX INFO: renamed from: a */
    private static String f233a;

    /* JADX INFO: renamed from: a */
    public static boolean f234a = false;

    /* JADX INFO: renamed from: a */
    private int f235a;

    /* JADX INFO: renamed from: a */
    private long f236a;

    /* JADX INFO: renamed from: a */
    private AbstractC0038bk f237a;

    /* JADX INFO: renamed from: a */
    private C0039bl f238a;

    /* JADX INFO: renamed from: a */
    private AbstractC0048bu f239a;

    /* JADX INFO: renamed from: a */
    private InterfaceC0050bw f240a;

    /* JADX INFO: renamed from: a */
    private C0054c f241a;

    /* JADX INFO: renamed from: a */
    private Image f242a;

    /* JADX INFO: renamed from: b */
    private long f243b;

    /* JADX INFO: renamed from: b */
    private Image f244b;

    /* JADX INFO: renamed from: c */
    private long f246c;

    /* JADX INFO: renamed from: c */
    private boolean f247c;

    /* JADX INFO: renamed from: d */
    private boolean f248d = false;

    /* JADX INFO: renamed from: b */
    public boolean f245b = false;

    /* JADX INFO: renamed from: a */
    public static AbstractC0038bk m92a(C0020at c0020at) {
        return c0020at.f237a;
    }

    /* JADX INFO: renamed from: a */
    public static C0039bl m93a(C0020at c0020at) {
        return c0020at.f238a;
    }

    /* JADX INFO: renamed from: e */
    private void m94e() {
        switch (C0011ak.f156b) {
            case 0:
                C0011ak.f146a.drawImage(this.f242a, C0011ak.f158c >> 1, 5, 17);
                break;
            case 1:
                C0011ak.f146a.drawRegion(this.f242a, 0, 0, this.f242a.getWidth(), this.f242a.getHeight(), 5, (C0011ak.f158c - this.f242a.getHeight()) - 5, (C0011ak.f160d - this.f242a.getWidth()) >> 1, 20);
                break;
            case 2:
                C0011ak.f146a.drawRegion(this.f242a, 0, 0, this.f242a.getWidth(), this.f242a.getHeight(), 6, 5, (C0011ak.f160d - this.f242a.getWidth()) >> 1, 20);
                break;
        }
        switch (C0011ak.f156b) {
            case 0:
                C0011ak.f146a.setColor(8716296);
                C0011ak.f146a.fillRect(0, C0011ak.f160d - 3, C0011ak.f158c, 3);
                C0011ak.f146a.setColor(9837593);
                C0011ak.f146a.fillRect(0, C0011ak.f160d - 19, C0011ak.f158c, 16);
                C0011ak.f146a.setColor(14005684);
                C0011ak.f146a.fillRect(0, C0011ak.f160d - 20, C0011ak.f158c, 1);
                break;
            case 1:
                C0011ak.f146a.setColor(8716296);
                C0011ak.f146a.fillRect(0, 0, 3, C0011ak.f160d);
                C0011ak.f146a.setColor(9837593);
                C0011ak.f146a.fillRect(3, 0, 16, C0011ak.f160d);
                C0011ak.f146a.setColor(14005684);
                C0011ak.f146a.fillRect(19, 0, 1, C0011ak.f160d);
                break;
            case 2:
                C0011ak.f146a.setColor(8716296);
                C0011ak.f146a.fillRect(C0011ak.f158c - 3, 0, 3, C0011ak.f160d);
                C0011ak.f146a.setColor(9837593);
                C0011ak.f146a.fillRect(C0011ak.f158c - 19, 0, 16, C0011ak.f160d);
                C0011ak.f146a.setColor(14005684);
                C0011ak.f146a.fillRect(C0011ak.f158c - 20, 0, 1, C0011ak.f160d);
                break;
        }
        if (this.f238a.f355a == 7) {
            C0049bv.m173a(0);
            switch (C0011ak.f156b) {
                case 0:
                    C0049bv.m176a(new StringBuffer().append("v. ").append(f233a).toString(), C0011ak.f158c - 40, C0011ak.f160d - 18);
                    break;
                case 1:
                    C0049bv.m179b(new StringBuffer().append("v. ").append(f233a).toString(), 8, 8);
                    break;
                case 2:
                    C0049bv.m181c(new StringBuffer().append("v. ").append(f233a).toString(), C0011ak.f158c - 18, 40);
                    break;
            }
        }
        this.f238a.m149b();
        if (this.f248d) {
            C0011ak.f146a.setColor(3959174);
            C0011ak.f146a.fillRect(0, 0, C0011ak.f158c, C0011ak.f160d);
            if (this.f244b != null) {
                C0087x.m278a(this.f244b, 0, 0, 16773120);
            }
        }
    }

    /* JADX INFO: renamed from: f */
    private void m95f() {
        this.f237a.m106b(((int) C0083t.f530a[0]) - (C0006af.m34a(((int) this.f236a) >> 2) >> 4), 250, ((int) C0083t.f530a[2]) - (C0006af.m35b(((int) this.f236a) >> 2) >> 3));
        if (this.f239a != null) {
            C0011ak.f149a.m273a(this.f239a);
        }
        C0011ak.f149a.m273a(C0010aj.f132a);
        C0083t.f529a.m252a(this.f237a, C0011ak.f149a);
        C0011ak.f140a.mo23a(C0011ak.f146a);
        C0011ak.f149a.m271a();
        C0011ak.f140a.mo24b();
    }

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: a */
    public final void mo43a() {
        this.f247c = false;
        f233a = C0011ak.f141a.f279a.getAppProperty("MIDlet-Version");
        this.f248d = false;
        try {
            this.f242a = C0000a.m2a("/content/interface/speed_spirit_logo.png");
            this.f244b = C0000a.m6b("/content/interface/loading_bar.png");
        } catch (Exception e) {
        }
        C0010aj.m65a();
        C0010aj.m66a(false);
        C0083t.m264a();
        C0083t.m265a("/content/level/1.wb1");
        this.f237a = AbstractC0038bk.m141a(C0011ak.f158c, C0011ak.f160d, 796, 5, 8192);
        C0010aj.f132a.m106b(((int) C0083t.f530a[0]) - 30, (int) C0083t.f530a[1], (int) C0083t.f530a[2]);
        C0010aj.f132a.m110d(0, 2048, 0);
        this.f237a.m102a(((AbstractC0023aw) C0010aj.f132a).f257a);
        this.f237a.m100a(0, 150, -500);
        this.f237a.m110d(0, 2048, 0);
        this.f241a = new C0054c("cameraScene");
        this.f241a.m19a(this.f237a);
        this.f240a = new C0084u(C0010aj.f137b, this.f237a);
        this.f241a.m191a(this.f240a);
        C0011ak.f149a.m274a(this.f237a);
        this.f239a = C0089z.m279a(101);
        this.f238a = new C0039bl();
        C0009ai c0009ai = new C0009ai();
        C0009ai c0009ai2 = new C0009ai();
        C0009ai c0009ai3 = new C0009ai();
        C0009ai c0009ai4 = new C0009ai();
        C0009ai c0009ai5 = new C0009ai();
        C0009ai c0009ai6 = new C0009ai();
        C0009ai c0009ai7 = new C0009ai();
        C0009ai c0009ai8 = new C0009ai();
        C0009ai c0009ai9 = new C0009ai();
        C0009ai c0009ai10 = new C0009ai();
        C0009ai c0009ai11 = new C0009ai();
        C0009ai c0009ai12 = new C0009ai();
        C0009ai c0009ai13 = new C0009ai();
        C0009ai c0009ai14 = new C0009ai();
        C0009ai c0009ai15 = new C0009ai();
        c0009ai.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_back.png", 0, C0011ak.f160d - 18, (short) 0, new C0068e(this.f238a, 13)));
        c0009ai.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_play.png", C0011ak.f158c - 16, C0011ak.f160d - 18, (short) 2, null));
        C0029bb c0029bb = new C0029bb(25, C0000a.m0a(15), C0011ak.f158c, C0011ak.f160d, C0011ak.f146a);
        c0029bb.m207a(new C0042bo(C0011ak.f143a, 4, C0011ak.f146a, new C0068e(this.f238a, 13)));
        c0029bb.m207a(new C0042bo(C0011ak.f143a, 22, C0011ak.f146a, new C0068e(this.f238a, 7)));
        c0029bb.m207a(new C0042bo(C0011ak.f143a, 3, C0011ak.f146a, new C0068e(this.f238a, 3)));
        c0029bb.m207a(new C0042bo(C0011ak.f143a, 2, C0011ak.f146a, new C0068e(this.f238a, 2)));
        c0029bb.m207a(new C0042bo(C0011ak.f143a, 0, C0011ak.f146a, new C0068e(this.f238a, 1)));
        c0009ai.m56a(c0029bb);
        c0009ai13.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_back.png", 0, C0011ak.f160d - 18, (short) 0, new C0068e(this.f238a, 0)));
        c0009ai13.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_play.png", C0011ak.f158c - 16, C0011ak.f160d - 18, (short) 2, null));
        C0029bb c0029bb2 = new C0029bb(25, C0000a.m0a(15), C0011ak.f158c, C0011ak.f160d, C0011ak.f146a);
        c0029bb2.m207a(new C0042bo(C0011ak.f143a, 54, C0011ak.f146a, new C0001aa(this)));
        c0029bb2.m207a(new C0042bo(C0011ak.f143a, 55, C0011ak.f146a, new C0068e(this.f238a, 0)));
        c0029bb2.m207a(new C0042bo(C0011ak.f143a, 56, C0011ak.f146a, new C0060cf()));
        c0009ai13.m56a(c0029bb2);
        c0009ai2.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_back.png", 0, C0011ak.f160d - 18, (short) 0, new C0068e(this.f238a, 0)));
        c0009ai2.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_play.png", C0011ak.f158c - 16, C0011ak.f160d - 18, (short) 2, null));
        C0029bb c0029bb3 = new C0029bb(25, C0000a.m0a(15), C0011ak.f158c, C0011ak.f160d, C0011ak.f146a);
        c0029bb3.m207a(new C0032be(C0011ak.f143a.m138a(10), C0019as.m85a(C0011ak.f152a[5]), C0000a.m0a(15), C0011ak.f146a, new C0030bc(this, 5)));
        c0029bb3.m207a(new C0032be(C0011ak.f143a.m138a(9), C0019as.m85a(C0011ak.f152a[4]), C0000a.m0a(15), C0011ak.f146a, new C0030bc(this, 4)));
        c0029bb3.m207a(new C0032be(C0011ak.f143a.m138a(8), C0019as.m85a(C0011ak.f152a[3]), C0000a.m0a(15), C0011ak.f146a, new C0030bc(this, 3)));
        c0029bb3.m207a(new C0032be(C0011ak.f143a.m138a(7), C0019as.m85a(C0011ak.f152a[2]), C0000a.m0a(15), C0011ak.f146a, new C0030bc(this, 2)));
        c0029bb3.m207a(new C0032be(C0011ak.f143a.m138a(6), C0019as.m85a(C0011ak.f152a[1]), C0000a.m0a(15), C0011ak.f146a, new C0030bc(this, 1)));
        c0029bb3.m207a(new C0032be(C0011ak.f143a.m138a(5), C0019as.m85a(C0011ak.f152a[0]), C0000a.m0a(15), C0011ak.f146a, new C0030bc(this, 0)));
        c0009ai2.m56a(c0029bb3);
        c0009ai3.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_back.png", 0, C0011ak.f160d - 18, (short) 0, new C0068e(this.f238a, 0)));
        c0009ai3.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_play.png", C0011ak.f158c - 16, C0011ak.f160d - 18, (short) 2, null));
        C0029bb c0029bb4 = new C0029bb(25, C0000a.m0a(15), C0011ak.f158c, C0011ak.f160d, C0011ak.f146a);
        c0029bb4.m207a(new C0042bo(C0011ak.f143a, 13, C0011ak.f146a, new C0068e(this.f238a, 9)));
        if (C0011ak.f159c) {
            c0029bb4.m207a(new C0037bj(C0011ak.f143a, 14, 15, C0011ak.f146a, new C0079p(this)));
        } else {
            c0029bb4.m207a(new C0037bj(C0011ak.f143a, 15, 14, C0011ak.f146a, new C0079p(this)));
        }
        if (C0011ak.f157b) {
            c0029bb4.m207a(new C0037bj(C0011ak.f143a, 11, 12, C0011ak.f146a, new C0044bq(this)));
        } else {
            c0029bb4.m207a(new C0037bj(C0011ak.f143a, 12, 11, C0011ak.f146a, new C0044bq(this)));
        }
        c0029bb4.m207a(new C0042bo(C0011ak.f143a, 48, C0011ak.f146a, new C0068e(this.f238a, 10)));
        c0009ai3.m56a(c0029bb4);
        c0009ai4.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_back.png", 0, C0011ak.f160d - 18, (short) 0, new C0068e(this.f238a, 0)));
        c0009ai4.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_play.png", C0011ak.f158c - 16, C0011ak.f160d - 18, (short) 2, null));
        C0029bb c0029bb5 = new C0029bb(25, C0000a.m0a(15), C0011ak.f158c, C0011ak.f160d, C0011ak.f146a);
        c0029bb5.m207a(new C0042bo(C0011ak.f143a, 18, C0011ak.f146a, new C0026az(this)));
        c0029bb5.m207a(new C0042bo(C0011ak.f143a, 16, C0011ak.f146a, new C0068e(this.f238a, 4)));
        c0009ai4.m56a(c0029bb5);
        c0009ai5.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_back.png", 0, C0011ak.f160d - 18, (short) 0, new C0068e(this.f238a, 3)));
        c0009ai5.m56a(new C0017aq(C0011ak.f146a, C0011ak.f143a, 17, C0000a.m0a(12), C0000a.m5b(70), C0000a.m5b(40), C0011ak.f158c, C0011ak.f160d));
        c0009ai6.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_back.png", 0, C0011ak.f160d - 18, (short) 0, new C0068e(this.f238a, 3)));
        c0009ai6.m56a(new C0017aq(C0011ak.f146a, C0011ak.f143a, 19, C0000a.m0a(12), C0000a.m5b(70), C0000a.m5b(40), C0011ak.f158c, C0011ak.f160d));
        c0009ai7.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_back.png", 0, C0011ak.f160d - 18, (short) 0, new C0068e(this.f238a, 3)));
        c0009ai7.m56a(new C0017aq(C0011ak.f146a, C0011ak.f143a, 52, C0000a.m0a(12), C0000a.m5b(70), C0000a.m5b(40), C0011ak.f158c, C0011ak.f160d));
        c0009ai8.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_back.png", 0, C0011ak.f160d - 18, (short) 0, new C0068e(this.f238a, 3)));
        c0009ai8.m56a(new C0017aq(C0011ak.f146a, C0011ak.f143a, 53, C0000a.m0a(12), C0000a.m5b(70), C0000a.m5b(40), C0011ak.f158c, C0011ak.f160d));
        c0009ai9.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_back.png", 0, C0011ak.f160d - 18, (short) 0, new C0068e(this.f238a, 3)));
        c0009ai9.m56a(new C0017aq(C0011ak.f146a, C0011ak.f143a, 21, C0000a.m0a(12), C0000a.m5b(70), C0000a.m5b(40), C0011ak.f158c, C0011ak.f160d));
        c0009ai10.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_back.png", 0, C0011ak.f160d - 18, (short) 0, new C0068e(this.f238a, 0)));
        c0009ai10.m56a(new C0017aq(C0011ak.f146a, C0011ak.f143a, 23, C0000a.m0a(12), C0000a.m5b(70), C0000a.m5b(40), C0011ak.f158c, C0011ak.f160d));
        c0009ai11.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_back.png", 0, C0011ak.f160d - 18, (short) 0, new C0068e(this.f238a, 0)));
        c0009ai11.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_play.png", C0011ak.f158c - 16, C0011ak.f160d - 18, (short) 2, new C0072i(this)));
        c0009ai11.m56a(new C0017aq(C0011ak.f146a, C0011ak.f143a, 27, C0000a.m0a(12), C0000a.m5b(70), C0000a.m5b(40), C0011ak.f158c, C0011ak.f160d));
        c0009ai12.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_back.png", 0, C0011ak.f160d - 18, (short) 0, new C0068e(this.f238a, 2)));
        c0009ai12.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_play.png", C0011ak.f158c - 16, C0011ak.f160d - 18, (short) 2, null));
        C0029bb c0029bb6 = new C0029bb(25, C0000a.m0a(15), C0011ak.f158c, C0011ak.f160d, C0011ak.f146a);
        c0029bb6.m207a(new C0042bo("Türkçe", C0011ak.f146a, new C0055ca(this, 5)));
        c0029bb6.m207a(new C0042bo("Español", C0011ak.f146a, new C0055ca(this, 4)));
        c0029bb6.m207a(new C0042bo("Italiano", C0011ak.f146a, new C0055ca(this, 3)));
        c0029bb6.m207a(new C0042bo("Français", C0011ak.f146a, new C0055ca(this, 2)));
        c0029bb6.m207a(new C0042bo("Deutsch", C0011ak.f146a, new C0055ca(this, 0)));
        c0029bb6.m207a(new C0042bo("English", C0011ak.f146a, new C0055ca(this, 1)));
        c0009ai12.m56a(c0029bb6);
        c0009ai14.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_back.png", 0, C0011ak.f160d - 18, (short) 0, new C0068e(this.f238a, 2)));
        c0009ai14.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_play.png", C0011ak.f158c - 16, C0011ak.f160d - 18, (short) 2, null));
        C0029bb c0029bb7 = new C0029bb(25, C0000a.m0a(15), C0011ak.f158c, C0011ak.f160d, C0011ak.f146a);
        c0029bb7.m207a(new C0042bo(C0011ak.f143a, 50, C0011ak.f146a, new C0033bf(this, (short) 2)));
        c0029bb7.m207a(new C0042bo(C0011ak.f143a, 49, C0011ak.f146a, new C0033bf(this, (short) 1)));
        c0029bb7.m207a(new C0042bo(C0011ak.f143a, 51, C0011ak.f146a, new C0033bf(this, (short) 0)));
        c0009ai14.m56a(c0029bb7);
        C0029bb c0029bb8 = new C0029bb(25, C0000a.m0a(15), C0011ak.f158c, C0011ak.f160d, C0011ak.f146a);
        c0029bb8.m207a(new C0042bo("Türkçe", C0011ak.f146a, new C0055ca(this, 5)));
        c0029bb8.m207a(new C0042bo("Español", C0011ak.f146a, new C0055ca(this, 4)));
        c0029bb8.m207a(new C0042bo("Italiano", C0011ak.f146a, new C0055ca(this, 3)));
        c0029bb8.m207a(new C0042bo("Français", C0011ak.f146a, new C0055ca(this, 2)));
        c0029bb8.m207a(new C0042bo("Deutsch", C0011ak.f146a, new C0055ca(this, 0)));
        c0029bb8.m207a(new C0042bo("English", C0011ak.f146a, new C0055ca(this, 1)));
        c0009ai15.m56a(c0029bb8);
        this.f238a.m147a(c0009ai);
        this.f238a.m147a(c0009ai2);
        this.f238a.m147a(c0009ai3);
        this.f238a.m147a(c0009ai4);
        this.f238a.m147a(c0009ai5);
        this.f238a.m147a(c0009ai6);
        this.f238a.m147a(c0009ai9);
        this.f238a.m147a(c0009ai10);
        this.f238a.m147a(c0009ai11);
        this.f238a.m147a(c0009ai12);
        this.f238a.m147a(c0009ai14);
        this.f238a.m147a(c0009ai7);
        this.f238a.m147a(c0009ai8);
        this.f238a.m147a(c0009ai13);
        this.f238a.m145a();
        if (f234a) {
            this.f238a.m150b(8);
        }
        if (C0011ak.f161d) {
            this.f238a.m150b(9);
        }
        f234a = false;
        this.f235a = 0;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f243b = jCurrentTimeMillis;
        this.f236a = jCurrentTimeMillis;
        this.f247c = true;
    }

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: a */
    public final void mo44a(int i) {
        if (this.f247c) {
            this.f243b = this.f236a;
            this.f236a = System.currentTimeMillis();
            this.f246c = this.f236a - this.f243b;
            this.f235a = (int) (((long) this.f235a) - this.f246c);
            if (this.f245b) {
                this.f243b = this.f236a;
                return;
            }
            int i2 = this.f238a.f355a;
            if (this.f235a < 0 && (C0011ak.f165h & i) != 0) {
                this.f235a = 200;
                this.f238a.m152d();
            }
            if (this.f235a < 0 && (C0011ak.f163f & i) != 0) {
                this.f235a = 200;
                this.f238a.m151c();
            }
            if (this.f235a < 0 && (i & 256) != 0) {
                this.f235a = 200;
                if (i2 == 1) {
                    this.f248d = true;
                    C0011ak.f146a.setColor(3959174);
                    C0011ak.f146a.fillRect(0, 0, C0011ak.f158c, C0011ak.f160d);
                    if (this.f244b != null) {
                        C0087x.m278a(this.f244b, 0, 0, 16773120);
                    }
                    C0011ak.f141a.f279a.canvas.flushGraphics();
                }
                this.f238a.m153e();
            }
            if (this.f235a < 0 && (i & 16384) != 0) {
                this.f235a = 200;
                if (C0011ak.f161d && i2 == 9) {
                    C0011ak.f141a.m122a();
                    return;
                }
                this.f238a.m148a((short) 0);
            }
            if (this.f235a < 0 && (i & 8192) != 0) {
                this.f235a = 200;
                if (i2 == 8) {
                    this.f238a.m148a((short) 2);
                } else {
                    this.f238a.m153e();
                }
            }
            C0011ak.f146a.setColor(3959174);
            C0011ak.f146a.fillRect(0, 0, C0011ak.f158c, C0011ak.f160d);
            m95f();
            m94e();
        }
    }

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: a */
    public final boolean mo45a() {
        return this.f247c;
    }

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: b */
    public final void mo46b() {
        C0010aj.m65a();
        C0083t.m264a();
        this.f240a = null;
        this.f241a = null;
        this.f239a = null;
        this.f237a = null;
        this.f238a = null;
        this.f242a = null;
        if (this.f244b != null) {
            this.f244b = null;
        }
        System.gc();
        this.f247c = false;
    }

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: c */
    public final void mo47c() {
        this.f245b = true;
        if (C0011ak.f157b) {
            C0011ak.f142a.m131b();
        }
    }

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: d */
    public final void mo48d() {
        this.f245b = false;
        this.f235a = 1800;
        if (C0011ak.f157b) {
            C0011ak.f142a.m132c();
        }
    }
}
