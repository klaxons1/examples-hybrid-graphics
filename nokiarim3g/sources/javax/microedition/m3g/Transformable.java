package javax.microedition.m3g;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public abstract class Transformable extends Object3D {
    private Transform transform = null;
    private Quat4f orientation = new Quat4f(0.0f, 0.0f, 0.0f, 1.0f);

    /* JADX INFO: renamed from: sx */
    private float f70sx = 1.0f;

    /* JADX INFO: renamed from: sy */
    private float f71sy = 1.0f;

    /* JADX INFO: renamed from: sz */
    private float f72sz = 1.0f;

    /* JADX INFO: renamed from: tx */
    private float f73tx = 0.0f;

    /* JADX INFO: renamed from: ty */
    private float f74ty = 0.0f;

    /* JADX INFO: renamed from: tz */
    private float f75tz = 0.0f;

    Transformable() {
    }

    void copy(Transformable transformable) {
        super.copy((Object3D) transformable);
        this.orientation.set(transformable.orientation);
        setTranslation(transformable.f73tx, transformable.f74ty, transformable.f75tz);
        setScale(transformable.f70sx, transformable.f71sy, transformable.f72sz);
        setTransform(transformable.transform);
    }

    public void getCompositeTransform(Transform transform) {
        if (transform == null) {
            throw new NullPointerException();
        }
        transform.setIdentity();
        transform.translate(this.f73tx, this.f74ty, this.f75tz);
        transform.rotateQuat(this.orientation.f65x, this.orientation.f66y, this.orientation.f67z, this.orientation.f64w);
        transform.scale(this.f70sx, this.f71sy, this.f72sz);
        if (this.transform != null) {
            transform.mulRight(this.transform);
        }
    }

    void getOrientation(Quat4f quat4f) {
        quat4f.set(this.orientation);
    }

    public void getOrientation(float[] fArr) {
        if (fArr.length < 4) {
            throw new IllegalArgumentException();
        }
        this.orientation.getAngleAxis(fArr);
    }

    public void getScale(float[] fArr) {
        if (fArr.length < 3) {
            throw new IllegalArgumentException();
        }
        fArr[0] = this.f70sx;
        fArr[1] = this.f71sy;
        fArr[2] = this.f72sz;
    }

    public void getTransform(Transform transform) {
        if (transform == null) {
            throw new NullPointerException();
        }
        if (this.transform == null) {
            transform.setIdentity();
        } else {
            transform.set(this.transform);
        }
    }

    void getTranslation(Vec4f vec4f) {
        vec4f.f77x = this.f73tx;
        vec4f.f78y = this.f74ty;
        vec4f.f79z = this.f75tz;
        vec4f.f76w = 1.0f;
    }

    public void getTranslation(float[] fArr) {
        if (fArr.length < 3) {
            throw new IllegalArgumentException();
        }
        fArr[0] = this.f73tx;
        fArr[1] = this.f74ty;
        fArr[2] = this.f75tz;
    }

    @Override // javax.microedition.m3g.Object3D
    boolean isCompatible(AnimationTrack animationTrack) {
        switch (animationTrack.getTargetProperty()) {
            case AnimationTrack.ORIENTATION /* 268 */:
            case AnimationTrack.SCALE /* 270 */:
            case AnimationTrack.TRANSLATION /* 275 */:
                return true;
            default:
                return super.isCompatible(animationTrack);
        }
    }

    public void postRotate(float f, float f2, float f3, float f4) {
        if (f2 == 0.0f && f3 == 0.0f && f4 == 0.0f && f != 0.0f) {
            throw new IllegalArgumentException();
        }
        Quat4f quat4f = new Quat4f();
        quat4f.setAngleAxis(f, f2, f3, f4);
        this.orientation.mul(quat4f);
    }

    public void preRotate(float f, float f2, float f3, float f4) {
        if (f2 == 0.0f && f3 == 0.0f && f4 == 0.0f && f != 0.0f) {
            throw new IllegalArgumentException();
        }
        Quat4f quat4f = new Quat4f();
        quat4f.setAngleAxis(f, f2, f3, f4);
        quat4f.mul(this.orientation);
        this.orientation.set(quat4f);
    }

    public void scale(float f, float f2, float f3) {
        this.f70sx *= f;
        this.f71sy *= f2;
        this.f72sz *= f3;
    }

    public void setOrientation(float f, float f2, float f3, float f4) {
        if (f2 == 0.0f && f3 == 0.0f && f4 == 0.0f && f != 0.0f) {
            throw new IllegalArgumentException();
        }
        this.orientation.setAngleAxis(f, f2, f3, f4);
    }

    void setOrientation(Quat4f quat4f) {
        this.orientation.set(quat4f);
    }

    public void setScale(float f, float f2, float f3) {
        this.f70sx = f;
        this.f71sy = f2;
        this.f72sz = f3;
    }

    public void setTransform(Transform transform) {
        if (transform == null) {
            this.transform = null;
        } else {
            if ((this instanceof Node) && !transform.isWUnity()) {
                throw new IllegalArgumentException();
            }
            if (this.transform == null) {
                this.transform = new Transform();
            }
            this.transform.set(transform);
        }
    }

    public void setTranslation(float f, float f2, float f3) {
        this.f73tx = f;
        this.f74ty = f2;
        this.f75tz = f3;
    }

    void setTranslation(Vec4f vec4f) {
        this.f73tx = vec4f.f77x;
        this.f74ty = vec4f.f78y;
        this.f75tz = vec4f.f79z;
    }

    public void translate(float f, float f2, float f3) {
        this.f73tx += f;
        this.f74ty += f2;
        this.f75tz += f3;
    }

    @Override // javax.microedition.m3g.Object3D
    void updateProperty(int i, float[] fArr) {
        switch (i) {
            case AnimationTrack.ORIENTATION /* 268 */:
                this.orientation.set(fArr);
                this.orientation.normalize();
                break;
            case AnimationTrack.SCALE /* 270 */:
                if (fArr.length != 1) {
                    this.f70sx = fArr[0];
                    this.f71sy = fArr[1];
                    this.f72sz = fArr[2];
                } else {
                    float f = fArr[0];
                    this.f72sz = f;
                    this.f71sy = f;
                    this.f70sx = f;
                }
                break;
            case AnimationTrack.TRANSLATION /* 275 */:
                this.f73tx = fArr[0];
                this.f74ty = fArr[1];
                this.f75tz = fArr[2];
                break;
            default:
                super.updateProperty(i, fArr);
                break;
        }
    }
}
