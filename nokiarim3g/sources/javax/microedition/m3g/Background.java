package javax.microedition.m3g;

import com.nokia.phone.p000ri.m3g.C0000GL;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class Background extends Object3D {
    public static final int BORDER = 32;
    public static final int REPEAT = 33;
    private int cropHeight;
    private int cropWidth;
    private int cropX;
    private int cropY;
    private int color = 0;
    private Image2D image = null;
    private int modeX = 32;
    private int modeY = 32;
    private boolean colorClearEnable = true;
    private boolean depthClearEnable = true;

    static void applyDefaults() {
        C0000GL.DepthMask(true);
        C0000GL.ColorMask(true, true, true, true);
        C0000GL.ClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        C0000GL.Clear(16640);
    }

    void apply(int i, int i2, int i3) {
        int i4;
        float f;
        int i5;
        float f2;
        int i6;
        C0000GL.DepthMask(true);
        C0000GL.ColorMask(true, true, true, true);
        C0000GL.ClearColor(((this.color >> 16) & 255) / 255.0f, ((this.color >> 8) & 255) / 255.0f, (this.color & 255) / 255.0f, ((this.color >> 24) & 255) / 255.0f);
        C0000GL.Clear((this.depthClearEnable ? 256 : 0) | 0 | (this.colorClearEnable ? 16384 : 0));
        if (this.image == null || this.cropWidth <= 0 || this.cropHeight <= 0) {
            return;
        }
        if (this.image.getFormat() != i3) {
            throw new IllegalArgumentException();
        }
        C0000GL.MatrixMode(C0000GL.PROJECTION);
        C0000GL.LoadIdentity();
        C0000GL.MatrixMode(C0000GL.MODELVIEW);
        C0000GL.LoadIdentity();
        float f3 = i / this.cropWidth;
        float f4 = i2 / this.cropHeight;
        float width = f3 * this.image.getWidth();
        float height = f4 * this.image.getHeight();
        float f5 = (((-i) * this.cropX) / this.cropWidth) - (i / 2);
        float f6 = ((this.cropY * i2) / this.cropHeight) + (i2 / 2);
        if (this.modeX != 32) {
            float f7 = f5 % width;
            if (f7 > 0.0f) {
                f7 -= width;
            }
            int i7 = (int) (2.5f + (i / width));
            i4 = i7;
            f = f7 - ((i7 / 2) * width);
        } else {
            i4 = 1;
            f = f5;
        }
        if (this.modeY != 32) {
            int i8 = (int) (2.5f + (i2 / height));
            i5 = i8;
            f2 = (f6 % height) + ((i8 / 2) * height);
        } else {
            i5 = 1;
            f2 = f6;
        }
        C0000GL.PixelStore(C0000GL.UNPACK_ROW_LENGTH, this.image.getWidth());
        C0000GL.PixelStore(C0000GL.UNPACK_SKIP_PIXELS, 0);
        C0000GL.PixelStore(C0000GL.UNPACK_SKIP_ROWS, 0);
        Fog.applyDefaults();
        CompositingMode.applyDefaults();
        for (int i9 = 0; i9 < Graphics3D.getNumTextureUnits(); i9++) {
            C0000GL.ActiveTexture(C0000GL.TEXTURE0 + i9);
            Texture2D.applyDefaults();
        }
        C0000GL.DepthFunc(C0000GL.ALWAYS);
        C0000GL.DepthMask(false);
        C0000GL.PixelZoom(f3, -f4);
        C0000GL.Disable(C0000GL.LIGHTING);
        switch (this.image.getFormat()) {
            case Image2D.ALPHA /* 96 */:
                C0000GL.Enable(C0000GL.ALPHA_TEST);
                i6 = 6406;
                break;
            case Image2D.LUMINANCE /* 97 */:
                i6 = 6409;
                break;
            case Image2D.LUMINANCE_ALPHA /* 98 */:
                C0000GL.Enable(C0000GL.ALPHA_TEST);
                i6 = 6410;
                break;
            case Image2D.RGB /* 99 */:
                i6 = 6407;
                break;
            case 100:
                C0000GL.Enable(C0000GL.ALPHA_TEST);
            default:
                i6 = 6408;
                break;
        }
        for (int i10 = 0; i10 < i5; i10++) {
            for (int i11 = 0; i11 < i4; i11++) {
                C0000GL.RasterPos4f(0.0f, 0.0f, 0.0f, 1.0f);
                C0000GL.Bitmap(0, 0, 0.0f, 0.0f, (i11 * width) + f, f2 - (i10 * height), null);
                C0000GL.DrawPixels(this.image.getWidth(), this.image.getHeight(), i6, C0000GL.UNSIGNED_BYTE, this.image.getImage());
            }
        }
        C0000GL.PixelStore(C0000GL.UNPACK_ROW_LENGTH, 0);
    }

    @Override // javax.microedition.m3g.Object3D
    Object3D createDuplicate() {
        Background background = new Background();
        background.copy(this);
        background.color = this.color;
        background.image = this.image;
        background.modeX = this.modeX;
        background.modeY = this.modeY;
        return background;
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

    public int getColor() {
        return this.color;
    }

    public int getCropHeight() {
        return this.cropHeight;
    }

    public int getCropWidth() {
        return this.cropWidth;
    }

    public int getCropX() {
        return this.cropX;
    }

    public int getCropY() {
        return this.cropY;
    }

    public Image2D getImage() {
        return this.image;
    }

    public int getImageModeX() {
        return this.modeX;
    }

    public int getImageModeY() {
        return this.modeY;
    }

    public boolean isColorClearEnabled() {
        return this.colorClearEnable;
    }

    @Override // javax.microedition.m3g.Object3D
    boolean isCompatible(AnimationTrack animationTrack) {
        switch (animationTrack.getTargetProperty()) {
            case 256:
            case 258:
            case 259:
                return true;
            case 257:
            default:
                return super.isCompatible(animationTrack);
        }
    }

    public boolean isDepthClearEnabled() {
        return this.depthClearEnable;
    }

    public void setColor(int i) {
        this.color = i;
    }

    public void setColorClearEnable(boolean z) {
        this.colorClearEnable = z;
    }

    public void setCrop(int i, int i2, int i3, int i4) {
        if (i3 < 0 || i4 < 0) {
            throw new IllegalArgumentException();
        }
        this.cropX = i;
        this.cropY = i2;
        this.cropWidth = i3;
        this.cropHeight = i4;
    }

    public void setDepthClearEnable(boolean z) {
        this.depthClearEnable = z;
    }

    public void setImage(Image2D image2D) {
        if (image2D != null) {
            if (image2D.getFormat() != 99 && image2D.getFormat() != 100) {
                throw new IllegalArgumentException();
            }
            this.cropX = 0;
            this.cropY = 0;
            this.cropWidth = image2D.getWidth();
            this.cropHeight = image2D.getHeight();
        }
        this.image = image2D;
    }

    public void setImageMode(int i, int i2) {
        if ((i != 33 && i != 32) || (i2 != 33 && i2 != 32)) {
            throw new IllegalArgumentException();
        }
        this.modeX = i;
        this.modeY = i2;
    }

    @Override // javax.microedition.m3g.Object3D
    void updateProperty(int i, float[] fArr) {
        switch (i) {
            case 256:
                this.color = (this.color & 16777215) | (Util.getIntColor(fArr) & (-16777216));
                break;
            case 257:
            default:
                super.updateProperty(i, fArr);
                break;
            case 258:
                this.color = (this.color & (-16777216)) | (Util.getIntColor(fArr) & 16777215);
                break;
            case 259:
                this.cropX = Util.roundToInt(fArr[0]);
                this.cropY = Util.roundToInt(fArr[1]);
                if (fArr.length > 2) {
                    this.cropWidth = Math.max(Util.roundToInt(fArr[2]), 0);
                    this.cropHeight = Math.max(Util.roundToInt(fArr[3]), 0);
                }
                break;
        }
    }
}
