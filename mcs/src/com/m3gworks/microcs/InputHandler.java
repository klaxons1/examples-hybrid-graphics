package com.m3gworks.microcs; 
public abstract class InputHandler {
   private static InputHandler var_5b;
   public boolean[] var_7e;

   public static InputHandler sub_5f() {
      if (var_5b == null) {
         try {
            var_5b = (InputHandler) GameConfig.getInstance().sub_274().newInstance();
         } catch (InstantiationException var1) {
            var1.printStackTrace();
         } catch (IllegalAccessException var2) {
            var2.printStackTrace();
         }
      }

      return var_5b;
   }

   public abstract void sub_bb();

   public void handlePlayerAction(int var1, boolean var2) {
      if (var1 != -1) {
         this.var_7e[var1] = var2;
      } else {
         for(int var3 = 0; var3 < this.var_7e.length; ++var3) {
            this.var_7e[var3] = var2;
         }

      }
   }
}
