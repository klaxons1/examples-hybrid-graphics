package p000;

import javax.microedition.lcdui.Graphics;

/* JADX INFO: renamed from: bo */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0042bo extends AbstractC0077n {

    /* JADX INFO: renamed from: a */
    private int f367a;

    /* JADX INFO: renamed from: a */
    private C0036bi f368a;

    /* JADX INFO: renamed from: a */
    private String f369a;

    /* JADX INFO: renamed from: b */
    private int f370b;

    /* JADX INFO: renamed from: c */
    private int f371c;

    /* JADX INFO: renamed from: d */
    private int f372d;

    /* JADX INFO: renamed from: e */
    private int f373e;

    public C0042bo(C0036bi c0036bi, int i, Graphics graphics, InterfaceC0013am interfaceC0013am) {
        super(interfaceC0013am);
        this.f368a = c0036bi;
        this.f367a = i;
    }

    public C0042bo(String str, Graphics graphics, InterfaceC0013am interfaceC0013am) {
        super(interfaceC0013am);
        this.f367a = -1;
        this.f369a = str;
    }

    @Override // p000.AbstractC0077n, p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final int mo74a() {
        return this.f373e;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final void mo75a() {
        if (((AbstractC0077n) this).f517a) {
            C0049bv.m173a(1);
        } else if (((AbstractC0077n) this).f516a.mo8a()) {
            C0049bv.m173a(0);
        } else {
            C0049bv.m173a(2);
        }
        switch (C0039bl.f354a) {
            case 0:
                C0049bv.m176a(this.f369a, this.f370b, this.f371c);
                break;
            case 1:
                C0049bv.m179b(this.f369a, this.f370b, this.f371c);
                break;
            case 2:
                C0049bv.m181c(this.f369a, this.f370b, this.f371c);
                break;
        }
        super.mo75a();
    }

    @Override // p000.AbstractC0077n, p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final void mo76a(int i) {
        this.f370b = i;
    }

    @Override // p000.AbstractC0077n, p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final void mo77a(C0009ai c0009ai) {
        if (this.f367a != -1) {
            this.f369a = this.f368a.m138a(this.f367a);
        }
        this.f369a = this.f369a.toUpperCase();
        this.f372d = C0049bv.m171a(this.f369a);
        this.f373e = C0049bv.m169a();
        super.mo77a(c0009ai);
    }

    @Override // p000.AbstractC0077n, p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final boolean mo78a() {
        return true;
    }

    @Override // p000.AbstractC0077n, p000.AbstractC0065ck
    /* JADX INFO: renamed from: b */
    public final int mo79b() {
        return this.f372d;
    }

    @Override // p000.AbstractC0077n, p000.AbstractC0065ck
    /* JADX INFO: renamed from: b */
    public final void mo81b(int i) {
        this.f371c = i;
    }

    @Override // p000.AbstractC0077n, p000.AbstractC0065ck
    /* JADX INFO: renamed from: c */
    public final int mo82c() {
        return this.f370b;
    }

    @Override // p000.AbstractC0077n, p000.AbstractC0065ck
    /* JADX INFO: renamed from: d */
    public final int mo84d() {
        return this.f371c;
    }
}
