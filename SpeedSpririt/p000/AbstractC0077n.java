package p000;

/* JADX INFO: renamed from: n */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public abstract class AbstractC0077n extends AbstractC0065ck {

    /* JADX INFO: renamed from: a */
    public InterfaceC0013am f516a;

    /* JADX INFO: renamed from: a */
    public boolean f517a = false;

    public AbstractC0077n(InterfaceC0013am interfaceC0013am) {
        this.f516a = interfaceC0013am;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public abstract int mo74a();

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public abstract void mo76a(int i);

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public void mo77a(C0009ai c0009ai) {
        super.mo77a(c0009ai);
        this.f517a = false;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: a */
    public boolean mo78a() {
        if (this.f516a != null) {
            return this.f516a.mo8a();
        }
        return false;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: b */
    public abstract int mo79b();

    /* JADX INFO: renamed from: b */
    public void mo140b() {
        if (this.f516a != null) {
            this.f516a.mo7a();
        }
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: b */
    public abstract void mo81b(int i);

    /* JADX INFO: renamed from: b */
    public final boolean m255b() {
        if (this.f516a != null) {
            return this.f516a.mo8a();
        }
        return false;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: c */
    public abstract int mo82c();

    /* JADX INFO: renamed from: c */
    public final void m256c() {
        this.f517a = true;
    }

    @Override // p000.AbstractC0065ck
    /* JADX INFO: renamed from: d */
    public abstract int mo84d();

    /* JADX INFO: renamed from: d */
    public final void m257d() {
        this.f517a = false;
    }
}
