package javax.microedition.m3g;

import com.nokia.phone.p000ri.m3g.Math;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
class Quat4f {

    /* JADX INFO: renamed from: w */
    float f64w;

    /* JADX INFO: renamed from: x */
    float f65x;

    /* JADX INFO: renamed from: y */
    float f66y;

    /* JADX INFO: renamed from: z */
    float f67z;

    Quat4f() {
    }

    Quat4f(float f, float f2, float f3, float f4) {
        this.f65x = f;
        this.f66y = f2;
        this.f67z = f3;
        this.f64w = f4;
    }

    Quat4f(Quat4f quat4f) {
        set(quat4f);
    }

    Quat4f(float[] fArr) {
        set(fArr);
    }

    final void add(Quat4f quat4f) {
        this.f65x += quat4f.f65x;
        this.f66y += quat4f.f66y;
        this.f67z += quat4f.f67z;
        this.f64w += quat4f.f64w;
    }

    final void conjugate(Quat4f quat4f) {
        this.f65x = -quat4f.f65x;
        this.f66y = -quat4f.f66y;
        this.f67z = -quat4f.f67z;
        this.f64w = quat4f.f64w;
    }

    final float dot(Quat4f quat4f) {
        return (this.f65x * quat4f.f65x) + (this.f66y * quat4f.f66y) + (this.f67z * quat4f.f67z) + (this.f64w * quat4f.f64w);
    }

    final void exp(Quat4f quat4f) {
        float fSqrt = (float) Math.sqrt((quat4f.f65x * quat4f.f65x) + (quat4f.f66y * quat4f.f66y) + (quat4f.f67z * quat4f.f67z));
        if (fSqrt <= 1.0E-5f) {
            this.f67z = 0.0f;
            this.f66y = 0.0f;
            this.f65x = 0.0f;
            this.f64w = 1.0f;
            return;
        }
        float fSin = ((float) Math.sin(fSqrt)) / fSqrt;
        this.f65x = quat4f.f65x * fSin;
        this.f66y = quat4f.f66y * fSin;
        this.f67z = fSin * quat4f.f67z;
        this.f64w = (float) Math.cos(fSqrt);
    }

    final void getAngleAxis(float[] fArr) {
        float fSqrt = (float) Math.sqrt((this.f65x * this.f65x) + (this.f66y * this.f66y) + (this.f67z * this.f67z));
        if (fSqrt > 1.0E-5f) {
            fArr[1] = this.f65x / fSqrt;
            fArr[2] = this.f66y / fSqrt;
            fArr[3] = this.f67z / fSqrt;
        } else {
            fArr[2] = 0.0f;
            fArr[1] = 0.0f;
            fArr[3] = 1.0f;
        }
        fArr[0] = 114.59156f * Math.acos(this.f64w);
    }

    final void log(Quat4f quat4f) {
        float fSqrt = (float) Math.sqrt((quat4f.f65x * quat4f.f65x) + (quat4f.f66y * quat4f.f66y) + (quat4f.f67z * quat4f.f67z));
        if (fSqrt > 1.0E-5f) {
            float fAtan2 = Math.atan2(fSqrt, this.f64w) / fSqrt;
            this.f65x = quat4f.f65x * fAtan2;
            this.f66y = quat4f.f66y * fAtan2;
            this.f67z = fAtan2 * quat4f.f67z;
        } else {
            this.f67z = 0.0f;
            this.f66y = 0.0f;
            this.f65x = 0.0f;
        }
        this.f64w = 0.0f;
    }

    final void logDiff(Quat4f quat4f, Quat4f quat4f2) {
        set(quat4f);
        conjugate(this);
        mul(quat4f2);
        log(this);
    }

    final void mul(float f) {
        this.f65x *= f;
        this.f66y *= f;
        this.f67z *= f;
        this.f64w *= f;
    }

    final void mul(Quat4f quat4f) {
        Quat4f quat4f2 = new Quat4f(this);
        this.f64w = (((quat4f2.f64w * quat4f.f64w) - (quat4f2.f65x * quat4f.f65x)) - (quat4f2.f66y * quat4f.f66y)) - (quat4f2.f67z * quat4f.f67z);
        this.f65x = (((quat4f2.f64w * quat4f.f65x) + (quat4f2.f65x * quat4f.f64w)) + (quat4f2.f66y * quat4f.f67z)) - (quat4f2.f67z * quat4f.f66y);
        this.f66y = ((quat4f2.f64w * quat4f.f66y) - (quat4f2.f65x * quat4f.f67z)) + (quat4f2.f66y * quat4f.f64w) + (quat4f2.f67z * quat4f.f65x);
        this.f67z = (quat4f2.f67z * quat4f.f64w) + (((quat4f2.f64w * quat4f.f67z) + (quat4f2.f65x * quat4f.f66y)) - (quat4f2.f66y * quat4f.f65x));
    }

    final void normalize() {
        float f = (this.f65x * this.f65x) + (this.f66y * this.f66y) + (this.f67z * this.f67z) + (this.f64w * this.f64w);
        if (f <= 1.0E-5f) {
            this.f67z = 0.0f;
            this.f66y = 0.0f;
            this.f65x = 0.0f;
            this.f64w = 1.0f;
            return;
        }
        float fSqrt = 1.0f / ((float) Math.sqrt(f));
        this.f65x *= fSqrt;
        this.f66y *= fSqrt;
        this.f67z *= fSqrt;
        this.f64w = fSqrt * this.f64w;
    }

    final void set(Quat4f quat4f) {
        this.f65x = quat4f.f65x;
        this.f66y = quat4f.f66y;
        this.f67z = quat4f.f67z;
        this.f64w = quat4f.f64w;
    }

    final void set(float[] fArr) {
        if (fArr.length != 4) {
            throw new Error("Invalid number of components for quaternion");
        }
        this.f65x = fArr[0];
        this.f66y = fArr[1];
        this.f67z = fArr[2];
        this.f64w = fArr[3];
    }

    final void setAngleAxis(float f, float f2, float f3, float f4) {
        Vec4f vec4f = new Vec4f(f2, f3, f4, 0.0f);
        vec4f.normalize();
        float fSin = (float) Math.sin(0.5f * f * 0.017453292f);
        this.f65x = vec4f.f77x * fSin;
        this.f66y = vec4f.f78y * fSin;
        this.f67z = vec4f.f79z * fSin;
        this.f64w = (float) Math.cos(0.5f * f * 0.017453292f);
    }

    final void setIdentity() {
        this.f67z = 0.0f;
        this.f66y = 0.0f;
        this.f65x = 0.0f;
        this.f64w = 1.0f;
    }

    final void setRotation(Vec4f vec4f, Vec4f vec4f2, Vec4f vec4f3) {
        if (vec4f.f76w != 0.0f || vec4f2.f76w != 0.0f) {
            throw new Error();
        }
        Vec4f vec4f4 = new Vec4f(vec4f);
        Vec4f vec4f5 = new Vec4f(vec4f2);
        if (vec4f3 != null) {
            Vec4f vec4f6 = new Vec4f(vec4f3);
            vec4f6.normalize();
            vec4f4.normalize();
            vec4f6.mul(vec4f4.dot(vec4f6));
            vec4f4.sub(vec4f6);
            vec4f6.set(vec4f3);
            vec4f6.normalize();
            vec4f5.normalize();
            vec4f6.mul(vec4f5.dot(vec4f6));
            vec4f5.sub(vec4f6);
        }
        if (!vec4f4.normalize() || !vec4f5.normalize()) {
            setIdentity();
            return;
        }
        float fDot = vec4f4.dot(vec4f5);
        if (fDot > 0.99999f) {
            setIdentity();
            return;
        }
        if (fDot >= -0.99999f) {
            Vec4f vec4f7 = new Vec4f();
            vec4f7.cross(vec4f4, vec4f5);
            setAngleAxis(Math.acos(fDot) / 0.017453292f, vec4f7.f77x, vec4f7.f78y, vec4f7.f79z);
            return;
        }
        if (vec4f3 == null) {
            vec4f3 = new Vec4f();
            float fAbs = Math.abs(vec4f4.f77x);
            float fAbs2 = Math.abs(vec4f4.f78y);
            float fAbs3 = Math.abs(vec4f4.f79z);
            if (fAbs <= fAbs2 && fAbs <= fAbs3) {
                vec4f3.set(1.0f, 0.0f, 0.0f, 0.0f);
            } else if (fAbs2 > fAbs || fAbs2 > fAbs3) {
                vec4f3.set(0.0f, 0.0f, 1.0f, 0.0f);
            } else {
                vec4f3.set(0.0f, 1.0f, 0.0f, 0.0f);
            }
            vec4f4.mul(vec4f3.dot(vec4f4));
            vec4f3.sub(vec4f4);
        }
        setAngleAxis(180.0f, vec4f3.f77x, vec4f3.f78y, vec4f3.f79z);
    }

    final void slerp(float f, Quat4f quat4f, Quat4f quat4f2) {
        float fSin;
        float fDot = quat4f.dot(quat4f2);
        if (fDot + 1.0f <= 1.0E-5f) {
            this.f65x = -quat4f.f66y;
            this.f66y = quat4f.f65x;
            this.f67z = -quat4f.f64w;
            this.f64w = quat4f.f67z;
            float fSin2 = (float) Math.sin((1.0f - f) * 1.5707964f);
            float fSin3 = (float) Math.sin(f * 1.5707964f);
            this.f65x = (quat4f.f65x * fSin2) + (this.f65x * fSin3);
            this.f66y = (quat4f.f66y * fSin2) + (this.f66y * fSin3);
            this.f67z = (fSin2 * quat4f.f67z) + (fSin3 * this.f67z);
            return;
        }
        if (1.0f - fDot > 1.0E-5f) {
            float fAcos = Math.acos(fDot);
            float fSin4 = (float) Math.sin(fAcos);
            fSin = ((float) Math.sin((1.0f - f) * fAcos)) / fSin4;
            f = ((float) Math.sin(fAcos * f)) / fSin4;
        } else {
            fSin = 1.0f - f;
        }
        this.f65x = (quat4f.f65x * fSin) + (quat4f2.f65x * f);
        this.f66y = (quat4f.f66y * fSin) + (quat4f2.f66y * f);
        this.f67z = (quat4f.f67z * fSin) + (quat4f2.f67z * f);
        this.f64w = (fSin * quat4f.f64w) + (quat4f2.f64w * f);
    }

    final void squad(float f, Quat4f quat4f, Quat4f quat4f2, Quat4f quat4f3, Quat4f quat4f4) {
        Quat4f quat4f5 = new Quat4f();
        Quat4f quat4f6 = new Quat4f();
        quat4f5.slerp(f, quat4f, quat4f4);
        quat4f6.slerp(f, quat4f2, quat4f3);
        slerp(2.0f * f * (1.0f - f), quat4f5, quat4f6);
    }

    final void sub(Quat4f quat4f) {
        this.f65x -= quat4f.f65x;
        this.f66y -= quat4f.f66y;
        this.f67z -= quat4f.f67z;
        this.f64w -= quat4f.f64w;
    }
}
