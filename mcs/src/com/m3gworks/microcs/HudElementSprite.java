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

public final class HudElementSprite {
   public Mesh var_53;
   private Camera var_6d;

   public HudElementSprite(Image2D var1, Camera var2, float var3, float var4, float var5, float var6) {
      this.var_6d = var2;
      VertexBuffer var7 = sub_30();
      int[] var8 = new int[]{1, 2, 0, 3};
      int[] var9 = new int[]{4};
      TriangleStripArray var10 = new TriangleStripArray(var8, var9);
      Appearance var11 = sub_75(var1);
      this.var_53 = new Mesh(var7, var10, var11);
      float var12 = var6 * 0.5F;
      this.var_53.scale(var12, var12, var12);
      this.var_53.setTranslation(var3, var4, var5);
      this.var_53.setAlignment(this.var_6d, 148, (Node)null, 144);
   }

   private static VertexBuffer sub_30() {
      short[] var0 = new short[]{-1, -1, 0, 1, -1, 0, 1, 1, 0, -1, 1, 0};
      VertexArray var1;
      (var1 = new VertexArray(var0.length / 3, 3, 2)).set(0, var0.length / 3, var0);
      short[] var2 = new short[]{0, 1, 1, 1, 1, 0, 0, 0};
      VertexArray var3;
      (var3 = new VertexArray(var2.length / 2, 2, 2)).set(0, var2.length / 2, var2);
      VertexBuffer var4;
      (var4 = new VertexBuffer()).setPositions(var1, 1.0F, (float[])null);
      var4.setTexCoords(0, var3, 1.0F, (float[])null);
      return var4;
   }

   private static Appearance sub_75(Image2D var0) {
      Appearance var1 = new Appearance();
      CompositingMode var2;
      (var2 = new CompositingMode()).setBlending(64);
      var1.setCompositingMode(var2);
      if (var0 != null) {
         Texture2D var3;
         (var3 = new Texture2D(var0)).setFiltering(210, 210);
         var3.setWrapping(240, 240);
         var3.setBlending(228);
         var1.setTexture(0, var3);
      }

      return var1;
   }

   public final void sub_9e() {
      this.var_53.align(this.var_6d);
   }
}
