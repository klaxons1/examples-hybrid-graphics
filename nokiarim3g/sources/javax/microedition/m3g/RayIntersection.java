package javax.microedition.m3g;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class RayIntersection {
    private Camera camera;
    private float[] ray;

    /* JADX INFO: renamed from: x */
    private float f68x;

    /* JADX INFO: renamed from: y */
    private float f69y;
    private float tMin = 3.402E38f;
    private Node root = null;
    private Node intersected = null;
    private float distance = 0.0f;
    private int submeshIndex = 0;
    private float[] textureS = new float[Graphics3D.getNumTextureUnits()];
    private float[] textureT = new float[Graphics3D.getNumTextureUnits()];
    private float[] normal = new float[3];

    public RayIntersection() {
        this.normal[0] = 0.0f;
        this.normal[1] = 0.0f;
        this.normal[2] = 1.0f;
    }

    boolean fill(float f, float[] fArr, float[] fArr2, int i, Node node, float f2, float[] fArr3) {
        if (f <= 0.0f || f >= this.tMin) {
            return false;
        }
        if (fArr == null || fArr2 == null) {
            for (int i2 = 0; i2 < this.textureS.length; i2++) {
                this.textureS[i2] = 0.0f;
                this.textureT[i2] = 0.0f;
            }
        } else {
            for (int i3 = 0; i3 < fArr.length; i3++) {
                this.textureS[i3] = fArr[i3];
                this.textureT[i3] = fArr2[i3];
            }
        }
        this.submeshIndex = i;
        this.distance = f2;
        this.intersected = node;
        if (fArr3 != null) {
            this.normal[0] = fArr3[0];
            this.normal[1] = fArr3[1];
            this.normal[2] = fArr3[2];
            float fSqrt = (float) Math.sqrt((fArr3[0] * fArr3[0]) + (fArr3[1] * fArr3[1]) + (fArr3[2] * fArr3[2]));
            if (fSqrt > 1.0E-5f) {
                float[] fArr4 = this.normal;
                fArr4[0] = fArr4[0] / fSqrt;
                float[] fArr5 = this.normal;
                fArr5[1] = fArr5[1] / fSqrt;
                float[] fArr6 = this.normal;
                fArr6[2] = fArr6[2] / fSqrt;
            } else {
                this.normal[0] = 0.0f;
                this.normal[1] = 0.0f;
                this.normal[2] = 1.0f;
            }
        } else {
            this.normal[0] = 0.0f;
            this.normal[1] = 0.0f;
            this.normal[2] = 1.0f;
        }
        this.tMin = f;
        return true;
    }

    Camera getCamera() {
        return this.camera;
    }

    public float getDistance() {
        return this.distance;
    }

    public Node getIntersected() {
        return this.intersected;
    }

    public float getNormalX() {
        return this.normal[0];
    }

    public float getNormalY() {
        return this.normal[1];
    }

    public float getNormalZ() {
        return this.normal[2];
    }

    float getPickX() {
        return this.f68x;
    }

    float getPickY() {
        return this.f69y;
    }

    public void getRay(float[] fArr) {
        if (fArr.length < 6) {
            throw new IllegalArgumentException();
        }
        if (this.ray != null) {
            fArr[0] = this.ray[0];
            fArr[1] = this.ray[1];
            fArr[2] = this.ray[2];
            fArr[3] = this.ray[3] - this.ray[0];
            fArr[4] = this.ray[4] - this.ray[1];
            fArr[5] = this.ray[5] - this.ray[2];
            return;
        }
        fArr[0] = 0.0f;
        fArr[1] = 0.0f;
        fArr[2] = 0.0f;
        fArr[3] = 0.0f;
        fArr[4] = 0.0f;
        fArr[5] = 1.0f;
    }

    Node getRoot() {
        return this.root;
    }

    public int getSubmeshIndex() {
        return this.submeshIndex;
    }

    public float getTextureS(int i) {
        if (i < 0 || i >= this.textureS.length) {
            throw new IndexOutOfBoundsException();
        }
        return this.textureS[i];
    }

    public float getTextureT(int i) {
        if (i < 0 || i >= this.textureT.length) {
            throw new IndexOutOfBoundsException();
        }
        return this.textureT[i];
    }

    void initPick(Node node, float[] fArr, float f, float f2, Camera camera) {
        this.root = node;
        this.ray = fArr;
        this.f68x = f;
        this.f69y = f2;
        this.camera = camera;
        this.tMin = 3.402E38f;
    }

    boolean test(float f) {
        return f > 0.0f && f < this.tMin;
    }
}
