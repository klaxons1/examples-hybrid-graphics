package p000;

import javax.microedition.lcdui.Graphics;

/* JADX INFO: renamed from: bb */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0029bb extends AbstractC0065ck {

    /* JADX INFO: renamed from: a */
    private int f287a;

    /* JADX INFO: renamed from: a */
    private C0009ai f288a = null;

    /* JADX INFO: renamed from: a */
    private Graphics f289a;

    /* JADX INFO: renamed from: a */
    private short f290a;

    /* JADX INFO: renamed from: b */
    private int f291b;

    /* JADX INFO: renamed from: c */
    private int f292c;

    /* JADX INFO: renamed from: d */
    private int f293d;

    /* JADX INFO: renamed from: e */
    private int f294e;

    /* JADX INFO: renamed from: f */
    private int f295f;

    /* JADX INFO: renamed from: g */
    private int f296g;

    /* JADX INFO: renamed from: h */
    private int f297h;

    /* JADX INFO: renamed from: i */
    private int f298i;

    /* JADX INFO: renamed from: j */
    private int f299j;

    /* JADX INFO: renamed from: k */
    private int f300k;

    /* JADX INFO: renamed from: l */
    private int f301l;

    /* JADX INFO: renamed from: m */
    private int f302m;

    /* JADX INFO: renamed from: n */
    private int f303n;

    /* JADX INFO: renamed from: o */
    private int f304o;

    /* JADX INFO: renamed from: p */
    private int f305p;

    /* JADX INFO: renamed from: q */
    private int f306q;

    /* JADX INFO: renamed from: r */
    private int f307r;

    public C0029bb(int i, int i2, int i3, int i4, Graphics graphics) {
        this.f294e = i3;
        this.f292c = i3;
        this.f295f = i4;
        this.f293d = i4;
        this.f287a = i;
        this.f291b = i2;
        this.f296g = i2;
        this.f297h = i4 - i;
        this.f289a = graphics;
    }

    /* JADX INFO: renamed from: b */
    private void m127b() {
        int i;
        int i2 = 0;
        AbstractC0065ck abstractC0065ck = super.f451d;
        while (abstractC0065ck != null) {
            if (!abstractC0065ck.mo78a() || !(abstractC0065ck instanceof AbstractC0077n)) {
                i = i2;
            } else {
                if (((AbstractC0077n) abstractC0065ck).f517a) {
                    if (i2 != this.f307r) {
                        this.f299j = this.f303n;
                        this.f300k = this.f304o;
                        this.f301l = this.f305p;
                        this.f302m = this.f306q;
                        switch (C0039bl.f354a) {
                            case 0:
                                this.f303n = abstractC0065ck.mo79b() + 4;
                                this.f304o = abstractC0065ck.mo74a();
                                this.f305p = abstractC0065ck.mo82c() - 2;
                                this.f306q = abstractC0065ck.mo84d() + 2;
                                break;
                            case 1:
                                this.f303n = abstractC0065ck.mo74a();
                                this.f304o = abstractC0065ck.mo79b() + 4;
                                this.f305p = abstractC0065ck.mo82c() - 20;
                                this.f306q = abstractC0065ck.mo84d() - 2;
                                break;
                            case 2:
                                this.f303n = abstractC0065ck.mo74a();
                                this.f304o = abstractC0065ck.mo79b() + 4;
                                this.f305p = abstractC0065ck.mo82c() + 2;
                                this.f306q = (abstractC0065ck.mo84d() - abstractC0065ck.mo79b()) - 3;
                                break;
                        }
                        this.f307r = i2;
                        return;
                    }
                    return;
                }
                i = i2 + 1;
            }
            abstractC0065ck = abstractC0065ck.f449b;
            i2 = i;
        }
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final int mo74a() {
        return this.f293d;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final void mo75a() {
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        m127b();
        this.f301l = this.f305p + ((this.f301l - this.f305p) / 2);
        this.f302m = this.f306q + ((this.f302m - this.f306q) / 2);
        this.f299j = this.f303n + ((this.f299j - this.f303n) / 2);
        this.f300k = this.f304o + ((this.f300k - this.f304o) / 2);
        this.f289a.setColor(16777215);
        this.f289a.drawRoundRect(this.f301l, this.f302m, this.f299j, this.f300k, 2, 2);
        switch (this.f290a) {
            case 1:
                for (AbstractC0065ck abstractC0065ck = super.f451d; abstractC0065ck != null; abstractC0065ck = abstractC0065ck.f449b) {
                    if (abstractC0065ck.mo78a()) {
                        abstractC0065ck.mo75a();
                    }
                }
                break;
            case 2:
                switch (C0039bl.f354a) {
                    case 0:
                        AbstractC0065ck abstractC0065ck2 = super.f451d;
                        int i7 = 1;
                        while (abstractC0065ck2 != null) {
                            if (abstractC0065ck2.mo78a()) {
                                i3 = i7 + 1;
                                abstractC0065ck2.mo76a((i7 * this.f298i) + abstractC0065ck2.mo82c());
                                abstractC0065ck2.mo75a();
                            } else {
                                i3 = i7;
                            }
                            abstractC0065ck2 = abstractC0065ck2.f449b;
                            i7 = i3;
                        }
                        break;
                    case 1:
                        AbstractC0065ck abstractC0065ck3 = super.f451d;
                        int i8 = 1;
                        while (abstractC0065ck3 != null) {
                            if (abstractC0065ck3.mo78a()) {
                                i2 = i8 + 1;
                                abstractC0065ck3.mo81b((i8 * this.f298i) + abstractC0065ck3.mo84d());
                                abstractC0065ck3.mo75a();
                            } else {
                                i2 = i8;
                            }
                            abstractC0065ck3 = abstractC0065ck3.f449b;
                            i8 = i2;
                        }
                        break;
                    case 2:
                        AbstractC0065ck abstractC0065ck4 = super.f451d;
                        int i9 = 1;
                        while (abstractC0065ck4 != null) {
                            if (abstractC0065ck4.mo78a()) {
                                i = i9 + 1;
                                abstractC0065ck4.mo81b(abstractC0065ck4.mo84d() - (i9 * this.f298i));
                                abstractC0065ck4.mo75a();
                            } else {
                                i = i9;
                            }
                            abstractC0065ck4 = abstractC0065ck4.f449b;
                            i9 = i;
                        }
                        break;
                }
                this.f298i <<= 1;
                if (this.f298i > this.f293d) {
                    this.f290a = (short) 1;
                    this.f288a.m58b();
                }
                break;
            case 3:
                switch (C0039bl.f354a) {
                    case 0:
                        AbstractC0065ck abstractC0065ck5 = super.f451d;
                        int i10 = 1;
                        while (abstractC0065ck5 != null) {
                            if (abstractC0065ck5.mo78a()) {
                                i6 = i10 + 1;
                                abstractC0065ck5.mo76a((i10 * this.f298i) + this.f296g);
                                abstractC0065ck5.mo75a();
                            } else {
                                i6 = i10;
                            }
                            abstractC0065ck5 = abstractC0065ck5.f449b;
                            i10 = i6;
                        }
                        break;
                    case 1:
                        AbstractC0065ck abstractC0065ck6 = super.f451d;
                        int i11 = 1;
                        while (abstractC0065ck6 != null) {
                            if (abstractC0065ck6.mo78a()) {
                                i5 = i11 + 1;
                                abstractC0065ck6.mo81b((i11 * this.f298i) + this.f296g);
                                abstractC0065ck6.mo75a();
                            } else {
                                i5 = i11;
                            }
                            abstractC0065ck6 = abstractC0065ck6.f449b;
                            i11 = i5;
                        }
                        break;
                    case 2:
                        AbstractC0065ck abstractC0065ck7 = super.f451d;
                        int i12 = 1;
                        while (abstractC0065ck7 != null) {
                            if (abstractC0065ck7.mo78a()) {
                                i4 = i12 + 1;
                                abstractC0065ck7.mo81b((this.f295f - this.f296g) - (i12 * this.f298i));
                                abstractC0065ck7.mo75a();
                            } else {
                                i4 = i12;
                            }
                            abstractC0065ck7 = abstractC0065ck7.f449b;
                            i12 = i4;
                        }
                        break;
                }
                if (this.f298i == 0) {
                    this.f290a = (short) 1;
                }
                this.f298i >>= 1;
                break;
        }
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final void mo76a(int i) {
        this.f296g = i;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final void mo77a(C0009ai c0009ai) {
        this.f288a = c0009ai;
        this.f293d = 0;
        for (AbstractC0065ck abstractC0065ck = super.f451d; abstractC0065ck != null; abstractC0065ck = abstractC0065ck.f449b) {
            if (abstractC0065ck.mo78a()) {
                abstractC0065ck.mo77a(c0009ai);
                this.f293d += abstractC0065ck.mo74a();
            }
        }
        switch (C0039bl.f354a) {
            case 0:
                this.f296g = this.f291b;
                this.f297h = this.f295f - this.f287a;
                int iMo74a = 0;
                for (AbstractC0065ck abstractC0065ck2 = super.f451d; abstractC0065ck2 != null; abstractC0065ck2 = abstractC0065ck2.f449b) {
                    if (abstractC0065ck2.mo78a()) {
                        abstractC0065ck2.mo81b((this.f297h - this.f293d) + iMo74a);
                        abstractC0065ck2.mo76a(this.f296g);
                        iMo74a += abstractC0065ck2.mo74a();
                    }
                }
                break;
            case 1:
                this.f296g = this.f291b;
                this.f297h = this.f287a;
                int iMo74a2 = 0;
                for (AbstractC0065ck abstractC0065ck3 = super.f452e; abstractC0065ck3 != null; abstractC0065ck3 = abstractC0065ck3.f450c) {
                    if (abstractC0065ck3.mo78a()) {
                        abstractC0065ck3.mo81b(this.f296g);
                        abstractC0065ck3.mo76a(this.f297h + iMo74a2 + 19);
                        iMo74a2 += abstractC0065ck3.mo74a();
                    }
                }
                break;
            case 2:
                this.f296g = this.f291b;
                this.f297h = this.f294e - this.f287a;
                int iMo74a3 = 0;
                for (AbstractC0065ck abstractC0065ck4 = super.f451d; abstractC0065ck4 != null; abstractC0065ck4 = abstractC0065ck4.f449b) {
                    if (abstractC0065ck4.mo78a()) {
                        abstractC0065ck4.mo81b(this.f295f - this.f296g);
                        abstractC0065ck4.mo76a((this.f297h - this.f293d) + iMo74a3);
                        iMo74a3 += abstractC0065ck4.mo74a();
                    }
                }
                break;
        }
        this.f304o = 0;
        this.f303n = 0;
        this.f300k = 0;
        this.f299j = 0;
        switch (C0039bl.f354a) {
            case 0:
                int i = this.f296g;
                this.f305p = i;
                this.f301l = i;
                int i2 = this.f297h;
                this.f306q = i2;
                this.f302m = i2;
                break;
            case 1:
            case 2:
                int i3 = this.f297h;
                this.f305p = i3;
                this.f301l = i3;
                int i4 = this.f296g;
                this.f306q = i4;
                this.f302m = i4;
                break;
        }
        this.f307r = -1;
        this.f298i = this.f293d;
        this.f288a.m55a();
        this.f290a = (short) 3;
        m127b();
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final boolean mo78a() {
        return true;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: b */
    public final int mo79b() {
        return this.f292c;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: b */
    public final void mo81b(int i) {
        this.f297h = i;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: b */
    public final void mo128b(C0009ai c0009ai) {
        for (AbstractC0065ck abstractC0065ck = super.f451d; abstractC0065ck != null; abstractC0065ck = abstractC0065ck.f449b) {
            if (abstractC0065ck.mo78a()) {
                abstractC0065ck.mo128b(c0009ai);
            }
        }
        this.f298i = 1;
        this.f290a = (short) 2;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: c */
    public final int mo82c() {
        return this.f296g;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: d */
    public final int mo84d() {
        return this.f297h;
    }
}
