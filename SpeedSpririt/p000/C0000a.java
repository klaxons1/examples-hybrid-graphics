package p000;

import java.io.DataInputStream;
import javax.microedition.lcdui.Image;

/* JADX INFO: renamed from: a */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0000a {

    /* JADX INFO: renamed from: a */
    private static float f4a;

    /* JADX INFO: renamed from: a */
    private static int f5a;

    /* JADX INFO: renamed from: a */
    public static Class f6a;

    /* JADX INFO: renamed from: b */
    private static float f7b;

    /* JADX INFO: renamed from: b */
    private static int f8b;

    /* JADX INFO: renamed from: a */
    public static int m0a(int i) {
        return (int) (f4a * i);
    }

    /* JADX INFO: renamed from: a */
    private static Class m1a(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }

    /* JADX INFO: renamed from: a */
    public static Image m2a(String str) {
        Image imageCreateRGBImage = null;
        try {
            Image imageM6b = m6b(str);
            float f = f5a / 176.0f;
            float f2 = f8b / 220.0f;
            int width = imageM6b.getWidth();
            int height = imageM6b.getHeight();
            int[] iArr = new int[width * height];
            imageM6b.getRGB(iArr, 0, width, 0, 0, width, height);
            imageCreateRGBImage = Image.createRGBImage(m4a(iArr, new int[((int) (width * f)) * ((int) (height * f2))], width, (int) (width * f)), (int) (width * f), (int) (height * f2), true);
            System.gc();
            return imageCreateRGBImage;
        } catch (Exception e) {
            e.printStackTrace();
            return imageCreateRGBImage;
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m3a(int i, int i2) {
        f5a = i;
        f8b = i2;
        f4a = f5a / 176.0f;
        f7b = f8b / 220.0f;
    }

    /* JADX INFO: renamed from: a */
    private static int[] m4a(int[] iArr, int[] iArr2, int i, int i2) {
        int length = iArr.length / i;
        int length2 = iArr2.length / i2;
        for (int i3 = 0; i3 < i2; i3++) {
            for (int i4 = 0; i4 < length2; i4++) {
                iArr2[(i4 * i2) + i3] = iArr[((int) Math.floor(((i - 1) * i3) / (i2 - 1))) + (((int) Math.floor(((length - 1) * i4) / (length2 - 1))) * i)];
            }
        }
        return iArr2;
    }

    /* JADX INFO: renamed from: b */
    public static int m5b(int i) {
        return (int) (f7b * i);
    }

    /* JADX INFO: renamed from: b */
    public static Image m6b(String str) {
        Image imageCreateImage;
        Class clsM1a;
        int i;
        try {
            if (f6a == null) {
                clsM1a = m1a("java.lang.Class");
                f6a = clsM1a;
            } else {
                clsM1a = f6a;
            }
            DataInputStream dataInputStream = new DataInputStream(clsM1a.getResourceAsStream(str));
            int iAvailable = dataInputStream.available();
            byte[] bArr = new byte[iAvailable];
            dataInputStream.read(bArr, 0, iAvailable);
            dataInputStream.close();
            if (iAvailable < 100) {
                i = (iAvailable % 10) + 10;
            } else if (iAvailable < 200) {
                i = (iAvailable % 20) + 50;
            } else {
                i = iAvailable < 300 ? (iAvailable % 20) + 80 : (iAvailable % 50) + 100;
            }
            for (int i2 = 0; i2 < i; i2++) {
                byte b = bArr[i2];
                bArr[i2] = bArr[(iAvailable - i2) - 1];
                bArr[(iAvailable - i2) - 1] = b;
            }
            imageCreateImage = Image.createImage(bArr, 0, iAvailable);
            try {
                System.gc();
            } catch (Exception e) {
                System.out.println(new StringBuffer().append("Image ").append(str).append(" ist nicht verschlüsselt!").toString());
            }
        } catch (Exception e2) {
            imageCreateImage = null;
        }
        return imageCreateImage;
    }
}
