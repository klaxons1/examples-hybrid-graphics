package p000;

/* JADX INFO: renamed from: ch */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0062ch implements InterfaceC0059ce {

    /* JADX INFO: renamed from: a */
    private float f420a;

    /* JADX INFO: renamed from: b */
    private float f421b;

    /* JADX INFO: renamed from: c */
    private float f422c;

    /* JADX INFO: renamed from: d */
    private float f423d;

    /* JADX INFO: renamed from: e */
    private float f424e;

    /* JADX INFO: renamed from: f */
    private float f425f;

    /* JADX INFO: renamed from: g */
    private float f426g;

    /* JADX INFO: renamed from: h */
    private float f427h;

    public C0062ch(float f, float f2, float f3, float f4) {
        this.f424e = f;
        this.f420a = f;
        this.f425f = f2;
        this.f421b = f2;
        this.f426g = f3;
        this.f422c = f3;
        this.f427h = f4;
        this.f423d = f4;
    }

    @Override // p000.InterfaceC0059ce
    /* JADX INFO: renamed from: a */
    public final void mo70a(int i, int i2) {
        this.f424e = this.f420a + i;
        this.f425f = this.f421b + i;
        this.f426g = this.f422c + i2;
        this.f427h = this.f423d + i2;
    }

    @Override // p000.InterfaceC0059ce
    /* JADX INFO: renamed from: a */
    public final boolean mo71a(C0024ax c0024ax, int i) {
        if (c0024ax.f268a[i + 4] > this.f424e && c0024ax.f268a[i + 4] < this.f425f && c0024ax.f268a[i + 6] > this.f426g && c0024ax.f268a[i + 6] < this.f427h) {
            if (Math.min(c0024ax.f268a[i + 4] - this.f424e, this.f425f - c0024ax.f268a[i + 4]) < Math.min(c0024ax.f268a[i + 6] - this.f426g, this.f427h - c0024ax.f268a[i + 6])) {
                if (c0024ax.f268a[i + 4] - this.f424e < this.f425f - c0024ax.f268a[i + 4]) {
                    c0024ax.f268a[i + 4] = this.f424e;
                } else {
                    c0024ax.f268a[i + 4] = this.f425f;
                }
            } else if (c0024ax.f268a[i + 6] - this.f426g < this.f427h - c0024ax.f268a[i + 6]) {
                c0024ax.f268a[i + 6] = this.f426g;
            } else {
                c0024ax.f268a[i + 6] = this.f427h;
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
