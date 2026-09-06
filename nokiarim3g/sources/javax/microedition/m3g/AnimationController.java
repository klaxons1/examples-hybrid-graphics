package javax.microedition.m3g;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class AnimationController extends Object3D {
    private int activationTime = 0;
    private int deactivationTime = 0;
    private float weight = 1.0f;
    private float speed = 1.0f;
    private int refWorldTime = 0;
    private float refSequenceTime = 0.0f;

    @Override // javax.microedition.m3g.Object3D
    Object3D createDuplicate() {
        AnimationController animationController = new AnimationController();
        animationController.copy(this);
        animationController.activationTime = this.activationTime;
        animationController.deactivationTime = this.deactivationTime;
        animationController.weight = this.weight;
        animationController.speed = this.speed;
        animationController.refWorldTime = this.refWorldTime;
        animationController.refSequenceTime = this.refSequenceTime;
        return animationController;
    }

    public int getActiveIntervalEnd() {
        return this.deactivationTime;
    }

    public int getActiveIntervalStart() {
        return this.activationTime;
    }

    public float getPosition(int i) {
        return ((i - this.refWorldTime) * this.speed) + this.refSequenceTime;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getWeight() {
        return this.weight;
    }

    boolean isActive(int i) {
        if (this.activationTime == this.deactivationTime) {
            return true;
        }
        return i >= this.activationTime && i < this.deactivationTime;
    }

    public void setActiveInterval(int i, int i2) {
        if (i > i2) {
            throw new IllegalArgumentException();
        }
        this.activationTime = i;
        this.deactivationTime = i2;
    }

    public void setPosition(float f, int i) {
        this.refWorldTime = i;
        this.refSequenceTime = f;
    }

    public void setSpeed(float f, int i) {
        this.refSequenceTime = getPosition(i);
        this.refWorldTime = i;
        this.speed = f;
    }

    public void setWeight(float f) {
        if (f < 0.0f) {
            throw new IllegalArgumentException();
        }
        this.weight = f;
    }

    int timeToActivation(int i) {
        if (i < this.activationTime) {
            return this.activationTime - i;
        }
        if (i < this.deactivationTime) {
            return 0;
        }
        return Integer.MAX_VALUE;
    }

    int timeToDeactivation(int i) {
        return i < this.deactivationTime ? this.deactivationTime - i : Integer.MAX_VALUE;
    }
}
