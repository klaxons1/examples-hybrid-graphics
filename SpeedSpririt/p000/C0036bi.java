package p000;

import java.io.DataInputStream;
import java.io.InputStream;

/* JADX INFO: renamed from: bi */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0036bi {

    /* JADX INFO: renamed from: a */
    private static String[] f333a = new String[63];

    /* JADX INFO: renamed from: a */
    private static int f332a = 0;

    /* JADX INFO: renamed from: a */
    public static int m137a() {
        return f332a;
    }

    /* JADX INFO: renamed from: a */
    public final String m138a(int i) {
        return f333a[i];
    }

    /* JADX INFO: renamed from: a */
    public final void m139a(int i) {
        f332a = i;
        InputStream resourceAsStream = null;
        try {
            switch (f332a) {
                case 0:
                    resourceAsStream = getClass().getResourceAsStream("/de.lang");
                    break;
                case 1:
                    resourceAsStream = getClass().getResourceAsStream("/gb.lang");
                    break;
                case 2:
                    resourceAsStream = getClass().getResourceAsStream("/fr.lang");
                    break;
                case 3:
                    resourceAsStream = getClass().getResourceAsStream("/it.lang");
                    break;
                case 4:
                    resourceAsStream = getClass().getResourceAsStream("/es.lang");
                    break;
                case 5:
                    resourceAsStream = getClass().getResourceAsStream("/tu.lang");
                    break;
            }
            DataInputStream dataInputStream = new DataInputStream(resourceAsStream);
            for (int i2 = 0; i2 < f333a.length; i2++) {
                f333a[i2] = dataInputStream.readUTF();
            }
            dataInputStream.close();
        } catch (Exception e) {
            for (int i3 = 0; i3 < f333a.length; i3++) {
                f333a[i3] = "<ERROR|LANG>";
            }
        }
    }
}
