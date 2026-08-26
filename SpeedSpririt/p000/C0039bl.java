package p000;

/* JADX INFO: renamed from: bl */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0039bl {

    /* JADX INFO: renamed from: a */
    public static short f354a;

    /* JADX INFO: renamed from: a */
    private C0009ai[] f356a = null;

    /* JADX INFO: renamed from: a */
    public int f355a = 0;

    /* JADX INFO: renamed from: b */
    private int f357b = 0;

    /* JADX INFO: renamed from: a */
    public final void m145a() {
        if (this.f356a != null) {
            this.f356a[0].m59c();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m146a(int i) {
        if (this.f356a == null || i >= this.f356a.length) {
            this.f357b = 0;
        } else {
            this.f357b = i;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m147a(C0009ai c0009ai) {
        if (this.f356a == null) {
            this.f356a = new C0009ai[1];
            this.f356a[0] = c0009ai;
            return;
        }
        C0009ai[] c0009aiArr = new C0009ai[this.f356a.length + 1];
        for (int i = 0; i < this.f356a.length; i++) {
            c0009aiArr[i] = this.f356a[i];
        }
        c0009aiArr[this.f356a.length] = c0009ai;
        this.f356a = c0009aiArr;
    }

    /* JADX INFO: renamed from: a */
    public final void m148a(short s) {
        if (this.f356a == null || this.f355a >= this.f356a.length) {
            return;
        }
        this.f356a[this.f355a].m57a(s);
    }

    /* JADX INFO: renamed from: b */
    public final void m149b() {
        if (this.f356a == null || this.f355a >= this.f356a.length) {
            return;
        }
        this.f356a[this.f355a].m63g();
        if (this.f356a[this.f355a].f126a) {
            this.f356a[this.f357b].m59c();
            this.f355a = this.f357b;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m150b(int i) {
        if (this.f356a == null || i >= this.f356a.length) {
            return;
        }
        this.f355a = i;
        this.f356a[this.f355a].m59c();
    }

    /* JADX INFO: renamed from: c */
    public final void m151c() {
        if (this.f356a == null || this.f355a >= this.f356a.length) {
            return;
        }
        this.f356a[this.f355a].m61e();
    }

    /* JADX INFO: renamed from: d */
    public final void m152d() {
        if (this.f356a == null || this.f355a >= this.f356a.length) {
            return;
        }
        this.f356a[this.f355a].m60d();
    }

    /* JADX INFO: renamed from: e */
    public final void m153e() {
        if (this.f356a == null || this.f355a >= this.f356a.length) {
            return;
        }
        this.f356a[this.f355a].m62f();
    }
}
