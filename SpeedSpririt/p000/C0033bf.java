package p000;

/* JADX INFO: renamed from: bf */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0033bf implements InterfaceC0013am {

    /* JADX INFO: renamed from: a */
    private final C0020at f320a;

    /* JADX INFO: renamed from: a */
    public short f321a;

    public C0033bf(C0020at c0020at, short s) {
        this.f320a = c0020at;
        this.f321a = s;
    }

    @Override // p000.InterfaceC0013am
    /* JADX INFO: renamed from: a */
    public final void mo7a() {
        C0011ak.m68a(this.f321a);
        switch (C0076m.f515a) {
            case 0:
                C0087x.m276a(61455);
                C0020at.m92a(this.f320a).mo21a(false);
                C0020at.m92a(this.f320a).m100a(0, 0, 0);
                break;
            case 1:
                C0087x.m276a(983280);
                C0020at.m92a(this.f320a).mo21a(false);
                C0020at.m92a(this.f320a).m100a(0, 0, 0);
                break;
            case 2:
                C0087x.m276a(15732480);
                C0020at.m92a(this.f320a).mo21a(false);
                C0020at.m92a(this.f320a).m100a(0, 0, 0);
                break;
        }
        C0020at.m93a(this.f320a).m146a(2);
    }

    @Override // p000.InterfaceC0013am
    /* JADX INFO: renamed from: a */
    public final boolean mo8a() {
        return true;
    }
}
