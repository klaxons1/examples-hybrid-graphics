package com.m3gworks.microcs; 
import java.util.Enumeration;
import java.util.Hashtable;
import javax.microedition.lcdui.Font;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public class BuyMenu extends MenuSystem {
   private static final String[] menuStrings = new String[]{"Return", "Purchase", "Player list", "Quit"};
   private int selectedMenuItem = 0;
   private int selectedWeaponIndex = 0;
   private static Image backgroundImage = null;
   private static Image weaponsSpriteSheet = null;
   private static Image forbiddenIcon = null;
   private int selectedCategory = 0;
   private static final int[] categoryOffsets = new int[]{0, 4, 7};
   private static final String[] categoryNames = new String[]{"primary", "secondary", "equipment"};
   private static final String[] categoryNamesShort = new String[]{"prima..", "secon..", "equip.."};
   private static final String[] parametersName = new String[]{"price:$", "clip capability:", "weight:"};
   private static final String[] parametersNameShort = new String[]{"price:$", "clip c...:", "weight:"};
   private boolean soundEnabled = true;
   private int soundOptionIndex = 0;

   public static void loadResources() {
      try {
         backgroundImage = Image.createImage("/res/image2d/bg_mask.png");
         if (GameConfig.getInstance().lowRes == 0) {
            weaponsSpriteSheet = Image.createImage("/res/image2d/weapons.png");
         } else {
            weaponsSpriteSheet = Image.createImage("/res/image2d/weapons_s.png");
         }

         forbiddenIcon = Image.createImage("/res/image2d/forbidden.png");
      } catch (Exception var1) {
         System.out.println("Failed to load 2D images");
      }
   }

   public final void renderMenu(Graphics var1, GameCanvas3D var2) {
      if (super.isMenuVisible) {
         switch(super.currentMenuState) {
         case 0:
            this.renderMainMenu(var1, var2);
            return;
         case 1:
            this.renderWeaponShop(var1, var2);
            return;
         case 3:
            this.renderPlayerList(var1, var2);
            return;
         case 4:
            this.renderOptions(var1, var2);
         case 2:
         default:
         }
      }
   }

   private static void drawBackground(Graphics var0, int var1, int var2) {
      int var3 = var2 / backgroundImage.getHeight();
      if (var2 % backgroundImage.getHeight() != 0) {
         ++var3;
      }

      for(int var4 = 0; var4 < var3; ++var4) {
         var0.drawRegion(backgroundImage, 0, 0, var1, backgroundImage.getHeight(), 0, 0, var4 * backgroundImage.getHeight(), 20);
      }

   }

   private void renderMainMenu(Graphics var1, GameCanvas3D var2) {
      int var3 = var2.getWidth();
      int var4 = var2.getHeight();
      drawBackground(var1, var3, var4);

      for(int var5 = 0; var5 < menuStrings.length; ++var5) {
         String var6 = menuStrings[var5].toLowerCase();
         int var7 = 15;
         int[] var8 = new int[4];

         for(int var9 = 0; var9 < var6.length(); ++var9) {
            MainMenu.getCharRegion(var6.charAt(var9), var8);
            if (var8[0] != -1) {
               var1.drawRegion(MainMenu.normalTextFont, var8[0], var8[1], var8[2], var8[3], 0, var7, 15 + var5 * 14, 20);
               var7 += var8[2];
            } else {
               var7 += 6;
            }
         }

         if (var5 == this.selectedMenuItem) {
            var1.drawImage(MainMenu.arrowIcon, 6, 15 + var5 * 14 + 3, 6);
         }
      }

   }

   private void renderWeaponShop(Graphics var1, GameCanvas3D var2) {
      int var3 = var2.getWidth();
      int var4 = var2.getHeight();
      int var5 = GameConfig.getInstance().lowRes;
      drawBackground(var1, var3, var4);
      byte var6 = 22;
      if (var5 == 1) {
         var6 = 6;
      }

      var1.setColor(16685312);
      var1.fillRect(0, var6, var3, 16);
      int var8 = var3 / categoryOffsets.length;
      int var9 = this.selectedCategory * var8;
      var1.setColor(0);
      var1.fillRect(var9, var6 + 1, var8, 14);
      String[] var10 = categoryNames;
      if (var5 == 1) {
         var10 = categoryNamesShort;
      }

      int var11;
      for(var11 = 0; var11 < var10.length; ++var11) {
         String var12 = var10[var11].toLowerCase();
         int var13 = var8 * var11 + (var8 - var12.length() * 6) / 2;
         int[] var14 = new int[4];

         for(int var15 = 0; var15 < var12.length(); ++var15) {
            MainMenu.getCharRegion(var12.charAt(var15), var14);
            if (var14[0] != -1) {
               var1.drawRegion(MainMenu.normalTextFont, var14[0], var14[1], var14[2], var14[3], 0, var13, var6 + 8, 6);
               var13 += var14[2];
            } else {
               var13 += 6;
            }
         }
      }

      var11 = var6 + 16 + 8;
      int var28 = var4 - var11 - var6;
      boolean var29 = false;
      ChooseTeam var30;
      WeaponShop var16 = (var30 = (ChooseTeam) GameEntityManager.getInstance().localPlayer).getWeaponShop();
      int var17 = categoryOffsets[this.selectedCategory];
      boolean var18 = false;
      int var31;
      if (this.selectedCategory == categoryOffsets.length - 1) {
         var31 = WeaponShop.allWeapons.size() - var17;
      } else {
         var31 = categoryOffsets[this.selectedCategory + 1] - var17;
      }

      if (this.selectedWeaponIndex < var17 || this.selectedWeaponIndex >= var17 + var31) {
         this.selectedWeaponIndex = var17;
      }

      for(int var19 = var17; var19 < var17 + var31; ++var19) {
         WeaponParameters var20 = (WeaponParameters) WeaponShop.allWeapons.elementAt(var19);
         var1.setColor(16685312);
         var1.fillRect(0, var11 + (var19 - var17) * 15, 48, 14);
         var1.setColor(0);
         if (var19 == this.selectedWeaponIndex) {
            var1.fillRect(0, var11 + (var19 - var17) * 15 + 1, 47, 12);
         }

         String var21 = var20.name.toLowerCase();
         int var22 = 3;
         int[] var23 = new int[4];

         for(int var24 = 0; var24 < var21.length(); ++var24) {
            MainMenu.getCharRegion(var21.charAt(var24), var23);
            if (var23[0] != -1) {
               var1.drawRegion(MainMenu.normalTextFont, var23[0], var23[1], var23[2], var23[3], 0, var22, var11 + (var19 - var17) * 15 + 7, 6);
               var22 += var23[2];
            } else {
               var22 += 6;
            }
         }
      }

      var1.setColor(16685312);
      var1.fillRect(0, var11 + var31 * 15, 48, var28 - var31 * 15);
      WeaponParameters var32 = (WeaponParameters) WeaponShop.allWeapons.elementAt(this.selectedWeaponIndex);
      int var33 = var28 / 2;
      var1.setColor(16685312);
      var1.drawRect(50, var11, var3 - 48, var33);
      var1.drawRegion(weaponsSpriteSheet, var32.spriteData[var5][0], var32.spriteData[var5][1], var32.spriteData[var5][2], var32.spriteData[var5][3], 0, var3 - (var3 - 48 - 2) / 2, var11 + var33 / 2, 3);
      var1.setColor(16685312);
      var1.drawRect(50, var11 + var33 + 3, var3 - 48, var28 - var33 - 4);
      StringBuffer var34 = new StringBuffer();
      if (var5 == 1) {
         var34.append(parametersNameShort[0]);
      } else {
         var34.append(parametersName[0]);
      }

      var34.append(var32.price);
      String var35 = var34.toString();
      int var36 = 56;
      int[] var37 = new int[4];

      int var25;
      for(var25 = 0; var25 < var35.length(); ++var25) {
         MainMenu.getCharRegion(var35.charAt(var25), var37);
         if (var37[0] != -1) {
            var1.drawRegion(MainMenu.normalTextFont, var37[0], var37[1], var37[2], var37[3], 0, var36, var11 + var33 + 8, 20);
            var36 += var37[2];
         } else {
            var36 += 6;
         }
      }

      if ((var25 = var32.weaponType / 10) == 1 || var25 == 2) {
         var34 = new StringBuffer();
         if (var5 == 1) {
            var34.append(parametersNameShort[1]);
         } else {
            var34.append(parametersName[1]);
         }

         var34.append(var32.clipCapacity);
         var35 = var34.toString();
         var36 = 56;
         var37 = new int[4];

         int var26;
         for(var26 = 0; var26 < var35.length(); ++var26) {
            MainMenu.getCharRegion(var35.charAt(var26), var37);
            if (var37[0] != -1) {
               var1.drawRegion(MainMenu.normalTextFont, var37[0], var37[1], var37[2], var37[3], 0, var36, var11 + var33 + 8 + 11, 20);
               var36 += var37[2];
            } else {
               var36 += 6;
            }
         }

         var34 = new StringBuffer();
         if (var5 == 1) {
            var34.append(parametersNameShort[2]);
         } else {
            var34.append(parametersName[2]);
         }

         var34.append(var32.weight.toLowerCase());
         var35 = var34.toString();
         var36 = 56;
         var37 = new int[4];

         for(var26 = 0; var26 < var35.length(); ++var26) {
            MainMenu.getCharRegion(var35.charAt(var26), var37);
            if (var37[0] != -1) {
               var1.drawRegion(MainMenu.normalTextFont, var37[0], var37[1], var37[2], var37[3], 0, var36, var11 + var33 + 8 + 22, 20);
               var36 += var37[2];
            } else {
               var36 += 6;
            }
         }
      }

      boolean var38 = false;
      if (var32.price > ((LocalPlayer)var30).money) {
         var38 = true;
      } else if (var32.weaponType == 50) {
         if (var16.equippedWeaponIds[0] == -1) {
            var38 = true;
         }
      } else if (var32.weaponType == 51 && var16.equippedWeaponIds[1] == -1) {
         var38 = true;
      }

      if (var38) {
         var1.drawImage(forbiddenIcon, var3 - (var3 - 48 - 2) / 2, var11 + var33 / 2, 3);
      }

   }

   private void renderPlayerList(Graphics var1, GameCanvas3D var2) {
      int var3 = var2.getWidth();
      int var4 = var2.getHeight();
      drawBackground(var1, var3, var4);
      Font var5 = Font.getFont(0, 0, 8);
      var1.setFont(var5);
      var1.setColor(16777150);
      var1.drawString("Part  Name", 10, 20, 36);
      var1.drawString("Life", var3 - 10, 22, 40);
      var1.setColor(5395026);
      var1.drawLine(10, 21, var3 - 10, 21);
      var1.setColor(15790320);
      Hashtable var6;
      Enumeration var7 = (var6 = GameEntityManager.getInstance().entityTable).keys();
      int var8 = 0;

      while(var7.hasMoreElements()) {
         Integer var9 = (Integer)var7.nextElement();
         GameEntity var10;
         if ((var10 = (GameEntity)var6.get(var9)).entityType != 1) {
            if (((ChooseTeam)var10).getTeamId() == 1) {
               var1.drawString("T", 10, 23 + var8 * 20, 20);
            } else {
               var1.drawString("CT", 10, 23 + var8 * 20, 20);
            }

            var1.drawString(var10.entityName, 35, 23 + var8 * 20, 20);
            StringBuffer var12;
            (var12 = new StringBuffer()).append(((ChooseTeam)var10).getHealth());
            var1.drawString(var12.toString(), var3 - 10, 23 + var8 * 20, 24);
            ++var8;
         }
      }

   }

   private void renderOptions(Graphics var1, GameCanvas3D var2) {
      int var3 = var2.getWidth();
      int var4 = var2.getHeight();
      drawBackground(var1, var3, var4);
      var1.setColor(16777215);
      var1.drawString("Sound", 10, 40, 20);
      String var5 = this.soundEnabled ? "On" : "Off";
      var1.drawString(var5, var2.getWidth() - 20, 40, 24);
   }

   public final void handleInput(int var1, int var2) {
      if (super.isMenuVisible) {
         switch(super.currentMenuState) {
         case 0:
            this.handleMainMenuInput(var1, var2);
            return;
         case 1:
            this.handleWeaponShopInput(var1, var2);
            return;
         case 3:
            this.returnToMainMenu();
            return;
         case 4:
            this.handleOptionsInput(var1, var2);
         case 2:
         default:
         }
      }
   }

   private void handleMainMenuInput(int var1, int var2) {
      if (var1 != 50 && var2 != 1) {
         if (var1 != 56 && var2 != 6) {
            if (var1 != 53 && var2 != 8) {
               if (var1 == -11) {
                  super.isMenuVisible = false;
               }
            } else {
               String var3;
               if ((var3 = menuStrings[this.selectedMenuItem]).equals("Return")) {
                  super.isMenuVisible = false;
                  return;
               }

               if (var3.equals("Purchase")) {
                  super.currentMenuState = 1;
                  return;
               }

               if (var3.equals("Player list")) {
                  super.currentMenuState = 3;
                  return;
               }

               if (var3.equals("Options")) {
                  this.soundEnabled = GameCanvas.getInstance().soundEnabled;
                  super.currentMenuState = 4;
                  return;
               }

               if (var3.equals("Quit")) {
                  super.isMenuVisible = false;
                  GameRoundManager.getInstance().gameState = 5;
                  GameCanvas var4;
                  (var4 = GameCanvas.getInstance()).screenState = 0;
                  var4.onSizeChanged();
                  return;
               }
            }

         } else if (this.selectedMenuItem == menuStrings.length - 1) {
            this.selectedMenuItem = 0;
         } else {
            ++this.selectedMenuItem;
         }
      } else if (this.selectedMenuItem == 0) {
         this.selectedMenuItem = menuStrings.length - 1;
      } else {
         --this.selectedMenuItem;
      }
   }

   private void handleWeaponShopInput(int var1, int var2) {
      WeaponShop.allWeapons.size();
      int var4 = categoryOffsets.length;
      int var5 = categoryOffsets[this.selectedCategory];
      boolean var6 = false;
      int var15;
      if (this.selectedCategory == categoryOffsets.length - 1) {
         var15 = WeaponShop.allWeapons.size() - var5;
      } else {
         var15 = categoryOffsets[this.selectedCategory + 1] - var5;
      }

      if (var1 != 52 && var2 != 2) {
         if (var1 != 54 && var2 != 5) {
            if (var1 != 50 && var2 != 1) {
               if (var1 != 56 && var2 != 6) {
                  if (var1 == 53 || var2 == 8) {
                     ChooseTeam var7;
                     WeaponShop var8 = (var7 = (ChooseTeam) GameEntityManager.getInstance().localPlayer).getWeaponShop();
                     WeaponParameters var9;
                     if ((var9 = (WeaponParameters) WeaponShop.allWeapons.elementAt(this.selectedWeaponIndex)).id == var8.equippedWeaponIds[0] || var9.id == var8.equippedWeaponIds[1] || var9.id == var8.equippedWeaponIds[2]) {
                        HUDManager.getInstance().showMessage(5, (String)null);
                        this.hideMenu();
                        return;
                     }

                     if (((LocalPlayer)var7).money >= var9.price) {
                        int var10;
                        int var11;
                        int var12;
                        int var14;
                        if (var9.weaponType == 50) {
                           if (var8.equippedWeaponIds[0] != -1) {
                              var10 = var7.getWeaponShop().getCurrentAmmo();
                              var11 = var7.getWeaponShop().getCurrentWeapon().clipCapacity;
                              var12 = var10 % var11;
                              var14 = var10 / var11;
                              if (var12 != 0) {
                                 ++var14;
                              }

                              if (var14 < 4) {
                                 var8.equipWeapon(var9);
                                 ((LocalPlayer)var7).spendMoney(var9.price);
                                 HUDManager.getInstance().showMessage(6, (String)null);
                              }

                              this.hideMenu();
                              return;
                           }
                        } else if (var9.weaponType == 51) {
                           if (var8.equippedWeaponIds[1] != -1) {
                              var10 = var7.getWeaponShop().getCurrentAmmo();
                              var11 = var7.getWeaponShop().getCurrentWeapon().clipCapacity;
                              var12 = var10 % var11;
                              var14 = var10 / var11;
                              if (var12 != 0) {
                                 ++var14;
                              }

                              if (var14 < 8) {
                                 var8.equipWeapon(var9);
                                 ((LocalPlayer)var7).spendMoney(var9.price);
                                 HUDManager.getInstance().showMessage(6, (String)null);
                              }

                              this.hideMenu();
                              return;
                           }
                        } else {
                           var8.equipWeapon(var9);
                           ((LocalPlayer)var7).spendMoney(var9.price);
                           GameCanvas3D.getInstance().setZoom(false);
                           HUDManager.getInstance().showMessage(6, (String)null);
                           this.hideMenu();
                        }
                     }
                  }

               } else if (this.selectedWeaponIndex == var5 + var15 - 1) {
                  this.selectedWeaponIndex = var5;
               } else {
                  ++this.selectedWeaponIndex;
               }
            } else if (this.selectedWeaponIndex == var5) {
               this.selectedWeaponIndex = var5 + var15 - 1;
            } else {
               --this.selectedWeaponIndex;
            }
         } else if (this.selectedCategory == var4 - 1) {
            this.selectedCategory = 0;
         } else {
            ++this.selectedCategory;
         }
      } else if (this.selectedCategory == 0) {
         this.selectedCategory = var4 - 1;
      } else {
         --this.selectedCategory;
      }
   }

   private void returnToMainMenu() {
      super.currentMenuState = 0;
   }

   private void handleOptionsInput(int var1, int var2) {
      if (var1 != 50 && var2 != 1) {
         if (var1 != 56 && var2 != 6) {
            if (var1 != 52 && var2 != 2) {
               if (var1 != 54 && var2 != 5) {
                  if (var1 != 53 && var2 != 8) {
                     if (var1 == 35) {
                        this.soundEnabled = GameCanvas.getInstance().soundEnabled;
                        super.currentMenuState = 0;
                     }

                  } else {
                     GameCanvas.getInstance().setSoundEnabled(this.soundEnabled);
                     super.currentMenuState = 0;
                  }
               } else {
                  switch(this.soundOptionIndex) {
                  case 0:
                     this.soundEnabled = !this.soundEnabled;
                  default:
                  }
               }
            } else {
               switch(this.soundOptionIndex) {
               case 0:
                  this.soundEnabled = !this.soundEnabled;
               default:
               }
            }
         } else if (this.soundOptionIndex == 0) {
            this.soundOptionIndex = 0;
         } else {
            ++this.soundOptionIndex;
         }
      } else if (this.soundOptionIndex == 0) {
         this.soundOptionIndex = 0;
      } else {
         --this.soundOptionIndex;
      }
   }

   public final void showMenu() {
      this.selectedMenuItem = 0;
      super.showMenu();
   }

   public final void hideMenu() {
      this.selectedMenuItem = 0;
      this.selectedWeaponIndex = 0;
      this.selectedCategory = 0;
      super.hideMenu();
   }

   public static void cleanupResources() {
      backgroundImage = null;
      forbiddenIcon = null;
      weaponsSpriteSheet = null;
   }
}
