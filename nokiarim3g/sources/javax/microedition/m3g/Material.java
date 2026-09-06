package javax.microedition.m3g;

import com.nokia.phone.p000ri.m3g.C0000GL;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class Material extends Object3D {
    private static final int ALL_TARGET_MASK = 15360;
    public static final int AMBIENT = 1024;
    public static final int DIFFUSE = 2048;
    public static final int EMISSIVE = 4096;
    public static final int SPECULAR = 8192;
    private float[] tempColor = new float[4];
    private boolean vertexColorTracking = false;
    private int ambientColor = 3355443;
    private int diffuseColor = -3355444;
    private int emissiveColor = 0;
    private int specularColor = 0;
    private float shininess = 0.0f;

    static void applyDefaults() {
        C0000GL.Disable(C0000GL.COLOR_MATERIAL);
        C0000GL.Disable(C0000GL.LIGHTING);
    }

    void apply(float f) {
        Util.getFloatColor(this.ambientColor, 1.0f, this.tempColor);
        C0000GL.Materialfv(C0000GL.FRONT_AND_BACK, C0000GL.AMBIENT, this.tempColor);
        Util.getFloatColor(this.diffuseColor, 1.0f, this.tempColor);
        float[] fArr = this.tempColor;
        fArr[3] = fArr[3] * f;
        C0000GL.Materialfv(C0000GL.FRONT_AND_BACK, C0000GL.DIFFUSE, this.tempColor);
        Util.getFloatColor(this.emissiveColor, 1.0f, this.tempColor);
        C0000GL.Materialfv(C0000GL.FRONT_AND_BACK, C0000GL.EMISSION, this.tempColor);
        Util.getFloatColor(this.specularColor, 1.0f, this.tempColor);
        C0000GL.Materialfv(C0000GL.FRONT_AND_BACK, C0000GL.SPECULAR, this.tempColor);
        C0000GL.Materialf(C0000GL.FRONT_AND_BACK, C0000GL.SHININESS, this.shininess);
        if (this.vertexColorTracking) {
            C0000GL.ColorMaterial(C0000GL.FRONT_AND_BACK, C0000GL.AMBIENT_AND_DIFFUSE);
            C0000GL.Enable(C0000GL.COLOR_MATERIAL);
        } else {
            C0000GL.Disable(C0000GL.COLOR_MATERIAL);
        }
        C0000GL.Enable(C0000GL.LIGHTING);
    }

    @Override // javax.microedition.m3g.Object3D
    Object3D createDuplicate() {
        Material material = new Material();
        material.copy(this);
        material.vertexColorTracking = this.vertexColorTracking;
        material.ambientColor = this.ambientColor;
        material.diffuseColor = this.diffuseColor;
        material.emissiveColor = this.emissiveColor;
        material.specularColor = this.specularColor;
        material.shininess = this.shininess;
        return material;
    }

    public int getColor(int i) {
        switch (i) {
            case 1024:
                return this.ambientColor & 16777215;
            case 2048:
                return this.diffuseColor;
            case 4096:
                return this.emissiveColor & 16777215;
            case 8192:
                return this.specularColor & 16777215;
            default:
                throw new IllegalArgumentException();
        }
    }

    public float getShininess() {
        return this.shininess;
    }

    @Override // javax.microedition.m3g.Object3D
    boolean isCompatible(AnimationTrack animationTrack) {
        switch (animationTrack.getTargetProperty()) {
            case 256:
            case 257:
            case AnimationTrack.DIFFUSE_COLOR /* 261 */:
            case AnimationTrack.EMISSIVE_COLOR /* 262 */:
            case AnimationTrack.SHININESS /* 271 */:
            case AnimationTrack.SPECULAR_COLOR /* 272 */:
                return true;
            default:
                return super.isCompatible(animationTrack);
        }
    }

    public boolean isVertexColorTrackingEnabled() {
        return this.vertexColorTracking;
    }

    public void setColor(int i, int i2) {
        if ((i | ALL_TARGET_MASK) != ALL_TARGET_MASK || (i & ALL_TARGET_MASK) == 0) {
            throw new IllegalArgumentException();
        }
        if ((i & 1024) != 0) {
            this.ambientColor = i2 & 16777215;
        }
        if ((i & 2048) != 0) {
            this.diffuseColor = i2;
        }
        if ((i & 4096) != 0) {
            this.emissiveColor = i2 & 16777215;
        }
        if ((i & 8192) != 0) {
            this.specularColor = i2 & 16777215;
        }
    }

    public void setShininess(float f) {
        if (f < 0.0f || f > 128.0f) {
            throw new IllegalArgumentException();
        }
        this.shininess = f;
    }

    public void setVertexColorTrackingEnable(boolean z) {
        this.vertexColorTracking = z;
    }

    @Override // javax.microedition.m3g.Object3D
    void updateProperty(int i, float[] fArr) {
        switch (i) {
            case 256:
                this.diffuseColor = (this.diffuseColor & 16777215) | (Util.getIntColor(fArr) & (-16777216));
                break;
            case 257:
                this.ambientColor = Util.getIntColor(fArr);
                break;
            case AnimationTrack.DIFFUSE_COLOR /* 261 */:
                this.diffuseColor = (this.diffuseColor & (-16777216)) | (Util.getIntColor(fArr) & 16777215);
                break;
            case AnimationTrack.EMISSIVE_COLOR /* 262 */:
                this.emissiveColor = Util.getIntColor(fArr);
                break;
            case AnimationTrack.SHININESS /* 271 */:
                this.shininess = Util.clamp(fArr[0], 0.0f, 128.0f);
                break;
            case AnimationTrack.SPECULAR_COLOR /* 272 */:
                this.specularColor = Util.getIntColor(fArr);
                break;
            default:
                super.updateProperty(i, fArr);
                break;
        }
    }
}
