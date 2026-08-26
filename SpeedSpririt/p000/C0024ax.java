package p000;

/* JADX INFO: renamed from: ax */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0024ax {

    /* JADX INFO: renamed from: a */
    public float f264a;

    /* JADX INFO: renamed from: a */
    public int f265a;

    /* JADX INFO: renamed from: a */
    public boolean f267a;

    /* JADX INFO: renamed from: a */
    public float[] f268a;

    /* JADX INFO: renamed from: a */
    private C0056cb[] f269a;

    /* JADX INFO: renamed from: a */
    public boolean[] f270a;

    /* JADX INFO: renamed from: c */
    public boolean f272c = false;

    /* JADX INFO: renamed from: a */
    public C0024ax f266a = null;

    /* JADX INFO: renamed from: b */
    public boolean f271b = true;

    public C0024ax(float[] fArr, float f, C0056cb[] c0056cbArr) {
        this.f269a = c0056cbArr;
        this.f268a = fArr;
        this.f264a = f;
        this.f265a = fArr.length / 10;
        this.f270a = new boolean[this.f265a];
    }

    /* JADX INFO: renamed from: a */
    public final void m113a() {
        for (int i = 0; i < this.f265a; i++) {
            float f = this.f268a[(i * 10) + 1];
            this.f268a[(i * 10) + 7] = f;
            this.f268a[(i * 10) + 4] = f;
            float f2 = this.f268a[(i * 10) + 2];
            this.f268a[(i * 10) + 8] = f2;
            this.f268a[(i * 10) + 5] = f2;
            float f3 = this.f268a[(i * 10) + 3];
            this.f268a[(i * 10) + 9] = f3;
            this.f268a[(i * 10) + 6] = f3;
            this.f270a[i] = false;
        }
        for (int i2 = 0; i2 < this.f269a.length; i2++) {
            this.f269a[i2].m192a();
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m114b() {
        if (this.f269a != null) {
            for (int i = 0; i < this.f269a.length; i++) {
                this.f269a[i].m193b();
            }
        }
    }
}
