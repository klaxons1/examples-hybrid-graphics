package javax.microedition.m3g;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public abstract class Node extends Transformable {
    public static final int NONE = 144;
    public static final int ORIGIN = 145;
    public static final int X_AXIS = 146;
    public static final int Y_AXIS = 147;
    public static final int Z_AXIS = 148;
    private Node parent = null;
    private Node zReference = null;
    private Node yReference = null;
    private int zTarget = NONE;
    private int yTarget = NONE;
    private boolean enabled = true;
    private boolean pickable = true;
    private float alphaFactor = 1.0f;
    private float totalAlphaFactor = 1.0f;
    private int scope = -1;
    private boolean boneFlag = false;
    private Node duplicatedInstance = null;

    Node() {
    }

    private static void transformTarget(int i, Transform transform, Vec4f vec4f, Vec4f vec4f2, Vec4f vec4f3, Vec4f vec4f4, Vec4f vec4f5) {
        switch (i) {
            case ORIGIN /* 145 */:
                if (vec4f == null) {
                    vec4f = Defs.ORIGIN;
                }
                vec4f5.set(vec4f);
                break;
            case X_AXIS /* 146 */:
                if (vec4f2 == null) {
                    vec4f2 = Defs.X_AXIS;
                }
                vec4f5.set(vec4f2);
                break;
            case Y_AXIS /* 147 */:
                if (vec4f3 == null) {
                    vec4f3 = Defs.Y_AXIS;
                }
                vec4f5.set(vec4f3);
                break;
            case Z_AXIS /* 148 */:
                if (vec4f4 == null) {
                    vec4f4 = Defs.Z_AXIS;
                }
                vec4f5.set(vec4f4);
                break;
            default:
                throw new Error();
        }
        transform.transform(vec4f5);
    }

    public final void align(Node node) {
        if (node != null && node.getRoot() != getRoot()) {
            throw new IllegalArgumentException();
        }
        doAlign(node);
    }

    void clearDuplicateReferences() {
        this.duplicatedInstance = null;
    }

    void computeAlignment(Node node, Vec4f vec4f, Vec4f vec4f2, Vec4f vec4f3, Vec4f vec4f4) {
        Node root = getRoot();
        if (this.zReference != null && (this.zReference.isChildOf(this) || this.zReference.getRoot() != root)) {
            throw new IllegalStateException();
        }
        if (this.yReference != null && (this.yReference.isChildOf(this) || this.yReference.getRoot() != root)) {
            throw new IllegalStateException();
        }
        Transform transform = new Transform();
        Vec4f vec4f5 = new Vec4f();
        Quat4f quat4f = new Quat4f(0.0f, 0.0f, 0.0f, 1.0f);
        Vec4f vec4f6 = new Vec4f();
        getTranslation(vec4f6);
        if (this.zTarget != 144) {
            if (this.zReference == null && node == this) {
                throw new IllegalStateException();
            }
            (this.zReference != null ? this.zReference : node).getTransformTo(this.parent, transform);
            transform.preTranslate(-vec4f6.f77x, -vec4f6.f78y, -vec4f6.f79z);
            transformTarget(this.zTarget, transform, vec4f, vec4f2, vec4f3, vec4f4, vec4f5);
            vec4f5.f76w = 0.0f;
            quat4f.setRotation(Defs.Z_AXIS, vec4f5, null);
        }
        if (this.yTarget != 144) {
            if (this.yReference == null && node == this) {
                throw new IllegalStateException();
            }
            if (this.yReference != null) {
                node = this.yReference;
            }
            node.getTransformTo(this.parent, transform);
            transform.preTranslate(-vec4f6.f77x, -vec4f6.f78y, -vec4f6.f79z);
            if (this.zTarget != 144) {
                transform.preRotateQuat(quat4f.f65x, quat4f.f66y, quat4f.f67z, -quat4f.f64w);
            }
            transformTarget(this.yTarget, transform, vec4f, vec4f2, vec4f3, vec4f4, vec4f5);
            vec4f5.f76w = 0.0f;
            if (this.zTarget != 144) {
                Quat4f quat4f2 = new Quat4f();
                quat4f2.setRotation(Defs.Y_AXIS, vec4f5, Defs.Z_AXIS);
                quat4f.mul(quat4f2);
            } else {
                quat4f.setRotation(Defs.Y_AXIS, vec4f5, null);
            }
        }
        if (this.zTarget == 144 && this.yTarget == 144) {
            return;
        }
        setOrientation(quat4f);
    }

    void copy(Node node) {
        super.copy((Transformable) node);
        node.duplicatedInstance = this;
        this.zReference = node.zReference;
        this.yReference = node.yReference;
        this.zTarget = node.zTarget;
        this.yTarget = node.yTarget;
        this.enabled = node.enabled;
        this.pickable = node.pickable;
        this.alphaFactor = node.alphaFactor;
        this.totalAlphaFactor = node.totalAlphaFactor;
        this.scope = node.scope;
    }

    void doAlign(Node node) {
        if (node == null) {
            computeAlignment(this, null, null, null, null);
        } else {
            computeAlignment(node, null, null, null, null);
        }
    }

    void doRender(Graphics3D graphics3D, int i) {
        throw new Error("Non-renderable\tNode!");
    }

    void doSetAlignment(Node node, int i, Node node2, int i2) {
        if (i < 144 || i > 148 || i2 < 144 || i2 > 148) {
            throw new IllegalArgumentException();
        }
        if (node == this || node2 == this) {
            throw new IllegalArgumentException();
        }
        if (node == node2 && i == i2 && i != 144) {
            throw new IllegalArgumentException();
        }
        this.zReference = node;
        this.yReference = node2;
        this.zTarget = i;
        this.yTarget = i2;
    }

    void enableBoneFlag() {
        this.boneFlag = true;
    }

    public float getAlphaFactor() {
        return this.alphaFactor;
    }

    int getDepth() {
        int i = 0;
        while (this.parent != null) {
            this = this.parent;
            i++;
        }
        return i;
    }

    Node getDuplicatedInstance() {
        return this.duplicatedInstance;
    }

    public Node getParent() {
        return this.parent;
    }

    Node getRoot() {
        while (this.parent != null) {
            this = this.parent;
        }
        return this;
    }

    public int getScope() {
        return this.scope;
    }

    float getTotalAlphaFactor() {
        return this.totalAlphaFactor;
    }

    public boolean getTransformTo(Node node, Transform transform) {
        if (node == null || transform == null) {
            throw new NullPointerException();
        }
        Transform transform2 = new Transform();
        Transform transform3 = new Transform();
        Transform transform4 = new Transform();
        if (getRoot() != node.getRoot()) {
            return false;
        }
        while (this.getDepth() > node.getDepth()) {
            this.getCompositeTransform(transform4);
            transform3.mulLeft(transform4);
            this = this.parent;
        }
        while (node.getDepth() > this.getDepth()) {
            node.getCompositeTransform(transform4);
            transform2.mulLeft(transform4);
            node = node.parent;
        }
        while (this != node) {
            this.getCompositeTransform(transform4);
            transform3.mulLeft(transform4);
            this = this.parent;
            node.getCompositeTransform(transform4);
            transform2.mulLeft(transform4);
            node = node.parent;
        }
        transform2.invert();
        transform2.mulRight(transform3);
        transform.set(transform2);
        return true;
    }

    boolean isChildOf(Node node) {
        while (this != null) {
            if (this.parent == node) {
                return true;
            }
            this = this.parent;
        }
        return false;
    }

    @Override // javax.microedition.m3g.Transformable, javax.microedition.m3g.Object3D
    boolean isCompatible(AnimationTrack animationTrack) {
        switch (animationTrack.getTargetProperty()) {
            case 256:
            case AnimationTrack.PICKABILITY /* 269 */:
            case AnimationTrack.VISIBILITY /* 276 */:
                return true;
            default:
                return super.isCompatible(animationTrack);
        }
    }

    boolean isPickable(Node node) {
        while (this != null) {
            if (!this.pickable) {
                return false;
            }
            if (this == node) {
                break;
            }
            this = this.parent;
        }
        return true;
    }

    public boolean isPickingEnabled() {
        return this.pickable;
    }

    public boolean isRenderingEnabled() {
        return this.enabled;
    }

    boolean isSkinnedMeshBone() {
        return this.boneFlag;
    }

    boolean isVisible(Node node) {
        while (this != null) {
            if (!this.enabled) {
                return false;
            }
            if (this == node) {
                break;
            }
            this = this.parent;
        }
        return true;
    }

    abstract boolean rayIntersect(int i, float[] fArr, RayIntersection rayIntersection, Transform transform);

    public void setAlignment(Node node, int i, Node node2, int i2) {
        doSetAlignment(node, i, node2, i2);
    }

    public void setAlphaFactor(float f) {
        if (f < 0.0f || f > 1.0f) {
            throw new IllegalArgumentException();
        }
        this.alphaFactor = f;
    }

    void setParent(Node node) {
        this.parent = node;
    }

    public void setPickingEnable(boolean z) {
        this.pickable = z;
    }

    public void setRenderingEnable(boolean z) {
        this.enabled = z;
    }

    public void setScope(int i) {
        this.scope = i;
    }

    void setSkinnedMeshBone() {
        while (this != null && !(this instanceof SkinnedMesh)) {
            this.enableBoneFlag();
            this = this.getParent();
        }
    }

    abstract void setupRender(Transform transform, Node node, RenderQueue renderQueue);

    void setupTotalAlphaFactor(Node node) {
        float f = this.alphaFactor;
        Node node2 = this;
        while (node2.parent != null && node2 != node) {
            node2 = node2.parent;
            f *= node2.alphaFactor;
        }
        this.totalAlphaFactor = f;
    }

    void updateDuplicateReferences() {
        if (this.zTarget != 144) {
            Node node = this.zReference.duplicatedInstance;
            if (this.zReference != null && node != null && node.isChildOf(this.duplicatedInstance.getRoot())) {
                this.duplicatedInstance.zReference = node;
            }
        }
        if (this.yTarget != 144) {
            Node node2 = this.yReference.duplicatedInstance;
            if (this.yReference == null || node2 == null || !node2.isChildOf(this.duplicatedInstance.getRoot())) {
                return;
            }
            this.duplicatedInstance.yReference = node2;
        }
    }

    @Override // javax.microedition.m3g.Transformable, javax.microedition.m3g.Object3D
    void updateProperty(int i, float[] fArr) {
        switch (i) {
            case 256:
                this.alphaFactor = Util.clamp(fArr[0], 0.0f, 1.0f);
                break;
            case AnimationTrack.PICKABILITY /* 269 */:
                this.pickable = fArr[0] >= 0.5f;
                break;
            case AnimationTrack.VISIBILITY /* 276 */:
                this.enabled = fArr[0] >= 0.5f;
                break;
            default:
                super.updateProperty(i, fArr);
                break;
        }
    }
}
