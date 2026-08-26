package p000;

/* JADX INFO: renamed from: c */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0054c extends C0003ac {

    /* JADX INFO: renamed from: a */
    public InterfaceC0050bw[] f402a;

    public C0054c(String str) {
        super(str);
        this.f402a = null;
    }

    /* JADX INFO: renamed from: a */
    public final void m191a(InterfaceC0050bw interfaceC0050bw) {
        if (this.f402a == null) {
            this.f402a = new InterfaceC0050bw[1];
            this.f402a[0] = interfaceC0050bw;
        } else {
            InterfaceC0050bw[] interfaceC0050bwArr = new InterfaceC0050bw[this.f402a.length + 1];
            System.arraycopy(this.f402a, 0, interfaceC0050bwArr, 0, this.f402a.length);
            interfaceC0050bwArr[this.f402a.length] = interfaceC0050bw;
            this.f402a = interfaceC0050bwArr;
        }
    }

    @Override // p000.C0003ac, p000.AbstractC0023aw
    /* JADX INFO: renamed from: a */
    public final void mo21a(boolean z) {
        if (this.f402a != null) {
            if (this.f263c || z) {
                if (((AbstractC0023aw) this).f262b || z) {
                    if (((AbstractC0023aw) this).f255a != null) {
                        ((AbstractC0023aw) this).f261b = ((AbstractC0023aw) ((AbstractC0023aw) this).f255a).f261b.m230a(((AbstractC0023aw) this).f257a, ((AbstractC0023aw) this).f261b);
                    } else {
                        ((AbstractC0023aw) this).f261b.m235a(((AbstractC0023aw) this).f257a);
                    }
                }
                for (AbstractC0023aw abstractC0023aw = ((C0003ac) this).f27a; abstractC0023aw != null; abstractC0023aw = abstractC0023aw.f260b) {
                    abstractC0023aw.mo21a(((AbstractC0023aw) this).f262b || z);
                }
                ((AbstractC0023aw) this).f256a.m213a(((AbstractC0023aw) this).f261b.m226a(), ((AbstractC0023aw) this).f261b.m239b(), ((AbstractC0023aw) this).f261b.m244c(), 0);
                for (AbstractC0023aw abstractC0023aw2 = ((C0003ac) this).f27a; abstractC0023aw2 != null; abstractC0023aw2 = abstractC0023aw2.f260b) {
                    ((AbstractC0023aw) this).f256a.m214a(abstractC0023aw2.f256a);
                }
                this.f263c = false;
                ((AbstractC0023aw) this).f262b = false;
            }
            for (int length = this.f402a.length - 1; length >= 0; length--) {
                if (this.f402a[length].mo183a()) {
                    this.f402a[length].mo182a();
                }
            }
        }
        if (this.f263c || z) {
            if (((AbstractC0023aw) this).f262b || z) {
                if (((AbstractC0023aw) this).f255a != null) {
                    ((AbstractC0023aw) this).f261b = ((AbstractC0023aw) ((AbstractC0023aw) this).f255a).f261b.m230a(((AbstractC0023aw) this).f257a, ((AbstractC0023aw) this).f261b);
                } else {
                    ((AbstractC0023aw) this).f261b.m235a(((AbstractC0023aw) this).f257a);
                }
            }
            for (AbstractC0023aw abstractC0023aw3 = ((C0003ac) this).f27a; abstractC0023aw3 != null; abstractC0023aw3 = abstractC0023aw3.f260b) {
                abstractC0023aw3.mo21a(((AbstractC0023aw) this).f262b || z);
            }
            ((AbstractC0023aw) this).f256a.m213a(((AbstractC0023aw) this).f261b.m226a(), ((AbstractC0023aw) this).f261b.m239b(), ((AbstractC0023aw) this).f261b.m244c(), 0);
            for (AbstractC0023aw abstractC0023aw4 = ((C0003ac) this).f27a; abstractC0023aw4 != null; abstractC0023aw4 = abstractC0023aw4.f260b) {
                ((AbstractC0023aw) this).f256a.m214a(abstractC0023aw4.f256a);
            }
            this.f263c = false;
            ((AbstractC0023aw) this).f262b = false;
        }
    }
}
