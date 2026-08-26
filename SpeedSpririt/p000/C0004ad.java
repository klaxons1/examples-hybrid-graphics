package p000;

import javax.microedition.lcdui.Graphics;
import javax.microedition.m3g.Background;
import javax.microedition.m3g.Graphics3D;

/* JADX INFO: renamed from: ad */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0004ad extends AbstractC0027b {

    /* JADX INFO: renamed from: a */
    private static Background f28a;

    /* JADX INFO: renamed from: a */
    public static Graphics3D f29a;

    public C0004ad() {
        f29a = Graphics3D.getInstance();
        if (f28a == null) {
            f28a = new Background();
            f28a.setColorClearEnable(false);
            f28a.setDepthClearEnable(true);
        }
    }

    @Override // p000.AbstractC0027b
    /* JADX INFO: renamed from: a */
    public final void mo22a() {
        try {
            f29a.clear(f28a);
        } catch (Exception e) {
        }
    }

    @Override // p000.AbstractC0027b
    /* JADX INFO: renamed from: a */
    public final void mo23a(Graphics graphics) {
        try {
            f29a.bindTarget(graphics);
        } catch (Exception e) {
            f29a.releaseTarget();
        }
    }

    @Override // p000.AbstractC0027b
    /* JADX INFO: renamed from: b */
    public final void mo24b() {
        f29a.releaseTarget();
    }
}
