package p000;

/* JADX INFO: renamed from: cd */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0058cd implements InterfaceC0059ce {

    /* JADX INFO: renamed from: a */
    private float f411a;

    /* JADX INFO: renamed from: a */
    private short f412a;

    /* JADX INFO: renamed from: b */
    private float f413b;

    /* JADX INFO: renamed from: c */
    private float f414c;

    /* JADX INFO: renamed from: d */
    private float f415d;

    /* JADX INFO: renamed from: e */
    private float f416e;

    /* JADX INFO: renamed from: f */
    private float f417f;

    /* JADX INFO: renamed from: g */
    private float f418g;

    /* JADX INFO: renamed from: h */
    private float f419h;

    public C0058cd(float f, float f2, float f3, float f4, short s) {
        this.f412a = (short) 0;
        this.f416e = f;
        this.f411a = f;
        this.f417f = f2;
        this.f413b = f2;
        this.f418g = f3;
        this.f414c = f3;
        this.f419h = f4;
        this.f415d = f4;
        this.f412a = s;
    }

    @Override // p000.InterfaceC0059ce
    /* JADX INFO: renamed from: a */
    public final void mo70a(int i, int i2) {
        this.f416e = this.f411a + i;
        this.f417f = this.f413b + i;
        this.f418g = this.f414c + i2;
        this.f419h = this.f415d + i2;
    }

    @Override // p000.InterfaceC0059ce
    /* JADX INFO: renamed from: a */
    public final boolean mo71a(C0024ax c0024ax, int i) {
        if (c0024ax.f268a[i + 4] > this.f416e && c0024ax.f268a[i + 4] < this.f417f && c0024ax.f268a[i + 6] > this.f418g && c0024ax.f268a[i + 6] < this.f419h) {
            switch (this.f412a) {
                case 0:
                    c0024ax.f268a[i + 4] = this.f416e;
                    break;
                case 1:
                    c0024ax.f268a[i + 4] = this.f417f;
                    break;
                case 2:
                    c0024ax.f268a[i + 6] = this.f418g;
                    break;
                case 3:
                    c0024ax.f268a[i + 6] = this.f419h;
                    break;
            }
            float[] fArr = c0024ax.f268a;
            int i2 = i + 7;
            fArr[i2] = fArr[i2] + ((c0024ax.f268a[i + 4] - c0024ax.f268a[i + 7]) * c0024ax.f264a);
            float[] fArr2 = c0024ax.f268a;
            int i3 = i + 8;
            fArr2[i3] = fArr2[i3] + ((c0024ax.f268a[i + 5] - c0024ax.f268a[i + 8]) * c0024ax.f264a);
            float[] fArr3 = c0024ax.f268a;
            int i4 = i + 9;
            fArr3[i4] = fArr3[i4] + ((c0024ax.f268a[i + 6] - c0024ax.f268a[i + 9]) * c0024ax.f264a);
            c0024ax.f267a = true;
        }
        return false;
    }
}
