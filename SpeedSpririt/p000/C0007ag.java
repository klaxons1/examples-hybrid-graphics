package p000;

import javax.microedition.lcdui.Image;
import javax.microedition.m3g.Transform;

/* JADX INFO: renamed from: ag */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0007ag extends AbstractC0053bz {

    /* JADX INFO: renamed from: a */
    private float f34a;

    /* JADX INFO: renamed from: a */
    public int f35a;

    /* JADX INFO: renamed from: a */
    private long f36a;

    /* JADX INFO: renamed from: a */
    private C0005ae f37a;

    /* JADX INFO: renamed from: a */
    private C0034bg f38a;

    /* JADX INFO: renamed from: a */
    private AbstractC0038bk f39a;

    /* JADX INFO: renamed from: a */
    private C0039bl f40a;

    /* JADX INFO: renamed from: a */
    private AbstractC0048bu f41a;

    /* JADX INFO: renamed from: a */
    private C0054c f42a;

    /* JADX INFO: renamed from: a */
    private C0071h f43a;

    /* JADX INFO: renamed from: a */
    private String f44a;

    /* JADX INFO: renamed from: a */
    private Image f45a;

    /* JADX INFO: renamed from: a */
    private C0084u f46a;

    /* JADX INFO: renamed from: a */
    private boolean f47a;

    /* JADX INFO: renamed from: a */
    private C0008ah[] f49a;

    /* JADX INFO: renamed from: a */
    private Image[] f50a;

    /* JADX INFO: renamed from: b */
    private int f51b;

    /* JADX INFO: renamed from: b */
    private long f52b;

    /* JADX INFO: renamed from: b */
    private AbstractC0038bk f53b;

    /* JADX INFO: renamed from: b */
    private Image f54b;

    /* JADX INFO: renamed from: b */
    private boolean f55b;

    /* JADX INFO: renamed from: c */
    private int f56c;

    /* JADX INFO: renamed from: c */
    private long f57c;

    /* JADX INFO: renamed from: c */
    private Image f58c;

    /* JADX INFO: renamed from: c */
    private boolean f59c;

    /* JADX INFO: renamed from: d */
    private int f60d;

    /* JADX INFO: renamed from: d */
    private long f61d;

    /* JADX INFO: renamed from: d */
    private Image f62d;

    /* JADX INFO: renamed from: d */
    private boolean f63d;

    /* JADX INFO: renamed from: e */
    private int f64e;

    /* JADX INFO: renamed from: e */
    private long f65e;

    /* JADX INFO: renamed from: e */
    private Image f66e;

    /* JADX INFO: renamed from: f */
    private int f67f;

    /* JADX INFO: renamed from: f */
    private long f68f;

    /* JADX INFO: renamed from: f */
    private Image f69f;

    /* JADX INFO: renamed from: g */
    private int f70g;

    /* JADX INFO: renamed from: g */
    private long f71g;

    /* JADX INFO: renamed from: g */
    private Image f72g;

    /* JADX INFO: renamed from: h */
    private int f73h;

    /* JADX INFO: renamed from: h */
    private long f74h;

    /* JADX INFO: renamed from: i */
    private int f75i;

    /* JADX INFO: renamed from: i */
    private long f76i;

    /* JADX INFO: renamed from: j */
    private long f77j;

    /* JADX INFO: renamed from: k */
    private long f78k;

    /* JADX INFO: renamed from: l */
    private long f79l;

    /* JADX INFO: renamed from: a */
    private float[] f48a = null;

    /* JADX INFO: renamed from: m */
    private long f80m = 0;

    public C0007ag() {
        this.f75i = 10;
        this.f75i = 10;
    }

    /* JADX INFO: renamed from: a */
    private static void m36a(Image image, int i, int i2, int i3) {
        switch (C0011ak.f156b) {
            case 0:
                C0011ak.f146a.drawImage(image, i, i2, i3);
                break;
            case 1:
                C0011ak.f146a.drawRegion(image, 0, 0, image.getWidth(), image.getHeight(), 5, i, i2, i3);
                break;
            case 2:
                C0011ak.f146a.drawRegion(image, 0, 0, image.getWidth(), image.getHeight(), 6, i, i2, i3);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    public static boolean m37a(C0007ag c0007ag) {
        return c0007ag.f55b;
    }

    /* JADX INFO: renamed from: a */
    public static boolean m38a(C0007ag c0007ag, boolean z) {
        c0007ag.f55b = z;
        return z;
    }

    /* JADX INFO: renamed from: e */
    private void m39e() {
        this.f48a = new float[12];
        new Transform();
        new C0005ae();
        this.f49a = new C0008ah[1];
        this.f49a[0] = new C0008ah(250L, 300000L);
        this.f49a[0].m50a((byte[]) null);
        this.f49a[0].m51a(C0010aj.f131a.m14a(this.f48a));
        this.f68f = 0L;
        this.f71g = 3000L;
    }

    /* JADX INFO: renamed from: f */
    private void m40f() {
        this.f48a = this.f49a[0].m53a(this.f48a, this.f68f);
        if (this.f48a[10] != -10000.0f) {
            ((AbstractC0023aw) C0010aj.f132a).f257a.m233a((int) (this.f48a[0] * 4096.0f), (int) (this.f48a[3] * 4096.0f), (int) (this.f48a[6] * 4096.0f), (int) this.f48a[9], -((int) (this.f48a[1] * 4096.0f)), -((int) (this.f48a[4] * 4096.0f)), -((int) (this.f48a[7] * 4096.0f)), -((int) this.f48a[10]), -((int) (this.f48a[2] * 4096.0f)), -((int) (this.f48a[5] * 4096.0f)), -((int) (this.f48a[8] * 4096.0f)), -((int) this.f48a[11]));
            C0010aj.f132a.m100a(0, 0, 0);
            C0010aj.f132a.mo21a(false);
            C0011ak.f149a.m274a(this.f39a);
            this.f37a = C0010aj.f134a.m105b(this.f37a);
            this.f39a = C0083t.m262a(this.f37a.f30a, this.f37a.f32c);
        }
        this.f68f += this.f57c;
        if (this.f68f > this.f61d) {
            this.f68f = 0L;
            this.f49a[0].m49a();
        }
    }

    /* JADX INFO: renamed from: g */
    private void m41g() {
        if (this.f41a != null) {
            C0011ak.f149a.m273a(this.f41a);
        }
        C0083t.f529a.m252a(this.f39a, C0011ak.f149a);
        C0011ak.f149a.m273a(C0010aj.f132a);
        C0011ak.f140a.mo23a(C0011ak.f146a);
        C0011ak.f149a.m271a();
        C0011ak.f140a.mo24b();
        if (this.f63d && this.f35a == 0) {
            C0057cc.m197d();
        }
        this.f37a = C0010aj.f132a.m97a();
        if (this.f35a == 0) {
            this.f56c = (int) (((long) this.f56c) + this.f57c);
            this.f51b--;
            if (this.f51b < 0) {
                this.f51b = 4;
                this.f60d -= this.f37a.f30a;
                this.f64e -= this.f37a.f32c;
                this.f34a = ((float) Math.sqrt((this.f60d * this.f60d) + (this.f64e * this.f64e))) / this.f56c;
                this.f60d = this.f37a.f30a;
                this.f64e = this.f37a.f32c;
                this.f56c = 0;
            }
        }
    }

    /* JADX INFO: renamed from: h */
    private void m42h() {
        if (this.f35a == 0) {
            C0019as.m88a(this.f38a.m134a(), this.f38a.f322a);
            if (this.f76i - this.f61d > 0) {
                C0019as.m89a(this.f76i - this.f61d);
            } else {
                if ((this.f61d - this.f76i) % 1000 < 500) {
                    C0011ak.f146a.setColor(220, 0, 0);
                    switch (C0011ak.f156b) {
                        case 0:
                            C0011ak.f146a.fillRect(C0011ak.f158c - 86, 17, 83, 13);
                            break;
                        case 1:
                            C0011ak.f146a.fillRect(((C0011ak.f158c - 17) - 13) - 1, (C0011ak.f160d - 83) - 3, 13, 83);
                            break;
                        case 2:
                            C0011ak.f146a.fillRect(16, 2, 13, 83);
                            break;
                    }
                }
                C0019as.m89a(0L);
            }
            C0019as.m87a((int) (this.f34a * 40.0f));
        } else if (this.f35a != 2) {
            if (this.f78k < 0) {
                C0049bv.m173a(1);
                switch (C0011ak.f156b) {
                    case 0:
                        C0049bv.m176a("REPLAY", C0011ak.f158c - 50, 10);
                        break;
                    case 1:
                        C0049bv.m179b("REPLAY", C0011ak.f158c - 20, 10);
                        break;
                    case 2:
                        C0049bv.m181c("REPLAY", 10, 54);
                        break;
                }
            }
            if (this.f78k < -500) {
                this.f78k = 500L;
            }
            this.f78k -= this.f57c;
        } else if (!this.f55b) {
            C0019as.m91a(this.f76i, this.f61d);
        }
        if (!this.f59c) {
            this.f77j -= this.f57c;
            if (this.f77j > 3000) {
                this.f69f = this.f50a[3];
            } else if (this.f77j > 2000) {
                this.f69f = this.f50a[2];
            } else if (this.f77j > 1000) {
                this.f69f = this.f50a[1];
            } else if (this.f77j > 0) {
                this.f69f = this.f50a[0];
            }
            if (this.f77j > 0) {
                switch (C0011ak.f156b) {
                    case 0:
                        C0011ak.f146a.drawImage(this.f69f, (C0011ak.f158c - this.f69f.getWidth()) >> 1, (C0011ak.f160d - this.f69f.getHeight()) >> 1, 20);
                        break;
                    case 1:
                        C0011ak.f146a.drawRegion(this.f69f, 0, 0, this.f69f.getWidth(), this.f69f.getHeight(), 5, (C0011ak.f158c - this.f69f.getHeight()) >> 1, (C0011ak.f160d - this.f69f.getWidth()) >> 1, 20);
                        break;
                    case 2:
                        C0011ak.f146a.drawRegion(this.f69f, 0, 0, this.f69f.getWidth(), this.f69f.getHeight(), 6, (C0011ak.f158c - this.f69f.getHeight()) >> 1, (C0011ak.f160d - this.f69f.getWidth()) >> 1, 20);
                        break;
                }
            }
        }
        if (!this.f55b) {
            if (this.f38a.m136a()) {
                if (this.f35a == 1) {
                    m36a(this.f62d, C0011ak.f158c - 16, C0011ak.f160d - 18, 20);
                } else {
                    m36a(this.f58c, C0011ak.f158c - 16, C0011ak.f160d - 18, 20);
                }
                m36a(this.f54b, 0, C0011ak.f160d - 18, 20);
            } else if (this.f59c) {
                if (this.f78k < 0) {
                    m36a(this.f58c, C0011ak.f158c - 16, C0011ak.f160d - 18, 20);
                }
                m36a(this.f45a, 0, C0011ak.f160d - 18, 20);
            } else if (this.f77j < 0) {
                m36a(this.f54b, 0, C0011ak.f160d - 18, 20);
            }
        }
        this.f78k -= this.f57c;
        if (this.f78k < -500) {
            this.f78k = 500L;
        }
        if (this.f38a.m136a() && this.f71g > 0) {
            this.f78k -= this.f57c;
            if (this.f78k < 0) {
                switch (C0011ak.f156b) {
                    case 0:
                        C0011ak.f146a.drawImage(this.f66e, (C0011ak.f158c - this.f66e.getWidth()) >> 1, (C0011ak.f160d - this.f66e.getHeight()) >> 1, 20);
                        break;
                    case 1:
                        C0011ak.f146a.drawRegion(this.f66e, 0, 0, this.f66e.getWidth(), this.f66e.getHeight(), 5, (C0011ak.f158c - this.f66e.getHeight()) >> 1, (C0011ak.f160d - this.f66e.getWidth()) >> 1, 20);
                        break;
                    case 2:
                        C0011ak.f146a.drawRegion(this.f66e, 0, 0, this.f66e.getWidth(), this.f66e.getHeight(), 6, (C0011ak.f158c - this.f66e.getHeight()) >> 1, (C0011ak.f160d - this.f66e.getWidth()) >> 1, 20);
                        break;
                }
            }
            if (this.f78k < -500) {
                this.f78k = 500L;
            }
        }
        if (this.f67f > 0) {
            this.f67f = (int) (((long) this.f67f) - this.f57c);
            C0049bv.m173a(0);
            switch (C0011ak.f156b) {
                case 0:
                    C0049bv.m176a(this.f44a, (C0011ak.f158c - this.f70g) - 3, 30);
                    break;
                case 1:
                    C0049bv.m179b(this.f44a, (C0011ak.f158c - 30) - this.f73h, (C0011ak.f160d - this.f70g) - 5);
                    break;
                case 2:
                    C0049bv.m181c(this.f44a, 30, this.f70g + 5);
                    break;
            }
        }
        if (this.f55b) {
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
            this.f40a.m149b();
        }
    }

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: a */
    public final void mo43a() {
        this.f75i--;
        RunnableC0078o.f518a = this.f75i;
        switch (this.f75i) {
            case 3:
                this.f40a = new C0039bl();
                C0009ai c0009ai = new C0009ai();
                C0009ai c0009ai2 = new C0009ai();
                c0009ai.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_back.png", 0, C0011ak.f160d - 18, (short) 0, new C0070g(this)));
                c0009ai.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_play.png", C0011ak.f158c - 16, C0011ak.f160d - 18, (short) 2, null));
                C0029bb c0029bb = new C0029bb(25, C0000a.m0a(15), C0011ak.f158c, C0011ak.f160d, C0011ak.f146a);
                c0029bb.m207a(new C0042bo(C0011ak.f143a, 4, C0011ak.f146a, new C0068e(this.f40a, 1)));
                if (C0011ak.f159c) {
                    c0029bb.m207a(new C0037bj(C0011ak.f143a, 14, 15, C0011ak.f146a, new C0040bm(this)));
                } else {
                    c0029bb.m207a(new C0037bj(C0011ak.f143a, 15, 14, C0011ak.f146a, new C0040bm(this)));
                }
                if (C0011ak.f157b) {
                    c0029bb.m207a(new C0037bj(C0011ak.f143a, 11, 12, C0011ak.f146a, new C0045br(this)));
                } else {
                    c0029bb.m207a(new C0037bj(C0011ak.f143a, 12, 11, C0011ak.f146a, new C0045br(this)));
                }
                c0029bb.m207a(new C0042bo(C0011ak.f143a, 57, C0011ak.f146a, new C0021au(this)));
                c0029bb.m207a(new C0042bo(C0011ak.f143a, 58, C0011ak.f146a, new C0070g(this)));
                c0009ai.m56a(c0029bb);
                c0009ai2.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_back.png", 0, C0011ak.f160d - 18, (short) 0, new C0068e(this.f40a, 0)));
                c0009ai2.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_play.png", C0011ak.f158c - 16, C0011ak.f160d - 18, (short) 2, null));
                C0029bb c0029bb2 = new C0029bb(25, C0000a.m0a(15), C0011ak.f158c, C0011ak.f160d, C0011ak.f146a);
                c0029bb2.m207a(new C0042bo(C0011ak.f143a, 54, C0011ak.f146a, new C0061cg(this)));
                c0029bb2.m207a(new C0042bo(C0011ak.f143a, 55, C0011ak.f146a, new C0068e(this.f40a, 0)));
                c0029bb2.m207a(new C0042bo(C0011ak.f143a, 56, C0011ak.f146a, new C0060cf()));
                c0009ai2.m56a(c0029bb2);
                this.f40a.m147a(c0009ai);
                this.f40a.m147a(c0009ai2);
                this.f40a.m145a();
                System.gc();
                this.f47a = true;
                break;
            case 4:
                this.f43a = new C0071h();
                this.f43a.f480a = C0083t.f529a;
                C0010aj.f131a.m13a(this.f43a);
                this.f43a.m221a();
                if (C0083t.f530a != null) {
                    C0010aj.f131a.m11a((int) C0083t.f530a[0], ((int) C0083t.f530a[1]) + 50, (int) C0083t.f530a[2], -((int) ((C0083t.f530a[3] / 360.0f) * 4096.0f)));
                } else {
                    C0010aj.f131a.m11a(-7572, 400, -8358, 1024);
                }
                this.f39a.mo21a(true);
                m39e();
                System.gc();
                break;
            case 5:
                AbstractC0038bk abstractC0038bkM141a = AbstractC0038bk.m141a(C0011ak.f158c, C0011ak.f160d, 796, 5, 8192);
                this.f39a = abstractC0038bkM141a;
                this.f53b = abstractC0038bkM141a;
                this.f42a = new C0054c("cameraScene");
                this.f42a.m19a(this.f39a);
                this.f46a = new C0084u(C0010aj.f137b, this.f39a);
                this.f42a.m191a(this.f46a);
                this.f39a.m106b((int) C0083t.f530a[0], ((int) C0083t.f530a[1]) + 100, (int) C0083t.f530a[2]);
                C0011ak.f149a.m274a(this.f39a);
                this.f41a = C0089z.m279a(101);
                System.gc();
                break;
            case 6:
                this.f37a = new C0005ae();
                this.f50a = new Image[4];
                try {
                    this.f50a[0] = C0000a.m6b("/content/interface/countdown_go.png");
                    this.f50a[1] = C0000a.m6b("/content/interface/countdown1.png");
                    this.f50a[2] = C0000a.m6b("/content/interface/countdown2.png");
                    this.f50a[3] = C0000a.m6b("/content/interface/countdown3.png");
                    this.f45a = C0000a.m6b("/content/interface/soft_back.png");
                    this.f54b = C0000a.m6b("/content/interface/soft_pause.png");
                    this.f58c = C0000a.m6b("/content/interface/soft_play.png");
                    this.f62d = C0000a.m6b("/content/interface/soft_stop.png");
                    C0000a.m6b("/content/interface/soft_retry.png");
                    this.f66e = C0000a.m6b("/content/interface/flagge.png");
                    this.f72g = C0000a.m6b("/content/interface/loading_bar.png");
                    break;
                } catch (Exception e) {
                }
                System.gc();
                break;
            case 7:
                switch (C0011ak.f154b) {
                    case 0:
                        C0083t.m265a("/content/level/1.wb1");
                        this.f38a = new C0034bg(C0083t.f531a, 1);
                        this.f76i = 62000L;
                        this.f44a = C0011ak.f143a.m138a(5);
                        this.f44a = this.f44a.toUpperCase();
                        this.f70g = C0049bv.m171a(this.f44a);
                        this.f73h = C0049bv.m169a();
                        break;
                    case 1:
                        C0083t.m265a("/content/level/2.wb1");
                        this.f38a = new C0034bg(C0083t.f531a, 1);
                        this.f76i = 80000L;
                        this.f44a = C0011ak.f143a.m138a(6);
                        this.f44a = this.f44a.toUpperCase();
                        this.f70g = C0049bv.m171a(this.f44a);
                        this.f73h = C0049bv.m169a();
                        break;
                    case 2:
                        C0083t.m265a("/content/level/3.wb1");
                        this.f38a = new C0034bg(C0083t.f531a, 1);
                        this.f76i = 91000L;
                        this.f44a = C0011ak.f143a.m138a(7);
                        this.f44a = this.f44a.toUpperCase();
                        this.f70g = C0049bv.m171a(this.f44a);
                        this.f73h = C0049bv.m169a();
                        break;
                    case 3:
                        C0083t.m265a("/content/level/4.wb1");
                        this.f38a = new C0034bg(C0083t.f531a, 2);
                        this.f76i = 175000L;
                        this.f44a = C0011ak.f143a.m138a(8);
                        this.f44a = this.f44a.toUpperCase();
                        this.f70g = C0049bv.m171a(this.f44a);
                        this.f73h = C0049bv.m169a();
                        break;
                    case 4:
                        C0083t.m265a("/content/level/5.wb1");
                        this.f38a = new C0034bg(C0083t.f531a, 2);
                        this.f76i = 166000L;
                        this.f44a = C0011ak.f143a.m138a(9);
                        this.f44a = this.f44a.toUpperCase();
                        this.f70g = C0049bv.m171a(this.f44a);
                        this.f73h = C0049bv.m169a();
                        break;
                    case 5:
                        C0083t.m265a("/content/level/6.wb1");
                        this.f38a = new C0034bg(C0083t.f531a, 2);
                        this.f76i = 188500L;
                        this.f44a = C0011ak.f143a.m138a(10);
                        this.f44a = this.f44a.toUpperCase();
                        this.f70g = C0049bv.m171a(this.f44a);
                        this.f73h = C0049bv.m169a();
                        break;
                }
                System.gc();
                break;
            case 8:
                this.f80m = 0L;
                switch (C0076m.f515a) {
                    case 0:
                        C0087x.m276a(61455);
                        break;
                    case 1:
                        C0087x.m276a(983280);
                        break;
                    case 2:
                        C0087x.m276a(15732480);
                        break;
                }
                System.gc();
                break;
            case 9:
                this.f35a = 0;
                this.f55b = false;
                this.f59c = true;
                this.f63d = false;
                this.f74h = 0L;
                this.f65e = 0L;
                this.f61d = 0L;
                this.f57c = 0L;
                this.f64e = 0;
                this.f60d = 0;
                this.f56c = 0;
                this.f51b = 0;
                this.f78k = 0L;
                this.f77j = 4000L;
                this.f67f = 10000;
                long jCurrentTimeMillis = System.currentTimeMillis();
                this.f52b = jCurrentTimeMillis;
                this.f36a = jCurrentTimeMillis;
                C0010aj.m66a(false);
                System.gc();
                break;
        }
    }

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: a */
    public final void mo44a(int i) {
        this.f52b = this.f36a;
        this.f36a = System.currentTimeMillis();
        this.f57c = this.f36a - this.f52b;
        if (this.f47a) {
            if (this.f55b || this.f77j >= 0) {
                if (!this.f55b) {
                    C0010aj.f131a.m12a(50L);
                    this.f46a.m268b();
                    this.f42a.mo21a(false);
                }
                if (this.f55b) {
                    if (this.f79l < 0 && (C0011ak.f165h & i) != 0) {
                        this.f79l = 1000L;
                        this.f40a.m152d();
                    }
                    if (this.f79l < 0 && (C0011ak.f163f & i) != 0) {
                        this.f79l = 1000L;
                        this.f40a.m151c();
                    }
                    if (this.f79l < 0 && (i & 256) != 0) {
                        this.f79l = 1000L;
                        this.f40a.m153e();
                    }
                    if (this.f79l < 0 && (i & 8192) != 0) {
                        this.f79l = 1000L;
                        this.f40a.m153e();
                    }
                    if (this.f79l < 0 && (i & 16384) != 0) {
                        this.f79l = 1000L;
                        this.f40a.m148a((short) 0);
                    }
                }
            } else {
                this.f74h += this.f57c;
                if (!this.f38a.m136a()) {
                    this.f61d += this.f57c;
                }
                if (this.f35a == 0) {
                    int iMax = Math.max(((int) (this.f57c + this.f65e)) / 50, 0) & 7;
                    this.f65e += this.f57c - ((long) (iMax * 50));
                    for (int i2 = 0; i2 < iMax; i2++) {
                        if (!this.f38a.m136a()) {
                            C0057cc.m196c();
                            if ((C0011ak.f162e & i) != 0) {
                                C0010aj.f131a.m16c();
                                if (this.f63d) {
                                    C0057cc.m194a();
                                }
                            }
                            if ((C0011ak.f164g & i) != 0) {
                                C0010aj.f131a.m17d();
                                if (this.f63d) {
                                    C0057cc.m195b();
                                }
                            }
                            if ((C0011ak.f163f & i) != 0 || (C0011ak.f166i & i) != 0 || (C0011ak.f169l & i) != 0) {
                                C0010aj.f131a.m10a();
                                if (this.f34a < 1.5f) {
                                }
                            } else if ((C0011ak.f165h & i) != 0 || (C0011ak.f167j & i) != 0 || (C0011ak.f168k & i) != 0) {
                                C0010aj.f131a.m15b();
                            }
                        }
                        C0010aj.f131a.m12a(50L);
                        this.f43a.m222a(50L);
                        this.f46a.m268b();
                        this.f42a.mo21a(false);
                        if (this.f38a.m136a()) {
                            this.f49a[0].m52a(C0010aj.f131a.m14a(this.f48a), this.f61d);
                        } else {
                            this.f49a[0].m54b(C0010aj.f131a.m14a(this.f48a), this.f61d);
                        }
                    }
                    this.f38a.m135a(this.f37a.f30a, this.f37a.f32c);
                    if (this.f38a.m136a() && this.f35a == 0) {
                        this.f71g -= this.f57c;
                        if (this.f71g < 0) {
                            this.f35a = 2;
                        }
                    }
                } else if (this.f35a == 2) {
                    this.f43a.m222a(50L);
                    this.f46a.m268b();
                    this.f42a.mo21a(false);
                    this.f38a.m135a(this.f37a.f30a, this.f37a.f32c);
                } else if (this.f35a == 1) {
                    m40f();
                }
            }
            this.f79l -= this.f57c;
            if ((i & 256) != 0 && this.f59c) {
                this.f59c = false;
            }
            if ((i & 16384) != 0 && this.f79l < 0) {
                this.f79l = 1000L;
                if (this.f55b) {
                    return;
                }
                if (this.f38a.m136a()) {
                    if (C0011ak.f152a[C0011ak.f154b] == 0 || C0011ak.f152a[C0011ak.f154b] > this.f61d) {
                        C0011ak.f152a[C0011ak.f154b] = this.f61d;
                    }
                    if (this.f61d <= this.f76i) {
                        C0011ak.f150a = (short) Math.max((int) C0011ak.f150a, C0011ak.f154b + 1);
                    }
                }
                if (this.f59c) {
                    C0011ak.f141a.m124a(C0011ak.f153a[1]);
                    return;
                } else {
                    if (this.f77j <= 0) {
                        this.f55b = !this.f55b;
                        return;
                    }
                    return;
                }
            }
            if ((i & 8192) != 0 && this.f79l < 0) {
                if (this.f59c) {
                    this.f59c = false;
                } else if (this.f38a.m136a()) {
                    if (this.f35a != 2) {
                        C0011ak.f146a.setColor(3959174);
                        C0011ak.f146a.fillRect(0, 0, C0011ak.f158c, C0011ak.f160d);
                        if (this.f72g != null) {
                            C0087x.m278a(this.f72g, 0, 0, 16773120);
                        }
                        if (C0011ak.f154b == 5) {
                            if (C0011ak.f152a[C0011ak.f154b] == 0 || C0011ak.f152a[C0011ak.f154b] > this.f61d) {
                                C0011ak.f152a[C0011ak.f154b] = this.f61d;
                            }
                            C0011ak.f141a.m124a(C0011ak.f153a[1]);
                            return;
                        }
                        if (C0011ak.f152a[C0011ak.f154b] == 0 || C0011ak.f152a[C0011ak.f154b] > this.f61d) {
                            C0011ak.f152a[C0011ak.f154b] = this.f61d;
                        }
                        if (this.f61d <= this.f76i) {
                            C0011ak.f154b++;
                            C0011ak.f150a = (short) Math.max((int) C0011ak.f150a, C0011ak.f154b);
                        }
                        C0011ak.f146a.setColor(3959174);
                        C0011ak.f146a.fillRect(0, 0, C0011ak.f158c, C0011ak.f160d);
                        if (this.f72g != null) {
                            C0087x.m278a(this.f72g, 0, 0, 16773120);
                        }
                        C0011ak.f141a.m124a(C0011ak.f153a[0]);
                        return;
                    }
                    this.f49a[0].m49a();
                    this.f35a = 1;
                    this.f63d = false;
                    this.f39a = this.f53b;
                }
                this.f79l = 1000L;
            }
            if (C0010aj.f132a.m104b().f31b < 0) {
                this.f80m += this.f57c;
            } else {
                this.f80m = 0L;
            }
            if (this.f80m >= 2500) {
                C0010aj.f131a.m11a(C0010aj.f132a.m96a(), C0010aj.f132a.m103b(), C0010aj.f132a.m107c(), 0);
                this.f80m = 0L;
            }
            C0011ak.f146a.setColor(3959174);
            C0011ak.f146a.fillRect(0, 0, C0011ak.f158c, C0011ak.f160d);
            m41g();
            m42h();
        }
    }

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: a */
    public final boolean mo45a() {
        return this.f47a;
    }

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: b */
    public final void mo46b() {
        for (int i = 0; i < this.f50a.length; i++) {
            this.f50a[i] = null;
        }
        this.f50a = null;
        this.f45a = null;
        this.f54b = null;
        this.f58c = null;
        this.f62d = null;
        this.f66e = null;
        this.f69f = null;
        this.f72g = null;
        this.f40a = null;
        C0010aj.m65a();
        C0083t.m264a();
        this.f53b = null;
        this.f39a = null;
        this.f43a = null;
        this.f38a = null;
        this.f37a = null;
        this.f50a = null;
        C0057cc.m198e();
        this.f49a = null;
        this.f48a = null;
        this.f75i = 10;
        System.gc();
        this.f47a = false;
    }

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: c */
    public final void mo47c() {
        this.f55b = true;
        if (C0011ak.f157b) {
            C0011ak.f142a.m131b();
        }
    }

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: d */
    public final void mo48d() {
        this.f79l = 1000L;
        if (C0011ak.f157b) {
            C0011ak.f142a.m132c();
        }
    }
}
