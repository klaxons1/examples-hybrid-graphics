package javax.microedition.m3g;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class Group extends Node {
    private static final int MAX_NODES = 8;
    private Node[] nodes = new Node[8];
    private int maxNodes = 8;
    private int numNodes = 0;

    public void addChild(Node node) {
        if (node == null) {
            throw new NullPointerException();
        }
        if (node == this || (node instanceof World) || node.getParent() != null || isChildOf(node)) {
            throw new IllegalArgumentException();
        }
        if (this.numNodes >= this.maxNodes) {
            Node[] nodeArr = new Node[this.maxNodes * 2];
            System.arraycopy(this.nodes, 0, nodeArr, 0, this.maxNodes);
            this.nodes = nodeArr;
            this.maxNodes *= 2;
        }
        Node[] nodeArr2 = this.nodes;
        int i = this.numNodes;
        this.numNodes = i + 1;
        nodeArr2[i] = node;
        node.setParent(this);
    }

    @Override // javax.microedition.m3g.Object3D
    int applyAnimation(int i) {
        int iApplyAnimation = super.applyAnimation(i);
        if (iApplyAnimation >= Integer.MAX_VALUE) {
            iApplyAnimation = Integer.MAX_VALUE;
        }
        int i2 = iApplyAnimation;
        for (int i3 = 0; i3 < this.numNodes; i3++) {
            int iApplyAnimation2 = this.nodes[i3].applyAnimation(i);
            if (iApplyAnimation2 < i2) {
                i2 = iApplyAnimation2;
            }
        }
        return i2;
    }

    @Override // javax.microedition.m3g.Node
    void clearDuplicateReferences() {
        super.clearDuplicateReferences();
        for (int i = 0; i < this.numNodes; i++) {
            this.nodes[i].clearDuplicateReferences();
        }
    }

    void copy(Group group) {
        super.copy((Node) group);
        this.nodes = new Node[group.nodes.length];
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= group.numNodes) {
                this.maxNodes = group.maxNodes;
                this.numNodes = group.numNodes;
                return;
            } else {
                addChild((Node) group.nodes[i2].createDuplicate());
                i = i2 + 1;
            }
        }
    }

    @Override // javax.microedition.m3g.Object3D
    Object3D createDuplicate() {
        Group group = new Group();
        group.copy(this);
        return group;
    }

    @Override // javax.microedition.m3g.Node
    void doAlign(Node node) {
        super.doAlign(node);
        for (int i = 0; i < this.numNodes; i++) {
            this.nodes[i].doAlign(node);
        }
    }

    @Override // javax.microedition.m3g.Object3D
    int doGetReferences(Object3D[] object3DArr) {
        int iDoGetReferences = super.doGetReferences(object3DArr);
        for (int i = 0; i < this.numNodes; i++) {
            if (object3DArr != null) {
                object3DArr[iDoGetReferences] = this.nodes[i];
            }
            iDoGetReferences++;
        }
        return iDoGetReferences;
    }

    public Node getChild(int i) {
        if (i >= this.numNodes || i < 0) {
            throw new IndexOutOfBoundsException();
        }
        return this.nodes[i];
    }

    public int getChildCount() {
        return this.numNodes;
    }

    public boolean pick(int i, float f, float f2, float f3, float f4, float f5, float f6, RayIntersection rayIntersection) {
        if (f4 == 0.0f && f5 == 0.0f && f6 == 0.0f) {
            throw new IllegalArgumentException();
        }
        Transform transform = new Transform();
        float[] fArr = {f, f2, f3, f + f4, f2 + f5, f3 + f6};
        RayIntersection rayIntersection2 = rayIntersection == null ? new RayIntersection() : rayIntersection;
        rayIntersection2.initPick(this, fArr, 0.0f, 0.0f, null);
        return rayIntersect(i, fArr, rayIntersection2, transform);
    }

    public boolean pick(int i, float f, float f2, Camera camera, RayIntersection rayIntersection) {
        if (camera.getRoot() != getRoot()) {
            throw new IllegalStateException();
        }
        if (camera == null) {
            throw new NullPointerException();
        }
        Vec4f vec4f = new Vec4f((2.0f * f) - 1.0f, 1.0f - (2.0f * f2), 1.0f, 1.0f);
        Vec4f vec4f2 = new Vec4f((2.0f * f) - 1.0f, 1.0f - (2.0f * f2), -1.0f, 1.0f);
        Transform transform = new Transform();
        camera.getProjection(transform);
        transform.invert();
        transform.transform(vec4f2);
        vec4f2.mul(1.0f / vec4f2.f76w);
        transform.transform(vec4f);
        vec4f.mul(1.0f / vec4f.f76w);
        float[] fArr = {vec4f2.f77x, vec4f2.f78y, vec4f2.f79z, vec4f.f77x, vec4f.f78y, vec4f.f79z, vec4f2.f79z, vec4f.f79z};
        Transform transform2 = new Transform();
        camera.getTransformTo(this, transform2);
        transform2.transform(vec4f2);
        vec4f2.mul(1.0f / vec4f2.f76w);
        transform2.transform(vec4f);
        vec4f.mul(1.0f / vec4f.f76w);
        RayIntersection rayIntersection2 = rayIntersection == null ? new RayIntersection() : rayIntersection;
        rayIntersection2.initPick(this, fArr, f, f2, camera);
        transform2.setIdentity();
        return rayIntersect(i, fArr, rayIntersection2, transform2);
    }

    @Override // javax.microedition.m3g.Node
    boolean rayIntersect(int i, float[] fArr, RayIntersection rayIntersection, Transform transform) {
        boolean z = false;
        Transform transform2 = new Transform();
        Transform transform3 = new Transform();
        int i2 = 0;
        while (true) {
            boolean z2 = z;
            if (i2 >= this.numNodes) {
                return z2;
            }
            if (((this.nodes[i2] instanceof Group) || (this.nodes[i2].getScope() & i) != 0) && this.nodes[i2].isPickable(rayIntersection.getRoot())) {
                transform2.set(transform);
                this.nodes[i2].getCompositeTransform(transform3);
                transform2.mulRight(transform3);
                if (this.nodes[i2].rayIntersect(i, fArr, rayIntersection, transform2)) {
                    z2 = true;
                }
            }
            z = z2;
            i2++;
        }
    }

    public void removeChild(Node node) {
        if (node != null) {
            if (node.isSkinnedMeshBone()) {
                throw new IllegalArgumentException();
            }
            for (int i = 0; i < this.numNodes; i++) {
                if (this.nodes[i] == node) {
                    System.arraycopy(this.nodes, i + 1, this.nodes, i, (this.numNodes - i) - 1);
                    this.numNodes--;
                    node.setParent(null);
                    return;
                }
            }
        }
    }

    @Override // javax.microedition.m3g.Node
    void setupRender(Transform transform, Node node, RenderQueue renderQueue) {
        Node parent;
        Transform transform2 = new Transform();
        Transform transform3 = new Transform();
        for (int i = 0; i < this.numNodes; i++) {
            if (this.nodes[i] != node) {
                transform2.set(transform);
                this.nodes[i].getCompositeTransform(transform3);
                transform2.mulRight(transform3);
                this.nodes[i].setupRender(transform2, this, renderQueue);
            }
        }
        if (this == renderQueue.getRoot() || (parent = getParent()) == node || parent == null) {
            return;
        }
        transform2.set(transform);
        getCompositeTransform(transform3);
        transform3.invert();
        transform2.mulRight(transform3);
        parent.setupRender(transform2, this, renderQueue);
    }

    @Override // javax.microedition.m3g.Node
    void updateDuplicateReferences() {
        super.updateDuplicateReferences();
        for (int i = 0; i < this.numNodes; i++) {
            this.nodes[i].updateDuplicateReferences();
        }
    }
}
