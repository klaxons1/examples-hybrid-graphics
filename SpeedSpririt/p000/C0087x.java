package p000;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/* JADX INFO: renamed from: x */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0087x {

    /* JADX INFO: renamed from: a */
    private static int f556a;

    /* JADX INFO: renamed from: a */
    private static Graphics f557a;

    /* JADX INFO: renamed from: b */
    private static int f558b;

    /* JADX INFO: renamed from: c */
    private static int f559c;

    /* JADX INFO: renamed from: a */
    public static void m276a(int i) {
        f559c = i;
    }

    /* JADX INFO: renamed from: a */
    public static void m277a(Graphics graphics, int i, int i2) {
        f557a = graphics;
        f556a = i;
        f558b = i2;
        f559c = 61455;
    }

    /* JADX INFO: renamed from: a */
    public static void m278a(Image image, int i, int i2, int i3) {
        switch (f559c & i3) {
            case 24576:
                f557a.drawImage(image, (f556a - image.getWidth()) - i, i2, 0);
                break;
            case 28672:
                f557a.drawImage(image, ((f556a >> 1) - (image.getWidth() >> 1)) + i, i2, 0);
                break;
            case 36864:
                f557a.drawImage(image, i, (f558b - image.getHeight()) - i2, 0);
                break;
            case 40960:
                f557a.drawImage(image, (f556a - image.getWidth()) - i, (f558b - image.getHeight()) - i2, 0);
                break;
            case 45056:
                f557a.drawImage(image, ((f556a >> 1) - (image.getWidth() >> 1)) + i, (f558b - image.getHeight()) - i2, 0);
                break;
            case 53248:
                f557a.drawImage(image, i, ((f558b >> 1) - (image.getHeight() >> 1)) + i2, 0);
                break;
            case 57344:
                f557a.drawImage(image, (f556a - image.getWidth()) - i, ((f558b >> 1) - (image.getHeight() >> 1)) + i2, 0);
                break;
            case 61440:
                f557a.drawImage(image, ((f556a >> 1) - (image.getWidth() >> 1)) + i, ((f558b >> 1) - (image.getHeight() >> 1)) + i2, 0);
                break;
            case 327680:
                f557a.drawRegion(image, 0, 0, image.getWidth(), image.getHeight(), 5, (f556a - i2) - image.getHeight(), i, 0);
                break;
            case 393216:
                f557a.drawRegion(image, 0, 0, image.getWidth(), image.getHeight(), 5, (f556a - i2) - image.getHeight(), (f558b - image.getWidth()) - i, 0);
                break;
            case 458752:
                f557a.drawRegion(image, 0, 0, image.getWidth(), image.getHeight(), 5, (f556a - i2) - image.getHeight(), ((f558b >> 1) - (image.getWidth() >> 1)) + i, 0);
                break;
            case 589824:
                f557a.drawRegion(image, 0, 0, image.getWidth(), image.getHeight(), 5, i2, i, 0);
                break;
            case 655360:
                f557a.drawRegion(image, 0, 0, image.getWidth(), image.getHeight(), 5, i2, (f558b - image.getWidth()) - i, 0);
                break;
            case 720896:
                f557a.drawRegion(image, 0, 0, image.getWidth(), image.getHeight(), 5, i2, ((f558b >> 1) - (image.getWidth() >> 1)) + i, 0);
                break;
            case 851968:
                f557a.drawRegion(image, 0, 0, image.getWidth(), image.getHeight(), 5, ((f556a >> 1) - (image.getHeight() >> 1)) - i2, i, 0);
                break;
            case 917504:
                f557a.drawRegion(image, 0, 0, image.getWidth(), image.getHeight(), 5, ((f556a >> 1) - (image.getHeight() >> 1)) - i2, (f558b - image.getWidth()) - i, 0);
                break;
            case 983040:
                f557a.drawRegion(image, 0, 0, image.getWidth(), image.getHeight(), 5, ((f556a >> 1) - (image.getHeight() >> 1)) - i2, ((f558b >> 1) - (image.getWidth() >> 1)) + i, 0);
                break;
            case 5242880:
                f557a.drawRegion(image, 0, 0, image.getWidth(), image.getHeight(), 6, i2, (f558b - i) - image.getWidth(), 0);
                break;
            case 6291456:
                f557a.drawRegion(image, 0, 0, image.getWidth(), image.getHeight(), 6, i2, i, 0);
                break;
            case 7340032:
                f557a.drawRegion(image, 0, 0, image.getWidth(), image.getHeight(), 6, i2, ((f558b >> 1) - (image.getWidth() >> 1)) - i, 0);
                break;
            case 9437184:
                f557a.drawRegion(image, 0, 0, image.getWidth(), image.getHeight(), 6, (f556a - image.getHeight()) - i2, (f558b - i) - image.getWidth(), 0);
                break;
            case 10485760:
                f557a.drawRegion(image, 0, 0, image.getWidth(), image.getHeight(), 6, (f556a - image.getHeight()) - i2, i, 0);
                break;
            case 11534336:
                f557a.drawRegion(image, 0, 0, image.getWidth(), image.getHeight(), 6, (f556a - image.getHeight()) - i2, ((f558b >> 1) - (image.getWidth() >> 1)) - i, 0);
                break;
            case 13631488:
                f557a.drawRegion(image, 0, 0, image.getWidth(), image.getHeight(), 6, ((f556a >> 1) - (image.getHeight() >> 1)) + i2, (f558b - i) - image.getWidth(), 0);
                break;
            case 14680064:
                f557a.drawRegion(image, 0, 0, image.getWidth(), image.getHeight(), 6, ((f556a >> 1) - (image.getHeight() >> 1)) + i2, i, 0);
                break;
            case 15728640:
                f557a.drawRegion(image, 0, 0, image.getWidth(), image.getHeight(), 6, ((f556a >> 1) - (image.getHeight() >> 1)) + i2, ((f558b >> 1) - (image.getWidth() >> 1)) - i, 0);
                break;
            default:
                f557a.drawImage(image, i, i2, 0);
                break;
        }
    }
}
