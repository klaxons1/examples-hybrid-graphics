package javax.microedition.m3g;

import javax.microedition.media.control.ToneControl;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
class Util {
    Util() {
    }

    public static final int b2ub(byte b) {
        return b & ToneControl.SILENCE;
    }

    static void byteToFloat(byte[] bArr, float[] fArr) {
        for (int i = 0; i < bArr.length; i++) {
            fArr[i] = bArr[i] & ToneControl.SILENCE;
        }
    }

    static float clamp(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        if (f > 1.0f) {
            return 1.0f;
        }
        return f;
    }

    static float clamp(float f, float f2, float f3) {
        if (f < f2) {
            return f2;
        }
        return f > f3 ? f3 : f;
    }

    static int clamp(int i, int i2, int i3) {
        if (i < i2) {
            return i2;
        }
        return i > i3 ? i3 : i;
    }

    static float clampPositive(float f) {
        if (f < 0.0f) {
            return 0.0f;
        }
        return f;
    }

    static void getFloatColor(int i, float f, float[] fArr) {
        fArr[0] = (((i >> 16) & 255) * f) / 255.0f;
        fArr[1] = (((i >> 8) & 255) * f) / 255.0f;
        fArr[2] = ((i & 255) * f) / 255.0f;
        fArr[3] = (((i >> 24) & 255) * f) / 255.0f;
    }

    static int getIntColor(float[] fArr) {
        int iClamp;
        int iClamp2;
        int iClamp3;
        int iClamp4;
        if (fArr.length == 1) {
            iClamp4 = (int) ((clamp(fArr[0]) * 255.0f) + 0.5f);
            iClamp3 = 255;
            iClamp2 = 255;
            iClamp = 255;
        } else {
            iClamp = (int) ((clamp(fArr[0]) * 255.0f) + 0.5f);
            iClamp2 = (int) ((clamp(fArr[1]) * 255.0f) + 0.5f);
            iClamp3 = (int) ((clamp(fArr[2]) * 255.0f) + 0.5f);
            iClamp4 = fArr.length == 4 ? (int) ((clamp(fArr[3]) * 255.0f) + 0.5f) : 255;
        }
        return (iClamp4 << 24) + (iClamp << 16) + (iClamp2 << 8) + iClamp3;
    }

    static final boolean intersectRectangle(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int[] iArr) {
        int i9 = i >= i5 ? i : i5;
        int i10 = i + i3 <= i5 + i7 ? i + i3 : i5 + i7;
        if (i10 - i9 < 0) {
            return false;
        }
        iArr[0] = i9;
        iArr[2] = i10 - i9;
        int i11 = i2 >= i6 ? i2 : i6;
        int i12 = i2 + i4 <= i6 + i8 ? i2 + i4 : i6 + i8;
        if (i12 - i11 < 0) {
            return false;
        }
        iArr[1] = i11;
        iArr[3] = i12 - i11;
        return true;
    }

    static final boolean intersectTriangle(Vec4f vec4f, Vec4f vec4f2, Vec4f vec4f3, Vec4f vec4f4, Vec4f vec4f5, Vec4f vec4f6, int i) {
        Vec4f vec4f7 = new Vec4f();
        Vec4f vec4f8 = new Vec4f();
        Vec4f vec4f9 = new Vec4f();
        Vec4f vec4f10 = new Vec4f();
        Vec4f vec4f11 = new Vec4f();
        vec4f7.sub(vec4f4, vec4f3);
        vec4f8.sub(vec4f5, vec4f3);
        vec4f10.cross(vec4f2, vec4f8);
        float fDot = vec4f7.dot(vec4f10);
        if (i == 0 && fDot <= 0.0f) {
            return false;
        }
        if (i == 1 && fDot >= 0.0f) {
            return false;
        }
        if (fDot > -1.0E-5f && fDot < 1.0E-5f) {
            return false;
        }
        float f = 1.0f / fDot;
        vec4f9.sub(vec4f, vec4f3);
        vec4f6.f78y = vec4f9.dot(vec4f10) * f;
        if (vec4f6.f78y < 0.0f || vec4f6.f78y > 1.0f) {
            return false;
        }
        vec4f11.cross(vec4f9, vec4f7);
        vec4f6.f79z = vec4f2.dot(vec4f11) * f;
        if (vec4f6.f79z < 0.0f || vec4f6.f78y + vec4f6.f79z > 1.0f) {
            return false;
        }
        vec4f6.f77x = vec4f8.dot(vec4f11) * f;
        return true;
    }

    static int roundToInt(float f) {
        return f >= 0.0f ? (int) (f + 0.5f) : (int) (f - 0.5f);
    }

    public static final byte ub2b(int i) {
        return i > 127 ? (byte) (i - 256) : (byte) i;
    }
}
