package p000;

/* JADX INFO: renamed from: ai */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0009ai {

    /* JADX INFO: renamed from: a */
    public C0017aq f122a = null;

    /* JADX INFO: renamed from: a */
    private AbstractC0065ck f123a = null;

    /* JADX INFO: renamed from: a */
    private AbstractC0077n f124a = null;

    /* JADX INFO: renamed from: a */
    private int f121a = 0;

    /* JADX INFO: renamed from: b */
    private boolean f129b = false;

    /* JADX INFO: renamed from: c */
    private boolean f130c = false;

    /* JADX INFO: renamed from: a */
    private short f125a = 0;

    /* JADX INFO: renamed from: a */
    public boolean f126a = false;

    /* JADX INFO: renamed from: b */
    private int f128b = 5;

    /* JADX INFO: renamed from: a */
    private AbstractC0051bx[] f127a = new AbstractC0051bx[3];

    public C0009ai() {
        AbstractC0051bx[] abstractC0051bxArr = this.f127a;
        AbstractC0051bx[] abstractC0051bxArr2 = this.f127a;
        this.f127a[2] = null;
        abstractC0051bxArr2[1] = null;
        abstractC0051bxArr[0] = null;
    }

    /* JADX INFO: renamed from: a */
    public final void m55a() {
        this.f121a++;
    }

    /* JADX INFO: renamed from: a */
    public final void m56a(AbstractC0065ck abstractC0065ck) {
        if (this.f123a == null) {
            this.f123a = abstractC0065ck;
        } else {
            this.f123a.m207a(abstractC0065ck);
        }
        if (abstractC0065ck instanceof AbstractC0051bx) {
            this.f127a[((AbstractC0051bx) abstractC0065ck).f394a] = (AbstractC0051bx) abstractC0065ck;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m57a(short s) {
        if (this.f128b >= 0 || this.f123a == null || this.f127a[s] == null || this.f129b || this.f130c) {
            return;
        }
        this.f123a.mo128b(this);
        this.f130c = true;
        this.f125a = s;
        this.f128b = 5;
    }

    /* JADX INFO: renamed from: b */
    public final void m58b() {
        this.f121a--;
    }

    /* JADX INFO: renamed from: c */
    public final void m59c() {
        this.f121a = 0;
        this.f129b = false;
        this.f130c = false;
        this.f126a = false;
        this.f128b = 5;
        if (this.f123a != null) {
            this.f123a.mo77a(this);
            this.f124a = this.f123a.m205a();
        }
    }

    /* JADX INFO: renamed from: d */
    public final void m60d() {
        if (this.f128b < 0) {
            if (this.f123a != null && this.f124a != null) {
                AbstractC0077n abstractC0077nM205a = this.f124a.m205a();
                if (abstractC0077nM205a != null) {
                    this.f124a = abstractC0077nM205a;
                } else {
                    this.f124a.m256c();
                }
            }
            if (this.f122a != null) {
                this.f122a.m80b();
            }
            this.f128b = 5;
        }
    }

    /* JADX INFO: renamed from: e */
    public final void m61e() {
        if (this.f128b < 0) {
            if (this.f123a != null && this.f124a != null) {
                AbstractC0077n abstractC0077nM208b = this.f124a.m208b();
                if (abstractC0077nM208b != null) {
                    this.f124a = abstractC0077nM208b;
                } else {
                    this.f124a.m256c();
                }
            }
            if (this.f122a != null) {
                this.f122a.m83c();
            }
            this.f128b = 5;
        }
    }

    /* JADX INFO: renamed from: f */
    public final void m62f() {
        if (this.f128b >= 0 || this.f123a == null || this.f124a == null || this.f129b || this.f130c) {
            return;
        }
        this.f123a.mo128b(this);
        this.f129b = true;
        this.f128b = 5;
    }

    /* JADX INFO: renamed from: g */
    public final void m63g() {
        this.f128b--;
        if (this.f129b && this.f121a == 0) {
            this.f129b = false;
            this.f130c = false;
            this.f126a = true;
            this.f124a.mo140b();
            return;
        }
        if (!this.f130c || this.f121a != 0) {
            this.f123a.mo75a();
            return;
        }
        this.f129b = false;
        this.f130c = false;
        this.f126a = true;
        this.f127a[this.f125a].m184b();
    }
}
