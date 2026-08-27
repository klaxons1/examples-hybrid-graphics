package com.m3gworks.microcs; 
import java.io.IOException;
import javax.microedition.lcdui.Image;
import javax.microedition.m3g.Appearance;
import javax.microedition.m3g.CompositingMode;
import javax.microedition.m3g.Group;
import javax.microedition.m3g.Image2D;
import javax.microedition.m3g.Loader;
import javax.microedition.m3g.Mesh;
import javax.microedition.m3g.PolygonMode;
import javax.microedition.m3g.Texture2D;
import javax.microedition.m3g.Transform;
import javax.microedition.m3g.TriangleStripArray;
import javax.microedition.m3g.VertexArray;
import javax.microedition.m3g.VertexBuffer;

public final class ResourceLoader {
   public static Image2D loadImage2DFromFile(String var0) {
      Image2D var1 = null;

      try {
         var1 = (Image2D)Loader.load(var0)[0];
      } catch (Exception var2) {
         System.out.println("Cannot make image from " + var0);
      }

      return var1;
   }

   public static Image2D[] loadSpriteSheet(String var0, int var1, int var2) {
      Image2D[] var3 = new Image2D[var1];

      try {
         Image var4 = Image.createImage(var0);

         for(int var5 = 0; var5 < var1; ++var5) {
            Image var6 = Image.createImage(var4, var5 * var2, 0, var2, var2, 0);
            var3[var5] = new Image2D(100, var6);
         }
      } catch (IOException var7) {
         var7.printStackTrace();
      }

      return var3;
   }

   public static Image2D[] loadSpriteSheetWithImages(String var0, int var1, int var2, Image[] var3) {
      Image2D[] var4 = new Image2D[var1];

      try {
         Image var5 = Image.createImage(var0);

         for(int var6 = 0; var6 < var1; ++var6) {
            var3[var6] = Image.createImage(var5, var6 * var2, 0, var2, var2, 0);
            var4[var6] = new Image2D(100, var3[var6]);
         }
      } catch (IOException var7) {
         var7.printStackTrace();
      }

      return var4;
   }

   public static Image2D createImage2D(String var0) {
      Object var1 = null;
      Image var2 = null;

      try {
         var2 = Image.createImage(var0);
      } catch (IOException var4) {
         var4.printStackTrace();
      }

      return new Image2D(100, var2);
   }

   public static Mesh createTexturedQuad(String var0, int var1) {
      short[] var2 = new short[]{-1, -1, 0, 1, -1, 0, 1, 1, 0, -1, 1, 0};
      short[] var3 = new short[]{0, 255, 255, 255, 255, 0, 0, 0};
      VertexArray var4;
      (var4 = new VertexArray(var2.length / 3, 3, 2)).set(0, var2.length / 3, var2);
      VertexArray var5;
      (var5 = new VertexArray(var3.length / 2, 2, 2)).set(0, var3.length / 2, var3);
      VertexBuffer var7;
      (var7 = new VertexBuffer()).setPositions(var4, 1.0F, (float[])null);
      var7.setTexCoords(0, var5, 0.003921569F, (float[])null);
      int[] var8 = new int[]{0, 1, 3, 2};
      int[] var9 = new int[]{4};
      TriangleStripArray var6 = new TriangleStripArray(var8, var9);
      Appearance var10 = new Appearance();
      PolygonMode var11;
      (var11 = new PolygonMode()).setCulling(var1);
      var10.setPolygonMode(var11);
      CompositingMode var12;
      (var12 = new CompositingMode()).setBlending(64);
      var10.setCompositingMode(var12);

      try {
         Texture2D var13;
         (var13 = new Texture2D(createImage2D(var0))).setBlending(228);
         var13.setWrapping(240, 240);
         var13.setFiltering(210, 210);
         var10.setTexture(0, var13);
      } catch (Exception var14) {
         System.out.println(var14);
      }

      return new Mesh(var7, var6, var10);
   }

   public static float[] getTransformedVertices(Mesh var0, Group var1) {
      Transform var2;
      (var2 = new Transform()).setIdentity();
      float[] var3 = new float[4];
      VertexArray var4 = var0.getVertexBuffer().getPositions(var3);
      float[] var6 = new float[var0.getVertexBuffer().getVertexCount() * 4];
      var2.transform(var4, var6, false);
      float var7 = var3[0];
      float var8 = var3[1];
      float var9 = var3[2];
      float var10 = var3[3];

      for(int var11 = 0; var11 < var6.length; ++var11) {
         var6[var11] *= var7;
         if (var11 % 4 == 0) {
            var6[var11] += var8;
         }

         if (var11 % 4 == 1) {
            var6[var11] += var9;
         }

         if (var11 % 4 == 2) {
            var6[var11] += var10;
         }
      }

      Transform var15;
      (var15 = new Transform()).setIdentity();
      var0.getTransformTo(var1, var15);
      float[] var12 = new float[16];
      var15.get(var12);
      float[] var13 = new float[3];
      var0.getTranslation(var13);
      var15.transform(var6);

      for(int var14 = 0; var14 < var6.length; ++var14) {
         if (var14 % 4 == 0) {
            var6[var14] += var13[0];
         }

         if (var14 % 4 == 1) {
            var6[var14] += var13[1];
         }

         if (var14 % 4 == 2) {
            var6[var14] += var13[2];
         }
      }

      return var6;
   }
}
