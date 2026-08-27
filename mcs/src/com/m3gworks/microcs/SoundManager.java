package com.m3gworks.microcs; 
import javax.microedition.media.Player;
import javax.microedition.media.PlayerListener;

public final class SoundManager implements PlayerListener {
   private static SoundManager instance;
   private Player[] var_b4;
   private Player[] var_10c;
   private Player[] var_124;
   private Player[] var_16f;
   private Player[] var_1cd;
   private int var_20f;
   private int var_253;
   private int var_26b;
   private int var_2af;
   private int var_2f0;

   private SoundManager() {
   }

   public static SoundManager getInstance() {
      if (instance == null) {
         instance = new SoundManager();
      }

      return instance;
   }

   public final void sub_5e(int var1) {
      switch(var1) {
      case 1:
         sub_a1(this.var_b4[this.var_20f]);
         this.var_20f = (this.var_20f + 1) % 4;
         return;
      case 2:
         sub_a1(this.var_10c[this.var_253]);
         this.var_253 = (this.var_253 + 1) % 2;
         return;
      case 3:
         sub_a1(this.var_124[this.var_26b]);
         this.var_26b = (this.var_26b + 1) % 2;
         return;
      case 4:
         sub_a1(this.var_16f[this.var_2af]);
         this.var_2af = (this.var_2af + 1) % 1;
         return;
      case 21:
         sub_a1(this.var_1cd[this.var_2f0]);
         this.var_2f0 = (this.var_2f0 + 1) % 4;
      default:
      }
   }

   private static void sub_a1(Player var0) {
      if (var0 != null && var0.getState() == 300) {
         try {
            var0.setMediaTime(0L);
            var0.start();
            return;
         } catch (Exception var1) {
            System.out.println("Could not play sound ");
         }
      }

   }

   public final void playerUpdate(Player var1, String var2, Object var3) {
      if (var2 == "endOfMedia") {
         try {
            var1.stop();
            var1.setMediaTime(0L);
            return;
         } catch (Exception var4) {
         }
      }

   }

   private void sub_e1() {
      int var1;
      if (this.var_b4 != null) {
         for(var1 = 0; var1 < 4; ++var1) {
            this.var_b4[var1].close();
         }
      }

      if (this.var_10c != null) {
         for(var1 = 0; var1 < 2; ++var1) {
            this.var_10c[var1].close();
         }
      }

      if (this.var_124 != null) {
         for(var1 = 0; var1 < 2; ++var1) {
            this.var_124[var1].close();
         }
      }

      if (this.var_16f != null) {
         for(var1 = 0; var1 < 1; ++var1) {
            this.var_16f[0].close();
         }
      }

      if (this.var_1cd != null) {
         for(var1 = 0; var1 < 4; ++var1) {
            this.var_1cd[var1].close();
         }
      }

   }

   public final void sub_102() {
      this.sub_e1();
      this.var_b4 = null;
      this.var_10c = null;
      this.var_124 = null;
      this.var_16f = null;
      this.var_1cd = null;
   }
}
