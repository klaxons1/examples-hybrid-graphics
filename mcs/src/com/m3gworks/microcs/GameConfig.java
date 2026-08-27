package com.m3gworks.microcs; 
public abstract class GameConfig {
   private static GameConfig instance;
   public int lowRes = 0;
   public static Class configClass;

   public static GameConfig getInstance() {
      if (instance == null) {
         try {
            Class var0 = null;

            try {
               Class var10000 = configClass;
               if (var10000 == null) {
                  try {
                     var10000 = Class.forName("com.m3gworks.microcs.CounterTerroristGameConfig");
                  } catch (ClassNotFoundException var2) {
                     throw new NoClassDefFoundError(var2.getMessage());
                  }

                  configClass = var10000;
               }

               var0 = var10000;
            } catch (Exception var3) {
               var3.printStackTrace();
            }

            instance = (GameConfig)var0.newInstance();
         } catch (InstantiationException var4) {
            var4.printStackTrace();
         } catch (IllegalAccessException var5) {
            var5.printStackTrace();
         }
      }

      return instance;
   }

   public abstract boolean isMultiplayer();

   public abstract boolean hasSound();

   public abstract boolean sub_a5();

   public abstract Class sub_106();

   public abstract Class sub_14f();

   public abstract Class sub_199();

   public abstract Class sub_1fb();

   public abstract Class sub_23a();

   public abstract Class sub_274();

   public abstract Class sub_2b8();

   public abstract Class sub_2cf();

   public abstract int sub_3bd();

   public abstract int sub_3d3();

   public abstract boolean isBloodEnabled();

   public abstract boolean isFullScreenEnabled();

   public abstract void sub_40a();

   public abstract void sub_45a();

   public abstract void sub_490();

   public abstract void sub_49f();

   public abstract void sub_4a9();

   public abstract void sub_4dd();

   public abstract void initializeAllMaps();

   public abstract void initializeAllWeapons();

   public abstract void sub_52b();
}
