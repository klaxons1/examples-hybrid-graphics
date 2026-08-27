package com.m3gworks.microcs; 
import java.util.Vector;
import javax.microedition.m3g.Camera;
import javax.microedition.m3g.Image2D;
import javax.microedition.m3g.Node;
import javax.microedition.m3g.RayIntersection;
import javax.microedition.m3g.Transform;
import javax.microedition.m3g.World;

public final class EffectManager {
   private static EffectManager instance;
   private static Image2D[] bloodSpraySprites;
   private static Image2D[] smokePuffSprites;
   private static Image2D[] wallSplashSprites;
   private static Image2D[] explosionSprites;
   private Vector bloodEffects;
   private Vector smokeEffects;
   private Vector wallSplashEffects;
   private Vector explosionEffects;

   private EffectManager() {
   }

   public static EffectManager getInstance() {
      if (instance == null) {
         instance = new EffectManager();
      }

      return instance;
   }

   public static void loadEffectResources() {
      bloodSpraySprites = ResourceLoader.loadSpriteSheet("/res/image2d/bloodspray.png", 4, 32);
      if (GameConfig.getInstance().hasSound()) {
         smokePuffSprites = ResourceLoader.loadSpriteSheet("/res/image2d/smokepuff.png", 4, 32);
      }

      if (GameConfig.getInstance().sub_a5()) {
         wallSplashSprites = ResourceLoader.loadSpriteSheet("/res/image2d/wallsplash.png", 4, 32);
      }

      explosionSprites = ResourceLoader.loadSpriteSheet("/res/image2d/explosion.png", 6, 64);
   }

   public final void createImpactEffect(int var1, RayIntersection var2, World var3, Camera var4) {
      Vector var5 = null;
      Image2D[] var6 = (Image2D[])null;
      float var7 = 1.0F;
      if (this.bloodEffects == null) {
         this.bloodEffects = new Vector();
      }

      if (this.smokeEffects == null) {
         this.smokeEffects = new Vector();
      }

      if (this.wallSplashEffects == null) {
         this.wallSplashEffects = new Vector();
      }

      if (var1 == 1) {
         var5 = this.bloodEffects;
         var6 = bloodSpraySprites;
         var7 = 16.0F;
      } else if (var1 == 2) {
         var5 = this.smokeEffects;
         var6 = smokePuffSprites;
         var7 = 6.0F;
      } else if (var1 == 3) {
         var5 = this.wallSplashEffects;
         var6 = wallSplashSprites;
         var7 = 16.0F;
      }

      ParticleEffect var8 = null;

      for(int var9 = 0; var9 < var5.size(); ++var9) {
         ParticleEffect var11;
         if (!(var11 = (ParticleEffect)var5.elementAt(var9)).isActive) {
            var8 = var11;
            break;
         }
      }

      if (var8 == null) {
         ParticleEffect var14 = null;
         if (var5.size() > 0) {
            var14 = (ParticleEffect)var5.elementAt(0);
         }

         if (var14 != null) {
            var8 = new ParticleEffect(var14.spriteMesh, var14.textureFrames, var4);
         } else {
            var8 = new ParticleEffect(var6, var4, var7);
         }

         var3.addChild(var8.spriteMesh);
         var5.addElement(var8);
      }

      var8.setActive(true);
      float var15 = 0.0F;
      float var10 = 0.0F;
      float var16 = 0.0F;
      if (var2 != null) {
         float var12 = var2.getDistance();
         float[] var13 = new float[6];
         var2.getRay(var13);
         var15 = var13[0] + var13[3] * var12;
         var10 = var13[1] + var13[4] * var12;
         var16 = var13[2] + var13[5] * var12;
      }

      var8.setPosition(var15, var10, var16);
      if (var1 == 2) {
         calculateSmokeTrajectory(var8, var2, var3);
      }

   }

   private static void calculateSmokeTrajectory(ParticleEffect var0, RayIntersection var1, World var2) {
      float var3 = var1.getNormalX();
      float var4 = var1.getNormalY();
      float var5 = var1.getNormalZ();
      Node var6 = var1.getIntersected();
      Transform var7 = new Transform();
      var6.getTransformTo(var2, var7);
      float[] var8 = new float[]{var3, var4, var5, 0.0F};
      var7.transform(var8);
      float[] var9;
      (var9 = new float[3])[0] = var8[0];
      var9[1] = var8[1];
      var9[2] = var8[2];
      float[] var10 = new float[6];
      var1.getRay(var10);
      float[] var11 = new float[]{var10[3], var10[4], var10[5]};
      if (MathUtils.dotProduct(var9, var11) > 0.0F) {
         var9[0] = -var9[0];
         var9[1] = -var9[1];
         var9[2] = -var9[2];
      }

      float var12 = 0.2F;
      float var13 = 0.2F / MathUtils.vectorLength(var9);
      var9[0] *= var13;
      var9[1] = var9[1] * var13 + 0.08F;
      var9[2] *= var13;
      var0.setVelocity(var9);
   }

   public final void createExplosionEffect(float[] var1, World var2, Camera var3) {
      if (this.explosionEffects == null) {
         this.explosionEffects = new Vector();
      }

      ParticleEffect var4 = null;

      for(int var5 = 0; var5 < this.explosionEffects.size(); ++var5) {
         ParticleEffect var7;
         if (!(var7 = (ParticleEffect)this.explosionEffects.elementAt(var5)).isActive) {
            var4 = var7;
            break;
         }
      }

      if (var4 == null) {
         var4 = new ParticleEffect(explosionSprites, var3, 32.0F);
         var2.addChild(var4.spriteMesh);
         this.explosionEffects.addElement(var4);
      }

      var4.setActive(true);
      var4.setPosition(var1[0], var1[1], var1[2]);
   }

   public final void updateAllEffects() {
      updateEffectPool(this.bloodEffects);
      updateEffectPool(this.smokeEffects);
      updateEffectPool(this.wallSplashEffects);
      updateEffectPool(this.explosionEffects);
   }

   private static void updateEffectPool(Vector var0) {
      if (var0 != null) {
         for(int var1 = 0; var1 < var0.size(); ++var1) {
            Object var2;
            if ((var2 = var0.elementAt(var1)) != null) {
               ParticleEffect var3;
               (var3 = (ParticleEffect)var2).updateAnimation();
            }
         }
      }

   }

   public final void cleanupEffectPools() {
      this.bloodEffects = null;
      this.smokeEffects = null;
      this.wallSplashEffects = null;
      this.explosionEffects = null;
   }

   public static void releaseEffectResources() {
      bloodSpraySprites = null;
      smokePuffSprites = null;
      wallSplashSprites = null;
      explosionSprites = null;
   }
}
