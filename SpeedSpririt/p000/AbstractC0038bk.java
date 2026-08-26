package p000;

/* JADX INFO: renamed from: bk */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public abstract class AbstractC0038bk extends AbstractC0043bp {

    /* JADX INFO: renamed from: a */
    public static C0005ae f343a = new C0005ae();

    /* JADX INFO: renamed from: b */
    public static C0005ae f344b = new C0005ae();

    /* JADX INFO: renamed from: c */
    public static C0005ae f345c = new C0005ae();

    /* JADX INFO: renamed from: c */
    private static C0073j f346c = new C0073j();

    /* JADX INFO: renamed from: a */
    public int f347a;

    /* JADX INFO: renamed from: a */
    public int[] f348a;

    /* JADX INFO: renamed from: a */
    public C0005ae[] f349a;

    /* JADX INFO: renamed from: b */
    public C0005ae[] f350b;

    /* JADX INFO: renamed from: c */
    public int f351c;

    /* JADX INFO: renamed from: d */
    public int f352d;

    /* JADX INFO: renamed from: e */
    public int f353e;

    public AbstractC0038bk(int i, int i2, int i3, int i4, int i5, String str) {
        super(str);
        this.f349a = new C0005ae[6];
        this.f350b = new C0005ae[6];
        for (int length = this.f350b.length - 1; length >= 0; length--) {
            this.f350b[length] = new C0005ae();
        }
        this.f348a = new int[6];
        this.f349a[0] = new C0005ae(0, 0, -4096);
        this.f349a[1] = new C0005ae(0, 0, 4096);
        this.f349a[2] = new C0005ae();
        this.f349a[3] = new C0005ae();
        this.f349a[4] = new C0005ae();
        this.f349a[5] = new C0005ae();
        this.f352d = i;
        this.f353e = i2;
        mo144e(i3, i4, i5);
    }

    /* JADX INFO: renamed from: a */
    public static AbstractC0038bk m141a(int i, int i2, int i3, int i4, int i5) {
        return new C0081r(i, i2, i3, i4, i5);
    }

    @Override // p000.AbstractC0023aw
    /* JADX INFO: renamed from: a */
    public final void mo20a(AbstractC0038bk abstractC0038bk, C0086w c0086w) {
    }

    @Override // p000.AbstractC0043bp, p000.AbstractC0023aw
    /* JADX INFO: renamed from: a */
    public final void mo21a(boolean z) {
        if (((AbstractC0023aw) this).f262b || z) {
            if (((AbstractC0023aw) this).f255a != null) {
                ((AbstractC0023aw) this).f261b = ((AbstractC0023aw) ((AbstractC0023aw) this).f255a).f261b.m230a(((AbstractC0023aw) this).f257a, ((AbstractC0023aw) this).f261b);
            } else {
                ((AbstractC0023aw) this).f261b.m235a(((AbstractC0023aw) this).f257a);
            }
            this.f350b = ((AbstractC0023aw) this).f261b.m238a(this.f349a, this.f350b);
            f343a = ((AbstractC0023aw) this).f261b.m228a(f343a);
            f344b = ((AbstractC0023aw) this).f261b.m241b(f344b);
            f345c.m31a(f344b);
            f344b.m29a(-this.f347a);
            f345c.m29a(-this.f351c);
            f344b.m32b(f343a);
            f345c.m32b(f343a);
            this.f348a[0] = f344b.m26a(this.f350b[0]);
            this.f348a[1] = f345c.m26a(this.f350b[1]);
            this.f348a[2] = f343a.m26a(this.f350b[2]);
            this.f348a[3] = f343a.m26a(this.f350b[3]);
            this.f348a[4] = f343a.m26a(this.f350b[4]);
            this.f348a[5] = f343a.m26a(this.f350b[5]);
            ((AbstractC0023aw) this).f262b = false;
            super.f263c = false;
            switch (C0076m.f515a) {
                case 1:
                    f346c.m231a();
                    f346c.m246c(0, 0, 1024);
                    ((AbstractC0023aw) this).f261b.m243b(f346c);
                    break;
                case 2:
                    f346c.m231a();
                    f346c.m246c(0, 0, -1024);
                    ((AbstractC0023aw) this).f261b.m243b(f346c);
                    break;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m142a(C0066cl c0066cl) {
        for (int i = 5; i >= 0; i--) {
            if (c0066cl.f454a.m26a(this.f350b[i]) - this.f348a[i] < (-c0066cl.f453a)) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: b */
    public abstract void mo143b();

    /* JADX INFO: renamed from: e */
    public void mo144e(int i, int i2, int i3) {
        this.f347a = i2;
        this.f351c = i3;
        int iM199a = C0064cj.m199a(i >> 1);
        int iM202b = C0064cj.m202b(i >> 1);
        this.f349a[2].m30a(iM202b, 0, -iM199a);
        this.f349a[3].m30a(-iM202b, 0, -iM199a);
        this.f349a[4].m30a(0, -iM202b, -iM199a);
        this.f349a[5].m30a(0, iM202b, -iM199a);
    }
}
