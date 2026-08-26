package p000;

/* JADX INFO: renamed from: ck */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public abstract class AbstractC0065ck {

    /* JADX INFO: renamed from: a */
    private static boolean f446a = true;

    /* JADX INFO: renamed from: f */
    private static AbstractC0065ck f447f = null;

    /* JADX INFO: renamed from: a */
    public AbstractC0065ck f448a = null;

    /* JADX INFO: renamed from: b */
    public AbstractC0065ck f449b = null;

    /* JADX INFO: renamed from: c */
    public AbstractC0065ck f450c = null;

    /* JADX INFO: renamed from: d */
    public AbstractC0065ck f451d = null;

    /* JADX INFO: renamed from: e */
    public AbstractC0065ck f452e = null;

    /* JADX INFO: renamed from: a */
    public abstract int mo74a();

    /* JADX INFO: renamed from: a */
    public final AbstractC0077n m205a() {
        f447f = this;
        return m206a(true);
    }

    /* JADX INFO: renamed from: a */
    public final AbstractC0077n m206a(boolean z) {
        if (f447f == this && !z) {
            return null;
        }
        if (!f446a) {
            if (this.f448a == null) {
                f446a = true;
                return m206a(false);
            }
            if (this.f449b == null) {
                return this.f448a.m206a(false);
            }
            f446a = true;
            return this.f449b.m206a(false);
        }
        if (this instanceof AbstractC0077n) {
            if (!((AbstractC0077n) this).f517a && ((AbstractC0077n) this).m255b()) {
                ((AbstractC0077n) this).m256c();
                return (AbstractC0077n) this;
            }
            ((AbstractC0077n) this).m257d();
        }
        if (this.f451d != null) {
            return this.f451d.m206a(false);
        }
        if (this.f449b != null) {
            return this.f449b.m206a(false);
        }
        if (this.f448a == null) {
            return null;
        }
        f446a = false;
        return this.f448a.m206a(false);
    }

    /* JADX INFO: renamed from: a */
    public void mo75a() {
        for (AbstractC0065ck abstractC0065ck = this.f451d; abstractC0065ck != null; abstractC0065ck = abstractC0065ck.f449b) {
            if (abstractC0065ck.mo78a()) {
                abstractC0065ck.mo75a();
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public abstract void mo76a(int i);

    /* JADX INFO: renamed from: a */
    public void mo77a(C0009ai c0009ai) {
        f446a = true;
        if (c0009ai != null) {
            c0009ai.m55a();
        }
        for (AbstractC0065ck abstractC0065ck = this.f451d; abstractC0065ck != null; abstractC0065ck = abstractC0065ck.f449b) {
            if (abstractC0065ck.mo78a()) {
                abstractC0065ck.mo77a(c0009ai);
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m207a(AbstractC0065ck abstractC0065ck) {
        if (this.f451d == null) {
            abstractC0065ck.f448a = this;
            abstractC0065ck.f450c = null;
            abstractC0065ck.f449b = null;
            this.f451d = abstractC0065ck;
            this.f452e = abstractC0065ck;
            return;
        }
        abstractC0065ck.f448a = this;
        abstractC0065ck.f450c = null;
        abstractC0065ck.f449b = this.f451d;
        this.f451d.f450c = abstractC0065ck;
        this.f451d = abstractC0065ck;
    }

    /* JADX INFO: renamed from: a */
    public abstract boolean mo78a();

    /* JADX INFO: renamed from: b */
    public abstract int mo79b();

    /* JADX INFO: renamed from: b */
    public final AbstractC0077n m208b() {
        f447f = this;
        return m209b(true);
    }

    /* JADX INFO: renamed from: b */
    public final AbstractC0077n m209b(boolean z) {
        if (f447f == this && !z) {
            return null;
        }
        if (!f446a) {
            if (this.f448a == null) {
                f446a = true;
                return m209b(false);
            }
            if (this.f450c == null) {
                return this.f448a.m209b(false);
            }
            f446a = true;
            return this.f450c.m209b(false);
        }
        if (this instanceof AbstractC0077n) {
            if (!((AbstractC0077n) this).f517a && ((AbstractC0077n) this).m255b()) {
                ((AbstractC0077n) this).m256c();
                return (AbstractC0077n) this;
            }
            ((AbstractC0077n) this).m257d();
        }
        if (this.f452e != null) {
            return this.f452e.m209b(false);
        }
        if (this.f450c != null) {
            return this.f450c.m209b(false);
        }
        if (this.f448a == null) {
            return null;
        }
        f446a = false;
        return this.f448a.m209b(false);
    }

    /* JADX INFO: renamed from: b */
    public abstract void mo81b(int i);

    /* JADX INFO: renamed from: b */
    public void mo128b(C0009ai c0009ai) {
        if (c0009ai != null) {
            c0009ai.m58b();
        }
        for (AbstractC0065ck abstractC0065ck = this.f451d; abstractC0065ck != null; abstractC0065ck = abstractC0065ck.f449b) {
            if (abstractC0065ck.mo78a()) {
                abstractC0065ck.mo128b(c0009ai);
            }
        }
    }

    /* JADX INFO: renamed from: c */
    public abstract int mo82c();

    /* JADX INFO: renamed from: d */
    public abstract int mo84d();
}
