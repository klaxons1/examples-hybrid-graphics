package p000;

/* JADX INFO: renamed from: u */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0084u implements InterfaceC0050bw {

    /* JADX INFO: renamed from: a */
    public static C0005ae f542a;

    /* JADX INFO: renamed from: b */
    public static C0005ae f543b;

    /* JADX INFO: renamed from: c */
    public static C0005ae f544c;

    /* JADX INFO: renamed from: a */
    public int f545a;

    /* JADX INFO: renamed from: a */
    public AbstractC0023aw f546a;

    /* JADX INFO: renamed from: a */
    public boolean f547a;

    /* JADX INFO: renamed from: b */
    public AbstractC0023aw f548b;

    /* JADX INFO: renamed from: c */
    public AbstractC0023aw f549c;

    /* JADX INFO: renamed from: d */
    public C0005ae f550d;

    public C0084u(AbstractC0023aw abstractC0023aw, AbstractC0023aw abstractC0023aw2) {
        this(abstractC0023aw, abstractC0023aw2, null);
    }

    private C0084u(AbstractC0023aw abstractC0023aw, AbstractC0023aw abstractC0023aw2, C0005ae c0005ae) {
        this.f546a = abstractC0023aw;
        this.f549c = abstractC0023aw2;
        this.f547a = true;
        this.f550d = c0005ae;
        if (c0005ae != null) {
            this.f550d.m28a();
        }
        if (f542a == null) {
            f542a = new C0005ae();
        }
        if (f543b == null) {
            f543b = new C0005ae();
        }
        if (f544c == null) {
            f544c = new C0005ae();
        }
        this.f548b = abstractC0023aw;
        while (this.f548b.f255a != null) {
            this.f548b = this.f548b.f255a;
        }
        while (abstractC0023aw2.f255a != null) {
            abstractC0023aw2 = abstractC0023aw2.f255a;
        }
        if (abstractC0023aw2 == this.f548b) {
            this.f548b = null;
        }
        this.f545a = 0;
    }

    @Override // p000.InterfaceC0050bw
    /* JADX INFO: renamed from: a */
    public final void mo182a() {
        if (this.f547a) {
            if (this.f548b != null) {
                this.f548b.mo21a(false);
            }
            f542a = this.f546a.m105b(f542a);
            f542a = ((AbstractC0023aw) this.f549c.f255a).f261b.m245c(f542a);
            f543b = this.f549c.m98a(f543b);
            f543b.m33c(f542a);
            f543b.m28a();
            if (this.f550d != null) {
                f544c.m31a(this.f550d);
            } else {
                f544c.m30a(0, 4096, 0);
            }
            f542a = f544c.m27a(f543b, f542a);
            f542a.m28a();
            if (this.f550d != null) {
                f543b = f542a.m27a(f544c, f543b);
            } else {
                f544c = f543b.m27a(f542a, f544c);
            }
            this.f549c.m101a(f542a, f544c, f543b);
        }
    }

    @Override // p000.InterfaceC0050bw
    /* JADX INFO: renamed from: a */
    public final boolean mo183a() {
        return this.f547a;
    }

    /* JADX INFO: renamed from: b */
    public final void m268b() {
        switch (this.f545a) {
            case 0:
                this.f549c.m100a(((this.f546a.m96a() - (this.f546a.m109d() / 12)) - this.f549c.m96a()) / 3, (((this.f546a.m103b() - (this.f546a.m111e() / 12)) + 180) - this.f549c.m103b()) / 3, ((this.f546a.m107c() - (this.f546a.m112f() / 12)) - this.f549c.m107c()) / 3);
                break;
            case 1:
                this.f549c.m100a(this.f546a.m96a() - (this.f546a.m109d() / 12), (this.f546a.m103b() - (this.f546a.m111e() / 12)) + 180, this.f546a.m107c() - (this.f546a.m112f() / 12));
                break;
        }
    }
}
