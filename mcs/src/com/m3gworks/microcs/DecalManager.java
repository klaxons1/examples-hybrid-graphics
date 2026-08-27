package com.m3gworks.microcs; 
import java.util.Vector;
import javax.microedition.m3g.Mesh;
import javax.microedition.m3g.Node;
import javax.microedition.m3g.RayIntersection;
import javax.microedition.m3g.Texture2D;
import javax.microedition.m3g.Transform;
import javax.microedition.m3g.World;

public final class DecalManager {
   private static DecalManager instance;
   private static Mesh decalMesh;
   private static float var_13f = 0.1F;
   private static float var_1a9 = 1.0F;
   private static Texture2D[] var_223;
   private static float[] var_26f = new float[]{0.0F, 0.0F, 1.0F};
   private Vector var_2ea;

   private DecalManager() {
   }

   public static DecalManager sub_42() {
      if (instance == null) {
         instance = new DecalManager();
      }

      return instance;
   }

   public static void sub_76(World var0) {
      String var1 = "/res/image2d/crater";
      StringBuffer var3;
      (var3 = new StringBuffer(var1)).append(0);
      var3.append(".png");
      decalMesh = ResourceLoader.createTexturedQuad(var3.toString(), 160);
      decalMesh.scale(0.5F, 0.5F, 0.5F);
      var_223 = new Texture2D[1];
      var_223[0] = decalMesh.getAppearance(0).getTexture(0);
      boolean var4 = false;
      var0.addChild(decalMesh);
      decalMesh.setPickingEnable(false);
      Transform var6 = new Transform();
      decalMesh.getTransformTo(var0, var6);
      var0.removeChild(decalMesh);
      float[] var5 = new float[]{0.0F, 0.0F, 1.0F, 0.0F};
      var6.transform(var5);
      var_26f[0] = var5[0];
      var_26f[1] = var5[1];
      var_26f[2] = var5[2];
   }

   public final void sub_c1(int var1, RayIntersection var2, World var3) {
      float var4 = var2.getDistance();
      float[] var8 = new float[6];
      var2.getRay(var8);
      float var5 = var8[0] + var8[3] * var4;
      float var6 = var8[1] + var8[4] * var4;
      float var7 = var8[2] + var8[5] * var4;
      float var9 = var2.getNormalX();
      float var10 = var2.getNormalY();
      float var11 = var2.getNormalZ();
      Node var12 = var2.getIntersected();
      Transform var13 = new Transform();
      var12.getTransformTo(var3, var13);
      float[] var14 = new float[]{var9, var10, var11, 0.0F};
      var13.transform(var14);
      float[] var15;
      (var15 = new float[3])[0] = var14[0];
      var15[1] = var14[1];
      var15[2] = var14[2];
      float[] var16 = new float[]{var8[3], var8[4], var8[5]};
      if (MathUtils.dotProduct(var15, var16) > 0.0F) {
         var15[0] = -var15[0];
         var15[1] = -var15[1];
         var15[2] = -var15[2];
      }

      float var19 = (float)Math.toDegrees((double)((float) MathUtilsArcSin.asin((double) MathUtils.dotProduct(var_26f, var15) / (Math.sqrt((double)(var_26f[0] * var_26f[0] + var_26f[1] * var_26f[1] + var_26f[2] * var_26f[2])) * Math.sqrt((double)(var15[0] * var15[0] + var15[1] * var15[1] + var15[2] * var15[2]))))));
      float[] var20;
      if ((var20 = MathUtils.crossProduct(var_26f, var15))[0] == 0.0F && var20[1] == 0.0F && var20[2] == 0.0F) {
         var20[1] = 1.0F;
      }

      float var21 = var_13f;
      if (var1 == 2) {
         var21 = var_1a9;
      }

      Mesh var22;
      (var22 = (Mesh) decalMesh.duplicate()).setTranslation(var5, var6, var7);
      var22.setScale(var21, var21, var21);
      if (var20[0] != 0.0F || var20[1] != 0.0F || var20[2] != 0.0F) {
         var22.postRotate(var19, var20[0], var20[1], var20[2]);
      }

      var3.addChild(var22);
      if (this.var_2ea == null) {
         this.var_2ea = new Vector();
      }

      this.var_2ea.addElement(var22);
   }

   public final void sub_106(World var1) {
      if (this.var_2ea != null) {
         for(int var2 = 0; var2 < this.var_2ea.size(); ++var2) {
            Mesh var3 = (Mesh)this.var_2ea.elementAt(var2);
            var1.removeChild(var3);
         }
      }

      this.var_2ea = null;
      this.var_2ea = new Vector();
   }

   public final void sub_112() {
      this.var_2ea = null;
   }

   public static void sub_173() {
      decalMesh = null;
      var_223 = null;
      var_26f = null;
   }
}
