package com.m3gworks.microcs; 
public abstract class InputManager {
   private static InputManager instance;

   public static InputManager getInstance() {
      if (instance == null) {
         try {
            instance = (InputManager) GameConfig.getInstance().sub_2cf().newInstance();
         } catch (InstantiationException var1) {
            var1.printStackTrace();
         } catch (IllegalAccessException var2) {
            var2.printStackTrace();
         }
      }

      return instance;
   }

   public abstract void keyPressed(int var1, GameCanvas3D var2);

   public abstract void keyReleased(int var1, GameCanvas3D var2);
}
