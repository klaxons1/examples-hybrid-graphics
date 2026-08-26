package p000;

import javax.microedition.lcdui.Image;

/* JADX INFO: renamed from: bh */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0035bh extends AbstractC0053bz {

    /* JADX INFO: renamed from: a */
    private long f326a;

    /* JADX INFO: renamed from: a */
    private boolean f328a;

    /* JADX INFO: renamed from: d */
    private Image f331d;

    /* JADX INFO: renamed from: a */
    private Image f327a = null;

    /* JADX INFO: renamed from: b */
    private Image f329b = null;

    /* JADX INFO: renamed from: c */
    private Image f330c = null;

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: a */
    public final void mo43a() {
        if (C0011ak.f157b) {
            C0011ak.f142a.m130a("/content/sound/speed_spirit.mid");
        }
        try {
            switch (C0011ak.f156b) {
                case 1:
                    C0000a.m3a(C0011ak.f158c, C0011ak.f158c);
                    break;
                case 2:
                    C0000a.m3a(C0011ak.f158c, C0011ak.f158c);
                    break;
            }
            this.f327a = C0000a.m2a("/content/interface/FS_preloader.png");
            this.f331d = C0000a.m2a("/content/interface/fish_logo.png");
            this.f330c = C0000a.m2a("/content/interface/abyss_logo.png");
            this.f329b = C0000a.m2a("/content/interface/thq_logo.png");
            C0000a.m3a(C0011ak.f158c, C0011ak.f160d);
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f326a = System.currentTimeMillis();
        this.f328a = true;
    }

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: a */
    public final void mo44a(int i) {
        C0011ak.f146a.setColor(16777215);
        C0011ak.f146a.fillRect(0, 0, C0011ak.f158c, C0011ak.f160d);
        if (System.currentTimeMillis() - this.f326a < 2000) {
            switch (C0011ak.f156b) {
                case 0:
                    C0011ak.f146a.drawImage(this.f329b, (C0011ak.f158c - this.f329b.getWidth()) / 2, (C0011ak.f160d - this.f329b.getHeight()) / 2, 20);
                    break;
                case 1:
                    C0011ak.f146a.drawRegion(this.f329b, 0, 0, this.f329b.getWidth(), this.f329b.getHeight(), 5, (C0011ak.f158c - this.f329b.getHeight()) / 2, (C0011ak.f160d - this.f329b.getWidth()) / 2, 20);
                    break;
                case 2:
                    C0011ak.f146a.drawRegion(this.f329b, 0, 0, this.f329b.getWidth(), this.f329b.getHeight(), 6, (C0011ak.f158c - this.f329b.getHeight()) / 2, (C0011ak.f160d - this.f329b.getWidth()) / 2, 20);
                    break;
            }
        }
        if (System.currentTimeMillis() - this.f326a < 4000) {
            switch (C0011ak.f156b) {
                case 0:
                    C0011ak.f146a.drawImage(this.f330c, (C0011ak.f158c - this.f330c.getWidth()) / 2, (C0011ak.f160d - this.f330c.getHeight()) / 2, 20);
                    break;
                case 1:
                    C0011ak.f146a.drawRegion(this.f330c, 0, 0, this.f330c.getWidth(), this.f330c.getHeight(), 5, (C0011ak.f158c - this.f330c.getHeight()) / 2, (C0011ak.f160d - this.f330c.getWidth()) / 2, 20);
                    break;
                case 2:
                    C0011ak.f146a.drawRegion(this.f330c, 0, 0, this.f330c.getWidth(), this.f330c.getHeight(), 6, (C0011ak.f158c - this.f330c.getHeight()) / 2, (C0011ak.f160d - this.f330c.getWidth()) / 2, 20);
                    break;
            }
        }
        if (System.currentTimeMillis() - this.f326a >= 6000) {
            C0011ak.f141a.m124a(C0011ak.f153a[1]);
            return;
        }
        switch (C0011ak.f156b) {
            case 0:
                C0011ak.f146a.drawImage(this.f327a, (C0011ak.f158c - this.f327a.getWidth()) / 2, (C0011ak.f160d - this.f327a.getHeight()) / 2, 20);
                C0011ak.f146a.drawImage(this.f331d, C0000a.m0a(173) - this.f331d.getWidth(), C0000a.m5b(200) - this.f331d.getHeight(), 20);
                break;
            case 1:
                C0011ak.f146a.drawRegion(this.f327a, 0, 0, this.f327a.getWidth(), this.f327a.getHeight(), 5, (C0011ak.f158c - this.f327a.getWidth()) / 2, (C0011ak.f160d - this.f327a.getHeight()) / 2, 20);
                C0011ak.f146a.drawRegion(this.f331d, 0, 0, this.f331d.getWidth(), this.f331d.getHeight(), 5, 1, ((C0011ak.f158c - this.f331d.getHeight()) / 2) + (this.f327a.getHeight() / 2) + 1, 20);
                break;
            case 2:
                C0011ak.f146a.drawRegion(this.f327a, 0, 0, this.f327a.getWidth(), this.f327a.getHeight(), 6, (C0011ak.f158c - this.f327a.getWidth()) / 2, (C0011ak.f160d - this.f327a.getHeight()) / 2, 20);
                C0011ak.f146a.drawRegion(this.f331d, 0, 0, this.f331d.getWidth(), this.f331d.getHeight(), 6, C0011ak.f158c - this.f331d.getWidth(), ((C0011ak.f160d - this.f327a.getHeight()) / 2) + 2, 20);
                break;
        }
    }

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: a */
    public final boolean mo45a() {
        return this.f328a;
    }

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: b */
    public final void mo46b() {
        this.f327a = null;
        this.f329b = null;
        this.f330c = null;
        this.f331d = null;
        this.f328a = false;
    }

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: c */
    public final void mo47c() {
    }

    @Override // p000.AbstractC0053bz
    /* JADX INFO: renamed from: d */
    public final void mo48d() {
    }
}
