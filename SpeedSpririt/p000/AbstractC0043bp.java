package p000;

/* JADX INFO: renamed from: bp */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public abstract class AbstractC0043bp extends AbstractC0023aw {

    /* JADX INFO: renamed from: b */
    public int f374b;

    public AbstractC0043bp() {
        this.f374b = 0;
    }

    public AbstractC0043bp(String str) {
        super(str);
        this.f374b = 0;
    }

    @Override // p000.AbstractC0023aw
    /* JADX INFO: renamed from: a */
    public final String mo18a(String str, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            str = new StringBuffer().append(str).append("  ").toString();
        }
        return new StringBuffer().append(str).append(((AbstractC0023aw) this).f258a).append(" |\t").append(((AbstractC0023aw) this).f256a.f454a.f30a).append("\t\t").append(((AbstractC0023aw) this).f256a.f454a.f31b).append("\t\t").append(((AbstractC0023aw) this).f256a.f454a.f32c).append("\t\t").append(((AbstractC0023aw) this).f256a.f453a).append("\n").toString();
    }

    @Override // p000.AbstractC0023aw
    /* JADX INFO: renamed from: a */
    public void mo21a(boolean z) {
        if (((AbstractC0023aw) this).f262b || z) {
            if (((AbstractC0023aw) this).f255a != null) {
                ((AbstractC0023aw) this).f261b = ((AbstractC0023aw) ((AbstractC0023aw) this).f255a).f261b.m230a(((AbstractC0023aw) this).f257a, ((AbstractC0023aw) this).f261b);
            } else {
                ((AbstractC0023aw) this).f261b.m235a(((AbstractC0023aw) this).f257a);
            }
            int[] iArr = ((AbstractC0023aw) this).f261b.f487a;
            ((AbstractC0023aw) this).f256a.m213a(((AbstractC0023aw) this).f261b.m226a(), ((AbstractC0023aw) this).f261b.m239b(), ((AbstractC0023aw) this).f261b.m244c(), (Math.max(Math.max(Math.abs(iArr[0]), Math.abs(iArr[1])), Math.abs(iArr[2])) * this.f374b) >> 12);
            ((AbstractC0023aw) this).f262b = false;
            this.f263c = false;
        }
    }
}
