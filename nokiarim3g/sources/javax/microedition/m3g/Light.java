package javax.microedition.m3g;

import com.nokia.phone.p000ri.m3g.C0000GL;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class Light extends Node {
    public static final int AMBIENT = 128;
    public static final int DIRECTIONAL = 129;
    public static final int OMNI = 130;
    public static final int SPOT = 131;
    private static float[] LOCAL_ORIGIN = {0.0f, 0.0f, 0.0f, 1.0f};
    private static float[] POSITIVE_Z_AXIS = {0.0f, 0.0f, 1.0f, 0.0f};
    private static float[] NEGATIVE_Z_AXIS = {0.0f, 0.0f, -1.0f, 0.0f};
    private static float[] ZERO = {0.0f, 0.0f, 0.0f, 0.0f};
    private float constantAttenuation = 1.0f;
    private float linearAttenuation = 0.0f;
    private float quadraticAttenuation = 0.0f;
    private float intensity = 1.0f;
    private int color = 16777215;
    private int mode = DIRECTIONAL;
    private float spotAngle = 45.0f;
    private float spotExponent = 0.0f;

    void apply(int i) {
        float[] fArr = new float[4];
        C0000GL.Enable(i);
        Util.getFloatColor(this.color, this.intensity, fArr);
        if (this.mode == 128) {
            C0000GL.Lightfv(i, C0000GL.AMBIENT, fArr);
            C0000GL.Lightfv(i, C0000GL.DIFFUSE, ZERO);
            C0000GL.Lightfv(i, C0000GL.SPECULAR, ZERO);
        } else {
            C0000GL.Lightfv(i, C0000GL.AMBIENT, ZERO);
            C0000GL.Lightfv(i, C0000GL.DIFFUSE, fArr);
            C0000GL.Lightfv(i, C0000GL.SPECULAR, fArr);
        }
        C0000GL.Lightfv(i, C0000GL.POSITION, this.mode == 129 ? POSITIVE_Z_AXIS : LOCAL_ORIGIN);
        C0000GL.Lightfv(i, C0000GL.SPOT_DIRECTION, NEGATIVE_Z_AXIS);
        if (this.mode == 131) {
            C0000GL.Lightf(i, C0000GL.SPOT_EXPONENT, this.spotExponent);
            C0000GL.Lightf(i, C0000GL.SPOT_CUTOFF, this.spotAngle);
        } else {
            C0000GL.Lightf(i, C0000GL.SPOT_CUTOFF, 180.0f);
        }
        if (this.mode == 130 || this.mode == 131) {
            C0000GL.Lightf(i, C0000GL.CONSTANT_ATTENUATION, this.constantAttenuation);
            C0000GL.Lightf(i, C0000GL.LINEAR_ATTENUATION, this.linearAttenuation);
            C0000GL.Lightf(i, C0000GL.QUADRATIC_ATTENUATION, this.quadraticAttenuation);
        } else if (this.mode == 128) {
            C0000GL.Lightf(i, C0000GL.CONSTANT_ATTENUATION, 1.0f);
            C0000GL.Lightf(i, C0000GL.LINEAR_ATTENUATION, 0.0f);
            C0000GL.Lightf(i, C0000GL.QUADRATIC_ATTENUATION, 0.0f);
        }
    }

    @Override // javax.microedition.m3g.Object3D
    Object3D createDuplicate() {
        Light light = new Light();
        light.copy((Node) this);
        light.constantAttenuation = this.constantAttenuation;
        light.linearAttenuation = this.linearAttenuation;
        light.quadraticAttenuation = this.quadraticAttenuation;
        light.intensity = this.intensity;
        light.color = this.color;
        light.mode = this.mode;
        light.spotAngle = this.spotAngle;
        light.spotExponent = this.spotExponent;
        return light;
    }

    public int getColor() {
        return this.color;
    }

    public float getConstantAttenuation() {
        return this.constantAttenuation;
    }

    public float getIntensity() {
        return this.intensity;
    }

    public float getLinearAttenuation() {
        return this.linearAttenuation;
    }

    public int getMode() {
        return this.mode;
    }

    public float getQuadraticAttenuation() {
        return this.quadraticAttenuation;
    }

    public float getSpotAngle() {
        return this.spotAngle;
    }

    public float getSpotExponent() {
        return this.spotExponent;
    }

    @Override // javax.microedition.m3g.Node, javax.microedition.m3g.Transformable, javax.microedition.m3g.Object3D
    boolean isCompatible(AnimationTrack animationTrack) {
        switch (animationTrack.getTargetProperty()) {
            case 258:
            case AnimationTrack.INTENSITY /* 265 */:
            case AnimationTrack.SPOT_ANGLE /* 273 */:
            case AnimationTrack.SPOT_EXPONENT /* 274 */:
                return true;
            default:
                return super.isCompatible(animationTrack);
        }
    }

    @Override // javax.microedition.m3g.Node
    boolean rayIntersect(int i, float[] fArr, RayIntersection rayIntersection, Transform transform) {
        return false;
    }

    public void setAttenuation(float f, float f2, float f3) {
        if (f < 0.0f || f2 < 0.0f || f3 < 0.0f || (f == 0.0f && f2 == 0.0f && f3 == 0.0f)) {
            throw new IllegalArgumentException();
        }
        this.constantAttenuation = f;
        this.linearAttenuation = f2;
        this.quadraticAttenuation = f3;
    }

    public void setColor(int i) {
        this.color = 16777215 & i;
    }

    public void setIntensity(float f) {
        this.intensity = f;
    }

    public void setMode(int i) {
        if (i < 128 || i > 131) {
            throw new IllegalArgumentException();
        }
        this.mode = i;
    }

    public void setSpotAngle(float f) {
        if (f < 0.0f || f > 90.0f) {
            throw new IllegalArgumentException();
        }
        this.spotAngle = f;
    }

    public void setSpotExponent(float f) {
        if (f < 0.0f || f > 128.0f) {
            throw new IllegalArgumentException();
        }
        this.spotExponent = f;
    }

    @Override // javax.microedition.m3g.Node
    void setupRender(Transform transform, Node node, RenderQueue renderQueue) {
        if (isVisible(renderQueue.getRoot())) {
            renderQueue.insertLight(this, transform);
        }
    }

    @Override // javax.microedition.m3g.Node, javax.microedition.m3g.Transformable, javax.microedition.m3g.Object3D
    void updateProperty(int i, float[] fArr) {
        switch (i) {
            case 258:
                this.color = Util.getIntColor(fArr);
                break;
            case AnimationTrack.INTENSITY /* 265 */:
                this.intensity = fArr[0];
                break;
            case AnimationTrack.SPOT_ANGLE /* 273 */:
                this.spotAngle = Util.clamp(fArr[0], 0.0f, 90.0f);
                break;
            case AnimationTrack.SPOT_EXPONENT /* 274 */:
                this.spotExponent = Util.clamp(fArr[0], 0.0f, 128.0f);
                break;
            default:
                super.updateProperty(i, fArr);
                break;
        }
    }
}
