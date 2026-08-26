package p000;

/* JADX INFO: renamed from: ci */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0063ci implements InterfaceC0059ce {

    /* JADX INFO: renamed from: a */
    private float f428a;

    /* JADX INFO: renamed from: b */
    private float f429b;

    /* JADX INFO: renamed from: c */
    private float f430c;

    /* JADX INFO: renamed from: d */
    private float f431d;

    /* JADX INFO: renamed from: e */
    private float f432e;

    /* JADX INFO: renamed from: f */
    private float f433f;

    /* JADX INFO: renamed from: g */
    private float f434g;

    /* JADX INFO: renamed from: h */
    private float f435h;

    /* JADX INFO: renamed from: i */
    private float f436i;

    /* JADX INFO: renamed from: j */
    private float f437j;

    /* JADX INFO: renamed from: k */
    private float f438k;

    /* JADX INFO: renamed from: l */
    private float f439l;

    /* JADX INFO: renamed from: m */
    private float f440m;

    /* JADX INFO: renamed from: n */
    private float f441n;

    /* JADX INFO: renamed from: o */
    private float f442o;

    /* JADX INFO: renamed from: p */
    private float f443p;

    /* JADX INFO: renamed from: q */
    private float f444q;

    public C0063ci(float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13) {
        this.f432e = f;
        this.f428a = f;
        this.f433f = f2;
        this.f429b = f2;
        this.f434g = f3;
        this.f430c = f3;
        this.f435h = f4;
        this.f431d = f4;
        this.f442o = f5;
        this.f443p = f6;
        this.f444q = f7;
        this.f439l = ((f9 - f6) * (f13 - f7)) - ((f10 - f7) * (f12 - f6));
        this.f440m = ((f10 - f7) * (f11 - f5)) - ((f8 - f5) * (f13 - f7));
        this.f441n = ((f8 - f5) * (f12 - f6)) - ((f9 - f6) * (f11 - f5));
        float fSqrt = (float) Math.sqrt((this.f439l * this.f439l) + (this.f440m * this.f440m) + (this.f441n * this.f441n));
        this.f439l /= fSqrt;
        this.f440m /= fSqrt;
        this.f441n /= fSqrt;
        this.f438k = ((((-this.f439l) * f5) - (this.f440m * f6)) - (this.f441n * f7)) / this.f440m;
        this.f436i = this.f439l / this.f440m;
        this.f437j = this.f441n / this.f440m;
    }

    @Override // p000.InterfaceC0059ce
    /* JADX INFO: renamed from: a */
    public final void mo70a(int i, int i2) {
        this.f432e = this.f428a + i;
        this.f433f = this.f429b + i;
        this.f434g = this.f430c + i2;
        this.f435h = this.f431d + i2;
        this.f438k = ((((-this.f439l) * (this.f442o + i)) - (this.f440m * this.f443p)) - (this.f441n * (this.f444q + i2))) / this.f440m;
    }

    @Override // p000.InterfaceC0059ce
    /* JADX INFO: renamed from: a */
    public final boolean mo71a(C0024ax c0024ax, int i) {
        if (c0024ax.f268a[i + 4] > this.f432e && c0024ax.f268a[i + 4] < this.f433f && c0024ax.f268a[i + 6] > this.f434g && c0024ax.f268a[i + 6] < this.f435h) {
            float f = (this.f436i * c0024ax.f268a[i + 4]) + c0024ax.f268a[i + 5] + (this.f437j * c0024ax.f268a[i + 6]) + this.f438k;
            if (f < 0.0f) {
                float[] fArr = c0024ax.f268a;
                int i2 = i + 4;
                fArr[i2] = fArr[i2] + (this.f439l * f);
                float[] fArr2 = c0024ax.f268a;
                int i3 = i + 5;
                fArr2[i3] = fArr2[i3] + (this.f440m * f);
                float[] fArr3 = c0024ax.f268a;
                int i4 = i + 6;
                fArr3[i4] = (f * this.f441n) + fArr3[i4];
                float[] fArr4 = c0024ax.f268a;
                int i5 = i + 7;
                fArr4[i5] = fArr4[i5] + ((c0024ax.f268a[i + 4] - c0024ax.f268a[i + 7]) * c0024ax.f264a);
                float[] fArr5 = c0024ax.f268a;
                int i6 = i + 8;
                fArr5[i6] = fArr5[i6] + ((c0024ax.f268a[i + 5] - c0024ax.f268a[i + 8]) * c0024ax.f264a);
                float[] fArr6 = c0024ax.f268a;
                int i7 = i + 9;
                fArr6[i7] = fArr6[i7] + ((c0024ax.f268a[i + 6] - c0024ax.f268a[i + 9]) * c0024ax.f264a);
                c0024ax.f270a[i / 10] = true;
                return true;
            }
            c0024ax.f270a[i / 10] = false;
        }
        return false;
    }
}
