package javax.microedition.m3g;

import com.nokia.phone.p000ri.m3g.C0000GL;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class TriangleStripArray extends IndexBuffer {
    private int firstIndex;
    private short[] indices;
    private short[][] stripIndices;
    private short[] stripLengths;
    private int maxIndex = -1;
    private int numTriangles = 0;
    private boolean dirtyState = true;

    TriangleStripArray() {
    }

    public TriangleStripArray(int i, int[] iArr) {
        if (iArr == null) {
            throw new NullPointerException();
        }
        if (iArr.length == 0) {
            throw new IllegalArgumentException();
        }
        if (i < 0) {
            throw new IndexOutOfBoundsException();
        }
        int i2 = i;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            if (iArr[i3] < 3 || iArr[i3] > 65535) {
                throw new IllegalArgumentException();
            }
            i2 += iArr[i3];
            if (i2 > 65535) {
                throw new IndexOutOfBoundsException();
            }
        }
        this.stripLengths = new short[iArr.length];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            this.stripLengths[i4] = (short) iArr[i4];
            this.numTriangles += iArr[i4] - 2;
        }
        this.firstIndex = i;
    }

    public TriangleStripArray(int[] iArr, int[] iArr2) {
        if (iArr == null || iArr2 == null) {
            throw new NullPointerException();
        }
        if (iArr2.length == 0 || iArr.length < 3) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < iArr.length; i++) {
            if (iArr[i] < 0 || iArr[i] > 65535) {
                throw new IndexOutOfBoundsException();
            }
        }
        int i2 = 0;
        for (int i3 = 0; i3 < iArr2.length; i3++) {
            if (iArr2[i3] < 3 || iArr2[i3] > 65535) {
                throw new IllegalArgumentException();
            }
            i2 += iArr2[i3];
            if (i2 > iArr.length) {
                throw new IllegalArgumentException();
            }
        }
        this.indices = new short[iArr.length];
        for (int i4 = 0; i4 < iArr.length; i4++) {
            this.indices[i4] = (short) iArr[i4];
        }
        this.stripIndices = new short[iArr2.length][];
        for (int i5 = 0; i5 < iArr2.length; i5++) {
            this.stripIndices[i5] = new short[iArr2[i5]];
            this.numTriangles += iArr2[i5] - 2;
        }
    }

    private void validate() {
        if (this.indices == null) {
            int i = 0;
            for (int i2 = 0; i2 < this.stripLengths.length; i2++) {
                i += this.stripLengths[i2];
            }
            this.maxIndex = (this.firstIndex + i) - 1;
        } else {
            int length = 0;
            for (int i3 = 0; i3 < this.stripIndices.length; i3++) {
                for (int i4 = 0; i4 < this.stripIndices[i3].length; i4++) {
                    this.stripIndices[i3][i4] = this.indices[length + i4];
                }
                length += this.stripIndices[i3].length;
            }
            short s = 0;
            for (int i5 = 0; i5 < this.indices.length; i5++) {
                if (this.indices[i5] > s) {
                    s = this.indices[i5];
                }
            }
            this.maxIndex = s;
        }
        this.dirtyState = false;
    }

    @Override // javax.microedition.m3g.Object3D
    Object3D createDuplicate() {
        TriangleStripArray triangleStripArray = new TriangleStripArray();
        triangleStripArray.copy(this);
        triangleStripArray.stripLengths = new short[this.stripLengths.length];
        System.arraycopy(this.stripLengths, 0, triangleStripArray.stripLengths, 0, this.stripLengths.length);
        if (this.indices == null) {
            triangleStripArray.indices = null;
        } else {
            triangleStripArray.indices = new short[this.indices.length];
            System.arraycopy(this.indices, 0, triangleStripArray.indices, 0, this.indices.length);
        }
        if (this.stripIndices == null) {
            triangleStripArray.stripIndices = null;
        } else {
            triangleStripArray.stripIndices = new short[this.stripIndices.length][];
            for (int i = 0; i < this.stripIndices.length; i++) {
                triangleStripArray.stripIndices[i] = new short[this.stripIndices[i].length];
                System.arraycopy(this.stripIndices, 0, triangleStripArray.stripIndices, 0, this.stripIndices.length);
            }
        }
        triangleStripArray.firstIndex = this.firstIndex;
        triangleStripArray.maxIndex = this.maxIndex;
        triangleStripArray.numTriangles = this.numTriangles;
        triangleStripArray.dirtyState = this.dirtyState;
        return triangleStripArray;
    }

    @Override // javax.microedition.m3g.IndexBuffer
    void draw() {
        int i = 0;
        if (this.dirtyState) {
            validate();
        }
        if (this.indices != null) {
            while (i < this.stripIndices.length) {
                C0000GL.DrawElements(5, this.stripIndices[i].length, C0000GL.UNSIGNED_SHORT, this.stripIndices[i]);
                i++;
            }
        } else {
            int i2 = this.firstIndex;
            while (i < this.stripLengths.length) {
                short s = this.stripLengths[i];
                C0000GL.DrawArrays(5, i2, s);
                i2 += s;
                i++;
            }
        }
    }

    @Override // javax.microedition.m3g.IndexBuffer
    boolean getIndices(int i, int[] iArr) {
        if (this.dirtyState) {
            validate();
        }
        if (i >= this.numTriangles) {
            return false;
        }
        if (this.indices != null) {
            for (int i2 = 0; i2 < this.stripIndices.length; i2++) {
                if (i < this.stripIndices[i2].length - 2) {
                    iArr[0] = this.stripIndices[i2][i + 0];
                    iArr[1] = this.stripIndices[i2][i + 1];
                    iArr[2] = this.stripIndices[i2][i + 2];
                    iArr[3] = i & 1;
                    return true;
                }
                i -= this.stripIndices[i2].length - 2;
            }
            return false;
        }
        int i3 = this.firstIndex;
        for (int i4 = 0; i4 < this.stripLengths.length; i4++) {
            if (i < this.stripLengths[i4] - 2) {
                iArr[0] = i3 + i + 0;
                iArr[1] = i3 + i + 1;
                iArr[2] = i3 + i + 2;
                iArr[3] = i & 1;
                return true;
            }
            i3 += this.stripLengths[i4];
            i -= this.stripLengths[i4] - 2;
        }
        return false;
    }

    @Override // javax.microedition.m3g.IndexBuffer
    int getMaxIndex() {
        if (this.dirtyState) {
            validate();
        }
        return this.maxIndex;
    }
}
