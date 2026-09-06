package javax.microedition.m3g;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class Transform {
    float[] matrix;

    public Transform() {
        this.matrix = new float[16];
        setIdentity();
    }

    public Transform(Transform transform) {
        this.matrix = new float[16];
        set(transform);
    }

    private static void mul(float[] fArr, float[] fArr2, float[] fArr3) {
        float[] fArr4 = new float[16];
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 4; i2++) {
                for (int i3 = 0; i3 < 4; i3++) {
                    int i4 = (i2 * 4) + i;
                    fArr4[i4] = fArr4[i4] + (fArr2[(i3 * 4) + i] * fArr3[(i2 * 4) + i3]);
                }
            }
        }
        for (int i5 = 0; i5 < 16; i5++) {
            fArr[i5] = fArr4[i5];
        }
    }

    private void mulLeft(float[] fArr) {
        mul(this.matrix, fArr, this.matrix);
    }

    private void mulRight(float[] fArr) {
        mul(this.matrix, this.matrix, fArr);
    }

    private float[] rotationMatrix(float f, float f2, float f3, float f4) {
        float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2) + (f3 * f3) + (f4 * f4));
        float f5 = f / fSqrt;
        float f6 = f2 / fSqrt;
        float f7 = f3 / fSqrt;
        float f8 = f4 / fSqrt;
        float f9 = f5 * f5;
        float f10 = f5 * f6;
        float f11 = f5 * f7;
        float f12 = f5 * f8;
        float f13 = f6 * f6;
        float f14 = f6 * f7;
        float f15 = f6 * f8;
        float f16 = f7 * f7;
        float f17 = f8 * f7;
        return new float[]{1.0f - (2.0f * (f13 + f16)), 2.0f * (f10 + f17), 2.0f * (f11 - f15), 0.0f, (f10 - f17) * 2.0f, 1.0f - ((f16 + f9) * 2.0f), 2.0f * (f14 + f12), 0.0f, (f15 + f11) * 2.0f, (f14 - f12) * 2.0f, 1.0f - (2.0f * (f9 + f13)), 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    private float[] scalingMatrix(float f, float f2, float f3) {
        return new float[]{f, 0.0f, 0.0f, 0.0f, 0.0f, f2, 0.0f, 0.0f, 0.0f, 0.0f, f3, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f};
    }

    private float[] translationMatrix(float f, float f2, float f3) {
        return new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, f, f2, f3, 1.0f};
    }

    void dump() {
        for (int i = 0; i < 4; i++) {
            for (int i2 = 0; i2 < 4; i2++) {
                System.out.print(new StringBuffer().append(this.matrix[(i2 * 4) + i]).append(" ").toString());
            }
            System.out.println("");
        }
    }

    public void get(float[] fArr) {
        if (fArr.length < 16) {
            throw new IllegalArgumentException();
        }
        fArr[0] = this.matrix[0];
        fArr[1] = this.matrix[4];
        fArr[2] = this.matrix[8];
        fArr[3] = this.matrix[12];
        fArr[4] = this.matrix[1];
        fArr[5] = this.matrix[5];
        fArr[6] = this.matrix[9];
        fArr[7] = this.matrix[13];
        fArr[8] = this.matrix[2];
        fArr[9] = this.matrix[6];
        fArr[10] = this.matrix[10];
        fArr[11] = this.matrix[14];
        fArr[12] = this.matrix[3];
        fArr[13] = this.matrix[7];
        fArr[14] = this.matrix[11];
        fArr[15] = this.matrix[15];
    }

    void getInverse(Transform transform) {
        float[] fArr = new float[12];
        float[] fArr2 = new float[16];
        for (int i = 0; i < 4; i++) {
            fArr2[i] = this.matrix[i * 4];
            fArr2[i + 4] = this.matrix[(i * 4) + 1];
            fArr2[i + 8] = this.matrix[(i * 4) + 2];
            fArr2[i + 12] = this.matrix[(i * 4) + 3];
        }
        fArr[0] = fArr2[10] * fArr2[15];
        fArr[1] = fArr2[11] * fArr2[14];
        fArr[2] = fArr2[9] * fArr2[15];
        fArr[3] = fArr2[11] * fArr2[13];
        fArr[4] = fArr2[9] * fArr2[14];
        fArr[5] = fArr2[10] * fArr2[13];
        fArr[6] = fArr2[8] * fArr2[15];
        fArr[7] = fArr2[11] * fArr2[12];
        fArr[8] = fArr2[8] * fArr2[14];
        fArr[9] = fArr2[10] * fArr2[12];
        fArr[10] = fArr2[8] * fArr2[13];
        fArr[11] = fArr2[9] * fArr2[12];
        transform.matrix[0] = (fArr[0] * fArr2[5]) + (fArr[3] * fArr2[6]) + (fArr[4] * fArr2[7]);
        float[] fArr3 = transform.matrix;
        fArr3[0] = fArr3[0] - (((fArr[1] * fArr2[5]) + (fArr[2] * fArr2[6])) + (fArr[5] * fArr2[7]));
        transform.matrix[1] = (fArr[1] * fArr2[4]) + (fArr[6] * fArr2[6]) + (fArr[9] * fArr2[7]);
        float[] fArr4 = transform.matrix;
        fArr4[1] = fArr4[1] - (((fArr[0] * fArr2[4]) + (fArr[7] * fArr2[6])) + (fArr[8] * fArr2[7]));
        transform.matrix[2] = (fArr[2] * fArr2[4]) + (fArr[7] * fArr2[5]) + (fArr[10] * fArr2[7]);
        float[] fArr5 = transform.matrix;
        fArr5[2] = fArr5[2] - (((fArr[3] * fArr2[4]) + (fArr[6] * fArr2[5])) + (fArr[11] * fArr2[7]));
        transform.matrix[3] = (fArr[5] * fArr2[4]) + (fArr[8] * fArr2[5]) + (fArr[11] * fArr2[6]);
        float[] fArr6 = transform.matrix;
        fArr6[3] = fArr6[3] - (((fArr[4] * fArr2[4]) + (fArr[9] * fArr2[5])) + (fArr[10] * fArr2[6]));
        transform.matrix[4] = (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]) + (fArr[5] * fArr2[3]);
        float[] fArr7 = transform.matrix;
        fArr7[4] = fArr7[4] - (((fArr[0] * fArr2[1]) + (fArr[3] * fArr2[2])) + (fArr[4] * fArr2[3]));
        transform.matrix[5] = (fArr[0] * fArr2[0]) + (fArr[7] * fArr2[2]) + (fArr[8] * fArr2[3]);
        float[] fArr8 = transform.matrix;
        fArr8[5] = fArr8[5] - (((fArr[1] * fArr2[0]) + (fArr[6] * fArr2[2])) + (fArr[9] * fArr2[3]));
        transform.matrix[6] = (fArr[3] * fArr2[0]) + (fArr[6] * fArr2[1]) + (fArr[11] * fArr2[3]);
        float[] fArr9 = transform.matrix;
        fArr9[6] = fArr9[6] - (((fArr[2] * fArr2[0]) + (fArr[7] * fArr2[1])) + (fArr[10] * fArr2[3]));
        transform.matrix[7] = (fArr[4] * fArr2[0]) + (fArr[9] * fArr2[1]) + (fArr[10] * fArr2[2]);
        float[] fArr10 = transform.matrix;
        fArr10[7] = fArr10[7] - (((fArr[5] * fArr2[0]) + (fArr[8] * fArr2[1])) + (fArr[11] * fArr2[2]));
        fArr[0] = fArr2[2] * fArr2[7];
        fArr[1] = fArr2[3] * fArr2[6];
        fArr[2] = fArr2[1] * fArr2[7];
        fArr[3] = fArr2[3] * fArr2[5];
        fArr[4] = fArr2[1] * fArr2[6];
        fArr[5] = fArr2[2] * fArr2[5];
        fArr[6] = fArr2[0] * fArr2[7];
        fArr[7] = fArr2[3] * fArr2[4];
        fArr[8] = fArr2[0] * fArr2[6];
        fArr[9] = fArr2[2] * fArr2[4];
        fArr[10] = fArr2[0] * fArr2[5];
        fArr[11] = fArr2[1] * fArr2[4];
        transform.matrix[8] = (fArr[0] * fArr2[13]) + (fArr[3] * fArr2[14]) + (fArr[4] * fArr2[15]);
        float[] fArr11 = transform.matrix;
        fArr11[8] = fArr11[8] - (((fArr[1] * fArr2[13]) + (fArr[2] * fArr2[14])) + (fArr[5] * fArr2[15]));
        transform.matrix[9] = (fArr[1] * fArr2[12]) + (fArr[6] * fArr2[14]) + (fArr[9] * fArr2[15]);
        float[] fArr12 = transform.matrix;
        fArr12[9] = fArr12[9] - (((fArr[0] * fArr2[12]) + (fArr[7] * fArr2[14])) + (fArr[8] * fArr2[15]));
        transform.matrix[10] = (fArr[2] * fArr2[12]) + (fArr[7] * fArr2[13]) + (fArr[10] * fArr2[15]);
        float[] fArr13 = transform.matrix;
        fArr13[10] = fArr13[10] - (((fArr[3] * fArr2[12]) + (fArr[6] * fArr2[13])) + (fArr[11] * fArr2[15]));
        transform.matrix[11] = (fArr[5] * fArr2[12]) + (fArr[8] * fArr2[13]) + (fArr[11] * fArr2[14]);
        float[] fArr14 = transform.matrix;
        fArr14[11] = fArr14[11] - (((fArr[4] * fArr2[12]) + (fArr[9] * fArr2[13])) + (fArr[10] * fArr2[14]));
        transform.matrix[12] = (fArr[2] * fArr2[10]) + (fArr[5] * fArr2[11]) + (fArr[1] * fArr2[9]);
        float[] fArr15 = transform.matrix;
        fArr15[12] = fArr15[12] - (((fArr[4] * fArr2[11]) + (fArr[0] * fArr2[9])) + (fArr[3] * fArr2[10]));
        transform.matrix[13] = (fArr[8] * fArr2[11]) + (fArr[0] * fArr2[8]) + (fArr[7] * fArr2[10]);
        float[] fArr16 = transform.matrix;
        fArr16[13] = fArr16[13] - (((fArr[6] * fArr2[10]) + (fArr[9] * fArr2[11])) + (fArr[1] * fArr2[8]));
        transform.matrix[14] = (fArr[6] * fArr2[9]) + (fArr[11] * fArr2[11]) + (fArr[3] * fArr2[8]);
        float[] fArr17 = transform.matrix;
        fArr17[14] = fArr17[14] - (((fArr[10] * fArr2[11]) + (fArr[2] * fArr2[8])) + (fArr[7] * fArr2[9]));
        transform.matrix[15] = (fArr[10] * fArr2[10]) + (fArr[4] * fArr2[8]) + (fArr[9] * fArr2[9]);
        float[] fArr18 = transform.matrix;
        fArr18[15] = fArr18[15] - ((fArr[5] * fArr2[8]) + ((fArr[8] * fArr2[9]) + (fArr[11] * fArr2[10])));
        float f = (fArr2[0] * transform.matrix[0]) + (fArr2[1] * transform.matrix[1]) + (fArr2[2] * transform.matrix[2]) + (fArr2[3] * transform.matrix[3]);
        if (f == 0.0f) {
            throw new IllegalStateException();
        }
        float f2 = 1.0f / f;
        for (int i2 = 0; i2 < 16; i2++) {
            float[] fArr19 = transform.matrix;
            fArr19[i2] = fArr19[i2] * f2;
        }
    }

    float[] getMatrix() {
        return this.matrix;
    }

    public void invert() {
        float[] fArr = new float[12];
        float[] fArr2 = new float[16];
        for (int i = 0; i < 4; i++) {
            fArr2[i] = this.matrix[i * 4];
            fArr2[i + 4] = this.matrix[(i * 4) + 1];
            fArr2[i + 8] = this.matrix[(i * 4) + 2];
            fArr2[i + 12] = this.matrix[(i * 4) + 3];
        }
        fArr[0] = fArr2[10] * fArr2[15];
        fArr[1] = fArr2[11] * fArr2[14];
        fArr[2] = fArr2[9] * fArr2[15];
        fArr[3] = fArr2[11] * fArr2[13];
        fArr[4] = fArr2[9] * fArr2[14];
        fArr[5] = fArr2[10] * fArr2[13];
        fArr[6] = fArr2[8] * fArr2[15];
        fArr[7] = fArr2[11] * fArr2[12];
        fArr[8] = fArr2[8] * fArr2[14];
        fArr[9] = fArr2[10] * fArr2[12];
        fArr[10] = fArr2[8] * fArr2[13];
        fArr[11] = fArr2[9] * fArr2[12];
        this.matrix[0] = (fArr[0] * fArr2[5]) + (fArr[3] * fArr2[6]) + (fArr[4] * fArr2[7]);
        float[] fArr3 = this.matrix;
        fArr3[0] = fArr3[0] - (((fArr[1] * fArr2[5]) + (fArr[2] * fArr2[6])) + (fArr[5] * fArr2[7]));
        this.matrix[1] = (fArr[1] * fArr2[4]) + (fArr[6] * fArr2[6]) + (fArr[9] * fArr2[7]);
        float[] fArr4 = this.matrix;
        fArr4[1] = fArr4[1] - (((fArr[0] * fArr2[4]) + (fArr[7] * fArr2[6])) + (fArr[8] * fArr2[7]));
        this.matrix[2] = (fArr[2] * fArr2[4]) + (fArr[7] * fArr2[5]) + (fArr[10] * fArr2[7]);
        float[] fArr5 = this.matrix;
        fArr5[2] = fArr5[2] - (((fArr[3] * fArr2[4]) + (fArr[6] * fArr2[5])) + (fArr[11] * fArr2[7]));
        this.matrix[3] = (fArr[5] * fArr2[4]) + (fArr[8] * fArr2[5]) + (fArr[11] * fArr2[6]);
        float[] fArr6 = this.matrix;
        fArr6[3] = fArr6[3] - (((fArr[4] * fArr2[4]) + (fArr[9] * fArr2[5])) + (fArr[10] * fArr2[6]));
        this.matrix[4] = (fArr[1] * fArr2[1]) + (fArr[2] * fArr2[2]) + (fArr[5] * fArr2[3]);
        float[] fArr7 = this.matrix;
        fArr7[4] = fArr7[4] - (((fArr[0] * fArr2[1]) + (fArr[3] * fArr2[2])) + (fArr[4] * fArr2[3]));
        this.matrix[5] = (fArr[0] * fArr2[0]) + (fArr[7] * fArr2[2]) + (fArr[8] * fArr2[3]);
        float[] fArr8 = this.matrix;
        fArr8[5] = fArr8[5] - (((fArr[1] * fArr2[0]) + (fArr[6] * fArr2[2])) + (fArr[9] * fArr2[3]));
        this.matrix[6] = (fArr[3] * fArr2[0]) + (fArr[6] * fArr2[1]) + (fArr[11] * fArr2[3]);
        float[] fArr9 = this.matrix;
        fArr9[6] = fArr9[6] - (((fArr[2] * fArr2[0]) + (fArr[7] * fArr2[1])) + (fArr[10] * fArr2[3]));
        this.matrix[7] = (fArr[4] * fArr2[0]) + (fArr[9] * fArr2[1]) + (fArr[10] * fArr2[2]);
        float[] fArr10 = this.matrix;
        fArr10[7] = fArr10[7] - (((fArr[5] * fArr2[0]) + (fArr[8] * fArr2[1])) + (fArr[11] * fArr2[2]));
        fArr[0] = fArr2[2] * fArr2[7];
        fArr[1] = fArr2[3] * fArr2[6];
        fArr[2] = fArr2[1] * fArr2[7];
        fArr[3] = fArr2[3] * fArr2[5];
        fArr[4] = fArr2[1] * fArr2[6];
        fArr[5] = fArr2[2] * fArr2[5];
        fArr[6] = fArr2[0] * fArr2[7];
        fArr[7] = fArr2[3] * fArr2[4];
        fArr[8] = fArr2[0] * fArr2[6];
        fArr[9] = fArr2[2] * fArr2[4];
        fArr[10] = fArr2[0] * fArr2[5];
        fArr[11] = fArr2[1] * fArr2[4];
        this.matrix[8] = (fArr[0] * fArr2[13]) + (fArr[3] * fArr2[14]) + (fArr[4] * fArr2[15]);
        float[] fArr11 = this.matrix;
        fArr11[8] = fArr11[8] - (((fArr[1] * fArr2[13]) + (fArr[2] * fArr2[14])) + (fArr[5] * fArr2[15]));
        this.matrix[9] = (fArr[1] * fArr2[12]) + (fArr[6] * fArr2[14]) + (fArr[9] * fArr2[15]);
        float[] fArr12 = this.matrix;
        fArr12[9] = fArr12[9] - (((fArr[0] * fArr2[12]) + (fArr[7] * fArr2[14])) + (fArr[8] * fArr2[15]));
        this.matrix[10] = (fArr[2] * fArr2[12]) + (fArr[7] * fArr2[13]) + (fArr[10] * fArr2[15]);
        float[] fArr13 = this.matrix;
        fArr13[10] = fArr13[10] - (((fArr[3] * fArr2[12]) + (fArr[6] * fArr2[13])) + (fArr[11] * fArr2[15]));
        this.matrix[11] = (fArr[5] * fArr2[12]) + (fArr[8] * fArr2[13]) + (fArr[11] * fArr2[14]);
        float[] fArr14 = this.matrix;
        fArr14[11] = fArr14[11] - (((fArr[4] * fArr2[12]) + (fArr[9] * fArr2[13])) + (fArr[10] * fArr2[14]));
        this.matrix[12] = (fArr[2] * fArr2[10]) + (fArr[5] * fArr2[11]) + (fArr[1] * fArr2[9]);
        float[] fArr15 = this.matrix;
        fArr15[12] = fArr15[12] - (((fArr[4] * fArr2[11]) + (fArr[0] * fArr2[9])) + (fArr[3] * fArr2[10]));
        this.matrix[13] = (fArr[8] * fArr2[11]) + (fArr[0] * fArr2[8]) + (fArr[7] * fArr2[10]);
        float[] fArr16 = this.matrix;
        fArr16[13] = fArr16[13] - (((fArr[6] * fArr2[10]) + (fArr[9] * fArr2[11])) + (fArr[1] * fArr2[8]));
        this.matrix[14] = (fArr[6] * fArr2[9]) + (fArr[11] * fArr2[11]) + (fArr[3] * fArr2[8]);
        float[] fArr17 = this.matrix;
        fArr17[14] = fArr17[14] - (((fArr[10] * fArr2[11]) + (fArr[2] * fArr2[8])) + (fArr[7] * fArr2[9]));
        this.matrix[15] = (fArr[10] * fArr2[10]) + (fArr[4] * fArr2[8]) + (fArr[9] * fArr2[9]);
        float[] fArr18 = this.matrix;
        fArr18[15] = fArr18[15] - ((fArr[5] * fArr2[8]) + ((fArr[8] * fArr2[9]) + (fArr[11] * fArr2[10])));
        float f = (fArr2[0] * this.matrix[0]) + (fArr2[1] * this.matrix[1]) + (fArr2[2] * this.matrix[2]) + (fArr2[3] * this.matrix[3]);
        if (f == 0.0f) {
            throw new ArithmeticException();
        }
        float f2 = 1.0f / f;
        for (int i2 = 0; i2 < 16; i2++) {
            float[] fArr19 = this.matrix;
            fArr19[i2] = fArr19[i2] * f2;
        }
    }

    boolean isWUnity() {
        return this.matrix[3] == 0.0f && this.matrix[7] == 0.0f && this.matrix[11] == 0.0f && this.matrix[15] == 1.0f;
    }

    void mulLeft(Transform transform) {
        mul(this.matrix, transform.matrix, this.matrix);
    }

    void mulRight(Transform transform) {
        mul(this.matrix, this.matrix, transform.matrix);
    }

    public void postMultiply(Transform transform) {
        mulRight(transform.matrix);
    }

    public void postRotate(float f, float f2, float f3, float f4) {
        if (f2 == 0.0f && f3 == 0.0f && f4 == 0.0f) {
            throw new IllegalArgumentException();
        }
        Quat4f quat4f = new Quat4f();
        quat4f.setAngleAxis(f, f2, f3, f4);
        postRotateQuat(quat4f.f65x, quat4f.f66y, quat4f.f67z, quat4f.f64w);
    }

    public void postRotateQuat(float f, float f2, float f3, float f4) {
        if (f == 0.0f && f2 == 0.0f && f3 == 0.0f && f4 == 0.0f) {
            throw new IllegalArgumentException();
        }
        mulRight(rotationMatrix(f, f2, f3, f4));
    }

    public void postScale(float f, float f2, float f3) {
        mulRight(scalingMatrix(f, f2, f3));
    }

    public void postTranslate(float f, float f2, float f3) {
        mulRight(translationMatrix(f, f2, f3));
    }

    void preRotateQuat(float f, float f2, float f3, float f4) {
        mulLeft(rotationMatrix(f, f2, f3, f4));
    }

    void preScale(float f, float f2, float f3) {
        mulLeft(scalingMatrix(f, f2, f3));
    }

    void preTranslate(float f, float f2, float f3) {
        mulLeft(translationMatrix(f, f2, f3));
    }

    void rotate(float f, float f2, float f3, float f4) {
        Quat4f quat4f = new Quat4f();
        quat4f.setAngleAxis(f, f2, f3, f4);
        rotateQuat(quat4f.f65x, quat4f.f66y, quat4f.f67z, quat4f.f64w);
    }

    void rotateQuat(float f, float f2, float f3, float f4) {
        mulRight(rotationMatrix(f, f2, f3, f4));
    }

    void scale(float f, float f2, float f3) {
        mulRight(scalingMatrix(f, f2, f3));
    }

    public void set(Transform transform) {
        for (int i = 0; i < 16; i++) {
            this.matrix[i] = transform.matrix[i];
        }
    }

    public void set(float[] fArr) {
        if (fArr.length < 16) {
            throw new IllegalArgumentException();
        }
        this.matrix[0] = fArr[0];
        this.matrix[1] = fArr[4];
        this.matrix[2] = fArr[8];
        this.matrix[3] = fArr[12];
        this.matrix[4] = fArr[1];
        this.matrix[5] = fArr[5];
        this.matrix[6] = fArr[9];
        this.matrix[7] = fArr[13];
        this.matrix[8] = fArr[2];
        this.matrix[9] = fArr[6];
        this.matrix[10] = fArr[10];
        this.matrix[11] = fArr[14];
        this.matrix[12] = fArr[3];
        this.matrix[13] = fArr[7];
        this.matrix[14] = fArr[11];
        this.matrix[15] = fArr[15];
    }

    public void setIdentity() {
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= 16) {
                return;
            }
            this.matrix[i2] = i2 % 5 == 0 ? 1.0f : 0.0f;
            i = i2 + 1;
        }
    }

    void transform(Vec4f vec4f) {
        Vec4f vec4f2 = new Vec4f(vec4f);
        vec4f.f77x = (this.matrix[0] * vec4f2.f77x) + (this.matrix[4] * vec4f2.f78y) + (this.matrix[8] * vec4f2.f79z) + (this.matrix[12] * vec4f2.f76w);
        vec4f.f78y = (this.matrix[1] * vec4f2.f77x) + (this.matrix[5] * vec4f2.f78y) + (this.matrix[9] * vec4f2.f79z) + (this.matrix[13] * vec4f2.f76w);
        vec4f.f79z = (this.matrix[2] * vec4f2.f77x) + (this.matrix[6] * vec4f2.f78y) + (this.matrix[10] * vec4f2.f79z) + (this.matrix[14] * vec4f2.f76w);
        vec4f.f76w = (vec4f2.f76w * this.matrix[15]) + (this.matrix[3] * vec4f2.f77x) + (this.matrix[7] * vec4f2.f78y) + (this.matrix[11] * vec4f2.f79z);
    }

    public void transform(VertexArray vertexArray, float[] fArr, boolean z) {
        int numEntries = vertexArray.getNumEntries();
        int numComponents = vertexArray.getNumComponents();
        if (fArr.length < numEntries * 4 || numComponents == 4) {
            throw new IllegalArgumentException();
        }
        Vec4f vec4f = new Vec4f();
        int i = 0;
        for (int i2 = 0; i2 < numEntries; i2++) {
            vertexArray.getValue(i2, vec4f);
            vec4f.f76w = z ? 1.0f : 0.0f;
            transform(vec4f);
            int i3 = i + 1;
            fArr[i] = vec4f.f77x;
            int i4 = i3 + 1;
            fArr[i3] = vec4f.f78y;
            int i5 = i4 + 1;
            fArr[i4] = vec4f.f79z;
            i = i5 + 1;
            fArr[i5] = vec4f.f76w;
        }
    }

    public void transform(float[] fArr) {
        int length = fArr.length;
        if (length % 4 != 0) {
            throw new IllegalArgumentException();
        }
        Vec4f vec4f = new Vec4f();
        for (int i = 0; i < length; i += 4) {
            vec4f.set(fArr[i], fArr[i + 1], fArr[i + 2], fArr[i + 3]);
            transform(vec4f);
            fArr[i] = vec4f.f77x;
            fArr[i + 1] = vec4f.f78y;
            fArr[i + 2] = vec4f.f79z;
            fArr[i + 3] = vec4f.f76w;
        }
    }

    void translate(float f, float f2, float f3) {
        mulRight(translationMatrix(f, f2, f3));
    }

    public void transpose() {
        float[] fArr = new float[16];
        for (int i = 0; i < 4; i++) {
            fArr[i] = this.matrix[i * 4];
            fArr[i + 4] = this.matrix[(i * 4) + 1];
            fArr[i + 8] = this.matrix[(i * 4) + 2];
            fArr[i + 12] = this.matrix[(i * 4) + 3];
        }
        this.matrix = fArr;
    }
}
