package javax.microedition.m3g;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
class TextureImage2D {
    byte[] pixels;

    TextureImage2D(byte[] bArr) {
        this.pixels = null;
        if (bArr == null) {
            throw new Error("null pixels!");
        }
        this.pixels = bArr;
    }

    void setImage(byte[] bArr) {
        if (bArr == null) {
            throw new Error("null pixels!");
        }
        this.pixels = bArr;
    }
}
