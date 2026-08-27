package com.m3gworks.microcs; 
import javax.microedition.m3g.Mesh;

public final class BoundingBox {
   public Mesh mesh;
   public float[] minBounds = new float[3];
   public float[] maxBounds = new float[3];

   public BoundingBox(float[] var1, Mesh var2) {
      this.mesh = var2;
      float[] var3 = calculateBounds(var1);
      this.minBounds[0] = var3[0];
      this.minBounds[1] = var3[1];
      this.minBounds[2] = var3[2];
      this.maxBounds[0] = var3[3];
      this.maxBounds[1] = var3[4];
      this.maxBounds[2] = var3[5];
   }

   private static float[] calculateBounds(float[] var0) {
      float[] var1 = new float[]{Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE, -3.4028235E38F, -3.4028235E38F, -3.4028235E38F};

      for(int var2 = 0; var2 < var0.length; ++var2) {
         float var3;
         if (var2 % 4 == 0) {
            if ((var3 = var0[var2]) < var1[0]) {
               var1[0] = var3;
            }

            if (var3 > var1[3]) {
               var1[3] = var3;
            }
         } else if (var2 % 4 == 1) {
            if ((var3 = var0[var2]) < var1[1]) {
               var1[1] = var3;
            }

            if (var3 > var1[4]) {
               var1[4] = var3;
            }
         } else if (var2 % 4 == 2) {
            if ((var3 = var0[var2]) < var1[2]) {
               var1[2] = var3;
            }

            if (var3 > var1[5]) {
               var1[5] = var3;
            }
         }
      }

      return var1;
   }

   public final boolean intersects(BoundingSphere var1) {
      float[] var2 = var1.center;
      float var3 = var1.radius;
      float[] var4;
      return ((var4 = this.clampPoint(var2))[0] - var2[0]) * (var4[0] - var2[0]) + (var4[1] - var2[1]) * (var4[1] - var2[1]) + (var4[2] - var2[2]) * (var4[2] - var2[2]) < var3 * var3;
   }

   public final float[] clampPoint(float[] var1) {
      float[] var2 = new float[3];
      if (var1[0] < this.minBounds[0]) {
         var2[0] = this.minBounds[0];
      } else if (var1[0] > this.maxBounds[0]) {
         var2[0] = this.maxBounds[0];
      } else {
         var2[0] = var1[0];
      }

      if (var1[1] < this.minBounds[1]) {
         var2[1] = this.minBounds[1];
      } else if (var1[1] > this.maxBounds[1]) {
         var2[1] = this.maxBounds[1];
      } else {
         var2[1] = var1[1];
      }

      if (var1[2] < this.minBounds[2]) {
         var2[2] = this.minBounds[2];
      } else if (var1[2] > this.maxBounds[2]) {
         var2[2] = this.maxBounds[2];
      } else {
         var2[2] = var1[2];
      }

      return var2;
   }

   public final boolean intersectsRay(float[] var1, float[] var2) {
      float var4;
      if (var1[0] < this.minBounds[0]) {
         if ((var4 = this.minBounds[0] - var1[0]) > var2[0]) {
            return false;
         }

         var4 /= var2[0];
      } else if (var1[0] > this.maxBounds[0]) {
         if ((var4 = this.maxBounds[0] - var1[0]) < var2[0]) {
            return false;
         }

         var4 /= var2[0];
      } else {
         var4 = -1.0F;
      }

      float var5;
      if (var1[1] < this.minBounds[1]) {
         if ((var5 = this.minBounds[1] - var1[1]) > var2[1]) {
            return false;
         }

         var5 /= var2[1];
      } else if (var1[1] > this.maxBounds[1]) {
         if ((var5 = this.maxBounds[1] - var1[1]) < var2[1]) {
            return false;
         }

         var5 /= var2[1];
      } else {
         var5 = -1.0F;
      }

      float var6;
      if (var1[2] < this.minBounds[2]) {
         if ((var6 = this.minBounds[2] - var1[2]) > var2[2]) {
            return false;
         }

         var6 /= var2[2];
      } else if (var1[2] > this.maxBounds[2]) {
         if ((var6 = this.maxBounds[2] - var1[2]) < var2[2]) {
            return false;
         }

         var6 /= var2[2];
      } else {
         var6 = -1.0F;
      }

      byte var7 = 0;
      float var8 = var4;
      if (var5 > var4) {
         var7 = 1;
         var8 = var5;
      }

      if (var6 > var8) {
         var7 = 2;
         var8 = var6;
      }

      float var9;
      float var10;
      switch(var7) {
      case 0:
         if ((var9 = var1[1] + var2[1] * var8) < this.minBounds[1] || var9 > this.maxBounds[1]) {
            return false;
         }

         if (!((var10 = var1[2] + var2[2] * var8) < this.minBounds[2]) && !(var10 > this.maxBounds[2])) {
            break;
         }

         return false;
      case 1:
         if (!((var9 = var1[0] + var2[0] * var8) < this.minBounds[0]) && !(var9 > this.maxBounds[0])) {
            if (!((var10 = var1[2] + var2[2] * var8) < this.minBounds[2]) && !(var10 > this.maxBounds[2])) {
               break;
            }

            return false;
         }

         return false;
      case 2:
         if ((var9 = var1[0] + var2[0] * var8) < this.minBounds[0] || var9 > this.maxBounds[0]) {
            return false;
         }

         if ((var10 = var1[1] + var2[1] * var8) < this.minBounds[1] || var10 > this.maxBounds[1]) {
            return false;
         }
      }

      return true;
   }
}
