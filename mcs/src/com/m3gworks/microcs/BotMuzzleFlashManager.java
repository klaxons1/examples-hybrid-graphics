package com.m3gworks.microcs; 
import java.util.Vector;
import javax.microedition.lcdui.Image;
import javax.microedition.m3g.Camera;
import javax.microedition.m3g.Image2D;

public final class BotMuzzleFlashManager {
   private static BotMuzzleFlashManager instance;
   public static Image2D[] rifleMuzzleFlashSprites;
   public static Image[] rifleMuzzleFlashImages;
   public static Image2D[] pistolMuzzleFlashSprites;
   public static Image[] pistolMuzzleFlashImages;
   private Vector activeMuzzleFlashes = new Vector();

   private BotMuzzleFlashManager() {
   }

   public static BotMuzzleFlashManager getInstance() {
      if (instance == null) {
         instance = new BotMuzzleFlashManager();
      }

      return instance;
   }

   public static void loadMuzzleFlashResources() {
      rifleMuzzleFlashImages = new Image[3];
      rifleMuzzleFlashSprites = ResourceLoader.loadSpriteSheetWithImages("/res/image2d/muzzleflash_r.png", 3, 32, rifleMuzzleFlashImages);
      pistolMuzzleFlashImages = new Image[1];
      pistolMuzzleFlashSprites = ResourceLoader.loadSpriteSheetWithImages("/res/image2d/muzzleflash_p.png", 1, 32, pistolMuzzleFlashImages);
   }

   public final ParticleEffect createMuzzleFlash(Camera var1, int var2) {
      if (this.activeMuzzleFlashes == null) {
         this.activeMuzzleFlashes = new Vector();
      }

      Image2D[] var3 = (Image2D[])null;
      if (var2 == 1) {
         var3 = rifleMuzzleFlashSprites;
      } else if (var2 == 2) {
         var3 = pistolMuzzleFlashSprites;
      }

      ParticleEffect var4;
      (var4 = new ParticleEffect(var3, var1, 3.0F)).spriteMesh.setPickingEnable(false); // muzzle flash scale
      this.activeMuzzleFlashes.addElement(var4);
      return var4;
   }

   public final void updateMuzzleFlashes() {
      if (this.activeMuzzleFlashes != null) {
         for(int var1 = 0; var1 < this.activeMuzzleFlashes.size(); ++var1) {
            Object var2;
            if ((var2 = this.activeMuzzleFlashes.elementAt(var1)) != null) {
               ParticleEffect var3;
               (var3 = (ParticleEffect)var2).updateAnimation();
            }
         }

      }
   }

   public final void cleanupMuzzleFlashes() {
      this.activeMuzzleFlashes = null;
   }

   public static void releaseMuzzleFlashResources() {
      rifleMuzzleFlashSprites = null;
      pistolMuzzleFlashSprites = null;
   }
}
