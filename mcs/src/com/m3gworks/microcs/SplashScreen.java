package com.m3gworks.microcs; 
import com.m3gworks.engine.GameMIDlet;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;

public final class SplashScreen extends Canvas implements Runnable {
   private static Image splashImage = null;
   private int imagePositionX = this.getWidth();
   private static int animationDelay = 10;
   private static int totalDisplayTime = 1000;
   private int elapsedTime = 0;

   private SplashScreen() {
      this.setFullScreenMode(true);
   }

   public final void paint(Graphics var1) {
      var1.setColor(0, 0, 0);
      var1.fillRect(0, 0, this.getWidth(), this.getHeight());
      var1.drawImage(splashImage, this.imagePositionX, this.getHeight() / 2, 6);
   }

   public final void run() {
      while(true) {
         if (this.imagePositionX <= (this.getWidth() - splashImage.getWidth()) / 2) {
            this.elapsedTime += animationDelay;
            if (this.elapsedTime > totalDisplayTime) {
               finishSplash();
               GameMIDlet.sub_f().var_3a.setCurrent(GameCanvas.getInstance());
               GameCanvas.getInstance().onSizeChanged();
               return;
            }
         }

         try {
            Thread.sleep((long) animationDelay);
         } catch (InterruptedException var2) {
            var2.printStackTrace();
         }

         if (this.imagePositionX > (this.getWidth() - splashImage.getWidth()) / 2) {
            this.imagePositionX -= 2;
         }

         this.repaint();
      }
   }

   private static void cleanUp() {
      splashImage = null;
   }

   public static void finishSplash() {
      GameCanvas.initializeMainMenu();
   }

   public static void initializeSplash() {
      cleanUp();
      GameCanvas.loadMainMenuResources();
   }
}
