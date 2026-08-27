package com.m3gworks.microcs; 
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.game.GameCanvas;
import javax.microedition.m3g.Camera;
import javax.microedition.m3g.Graphics3D;
import javax.microedition.m3g.Transform;

public class GameCanvas3D extends GameCanvas {
   private static GameCanvas3D instance;
   private Graphics3D graphics3D = Graphics3D.getInstance();
   private Graphics graphics = this.getGraphics();
   public boolean isSniperMode;

   public GameCanvas3D() {
      super(false);
      this.initializeScreen();
   }

   public final void initializeScreen() {
      if (GameConfig.getInstance().isFullScreenEnabled()) {
         this.setFullScreenMode(true);
      }

      MapLoader.getInstance().setupBackground(this.getWidth(), this.getHeight());
      CameraManager.getInstance().setupActiveCamera(CameraManager.getInstance().getCamera("MAIN"), this);
      this.setZoom(false);
   }

   public static GameCanvas3D createInstance() {
      instance = null;

      try {
         instance = (GameCanvas3D) GameConfig.getInstance().sub_106().newInstance();
      } catch (InstantiationException var1) {
         var1.printStackTrace();
      } catch (IllegalAccessException var2) {
         var2.printStackTrace();
      }

      return instance;
   }

   public static GameCanvas3D getInstance() {
      return instance;
   }

   public final void renderFrame() {
      try {
         this.render3DScene();
         this.render2DOverlay();
         this.flushGraphics();
      } catch (Exception var2) {
         System.out.println(var2);
         var2.printStackTrace();
      }
   }

   private void render3DScene() {
      try {
         InputHandler.sub_5f().sub_bb();
         EnemyAI.getInstance().updateAllBots();
         GameEntityManager.getInstance().updateAllEntities();
         this.updateGameEffects();
         this.graphics3D.bindTarget(this.graphics, true, 6);
         this.graphics3D.render(MapLoader.getInstance().currentWorld);
      } catch (Exception var5) {
         var5.printStackTrace();
      } finally {
         this.graphics3D.releaseTarget();
         this.graphics3D.setCamera((Camera)null, (Transform)null);
         this.graphics3D.resetLights();
      }

   }

   public final void render2DOverlay() {
      HUDManager.getInstance().renderHUD(this.graphics, this);
      MenuSystem.getInstance().renderMenu(this.graphics, this);
   }

   public void updateGameEffects() {
   }

   public final void setZoom(boolean var1) {
      this.isSniperMode = var1;
      float var2 = (float)this.getWidth() / (float)this.getHeight();
      Camera var3 = CameraManager.getInstance().activeCamera;
      float var4 = 60.0F / var2;
      if (var1) {
         var4 /= 2.0F;
      }

      var3.setPerspective(var4, var2, 0.1F, 300.0F);
   }

   public void keyPressed(int var1) {
      InputManager.getInstance().keyPressed(var1, this);
   }

   public void keyReleased(int var1) {
      InputManager.getInstance().keyReleased(var1, this);
   }

   public static void cleanup() {
      instance.graphics = null;
      instance.graphics3D = null;
      instance = null;
   }

   public void sizeChanged(int var1, int var2) {
      this.graphics = this.getGraphics();
   }
}
