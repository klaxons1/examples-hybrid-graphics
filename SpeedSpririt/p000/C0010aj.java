package p000;

import java.io.InputStream;

/* JADX INFO: renamed from: aj */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0010aj {

    /* JADX INFO: renamed from: a */
    public static C0002ab f131a;

    /* JADX INFO: renamed from: a */
    public static C0003ac f132a;

    /* JADX INFO: renamed from: a */
    public static AbstractC0038bk f133a;

    /* JADX INFO: renamed from: a */
    public static AbstractC0048bu f134a;

    /* JADX INFO: renamed from: a */
    public static Class f135a;

    /* JADX INFO: renamed from: a */
    private static short f136a;

    /* JADX INFO: renamed from: b */
    public static C0003ac f137b;

    /* JADX INFO: renamed from: b */
    public static AbstractC0038bk f138b;

    /* JADX INFO: renamed from: a */
    private static Class m64a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m65a() {
        f137b = null;
        f133a = null;
        f138b = null;
        f132a = null;
        f134a = null;
        f131a = null;
    }

    /* JADX INFO: renamed from: a */
    public static void m66a(boolean z) {
        Class clsM64a;
        int i = 0;
        f136a = (short) 0;
        try {
            if (f135a == null) {
                clsM64a = m64a("java.lang.Class");
                f135a = clsM64a;
            } else {
                clsM64a = f135a;
            }
            InputStream resourceAsStream = clsM64a.getResourceAsStream("/content/car/car_setup.txt");
            String str = "";
            String string = "";
            String string2 = "";
            String string3 = "";
            String string4 = "";
            String string5 = "";
            String string6 = "";
            String string7 = "";
            float[] fArr = new float[3];
            while (resourceAsStream.available() > 0) {
                char c = (char) resourceAsStream.read();
                if (c != '\n' && c != '\r') {
                    switch (f136a) {
                        case 0:
                            String string8 = new StringBuffer().append(str).append(c).toString();
                            if (string8.equals("MESH=")) {
                                f136a = (short) 1;
                            }
                            if (string8.equals("TEXTURE0=")) {
                                f136a = (short) 2;
                            }
                            if (string8.equals("TEXTURE1=")) {
                                f136a = (short) 3;
                            }
                            if (string8.equals("BBOX=")) {
                                f136a = (short) 5;
                            }
                            if (string8.equals("ENVMAP=")) {
                                f136a = (short) 4;
                            }
                            if (string8.equals("GHOST=")) {
                                f136a = (short) 6;
                            }
                            if (!string8.equals("ANIM=")) {
                                str = string8;
                            } else {
                                f136a = (short) 7;
                                str = string8;
                            }
                            break;
                        case 1:
                            string = new StringBuffer().append(string).append(c).toString();
                            break;
                        case 2:
                            string3 = new StringBuffer().append(string3).append(c).toString();
                            break;
                        case 3:
                            string4 = new StringBuffer().append(string4).append(c).toString();
                            break;
                        case 4:
                            string5 = new StringBuffer().append(string5).append(c).toString();
                            break;
                        case 5:
                            if (!(c == ',' || c == ';') || i >= 3) {
                                string6 = new StringBuffer().append(string6).append(c).toString();
                            } else {
                                fArr[i] = Float.parseFloat(string6);
                                string6 = "";
                                i++;
                            }
                            break;
                        case 6:
                            string2 = new StringBuffer().append(string2).append(c).toString();
                            break;
                        case 7:
                            string7 = new StringBuffer().append(string7).append(c).toString();
                            break;
                    }
                } else {
                    f136a = (short) 0;
                    str = "";
                }
            }
            if (z) {
                C0089z.m279a(100);
            }
            f132a = new C0003ac();
            f137b = new C0003ac();
            f134a = C0089z.m279a(100);
            f132a.m19a(f137b);
            f132a.m19a(f134a);
            f133a = AbstractC0038bk.m141a(C0011ak.f158c, C0011ak.f160d, 796, 5, 8192);
            f133a.m108c(0, 2048, 0);
            f132a.m19a(f133a);
            f138b = AbstractC0038bk.m141a(C0011ak.f158c, C0011ak.f160d, 796, 5, 8192);
            f138b.m108c(-180, 0, 0);
            f132a.m19a(f138b);
            f131a = new C0002ab(fArr[0], fArr[1], fArr[2], 0.0f, 0.0f, 0.0f, f132a, null);
            f137b.m100a(f131a.m9a().f30a, f131a.m9a().f31b, f131a.m9a().f32c);
            f133a.m100a(f131a.m9a().f30a, f131a.m9a().f31b + 100, f131a.m9a().f32c);
            f138b.m100a(f131a.m9a().f30a, f131a.m9a().f31b + 100, f131a.m9a().f32c + 500);
            switch (C0076m.f515a) {
                case 1:
                    f133a.m108c(0, 0, 90);
                    break;
                case 2:
                    f133a.m108c(0, 0, -90);
                    break;
            }
        } catch (Exception e) {
            System.out.println("ERROR | building car from \"car_setup.txt\"");
        }
    }
}
