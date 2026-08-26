package p000;

/* JADX INFO: renamed from: q */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0080q {

    /* JADX INFO: renamed from: a */
    public AbstractC0048bu[] f523a = null;

    /* JADX INFO: renamed from: a */
    public int f522a = 0;

    /* JADX INFO: renamed from: a */
    public final void m259a() {
        this.f522a = 0;
    }

    /* JADX INFO: renamed from: a */
    public final void m260a(AbstractC0048bu abstractC0048bu) {
        if (this.f523a == null) {
            this.f523a = new AbstractC0048bu[1];
            this.f523a[0] = abstractC0048bu;
            this.f522a = 1;
        } else {
            if (this.f522a != this.f523a.length) {
                this.f523a[this.f522a] = abstractC0048bu;
                this.f522a++;
                return;
            }
            AbstractC0048bu[] abstractC0048buArr = new AbstractC0048bu[this.f523a.length + 1];
            System.arraycopy(this.f523a, 0, abstractC0048buArr, 0, this.f523a.length);
            abstractC0048buArr[this.f523a.length] = abstractC0048bu;
            this.f523a = abstractC0048buArr;
            this.f522a++;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m261b() {
        for (int i = 0; i < this.f522a; i++) {
            this.f523a[i].mo119b();
        }
        for (int i2 = 0; i2 < this.f522a; i2++) {
            this.f523a[i2].mo168c();
        }
    }
}
