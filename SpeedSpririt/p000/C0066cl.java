package p000;

/* JADX INFO: renamed from: cl */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0066cl {

    /* JADX INFO: renamed from: a */
    public int f453a;

    /* JADX INFO: renamed from: a */
    public C0005ae f454a;

    public C0066cl() {
        this(0, 0, 0, 0);
    }

    private C0066cl(int i, int i2, int i3, int i4) {
        this.f454a = new C0005ae(i, i2, i3);
        this.f453a = i4;
    }

    /* JADX INFO: renamed from: a */
    private C0066cl m210a(C0066cl c0066cl, C0066cl c0066cl2) {
        if (this.f453a == 0) {
            c0066cl2.m212b(c0066cl);
        } else if (c0066cl.f453a == 0) {
            c0066cl2.m212b(this);
        } else {
            int i = c0066cl.f454a.f30a - this.f454a.f30a;
            int i2 = c0066cl.f454a.f31b - this.f454a.f31b;
            int i3 = c0066cl.f454a.f32c - this.f454a.f32c;
            int i4 = c0066cl.f453a - this.f453a;
            int i5 = (i * i) + (i2 * i2) + (i3 * i3);
            if (i4 * i4 < i5) {
                int iM201a = C0064cj.m201a(((long) i5) << 12);
                int i6 = (int) ((((long) ((i4 << 12) + iM201a)) << 12) / ((long) (iM201a * 2)));
                c0066cl2.m213a(((int) ((((long) i6) * (((long) i) << 12)) >> 24)) + this.f454a.f30a, ((int) ((((long) i6) * (((long) i2) << 12)) >> 24)) + this.f454a.f31b, ((int) (((((long) i3) << 12) * ((long) i6)) >> 24)) + this.f454a.f32c, ((iM201a >> 12) + (c0066cl.f453a + this.f453a)) >> 1);
            } else if (i4 >= 0) {
                c0066cl2.m211a(c0066cl.f454a, c0066cl.f453a);
            } else {
                c0066cl2.m211a(this.f454a, this.f453a);
            }
        }
        return c0066cl2;
    }

    /* JADX INFO: renamed from: a */
    private void m211a(C0005ae c0005ae, int i) {
        this.f454a.m31a(c0005ae);
        this.f453a = i;
    }

    /* JADX INFO: renamed from: b */
    private void m212b(C0066cl c0066cl) {
        this.f454a.m31a(c0066cl.f454a);
        this.f453a = c0066cl.f453a;
    }

    /* JADX INFO: renamed from: a */
    public final void m213a(int i, int i2, int i3, int i4) {
        this.f454a.f30a = i;
        this.f454a.f31b = i2;
        this.f454a.f32c = i3;
        this.f453a = i4;
    }

    /* JADX INFO: renamed from: a */
    public final void m214a(C0066cl c0066cl) {
        m210a(c0066cl, this);
    }

    public final String toString() {
        return new StringBuffer().append("AEBoundingSphere | x: ").append(this.f454a.f30a).append(" y: ").append(this.f454a.f31b).append(" z: ").append(this.f454a.f32c).append(" r: ").append(this.f453a).toString();
    }
}
