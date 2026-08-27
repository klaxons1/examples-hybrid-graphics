package com.m3gworks.microcs;
import com.m3gworks.engine.GameMIDlet;
import java.util.Vector;
import javax.microedition.lcdui.Image;

public class MainMenu extends GameCanvas {
   private static Image titleImage = null;
   private static Image titleImageSmall = null;
   public static Image arrowIcon;
   private int selectedMenuItem = 0;
   private boolean canScrollDown = true;
   private int scrollOffset = 0;
   private static final String[] menuItems = new String[]{"start", "help", "about", "exit"};
   public static Image boldTextFont;
   public static Image normalTextFont;
   private static final String[] helpText = new String[]{"forward:2,up", "backward:8,down", "turn left:4,left", "turn right:6,right", "shoot:5,fire", "buy:0", "buy ammos:3", "change weapon:1", "popup menu:#", "collimator on/off:9"};
   private static final String[] aboutText = new String[]{"micro counter strike", "full version 1.0.0", "", "produced by:", "www.m3gworks.com", "", "contact us:", "m3gworks@hotmail.com", "", "copyright^2007", "m3gworks team", "modded by ae-mods.ru", "2025"};

   public final void onSizeChanged() {
      switch(super.screenState) {
      case 0:
         this.renderMainMenu();
         return;
      case 1:
         this.renderMapSelection();
         return;
      case 2:
         this.renderOptions();
         return;
      case 3:
         this.renderHelp();
         return;
      case 4:
         this.renderAbout();
         return;
      case 9:
         this.renderLoadingScreen();
      case 5:
      case 6:
      case 7:
      case 8:
      default:
      }
   }

   public void keyPressed(int var1) {
      switch(super.screenState) {
      case 0:
         this.handleMainMenuInput(var1);
         return;
      case 1:
         this.handleMapSelectionInput(var1);
         return;
      case 2:
         this.handleOptionsInput(var1);
         return;
      case 3:
         this.handleHelpInput(var1);
         return;
      case 4:
         this.handleAboutInput(var1);
      default:
      }
   }

   private void drawHeader(String var1) {
      super.graphics.setColor(16685312);
      super.graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
      super.graphics.setColor(0);
      int var2 = (int)((float)this.getWidth() * 2.5568182F);
      int var3 = (int)((float)this.getHeight() * 1.8181819F);
      super.graphics.fillArc(this.getWidth() - var2 - 2, -((var3 - this.getHeight()) / 3), var2, var3, 90, -160);
      int var4 = GameConfig.getInstance().lowRes;
      byte var5 = 15;
      byte var6 = 18;
      if (var4 == 1) {
         var5 = 8;
         var6 = 12;
      }

      super.graphics.setColor(0);
      super.graphics.drawLine(0, var5 - 1, this.getWidth(), var5 - 1);

      int var7;
      for(var7 = 0; var7 < var6; ++var7) {
         super.graphics.setColor(255 - var7 * 3, 255 - var7 * 3, 255 - var7 * 3);
         super.graphics.fillRect(0, var5 + var7, this.getWidth(), 1);
      }

      super.graphics.setColor(0);
      super.graphics.drawLine(0, var5 + var6, this.getWidth(), var5 + var6);
      var7 = var5 + (var6 - 8) / 2;
      int var8 = 10;
      int[] var9 = new int[4];

      for(int var10 = 0; var10 < var1.length(); ++var10) {
         getBoldCharRegion(var1.charAt(var10), var9);
         if (var9[0] != -1) {
            super.graphics.drawRegion(boldTextFont, var9[0], var9[1], var9[2], var9[3], 0, var8, var7, 20);
            var8 += var9[2] + 1;
         } else {
            var8 += 8;
         }
      }

   }

   private void drawScrollableText(String[] var1) {
      this.getWidth();
      int var3 = this.getHeight();
      int var4 = GameConfig.getInstance().lowRes;
      this.canScrollDown = false;

      for(int var6 = this.scrollOffset; var6 < var1.length; ++var6) {
         String var7 = var1[var6];
         int var8 = 10;
         byte var9 = 43;
         if (var4 == 1) {
            var9 = 30;
         }

         int var14;
         if ((var14 = var9 + (var6 - this.scrollOffset) * 16) > var3 - 20) {
            this.canScrollDown = true;
            break;
         }

         int[] var10 = new int[4];

         for(int var11 = 0; var11 < var7.length(); ++var11) {
            getCharRegion(var7.charAt(var11), var10);
            if (var10[0] != -1) {
               super.graphics.drawRegion(normalTextFont, var10[0], var10[1], var10[2], var10[3], 0, var8, var14, 20);
               var8 += var10[2];
            } else {
               var8 += 6;
            }
         }
      }

      if (this.scrollOffset != 0) {
         byte var13 = 38;
         if (var4 == 1) {
            var13 = 25;
         }

         super.graphics.drawRegion(arrowIcon, 0, 0, arrowIcon.getWidth(), arrowIcon.getHeight(), 6, 10, var13, 17);
      }

      if (this.canScrollDown) {
         super.graphics.drawRegion(arrowIcon, 0, 0, arrowIcon.getWidth(), arrowIcon.getHeight(), 5, 10, var3 - 10, 17);
      }

   }

   private void renderMainMenu() {
      this.drawHeader("menu");
      Image var1 = null;
      if (GameConfig.getInstance().lowRes == 1) {
         var1 = titleImageSmall;
         titleImage = null;
      } else {
         var1 = titleImage;
         titleImageSmall = null;
      }

      super.graphics.drawImage(var1, this.getWidth() / 2, this.getHeight() - 5, 33);

      for(int var2 = 0; var2 < menuItems.length; ++var2) {
         String var3 = menuItems[var2].toLowerCase();
         int var4 = 10;
         byte var5 = 43;
         if (GameConfig.getInstance().lowRes == 1) {
            var5 = 30;
         }

         int var10 = var5 + var2 * 14;
         int[] var7 = new int[4];

         for(int var8 = 0; var8 < var3.length(); ++var8) {
            getCharRegion(var3.charAt(var8), var7);
            if (var7[0] != -1) {
               super.graphics.drawRegion(normalTextFont, var7[0], var7[1], var7[2], var7[3], 0, var4, var10, 20);
               var4 += var7[2];
            } else {
               var4 += 6;
            }
         }

         if (var2 == this.selectedMenuItem) {
            super.graphics.drawImage(arrowIcon, 4, var10 + 3, 6);
         }
      }

      this.flushGraphics();
      if (super.gameMIDlet.var_3a.getCurrent() != this) {
         super.gameMIDlet.var_3a.setCurrent(this);
      }

   }

   private void handleMainMenuInput(int var1) {
      if (var1 != 50 && this.getGameAction(var1) != 1) {
         if (var1 != 56 && this.getGameAction(var1) != 6) {
            if (var1 == 53 || this.getGameAction(var1) == 8) {
               switch(this.selectedMenuItem) {
               case 0:
                  super.screenState = 1;
                  break;
               case 1:
                  super.screenState = 3;
                  break;
               case 2:
                  super.screenState = 4;
                  break;
               case 3:
                   GameInitializer.getInstance();
                   GameInitializer.cleanupAllResources();
                   SplashScreen.initializeSplash();
                   GameMIDlet.sub_f().destroyApp(false);

                   GameMIDlet.sub_f().notifyDestroyed();
                  return;
               }
            }
         } else if (this.selectedMenuItem == menuItems.length - 1) {
            this.selectedMenuItem = 0;
         } else {
            ++this.selectedMenuItem;
         }
      } else if (this.selectedMenuItem == 0) {
         this.selectedMenuItem = menuItems.length - 1;
      } else {
         --this.selectedMenuItem;
      }

      this.onSizeChanged();
   }

   private void renderMapSelection() {
      this.drawHeader("choose a map");
      Vector var1 = MapLoader.getInstance().availableMaps;

      for(int var2 = 0; var2 < var1.size(); ++var2) {
         String var4 = ((MapParameters)var1.elementAt(var2)).mapName.toLowerCase();
         int var5 = 10;
         byte var6 = 43;
         int var7;
         if ((var7 = GameConfig.getInstance().lowRes) == 1) {
            var6 = 30;
         }

         int var11 = var6 + var2 * 14;
         int[] var8 = new int[4];

         int var9;
         for(var9 = 0; var9 < var4.length(); ++var9) {
            getCharRegion(var4.charAt(var9), var8);
            if (var8[0] != -1) {
               super.graphics.drawRegion(normalTextFont, var8[0], var8[1], var8[2], var8[3], 0, var5, var11, 20);
               var5 += var8[2];
            } else {
               var5 += 6;
            }
         }

         if (var2 == super.touchX) {
            byte var12 = 43;
            if (var7 == 1) {
               var12 = 30;
            }

            var9 = var12 + var2 * 14 + 3;
            super.graphics.drawImage(arrowIcon, 4, var9, 6);
         }
      }

      this.flushGraphics();
      if (super.gameMIDlet.var_3a.getCurrent() != this) {
         super.gameMIDlet.var_3a.setCurrent(this);
      }

   }

   private void handleMapSelectionInput(int var1) {
      Vector var2 = MapLoader.getInstance().availableMaps;
      if (var1 != 56 && this.getGameAction(var1) != 1) {
         if (var1 != 50 && this.getGameAction(var1) != 6) {
            if (var1 == 53 || this.getGameAction(var1) == 8) {
               MapLoader.getInstance().currentMapIndex = super.touchX;
               GameInitializer.getInstance();
               GameInitializer.setupGameSession();
               GameInitializer.getInstance();
               GameInitializer.startGame();
               return;
            }

            if (var1 == 35 || var1 == -11) {
               super.screenState = 0;
            }
         } else if (super.touchX == var2.size() - 1) {
            super.touchX = 0;
         } else {
            ++super.touchX;
         }
      } else if (super.touchX == 0) {
         super.touchX = var2.size() - 1;
      } else {
         --super.touchX;
      }

      this.onSizeChanged();
   }

   private void renderOptions() {
      this.drawHeader("options");
      String var1 = "sound";
      int var2 = 10;
      byte var3 = 43;
      if (GameConfig.getInstance().lowRes == 1) {
         var3 = 30;
      }

      int[] var5 = new int[4];

      for(int var6 = 0; var6 < var1.length(); ++var6) {
         getCharRegion(var1.charAt(var6), var5);
         if (var5[0] != -1) {
            super.graphics.drawRegion(normalTextFont, var5[0], var5[1], var5[2], var5[3], 0, var2, var3, 20);
            var2 += var5[2];
         } else {
            var2 += 6;
         }
      }

      super.graphics.drawRegion(arrowIcon, 0, 0, arrowIcon.getWidth(), arrowIcon.getHeight(), 3, this.getWidth() - 40, var3 + 3, 24);
      String var9 = super.soundSettingChanged ? "on" : "off";
      var2 = this.getWidth() - 35;

      for(int var7 = 0; var7 < var9.length(); ++var7) {
         getCharRegion(var9.charAt(var7), var5);
         if (var5[0] != -1) {
            super.graphics.drawRegion(normalTextFont, var5[0], var5[1], var5[2], var5[3], 0, var2, var3, 20);
            var2 += var5[2];
         } else {
            var2 += 6;
         }
      }

      super.graphics.drawRegion(arrowIcon, 0, 0, arrowIcon.getWidth(), arrowIcon.getHeight(), 0, this.getWidth() - 10, var3 + 3, 24);
      this.flushGraphics();
      if (super.gameMIDlet.var_3a.getCurrent() != this) {
         super.gameMIDlet.var_3a.setCurrent(this);
      }

   }

   private void handleOptionsInput(int var1) {
      if (var1 != 50 && this.getGameAction(var1) != 1) {
         if (var1 != 56 && this.getGameAction(var1) != 6) {
            if (var1 != 52 && this.getGameAction(var1) != 2) {
               if (var1 != 54 && this.getGameAction(var1) != 5) {
                  if (var1 != 53 && this.getGameAction(var1) != 8) {
                     if (var1 == 35 || var1 == -11) {
                        super.soundSettingChanged = super.soundEnabled;
                        super.screenState = 0;
                     }
                  } else {
                     super.soundEnabled = super.soundSettingChanged;
                     super.screenState = 0;
                  }
               } else {
                  switch(super.inputMode) {
                  case 0:
                     super.soundSettingChanged = !super.soundSettingChanged;
                  }
               }
            } else {
               switch(super.inputMode) {
               case 0:
                  super.soundSettingChanged = !super.soundSettingChanged;
               }
            }
         } else if (super.inputMode == 0) {
            super.inputMode = 0;
         } else {
            ++super.inputMode;
         }
      } else if (super.inputMode == 0) {
         super.inputMode = 0;
      } else {
         --super.inputMode;
      }

      this.onSizeChanged();
   }

   private void renderHelp() {
      this.drawHeader("help");
      this.drawScrollableText(helpText);
      this.flushGraphics();
      if (super.gameMIDlet.var_3a.getCurrent() != this) {
         super.gameMIDlet.var_3a.setCurrent(this);
      }

   }

   private void handleHelpInput(int var1) {
      if (var1 != 50 && this.getGameAction(var1) != 1) {
         if (var1 != 56 && this.getGameAction(var1) != 6) {
            if (var1 == 53 || var1 == 35 || this.getGameAction(var1) == 8 || var1 == -11) {
               this.scrollOffset = 0;
               this.canScrollDown = true;
               super.screenState = 0;
            }
         } else if (this.canScrollDown) {
            ++this.scrollOffset;
            if (this.scrollOffset > helpText.length - 1) {
               this.scrollOffset = helpText.length - 1;
            }
         }
      } else {
         --this.scrollOffset;
         if (this.scrollOffset < 0) {
            this.scrollOffset = 0;
         }
      }

      this.onSizeChanged();
   }

   private void renderAbout() {
      this.drawHeader("about");
      this.drawScrollableText(aboutText);
      this.flushGraphics();
      if (super.gameMIDlet.var_3a.getCurrent() != this) {
         super.gameMIDlet.var_3a.setCurrent(this);
      }

   }

   private void handleAboutInput(int var1) {
      if (var1 != 50 && this.getGameAction(var1) != 1) {
         if (var1 != 56 && this.getGameAction(var1) != 6) {
            if (var1 == 53 || var1 == 35 || this.getGameAction(var1) == 8 || var1 == -11) {
               this.scrollOffset = 0;
               this.canScrollDown = true;
               super.screenState = 0;
            }
         } else if (this.canScrollDown) {
            ++this.scrollOffset;
            if (this.scrollOffset > helpText.length - 1) {
               this.scrollOffset = helpText.length - 1;
            }
         }
      } else {
         --this.scrollOffset;
         if (this.scrollOffset < 0) {
            this.scrollOffset = 0;
         }
      }

      this.onSizeChanged();
   }

   private void renderLoadingScreen() {
      super.graphics.setColor(0, 0, 0);
      super.graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
      int var2 = this.getHeight() - 20;
      int var3 = this.getWidth() - 40;
      super.graphics.setColor(16685312);
      super.graphics.fillRect(20, var2, (int)((float)var3 * ((float) GameInitializer.getInstance().progressPercentage / 100.0F)), 5);
      super.graphics.setColor(1250067);
      super.graphics.drawRect(20, var2, var3, 5);
      this.flushGraphics();
   }

   public final void showErrorMessage(String var1) {
      super.graphics.setColor(0, 0, 0);
      super.graphics.fillRect(0, 0, this.getWidth(), this.getHeight());
      super.graphics.setColor(255, 255, 255);
      super.graphics.drawString(var1, 0, 0, 20);
      this.flushGraphics();
      if (super.gameMIDlet.var_3a.getCurrent() != this) {
         super.gameMIDlet.var_3a.setCurrent(this);
      }

   }

   public static void getCharRegion(char var0, int[] var1) {
      var1[0] = -1;
      var1[1] = -1;
      var1[2] = -1;
      var1[3] = -1;
      if (var0 >= 'a' && var0 <= 'z') {
         var1[0] = 0 + (var0 - 97) * 6;
         var1[1] = 0;
         var1[2] = 6;
         var1[3] = 6;
      } else if (var0 >= '0' && var0 <= '9') {
         var1[0] = 156 + (var0 - 48) * 6;
         var1[1] = 0;
         var1[2] = 6;
         var1[3] = 6;
      } else {
         switch(var0) {
         case '!':
            var1[0] = 225;
            var1[1] = 0;
            var1[2] = 3;
            var1[3] = 6;
            return;
         case '#':
            var1[0] = 264;
            var1[1] = 0;
            var1[2] = 7;
            var1[3] = 6;
            return;
         case '$':
            var1[0] = 257;
            var1[1] = 0;
            var1[2] = 7;
            var1[3] = 6;
            return;
         case '\'':
            var1[0] = 222;
            var1[1] = 0;
            var1[2] = 3;
            var1[3] = 6;
            return;
         case '(':
            var1[0] = 236;
            var1[1] = 0;
            var1[2] = 4;
            var1[3] = 6;
            return;
         case ')':
            var1[0] = 240;
            var1[1] = 0;
            var1[2] = 4;
            var1[3] = 6;
            return;
         case ',':
            var1[0] = 219;
            var1[1] = 0;
            var1[2] = 3;
            var1[3] = 6;
            return;
         case '-':
            var1[0] = 244;
            var1[1] = 0;
            var1[2] = 6;
            var1[3] = 6;
            return;
         case '.':
            var1[0] = 216;
            var1[1] = 0;
            var1[2] = 3;
            var1[3] = 6;
            return;
         case ':':
            var1[0] = 232;
            var1[1] = 0;
            var1[2] = 4;
            var1[3] = 6;
            return;
         case ';':
            var1[0] = 228;
            var1[1] = 0;
            var1[2] = 4;
            var1[3] = 6;
            return;
         case '?':
            var1[0] = 250;
            var1[1] = 0;
            var1[2] = 7;
            var1[3] = 6;
            return;
         case '@':
            var1[0] = 271;
            var1[1] = 0;
            var1[2] = 7;
            var1[3] = 6;
            return;
         case '^':
            var1[0] = 278;
            var1[1] = 0;
            var1[2] = 8;
            var1[3] = 6;
         default:
         }
      }
   }

   public static void getBoldCharRegion(char var0, int[] var1) {
      var1[0] = -1;
      var1[1] = -1;
      var1[2] = -1;
      var1[3] = -1;
      if (var0 >= 'a' && var0 <= 'z') {
         var1[0] = (var0 - 97) * 8;
         var1[1] = 0;
         var1[2] = 8;
         var1[3] = 8;
      }

   }

   public static void loadResources() {
      try {
         titleImageSmall = Image.createImage("/res/image2d/title_s.png");
         titleImage = Image.createImage("/res/image2d/title.png");
         arrowIcon = Image.createImage("/res/image2d/arrow_s.png");
         normalTextFont = Image.createImage("/res/image2d/text.png");
         boldTextFont = Image.createImage("/res/image2d/text_b.png");
      } catch (Exception var1) {
         var1.printStackTrace();
      }
   }

   public static void cleanUp() {
      titleImage = null;
      titleImageSmall = null;
      arrowIcon = null;
      normalTextFont = null;
      boldTextFont = null;
   }
}
