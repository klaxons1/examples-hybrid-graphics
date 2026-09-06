package javax.microedition.m3g;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class World extends Group {
    private Camera activeCamera = null;
    private Background background = null;

    @Override // javax.microedition.m3g.Group, javax.microedition.m3g.Object3D
    int applyAnimation(int i) {
        int iApplyAnimation = super.applyAnimation(i);
        return this.background != null ? Math.min(iApplyAnimation, this.background.applyAnimation(i)) : iApplyAnimation;
    }

    @Override // javax.microedition.m3g.Group, javax.microedition.m3g.Object3D
    Object3D createDuplicate() {
        World world = new World();
        world.copy((Group) this);
        world.activeCamera = this.activeCamera;
        world.background = this.background;
        return world;
    }

    @Override // javax.microedition.m3g.Group, javax.microedition.m3g.Object3D
    int doGetReferences(Object3D[] object3DArr) {
        int iDoGetReferences = super.doGetReferences(object3DArr);
        if (this.activeCamera != null) {
            if (object3DArr != null) {
                object3DArr[iDoGetReferences] = this.activeCamera;
            }
            iDoGetReferences++;
        }
        if (this.background == null) {
            return iDoGetReferences;
        }
        if (object3DArr != null) {
            object3DArr[iDoGetReferences] = this.background;
        }
        return iDoGetReferences + 1;
    }

    public Camera getActiveCamera() {
        return this.activeCamera;
    }

    public Background getBackground() {
        return this.background;
    }

    public void setActiveCamera(Camera camera) {
        if (camera == null) {
            throw new NullPointerException();
        }
        this.activeCamera = camera;
    }

    public void setBackground(Background background) {
        this.background = background;
    }

    @Override // javax.microedition.m3g.Group, javax.microedition.m3g.Node
    void updateDuplicateReferences() {
        super.updateDuplicateReferences();
        if (this.activeCamera == null || this.activeCamera.getDuplicatedInstance() == null || !this.activeCamera.getDuplicatedInstance().isChildOf(getDuplicatedInstance())) {
            return;
        }
        ((World) getDuplicatedInstance()).activeCamera = (Camera) this.activeCamera.getDuplicatedInstance();
    }
}
