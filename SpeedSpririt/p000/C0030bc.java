package p000;

/* JADX INFO: renamed from: bc */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0030bc implements InterfaceC0013am {

    /* JADX INFO: renamed from: a */
    private int f308a;

    public C0030bc(C0020at c0020at, int i) {
        this.f308a = i;
    }

    @Override // p000.InterfaceC0013am
    /* JADX INFO: renamed from: a */
    public final void mo7a() {
        C0011ak.f154b = this.f308a;
        C0011ak.f141a.m124a(C0011ak.f153a[0]);
    }

    @Override // p000.InterfaceC0013am
    /* JADX INFO: renamed from: a */
    public final boolean mo8a() {
        return this.f308a <= C0011ak.f150a;
    }
}
