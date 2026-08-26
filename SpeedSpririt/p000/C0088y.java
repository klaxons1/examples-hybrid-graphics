package p000;

/* JADX INFO: renamed from: y */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0088y extends AbstractC0053bz {

    /* JADX INFO: renamed from: a */
    private int f560a;

    /* JADX INFO: renamed from: a */
    private long f561a;

    /* JADX INFO: renamed from: a */
    private C0039bl f562a;

    /* JADX INFO: renamed from: a */
    private boolean f563a = false;

    /* JADX INFO: renamed from: b */
    private long f564b;

    /* JADX INFO: renamed from: c */
    private long f565c;

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: a */
    public final void mo43a() {
        this.f562a = new C0039bl();
        C0009ai c0009ai = new C0009ai();
        c0009ai.m56a(new C0022av(C0011ak.f146a, "/content/interface/soft_play.png", C0011ak.f158c - 15, C0011ak.f160d - 19, (short) 2, new C0016ap(this)));
        C0029bb c0029bb = new C0029bb(30, 10, C0011ak.f158c, C0011ak.f160d, C0011ak.f146a);
        if (C0011ak.f157b) {
            c0029bb.m207a(new C0037bj(C0011ak.f143a, 11, 12, C0011ak.f146a, new C0018ar(this)));
        } else {
            c0029bb.m207a(new C0037bj(C0011ak.f143a, 12, 11, C0011ak.f146a, new C0018ar(this)));
        }
        c0009ai.m56a(c0029bb);
        this.f562a.m147a(c0009ai);
        this.f562a.m145a();
        this.f560a = 0;
        this.f565c = 0L;
        long jCurrentTimeMillis = System.currentTimeMillis();
        this.f564b = jCurrentTimeMillis;
        this.f561a = jCurrentTimeMillis;
        this.f563a = true;
    }

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: a */
    public final void mo44a(int i) {
        if (this.f563a) {
            this.f564b = this.f561a;
            this.f561a = System.currentTimeMillis();
            this.f565c = this.f561a - this.f564b;
            this.f560a = (int) (((long) this.f560a) - this.f565c);
            if (this.f560a < 0 && (C0011ak.f165h & i) != 0) {
                this.f560a = 200;
                this.f562a.m152d();
            }
            if (this.f560a < 0 && (C0011ak.f163f & i) != 0) {
                this.f560a = 200;
                this.f562a.m151c();
            }
            if (this.f560a < 0 && (i & 8192) != 0) {
                this.f560a = 200;
                this.f562a.m148a((short) 2);
            }
            if (this.f560a < 0 && (i & 256) != 0) {
                this.f560a = 200;
                this.f562a.m153e();
            }
            C0011ak.f146a.setColor(3959174);
            C0011ak.f146a.fillRect(0, 0, C0011ak.f158c, C0011ak.f160d);
            C0011ak.f146a.setColor(9837593);
            switch (C0011ak.f156b) {
                case 0:
                    C0011ak.f146a.fillRect(0, C0011ak.f160d - 24, C0011ak.f158c, 24);
                    C0011ak.f146a.fillRect(0, 0, C0011ak.f158c, C0011ak.f170m + 10);
                    C0011ak.f146a.setColor(14005684);
                    C0011ak.f146a.fillRect(0, C0011ak.f160d - 25, C0011ak.f158c, 1);
                    C0011ak.f146a.fillRect(0, C0011ak.f170m + 10, C0011ak.f158c, 1);
                    break;
                case 1:
                    C0011ak.f146a.fillRect((C0011ak.f158c - C0011ak.f170m) - 10, 0, C0011ak.f170m + 10, C0011ak.f160d);
                    C0011ak.f146a.fillRect(0, 0, 24, C0011ak.f160d);
                    break;
                case 2:
                    C0011ak.f146a.fillRect(0, 0, C0011ak.f170m + 10, C0011ak.f160d);
                    C0011ak.f146a.fillRect(C0011ak.f158c - 24, 0, 24, C0011ak.f160d);
                    break;
            }
            this.f562a.m149b();
        }
    }

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: a */
    public final boolean mo45a() {
        return this.f563a;
    }

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: b */
    public final void mo46b() {
        this.f562a = null;
        this.f563a = false;
    }

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: c */
    public final void mo47c() {
    }

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: d */
    public final void mo48d() {
    }
}
