package p000;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/* JADX INFO: renamed from: av */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0022av extends AbstractC0051bx {

    /* JADX INFO: renamed from: a */
    private int f249a;

    /* JADX INFO: renamed from: a */
    private Graphics f250a;

    /* JADX INFO: renamed from: a */
    private Image f251a;

    /* JADX INFO: renamed from: b */
    private int f252b;

    /* JADX INFO: renamed from: c */
    private int f253c;

    /* JADX INFO: renamed from: d */
    private int f254d;

    public C0022av(Graphics graphics, String str, int i, int i2, short s, InterfaceC0013am interfaceC0013am) {
        super(interfaceC0013am, s);
        this.f250a = graphics;
        try {
            this.f251a = C0000a.m6b(str);
        } catch (Exception e) {
            this.f251a = null;
        }
        this.f249a = i;
        this.f252b = i2;
        if (this.f251a != null) {
            this.f253c = this.f251a.getWidth();
            this.f254d = this.f251a.getHeight();
        } else {
            this.f254d = 0;
            this.f253c = 0;
        }
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final int mo74a() {
        return this.f254d;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final void mo75a() {
        if (this.f251a != null) {
            try {
                switch (C0039bl.f354a) {
                    case 0:
                        this.f250a.drawImage(this.f251a, this.f249a, this.f252b, 0);
                        break;
                    case 1:
                        this.f250a.drawRegion(this.f251a, 0, 0, this.f251a.getWidth(), this.f251a.getHeight(), 5, this.f249a, this.f252b, 0);
                        break;
                    case 2:
                        this.f250a.drawRegion(this.f251a, 0, 0, this.f251a.getWidth(), this.f251a.getHeight(), 6, this.f249a, this.f252b, 0);
                        break;
                }
            } catch (Exception e) {
            }
        }
        super.mo75a();
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final void mo76a(int i) {
        this.f249a = i;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final boolean mo78a() {
        return true;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: b */
    public final int mo79b() {
        return this.f253c;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: b */
    public final void mo81b(int i) {
        this.f252b = i;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: c */
    public final int mo82c() {
        return this.f249a;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: d */
    public final int mo84d() {
        return this.f252b;
    }
}
