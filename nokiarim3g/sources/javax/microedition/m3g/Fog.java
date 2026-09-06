package javax.microedition.m3g;

import com.nokia.phone.p000ri.m3g.C0000GL;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class Fog extends Object3D {
    public static final int EXPONENTIAL = 80;
    public static final int LINEAR = 81;
    private int fogColor = 0;
    private float fogDensity = 1.0f;
    private float fogStart = 0.0f;
    private float fogEnd = 1.0f;
    private int fogMode = 81;

    static void applyDefaults() {
        C0000GL.Disable(C0000GL.FOG);
    }

    void apply() {
        float[] fArr = new float[4];
        switch (this.fogMode) {
            case EXPONENTIAL /* 80 */:
                C0000GL.Enable(C0000GL.FOG);
                C0000GL.Fogi(C0000GL.FOG_MODE, 2048);
                C0000GL.Fogf(C0000GL.FOG_DENSITY, this.fogDensity);
                Util.getFloatColor(this.fogColor, 1.0f, fArr);
                C0000GL.Fogfv(C0000GL.FOG_COLOR, fArr);
                break;
            case LINEAR /* 81 */:
                C0000GL.Enable(C0000GL.FOG);
                C0000GL.Fogi(C0000GL.FOG_MODE, C0000GL.LINEAR);
                C0000GL.Fogf(C0000GL.FOG_START, this.fogStart);
                C0000GL.Fogf(C0000GL.FOG_END, this.fogEnd);
                Util.getFloatColor(this.fogColor, 1.0f, fArr);
                C0000GL.Fogfv(C0000GL.FOG_COLOR, fArr);
                break;
        }
    }

    @Override // javax.microedition.m3g.Object3D
    Object3D createDuplicate() {
        Fog fog = new Fog();
        fog.copy(this);
        fog.fogColor = this.fogColor;
        fog.fogDensity = this.fogDensity;
        fog.fogStart = this.fogStart;
        fog.fogEnd = this.fogEnd;
        fog.fogMode = this.fogMode;
        return fog;
    }

    public int getColor() {
        return this.fogColor;
    }

    public float getDensity() {
        return this.fogDensity;
    }

    public float getFarDistance() {
        return this.fogEnd;
    }

    public int getMode() {
        return this.fogMode;
    }

    public float getNearDistance() {
        return this.fogStart;
    }

    @Override // javax.microedition.m3g.Object3D
    boolean isCompatible(AnimationTrack animationTrack) {
        switch (animationTrack.getTargetProperty()) {
            case 258:
            case 260:
            case AnimationTrack.FAR_DISTANCE /* 263 */:
            case AnimationTrack.NEAR_DISTANCE /* 267 */:
                return true;
            default:
                return super.isCompatible(animationTrack);
        }
    }

    public void setColor(int i) {
        this.fogColor = 16777215 & i;
    }

    public void setDensity(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException();
        }
        this.fogDensity = f;
    }

    public void setLinear(float f, float f2) {
        this.fogStart = f;
        this.fogEnd = f2;
    }

    public void setMode(int i) {
        if (i != 80 && i != 81) {
            throw new IllegalArgumentException();
        }
        this.fogMode = i;
    }

    @Override // javax.microedition.m3g.Object3D
    void updateProperty(int i, float[] fArr) {
        switch (i) {
            case 258:
                this.fogColor = Util.getIntColor(fArr);
                break;
            case 260:
                this.fogDensity = fArr[0] >= 0.0f ? fArr[0] : 0.0f;
                break;
            case AnimationTrack.FAR_DISTANCE /* 263 */:
                this.fogEnd = fArr[0];
                break;
            case AnimationTrack.NEAR_DISTANCE /* 267 */:
                this.fogStart = fArr[0];
                break;
            default:
                super.updateProperty(i, fArr);
                break;
        }
    }
}
