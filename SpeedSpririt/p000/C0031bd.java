package p000;

import java.io.InputStream;
import javax.microedition.media.Manager;
import javax.microedition.media.Player;

/* JADX INFO: renamed from: bd */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0031bd {

    /* JADX INFO: renamed from: a */
    public Player f309a;

    /* JADX INFO: renamed from: b */
    public Player f310b;

    /* JADX INFO: renamed from: a */
    public final void m129a() {
        try {
            if (this.f309a.getState() == 400) {
                this.f309a.stop();
                this.f309a.deallocate();
                this.f309a.close();
            }
            if (this.f310b.getState() == 400) {
                this.f310b.stop();
                this.f310b.deallocate();
                this.f310b.close();
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m130a(String str) {
        try {
            InputStream resourceAsStream = getClass().getResourceAsStream(str);
            this.f309a = Manager.createPlayer(resourceAsStream, "audio/midi");
            this.f309a.setLoopCount(-1);
            this.f309a.start();
            resourceAsStream.close();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m131b() {
        try {
            this.f309a.stop();
        } catch (Exception e) {
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m132c() {
        try {
            if (C0011ak.f157b) {
                System.out.println("resume:Sound");
                this.f309a.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.f309a.deallocate();
            this.f309a.close();
            this.f309a = null;
        }
    }
}
