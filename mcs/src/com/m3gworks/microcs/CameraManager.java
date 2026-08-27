package com.m3gworks.microcs; 
import java.util.Enumeration;
import java.util.Hashtable;
import javax.microedition.m3g.Camera;

public final class CameraManager {
   private static CameraManager instance;
   private Hashtable cameraTable = null;
   public Camera activeCamera;

   private CameraManager() {
   }

   public static CameraManager getInstance() {
      if (instance == null) {
         instance = new CameraManager();
      }

      return instance;
   }

   public final void initialize() {
      this.cameraTable = new Hashtable();
      GameConfig.getInstance().sub_52b();
   }

   public final void cleanup() {
      Enumeration var1 = this.cameraTable.keys();

      while(var1.hasMoreElements()) {
         String var2 = (String)var1.nextElement();
         this.cameraTable.get(var2);
      }

      this.cameraTable = null;
   }

   public final void registerCamera(String var1, Camera var2) {
      this.cameraTable.put(var1, var2);
   }

   public final Camera getCamera(String var1) {
      Object var2;
      return (var2 = this.cameraTable.get(var1)) == null ? null : (Camera)var2;
   }

   public final void setupActiveCamera(Camera var1, GameCanvas3D var2) {
      this.activeCamera = var1;
      float var3 = (float)var2.getWidth() / (float)var2.getHeight();
      float var4 = 60.0F / var3;
      var1.setPerspective(var4, var3, 0.1F, 1000.0F);
      MapLoader.getInstance().currentWorld.setActiveCamera(var1);
   }
}
