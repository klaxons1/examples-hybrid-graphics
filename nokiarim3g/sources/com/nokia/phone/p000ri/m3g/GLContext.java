package com.nokia.phone.p000ri.m3g;

import javax.microedition.lcdui.Graphics;
import javax.microedition.m3g.Image2D;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class GLContext {
    private C0000GL glState = new C0000GL();
    private int handle;

    private GLContext(int i) {
        this.handle = i;
    }

    private static native void _blitFromGraphics(int i, Graphics graphics, int i2, int i3, int i4, int i5, int i6, int i7);

    private static native void _blitFromImage2D(int i, Image2D image2D, int i2, int i3, int i4, int i5, int i6, int i7);

    private static native void _blitToGraphics(int i, Graphics graphics, int i2, int i3, int i4, int i5, int i6, int i7);

    private static native void _blitToImage2D(int i, Image2D image2D, int i2, int i3, int i4, int i5, int i6, int i7);

    private static native int _createOffscreenContext(int i, int i2, boolean z);

    private static native void _deleteContext(int i);

    private static native void _makeCurrent(int i);

    public static GLContext create(int i, int i2, boolean z) {
        return new GLContext(_createOffscreenContext(i, i2, z));
    }

    public void blitFrom(Graphics graphics, int i, int i2, int i3, int i4, int i5, int i6) {
        _blitFromGraphics(this.handle, graphics, i, i2, i3, i4, i5, i6);
    }

    public void blitFrom(Image2D image2D, int i, int i2, int i3, int i4, int i5, int i6) {
        _blitFromImage2D(this.handle, image2D, i, i2, i3, i4, i5, i6);
    }

    public void blitTo(Graphics graphics, int i, int i2, int i3, int i4, int i5, int i6) {
        _blitToGraphics(this.handle, graphics, i, i2, i3, i4, i5, i6);
    }

    public void blitTo(Image2D image2D, int i, int i2, int i3, int i4, int i5, int i6) {
        _blitToImage2D(this.handle, image2D, i, i2, i3, i4, i5, i6);
    }

    public void delete() {
        _deleteContext(this.handle);
        if (C0000GL.current == this.glState) {
            C0000GL.current = null;
        }
        this.glState = null;
    }

    public void makeCurrent() {
        _makeCurrent(this.handle);
        C0000GL.current = this.glState;
    }
}
