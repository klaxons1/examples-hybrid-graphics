package javax.microedition.m3g;

import com.nokia.phone.p000ri.m3g.C0000GL;
import com.nokia.phone.p000ri.m3g.GLContext;
import java.util.Hashtable;
import java.util.Vector;
import javax.microedition.lcdui.Graphics;

/* JADX INFO: loaded from: C:\Temp\jadx-930065285792042583\classes.dex */
public class Graphics3D {
    public static final int ANTIALIAS = 2;
    public static final int DITHER = 4;
    private static final int MAX_LIGHTS = 8;
    private static final int MAX_TEXTURE_DIMENSION = 256;
    private static final int MAX_TRANSFORMS_PER_VERTEX = Integer.MAX_VALUE;
    private static final int MAX_VIEWPORT_DIMENSION = 1024;
    private static final int NUM_TEXTURE_UNITS = 2;
    public static final int TRUE_COLOR = 8;
    private static Graphics3D s_instance = null;
    private Object currentTarget;
    private int dstClipHeight;
    private int dstClipWidth;
    private int dstClipX;
    private int dstClipY;
    private int dstOriginX;
    private int dstOriginY;
    private int targetFormat;
    private int trueDstX;
    private int trueDstY;
    private int trueHeight;
    private int trueSrcX;
    private int trueSrcY;
    private int trueWidth;
    private int viewportHeight;
    private int viewportWidth;
    private int viewportX;
    private int viewportY;
    private boolean depthBufferEnabled = true;
    private boolean ditheringEnabled = false;
    private boolean antialiasingEnabled = false;
    private boolean trueColorEnabled = false;
    private GLContext glContext = null;
    private int glMaxWidth = 32;
    private int glMaxHeight = 32;
    private float depthNear = 0.0f;
    private float depthFar = 1.0f;
    private Transform viewTransform = new Transform();
    private Camera camera = null;
    private Vector lights = new Vector();
    private Vector lightTransforms = new Vector();
    private RenderQueue renderQueue = new RenderQueue();

    private Graphics3D() {
        this.viewTransform.setIdentity();
    }

    public static final Graphics3D getInstance() {
        if (s_instance == null) {
            s_instance = new Graphics3D();
        }
        return s_instance;
    }

    static int getMaxLights() {
        return 8;
    }

    static int getMaxTextureDimension() {
        return 256;
    }

    static int getNumTextureUnits() {
        return 2;
    }

    public static final Hashtable getProperties() {
        Hashtable hashtable = new Hashtable();
        hashtable.put("supportAntialiasing", new Boolean(false));
        hashtable.put("supportTrueColor", new Boolean(false));
        hashtable.put("supportDithering", new Boolean(false));
        hashtable.put("supportMipmapping", new Boolean(true));
        hashtable.put("supportPerspectiveCorrection", new Boolean(true));
        hashtable.put("supportLocalCameraLighting", new Boolean(true));
        hashtable.put("maxLights", new Integer(8));
        hashtable.put("maxViewportDimension", new Integer(1024));
        hashtable.put("maxTextureDimension", new Integer(256));
        hashtable.put("maxSpriteCropDimension", new Integer(256));
        hashtable.put("numTextureUnits", new Integer(2));
        hashtable.put("maxTransformsPerVertex", new Integer(Integer.MAX_VALUE));
        return hashtable;
    }

    private void lockTargetPixels() {
        if (this.trueWidth <= 0 || this.trueHeight <= 0) {
            return;
        }
        if (this.currentTarget instanceof Graphics) {
            this.glContext.blitFrom((Graphics) this.currentTarget, this.trueDstX, this.trueDstY, this.trueWidth, this.trueHeight, this.trueSrcX, this.trueSrcY);
        } else if (this.currentTarget instanceof Image2D) {
            this.glContext.blitFrom((Image2D) this.currentTarget, this.trueDstX, this.trueDstY, this.trueWidth, this.trueHeight, this.trueSrcX, this.trueSrcY);
        }
    }

    private void releaseTargetPixels() {
        if (this.trueWidth <= 0 || this.trueHeight <= 0) {
            return;
        }
        if (this.currentTarget instanceof Graphics) {
            this.glContext.blitTo((Graphics) this.currentTarget, this.trueDstX, this.trueDstY, this.trueWidth, this.trueHeight, this.trueSrcX, this.trueSrcY);
        } else if (this.currentTarget instanceof Image2D) {
            Image2D image2D = (Image2D) this.currentTarget;
            this.glContext.blitTo(image2D, this.trueDstX, this.trueDstY, this.trueWidth, this.trueHeight, this.trueSrcX, this.trueSrcY);
            image2D.setDirty();
        }
    }

    private void updatePixelMapping() {
        this.trueSrcX = this.viewportX;
        this.trueSrcY = this.viewportY;
        this.trueWidth = this.viewportWidth;
        this.trueHeight = this.viewportHeight;
        this.trueDstX = this.viewportX + this.dstClipX;
        this.trueDstY = this.viewportY + this.dstClipY;
        if (this.trueDstX < this.dstClipX) {
            this.trueWidth -= this.dstClipX - this.trueDstX;
            this.trueSrcX += this.dstClipX - this.trueDstX;
            this.trueDstX = this.dstClipX;
        }
        if (this.trueDstY < this.dstClipY) {
            this.trueHeight -= this.dstClipY - this.trueDstY;
            this.trueSrcY += this.dstClipY - this.trueDstY;
            this.trueDstY = this.dstClipY;
        }
        if (this.trueDstX + this.trueWidth > this.dstClipX + this.dstClipWidth) {
            this.trueWidth -= (this.trueDstX + this.trueWidth) - (this.dstClipX + this.dstClipWidth);
        }
        if (this.trueDstY + this.trueHeight > this.dstClipY + this.dstClipHeight) {
            this.trueHeight -= (this.trueDstY + this.trueHeight) - (this.dstClipY + this.dstClipHeight);
        }
        if (this.trueSrcX < 0 || this.trueSrcY < 0 || this.trueSrcX + this.trueWidth > this.glMaxWidth || this.trueSrcY + this.trueHeight > this.glMaxHeight) {
            throw new Error("Internal error: source rectangle clipping");
        }
        if (this.trueDstX >= 0 && this.trueDstY >= 0 && this.trueDstX + this.trueWidth <= this.dstClipX + this.dstClipWidth && this.trueDstY + this.trueHeight <= this.dstClipY + this.dstClipHeight) {
            C0000GL.Scissor(this.trueSrcX, screenToGL(this.trueSrcY, this.trueHeight), this.trueWidth > 0 ? this.trueWidth : 0, this.trueHeight > 0 ? this.trueHeight : 0);
        } else {
            System.out.println(new StringBuffer().append("(").append(this.dstClipX).append(", ").append(this.dstClipY).append(")->(").append(this.dstClipX + this.dstClipWidth).append(", ").append(this.dstClipY + this.dstClipHeight).append(")").toString());
            System.out.println(new StringBuffer().append("(").append(this.trueDstX).append(", ").append(this.trueDstY).append(")->(").append(this.trueDstX + this.trueWidth).append(", ").append(this.trueDstY + this.trueHeight).append(")").toString());
            throw new Error("Internal error: destination rectangle clipping");
        }
    }

    private void validateGLContext() {
        if (this.glContext == null || this.glMaxWidth < this.dstClipWidth || this.glMaxHeight < this.dstClipHeight) {
            this.glMaxWidth = Math.max(this.dstClipWidth, this.glMaxWidth);
            this.glMaxHeight = Math.max(this.dstClipHeight, this.glMaxHeight);
            this.glContext = GLContext.create(this.glMaxWidth, this.glMaxHeight, true);
            this.glContext.makeCurrent();
            C0000GL.Enable(C0000GL.SCISSOR_TEST);
            C0000GL.Enable(C0000GL.NORMALIZE);
            C0000GL.PixelStore(C0000GL.UNPACK_ALIGNMENT, 1);
            C0000GL.LightModelfv(C0000GL.LIGHT_MODEL_AMBIENT, new float[]{0.0f, 0.0f, 0.0f, 0.0f});
            C0000GL.MatrixMode(C0000GL.MODELVIEW);
        } else {
            this.glContext.makeCurrent();
        }
        if (this.depthBufferEnabled) {
            C0000GL.Enable(C0000GL.DEPTH_TEST);
        } else {
            C0000GL.Disable(C0000GL.DEPTH_TEST);
        }
        if (this.ditheringEnabled) {
            C0000GL.Enable(C0000GL.DITHER);
        } else {
            C0000GL.Disable(C0000GL.DITHER);
        }
        if (this.antialiasingEnabled) {
            C0000GL.Enable(C0000GL.MULTISAMPLE);
        } else {
            C0000GL.Disable(C0000GL.MULTISAMPLE);
        }
    }

    public int addLight(Light light, Transform transform) {
        if (light == null) {
            throw new NullPointerException();
        }
        int i = 0;
        int size = this.lights.size();
        while (i < size && this.lights.elementAt(i) != null) {
            i++;
        }
        if (i == size) {
            this.lights.setSize(size + 1);
            this.lightTransforms.setSize(size + 1);
        }
        setLight(i, light, transform);
        return i;
    }

    void applyLights(int i) {
        int i2;
        int size = this.lights.size();
        int i3 = 0;
        int i4 = 0;
        while (i3 < size && i4 < 8) {
            Light light = (Light) this.lights.elementAt(i3);
            if ((light.getScope() & i) != 0) {
                C0000GL.PushMatrix();
                Transform transform = (Transform) this.lightTransforms.elementAt(i3);
                if (transform != null) {
                    C0000GL.MultMatrixf(transform.getMatrix());
                }
                light.apply(i4 + 16384);
                i2 = i4 + 1;
                C0000GL.PopMatrix();
            } else {
                i2 = i4;
            }
            i3++;
            i4 = i2;
        }
        while (i4 < 8) {
            C0000GL.Disable(i4 + 16384);
            i4++;
        }
    }

    public void bindTarget(Object obj) {
        bindTarget(obj, true, 0);
    }

    public void bindTarget(Object obj, boolean z, int i) {
        if (this.currentTarget != null) {
            throw new IllegalStateException();
        }
        if (obj == null) {
            throw new NullPointerException();
        }
        if ((i & (-15)) != 0) {
            throw new IllegalArgumentException();
        }
        this.depthBufferEnabled = z;
        this.antialiasingEnabled = (i & 2) != 0;
        this.ditheringEnabled = (i & 4) != 0;
        this.trueColorEnabled = (i & 8) != 0;
        if (obj instanceof Graphics) {
            Graphics graphics = (Graphics) obj;
            this.dstOriginX = graphics.getTranslateX();
            this.dstOriginY = graphics.getTranslateY();
            this.dstClipX = graphics.getClipX() + this.dstOriginX;
            this.dstClipY = graphics.getClipY() + this.dstOriginY;
            this.dstClipWidth = graphics.getClipWidth();
            this.dstClipHeight = graphics.getClipHeight();
            this.targetFormat = 99;
        } else {
            if (!(obj instanceof Image2D)) {
                throw new IllegalArgumentException();
            }
            Image2D image2D = (Image2D) obj;
            if (!image2D.isMutable() || (image2D.getFormat() != 99 && image2D.getFormat() != 100)) {
                throw new IllegalArgumentException();
            }
            this.dstOriginX = 0;
            this.dstOriginY = 0;
            this.dstClipX = 0;
            this.dstClipY = 0;
            this.dstClipWidth = image2D.getWidth();
            this.dstClipHeight = image2D.getHeight();
            this.targetFormat = image2D.getFormat();
        }
        this.viewportX = 0;
        this.viewportY = 0;
        this.viewportWidth = Math.min(this.dstClipWidth, 1024);
        this.viewportHeight = Math.min(this.dstClipHeight, 1024);
        validateGLContext();
        this.currentTarget = obj;
        updatePixelMapping();
        lockTargetPixels();
    }

    public void clear(Background background) {
        if (this.currentTarget == null) {
            throw new IllegalStateException();
        }
        this.glContext.makeCurrent();
        C0000GL.Viewport(this.viewportX, screenToGL(this.viewportY, this.viewportHeight), this.viewportWidth, this.viewportHeight);
        C0000GL.DepthRange(this.depthNear, this.depthFar);
        if (background != null) {
            background.apply(this.viewportWidth, this.viewportHeight, this.targetFormat);
        } else {
            Background.applyDefaults();
        }
    }

    Camera getCurrentCamera() {
        return this.camera;
    }

    Transform getViewTransform() {
        return this.viewTransform;
    }

    int getViewportHeight() {
        return this.viewportHeight;
    }

    int getViewportWidth() {
        return this.viewportWidth;
    }

    int getViewportX() {
        return this.viewportX;
    }

    int getViewportY() {
        return this.viewportY;
    }

    public void releaseTarget() {
        if (this.currentTarget == null) {
            throw new IllegalStateException();
        }
        this.glContext.makeCurrent();
        C0000GL.Finish();
        releaseTargetPixels();
        this.currentTarget = null;
    }

    public void render(Node node, Transform transform) {
        if (this.currentTarget == null || this.camera == null) {
            throw new IllegalStateException();
        }
        if (node == null) {
            throw new NullPointerException();
        }
        if (!(node instanceof Mesh) && !(node instanceof Sprite3D) && !(node instanceof Group)) {
            throw new IllegalArgumentException();
        }
        if (this.trueWidth <= 0 || this.trueHeight <= 0) {
            return;
        }
        Transform transform2 = new Transform();
        try {
            if (transform != null) {
                transform2.set(transform);
            } else {
                transform2.setIdentity();
            }
            this.renderQueue.begin(node, null);
            node.setupRender(transform2, null, this.renderQueue);
            this.renderQueue.commit(this);
            this.renderQueue.clear();
        } catch (Throwable th) {
            this.renderQueue.clear();
            throw th;
        }
    }

    public void render(VertexBuffer vertexBuffer, IndexBuffer indexBuffer, Appearance appearance, Transform transform) {
        render(vertexBuffer, indexBuffer, appearance, transform, -1);
    }

    public void render(VertexBuffer vertexBuffer, IndexBuffer indexBuffer, Appearance appearance, Transform transform, int i) {
        if (this.currentTarget == null || this.camera == null) {
            throw new IllegalStateException();
        }
        if (vertexBuffer == null || indexBuffer == null || appearance == null) {
            throw new NullPointerException();
        }
        if (indexBuffer.getMaxIndex() >= vertexBuffer.getNumVertices()) {
            throw new IllegalStateException();
        }
        if (this.trueWidth <= 0 || this.trueHeight <= 0) {
            return;
        }
        render(vertexBuffer, indexBuffer, appearance, transform, i, 1.0f);
    }

    void render(VertexBuffer vertexBuffer, IndexBuffer indexBuffer, Appearance appearance, Transform transform, int i, float f) {
        if (!this.camera.isValid() || (this.camera.getScope() & i) == 0) {
            return;
        }
        this.glContext.makeCurrent();
        C0000GL.Viewport(this.viewportX, screenToGL(this.viewportY, this.viewportHeight), this.viewportWidth, this.viewportHeight);
        C0000GL.DepthRange(this.depthNear, this.depthFar);
        this.camera.applyProjection();
        C0000GL.LoadIdentity();
        C0000GL.MultMatrixf(this.viewTransform.getMatrix());
        applyLights(i);
        if (transform != null) {
            C0000GL.MultMatrixf(transform.getMatrix());
        }
        float fClamp = Util.clamp(f);
        appearance.apply(fClamp);
        vertexBuffer.load(appearance.getVertexMask(), fClamp);
        vertexBuffer.applyScaleBias();
        indexBuffer.draw();
    }

    public void render(World world) {
        Camera activeCamera = world.getActiveCamera();
        if (this.currentTarget == null || activeCamera == null || !activeCamera.isChildOf(world)) {
            throw new IllegalStateException();
        }
        setCamera(activeCamera, null);
        try {
            clear(world.getBackground());
            try {
                Transform transform = new Transform();
                world.getTransformTo(activeCamera, transform);
                transform.setIdentity();
                resetLights();
                this.renderQueue.begin(world, this);
                activeCamera.setupRender(transform, null, this.renderQueue);
                this.renderQueue.commit(this);
            } finally {
                this.renderQueue.clear();
            }
        } catch (IllegalArgumentException e) {
            throw new IllegalStateException();
        }
    }

    public void resetLights() {
        this.lights.removeAllElements();
        this.lightTransforms.removeAllElements();
    }

    int screenToGL(int i, int i2) {
        return this.glMaxHeight - (i + i2);
    }

    public void setCamera(Camera camera, Transform transform) {
        if (transform != null) {
            try {
                transform.getInverse(this.viewTransform);
            } catch (IllegalStateException e) {
                throw new ArithmeticException();
            }
        } else {
            this.viewTransform.setIdentity();
        }
        this.camera = camera;
    }

    public void setDepthRange(float f, float f2) {
        if (f < 0.0f || f > 1.0f || f2 < 0.0f || f2 > 1.0f) {
            throw new IllegalArgumentException();
        }
        this.depthNear = f;
        this.depthFar = f2;
    }

    public void setLight(int i, Light light, Transform transform) {
        if (i < 0 || i >= this.lights.size()) {
            throw new IndexOutOfBoundsException();
        }
        this.lights.setElementAt(light, i);
        if (light == null || transform == null) {
            this.lightTransforms.setElementAt(null, i);
            return;
        }
        if (this.lightTransforms.elementAt(i) == null) {
            this.lightTransforms.setElementAt(new Transform(), i);
        }
        ((Transform) this.lightTransforms.elementAt(i)).set(transform);
    }

    public void setViewport(int i, int i2, int i3, int i4) {
        if (i3 <= 0 || i4 <= 0 || i3 > 1024 || i4 > 1024) {
            throw new IllegalArgumentException();
        }
        this.viewportX = (this.dstOriginX + i) - this.dstClipX;
        this.viewportY = (this.dstOriginY + i2) - this.dstClipY;
        this.viewportWidth = i3;
        this.viewportHeight = i4;
        if (this.currentTarget != null) {
            this.glContext.makeCurrent();
            releaseTargetPixels();
            updatePixelMapping();
            lockTargetPixels();
        }
    }
}
