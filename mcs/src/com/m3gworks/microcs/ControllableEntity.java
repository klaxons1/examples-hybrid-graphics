package com.m3gworks.microcs; 
import javax.microedition.m3g.Node;
import javax.microedition.m3g.RayIntersection;
import javax.microedition.m3g.Transform;
import javax.microedition.m3g.World;

public class ControllableEntity extends GameEntity {
   public Transform var_a4 = new Transform();

   public ControllableEntity(int var1, String var2, int var3, Model3D var4) {
      super(var1, var2, var3);
      super.model3D = var4;
   }

   public void initialize(World var1) {
      super.model3D.createModel(var1).setUserObject(this);
   }

   public void reset() {
      super.reset();
      this.var_a4 = null;
   }

   public void respawn() {
      this.var_a4.setIdentity();
      super.respawn();
   }

   public final void updateBot() {
      super.model3D.rootNode.setTransform(this.var_a4);
   }

   public final float getCollisionRadius() {
      return 1.0F;
   }

   public final float[] sub_19(float[] var1) {
      float[] var2 = new float[3];
      BoundingBox var3;
      if ((var3 = this.checkCollision(var1)) != null) {
         float[] var4 = this.getPosition();
         float[] var5 = var3.clampPoint(var4);
         float[] var6;
         if ((var6 = new float[]{var5[0] - var4[0], 0.0F, var5[2] - var4[2]})[0] == 0.0F && var6[1] == 0.0F && var6[2] == 0.0F) {
            var2[0] = var1[0];
            var2[1] = var1[1];
            var2[2] = var1[2];
            return var2;
         }

         RayIntersection var7 = new RayIntersection();
         World var8;
         if (!(var8 = MapLoader.getInstance().currentWorld).pick(-1, var4[0], var4[1] / 4.0F, var4[2], var6[0], var6[1], var6[2], var7)) {
            return var2;
         }

         Node var9;
         if ((var9 = var7.getIntersected()) == var3.mesh) {
            float var10 = var7.getNormalX();
            float var11 = var7.getNormalY();
            float var12 = var7.getNormalZ();
            Transform var13 = new Transform();
            var9.getTransformTo(var8, var13);
            float[] var14 = new float[]{var10, var11, var12, 0.0F};
            var13.transform(var14);
            var14[1] = 0.0F;
            float[] var15;
            (var15 = new float[3])[0] = var14[0];
            var15[1] = var14[1];
            var15[2] = var14[2];
            if ((float)Math.toDegrees((double)((float) MathUtilsArcSin.asin((double) MathUtils.dotProduct(var1, var15) / (Math.sqrt((double)(var1[0] * var1[0] + var1[1] * var1[1] + var1[2] * var1[2])) * Math.sqrt((double)(var15[0] * var15[0] + var15[1] * var15[1] + var15[2] * var15[2])))))) >= 90.0F) {
               var15[0] = -var14[0];
               var15[1] = -var14[1];
               var15[2] = -var14[2];
               float[] var19;
               if ((var19 = MathUtils.vectorRejection(var1, var15))[0] != 0.0F || var19[1] != 0.0F || var19[2] != 0.0F) {
                  double var20 = (double) MathUtils.dotProduct(var1, var19) / (Math.sqrt((double)(var1[0] * var1[0] + var1[1] * var1[1] + var1[2] * var1[2])) * Math.sqrt((double)(var19[0] * var19[0] + var19[1] * var19[1] + var19[2] * var19[2])));
                  float var23 = (float)((double) MathUtils.vectorLength(var1) * var20);
                  float[] var24 = MathUtils.normalizeVector(var19);
                  var2[0] = var24[0] * var23;
                  var2[1] = var24[1] * var23;
                  var2[2] = var24[2] * var23;
                  if (this.checkCollision(var2) != null) {
                     var2[0] = 0.0F;
                     var2[1] = 0.0F;
                     var2[2] = 0.0F;
                  }

                  return var2;
               }
            } else {
               var2[0] = var1[0];
               var2[1] = var1[1];
               var2[2] = var1[2];
            }

            return var2;
         }
      }

      var2[0] = var1[0];
      var2[1] = var1[1];
      var2[2] = var1[2];
      return var2;
   }

   public final float moveForward(float var1) {
      super.pitchAngle += var1;
      float var2 = 75.0F;
      if (super.pitchAngle > var2) {
         super.pitchAngle = var2;
         return 0.0F;
      } else {
         this.var_a4.postRotate(var1, 1.0F, 0.0F, 0.0F);
         return var1;
      }
   }

   public final float strafe(float var1) {
      super.pitchAngle -= var1;
      float var2 = -75.0F;
      if (super.pitchAngle < var2) {
         super.pitchAngle = var2;
         return 0.0F;
      } else {
         this.var_a4.postRotate(-var1, 1.0F, 0.0F, 0.0F);
         return var1;
      }
   }

   public final float turnRight(float var1) {
      this.var_a4.postRotate(-super.pitchAngle, 1.0F, 0.0F, 0.0F);
      this.var_a4.postRotate(var1, 0.0F, 1.0F, 0.0F);
      this.var_a4.postRotate(super.pitchAngle, 1.0F, 0.0F, 0.0F);
      super.yawAngle += var1;
      return var1;
   }

   public final float turnLeft(float var1) {
      this.var_a4.postRotate(-super.pitchAngle, 1.0F, 0.0F, 0.0F);
      this.var_a4.postRotate(-var1, 0.0F, 1.0F, 0.0F);
      this.var_a4.postRotate(super.pitchAngle, 1.0F, 0.0F, 0.0F);
      super.yawAngle -= var1;
      return var1;
   }

   public final void sub_6f(float[] var1) {
      this.moveBoundingSphere(var1);
      super.model3D.rootNode.translate(var1[0], var1[1], var1[2]);
   }
}
