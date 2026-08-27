package p001a.p002a.p003a.p004a;

import com.nokia.mid.sound.Sound;
import com.nokia.mid.ui.DeviceControl;
import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Gauge;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.media.Player;
import javax.microedition.media.PlayerListener;
import javax.microedition.rms.RecordStore;

/* JADX INFO: renamed from: a.a.a.a.a */
/* JADX INFO: loaded from: C:\Temp\jadx-6965330237357844059\classes.dex */
public class RunnableC0001a extends Canvas implements Runnable, PlayerListener {

    /* JADX INFO: renamed from: A */
    public static C0002b f357A = null;

    /* JADX INFO: renamed from: D */
    public static final int f358D = 9;

    /* JADX INFO: renamed from: E */
    public static final int f359E = 3;

    /* JADX INFO: renamed from: G */
    public static Graphics f360G = null;

    /* JADX INFO: renamed from: a */
    public static final int f361a = 2;

    /* JADX INFO: renamed from: b */
    public static int[] f362b = null;

    /* JADX INFO: renamed from: c */
    private static long[] f363c = null;

    /* JADX INFO: renamed from: case, reason: not valid java name */
    public static final int f472case = -7;

    /* JADX INFO: renamed from: else, reason: not valid java name */
    public static final int f473else = 6;

    /* JADX INFO: renamed from: g */
    public static int[] f364g = null;

    /* JADX INFO: renamed from: i */
    public static final int f365i = 11;

    /* JADX INFO: renamed from: k */
    public static final int f366k = 7;

    /* JADX INFO: renamed from: new, reason: not valid java name */
    public static Image f474new = null;

    /* JADX INFO: renamed from: null, reason: not valid java name */
    public static final int f475null = 4;

    /* JADX INFO: renamed from: o */
    public static final int f367o = 10;

    /* JADX INFO: renamed from: p */
    public static final int f368p = 13;

    /* JADX INFO: renamed from: r */
    public static final int f369r = 8;

    /* JADX INFO: renamed from: t */
    public static final int f370t = 12;

    /* JADX INFO: renamed from: v */
    public static final int f371v = -6;

    /* JADX INFO: renamed from: x */
    public static final int f372x = 1;

    /* JADX INFO: renamed from: z */
    public static final int f373z = 5;

    /* JADX INFO: renamed from: B */
    public int f374B;

    /* JADX INFO: renamed from: C */
    public boolean f375C;

    /* JADX INFO: renamed from: F */
    public boolean f376F;

    /* JADX INFO: renamed from: H */
    public int f377H;

    /* JADX INFO: renamed from: byte, reason: not valid java name */
    public int f476byte;

    /* JADX INFO: renamed from: char, reason: not valid java name */
    public boolean f477char;

    /* JADX INFO: renamed from: d */
    public int f378d;

    /* JADX INFO: renamed from: do */
    public int f379do;

    /* JADX INFO: renamed from: e */
    public int f380e;

    /* JADX INFO: renamed from: f */
    public Random f381f;

    /* JADX INFO: renamed from: for, reason: not valid java name */
    public boolean f478for;

    /* JADX INFO: renamed from: goto, reason: not valid java name */
    public int f479goto;

    /* JADX INFO: renamed from: h */
    public boolean f382h;

    /* JADX INFO: renamed from: if */
    public String[] f383if;

    /* JADX INFO: renamed from: int, reason: not valid java name */
    public int f480int;

    /* JADX INFO: renamed from: j */
    public int[] f384j;

    /* JADX INFO: renamed from: l */
    public Object f385l;

    /* JADX INFO: renamed from: long, reason: not valid java name */
    public int f481long;

    /* JADX INFO: renamed from: m */
    public Command f386m;

    /* JADX INFO: renamed from: n */
    public int f387n;

    /* JADX INFO: renamed from: q */
    public boolean f388q;

    /* JADX INFO: renamed from: s */
    public int[][] f389s;

    /* JADX INFO: renamed from: try, reason: not valid java name */
    public int f482try;

    /* JADX INFO: renamed from: u */
    public Thread f390u;

    /* JADX INFO: renamed from: void, reason: not valid java name */
    public int f483void;

    /* JADX INFO: renamed from: w */
    public Command f391w;

    /* JADX INFO: renamed from: y */
    public CommandListener f392y;

    public RunnableC0001a() {
        this.f386m = new Command("", 1, 0);
        this.f391w = new Command("", 1, 0);
        this.f377H = 2;
        this.f380e = -6;
        this.f381f = new Random();
    }

    public RunnableC0001a(int i, Object obj) {
        this.f386m = new Command("", 1, 0);
        this.f391w = new Command("", 1, 0);
        this.f377H = 2;
        this.f380e = -6;
        this.f381f = new Random();
        this.f377H = i;
        this.f385l = obj;
    }

    /* JADX INFO: renamed from: a */
    private static int m55a(byte[] bArr, int i, int i2) {
        if (f363c == null) {
            f363c = new long[256];
            int i3 = 0;
            while (true) {
                int i4 = i3;
                if (i4 >= 256) {
                    break;
                }
                long j = i4;
                int i5 = 0;
                while (i5 < 8) {
                    i5++;
                    j = (1 & j) == 1 ? 3988292384L ^ (j >> 1) : j >> 1;
                }
                f363c[i4] = j;
                i3 = i4 + 1;
            }
        }
        long j2 = 4294967295L;
        while (i < i2) {
            j2 = (j2 >> 8) ^ f363c[(int) ((((long) bArr[i]) ^ j2) & 255)];
            i++;
        }
        return (int) (j2 ^ 4294967295L);
    }

    /* JADX INFO: renamed from: a */
    public static Image m56a(byte[] bArr) {
        int i = 1;
        int i2 = ((bArr[2] & 255) << 8) | (bArr[3] & 255);
        int i3 = ((bArr[4] & 255) << 8) | (bArr[5] & 255);
        int i4 = (i3 * i2) + ((i3 * i2) / i2);
        byte[] bArr2 = new byte[((bArr[6] & 128) > 0 ? 13 : 0) + ((bArr[7] < 0 ? bArr[7] + 256 : bArr[7]) * 3) + 41 + 4 + 12 + 11 + i4 + 12];
        bArr2[0] = -119;
        bArr2[1] = 80;
        bArr2[2] = 78;
        bArr2[3] = 71;
        bArr2[4] = 13;
        bArr2[5] = 10;
        bArr2[6] = 26;
        bArr2[7] = 10;
        bArr2[8] = 0;
        bArr2[9] = 0;
        bArr2[10] = 0;
        bArr2[11] = 13;
        bArr2[12] = 73;
        bArr2[13] = 72;
        bArr2[14] = 68;
        bArr2[15] = 82;
        bArr2[16] = (byte) (i2 >> 24);
        bArr2[17] = (byte) (i2 >> 16);
        bArr2[18] = (byte) (i2 >> 8);
        bArr2[19] = (byte) i2;
        bArr2[20] = (byte) (i3 >> 24);
        bArr2[21] = (byte) (i3 >> 16);
        bArr2[22] = (byte) (i3 >> 8);
        bArr2[23] = (byte) i3;
        bArr2[24] = (byte) ((bArr[6] >> 3) & 15);
        bArr2[25] = (byte) (bArr[6] & 7);
        int iM55a = m55a(bArr2, 12, 29);
        bArr2[29] = (byte) (iM55a >> 24);
        bArr2[30] = (byte) (iM55a >> 16);
        bArr2[31] = (byte) (iM55a >> 8);
        bArr2[32] = (byte) iM55a;
        int i5 = bArr[7];
        if (i5 < 0) {
            i5 += 256;
        }
        bArr2[33] = (byte) ((i5 * 3) >> 24);
        bArr2[34] = (byte) ((i5 * 3) >> 16);
        bArr2[35] = (byte) ((i5 * 3) >> 8);
        bArr2[36] = (byte) (i5 * 3);
        bArr2[37] = 80;
        bArr2[38] = 76;
        bArr2[39] = 84;
        bArr2[40] = 69;
        System.arraycopy(bArr, 8, bArr2, 41, i5 * 3);
        int i6 = (i5 * 3) + 41;
        int iM55a2 = m55a(bArr2, 37, i6);
        int i7 = i6 + 1;
        bArr2[i6] = (byte) (iM55a2 >> 24);
        int i8 = i7 + 1;
        bArr2[i7] = (byte) (iM55a2 >> 16);
        int i9 = i8 + 1;
        bArr2[i8] = (byte) (iM55a2 >> 8);
        int i10 = i9 + 1;
        bArr2[i9] = (byte) iM55a2;
        int i11 = (i5 * 3) + 12 + 37;
        if ((bArr[6] & 128) > 0) {
            int i12 = i10 + 3;
            int i13 = i12 + 1;
            bArr2[i12] = 1;
            int i14 = i13 + 1;
            bArr2[i13] = 116;
            int i15 = i14 + 1;
            bArr2[i14] = 82;
            int i16 = i15 + 1;
            bArr2[i15] = 78;
            bArr2[i16] = 83;
            int i17 = i16 + 1 + 1;
            int iM55a3 = m55a(bArr2, i11, i17);
            int i18 = i17 + 1;
            bArr2[i17] = (byte) (iM55a3 >> 24);
            int i19 = i18 + 1;
            bArr2[i18] = (byte) (iM55a3 >> 16);
            int i20 = i19 + 1;
            bArr2[i19] = (byte) (iM55a3 >> 8);
            i10 = i20 + 1;
            bArr2[i20] = (byte) iM55a3;
            i11 += 13;
        }
        int i21 = i10 + 1;
        bArr2[i10] = (byte) ((i4 + 11) >> 24);
        int i22 = i21 + 1;
        bArr2[i21] = (byte) ((i4 + 11) >> 16);
        int i23 = i22 + 1;
        bArr2[i22] = (byte) ((i4 + 11) >> 8);
        int i24 = i23 + 1;
        bArr2[i23] = (byte) (i4 + 11);
        int i25 = i24 + 1;
        bArr2[i24] = 73;
        int i26 = i25 + 1;
        bArr2[i25] = 68;
        int i27 = i26 + 1;
        bArr2[i26] = 65;
        int i28 = i27 + 1;
        bArr2[i27] = 84;
        int i29 = i28 + 1;
        bArr2[i28] = 120;
        int i30 = i29 + 1;
        bArr2[i29] = -38;
        int i31 = i30 + 1;
        bArr2[i30] = 1;
        int i32 = i31 + 1;
        bArr2[i31] = (byte) (i4 & 255);
        int i33 = i32 + 1;
        bArr2[i32] = (byte) ((i4 >> 8) & 255);
        int i34 = i33 + 1;
        bArr2[i33] = (byte) ((i4 ^ 255) & 255);
        bArr2[i34] = (byte) (((i4 >> 8) ^ 255) & 255);
        int i35 = i34 + 1 + 1;
        for (int i36 = 0; i36 < i3; i36++) {
            System.arraycopy(bArr, (i5 * 3) + 8 + (i36 * i2), bArr2, i35, i2);
            i35 += i2 + 1;
        }
        int i37 = i35 - 1;
        int i38 = 0;
        for (int i39 = i37 - i4; i39 < i37; i39++) {
            i = (i + (bArr2[i39] & 255)) % 65521;
            i38 = (i38 + i) % 65521;
        }
        int i40 = (i38 << 16) + i;
        int i41 = i37 + 1;
        bArr2[i37] = (byte) ((i40 >> 24) & 255);
        int i42 = i41 + 1;
        bArr2[i41] = (byte) ((i40 >> 16) & 255);
        int i43 = i42 + 1;
        bArr2[i42] = (byte) ((i40 >> 8) & 255);
        int i44 = i43 + 1;
        bArr2[i43] = (byte) (i40 & 255);
        int iM55a4 = m55a(bArr2, i11, i44);
        int i45 = i44 + 1;
        bArr2[i44] = (byte) (iM55a4 >> 24);
        int i46 = i45 + 1;
        bArr2[i45] = (byte) (iM55a4 >> 16);
        int i47 = i46 + 1;
        bArr2[i46] = (byte) (iM55a4 >> 8);
        bArr2[i47] = (byte) iM55a4;
        int i48 = i47 + 1 + 4;
        int i49 = i48 + 1;
        bArr2[i48] = 73;
        int i50 = i49 + 1;
        bArr2[i49] = 69;
        int i51 = i50 + 1;
        bArr2[i50] = 78;
        int i52 = i51 + 1;
        bArr2[i51] = 68;
        int i53 = i52 + 1;
        bArr2[i52] = -82;
        int i54 = i53 + 1;
        bArr2[i53] = 66;
        int i55 = i54 + 1;
        bArr2[i54] = 96;
        int i56 = i55 + 1;
        bArr2[i55] = -126;
        return Image.createImage(bArr2, 0, bArr2.length);
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m57a(InputStream inputStream) {
        byte[] bArr = null;
        try {
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            bArr = new byte[dataInputStream.readInt()];
            dataInputStream.readFully(bArr);
            dataInputStream.close();
            return bArr;
        } catch (Exception e) {
            return bArr;
        }
    }

    /* JADX INFO: renamed from: a */
    public static byte[] m58a(byte[] bArr, int i) {
        int i2 = bArr[7];
        int i3 = i2 < 0 ? i2 + 256 : i2;
        if (i < 0) {
            for (int i4 = 0; i4 < i3 * 3; i4++) {
                int i5 = bArr[i4 + 8];
                if (i5 < 0) {
                    i5 += 256;
                }
                int i6 = i5 - (((((-i) << 16) / 100) * i5) >> 16);
                if (i6 < 0) {
                    i6 = 0;
                }
                bArr[i4 + 8] = (byte) i6;
            }
        } else {
            for (int i7 = 0; i7 < i3 * 3; i7++) {
                int i8 = bArr[i7 + 8];
                if (i8 < 0) {
                    i8 += 256;
                }
                int i9 = i8 + ((((i << 16) / 100) * i8) >> 16);
                if (i9 > 255) {
                    i9 = 255;
                }
                bArr[i7 + 8] = (byte) i9;
            }
        }
        return bArr;
    }

    /* JADX INFO: renamed from: a */
    public int m59a(char c) {
        return !f357A.f436af ? f357A.f411C[c].getWidth() : f357A.f437ag.charWidth(c);
    }

    /* JADX INFO: renamed from: a */
    public int m60a(String str) {
        if (f357A.f436af) {
            int iStringWidth = str.indexOf("\n") == -1 ? f357A.f437ag.stringWidth(str) : 0;
            while (str.indexOf("\n") != -1) {
                iStringWidth = Math.max(iStringWidth, f357A.f437ag.stringWidth(str.substring(0, str.indexOf("\n"))));
                str = str.substring(str.indexOf("\n") + 1);
            }
            return Math.max(iStringWidth, f357A.f437ag.stringWidth(str));
        }
        int i = 0;
        int iMax = 0;
        int width = 0;
        while (i < str.length()) {
            char cCharAt = str.charAt(i);
            if (cCharAt == 65535) {
                width += f357A.f442am;
            } else if (cCharAt == 65534) {
                iMax = Math.max(iMax, width);
                width = 0;
            } else {
                width += (i < str.length() + (-1) ? f357A.f444ao : (byte) 1) + f357A.f411C[str.charAt(i)].getWidth();
            }
            i++;
        }
        return Math.max(iMax, width);
    }

    /* JADX INFO: renamed from: a */
    public String m61a(String str, int i) {
        String string = "";
        int i2 = 0;
        String string2 = new StringBuffer().append(str).append(f357A.f434ac).toString();
        while (string2.indexOf(f357A.f434ac) != -1) {
            String strSubstring = string2.substring(0, string2.indexOf(f357A.f434ac));
            string2 = string2.substring(string2.indexOf(f357A.f434ac) + 1);
            while (strSubstring.indexOf(f357A.f420M) != -1) {
                String strSubstring2 = strSubstring.substring(0, strSubstring.indexOf(f357A.f420M));
                int iM60a = m60a(strSubstring2);
                String strSubstring3 = strSubstring.substring(strSubstring.indexOf(f357A.f420M) + 1, strSubstring.length());
                if ((i2 > 0 ? f357A.f442am : (byte) 0) + i2 + iM60a <= i) {
                    string = new StringBuffer().append(string).append(i2 > 0 ? new StringBuffer().append("").append(f357A.f434ac).toString() : "").append(strSubstring2).append(f357A.f420M).toString();
                } else if (iM60a <= i) {
                    string = new StringBuffer().append(string).append(f357A.f420M).append(strSubstring2).append(f357A.f420M).toString();
                } else {
                    if (string.length() > 0) {
                        string = new StringBuffer().append(string).append(f357A.f420M).toString();
                    }
                    int i3 = 0;
                    int iM59a = 0;
                    String string3 = string;
                    while (i3 < strSubstring2.length()) {
                        if ((iM59a > 0 ? f357A.f444ao : (byte) 0) + iM59a + m59a(strSubstring2.charAt(i3)) <= i) {
                            string3 = new StringBuffer().append(string3).append(strSubstring2.charAt(i3)).toString();
                            iM59a += (iM59a > 0 ? f357A.f444ao : (byte) 0) + m59a(strSubstring2.charAt(i3));
                        } else if (this.f478for) {
                            string3 = new StringBuffer().append(string3).append(f357A.f420M).toString();
                            i3--;
                            iM59a = 0;
                        } else {
                            string3 = new StringBuffer().append(string3.substring(0, string3.length() - 1)).append(f357A.f427U).append(f357A.f420M).toString();
                            i3 -= 2;
                            iM59a = 0;
                        }
                        i3++;
                    }
                    string = new StringBuffer().append(string3).append(f357A.f420M).toString();
                }
                strSubstring = strSubstring3;
                i2 = 0;
            }
            int iM60a2 = m60a(strSubstring);
            if ((i2 > 0 ? f357A.f442am : (byte) 0) + i2 + iM60a2 <= i) {
                String string4 = new StringBuffer().append(string).append(i2 > 0 ? new StringBuffer().append("").append(f357A.f434ac).toString() : "").append(strSubstring).toString();
                i2 += (i2 > 0 ? f357A.f442am : (byte) 0) + iM60a2;
                string = string4;
            } else if (iM60a2 <= i) {
                string = new StringBuffer().append(string).append(f357A.f420M).append(strSubstring).toString();
                i2 = iM60a2;
            } else {
                if (string.length() > 0) {
                    string = new StringBuffer().append(string).append(f357A.f420M).toString();
                }
                int i4 = 0;
                int iM59a2 = 0;
                String string5 = string;
                while (i4 < strSubstring.length()) {
                    if ((iM59a2 > 0 ? f357A.f444ao : (byte) 0) + iM59a2 + m59a(strSubstring.charAt(i4)) <= i) {
                        string5 = new StringBuffer().append(string5).append(strSubstring.charAt(i4)).toString();
                        iM59a2 += (iM59a2 > 0 ? f357A.f444ao : (byte) 0) + m59a(strSubstring.charAt(i4));
                    } else if (this.f478for) {
                        string5 = new StringBuffer().append(string5).append(f357A.f420M).toString();
                        i4--;
                        iM59a2 = 0;
                    } else {
                        string5 = new StringBuffer().append(string5.substring(0, string5.length() - 1)).append(f357A.f427U).append(f357A.f420M).toString();
                        i4 -= 2;
                        iM59a2 = 0;
                    }
                    i4++;
                }
                i2 = iM59a2;
                string = string5;
            }
        }
        return string;
    }

    /* JADX INFO: renamed from: a */
    public String m62a(String str, String str2, String str3) {
        return str.indexOf(str2) != -1 ? new StringBuffer().append(str.substring(0, str.indexOf(str2))).append(str3).append(str.substring(str.indexOf(str2) + str2.length(), str.length())).toString() : str;
    }

    /* JADX INFO: renamed from: a */
    public String m63a(String str, String[] strArr) {
        boolean z;
        String string = "";
        if (f357A.f436af) {
            return str;
        }
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt == ' ') {
                string = new StringBuffer().append(string).append((char) 65535).toString();
            } else if (cCharAt == '\n' || cCharAt == '\r') {
                string = new StringBuffer().append(string).append((char) 65534).toString();
            } else {
                char c = 0;
                while (true) {
                    if (c >= strArr.length) {
                        z = false;
                        break;
                    }
                    if (strArr[c].indexOf(cCharAt) != -1) {
                        string = new StringBuffer().append(string).append(c).toString();
                        z = true;
                        break;
                    }
                    c = (char) (c + 1);
                }
                if (!z) {
                    f357A.f436af = true;
                }
            }
        }
        return f357A.f436af ? str : string;
    }

    /* JADX INFO: renamed from: a */
    public void mo24a() {
    }

    /* JADX INFO: renamed from: a */
    public void m64a(int i, int i2) {
        m66a(i, i2, false);
    }

    /* JADX INFO: renamed from: a */
    public void m65a(int i, int i2, int i3) {
        while (i > 0 && i < 1000) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = (i << 16) / 1000;
            this.f479goto = ((((int) ((j * j) / 65536)) * getWidth()) >> 16) * i3 * i2;
            m122long();
            i += ((int) (System.currentTimeMillis() - jCurrentTimeMillis)) * i2;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m66a(int i, int i2, boolean z) {
        try {
            if (this.f376F || z) {
                f357A.f455do.vibrate(i2);
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: renamed from: a */
    public void mo29a(int i, Gauge gauge) {
    }

    /* JADX INFO: renamed from: a */
    public void m67a(Object obj) {
        try {
            if (this.f477char) {
                if (obj instanceof Sound) {
                    ((Sound) obj).play(1);
                } else if (obj instanceof Player) {
                    ((Player) obj).removePlayerListener(this);
                    ((Player) obj).addPlayerListener(this);
                    ((Player) obj).start();
                }
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: renamed from: a */
    public void mo31a(Gauge gauge) {
    }

    /* JADX INFO: renamed from: a */
    public void mo32a(Graphics graphics) {
    }

    /* JADX INFO: renamed from: a */
    public void m68a(Graphics graphics, String str, Image[] imageArr, int i, int i2, int i3) {
        int iM60a;
        int iM60a2;
        int iM60a3;
        int iM60a4;
        if ((i3 & 32) > 0) {
            i2 -= m76if(str) - f357A.f440aj;
        }
        if (f357A.f436af) {
            graphics.setColor(f357A.f415G);
            graphics.setFont(f357A.f437ag);
            while (str.indexOf("\n") != -1) {
                graphics.drawString(str.substring(0, str.indexOf("\n")), i, i2, i3);
                str = str.substring(str.indexOf("\n") + 1);
                i2 += f357A.f440aj + f357A.f431Z;
            }
            graphics.drawString(str, i, i2, i3);
            return;
        }
        while (i2 < graphics.getClipY() && f357A.f440aj + i2 < graphics.getClipY()) {
            str = str.indexOf(65534) != -1 ? str.substring(str.indexOf(65534) + 1) : "";
            i2 += f357A.f440aj + f357A.f431Z;
        }
        if ((i3 & 8) > 0) {
            iM60a = i - (str.indexOf(65534) == -1 ? m60a(str) : m60a(str.substring(0, str.indexOf(65534))));
        } else {
            iM60a = i;
        }
        if ((i3 & 1) > 0) {
            iM60a2 = iM60a - (str.indexOf(65534) == -1 ? m60a(str) / 2 : m60a(str.substring(0, str.indexOf(65534))) / 2);
        } else {
            iM60a2 = iM60a;
        }
        int i4 = 0;
        int i5 = iM60a2;
        while (i4 < str.length()) {
            char cCharAt = str.charAt(i4);
            int i6 = i4;
            int i7 = i5;
            while (cCharAt == 65535) {
                i7 += f357A.f442am;
                i6++;
                if (i6 >= str.length()) {
                    return;
                } else {
                    cCharAt = str.charAt(i6);
                }
            }
            char cCharAt2 = cCharAt;
            int i8 = i6;
            while (cCharAt2 == 65534) {
                if ((i3 & 8) > 0) {
                    iM60a3 = i - (str.substring(i8 + 1).indexOf(65534) == -1 ? m60a(str.substring(i8 + 1)) : m60a(str.substring(i8 + 1, (i8 + 1) + str.substring(i8 + 1).indexOf(65534))));
                } else {
                    iM60a3 = i;
                }
                if ((i3 & 1) > 0) {
                    iM60a4 = iM60a3 - (str.substring(i8 + 1).indexOf(65534) == -1 ? m60a(str.substring(i8 + 1)) / 2 : m60a(str.substring(i8 + 1, (i8 + 1) + str.substring(i8 + 1).indexOf(65534))) / 2);
                } else {
                    iM60a4 = iM60a3;
                }
                i2 += f357A.f440aj + f357A.f431Z;
                if (i2 > graphics.getClipY() + graphics.getClipHeight()) {
                    str.length();
                    return;
                }
                int i9 = i8 + 1;
                if (i9 >= str.length()) {
                    return;
                }
                cCharAt2 = str.charAt(i9);
                i8 = i9;
                i7 = iM60a4;
            }
            if ((i7 > graphics.getClipX() && i7 < graphics.getClipX() + graphics.getClipWidth()) || (imageArr[cCharAt2].getWidth() + i7 > graphics.getClipX() && imageArr[cCharAt2].getWidth() + i7 < graphics.getClipX() + graphics.getClipWidth())) {
                graphics.drawImage(imageArr[cCharAt2], i7, i2, (i3 & 50) | 4);
            }
            int width = i7 + imageArr[cCharAt2].getWidth() + f357A.f444ao;
            i4 = i8 + 1;
            i5 = width;
        }
    }

    /* JADX INFO: renamed from: a */
    public void m69a(boolean z) {
        try {
            if (z) {
                DeviceControl.setLights(0, 100);
            } else {
                DeviceControl.setLights(0, 0);
            }
        } catch (Exception e) {
        }
    }

    /* JADX INFO: renamed from: a */
    public void mo35a(byte[] bArr, Gauge gauge) throws Exception {
    }

    /* JADX INFO: renamed from: a */
    public void m70a(int[] iArr) {
        if (this.f389s == null) {
            this.f389s = new int[][]{iArr};
            this.f384j = new int[iArr.length];
        } else {
            int[][] iArr2 = new int[this.f389s.length + 1][];
            for (int i = 0; i < this.f389s.length; i++) {
                iArr2[i] = this.f389s[i];
            }
            iArr2[this.f389s.length] = iArr;
            this.f389s = iArr2;
        }
        if (iArr.length > this.f384j.length) {
            this.f384j = new int[iArr.length];
        }
    }

    /* JADX INFO: renamed from: a */
    public boolean m71a(int i) {
        for (int i2 = 0; i2 < ((Object[][]) ((Object[]) this.f385l)[3]).length; i2++) {
            if (i == ((int[]) ((Object[][]) ((Object[]) this.f385l)[3])[i2][1])[0] || (getGameAction(i) == 8 && ((int[]) ((Object[][]) ((Object[]) this.f385l)[3])[i2][1])[0] == -6)) {
                f357A.commandAction((Command) ((Object[][]) ((Object[]) this.f385l)[3])[i2][2], this);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x008b  */
    /* JADX INFO: renamed from: byte, reason: not valid java name */
    public void m117byte() {
        for (int i = 0; i < ((Object[][]) ((Object[]) this.f385l)[3]).length; i++) {
            for (int i2 = 0; i2 < 3; i2++) {
                if (((int[]) ((Object[][]) ((Object[]) this.f385l)[3])[i][1])[4] != 0) {
                    int[] iArr = (int[]) ((Object[][]) ((Object[]) this.f385l)[3])[i][1];
                    iArr[1] = ((int[]) ((Object[][]) ((Object[]) this.f385l)[3])[i][1])[4] + iArr[1];
                    if (((int[]) ((Object[][]) ((Object[]) this.f385l)[3])[i][1])[1] != 0) {
                        if (((int[]) ((Object[][]) ((Object[]) this.f385l)[3])[i][1])[2] + ((int[]) ((Object[][]) ((Object[]) this.f385l)[3])[i][1])[1] == (getWidth() / 7) * 3) {
                            ((int[]) ((Object[][]) ((Object[]) this.f385l)[3])[i][1])[4] = -((int[]) ((Object[][]) ((Object[]) this.f385l)[3])[i][1])[4];
                        }
                    } else {
                        ((int[]) ((Object[][]) ((Object[]) this.f385l)[3])[i][1])[4] = -((int[]) ((Object[][]) ((Object[]) this.f385l)[3])[i][1])[4];
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: case, reason: not valid java name */
    public void m118case() {
        f474new.getRGB(f364g, 0, getWidth(), 0, 0, getWidth(), getHeight());
        int i = (this.f481long << 16) / 1000;
        for (int i2 = 0; i2 < f364g.length; i2++) {
            int i3 = (f362b[i2] >> 16) & 255;
            int i4 = (f362b[i2] >> 8) & 255;
            int i5 = f362b[i2] & 255;
            f364g[i2] = ((i3 + (((((f364g[i2] >> 16) & 255) - i3) * i) >> 16)) << 16) | ((i4 + (((((f364g[i2] >> 8) & 255) - i4) * i) >> 16)) << 8) | (((((f364g[i2] & 255) - i5) * i) >> 16) + i5);
        }
    }

    /* JADX INFO: renamed from: char, reason: not valid java name */
    public void m119char() {
        this.f481long = 0;
        while (this.f481long < 1000) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            m118case();
            m122long();
            this.f481long = ((int) (System.currentTimeMillis() - jCurrentTimeMillis)) + this.f481long;
        }
    }

    /* JADX INFO: renamed from: do */
    public int m72do(int i) {
        if (!this.f375C) {
            return -1;
        }
        this.f384j[this.f378d] = i;
        this.f378d++;
        int i2 = -1;
        for (int i3 = 0; i3 < this.f389s.length; i3++) {
            if (this.f389s[i3].length <= this.f378d) {
                int i4 = i3;
                for (int i5 = 0; i5 < this.f389s[i3].length; i5++) {
                    if (this.f389s[i3][i5] != this.f384j[i5]) {
                        i4 = -1;
                    }
                }
                if (i4 != -1) {
                    this.f378d = 0;
                    f357A.m85a(false, false);
                    f357A.f449aw.showNotify();
                }
                i2 = i4;
            }
        }
        if (this.f378d != this.f384j.length) {
            return i2;
        }
        this.f378d--;
        for (int i6 = 0; i6 < this.f384j.length - 1; i6++) {
            this.f384j[i6] = this.f384j[i6 + 1];
        }
        return i2;
    }

    /* JADX INFO: renamed from: do */
    public void m73do() {
        this.f476byte = 0;
        while (this.f476byte < 1000) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            m125try();
            m122long();
            this.f476byte = ((int) (System.currentTimeMillis() - jCurrentTimeMillis)) + this.f476byte;
        }
    }

    /* JADX INFO: renamed from: do */
    public void m74do(String str) {
        int[] iArr = new int[str.length()];
        for (int i = 0; i < iArr.length; i++) {
            if (str.charAt(i) == '0') {
                iArr[i] = 48;
            }
            if (str.charAt(i) == '1') {
                iArr[i] = 49;
            }
            if (str.charAt(i) == '2' || ((str.charAt(i) >= 'a' && str.charAt(i) <= 'c') || (str.charAt(i) >= 'A' && str.charAt(i) <= 'C'))) {
                iArr[i] = 50;
            }
            if (str.charAt(i) == '3' || ((str.charAt(i) >= 'd' && str.charAt(i) <= 'f') || (str.charAt(i) >= 'D' && str.charAt(i) <= 'F'))) {
                iArr[i] = 51;
            }
            if (str.charAt(i) == '4' || ((str.charAt(i) >= 'g' && str.charAt(i) <= 'i') || (str.charAt(i) >= 'G' && str.charAt(i) <= 'I'))) {
                iArr[i] = 52;
            }
            if (str.charAt(i) == '5' || ((str.charAt(i) >= 'j' && str.charAt(i) <= 'l') || (str.charAt(i) >= 'J' && str.charAt(i) <= 'L'))) {
                iArr[i] = 53;
            }
            if (str.charAt(i) == '6' || ((str.charAt(i) >= 'm' && str.charAt(i) <= 'o') || (str.charAt(i) >= 'M' && str.charAt(i) <= 'O'))) {
                iArr[i] = 54;
            }
            if (str.charAt(i) == '7' || ((str.charAt(i) >= 'p' && str.charAt(i) <= 's') || (str.charAt(i) >= 'P' && str.charAt(i) <= 'S'))) {
                iArr[i] = 55;
            }
            if (str.charAt(i) == '8' || ((str.charAt(i) >= 't' && str.charAt(i) <= 'v') || (str.charAt(i) >= 'T' && str.charAt(i) <= 'V'))) {
                iArr[i] = 56;
            }
            if (str.charAt(i) == '9' || ((str.charAt(i) >= 'w' && str.charAt(i) <= 'z') || (str.charAt(i) >= 'W' && str.charAt(i) <= 'Z'))) {
                iArr[i] = 57;
            }
            if (str.charAt(i) == '*') {
                iArr[i] = 42;
            }
            if (str.charAt(i) == '#') {
                iArr[i] = 35;
            }
        }
        m70a(iArr);
    }

    /* JADX INFO: renamed from: do */
    public byte[] mo43do(Gauge gauge) {
        return null;
    }

    /* JADX INFO: renamed from: else, reason: not valid java name */
    public void m120else() {
        this.f481long = 1000;
        while (this.f481long > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            m118case();
            m122long();
            this.f481long -= (int) (System.currentTimeMillis() - jCurrentTimeMillis);
        }
        this.f481long = 1000;
    }

    /* JADX INFO: renamed from: for */
    public void mo106for() {
    }

    /* JADX INFO: renamed from: goto */
    public boolean mo110goto() {
        return false;
    }

    public void hideNotify() {
    }

    /* JADX INFO: renamed from: if */
    public int m75if(int i) {
        int iNextInt = this.f381f.nextInt();
        if (iNextInt < 0) {
            iNextInt = -(iNextInt + 1);
        }
        return iNextInt / (Integer.MAX_VALUE / i);
    }

    /* JADX INFO: renamed from: if */
    public int m76if(String str) {
        int i = 0;
        byte b = f357A.f440aj;
        if (f357A.f436af) {
            f357A.f437ag.getHeight();
        }
        int i2 = 0;
        while (true) {
            int i3 = i;
            if (i2 >= str.length()) {
                return ((i3 + 1) * f357A.f440aj) + (f357A.f431Z * i3);
            }
            i = str.charAt(i2) == f357A.f420M ? i3 + 1 : i3;
            i2++;
        }
    }

    /* JADX INFO: renamed from: if */
    public void m77if() {
        this.f479goto = 0;
        this.f483void = 0;
        switch (m75if(4)) {
            case 0:
                m78if(999, -1, -1);
                break;
            case 1:
                m78if(999, -1, 1);
                break;
            case 2:
                m65a(999, -1, -1);
                break;
            case 3:
                m65a(999, -1, 1);
                break;
        }
        this.f479goto = 0;
        this.f483void = 0;
    }

    /* JADX INFO: renamed from: if */
    public void m78if(int i, int i2, int i3) {
        while (i > 0 && i < 1000) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            long j = (i << 16) / 1000;
            this.f483void = ((((int) ((j * j) / 65536)) * getHeight()) >> 16) * i3 * i2;
            m122long();
            i += ((int) (System.currentTimeMillis() - jCurrentTimeMillis)) * i2;
        }
    }

    /* JADX INFO: renamed from: if */
    public void mo52if(Gauge gauge) {
    }

    /* JADX INFO: renamed from: if */
    public void m79if(Graphics graphics) {
        for (int i = 0; i < ((Object[][]) ((Object[]) this.f385l)[3]).length; i++) {
            graphics.setClip(((int[]) ((Object[][]) ((Object[]) this.f385l)[3])[i][1])[3] + this.f479goto, (this.f483void + getHeight()) - f357A.f440aj, (getWidth() / 7) * 3, f357A.f440aj);
            m68a(graphics, (String) ((Object[][]) ((Object[]) this.f385l)[3])[i][0], f357A.f411C, this.f479goto + ((int[]) ((Object[][]) ((Object[]) this.f385l)[3])[i][1])[3] + ((int[]) ((Object[][]) ((Object[]) this.f385l)[3])[i][1])[1], (this.f483void + getHeight()) - f357A.f440aj, 20);
            graphics.setClip(0, 0, getWidth(), getHeight());
        }
    }

    /* JADX INFO: renamed from: int, reason: not valid java name */
    public void m121int() {
        this.f476byte = 1000;
        while (this.f476byte > 0) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            m125try();
            m122long();
            this.f476byte -= (int) (System.currentTimeMillis() - jCurrentTimeMillis);
        }
        this.f476byte = 1000;
    }

    public void keyPressed(int i) {
        if (this.f388q) {
            if (this.f377H == 1) {
                ((int[]) ((Object[]) this.f385l)[2])[3] = 1;
            }
            if (this.f377H == 9 || this.f377H == 10 || this.f377H == 3 || this.f377H == 11) {
                boolean zM71a = m71a(i);
                if (this.f377H == 9 && !zM71a) {
                    if (((f357A.f425S == 1 && (getGameAction(i) == 2 || i == 52)) || (f357A.f425S == 2 && (getGameAction(i) == 1 || i == 50))) && ((int[]) ((Object[]) this.f385l)[2])[0] > 0) {
                        int[] iArr = (int[]) ((Object[]) this.f385l)[2];
                        iArr[0] = iArr[0] - 1;
                    }
                    if (((f357A.f425S == 1 && (getGameAction(i) == 5 || i == 54)) || (f357A.f425S == 2 && (getGameAction(i) == 6 || i == 56))) && ((int[]) ((Object[]) this.f385l)[2])[0] < ((String[]) ((Object[]) this.f385l)[1]).length - 1) {
                        int[] iArr2 = (int[]) ((Object[]) this.f385l)[2];
                        iArr2[0] = iArr2[0] + 1;
                    }
                }
                if (this.f377H == 10 && !zM71a) {
                    if ((getGameAction(i) == 1 || i == 50) && ((int[]) ((Object[]) this.f385l)[4])[0] < 0) {
                        int[] iArr3 = (int[]) ((Object[]) this.f385l)[4];
                        iArr3[0] = iArr3[0] + f357A.f440aj + f357A.f431Z;
                    }
                    if ((getGameAction(i) == 6 || i == 56) && (-((int[]) ((Object[]) this.f385l)[4])[0]) < ((int[]) ((Object[]) this.f385l)[4])[1] - (((getHeight() - (f357A.f440aj * 2)) - f357A.f431Z) - (f357A.f454d[0].getHeight() * 2))) {
                        int[] iArr4 = (int[]) ((Object[]) this.f385l)[4];
                        iArr4[0] = iArr4[0] - (f357A.f440aj + f357A.f431Z);
                    }
                }
                if (this.f377H == 11 && !zM71a) {
                    if ((getGameAction(i) == 1 || i == 50) && f357A.f487else - (getWidth() / f357A.f495void) >= 0) {
                        f357A.f487else -= getWidth() / f357A.f495void;
                    }
                    if (getGameAction(i) == 6 || i == 56) {
                        if ((getWidth() / f357A.f495void) + f357A.f487else < (f357A.f436af ? f357A.f461m.length : f357A.f411C.length)) {
                            f357A.f487else += getWidth() / f357A.f495void;
                        }
                    }
                    if ((getGameAction(i) == 2 || i == 52) && f357A.f487else > 0) {
                        f357A.f487else--;
                    }
                    if (getGameAction(i) == 5 || i == 54) {
                        if (f357A.f487else + 1 < (f357A.f436af ? f357A.f461m.length : f357A.f411C.length)) {
                            f357A.f487else++;
                        }
                    }
                }
            }
        }
        if (this.f377H == 2 && i == this.f380e && mo110goto()) {
            C0002b c0002b = f357A;
            if (C0002b.f399ap == 1) {
                this.f481long = 0;
                mo32a(f360G);
                f474new.getRGB(f362b, 0, getWidth(), 0, 0, getWidth(), getHeight());
                f474new.getRGB(f364g, 0, getWidth(), 0, 0, getWidth(), getHeight());
            }
            f357A.f428V = 2;
            f357A.m82a();
        }
    }

    /* JADX INFO: renamed from: long, reason: not valid java name */
    public void m122long() {
        this.f382h = true;
        repaint();
        while (this.f382h) {
            try {
                Thread thread = this.f390u;
                Thread.sleep(16L);
            } catch (InterruptedException e) {
                return;
            }
        }
    }

    /* JADX INFO: renamed from: new, reason: not valid java name */
    public void m123new() {
        switch (m75if(4)) {
            case 0:
                m78if(1, 1, -1);
                break;
            case 1:
                m78if(1, 1, 1);
                break;
            case 2:
                m65a(1, 1, -1);
                break;
            case 3:
                m65a(1, 1, 1);
                break;
        }
        this.f479goto = getWidth();
        this.f483void = getHeight();
    }

    /* JADX WARN: Code duplicated, block: B:12:0x002a  */
    /* JADX WARN: Code duplicated, block: B:6:0x000e  */
    /* JADX INFO: renamed from: null, reason: not valid java name */
    public void m124null() {
        C0002b c0002b = f357A;
        if (C0002b.f399ap != 1) {
            C0002b c0002b2 = f357A;
            if (C0002b.f399ap == 2) {
                if (f474new != null || getWidth() != f474new.getWidth() || getHeight() != f474new.getHeight()) {
                    f474new = Image.createImage(getWidth(), getHeight());
                    f360G = f474new.getGraphics();
                    f364g = new int[getWidth() * getHeight()];
                }
            }
        } else if (f474new != null) {
            f474new = Image.createImage(getWidth(), getHeight());
            f360G = f474new.getGraphics();
            f364g = new int[getWidth() * getHeight()];
        } else {
            f474new = Image.createImage(getWidth(), getHeight());
            f360G = f474new.getGraphics();
            f364g = new int[getWidth() * getHeight()];
        }
        C0002b c0002b3 = f357A;
        if (C0002b.f399ap == 1) {
            if (f362b == null || f362b.length < getWidth() * getHeight()) {
                f362b = new int[getWidth() * getHeight()];
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:54:0x031a  */
    public void paint(Graphics graphics) {
        int length;
        C0002b c0002b = f357A;
        if (C0002b.f399ap != 1) {
            C0002b c0002b2 = f357A;
            if (C0002b.f399ap != 2) {
                f360G = graphics;
            }
        }
        if (this.f377H == 9) {
            if (f357A.f448av == 9) {
                mo32a(f360G);
            } else {
                f360G.setColor(f357A.f463o);
                f360G.fillRect(0, 0, getWidth(), getHeight());
                if (((Object[]) this.f385l)[0] != null) {
                    f360G.drawImage((Image) ((Object[]) this.f385l)[0], getWidth() / 2, getHeight() / 2, 3);
                }
                if (f357A.f425S == 1) {
                    f360G.setClip(this.f479goto + f357A.f454d[0].getWidth(), this.f483void + f357A.f486char, getWidth() - (f357A.f454d[0].getWidth() * 2), f357A.f440aj);
                    m68a(f360G, ((String[]) ((Object[]) this.f385l)[1])[((int[]) ((Object[]) this.f385l)[2])[0]], f357A.f411C, this.f479goto + ((int[][]) ((Object[]) this.f385l)[4])[((int[]) ((Object[]) this.f385l)[2])[0]][2] + ((int[][]) ((Object[]) this.f385l)[4])[((int[]) ((Object[]) this.f385l)[2])[0]][0], f357A.f486char + this.f483void, 20);
                    f360G.setClip(0, 0, getWidth(), getHeight());
                    if (((int[]) ((Object[]) this.f385l)[2])[0] > 0) {
                        f360G.drawImage(f357A.f454d[2], this.f479goto, this.f483void + f357A.f486char, 20);
                    }
                    if (((int[]) ((Object[]) this.f385l)[2])[0] < ((String[]) ((Object[]) this.f385l)[1]).length - 1) {
                        f360G.drawImage(f357A.f454d[3], this.f479goto + getWidth(), this.f483void + f357A.f486char, 24);
                    }
                }
                if (f357A.f425S == 2) {
                    if (((int[]) ((Object[]) this.f385l)[2])[0] > 0) {
                        int i = f357A.f415G;
                        f357A.f415G = f357A.f416H;
                        m68a(f360G, ((String[]) ((Object[]) this.f385l)[1])[((int[]) ((Object[]) this.f385l)[2])[0] - 1], f357A.f438ah, this.f479goto + ((int[][]) ((Object[]) this.f385l)[4])[((int[]) ((Object[]) this.f385l)[2])[0] - 1][2] + ((int[][]) ((Object[]) this.f385l)[4])[((int[]) ((Object[]) this.f385l)[2])[0] - 1][0], f357A.f486char + this.f483void, 20);
                        f357A.f415G = i;
                    }
                    m68a(f360G, ((String[]) ((Object[]) this.f385l)[1])[((int[]) ((Object[]) this.f385l)[2])[0]], f357A.f411C, this.f479goto + ((int[][]) ((Object[]) this.f385l)[4])[((int[]) ((Object[]) this.f385l)[2])[0]][2] + ((int[][]) ((Object[]) this.f385l)[4])[((int[]) ((Object[]) this.f385l)[2])[0]][0], f357A.f431Z + this.f483void + f357A.f486char + f357A.f440aj, 20);
                    if (((int[]) ((Object[]) this.f385l)[2])[0] < ((String[]) ((Object[]) this.f385l)[1]).length - 1) {
                        int i2 = f357A.f415G;
                        f357A.f415G = f357A.f416H;
                        m68a(f360G, ((String[]) ((Object[]) this.f385l)[1])[((int[]) ((Object[]) this.f385l)[2])[0] + 1], f357A.f438ah, this.f479goto + ((int[][]) ((Object[]) this.f385l)[4])[((int[]) ((Object[]) this.f385l)[2])[0] + 1][2] + ((int[][]) ((Object[]) this.f385l)[4])[((int[]) ((Object[]) this.f385l)[2])[0] + 1][0], (f357A.f431Z * 2) + this.f483void + f357A.f486char + (f357A.f440aj * 2), 20);
                        f357A.f415G = i2;
                    }
                    if (((int[]) ((Object[]) this.f385l)[2])[0] > 0) {
                        f360G.drawImage(f357A.f454d[0], this.f479goto + (getWidth() / 2), (this.f483void + f357A.f486char) - f357A.f454d[0].getHeight(), 17);
                    }
                    if (((int[]) ((Object[]) this.f385l)[2])[0] < ((String[]) ((Object[]) this.f385l)[1]).length - 1) {
                        f360G.drawImage(f357A.f454d[1], this.f479goto + (getWidth() / 2), this.f483void + f357A.f486char + (f357A.f440aj * 3) + (f357A.f431Z * 2), 17);
                    }
                }
                m79if(f360G);
            }
        }
        if (this.f377H == 3) {
            f357A.m84a(f360G);
            m79if(f360G);
        }
        if (this.f377H == 10) {
            f360G.setColor(f357A.f463o);
            f360G.fillRect(0, 0, getWidth(), getHeight());
            if (((Object[]) this.f385l)[0] != null) {
                f360G.drawImage((Image) ((Object[]) this.f385l)[0], getWidth() / 2, getHeight() / 2, 3);
            }
            m68a(f360G, (String) ((Object[]) this.f385l)[1], f357A.f411C, this.f479goto + ((int[]) ((Object[]) this.f385l)[4])[4] + ((int[]) ((Object[]) this.f385l)[4])[2], this.f483void, 20);
            if (((int[]) ((Object[]) this.f385l)[4])[0] < 0) {
                f360G.drawImage(f357A.f454d[0], this.f479goto + (getWidth() / 2), this.f483void + f357A.f440aj, 17);
            }
            if ((-((int[]) ((Object[]) this.f385l)[4])[0]) < ((int[]) ((Object[]) this.f385l)[4])[1] - (((getHeight() - (f357A.f440aj * 2)) - f357A.f431Z) - (f357A.f454d[0].getHeight() * 2))) {
                f360G.drawImage(f357A.f454d[1], this.f479goto + (getWidth() / 2), (((this.f483void + getHeight()) - f357A.f440aj) - f357A.f431Z) - f357A.f454d[1].getHeight(), 17);
            }
            f360G.setClip(this.f479goto, this.f483void + f357A.f440aj + f357A.f454d[0].getHeight(), getWidth(), ((getHeight() - (f357A.f440aj * 2)) - f357A.f431Z) - (f357A.f454d[0].getHeight() * 2));
            m68a(f360G, (String) ((Object[]) this.f385l)[2], f357A.f411C, (getWidth() / 2) + this.f479goto, f357A.f454d[0].getHeight() + this.f483void + f357A.f440aj + ((int[]) ((Object[]) this.f385l)[4])[0], 17);
            m79if(f360G);
        }
        if (this.f377H == 11) {
            if (f357A.f448av == 9) {
                mo32a(f360G);
            } else {
                f360G.setColor(f357A.f463o);
                f360G.fillRect(0, 0, getWidth(), getHeight());
                if (((Object[]) this.f385l)[0] != null) {
                    f360G.drawImage((Image) ((Object[]) this.f385l)[0], getWidth() / 2, getHeight() / 2, 3);
                }
                m68a(f360G, (String) ((Object[]) this.f385l)[1], f357A.f411C, this.f479goto + ((int[]) ((Object[]) this.f385l)[4])[2] + ((int[]) ((Object[]) this.f385l)[4])[0], this.f483void, 20);
                int width = getWidth() / f357A.f495void;
                if (f357A.f436af) {
                    length = f357A.f461m.length / width;
                    if (length * width != f357A.f461m.length) {
                        length++;
                    }
                } else {
                    length = f357A.f411C.length / width;
                    if (length * width != f357A.f411C.length) {
                        length++;
                    }
                }
                int width2 = (getWidth() - (f357A.f495void * width)) / 2;
                int height = f357A.f440aj + f357A.f431Z + ((((getHeight() - (f357A.f440aj * 3)) - (f357A.f431Z * 3)) - (f357A.f440aj * length)) / 2);
                int i3 = f357A.f487else / width;
                int i4 = f357A.f487else - (width * i3);
                if (height < f357A.f440aj + f357A.f431Z) {
                    height = f357A.f440aj + f357A.f431Z + ((f357A.f459j.getHeight() - f357A.f440aj) / 2);
                }
                if ((f357A.f440aj * i3) + height + (f357A.f440aj / 2) + (f357A.f459j.getHeight() / 2) > (getHeight() - (f357A.f440aj * 2)) - (f357A.f431Z * 2)) {
                    height = ((getHeight() - (f357A.f440aj * 2)) - (f357A.f431Z * 2)) - (((f357A.f440aj * i3) + (f357A.f440aj / 2)) + (f357A.f459j.getHeight() / 2));
                }
                f360G.setClip(this.f479goto, this.f483void + f357A.f440aj + f357A.f431Z, getWidth(), (getHeight() - (f357A.f440aj * 3)) - (f357A.f431Z * 3));
                int i5 = 0;
                for (int i6 = 0; i6 < length; i6++) {
                    for (int i7 = 0; i7 < width; i7++) {
                        if (!f357A.f436af && i5 < f357A.f411C.length) {
                            f360G.drawImage(f357A.f411C[i5], this.f479goto + width2 + (f357A.f495void * i7) + (f357A.f495void / 2), this.f483void + height + (f357A.f440aj * i6), 17);
                        } else if (f357A.f436af && i5 < f357A.f461m.length) {
                            f360G.drawChar(f357A.f461m[i5], this.f479goto + width2 + (f357A.f495void * i7) + (f357A.f495void / 2), this.f483void + height + (f357A.f440aj * i6), 17);
                        }
                        i5++;
                    }
                }
                if (f357A.f436af) {
                    f360G.drawRect(((((this.f479goto + width2) + (f357A.f495void * i4)) + (f357A.f495void / 2)) - (f357A.f495void / 2)) - 1, ((((height + this.f483void) + (f357A.f440aj * i3)) + (f357A.f440aj / 2)) - (f357A.f440aj / 2)) - 1, f357A.f495void + 1, f357A.f440aj + 1);
                } else {
                    f360G.drawImage(f357A.f459j, this.f479goto + width2 + (f357A.f495void * i4) + (f357A.f495void / 2), height + this.f483void + (f357A.f440aj * i3) + (f357A.f440aj / 2), 3);
                }
                m79if(f360G);
                m68a(f360G, (String) ((Object[]) this.f385l)[2], f357A.f411C, (getWidth() / 2) + this.f479goto, ((this.f483void + getHeight()) - (f357A.f440aj * 2)) - f357A.f431Z, 17);
            }
        }
        if (this.f377H == 12) {
            if (f357A.f428V == 9) {
                mo32a(f360G);
            } else {
                f357A.mo0a(f360G, ((Gauge) ((Object[]) this.f385l)[0]).getValue());
            }
        }
        if (this.f377H == 1) {
            f360G.setColor(((int[]) ((Object[]) this.f385l)[1])[((int[]) ((Object[]) this.f385l)[2])[0]]);
            f360G.fillRect(0, 0, getWidth(), getHeight());
            if (((int[]) ((Object[]) this.f385l)[2])[0] > 0) {
                ((Image[][]) ((Object[]) this.f385l)[0])[((int[]) ((Object[]) this.f385l)[2])[0] - 1][((int[]) ((Object[]) this.f385l)[2])[2]] = null;
            }
            if (((Image[][]) ((Object[]) this.f385l)[0])[((int[]) ((Object[]) this.f385l)[2])[0]][((int[]) ((Object[]) this.f385l)[2])[2]] == null) {
                try {
                    ((Image[][]) ((Object[]) this.f385l)[0])[((int[]) ((Object[]) this.f385l)[2])[0]][((int[]) ((Object[]) this.f385l)[2])[2]] = Image.createImage(new StringBuffer().append(f357A.f462n[((int[]) ((Object[]) this.f385l)[2])[0]]).append(".png").toString());
                } catch (IOException e) {
                }
            }
            f360G.drawImage(((Image[][]) ((Object[]) this.f385l)[0])[((int[]) ((Object[]) this.f385l)[2])[0]][((int[]) ((Object[]) this.f385l)[2])[2]], this.f479goto + (getWidth() / 2), this.f483void + (getHeight() / 2), 3);
        }
        C0002b c0002b3 = f357A;
        if (C0002b.f399ap != 1 || this.f481long >= 1000) {
            C0002b c0002b4 = f357A;
            if (C0002b.f399ap == 2 && this.f476byte < 1000) {
                graphics.drawRGB(f364g, 0, getWidth(), 0, 0, getWidth(), getHeight(), false);
            } else if (f474new != null) {
                graphics.drawImage(f474new, 0, 0, 20);
            }
        } else {
            graphics.drawRGB(f364g, 0, getWidth(), 0, 0, getWidth(), getHeight(), false);
        }
        this.f382h = false;
    }

    public void playerUpdate(Player player, String str, Object obj) {
        if (str.equals("endOfMedia") || str.equals("stopped")) {
            player.deallocate();
        }
    }

    /* JADX WARN: Code duplicated, block: B:122:0x0259  */
    /* JADX WARN: Code duplicated, block: B:133:0x0278  */
    /* JADX WARN: Code duplicated, block: B:242:0x0645  */
    /* JADX WARN: Code duplicated, block: B:257:0x06c7  */
    /* JADX WARN: Code duplicated, block: B:57:0x015f  */
    /* JADX WARN: Code duplicated, block: B:72:0x0197  */
    /* JADX WARN: Code duplicated, block: B:83:0x01b6  */
    public void run() {
        byte b;
        int i;
        int i2;
        byte b2;
        this.f482try++;
        if (this.f377H == 12) {
            C0002b c0002b = f357A;
            if (C0002b.f399ap == 1) {
                m119char();
            }
            C0002b c0002b2 = f357A;
            if (C0002b.f399ap == 2) {
                if (((int[]) ((Object[]) this.f385l)[1])[0] == 5) {
                    f357A.f428V = ((int[]) ((Object[]) this.f385l)[1])[1];
                    m121int();
                    f357A.f428V = 0;
                }
                m73do();
            }
            new Thread(new RunnableC0001a(((int[]) ((Object[]) this.f385l)[1])[0], ((Object[]) this.f385l)[0])).start();
            while (this.f388q) {
                repaint();
                try {
                    Thread thread = this.f390u;
                    Thread.sleep(200L);
                } catch (InterruptedException e) {
                }
                if (((Gauge) ((Object[]) this.f385l)[0]).getValue() == 100) {
                    this.f388q = false;
                }
            }
            repaint();
            try {
                Thread thread2 = this.f390u;
                Thread.sleep(200L);
            } catch (InterruptedException e2) {
            }
            C0002b c0002b3 = f357A;
            if (C0002b.f399ap == 1 && ((int[]) ((Object[]) this.f385l)[1])[1] == 9) {
                f357A.f449aw.mo32a(f360G);
                f474new.getRGB(f362b, 0, getWidth(), 0, 0, getWidth(), getHeight());
                m120else();
            }
            C0002b c0002b4 = f357A;
            if (C0002b.f399ap == 2) {
                m121int();
                if (((int[]) ((Object[]) this.f385l)[1])[1] == 9) {
                    f357A.f428V = ((int[]) ((Object[]) this.f385l)[1])[1];
                    m73do();
                }
            }
            f357A.f428V = ((int[]) ((Object[]) this.f385l)[1])[1];
        }
        if (this.f377H == 1) {
            for (int i3 = 0; i3 < ((Image[][]) ((Object[]) this.f385l)[0]).length; i3++) {
                ((int[]) ((Object[]) this.f385l)[2])[0] = i3;
                ((int[]) ((Object[]) this.f385l)[2])[2] = 0;
                ((int[]) ((Object[]) this.f385l)[2])[3] = 0;
                m122long();
                C0002b c0002b5 = f357A;
                if (C0002b.f399ap == 1) {
                    m119char();
                }
                C0002b c0002b6 = f357A;
                if (C0002b.f399ap == 2) {
                    m73do();
                }
                C0002b c0002b7 = f357A;
                if (C0002b.f399ap == 3) {
                    m77if();
                }
                int length = 0;
                while (length < ((Image[][]) ((Object[]) this.f385l)[0])[((int[]) ((Object[]) this.f385l)[2])[0]].length - 1) {
                    try {
                        if (((int[]) ((Object[]) this.f385l)[2])[3] == 1) {
                            length = ((Image[][]) ((Object[]) this.f385l)[0])[((int[]) ((Object[]) this.f385l)[2])[0]].length - 1;
                            ((int[]) ((Object[]) this.f385l)[2])[2] = length;
                            if (((Image[][]) ((Object[]) this.f385l)[0])[((int[]) ((Object[]) this.f385l)[2])[0]][((int[]) ((Object[]) this.f385l)[2])[2]] == null) {
                                ((Image[][]) ((Object[]) this.f385l)[0])[((int[]) ((Object[]) this.f385l)[2])[0]][((int[]) ((Object[]) this.f385l)[2])[2]] = Image.createImage(new StringBuffer().append(f357A.f462n[i3]).append("_").append(length).append(".png").toString());
                            }
                        } else {
                            long jCurrentTimeMillis = System.currentTimeMillis();
                            ((Image[][]) ((Object[]) this.f385l)[0])[((int[]) ((Object[]) this.f385l)[2])[0]][((int[]) ((Object[]) this.f385l)[2])[2]] = null;
                            System.gc();
                            int[] iArr = (int[]) ((Object[]) this.f385l)[2];
                            iArr[2] = iArr[2] + 1;
                            if (((Image[][]) ((Object[]) this.f385l)[0])[((int[]) ((Object[]) this.f385l)[2])[0]][((int[]) ((Object[]) this.f385l)[2])[2]] == null) {
                                ((Image[][]) ((Object[]) this.f385l)[0])[((int[]) ((Object[]) this.f385l)[2])[0]][((int[]) ((Object[]) this.f385l)[2])[2]] = Image.createImage(new StringBuffer().append(f357A.f462n[i3]).append("_").append(length + 1).append(".png").toString());
                            }
                            m122long();
                            int iCurrentTimeMillis = 200 - ((int) (System.currentTimeMillis() - jCurrentTimeMillis));
                            if (iCurrentTimeMillis < 0) {
                                iCurrentTimeMillis = 1;
                            }
                            try {
                                Thread thread3 = this.f390u;
                                Thread.sleep(iCurrentTimeMillis);
                            } catch (InterruptedException e3) {
                            }
                        }
                        length++;
                    } catch (IOException e4) {
                    }
                }
                repaint();
                try {
                    Thread thread4 = this.f390u;
                    Thread.sleep(((int[]) ((Object[]) this.f385l)[2])[1]);
                } catch (InterruptedException e5) {
                }
                if (i3 < ((Image[][]) ((Object[]) this.f385l)[0]).length - 1) {
                    C0002b c0002b8 = f357A;
                    if (C0002b.f399ap == 1) {
                        f474new.getRGB(f362b, 0, getWidth(), 0, 0, getWidth(), getHeight());
                    }
                    C0002b c0002b9 = f357A;
                    if (C0002b.f399ap == 2) {
                        m121int();
                    }
                    C0002b c0002b10 = f357A;
                    if (C0002b.f399ap == 3) {
                        m123new();
                    }
                }
            }
            f357A.f428V = 1;
            if (f357A.f424R != null) {
                try {
                    DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(f357A.m88a("d")));
                    dataInputStream.readByte();
                    dataInputStream.close();
                } catch (Exception e6) {
                    f357A.f428V = 11;
                }
            }
        }
        if (this.f377H == 9) {
            C0002b c0002b11 = f357A;
            if (C0002b.f399ap == 2) {
                int i4 = this.f476byte;
                m121int();
                this.f476byte = i4;
            }
            if (f357A.f448av == 9) {
                f357A.m94if();
                f357A.m92do();
                ((Object[]) this.f385l)[0] = f357A.f413E;
            }
            C0002b c0002b12 = f357A;
            if (C0002b.f399ap == 1) {
                m119char();
            }
            C0002b c0002b13 = f357A;
            if (C0002b.f399ap == 2 && this.f476byte == 0) {
                m73do();
            }
            C0002b c0002b14 = f357A;
            if (C0002b.f399ap != 2) {
                C0002b c0002b15 = f357A;
                if (C0002b.f399ap == 3) {
                    m77if();
                }
            } else {
                m77if();
            }
            int width = getWidth();
            int width2 = f357A.f425S == 1 ? width - (f357A.f454d[0].getWidth() * 2) : width;
            while (this.f388q) {
                for (int i5 = 0; i5 < ((String[]) ((Object[]) this.f385l)[1]).length; i5++) {
                    for (int i6 = 0; i6 < 3; i6++) {
                        if (((int[][]) ((Object[]) this.f385l)[4])[i5][3] != 0) {
                            int[] iArr2 = ((int[][]) ((Object[]) this.f385l)[4])[i5];
                            iArr2[0] = ((int[][]) ((Object[]) this.f385l)[4])[i5][3] + iArr2[0];
                            if (((int[][]) ((Object[]) this.f385l)[4])[i5][0] == 0) {
                                ((int[][]) ((Object[]) this.f385l)[4])[i5][3] = -((int[][]) ((Object[]) this.f385l)[4])[i5][3];
                            } else if (((int[][]) ((Object[]) this.f385l)[4])[i5][1] + ((int[][]) ((Object[]) this.f385l)[4])[i5][0] == width2) {
                                ((int[][]) ((Object[]) this.f385l)[4])[i5][3] = -((int[][]) ((Object[]) this.f385l)[4])[i5][3];
                            }
                        }
                    }
                }
                m117byte();
                repaint();
                try {
                    Thread thread5 = this.f390u;
                    Thread.sleep(200L);
                } catch (InterruptedException e7) {
                }
            }
        }
        if (this.f377H == 3) {
            C0002b c0002b16 = f357A;
            if (C0002b.f399ap == 1) {
                m119char();
            }
            C0002b c0002b17 = f357A;
            if (C0002b.f399ap != 2) {
                C0002b c0002b18 = f357A;
                if (C0002b.f399ap == 3) {
                    m77if();
                }
            } else {
                m77if();
            }
            b = 2;
        } else {
            b = -1;
        }
        if (this.f377H == 10) {
            C0002b c0002b19 = f357A;
            if (C0002b.f399ap == 1) {
                m119char();
            }
            C0002b c0002b20 = f357A;
            if (C0002b.f399ap != 2) {
                C0002b c0002b21 = f357A;
                if (C0002b.f399ap == 3) {
                    m77if();
                }
            } else {
                m77if();
            }
            i = 2;
            b = 4;
        } else {
            i = 0;
        }
        if (this.f377H == 11) {
            if (f357A.f448av == 9) {
                C0002b c0002b22 = f357A;
                if (C0002b.f399ap == 2) {
                    m121int();
                }
            }
            f357A.m94if();
            f357A.m92do();
            ((Object[]) this.f385l)[0] = f357A.f469w;
            C0002b c0002b23 = f357A;
            if (C0002b.f399ap == 1) {
                m119char();
            }
            C0002b c0002b24 = f357A;
            if (C0002b.f399ap == 2) {
                m73do();
            }
            C0002b c0002b25 = f357A;
            if (C0002b.f399ap == 3) {
                m77if();
            }
            i2 = 0;
            b2 = 4;
        } else {
            i2 = i;
            b2 = b;
        }
        if (b2 != -1) {
            while (this.f388q) {
                for (int i7 = 0; i7 < 3; i7++) {
                    if (((int[]) ((Object[]) this.f385l)[b2])[i2 + 3] != 0) {
                        int[] iArr3 = (int[]) ((Object[]) this.f385l)[b2];
                        iArr3[i2] = ((int[]) ((Object[]) this.f385l)[b2])[i2 + 3] + iArr3[i2];
                        if (((int[]) ((Object[]) this.f385l)[b2])[i2] == 0) {
                            ((int[]) ((Object[]) this.f385l)[b2])[i2 + 3] = -((int[]) ((Object[]) this.f385l)[b2])[i2 + 3];
                        } else if (((int[]) ((Object[]) this.f385l)[b2])[i2 + 1] + ((int[]) ((Object[]) this.f385l)[b2])[i2] == getWidth()) {
                            ((int[]) ((Object[]) this.f385l)[b2])[i2 + 3] = -((int[]) ((Object[]) this.f385l)[b2])[i2 + 3];
                        }
                    }
                }
                m117byte();
                repaint();
                try {
                    Thread thread6 = this.f390u;
                    Thread.sleep(200L);
                } catch (InterruptedException e8) {
                }
            }
        }
        if (this.f377H == 9) {
            C0002b c0002b26 = f357A;
            if (C0002b.f399ap == 1 && f357A.f448av == 2) {
                f357A.f449aw.mo32a(f360G);
                f474new.getRGB(f362b, 0, getWidth(), 0, 0, getWidth(), getHeight());
                m120else();
            }
            C0002b c0002b27 = f357A;
            if (C0002b.f399ap == 2 && f357A.f428V == 7) {
                m121int();
            }
            C0002b c0002b28 = f357A;
            if (C0002b.f399ap != 2) {
                C0002b c0002b29 = f357A;
                if (C0002b.f399ap == 3) {
                    m123new();
                }
            } else {
                m123new();
            }
        }
        if (this.f377H == 3 || this.f377H == 10 || this.f377H == 11) {
            C0002b c0002b30 = f357A;
            if (C0002b.f399ap != 2) {
                C0002b c0002b31 = f357A;
                if (C0002b.f399ap == 3) {
                    m123new();
                }
            } else {
                m123new();
            }
        }
        if (this.f377H == 4) {
            f357A.f449aw.mo29a(f357A.f409A, (Gauge) this.f385l);
        }
        if (this.f377H == 5) {
            f357A.f449aw.mo52if((Gauge) this.f385l);
        }
        if (this.f377H == 6) {
            try {
                f357A.f449aw.mo35a(f357A.m88a("s"), (Gauge) this.f385l);
            } catch (Exception e9) {
                try {
                    RecordStore.deleteRecordStore("s");
                } catch (Exception e10) {
                }
                f357A.f450ax = f357A.m97if(f357A.f450ax, f357A.f488for[1]);
            }
        }
        if (this.f377H == 7) {
            f357A.f449aw.mo106for();
            if (f357A.m87a("s", f357A.f449aw.mo43do((Gauge) this.f385l)) && f357A.m80a(f357A.f450ax, f357A.f488for[1]) == -1) {
                f357A.f450ax = f357A.m91a(f357A.f450ax, f357A.f488for[1], 0);
            }
            ((Gauge) this.f385l).setValue(100);
            f357A.f449aw.mo24a();
        }
        if (this.f377H == 8) {
            f357A.m83a((Gauge) this.f385l);
        }
        if (this.f377H == 13) {
            f357A.m93do((Gauge) this.f385l);
            ((Gauge) this.f385l).setValue(100);
        }
        this.f482try--;
        C0002b c0002b32 = f357A;
        if (C0002b.f399ap == 1) {
            f474new.getRGB(f362b, 0, getWidth(), 0, 0, getWidth(), getHeight());
        }
        if (this.f377H == 4 || this.f377H == 5 || this.f377H == 6 || this.f377H == 7 || this.f377H == 8 || this.f377H == 13) {
            return;
        }
        f357A.m82a();
        f357A.m94if();
    }

    public void showNotify() {
        if (this.f377H == 2 || this.f482try != 0) {
            return;
        }
        this.f390u = new Thread(this);
        this.f388q = true;
        this.f390u.start();
    }

    public void sizeChanged(int i, int i2) {
        super.sizeChanged(i, i2);
        m124null();
    }

    /* JADX INFO: renamed from: try, reason: not valid java name */
    public void m125try() {
        int i = (this.f387n >> 16) & 255;
        int i2 = (this.f387n >> 8) & 255;
        int i3 = this.f387n & 255;
        f474new.getRGB(f364g, 0, getWidth(), 0, 0, getWidth(), getHeight());
        int i4 = ((1000 - this.f476byte) << 16) / 1000;
        for (int i5 = 0; i5 < f364g.length; i5++) {
            int i6 = (f364g[i5] >> 16) & 255;
            int i7 = (f364g[i5] >> 8) & 255;
            int i8 = f364g[i5] & 255;
            f364g[i5] = ((i6 + (((i - i6) * i4) >> 16)) << 16) | ((i7 + (((i2 - i7) * i4) >> 16)) << 8) | (f364g[i5] & 255);
        }
    }
}
