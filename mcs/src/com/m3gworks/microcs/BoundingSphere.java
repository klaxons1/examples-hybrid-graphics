package com.m3gworks.microcs; 
public final class BoundingSphere {
   public float[] center = new float[3];
   public float radius;

   public BoundingSphere() {
   }

   public BoundingSphere(float[] var1, float var2) {
      this.center = var1;
      this.radius = var2;
   }

   public final boolean intersects(BoundingSphere var1) {
      float[] var2;
      float var3 = ((var2 = var1.center)[0] - this.center[0]) * (var2[0] - this.center[0]) + (var2[1] - this.center[1]) * (var2[1] - this.center[1]) + (var2[2] - this.center[2]) * (var2[2] - this.center[2]);
      float var4 = (this.radius + var1.radius) * (this.radius + var1.radius);
      return !(var3 > var4);
   }

   public final void setCenter(float var1, float var2, float var3) {
      this.center[0] = var1;
      this.center[1] = var2;
      this.center[2] = var3;
   }
}
