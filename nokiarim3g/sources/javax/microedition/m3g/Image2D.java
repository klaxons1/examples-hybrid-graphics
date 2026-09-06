package javax.microedition.m3g;

import javax.microedition.lcdui.Image;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class Image2D extends Object3D {
    public static final int ALPHA = 96;
    public static final int LUMINANCE = 97;
    public static final int LUMINANCE_ALPHA = 98;
    public static final int RGB = 99;
    public static final int RGBA = 100;
    private byte[] cleanImage;
    private boolean dirty;
    private int format;
    private int height;
    private boolean mutable;
    private int numComponents;
    private byte[] palette;
    private byte[] pixels;
    private int width;

    public Image2D(int i, int i2, int i3) {
        this.format = 99;
        this.pixels = null;
        this.palette = null;
        this.dirty = true;
        this.cleanImage = null;
        this.mutable = false;
        if (i2 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException();
        }
        this.numComponents = getNumComponents(i);
        this.pixels = new byte[i2 * i3 * this.numComponents];
        for (int i4 = 0; i4 < this.pixels.length; i4++) {
            this.pixels[i4] = -1;
        }
        this.width = i2;
        this.height = i3;
        this.format = i;
        this.mutable = true;
    }

    public Image2D(int i, int i2, int i3, byte[] bArr) {
        this.format = 99;
        this.pixels = null;
        this.palette = null;
        this.dirty = true;
        this.cleanImage = null;
        this.mutable = false;
        if (i2 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException();
        }
        this.numComponents = getNumComponents(i);
        int i4 = i2 * i3 * this.numComponents;
        if (bArr.length < i4) {
            throw new IllegalArgumentException();
        }
        this.pixels = new byte[i4];
        System.arraycopy(bArr, 0, this.pixels, 0, i4);
        this.width = i2;
        this.height = i3;
        this.format = i;
        this.mutable = false;
    }

    public Image2D(int i, int i2, int i3, byte[] bArr, byte[] bArr2) {
        this.format = 99;
        this.pixels = null;
        this.palette = null;
        this.dirty = true;
        this.cleanImage = null;
        this.mutable = false;
        if (i2 <= 0 || i3 <= 0) {
            throw new IllegalArgumentException();
        }
        this.numComponents = getNumComponents(i);
        int i4 = i2 * i3;
        if (bArr.length < i4) {
            throw new IllegalArgumentException();
        }
        if (bArr2.length < this.numComponents * 256 && bArr2.length % this.numComponents != 0) {
            throw new IllegalArgumentException();
        }
        int iMin = Math.min(bArr2.length, this.numComponents * 256);
        this.pixels = new byte[i4];
        System.arraycopy(bArr, 0, this.pixels, 0, i4);
        this.palette = new byte[iMin];
        System.arraycopy(bArr2, 0, this.palette, 0, iMin);
        this.width = i2;
        this.height = i3;
        this.format = i;
        this.mutable = false;
    }

    public Image2D(int i, Object obj) {
        this.format = 99;
        this.pixels = null;
        this.palette = null;
        this.dirty = true;
        this.cleanImage = null;
        this.mutable = false;
        this.numComponents = getNumComponents(i);
        if (obj == null) {
            throw new NullPointerException();
        }
        if (!(obj instanceof Image)) {
            throw new IllegalArgumentException();
        }
        Image image = (Image) obj;
        this.width = image.getWidth();
        this.height = image.getHeight();
        this.pixels = new byte[this.width * this.height * this.numComponents];
        int[] iArr = new int[this.width * this.height];
        image.getRGB(iArr, 0, this.width, 0, 0, this.width, this.height);
        convertRGBAPixels(iArr, this.pixels, i);
        this.format = i;
        this.mutable = false;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    private void convertRGBAPixels(int[] iArr, byte[] bArr, int i) {
        int i2 = 0;
        switch (i) {
            case ALPHA /* 96 */:
            case LUMINANCE /* 97 */:
                while (i2 < iArr.length) {
                    bArr[i2] = getRGBAverage(iArr[i2]);
                    i2++;
                }
                break;
            case LUMINANCE_ALPHA /* 98 */:
                while (i2 < iArr.length) {
                    bArr[i2 * 2] = getRGBAverage(iArr[i2]);
                    bArr[(i2 * 2) + 1] = (byte) ((iArr[i2] & (-16777216)) >> 24);
                    i2++;
                }
                break;
            case RGB /* 99 */:
                while (i2 < iArr.length) {
                    bArr[i2 * 3] = (byte) ((iArr[i2] & 16711680) >> 16);
                    bArr[(i2 * 3) + 1] = (byte) ((iArr[i2] & 65280) >> 8);
                    bArr[(i2 * 3) + 2] = (byte) (iArr[i2] & 255);
                    i2++;
                }
                break;
            case 100:
                while (i2 < iArr.length) {
                    bArr[i2 * 4] = (byte) ((iArr[i2] & 16711680) >> 16);
                    bArr[(i2 * 4) + 1] = (byte) ((iArr[i2] & 65280) >> 8);
                    bArr[(i2 * 4) + 2] = (byte) (iArr[i2] & 255);
                    bArr[(i2 * 4) + 3] = (byte) ((iArr[i2] & (-16777216)) >> 24);
                    i2++;
                }
                break;
        }
    }

    private int getNumComponents(int i) {
        switch (i) {
            case ALPHA /* 96 */:
            case LUMINANCE /* 97 */:
                return 1;
            case LUMINANCE_ALPHA /* 98 */:
                return 2;
            case RGB /* 99 */:
                return 3;
            case 100:
                return 4;
            default:
                throw new IllegalArgumentException();
        }
    }

    private static byte getRGBAverage(int i) {
        return (byte) (((Util.b2ub((byte) ((16711680 & i) >> 16)) + Util.b2ub((byte) ((65280 & i) >> 8))) + Util.b2ub((byte) (i & 255))) / 3);
    }

    @Override // javax.microedition.m3g.Object3D
    Object3D createDuplicate() {
        Image2D image2D = this.palette == null ? new Image2D(this.format, this.width, this.height, this.pixels) : new Image2D(this.format, this.width, this.height, this.pixels, this.palette);
        image2D.copy(this);
        if (this.cleanImage == null) {
            image2D.cleanImage = null;
        } else {
            image2D.cleanImage = new byte[this.cleanImage.length];
            System.arraycopy(this.cleanImage, 0, image2D.cleanImage, 0, this.cleanImage.length);
        }
        image2D.dirty = this.dirty;
        image2D.mutable = this.mutable;
        return image2D;
    }

    public int getFormat() {
        return this.format;
    }

    public int getHeight() {
        return this.height;
    }

    byte[] getImage() {
        if (this.palette == null) {
            if (this.pixels == null) {
                throw new Error("null pixels in Image2D.getImage()");
            }
            this.dirty = false;
            return this.pixels;
        }
        if (this.dirty || this.cleanImage == null) {
            if (this.cleanImage == null) {
                this.cleanImage = new byte[this.pixels.length * this.numComponents];
            }
            for (int i = 0; i < this.pixels.length; i++) {
                try {
                    System.arraycopy(this.palette, Util.b2ub(this.pixels[i]) * this.numComponents, this.cleanImage, this.numComponents * i, this.numComponents);
                } catch (ArrayIndexOutOfBoundsException e) {
                }
            }
            this.dirty = false;
        }
        return this.cleanImage;
    }

    int getNumComponents() {
        return this.numComponents;
    }

    public int getWidth() {
        return this.width;
    }

    boolean isDirty() {
        return this.dirty;
    }

    public boolean isMutable() {
        return this.mutable;
    }

    public void set(int i, int i2, int i3, int i4, byte[] bArr) {
        if (!isMutable()) {
            throw new IllegalStateException();
        }
        if (i < 0 || i2 < 0 || i3 <= 0 || i4 <= 0 || i + i3 > this.width || i2 + i4 > this.height) {
            throw new IllegalArgumentException();
        }
        if (bArr.length < i3 * i4 * this.numComponents) {
            throw new IllegalArgumentException();
        }
        for (int i5 = 0; i5 < i4; i5++) {
            System.arraycopy(bArr, i5 * i3 * this.numComponents, this.pixels, (((i2 + i5) * this.width) + i) * this.numComponents, this.numComponents * i3);
        }
        this.dirty = true;
    }

    void setDirty() {
        this.dirty = true;
    }
}
