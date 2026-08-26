package p000;

/* JADX INFO: renamed from: j */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0073j {

    /* JADX INFO: renamed from: a */
    private int f484a;

    /* JADX INFO: renamed from: a */
    private short f485a;

    /* JADX INFO: renamed from: a */
    private boolean f486a;

    /* JADX INFO: renamed from: a */
    public int[] f487a;

    /* JADX INFO: renamed from: b */
    private int f488b;

    /* JADX INFO: renamed from: b */
    private int[] f489b;

    /* JADX INFO: renamed from: c */
    private int f490c;

    /* JADX INFO: renamed from: c */
    private int[] f491c;

    public C0073j() {
        new C0005ae();
        this.f487a = new int[3];
        this.f489b = new int[9];
        this.f491c = new int[3];
        m231a();
        this.f485a = (short) 4;
    }

    /* JADX INFO: renamed from: b */
    private void m225b() {
        switch (this.f485a) {
            case 0:
                this.f488b = C0064cj.m203c(this.f489b[6]);
                if (this.f488b >= 2048) {
                    this.f484a = C0064cj.m200a(this.f489b[1], this.f489b[4]);
                    this.f490c = 0;
                } else if (this.f488b <= -2048) {
                    this.f484a = -C0064cj.m200a(this.f489b[1], this.f489b[4]);
                    this.f490c = 0;
                } else {
                    this.f484a = C0064cj.m200a(-this.f489b[7], this.f489b[8]);
                    this.f490c = C0064cj.m200a(-this.f489b[3], this.f489b[0]);
                }
                break;
            case 1:
                this.f490c = C0064cj.m203c(-this.f489b[3]);
                if (this.f490c >= 2048) {
                    this.f484a = C0064cj.m200a(-this.f489b[2], this.f489b[8]);
                    this.f488b = 0;
                } else if (this.f490c <= -2048) {
                    this.f484a = -C0064cj.m200a(-this.f489b[2], this.f489b[8]);
                    this.f488b = 0;
                } else {
                    this.f484a = C0064cj.m200a(this.f489b[5], this.f489b[4]);
                    this.f488b = C0064cj.m200a(this.f489b[6], this.f489b[0]);
                }
                break;
            case 2:
                this.f484a = C0064cj.m203c(-this.f489b[7]);
                if (this.f484a >= 2048) {
                    this.f488b = C0064cj.m200a(-this.f489b[3], this.f489b[0]);
                    this.f490c = 0;
                } else if (this.f484a <= -2048) {
                    this.f488b = -C0064cj.m200a(-this.f489b[3], this.f489b[0]);
                    this.f490c = 0;
                } else {
                    this.f488b = C0064cj.m200a(this.f489b[6], this.f489b[8]);
                    this.f490c = C0064cj.m200a(this.f489b[1], this.f489b[4]);
                }
                break;
            case 3:
                this.f490c = C0064cj.m203c(this.f489b[1]);
                if (this.f490c >= 2048) {
                    this.f488b = C0064cj.m200a(this.f489b[5], this.f489b[8]);
                    this.f484a = 0;
                } else if (this.f490c <= -2048) {
                    this.f488b = -C0064cj.m200a(this.f489b[5], this.f489b[8]);
                    this.f484a = 0;
                } else {
                    this.f488b = C0064cj.m200a(-this.f489b[2], this.f489b[0]);
                    this.f484a = C0064cj.m200a(-this.f489b[7], this.f489b[4]);
                }
                break;
            case 4:
                this.f484a = C0064cj.m203c(this.f489b[5]);
                if (this.f484a >= 2048) {
                    this.f490c = C0064cj.m200a(this.f489b[6], this.f489b[0]);
                    this.f488b = 0;
                } else if (this.f484a <= -2048) {
                    this.f490c = -C0064cj.m200a(this.f489b[6], this.f489b[0]);
                    this.f488b = 0;
                } else {
                    this.f490c = C0064cj.m200a(-this.f489b[3], this.f489b[4]);
                    this.f488b = C0064cj.m200a(-this.f489b[2], this.f489b[8]);
                }
                break;
            case 5:
                this.f488b = C0064cj.m203c(-this.f489b[2]);
                if (this.f488b >= 2048) {
                    this.f490c = C0064cj.m200a(-this.f489b[3], this.f489b[6]);
                    this.f484a = 0;
                } else if (this.f488b <= -2048) {
                    this.f490c = -C0064cj.m200a(-this.f489b[3], this.f489b[6]);
                    this.f484a = 0;
                } else {
                    this.f490c = C0064cj.m200a(this.f489b[1], this.f489b[0]);
                    this.f484a = C0064cj.m200a(this.f489b[5], this.f489b[8]);
                }
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    public final int m226a() {
        return this.f491c[0];
    }

    /* JADX INFO: renamed from: a */
    public final C0005ae m227a() {
        return new C0005ae(this.f491c[0], this.f491c[1], this.f491c[2]);
    }

    /* JADX INFO: renamed from: a */
    public final C0005ae m228a(C0005ae c0005ae) {
        c0005ae.f30a = this.f491c[0];
        c0005ae.f31b = this.f491c[1];
        c0005ae.f32c = this.f491c[2];
        return c0005ae;
    }

    /* JADX INFO: renamed from: a */
    public final C0073j m229a(C0073j c0073j) {
        c0073j.f487a[0] = 16777216 / this.f487a[0];
        c0073j.f487a[1] = 16777216 / this.f487a[1];
        c0073j.f487a[2] = 16777216 / this.f487a[2];
        c0073j.f489b[0] = this.f489b[0];
        c0073j.f489b[3] = this.f489b[1];
        c0073j.f489b[6] = this.f489b[2];
        c0073j.f489b[1] = this.f489b[3];
        c0073j.f489b[4] = this.f489b[4];
        c0073j.f489b[7] = this.f489b[5];
        c0073j.f489b[2] = this.f489b[6];
        c0073j.f489b[5] = this.f489b[7];
        c0073j.f489b[8] = this.f489b[8];
        c0073j.f491c[0] = (c0073j.f487a[0] * (((-((c0073j.f489b[0] * this.f491c[0]) >> 12)) - ((c0073j.f489b[3] * this.f491c[1]) >> 12)) - ((c0073j.f489b[6] * this.f491c[2]) >> 12))) >> 12;
        c0073j.f491c[1] = (c0073j.f487a[1] * (((-((c0073j.f489b[1] * this.f491c[0]) >> 12)) - ((c0073j.f489b[4] * this.f491c[1]) >> 12)) - ((c0073j.f489b[7] * this.f491c[2]) >> 12))) >> 12;
        c0073j.f491c[2] = (c0073j.f487a[2] * (((-((c0073j.f489b[2] * this.f491c[0]) >> 12)) - ((c0073j.f489b[5] * this.f491c[1]) >> 12)) - ((c0073j.f489b[8] * this.f491c[2]) >> 12))) >> 12;
        c0073j.f486a = true;
        return c0073j;
    }

    /* JADX INFO: renamed from: a */
    public final C0073j m230a(C0073j c0073j, C0073j c0073j2) {
        c0073j2.f491c[0] = this.f491c[0] + ((this.f487a[0] * ((((this.f489b[0] * c0073j.f491c[0]) >> 12) + ((this.f489b[3] * c0073j.f491c[1]) >> 12)) + ((this.f489b[6] * c0073j.f491c[2]) >> 12))) >> 12);
        c0073j2.f491c[1] = this.f491c[1] + ((this.f487a[1] * ((((this.f489b[1] * c0073j.f491c[0]) >> 12) + ((this.f489b[4] * c0073j.f491c[1]) >> 12)) + ((this.f489b[7] * c0073j.f491c[2]) >> 12))) >> 12);
        c0073j2.f491c[2] = this.f491c[2] + ((this.f487a[2] * ((((this.f489b[2] * c0073j.f491c[0]) >> 12) + ((this.f489b[5] * c0073j.f491c[1]) >> 12)) + ((this.f489b[8] * c0073j.f491c[2]) >> 12))) >> 12);
        c0073j2.f487a[0] = (this.f487a[0] * c0073j.f487a[0]) >> 12;
        c0073j2.f487a[1] = (this.f487a[1] * c0073j.f487a[1]) >> 12;
        c0073j2.f487a[2] = (this.f487a[2] * c0073j.f487a[2]) >> 12;
        c0073j2.f489b[0] = ((this.f489b[0] * c0073j.f489b[0]) >> 12) + ((this.f489b[3] * c0073j.f489b[1]) >> 12) + ((this.f489b[6] * c0073j.f489b[2]) >> 12);
        c0073j2.f489b[1] = ((this.f489b[1] * c0073j.f489b[0]) >> 12) + ((this.f489b[4] * c0073j.f489b[1]) >> 12) + ((this.f489b[7] * c0073j.f489b[2]) >> 12);
        c0073j2.f489b[2] = ((this.f489b[2] * c0073j.f489b[0]) >> 12) + ((this.f489b[5] * c0073j.f489b[1]) >> 12) + ((this.f489b[8] * c0073j.f489b[2]) >> 12);
        c0073j2.f489b[3] = ((this.f489b[0] * c0073j.f489b[3]) >> 12) + ((this.f489b[3] * c0073j.f489b[4]) >> 12) + ((this.f489b[6] * c0073j.f489b[5]) >> 12);
        c0073j2.f489b[4] = ((this.f489b[1] * c0073j.f489b[3]) >> 12) + ((this.f489b[4] * c0073j.f489b[4]) >> 12) + ((this.f489b[7] * c0073j.f489b[5]) >> 12);
        c0073j2.f489b[5] = ((this.f489b[2] * c0073j.f489b[3]) >> 12) + ((this.f489b[5] * c0073j.f489b[4]) >> 12) + ((this.f489b[8] * c0073j.f489b[5]) >> 12);
        c0073j2.f489b[6] = ((this.f489b[0] * c0073j.f489b[6]) >> 12) + ((this.f489b[3] * c0073j.f489b[7]) >> 12) + ((this.f489b[6] * c0073j.f489b[8]) >> 12);
        c0073j2.f489b[7] = ((this.f489b[1] * c0073j.f489b[6]) >> 12) + ((this.f489b[4] * c0073j.f489b[7]) >> 12) + ((this.f489b[7] * c0073j.f489b[8]) >> 12);
        c0073j2.f489b[8] = ((this.f489b[2] * c0073j.f489b[6]) >> 12) + ((this.f489b[5] * c0073j.f489b[7]) >> 12) + ((this.f489b[8] * c0073j.f489b[8]) >> 12);
        c0073j2.f486a = true;
        return c0073j2;
    }

    /* JADX INFO: renamed from: a */
    public final void m231a() {
        int[] iArr = this.f487a;
        int[] iArr2 = this.f487a;
        this.f487a[2] = 4096;
        iArr2[1] = 4096;
        iArr[0] = 4096;
        this.f489b[0] = 4096;
        this.f489b[3] = 0;
        this.f489b[6] = 0;
        this.f489b[1] = 0;
        this.f489b[4] = 4096;
        this.f489b[7] = 0;
        this.f489b[2] = 0;
        this.f489b[5] = 0;
        this.f489b[8] = 4096;
        int[] iArr3 = this.f491c;
        int[] iArr4 = this.f491c;
        this.f491c[2] = 0;
        iArr4[1] = 0;
        iArr3[0] = 0;
        this.f490c = 0;
        this.f488b = 0;
        this.f484a = 0;
        this.f486a = false;
    }

    /* JADX INFO: renamed from: a */
    public final void m232a(int i, int i2, int i3) {
        int[] iArr = this.f491c;
        iArr[0] = iArr[0] + i;
        int[] iArr2 = this.f491c;
        iArr2[1] = iArr2[1] + i2;
        int[] iArr3 = this.f491c;
        iArr3[2] = iArr3[2] + i3;
    }

    /* JADX INFO: renamed from: a */
    public final void m233a(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        int[] iArr = this.f487a;
        int[] iArr2 = this.f487a;
        this.f487a[2] = 4096;
        iArr2[1] = 4096;
        iArr[0] = 4096;
        this.f489b[0] = i;
        this.f489b[3] = i2;
        this.f489b[6] = i3;
        this.f491c[0] = i4;
        this.f489b[1] = -i5;
        this.f489b[4] = -i6;
        this.f489b[7] = -i7;
        this.f491c[1] = -i8;
        this.f489b[2] = -i9;
        this.f489b[5] = -i10;
        this.f489b[8] = -i11;
        this.f491c[2] = -i12;
        this.f486a = true;
    }

    /* JADX INFO: renamed from: a */
    public final void m234a(C0005ae c0005ae, C0005ae c0005ae2, C0005ae c0005ae3) {
        this.f489b[0] = c0005ae.f30a;
        this.f489b[3] = c0005ae2.f30a;
        this.f489b[6] = c0005ae3.f30a;
        this.f489b[1] = c0005ae.f31b;
        this.f489b[4] = c0005ae2.f31b;
        this.f489b[7] = c0005ae3.f31b;
        this.f489b[2] = c0005ae.f32c;
        this.f489b[5] = c0005ae2.f32c;
        this.f489b[8] = c0005ae3.f32c;
        this.f486a = true;
    }

    /* JADX INFO: renamed from: a */
    public final void m235a(C0073j c0073j) {
        System.arraycopy(c0073j.f487a, 0, this.f487a, 0, this.f487a.length);
        System.arraycopy(c0073j.f489b, 0, this.f489b, 0, this.f489b.length);
        System.arraycopy(c0073j.f491c, 0, this.f491c, 0, this.f491c.length);
        this.f484a = c0073j.f484a;
        this.f488b = c0073j.f488b;
        this.f490c = c0073j.f490c;
        this.f486a = c0073j.f486a;
    }

    /* JADX INFO: renamed from: a */
    public final void m236a(float[] fArr) {
        fArr[0] = this.f487a[0] * this.f489b[0] * 5.9604645E-8f;
        fArr[1] = this.f487a[1] * this.f489b[3] * 5.9604645E-8f;
        fArr[2] = this.f487a[2] * this.f489b[6] * 5.9604645E-8f;
        fArr[3] = this.f491c[0];
        fArr[4] = this.f487a[0] * this.f489b[1] * 5.9604645E-8f;
        fArr[5] = this.f487a[1] * this.f489b[4] * 5.9604645E-8f;
        fArr[6] = this.f487a[2] * this.f489b[7] * 5.9604645E-8f;
        fArr[7] = this.f491c[1];
        fArr[8] = this.f487a[0] * this.f489b[2] * 5.9604645E-8f;
        fArr[9] = this.f487a[1] * this.f489b[5] * 5.9604645E-8f;
        fArr[10] = this.f487a[2] * this.f489b[8] * 5.9604645E-8f;
        fArr[11] = this.f491c[2];
        fArr[12] = 0.0f;
        fArr[13] = 0.0f;
        fArr[14] = 0.0f;
        fArr[15] = 1.0f;
    }

    /* JADX INFO: renamed from: a */
    public final int[] m237a(int[] iArr) {
        iArr[0] = (this.f487a[0] * this.f489b[0]) >> 12;
        iArr[1] = (this.f487a[1] * this.f489b[3]) >> 12;
        iArr[2] = (this.f487a[2] * this.f489b[6]) >> 12;
        iArr[3] = this.f491c[0];
        iArr[4] = -((this.f487a[0] * this.f489b[1]) >> 12);
        iArr[5] = -((this.f487a[1] * this.f489b[4]) >> 12);
        iArr[6] = -((this.f487a[2] * this.f489b[7]) >> 12);
        iArr[7] = -this.f491c[1];
        iArr[8] = -((this.f487a[0] * this.f489b[2]) >> 12);
        iArr[9] = -((this.f487a[1] * this.f489b[5]) >> 12);
        iArr[10] = -((this.f487a[2] * this.f489b[8]) >> 12);
        iArr[11] = -this.f491c[2];
        return iArr;
    }

    /* JADX INFO: renamed from: a */
    public final C0005ae[] m238a(C0005ae[] c0005aeArr, C0005ae[] c0005aeArr2) {
        for (int length = c0005aeArr2.length - 1; length >= 0; length--) {
            c0005aeArr2[length].f30a = ((this.f489b[0] * c0005aeArr[length].f30a) >> 12) + ((this.f489b[3] * c0005aeArr[length].f31b) >> 12) + ((this.f489b[6] * c0005aeArr[length].f32c) >> 12);
            c0005aeArr2[length].f31b = ((this.f489b[1] * c0005aeArr[length].f30a) >> 12) + ((this.f489b[4] * c0005aeArr[length].f31b) >> 12) + ((this.f489b[7] * c0005aeArr[length].f32c) >> 12);
            c0005aeArr2[length].f32c = ((this.f489b[2] * c0005aeArr[length].f30a) >> 12) + ((this.f489b[5] * c0005aeArr[length].f31b) >> 12) + ((this.f489b[8] * c0005aeArr[length].f32c) >> 12);
        }
        return c0005aeArr2;
    }

    /* JADX INFO: renamed from: b */
    public final int m239b() {
        return this.f491c[1];
    }

    /* JADX INFO: renamed from: b */
    public final C0005ae m240b() {
        return new C0005ae(this.f489b[3], this.f489b[4], this.f489b[5]);
    }

    /* JADX INFO: renamed from: b */
    public final C0005ae m241b(C0005ae c0005ae) {
        c0005ae.f30a = this.f489b[6];
        c0005ae.f31b = this.f489b[7];
        c0005ae.f32c = this.f489b[8];
        return c0005ae;
    }

    /* JADX INFO: renamed from: b */
    public final void m242b(int i, int i2, int i3) {
        this.f491c[0] = i;
        this.f491c[1] = i2;
        this.f491c[2] = i3;
    }

    /* JADX INFO: renamed from: b */
    public final void m243b(C0073j c0073j) {
        int i = this.f489b[0];
        int i2 = this.f489b[3];
        int i3 = this.f489b[6];
        int i4 = this.f489b[1];
        int i5 = this.f489b[4];
        int i6 = this.f489b[7];
        int i7 = this.f489b[2];
        int i8 = this.f489b[5];
        int i9 = this.f489b[8];
        int[] iArr = this.f491c;
        iArr[0] = iArr[0] + ((this.f487a[0] * ((((this.f489b[0] * c0073j.f491c[0]) >> 12) + ((this.f489b[3] * c0073j.f491c[1]) >> 12)) + ((this.f489b[6] * c0073j.f491c[2]) >> 12))) >> 12);
        int[] iArr2 = this.f491c;
        iArr2[1] = iArr2[1] + ((this.f487a[1] * ((((this.f489b[1] * c0073j.f491c[0]) >> 12) + ((this.f489b[4] * c0073j.f491c[1]) >> 12)) + ((this.f489b[7] * c0073j.f491c[2]) >> 12))) >> 12);
        int[] iArr3 = this.f491c;
        iArr3[2] = iArr3[2] + ((this.f487a[2] * ((((this.f489b[2] * c0073j.f491c[0]) >> 12) + ((this.f489b[5] * c0073j.f491c[1]) >> 12)) + ((this.f489b[8] * c0073j.f491c[2]) >> 12))) >> 12);
        this.f487a[0] = (this.f487a[0] * c0073j.f487a[0]) >> 12;
        this.f487a[1] = (this.f487a[1] * c0073j.f487a[1]) >> 12;
        this.f487a[2] = (this.f487a[2] * c0073j.f487a[2]) >> 12;
        this.f489b[0] = ((c0073j.f489b[0] * i) >> 12) + ((c0073j.f489b[1] * i2) >> 12) + ((c0073j.f489b[2] * i3) >> 12);
        this.f489b[1] = ((c0073j.f489b[0] * i4) >> 12) + ((c0073j.f489b[1] * i5) >> 12) + ((c0073j.f489b[2] * i6) >> 12);
        this.f489b[2] = ((c0073j.f489b[0] * i7) >> 12) + ((c0073j.f489b[1] * i8) >> 12) + ((c0073j.f489b[2] * i9) >> 12);
        this.f489b[3] = ((c0073j.f489b[3] * i) >> 12) + ((c0073j.f489b[4] * i2) >> 12) + ((c0073j.f489b[5] * i3) >> 12);
        this.f489b[4] = ((c0073j.f489b[3] * i4) >> 12) + ((c0073j.f489b[4] * i5) >> 12) + ((c0073j.f489b[5] * i6) >> 12);
        this.f489b[5] = ((c0073j.f489b[3] * i7) >> 12) + ((c0073j.f489b[4] * i8) >> 12) + ((c0073j.f489b[5] * i9) >> 12);
        this.f489b[6] = ((i * c0073j.f489b[6]) >> 12) + ((i2 * c0073j.f489b[7]) >> 12) + ((c0073j.f489b[8] * i3) >> 12);
        this.f489b[7] = ((c0073j.f489b[6] * i4) >> 12) + ((c0073j.f489b[7] * i5) >> 12) + ((c0073j.f489b[8] * i6) >> 12);
        this.f489b[8] = ((c0073j.f489b[6] * i7) >> 12) + ((c0073j.f489b[7] * i8) >> 12) + ((c0073j.f489b[8] * i9) >> 12);
        this.f486a = true;
    }

    /* JADX INFO: renamed from: c */
    public final int m244c() {
        return this.f491c[2];
    }

    /* JADX INFO: renamed from: c */
    public final C0005ae m245c(C0005ae c0005ae) {
        int i = 16777216 / this.f487a[0];
        int i2 = 16777216 / this.f487a[1];
        int i3 = 16777216 / this.f487a[2];
        int i4 = ((((-((this.f489b[0] * this.f491c[0]) >> 12)) - ((this.f489b[1] * this.f491c[1]) >> 12)) - ((this.f489b[2] * this.f491c[2]) >> 12)) * i) >> 12;
        int i5 = ((((-((this.f489b[3] * this.f491c[0]) >> 12)) - ((this.f489b[4] * this.f491c[1]) >> 12)) - ((this.f489b[5] * this.f491c[2]) >> 12)) * i2) >> 12;
        int i6 = ((((-((this.f489b[6] * this.f491c[0]) >> 12)) - ((this.f489b[7] * this.f491c[1]) >> 12)) - ((this.f489b[8] * this.f491c[2]) >> 12)) * i3) >> 12;
        int i7 = c0005ae.f30a;
        int i8 = c0005ae.f31b;
        int i9 = c0005ae.f32c;
        c0005ae.f30a = i4 + ((((this.f489b[0] * i) >> 12) * i7) >> 12) + ((((this.f489b[1] * i2) >> 12) * i8) >> 12) + ((((this.f489b[2] * i3) >> 12) * i9) >> 12);
        c0005ae.f31b = ((((this.f489b[3] * i) >> 12) * i7) >> 12) + ((((this.f489b[4] * i2) >> 12) * i8) >> 12) + ((((this.f489b[5] * i3) >> 12) * i9) >> 12) + i5;
        c0005ae.f32c = ((((i * this.f489b[6]) >> 12) * i7) >> 12) + ((((i2 * this.f489b[7]) >> 12) * i8) >> 12) + ((((this.f489b[8] * i3) >> 12) * i9) >> 12) + i6;
        return c0005ae;
    }

    /* JADX INFO: renamed from: c */
    public final void m246c(int i, int i2, int i3) {
        if (this.f486a) {
            m225b();
            this.f486a = false;
        }
        this.f484a += i;
        this.f488b += i2;
        this.f490c += i3;
        m248d(this.f484a, this.f488b, this.f490c);
    }

    /* JADX INFO: renamed from: d */
    public final int m247d() {
        return this.f489b[6];
    }

    /* JADX INFO: renamed from: d */
    public final void m248d(int i, int i2, int i3) {
        this.f484a = i;
        this.f488b = i2;
        this.f490c = i3;
        this.f486a = false;
        int iM199a = C0064cj.m199a(i);
        int iM199a2 = C0064cj.m199a(i2);
        int iM199a3 = C0064cj.m199a(i3);
        int iM202b = C0064cj.m202b(i);
        int iM202b2 = C0064cj.m202b(i2);
        int iM202b3 = C0064cj.m202b(i3);
        switch (this.f485a) {
            case 0:
                this.f489b[0] = (iM202b2 * iM202b3) >> 12;
                this.f489b[3] = -((iM202b2 * iM199a3) >> 12);
                this.f489b[6] = iM199a2;
                this.f489b[1] = ((((iM202b3 * iM199a) >> 12) * iM199a2) >> 12) + ((iM202b * iM199a3) >> 12);
                this.f489b[4] = ((iM202b * iM202b3) >> 12) - ((((iM199a * iM199a2) >> 12) * iM199a3) >> 12);
                this.f489b[7] = -((iM202b2 * iM199a) >> 12);
                this.f489b[2] = (-((((iM202b * iM202b3) >> 12) * iM199a2) >> 12)) + ((iM199a * iM199a3) >> 12);
                this.f489b[5] = ((iM199a * iM202b3) >> 12) + ((((iM199a2 * iM202b) >> 12) * iM199a3) >> 12);
                this.f489b[8] = (iM202b * iM202b2) >> 12;
                break;
            case 1:
                this.f489b[0] = (iM202b2 * iM202b3) >> 12;
                this.f489b[3] = -iM199a3;
                this.f489b[6] = (iM202b3 * iM199a2) >> 12;
                this.f489b[1] = ((iM199a * iM199a2) >> 12) + ((((iM202b * iM202b2) >> 12) * iM199a3) >> 12);
                this.f489b[4] = (iM202b * iM202b3) >> 12;
                this.f489b[7] = (-((iM202b2 * iM199a) >> 12)) + ((((iM202b * iM199a2) >> 12) * iM199a3) >> 12);
                this.f489b[2] = (-((iM202b * iM199a2) >> 12)) + ((((iM202b2 * iM199a) >> 12) * iM199a3) >> 12);
                this.f489b[5] = (iM202b3 * iM199a) >> 12;
                this.f489b[8] = ((((iM199a * iM199a2) >> 12) * iM199a3) >> 12) + ((iM202b * iM202b2) >> 12);
                break;
            case 2:
                this.f489b[0] = ((iM202b2 * iM202b3) >> 12) + ((((iM199a * iM199a2) >> 12) * iM199a3) >> 12);
                this.f489b[3] = ((((iM202b3 * iM199a) >> 12) * iM199a2) >> 12) - ((iM202b2 * iM199a3) >> 12);
                this.f489b[6] = (iM202b * iM199a2) >> 12;
                this.f489b[1] = (iM202b * iM199a3) >> 12;
                this.f489b[4] = (iM202b * iM202b3) >> 12;
                this.f489b[7] = -iM199a;
                this.f489b[2] = (-((iM202b3 * iM199a2) >> 12)) + ((((iM202b2 * iM199a) >> 12) * iM199a3) >> 12);
                this.f489b[5] = ((iM199a * ((iM202b3 * iM202b2) >> 12)) >> 12) + ((iM199a2 * iM199a3) >> 12);
                this.f489b[8] = (iM202b * iM202b2) >> 12;
                break;
            case 3:
                this.f489b[0] = (iM202b2 * iM202b3) >> 12;
                this.f489b[3] = ((iM199a * iM199a2) >> 12) - ((((iM202b * iM202b2) >> 12) * iM199a3) >> 12);
                this.f489b[6] = ((iM202b * iM199a2) >> 12) + ((((iM202b2 * iM199a) >> 12) * iM199a3) >> 12);
                this.f489b[1] = iM199a3;
                this.f489b[4] = (iM202b * iM202b3) >> 12;
                this.f489b[7] = -((iM202b3 * iM199a) >> 12);
                this.f489b[2] = -((iM202b3 * iM199a2) >> 12);
                this.f489b[5] = ((iM202b2 * iM199a) >> 12) + ((((iM202b * iM199a2) >> 12) * iM199a3) >> 12);
                this.f489b[8] = ((iM202b * iM202b2) >> 12) - ((((iM199a * iM199a2) >> 12) * iM199a3) >> 12);
                break;
            case 4:
                this.f489b[0] = ((iM202b2 * iM202b3) >> 12) - ((((iM199a * iM199a2) >> 12) * iM199a3) >> 12);
                this.f489b[3] = -((iM202b * iM199a3) >> 12);
                this.f489b[6] = ((iM202b3 * iM199a2) >> 12) + ((((iM202b2 * iM199a) >> 12) * iM199a3) >> 12);
                this.f489b[1] = ((((iM202b3 * iM199a) >> 12) * iM199a2) >> 12) + ((iM202b2 * iM199a3) >> 12);
                this.f489b[4] = (iM202b * iM202b3) >> 12;
                this.f489b[7] = ((iM199a3 * iM199a2) >> 12) + (-((((iM202b3 * iM202b2) >> 12) * iM199a) >> 12));
                this.f489b[2] = -((iM199a2 * iM202b) >> 12);
                this.f489b[5] = iM199a;
                this.f489b[8] = (iM202b * iM202b2) >> 12;
                break;
            case 5:
                this.f489b[0] = (iM202b2 * iM202b3) >> 12;
                this.f489b[3] = ((((iM202b3 * iM199a) >> 12) * iM199a2) >> 12) - ((iM202b * iM199a3) >> 12);
                this.f489b[6] = ((((iM202b * iM202b3) >> 12) * iM199a2) >> 12) + ((iM199a * iM199a3) >> 12);
                this.f489b[1] = (iM202b2 * iM199a3) >> 12;
                this.f489b[4] = ((iM202b * iM202b3) >> 12) + ((((iM199a * iM199a2) >> 12) * iM199a3) >> 12);
                this.f489b[7] = ((iM199a3 * ((iM202b * iM199a2) >> 12)) >> 12) + (-((iM202b3 * iM199a) >> 12));
                this.f489b[2] = -iM199a2;
                this.f489b[5] = (iM199a * iM202b2) >> 12;
                this.f489b[8] = (iM202b * iM202b2) >> 12;
                break;
        }
    }

    /* JADX INFO: renamed from: e */
    public final int m249e() {
        return this.f489b[7];
    }

    /* JADX INFO: renamed from: f */
    public final int m250f() {
        return this.f489b[8];
    }

    public final String toString() {
        return new StringBuffer().append(new StringBuffer().append(new StringBuffer().append("").append("|\t").append((this.f487a[0] * this.f489b[0]) >> 12).append(",\t").append((this.f487a[1] * this.f489b[3]) >> 12).append(",\t").append((this.f487a[2] * this.f489b[6]) >> 12).append(",\t").append(this.f491c[0]).append("\t|\n").toString()).append("|\t").append((this.f487a[0] * this.f489b[1]) >> 12).append(",\t").append((this.f487a[1] * this.f489b[4]) >> 12).append(",\t").append((this.f487a[2] * this.f489b[7]) >> 12).append(",\t").append(this.f491c[1]).append("\t|\n").toString()).append("|\t").append((this.f487a[0] * this.f489b[2]) >> 12).append(",\t").append((this.f487a[1] * this.f489b[5]) >> 12).append(",\t").append((this.f487a[2] * this.f489b[8]) >> 12).append(",\t").append(this.f491c[2]).append("\t|\n").toString();
    }
}
