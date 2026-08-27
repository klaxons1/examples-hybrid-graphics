package com.m3gworks.microcs; 
import com.m3gworks.engine.GameMIDlet;
import javax.microedition.lcdui.Graphics;

public abstract class GameCanvas extends javax.microedition.lcdui.game.GameCanvas {
   private static GameCanvas instance;
   public GameMIDlet gameMIDlet = GameMIDlet.sub_f();
   public Graphics graphics = null;
   public int screenState;
   public int touchX = 0;
   public int touchY = 0;
   public int terroristPrimaryWeapon;
   public int terroristSecondaryWeapon;
   public int terroristSpecialWeapon;
   public int inputMode = 1;
   public boolean soundEnabled = false;
   public boolean soundSettingChanged;

   public GameCanvas() {
      super(false);
      this.soundSettingChanged = this.soundEnabled;
      this.setFullScreenMode(true);
      this.graphics = this.getGraphics();
      if (this.getWidth() < 130) {
         GameConfig.getInstance().lowRes = 1;
      } else {
         GameConfig.getInstance().lowRes = 0;
      }

      this.screenState = 0;
   }

   public static GameCanvas getInstance() {
      if (instance == null) {
         try {
            instance = (GameCanvas) GameConfig.getInstance().sub_199().newInstance();
         } catch (InstantiationException var1) {
            var1.printStackTrace();
         } catch (IllegalAccessException var2) {
            var2.printStackTrace();
         }
      }

      return instance;
   }

   public abstract void onSizeChanged();

   public abstract void showErrorMessage(String var1);

   public abstract void keyPressed(int var1);

   public void sizeChanged(int var1, int var2) {
      this.graphics = this.getGraphics();
      this.onSizeChanged();
   }

   public static void initializeMainMenu() {
      GameConfig.getInstance().sub_40a();
   }

   public static void loadMainMenuResources() {
      GameConfig.getInstance().sub_49f();
   }

   public final void setSoundEnabled(boolean var1) {
      this.soundEnabled = var1;
      this.soundSettingChanged = var1;
   }
}
