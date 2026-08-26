package p000;

/* JADX INFO: renamed from: ae */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0005ae {

    /* JADX INFO: renamed from: a */
    public int f30a;

    /* JADX INFO: renamed from: b */
    public int f31b;

    /* JADX INFO: renamed from: c */
    public int f32c;

    public C0005ae() {
        this.f32c = 0;
        this.f31b = 0;
        this.f30a = 0;
    }

    public C0005ae(int i, int i2, int i3) {
        this.f30a = i;
        this.f31b = i2;
        this.f32c = i3;
    }

    public C0005ae(C0005ae c0005ae) {
        this.f30a = c0005ae.f30a;
        this.f31b = c0005ae.f31b;
        this.f32c = c0005ae.f32c;
    }

    /* JADX INFO: renamed from: a */
    private C0005ae m25a(C0005ae c0005ae) {
        int iM204d = C0064cj.m204d((int) (((((long) this.f30a) * ((long) this.f30a)) >> 12) + ((((long) this.f31b) * ((long) this.f31b)) >> 12) + ((((long) this.f32c) * ((long) this.f32c)) >> 12)));
        c0005ae.f30a = (this.f30a * iM204d) >> 12;
        c0005ae.f31b = (this.f31b * iM204d) >> 12;
        c0005ae.f32c = (iM204d * this.f32c) >> 12;
        return c0005ae;
    }

    /* JADX INFO: renamed from: a */
    public final int m26a(C0005ae c0005ae) {
        return ((this.f30a * c0005ae.f30a) >> 12) + ((this.f31b * c0005ae.f31b) >> 12) + ((this.f32c * c0005ae.f32c) >> 12);
    }

    /* JADX INFO: renamed from: a */
    public final C0005ae m27a(C0005ae c0005ae, C0005ae c0005ae2) {
        c0005ae2.f30a = ((this.f31b * c0005ae.f32c) >> 12) - ((this.f32c * c0005ae.f31b) >> 12);
        c0005ae2.f31b = ((this.f32c * c0005ae.f30a) >> 12) - ((this.f30a * c0005ae.f32c) >> 12);
        c0005ae2.f32c = ((this.f30a * c0005ae.f31b) >> 12) - ((this.f31b * c0005ae.f30a) >> 12);
        return c0005ae2;
    }

    /* JADX INFO: renamed from: a */
    public final void m28a() {
        m25a(this);
    }

    /* JADX INFO: renamed from: a */
    public final void m29a(int i) {
        this.f30a = (int) ((((long) i) * ((long) this.f30a)) >> 12);
        this.f31b = (int) ((((long) i) * ((long) this.f31b)) >> 12);
        this.f32c = (int) ((((long) i) * ((long) this.f32c)) >> 12);
    }

    /* JADX INFO: renamed from: a */
    public final void m30a(int i, int i2, int i3) {
        this.f30a = i;
        this.f31b = i2;
        this.f32c = i3;
    }

    /* JADX INFO: renamed from: a */
    public final void m31a(C0005ae c0005ae) {
        this.f30a = c0005ae.f30a;
        this.f31b = c0005ae.f31b;
        this.f32c = c0005ae.f32c;
    }

    /* JADX INFO: renamed from: b */
    public final void m32b(C0005ae c0005ae) {
        this.f30a += c0005ae.f30a;
        this.f31b += c0005ae.f31b;
        this.f32c += c0005ae.f32c;
    }

    /* JADX INFO: renamed from: c */
    public final void m33c(C0005ae c0005ae) {
        this.f30a -= c0005ae.f30a;
        this.f31b -= c0005ae.f31b;
        this.f32c -= c0005ae.f32c;
    }

    public final String toString() {
        return new StringBuffer().append("AEVector3D | ").append(this.f30a).append(",\t").append(this.f31b).append(",\t").append(this.f32c).toString();
    }
}
