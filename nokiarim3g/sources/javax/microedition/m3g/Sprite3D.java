package javax.microedition.m3g;

import com.nokia.phone.p000ri.m3g.C0000GL;
import javax.microedition.media.control.ToneControl;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class Sprite3D extends Node {
    private static int maxCropDimension = Graphics3D.getMaxTextureDimension();
    private Appearance appearance;
    private Image2D image;
    private boolean scaled;
    private boolean depthTest = true;
    private int[] crop = new int[4];
    private boolean flipX = false;
    private boolean flipY = false;
    private Transform transformToCamera = new Transform();

    public Sprite3D(boolean z, Image2D image2D, Appearance appearance) {
        this.scaled = false;
        this.appearance = null;
        this.scaled = z;
        this.appearance = appearance;
        setImage(image2D);
    }

    @Override // javax.microedition.m3g.Object3D
    int applyAnimation(int i) {
        int iApplyAnimation = super.applyAnimation(i);
        return this.appearance != null ? Math.min(iApplyAnimation, this.appearance.animate(i)) : iApplyAnimation;
    }

    @Override // javax.microedition.m3g.Object3D
    Object3D createDuplicate() {
        Sprite3D sprite3D = new Sprite3D(this.scaled, this.image, this.appearance);
        sprite3D.copy((Node) this);
        sprite3D.depthTest = this.depthTest;
        System.arraycopy(this.crop, 0, sprite3D.crop, 0, this.crop.length);
        sprite3D.appearance = this.appearance;
        sprite3D.transformToCamera.set(this.transformToCamera);
        return sprite3D;
    }

    @Override // javax.microedition.m3g.Object3D
    int doGetReferences(Object3D[] object3DArr) {
        int iDoGetReferences = super.doGetReferences(object3DArr);
        if (this.image != null) {
            if (object3DArr != null) {
                object3DArr[iDoGetReferences] = this.image;
            }
            iDoGetReferences++;
        }
        if (this.appearance == null) {
            return iDoGetReferences;
        }
        if (object3DArr != null) {
            object3DArr[iDoGetReferences] = this.appearance;
        }
        return iDoGetReferences + 1;
    }

    @Override // javax.microedition.m3g.Node
    void doRender(Graphics3D graphics3D, int i) {
        float f;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        int viewportHeight = graphics3D.getViewportHeight();
        int viewportWidth = graphics3D.getViewportWidth();
        int viewportX = graphics3D.getViewportX();
        int viewportY = graphics3D.getViewportY();
        Camera currentCamera = graphics3D.getCurrentCamera();
        Vec4f vec4f = new Vec4f(0.0f, 0.0f, 0.0f, 1.0f);
        Vec4f vec4f2 = new Vec4f(1.0f, 0.0f, 0.0f, 1.0f);
        Vec4f vec4f3 = new Vec4f(0.0f, 1.0f, 0.0f, 1.0f);
        this.transformToCamera.mulLeft(graphics3D.getViewTransform());
        Transform transform = new Transform();
        transform.set(this.transformToCamera);
        transform.transform(vec4f);
        transform.transform(vec4f2);
        transform.transform(vec4f3);
        Vec4f vec4f4 = new Vec4f(vec4f);
        vec4f.mul(1.0f / vec4f.f76w);
        vec4f2.mul(1.0f / vec4f2.f76w);
        vec4f3.mul(1.0f / vec4f3.f76w);
        vec4f2.sub(vec4f);
        vec4f3.sub(vec4f);
        Vec4f vec4f5 = new Vec4f(vec4f2.length(), 0.0f, 0.0f, 0.0f);
        Vec4f vec4f6 = new Vec4f(0.0f, vec4f3.length(), 0.0f, 0.0f);
        vec4f5.add(vec4f4);
        vec4f6.add(vec4f4);
        currentCamera.getProjection(transform);
        transform.transform(vec4f4);
        transform.transform(vec4f5);
        transform.transform(vec4f6);
        if (vec4f4.f76w <= 0.0f || (-vec4f4.f76w) >= vec4f4.f79z || vec4f4.f79z > vec4f4.f76w) {
            return;
        }
        vec4f4.mul(1.0f / vec4f4.f76w);
        vec4f5.mul(1.0f / vec4f5.f76w);
        vec4f6.mul(1.0f / vec4f6.f76w);
        vec4f5.sub(vec4f4);
        vec4f6.sub(vec4f4);
        float f7 = this.flipX ? this.crop[2] / 2 : (-this.crop[2]) / 2;
        float f8 = this.flipY ? (-this.crop[3]) / 2 : this.crop[3] / 2;
        if (this.scaled) {
            float length = vec4f5.length() * viewportWidth * 0.5f;
            float length2 = vec4f6.length() * viewportHeight * 0.5f;
            float f9 = (-length) / 2.0f;
            float f10 = length2 / 2.0f;
            if (this.flipX) {
                f9 += length;
            }
            if (this.flipY) {
                f10 -= length2;
            }
            float f11 = length / (this.flipX ? -this.crop[2] : this.crop[2]);
            f = f10;
            f2 = f9;
            f3 = length2;
            f4 = length;
            f5 = length2 / (this.flipY ? -this.crop[3] : this.crop[3]);
            f6 = f11;
        } else {
            float f12 = this.flipX ? -1.0f : 1.0f;
            float f13 = this.flipY ? -1.0f : 1.0f;
            float f14 = this.crop[2];
            f = f8;
            f2 = f7;
            f3 = this.crop[3];
            f4 = f14;
            f5 = f13;
            f6 = f12;
        }
        int[] iArr = new int[4];
        if (Util.intersectRectangle(this.crop[0], this.crop[1], this.crop[2], this.crop[3], 0, 0, this.image.getWidth(), this.image.getHeight(), iArr)) {
            float f15 = this.flipX ? this.crop[0] > 0 ? f2 + ((this.crop[0] - iArr[0]) * f6) : f2 : f2 - ((this.crop[0] - iArr[0]) * f6);
            float f16 = this.flipY ? this.crop[1] > 0 ? f - ((this.crop[1] - iArr[1]) * f5) : f : f + ((this.crop[1] - iArr[1]) * f5);
            transform.preScale(viewportWidth / (viewportWidth + f4), viewportHeight / (viewportHeight + f3), 1.0f);
            int i2 = (int) (viewportHeight + f3);
            C0000GL.Viewport((int) (viewportX - (f4 / 2.0f)), graphics3D.screenToGL((int) (viewportY - (f3 / 2.0f)), i2), (int) (viewportWidth + f4), i2);
            C0000GL.MatrixMode(C0000GL.PROJECTION);
            C0000GL.LoadMatrixf(transform.getMatrix());
            C0000GL.MatrixMode(C0000GL.MODELVIEW);
            C0000GL.LoadMatrixf(this.transformToCamera.getMatrix());
            C0000GL.Disable(C0000GL.LIGHTING);
            C0000GL.RasterPos4f(0.0f, 0.0f, 0.0f, 1.0f);
            C0000GL.PixelStore(C0000GL.UNPACK_ROW_LENGTH, this.image.getWidth());
            C0000GL.PixelStore(C0000GL.UNPACK_SKIP_PIXELS, iArr[0]);
            C0000GL.PixelStore(C0000GL.UNPACK_SKIP_ROWS, iArr[1]);
            C0000GL.Bitmap(0, 0, 0.0f, 0.0f, f15, f16, null);
            C0000GL.PixelZoom(f6, -f5);
            int i3 = C0000GL.RGBA;
            switch (this.image.getFormat()) {
                case Image2D.ALPHA /* 96 */:
                    i3 = C0000GL.ALPHA;
                    break;
                case Image2D.LUMINANCE /* 97 */:
                    i3 = C0000GL.LUMINANCE;
                    break;
                case Image2D.LUMINANCE_ALPHA /* 98 */:
                    i3 = C0000GL.LUMINANCE_ALPHA;
                    break;
                case Image2D.RGB /* 99 */:
                    i3 = C0000GL.RGB;
                    break;
            }
            this.appearance.applySprite();
            if (i3 == 6406) {
                byte[] image = this.image.getImage();
                byte[] bArr = new byte[image.length * 2];
                for (int i4 = 0; i4 < image.length; i4++) {
                    bArr[i4 * 2] = -1;
                    bArr[(i4 * 2) + 1] = image[i4];
                }
                C0000GL.DrawPixels(iArr[2], iArr[3], C0000GL.LUMINANCE_ALPHA, C0000GL.UNSIGNED_BYTE, bArr);
            } else {
                C0000GL.DrawPixels(iArr[2], iArr[3], i3, C0000GL.UNSIGNED_BYTE, this.image.getImage());
            }
            C0000GL.PixelStore(C0000GL.UNPACK_ROW_LENGTH, 0);
            C0000GL.PixelStore(C0000GL.UNPACK_SKIP_PIXELS, 0);
            C0000GL.PixelStore(C0000GL.UNPACK_SKIP_ROWS, 0);
        }
    }

    public Appearance getAppearance() {
        return this.appearance;
    }

    public int getCropHeight() {
        return this.flipY ? -this.crop[3] : this.crop[3];
    }

    public int getCropWidth() {
        return this.flipX ? -this.crop[2] : this.crop[2];
    }

    public int getCropX() {
        return this.crop[0];
    }

    public int getCropY() {
        return this.crop[1];
    }

    public Image2D getImage() {
        return this.image;
    }

    @Override // javax.microedition.m3g.Node, javax.microedition.m3g.Transformable, javax.microedition.m3g.Object3D
    boolean isCompatible(AnimationTrack animationTrack) {
        switch (animationTrack.getTargetProperty()) {
            case 259:
                return true;
            default:
                return super.isCompatible(animationTrack);
        }
    }

    public boolean isScaled() {
        return this.scaled;
    }

    @Override // javax.microedition.m3g.Node
    boolean rayIntersect(int i, float[] fArr, RayIntersection rayIntersection, Transform transform) {
        Camera camera;
        if (this.appearance == null || this.image == null || !this.scaled || this.crop[2] == 0 || this.crop[3] == 0 || (camera = rayIntersection.getCamera()) == null || this.image == null) {
            return false;
        }
        int[] iArr = new int[4];
        if (!Util.intersectRectangle(this.crop[0], this.crop[1], this.crop[2], this.crop[3], 0, 0, this.image.getWidth(), this.image.getHeight(), iArr)) {
            return false;
        }
        Vec4f vec4f = new Vec4f(0.0f, 0.0f, 0.0f, 1.0f);
        Vec4f vec4f2 = new Vec4f(0.5f, 0.0f, 0.0f, 1.0f);
        Vec4f vec4f3 = new Vec4f(0.0f, 0.5f, 0.0f, 1.0f);
        Transform transform2 = new Transform();
        getTransformTo(camera, transform2);
        transform2.transform(vec4f);
        transform2.transform(vec4f2);
        transform2.transform(vec4f3);
        Vec4f vec4f4 = new Vec4f(vec4f);
        vec4f.mul(1.0f / vec4f.f76w);
        vec4f2.mul(1.0f / vec4f2.f76w);
        vec4f3.mul(1.0f / vec4f3.f76w);
        float f = (vec4f.f79z - fArr[6]) / (fArr[7] - fArr[6]);
        vec4f2.sub(vec4f);
        vec4f3.sub(vec4f);
        Vec4f vec4f5 = new Vec4f(vec4f2.length(), 0.0f, 0.0f, 0.0f);
        Vec4f vec4f6 = new Vec4f(0.0f, vec4f3.length(), 0.0f, 0.0f);
        vec4f5.add(vec4f4);
        vec4f6.add(vec4f4);
        camera.getProjection(transform2);
        transform2.transform(vec4f4);
        transform2.transform(vec4f5);
        transform2.transform(vec4f6);
        if (vec4f4.f76w <= 0.0f || (-vec4f4.f76w) >= vec4f4.f79z || vec4f4.f79z > vec4f4.f76w) {
            return false;
        }
        vec4f4.mul(1.0f / vec4f4.f76w);
        vec4f5.mul(1.0f / vec4f5.f76w);
        vec4f6.mul(1.0f / vec4f6.f76w);
        vec4f5.sub(vec4f4);
        vec4f6.sub(vec4f4);
        vec4f5.f77x = vec4f5.length() / this.crop[2];
        vec4f6.f78y = vec4f6.length() / this.crop[3];
        vec4f4.f77x -= ((((this.crop[0] * 2) + this.crop[2]) - (iArr[0] * 2)) - iArr[2]) * vec4f5.f77x;
        vec4f4.f78y += ((((this.crop[1] * 2) + this.crop[3]) - (iArr[1] * 2)) - iArr[3]) * vec4f6.f78y;
        vec4f5.f77x *= iArr[2];
        vec4f6.f78y *= iArr[3];
        float[] fArr2 = new float[12];
        int[] iArr2 = new int[8];
        fArr2[0] = vec4f4.f77x - vec4f5.f77x;
        fArr2[1] = vec4f4.f78y + vec4f6.f78y;
        fArr2[2] = vec4f4.f79z;
        fArr2[3] = fArr2[0];
        fArr2[4] = vec4f4.f78y - vec4f6.f78y;
        fArr2[5] = fArr2[2];
        fArr2[6] = vec4f5.f77x + vec4f4.f77x;
        fArr2[7] = fArr2[1];
        fArr2[8] = fArr2[2];
        fArr2[9] = fArr2[6];
        fArr2[10] = fArr2[4];
        fArr2[11] = fArr2[2];
        if (this.flipX) {
            iArr2[0] = iArr[0] + iArr[2];
            iArr2[2] = iArr[0] + iArr[2];
            iArr2[4] = iArr[0];
            iArr2[6] = iArr[0];
        } else {
            iArr2[0] = iArr[0];
            iArr2[2] = iArr[0];
            iArr2[4] = iArr[0] + iArr[2];
            iArr2[6] = iArr[0] + iArr[2];
        }
        if (this.flipY) {
            iArr2[1] = iArr[1] + iArr[3];
            iArr2[3] = iArr[1];
            iArr2[5] = iArr[1] + iArr[3];
            iArr2[7] = iArr[1];
        } else {
            iArr2[1] = iArr[1];
            iArr2[3] = iArr[1] + iArr[3];
            iArr2[5] = iArr[1];
            iArr2[7] = iArr[1] + iArr[3];
        }
        float pickX = (2.0f * rayIntersection.getPickX()) - 1.0f;
        float pickY = 1.0f - (2.0f * rayIntersection.getPickY());
        if (pickX < fArr2[0] || pickX > fArr2[6] || pickY > fArr2[1] || pickY < fArr2[4] || !rayIntersection.test(f)) {
            return false;
        }
        float f2 = pickX - fArr2[0];
        float f3 = fArr2[1] - pickY;
        float[] fArr3 = {0.0f};
        float[] fArr4 = {0.0f};
        if (this.flipX) {
            fArr3[0] = iArr2[0] - ((f2 * (iArr2[0] - iArr2[4])) / (fArr2[6] - fArr2[0]));
        } else {
            fArr3[0] = ((f2 * (iArr2[4] - iArr2[0])) / (fArr2[6] - fArr2[0])) + iArr2[0];
        }
        if (this.flipY) {
            fArr4[0] = iArr2[1] - ((f3 * (iArr2[1] - iArr2[3])) / (fArr2[1] - fArr2[4]));
        } else {
            fArr4[0] = ((f3 * (iArr2[3] - iArr2[1])) / (fArr2[1] - fArr2[4])) + iArr2[1];
        }
        int iClamp = Util.clamp(Util.roundToInt(fArr3[0]), 0, this.image.getWidth() - 1);
        int iClamp2 = Util.clamp(Util.roundToInt(fArr4[0]), 0, this.image.getWidth() - 1);
        fArr3[0] = Util.clamp(fArr3[0], 0.0f, this.image.getWidth());
        fArr4[0] = Util.clamp(fArr4[0], 0.0f, this.image.getHeight());
        byte b = ToneControl.SILENCE;
        int alphaThreshold = this.appearance.getCompositingMode() != null ? (int) (this.appearance.getCompositingMode().getAlphaThreshold() * 256.0f) : 0;
        switch (this.image.getFormat()) {
            case Image2D.ALPHA /* 96 */:
                b = this.image.getImage()[(iClamp * 1) + (iClamp2 * this.image.getWidth() * 1) + 0];
                break;
            case Image2D.LUMINANCE_ALPHA /* 98 */:
                b = this.image.getImage()[(iClamp * 2) + (iClamp2 * this.image.getWidth() * 2) + 1];
                break;
            case 100:
                b = this.image.getImage()[(iClamp * 4) + (iClamp2 * this.image.getWidth() * 4) + 3];
                break;
        }
        fArr3[0] = fArr3[0] / this.image.getWidth();
        fArr4[0] = fArr4[0] / this.image.getHeight();
        if ((b & ToneControl.SILENCE) >= alphaThreshold) {
            return rayIntersection.fill(f, fArr3, fArr4, 0, this, f, null);
        }
        return false;
    }

    public void setAppearance(Appearance appearance) {
        this.appearance = appearance;
    }

    public void setCrop(int i, int i2, int i3, int i4) {
        if (Math.abs(i3) > maxCropDimension || Math.abs(i4) > maxCropDimension) {
            throw new IllegalArgumentException();
        }
        this.crop[0] = i;
        this.crop[1] = i2;
        this.crop[2] = i3 >= 0 ? i3 : -i3;
        this.crop[3] = i4 >= 0 ? i4 : -i4;
        this.flipX = i3 < 0;
        this.flipY = i4 < 0;
    }

    public void setImage(Image2D image2D) {
        if (image2D == null) {
            throw new NullPointerException();
        }
        this.image = image2D;
        this.crop[0] = 0;
        this.crop[1] = 0;
        this.crop[2] = image2D.getWidth() <= maxCropDimension ? image2D.getWidth() : maxCropDimension;
        this.crop[3] = image2D.getHeight() <= maxCropDimension ? image2D.getHeight() : maxCropDimension;
    }

    @Override // javax.microedition.m3g.Node
    void setupRender(Transform transform, Node node, RenderQueue renderQueue) {
        if (this.image == null || this.appearance == null || !isVisible(renderQueue.getRoot()) || this.crop[2] == 0 || this.crop[3] == 0) {
            return;
        }
        this.transformToCamera.set(transform);
        renderQueue.insert(this, 0, this.appearance.getSortKey());
    }

    @Override // javax.microedition.m3g.Node, javax.microedition.m3g.Transformable, javax.microedition.m3g.Object3D
    void updateProperty(int i, float[] fArr) {
        switch (i) {
            case 259:
                this.crop[0] = Util.roundToInt(fArr[0]);
                this.crop[1] = Util.roundToInt(fArr[1]);
                if (fArr.length > 2) {
                    this.crop[2] = Util.clamp(Util.roundToInt(fArr[2]), -maxCropDimension, maxCropDimension);
                    this.crop[3] = Util.clamp(Util.roundToInt(fArr[3]), -maxCropDimension, maxCropDimension);
                }
                break;
            default:
                super.updateProperty(i, fArr);
                break;
        }
    }
}
