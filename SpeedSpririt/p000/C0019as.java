package p000;

import javax.microedition.lcdui.Image;

/* JADX INFO: renamed from: as */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0019as {

    /* JADX INFO: renamed from: a */
    private static long f219a;

    /* JADX INFO: renamed from: a */
    private static String f220a;

    /* JADX INFO: renamed from: a */
    private static Image f221a;

    /* JADX INFO: renamed from: a */
    private static Image[] f222a;

    /* JADX INFO: renamed from: b */
    private static String f223b = "";

    /* JADX INFO: renamed from: b */
    private static Image f224b;

    /* JADX INFO: renamed from: b */
    private static Image[] f225b;

    /* JADX INFO: renamed from: c */
    private static Image f226c;

    /* JADX INFO: renamed from: d */
    private static Image f227d;

    /* JADX INFO: renamed from: e */
    private static Image f228e;

    /* JADX INFO: renamed from: f */
    private static Image f229f;

    /* JADX INFO: renamed from: g */
    private static Image f230g;

    /* JADX INFO: renamed from: h */
    private static Image f231h;

    /* JADX INFO: renamed from: i */
    private static Image f232i;

    /* JADX INFO: renamed from: a */
    public static String m85a(long j) {
        int i = ((int) (j / 60000)) % 100;
        int i2 = (((int) j) / 1000) - (i * 60);
        int i3 = (int) (((j - ((long) (60000 * i))) - ((long) (i2 * 1000))) / 10);
        return new StringBuffer().append(i / 10).append("").append(i % 10).append(":").append(i2 / 10).append("").append(i2 % 10).append(":").append(i3 / 10).append("").append(i3 % 10).toString();
    }

    /* JADX INFO: renamed from: a */
    public static void m86a() {
        f222a = new Image[10];
        f225b = new Image[10];
        for (int i = 0; i < f222a.length; i++) {
            try {
                f222a[i] = C0000a.m6b(new StringBuffer().append("/content/interface/mph/").append(i).append("_mph.png").toString());
            } catch (Exception e) {
                System.out.println(e.toString());
                return;
            }
        }
        for (int i2 = 0; i2 < f225b.length; i2++) {
            f225b[i2] = C0000a.m6b(new StringBuffer().append("/content/interface/time/").append(i2).append("_time.png").toString());
        }
        f221a = C0000a.m6b("/content/interface/anzeige_mph.png");
        f227d = C0000a.m6b("/content/interface/lap_anzeige.png");
        f228e = C0000a.m6b("/content/interface/lap_anzeige_de.png");
        f229f = C0000a.m6b("/content/interface/lap_anzeige_fr.png");
        f230g = C0000a.m6b("/content/interface/lap_anzeige_es.png");
        f231h = C0000a.m6b("/content/interface/lap_anzeige_it.png");
        f232i = C0000a.m6b("/content/interface/lap_anzeige_tu.png");
        f226c = C0000a.m6b("/content/interface/time_anzeige.png");
    }

    /* JADX INFO: renamed from: a */
    public static void m87a(int i) {
        int i2 = i % 1000;
        switch (C0011ak.f156b) {
            case 0:
                C0011ak.f146a.drawImage(f222a[i2 / 100], (C0011ak.f158c - f221a.getWidth()) - 11, (C0011ak.f160d - f221a.getHeight()) - 32, 0);
                C0011ak.f146a.drawImage(f222a[(i2 % 100) / 10], C0011ak.f158c - f221a.getWidth(), (C0011ak.f160d - f221a.getHeight()) - 32, 0);
                C0011ak.f146a.drawImage(f222a[i2 % 10], (C0011ak.f158c - f221a.getWidth()) + 11, (C0011ak.f160d - f221a.getHeight()) - 32, 0);
                C0011ak.f146a.drawImage(f221a, (C0011ak.f158c - f221a.getWidth()) - 10, (C0011ak.f160d - f221a.getHeight()) - 20, 0);
                break;
            case 1:
                C0011ak.f146a.drawRegion(f222a[i2 / 100], 0, 0, f222a[i2 / 100].getWidth(), f222a[i2 / 100].getHeight(), 5, 29, (C0011ak.f160d - 17) - f221a.getWidth(), 20);
                C0011ak.f146a.drawRegion(f222a[(i2 % 100) / 10], 0, 0, f222a[(i2 % 100) / 10].getWidth(), f222a[(i2 % 100) / 10].getHeight(), 5, 29, (C0011ak.f160d - 6) - f221a.getWidth(), 20);
                C0011ak.f146a.drawRegion(f222a[i2 % 10], 0, 0, f222a[i2 % 10].getWidth(), f222a[i2 % 10].getHeight(), 5, 29, (C0011ak.f160d + 5) - f221a.getWidth(), 20);
                C0011ak.f146a.drawRegion(f221a, 0, 0, f221a.getWidth(), f221a.getHeight(), 5, 20, (C0011ak.f160d - 16) - f221a.getWidth(), 20);
                break;
            case 2:
                C0011ak.f146a.drawRegion(f222a[i2 / 100], 0, 0, f222a[i2 / 100].getWidth(), f222a[i2 / 100].getHeight(), 6, (C0011ak.f158c - f221a.getHeight()) - 15, 22, 20);
                C0011ak.f146a.drawRegion(f222a[(i2 % 100) / 10], 0, 0, f222a[(i2 % 100) / 10].getWidth(), f222a[(i2 % 100) / 10].getHeight(), 6, (C0011ak.f158c - f221a.getHeight()) - 15, 11, 20);
                C0011ak.f146a.drawRegion(f222a[i2 % 10], 0, 0, f222a[i2 % 10].getWidth(), f222a[i2 % 10].getHeight(), 6, (C0011ak.f158c - f221a.getHeight()) - 15, 0, 20);
                C0011ak.f146a.drawRegion(f221a, 0, 0, f221a.getWidth(), f221a.getHeight(), 6, (C0011ak.f158c - f221a.getHeight()) - 2, 10, 20);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m88a(int i, int i2) {
        int i3 = i % 10;
        int i4 = i2 % 10;
        switch (C0011ak.f139a) {
            case 0:
                f224b = f228e;
                break;
            case 1:
                f224b = f227d;
                break;
            case 2:
                f224b = f229f;
                break;
            case 3:
                f224b = f231h;
                break;
            case 4:
                f224b = f230g;
                break;
            case 5:
                f224b = f232i;
                break;
        }
        switch (C0011ak.f156b) {
            case 0:
                C0011ak.f146a.drawImage(f224b, (C0011ak.f158c - f224b.getWidth()) - 13, 5, 0);
                C0011ak.f146a.drawImage(f222a[i4], C0011ak.f158c - 13, 4, 0);
                C0011ak.f146a.drawImage(f222a[i3], C0011ak.f158c - 32, 4, 0);
                break;
            case 1:
                C0011ak.f146a.drawRegion(f224b, 0, 0, f224b.getWidth(), f224b.getHeight(), 5, (C0011ak.f158c - f224b.getHeight()) - 5, (C0011ak.f160d - f224b.getWidth()) - 33, 20);
                C0011ak.f146a.drawRegion(f222a[i4], 0, 0, f222a[i4].getWidth(), f222a[i4].getHeight(), 5, (C0011ak.f158c - f222a[i4].getHeight()) - 4, C0011ak.f160d - 33, 20);
                C0011ak.f146a.drawRegion(f222a[i3], 0, 0, f222a[i3].getWidth(), f222a[i3].getHeight(), 5, (C0011ak.f158c - f222a[i3].getHeight()) - 4, C0011ak.f160d - 52, 20);
                break;
            case 2:
                C0011ak.f146a.drawRegion(f224b, 0, 0, f224b.getWidth(), f224b.getHeight(), 6, 5, 13, 20);
                C0011ak.f146a.drawRegion(f222a[i4], 0, 0, f222a[i4].getWidth(), f222a[i4].getHeight(), 6, 4, 13 - f222a[i4].getWidth(), 20);
                C0011ak.f146a.drawRegion(f222a[i3], 0, 0, f222a[i3].getWidth(), f222a[i3].getHeight(), 6, 4, 32 - f222a[i3].getWidth(), 20);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m89a(long j) {
        m90a(j, (C0011ak.f158c - f226c.getWidth()) - 25, 20);
    }

    /* JADX INFO: renamed from: a */
    private static void m90a(long j, int i, int i2) {
        int i3 = ((int) (j / 60000)) % 100;
        int i4 = (((int) j) / 1000) - (i3 * 60);
        int i5 = (int) (((j - ((long) (60000 * i3))) - ((long) (i4 * 1000))) / 10);
        switch (C0011ak.f156b) {
            case 0:
                C0011ak.f146a.drawImage(f226c, i, i2 - 1, 0);
                C0011ak.f146a.drawImage(f225b[i3 / 10], i + 10, i2, 0);
                C0011ak.f146a.drawImage(f225b[i3 % 10], i + 20, i2, 0);
                C0011ak.f146a.drawImage(f225b[i4 / 10], i + 35, i2, 0);
                C0011ak.f146a.drawImage(f225b[i4 % 10], i + 45, i2, 0);
                C0011ak.f146a.drawImage(f225b[i5 / 10], i + 60, i2, 0);
                C0011ak.f146a.drawImage(f225b[i5 % 10], i + 70, i2, 0);
                break;
            case 1:
                C0011ak.f146a.drawRegion(f226c, 0, 0, f226c.getWidth(), f226c.getHeight(), 5, (C0011ak.f158c - i2) - f226c.getHeight(), (C0011ak.f160d - f221a.getWidth()) - 62, 20);
                C0011ak.f146a.drawRegion(f225b[i3 / 10], 0, 0, f225b[i3 / 10].getWidth(), f225b[i3 / 10].getHeight(), 5, (C0011ak.f158c - i2) - f226c.getHeight(), (C0011ak.f160d - f221a.getWidth()) - 52, 20);
                C0011ak.f146a.drawRegion(f225b[i3 % 10], 0, 0, f225b[i3 % 10].getWidth(), f225b[i3 % 10].getHeight(), 5, (C0011ak.f158c - i2) - f226c.getHeight(), (C0011ak.f160d - f221a.getWidth()) - 42, 20);
                C0011ak.f146a.drawRegion(f225b[i4 / 10], 0, 0, f225b[i4 / 10].getWidth(), f225b[i4 / 10].getHeight(), 5, (C0011ak.f158c - i2) - f226c.getHeight(), (C0011ak.f160d - f221a.getWidth()) - 27, 20);
                C0011ak.f146a.drawRegion(f225b[i4 % 10], 0, 0, f225b[i4 % 10].getWidth(), f225b[i4 % 10].getHeight(), 5, (C0011ak.f158c - i2) - f226c.getHeight(), (C0011ak.f160d - f221a.getWidth()) - 17, 20);
                C0011ak.f146a.drawRegion(f225b[i5 / 10], 0, 0, f225b[i5 / 10].getWidth(), f225b[i5 / 10].getHeight(), 5, (C0011ak.f158c - i2) - f226c.getHeight(), (C0011ak.f160d - f221a.getWidth()) - 2, 20);
                C0011ak.f146a.drawRegion(f225b[i5 % 10], 0, 0, f225b[i5 % 10].getWidth(), f225b[i5 % 10].getHeight(), 5, (C0011ak.f158c - i2) - f226c.getHeight(), (C0011ak.f160d - f221a.getWidth()) + 8, 20);
                break;
            case 2:
                C0011ak.f146a.drawRegion(f226c, 0, 0, f226c.getWidth(), f226c.getHeight(), 6, i2 - 2, 23, 20);
                C0011ak.f146a.drawRegion(f225b[i3 / 10], 0, 0, f225b[i3 / 10].getWidth(), f225b[i3 / 10].getHeight(), 6, i2 - 1, 62, 20);
                C0011ak.f146a.drawRegion(f225b[i3 % 10], 0, 0, f225b[i3 % 10].getWidth(), f225b[i3 % 10].getHeight(), 6, i2 - 1, 52, 20);
                C0011ak.f146a.drawRegion(f225b[i4 / 10], 0, 0, f225b[i4 / 10].getWidth(), f225b[i4 / 10].getHeight(), 6, i2 - 1, 37, 20);
                C0011ak.f146a.drawRegion(f225b[i4 % 10], 0, 0, f225b[i4 % 10].getWidth(), f225b[i4 % 10].getHeight(), 6, i2 - 1, 27, 20);
                C0011ak.f146a.drawRegion(f225b[i5 / 10], 0, 0, f225b[i5 / 10].getWidth(), f225b[i5 / 10].getHeight(), 6, i2 - 1, 12, 20);
                C0011ak.f146a.drawRegion(f225b[i5 % 10], 0, 0, f225b[i5 % 10].getWidth(), f225b[i5 % 10].getHeight(), 6, i2 - 1, 2, 20);
                break;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m91a(long j, long j2) {
        String strM138a;
        String strM138a2;
        if (j >= j2) {
            f219a = j - j2;
            f220a = "-";
        } else {
            f219a = j2 - j;
            f220a = "+";
        }
        f220a = new StringBuffer().append(f220a).append(m85a(f219a)).toString();
        switch (C0011ak.f154b) {
            case 0:
                f223b = C0011ak.f143a.m138a(5);
                break;
            case 1:
                f223b = C0011ak.f143a.m138a(6);
                break;
            case 2:
                f223b = C0011ak.f143a.m138a(7);
                break;
            case 3:
                f223b = C0011ak.f143a.m138a(8);
                break;
            case 4:
                f223b = C0011ak.f143a.m138a(9);
                break;
            case 5:
                f223b = C0011ak.f143a.m138a(10);
                break;
        }
        C0049bv.m173a(0);
        switch (C0011ak.f156b) {
            case 0:
                C0049bv.m176a(f223b, (C0011ak.f158c >> 1) - 30, ((C0011ak.f160d / 3) + (C0049bv.m169a() * 2)) - 15);
                C0049bv.m176a(f220a, (C0011ak.f158c >> 1) - 25, ((C0011ak.f160d / 3) + (C0049bv.m169a() * 3)) - 15);
                break;
            case 1:
                C0049bv.m179b(f223b, ((C0011ak.f158c >> 1) + C0049bv.m169a()) - 5, (C0011ak.f160d >> 1) - 30);
                C0049bv.m179b(f220a, (C0011ak.f158c >> 1) - 5, (C0011ak.f160d >> 1) - 25);
                break;
            case 2:
                C0049bv.m181c(f223b, ((C0011ak.f158c >> 1) + (C0049bv.m169a() * 2)) - 30, (C0011ak.f160d >> 1) + 30);
                C0049bv.m181c(f220a, ((C0011ak.f158c >> 1) + (C0049bv.m169a() * 3)) - 30, (C0011ak.f160d >> 1) + 25);
                break;
        }
        if (j - j2 < 0) {
            strM138a = C0011ak.f143a.m138a(45);
            strM138a2 = null;
        } else if (C0011ak.f154b == 5) {
            String strM138a3 = C0011ak.f143a.m138a(60);
            strM138a2 = C0011ak.f143a.m138a(62);
            strM138a = strM138a3;
        } else if (C0011ak.f150a <= C0011ak.f154b) {
            strM138a = C0011ak.f143a.m138a(47);
            strM138a2 = null;
        } else {
            strM138a2 = null;
            strM138a = null;
        }
        if (strM138a != null) {
            switch (C0011ak.f156b) {
                case 0:
                    C0049bv.m176a(strM138a, (C0011ak.f158c >> 1) - (C0049bv.m171a(strM138a) >> 1), (C0011ak.f160d / 3) + (C0049bv.m169a() * 4));
                    if (strM138a2 != null) {
                        C0049bv.m176a(strM138a2, (C0011ak.f158c >> 1) - (C0049bv.m171a(strM138a2) >> 1), (C0011ak.f160d / 3) + (C0049bv.m169a() * 5));
                    }
                    break;
                case 1:
                    C0049bv.m179b(strM138a, ((C0011ak.f158c >> 1) - C0049bv.m169a()) - 15, (C0011ak.f160d >> 1) - (C0049bv.m171a(strM138a) >> 1));
                    if (strM138a2 != null) {
                        C0049bv.m179b(strM138a2, ((C0011ak.f158c >> 1) - (C0049bv.m169a() * 2)) - 15, (C0011ak.f160d >> 1) - (C0049bv.m171a(strM138a2) >> 1));
                    }
                    break;
                case 2:
                    C0049bv.m181c(strM138a, ((C0011ak.f158c >> 1) + (C0049bv.m169a() * 4)) - 20, (C0011ak.f160d >> 1) + (C0049bv.m171a(strM138a) >> 1));
                    if (strM138a2 != null) {
                        C0049bv.m181c(strM138a2, ((C0011ak.f158c >> 1) + (C0049bv.m169a() * 5)) - 20, (C0011ak.f160d >> 1) + (C0049bv.m171a(strM138a2) >> 1));
                    }
                    break;
            }
        }
    }
}
