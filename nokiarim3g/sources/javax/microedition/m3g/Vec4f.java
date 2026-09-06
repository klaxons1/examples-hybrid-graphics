package javax.microedition.m3g;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
class Vec4f {

    /* JADX INFO: renamed from: w */
    float f76w;

    /* JADX INFO: renamed from: x */
    float f77x;

    /* JADX INFO: renamed from: y */
    float f78y;

    /* JADX INFO: renamed from: z */
    float f79z;

    Vec4f() {
    }

    Vec4f(float f, float f2, float f3, float f4) {
        this.f77x = f;
        this.f78y = f2;
        this.f79z = f3;
        this.f76w = f4;
    }

    Vec4f(Vec4f vec4f) {
        this.f77x = vec4f.f77x;
        this.f78y = vec4f.f78y;
        this.f79z = vec4f.f79z;
        this.f76w = vec4f.f76w;
    }

    final void add(Vec4f vec4f) {
        this.f77x += vec4f.f77x;
        this.f78y += vec4f.f78y;
        this.f79z += vec4f.f79z;
        this.f76w += vec4f.f76w;
    }

    final void cross(Vec4f vec4f, Vec4f vec4f2) {
        this.f77x = (vec4f.f78y * vec4f2.f79z) - (vec4f.f79z * vec4f2.f78y);
        this.f78y = (vec4f.f79z * vec4f2.f77x) - (vec4f.f77x * vec4f2.f79z);
        this.f79z = (vec4f.f77x * vec4f2.f78y) - (vec4f.f78y * vec4f2.f77x);
        this.f76w = 0.0f;
    }

    final float dot(Vec4f vec4f) {
        return (this.f77x * vec4f.f77x) + (this.f78y * vec4f.f78y) + (this.f79z * vec4f.f79z) + (this.f76w * vec4f.f76w);
    }

    final float length() {
        return (float) Math.sqrt((this.f77x * this.f77x) + (this.f78y * this.f78y) + (this.f79z * this.f79z));
    }

    final void mul(float f) {
        this.f77x *= f;
        this.f78y *= f;
        this.f79z *= f;
        this.f76w *= f;
    }

    final boolean normalize() {
        float f = (this.f77x * this.f77x) + (this.f78y * this.f78y) + (this.f79z * this.f79z) + (this.f76w * this.f76w);
        if (f < 1.0E-5f) {
            return false;
        }
        float fSqrt = 1.0f / ((float) Math.sqrt(f));
        this.f77x *= fSqrt;
        this.f78y *= fSqrt;
        this.f79z *= fSqrt;
        this.f76w = fSqrt * this.f76w;
        return true;
    }

    final void set(float f, float f2, float f3, float f4) {
        this.f77x = f;
        this.f78y = f2;
        this.f79z = f3;
        this.f76w = f4;
    }

    final void set(Vec4f vec4f) {
        this.f77x = vec4f.f77x;
        this.f78y = vec4f.f78y;
        this.f79z = vec4f.f79z;
        this.f76w = vec4f.f76w;
    }

    final void sub(Vec4f vec4f) {
        this.f77x -= vec4f.f77x;
        this.f78y -= vec4f.f78y;
        this.f79z -= vec4f.f79z;
        this.f76w -= vec4f.f76w;
    }

    final void sub(Vec4f vec4f, Vec4f vec4f2) {
        this.f77x = vec4f.f77x - vec4f2.f77x;
        this.f78y = vec4f.f78y - vec4f2.f78y;
        this.f79z = vec4f.f79z - vec4f2.f79z;
        this.f76w = vec4f.f76w - vec4f2.f76w;
    }
}
