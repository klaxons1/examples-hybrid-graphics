package javax.microedition.m3g;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
class RenderQueue {
    private static final int MAX_LIGHTS = 8;
    private static final int MAX_MESHES = 8;
    private int[] subMeshIndexes = new int[8];
    private int[] sortKeys = new int[8];
    private Node[] meshes = new Node[8];
    private int maxMeshes = 8;
    private int numMeshes = 0;
    private Node root = null;
    private Graphics3D lightTarget = null;

    RenderQueue() {
    }

    void begin(Node node, Graphics3D graphics3D) {
        if (this.numMeshes != 0) {
            throw new Error("RenderQueue not flushed");
        }
        if (node == null) {
            throw new Error("null root node");
        }
        this.root = node;
        this.lightTarget = graphics3D;
    }

    void clear() {
        this.numMeshes = 0;
        this.root = null;
        this.lightTarget = null;
    }

    void commit(Graphics3D graphics3D) {
        for (int i = 0; i < this.numMeshes; i++) {
            this.meshes[i].doRender(graphics3D, this.subMeshIndexes[i]);
        }
    }

    Node getRoot() {
        return this.root;
    }

    void insert(Node node, int i, int i2) {
        int i3 = 0;
        if (this.numMeshes >= this.maxMeshes) {
            Node[] nodeArr = new Node[this.maxMeshes * 2];
            int[] iArr = new int[this.maxMeshes * 2];
            int[] iArr2 = new int[this.maxMeshes * 2];
            System.arraycopy(this.meshes, 0, nodeArr, 0, this.maxMeshes);
            System.arraycopy(this.subMeshIndexes, 0, iArr, 0, this.maxMeshes);
            System.arraycopy(this.sortKeys, 0, iArr2, 0, this.maxMeshes);
            this.meshes = nodeArr;
            this.subMeshIndexes = iArr;
            this.sortKeys = iArr2;
            this.maxMeshes *= 2;
        }
        while (i3 < this.numMeshes) {
            if (this.sortKeys[i3] > i2) {
                System.arraycopy(this.meshes, i3, this.meshes, i3 + 1, this.numMeshes - i3);
                System.arraycopy(this.subMeshIndexes, i3, this.subMeshIndexes, i3 + 1, this.numMeshes - i3);
                System.arraycopy(this.sortKeys, i3, this.sortKeys, i3 + 1, this.numMeshes - i3);
                break;
            }
            i3++;
        }
        this.meshes[i3] = node;
        this.subMeshIndexes[i3] = i;
        this.sortKeys[i3] = i2;
        this.numMeshes++;
    }

    void insertLight(Light light, Transform transform) {
        if (this.lightTarget != null) {
            this.lightTarget.addLight(light, transform);
        }
    }
}
