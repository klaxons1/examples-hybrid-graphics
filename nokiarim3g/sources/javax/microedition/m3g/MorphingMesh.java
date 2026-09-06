package javax.microedition.m3g;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class MorphingMesh extends Mesh {
    private VertexBuffer morphed;
    private VertexArray morphedColors;
    private VertexArray morphedNormals;
    private VertexArray[] morphedTexCoords;
    private VertexArray morphedVertices;
    private int numTargets;
    private float sumWeights;
    private float[] targetBase;
    private VertexArray[] targetVertices;
    private VertexBuffer[] targets;
    private int timestamp;
    private float[] weights;

    public MorphingMesh(VertexBuffer vertexBuffer, VertexBuffer[] vertexBufferArr, IndexBuffer indexBuffer, Appearance appearance) {
        super(vertexBuffer, indexBuffer, appearance);
        this.sumWeights = 1.0f;
        this.targetVertices = null;
        this.targetBase = null;
        this.morphedVertices = null;
        this.morphedNormals = null;
        this.morphedColors = null;
        this.morphedTexCoords = null;
        this.timestamp = -1;
        initTargets(vertexBuffer, vertexBufferArr, new IndexBuffer[]{indexBuffer}, appearance != null ? new Appearance[]{appearance} : null);
    }

    public MorphingMesh(VertexBuffer vertexBuffer, VertexBuffer[] vertexBufferArr, IndexBuffer[] indexBufferArr, Appearance[] appearanceArr) {
        super(vertexBuffer, indexBufferArr, appearanceArr);
        this.sumWeights = 1.0f;
        this.targetVertices = null;
        this.targetBase = null;
        this.morphedVertices = null;
        this.morphedNormals = null;
        this.morphedColors = null;
        this.morphedTexCoords = null;
        this.timestamp = -1;
        initTargets(vertexBuffer, vertexBufferArr, indexBufferArr, appearanceArr);
    }

    private void initTargets(VertexBuffer vertexBuffer, VertexBuffer[] vertexBufferArr, IndexBuffer[] indexBufferArr, Appearance[] appearanceArr) {
        if (vertexBufferArr.length == 0) {
            throw new IllegalArgumentException();
        }
        for (VertexBuffer vertexBuffer2 : vertexBufferArr) {
            if (vertexBuffer2 == null) {
                throw new NullPointerException();
            }
        }
        this.targets = new VertexBuffer[vertexBufferArr.length];
        System.arraycopy(vertexBufferArr, 0, this.targets, 0, vertexBufferArr.length);
        this.numTargets = vertexBufferArr.length;
        this.weights = new float[this.numTargets];
        for (int i = 0; i < this.numTargets; i++) {
            this.weights[i] = 0.0f;
        }
        this.targetVertices = new VertexArray[this.numTargets];
    }

    @Override // javax.microedition.m3g.Mesh, javax.microedition.m3g.Object3D
    int applyAnimation(int i) {
        int iMin = Math.min(super.applyAnimation(i), Integer.MAX_VALUE);
        for (int i2 = 0; i2 < this.targets.length; i2++) {
            if (this.targets[i2] == null) {
                throw new Error();
            }
            iMin = Math.min(this.targets[i2].applyAnimation(i), iMin);
        }
        return iMin;
    }

    @Override // javax.microedition.m3g.Mesh, javax.microedition.m3g.Object3D
    Object3D createDuplicate() {
        MorphingMesh morphingMesh = new MorphingMesh(getVertexBuffer(), this.targets, getIndexBuffers(), getAppearances());
        morphingMesh.copy((Node) this);
        morphingMesh.setWeights(this.weights);
        return morphingMesh;
    }

    void createDuplicates(VertexBuffer vertexBuffer) {
        int length;
        this.morphed = vertexBuffer.duplicateData();
        if (vertexBuffer.getPositions(null) != null) {
            this.morphedVertices = vertexBuffer.getPositions(null).duplicateData();
            length = this.morphedVertices.length();
            this.morphed.setPositions(this.morphedVertices);
        } else {
            this.morphedVertices = null;
            length = 0;
        }
        if (vertexBuffer.getNormals() != null) {
            this.morphedNormals = vertexBuffer.getNormals().duplicateData();
            if (this.morphedNormals.length() > length) {
                length = this.morphedNormals.length();
            }
            this.morphed.setNormals(this.morphedNormals);
        } else {
            this.morphedNormals = null;
        }
        if (vertexBuffer.getColors() != null) {
            this.morphedColors = vertexBuffer.getColors().duplicateData();
            if (this.morphedColors.length() > length) {
                length = this.morphedColors.length();
            }
            this.morphed.setColors(this.morphedColors);
        } else {
            this.morphedColors = null;
        }
        this.morphedTexCoords = new VertexArray[Graphics3D.getNumTextureUnits()];
        for (int i = 0; i < this.morphedTexCoords.length; i++) {
            if (vertexBuffer.getTexCoords(i, null) != null) {
                this.morphedTexCoords[i] = vertexBuffer.getTexCoords(i, null).duplicateData();
                if (this.morphedTexCoords[i].length() > length) {
                    length = this.morphedTexCoords[i].length();
                }
                this.morphed.setTexCoords(i, this.morphedTexCoords[i]);
            } else {
                this.morphedTexCoords[i] = null;
            }
        }
        this.targetBase = new float[length];
    }

    @Override // javax.microedition.m3g.Mesh, javax.microedition.m3g.Object3D
    int doGetReferences(Object3D[] object3DArr) {
        int iDoGetReferences = super.doGetReferences(object3DArr);
        for (int i = 0; i < this.numTargets; i++) {
            if (this.targets[i] != null) {
                if (object3DArr != null) {
                    object3DArr[iDoGetReferences] = this.targets[i];
                }
                iDoGetReferences++;
            }
        }
        return iDoGetReferences;
    }

    @Override // javax.microedition.m3g.Mesh, javax.microedition.m3g.Node
    void doRender(Graphics3D graphics3D, int i) {
        IndexBuffer indexBuffer = getIndexBuffer(i);
        Appearance appearance = getAppearance(i);
        if (indexBuffer == null || appearance == null) {
            return;
        }
        morph(getVertexBuffer());
        graphics3D.render(this.morphed, indexBuffer, appearance, getTransformToCamera(), getScope(), getTotalAlphaFactor());
    }

    public VertexBuffer getMorphTarget(int i) {
        if (i < 0 || i >= this.numTargets) {
            throw new IndexOutOfBoundsException();
        }
        return this.targets[i];
    }

    public int getMorphTargetCount() {
        return this.numTargets;
    }

    public void getWeights(float[] fArr) {
        if (fArr.length < this.numTargets) {
            throw new IllegalArgumentException();
        }
        for (int i = 0; i < this.numTargets; i++) {
            fArr[i] = this.weights[i];
        }
    }

    @Override // javax.microedition.m3g.Node, javax.microedition.m3g.Transformable, javax.microedition.m3g.Object3D
    boolean isCompatible(AnimationTrack animationTrack) {
        switch (animationTrack.getTargetProperty()) {
            case AnimationTrack.MORPH_WEIGHTS /* 266 */:
                return true;
            default:
                return super.isCompatible(animationTrack);
        }
    }

    void morph(VertexBuffer vertexBuffer) {
        if (this.timestamp != vertexBuffer.getTimeStamp()) {
            this.timestamp = vertexBuffer.getTimeStamp();
            createDuplicates(vertexBuffer);
        }
        VertexBuffer vertexBuffer2 = getVertexBuffer();
        if (this.morphedVertices != null) {
            int i = 0;
            for (int i2 = 0; i2 < this.numTargets; i2++) {
                this.targetVertices[i2] = this.targets[i2].getPositions(null);
                if (this.targetVertices[i2] == null) {
                    i++;
                }
            }
            if (i != this.numTargets && i != 0) {
                throw new IllegalStateException();
            }
            if (i == 0) {
                vertexBuffer2.getPositions(null).getFloatValues(this.targetBase);
                this.morphedVertices.morph(this.targetVertices, this.weights, this.targetBase, this.sumWeights);
            } else {
                this.morphedVertices.copyData(vertexBuffer2.getPositions(null));
            }
        } else {
            for (int i3 = 0; i3 < this.numTargets; i3++) {
                if (this.targets[i3].getPositions(null) != null) {
                    throw new IllegalStateException();
                }
            }
        }
        if (this.morphedNormals != null) {
            int i4 = 0;
            for (int i5 = 0; i5 < this.numTargets; i5++) {
                this.targetVertices[i5] = this.targets[i5].getNormals();
                if (this.targetVertices[i5] == null) {
                    i4++;
                }
            }
            if (i4 != this.numTargets && i4 != 0) {
                throw new IllegalStateException();
            }
            if (i4 == 0) {
                vertexBuffer2.getNormals().getFloatValues(this.targetBase);
                this.morphedNormals.morph(this.targetVertices, this.weights, this.targetBase, this.sumWeights);
            } else {
                this.morphedNormals.copyData(vertexBuffer2.getNormals());
            }
        } else {
            for (int i6 = 0; i6 < this.numTargets; i6++) {
                if (this.targets[i6].getNormals() != null) {
                    throw new IllegalStateException();
                }
            }
        }
        if (this.morphedColors != null) {
            int i7 = 0;
            for (int i8 = 0; i8 < this.numTargets; i8++) {
                this.targetVertices[i8] = this.targets[i8].getColors();
                if (this.targetVertices[i8] == null) {
                    i7++;
                }
            }
            if (i7 != this.numTargets && i7 != 0) {
                throw new IllegalStateException();
            }
            if (i7 == 0) {
                vertexBuffer2.getColors().getColorFloatValues(this.targetBase);
                this.morphedColors.morphColors(this.targetVertices, this.weights, this.targetBase, this.sumWeights);
            } else {
                this.morphedColors.copyData(vertexBuffer2.getColors());
            }
        } else {
            for (int i9 = 0; i9 < this.numTargets; i9++) {
                if (this.targets[i9].getColors() != null) {
                    throw new IllegalStateException();
                }
            }
            float defaultColor = this.sumWeights * ((vertexBuffer2.getDefaultColor() >> 24) & 255);
            float defaultColor2 = this.sumWeights * ((vertexBuffer2.getDefaultColor() >> 16) & 255);
            float defaultColor3 = this.sumWeights * ((vertexBuffer2.getDefaultColor() >> 8) & 255);
            float defaultColor4 = (vertexBuffer2.getDefaultColor() & 255) * this.sumWeights;
            for (int i10 = 0; i10 < this.numTargets; i10++) {
                defaultColor += this.weights[i10] * ((this.targets[i10].getDefaultColor() >> 24) & 255);
                defaultColor2 += this.weights[i10] * ((this.targets[i10].getDefaultColor() >> 16) & 255);
                defaultColor3 += this.weights[i10] * ((this.targets[i10].getDefaultColor() >> 8) & 255);
                defaultColor4 += this.weights[i10] * (this.targets[i10].getDefaultColor() & 255);
            }
            this.morphed.setDefaultColor((((((Util.clamp((int) (defaultColor + 0.5f), 0, 255) << 8) | Util.clamp((int) (defaultColor2 + 0.5f), 0, 255)) << 8) | Util.clamp((int) (defaultColor3 + 0.5f), 0, 255)) << 8) | Util.clamp((int) (defaultColor4 + 0.5f), 0, 255));
        }
        for (int i11 = 0; i11 < this.morphedTexCoords.length; i11++) {
            if (this.morphedTexCoords[i11] != null) {
                int i12 = 0;
                for (int i13 = 0; i13 < this.numTargets; i13++) {
                    this.targetVertices[i13] = this.targets[i13].getTexCoords(i11, null);
                    if (this.targetVertices[i13] == null) {
                        i12++;
                    }
                }
                if (i12 != this.numTargets && i12 != 0) {
                    throw new IllegalStateException();
                }
                if (i12 == 0) {
                    vertexBuffer2.getTexCoords(i11, null).getFloatValues(this.targetBase);
                    this.morphedTexCoords[i11].morph(this.targetVertices, this.weights, this.targetBase, this.sumWeights);
                } else {
                    this.morphedTexCoords[i11].copyData(vertexBuffer2.getTexCoords(i11, null));
                }
            } else {
                for (int i14 = 0; i14 < this.numTargets; i14++) {
                    if (this.targets[i14].getTexCoords(i11, null) != null) {
                        throw new IllegalStateException();
                    }
                }
            }
        }
    }

    @Override // javax.microedition.m3g.Mesh, javax.microedition.m3g.Node
    boolean rayIntersect(int i, float[] fArr, RayIntersection rayIntersection, Transform transform) {
        morph(getVertexBuffer());
        return super.rayIntersect(i, fArr, rayIntersection, transform, this.morphed);
    }

    public void setWeights(float[] fArr) {
        if (fArr.length < this.numTargets) {
            throw new IllegalArgumentException();
        }
        this.sumWeights = 1.0f;
        for (int i = 0; i < this.numTargets; i++) {
            this.weights[i] = fArr[i];
            this.sumWeights -= fArr[i];
        }
    }

    @Override // javax.microedition.m3g.Mesh, javax.microedition.m3g.Node
    void setupRender(Transform transform, Node node, RenderQueue renderQueue) {
        super.setupRender(transform, node, renderQueue);
    }

    @Override // javax.microedition.m3g.Node, javax.microedition.m3g.Transformable, javax.microedition.m3g.Object3D
    void updateProperty(int i, float[] fArr) {
        switch (i) {
            case AnimationTrack.MORPH_WEIGHTS /* 266 */:
                this.sumWeights = 1.0f;
                for (int i2 = 0; i2 < this.numTargets; i2++) {
                    if (i2 < fArr.length) {
                        this.weights[i2] = fArr[i2];
                        this.sumWeights -= fArr[i2];
                    } else {
                        this.weights[i2] = 0.0f;
                    }
                }
                break;
            default:
                super.updateProperty(i, fArr);
                break;
        }
    }
}
