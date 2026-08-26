package p000;

import javax.microedition.lcdui.Display;

/* JADX INFO: renamed from: ab */
/* JADX INFO: loaded from: C:\Temp\jadx-11138887959836137865\classes.dex */
public final class C0002ab {

    /* JADX INFO: renamed from: a */
    public static Display f9a;

    /* JADX INFO: renamed from: a */
    public static boolean f10a;

    /* JADX INFO: renamed from: a */
    private AbstractC0023aw f19a;

    /* JADX INFO: renamed from: a */
    private C0047bt f20a;

    /* JADX INFO: renamed from: a */
    private AbstractC0048bu f21a;

    /* JADX INFO: renamed from: a */
    public int[] f22a;

    /* JADX INFO: renamed from: f */
    private static float f12f = 0.9f;

    /* JADX INFO: renamed from: g */
    private static float f13g = 1.0f;

    /* JADX INFO: renamed from: b */
    private static int f11b = 0;

    /* JADX INFO: renamed from: h */
    private static float f14h = 0.00875f;

    /* JADX INFO: renamed from: i */
    private static float f15i = 0.4f;

    /* JADX INFO: renamed from: j */
    private static float f16j = 0.2f;

    /* JADX INFO: renamed from: a */
    public int f18a = 0;

    /* JADX INFO: renamed from: e */
    private float f26e = 0.0f;

    /* JADX INFO: renamed from: d */
    private float f25d = 0.0f;

    /* JADX INFO: renamed from: c */
    private float f24c = 0.0f;

    /* JADX INFO: renamed from: b */
    private float f23b = 0.0f;

    /* JADX INFO: renamed from: a */
    private float f17a = 0.0f;

    public C0002ab(float f, float f2, float f3, float f4, float f5, float f6, AbstractC0023aw abstractC0023aw, AbstractC0048bu abstractC0048bu) {
        this.f19a = abstractC0023aw;
        this.f21a = abstractC0048bu;
        this.f20a = new C0047bt(f, f2, f3, f4, f5, f6, f16j);
        ((AbstractC0015ao) this.f20a).f199a.f272c = true;
    }

    /* JADX INFO: renamed from: a */
    public final C0005ae m9a() {
        return this.f20a.m161a();
    }

    /* JADX INFO: renamed from: a */
    public final void m10a() {
        if (this.f25d < f12f) {
            this.f25d += 2.0f * f14h;
        }
        if (this.f25d < 0.0f) {
            this.f25d = 0.0f;
        }
    }

    /* JADX INFO: renamed from: a */
    public final void m11a(int i, int i2, int i3, int i4) {
        C0073j c0073j = new C0073j();
        c0073j.m231a();
        c0073j.m248d(0, i4, 0);
        c0073j.m242b(i, i2, i3);
        this.f20a.m164a(c0073j);
        this.f19a.f257a.m235a(this.f20a.m162a(this.f19a.f257a));
        this.f19a.m100a(0, 0, 0);
    }

    /* JADX INFO: renamed from: a */
    public final void m12a(long j) {
        this.f19a.f257a.m235a(this.f20a.m162a(this.f19a.f257a));
        this.f19a.m100a(0, 0, 0);
        this.f19a.mo21a(true);
        C0073j c0073jM162a = this.f20a.m162a(new C0073j());
        if (f11b > 0 && this.f21a != null) {
            ((AbstractC0023aw) this.f21a).f257a.m235a(this.f20a.m162a(((AbstractC0023aw) this.f21a).f257a));
            this.f21a.m100a(0, 0, 0);
        }
        this.f17a = ((((AbstractC0015ao) this.f20a).f199a.f268a[34] - ((AbstractC0015ao) this.f20a).f199a.f268a[4]) * (1.0f - Math.abs(this.f26e))) + ((((AbstractC0015ao) this.f20a).f199a.f268a[14] - ((AbstractC0015ao) this.f20a).f199a.f268a[4]) * this.f26e);
        this.f23b = ((((AbstractC0015ao) this.f20a).f199a.f268a[35] - ((AbstractC0015ao) this.f20a).f199a.f268a[5]) * (1.0f - Math.abs(this.f26e))) + ((((AbstractC0015ao) this.f20a).f199a.f268a[15] - ((AbstractC0015ao) this.f20a).f199a.f268a[5]) * this.f26e);
        this.f24c = ((((AbstractC0015ao) this.f20a).f199a.f268a[36] - ((AbstractC0015ao) this.f20a).f199a.f268a[6]) * (1.0f - Math.abs(this.f26e))) + ((((AbstractC0015ao) this.f20a).f199a.f268a[16] - ((AbstractC0015ao) this.f20a).f199a.f268a[6]) * this.f26e);
        float fSqrt = this.f25d / ((float) Math.sqrt(((this.f17a * this.f17a) + (this.f23b * this.f23b)) + (this.f24c * this.f24c)));
        this.f17a *= fSqrt;
        this.f23b *= fSqrt;
        this.f24c = fSqrt * this.f24c;
        if (((AbstractC0015ao) this.f20a).f199a.f270a[2]) {
            float[] fArr = ((AbstractC0015ao) this.f20a).f199a.f268a;
            fArr[24] = fArr[24] + (j * this.f17a);
            float[] fArr2 = ((AbstractC0015ao) this.f20a).f199a.f268a;
            fArr2[25] = fArr2[25] + (j * this.f23b);
            float[] fArr3 = ((AbstractC0015ao) this.f20a).f199a.f268a;
            fArr3[26] = fArr3[26] + (j * this.f24c);
        }
        if (((AbstractC0015ao) this.f20a).f199a.f270a[3]) {
            float[] fArr4 = ((AbstractC0015ao) this.f20a).f199a.f268a;
            fArr4[34] = fArr4[34] + (j * this.f17a);
            float[] fArr5 = ((AbstractC0015ao) this.f20a).f199a.f268a;
            fArr5[35] = fArr5[35] + (j * this.f23b);
            float[] fArr6 = ((AbstractC0015ao) this.f20a).f199a.f268a;
            fArr6[36] = fArr6[36] + (j * this.f24c);
        }
        if (f11b > 0) {
            this.f25d = f13g;
            f11b--;
        } else {
            if (this.f25d > 0.0f) {
                this.f25d -= f14h;
            }
            if (this.f25d < 0.0f) {
                this.f25d += f14h;
            }
        }
        this.f26e = 0.0f;
        if (this.f22a != null && this.f18a < this.f22a.length) {
            float f = this.f22a[this.f18a] - ((AbstractC0015ao) this.f20a).f199a.f268a[4];
            float f2 = this.f22a[this.f18a + 2] - ((AbstractC0015ao) this.f20a).f199a.f268a[6];
            float f3 = ((AbstractC0015ao) this.f20a).f199a.f268a[34] - ((AbstractC0015ao) this.f20a).f199a.f268a[4];
            float f4 = ((AbstractC0015ao) this.f20a).f199a.f268a[36] - ((AbstractC0015ao) this.f20a).f199a.f268a[6];
            Math.sqrt((f * f) + (f2 * f2));
            Math.sqrt((f3 * f3) + (f4 * f4));
            if (Math.abs(((int) ((AbstractC0015ao) this.f20a).f199a.f268a[4]) - this.f22a[this.f18a]) < 1000 && Math.abs(((int) ((AbstractC0015ao) this.f20a).f199a.f268a[6]) - this.f22a[this.f18a + 2]) < 1000) {
                this.f18a += 3;
            }
        }
        if (f10a && ((AbstractC0015ao) this.f20a).f199a.f267a) {
            f9a.vibrate(100);
        }
        this.f20a.m162a(c0073jM162a);
    }

    /* JADX INFO: renamed from: a */
    public final void m13a(C0071h c0071h) {
        this.f20a.m163a(c0071h);
    }

    /* JADX INFO: renamed from: a */
    public final float[] m14a(float[] fArr) {
        return this.f20a.m165a(fArr);
    }

    /* JADX INFO: renamed from: b */
    public final void m15b() {
        if (this.f25d > (-f12f)) {
            this.f25d -= 2.0f * f14h;
        }
    }

    /* JADX INFO: renamed from: c */
    public final void m16c() {
        this.f26e = f15i;
    }

    /* JADX INFO: renamed from: d */
    public final void m17d() {
        this.f26e = -f15i;
    }
}
