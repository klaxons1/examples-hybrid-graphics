package fi.hybrid.m3g.examples;

import java.io.IOException;
import javax.microedition.m3g.Appearance;
import javax.microedition.m3g.Graphics3D;
import javax.microedition.m3g.Loader;
import javax.microedition.m3g.Material;
import javax.microedition.m3g.Mesh;
import javax.microedition.m3g.Object3D;
import javax.microedition.m3g.TriangleStripArray;
import javax.microedition.m3g.VertexArray;
import javax.microedition.m3g.VertexBuffer;

public abstract class ExampleBase {
   public static final int SHOW_RENDER_TIME = 1;
   public static final int DOUBLE_BUFFERING = 2;
   public static final int USES_CURSOR = 4;
   public static final int USES_MAX_FRAMES = 8;
   public static final int KEY_1 = 0;
   public static final int KEY_2 = 1;
   public static final int KEY_3 = 2;
   public static final int KEY_4 = 3;
   public static final int KEY_5 = 4;
   public static final int KEY_6 = 5;
   public static final int KEY_7 = 6;
   public static final int KEY_8 = 7;
   public static final int KEY_9 = 8;
   public static final int KEY_0 = 9;
   public static final int KEY_UP = 10;
   public static final int KEY_RIGHT = 11;
   public static final int KEY_DOWN = 12;
   public static final int KEY_LEFT = 13;
   public static final int KEY_EXIT = 14;
   public static final int KEY_FPS_TOGGLE = 15;
   private static long sSeed = 5555555L;
   private int iFeatures;
   private int iCounter;
   private int iStartTime;
   private int iMaxFrames;
   private boolean bStop;
   private float iMouseX;
   private float iMouseY;
   protected int width;
   protected int height;
   protected PlatformServices platformServices;
   protected String exampleDescription = null;

   public ExampleBase(int var1) {
      this.iFeatures = var1;
      this.iCounter = 0;
      this.iMaxFrames = 0;
      this.bStop = false;
      this.iStartTime = 0;
      this.iMouseX = 0.0F;
      this.iMouseY = 0.0F;
      Graphics3D.getInstance().resetLights();
   }

   public String getDescription() {
      return this.exampleDescription == null ? this.toString() : this.exampleDescription;
   }

   public float getMouseX() {
      return this.iMouseX;
   }

   public float getMouseY() {
      return this.iMouseY;
   }

   public void setMousePos(float var1, float var2) {
      this.iMouseX = var1;
      this.iMouseY = var2;
   }

   public void setStartTime(int var1) {
      this.iStartTime = var1;
   }

   public int getStartTime() {
      return this.iStartTime;
   }

   public void setMaxFrames(int var1) {
      this.iMaxFrames = var1;
      this.setFeatures(8);
   }

   public int getMaxFrames() {
      return this.iMaxFrames;
   }

   public int getCount() {
      return this.iCounter;
   }

   public void keyPressed(int var1) {
      if (var1 == 15) {
         this.iFeatures ^= 1;
      }

   }

   public void keyReleased(int var1) {
   }

   protected abstract void initialize();

   public void render(Object var1, int var2, int var3) {
      this.width = var2;
      this.height = var3;
      this.render(var1);
   }

   protected void render(Object var1) {
      Graphics3D.getInstance().bindTarget(var1);
      int var2 = (int)System.currentTimeMillis() - this.iStartTime;
      this.render(var2);
      Graphics3D.getInstance().releaseTarget();
      this.render2D(var2, var1);
      ++this.iCounter;
      if ((this.iFeatures & 8) != 0 && this.iCounter >= this.iMaxFrames) {
         this.bStop = true;
      }

   }

   protected void render2D(int var1, Object var2) {
   }

   protected void render(int var1) {
   }

   public int getFeatures() {
      return this.iFeatures;
   }

   public void setFeatures(int var1) {
      this.iFeatures |= var1;
   }

   public boolean getStop() {
      return this.bStop;
   }

   public static Mesh createBox() {
      byte[] var0 = new byte[]{10, 10, 10, -10, 10, 10, 10, -10, 10, -10, -10, 10, -10, 10, -10, 10, 10, -10, -10, -10, -10, 10, -10, -10, -10, 10, 10, -10, 10, -10, -10, -10, 10, -10, -10, -10, 10, 10, -10, 10, 10, 10, 10, -10, -10, 10, -10, 10, 10, 10, -10, -10, 10, -10, 10, 10, 10, -10, 10, 10, 10, -10, 10, -10, -10, 10, 10, -10, -10, -10, -10, -10};
      VertexArray var1 = new VertexArray(var0.length / 3, 3, 1);
      var1.set(0, var0.length / 3, var0);
      byte[] var2 = new byte[]{0, 0, 127, 0, 0, 127, 0, 0, 127, 0, 0, 127, 0, 0, -127, 0, 0, -127, 0, 0, -127, 0, 0, -127, -127, 0, 0, -127, 0, 0, -127, 0, 0, -127, 0, 0, 127, 0, 0, 127, 0, 0, 127, 0, 0, 127, 0, 0, 0, 127, 0, 0, 127, 0, 0, 127, 0, 0, 127, 0, 0, -127, 0, 0, -127, 0, 0, -127, 0, 0, -127, 0};
      VertexArray var3 = new VertexArray(var2.length / 3, 3, 1);
      var3.set(0, var2.length / 3, var2);
      int[] var4 = new int[]{4, 4, 4, 4, 4, 4};
      VertexBuffer var5 = new VertexBuffer();
      var5.setPositions(var1, 1.0F, (float[])null);
      var5.setNormals(var3);
      TriangleStripArray var6 = new TriangleStripArray(0, var4);
      Appearance var7 = new Appearance();
      var7.setMaterial(new Material());
      return new Mesh(var5, var6, var7);
   }

   public Object3D[] load(String var1) {
      try {
         Object3D[] var2 = Loader.load(this.platformServices.getResourceDir() + var1 + ".m3g");
         return var2;
      } catch (IOException var4) {
         System.out.println("Load failed (" + var4.getMessage() + ")");
         var4.printStackTrace();
         return null;
      }
   }

   public Object3D[] loadGeneric(String var1) {
      try {
         Object3D[] var2 = Loader.load(this.platformServices.getResourceDir() + var1);
         return var2;
      } catch (IOException var4) {
         System.out.println("Load failed (" + var4.getMessage() + ")");
         var4.printStackTrace();
         return null;
      }
   }

   static double random() {
      sSeed = (16807L * sSeed + 3L) % 268435455L;
      return (double)sSeed / 2.68435455E8;
   }

   public void setPlatformServices(PlatformServices var1) {
      this.platformServices = var1;
   }
}
