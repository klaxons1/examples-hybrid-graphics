package javax.microedition.m3g;

import com.nokia.phone.p000ri.m3g.C0000GL;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class VertexBuffer extends Object3D {
    static final int COLOR = 4;
    static final int NORMAL = 2;
    static final int POSITION = 1;
    static final int TEXCOORD0 = 8;
    static final int TEXCOORD1 = 16;
    private static byte[] tempColors = new byte[4];
    private float[][] texBias;
    private VertexArray[] texCoords;
    private float[] texScale;
    private int vertexCount = 0;
    private int arrayCount = 0;
    private int arrayMask = 0;
    private VertexArray vertices = null;
    private VertexArray normals = null;
    private VertexArray colors = null;
    private byte[] colorCache = null;
    private float vertexScale = 1.0f;
    private float[] vertexBias = null;
    private int defaultColor = -1;
    private int timestamp = 0;

    public VertexBuffer() {
        this.texCoords = null;
        this.texScale = null;
        this.texBias = null;
        this.texCoords = new VertexArray[Graphics3D.getNumTextureUnits()];
        this.texScale = new float[Graphics3D.getNumTextureUnits()];
        this.texBias = new float[Graphics3D.getNumTextureUnits()][];
        for (int i = 0; i < Graphics3D.getNumTextureUnits(); i++) {
            this.texCoords[i] = null;
            this.texScale[i] = 1.0f;
            this.texBias[i] = null;
        }
    }

    void applyScaleBias() {
        for (int i = 0; i < this.texCoords.length; i++) {
            if (this.texCoords[i] != null) {
                C0000GL.ActiveTexture(C0000GL.TEXTURE0 + i);
                C0000GL.MatrixMode(C0000GL.TEXTURE);
                if (this.texBias[i] != null) {
                    C0000GL.Translatef(this.texBias[i][0], this.texBias[i][1], this.texBias[i].length > 2 ? this.texBias[i][2] : 0.0f);
                }
                C0000GL.Scalef(this.texScale[i], this.texScale[i], this.texScale[i]);
            }
        }
        C0000GL.MatrixMode(C0000GL.MODELVIEW);
        if (this.vertexBias != null) {
            C0000GL.Translatef(this.vertexBias[0], this.vertexBias[1], this.vertexBias.length > 2 ? this.vertexBias[2] : 0.0f);
        }
        C0000GL.Scalef(this.vertexScale, this.vertexScale, this.vertexScale);
    }

    @Override // javax.microedition.m3g.Object3D
    Object3D createDuplicate() {
        VertexBuffer vertexBuffer = new VertexBuffer();
        vertexBuffer.copy(this);
        vertexBuffer.vertexCount = this.vertexCount;
        vertexBuffer.arrayCount = this.arrayCount;
        vertexBuffer.vertices = this.vertices;
        vertexBuffer.normals = this.normals;
        vertexBuffer.colors = this.colors;
        vertexBuffer.texCoords = new VertexArray[this.texCoords.length];
        System.arraycopy(this.texCoords, 0, vertexBuffer.texCoords, 0, this.texCoords.length);
        vertexBuffer.arrayMask = this.arrayMask;
        vertexBuffer.vertexScale = this.vertexScale;
        if (this.vertexBias != null) {
            vertexBuffer.vertexBias = new float[this.vertexBias.length];
            System.arraycopy(this.vertexBias, 0, vertexBuffer.vertexBias, 0, this.vertexBias.length);
        }
        vertexBuffer.texScale = new float[this.texScale.length];
        System.arraycopy(this.texScale, 0, vertexBuffer.texScale, 0, this.texScale.length);
        vertexBuffer.texBias = new float[this.texBias.length][];
        for (int i = 0; i < this.texBias.length; i++) {
            if (this.texBias[i] != null) {
                vertexBuffer.texBias[i] = new float[this.texBias[i].length];
                System.arraycopy(this.texBias[i], 0, vertexBuffer.texBias[i], 0, this.texBias[i].length);
            }
        }
        vertexBuffer.defaultColor = this.defaultColor;
        return vertexBuffer;
    }

    @Override // javax.microedition.m3g.Object3D
    int doGetReferences(Object3D[] object3DArr) {
        int iDoGetReferences = super.doGetReferences(object3DArr);
        if (this.vertices != null) {
            if (object3DArr != null) {
                object3DArr[iDoGetReferences] = this.vertices;
            }
            iDoGetReferences++;
        }
        if (this.normals != null) {
            if (object3DArr != null) {
                object3DArr[iDoGetReferences] = this.normals;
            }
            iDoGetReferences++;
        }
        if (this.colors != null) {
            if (object3DArr != null) {
                object3DArr[iDoGetReferences] = this.colors;
            }
            iDoGetReferences++;
        }
        int i = iDoGetReferences;
        for (int i2 = 0; i2 < this.texCoords.length; i2++) {
            if (this.texCoords[i2] != null) {
                if (object3DArr != null) {
                    object3DArr[i] = this.texCoords[i2];
                }
                i++;
            }
        }
        return i;
    }

    VertexBuffer duplicateData() {
        VertexBuffer vertexBuffer = new VertexBuffer();
        vertexBuffer.vertexCount = this.vertexCount;
        vertexBuffer.arrayCount = this.arrayCount;
        vertexBuffer.vertices = this.vertices;
        vertexBuffer.normals = this.normals;
        vertexBuffer.colors = this.colors;
        vertexBuffer.texCoords = new VertexArray[this.texCoords.length];
        for (int i = 0; i < this.texCoords.length; i++) {
            vertexBuffer.texCoords[i] = this.texCoords[i];
        }
        vertexBuffer.arrayMask = this.arrayMask;
        vertexBuffer.vertexScale = this.vertexScale;
        vertexBuffer.vertexBias = this.vertexBias;
        vertexBuffer.texScale = this.texScale;
        vertexBuffer.texBias = this.texBias;
        vertexBuffer.defaultColor = this.defaultColor;
        return vertexBuffer;
    }

    public VertexArray getColors() {
        return this.colors;
    }

    public int getDefaultColor() {
        return this.defaultColor;
    }

    boolean getNormalVertex(int i, Vec4f vec4f) {
        float f;
        float f2;
        float f3;
        if (this.normals == null) {
            return false;
        }
        byte[] byteValues = this.normals.getByteValues();
        short[] shortValues = this.normals.getShortValues();
        if (byteValues != null) {
            f = byteValues[(i * 3) + 0];
            f2 = byteValues[(i * 3) + 1];
            f3 = byteValues[(i * 3) + 2];
        } else {
            f = shortValues[(i * 3) + 0];
            f2 = shortValues[(i * 3) + 1];
            f3 = shortValues[(i * 3) + 2];
        }
        vec4f.set(f, f2, f3, 1.0f);
        return true;
    }

    public VertexArray getNormals() {
        return this.normals;
    }

    int getNumVertices() {
        return this.vertexCount;
    }

    public VertexArray getPositions(float[] fArr) {
        if (fArr != null) {
            if (fArr.length < 4) {
                throw new IllegalArgumentException();
            }
            if (this.vertices != null) {
                fArr[0] = this.vertexScale;
                if (this.vertexBias != null) {
                    fArr[1] = this.vertexBias[0];
                    fArr[2] = this.vertexBias[1];
                    fArr[3] = this.vertexBias[2];
                } else {
                    fArr[1] = 0.0f;
                    fArr[2] = 0.0f;
                    fArr[3] = 0.0f;
                }
            }
        }
        return this.vertices;
    }

    public VertexArray getTexCoords(int i, float[] fArr) {
        if (i < 0 || i >= this.texCoords.length) {
            throw new IndexOutOfBoundsException();
        }
        if (this.texCoords[i] != null && fArr != null) {
            if (this.texBias[i] != null) {
                if (fArr.length < this.texBias[i].length + 1) {
                    throw new IllegalArgumentException();
                }
            } else if (fArr.length < 3) {
                throw new IllegalArgumentException();
            }
            fArr[0] = this.texScale[i];
            if (this.texBias[i] != null) {
                fArr[1] = this.texBias[i][0];
                fArr[2] = this.texBias[i][1];
                if (this.texBias[i].length == 3) {
                    fArr[3] = this.texBias[i][2];
                }
            } else {
                for (int i2 = 1; i2 < Math.min(fArr.length, this.texCoords[i].getNumComponents() + 1); i2++) {
                    fArr[i2] = 0.0f;
                }
            }
        }
        return this.texCoords[i];
    }

    boolean getTexVertex(int i, int i2, Vec4f vec4f) {
        float f;
        float f2;
        if (this.texCoords[i2] == null) {
            return false;
        }
        byte[] byteValues = this.texCoords[i2].getByteValues();
        short[] shortValues = this.texCoords[i2].getShortValues();
        int numComponents = this.texCoords[i2].getNumComponents();
        if (byteValues != null) {
            f = byteValues[(i * numComponents) + 0];
            f2 = byteValues[(i * numComponents) + 1];
        } else {
            f = shortValues[(i * numComponents) + 0];
            f2 = shortValues[(i * numComponents) + 1];
        }
        float f3 = f * this.texScale[i2];
        float f4 = f2 * this.texScale[i2];
        if (this.texBias[i2] != null) {
            f3 += this.texBias[i2][0];
            f4 += this.texBias[i2][1];
        }
        vec4f.set(f3, f4, 0.0f, 1.0f);
        return true;
    }

    int getTimeStamp() {
        return this.timestamp;
    }

    void getVertex(int i, Vec4f vec4f) {
        float f;
        float f2;
        float f3;
        byte[] byteValues = this.vertices.getByteValues();
        short[] shortValues = this.vertices.getShortValues();
        if (byteValues != null) {
            f = byteValues[(i * 3) + 0];
            f2 = byteValues[(i * 3) + 1];
            f3 = byteValues[(i * 3) + 2];
        } else {
            f = shortValues[(i * 3) + 0];
            f2 = shortValues[(i * 3) + 1];
            f3 = shortValues[(i * 3) + 2];
        }
        float f4 = f * this.vertexScale;
        float f5 = f2 * this.vertexScale;
        float f6 = f3 * this.vertexScale;
        if (this.vertexBias != null) {
            f4 += this.vertexBias[0];
            f5 += this.vertexBias[1];
            f6 += this.vertexBias[2];
        }
        vec4f.set(f4, f5, f6, 1.0f);
    }

    public int getVertexCount() {
        return this.vertexCount;
    }

    @Override // javax.microedition.m3g.Object3D
    boolean isCompatible(AnimationTrack animationTrack) {
        switch (animationTrack.getTargetProperty()) {
            case 256:
            case 258:
                return true;
            case 257:
            default:
                return super.isCompatible(animationTrack);
        }
    }

    void load(int i, float f) {
        if (this.vertices == null || (this.arrayMask & i) != i) {
            throw new IllegalStateException(new StringBuffer().append("required mask ").append(i).append(", got ").append(this.arrayMask).toString());
        }
        C0000GL.EnableClientState(C0000GL.VERTEX_ARRAY);
        if (this.vertices.getShortValues() != null) {
            C0000GL.VertexPointer(this.vertices.getNumComponents(), C0000GL.SHORT, 0, this.vertices.getShortValues());
        } else {
            C0000GL.VertexPointer(this.vertices.getNumComponents(), C0000GL.BYTE, 0, this.vertices.getByteValues());
        }
        if (this.normals != null) {
            C0000GL.EnableClientState(C0000GL.NORMAL_ARRAY);
            if (this.normals.getShortValues() != null) {
                C0000GL.NormalPointer(C0000GL.SHORT, 0, this.normals.getShortValues());
            } else {
                C0000GL.NormalPointer(C0000GL.BYTE, 0, this.normals.getByteValues());
            }
        } else {
            C0000GL.DisableClientState(C0000GL.NORMAL_ARRAY);
        }
        for (int i2 = 0; i2 < this.texCoords.length; i2++) {
            C0000GL.ClientActiveTexture(C0000GL.TEXTURE0 + i2);
            if (this.texCoords[i2] != null) {
                C0000GL.EnableClientState(C0000GL.TEXTURE_COORD_ARRAY);
                if (this.texCoords[i2].getShortValues() != null) {
                    C0000GL.TexCoordPointer(this.texCoords[i2].getNumComponents(), C0000GL.SHORT, 0, this.texCoords[i2].getShortValues());
                } else {
                    C0000GL.TexCoordPointer(this.texCoords[i2].getNumComponents(), C0000GL.BYTE, 0, this.texCoords[i2].getByteValues());
                }
            } else {
                C0000GL.DisableClientState(C0000GL.TEXTURE_COORD_ARRAY);
            }
        }
        if (this.colors == null) {
            C0000GL.Color4ub((byte) ((this.defaultColor >> 16) & 255), (byte) ((this.defaultColor >> 8) & 255), (byte) (this.defaultColor & 255), (byte) (((this.defaultColor >> 24) & 255) * f));
            C0000GL.DisableClientState(C0000GL.COLOR_ARRAY);
            return;
        }
        C0000GL.EnableClientState(C0000GL.COLOR_ARRAY);
        if (f == 1.0f) {
            C0000GL.ColorPointer(this.colors.getNumComponents(), C0000GL.UNSIGNED_BYTE, 0, this.colors.getByteValues());
            return;
        }
        int numEntries = this.colors.getNumEntries();
        if (this.colorCache == null || this.colorCache.length < numEntries * 4) {
            this.colorCache = new byte[numEntries * 4];
        }
        int i3 = 0;
        for (int i4 = 0; i4 < numEntries; i4++) {
            int colorValue = this.colors.getColorValue(i4);
            int i5 = i3 + 1;
            this.colorCache[i3] = (byte) ((colorValue >> 16) & 255);
            int i6 = i5 + 1;
            this.colorCache[i5] = (byte) ((colorValue >> 8) & 255);
            int i7 = i6 + 1;
            this.colorCache[i6] = (byte) (colorValue & 255);
            i3 = i7 + 1;
            this.colorCache[i7] = (byte) ((((colorValue >> 24) & 255) * f) + 0.5f);
        }
        C0000GL.ColorPointer(4, C0000GL.UNSIGNED_BYTE, 0, this.colorCache);
    }

    public void setColors(VertexArray vertexArray) {
        if (vertexArray != null && (vertexArray.getByteValues() == null || vertexArray.getNumComponents() < 3 || vertexArray.getNumComponents() > 4)) {
            throw new IllegalArgumentException();
        }
        updateArray(this.colors, vertexArray, 4);
        this.colors = vertexArray;
        this.timestamp++;
    }

    public void setDefaultColor(int i) {
        this.defaultColor = i;
        this.timestamp++;
    }

    public void setNormals(VertexArray vertexArray) {
        if (vertexArray != null && vertexArray.getNumComponents() != 3) {
            throw new IllegalArgumentException();
        }
        updateArray(this.normals, vertexArray, 2);
        this.normals = vertexArray;
        this.timestamp++;
    }

    void setPositions(VertexArray vertexArray) {
        setPositions(vertexArray, this.vertexScale, this.vertexBias);
    }

    public void setPositions(VertexArray vertexArray, float f, float[] fArr) {
        if (vertexArray != null && (vertexArray.getNumComponents() != 3 || (fArr != null && fArr.length < 3))) {
            throw new IllegalArgumentException();
        }
        updateArray(this.vertices, vertexArray, 1);
        this.vertices = vertexArray;
        this.vertexScale = f;
        if (fArr == null || vertexArray == null) {
            this.vertexBias = null;
        } else {
            this.vertexBias = new float[3];
            this.vertexBias[0] = fArr[0];
            this.vertexBias[1] = fArr[1];
            this.vertexBias[2] = fArr[2];
        }
        this.timestamp++;
    }

    void setTexCoords(int i, VertexArray vertexArray) {
        setTexCoords(i, vertexArray, this.texScale[i], this.texBias[i]);
    }

    public void setTexCoords(int i, VertexArray vertexArray, float f, float[] fArr) {
        if (vertexArray != null && (vertexArray.getNumComponents() > 3 || vertexArray.getNumComponents() < 2 || (fArr != null && fArr.length < vertexArray.getNumComponents()))) {
            throw new IllegalArgumentException();
        }
        if (i < 0 || i >= this.texCoords.length) {
            throw new IndexOutOfBoundsException();
        }
        updateArray(this.texCoords[i], vertexArray, 8 << i);
        this.texCoords[i] = vertexArray;
        this.texScale[i] = f;
        if (fArr == null || vertexArray == null) {
            this.texBias[i] = null;
        } else {
            this.texBias[i] = new float[vertexArray.getNumComponents()];
            this.texBias[i][0] = fArr[0];
            this.texBias[i][1] = fArr[1];
            if (this.texBias[i].length == 3) {
                this.texBias[i][2] = fArr[2];
            }
        }
        this.timestamp++;
    }

    void updateArray(VertexArray vertexArray, VertexArray vertexArray2, int i) {
        int i2;
        if (vertexArray != null || vertexArray2 == null) {
            i2 = (vertexArray == null || vertexArray2 != null) ? 0 : -1;
        } else {
            i2 = 1;
        }
        if (vertexArray2 != null) {
            if (this.arrayCount == 0 || (this.arrayCount == 1 && i2 == 0)) {
                this.vertexCount = vertexArray2.getNumEntries();
            } else if (vertexArray2.getNumEntries() != this.vertexCount) {
                throw new IllegalArgumentException();
            }
        }
        if (vertexArray2 != null) {
            this.arrayMask |= i;
        } else {
            this.arrayMask &= i ^ (-1);
        }
        this.arrayCount = i2 + this.arrayCount;
        if (this.arrayCount == 0) {
            this.vertexCount = 0;
        }
    }

    @Override // javax.microedition.m3g.Object3D
    void updateProperty(int i, float[] fArr) {
        switch (i) {
            case 256:
                this.defaultColor &= 16777215;
                this.defaultColor |= Util.getIntColor(fArr) & (-16777216);
                break;
            case 257:
            default:
                super.updateProperty(i, fArr);
                break;
            case 258:
                this.defaultColor &= -16777216;
                this.defaultColor |= Util.getIntColor(fArr) & 16777215;
                break;
        }
    }
}
