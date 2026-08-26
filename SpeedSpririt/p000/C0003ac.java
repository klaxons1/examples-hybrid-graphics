package p000;

/* JADX INFO: renamed from: ac */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public class C0003ac extends AbstractC0023aw {

    /* JADX INFO: renamed from: a */
    public AbstractC0023aw f27a;

    public C0003ac() {
        super("<Group>");
        this.f27a = null;
    }

    public C0003ac(String str) {
        super(str);
        this.f27a = null;
    }

    @Override // p000.AbstractC0023aw
    /* JADX INFO: renamed from: a */
    public final String mo18a(String str, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            str = new StringBuffer().append(str).append("  ").toString();
        }
        String string = new StringBuffer().append(str).append(((AbstractC0023aw) this).f258a).append(" |\t").append(((AbstractC0023aw) this).f256a.f454a.f30a).append("\t\t").append(((AbstractC0023aw) this).f256a.f454a.f31b).append("\t\t").append(((AbstractC0023aw) this).f256a.f454a.f32c).append("\t\t").append(((AbstractC0023aw) this).f256a.f453a).append("\n").toString();
        int i3 = i + 1;
        for (AbstractC0023aw abstractC0023aw = this.f27a; abstractC0023aw != null; abstractC0023aw = abstractC0023aw.f260b) {
            string = abstractC0023aw.mo18a(string, i3);
        }
        return string;
    }

    /* JADX INFO: renamed from: a */
    public final void m19a(AbstractC0023aw abstractC0023aw) {
        if (abstractC0023aw != null) {
            abstractC0023aw.f255a = this;
            abstractC0023aw.f260b = this.f27a;
            this.f27a = abstractC0023aw;
        }
    }

    @Override // p000.AbstractC0023aw
    /* JADX INFO: renamed from: a */
    public final void mo20a(AbstractC0038bk abstractC0038bk, C0086w c0086w) {
        if (((AbstractC0023aw) this).f259a && abstractC0038bk.m142a(((AbstractC0023aw) this).f256a)) {
            for (AbstractC0023aw abstractC0023aw = this.f27a; abstractC0023aw != null; abstractC0023aw = abstractC0023aw.f260b) {
                abstractC0023aw.mo20a(abstractC0038bk, c0086w);
            }
        }
    }

    @Override // p000.AbstractC0023aw
    /* JADX INFO: renamed from: a */
    public void mo21a(boolean z) {
        if (this.f263c || z) {
            if (((AbstractC0023aw) this).f262b || z) {
                if (((AbstractC0023aw) this).f255a != null) {
                    ((AbstractC0023aw) this).f261b = ((AbstractC0023aw) ((AbstractC0023aw) this).f255a).f261b.m230a(((AbstractC0023aw) this).f257a, ((AbstractC0023aw) this).f261b);
                } else {
                    ((AbstractC0023aw) this).f261b.m235a(((AbstractC0023aw) this).f257a);
                }
            }
            for (AbstractC0023aw abstractC0023aw = this.f27a; abstractC0023aw != null; abstractC0023aw = abstractC0023aw.f260b) {
                abstractC0023aw.mo21a(((AbstractC0023aw) this).f262b || z);
            }
            ((AbstractC0023aw) this).f256a.m213a(((AbstractC0023aw) this).f261b.m226a(), ((AbstractC0023aw) this).f261b.m239b(), ((AbstractC0023aw) this).f261b.m244c(), 0);
            for (AbstractC0023aw abstractC0023aw2 = this.f27a; abstractC0023aw2 != null; abstractC0023aw2 = abstractC0023aw2.f260b) {
                ((AbstractC0023aw) this).f256a.m214a(abstractC0023aw2.f256a);
            }
            this.f263c = false;
            ((AbstractC0023aw) this).f262b = false;
        }
    }
}
