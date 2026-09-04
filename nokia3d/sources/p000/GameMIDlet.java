package p000;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

/* JADX INFO: loaded from: C:\Temp\jadx-5247753011597502155\classes.dex */
public class GameMIDlet extends MIDlet implements Runnable {
    private static Thread m_thread;
    private boolean m_running = false;
    private boolean m_firstRun = true;
    private boolean m_requestExit = false;
    private boolean m_exitApplication = false;
    private Nokia3D m_gameMode = new Nokia3D(this);
    private Display m_display = Display.getDisplay(this);

    public void startApp() {
        if (this.m_firstRun) {
            this.m_gameMode.startApp(false);
            this.m_display.setCurrent(this.m_gameMode);
            this.m_firstRun = false;
        } else {
            this.m_gameMode.startApp(true);
        }
        this.m_running = true;
        m_thread = new Thread(this);
        m_thread.start();
    }

    public void pauseApp() {
    }

    public void destroyApp(boolean z) {
        try {
            this.m_running = false;
            if (m_thread != null) {
                m_thread.join();
            }
        } catch (Exception e) {
        }
        notifyDestroyed();
    }

    @Override // java.lang.Runnable
    public void run() {
        while (this.m_running) {
            try {
                this.m_gameMode.executeOnce();
                Thread.sleep(10L);
            } catch (Exception e) {
            }
        }
    }
}
