package javax.microedition.m3g;

import com.nokia.phone.p000ri.m3g.C0000GL;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class PolygonMode extends Object3D {
    public static final int CULL_BACK = 160;
    public static final int CULL_FRONT = 161;
    public static final int CULL_NONE = 162;
    public static final int SHADE_FLAT = 164;
    public static final int SHADE_SMOOTH = 165;
    public static final int WINDING_CCW = 168;
    public static final int WINDING_CW = 169;
    private boolean enableLocalCameraLighting = false;
    private boolean enablePerspectiveCorrection = false;
    private int cullingMode = CULL_BACK;
    private int windingMode = WINDING_CCW;
    private int shadingMode = SHADE_SMOOTH;
    private boolean enableTwoSidedLighting = false;

    static void applyDefaults() {
        C0000GL.PolygonMode(C0000GL.FRONT_AND_BACK, C0000GL.FILL);
        C0000GL.CullFace(C0000GL.BACK);
        C0000GL.Enable(C0000GL.CULL_FACE);
        C0000GL.ShadeModel(C0000GL.SMOOTH);
        C0000GL.FrontFace(C0000GL.CCW);
        C0000GL.Hint(C0000GL.PERSPECTIVE_CORRECTION_HINT, C0000GL.FASTEST);
        C0000GL.LightModeli(C0000GL.LIGHT_MODEL_TWO_SIDE, 0);
        C0000GL.LightModeli(C0000GL.LIGHT_MODEL_LOCAL_VIEWER, 0);
    }

    void apply() {
        C0000GL.PolygonMode(C0000GL.FRONT_AND_BACK, C0000GL.FILL);
        if (this.cullingMode == 162) {
            C0000GL.Disable(C0000GL.CULL_FACE);
        } else {
            if (this.cullingMode == 160) {
                C0000GL.CullFace(C0000GL.BACK);
            } else {
                C0000GL.CullFace(C0000GL.FRONT);
            }
            C0000GL.Enable(C0000GL.CULL_FACE);
        }
        C0000GL.LightModeli(C0000GL.LIGHT_MODEL_TWO_SIDE, this.enableTwoSidedLighting ? 1 : 0);
        if (this.shadingMode == 164) {
            C0000GL.ShadeModel(C0000GL.FLAT);
        } else {
            C0000GL.ShadeModel(C0000GL.SMOOTH);
        }
        if (this.windingMode == 169) {
            C0000GL.FrontFace(C0000GL.f0CW);
        } else {
            C0000GL.FrontFace(C0000GL.CCW);
        }
        C0000GL.Hint(C0000GL.PERSPECTIVE_CORRECTION_HINT, this.enablePerspectiveCorrection ? C0000GL.NICEST : C0000GL.FASTEST);
        C0000GL.LightModeli(C0000GL.LIGHT_MODEL_LOCAL_VIEWER, this.enableLocalCameraLighting ? 1 : 0);
    }

    @Override // javax.microedition.m3g.Object3D
    Object3D createDuplicate() {
        PolygonMode polygonMode = new PolygonMode();
        polygonMode.copy(this);
        polygonMode.enableLocalCameraLighting = this.enableLocalCameraLighting;
        polygonMode.enablePerspectiveCorrection = this.enablePerspectiveCorrection;
        polygonMode.cullingMode = this.cullingMode;
        polygonMode.windingMode = this.windingMode;
        polygonMode.shadingMode = this.shadingMode;
        polygonMode.enableTwoSidedLighting = this.enableTwoSidedLighting;
        return polygonMode;
    }

    public int getCulling() {
        return this.cullingMode;
    }

    public int getShading() {
        return this.shadingMode;
    }

    public int getWinding() {
        return this.windingMode;
    }

    public boolean isTwoSidedLightingEnabled() {
        return this.enableTwoSidedLighting;
    }

    public void setCulling(int i) {
        if (i != 160 && i != 161 && i != 162) {
            throw new IllegalArgumentException();
        }
        this.cullingMode = i;
    }

    public void setLocalCameraLightingEnable(boolean z) {
        this.enableLocalCameraLighting = z;
    }

    public void setPerspectiveCorrectionEnable(boolean z) {
        this.enablePerspectiveCorrection = z;
    }

    public void setShading(int i) {
        if (i != 164 && i != 165) {
            throw new IllegalArgumentException();
        }
        this.shadingMode = i;
    }

    public void setTwoSidedLightingEnable(boolean z) {
        this.enableTwoSidedLighting = z;
    }

    public void setWinding(int i) {
        if (i != 169 && i != 168) {
            throw new IllegalArgumentException();
        }
        this.windingMode = i;
    }
}
