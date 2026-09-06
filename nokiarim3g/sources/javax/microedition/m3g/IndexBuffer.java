package javax.microedition.m3g;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public abstract class IndexBuffer extends Object3D {
    IndexBuffer() {
    }

    abstract void draw();

    abstract boolean getIndices(int i, int[] iArr);

    abstract int getMaxIndex();
}
