package com.m3gworks.microcs; 
import javax.microedition.m3g.Appearance;
import javax.microedition.m3g.Mesh;
import javax.microedition.m3g.Node;
import javax.microedition.m3g.VertexArray;
import javax.microedition.m3g.World;

public abstract class Model3D {
   public Node rootNode;
   public Node meshNode;

   public Model3D() {
   }

   public Model3D(GameEntity var1) {
   }

   public abstract Node createModel(World var1);

   public void cleanUp() {
      this.rootNode = null;
      this.meshNode = null;
   }

   public static void copyMeshData(Mesh var0, Mesh var1) {
      var1.setAppearance(0, (Appearance)null);
      var1.setAppearance(0, var0.getAppearance(0));
      VertexArray var2 = var0.getVertexBuffer().getNormals();
      var1.getVertexBuffer().setNormals(var2);
      float[] var3 = new float[4];
      VertexArray var4 = var0.getVertexBuffer().getPositions(var3);
      float[] var5 = new float[]{var3[1], var3[2], var3[3]};
      var1.getVertexBuffer().setPositions(var4, var3[0], var5);
      VertexArray var6 = var0.getVertexBuffer().getTexCoords(0, var3);
      var5[0] = var3[1];
      var5[1] = var3[2];
      var5[2] = var3[3];
      var1.getVertexBuffer().setTexCoords(0, var6, var3[0], var5);
   }

   public final void setVisible(boolean var1) {
      this.rootNode.setRenderingEnable(var1);
   }
}
