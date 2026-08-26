package p000;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/* JADX INFO: renamed from: aq */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0017aq extends AbstractC0065ck {

    /* JADX INFO: renamed from: a */
    public static Image f201a;

    /* JADX INFO: renamed from: a */
    private int f202a;

    /* JADX INFO: renamed from: a */
    private C0036bi f203a;

    /* JADX INFO: renamed from: a */
    private Graphics f205a;

    /* JADX INFO: renamed from: a */
    private String[] f206a;

    /* JADX INFO: renamed from: f */
    private int f211f;

    /* JADX INFO: renamed from: g */
    private int f212g;

    /* JADX INFO: renamed from: h */
    private int f213h;

    /* JADX INFO: renamed from: i */
    private int f214i;

    /* JADX INFO: renamed from: j */
    private int f215j;

    /* JADX INFO: renamed from: k */
    private int f216k;

    /* JADX INFO: renamed from: m */
    private int f218m;

    /* JADX INFO: renamed from: l */
    private int f217l = 0;

    /* JADX INFO: renamed from: b */
    private int f207b = 0;

    /* JADX INFO: renamed from: c */
    private int f208c = 0;

    /* JADX INFO: renamed from: d */
    private int f209d = 0;

    /* JADX INFO: renamed from: e */
    private int f210e = 0;

    /* JADX INFO: renamed from: a */
    private String f204a = null;

    public C0017aq(Graphics graphics, C0036bi c0036bi, int i, int i2, int i3, int i4, int i5, int i6) {
        this.f205a = graphics;
        this.f203a = c0036bi;
        this.f202a = i;
        this.f213h = i2;
        this.f214i = i3;
        this.f215j = i4;
        this.f211f = i5;
        this.f212g = i6;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final int mo74a() {
        return this.f210e;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final void mo75a() {
        this.f205a.setColor(8716296);
        this.f205a.fillRect(this.f207b, this.f208c, this.f209d, this.f210e);
        this.f205a.setColor(14005684);
        this.f205a.drawRect(this.f207b, this.f208c, this.f209d, this.f210e);
        C0049bv.m173a(0);
        switch (C0039bl.f354a) {
            case 0:
                int i = this.f217l;
                int i2 = 0;
                while (i < this.f216k + this.f217l && i < this.f206a.length) {
                    C0049bv.m176a(this.f206a[i], this.f207b + 10, (i2 * this.f218m) + this.f208c + 10);
                    i++;
                    i2++;
                }
                if (f201a != null && this.f206a.length > this.f216k) {
                    this.f205a.drawImage(f201a, (this.f209d + this.f207b) - 15, (this.f210e + this.f208c) - 15, 0);
                }
                break;
            case 1:
                int i3 = this.f217l;
                int i4 = 0;
                while (i3 < this.f216k + this.f217l && i3 < this.f206a.length) {
                    C0049bv.m179b(this.f206a[i3], ((this.f211f - this.f214i) - (i4 * this.f218m)) - 10, this.f213h + 10);
                    i3++;
                    i4++;
                }
                if (f201a != null && this.f206a.length > this.f216k) {
                    this.f205a.drawRegion(f201a, 0, 0, f201a.getWidth(), f201a.getHeight(), 5, this.f207b + 5, (this.f210e + this.f208c) - 15, 0);
                }
                break;
            case 2:
                int i5 = this.f217l;
                int i6 = 0;
                while (i5 < this.f216k + this.f217l && i5 < this.f206a.length) {
                    C0049bv.m181c(this.f206a[i5], (i6 * this.f218m) + this.f214i + 10, (this.f212g - this.f213h) - 10);
                    i5++;
                    i6++;
                }
                if (f201a != null && this.f206a.length > this.f216k) {
                    this.f205a.drawRegion(f201a, 0, 0, f201a.getWidth(), f201a.getHeight(), 5, (this.f209d + this.f207b) - 15, this.f208c + 5, 0);
                }
                break;
        }
        super.mo75a();
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final void mo76a(int i) {
        this.f207b = i;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final void mo77a(C0009ai c0009ai) {
        int i;
        int i2;
        int i3;
        int i4;
        this.f218m = C0049bv.m169a();
        String strM138a = this.f204a;
        if (this.f202a != -1) {
            strM138a = this.f203a.m138a(this.f202a);
        }
        switch (C0039bl.f354a) {
            case 0:
                this.f209d = this.f211f - (this.f213h << 1);
                this.f210e = (this.f212g - this.f214i) - this.f215j;
                this.f207b = this.f213h;
                this.f208c = this.f214i;
                i = this.f209d;
                i2 = this.f210e;
                break;
            case 1:
                this.f209d = (this.f211f - this.f214i) - this.f215j;
                this.f210e = this.f212g - (this.f213h << 1);
                this.f207b = this.f215j;
                this.f208c = this.f213h;
                i = this.f210e;
                i2 = this.f209d;
                break;
            case 2:
                this.f209d = (this.f211f - this.f214i) - this.f215j;
                this.f210e = this.f212g - (this.f213h << 1);
                this.f207b = this.f214i;
                this.f208c = this.f213h;
                i = this.f210e;
                i2 = this.f209d;
                break;
            default:
                i2 = 0;
                i = 0;
                break;
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        for (int i8 = 0; i8 < strM138a.length(); i8++) {
            if (strM138a.charAt(i8) == '\n' || strM138a.charAt(i8) == '\r') {
                i5++;
                i6 = i8 + 1;
                i7 = i8 + 1;
            } else {
                if (C0049bv.m171a(strM138a.substring(i6, i8)) > i - 20) {
                    i5++;
                    if (i6 < i7) {
                        i6 = i7 + 1;
                        i4 = i7;
                    } else {
                        int i9 = i8 - 1;
                        i6 = i9;
                        i4 = i9;
                    }
                } else {
                    i4 = i7;
                }
                i7 = strM138a.charAt(i8) == ' ' ? i8 : i4;
            }
        }
        this.f206a = new String[i5 + 1];
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        for (int i13 = 0; i13 < strM138a.length(); i13++) {
            if (strM138a.charAt(i13) == '\n' || strM138a.charAt(i13) == '\r') {
                this.f206a[i10] = strM138a.substring(i11, i13);
                i11 = i13 + 1;
                i12 = i13 + 1;
                i10++;
            } else {
                if (C0049bv.m171a(strM138a.substring(i11, i13)) <= i - 20) {
                    i3 = i12;
                } else if (i11 < i12) {
                    this.f206a[i10] = strM138a.substring(i11, i12);
                    i11 = i12 + 1;
                    i10++;
                    i3 = i12;
                } else {
                    this.f206a[i10] = strM138a.substring(i11, i13 - 1);
                    int i14 = i13 - 1;
                    i10++;
                    i11 = i14;
                    i3 = i14;
                }
                i12 = strM138a.charAt(i13) == ' ' ? i13 : i3;
            }
        }
        this.f206a[i10] = strM138a.substring(i11, strM138a.length());
        this.f216k = (i2 - 20) / this.f218m;
        this.f217l = 0;
        if (c0009ai != null) {
            c0009ai.f122a = this;
        }
        super.mo77a(c0009ai);
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public final boolean mo78a() {
        return true;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: b */
    public final int mo79b() {
        return this.f209d;
    }

    /* JADX INFO: renamed from: b */
    public final void m80b() {
        if (this.f217l < this.f206a.length - this.f216k) {
            this.f217l += this.f216k;
        }
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: b */
    public final void mo81b(int i) {
        this.f208c = i;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: c */
    public final int mo82c() {
        return this.f207b;
    }

    /* JADX INFO: renamed from: c */
    public final void m83c() {
        this.f217l -= this.f216k;
        if (this.f217l < 0) {
            this.f217l = 0;
        }
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: d */
    public final int mo84d() {
        return this.f208c;
    }
}
