package p000;

import javax.microedition.lcdui.Graphics;
import p001a.p002a.p003a.p004a.C0002b;

/* JADX INFO: loaded from: C:\Temp\jadx-6965330237357844059\classes.dex */
public class GoldenWarrior3D extends C0002b {

    /* JADX INFO: renamed from: aA */
    int f0aA;

    /* JADX INFO: renamed from: aB */
    int f1aB;

    /* JADX INFO: renamed from: aC */
    int f2aC;

    /* JADX INFO: renamed from: aD */
    int f3aD;

    /* JADX INFO: renamed from: aE */
    int f4aE;

    /* JADX INFO: renamed from: aF */
    int f5aF;

    /* JADX INFO: renamed from: aG */
    int f6aG;

    /* JADX INFO: renamed from: az */
    int f7az;

    public GoldenWarrior3D() {
        super(new RunnableC0000a(), true, true, new int[]{RunnableC0000a.f67cu, 0});
        this.f4aE = 255;
        this.f5aF = 196;
        this.f7az = 0;
        this.f0aA = 0;
        this.f1aB = 0;
        this.f3aD = 0;
        this.f6aG = this.f449aw.getHeight() / 10;
        this.f2aC = this.f449aw.getWidth() - 5;
        this.f415G = 16776960;
    }

    @Override // p001a.p002a.p003a.p004a.C0002b
    /* JADX INFO: renamed from: a */
    public void mo0a(Graphics graphics, int i) {
        graphics.setColor(0);
        graphics.fillRect(0, 0, this.f449aw.getWidth(), this.f449aw.getHeight());
        int i2 = (this.f2aC * ((i << 8) / 100)) >> 8;
        int width = (this.f449aw.getWidth() - this.f2aC) / 2;
        int height = (this.f449aw.getHeight() - this.f6aG) / 2;
        graphics.setColor(16777011);
        graphics.drawRect(width - 1, height - 1, this.f2aC + 2, this.f6aG + 2);
        for (int i3 = 0; i3 < i2; i3++) {
            int i4 = ((i2 - i3) << 8) / this.f2aC;
            graphics.setColor(this.f4aE + (((this.f0aA - this.f4aE) * i4) >> 8), this.f5aF + (((this.f1aB - this.f5aF) * i4) >> 8), ((i4 * (this.f3aD - this.f7az)) >> 8) + this.f7az);
            graphics.drawLine(width + i3, height, width + i3, this.f6aG + height);
        }
    }
}
