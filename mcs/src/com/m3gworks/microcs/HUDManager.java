package com.m3gworks.microcs; 
import javax.microedition.lcdui.Graphics;

public abstract class HUDManager {
   private static HUDManager instance;

   public static HUDManager getInstance() {
      if (instance == null) {
         try {
            instance = (HUDManager) GameConfig.getInstance().sub_1fb().newInstance();
         } catch (InstantiationException var1) {
            var1.printStackTrace();
         } catch (IllegalAccessException var2) {
            var2.printStackTrace();
         }
      }

      return instance;
   }

   public abstract void renderHUD(Graphics var1, GameCanvas3D var2);

   public abstract void showMessage(int var1, String var2);

   public abstract void clearCustomText();

   public static void loadHUDResources() {
      GameConfig.getInstance().sub_45a();
   }

   public static void cleanupHUDResources() {
      GameConfig.getInstance().sub_4a9();
   }
}
