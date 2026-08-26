package p000;

/* JADX INFO: renamed from: ca */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0055ca implements InterfaceC0013am {

    /* JADX INFO: renamed from: a */
    public int f403a;

    /* JADX INFO: renamed from: a */
    private final C0020at f404a;

    public C0055ca(C0020at c0020at, int i) {
        this.f404a = c0020at;
        this.f403a = i;
    }

    @Override // p000.InterfaceC0013am
    /* JADX INFO: renamed from: a */
    public final void mo7a() {
        C0011ak.f139a = this.f403a;
        C0011ak.f143a.m139a(this.f403a);
        if (C0011ak.f161d && C0020at.m93a(this.f404a).f355a == 9) {
            C0011ak.f161d = false;
        } else {
            C0020at.m93a(this.f404a).m146a(2);
        }
    }

    @Override // p000.InterfaceC0013am
    /* JADX INFO: renamed from: a */
    public final boolean mo8a() {
        return true;
    }
}
