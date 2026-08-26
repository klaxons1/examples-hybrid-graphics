package p000;

/* JADX INFO: renamed from: z */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0089z {

    /* JADX INFO: renamed from: a */
    private static int[] f566a;

    /* JADX INFO: renamed from: a */
    private static AbstractC0048bu[] f567a;

    /* JADX INFO: renamed from: a */
    private static String[] f568a;

    /* JADX INFO: renamed from: a */
    private static AbstractC0085v[] f569a;

    /* JADX INFO: renamed from: a */
    private static boolean[] f570a;

    /* JADX INFO: renamed from: b */
    private static int[] f571b;

    /* JADX INFO: renamed from: b */
    private static String[] f572b;

    /* JADX INFO: renamed from: b */
    private static boolean[] f573b;

    /* JADX INFO: renamed from: c */
    private static int[] f574c;

    /* JADX INFO: renamed from: d */
    private static int[] f575d;

    /* JADX INFO: renamed from: e */
    private static int[] f576e;

    /* JADX INFO: renamed from: a */
    public static AbstractC0048bu m279a(int i) {
        for (int i2 = 0; i2 < f571b.length; i2++) {
            if (i == f571b[i2]) {
                f573b[i2] = true;
                if (f567a[i2] != null) {
                    return (AbstractC0048bu) f567a[i2].mo117a();
                }
                if (f574c[i2] == -1) {
                    f567a[i2] = AbstractC0048bu.m166a(new StringBuffer().append("SKY_").append(f571b[i2]).toString(), f572b[i2]);
                } else {
                    f567a[i2] = AbstractC0048bu.m167a(new StringBuffer().append("MESH_").append(f571b[i2]).toString(), f572b[i2], f574c[i2]);
                    if (f576e[i2] == -1) {
                        f567a[i2].f388a = 1;
                    } else {
                        f567a[i2].f388a = f576e[i2];
                    }
                }
                if (f567a[i2] != null && f575d[i2] != Integer.MIN_VALUE) {
                    f567a[i2].mo118a(m280a(f575d[i2]));
                }
                if (f567a[i2] == null) {
                    System.out.println(new StringBuffer().append("ERROR | AEResourceManager.getGeometryResource() ").append(f572b[i2]).append(" not found !").toString());
                }
                return f567a[i2];
            }
        }
        System.out.println(new StringBuffer().append("ERROR | AEResourceManager.getGeometryResource(").append(i).append(") not found ! Unknown id !").toString());
        return null;
    }

    /* JADX INFO: renamed from: a */
    private static AbstractC0085v m280a(int i) {
        for (int i2 = 0; i2 < f566a.length; i2++) {
            if (i == f566a[i2]) {
                f570a[i2] = true;
                if (f569a[i2] != null) {
                    return f569a[i2];
                }
                f569a[i2] = AbstractC0085v.m269a(new String[]{f568a[i2]});
                if (f569a[i2] == null) {
                    System.out.println(new StringBuffer().append("ERROR | AEResourceManager.getTextureResource() ").append(f568a[i2]).append(" not found !").toString());
                }
                return f569a[i2];
            }
        }
        return null;
    }

    /* JADX INFO: renamed from: a */
    public static void m281a(int i, String str) {
        if (f568a == null) {
            f568a = new String[1];
            f568a[0] = str;
            f569a = new AbstractC0085v[1];
            f566a = new int[1];
            f566a[0] = i;
            f570a = new boolean[1];
            f570a[0] = false;
            return;
        }
        String[] strArr = new String[f568a.length + 1];
        System.arraycopy(f568a, 0, strArr, 0, f568a.length);
        strArr[f568a.length] = str;
        f568a = strArr;
        AbstractC0085v[] abstractC0085vArr = new AbstractC0085v[f569a.length + 1];
        System.arraycopy(f569a, 0, abstractC0085vArr, 0, f569a.length);
        f569a = abstractC0085vArr;
        int[] iArr = new int[f566a.length + 1];
        System.arraycopy(f566a, 0, iArr, 0, f566a.length);
        iArr[f566a.length] = i;
        f566a = iArr;
        boolean[] zArr = new boolean[f570a.length + 1];
        System.arraycopy(f570a, 0, zArr, 0, f570a.length);
        zArr[f570a.length] = false;
        f570a = zArr;
    }

    /* JADX INFO: renamed from: a */
    public static void m282a(int i, String str, int i2) {
        m283a(i, str, -1, i2);
    }

    /* JADX INFO: renamed from: a */
    public static void m283a(int i, String str, int i2, int i3) {
        m284a(i, str, i2, i3, -1);
    }

    /* JADX INFO: renamed from: a */
    private static void m284a(int i, String str, int i2, int i3, int i4) {
        if (f572b == null) {
            f572b = new String[1];
            f572b[0] = str;
            f574c = new int[1];
            f574c[0] = i2;
            f567a = new AbstractC0048bu[1];
            f571b = new int[1];
            f571b[0] = i;
            f573b = new boolean[1];
            f573b[0] = false;
            f575d = new int[1];
            f575d[0] = i3;
            f576e = new int[1];
            f576e[0] = i4;
            return;
        }
        String[] strArr = new String[f572b.length + 1];
        System.arraycopy(f572b, 0, strArr, 0, f572b.length);
        strArr[f572b.length] = str;
        f572b = strArr;
        int[] iArr = new int[f574c.length + 1];
        System.arraycopy(f574c, 0, iArr, 0, f574c.length);
        iArr[f574c.length] = i2;
        f574c = iArr;
        AbstractC0048bu[] abstractC0048buArr = new AbstractC0048bu[f567a.length + 1];
        System.arraycopy(f567a, 0, abstractC0048buArr, 0, f567a.length);
        f567a = abstractC0048buArr;
        int[] iArr2 = new int[f571b.length + 1];
        System.arraycopy(f571b, 0, iArr2, 0, f571b.length);
        iArr2[f571b.length] = i;
        f571b = iArr2;
        boolean[] zArr = new boolean[f573b.length + 1];
        System.arraycopy(f573b, 0, zArr, 0, f573b.length);
        zArr[f573b.length] = false;
        f573b = zArr;
        int[] iArr3 = new int[f575d.length + 1];
        System.arraycopy(f575d, 0, iArr3, 0, f575d.length);
        iArr3[f575d.length] = i3;
        f575d = iArr3;
        int[] iArr4 = new int[f576e.length + 1];
        System.arraycopy(f576e, 0, iArr4, 0, f576e.length);
        iArr4[f576e.length] = i4;
        f576e = iArr4;
    }
}
