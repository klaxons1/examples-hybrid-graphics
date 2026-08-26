package p000;

import javax.microedition.lcdui.Image;

/* JADX INFO: renamed from: cc */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0057cc {

    /* JADX INFO: renamed from: a */
    private static int f409a = 1;

    /* JADX INFO: renamed from: a */
    private static Image[] f410a;

    /* JADX INFO: renamed from: a */
    public static void m194a() {
        f409a = 0;
    }

    /* JADX INFO: renamed from: b */
    public static void m195b() {
        f409a = 2;
    }

    /* JADX INFO: renamed from: c */
    public static void m196c() {
        f409a = 1;
    }

    /* JADX INFO: renamed from: d */
    public static void m197d() {
        C0087x.m278a(f410a[f409a], 0, 0, 12300288);
    }

    /* JADX INFO: renamed from: e */
    public static void m198e() {
        if (f410a != null) {
            for (int i = 0; i < f410a.length; i++) {
                f410a[i] = null;
            }
            f410a = null;
        }
    }
}
