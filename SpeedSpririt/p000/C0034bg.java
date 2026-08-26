package p000;

/* JADX INFO: renamed from: bg */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0034bg {

    /* JADX INFO: renamed from: a */
    public int f322a;

    /* JADX INFO: renamed from: a */
    private int[] f323a;

    /* JADX INFO: renamed from: b */
    private int f324b;

    /* JADX INFO: renamed from: c */
    private int f325c = 1;

    public C0034bg(int[] iArr, int i) {
        this.f323a = iArr;
        this.f324b = i;
        this.f322a = i;
    }

    /* JADX INFO: renamed from: a */
    public final int m134a() {
        return Math.min((this.f322a - this.f324b) + 1, this.f322a);
    }

    /* JADX INFO: renamed from: a */
    public final void m135a(int i, int i2) {
        if (Math.abs(i - this.f323a[this.f325c * 2]) >= 1000 || Math.abs(i2 - this.f323a[(this.f325c * 2) + 1]) >= 1000) {
            return;
        }
        if (this.f325c == 0) {
            this.f324b--;
        }
        this.f325c++;
        if (this.f325c > 2) {
            this.f325c = 0;
        }
    }

    /* JADX INFO: renamed from: a */
    public final boolean m136a() {
        return this.f324b == 0;
    }
}
