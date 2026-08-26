package p000;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;

/* JADX INFO: renamed from: o */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class RunnableC0078o implements Runnable {

    /* JADX INFO: renamed from: a */
    public static int f518a;

    /* JADX INFO: renamed from: a */
    private Graphics f519a;

    /* JADX INFO: renamed from: a */
    private GameCanvas f520a;

    /* JADX INFO: renamed from: a */
    public boolean f521a = false;

    /* JADX INFO: renamed from: a */
    private void m258a() {
        System.out.println(new StringBuffer().append("loading thread ...").append(System.currentTimeMillis()).toString());
        this.f519a.setColor(255, 255, 255);
        this.f519a.fillRect(0, 0, 176, 220);
        this.f519a.setColor(0);
        this.f519a.drawString(new StringBuffer().append("Mem: ").append(Runtime.getRuntime().freeMemory()).toString(), 80, 80, 0);
        this.f519a.drawString(new StringBuffer().append("Step: ").append(f518a).toString(), 80, 100, 0);
    }

    @Override // java.lang.Runnable
    public final void run() {
        while (this.f521a) {
            m258a();
            if (this.f520a != null) {
                this.f520a.flushGraphics();
            }
            try {
                Thread.sleep(500L);
            } catch (Exception e) {
                this.f521a = false;
            }
        }
    }
}
