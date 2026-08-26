package p000;

/* JADX INFO: renamed from: h */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0071h {

    /* JADX INFO: renamed from: a */
    private C0024ax f479a = null;

    /* JADX INFO: renamed from: c */
    private float f483c = 0.0f;

    /* JADX INFO: renamed from: a */
    private float f477a = 0.0f;

    /* JADX INFO: renamed from: b */
    private float f482b = -4.0f;

    /* JADX INFO: renamed from: a */
    private InterfaceC0059ce[] f481a = null;

    /* JADX INFO: renamed from: a */
    public C0074k f480a = null;

    /* JADX INFO: renamed from: a */
    private AbstractC0015ao f478a = null;

    /* JADX INFO: renamed from: a */
    public final void m221a() {
        for (C0024ax c0024ax = this.f479a; c0024ax != null; c0024ax = c0024ax.f266a) {
            c0024ax.m113a();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m222a(long j) {
        float f = j * j * 5.0E-4f;
        float f2 = this.f477a * f;
        float f3 = this.f482b * f;
        float f4 = this.f483c * f;
        for (C0024ax c0024ax = this.f479a; c0024ax != null; c0024ax = c0024ax.f266a) {
            if (c0024ax.f271b) {
                int i = 0;
                for (int i2 = 0; i2 < c0024ax.f265a; i2++) {
                    float f5 = c0024ax.f268a[i + 7];
                    float f6 = c0024ax.f268a[i + 8];
                    float f7 = c0024ax.f268a[i + 9];
                    c0024ax.f268a[i + 7] = c0024ax.f268a[i + 4];
                    c0024ax.f268a[i + 8] = c0024ax.f268a[i + 5];
                    c0024ax.f268a[i + 9] = c0024ax.f268a[i + 6];
                    float[] fArr = c0024ax.f268a;
                    int i3 = i + 4;
                    fArr[i3] = (c0024ax.f268a[i + 4] - f5) + f2 + fArr[i3];
                    float[] fArr2 = c0024ax.f268a;
                    int i4 = i + 5;
                    fArr2[i4] = (c0024ax.f268a[i + 5] - f6) + f3 + fArr2[i4];
                    float[] fArr3 = c0024ax.f268a;
                    int i5 = i + 6;
                    fArr3[i5] = (c0024ax.f268a[i + 6] - f7) + f4 + fArr3[i5];
                    i += 10;
                }
                c0024ax.f267a = false;
            }
        }
        this.f478a.mo72a();
        for (AbstractC0015ao abstractC0015ao = this.f478a; abstractC0015ao != null && abstractC0015ao.f198a != null; abstractC0015ao = abstractC0015ao.f198a) {
            for (AbstractC0015ao abstractC0015ao2 = abstractC0015ao.f198a; abstractC0015ao2 != null; abstractC0015ao2 = abstractC0015ao2.f198a) {
                if (abstractC0015ao.f199a.f271b && abstractC0015ao2.f199a.f271b && Math.abs(abstractC0015ao.f199a.f268a[4] - abstractC0015ao2.f199a.f268a[4]) < 1000.0f && Math.abs(abstractC0015ao.f199a.f268a[6] - abstractC0015ao2.f199a.f268a[6]) < 1000.0f) {
                    abstractC0015ao.mo73a(abstractC0015ao2.f200a);
                }
            }
        }
        if (this.f481a != null) {
            for (C0024ax c0024ax2 = this.f479a; c0024ax2 != null; c0024ax2 = c0024ax2.f266a) {
                if (c0024ax2.f271b && c0024ax2.f272c) {
                    int i6 = 0;
                    for (int i7 = 0; i7 < c0024ax2.f265a; i7++) {
                        for (int i8 = 0; i8 < this.f481a.length && !this.f481a[i8].mo71a(c0024ax2, i6); i8++) {
                        }
                        i6 += 10;
                    }
                }
            }
        }
        if (this.f480a != null) {
            for (C0024ax c0024ax3 = this.f479a; c0024ax3 != null; c0024ax3 = c0024ax3.f266a) {
                if (c0024ax3.f271b) {
                    this.f480a.m251a((int) c0024ax3.f268a[4], (int) c0024ax3.f268a[6], 500);
                    while (!this.f480a.m253a()) {
                        InterfaceC0059ce[] interfaceC0059ceArrM254a = this.f480a.m254a();
                        int i9 = 0;
                        for (int i10 = 0; i10 < c0024ax3.f265a; i10++) {
                            for (int i11 = 0; i11 < interfaceC0059ceArrM254a.length && !interfaceC0059ceArrM254a[i11].mo71a(c0024ax3, i9); i11++) {
                            }
                            i9 += 10;
                        }
                    }
                }
            }
        }
        for (C0024ax c0024ax4 = this.f479a; c0024ax4 != null; c0024ax4 = c0024ax4.f266a) {
            if (c0024ax4.f271b) {
                c0024ax4.m114b();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m223a(AbstractC0015ao abstractC0015ao) {
        if (abstractC0015ao != null) {
            abstractC0015ao.f198a = this.f478a;
        }
        this.f478a = abstractC0015ao;
    }

    /* JADX INFO: renamed from: a */
    public final void m224a(C0024ax c0024ax) {
        if (c0024ax != null) {
            c0024ax.f266a = this.f479a;
        }
        this.f479a = c0024ax;
    }
}
