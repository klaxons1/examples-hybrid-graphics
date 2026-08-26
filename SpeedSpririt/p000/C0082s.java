package p000;

import javax.microedition.lcdui.Image;
import javax.microedition.m3g.Image2D;
import javax.microedition.m3g.Texture2D;

/* JADX INFO: renamed from: s */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0082s extends AbstractC0085v {

    /* JADX INFO: renamed from: a */
    public Texture2D[] f526a;

    public C0082s(String[] strArr) {
        if (strArr != null) {
            this.f526a = new Texture2D[strArr.length];
            for (int i = 0; i < strArr.length; i++) {
                try {
                    this.f526a[i] = new Texture2D(new Image2D(100, Image.createImage(new StringBuffer().append(strArr[i]).append(".png").toString())));
                    this.f526a[i].setBlending(228);
                    this.f526a[i].setWrapping(241, 241);
                } catch (Exception e) {
                    this.f526a = null;
                }
            }
        }
    }
}
