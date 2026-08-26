package p000;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public class CCMIDlet extends MIDlet implements Runnable {

    /* JADX INFO: renamed from: a */
    private boolean f2a = false;
    public boolean paused = false;

    /* JADX INFO: renamed from: b */
    private boolean f3b = false;
    public boolean goToPauseFlag = false;
    public boolean goToResumeFlag = false;

    /* JADX INFO: renamed from: a */
    private Display f1a = Display.getDisplay(this);
    public C0052by canvas = new C0052by(this);

    /* JADX INFO: renamed from: a */
    private Thread f0a = new Thread(this);

    public CCMIDlet() {
        C0002ab.f9a = Display.getDisplay(this);
    }

    public void destroyApp(boolean z) {
        this.paused = true;
        this.f3b = true;
        C0052by.m187c();
        notifyDestroyed();
    }

    public void pauseApp() {
        C0052by.m186b();
    }

    public void quit() {
        destroyApp(false);
    }

    @Override // java.lang.Runnable
    public void run() {
        while (!this.f3b) {
            this.canvas.m189a();
            try {
                Thread.sleep(2L);
            } catch (InterruptedException e) {
            }
            if (!this.paused) {
                this.canvas.m190d();
            }
        }
    }

    public void startApp() {
        this.f1a.setCurrent(this.canvas);
        if (!this.f3b) {
            if (this.f2a) {
                return;
            }
            this.f0a = new Thread(this);
            this.f0a.start();
            this.f2a = true;
            return;
        }
        this.f3b = false;
        this.paused = false;
        if (C0011ak.f141a != null && C0011ak.f141a.f281a != null) {
            C0011ak.f141a.f281a.mo48d();
        }
        if (this.f0a == null) {
            this.f0a = new Thread(this);
            this.f0a.start();
        }
    }
}
