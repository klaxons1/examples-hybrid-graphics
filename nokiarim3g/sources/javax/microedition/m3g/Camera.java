package javax.microedition.m3g;

import com.nokia.phone.p000ri.m3g.C0000GL;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class Camera extends Node {
    public static final int GENERIC = 48;
    public static final int PARALLEL = 49;
    public static final int PERSPECTIVE = 50;
    private int projType = 49;
    private float[] projMatrix = new float[16];
    private float heightFov = 2.0f;
    private float aspect = 1.0f;
    private float clipNear = -1.0f;
    private float clipFar = 1.0f;

    public Camera() {
        setParallel(2.0f, 1.0f, 1.0f, -1.0f);
    }

    void applyProjection() {
        C0000GL.MatrixMode(C0000GL.PROJECTION);
        C0000GL.LoadMatrixf(this.projMatrix);
        C0000GL.MatrixMode(C0000GL.MODELVIEW);
    }

    @Override // javax.microedition.m3g.Object3D
    Object3D createDuplicate() {
        Camera camera = new Camera();
        camera.copy((Node) this);
        System.arraycopy(this.projMatrix, 0, camera.projMatrix, 0, this.projMatrix.length);
        camera.projType = this.projType;
        camera.heightFov = this.heightFov;
        camera.aspect = this.aspect;
        camera.clipNear = this.clipNear;
        camera.clipFar = this.clipFar;
        return camera;
    }

    public int getProjection(Transform transform) {
        if (transform != null) {
            if (this.clipNear == this.clipFar) {
                throw new ArithmeticException();
            }
            System.arraycopy(this.projMatrix, 0, transform.getMatrix(), 0, 16);
        }
        return this.projType;
    }

    public int getProjection(float[] fArr) {
        if (fArr != null && fArr.length < 4) {
            throw new IllegalArgumentException();
        }
        if (fArr != null && this.projType != 48) {
            fArr[0] = this.heightFov;
            fArr[1] = this.aspect;
            fArr[2] = this.clipNear;
            fArr[3] = this.clipFar;
        }
        return this.projType;
    }

    @Override // javax.microedition.m3g.Node, javax.microedition.m3g.Transformable, javax.microedition.m3g.Object3D
    boolean isCompatible(AnimationTrack animationTrack) {
        switch (animationTrack.getTargetProperty()) {
            case AnimationTrack.FAR_DISTANCE /* 263 */:
            case AnimationTrack.FIELD_OF_VIEW /* 264 */:
            case AnimationTrack.NEAR_DISTANCE /* 267 */:
                return true;
            case AnimationTrack.INTENSITY /* 265 */:
            case AnimationTrack.MORPH_WEIGHTS /* 266 */:
            default:
                return super.isCompatible(animationTrack);
        }
    }

    boolean isValid() {
        return this.clipNear != this.clipFar;
    }

    @Override // javax.microedition.m3g.Node
    boolean rayIntersect(int i, float[] fArr, RayIntersection rayIntersection, Transform transform) {
        return false;
    }

    public void setGeneric(Transform transform) {
        if (transform == null) {
            throw new NullPointerException();
        }
        this.projType = 48;
        System.arraycopy(transform.getMatrix(), 0, this.projMatrix, 0, 16);
    }

    public void setParallel(float f, float f2, float f3, float f4) {
        if (f <= 0.0f || f2 <= 0.0f) {
            throw new IllegalArgumentException();
        }
        this.projType = 49;
        this.heightFov = f;
        this.aspect = f2;
        this.clipNear = f3;
        this.clipFar = f4;
        float[] fArr = this.projMatrix;
        fArr[0] = 2.0f / (f2 * f);
        fArr[3] = 0.0f;
        fArr[2] = 0.0f;
        fArr[1] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 2.0f / f;
        fArr[7] = 0.0f;
        fArr[6] = 0.0f;
        fArr[9] = 0.0f;
        fArr[8] = 0.0f;
        fArr[10] = (-2.0f) / (f4 - f3);
        fArr[11] = 0.0f;
        fArr[13] = 0.0f;
        fArr[12] = 0.0f;
        fArr[14] = (-(f4 + f3)) / (f4 - f3);
        fArr[15] = 1.0f;
    }

    public void setPerspective(float f, float f2, float f3, float f4) {
        if (f <= 0.0f || f >= 180.0f || f2 <= 0.0f || f3 <= 0.0f || f4 <= 0.0f) {
            throw new IllegalArgumentException();
        }
        this.projType = 50;
        this.heightFov = f;
        this.aspect = f2;
        this.clipNear = f3;
        this.clipFar = f4;
        float fTan = (float) Math.tan(0.008726646f * f);
        float[] fArr = this.projMatrix;
        fArr[0] = 1.0f / (f2 * fTan);
        fArr[3] = 0.0f;
        fArr[2] = 0.0f;
        fArr[1] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 1.0f / fTan;
        fArr[7] = 0.0f;
        fArr[6] = 0.0f;
        fArr[9] = 0.0f;
        fArr[8] = 0.0f;
        fArr[10] = (-(f4 + f3)) / (f4 - f3);
        fArr[11] = -1.0f;
        fArr[13] = 0.0f;
        fArr[12] = 0.0f;
        fArr[14] = (((-2.0f) * f4) * f3) / (f4 - f3);
        fArr[15] = 0.0f;
    }

    @Override // javax.microedition.m3g.Node
    void setupRender(Transform transform, Node node, RenderQueue renderQueue) {
        Transform transform2 = new Transform();
        Transform transform3 = new Transform();
        Node parent = getParent();
        if (parent == node || parent == null) {
            return;
        }
        transform2.set(transform);
        getCompositeTransform(transform3);
        transform3.invert();
        transform2.mulRight(transform3);
        parent.setupRender(transform2, this, renderQueue);
    }

    @Override // javax.microedition.m3g.Node, javax.microedition.m3g.Transformable, javax.microedition.m3g.Object3D
    void updateProperty(int i, float[] fArr) {
        if (this.projType == 48) {
            super.updateProperty(i, fArr);
        }
        switch (i) {
            case AnimationTrack.FAR_DISTANCE /* 263 */:
                this.clipFar = this.projType == 50 ? Util.clampPositive(fArr[0]) : fArr[0];
                break;
            case AnimationTrack.FIELD_OF_VIEW /* 264 */:
                this.heightFov = this.projType == 50 ? Util.clamp(fArr[0], 0.0f, 180.0f) : Util.clampPositive(fArr[0]);
                break;
            case AnimationTrack.INTENSITY /* 265 */:
            case AnimationTrack.MORPH_WEIGHTS /* 266 */:
            default:
                super.updateProperty(i, fArr);
                break;
            case AnimationTrack.NEAR_DISTANCE /* 267 */:
                this.clipNear = this.projType == 50 ? Util.clampPositive(fArr[0]) : fArr[0];
                break;
        }
    }
}
