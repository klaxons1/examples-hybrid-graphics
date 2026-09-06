package javax.microedition.m3g;

import com.sun.midp.security.Permissions;
import javax.microedition.media.control.ToneControl;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class VertexArray extends Object3D {
    private byte[] byteValues;
    private int numComponents;
    private int numEntries;
    private short[] shortValues;

    public VertexArray(int i, int i2, int i3) {
        this.byteValues = null;
        this.shortValues = null;
        if (i < 1 || i > 65535 || i2 < 2 || i2 > 4) {
            throw new IllegalArgumentException();
        }
        if (i3 == 1) {
            this.byteValues = new byte[i * i2];
            for (int i4 = 0; i4 < i * i2; i4++) {
                this.byteValues[i4] = 0;
            }
        } else {
            if (i3 != 2) {
                throw new IllegalArgumentException();
            }
            this.shortValues = new short[i * i2];
            for (int i5 = 0; i5 < i * i2; i5++) {
                this.shortValues[i5] = 0;
            }
        }
        this.numEntries = i;
        this.numComponents = i2;
    }

    void copyData(VertexArray vertexArray) {
        int i = 0;
        if (this.byteValues != null) {
            while (i < this.byteValues.length) {
                this.byteValues[i] = vertexArray.byteValues[i];
                i++;
            }
        } else {
            while (i < this.shortValues.length) {
                this.shortValues[i] = vertexArray.shortValues[i];
                i++;
            }
        }
    }

    @Override // javax.microedition.m3g.Object3D
    Object3D createDuplicate() {
        VertexArray vertexArrayDuplicateData = duplicateData();
        vertexArrayDuplicateData.copy(this);
        return vertexArrayDuplicateData;
    }

    VertexArray duplicateData() {
        VertexArray vertexArray = this.byteValues != null ? new VertexArray(this.numEntries, this.numComponents, 1) : new VertexArray(this.numEntries, this.numComponents, 2);
        vertexArray.copyData(this);
        return vertexArray;
    }

    byte[] getByteValues() {
        return this.byteValues;
    }

    void getColorFloatValues(float[] fArr) {
        Util.byteToFloat(this.byteValues, fArr);
    }

    int getColorValue(int i) {
        int i2 = this.numComponents * i;
        if (this.byteValues == null) {
            throw new Error();
        }
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = ((this.byteValues[i2] << Permissions.ONE_SHOT) & 16711680) | 0 | ((this.byteValues[i3] << 8) & 65280);
        int i6 = i4 + 1;
        int i7 = i5 | (this.byteValues[i4] & ToneControl.SILENCE);
        if (this.numComponents < 4) {
            return i7 | (-16777216);
        }
        int i8 = i6 + 1;
        return i7 | ((this.byteValues[i6] << 24) & (-16777216));
    }

    void getFloatValues(float[] fArr) {
        int i = 0;
        if (this.byteValues != null) {
            while (i < this.byteValues.length) {
                fArr[i] = this.byteValues[i];
                i++;
            }
        } else {
            while (i < this.shortValues.length) {
                fArr[i] = this.shortValues[i];
                i++;
            }
        }
    }

    int getNumComponents() {
        return this.numComponents;
    }

    int getNumEntries() {
        return this.numEntries;
    }

    short[] getShortValues() {
        return this.shortValues;
    }

    void getValue(int i, Vec4f vec4f) {
        int i2;
        int i3;
        float f;
        float f2 = 1.0f;
        float f3 = 0.0f;
        int i4 = this.numComponents * i;
        if (this.byteValues == null) {
            int i5 = i4 + 1;
            vec4f.f77x = this.shortValues[i4];
            int i6 = i5 + 1;
            vec4f.f78y = this.shortValues[i5];
            if (this.numComponents >= 3) {
                i2 = i6 + 1;
                f3 = this.shortValues[i6];
            } else {
                i2 = i6;
            }
            vec4f.f79z = f3;
            if (this.numComponents >= 4) {
                int i7 = i2 + 1;
                f2 = this.shortValues[i2];
            }
            vec4f.f76w = f2;
            return;
        }
        int i8 = i4 + 1;
        vec4f.f77x = this.byteValues[i4];
        int i9 = i8 + 1;
        vec4f.f78y = this.byteValues[i8];
        if (this.numComponents >= 3) {
            i3 = i9 + 1;
            f3 = this.byteValues[i9];
        } else {
            i3 = i9;
        }
        vec4f.f79z = f3;
        if (this.numComponents >= 4) {
            int i10 = i3 + 1;
            f = this.byteValues[i3];
        } else {
            f = 1.0f;
        }
        vec4f.f76w = f;
    }

    boolean isCompatible(VertexArray vertexArray) {
        if (vertexArray != null) {
            if ((vertexArray.byteValues != null) == (this.byteValues != null)) {
                if ((vertexArray.shortValues != null) == (this.shortValues != null) && vertexArray.numComponents == this.numComponents && vertexArray.numEntries == this.numEntries) {
                    return true;
                }
            }
        }
        return false;
    }

    int length() {
        return this.numEntries * this.numComponents;
    }

    void morph(VertexArray[] vertexArrayArr, float[] fArr, float[] fArr2, float f) {
        for (VertexArray vertexArray : vertexArrayArr) {
            if (!isCompatible(vertexArray)) {
                throw new IllegalStateException();
            }
        }
        if (this.byteValues != null) {
            for (int i = 0; i < this.byteValues.length; i++) {
                float f2 = 0.0f;
                for (int i2 = 0; i2 < vertexArrayArr.length; i2++) {
                    f2 += vertexArrayArr[i2].byteValues[i] * fArr[i2];
                }
                this.byteValues[i] = (byte) Util.roundToInt(f2 + (fArr2[i] * f));
            }
            return;
        }
        for (int i3 = 0; i3 < this.shortValues.length; i3++) {
            float f3 = 0.0f;
            for (int i4 = 0; i4 < vertexArrayArr.length; i4++) {
                f3 += vertexArrayArr[i4].shortValues[i3] * fArr[i4];
            }
            this.shortValues[i3] = (short) Util.roundToInt(f3 + (fArr2[i3] * f));
        }
    }

    void morphColors(VertexArray[] vertexArrayArr, float[] fArr, float[] fArr2, float f) {
        for (VertexArray vertexArray : vertexArrayArr) {
            if (!isCompatible(vertexArray)) {
                throw new IllegalStateException();
            }
        }
        if (this.byteValues != null) {
            for (int i = 0; i < this.byteValues.length; i++) {
                float f2 = 0.0f;
                for (int i2 = 0; i2 < vertexArrayArr.length; i2++) {
                    f2 += (vertexArrayArr[i2].byteValues[i] & 255) * fArr[i2];
                }
                this.byteValues[i] = (byte) Util.clamp((int) (f2 + (fArr2[i] * f) + 0.5f), 0, 255);
            }
        }
    }

    public void set(int i, int i2, byte[] bArr) {
        if (this.byteValues == null) {
            throw new IllegalStateException();
        }
        if (i2 < 0 || this.numComponents * i2 > bArr.length) {
            throw new IllegalArgumentException();
        }
        if (i < 0 || i + i2 > this.numEntries) {
            throw new IndexOutOfBoundsException();
        }
        for (int i3 = 0; i3 < this.numComponents * i2; i3++) {
            this.byteValues[(this.numComponents * i) + i3] = bArr[i3];
        }
    }

    public void set(int i, int i2, short[] sArr) {
        if (this.shortValues == null) {
            throw new IllegalStateException();
        }
        if (i2 < 0 || this.numComponents * i2 > sArr.length) {
            throw new IllegalArgumentException();
        }
        if (i < 0 || i + i2 > this.numEntries) {
            throw new IndexOutOfBoundsException();
        }
        for (int i3 = 0; i3 < this.numComponents * i2; i3++) {
            this.shortValues[(this.numComponents * i) + i3] = sArr[i3];
        }
    }
}
