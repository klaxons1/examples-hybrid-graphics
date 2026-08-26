package p000;

/* JADX INFO: renamed from: f */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0069f implements InterfaceC0050bw {

    /* JADX INFO: renamed from: a */
    public C0005ae f471a;

    /* JADX INFO: renamed from: a */
    public AbstractC0023aw f472a;

    /* JADX INFO: renamed from: a */
    public boolean f473a;

    /* JADX INFO: renamed from: b */
    public AbstractC0023aw f474b;

    /* JADX INFO: renamed from: c */
    public AbstractC0023aw f475c;

    public C0069f(AbstractC0023aw abstractC0023aw, AbstractC0023aw abstractC0023aw2, C0005ae c0005ae) {
        this.f472a = abstractC0023aw;
        this.f475c = abstractC0023aw2;
        this.f473a = (abstractC0023aw == null || abstractC0023aw2 == null) ? false : true;
        this.f474b = abstractC0023aw;
        while (this.f474b.f255a != null) {
            this.f474b = this.f474b.f255a;
        }
        AbstractC0023aw abstractC0023aw3 = abstractC0023aw2;
        while (abstractC0023aw3.f255a != null) {
            abstractC0023aw3 = abstractC0023aw3.f255a;
        }
        if (abstractC0023aw3 == this.f474b) {
            this.f474b = null;
        }
        this.f471a = c0005ae;
        new C0005ae();
        if (c0005ae != null) {
            C0005ae c0005ae2 = new C0005ae(0, 4096, 0);
            C0005ae c0005ae3 = new C0005ae(c0005ae);
            C0005ae c0005ae4 = new C0005ae();
            c0005ae3.m28a();
            C0005ae c0005aeM27a = c0005ae2.m27a(c0005ae3, c0005ae4);
            abstractC0023aw2.m101a(c0005aeM27a, c0005ae3.m27a(c0005aeM27a, c0005ae2), c0005ae3);
        }
    }

    @Override // p000.InterfaceC0050bw
    /* JADX INFO: renamed from: a */
    public final void mo182a() {
        if (this.f473a) {
            if (this.f474b != null) {
                this.f474b.mo21a(false);
            }
            if (this.f471a == null) {
                this.f475c.m106b(this.f472a.m96a(), this.f472a.m103b(), this.f472a.m107c());
            } else {
                this.f475c.m106b(this.f472a.m96a() + this.f471a.f30a, this.f472a.m103b() + this.f471a.f31b, this.f472a.m107c() + this.f471a.f32c);
            }
        }
    }

    @Override // p000.InterfaceC0050bw
    /* JADX INFO: renamed from: a */
    public final boolean mo183a() {
        return this.f473a;
    }
}
