package p000;

/* JADX INFO: renamed from: cb */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0056cb {

    /* JADX INFO: renamed from: a */
    private int f405a;

    /* JADX INFO: renamed from: a */
    private C0024ax f406a;

    /* JADX INFO: renamed from: a */
    private float[] f407a;

    /* JADX INFO: renamed from: a */
    private int[] f408a;

    public C0056cb(C0024ax c0024ax, int[] iArr) {
        this.f406a = c0024ax;
        this.f408a = iArr;
        this.f405a = iArr.length / 2;
        this.f407a = new float[this.f405a];
    }

    /* JADX INFO: renamed from: a */
    public final void m192a() {
        for (int i = 0; i < this.f405a; i++) {
            float f = this.f406a.f268a[this.f408a[i * 2] + 1] - this.f406a.f268a[this.f408a[(i * 2) + 1] + 1];
            float f2 = this.f406a.f268a[this.f408a[i * 2] + 2] - this.f406a.f268a[this.f408a[(i * 2) + 1] + 2];
            float f3 = this.f406a.f268a[this.f408a[i * 2] + 3] - this.f406a.f268a[this.f408a[(i * 2) + 1] + 3];
            this.f407a[i] = (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3));
            float[] fArr = this.f407a;
            fArr[i] = fArr[i] * this.f407a[i];
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m193b() {
        int i = 0;
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= this.f405a) {
                return;
            }
            float f = this.f406a.f268a[this.f408a[i3 + 1] + 4] - this.f406a.f268a[this.f408a[i3] + 4];
            float f2 = this.f406a.f268a[this.f408a[i3 + 1] + 5] - this.f406a.f268a[this.f408a[i3] + 5];
            float f3 = this.f406a.f268a[this.f408a[i3 + 1] + 6] - this.f406a.f268a[this.f408a[i3] + 6];
            float f4 = ((this.f407a[i2] / ((((f * f) + (f2 * f2)) + (f3 * f3)) + this.f407a[i2])) - 0.5f) / ((this.f406a.f268a[this.f408a[i3]] + this.f406a.f268a[this.f408a[i3 + 1]]) * 0.5f);
            float[] fArr = this.f406a.f268a;
            int i4 = this.f408a[i3] + 4;
            fArr[i4] = fArr[i4] - ((f4 * f) * this.f406a.f268a[this.f408a[i3]]);
            float[] fArr2 = this.f406a.f268a;
            int i5 = this.f408a[i3] + 5;
            fArr2[i5] = fArr2[i5] - ((f4 * f2) * this.f406a.f268a[this.f408a[i3]]);
            float[] fArr3 = this.f406a.f268a;
            int i6 = this.f408a[i3] + 6;
            fArr3[i6] = fArr3[i6] - ((f4 * f3) * this.f406a.f268a[this.f408a[i3]]);
            float[] fArr4 = this.f406a.f268a;
            int i7 = this.f408a[i3 + 1] + 4;
            fArr4[i7] = (f * f4 * this.f406a.f268a[this.f408a[i3 + 1]]) + fArr4[i7];
            float[] fArr5 = this.f406a.f268a;
            int i8 = this.f408a[i3 + 1] + 5;
            fArr5[i8] = (f2 * f4 * this.f406a.f268a[this.f408a[i3 + 1]]) + fArr5[i8];
            float[] fArr6 = this.f406a.f268a;
            int i9 = this.f408a[i3 + 1] + 6;
            fArr6[i9] = (f3 * f4 * this.f406a.f268a[this.f408a[i3 + 1]]) + fArr6[i9];
            i = i3 + 2;
            i2++;
        }
    }
}
