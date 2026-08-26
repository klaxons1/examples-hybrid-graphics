package p000;

import javax.microedition.m3g.Camera;
import javax.microedition.m3g.Transform;

/* JADX INFO: renamed from: r */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0081r extends AbstractC0038bk {

    /* JADX INFO: renamed from: a */
    private static Transform f524a = new Transform();

    /* JADX INFO: renamed from: a */
    public Camera f525a;

    public C0081r(int i, int i2, int i3, int i4, int i5) {
        super(i, i2, i3, i4, i5, "<JSR-Camera>");
    }

    @Override // p000.AbstractC0038bk
    /* JADX INFO: renamed from: b */
    public final void mo143b() {
        if (C0004ad.f29a != null) {
            C0004ad.f29a.setCamera(this.f525a, f524a);
        }
    }

    @Override // p000.AbstractC0038bk
    /* JADX INFO: renamed from: e */
    public final void mo144e(int i, int i2, int i3) {
        float f = 0.8f;
        super.mo144e(i, i2, i3);
        if (this.f525a == null) {
            this.f525a = new Camera();
        }
        if (this.f352d != 0 && this.f353e != 0) {
            f = this.f352d / this.f353e;
        }
        this.f525a.setPerspective(i * 0.087890625f, f, i2, i3);
    }
}
