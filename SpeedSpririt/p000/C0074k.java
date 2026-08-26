package p000;

/* JADX INFO: renamed from: k */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0074k {

    /* JADX INFO: renamed from: a */
    private int f492a;

    /* JADX INFO: renamed from: a */
    private C0005ae f493a;

    /* JADX INFO: renamed from: a */
    private int[] f494a;

    /* JADX INFO: renamed from: a */
    private AbstractC0023aw[] f495a;

    /* JADX INFO: renamed from: a */
    public boolean[] f496a;

    /* JADX INFO: renamed from: a */
    private InterfaceC0059ce[][] f497a;

    /* JADX INFO: renamed from: b */
    private int f498b;

    /* JADX INFO: renamed from: c */
    private int f499c;

    /* JADX INFO: renamed from: i */
    private int f505i = 0;

    /* JADX INFO: renamed from: h */
    private int f504h = 0;

    /* JADX INFO: renamed from: g */
    private int f503g = 0;

    /* JADX INFO: renamed from: f */
    private int f502f = 0;

    /* JADX INFO: renamed from: e */
    private int f501e = 0;

    /* JADX INFO: renamed from: d */
    private int f500d = 0;

    public C0074k(AbstractC0023aw[] abstractC0023awArr, int[] iArr, InterfaceC0059ce[][] interfaceC0059ceArr, int i, int i2, int i3) {
        this.f495a = abstractC0023awArr;
        this.f494a = iArr;
        this.f497a = interfaceC0059ceArr;
        this.f492a = i;
        this.f498b = i2;
        this.f499c = i3;
        this.f496a = new boolean[i * i2];
        for (int i4 = 0; i4 < this.f496a.length; i4++) {
            this.f496a[i4] = true;
        }
        this.f493a = new C0005ae();
    }

    /* JADX INFO: renamed from: a */
    public final void m251a(int i, int i2, int i3) {
        this.f500d = ((i - i3) + 2048) >> 12;
        this.f501e = ((i2 - i3) + 2048) >> 12;
        this.f502f = ((i + i3) + 2048) >> 12;
        this.f503g = ((i2 + i3) + 2048) >> 12;
        this.f500d = Math.max(Math.min(this.f500d, this.f492a - 1), 0);
        this.f501e = Math.max(Math.min(this.f501e, this.f498b - 1), 0);
        this.f502f = Math.max(Math.min(this.f502f, this.f492a - 1), 0);
        this.f503g = Math.max(Math.min(this.f503g, this.f498b - 1), 0);
        this.f504h = this.f500d;
        this.f505i = this.f501e;
    }

    /* JADX INFO: renamed from: a */
    public final void m252a(AbstractC0038bk abstractC0038bk, C0086w c0086w) {
        this.f493a = abstractC0038bk.m105b(this.f493a);
        int i = ((this.f493a.f30a + 2048) >> 12) - this.f499c;
        int i2 = ((this.f493a.f32c + 2048) >> 12) - this.f499c;
        for (int i3 = i; i3 <= (this.f499c * 2) + i; i3++) {
            for (int i4 = i2; i4 <= (this.f499c * 2) + i2; i4++) {
                if (i3 >= 0 && i3 < this.f492a && i4 >= 0 && i4 < this.f498b && this.f495a[(this.f492a * i4) + i3] != null) {
                    c0086w.m273a(this.f495a[(this.f492a * i4) + i3]);
                }
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m253a() {
        return this.f504h > this.f502f && this.f505i >= this.f503g;
    }

    /* JADX INFO: renamed from: a */
    public final InterfaceC0059ce[] m254a() {
        InterfaceC0059ce[] interfaceC0059ceArr = this.f497a[this.f494a[this.f504h + (this.f505i * this.f492a)]];
        for (InterfaceC0059ce interfaceC0059ce : interfaceC0059ceArr) {
            interfaceC0059ce.mo70a(this.f504h << 12, this.f505i << 12);
        }
        if (this.f504h != this.f502f || this.f505i >= this.f503g) {
            this.f504h++;
        } else {
            this.f504h = this.f500d;
            this.f505i++;
        }
        return interfaceC0059ceArr;
    }
}
