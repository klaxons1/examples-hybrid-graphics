package javax.microedition.m3g;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class Mesh extends Node {
    private Appearance[] appearances;
    private IndexBuffer[] indexBuffers;
    private Transform transformToCamera = new Transform();
    private VertexBuffer vertexBuffer;

    public Mesh(VertexBuffer vertexBuffer, IndexBuffer indexBuffer, Appearance appearance) {
        this.appearances = null;
        this.indexBuffers = null;
        this.vertexBuffer = null;
        if (vertexBuffer == null || indexBuffer == null) {
            throw new NullPointerException();
        }
        this.vertexBuffer = vertexBuffer;
        this.indexBuffers = new IndexBuffer[1];
        this.appearances = new Appearance[1];
        this.indexBuffers[0] = indexBuffer;
        this.appearances[0] = appearance;
    }

    public Mesh(VertexBuffer vertexBuffer, IndexBuffer[] indexBufferArr, Appearance[] appearanceArr) {
        this.appearances = null;
        this.indexBuffers = null;
        this.vertexBuffer = null;
        if (vertexBuffer == null || indexBufferArr == null) {
            throw new NullPointerException();
        }
        if (indexBufferArr.length == 0 || (appearanceArr != null && appearanceArr.length < indexBufferArr.length)) {
            throw new IllegalArgumentException();
        }
        if (indexBufferArr.length == 0) {
            throw new IllegalArgumentException();
        }
        for (IndexBuffer indexBuffer : indexBufferArr) {
            if (indexBuffer == null) {
                throw new NullPointerException();
            }
        }
        this.vertexBuffer = vertexBuffer;
        this.indexBuffers = new IndexBuffer[indexBufferArr.length];
        this.appearances = new Appearance[indexBufferArr.length];
        System.arraycopy(indexBufferArr, 0, this.indexBuffers, 0, this.indexBuffers.length);
        if (appearanceArr != null) {
            System.arraycopy(appearanceArr, 0, this.appearances, 0, this.indexBuffers.length);
        }
    }

    @Override // javax.microedition.m3g.Object3D
    int applyAnimation(int i) {
        int iApplyAnimation = super.applyAnimation(i);
        int iMin = Math.min(iApplyAnimation, Integer.MAX_VALUE);
        for (int i2 = 0; i2 < this.indexBuffers.length; i2++) {
            if (this.appearances[i2] != null) {
                iApplyAnimation = this.appearances[i2].applyAnimation(i);
            }
            iMin = Math.min(iApplyAnimation, iMin);
        }
        return this.vertexBuffer != null ? Math.min(this.vertexBuffer.applyAnimation(i), iMin) : iMin;
    }

    @Override // javax.microedition.m3g.Object3D
    Object3D createDuplicate() {
        Mesh mesh = new Mesh(this.vertexBuffer, this.indexBuffers, this.appearances);
        mesh.copy((Node) this);
        return mesh;
    }

    @Override // javax.microedition.m3g.Object3D
    int doGetReferences(Object3D[] object3DArr) {
        int iDoGetReferences = super.doGetReferences(object3DArr);
        if (object3DArr != null) {
            object3DArr[iDoGetReferences] = this.vertexBuffer;
        }
        int i = iDoGetReferences + 1;
        for (int i2 = 0; i2 < this.indexBuffers.length; i2++) {
            if (this.indexBuffers[i2] != null) {
                if (object3DArr != null) {
                    object3DArr[i] = this.indexBuffers[i2];
                }
                i++;
            }
            if (this.appearances[i2] != null) {
                if (object3DArr != null) {
                    object3DArr[i] = this.appearances[i2];
                }
                i++;
            }
        }
        return i;
    }

    @Override // javax.microedition.m3g.Node
    void doRender(Graphics3D graphics3D, int i) {
        if (this.indexBuffers[i] == null || this.appearances[i] == null) {
            return;
        }
        graphics3D.render(this.vertexBuffer, this.indexBuffers[i], this.appearances[i], this.transformToCamera, getScope(), getTotalAlphaFactor());
    }

    public Appearance getAppearance(int i) {
        if (i < 0 || i >= this.appearances.length) {
            throw new IndexOutOfBoundsException();
        }
        return this.appearances[i];
    }

    Appearance[] getAppearances() {
        return this.appearances;
    }

    public IndexBuffer getIndexBuffer(int i) {
        if (i < 0 || i >= this.indexBuffers.length) {
            throw new IndexOutOfBoundsException();
        }
        return this.indexBuffers[i];
    }

    IndexBuffer[] getIndexBuffers() {
        return this.indexBuffers;
    }

    public int getSubmeshCount() {
        return this.indexBuffers.length;
    }

    Transform getTransformToCamera() {
        return this.transformToCamera;
    }

    public VertexBuffer getVertexBuffer() {
        return this.vertexBuffer;
    }

    @Override // javax.microedition.m3g.Node
    boolean rayIntersect(int i, float[] fArr, RayIntersection rayIntersection, Transform transform) {
        return rayIntersect(i, fArr, rayIntersection, transform, this.vertexBuffer);
    }

    boolean rayIntersect(int i, float[] fArr, RayIntersection rayIntersection, Transform transform, VertexBuffer vertexBuffer) {
        int i2;
        boolean z;
        float[] fArr2;
        if (vertexBuffer == null || this.appearances == null || this.indexBuffers == null) {
            return false;
        }
        if (vertexBuffer.getPositions(null) == null) {
            throw new IllegalStateException("No vertex positions");
        }
        boolean z2 = false;
        Vec4f vec4f = new Vec4f(fArr[0], fArr[1], fArr[2], 1.0f);
        Vec4f vec4f2 = new Vec4f(fArr[3], fArr[4], fArr[5], 1.0f);
        Transform transform2 = new Transform();
        transform2.set(transform);
        transform2.invert();
        transform2.transform(vec4f);
        transform2.transform(vec4f2);
        vec4f.mul(1.0f / vec4f.f76w);
        vec4f2.mul(1.0f / vec4f2.f76w);
        vec4f2.sub(vec4f);
        Vec4f vec4f3 = new Vec4f();
        Vec4f vec4f4 = new Vec4f();
        Vec4f vec4f5 = new Vec4f();
        Vec4f vec4f6 = new Vec4f();
        Vec4f vec4f7 = new Vec4f();
        Transform transform3 = new Transform();
        int[] iArr = new int[4];
        float[] fArr3 = new float[Graphics3D.getNumTextureUnits()];
        float[] fArr4 = new float[Graphics3D.getNumTextureUnits()];
        float[] fArr5 = null;
        for (int i3 = 0; i3 < this.indexBuffers.length; i3++) {
            if (this.appearances[i3] != null && this.indexBuffers[i3] != null) {
                if (this.appearances[i3].getPolygonMode() != null) {
                    int i4 = this.appearances[i3].getPolygonMode().getWinding() == 168 ? 0 : 1;
                    switch (this.appearances[i3].getPolygonMode().getCulling()) {
                        case PolygonMode.CULL_FRONT /* 161 */:
                            i4 ^= 1;
                            break;
                        case PolygonMode.CULL_NONE /* 162 */:
                            i4 = 2;
                            break;
                    }
                    i2 = i4;
                } else {
                    i2 = 0;
                }
                int i5 = 0;
                while (this.indexBuffers[i3].getIndices(i5, iArr)) {
                    int vertexCount = vertexBuffer.getVertexCount();
                    if (iArr[0] >= vertexCount || iArr[1] >= vertexCount || iArr[2] >= vertexCount) {
                        throw new IllegalStateException(new StringBuffer().append("Index overflow: (").append(iArr[0]).append(", ").append(iArr[1]).append(", ").append(iArr[2]).append(") >=").append(vertexCount).toString());
                    }
                    if (iArr[0] < 0 || iArr[1] < 0 || iArr[2] < 0) {
                        throw new IllegalStateException("Index underflow");
                    }
                    vertexBuffer.getVertex(iArr[0], vec4f3);
                    vertexBuffer.getVertex(iArr[1], vec4f4);
                    vertexBuffer.getVertex(iArr[2], vec4f5);
                    if (!Util.intersectTriangle(vec4f, vec4f2, vec4f3, vec4f4, vec4f5, vec4f7, iArr[3] ^ i2)) {
                        z = z2;
                    } else if (rayIntersection.test(vec4f7.f77x)) {
                        if (vertexBuffer.getNormalVertex(iArr[0], vec4f3)) {
                            vertexBuffer.getNormalVertex(iArr[1], vec4f4);
                            vertexBuffer.getNormalVertex(iArr[2], vec4f5);
                            fArr2 = new float[]{(vec4f3.f77x * (1.0f - (vec4f7.f78y + vec4f7.f79z))) + (vec4f4.f77x * vec4f7.f78y) + (vec4f5.f77x * vec4f7.f79z), (vec4f3.f78y * (1.0f - (vec4f7.f78y + vec4f7.f79z))) + (vec4f4.f78y * vec4f7.f78y) + (vec4f5.f78y * vec4f7.f79z), (vec4f3.f79z * (1.0f - (vec4f7.f78y + vec4f7.f79z))) + (vec4f4.f79z * vec4f7.f78y) + (vec4f5.f79z * vec4f7.f79z)};
                        } else {
                            fArr2 = fArr5;
                        }
                        for (int i6 = 0; i6 < fArr3.length; i6++) {
                            if (vertexBuffer.getTexVertex(iArr[0], i6, vec4f3)) {
                                vertexBuffer.getTexVertex(iArr[1], i6, vec4f4);
                                vertexBuffer.getTexVertex(iArr[2], i6, vec4f5);
                                vec4f6.f77x = (vec4f3.f77x * (1.0f - (vec4f7.f78y + vec4f7.f79z))) + (vec4f4.f77x * vec4f7.f78y) + (vec4f5.f77x * vec4f7.f79z);
                                vec4f6.f78y = (vec4f3.f78y * (1.0f - (vec4f7.f78y + vec4f7.f79z))) + (vec4f4.f78y * vec4f7.f78y) + (vec4f5.f78y * vec4f7.f79z);
                                vec4f6.f79z = 0.0f;
                                vec4f6.f76w = 1.0f;
                                if (this.appearances[i3] != null && this.appearances[i3].getTexture(i6) != null) {
                                    this.appearances[i3].getTexture(i6).getCompositeTransform(transform3);
                                    transform3.transform(vec4f6);
                                    vec4f6.mul(1.0f / vec4f6.f76w);
                                }
                                fArr4[i6] = vec4f6.f77x;
                                fArr3[i6] = vec4f6.f78y;
                            } else {
                                fArr4[i6] = 0.0f;
                                fArr3[i6] = 0.0f;
                            }
                        }
                        if (rayIntersection.fill(vec4f7.f77x, fArr4, fArr3, i3, this, vec4f7.f77x, fArr2)) {
                            z = true;
                            fArr5 = fArr2;
                        } else {
                            fArr5 = fArr2;
                            z = z2;
                        }
                    } else {
                        z = z2;
                    }
                    i5++;
                    z2 = z;
                }
            }
        }
        return z2;
    }

    public void setAppearance(int i, Appearance appearance) {
        if (i < 0 || i >= this.appearances.length) {
            throw new IndexOutOfBoundsException();
        }
        this.appearances[i] = appearance;
    }

    @Override // javax.microedition.m3g.Node
    void setupRender(Transform transform, Node node, RenderQueue renderQueue) {
        if (isVisible(renderQueue.getRoot())) {
            setupTotalAlphaFactor(renderQueue.getRoot());
            this.transformToCamera.set(transform);
            for (int i = 0; i < this.indexBuffers.length; i++) {
                if (this.appearances[i] != null) {
                    if (this.vertexBuffer.getNumVertices() <= this.indexBuffers[i].getMaxIndex()) {
                        throw new IllegalStateException();
                    }
                    renderQueue.insert(this, i, this.appearances[i].getSortKey());
                }
            }
        }
    }
}
