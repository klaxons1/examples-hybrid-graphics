package p000;

import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;

/* JADX INFO: renamed from: bj */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0037bj extends AbstractC0077n {

    /* JADX INFO: renamed from: a */
    private int f334a;

    /* JADX INFO: renamed from: a */
    private C0036bi f335a;

    /* JADX INFO: renamed from: a */
    private String f336a;

    /* JADX INFO: renamed from: b */
    private int f337b;

    /* JADX INFO: renamed from: c */
    private int f338c;

    /* JADX INFO: renamed from: d */
    private int f339d;

    /* JADX INFO: renamed from: e */
    private int f340e;

    /* JADX INFO: renamed from: f */
    private int f341f;

    /* JADX INFO: renamed from: g */
    private int f342g;

    public C0037bj(C0036bi c0036bi, int i, int i2, Graphics graphics, InterfaceC0013am interfaceC0013am) {
        super(interfaceC0013am);
        this.f335a = c0036bi;
        this.f334a = i;
        this.f338c = i;
        this.f337b = i2;
    }

    @Override // p000.AbstractC0077n, p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final int mo74a() {
        return this.f342g;
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
                C0049bv.m176a(this.f336a, this.f339d, this.f340e);
                break;
            case 1:
                C0049bv.m179b(this.f336a, this.f339d, this.f340e);
                break;
            case 2:
                C0049bv.m181c(this.f336a, this.f339d, this.f340e);
                break;
        }
        super.mo75a();
    }

    @Override // p000.AbstractC0077n, p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final void mo76a(int i) {
        this.f339d = i;
    }

    @Override // p000.AbstractC0077n, p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final void mo77a(C0009ai c0009ai) {
        Font.getFont(64, 0, 8);
        this.f336a = this.f335a.m138a(this.f338c);
        this.f336a = this.f336a.toUpperCase();
        this.f341f = C0049bv.m172a(this.f336a, 0);
        this.f342g = C0049bv.m170a(0);
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
        return this.f341f;
    }

    @Override // p000.AbstractC0077n
    /* JADX INFO: renamed from: b */
    public final void mo140b() {
        super.mo140b();
        if (this.f338c == this.f334a) {
            this.f338c = this.f337b;
        } else {
            this.f338c = this.f334a;
        }
        this.f336a = this.f335a.m138a(this.f338c);
        this.f336a = this.f336a.toUpperCase();
    }

    @Override // p000.AbstractC0077n, p000.AbstractC0065ck
    /* JADX INFO: renamed from: b */
    public final void mo81b(int i) {
        this.f340e = i;
    }

    @Override // p000.AbstractC0077n, p000.AbstractC0065ck
    /* JADX INFO: renamed from: c */
    public final int mo82c() {
        return this.f339d;
    }

    @Override // p000.AbstractC0077n, p000.AbstractC0065ck
    /* JADX INFO: renamed from: d */
    public final int mo84d() {
        return this.f340e;
    }
}
