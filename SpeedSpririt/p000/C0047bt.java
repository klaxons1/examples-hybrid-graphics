package p000;

/* JADX INFO: renamed from: bt */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0047bt extends AbstractC0015ao {

    /* JADX INFO: renamed from: a */
    private float f380a;

    /* JADX INFO: renamed from: a */
    private int[] f381a = new int[12];

    /* JADX INFO: renamed from: a */
    private C0056cb[] f382a;

    /* JADX INFO: renamed from: b */
    private float f383b;

    /* JADX INFO: renamed from: c */
    private float f384c;

    /* JADX INFO: renamed from: d */
    private float f385d;

    /* JADX INFO: renamed from: e */
    private float f386e;

    /* JADX INFO: renamed from: f */
    private float f387f;

    public C0047bt(float f, float f2, float f3, float f4, float f5, float f6, float f7) {
        this.f380a = f;
        this.f383b = f2;
        this.f384c = f3;
        this.f385d = (1.0f / f) * 4096.0f;
        this.f386e = (1.0f / f2) * 4096.0f;
        this.f387f = (1.0f / f3) * 4096.0f;
        float[] fArr = new float[80];
        fArr[30] = 0.5f;
        fArr[20] = 0.5f;
        fArr[10] = 0.5f;
        fArr[0] = 0.5f;
        fArr[70] = 1.0f;
        fArr[60] = 1.0f;
        fArr[50] = 1.0f;
        fArr[40] = 1.0f;
        fArr[1] = ((-f) * 0.5f) + f4;
        fArr[2] = ((-f2) * 0.5f) + f5;
        fArr[3] = ((-f3) * 0.5f) + f6;
        fArr[11] = (0.5f * f) + f4;
        fArr[12] = ((-f2) * 0.5f) + f5;
        fArr[13] = ((-f3) * 0.5f) + f6;
        fArr[21] = (0.5f * f) + f4;
        fArr[22] = ((-f2) * 0.5f) + f5;
        fArr[23] = (0.5f * f3) + f6;
        fArr[31] = ((-f) * 0.5f) + f4;
        fArr[32] = ((-f2) * 0.5f) + f5;
        fArr[33] = (0.5f * f3) + f6;
        fArr[41] = ((-f) * 0.5f) + f4;
        fArr[42] = (0.5f * f2) + f5;
        fArr[43] = ((-f3) * 0.5f) + f6;
        fArr[51] = (0.5f * f) + f4;
        fArr[52] = (0.5f * f2) + f5;
        fArr[53] = ((-f3) * 0.5f) + f6;
        fArr[61] = (0.5f * f) + f4;
        fArr[62] = (0.5f * f2) + f5;
        fArr[63] = (0.5f * f3) + f6;
        fArr[71] = ((-f) * 0.5f) + f4;
        fArr[72] = (0.5f * f2) + f5;
        fArr[73] = (0.5f * f3) + f6;
        this.f382a = new C0056cb[1];
        ((AbstractC0015ao) this).f199a = new C0024ax(fArr, f7, this.f382a);
        this.f382a[0] = new C0056cb(((AbstractC0015ao) this).f199a, new int[]{0, 10, 10, 20, 20, 30, 30, 0, 40, 50, 50, 60, 60, 70, 70, 40, 0, 40, 10, 50, 20, 60, 30, 70, 0, 20, 10, 30, 40, 60, 50, 70, 0, 50, 10, 40, 20, 70, 30, 60, 0, 70, 30, 40, 20, 50, 10, 60, 0, 60, 10, 70, 20, 40, 30, 50});
        float f8 = ((f + f2) + f3) / 6.0f;
        ((AbstractC0015ao) this).f200a = new C0046bs(((AbstractC0015ao) this).f199a, new float[]{f8, f8, f8, f8, f8, f8, f8, f8}, new float[]{0.25f * f, 0.25f * f2, 0.25f * f3, 0.5f * f, 0.25f * f2, 0.25f * f3, 0.5f * f, 0.25f * f2, 0.5f * f3, 0.25f * f, 0.25f * f2, 0.5f * f3, 0.25f * f, 0.5f * f2, 0.25f * f3, 0.5f * f, 0.5f * f2, 0.25f * f3, 0.5f * f, 0.5f * f2, 0.5f * f3, 0.25f * f, 0.5f * f2, 0.5f * f3}, new int[]{4, 14, 24, 34, 44, 54, 64, 74});
    }

    /* JADX INFO: renamed from: a */
    public final C0005ae m161a() {
        return new C0005ae((int) (this.f380a * 0.5f), (int) (this.f383b * 0.5f), (int) (this.f384c * 0.5f));
    }

    /* JADX INFO: renamed from: a */
    public final C0073j m162a(C0073j c0073j) {
        c0073j.m231a();
        c0073j.m233a((int) ((((AbstractC0015ao) this).f199a.f268a[14] - ((AbstractC0015ao) this).f199a.f268a[4]) * this.f385d), (int) ((((AbstractC0015ao) this).f199a.f268a[44] - ((AbstractC0015ao) this).f199a.f268a[4]) * this.f386e), (int) ((((AbstractC0015ao) this).f199a.f268a[34] - ((AbstractC0015ao) this).f199a.f268a[4]) * this.f387f), (int) ((AbstractC0015ao) this).f199a.f268a[4], -((int) ((((AbstractC0015ao) this).f199a.f268a[15] - ((AbstractC0015ao) this).f199a.f268a[5]) * this.f385d)), -((int) ((((AbstractC0015ao) this).f199a.f268a[45] - ((AbstractC0015ao) this).f199a.f268a[5]) * this.f386e)), -((int) ((((AbstractC0015ao) this).f199a.f268a[35] - ((AbstractC0015ao) this).f199a.f268a[5]) * this.f387f)), -((int) ((AbstractC0015ao) this).f199a.f268a[5]), -((int) ((((AbstractC0015ao) this).f199a.f268a[16] - ((AbstractC0015ao) this).f199a.f268a[6]) * this.f385d)), -((int) ((((AbstractC0015ao) this).f199a.f268a[46] - ((AbstractC0015ao) this).f199a.f268a[6]) * this.f386e)), -((int) ((((AbstractC0015ao) this).f199a.f268a[36] - ((AbstractC0015ao) this).f199a.f268a[6]) * this.f387f)), -((int) ((AbstractC0015ao) this).f199a.f268a[6]));
        return c0073j;
    }

    @Override // p000.AbstractC0015ao
    /* JADX INFO: renamed from: a */
    public final void mo72a() {
        float f = ((AbstractC0015ao) this).f199a.f268a[4];
        float f2 = ((AbstractC0015ao) this).f199a.f268a[5];
        float f3 = ((AbstractC0015ao) this).f199a.f268a[6];
        float f4 = (this.f385d / 4096.0f) * (((AbstractC0015ao) this).f199a.f268a[14] - ((AbstractC0015ao) this).f199a.f268a[4]);
        float f5 = (this.f385d / 4096.0f) * (((AbstractC0015ao) this).f199a.f268a[15] - ((AbstractC0015ao) this).f199a.f268a[5]);
        float f6 = (this.f385d / 4096.0f) * (((AbstractC0015ao) this).f199a.f268a[16] - ((AbstractC0015ao) this).f199a.f268a[6]);
        float f7 = (this.f386e / 4096.0f) * (((AbstractC0015ao) this).f199a.f268a[44] - ((AbstractC0015ao) this).f199a.f268a[4]);
        float f8 = (this.f386e / 4096.0f) * (((AbstractC0015ao) this).f199a.f268a[45] - ((AbstractC0015ao) this).f199a.f268a[5]);
        float f9 = (this.f386e / 4096.0f) * (((AbstractC0015ao) this).f199a.f268a[46] - ((AbstractC0015ao) this).f199a.f268a[6]);
        float f10 = (this.f387f / 4096.0f) * (((AbstractC0015ao) this).f199a.f268a[34] - ((AbstractC0015ao) this).f199a.f268a[4]);
        float f11 = (this.f387f / 4096.0f) * (((AbstractC0015ao) this).f199a.f268a[35] - ((AbstractC0015ao) this).f199a.f268a[5]);
        float f12 = (this.f387f / 4096.0f) * (((AbstractC0015ao) this).f199a.f268a[36] - ((AbstractC0015ao) this).f199a.f268a[6]);
        for (int i = 0; i < ((AbstractC0015ao) this).f200a.f377a.length; i++) {
            ((AbstractC0015ao) this).f200a.f379c[i * 3] = (((AbstractC0015ao) this).f200a.f378b[i * 3] * f4) + (((AbstractC0015ao) this).f200a.f378b[(i * 3) + 1] * f7) + (((AbstractC0015ao) this).f200a.f378b[(i * 3) + 2] * f10) + f;
            ((AbstractC0015ao) this).f200a.f379c[(i * 3) + 1] = (((AbstractC0015ao) this).f200a.f378b[i * 3] * f5) + (((AbstractC0015ao) this).f200a.f378b[(i * 3) + 1] * f8) + (((AbstractC0015ao) this).f200a.f378b[(i * 3) + 2] * f11) + f2;
            ((AbstractC0015ao) this).f200a.f379c[(i * 3) + 2] = (((AbstractC0015ao) this).f200a.f378b[i * 3] * f6) + (((AbstractC0015ao) this).f200a.f378b[(i * 3) + 1] * f9) + (((AbstractC0015ao) this).f200a.f378b[(i * 3) + 2] * f12) + f3;
        }
        if (((AbstractC0015ao) this).f198a != null) {
            ((AbstractC0015ao) this).f198a.mo72a();
        }
    }

    @Override // p000.AbstractC0015ao
    /* JADX INFO: renamed from: a */
    public final void mo73a(C0046bs c0046bs) {
        for (int i = 0; i < c0046bs.f377a.length; i++) {
            for (int i2 = 0; i2 < ((AbstractC0015ao) this).f200a.f377a.length; i2++) {
                float f = c0046bs.f379c[i * 3] - ((AbstractC0015ao) this).f200a.f379c[i2 * 3];
                float f2 = c0046bs.f379c[(i * 3) + 1] - ((AbstractC0015ao) this).f200a.f379c[(i2 * 3) + 1];
                float f3 = c0046bs.f379c[(i * 3) + 2] - ((AbstractC0015ao) this).f200a.f379c[(i2 * 3) + 2];
                float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
                float f4 = (fSqrt - c0046bs.f376a[i]) - ((AbstractC0015ao) this).f200a.f376a[i2];
                if (f4 < 0.0f) {
                    float[] fArr = c0046bs.f375a.f268a;
                    int i3 = c0046bs.f377a[i];
                    fArr[i3] = (float) (((double) fArr[i3]) - (((double) ((f / fSqrt) * f4)) * 0.5d));
                    float[] fArr2 = c0046bs.f375a.f268a;
                    int i4 = c0046bs.f377a[i] + 1;
                    fArr2[i4] = (float) (((double) fArr2[i4]) - (((double) ((f2 / fSqrt) * f4)) * 0.5d));
                    float[] fArr3 = c0046bs.f375a.f268a;
                    int i5 = c0046bs.f377a[i] + 2;
                    fArr3[i5] = (float) (((double) fArr3[i5]) - (((double) ((f3 / fSqrt) * f4)) * 0.5d));
                    float[] fArr4 = ((AbstractC0015ao) this).f200a.f375a.f268a;
                    int i6 = ((AbstractC0015ao) this).f200a.f377a[i2];
                    fArr4[i6] = (float) (((double) fArr4[i6]) + (((double) ((f / fSqrt) * f4)) * 0.5d));
                    float[] fArr5 = ((AbstractC0015ao) this).f200a.f375a.f268a;
                    int i7 = ((AbstractC0015ao) this).f200a.f377a[i2] + 1;
                    fArr5[i7] = (float) (((double) fArr5[i7]) + (((double) ((f2 / fSqrt) * f4)) * 0.5d));
                    float[] fArr6 = ((AbstractC0015ao) this).f200a.f375a.f268a;
                    int i8 = ((AbstractC0015ao) this).f200a.f377a[i2] + 2;
                    fArr6[i8] = (float) ((((double) ((f3 / fSqrt) * f4)) * 0.5d) + ((double) fArr6[i8]));
                    ((AbstractC0015ao) this).f200a.f375a.f267a = true;
                    c0046bs.f375a.f267a = true;
                    break;
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m163a(C0071h c0071h) {
        c0071h.m224a(((AbstractC0015ao) this).f199a);
        c0071h.m223a(this);
    }

    /* JADX INFO: renamed from: a */
    public final void m164a(C0073j c0073j) {
        this.f381a = c0073j.m237a(this.f381a);
        float f = 2.4414062E-4f * this.f381a[0];
        float f2 = 2.4414062E-4f * (-this.f381a[4]);
        float f3 = 2.4414062E-4f * (-this.f381a[8]);
        float f4 = 2.4414062E-4f * this.f381a[1];
        float f5 = 2.4414062E-4f * (-this.f381a[5]);
        float f6 = 2.4414062E-4f * (-this.f381a[9]);
        float f7 = 2.4414062E-4f * this.f381a[2];
        float f8 = 2.4414062E-4f * (-this.f381a[6]);
        float f9 = 2.4414062E-4f * (-this.f381a[10]);
        for (int i = 0; i < ((AbstractC0015ao) this).f199a.f268a.length; i += 10) {
            float f10 = (((AbstractC0015ao) this).f199a.f268a[i + 1] * f) + (((AbstractC0015ao) this).f199a.f268a[i + 2] * f4) + (((AbstractC0015ao) this).f199a.f268a[i + 3] * f7) + this.f381a[3];
            ((AbstractC0015ao) this).f199a.f268a[i + 7] = f10;
            ((AbstractC0015ao) this).f199a.f268a[i + 4] = f10;
            float f11 = (((((AbstractC0015ao) this).f199a.f268a[i + 1] * f2) + (((AbstractC0015ao) this).f199a.f268a[i + 2] * f5)) + (((AbstractC0015ao) this).f199a.f268a[i + 3] * f8)) - this.f381a[7];
            ((AbstractC0015ao) this).f199a.f268a[i + 8] = f11;
            ((AbstractC0015ao) this).f199a.f268a[i + 5] = f11;
            float f12 = (((((AbstractC0015ao) this).f199a.f268a[i + 1] * f3) + (((AbstractC0015ao) this).f199a.f268a[i + 2] * f6)) + (((AbstractC0015ao) this).f199a.f268a[i + 3] * f9)) - this.f381a[11];
            ((AbstractC0015ao) this).f199a.f268a[i + 9] = f12;
            ((AbstractC0015ao) this).f199a.f268a[i + 6] = f12;
        }
    }

    /* JADX INFO: renamed from: a */
    public final float[] m165a(float[] fArr) {
        fArr[0] = ((((AbstractC0015ao) this).f199a.f268a[14] - ((AbstractC0015ao) this).f199a.f268a[4]) * this.f385d) / 4096.0f;
        fArr[1] = ((((AbstractC0015ao) this).f199a.f268a[15] - ((AbstractC0015ao) this).f199a.f268a[5]) * this.f385d) / 4096.0f;
        fArr[2] = ((((AbstractC0015ao) this).f199a.f268a[16] - ((AbstractC0015ao) this).f199a.f268a[6]) * this.f385d) / 4096.0f;
        fArr[3] = ((((AbstractC0015ao) this).f199a.f268a[44] - ((AbstractC0015ao) this).f199a.f268a[4]) * this.f386e) / 4096.0f;
        fArr[4] = ((((AbstractC0015ao) this).f199a.f268a[45] - ((AbstractC0015ao) this).f199a.f268a[5]) * this.f386e) / 4096.0f;
        fArr[5] = ((((AbstractC0015ao) this).f199a.f268a[46] - ((AbstractC0015ao) this).f199a.f268a[6]) * this.f386e) / 4096.0f;
        fArr[6] = ((((AbstractC0015ao) this).f199a.f268a[34] - ((AbstractC0015ao) this).f199a.f268a[4]) * this.f387f) / 4096.0f;
        fArr[7] = ((((AbstractC0015ao) this).f199a.f268a[35] - ((AbstractC0015ao) this).f199a.f268a[5]) * this.f387f) / 4096.0f;
        fArr[8] = ((((AbstractC0015ao) this).f199a.f268a[36] - ((AbstractC0015ao) this).f199a.f268a[6]) * this.f387f) / 4096.0f;
        fArr[9] = ((AbstractC0015ao) this).f199a.f268a[4];
        fArr[10] = ((AbstractC0015ao) this).f199a.f268a[5];
        fArr[11] = ((AbstractC0015ao) this).f199a.f268a[6];
        return fArr;
    }
}
