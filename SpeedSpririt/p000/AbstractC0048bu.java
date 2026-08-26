package p000;

/* JADX INFO: renamed from: bu */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public abstract class AbstractC0048bu extends AbstractC0043bp {

    /* JADX INFO: renamed from: a */
    public int f388a;

    /* JADX INFO: renamed from: c */
    public C0073j f389c;

    public AbstractC0048bu() {
        this.f389c = new C0073j();
        this.f388a = 0;
    }

    public AbstractC0048bu(String str) {
        super(str);
        this.f389c = new C0073j();
        this.f388a = 0;
    }

    /* JADX INFO: renamed from: a */
    public static AbstractC0048bu m166a(String str, String str2) {
        return new C0025ay(str, str2);
    }

    /* JADX INFO: renamed from: a */
    public static AbstractC0048bu m167a(String str, String str2, int i) {
        return new C0067d(str, str2, i);
    }

    /* JADX INFO: renamed from: a */
    public abstract AbstractC0023aw mo117a();

    @Override // p000.AbstractC0023aw
    /* JADX INFO: renamed from: a */
    public void mo20a(AbstractC0038bk abstractC0038bk, C0086w c0086w) {
        if (((AbstractC0023aw) this).f259a && abstractC0038bk.m142a(((AbstractC0023aw) this).f256a)) {
            this.f389c = ((AbstractC0023aw) abstractC0038bk).f261b.m229a(this.f389c);
            this.f389c.m243b(((AbstractC0023aw) this).f261b);
            c0086w.m272a(this.f388a, this);
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo118a(AbstractC0085v abstractC0085v);

    /* JADX INFO: renamed from: b */
    public abstract void mo119b();

    /* JADX INFO: renamed from: c */
    public void mo168c() {
    }
}
