package p000;

/* JADX INFO: renamed from: al */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0012al implements InterfaceC0059ce {

    /* JADX INFO: renamed from: a */
    private float f171a;

    /* JADX INFO: renamed from: a */
    private short f172a;

    /* JADX INFO: renamed from: b */
    private float f173b;

    /* JADX INFO: renamed from: c */
    private float f174c;

    /* JADX INFO: renamed from: d */
    private float f175d;

    /* JADX INFO: renamed from: e */
    private float f176e;

    /* JADX INFO: renamed from: f */
    private float f177f;

    /* JADX INFO: renamed from: g */
    private float f178g;

    /* JADX INFO: renamed from: h */
    private float f179h;

    /* JADX INFO: renamed from: i */
    private float f180i;

    /* JADX INFO: renamed from: j */
    private float f181j;

    /* JADX INFO: renamed from: k */
    private float f182k;

    /* JADX INFO: renamed from: l */
    private float f183l;

    public C0012al(float f, float f2, float f3, float f4, short s) {
        this.f176e = f;
        this.f171a = f;
        this.f178g = f3;
        this.f174c = f3;
        this.f177f = f2;
        this.f173b = f2;
        this.f179h = f4;
        this.f175d = f4;
        this.f180i = f2 - f;
        this.f181j = f4 - f3;
        this.f182k = this.f180i / this.f181j;
        this.f183l = this.f181j / this.f180i;
        this.f172a = s;
    }

    @Override // p000.InterfaceC0059ce
    /* JADX INFO: renamed from: a */
    public final void mo70a(int i, int i2) {
        this.f176e = this.f171a + i;
        this.f177f = this.f173b + i;
        this.f178g = this.f174c + i2;
        this.f179h = this.f175d + i2;
    }

    @Override // p000.InterfaceC0059ce
    /* JADX INFO: renamed from: a */
    public final boolean mo71a(C0024ax c0024ax, int i) {
        if (c0024ax.f268a[i + 4] <= this.f176e || c0024ax.f268a[i + 4] >= this.f177f || c0024ax.f268a[i + 6] <= this.f178g || c0024ax.f268a[i + 6] >= this.f179h) {
            return false;
        }
        switch (this.f172a) {
            case 0:
                float f = c0024ax.f268a[i + 4];
                float f2 = ((c0024ax.f268a[i + 6] - (this.f182k * f)) - (this.f178g + (this.f183l * this.f177f))) / ((-this.f183l) - this.f182k);
                float f3 = ((-this.f183l) * f) + this.f178g + (this.f183l * this.f177f);
                if (f2 < f) {
                    c0024ax.f268a[i + 4] = f2;
                    c0024ax.f268a[i + 6] = f3;
                    c0024ax.f267a = true;
                }
                break;
            case 1:
                float f4 = c0024ax.f268a[i + 4];
                float f5 = ((c0024ax.f268a[i + 6] + (this.f182k * f4)) - (this.f178g - (this.f183l * this.f176e))) / (this.f183l + this.f182k);
                float f6 = ((this.f183l * f4) + this.f178g) - (this.f183l * this.f176e);
                if (f5 < f4) {
                    c0024ax.f268a[i + 4] = f5;
                    c0024ax.f268a[i + 6] = f6;
                    c0024ax.f267a = true;
                }
                break;
            case 2:
                float f7 = c0024ax.f268a[i + 4];
                float f8 = ((c0024ax.f268a[i + 6] + (this.f182k * f7)) - (this.f178g - (this.f183l * this.f176e))) / (this.f183l + this.f182k);
                float f9 = ((this.f183l * f7) + this.f178g) - (this.f183l * this.f176e);
                if (f8 > f7) {
                    c0024ax.f268a[i + 4] = f8;
                    c0024ax.f268a[i + 6] = f9;
                    c0024ax.f267a = true;
                }
                break;
            case 3:
                float f10 = c0024ax.f268a[i + 4];
                float f11 = ((c0024ax.f268a[i + 6] - (this.f182k * f10)) - (this.f178g + (this.f183l * this.f177f))) / ((-this.f183l) - this.f182k);
                float f12 = ((-this.f183l) * f10) + this.f178g + (this.f183l * this.f177f);
                if (f11 > f10) {
                    c0024ax.f268a[i + 4] = f11;
                    c0024ax.f268a[i + 6] = f12;
                    c0024ax.f267a = true;
                }
                break;
        }
        return false;
    }
}
