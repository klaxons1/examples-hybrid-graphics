package javax.microedition.m3g;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class KeyframeSequence extends Object3D {
    public static final int CONSTANT = 192;
    public static final int LINEAR = 176;
    public static final int LOOP = 193;
    public static final int SLERP = 177;
    public static final int SPLINE = 178;
    public static final int SQUAD = 179;
    public static final int STEP = 180;

    /* JADX INFO: renamed from: a */
    private Quat4f[] f62a;

    /* JADX INFO: renamed from: b */
    private Quat4f[] f63b;
    private boolean dirty;
    private int firstValid;
    private float[][] inTangent;
    private int interpolation;
    private int[] keyframeTimes;
    private float[][] keyframes;
    private int lastValid;
    private float[][] outTangent;
    private int duration = 0;
    private boolean closed = false;

    public KeyframeSequence(int i, int i2, int i3) {
        this.dirty = true;
        if (i < 1 || i2 < 1) {
            throw new IllegalArgumentException();
        }
        if (i3 < 176 || i3 > 180) {
            throw new IllegalArgumentException();
        }
        if ((i3 == 177 || i3 == 179) && i2 != 4) {
            throw new IllegalArgumentException();
        }
        this.keyframes = (float[][]) Array.newInstance((Class<?>) Float.TYPE, i, i2);
        this.keyframeTimes = new int[i];
        this.interpolation = i3;
        if (i3 == 178) {
            this.inTangent = (float[][]) Array.newInstance((Class<?>) Float.TYPE, i, i2);
            this.outTangent = (float[][]) Array.newInstance((Class<?>) Float.TYPE, i, i2);
        } else if (i3 == 179) {
            this.f62a = new Quat4f[i];
            this.f63b = new Quat4f[i];
            for (int i4 = 0; i4 < i; i4++) {
                this.f62a[i4] = new Quat4f();
                this.f63b[i4] = new Quat4f();
            }
        }
        this.firstValid = 0;
        this.lastValid = i - 1;
        this.dirty = true;
    }

    private final float hermite(float f, float f2, float f3, float f4, float f5) {
        float f6 = f * f;
        float f7 = f6 * f;
        return ((f7 - f6) * f5) + ((((2.0f * f7) - (3.0f * f6)) + 1.0f) * f2) + ((((-2.0f) * f7) + (3.0f * f6)) * f3) + (((f7 - (2.0f * f6)) + f) * f4);
    }

    private float incomingTangentScale(int i) {
        if (!this.closed && (i == this.firstValid || i == this.lastValid)) {
            return 0.0f;
        }
        int iKeyframeBefore = keyframeBefore(i);
        return (2.0f * timeDelta(iKeyframeBefore)) / (timeDelta(iKeyframeBefore) + timeDelta(i));
    }

    private int keyframeAfter(int i) {
        if (i == this.lastValid) {
            return this.firstValid;
        }
        if (i == this.keyframeTimes.length - 1) {
            return 0;
        }
        return i + 1;
    }

    private int keyframeBefore(int i) {
        if (i == this.firstValid) {
            return this.lastValid;
        }
        return i == 0 ? this.keyframeTimes.length - 1 : i - 1;
    }

    private final void lerp(float[] fArr, float f, int i, int i2) {
        float[] keyframeValue = getKeyframeValue(i);
        float[] keyframeValue2 = getKeyframeValue(i2);
        for (int i3 = 0; i3 < fArr.length; i3++) {
            fArr[i3] = keyframeValue[i3] + ((keyframeValue2[i3] - keyframeValue[i3]) * f);
        }
    }

    private float outgoingTangentScale(int i) {
        if (!this.closed && (i == this.firstValid || i == this.lastValid)) {
            return 0.0f;
        }
        return (2.0f * timeDelta(i)) / (timeDelta(keyframeBefore(i)) + timeDelta(i));
    }

    private final void precalculateAB() {
        Quat4f quat4f = new Quat4f();
        Quat4f quat4f2 = new Quat4f();
        Quat4f quat4f3 = new Quat4f();
        Quat4f quat4f4 = new Quat4f();
        Quat4f quat4f5 = new Quat4f();
        Quat4f quat4f6 = new Quat4f();
        Quat4f quat4f7 = new Quat4f();
        int iKeyframeAfter = this.firstValid;
        do {
            quat4f3.set(getKeyframeValue(keyframeBefore(iKeyframeAfter)));
            quat4f.set(getKeyframeValue(iKeyframeAfter));
            quat4f2.set(getKeyframeValue(keyframeAfter(iKeyframeAfter)));
            quat4f4.set(getKeyframeValue(keyframeAfter(keyframeAfter(iKeyframeAfter))));
            quat4f7.logDiff(quat4f, quat4f2);
            quat4f6.logDiff(quat4f3, quat4f);
            quat4f7.add(quat4f6);
            quat4f7.mul(0.5f);
            quat4f5.set(quat4f7);
            quat4f5.mul(outgoingTangentScale(iKeyframeAfter));
            quat4f6.logDiff(quat4f, quat4f2);
            quat4f5.sub(quat4f6);
            quat4f5.mul(0.5f);
            quat4f6.exp(quat4f5);
            this.f62a[iKeyframeAfter].set(quat4f);
            this.f62a[iKeyframeAfter].mul(quat4f6);
            quat4f5.set(quat4f7);
            quat4f5.mul(incomingTangentScale(iKeyframeAfter));
            quat4f6.logDiff(quat4f3, quat4f);
            quat4f6.sub(quat4f5);
            quat4f6.mul(0.5f);
            quat4f6.exp(quat4f6);
            this.f63b[iKeyframeAfter].set(quat4f);
            this.f63b[iKeyframeAfter].mul(quat4f6);
            iKeyframeAfter = keyframeAfter(iKeyframeAfter);
        } while (iKeyframeAfter != this.firstValid);
    }

    private final void precalculateTangents() {
        int iKeyframeAfter = this.firstValid;
        do {
            float[] keyframeValue = getKeyframeValue(keyframeBefore(iKeyframeAfter));
            float[] keyframeValue2 = getKeyframeValue(keyframeAfter(iKeyframeAfter));
            float fIncomingTangentScale = incomingTangentScale(iKeyframeAfter);
            float fOutgoingTangentScale = outgoingTangentScale(iKeyframeAfter);
            for (int i = 0; i < getNumComponents(); i++) {
                this.inTangent[iKeyframeAfter][i] = (keyframeValue2[i] - keyframeValue[i]) * 0.5f * fIncomingTangentScale;
                this.outTangent[iKeyframeAfter][i] = (keyframeValue2[i] - keyframeValue[i]) * 0.5f * fOutgoingTangentScale;
            }
            iKeyframeAfter = keyframeAfter(iKeyframeAfter);
        } while (iKeyframeAfter != this.firstValid);
    }

    private final void slerp(float[] fArr, float f, int i, int i2) {
        if (fArr.length != 4) {
            throw new Error("Invalid keyframe type");
        }
        Quat4f quat4f = new Quat4f(getKeyframeValue(i));
        Quat4f quat4f2 = new Quat4f(getKeyframeValue(i2));
        Quat4f quat4f3 = new Quat4f();
        quat4f3.slerp(f, quat4f, quat4f2);
        fArr[0] = quat4f3.f65x;
        fArr[1] = quat4f3.f66y;
        fArr[2] = quat4f3.f67z;
        fArr[3] = quat4f3.f64w;
    }

    private final void spline(float[] fArr, float f, int i, int i2) {
        int iKeyframeBefore = keyframeBefore(i);
        int iKeyframeAfter = keyframeAfter(i2);
        getKeyframeValue(iKeyframeBefore);
        float[] keyframeValue = getKeyframeValue(i);
        float[] keyframeValue2 = getKeyframeValue(i2);
        getKeyframeValue(iKeyframeAfter);
        int i3 = 0;
        while (true) {
            int i4 = i3;
            if (i4 >= fArr.length) {
                return;
            }
            fArr[i4] = hermite(f, keyframeValue[i4], keyframeValue2[i4], this.outTangent[i][i4], this.inTangent[i2][i4]);
            i3 = i4 + 1;
        }
    }

    private final void squad(float[] fArr, float f, int i, int i2) {
        if (fArr.length != 4) {
            throw new Error("Invalid keyframe type");
        }
        Quat4f quat4f = new Quat4f();
        Quat4f quat4f2 = new Quat4f();
        Quat4f quat4f3 = new Quat4f();
        quat4f.set(getKeyframeValue(i));
        quat4f2.set(getKeyframeValue(i2));
        quat4f3.squad(f, quat4f, this.f62a[i], this.f63b[i2], quat4f2);
        fArr[0] = quat4f3.f65x;
        fArr[1] = quat4f3.f66y;
        fArr[2] = quat4f3.f67z;
        fArr[3] = quat4f3.f64w;
    }

    private int timeDelta(int i) {
        return i == this.lastValid ? (this.duration - this.keyframeTimes[this.lastValid]) + this.keyframeTimes[this.firstValid] : this.keyframeTimes[keyframeAfter(i)] - this.keyframeTimes[i];
    }

    private void updateTangents() {
        if (this.dirty) {
            throw new Error();
        }
        if (this.interpolation == 178) {
            precalculateTangents();
        } else if (this.interpolation == 179) {
            precalculateAB();
        }
    }

    private void validate() {
        if (this.duration <= 0) {
            throw new IllegalStateException();
        }
        int i = this.firstValid;
        while (i != this.lastValid) {
            int i2 = i < this.keyframeTimes.length + (-1) ? i + 1 : 0;
            if (this.keyframeTimes[i2] < this.keyframeTimes[i] || this.keyframeTimes[i2] > this.duration) {
                throw new IllegalStateException();
            }
            i = i2;
        }
        this.dirty = false;
        updateTangents();
    }

    @Override // javax.microedition.m3g.Object3D
    Object3D createDuplicate() {
        KeyframeSequence keyframeSequence = new KeyframeSequence(this.keyframes.length, this.keyframes[0].length, this.interpolation);
        setValidRange(this.firstValid, this.lastValid);
        keyframeSequence.copy(this);
        for (int i = 0; i < this.keyframes.length; i++) {
            System.arraycopy(this.keyframes[i], 0, keyframeSequence.keyframes[i], 0, this.keyframes[i].length);
        }
        System.arraycopy(this.keyframeTimes, 0, keyframeSequence.keyframeTimes, 0, this.keyframeTimes.length);
        keyframeSequence.duration = this.duration;
        keyframeSequence.closed = this.closed;
        keyframeSequence.dirty = this.dirty;
        return keyframeSequence;
    }

    public int getDuration() {
        return this.duration;
    }

    final int getKeyframeTime(int i) {
        return this.keyframeTimes[i];
    }

    float[] getKeyframeValue(int i) {
        return this.keyframes[i];
    }

    int getNumComponents() {
        return this.keyframes[0].length;
    }

    final int getNumKeyframes() {
        return this.keyframeTimes.length;
    }

    public int getRepeatMode() {
        return this.closed ? LOOP : CONSTANT;
    }

    int getSample(float f, float[] fArr) {
        float f2;
        if (this.dirty) {
            validate();
        }
        if (this.closed) {
            f2 = f < 0.0f ? (f % this.duration) + this.duration : f % this.duration;
            if (f2 < this.keyframeTimes[this.firstValid]) {
                f2 += this.duration;
            }
        } else {
            if (f < this.keyframeTimes[this.firstValid]) {
                float[] keyframeValue = getKeyframeValue(this.firstValid);
                System.arraycopy(keyframeValue, 0, fArr, 0, keyframeValue.length);
                float f3 = this.keyframeTimes[this.firstValid] - f;
                return f3 <= 2.1474836E9f ? (int) f3 : Integer.MAX_VALUE;
            }
            if (f >= this.keyframeTimes[this.lastValid]) {
                float[] keyframeValue2 = getKeyframeValue(this.lastValid);
                System.arraycopy(keyframeValue2, 0, fArr, 0, keyframeValue2.length);
                return Integer.MAX_VALUE;
            }
            f2 = f;
        }
        int iKeyframeAfter = this.firstValid;
        while (iKeyframeAfter != this.lastValid && this.keyframeTimes[keyframeAfter(iKeyframeAfter)] <= f2) {
            iKeyframeAfter = keyframeAfter(iKeyframeAfter);
        }
        if (f2 - this.keyframeTimes[iKeyframeAfter] < 1.0E-5f || this.interpolation == 180) {
            System.arraycopy(getKeyframeValue(iKeyframeAfter), 0, fArr, 0, getNumComponents());
            if (this.interpolation == 180) {
                return (int) (timeDelta(iKeyframeAfter) - (f2 - this.keyframeTimes[iKeyframeAfter]));
            }
            return 1;
        }
        float fTimeDelta = (f2 - this.keyframeTimes[iKeyframeAfter]) / timeDelta(iKeyframeAfter);
        int iKeyframeAfter2 = keyframeAfter(iKeyframeAfter);
        switch (this.interpolation) {
            case LINEAR /* 176 */:
                lerp(fArr, fTimeDelta, iKeyframeAfter, iKeyframeAfter2);
                break;
            case SLERP /* 177 */:
                slerp(fArr, fTimeDelta, iKeyframeAfter, iKeyframeAfter2);
                break;
            case SPLINE /* 178 */:
                spline(fArr, fTimeDelta, iKeyframeAfter, iKeyframeAfter2);
                break;
            case SQUAD /* 179 */:
                squad(fArr, fTimeDelta, iKeyframeAfter, iKeyframeAfter2);
                break;
            default:
                throw new Error("Invalid type for interpolation!");
        }
        return 1;
    }

    public void setDuration(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException();
        }
        this.duration = i;
    }

    public void setKeyframe(int i, int i2, float[] fArr) {
        if (fArr == null) {
            throw new NullPointerException();
        }
        if (fArr.length < getNumComponents() || i2 < 0) {
            throw new IllegalArgumentException();
        }
        this.keyframeTimes[i] = i2;
        float[] fArr2 = this.keyframes[i];
        if (this.interpolation == 177 || this.interpolation == 179) {
            Quat4f quat4f = new Quat4f(fArr[0], fArr[1], fArr[2], fArr[3]);
            quat4f.normalize();
            fArr2[0] = quat4f.f65x;
            fArr2[1] = quat4f.f66y;
            fArr2[2] = quat4f.f67z;
            fArr2[3] = quat4f.f64w;
        } else {
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
        }
        this.dirty = true;
    }

    public void setRepeatMode(int i) {
        if (i != 192 && i != 193) {
            throw new IllegalArgumentException();
        }
        this.closed = i == 193;
        if (this.dirty) {
            return;
        }
        updateTangents();
    }

    public void setValidRange(int i, int i2) {
        if (i < 0 || i >= this.keyframeTimes.length || i2 < 0 || i2 >= this.keyframeTimes.length) {
            throw new IndexOutOfBoundsException();
        }
        this.firstValid = i;
        this.lastValid = i2;
        this.dirty = true;
    }
}
