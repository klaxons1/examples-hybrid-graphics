package javax.microedition.m3g;

import com.nokia.phone.p000ri.m3g.C0000GL;
import com.nokia.phone.p000ri.m3g.Math;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class Texture2D extends Transformable {
    public static final int FILTER_BASE_LEVEL = 208;
    public static final int FILTER_LINEAR = 209;
    public static final int FILTER_NEAREST = 210;
    public static final int FUNC_ADD = 224;
    public static final int FUNC_BLEND = 225;
    public static final int FUNC_DECAL = 226;
    public static final int FUNC_MODULATE = 227;
    public static final int FUNC_REPLACE = 228;
    public static final int WRAP_CLAMP = 240;
    public static final int WRAP_REPEAT = 241;
    private int format;
    private Image2D image;
    private int levels;
    private boolean newImage;
    private int levelFilter = FILTER_BASE_LEVEL;
    private int imageFilter = FILTER_NEAREST;
    private int wrapS = WRAP_REPEAT;
    private int wrapT = WRAP_REPEAT;
    private int texObjName = 0;
    private TextureImage2D[] mipmapImages = null;
    private int blendFunc = FUNC_MODULATE;
    private int blendColor = 0;

    public Texture2D(Image2D image2D) {
        this.image = null;
        this.levels = 1;
        checkDimension(image2D.getWidth());
        checkDimension(image2D.getHeight());
        this.levels = ((int) Math.log2(Math.max(image2D.getWidth(), image2D.getHeight()))) + 1;
        this.image = image2D;
        this.newImage = true;
    }

    static void applyDefaults() {
        C0000GL.Disable(C0000GL.TEXTURE_2D);
    }

    static void checkDimension(int i) {
        int iIntValue = ((Integer) Graphics3D.getProperties().get("maxTextureDimension")).intValue();
        if (i <= 0 || iIntValue < i) {
            throw new IllegalArgumentException();
        }
        int i2 = 1;
        while (i2 < i) {
            i2 *= 2;
        }
        if (i2 != i) {
            throw new IllegalArgumentException();
        }
    }

    private void generateAveragedBitmap(byte[] bArr, byte[] bArr2, int i, int i2, int i3, int i4) {
        int numComponents = this.image.getNumComponents();
        if (i == 1) {
            int i5 = 0;
            for (int i6 = 0; i6 < i4; i6++) {
                for (int i7 = 0; i7 < i3; i7++) {
                    int i8 = ((i6 * i) + i7) * 2 * numComponents;
                    for (int i9 = 0; i9 < numComponents; i9++) {
                        bArr2[i5] = Util.ub2b((Util.b2ub(bArr[i8]) + Util.b2ub(bArr[(i * numComponents) + i8])) / 2);
                        i5++;
                        i8++;
                    }
                }
            }
            return;
        }
        if (i2 == 1) {
            int i10 = 0;
            for (int i11 = 0; i11 < i4; i11++) {
                for (int i12 = 0; i12 < i3; i12++) {
                    int i13 = ((i11 * i) + i12) * 2 * numComponents;
                    for (int i14 = 0; i14 < numComponents; i14++) {
                        bArr2[i10] = Util.ub2b((Util.b2ub(bArr[i13]) + Util.b2ub(bArr[i13 + numComponents])) / 2);
                        i10++;
                        i13++;
                    }
                }
            }
            return;
        }
        int i15 = 0;
        for (int i16 = 0; i16 < i4; i16++) {
            for (int i17 = 0; i17 < i3; i17++) {
                int i18 = ((i16 * i) + i17) * 2 * numComponents;
                for (int i19 = 0; i19 < numComponents; i19++) {
                    bArr2[i15] = Util.ub2b((((Util.b2ub(bArr[i18]) + Util.b2ub(bArr[i18 + numComponents])) + Util.b2ub(bArr[(i * numComponents) + i18])) + Util.b2ub(bArr[((i + 1) * numComponents) + i18])) / 4);
                    i15++;
                    i18++;
                }
            }
        }
    }

    private void generateMipmap() {
        int width = this.image.getWidth();
        int height = this.image.getHeight();
        int numComponents = this.image.getNumComponents();
        int i = 0;
        while (i < this.levels - 1) {
            int iNewLength = newLength(width);
            int iNewLength2 = newLength(height);
            byte[] bArr = new byte[iNewLength * iNewLength2 * numComponents];
            generateAveragedBitmap(this.mipmapImages[i].pixels, bArr, width, height, iNewLength, iNewLength2);
            if (this.mipmapImages[i + 1] == null) {
                this.mipmapImages[i + 1] = new TextureImage2D(bArr);
            } else {
                this.mipmapImages[i + 1].setImage(bArr);
            }
            i++;
            height = iNewLength2;
            width = iNewLength;
        }
    }

    private int newLength(int i) {
        if (i < 2) {
            return 1;
        }
        return i / 2;
    }

    void apply() {
        boolean z;
        int i;
        int i2;
        if (this.image == null) {
            C0000GL.Disable(C0000GL.TEXTURE_2D);
            return;
        }
        if (this.texObjName == 0) {
            int[] iArr = new int[1];
            C0000GL.GenTextures(1, iArr);
            this.texObjName = iArr[0];
        }
        C0000GL.BindTexture(C0000GL.TEXTURE_2D, this.texObjName);
        C0000GL.MatrixMode(C0000GL.TEXTURE);
        Transform transform = new Transform();
        getCompositeTransform(transform);
        if (!transform.isWUnity()) {
            C0000GL.Hint(C0000GL.PERSPECTIVE_CORRECTION_HINT, C0000GL.NICEST);
        }
        C0000GL.LoadMatrixf(transform.getMatrix());
        C0000GL.MatrixMode(C0000GL.MODELVIEW);
        float[] fArr = new float[4];
        int i3 = C0000GL.REPLACE;
        switch (this.blendFunc) {
            case FUNC_ADD /* 224 */:
                i3 = 260;
                break;
            case FUNC_BLEND /* 225 */:
                i3 = C0000GL.BLEND;
                break;
            case FUNC_DECAL /* 226 */:
                i3 = C0000GL.DECAL;
                break;
            case FUNC_MODULATE /* 227 */:
                i3 = C0000GL.MODULATE;
                break;
            case FUNC_REPLACE /* 228 */:
                i3 = C0000GL.REPLACE;
                break;
        }
        C0000GL.TexEnvi(C0000GL.TEXTURE_ENV, C0000GL.TEXTURE_ENV_MODE, i3);
        Util.getFloatColor(this.blendColor, 1.0f, fArr);
        C0000GL.TexEnvfv(C0000GL.TEXTURE_ENV, C0000GL.TEXTURE_ENV_COLOR, fArr);
        int i4 = isMipmaped() ? this.levels : 1;
        if (this.mipmapImages == null || this.mipmapImages.length != i4) {
            this.mipmapImages = new TextureImage2D[i4];
            z = true;
        } else {
            z = false;
        }
        boolean zIsDirty = this.image.isDirty();
        if (zIsDirty || this.newImage || this.mipmapImages[0] == null) {
            if (this.mipmapImages[0] == null) {
                this.mipmapImages[0] = new TextureImage2D(this.image.getImage());
            } else {
                this.mipmapImages[0].setImage(this.image.getImage());
            }
        }
        if ((isMipmaped() && zIsDirty) || ((isMipmaped() && this.newImage) || (z && i4 != 1))) {
            generateMipmap();
        }
        this.newImage = false;
        int i5 = C0000GL.RGB;
        switch (this.image.getFormat()) {
            case Image2D.ALPHA /* 96 */:
                i5 = C0000GL.ALPHA;
                break;
            case Image2D.LUMINANCE /* 97 */:
                i5 = C0000GL.LUMINANCE;
                break;
            case Image2D.LUMINANCE_ALPHA /* 98 */:
                i5 = C0000GL.LUMINANCE_ALPHA;
                break;
            case Image2D.RGB /* 99 */:
                i5 = C0000GL.RGB;
                break;
            case 100:
                i5 = C0000GL.RGBA;
                break;
        }
        for (int i6 = 0; i6 < i4; i6++) {
            C0000GL.TexImage2D(C0000GL.TEXTURE_2D, i6, i5, Math.max(this.image.getWidth() >> i6, 1), Math.max(this.image.getHeight() >> i6, 1), 0, i5, C0000GL.UNSIGNED_BYTE, this.mipmapImages[i6].pixels);
        }
        if (this.wrapS == 240) {
            C0000GL.TexParameteri(C0000GL.TEXTURE_2D, C0000GL.TEXTURE_WRAP_S, C0000GL.CLAMP);
        } else {
            C0000GL.TexParameteri(C0000GL.TEXTURE_2D, C0000GL.TEXTURE_WRAP_S, C0000GL.REPEAT);
        }
        if (this.wrapT == 240) {
            C0000GL.TexParameteri(C0000GL.TEXTURE_2D, C0000GL.TEXTURE_WRAP_T, C0000GL.CLAMP);
        } else {
            C0000GL.TexParameteri(C0000GL.TEXTURE_2D, C0000GL.TEXTURE_WRAP_T, C0000GL.REPEAT);
        }
        if (this.levelFilter == 208) {
            if (this.imageFilter == 210) {
                i = 9728;
                i2 = 9728;
            } else {
                i = 9729;
                i2 = 9729;
            }
        } else if (this.levelFilter == 209) {
            if (this.imageFilter == 210) {
                i = 9728;
                i2 = 9985;
            } else {
                i = 9729;
                i2 = 9987;
            }
        } else if (this.imageFilter == 210) {
            i = 9728;
            i2 = 9984;
        } else {
            i = 9729;
            i2 = 9986;
        }
        C0000GL.TexParameteri(C0000GL.TEXTURE_2D, C0000GL.TEXTURE_MIN_FILTER, i2);
        C0000GL.TexParameteri(C0000GL.TEXTURE_2D, C0000GL.TEXTURE_MAG_FILTER, i);
        C0000GL.Enable(C0000GL.TEXTURE_2D);
    }

    @Override // javax.microedition.m3g.Object3D
    Object3D createDuplicate() {
        Texture2D texture2D = new Texture2D(this.image);
        texture2D.copy((Transformable) this);
        texture2D.levelFilter = this.levelFilter;
        texture2D.imageFilter = this.imageFilter;
        texture2D.wrapS = this.wrapS;
        texture2D.wrapT = this.wrapT;
        texture2D.format = this.format;
        if (this.mipmapImages != null) {
            if (texture2D.mipmapImages == null || texture2D.mipmapImages.length != this.mipmapImages.length) {
                texture2D.mipmapImages = new TextureImage2D[this.mipmapImages.length];
            }
            for (int i = 0; i < this.mipmapImages.length; i++) {
                if (this.mipmapImages[i] != null) {
                    texture2D.mipmapImages[i] = new TextureImage2D(this.mipmapImages[i].pixels);
                } else {
                    texture2D.mipmapImages[i] = null;
                }
            }
        }
        texture2D.newImage = this.newImage;
        texture2D.levels = this.levels;
        texture2D.blendFunc = this.blendFunc;
        texture2D.blendColor = this.blendColor;
        return texture2D;
    }

    @Override // javax.microedition.m3g.Object3D
    int doGetReferences(Object3D[] object3DArr) {
        int iDoGetReferences = super.doGetReferences(object3DArr);
        if (this.image == null) {
            return iDoGetReferences;
        }
        if (object3DArr != null) {
            object3DArr[iDoGetReferences] = this.image;
        }
        return iDoGetReferences + 1;
    }

    public int getBlendColor() {
        return this.blendColor;
    }

    public int getBlending() {
        return this.blendFunc;
    }

    public Image2D getImage() {
        return this.image;
    }

    public int getWrappingS() {
        return this.wrapS;
    }

    public int getWrappingT() {
        return this.wrapT;
    }

    @Override // javax.microedition.m3g.Transformable, javax.microedition.m3g.Object3D
    boolean isCompatible(AnimationTrack animationTrack) {
        switch (animationTrack.getTargetProperty()) {
            case 258:
                return true;
            default:
                return super.isCompatible(animationTrack);
        }
    }

    boolean isMipmaped() {
        return this.levelFilter != 208;
    }

    public void setBlendColor(int i) {
        this.blendColor = 16777215 & i;
    }

    public void setBlending(int i) {
        if (i != 224 && i != 225 && i != 226 && i != 227 && i != 228) {
            throw new IllegalArgumentException();
        }
        this.blendFunc = i;
    }

    public void setFiltering(int i, int i2) {
        if ((i != 209 && i != 210 && i != 208) || (i2 != 209 && i2 != 210)) {
            throw new IllegalArgumentException();
        }
        this.levelFilter = i;
        this.imageFilter = i2;
    }

    public void setImage(Image2D image2D) {
        checkDimension(image2D.getWidth());
        checkDimension(image2D.getHeight());
        if (this.image != image2D) {
            int iLog2 = ((int) Math.log2(Math.max(image2D.getWidth(), image2D.getHeight()))) + 1;
            if (iLog2 != this.levels) {
                this.levels = iLog2;
                this.mipmapImages = null;
            }
            this.image = image2D;
            this.newImage = true;
        }
    }

    public void setWrapping(int i, int i2) {
        if (i != 240 && i != 241) {
            throw new IllegalArgumentException();
        }
        if (i2 != 240 && i2 != 241) {
            throw new IllegalArgumentException();
        }
        this.wrapS = i;
        this.wrapT = i2;
    }

    @Override // javax.microedition.m3g.Transformable, javax.microedition.m3g.Object3D
    void updateProperty(int i, float[] fArr) {
        switch (i) {
            case 258:
                this.blendColor = Util.getIntColor(fArr);
                break;
            default:
                super.updateProperty(i, fArr);
                break;
        }
    }
}
