package com.m3gworks.microcs; 
import java.util.Vector;

public final class WeaponShop {
   public static Vector allWeapons = new Vector();
   public static int defaultPrimaryWeaponId = -1;
   public static int defaultSecondaryWeaponId = -1;
   public static int defaultEquipmentId = -1;
   public static int defaultRifleId = -1;
   public static int defaultPistolId = -1;
   public int[] equippedWeaponIds = new int[]{-1, -1, -1, -1};
   public int[] ammoCounts = new int[4];
   public int currentWeaponSlot;
   public int armorLevel = 0;

   static {
      GameConfig.getInstance().initializeAllWeapons();
   }

   public static void registerWeapon(WeaponParameters var0) {
      allWeapons.addElement(var0);
      var0.id = allWeapons.indexOf(var0);
      if (defaultPrimaryWeaponId == -1 && var0.weaponType / 10 == 1) {
         defaultPrimaryWeaponId = var0.id;
      } else if (defaultSecondaryWeaponId == -1 && var0.weaponType / 10 == 2) {
         defaultSecondaryWeaponId = var0.id;
      } else if (defaultEquipmentId == -1 && var0.weaponType / 10 == 3) {
         defaultEquipmentId = var0.id;
      } else if (defaultRifleId == -1 && var0.weaponType == 50) {
         defaultRifleId = var0.id;
      } else {
         if (defaultPistolId == -1 && var0.weaponType == 51) {
            defaultPistolId = var0.id;
         }

      }
   }

   public final void initializeInventory() {
      if (GameConfig.getInstance().isBloodEnabled()) {
         this.equippedWeaponIds[0] = GameCanvas.getInstance().terroristPrimaryWeapon;
         this.ammoCounts[0] = ((WeaponParameters) allWeapons.elementAt(this.equippedWeaponIds[0])).clipCapacity * 3;
         this.equippedWeaponIds[1] = GameCanvas.getInstance().terroristSecondaryWeapon;
         this.ammoCounts[1] = ((WeaponParameters) allWeapons.elementAt(this.equippedWeaponIds[1])).clipCapacity * 5;
         this.equippedWeaponIds[2] = defaultEquipmentId;
         this.equippedWeaponIds[3] = GameCanvas.getInstance().terroristSpecialWeapon;
         this.ammoCounts[3] = ((WeaponParameters) allWeapons.elementAt(this.equippedWeaponIds[3])).clipCapacity * 5;
         this.switchToWeaponSlot(1);
      } else {
         this.equippedWeaponIds[0] = -1;
         this.ammoCounts[0] = 0;
         this.equippedWeaponIds[1] = defaultSecondaryWeaponId;
         this.ammoCounts[1] = ((WeaponParameters) allWeapons.elementAt(this.equippedWeaponIds[1])).initialAmmo;
         this.equippedWeaponIds[2] = defaultEquipmentId;
         this.equippedWeaponIds[3] = -1;
         this.ammoCounts[3] = 0;
         this.switchToWeaponSlot(2);
      }

      this.armorLevel = 0;
   }

   public final void useAmmo() {
      int var10002 = this.ammoCounts[this.currentWeaponSlot - 1]--;
   }

   public final boolean switchToWeaponSlot(int var1) {
      if (this.equippedWeaponIds[var1 - 1] != -1) {
         this.currentWeaponSlot = var1;
         return true;
      } else {
         return false;
      }
   }

   public final int getCurrentAmmo() {
      return this.ammoCounts[this.currentWeaponSlot - 1];
   }

   public final WeaponParameters getCurrentWeapon() {
      return (WeaponParameters) allWeapons.elementAt(this.equippedWeaponIds[this.currentWeaponSlot - 1]);
   }

   public final void equipWeapon(WeaponParameters var1) {
      int var2;
      if ((var2 = var1.weaponType / 10) != 1 && var2 != 2 && var2 != 4) {
         if (var2 == 5) {
            byte var3 = 0;
            if (var1.weaponType == 51) {
               var3 = 1;
            }

            int[] var10000 = this.ammoCounts;
            var10000[var3] += ((WeaponParameters) allWeapons.elementAt(this.equippedWeaponIds[var3])).clipCapacity;
         } else {
            if (var2 == 6 && var1.weaponType == 60) {
               this.armorLevel = 100;
            }

         }
      } else {
         this.equippedWeaponIds[var2 - 1] = var1.id;
         this.ammoCounts[var2 - 1] = var1.initialAmmo;
         this.switchToWeaponSlot(var2);
      }
   }

   public final void unequipWeapon(int var1) {
      this.equippedWeaponIds[var1 - 1] = -1;
      this.ammoCounts[var1 - 1] = 0;
   }

   public final void cleanup() {
      this.equippedWeaponIds = null;
      this.ammoCounts = null;
   }

   public static void staticCleanup() {
      allWeapons = null;
   }
}
