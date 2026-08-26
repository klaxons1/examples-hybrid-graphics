package p000;

/* JADX INFO: renamed from: l */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0075l implements InterfaceC0059ce {

    /* JADX INFO: renamed from: a */
    private float f506a;

    /* JADX INFO: renamed from: b */
    private float f507b;

    /* JADX INFO: renamed from: c */
    private float f508c;

    /* JADX INFO: renamed from: d */
    private float f509d;

    /* JADX INFO: renamed from: e */
    private float f510e;

    /* JADX INFO: renamed from: f */
    private float f511f;

    /* JADX INFO: renamed from: g */
    private float f512g;

    /* JADX INFO: renamed from: h */
    private float f513h;

    /* JADX INFO: renamed from: i */
    private float f514i;

    public C0075l(float f, float f2, float f3, float f4, float f5) {
        this.f511f = f;
        this.f507b = f;
        this.f512g = f2;
        this.f508c = f2;
        this.f513h = f3;
        this.f509d = f3;
        this.f514i = f4;
        this.f510e = f4;
        this.f506a = f5;
    }

    @Override // p000.InterfaceC0059ce
    /* JADX INFO: renamed from: a */
    public final void mo70a(int i, int i2) {
        this.f511f = this.f507b + i;
        this.f512g = this.f508c + i;
        this.f513h = this.f509d + i2;
        this.f514i = this.f510e + i2;
    }

    @Override // p000.InterfaceC0059ce
    /* JADX INFO: renamed from: a */
    public final boolean mo71a(C0024ax c0024ax, int i) {
        if (c0024ax.f268a[i + 4] > this.f511f && c0024ax.f268a[i + 4] < this.f512g && c0024ax.f268a[i + 6] > this.f513h && c0024ax.f268a[i + 6] < this.f514i) {
            if (c0024ax.f268a[i + 5] < this.f506a) {
                c0024ax.f268a[i + 5] = this.f506a;
                float[] fArr = c0024ax.f268a;
                int i2 = i + 7;
                fArr[i2] = fArr[i2] + ((c0024ax.f268a[i + 4] - c0024ax.f268a[i + 7]) * c0024ax.f264a);
                float[] fArr2 = c0024ax.f268a;
                int i3 = i + 8;
                fArr2[i3] = fArr2[i3] + ((c0024ax.f268a[i + 5] - c0024ax.f268a[i + 8]) * c0024ax.f264a);
                float[] fArr3 = c0024ax.f268a;
                int i4 = i + 9;
                fArr3[i4] = fArr3[i4] + ((c0024ax.f268a[i + 6] - c0024ax.f268a[i + 9]) * c0024ax.f264a);
                c0024ax.f270a[i / 10] = true;
                return true;
            }
            c0024ax.f270a[i / 10] = false;
        }
        return false;
    }
}
