package p000;

import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

/* JADX INFO: renamed from: bn */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0041bn {

    /* JADX INFO: renamed from: a */
    private static Graphics f358a;

    /* JADX INFO: renamed from: a */
    public int f359a;

    /* JADX INFO: renamed from: a */
    private Image f360a;

    /* JADX INFO: renamed from: a */
    private int[] f361a;

    /* JADX INFO: renamed from: b */
    public int f362b;

    /* JADX INFO: renamed from: b */
    private int[] f363b;

    /* JADX INFO: renamed from: c */
    private int f364c;

    /* JADX INFO: renamed from: c */
    private int[] f365c;

    /* JADX INFO: renamed from: d */
    private int f366d;

    public C0041bn(String str, Graphics graphics) {
        f358a = graphics;
        try {
            this.f360a = Image.createImage(str);
            this.f361a = new int[160];
            this.f363b = new int[160];
            this.f365c = new int[160];
            int height = this.f360a.getHeight() / 10;
            this.f359a = height;
            this.f364c = height;
            this.f366d = this.f360a.getWidth() / 16;
            int[] iArr = new int[this.f360a.getWidth() * this.f360a.getHeight()];
            this.f360a.getRGB(iArr, 0, this.f360a.getWidth(), 0, 0, this.f360a.getWidth(), this.f360a.getHeight());
            for (int i = 0; i < 16; i++) {
                for (int i2 = 0; i2 < 10; i2++) {
                    this.f361a[(i2 * 16) + i] = this.f366d * i;
                    this.f363b[(i2 * 16) + i] = this.f359a * i2;
                    this.f365c[(i2 * 16) + i] = m154a(this.f366d * i, this.f359a * i2, iArr);
                }
            }
            this.f362b = 1;
            this.f365c[0] = this.f366d >> 3;
        } catch (Exception e) {
            this.f360a = null;
        }
        System.gc();
    }

    /* JADX INFO: renamed from: a */
    private int m154a(int i, int i2, int[] iArr) {
        int i3 = this.f366d - 1;
        for (int i4 = 0; i4 < this.f366d; i4++) {
            for (int i5 = 0; i5 < this.f359a; i5++) {
                if (((iArr[(i4 + i) + ((i5 + i2) * this.f360a.getWidth())] >> 24) & 255) > 0) {
                    i3 = i4;
                    break;
                }
            }
        }
        return i3 + 1;
    }

    /* JADX INFO: renamed from: a */
    private void m155a(int i, int i2, int i3) {
        int[] iArr = new int[this.f360a.getWidth() * this.f360a.getHeight()];
        this.f360a.getRGB(iArr, 0, this.f360a.getWidth(), 0, 0, this.f360a.getWidth(), this.f360a.getHeight());
        int width = this.f360a.getWidth();
        int i4 = 0;
        for (int i5 = 0; i5 < this.f360a.getHeight(); i5++) {
            for (int i6 = 0; i6 < this.f360a.getWidth(); i6++) {
                iArr[i6 + i4] = (((iArr[i6 + i4] >> 24) & 255) << 24) | (i << 16) | (i2 << 8) | i3;
            }
            i4 += width;
        }
        this.f360a = Image.createRGBImage(iArr, this.f360a.getWidth(), this.f360a.getHeight(), true);
    }

    /* JADX INFO: renamed from: a */
    public final int m156a(String str) {
        char c;
        int i = 0;
        for (int i2 = 0; i2 < str.length(); i2++) {
            switch (str.charAt(i2)) {
                case ' ':
                    c = 0;
                    break;
                case '!':
                    c = 1;
                    break;
                case '\"':
                    c = 2;
                    break;
                case '#':
                    c = 3;
                    break;
                case '$':
                    c = 4;
                    break;
                case '%':
                    c = 5;
                    break;
                case '&':
                    c = 6;
                    break;
                case '\'':
                    c = 7;
                    break;
                case '(':
                    c = '\b';
                    break;
                case ')':
                    c = '\t';
                    break;
                case '*':
                    c = '\n';
                    break;
                case '+':
                    c = 11;
                    break;
                case ',':
                    c = '\f';
                    break;
                case '-':
                    c = '\r';
                    break;
                case '.':
                    c = 14;
                    break;
                case '/':
                    c = 15;
                    break;
                case '0':
                    c = 16;
                    break;
                case '1':
                    c = 17;
                    break;
                case '2':
                    c = 18;
                    break;
                case '3':
                    c = 19;
                    break;
                case '4':
                    c = 20;
                    break;
                case '5':
                    c = 21;
                    break;
                case '6':
                    c = 22;
                    break;
                case '7':
                    c = 23;
                    break;
                case '8':
                    c = 24;
                    break;
                case '9':
                    c = 25;
                    break;
                case ':':
                    c = 26;
                    break;
                case ';':
                    c = 27;
                    break;
                case '<':
                    c = 28;
                    break;
                case '=':
                    c = 29;
                    break;
                case '>':
                    c = 30;
                    break;
                case '?':
                    c = 31;
                    break;
                case '@':
                    c = ' ';
                    break;
                case 'A':
                    c = '!';
                    break;
                case 'B':
                    c = '\"';
                    break;
                case 'C':
                    c = '#';
                    break;
                case 'D':
                    c = '$';
                    break;
                case 'E':
                    c = '%';
                    break;
                case 'F':
                    c = '&';
                    break;
                case 'G':
                    c = '\'';
                    break;
                case 'H':
                    c = '(';
                    break;
                case 'I':
                    c = ')';
                    break;
                case 'J':
                    c = '*';
                    break;
                case 'K':
                    c = '+';
                    break;
                case 'L':
                    c = ',';
                    break;
                case 'M':
                    c = '-';
                    break;
                case 'N':
                    c = '.';
                    break;
                case 'O':
                    c = '/';
                    break;
                case 'P':
                    c = '0';
                    break;
                case 'Q':
                    c = '1';
                    break;
                case 'R':
                    c = '2';
                    break;
                case 'S':
                    c = '3';
                    break;
                case 'T':
                    c = '4';
                    break;
                case 'U':
                    c = '5';
                    break;
                case 'V':
                    c = '6';
                    break;
                case 'W':
                    c = '7';
                    break;
                case 'X':
                    c = '8';
                    break;
                case 'Y':
                    c = '9';
                    break;
                case 'Z':
                    c = ':';
                    break;
                case '[':
                    c = ';';
                    break;
                case '\\':
                    c = '<';
                    break;
                case ']':
                    c = '=';
                    break;
                case '^':
                    c = '>';
                    break;
                case '_':
                    c = '?';
                    break;
                case '`':
                    c = '@';
                    break;
                case 'a':
                    c = 'A';
                    break;
                case 'b':
                    c = 'B';
                    break;
                case 'c':
                    c = 'C';
                    break;
                case 'd':
                    c = 'D';
                    break;
                case 'e':
                    c = 'E';
                    break;
                case 'f':
                    c = 'F';
                    break;
                case 'g':
                    c = 'G';
                    break;
                case 'h':
                    c = 'H';
                    break;
                case 'i':
                    c = 'I';
                    break;
                case 'j':
                    c = 'J';
                    break;
                case 'k':
                    c = 'K';
                    break;
                case 'l':
                    c = 'L';
                    break;
                case 'm':
                    c = 'M';
                    break;
                case 'n':
                    c = 'N';
                    break;
                case 'o':
                    c = 'O';
                    break;
                case 'p':
                    c = 'P';
                    break;
                case 'q':
                    c = 'Q';
                    break;
                case 'r':
                    c = 'R';
                    break;
                case 's':
                    c = 'S';
                    break;
                case 't':
                    c = 'T';
                    break;
                case 'u':
                    c = 'U';
                    break;
                case 'v':
                    c = 'V';
                    break;
                case 'w':
                    c = 'W';
                    break;
                case 'x':
                    c = 'X';
                    break;
                case 'y':
                    c = 'Y';
                    break;
                case 'z':
                    c = 'Z';
                    break;
                case '{':
                    c = '[';
                    break;
                case '|':
                    c = '\\';
                    break;
                case '}':
                    c = ']';
                    break;
                case '~':
                    c = '^';
                    break;
                case 153:
                case 8482:
                    c = 155;
                    break;
                case 161:
                    c = '`';
                    break;
                case 169:
                    c = 154;
                    break;
                case 171:
                    c = 'a';
                    break;
                case 174:
                    c = 153;
                    break;
                case 187:
                    c = 'b';
                    break;
                case 191:
                    c = 'c';
                    break;
                case 192:
                    c = 'd';
                    break;
                case 193:
                    c = 'e';
                    break;
                case 194:
                    c = 'f';
                    break;
                case 196:
                    c = 'g';
                    break;
                case 199:
                    c = 'h';
                    break;
                case 200:
                    c = 'i';
                    break;
                case 201:
                    c = 'j';
                    break;
                case 202:
                    c = 'k';
                    break;
                case 203:
                    c = 'l';
                    break;
                case 204:
                    c = 'm';
                    break;
                case 205:
                    c = 'n';
                    break;
                case 206:
                    c = 'o';
                    break;
                case 207:
                    c = 'p';
                    break;
                case 209:
                    c = 'q';
                    break;
                case 210:
                    c = 'r';
                    break;
                case 211:
                    c = 's';
                    break;
                case 212:
                    c = 't';
                    break;
                case 214:
                    c = 'u';
                    break;
                case 217:
                    c = 'v';
                    break;
                case 218:
                    c = 'w';
                    break;
                case 219:
                    c = 'x';
                    break;
                case 220:
                    c = 'y';
                    break;
                case 223:
                    c = 'z';
                    break;
                case 224:
                    c = '{';
                    break;
                case 225:
                    c = '|';
                    break;
                case 226:
                    c = '}';
                    break;
                case 228:
                    c = '~';
                    break;
                case 231:
                    c = 127;
                    break;
                case 232:
                    c = 128;
                    break;
                case 233:
                    c = 129;
                    break;
                case 234:
                    c = 130;
                    break;
                case 235:
                    c = 131;
                    break;
                case 236:
                    c = 132;
                    break;
                case 237:
                    c = 133;
                    break;
                case 238:
                    c = 134;
                    break;
                case 239:
                    c = 135;
                    break;
                case 241:
                    c = 136;
                    break;
                case 242:
                    c = 137;
                    break;
                case 243:
                    c = 138;
                    break;
                case 244:
                    c = 139;
                    break;
                case 246:
                    c = 140;
                    break;
                case 249:
                    c = 141;
                    break;
                case 250:
                    c = 142;
                    break;
                case 251:
                    c = 143;
                    break;
                case 252:
                    c = 144;
                    break;
                case 286:
                    c = 147;
                    break;
                case 287:
                    c = 148;
                    break;
                case 304:
                    c = 151;
                    break;
                case 305:
                    c = 152;
                    break;
                case 338:
                    c = 146;
                    break;
                case 339:
                    c = 145;
                    break;
                case 350:
                    c = 149;
                    break;
                case 351:
                    c = 150;
                    break;
                default:
                    c = 0;
                    break;
            }
            i += this.f365c[c] + this.f362b;
        }
        return i;
    }

    /* JADX INFO: renamed from: a */
    public final void m157a(int i) {
        m155a((i >> 16) & 255, (i >> 8) & 255, i & 255);
    }

    /* JADX INFO: renamed from: a */
    public final void m158a(String str, int i, int i2) {
        char c;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            int i5 = i4;
            int i6 = i3;
            if (i5 >= str.length()) {
                return;
            }
            switch (str.charAt(i5)) {
                case ' ':
                    c = 0;
                    break;
                case '!':
                    c = 1;
                    break;
                case '\"':
                    c = 2;
                    break;
                case '#':
                    c = 3;
                    break;
                case '$':
                    c = 4;
                    break;
                case '%':
                    c = 5;
                    break;
                case '&':
                    c = 6;
                    break;
                case '\'':
                    c = 7;
                    break;
                case '(':
                    c = '\b';
                    break;
                case ')':
                    c = '\t';
                    break;
                case '*':
                    c = '\n';
                    break;
                case '+':
                    c = 11;
                    break;
                case ',':
                    c = '\f';
                    break;
                case '-':
                    c = '\r';
                    break;
                case '.':
                    c = 14;
                    break;
                case '/':
                    c = 15;
                    break;
                case '0':
                    c = 16;
                    break;
                case '1':
                    c = 17;
                    break;
                case '2':
                    c = 18;
                    break;
                case '3':
                    c = 19;
                    break;
                case '4':
                    c = 20;
                    break;
                case '5':
                    c = 21;
                    break;
                case '6':
                    c = 22;
                    break;
                case '7':
                    c = 23;
                    break;
                case '8':
                    c = 24;
                    break;
                case '9':
                    c = 25;
                    break;
                case ':':
                    c = 26;
                    break;
                case ';':
                    c = 27;
                    break;
                case '<':
                    c = 28;
                    break;
                case '=':
                    c = 29;
                    break;
                case '>':
                    c = 30;
                    break;
                case '?':
                    c = 31;
                    break;
                case '@':
                    c = ' ';
                    break;
                case 'A':
                    c = '!';
                    break;
                case 'B':
                    c = '\"';
                    break;
                case 'C':
                    c = '#';
                    break;
                case 'D':
                    c = '$';
                    break;
                case 'E':
                    c = '%';
                    break;
                case 'F':
                    c = '&';
                    break;
                case 'G':
                    c = '\'';
                    break;
                case 'H':
                    c = '(';
                    break;
                case 'I':
                    c = ')';
                    break;
                case 'J':
                    c = '*';
                    break;
                case 'K':
                    c = '+';
                    break;
                case 'L':
                    c = ',';
                    break;
                case 'M':
                    c = '-';
                    break;
                case 'N':
                    c = '.';
                    break;
                case 'O':
                    c = '/';
                    break;
                case 'P':
                    c = '0';
                    break;
                case 'Q':
                    c = '1';
                    break;
                case 'R':
                    c = '2';
                    break;
                case 'S':
                    c = '3';
                    break;
                case 'T':
                    c = '4';
                    break;
                case 'U':
                    c = '5';
                    break;
                case 'V':
                    c = '6';
                    break;
                case 'W':
                    c = '7';
                    break;
                case 'X':
                    c = '8';
                    break;
                case 'Y':
                    c = '9';
                    break;
                case 'Z':
                    c = ':';
                    break;
                case '[':
                    c = ';';
                    break;
                case '\\':
                    c = '<';
                    break;
                case ']':
                    c = '=';
                    break;
                case '^':
                    c = '>';
                    break;
                case '_':
                    c = '?';
                    break;
                case '`':
                    c = '@';
                    break;
                case 'a':
                    c = 'A';
                    break;
                case 'b':
                    c = 'B';
                    break;
                case 'c':
                    c = 'C';
                    break;
                case 'd':
                    c = 'D';
                    break;
                case 'e':
                    c = 'E';
                    break;
                case 'f':
                    c = 'F';
                    break;
                case 'g':
                    c = 'G';
                    break;
                case 'h':
                    c = 'H';
                    break;
                case 'i':
                    c = 'I';
                    break;
                case 'j':
                    c = 'J';
                    break;
                case 'k':
                    c = 'K';
                    break;
                case 'l':
                    c = 'L';
                    break;
                case 'm':
                    c = 'M';
                    break;
                case 'n':
                    c = 'N';
                    break;
                case 'o':
                    c = 'O';
                    break;
                case 'p':
                    c = 'P';
                    break;
                case 'q':
                    c = 'Q';
                    break;
                case 'r':
                    c = 'R';
                    break;
                case 's':
                    c = 'S';
                    break;
                case 't':
                    c = 'T';
                    break;
                case 'u':
                    c = 'U';
                    break;
                case 'v':
                    c = 'V';
                    break;
                case 'w':
                    c = 'W';
                    break;
                case 'x':
                    c = 'X';
                    break;
                case 'y':
                    c = 'Y';
                    break;
                case 'z':
                    c = 'Z';
                    break;
                case '{':
                    c = '[';
                    break;
                case '|':
                    c = '\\';
                    break;
                case '}':
                    c = ']';
                    break;
                case '~':
                    c = '^';
                    break;
                case 153:
                case 8482:
                    c = 155;
                    break;
                case 161:
                    c = '`';
                    break;
                case 169:
                    c = 154;
                    break;
                case 171:
                    c = 'a';
                    break;
                case 174:
                    c = 153;
                    break;
                case 187:
                    c = 'b';
                    break;
                case 191:
                    c = 'c';
                    break;
                case 192:
                    c = 'd';
                    break;
                case 193:
                    c = 'e';
                    break;
                case 194:
                    c = 'f';
                    break;
                case 196:
                    c = 'g';
                    break;
                case 199:
                    c = 'h';
                    break;
                case 200:
                    c = 'i';
                    break;
                case 201:
                    c = 'j';
                    break;
                case 202:
                    c = 'k';
                    break;
                case 203:
                    c = 'l';
                    break;
                case 204:
                    c = 'm';
                    break;
                case 205:
                    c = 'n';
                    break;
                case 206:
                    c = 'o';
                    break;
                case 207:
                    c = 'p';
                    break;
                case 209:
                    c = 'q';
                    break;
                case 210:
                    c = 'r';
                    break;
                case 211:
                    c = 's';
                    break;
                case 212:
                    c = 't';
                    break;
                case 214:
                    c = 'u';
                    break;
                case 217:
                    c = 'v';
                    break;
                case 218:
                    c = 'w';
                    break;
                case 219:
                    c = 'x';
                    break;
                case 220:
                    c = 'y';
                    break;
                case 223:
                    c = 'z';
                    break;
                case 224:
                    c = '{';
                    break;
                case 225:
                    c = '|';
                    break;
                case 226:
                    c = '}';
                    break;
                case 228:
                    c = '~';
                    break;
                case 231:
                    c = 127;
                    break;
                case 232:
                    c = 128;
                    break;
                case 233:
                    c = 129;
                    break;
                case 234:
                    c = 130;
                    break;
                case 235:
                    c = 131;
                    break;
                case 236:
                    c = 132;
                    break;
                case 237:
                    c = 133;
                    break;
                case 238:
                    c = 134;
                    break;
                case 239:
                    c = 135;
                    break;
                case 241:
                    c = 136;
                    break;
                case 242:
                    c = 137;
                    break;
                case 243:
                    c = 138;
                    break;
                case 244:
                    c = 139;
                    break;
                case 246:
                    c = 140;
                    break;
                case 249:
                    c = 141;
                    break;
                case 250:
                    c = 142;
                    break;
                case 251:
                    c = 143;
                    break;
                case 252:
                    c = 144;
                    break;
                case 286:
                    c = 147;
                    break;
                case 287:
                    c = 148;
                    break;
                case 304:
                    c = 151;
                    break;
                case 305:
                    c = 152;
                    break;
                case 338:
                    c = 146;
                    break;
                case 339:
                    c = 145;
                    break;
                case 350:
                    c = 149;
                    break;
                case 351:
                    c = 150;
                    break;
                default:
                    c = 0;
                    break;
            }
            char c2 = c;
            f358a.drawRegion(this.f360a, this.f361a[c2], this.f363b[c2], this.f365c[c2], this.f364c, 0, i + i6, i2, 0);
            i3 = i6 + this.f365c[c2] + this.f362b;
            i4 = i5 + 1;
        }
    }

    /* JADX INFO: renamed from: b */
    public final void m159b(String str, int i, int i2) {
        char c;
        int i3 = i - (this.f364c - this.f359a);
        int i4 = 0;
        int i5 = 0;
        while (true) {
            int i6 = i5;
            int i7 = i4;
            if (i6 >= str.length()) {
                return;
            }
            switch (str.charAt(i6)) {
                case ' ':
                    c = 0;
                    break;
                case '!':
                    c = 1;
                    break;
                case '\"':
                    c = 2;
                    break;
                case '#':
                    c = 3;
                    break;
                case '$':
                    c = 4;
                    break;
                case '%':
                    c = 5;
                    break;
                case '&':
                    c = 6;
                    break;
                case '\'':
                    c = 7;
                    break;
                case '(':
                    c = '\b';
                    break;
                case ')':
                    c = '\t';
                    break;
                case '*':
                    c = '\n';
                    break;
                case '+':
                    c = 11;
                    break;
                case ',':
                    c = '\f';
                    break;
                case '-':
                    c = '\r';
                    break;
                case '.':
                    c = 14;
                    break;
                case '/':
                    c = 15;
                    break;
                case '0':
                    c = 16;
                    break;
                case '1':
                    c = 17;
                    break;
                case '2':
                    c = 18;
                    break;
                case '3':
                    c = 19;
                    break;
                case '4':
                    c = 20;
                    break;
                case '5':
                    c = 21;
                    break;
                case '6':
                    c = 22;
                    break;
                case '7':
                    c = 23;
                    break;
                case '8':
                    c = 24;
                    break;
                case '9':
                    c = 25;
                    break;
                case ':':
                    c = 26;
                    break;
                case ';':
                    c = 27;
                    break;
                case '<':
                    c = 28;
                    break;
                case '=':
                    c = 29;
                    break;
                case '>':
                    c = 30;
                    break;
                case '?':
                    c = 31;
                    break;
                case '@':
                    c = ' ';
                    break;
                case 'A':
                    c = '!';
                    break;
                case 'B':
                    c = '\"';
                    break;
                case 'C':
                    c = '#';
                    break;
                case 'D':
                    c = '$';
                    break;
                case 'E':
                    c = '%';
                    break;
                case 'F':
                    c = '&';
                    break;
                case 'G':
                    c = '\'';
                    break;
                case 'H':
                    c = '(';
                    break;
                case 'I':
                    c = ')';
                    break;
                case 'J':
                    c = '*';
                    break;
                case 'K':
                    c = '+';
                    break;
                case 'L':
                    c = ',';
                    break;
                case 'M':
                    c = '-';
                    break;
                case 'N':
                    c = '.';
                    break;
                case 'O':
                    c = '/';
                    break;
                case 'P':
                    c = '0';
                    break;
                case 'Q':
                    c = '1';
                    break;
                case 'R':
                    c = '2';
                    break;
                case 'S':
                    c = '3';
                    break;
                case 'T':
                    c = '4';
                    break;
                case 'U':
                    c = '5';
                    break;
                case 'V':
                    c = '6';
                    break;
                case 'W':
                    c = '7';
                    break;
                case 'X':
                    c = '8';
                    break;
                case 'Y':
                    c = '9';
                    break;
                case 'Z':
                    c = ':';
                    break;
                case '[':
                    c = ';';
                    break;
                case '\\':
                    c = '<';
                    break;
                case ']':
                    c = '=';
                    break;
                case '^':
                    c = '>';
                    break;
                case '_':
                    c = '?';
                    break;
                case '`':
                    c = '@';
                    break;
                case 'a':
                    c = 'A';
                    break;
                case 'b':
                    c = 'B';
                    break;
                case 'c':
                    c = 'C';
                    break;
                case 'd':
                    c = 'D';
                    break;
                case 'e':
                    c = 'E';
                    break;
                case 'f':
                    c = 'F';
                    break;
                case 'g':
                    c = 'G';
                    break;
                case 'h':
                    c = 'H';
                    break;
                case 'i':
                    c = 'I';
                    break;
                case 'j':
                    c = 'J';
                    break;
                case 'k':
                    c = 'K';
                    break;
                case 'l':
                    c = 'L';
                    break;
                case 'm':
                    c = 'M';
                    break;
                case 'n':
                    c = 'N';
                    break;
                case 'o':
                    c = 'O';
                    break;
                case 'p':
                    c = 'P';
                    break;
                case 'q':
                    c = 'Q';
                    break;
                case 'r':
                    c = 'R';
                    break;
                case 's':
                    c = 'S';
                    break;
                case 't':
                    c = 'T';
                    break;
                case 'u':
                    c = 'U';
                    break;
                case 'v':
                    c = 'V';
                    break;
                case 'w':
                    c = 'W';
                    break;
                case 'x':
                    c = 'X';
                    break;
                case 'y':
                    c = 'Y';
                    break;
                case 'z':
                    c = 'Z';
                    break;
                case '{':
                    c = '[';
                    break;
                case '|':
                    c = '\\';
                    break;
                case '}':
                    c = ']';
                    break;
                case '~':
                    c = '^';
                    break;
                case 153:
                case 8482:
                    c = 155;
                    break;
                case 161:
                    c = '`';
                    break;
                case 169:
                    c = 154;
                    break;
                case 171:
                    c = 'a';
                    break;
                case 174:
                    c = 153;
                    break;
                case 187:
                    c = 'b';
                    break;
                case 191:
                    c = 'c';
                    break;
                case 192:
                    c = 'd';
                    break;
                case 193:
                    c = 'e';
                    break;
                case 194:
                    c = 'f';
                    break;
                case 196:
                    c = 'g';
                    break;
                case 199:
                    c = 'h';
                    break;
                case 200:
                    c = 'i';
                    break;
                case 201:
                    c = 'j';
                    break;
                case 202:
                    c = 'k';
                    break;
                case 203:
                    c = 'l';
                    break;
                case 204:
                    c = 'm';
                    break;
                case 205:
                    c = 'n';
                    break;
                case 206:
                    c = 'o';
                    break;
                case 207:
                    c = 'p';
                    break;
                case 209:
                    c = 'q';
                    break;
                case 210:
                    c = 'r';
                    break;
                case 211:
                    c = 's';
                    break;
                case 212:
                    c = 't';
                    break;
                case 214:
                    c = 'u';
                    break;
                case 217:
                    c = 'v';
                    break;
                case 218:
                    c = 'w';
                    break;
                case 219:
                    c = 'x';
                    break;
                case 220:
                    c = 'y';
                    break;
                case 223:
                    c = 'z';
                    break;
                case 224:
                    c = '{';
                    break;
                case 225:
                    c = '|';
                    break;
                case 226:
                    c = '}';
                    break;
                case 228:
                    c = '~';
                    break;
                case 231:
                    c = 127;
                    break;
                case 232:
                    c = 128;
                    break;
                case 233:
                    c = 129;
                    break;
                case 234:
                    c = 130;
                    break;
                case 235:
                    c = 131;
                    break;
                case 236:
                    c = 132;
                    break;
                case 237:
                    c = 133;
                    break;
                case 238:
                    c = 134;
                    break;
                case 239:
                    c = 135;
                    break;
                case 241:
                    c = 136;
                    break;
                case 242:
                    c = 137;
                    break;
                case 243:
                    c = 138;
                    break;
                case 244:
                    c = 139;
                    break;
                case 246:
                    c = 140;
                    break;
                case 249:
                    c = 141;
                    break;
                case 250:
                    c = 142;
                    break;
                case 251:
                    c = 143;
                    break;
                case 252:
                    c = 144;
                    break;
                case 286:
                    c = 147;
                    break;
                case 287:
                    c = 148;
                    break;
                case 304:
                    c = 151;
                    break;
                case 305:
                    c = 152;
                    break;
                case 338:
                    c = 146;
                    break;
                case 339:
                    c = 145;
                    break;
                case 350:
                    c = 149;
                    break;
                case 351:
                    c = 150;
                    break;
                default:
                    c = 0;
                    break;
            }
            char c2 = c;
            f358a.drawRegion(this.f360a, this.f361a[c2], this.f363b[c2], this.f365c[c2], this.f364c, 5, i3 - this.f364c, i2 + i7, 0);
            i4 = i7 + this.f365c[c2] + this.f362b;
            i5 = i6 + 1;
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m160c(String str, int i, int i2) {
        char c;
        int i3 = 0;
        int i4 = 0;
        while (i3 < str.length()) {
            switch (str.charAt(i3)) {
                case ' ':
                    c = 0;
                    break;
                case '!':
                    c = 1;
                    break;
                case '\"':
                    c = 2;
                    break;
                case '#':
                    c = 3;
                    break;
                case '$':
                    c = 4;
                    break;
                case '%':
                    c = 5;
                    break;
                case '&':
                    c = 6;
                    break;
                case '\'':
                    c = 7;
                    break;
                case '(':
                    c = '\b';
                    break;
                case ')':
                    c = '\t';
                    break;
                case '*':
                    c = '\n';
                    break;
                case '+':
                    c = 11;
                    break;
                case ',':
                    c = '\f';
                    break;
                case '-':
                    c = '\r';
                    break;
                case '.':
                    c = 14;
                    break;
                case '/':
                    c = 15;
                    break;
                case '0':
                    c = 16;
                    break;
                case '1':
                    c = 17;
                    break;
                case '2':
                    c = 18;
                    break;
                case '3':
                    c = 19;
                    break;
                case '4':
                    c = 20;
                    break;
                case '5':
                    c = 21;
                    break;
                case '6':
                    c = 22;
                    break;
                case '7':
                    c = 23;
                    break;
                case '8':
                    c = 24;
                    break;
                case '9':
                    c = 25;
                    break;
                case ':':
                    c = 26;
                    break;
                case ';':
                    c = 27;
                    break;
                case '<':
                    c = 28;
                    break;
                case '=':
                    c = 29;
                    break;
                case '>':
                    c = 30;
                    break;
                case '?':
                    c = 31;
                    break;
                case '@':
                    c = ' ';
                    break;
                case 'A':
                    c = '!';
                    break;
                case 'B':
                    c = '\"';
                    break;
                case 'C':
                    c = '#';
                    break;
                case 'D':
                    c = '$';
                    break;
                case 'E':
                    c = '%';
                    break;
                case 'F':
                    c = '&';
                    break;
                case 'G':
                    c = '\'';
                    break;
                case 'H':
                    c = '(';
                    break;
                case 'I':
                    c = ')';
                    break;
                case 'J':
                    c = '*';
                    break;
                case 'K':
                    c = '+';
                    break;
                case 'L':
                    c = ',';
                    break;
                case 'M':
                    c = '-';
                    break;
                case 'N':
                    c = '.';
                    break;
                case 'O':
                    c = '/';
                    break;
                case 'P':
                    c = '0';
                    break;
                case 'Q':
                    c = '1';
                    break;
                case 'R':
                    c = '2';
                    break;
                case 'S':
                    c = '3';
                    break;
                case 'T':
                    c = '4';
                    break;
                case 'U':
                    c = '5';
                    break;
                case 'V':
                    c = '6';
                    break;
                case 'W':
                    c = '7';
                    break;
                case 'X':
                    c = '8';
                    break;
                case 'Y':
                    c = '9';
                    break;
                case 'Z':
                    c = ':';
                    break;
                case '[':
                    c = ';';
                    break;
                case '\\':
                    c = '<';
                    break;
                case ']':
                    c = '=';
                    break;
                case '^':
                    c = '>';
                    break;
                case '_':
                    c = '?';
                    break;
                case '`':
                    c = '@';
                    break;
                case 'a':
                    c = 'A';
                    break;
                case 'b':
                    c = 'B';
                    break;
                case 'c':
                    c = 'C';
                    break;
                case 'd':
                    c = 'D';
                    break;
                case 'e':
                    c = 'E';
                    break;
                case 'f':
                    c = 'F';
                    break;
                case 'g':
                    c = 'G';
                    break;
                case 'h':
                    c = 'H';
                    break;
                case 'i':
                    c = 'I';
                    break;
                case 'j':
                    c = 'J';
                    break;
                case 'k':
                    c = 'K';
                    break;
                case 'l':
                    c = 'L';
                    break;
                case 'm':
                    c = 'M';
                    break;
                case 'n':
                    c = 'N';
                    break;
                case 'o':
                    c = 'O';
                    break;
                case 'p':
                    c = 'P';
                    break;
                case 'q':
                    c = 'Q';
                    break;
                case 'r':
                    c = 'R';
                    break;
                case 's':
                    c = 'S';
                    break;
                case 't':
                    c = 'T';
                    break;
                case 'u':
                    c = 'U';
                    break;
                case 'v':
                    c = 'V';
                    break;
                case 'w':
                    c = 'W';
                    break;
                case 'x':
                    c = 'X';
                    break;
                case 'y':
                    c = 'Y';
                    break;
                case 'z':
                    c = 'Z';
                    break;
                case '{':
                    c = '[';
                    break;
                case '|':
                    c = '\\';
                    break;
                case '}':
                    c = ']';
                    break;
                case '~':
                    c = '^';
                    break;
                case 153:
                case 8482:
                    c = 155;
                    break;
                case 161:
                    c = '`';
                    break;
                case 169:
                    c = 154;
                    break;
                case 171:
                    c = 'a';
                    break;
                case 174:
                    c = 153;
                    break;
                case 187:
                    c = 'b';
                    break;
                case 191:
                    c = 'c';
                    break;
                case 192:
                    c = 'd';
                    break;
                case 193:
                    c = 'e';
                    break;
                case 194:
                    c = 'f';
                    break;
                case 196:
                    c = 'g';
                    break;
                case 199:
                    c = 'h';
                    break;
                case 200:
                    c = 'i';
                    break;
                case 201:
                    c = 'j';
                    break;
                case 202:
                    c = 'k';
                    break;
                case 203:
                    c = 'l';
                    break;
                case 204:
                    c = 'm';
                    break;
                case 205:
                    c = 'n';
                    break;
                case 206:
                    c = 'o';
                    break;
                case 207:
                    c = 'p';
                    break;
                case 209:
                    c = 'q';
                    break;
                case 210:
                    c = 'r';
                    break;
                case 211:
                    c = 's';
                    break;
                case 212:
                    c = 't';
                    break;
                case 214:
                    c = 'u';
                    break;
                case 217:
                    c = 'v';
                    break;
                case 218:
                    c = 'w';
                    break;
                case 219:
                    c = 'x';
                    break;
                case 220:
                    c = 'y';
                    break;
                case 223:
                    c = 'z';
                    break;
                case 224:
                    c = '{';
                    break;
                case 225:
                    c = '|';
                    break;
                case 226:
                    c = '}';
                    break;
                case 228:
                    c = '~';
                    break;
                case 231:
                    c = 127;
                    break;
                case 232:
                    c = 128;
                    break;
                case 233:
                    c = 129;
                    break;
                case 234:
                    c = 130;
                    break;
                case 235:
                    c = 131;
                    break;
                case 236:
                    c = 132;
                    break;
                case 237:
                    c = 133;
                    break;
                case 238:
                    c = 134;
                    break;
                case 239:
                    c = 135;
                    break;
                case 241:
                    c = 136;
                    break;
                case 242:
                    c = 137;
                    break;
                case 243:
                    c = 138;
                    break;
                case 244:
                    c = 139;
                    break;
                case 246:
                    c = 140;
                    break;
                case 249:
                    c = 141;
                    break;
                case 250:
                    c = 142;
                    break;
                case 251:
                    c = 143;
                    break;
                case 252:
                    c = 144;
                    break;
                case 286:
                    c = 147;
                    break;
                case 287:
                    c = 148;
                    break;
                case 304:
                    c = 151;
                    break;
                case 305:
                    c = 152;
                    break;
                case 338:
                    c = 146;
                    break;
                case 339:
                    c = 145;
                    break;
                case 350:
                    c = 149;
                    break;
                case 351:
                    c = 150;
                    break;
                default:
                    c = 0;
                    break;
            }
            int i5 = i4 + this.f365c[c] + this.f362b;
            f358a.drawRegion(this.f360a, this.f361a[c], this.f363b[c], this.f365c[c], this.f364c, 6, i, i2 - i5, 0);
            i3++;
            i4 = i5;
        }
    }
}
