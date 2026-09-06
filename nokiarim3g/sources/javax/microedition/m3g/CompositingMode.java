package javax.microedition.m3g;

import com.nokia.phone.p000ri.m3g.C0000GL;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class CompositingMode extends Object3D {
    public static final int ALPHA = 64;
    public static final int ALPHA_ADD = 65;
    public static final int MODULATE = 66;
    public static final int MODULATE_X2 = 67;
    public static final int REPLACE = 68;
    private int blendingMode = 68;
    private float alphaThreshold = 0.0f;
    private boolean depthTest = true;
    private boolean depthWrite = true;
    private boolean colorWrite = true;
    private boolean alphaWrite = true;
    private float factor = 0.0f;
    private float units = 0.0f;

    static void applyDefaults() {
        C0000GL.DepthFunc(C0000GL.LEQUAL);
        C0000GL.DepthMask(true);
        C0000GL.ColorMask(true, true, true, true);
        C0000GL.AlphaFunc(C0000GL.GEQUAL, 0.0f);
        C0000GL.Disable(C0000GL.ALPHA_TEST);
        C0000GL.Disable(C0000GL.BLEND);
        C0000GL.Disable(C0000GL.POLYGON_OFFSET_FILL);
    }

    void apply() {
        int i = C0000GL.SRC_ALPHA;
        int i2 = 0;
        C0000GL.DepthMask(this.depthWrite);
        if (this.depthTest) {
            C0000GL.DepthFunc(C0000GL.LEQUAL);
        } else {
            C0000GL.DepthFunc(C0000GL.ALWAYS);
        }
        C0000GL.ColorMask(this.colorWrite, this.colorWrite, this.colorWrite, this.alphaWrite);
        C0000GL.AlphaFunc(C0000GL.GEQUAL, this.alphaThreshold);
        if (this.alphaThreshold == 0.0f) {
            C0000GL.Disable(C0000GL.ALPHA_TEST);
        } else {
            C0000GL.Enable(C0000GL.ALPHA_TEST);
        }
        if (this.blendingMode == 68) {
            C0000GL.Disable(C0000GL.BLEND);
        } else {
            switch (this.blendingMode) {
                case 64:
                    i2 = C0000GL.ONE_MINUS_SRC_ALPHA;
                    break;
                case ALPHA_ADD /* 65 */:
                    i2 = 1;
                    break;
                case MODULATE /* 66 */:
                    i = 774;
                    break;
                case MODULATE_X2 /* 67 */:
                    i2 = C0000GL.SRC_COLOR;
                    i = 774;
                    break;
                default:
                    i = 1;
                    break;
            }
            C0000GL.BlendFunc(i, i2);
            C0000GL.Enable(C0000GL.BLEND);
        }
        C0000GL.PolygonOffset(this.factor, this.units);
        if (this.factor == 0.0f && this.units == 0.0f) {
            C0000GL.Disable(C0000GL.POLYGON_OFFSET_FILL);
        } else {
            C0000GL.Enable(C0000GL.POLYGON_OFFSET_FILL);
        }
    }

    @Override // javax.microedition.m3g.Object3D
    Object3D createDuplicate() {
        CompositingMode compositingMode = new CompositingMode();
        compositingMode.copy(this);
        compositingMode.blendingMode = this.blendingMode;
        compositingMode.alphaThreshold = this.alphaThreshold;
        compositingMode.depthTest = this.depthTest;
        compositingMode.depthWrite = this.depthWrite;
        compositingMode.colorWrite = this.colorWrite;
        compositingMode.factor = this.factor;
        compositingMode.units = this.units;
        return compositingMode;
    }

    public float getAlphaThreshold() {
        return this.alphaThreshold;
    }

    public int getBlending() {
        return this.blendingMode;
    }

    public float getDepthOffsetFactor() {
        return this.factor;
    }

    public float getDepthOffsetUnits() {
        return this.units;
    }

    public boolean isAlphaWriteEnabled() {
        return this.alphaWrite;
    }

    public boolean isColorWriteEnabled() {
        return this.colorWrite;
    }

    public boolean isDepthTestEnabled() {
        return this.depthTest;
    }

    public boolean isDepthWriteEnabled() {
        return this.depthWrite;
    }

    public void setAlphaThreshold(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException();
        }
        this.alphaThreshold = f;
    }

    public void setAlphaWriteEnable(boolean z) {
        this.alphaWrite = z;
    }

    public void setBlending(int i) {
        if (i != 68 && i != 64 && i != 66 && i != 67 && i != 65) {
            throw new IllegalArgumentException();
        }
        this.blendingMode = i;
    }

    public void setColorWriteEnable(boolean z) {
        this.colorWrite = z;
    }

    public void setDepthOffset(float f, float f2) {
        this.factor = f;
        this.units = f2;
    }

    public void setDepthTestEnable(boolean z) {
        this.depthTest = z;
    }

    public void setDepthWriteEnable(boolean z) {
        this.depthWrite = z;
    }
}
