package com.m3gworks.microcs; 
import javax.microedition.m3g.Appearance;
import javax.microedition.m3g.Camera;
import javax.microedition.m3g.CompositingMode;
import javax.microedition.m3g.Image2D;
import javax.microedition.m3g.Mesh;
import javax.microedition.m3g.Node;
import javax.microedition.m3g.Texture2D;
import javax.microedition.m3g.TriangleStripArray;
import javax.microedition.m3g.VertexArray;
import javax.microedition.m3g.VertexBuffer;

public final class ParticleEffect {
   public Mesh spriteMesh;
   private Appearance appearance;
   public Texture2D[] textureFrames;
   private int totalFrames;
   private int currentFrame;
   public boolean isActive;
   private Camera camera;
   private float[] velocity = new float[3];

   public ParticleEffect(Image2D[] var1, Camera var2, float var3) {
      this.camera = var2;
      VertexBuffer var4 = createQuadVertexBuffer();
      int[] var5 = new int[]{1, 2, 0, 3};
      int[] var6 = new int[]{4};
      TriangleStripArray var7 = new TriangleStripArray(var5, var6);
      this.totalFrames = var1.length;
      this.currentFrame = 0;
      this.textureFrames = createTexturesFromImages(var1, this.totalFrames);
      this.appearance = this.createTransparentAppearance(this.textureFrames[this.currentFrame]);
      this.spriteMesh = new Mesh(var4, var7, this.appearance);
      float var8 = var3 * 0.5F;
      this.spriteMesh.scale(var8, var8, var8);
      if (this.camera != null) {
         this.spriteMesh.setAlignment(this.camera, 148, (Node)null, 144);
      }

      this.spriteMesh.setPickingEnable(false);
      this.setActive(false);
   }

   public ParticleEffect(Mesh var1, Texture2D[] var2, Camera var3) {
      this.currentFrame = 0;
      this.textureFrames = var2;
      this.totalFrames = var2.length;
      this.spriteMesh = (Mesh)var1.duplicate();
      this.appearance = this.spriteMesh.getAppearance(0);
      this.appearance.setTexture(0, var2[this.currentFrame]);
      this.camera = var3;
      if (this.camera != null) {
         this.spriteMesh.setAlignment(this.camera, 148, (Node)null, 144);
      }

      this.spriteMesh.setPickingEnable(false);
      this.setActive(false);
   }

   private static VertexBuffer createQuadVertexBuffer() {
      short[] var0 = new short[]{-1, -1, 0, 1, -1, 0, 1, 1, 0, -1, 1, 0};
      VertexArray var1;
      (var1 = new VertexArray(var0.length / 3, 3, 2)).set(0, var0.length / 3, var0);
      short[] var2 = new short[]{0, 1, 1, 1, 1, 0, 0, 0};
      VertexArray var3;
      (var3 = new VertexArray(var2.length / 2, 2, 2)).set(0, var2.length / 2, var2);
      VertexBuffer var4;
      (var4 = new VertexBuffer()).setPositions(var1, 0.25F, (float[])null);
      var4.setTexCoords(0, var3, 1.0F, (float[])null);
      return var4;
   }

   private static Texture2D[] createTexturesFromImages(Image2D[] var0, int var1) {
      Texture2D[] var2 = new Texture2D[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         if (var0[var3] != null) {
            var2[var3] = new Texture2D(var0[var3]);
            var2[var3].setFiltering(210, 210);
            var2[var3].setWrapping(240, 240);
            var2[var3].setBlending(228);
         } else {
            System.out.println("Image " + var3 + " is null");
         }
      }

      return var2;
   }

   private Appearance createTransparentAppearance(Texture2D var1) {
      this.appearance = new Appearance();
      CompositingMode var2;
      (var2 = new CompositingMode()).setBlending(64);
      this.appearance.setCompositingMode(var2);
      this.appearance.setTexture(0, var1);
      return this.appearance;
   }

   public final void setPosition(float var1, float var2, float var3) {
      this.spriteMesh.setTranslation(var1, var2, var3);
   }

   public final void setActive(boolean var1) {
      this.isActive = var1;
      if (this.isActive) {
         this.spriteMesh.setRenderingEnable(true);
         this.currentFrame = 0;
         this.velocity[0] = 0.0F;
         this.velocity[0] = 0.0F;
         this.velocity[0] = 0.0F;
      } else {
         this.spriteMesh.setRenderingEnable(false);
      }
   }

   public final void updateAnimation() {
      if (this.isActive) {
         if (this.camera != null) {
            this.spriteMesh.align(this.camera);
         }

         if (this.currentFrame == this.totalFrames) {
            this.setActive(false);
            return;
         }

         this.appearance.setTexture(0, this.textureFrames[this.currentFrame]);
         ++this.currentFrame;
         if (this.velocity[0] != 0.0F || this.velocity[1] != 0.0F || this.velocity[2] != 0.0F) {
            float[] var1 = new float[3];
            this.spriteMesh.getTranslation(var1);
            float[] var2 = MathUtils.addVectors(var1, this.velocity);
            this.setPosition(var2[0], var2[1], var2[2]);
         }
      }

   }

   public final void setVelocity(float[] var1) {
      System.arraycopy(var1, 0, this.velocity, 0, this.velocity.length);
   }
}
