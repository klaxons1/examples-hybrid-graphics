package p000;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;

/* JADX INFO: renamed from: ah */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0008ah {

    /* JADX INFO: renamed from: A */
    public float f81A;

    /* JADX INFO: renamed from: B */
    public float f82B;

    /* JADX INFO: renamed from: a */
    public float f83a;

    /* JADX INFO: renamed from: a */
    public long f84a;

    /* JADX INFO: renamed from: b */
    public float f91b;

    /* JADX INFO: renamed from: b */
    public long f92b;

    /* JADX INFO: renamed from: c */
    public float f93c;

    /* JADX INFO: renamed from: d */
    public float f95d;

    /* JADX INFO: renamed from: d */
    public long f96d;

    /* JADX INFO: renamed from: e */
    public float f97e;

    /* JADX INFO: renamed from: e */
    public long f98e;

    /* JADX INFO: renamed from: f */
    public float f99f;

    /* JADX INFO: renamed from: f */
    public long f100f;

    /* JADX INFO: renamed from: g */
    public float f101g;

    /* JADX INFO: renamed from: h */
    public float f102h;

    /* JADX INFO: renamed from: i */
    public float f103i;

    /* JADX INFO: renamed from: j */
    public float f104j;

    /* JADX INFO: renamed from: k */
    public float f105k;

    /* JADX INFO: renamed from: l */
    public float f106l;

    /* JADX INFO: renamed from: m */
    public float f107m;

    /* JADX INFO: renamed from: n */
    public float f108n;

    /* JADX INFO: renamed from: o */
    public float f109o;

    /* JADX INFO: renamed from: p */
    public float f110p;

    /* JADX INFO: renamed from: q */
    public float f111q;

    /* JADX INFO: renamed from: r */
    public float f112r;

    /* JADX INFO: renamed from: s */
    public float f113s;

    /* JADX INFO: renamed from: t */
    public float f114t;

    /* JADX INFO: renamed from: u */
    public float f115u;

    /* JADX INFO: renamed from: v */
    public float f116v;

    /* JADX INFO: renamed from: w */
    public float f117w;

    /* JADX INFO: renamed from: x */
    public float f118x;

    /* JADX INFO: renamed from: y */
    public float f119y;

    /* JADX INFO: renamed from: z */
    public float f120z;

    /* JADX INFO: renamed from: a */
    public int[] f90a = {1, 2, 0};

    /* JADX INFO: renamed from: a */
    private ByteArrayOutputStream f86a = null;

    /* JADX INFO: renamed from: a */
    private DataOutputStream f88a = null;

    /* JADX INFO: renamed from: a */
    private DataInputStream f87a = null;

    /* JADX INFO: renamed from: a */
    private ByteArrayInputStream f85a = null;

    /* JADX INFO: renamed from: a */
    public float[] f89a = new float[4];

    /* JADX INFO: renamed from: c */
    public long f94c = 0;

    public C0008ah(long j, long j2) {
        this.f96d = j;
        this.f100f = j2;
        this.f98e = j2;
    }

    /* JADX INFO: renamed from: a */
    public final void m49a() {
        if (this.f87a == null && this.f86a != null) {
            this.f85a = new ByteArrayInputStream(this.f86a.toByteArray());
            this.f87a = new DataInputStream(this.f85a);
        }
        if (this.f87a != null) {
            try {
                this.f87a.reset();
            } catch (Exception e) {
                e.getMessage();
            }
        }
        this.f91b = this.f117w;
        this.f93c = this.f118x;
        this.f95d = this.f119y;
        this.f83a = this.f116v;
        this.f107m = this.f120z;
        this.f108n = this.f81A;
        this.f109o = this.f82B;
        this.f92b = 0L;
        this.f84a = 0L;
        this.f94c = 0L;
        this.f100f = this.f98e;
    }

    /* JADX INFO: renamed from: a */
    public final void m50a(byte[] bArr) {
        if (bArr == null) {
            this.f86a = null;
            this.f88a = null;
            this.f87a = null;
            this.f85a = null;
        } else {
            this.f85a = new ByteArrayInputStream(bArr);
            this.f87a = new DataInputStream(this.f85a);
            this.f86a = null;
            this.f88a = null;
        }
        this.f92b = 0L;
        this.f84a = 0L;
        this.f94c = 0L;
        this.f100f = this.f98e;
    }

    /* JADX INFO: renamed from: a */
    public final void m51a(float[] fArr) {
        float f = fArr[0] + fArr[4] + fArr[8];
        if (f > 0.0f) {
            float fSqrt = (float) Math.sqrt(f + 1.0f);
            this.f83a = fSqrt / 2.0f;
            float f2 = 0.5f / fSqrt;
            this.f91b = (fArr[7] - fArr[5]) * f2;
            this.f93c = (fArr[2] - fArr[6]) * f2;
            this.f95d = f2 * (fArr[3] - fArr[1]);
        } else {
            int i = fArr[4] > fArr[0] ? 1 : 0;
            if (fArr[8] > fArr[i * 4]) {
                i = 2;
            }
            int i2 = this.f90a[i];
            int i3 = this.f90a[i2];
            float fSqrt2 = (float) Math.sqrt(((double) (fArr[i * 4] - (fArr[i2 * 4] + fArr[i3 * 4]))) + 1.0d);
            this.f89a[i] = fSqrt2 * 0.5f;
            if (fSqrt2 != 0.0d) {
                fSqrt2 = 0.5f / fSqrt2;
            }
            this.f89a[3] = (fArr[(i3 * 3) + i2] - fArr[(i2 * 3) + i3]) * fSqrt2;
            this.f89a[i2] = (fArr[(i2 * 3) + i] + fArr[(i * 3) + i2]) * fSqrt2;
            this.f89a[i3] = (fArr[(i * 3) + i3] + fArr[(i3 * 3) + i]) * fSqrt2;
            this.f91b = this.f89a[0];
            this.f93c = this.f89a[1];
            this.f95d = this.f89a[2];
            this.f83a = this.f89a[3];
        }
        float fSqrt3 = (float) Math.sqrt((this.f91b * this.f91b) + (this.f93c * this.f93c) + (this.f95d * this.f95d) + (this.f83a * this.f83a));
        float f3 = this.f91b / fSqrt3;
        this.f91b = f3;
        this.f117w = f3;
        float f4 = this.f93c / fSqrt3;
        this.f93c = f4;
        this.f118x = f4;
        float f5 = this.f95d / fSqrt3;
        this.f95d = f5;
        this.f119y = f5;
        float f6 = this.f83a / fSqrt3;
        this.f83a = f6;
        this.f116v = f6;
        float f7 = fArr[9];
        this.f107m = f7;
        this.f120z = f7;
        float f8 = fArr[10];
        this.f108n = f8;
        this.f81A = f8;
        float f9 = fArr[11];
        this.f109o = f9;
        this.f82B = f9;
        this.f92b = 0L;
        this.f84a = 0L;
        this.f100f = this.f98e;
    }

    /* JADX INFO: renamed from: a */
    public final void m52a(float[] fArr, long j) {
        this.f94c = j - this.f96d;
        m54b(fArr, j);
        this.f100f = 0L;
    }

    /* JADX INFO: renamed from: a */
    public final float[] m53a(float[] fArr, long j) {
        if (this.f85a == null && this.f86a == null) {
            return fArr;
        }
        try {
            if (this.f87a != null && this.f84a < j && this.f87a.available() == 0) {
                fArr[10] = -10000.0f;
                return fArr;
            }
            if (this.f85a == null && this.f86a != null) {
                this.f85a = new ByteArrayInputStream(this.f86a.toByteArray());
                this.f87a = new DataInputStream(this.f85a);
            }
            if (this.f84a < j && this.f87a.available() == 0) {
                fArr[10] = -10000.0f;
                return fArr;
            }
            if (this.f84a < j) {
                float f = this.f91b;
                this.f99f = f;
                this.f104j = f;
                float f2 = this.f93c;
                this.f101g = f2;
                this.f105k = f2;
                float f3 = this.f95d;
                this.f102h = f3;
                this.f106l = f3;
                float f4 = this.f83a;
                this.f97e = f4;
                this.f103i = f4;
                this.f113s = this.f107m;
                this.f114t = this.f108n;
                this.f115u = this.f109o;
                this.f92b = this.f84a;
                this.f91b = Float.intBitsToFloat(this.f87a.readInt());
                this.f93c = Float.intBitsToFloat(this.f87a.readInt());
                this.f95d = Float.intBitsToFloat(this.f87a.readInt());
                this.f83a = Float.intBitsToFloat(this.f87a.readInt());
                this.f107m = Float.intBitsToFloat(this.f87a.readInt());
                this.f108n = Float.intBitsToFloat(this.f87a.readInt());
                this.f109o = Float.intBitsToFloat(this.f87a.readInt());
                this.f84a = this.f87a.readLong();
                return m53a(fArr, j);
            }
            float f5 = this.f84a == this.f92b ? 1.0f : (j - this.f92b) / (this.f84a - this.f92b);
            if ((this.f99f * this.f91b) + (this.f101g * this.f93c) + (this.f102h * this.f95d) + (this.f97e * this.f83a) < 0.0f) {
                this.f99f = this.f104j - ((this.f91b + this.f104j) * f5);
                this.f101g = this.f105k - ((this.f93c + this.f105k) * f5);
                this.f102h = this.f106l - ((this.f95d + this.f106l) * f5);
                this.f97e = this.f103i - ((this.f83a + this.f103i) * f5);
            } else {
                this.f99f = this.f104j + ((this.f91b - this.f104j) * f5);
                this.f101g = this.f105k + ((this.f93c - this.f105k) * f5);
                this.f102h = this.f106l + ((this.f95d - this.f106l) * f5);
                this.f97e = this.f103i + ((this.f83a - this.f103i) * f5);
            }
            float fSqrt = (float) Math.sqrt((this.f99f * this.f99f) + (this.f101g * this.f101g) + (this.f102h * this.f102h) + (this.f97e * this.f97e));
            this.f99f /= fSqrt;
            this.f101g /= fSqrt;
            this.f102h /= fSqrt;
            this.f97e /= fSqrt;
            this.f110p = this.f113s + ((this.f107m - this.f113s) * f5);
            this.f111q = this.f114t + ((this.f108n - this.f114t) * f5);
            this.f112r = (f5 * (this.f109o - this.f115u)) + this.f115u;
            double d = this.f99f * this.f99f;
            double d2 = this.f99f * this.f101g;
            double d3 = this.f99f * this.f102h;
            double d4 = this.f99f * this.f97e;
            double d5 = this.f101g * this.f101g;
            double d6 = this.f101g * this.f102h;
            double d7 = this.f101g * this.f97e;
            double d8 = this.f102h * this.f102h;
            double d9 = this.f102h * this.f97e;
            fArr[0] = (float) (1.0d - (2.0d * (d5 + d8)));
            fArr[1] = (float) (2.0d * (d2 - d9));
            fArr[2] = (float) (2.0d * (d3 + d7));
            fArr[3] = (float) ((d2 + d9) * 2.0d);
            fArr[4] = (float) (1.0d - ((d8 + d) * 2.0d));
            fArr[5] = (float) (2.0d * (d6 - d4));
            fArr[6] = (float) ((d3 - d7) * 2.0d);
            fArr[7] = (float) (2.0d * (d4 + d6));
            fArr[8] = (float) (1.0d - ((d + d5) * 2.0d));
            fArr[9] = this.f110p;
            fArr[10] = this.f111q;
            fArr[11] = this.f112r;
            return fArr;
        } catch (Exception e) {
            e.getMessage();
            return fArr;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m54b(float[] fArr, long j) {
        float f = fArr[0] + fArr[4] + fArr[8];
        if (j < this.f100f && j < this.f100f && j - this.f94c >= this.f96d) {
            this.f94c = j;
            if (this.f86a == null) {
                this.f86a = new ByteArrayOutputStream();
                this.f88a = new DataOutputStream(this.f86a);
                this.f87a = null;
                this.f85a = null;
            }
            if (f > 0.0f) {
                float fSqrt = (float) Math.sqrt(f + 1.0f);
                this.f83a = fSqrt / 2.0f;
                float f2 = 0.5f / fSqrt;
                this.f91b = (fArr[7] - fArr[5]) * f2;
                this.f93c = (fArr[2] - fArr[6]) * f2;
                this.f95d = f2 * (fArr[3] - fArr[1]);
            } else {
                int i = fArr[4] > fArr[0] ? 1 : 0;
                if (fArr[8] > fArr[i * 4]) {
                    i = 2;
                }
                int i2 = this.f90a[i];
                int i3 = this.f90a[i2];
                float fSqrt2 = (float) Math.sqrt(((double) (fArr[i * 4] - (fArr[i2 * 4] + fArr[i3 * 4]))) + 1.0d);
                this.f89a[i] = 0.5f * fSqrt2;
                if (fSqrt2 != 0.0d) {
                    fSqrt2 = 0.5f / fSqrt2;
                }
                this.f89a[3] = (fArr[(i3 * 3) + i2] - fArr[(i2 * 3) + i3]) * fSqrt2;
                this.f89a[i2] = (fArr[(i2 * 3) + i] + fArr[(i * 3) + i2]) * fSqrt2;
                this.f89a[i3] = (fArr[(i * 3) + i3] + fArr[(i3 * 3) + i]) * fSqrt2;
                this.f91b = this.f89a[0];
                this.f93c = this.f89a[1];
                this.f95d = this.f89a[2];
                this.f83a = this.f89a[3];
            }
            float fSqrt3 = (float) Math.sqrt((this.f91b * this.f91b) + (this.f93c * this.f93c) + (this.f95d * this.f95d) + (this.f83a * this.f83a));
            this.f91b /= fSqrt3;
            this.f93c /= fSqrt3;
            this.f95d /= fSqrt3;
            this.f83a /= fSqrt3;
            try {
                this.f88a.writeInt(Float.floatToIntBits(this.f91b));
                this.f88a.writeInt(Float.floatToIntBits(this.f93c));
                this.f88a.writeInt(Float.floatToIntBits(this.f95d));
                this.f88a.writeInt(Float.floatToIntBits(this.f83a));
                this.f88a.writeInt(Float.floatToIntBits(fArr[9]));
                this.f88a.writeInt(Float.floatToIntBits(fArr[10]));
                this.f88a.writeInt(Float.floatToIntBits(fArr[11]));
                this.f88a.writeLong(j);
            } catch (Exception e) {
                e.getMessage();
            }
        }
    }
}
