package javax.microedition.m3g;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class AnimationTrack extends Object3D {
    public static final int ALPHA = 256;
    public static final int AMBIENT_COLOR = 257;
    public static final int COLOR = 258;
    public static final int CROP = 259;
    public static final int DENSITY = 260;
    public static final int DIFFUSE_COLOR = 261;
    public static final int EMISSIVE_COLOR = 262;
    public static final int FAR_DISTANCE = 263;
    public static final int FIELD_OF_VIEW = 264;
    public static final int INTENSITY = 265;
    public static final int MORPH_WEIGHTS = 266;
    public static final int NEAR_DISTANCE = 267;
    public static final int ORIENTATION = 268;
    public static final int PICKABILITY = 269;
    public static final int SCALE = 270;
    public static final int SHININESS = 271;
    public static final int SPECULAR_COLOR = 272;
    public static final int SPOT_ANGLE = 273;
    public static final int SPOT_EXPONENT = 274;
    public static final int TRANSLATION = 275;
    public static final int VISIBILITY = 276;
    private AnimationController controller;
    private int property;
    private KeyframeSequence sequence;

    public AnimationTrack(KeyframeSequence keyframeSequence, int i) {
        if (i < 256 || i > 276 || !isValidSize(i, keyframeSequence.getNumComponents())) {
            throw new IllegalArgumentException();
        }
        this.sequence = keyframeSequence;
        this.property = i;
    }

    static boolean isValidSize(int i, int i2) {
        switch (i) {
            case 256:
            case 260:
            case FAR_DISTANCE /* 263 */:
            case FIELD_OF_VIEW /* 264 */:
            case INTENSITY /* 265 */:
            case NEAR_DISTANCE /* 267 */:
            case PICKABILITY /* 269 */:
            case SHININESS /* 271 */:
            case SPOT_ANGLE /* 273 */:
            case SPOT_EXPONENT /* 274 */:
            case VISIBILITY /* 276 */:
                return i2 == 1;
            case 257:
            case 258:
            case DIFFUSE_COLOR /* 261 */:
            case EMISSIVE_COLOR /* 262 */:
            case SPECULAR_COLOR /* 272 */:
                return i2 == 3;
            case 259:
                return i2 == 2 || i2 == 4;
            case MORPH_WEIGHTS /* 266 */:
                return i2 > 0;
            case ORIENTATION /* 268 */:
                return i2 == 4;
            case SCALE /* 270 */:
                return i2 == 1 || i2 == 3;
            case TRANSLATION /* 275 */:
                return i2 == 3;
            default:
                throw new Error("Unknown animation target property!");
        }
    }

    @Override // javax.microedition.m3g.Object3D
    Object3D createDuplicate() {
        AnimationTrack animationTrack = new AnimationTrack(this.sequence, this.property);
        animationTrack.copy(this);
        animationTrack.controller = this.controller;
        return animationTrack;
    }

    @Override // javax.microedition.m3g.Object3D
    int doGetReferences(Object3D[] object3DArr) {
        int iDoGetReferences = super.doGetReferences(object3DArr);
        if (this.sequence != null) {
            if (object3DArr != null) {
                object3DArr[iDoGetReferences] = this.sequence;
            }
            iDoGetReferences++;
        }
        if (this.controller == null) {
            return iDoGetReferences;
        }
        if (object3DArr != null) {
            object3DArr[iDoGetReferences] = this.controller;
        }
        return iDoGetReferences + 1;
    }

    void getContribution(int i, float[] fArr, float[] fArr2) {
        if (this.controller == null || !this.controller.isActive(i)) {
            fArr2[0] = 0.0f;
            fArr2[1] = Math.max(1, this.controller != null ? this.controller.timeToActivation(i) : Integer.MAX_VALUE);
            return;
        }
        float[] fArr3 = new float[this.sequence.getNumComponents()];
        fArr2[1] = Math.min(this.sequence.getSample(this.controller.getPosition(i), fArr3), this.controller.timeToDeactivation(i));
        float weight = this.controller.getWeight();
        for (int i2 = 0; i2 < fArr3.length; i2++) {
            fArr[i2] = fArr[i2] + (fArr3[i2] * weight);
        }
        fArr2[0] = weight;
    }

    public AnimationController getController() {
        return this.controller;
    }

    public KeyframeSequence getKeyframeSequence() {
        return this.sequence;
    }

    public int getTargetProperty() {
        return this.property;
    }

    public void setController(AnimationController animationController) {
        this.controller = animationController;
    }
}
