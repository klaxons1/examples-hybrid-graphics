package p000;

import java.util.Random;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.m3g.Appearance;
import javax.microedition.m3g.Camera;
import javax.microedition.m3g.CompositingMode;
import javax.microedition.m3g.Fog;
import javax.microedition.m3g.Graphics3D;
import javax.microedition.m3g.Image2D;
import javax.microedition.m3g.Loader;
import javax.microedition.m3g.Material;
import javax.microedition.m3g.Mesh;
import javax.microedition.m3g.Node;
import javax.microedition.m3g.Object3D;
import javax.microedition.m3g.PolygonMode;
import javax.microedition.m3g.Texture2D;
import javax.microedition.m3g.TriangleStripArray;
import javax.microedition.m3g.VertexArray;
import javax.microedition.m3g.VertexBuffer;
import javax.microedition.m3g.World;

/* JADX INFO: loaded from: C:\Temp\jadx-5247753011597502155\classes.dex */
public class Nokia3D extends Canvas {
    private static final boolean DEBUG = false;
    private static final int DUAL_TEXTURE = 2;
    private static final float GROUND_LEVEL = 0.0f;
    private static final int NO_TEXTURE = 0;
    private static final int NUM_SNOWFLAKES = 20;
    private static final int ONE_TEXTURE = 1;
    private static final int SCENE_BUG = 1;
    private static final int SCENE_BUG_LENGTH = 6700;
    private static final int SCENE_COUNT = 5;
    private static final int SCENE_NOKIA = 0;
    private static final int SCENE_NOKIA_HIDEBUG = 22000;
    private static final int SCENE_NOKIA_LENGTH = 33000;
    private static final int SCENE_POND = 3;
    private static final int SCENE_TUNNEL = 2;
    private static final int SCENE_TUNNEL_LENGTH = 3000;
    private static final float SNOWFLAKE_SCALE = 6.0f;
    private static final int TOGGLE_FOG = 3;
    private static final int UID_NOKIA_ANTIMAGE = 47364324;
    private static final int UID_POND_ANTHEAD = 296699498;
    private static final int UID_POND_CAMERA1 = 653251478;
    private static final int UID_POND_CAMERA2 = 124296655;
    private static final int UID_POND_CAMERA3 = 901844788;
    private static final int UID_POND_CAMERA4 = 468090727;
    private static final int UID_TUNNEL_CAMERA = 457572229;
    private static final int UID_TUNNEL_LIGHT = 131143914;
    private static final int UID_TUNNEL_MESH = 116237701;
    private Appearance flakeAppearance;
    private CompositingMode flakeCompositing;
    private Material flakeMaterial;
    private PolygonMode flakePolyMode;
    private Texture2D flakeTexture;
    private VertexArray flakeTextureArray;
    private Image2D flakeTextureImage;
    private TriangleStripArray flakeTriangles;
    private VertexArray flakeVertexArray;
    private VertexBuffer flakeVertexBuffer;
    private Graphics3D g3d;
    private int m_currentScene;
    private int m_currentTime;
    private int m_deltaTime;
    private long m_lastFrame;
    private GameMIDlet m_midlet;
    private World[] m_scenes;
    private Mesh[] m_snowFlakes;
    private int numTextureUnits;
    private Fog tunnelFog;
    private short[] tunnelTexCoords;
    private Texture2D tunnelTexture1;
    private Texture2D tunnelTexture2;
    private VertexArray tunnelTextureArray;
    private Image2D tunnelTextureImage2;
    private static final short[] flakeVertices = {-10, 0, 10, -10, 0, -10, 10, 0, 10, 10, 0, -10};
    private static final short[] flakeTexCoords = {0, 10, 0, 0, 10, 10, 10, 0};
    private static final int SCENE_LOWPOLY = 4;
    private static final int[] flakeStripLengths = {SCENE_LOWPOLY};
    private static final int[] flakeStrip = {0, 1, 2, 3};
    private Random m_random = new Random();
    private boolean m_tunnelFadeOut = DEBUG;
    private boolean m_fogOn = DEBUG;
    private float m_lightIntensity = 1.0f;
    private float[] m_cameraFOVs = {35.0f, 25.0f, 30.0f, 30.0f};
    private int m_currentCamera = 0;
    private boolean showBug = DEBUG;

    public Nokia3D(GameMIDlet gameMIDlet) {
        this.m_midlet = gameMIDlet;
    }

    public void startApp(boolean z) {
        this.g3d = Graphics3D.getInstance();
        try {
            this.m_scenes = new World[SCENE_COUNT];
            this.m_scenes[0] = loadScene("/nokia_on_ice.m3g");
            preInitNokiaScene();
            this.m_currentScene = 0;
            this.m_currentTime = 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private World loadScene(String str) {
        long jFreeMemory = Runtime.getRuntime().freeMemory();
        Object3D[] object3DArrLoad = null;
        try {
            object3DArrLoad = Loader.load(str);
        } catch (Exception e) {
            e.printStackTrace();
        } catch (OutOfMemoryError e2) {
            System.err.println("Not enough memory.\nUse '-heapsize 1M' to increse heap size.");
            this.m_midlet.destroyApp(true);
        }
        long jFreeMemory2 = jFreeMemory - Runtime.getRuntime().freeMemory();
        return (World) object3DArrLoad[0];
    }

    public void executeOnce() {
        if (Display.getDisplay(this.m_midlet).getCurrent() == this) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (this.m_lastFrame == 0) {
                this.m_deltaTime = 0;
            } else {
                this.m_deltaTime = (int) (jCurrentTimeMillis - this.m_lastFrame);
            }
            this.m_lastFrame = jCurrentTimeMillis;
            repaint();
            serviceRepaints();
        }
    }

    protected void keyPressed(int i) {
        int gameAction = getGameAction(i);
        if (this.m_currentScene == 2) {
            if (i == 49) {
                switchTunnelMode(0);
            } else if (i == 50) {
                switchTunnelMode(1);
            } else if (i == 51) {
                switchTunnelMode(2);
            } else if (i == 52) {
                switchTunnelMode(3);
            } else if (i == 53) {
                this.m_tunnelFadeOut = true;
            }
        }
        if (this.m_currentScene == 3) {
            World world = this.m_scenes[3];
            if (i == 49) {
                world.setActiveCamera(world.find(UID_POND_CAMERA1));
                this.m_currentCamera = 0;
            } else if (i == 50) {
                world.setActiveCamera(world.find(UID_POND_CAMERA2));
                this.m_currentCamera = 1;
            } else if (i == 51) {
                world.setActiveCamera(world.find(UID_POND_CAMERA3));
                this.m_currentCamera = 2;
            } else if (i == 52) {
                world.setActiveCamera(world.find(UID_POND_CAMERA4));
                this.m_currentCamera = 3;
            } else if (gameAction == 1) {
                float f = this.m_cameraFOVs[this.m_currentCamera];
                if (f > 15.0f) {
                    f -= 5.0f;
                }
                this.m_cameraFOVs[this.m_currentCamera] = f;
                world.getActiveCamera().setPerspective(f, 1.0f, 0.1f, 5.0f);
            } else if (gameAction == 6) {
                float f2 = this.m_cameraFOVs[this.m_currentCamera];
                if (f2 < 45.0f) {
                    f2 += 5.0f;
                }
                this.m_cameraFOVs[this.m_currentCamera] = f2;
                world.getActiveCamera().setPerspective(f2, 1.0f, 0.1f, 5.0f);
            }
        }
        if (i == 48) {
            this.m_midlet.destroyApp(true);
        }
    }

    public void paint(Graphics graphics) {
        int width = getWidth();
        int height = getHeight();
        if (this.g3d == null) {
            graphics.setClip(0, 0, width, height);
            graphics.setColor(100, 10, 15);
            graphics.fillRect(0, 0, width, height);
            return;
        }
        int i = (this.m_deltaTime * 3) / SCENE_LOWPOLY;
        updateDemo(this.m_currentTime, i);
        this.g3d.bindTarget(graphics);
        try {
            World world = this.m_scenes[this.m_currentScene];
            world.animate(this.m_currentTime);
            postAnimate();
            this.g3d.render(world);
            this.g3d.releaseTarget();
            this.m_currentTime = i + this.m_currentTime;
        } catch (Throwable th) {
            this.g3d.releaseTarget();
            throw th;
        }
    }

    private void updateDemo(int i, int i2) {
        if (this.m_currentScene == 0) {
            updateNokiaScene(i);
        } else if (this.m_currentScene == 1) {
            updateBugScene(i);
        } else if (this.m_currentScene == 2) {
            updateTunnelScene(i, i2);
        }
    }

    private void postAnimate() {
        if (this.m_currentScene == 3) {
            this.m_scenes[this.m_currentScene].getActiveCamera().getParent().align((Node) null);
        }
    }

    private void freeOldScene() {
        Runtime.getRuntime().freeMemory();
        removeSnowFlakes();
        removeTunnelScene();
        this.m_scenes[this.m_currentScene] = null;
        System.gc();
    }

    private void showMemory() {
    }

    private void preInitNokiaScene() {
        this.m_scenes[0].find(UID_NOKIA_ANTIMAGE).setRenderingEnable(DEBUG);
        initSnowFlakes();
    }

    private void updateNokiaScene(int i) {
        if (i > SCENE_NOKIA_HIDEBUG && !this.showBug) {
            this.m_scenes[0].find(UID_NOKIA_ANTIMAGE).setRenderingEnable(true);
            this.showBug = true;
        }
        animateSnowFlakes(i);
        if (i > SCENE_NOKIA_LENGTH) {
            freeOldScene();
            this.m_scenes[1] = loadScene("/otokka_jump2.m3g");
            this.m_currentScene = 1;
            this.m_currentTime = 0;
        }
    }

    private void updateBugScene(int i) {
        if (i > SCENE_BUG_LENGTH) {
            freeOldScene();
            this.m_scenes[2] = loadScene("/tunnel.m3g");
            preInitTunnelScene();
            this.m_currentScene = 2;
            this.m_currentTime = 0;
        }
    }

    private void preInitTunnelScene() {
        Mesh meshFind = this.m_scenes[2].find(UID_TUNNEL_MESH);
        Appearance appearance = meshFind.getAppearance(0);
        VertexBuffer vertexBuffer = meshFind.getVertexBuffer();
        int vertexCount = vertexBuffer.getVertexCount();
        Graphics3D graphics3D = this.g3d;
        this.numTextureUnits = ((Integer) Graphics3D.getProperties().get("numTextureUnits")).intValue();
        if (this.numTextureUnits > 1) {
            this.tunnelTexCoords = new short[vertexCount * 2];
            for (int i = 0; i < vertexCount * 2; i++) {
                this.tunnelTexCoords[i] = (short) (this.m_random.nextInt() & 255);
            }
            this.tunnelTextureArray = new VertexArray(vertexCount, 2, 2);
            this.tunnelTextureArray.set(0, vertexCount, this.tunnelTexCoords);
            vertexBuffer.setTexCoords(1, this.tunnelTextureArray, 4.0E-4f, (float[]) null);
            this.tunnelTextureImage2 = new Image2D(99, loadImage("/ttex2.png"));
            this.tunnelTexture2 = new Texture2D(this.tunnelTextureImage2);
            this.tunnelTexture2.setBlending(224);
        }
        this.tunnelTexture1 = appearance.getTexture(0);
        switchTunnelMode(1);
        this.tunnelFog = new Fog();
        this.tunnelFog.setMode(81);
        this.tunnelFog.setColor(6324384);
        this.tunnelFog.setLinear(10.0f, 25.0f);
    }

    private void updateTunnelScene(int i, int i2) {
        this.m_scenes[2].find(UID_TUNNEL_LIGHT).setIntensity(this.m_lightIntensity);
        if (this.m_tunnelFadeOut) {
            this.m_lightIntensity -= i2 * 0.001f;
            if (this.m_lightIntensity <= -2.0f) {
                freeOldScene();
                this.m_scenes[3] = loadScene("/pond_vilkutus2.m3g");
                preInitPondScene();
                this.m_currentScene = 3;
                this.m_currentTime = 0;
            }
        }
    }

    private void removeTunnelScene() {
        this.tunnelTextureImage2 = null;
        this.tunnelFog = null;
        this.tunnelTexture1 = null;
        this.tunnelTexture2 = null;
        this.tunnelTextureArray = null;
        this.tunnelTexCoords = null;
    }

    private void switchTunnelMode(int i) {
        Appearance appearance = this.m_scenes[2].find(UID_TUNNEL_MESH).getAppearance(0);
        if (i == 0) {
            appearance.setTexture(0, (Texture2D) null);
            if (this.numTextureUnits > 1) {
                appearance.setTexture(1, (Texture2D) null);
                return;
            }
            return;
        }
        if (i == 1) {
            appearance.setTexture(0, this.tunnelTexture1);
            if (this.numTextureUnits > 1) {
                appearance.setTexture(1, (Texture2D) null);
                return;
            }
            return;
        }
        if (i == 2) {
            appearance.setTexture(0, this.tunnelTexture1);
            if (this.numTextureUnits > 1) {
                appearance.setTexture(1, this.tunnelTexture2);
                return;
            }
            return;
        }
        if (i == 3) {
            if (!this.m_fogOn) {
                appearance.setFog(this.tunnelFog);
                this.m_fogOn = true;
            } else {
                appearance.setFog((Fog) null);
                this.m_fogOn = DEBUG;
            }
        }
    }

    private void preInitPondScene() {
        World world = this.m_scenes[3];
        Camera cameraFind = world.find(UID_POND_CAMERA1);
        cameraFind.setPerspective(this.m_cameraFOVs[0], 1.0f, 0.1f, 5.0f);
        this.m_currentCamera = 0;
        world.setActiveCamera(cameraFind);
        Node nodeFind = world.find(UID_POND_ANTHEAD);
        cameraFind.getParent().setAlignment(nodeFind, 145, world, 148);
        cameraFind.scale(-1.0f, 1.0f, -1.0f);
        Camera cameraFind2 = world.find(UID_POND_CAMERA2);
        cameraFind2.setPerspective(this.m_cameraFOVs[1], 1.0f, 0.1f, 5.0f);
        cameraFind2.getParent().setAlignment(nodeFind, 145, world, 148);
        cameraFind2.scale(-1.0f, 1.0f, -1.0f);
        Camera cameraFind3 = world.find(UID_POND_CAMERA3);
        cameraFind3.setPerspective(this.m_cameraFOVs[2], 1.0f, 0.1f, 5.0f);
        cameraFind3.getParent().setAlignment(nodeFind, 145, world, 148);
        cameraFind3.scale(-1.0f, 1.0f, -1.0f);
        Camera cameraFind4 = world.find(UID_POND_CAMERA4);
        cameraFind4.setPerspective(this.m_cameraFOVs[3], 1.0f, 0.1f, 5.0f);
        cameraFind4.getParent().setAlignment(nodeFind, 145, world, 148);
        cameraFind4.scale(-1.0f, 1.0f, -1.0f);
    }

    private Image loadImage(String str) {
        try {
            return Image.createImage(str);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private void initSnowFlakes() {
        this.flakeVertexArray = new VertexArray(flakeVertices.length / 3, 3, 2);
        this.flakeVertexArray.set(0, flakeVertices.length / 3, flakeVertices);
        this.flakeTextureArray = new VertexArray(flakeTexCoords.length / 2, 2, 2);
        this.flakeTextureArray.set(0, flakeTexCoords.length / 2, flakeTexCoords);
        this.flakeVertexBuffer = new VertexBuffer();
        this.flakeVertexBuffer.setPositions(this.flakeVertexArray, 0.01f, (float[]) null);
        this.flakeVertexBuffer.setTexCoords(0, this.flakeTextureArray, 0.1f, (float[]) null);
        this.flakeTriangles = new TriangleStripArray(flakeStrip, flakeStripLengths);
        this.flakeAppearance = new Appearance();
        this.flakeTextureImage = new Image2D(100, loadImage("/snowflake.png"));
        this.flakeTexture = new Texture2D(this.flakeTextureImage);
        this.flakeTexture.setFiltering(208, 210);
        this.flakeTexture.setBlending(228);
        this.flakePolyMode = new PolygonMode();
        this.flakePolyMode.setPerspectiveCorrectionEnable(DEBUG);
        this.flakePolyMode.setShading(164);
        this.flakePolyMode.setCulling(162);
        this.flakePolyMode.setWinding(169);
        this.flakePolyMode.setLocalCameraLightingEnable(DEBUG);
        this.flakePolyMode.setTwoSidedLightingEnable(true);
        this.flakeCompositing = new CompositingMode();
        this.flakeCompositing.setBlending(64);
        this.flakeCompositing.setAlphaWriteEnable(DEBUG);
        this.flakeAppearance.setTexture(0, this.flakeTexture);
        this.flakeAppearance.setPolygonMode(this.flakePolyMode);
        this.flakeAppearance.setCompositingMode(this.flakeCompositing);
        World world = this.m_scenes[0];
        this.m_snowFlakes = new Mesh[NUM_SNOWFLAKES];
        for (int i = 0; i < NUM_SNOWFLAKES; i++) {
            this.m_snowFlakes[i] = new Mesh(this.flakeVertexBuffer, this.flakeTriangles, this.flakeAppearance);
            this.m_snowFlakes[i].translate(rnd(-6.0f, SNOWFLAKE_SCALE), rnd(-6.0f, SNOWFLAKE_SCALE), rnd(GROUND_LEVEL, 3.0f));
            world.addChild(this.m_snowFlakes[i]);
        }
    }

    private void removeSnowFlakes() {
        this.flakeAppearance = null;
        this.flakeMaterial = null;
        this.flakePolyMode = null;
        this.flakeCompositing = null;
        this.flakeTextureImage = null;
        this.flakeTexture = null;
        this.flakeVertexArray = null;
        this.flakeTextureArray = null;
        this.flakeVertexBuffer = null;
        this.flakeTriangles = null;
        this.m_snowFlakes = null;
    }

    private float rnd(float f, float f2) {
        float fNextInt = (this.m_random.nextInt() & 4095) / 4095.0f;
        return (fNextInt * f2) + ((1.0f - fNextInt) * f);
    }

    private void animateSnowFlakes(int i) {
        float[] fArr = new float[3];
        for (int i2 = 0; i2 < NUM_SNOWFLAKES; i2++) {
            this.m_snowFlakes[i2].translate(GROUND_LEVEL, GROUND_LEVEL, -0.1f);
            this.m_snowFlakes[i2].getTranslation(fArr);
            if (fArr[2] < GROUND_LEVEL) {
                this.m_snowFlakes[i2].translate(GROUND_LEVEL, GROUND_LEVEL, 3.0f);
            }
        }
    }
}
