package javax.microedition.m3g;

import java.util.Vector;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class SkinnedMesh extends Mesh {
    private boolean dirtyState;
    private float[] fPositions;
    private float[] fVec;
    private VertexBuffer morphedVB;
    private float[] scaleBias;
    private Group skeleton;
    private Vec4f tempVec;
    private Vector transforms;

    class WeightedTransform {
        public Node bone;
        public int firstVertex;
        public int lastVertex;
        private final SkinnedMesh this$0;
        public int weight;
        public Transform positionTransform = new Transform();
        public Transform normalTransform = new Transform();
        public Transform toBone = new Transform();

        public WeightedTransform(SkinnedMesh skinnedMesh, Node node, Transform transform, int i, int i2, int i3) {
            this.this$0 = skinnedMesh;
            this.bone = node;
            this.weight = i;
            this.toBone.set(transform);
            this.firstVertex = i2;
            this.lastVertex = i3;
        }
    }

    public SkinnedMesh(VertexBuffer vertexBuffer, IndexBuffer indexBuffer, Appearance appearance, Group group) {
        super(vertexBuffer, indexBuffer, appearance);
        this.morphedVB = new VertexBuffer();
        this.fPositions = null;
        this.transforms = new Vector();
        this.skeleton = null;
        this.dirtyState = true;
        this.tempVec = new Vec4f();
        this.fVec = new float[3];
        this.scaleBias = new float[4];
        if (group == null) {
            throw new NullPointerException();
        }
        if (group.getParent() != null || (group instanceof World)) {
            throw new IllegalArgumentException();
        }
        group.setParent(this);
        this.skeleton = group;
        updateVB();
    }

    public SkinnedMesh(VertexBuffer vertexBuffer, IndexBuffer[] indexBufferArr, Appearance[] appearanceArr, Group group) {
        super(vertexBuffer, indexBufferArr, appearanceArr);
        this.morphedVB = new VertexBuffer();
        this.fPositions = null;
        this.transforms = new Vector();
        this.skeleton = null;
        this.dirtyState = true;
        this.tempVec = new Vec4f();
        this.fVec = new float[3];
        this.scaleBias = new float[4];
        if (group == null) {
            throw new NullPointerException();
        }
        if (group.getParent() != null || (group instanceof World)) {
            throw new IllegalArgumentException();
        }
        group.setParent(this);
        this.skeleton = group;
        updateVB();
    }

    public void addTransform(Node node, int i, int i2, int i3) {
        int i4;
        if (node == null) {
            throw new NullPointerException();
        }
        if (i3 <= 0 || i <= 0 || !node.isChildOf(this)) {
            throw new IllegalArgumentException();
        }
        if (i2 < 0 || i2 + i3 > 65535) {
            throw new IndexOutOfBoundsException();
        }
        int i5 = 0;
        while (true) {
            i4 = i5;
            if (i4 >= this.transforms.size() || i2 <= ((WeightedTransform) this.transforms.elementAt(i4)).firstVertex) {
                break;
            } else {
                i5 = i4 + 1;
            }
        }
        Transform transform = new Transform();
        getTransformTo(node, transform);
        this.transforms.insertElementAt(new WeightedTransform(this, node, transform, i, i2, (i2 + i3) - 1), i4);
        node.setSkinnedMeshBone();
    }

    @Override // javax.microedition.m3g.Mesh, javax.microedition.m3g.Object3D
    int applyAnimation(int i) {
        return Math.min(this.skeleton.applyAnimation(i), super.applyAnimation(i));
    }

    @Override // javax.microedition.m3g.Node
    void clearDuplicateReferences() {
        super.clearDuplicateReferences();
        this.skeleton.clearDuplicateReferences();
    }

    @Override // javax.microedition.m3g.Mesh, javax.microedition.m3g.Object3D
    Object3D createDuplicate() {
        SkinnedMesh skinnedMesh = new SkinnedMesh(getVertexBuffer(), getIndexBuffers(), getAppearances(), (Group) this.skeleton.createDuplicate());
        skinnedMesh.copy((Node) this);
        for (int i = 0; i < this.transforms.size(); i++) {
            skinnedMesh.transforms.insertElementAt(this.transforms.elementAt(i), i);
        }
        return skinnedMesh;
    }

    @Override // javax.microedition.m3g.Node
    void doAlign(Node node) {
        super.doAlign(node);
        if (this.skeleton != null) {
            this.skeleton.doAlign(node);
        }
    }

    @Override // javax.microedition.m3g.Mesh, javax.microedition.m3g.Object3D
    int doGetReferences(Object3D[] object3DArr) {
        int iDoGetReferences = super.doGetReferences(object3DArr);
        if (this.skeleton == null) {
            return iDoGetReferences;
        }
        if (object3DArr != null) {
            object3DArr[iDoGetReferences] = this.skeleton;
        }
        return iDoGetReferences + 1;
    }

    @Override // javax.microedition.m3g.Mesh, javax.microedition.m3g.Node
    void doRender(Graphics3D graphics3D, int i) {
        IndexBuffer indexBuffer = getIndexBuffer(i);
        Appearance appearance = getAppearance(i);
        if (indexBuffer == null || appearance == null) {
            return;
        }
        morph();
        this.morphedVB.getPositions(null).getShortValues();
        graphics3D.render(this.morphedVB, indexBuffer, appearance, getTransformToCamera(), getScope(), getTotalAlphaFactor());
    }

    public Group getSkeleton() {
        return this.skeleton;
    }

    void morph() {
        int i;
        if (this.dirtyState) {
            VertexBuffer vertexBuffer = getVertexBuffer();
            VertexArray positions = vertexBuffer.getPositions(this.scaleBias);
            if (positions == null) {
                throw new IllegalStateException();
            }
            VertexArray normals = vertexBuffer.getNormals();
            int i2 = 0;
            int i3 = 0;
            float[] fArr = {-2.1474836E9f, -2.1474836E9f, -2.1474836E9f};
            float[] fArr2 = {2.1474836E9f, 2.1474836E9f, 2.1474836E9f};
            updateVB();
            int vertexCount = vertexBuffer.getVertexCount();
            int i4 = 0;
            while (true) {
                int i5 = i4;
                if (i5 >= this.transforms.size()) {
                    short[] shortValues = positions.getShortValues();
                    byte[] byteValues = positions.getByteValues();
                    short[] shortValues2 = this.morphedVB.getPositions(null).getShortValues();
                    short[] shortValues3 = normals != null ? normals.getShortValues() : null;
                    byte[] byteValues2 = normals != null ? normals.getByteValues() : null;
                    short[] shortValues4 = normals != null ? this.morphedVB.getNormals().getShortValues() : null;
                    int i6 = 0;
                    int i7 = -1;
                    while (i6 < vertexCount) {
                        while (true) {
                            i = i7;
                            if (this.transforms.size() <= i + 1) {
                                break;
                            }
                            WeightedTransform weightedTransform = (WeightedTransform) this.transforms.elementAt(i + 1);
                            if (weightedTransform.firstVertex > i6) {
                                break;
                            }
                            i2 += weightedTransform.weight;
                            i3++;
                            i7 = i + 1;
                        }
                        int i8 = 0;
                        if (i3 > 0) {
                            this.fPositions[(i6 * 3) + 2] = 0.0f;
                            this.fPositions[(i6 * 3) + 1] = 0.0f;
                            this.fPositions[i6 * 3] = 0.0f;
                            if (shortValues4 != null) {
                                shortValues4[(i6 * 3) + 2] = 0;
                                shortValues4[(i6 * 3) + 1] = 0;
                                shortValues4[i6 * 3] = 0;
                            }
                            if (i2 != 0 && this.scaleBias[0] != 0.0f) {
                                for (int i9 = 0; i9 <= i; i9++) {
                                    WeightedTransform weightedTransform2 = (WeightedTransform) this.transforms.elementAt(i9);
                                    if (weightedTransform2.lastVertex >= i6) {
                                        if (weightedTransform2.lastVertex == i6) {
                                            i3--;
                                            i8 += weightedTransform2.weight;
                                        }
                                        float f = weightedTransform2.weight / i2;
                                        for (int i10 = 0; i10 < 3; i10++) {
                                            if (shortValues != null) {
                                                this.fVec[i10] = shortValues[(i6 * 3) + i10];
                                            } else {
                                                this.fVec[i10] = byteValues[(i6 * 3) + i10];
                                            }
                                        }
                                        this.tempVec.f77x = ((this.fVec[0] * this.scaleBias[0]) + this.scaleBias[1]) * f;
                                        this.tempVec.f78y = ((this.fVec[1] * this.scaleBias[0]) + this.scaleBias[2]) * f;
                                        this.tempVec.f79z = ((this.fVec[2] * this.scaleBias[0]) + this.scaleBias[3]) * f;
                                        this.tempVec.f76w = f;
                                        weightedTransform2.positionTransform.transform(this.tempVec);
                                        float[] fArr3 = this.fPositions;
                                        int i11 = i6 * 3;
                                        fArr3[i11] = fArr3[i11] + this.tempVec.f77x;
                                        float[] fArr4 = this.fPositions;
                                        int i12 = (i6 * 3) + 1;
                                        fArr4[i12] = fArr4[i12] + this.tempVec.f78y;
                                        float[] fArr5 = this.fPositions;
                                        int i13 = (i6 * 3) + 2;
                                        fArr5[i13] = fArr5[i13] + this.tempVec.f79z;
                                        int i14 = 0;
                                        while (true) {
                                            int i15 = i14;
                                            if (i15 >= 3) {
                                                break;
                                            }
                                            fArr[i15] = fArr[i15] > this.fPositions[(i6 * 3) + i15] ? fArr[i15] : this.fPositions[(i6 * 3) + i15];
                                            fArr2[i15] = fArr2[i15] < this.fPositions[(i6 * 3) + i15] ? fArr2[i15] : this.fPositions[(i6 * 3) + i15];
                                            i14 = i15 + 1;
                                        }
                                        if (shortValues4 != null) {
                                            for (int i16 = 0; i16 < 3; i16++) {
                                                if (shortValues3 != null) {
                                                    this.fVec[i16] = (shortValues3[(i6 * 3) + i16] + 0.5f) / 32767.5f;
                                                } else {
                                                    this.fVec[i16] = (byteValues2[(i6 * 3) + i16] + 0.5f) / 127.5f;
                                                }
                                            }
                                            this.tempVec.f77x = this.fVec[0] * f;
                                            this.tempVec.f78y = this.fVec[1] * f;
                                            this.tempVec.f79z = this.fVec[2] * f;
                                            this.tempVec.f76w = 0.0f;
                                            weightedTransform2.normalTransform.transform(this.tempVec);
                                            int i17 = i6 * 3;
                                            shortValues4[i17] = (short) (shortValues4[i17] + ((short) Util.roundToInt((this.tempVec.f77x * 32767.5f) - 0.5f)));
                                            int i18 = (i6 * 3) + 1;
                                            shortValues4[i18] = (short) (shortValues4[i18] + ((short) Util.roundToInt((this.tempVec.f78y * 32767.5f) - 0.5f)));
                                            int i19 = (i6 * 3) + 2;
                                            shortValues4[i19] = (short) (shortValues4[i19] + ((short) Util.roundToInt((this.tempVec.f79z * 32767.5f) - 0.5f)));
                                        }
                                    }
                                }
                                i2 -= i8;
                            }
                        } else {
                            int i20 = 0;
                            while (true) {
                                int i21 = i20;
                                if (i21 < 3) {
                                    if (shortValues != null) {
                                        this.fPositions[(i6 * 3) + i21] = shortValues[(i6 * 3) + i21];
                                    } else {
                                        this.fPositions[(i6 * 3) + i21] = (short) (byteValues[(i6 * 3) + i21] * 257);
                                    }
                                    this.fPositions[(i6 * 3) + i21] = (this.fPositions[(i6 * 3) + i21] * this.scaleBias[0]) + this.scaleBias[i21 + 1];
                                    fArr[i21] = fArr[i21] > this.fPositions[(i6 * 3) + i21] ? fArr[i21] : this.fPositions[(i6 * 3) + i21];
                                    fArr2[i21] = fArr2[i21] < this.fPositions[(i6 * 3) + i21] ? fArr2[i21] : this.fPositions[(i6 * 3) + i21];
                                    if (shortValues4 != null) {
                                        if (shortValues3 != null) {
                                            shortValues4[(i6 * 3) + i21] = shortValues3[(i6 * 3) + i21];
                                        } else {
                                            shortValues4[(i6 * 3) + i21] = (short) (byteValues2[(i6 * 3) + i21] * 257);
                                        }
                                    }
                                    i20 = i21 + 1;
                                }
                            }
                        }
                        i6++;
                        i7 = i;
                    }
                    int i22 = 0;
                    float f2 = 0.0f;
                    while (true) {
                        int i23 = i22;
                        if (i23 >= 3) {
                            break;
                        }
                        this.fVec[i23] = (fArr2[i23] + fArr[i23]) / 2.0f;
                        float f3 = (fArr[i23] - fArr2[i23]) / 2.0f;
                        if (f2 <= f3) {
                            f2 = f3;
                        }
                        i22 = i23 + 1;
                    }
                    float f4 = f2 == 0.0f ? 1.0f : f2 / 32767.0f;
                    int i24 = 0;
                    while (true) {
                        int i25 = i24;
                        if (i25 >= vertexCount) {
                            this.morphedVB.setPositions(this.morphedVB.getPositions(null), f4, this.fVec);
                            this.dirtyState = false;
                            return;
                        } else {
                            for (int i26 = 0; i26 < 3; i26++) {
                                shortValues2[(i25 * 3) + i26] = (short) Util.roundToInt((this.fPositions[(i25 * 3) + i26] - this.fVec[i26]) / f4);
                            }
                            i24 = i25 + 1;
                        }
                    }
                } else {
                    WeightedTransform weightedTransform3 = (WeightedTransform) this.transforms.elementAt(i5);
                    if (weightedTransform3.firstVertex < 0 || weightedTransform3.lastVertex >= vertexCount) {
                        break;
                    }
                    weightedTransform3.bone.getTransformTo(this, weightedTransform3.positionTransform);
                    weightedTransform3.positionTransform.mulRight(weightedTransform3.toBone);
                    if (normals != null) {
                        weightedTransform3.normalTransform.set(weightedTransform3.positionTransform);
                        weightedTransform3.normalTransform.invert();
                        weightedTransform3.normalTransform.transpose();
                    }
                    i4 = i5 + 1;
                }
            }
            throw new IllegalStateException();
        }
    }

    @Override // javax.microedition.m3g.Mesh, javax.microedition.m3g.Node
    boolean rayIntersect(int i, float[] fArr, RayIntersection rayIntersection, Transform transform) {
        morph();
        return super.rayIntersect(i, fArr, rayIntersection, transform, this.morphedVB);
    }

    @Override // javax.microedition.m3g.Mesh, javax.microedition.m3g.Node
    void setupRender(Transform transform, Node node, RenderQueue renderQueue) {
        Node parent;
        this.dirtyState = true;
        super.setupRender(transform, node, renderQueue);
        Transform transform2 = new Transform();
        Transform transform3 = new Transform();
        if (this.skeleton != node) {
            transform2.set(transform);
            this.skeleton.getCompositeTransform(transform3);
            transform2.mulRight(transform3);
            this.skeleton.setupRender(transform2, this, renderQueue);
        }
        if (this == renderQueue.getRoot() || (parent = getParent()) == null || parent == node) {
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
        SkinnedMesh skinnedMesh = (SkinnedMesh) getDuplicatedInstance();
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= skinnedMesh.transforms.size()) {
                this.skeleton.updateDuplicateReferences();
                return;
            }
            WeightedTransform weightedTransform = (WeightedTransform) skinnedMesh.transforms.elementAt(i2);
            if (weightedTransform.bone.getDuplicatedInstance() != null) {
                weightedTransform.bone = weightedTransform.bone.getDuplicatedInstance();
            }
            i = i2 + 1;
        }
    }

    void updateVB() {
        VertexBuffer vertexBuffer = getVertexBuffer();
        if (this.morphedVB.getVertexCount() != vertexBuffer.getVertexCount()) {
            VertexArray positions = vertexBuffer.getPositions(this.scaleBias);
            this.fVec[0] = this.scaleBias[1];
            this.fVec[1] = this.scaleBias[2];
            this.fVec[2] = this.scaleBias[3];
            this.morphedVB.setPositions(new VertexArray(positions.getNumEntries(), 3, 2), this.scaleBias[0], this.fVec);
            this.fPositions = new float[positions.getNumEntries() * 3];
        }
        VertexArray normals = vertexBuffer.getNormals();
        if (normals != null && (this.morphedVB.getNormals() == null || normals.getNumComponents() != this.morphedVB.getNormals().getNumComponents())) {
            this.morphedVB.setNormals(new VertexArray(normals.getNumEntries(), 3, 2));
        }
        this.morphedVB.setDefaultColor(vertexBuffer.getDefaultColor());
        this.morphedVB.setColors(vertexBuffer.getColors());
        for (int i = 0; i < Graphics3D.getNumTextureUnits(); i++) {
            if (vertexBuffer.getTexCoords(i, null) != this.morphedVB.getTexCoords(i, null)) {
                VertexArray texCoords = vertexBuffer.getTexCoords(i, this.scaleBias);
                this.fVec[0] = this.scaleBias[1];
                this.fVec[1] = this.scaleBias[2];
                this.fVec[2] = this.scaleBias[3];
                this.morphedVB.setTexCoords(i, texCoords, this.scaleBias[0], this.fVec);
            }
        }
    }
}
