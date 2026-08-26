package p000;

/* JADX INFO: renamed from: an */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0014an implements InterfaceC0059ce {

    /* JADX INFO: renamed from: a */
    private float f184a;

    /* JADX INFO: renamed from: a */
    private boolean f185a;

    /* JADX INFO: renamed from: b */
    private float f186b;

    /* JADX INFO: renamed from: c */
    private float f187c;

    /* JADX INFO: renamed from: d */
    private float f188d;

    /* JADX INFO: renamed from: e */
    private float f189e;

    /* JADX INFO: renamed from: f */
    private float f190f;

    /* JADX INFO: renamed from: g */
    private float f191g;

    /* JADX INFO: renamed from: h */
    private float f192h;

    /* JADX INFO: renamed from: i */
    private float f193i;

    /* JADX INFO: renamed from: j */
    private float f194j;

    /* JADX INFO: renamed from: k */
    private float f195k;

    /* JADX INFO: renamed from: l */
    private float f196l;

    /* JADX INFO: renamed from: m */
    private float f197m;

    public C0014an(float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z) {
        this.f194j = f;
        this.f190f = f;
        this.f195k = f2;
        this.f191g = f2;
        this.f196l = f3;
        this.f192h = f3;
        this.f197m = f4;
        this.f193i = f4;
        this.f184a = f5;
        this.f188d = f6;
        this.f186b = f6;
        this.f189e = f7;
        this.f187c = f7;
        this.f185a = z;
    }

    @Override // p000.InterfaceC0059ce
    /* JADX INFO: renamed from: a */
    public final void mo70a(int i, int i2) {
        this.f194j = this.f190f + i;
        this.f195k = this.f191g + i;
        this.f188d = this.f186b + i;
        this.f196l = this.f192h + i2;
        this.f197m = this.f193i + i2;
        this.f189e = this.f187c + i2;
    }

    @Override // p000.InterfaceC0059ce
    /* JADX INFO: renamed from: a */
    public final boolean mo71a(C0024ax c0024ax, int i) {
        if (c0024ax.f268a[i + 4] <= this.f194j || c0024ax.f268a[i + 4] >= this.f195k || c0024ax.f268a[i + 6] <= this.f196l || c0024ax.f268a[i + 6] >= this.f197m) {
            return false;
        }
        float f = c0024ax.f268a[i + 4] - this.f188d;
        float f2 = c0024ax.f268a[i + 6] - this.f189e;
        float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
        if ((fSqrt >= this.f184a || !this.f185a) && (fSqrt <= this.f184a || this.f185a)) {
            return false;
        }
        float[] fArr = c0024ax.f268a;
        int i2 = i + 4;
        fArr[i2] = ((f * (this.f184a - fSqrt)) / fSqrt) + fArr[i2];
        float[] fArr2 = c0024ax.f268a;
        int i3 = i + 6;
        fArr2[i3] = ((f2 * (this.f184a - fSqrt)) / fSqrt) + fArr2[i3];
        float[] fArr3 = c0024ax.f268a;
        int i4 = i + 7;
        fArr3[i4] = fArr3[i4] + ((c0024ax.f268a[i + 4] - c0024ax.f268a[i + 7]) * c0024ax.f264a);
        float[] fArr4 = c0024ax.f268a;
        int i5 = i + 8;
        fArr4[i5] = fArr4[i5] + ((c0024ax.f268a[i + 5] - c0024ax.f268a[i + 8]) * c0024ax.f264a);
        float[] fArr5 = c0024ax.f268a;
        int i6 = i + 9;
        fArr5[i6] = fArr5[i6] + ((c0024ax.f268a[i + 6] - c0024ax.f268a[i + 9]) * c0024ax.f264a);
        c0024ax.f267a = true;
        return false;
    }
}
