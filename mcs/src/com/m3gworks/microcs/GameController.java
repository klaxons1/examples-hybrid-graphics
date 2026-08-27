package com.m3gworks.microcs; 
import javax.microedition.m3g.Background;

public class GameController extends InputHandler {
   private boolean var_4f = false;
   private int var_83 = 0;
   public int var_8e = 0;
   private int var_fa = 1;
   public int var_151 = 0;
   private int var_19d = 1;

   public GameController() {
      super.var_7e = new boolean[9];
   }

   public final void sub_bb() {
      GameEntity var1;
      ChooseTeam var2 = (ChooseTeam)(var1 = GameEntityManager.getInstance().localPlayer);
      float var3 = 0.0F;
      if (!super.var_7e[5] && !super.var_7e[6] && !super.var_7e[7] && !super.var_7e[8]) {
         var1.stateCounter = 0;
      } else {
         ++var1.stateCounter;
      }

      var3 = (var3 = GameEntity.COLLISION_THRESHOLD * (float)var1.stateCounter) >= GameEntity.MAX_MOVE_DISTANCE ? GameEntity.MAX_MOVE_DISTANCE : var3;
      if (super.var_7e[1]) {
         sub_5b((ControllableEntity)var1, 1);
      } else if (super.var_7e[2]) {
         sub_5b((ControllableEntity)var1, 2);
      }

      if (super.var_7e[3]) {
         sub_5b((ControllableEntity)var1, 3);
      } else if (super.var_7e[4]) {
         sub_5b((ControllableEntity)var1, 4);
      }

      if (!super.var_7e[1] && !super.var_7e[2] && !super.var_7e[3] && !super.var_7e[4]) {
         if (this.var_8e != 0) {
            --this.var_8e;
         }
      } else {
         if (this.var_8e == 0) {
            this.var_fa = 1;
         } else if (this.var_8e == 3) {
            this.var_fa = -1;
         }

         this.var_8e += this.var_fa;
      }

      var2.getGranade().updateGrenade(MapLoader.getInstance().currentWorld);
      float var4;
      if (super.var_7e[5]) {
         var1.moveForward(var3);
         var4 = 0.0F;
      } else if (super.var_7e[6]) {
         var1.strafe(var3);
         var4 = 0.0F;
      }

      Background var5;
      int var7;
      if (super.var_7e[7]) {
         var4 = var1.turnRight(var3);
         if ((var5 = MapLoader.getInstance().currentWorld.getBackground()) != null) {
            var7 = (int)(var4 * ((float)var5.getCropWidth() / 60.0F));
            var5.setCrop(var5.getCropX() - var7, var5.getCropY(), var5.getCropWidth(), var5.getCropHeight());
         }
      } else if (super.var_7e[8]) {
         var4 = var1.turnLeft(var3);
         if ((var5 = MapLoader.getInstance().currentWorld.getBackground()) != null) {
            var7 = (int)(var4 * ((float)var5.getCropWidth() / 60.0F));
            var5.setCrop(var5.getCropX() + var7, var5.getCropY(), var5.getCropWidth(), var5.getCropHeight());
         }
      }

      if (super.var_7e[0]) {
         int var8 = var2.getWeaponShop().getCurrentWeapon().weaponType;
         int var9 = var2.getWeaponShop().currentWeaponSlot;
         if (var8 == 10 && !this.var_4f) {
            this.var_4f = true;
            return;
         }

         if (var9 == 2 || var9 == 3 || var9 == 4 || var8 == 11) {
            this.handlePlayerAction(0, false);
         }

         if (var9 == 3) {
            ((HUDRenderer) HUDManager.getInstance()).sub_f0();
            var2.fireWeapon();
            return;
         }

         if (var2.getWeaponShop().getCurrentAmmo() > 0) {
            if (var8 == 10) {
               float var6 = 0.1F * (float)this.var_83;
               switch(Randomizer.random.nextInt(3)) {
               case 0:
                  var1.turnRight(var6);
                  break;
               case 1:
                  var1.turnLeft(var6);
               case 2:
               }

               ++this.var_83;
            }

            if (GameCanvas.getInstance().soundEnabled) {
               if (var8 == 10) {
                  SoundManager.getInstance().sub_5e(1);
               } else if (var8 == 11) {
                  SoundManager.getInstance().sub_5e(2);
               } else if (var8 == 20) {
                  SoundManager.getInstance().sub_5e(3);
               }
            }

            var2.fireWeapon();
            if (var9 != 1 && var9 != 2) {
               if (var9 == 4 && var2.getWeaponShop().ammoCounts[2] <= 0) {
                  var2.getWeaponShop().unequipWeapon(4);
                  var2.getWeaponShop().switchToWeaponSlot(2);
               }
            } else {
               ((HUDRenderer) HUDManager.getInstance()).sub_b0();
               if (var2.getWeaponShop().getCurrentAmmo() == 0) {
                  HUDManager.getInstance().showMessage(4, (String)null);
               }

               if (this.var_151 == 0) {
                  this.var_19d = 1;
               } else if (this.var_151 == 3) {
                  this.var_19d = -1;
               }

               this.var_151 += this.var_19d;
            }

            if (var8 == 10 && !this.var_4f) {
               this.var_4f = false;
               return;
            }
         }
      } else if (this.var_151 != 0) {
         --this.var_151;
      }

   }

   private static void sub_5b(ControllableEntity var0, int var1) {
      float[] var2 = var0.getForwardVector(var1, 1.0F);
      BoundingSphere var3 = var0.getFutureBoundingSphere(var2);
      float[] var4;
      if (var0.findEntityInRadius(var3) == null && ((var4 = var0.sub_19(var2))[0] != 0.0F || var4[1] != 0.0F || var4[2] != 0.0F)) {
         var0.sub_6f(var4);
      }

   }

   public final void handlePlayerAction(int var1, boolean var2) {
      super.handlePlayerAction(var1, var2);
      if (var1 != -1 && var1 == 0 && var2) {
         this.var_4f = true;
         this.var_83 = 0;
      }

   }
}
