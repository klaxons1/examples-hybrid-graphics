package com.m3gworks.microcs; 
import javax.microedition.lcdui.Graphics;

public abstract class MenuSystem {
   private static MenuSystem instance;
   public int currentMenuState;
   public boolean isMenuVisible = false;

   public static void initializeMenuSystem() {
      GameConfig.getInstance().sub_490();
   }

   public static void cleanupMenuSystem() {
      GameConfig.getInstance().sub_4dd();
   }

   public static MenuSystem getInstance() {
      if (instance == null) {
         try {
            instance = (MenuSystem) GameConfig.getInstance().sub_23a().newInstance();
         } catch (InstantiationException var1) {
            var1.printStackTrace();
         } catch (IllegalAccessException var2) {
            var2.printStackTrace();
         }
      }

      return instance;
   }

   public abstract void renderMenu(Graphics var1, GameCanvas3D var2);

   public abstract void handleInput(int var1, int var2);

   public void showMenu() {
      this.isMenuVisible = true;
   }

   public void hideMenu() {
      this.isMenuVisible = false;
   }
}
