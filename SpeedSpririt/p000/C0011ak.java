package p000;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.m3g.Graphics3D;
import javax.microedition.rms.RecordStore;
import javax.microedition.rms.RecordStoreException;

/* JADX INFO: renamed from: ak */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0011ak {

    /* JADX INFO: renamed from: a */
    public static AbstractC0027b f140a;

    /* JADX INFO: renamed from: a */
    public static C0028ba f141a;

    /* JADX INFO: renamed from: a */
    public static C0031bd f142a;

    /* JADX INFO: renamed from: a */
    public static C0036bi f143a;

    /* JADX INFO: renamed from: a */
    public static Font f145a;

    /* JADX INFO: renamed from: a */
    public static Graphics f146a;

    /* JADX INFO: renamed from: a */
    public static Graphics3D f147a;

    /* JADX INFO: renamed from: a */
    public static C0086w f149a;

    /* JADX INFO: renamed from: a */
    public static AbstractC0053bz[] f153a;

    /* JADX INFO: renamed from: b */
    public static int f154b;

    /* JADX INFO: renamed from: c */
    public static int f158c;

    /* JADX INFO: renamed from: d */
    public static int f160d;

    /* JADX INFO: renamed from: a */
    public static String f144a = "";

    /* JADX INFO: renamed from: b */
    public static String f155b = "";

    /* JADX INFO: renamed from: a */
    public static boolean f151a = false;

    /* JADX INFO: renamed from: b */
    public static boolean f157b = true;

    /* JADX INFO: renamed from: c */
    public static boolean f159c = true;

    /* JADX INFO: renamed from: a */
    public static long[] f152a = new long[6];

    /* JADX INFO: renamed from: a */
    public static short f150a = 0;

    /* JADX INFO: renamed from: a */
    public static int f139a = 1;

    /* JADX INFO: renamed from: b */
    public static short f156b = 0;

    /* JADX INFO: renamed from: d */
    public static boolean f161d = true;

    /* JADX INFO: renamed from: e */
    public static int f162e = 4;

    /* JADX INFO: renamed from: f */
    public static int f163f = 2;

    /* JADX INFO: renamed from: g */
    public static int f164g = 32;

    /* JADX INFO: renamed from: h */
    public static int f165h = 64;

    /* JADX INFO: renamed from: i */
    public static int f166i = 512;

    /* JADX INFO: renamed from: j */
    public static int f167j = 1024;

    /* JADX INFO: renamed from: k */
    public static int f168k = 1048576;

    /* JADX INFO: renamed from: l */
    public static int f169l = 2097152;

    /* JADX INFO: renamed from: m */
    public static int f170m = 50;

    /* JADX INFO: renamed from: a */
    public static RecordStore f148a = null;

    /* JADX INFO: renamed from: a */
    public static void m67a() {
        try {
            f148a = RecordStore.openRecordStore("SpeedSpirit", false);
            f148a.closeRecordStore();
        } catch (RecordStoreException e) {
        }
        try {
            f148a = RecordStore.openRecordStore("SpeedSpirit", false);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(f148a.getRecord(1));
            DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
            f144a = dataInputStream.readUTF();
            f155b = dataInputStream.readUTF();
            f151a = dataInputStream.readBoolean();
            f157b = dataInputStream.readBoolean();
            f159c = dataInputStream.readBoolean();
            for (int i = 0; i < f152a.length; i++) {
                f152a[i] = dataInputStream.readLong();
            }
            f150a = dataInputStream.readShort();
            f139a = dataInputStream.readInt();
            f156b = dataInputStream.readShort();
            m68a(f156b);
            f161d = dataInputStream.readBoolean();
            dataInputStream.close();
            byteArrayInputStream.close();
            f148a.closeRecordStore();
            f148a = null;
        } catch (IOException e2) {
        } catch (RecordStoreException e3) {
        }
    }

    /* JADX INFO: renamed from: a */
    public static void m68a(short s) {
        C0039bl.f354a = s;
        C0076m.f515a = s;
        f156b = s;
        switch (s) {
            case 0:
                f162e = 4;
                f163f = 2;
                f164g = 32;
                f165h = 64;
                f166i = 512;
                f167j = 1024;
                f168k = 1048576;
                f169l = 2097152;
                break;
            case 1:
                f162e = 2;
                f163f = 32;
                f164g = 64;
                f165h = 4;
                f166i = 1024;
                f167j = 512;
                f168k = 1048576;
                f169l = 2097152;
                break;
            case 2:
                f162e = 64;
                f163f = 4;
                f164g = 2;
                f165h = 32;
                f166i = 512;
                f167j = 1024;
                f168k = 2097152;
                f169l = 1048576;
                break;
        }
    }

    /* JADX INFO: renamed from: b */
    public static void m69b() {
        try {
            RecordStore.deleteRecordStore("SpeedSpirit");
        } catch (RecordStoreException e) {
        }
        try {
            f148a = RecordStore.openRecordStore("SpeedSpirit", true);
        } catch (RecordStoreException e2) {
        }
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
            dataOutputStream.writeUTF(f144a);
            dataOutputStream.writeUTF(f155b);
            dataOutputStream.writeBoolean(f151a);
            dataOutputStream.writeBoolean(f157b);
            dataOutputStream.writeBoolean(f159c);
            for (int i = 0; i < f152a.length; i++) {
                dataOutputStream.writeLong(f152a[i]);
            }
            dataOutputStream.writeShort(f150a);
            dataOutputStream.writeInt(f139a);
            dataOutputStream.writeShort(f156b);
            dataOutputStream.writeBoolean(f161d);
            dataOutputStream.close();
            byteArrayOutputStream.close();
            f148a.addRecord(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.toByteArray().length);
            f148a.closeRecordStore();
            f148a = null;
        } catch (IOException e3) {
        } catch (RecordStoreException e4) {
        }
    }
}
