package p000;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.game.GameCanvas;

/* JADX INFO: renamed from: ba */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0028ba {

    /* JADX INFO: renamed from: a */
    private int f278a;

    /* JADX INFO: renamed from: a */
    public CCMIDlet f279a;

    /* JADX INFO: renamed from: a */
    private C0036bi f280a;

    /* JADX INFO: renamed from: a */
    private Graphics f282a;

    /* JADX INFO: renamed from: a */
    private GameCanvas f284a;

    /* JADX INFO: renamed from: b */
    private int f286b;

    /* JADX INFO: renamed from: a */
    public AbstractC0053bz f281a = null;

    /* JADX INFO: renamed from: a */
    public boolean f285a = false;

    /* JADX INFO: renamed from: a */
    private Image f283a = C0000a.m6b("/content/interface/soft_play.png");

    public C0028ba(CCMIDlet cCMIDlet, GameCanvas gameCanvas, int i, int i2, Graphics graphics, C0036bi c0036bi) {
        this.f279a = cCMIDlet;
        this.f278a = i;
        this.f286b = i2;
        this.f284a = gameCanvas;
        this.f282a = graphics;
        this.f280a = c0036bi;
    }

    /* JADX INFO: renamed from: d */
    private void m121d() {
        int height = this.f283a.getHeight();
        int width = this.f283a.getWidth();
        this.f282a.setColor(0);
        this.f282a.fillRect(0, 0, this.f278a, this.f286b);
        this.f282a.setColor(3959174);
        this.f282a.fillRect(0, 0, this.f278a, this.f286b);
        this.f282a.setColor(9837593);
        this.f282a.fillRect(0, (this.f286b - height) - 1, this.f278a, height + 1);
        this.f282a.fillRect(0, 0, this.f278a, height + 1);
        this.f282a.setColor(14005684);
        this.f282a.fillRect(0, (this.f286b - height) - 2, this.f278a, 1);
        this.f282a.fillRect(0, height + 2, this.f278a, 1);
        this.f282a.setColor(16777215);
        switch (C0036bi.m137a()) {
            case 0:
                this.f282a.drawString("FORTSETZEN", this.f278a >> 1, (this.f286b * 2) / 3, 17);
                break;
            case 1:
                this.f282a.drawString("RESUME", this.f278a >> 1, (this.f286b * 2) / 3, 17);
                break;
            case 2:
                this.f282a.drawString("CONTINUER", this.f278a >> 1, (this.f286b * 2) / 3, 17);
                break;
            case 3:
                this.f282a.drawString("CONTINUARE", this.f278a >> 1, (this.f286b * 2) / 3, 17);
                break;
            case 4:
                this.f282a.drawString("CONTINUAR", this.f278a >> 1, (this.f286b * 2) / 3, 17);
                break;
            case 5:
                this.f282a.drawString("RESUME", this.f278a >> 1, (this.f286b * 2) / 3, 17);
                break;
        }
        this.f282a.drawImage(this.f283a, (this.f278a >> 1) - (width >> 1), (this.f286b - height) - 1, 0);
        this.f284a.flushGraphics();
    }

    /* JADX INFO: renamed from: a */
    public final void m122a() {
        this.f279a.quit();
    }

    /* JADX INFO: renamed from: a */
    public final void m123a(int i) {
        if (this.f285a) {
            m121d();
        } else if (this.f281a != null) {
            if (this.f281a.mo45a()) {
                this.f281a.mo44a(i);
            } else {
                this.f281a.mo43a();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m124a(AbstractC0053bz abstractC0053bz) {
        if (this.f281a != null) {
            this.f281a.mo46b();
        }
        this.f281a = abstractC0053bz;
        if (this.f281a != null) {
            this.f281a.mo43a();
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m125b() {
        if (this.f285a) {
            return;
        }
        this.f285a = true;
        if (this.f281a != null) {
            this.f281a.mo47c();
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m126c() {
        this.f285a = false;
        if (this.f281a != null) {
            this.f281a.mo48d();
        }
    }
}
