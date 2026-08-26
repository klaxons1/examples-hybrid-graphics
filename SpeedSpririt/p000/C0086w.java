package p000;

/* JADX INFO: renamed from: w */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0086w {

    /* JADX INFO: renamed from: a */
    private AbstractC0023aw f551a;

    /* JADX INFO: renamed from: a */
    private AbstractC0027b f552a;

    /* JADX INFO: renamed from: a */
    private AbstractC0038bk f553a = null;

    /* JADX INFO: renamed from: a */
    private C0080q[] f554a = new C0080q[1];

    /* JADX INFO: renamed from: a */
    private boolean[] f555a;

    public C0086w(AbstractC0027b abstractC0027b) {
        this.f554a[0] = new C0080q();
        this.f555a = new boolean[1];
        this.f555a[0] = true;
        this.f552a = abstractC0027b;
    }

    /* JADX INFO: renamed from: a */
    private void m270a(boolean z) {
        C0080q[] c0080qArr = new C0080q[this.f554a.length + 1];
        System.arraycopy(this.f554a, 0, c0080qArr, 0, this.f554a.length);
        c0080qArr[this.f554a.length] = new C0080q();
        this.f554a = c0080qArr;
        boolean[] zArr = new boolean[this.f555a.length + 1];
        System.arraycopy(this.f555a, 0, zArr, 0, this.f555a.length);
        zArr[this.f555a.length] = z;
        this.f555a = zArr;
    }

    /* JADX INFO: renamed from: a */
    public final void m271a() {
        for (int i = 0; i < this.f554a.length; i++) {
            this.f554a[i].m261b();
            if (this.f555a[i]) {
                this.f552a.mo22a();
            }
            this.f554a[i].m259a();
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m272a(int i, AbstractC0048bu abstractC0048bu) {
        this.f554a[i].m260a(abstractC0048bu);
    }

    /* JADX INFO: renamed from: a */
    public final void m273a(AbstractC0023aw abstractC0023aw) {
        if (abstractC0023aw != null) {
            try {
                if (this.f554a == null || this.f553a == null) {
                    return;
                }
                abstractC0023aw.mo21a(false);
                if (this.f551a != null) {
                    this.f551a.mo21a(false);
                } else {
                    this.f553a.mo21a(false);
                }
                abstractC0023aw.mo20a(this.f553a, this);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m274a(AbstractC0038bk abstractC0038bk) {
        this.f553a = abstractC0038bk;
        this.f553a.mo143b();
        this.f551a = this.f553a;
        while (this.f551a.f255a != null) {
            this.f551a = this.f551a.f255a;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m275b() {
        m270a(true);
    }
}
