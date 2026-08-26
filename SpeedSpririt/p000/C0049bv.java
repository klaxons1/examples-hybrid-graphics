package p000;

import javax.microedition.lcdui.Graphics;

/* JADX INFO: renamed from: bv */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0049bv {

    /* JADX INFO: renamed from: a */
    private static int f390a;

    /* JADX INFO: renamed from: a */
    private static Graphics f391a;

    /* JADX INFO: renamed from: a */
    private static C0041bn[] f392a;

    /* JADX INFO: renamed from: a */
    public static int m169a() {
        return f392a[f390a].f359a;
    }

    /* JADX INFO: renamed from: a */
    public static int m170a(int i) {
        if (i < 0 || i >= f392a.length) {
            return 0;
        }
        return f392a[i].f359a;
    }

    /* JADX INFO: renamed from: a */
    public static int m171a(String str) {
        return f392a[f390a].m156a(str);
    }

    /* JADX INFO: renamed from: a */
    public static int m172a(String str, int i) {
        if (i < 0 || i >= f392a.length) {
            return 0;
        }
        return f392a[i].m156a(str);
    }

    /* JADX INFO: renamed from: a */
    public static void m173a(int i) {
        if (i < 0 || i >= f392a.length) {
            return;
        }
        f390a = i;
    }

    /* JADX INFO: renamed from: a */
    public static void m174a(int i, int i2) {
        if (i2 < 0 || i2 >= f392a.length) {
            return;
        }
        f392a[i2].m157a(i);
    }

    /* JADX INFO: renamed from: a */
    public static void m175a(String str) {
        if (f391a != null) {
            if (f392a == null) {
                f392a = new C0041bn[1];
                f392a[0] = new C0041bn(str, f391a);
            } else {
                C0041bn[] c0041bnArr = new C0041bn[f392a.length + 1];
                System.arraycopy(f392a, 0, c0041bnArr, 0, f392a.length);
                c0041bnArr[f392a.length] = new C0041bn(str, f391a);
                f392a = c0041bnArr;
            }
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m176a(String str, int i, int i2) {
        f392a[f390a].m158a(str, i, i2);
    }

    /* JADX INFO: renamed from: a */
    public static void m177a(Graphics graphics) {
        f391a = graphics;
    }

    /* JADX INFO: renamed from: b */
    public static void m178b(int i, int i2) {
        if (i2 < 0 || i2 >= f392a.length) {
            return;
        }
        f392a[i2].f362b = i;
    }

    /* JADX INFO: renamed from: b */
    public static void m179b(String str, int i, int i2) {
        f392a[f390a].m159b(str, i, i2);
    }

    /* JADX INFO: renamed from: c */
    public static void m180c(int i, int i2) {
        if (i2 < 0 || i2 >= f392a.length) {
            return;
        }
        f392a[i2].f359a = i;
    }

    /* JADX INFO: renamed from: c */
    public static void m181c(String str, int i, int i2) {
        f392a[f390a].m160c(str, i, i2);
    }
}
