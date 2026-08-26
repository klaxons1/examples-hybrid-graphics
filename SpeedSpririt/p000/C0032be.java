package p000;

import javax.microedition.lcdui.Graphics;

/* JADX INFO: renamed from: be */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0032be extends AbstractC0077n {

    /* JADX INFO: renamed from: a */
    private int f311a;

    /* JADX INFO: renamed from: a */
    private String f312a;

    /* JADX INFO: renamed from: a */
    private Graphics f313a;

    /* JADX INFO: renamed from: b */
    private int f314b;

    /* JADX INFO: renamed from: b */
    private String f315b;

    /* JADX INFO: renamed from: b */
    private boolean f316b;

    /* JADX INFO: renamed from: c */
    private int f317c;

    /* JADX INFO: renamed from: d */
    private int f318d;

    /* JADX INFO: renamed from: e */
    private int f319e;

    public C0032be(String str, String str2, int i, Graphics graphics, InterfaceC0013am interfaceC0013am) {
        super(interfaceC0013am);
        this.f313a = graphics;
        this.f312a = str;
        this.f315b = str2;
        this.f316b = true;
        this.f311a = i;
    }

    /* JADX INFO: renamed from: a */
    private void m133a(String str, String str2) {
        int clipHeight;
        this.f312a = str;
        this.f315b = str2;
        this.f312a = this.f312a.toUpperCase();
        this.f315b = this.f315b.toUpperCase();
        int iM171a = C0049bv.m171a(this.f312a);
        switch (C0076m.f515a) {
            case 0:
                clipHeight = ((this.f313a.getClipWidth() - C0049bv.m171a("99:99:99")) - (this.f311a * 2)) - C0049bv.m171a("  ");
                break;
            case 1:
                clipHeight = ((this.f313a.getClipHeight() - C0049bv.m171a("99:99:99")) - (this.f311a * 2)) - C0049bv.m171a("  ");
                break;
            case 2:
                clipHeight = ((this.f313a.getClipHeight() - C0049bv.m171a("99:99:99")) - (this.f311a * 2)) - C0049bv.m171a("  ");
                break;
            default:
                clipHeight = 0;
                break;
        }
        while (iM171a > clipHeight) {
            this.f312a = this.f312a.substring(0, this.f312a.length() - 1);
            iM171a = C0049bv.m171a(new StringBuffer().append(this.f312a).append("...").toString());
            if (iM171a < clipHeight) {
                this.f312a = new StringBuffer().append(this.f312a).append("...").toString();
            }
        }
    }

    @Override // p000.AbstractC0077n, p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final int mo74a() {
        return this.f319e;
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
                C0049bv.m176a(this.f312a, this.f314b, this.f317c);
                C0049bv.m176a(this.f315b, (this.f313a.getClipWidth() - this.f314b) - C0049bv.m171a(this.f315b), this.f317c);
                break;
            case 1:
                C0049bv.m179b(this.f312a, this.f314b, this.f317c);
                C0049bv.m179b(this.f315b, this.f314b, (this.f313a.getClipHeight() - this.f317c) - C0049bv.m171a(this.f315b));
                break;
            case 2:
                C0049bv.m181c(this.f312a, this.f314b, this.f317c);
                C0049bv.m181c(this.f315b, this.f314b, (this.f313a.getClipHeight() - this.f317c) + C0049bv.m171a(this.f315b));
                break;
        }
        super.mo75a();
    }

    @Override // p000.AbstractC0077n, p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final void mo76a(int i) {
        if (this.f314b == i || C0076m.f515a != 0) {
            this.f314b = i;
        } else {
            this.f314b = i;
            m133a(this.f312a, this.f315b);
        }
    }

    @Override // p000.AbstractC0077n, p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final void mo77a(C0009ai c0009ai) {
        this.f312a = this.f312a.toUpperCase();
        this.f315b = this.f315b.toUpperCase();
        switch (C0076m.f515a) {
            case 0:
                this.f318d = this.f313a.getClipWidth() - (this.f311a * 2);
                break;
            case 1:
            case 2:
                this.f318d = this.f313a.getClipHeight() - (this.f311a * 2);
                break;
        }
        this.f319e = C0049bv.m169a();
        super.mo77a(c0009ai);
    }

    @Override // p000.AbstractC0077n, p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final boolean mo78a() {
        return this.f316b;
    }

    @Override // p000.AbstractC0077n, p000.AbstractC0065ck
    /* JADX INFO: renamed from: b */
    public final int mo79b() {
        return this.f318d;
    }

    @Override // p000.AbstractC0077n, p000.AbstractC0065ck
    /* JADX INFO: renamed from: b */
    public final void mo81b(int i) {
        if (this.f317c == i || !(C0076m.f515a == 1 || C0076m.f515a == 2)) {
            this.f317c = i;
        } else {
            this.f317c = i;
            m133a(this.f312a, this.f315b);
        }
    }

    @Override // p000.AbstractC0077n, p000.AbstractC0065ck
    /* JADX INFO: renamed from: c */
    public final int mo82c() {
        return this.f314b;
    }

    @Override // p000.AbstractC0077n, p000.AbstractC0065ck
    /* JADX INFO: renamed from: d */
    public final int mo84d() {
        return this.f317c;
    }
}
