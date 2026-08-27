package com.m3gworks.microcs; 
import javax.microedition.m3g.Transform;
import javax.microedition.m3g.World;

public class BotCharacter extends GameEntity {
   public float[] movementVector;
   private Transform bodyTransform = new Transform();
   private Transform headTransform = new Transform();
   private Transform legsTransform = new Transform();
   private float accumulatedRotation = 0.0F;
   public int currentAnimationFrame;
   public int botState = -1;
   public int animationCounter = 0;

   public BotCharacter(int var1, String var2, int var3) {
      super(var1, var2, var3);
      super.model3D = new TerroristModelLoader(this);
   }

   public void initialize(World var1) {
      super.model3D.createModel(var1).setUserObject(this);
   }

   public void reset() {
      super.reset();
      this.bodyTransform = null;
      this.headTransform = null;
      this.legsTransform = null;
      this.movementVector = null;
   }

   public void respawn() {
      super.respawn();
      this.currentAnimationFrame = TerroristModelLoader.var_2ca[1][1] - TerroristModelLoader.var_2ca[1][0] - 1;
      this.bodyTransform.setIdentity();
      this.headTransform.setIdentity();
      this.legsTransform.setIdentity();
      this.botState = -1;
      this.updateBot();
   }

   public final void updateBot() {
      TerroristModelLoader var1;
      (var1 = (TerroristModelLoader)super.model3D).var_cf.setTransform(this.bodyTransform);
      var1.var_158.setTransform(this.headTransform);
      var1.var_1d0.setTransform(this.legsTransform);
      boolean var2 = false;
      if (this.botState != 0 && this.botState != -1) {
         float[] var3 = this.getPosition();
         float[] var4;
         float var5 = ((var4 = GameEntityManager.getInstance().localPlayer.getPosition())[0] - var3[0]) * (var4[0] - var3[0]) + (var4[2] - var3[2]) * (var4[2] - var3[2]);
         float var6 = 3600.0F;
         if (var5 < var6) {
            var2 = true;
         }
      } else {
         var2 = true;
      }

      if (var2) {
         super.model3D.rootNode.animate(this.currentAnimationFrame * 50);
      }

   }

   public final float getCollisionRadius() {
      return 1.0F;
   }

   public final float[] checkMovement(float[] var1) {
      float[] var2 = new float[3];
      if (this.checkCollision(var1) == null) {
         var2[0] = var1[0];
         var2[1] = var1[1];
         var2[2] = var1[2];
      }

      return var2;
   }

   public final float moveForward(float var1) {
      super.pitchAngle += var1;
      float var2 = 75.0F;
      if (super.pitchAngle > var2) {
         super.pitchAngle = var2;
         return 0.0F;
      } else {
         this.bodyTransform.postRotate(var1, TerroristModelLoader.var_25d[0], TerroristModelLoader.var_25d[1], TerroristModelLoader.var_25d[2]);
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
         this.bodyTransform.postRotate(-var1, TerroristModelLoader.var_25d[0], TerroristModelLoader.var_25d[1], TerroristModelLoader.var_25d[2]);
         return var1;
      }
   }

   public final float turnRight(float var1) {
      super.yawAngle += var1;
      this.headTransform.postRotate(var1, TerroristModelLoader.var_27b[0], TerroristModelLoader.var_27b[1], TerroristModelLoader.var_27b[2]);
      this.accumulatedRotation += var1;
      if (this.accumulatedRotation >= 45.0F) {
         this.resetAccumulatedRotation();
      }

      return var1;
   }

   public final float turnLeft(float var1) {
      super.yawAngle -= var1;
      this.headTransform.postRotate(-var1, TerroristModelLoader.var_27b[0], TerroristModelLoader.var_27b[1], TerroristModelLoader.var_27b[2]);
      this.accumulatedRotation -= var1;
      if (this.accumulatedRotation <= -45.0F) {
         this.resetAccumulatedRotation();
      }

      return var1;
   }

   public final void applyMovement(int var1, float[] var2) {
      this.movementVector = var2;
      if (var1 != 1 && var1 != 2) {
         this.adjustRotation();
      } else {
         this.resetAccumulatedRotation();
      }

      this.setBotState(var1);
      this.moveBoundingSphere(var2);
   }

   public final void changeState() {
      int var1 = TerroristModelLoader.var_2ca[1][1];
      super.model3D.rootNode.translate(this.movementVector[0] / (float)var1, this.movementVector[1] / (float)var1, this.movementVector[2] / (float)var1);
   }

   private void resetAccumulatedRotation() {
      this.legsTransform.postRotate(this.accumulatedRotation, TerroristModelLoader.var_27b[0], TerroristModelLoader.var_27b[1], TerroristModelLoader.var_27b[2]);
      this.accumulatedRotation = 0.0F;
   }

   private void adjustRotation() {
      float var1 = 0.0F;
      if (this.accumulatedRotation > 0.0F) {
         var1 = 60.0F - this.accumulatedRotation;
         this.accumulatedRotation = 60.0F;
      } else {
         var1 = -60.0F - this.accumulatedRotation;
         this.accumulatedRotation = -60.0F;
      }

      this.legsTransform.postRotate(-var1, TerroristModelLoader.var_27b[0], TerroristModelLoader.var_27b[1], TerroristModelLoader.var_27b[2]);
   }

   public final void setBotState(int var1) {
      if (var1 == 0) {
         this.bodyTransform.setIdentity();
         this.headTransform.setIdentity();
         this.legsTransform.setIdentity();
      }

      this.botState = var1;
      this.animationCounter = 1;
   }

   public final void updateAnimation() {
      if (!this.isAnimationFinished()) {
         this.currentAnimationFrame = TerroristModelLoader.var_2ca[this.botState][0] + (this.animationCounter - 1);
         ++this.animationCounter;
      }
   }

   public final boolean isAnimationFinished() {
      if (this.botState == -1) {
         return true;
      } else {
         return this.animationCounter > TerroristModelLoader.var_2ca[this.botState][1];
      }
   }
}
