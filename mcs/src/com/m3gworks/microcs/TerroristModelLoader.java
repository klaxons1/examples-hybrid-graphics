package com.m3gworks.microcs; 
import java.io.IOException;
import javax.microedition.m3g.Group;
import javax.microedition.m3g.Loader;
import javax.microedition.m3g.Mesh;
import javax.microedition.m3g.Node;
import javax.microedition.m3g.Object3D;
import javax.microedition.m3g.SkinnedMesh;
import javax.microedition.m3g.Transform;
import javax.microedition.m3g.World;

public final class TerroristModelLoader extends Model3D {
   public Group var_68;
   public Group var_cf;
   public Group var_158;
   public Group var_1d0;
   public static float[] var_25d;
   public static float[] var_27b;
   private static Model3D var_290;
   public static final int[][] var_2ca = new int[][]{{9, 6}, {0, 9}, {0, 9}, {0, 9}, {0, 9}};

   public TerroristModelLoader(GameEntity var1) {
      super(var1);
   }

   public final Node createModel(World var1) {
      Object3D[] var2 = (Object3D[])null;

      try {
         String var3 = "/res/role/terrorist.m3g";
         var2 = Loader.load("/res/role/terrorist.m3g");
      } catch (IOException var7) {
         var7.printStackTrace();
      }

      World var8 = null;

      for(int var4 = 0; var4 < var2.length; ++var4) {
         if (var2[var4] instanceof World) {
            var8 = (World)var2[var4];
         }
      }

      super.meshNode = (Mesh)var8.find(87);
      var8.removeChild(super.meshNode);
      if (var_290 != null) {
         Model3D.copyMeshData((Mesh)var_290.meshNode, (Mesh)super.meshNode);
      }

      Group var9 = ((SkinnedMesh)super.meshNode).getSkeleton();
      this.var_68 = (Group)var9.find(77);
      this.var_cf = (Group)var9.find(76);
      this.var_158 = (Group)var9.find(75);
      this.var_1d0 = (Group)var9.find(70);
      var1.addChild(super.meshNode);
      Transform var5 = new Transform();
      var1.getTransformTo(super.meshNode, var5);
      float[] var6 = new float[]{0.0F, 1.0F, 0.0F, 0.0F};
      var5.transform(var6);
      super.meshNode.postRotate(180.0F, var6[0], var6[1], var6[2]);
      if (var_290 == null) {
         this.sub_4f(var1);
         var_290 = this;
      }

      super.rootNode = super.meshNode;
      return super.meshNode;
   }

   public final void cleanUp() {
      super.cleanUp();
      this.var_68 = null;
      this.var_cf = null;
      this.var_158 = null;
      this.var_1d0 = null;
      var_290 = null;
   }

   private void sub_4f(World var1) {
      Transform var2 = new Transform();
      var1.getTransformTo(this.var_158, var2);
      float[] var3 = new float[]{1.0F, 0.0F, 0.0F, 0.0F};
      var2.transform(var3);
      var_25d = new float[3];
      var_25d[0] = var3[0];
      var_25d[1] = var3[1];
      var_25d[2] = var3[2];
      float[] var4 = new float[]{0.0F, 1.0F, 0.0F, 0.0F};
      var2.transform(var4);
      var_27b = new float[3];
      var_27b[0] = var4[0];
      var_27b[1] = var4[1];
      var_27b[2] = var4[2];
   }
}
