package p000;

/* JADX INFO: renamed from: aw */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public abstract class AbstractC0023aw {

    /* JADX INFO: renamed from: a */
    public C0003ac f255a;

    /* JADX INFO: renamed from: a */
    public C0066cl f256a;

    /* JADX INFO: renamed from: a */
    public C0073j f257a;

    /* JADX INFO: renamed from: a */
    public String f258a;

    /* JADX INFO: renamed from: a */
    public boolean f259a;

    /* JADX INFO: renamed from: b */
    public AbstractC0023aw f260b;

    /* JADX INFO: renamed from: b */
    public C0073j f261b;

    /* JADX INFO: renamed from: b */
    public boolean f262b;

    /* JADX INFO: renamed from: c */
    public boolean f263c;

    public AbstractC0023aw() {
        this("<GraphNode>");
    }

    public AbstractC0023aw(String str) {
        this.f255a = null;
        this.f258a = str;
        this.f259a = true;
        this.f257a = new C0073j();
        this.f261b = new C0073j();
        this.f256a = new C0066cl();
        this.f262b = true;
        this.f263c = true;
    }

    /* JADX INFO: renamed from: a */
    public final int m96a() {
        return this.f261b.m226a();
    }

    /* JADX INFO: renamed from: a */
    public final C0005ae m97a() {
        return this.f257a.m227a();
    }

    /* JADX INFO: renamed from: a */
    public final C0005ae m98a(C0005ae c0005ae) {
        return this.f257a.m228a(c0005ae);
    }

    /* JADX INFO: renamed from: a */
    public abstract String mo18a(String str, int i);

    /* JADX INFO: renamed from: a */
    public final void m99a() {
        this.f263c = true;
        if (this.f255a != null) {
            this.f255a.m99a();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m100a(int i, int i2, int i3) {
        this.f257a.m232a(i, i2, i3);
        this.f262b = true;
        m99a();
    }

    /* JADX INFO: renamed from: a */
    public final void m101a(C0005ae c0005ae, C0005ae c0005ae2, C0005ae c0005ae3) {
        this.f257a.m234a(c0005ae, c0005ae2, c0005ae3);
        this.f262b = true;
        m99a();
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo20a(AbstractC0038bk abstractC0038bk, C0086w c0086w);

    /* JADX INFO: renamed from: a */
    public final void m102a(C0073j c0073j) {
        this.f257a.m235a(c0073j);
        this.f262b = true;
        m99a();
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo21a(boolean z);

    /* JADX INFO: renamed from: b */
    public final int m103b() {
        return this.f261b.m239b();
    }

    /* JADX INFO: renamed from: b */
    public final C0005ae m104b() {
        return this.f257a.m240b();
    }

    /* JADX INFO: renamed from: b */
    public final C0005ae m105b(C0005ae c0005ae) {
        return this.f261b.m228a(c0005ae);
    }

    /* JADX INFO: renamed from: b */
    public final void m106b(int i, int i2, int i3) {
        this.f257a.m242b(i, i2, i3);
        this.f262b = true;
        m99a();
    }

    /* JADX INFO: renamed from: c */
    public final int m107c() {
        return this.f261b.m244c();
    }

    /* JADX INFO: renamed from: c */
    public final void m108c(int i, int i2, int i3) {
        this.f257a.m246c(i, i2, i3);
        this.f262b = true;
        m99a();
    }

    /* JADX INFO: renamed from: d */
    public final int m109d() {
        return this.f261b.m247d();
    }

    /* JADX INFO: renamed from: d */
    public final void m110d(int i, int i2, int i3) {
        this.f257a.m248d(i, i2, i3);
        this.f262b = true;
        m99a();
    }

    /* JADX INFO: renamed from: e */
    public final int m111e() {
        return this.f261b.m249e();
    }

    /* JADX INFO: renamed from: f */
    public final int m112f() {
        return this.f261b.m250f();
    }

    public final String toString() {
        return mo18a("", 0);
    }
}
