package javax.microedition.m3g;

import java.util.Vector;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public abstract class Object3D {
    private int userID;
    private Object userObject = null;
    private Vector animTracks = null;

    Object3D() {
    }

    public void addAnimationTrack(AnimationTrack animationTrack) {
        if (animationTrack == null) {
            throw new NullPointerException();
        }
        if ((this.animTracks != null && this.animTracks.contains(animationTrack)) || !isCompatible(animationTrack)) {
            throw new IllegalArgumentException();
        }
        if (this.animTracks == null) {
            this.animTracks = new Vector();
        }
        int numComponents = animationTrack.getKeyframeSequence().getNumComponents();
        int targetProperty = animationTrack.getTargetProperty();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.animTracks.size()) {
                this.animTracks.addElement(animationTrack);
                return;
            }
            AnimationTrack animationTrack2 = (AnimationTrack) this.animTracks.elementAt(i2);
            if (animationTrack2.getTargetProperty() > targetProperty) {
                this.animTracks.insertElementAt(animationTrack, i2);
                return;
            } else {
                if (animationTrack2.getTargetProperty() == targetProperty && animationTrack2.getKeyframeSequence().getNumComponents() != numComponents) {
                    throw new IllegalArgumentException();
                }
                i = i2 + 1;
            }
        }
    }

    public final int animate(int i) {
        return applyAnimation(i);
    }

    int applyAnimation(int i) {
        if (this.animTracks == null) {
            return Integer.MAX_VALUE;
        }
        float[] fArr = new float[2];
        int i2 = 0;
        int iMin = Integer.MAX_VALUE;
        while (i2 < this.animTracks.size()) {
            AnimationTrack animationTrack = (AnimationTrack) this.animTracks.elementAt(i2);
            int targetProperty = animationTrack.getTargetProperty();
            float[] fArr2 = new float[animationTrack.getKeyframeSequence().getNumComponents()];
            float f = 0.0f;
            do {
                animationTrack.getContribution(i, fArr2, fArr);
                f += fArr[0];
                iMin = Math.min(iMin, (int) fArr[1]);
                i2++;
                if (i2 == this.animTracks.size()) {
                    break;
                }
                animationTrack = (AnimationTrack) this.animTracks.elementAt(i2);
            } while (animationTrack.getTargetProperty() == targetProperty);
            if (f > 0.0f) {
                updateProperty(targetProperty, fArr2);
            }
        }
        return iMin;
    }

    void copy(Object3D object3D) {
        this.userID = object3D.userID;
        this.userObject = object3D.userObject;
        if (object3D.animTracks == null) {
            this.animTracks = null;
            return;
        }
        this.animTracks = new Vector(object3D.animTracks.size());
        this.animTracks.setSize(object3D.animTracks.size());
        for (int i = 0; i < object3D.animTracks.size(); i++) {
            this.animTracks.setElementAt(object3D.animTracks.elementAt(i), i);
        }
    }

    abstract Object3D createDuplicate();

    int doGetReferences(Object3D[] object3DArr) {
        int i = 0;
        if (this.animTracks == null) {
            return 0;
        }
        if (object3DArr != null) {
            while (true) {
                int i2 = i;
                if (i2 >= this.animTracks.size()) {
                    break;
                }
                object3DArr[i2] = (Object3D) this.animTracks.elementAt(i2);
                i = i2 + 1;
            }
        }
        return this.animTracks.size();
    }

    public final Object3D duplicate() {
        Object3D object3DCreateDuplicate = createDuplicate();
        if (this instanceof Node) {
            Node node = (Node) this;
            node.updateDuplicateReferences();
            node.clearDuplicateReferences();
        }
        return object3DCreateDuplicate;
    }

    public Object3D find(int i) {
        if (this.userID == i) {
            return this;
        }
        int references = getReferences(null);
        Object3D[] object3DArr = new Object3D[references];
        getReferences(object3DArr);
        for (int i2 = 0; i2 < references; i2++) {
            Object3D object3DFind = object3DArr[i2].find(i);
            if (object3DFind != null) {
                return object3DFind;
            }
        }
        return null;
    }

    public AnimationTrack getAnimationTrack(int i) {
        if (this.animTracks == null || i < 0 || i >= this.animTracks.size()) {
            throw new IndexOutOfBoundsException();
        }
        return (AnimationTrack) this.animTracks.elementAt(i);
    }

    public int getAnimationTrackCount() {
        if (this.animTracks != null) {
            return this.animTracks.size();
        }
        return 0;
    }

    public int getReferences(Object3D[] object3DArr) {
        if (object3DArr != null) {
            if (object3DArr.length < doGetReferences(null)) {
                throw new IllegalArgumentException();
            }
        }
        return doGetReferences(object3DArr);
    }

    public int getUserID() {
        return this.userID;
    }

    public Object getUserObject() {
        return this.userObject;
    }

    boolean isCompatible(AnimationTrack animationTrack) {
        return false;
    }

    public void removeAnimationTrack(AnimationTrack animationTrack) {
        if (animationTrack == null) {
            throw new NullPointerException();
        }
        if (this.animTracks != null) {
            this.animTracks.removeElement(animationTrack);
            if (this.animTracks.size() == 0) {
                this.animTracks = null;
            }
        }
    }

    public void setUserID(int i) {
        this.userID = i;
    }

    public void setUserObject(Object obj) {
        this.userObject = obj;
    }

    void updateProperty(int i, float[] fArr) {
        throw new Error("Invalid animation target property!");
    }
}
