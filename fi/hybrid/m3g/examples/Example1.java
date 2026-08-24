package fi.hybrid.m3g.examples;

import java.util.Vector;
import javax.microedition.m3g.Background;
import javax.microedition.m3g.Camera;
import javax.microedition.m3g.Graphics3D;
import javax.microedition.m3g.Group;
import javax.microedition.m3g.Light;
import javax.microedition.m3g.Mesh;
import javax.microedition.m3g.Node;
import javax.microedition.m3g.World;

public class Example1 extends ExampleBase {
   private World iWorld;
   private Vector iNodes;
   private Vector iAxis;

   public Example1() {
      super(1);
      this.exampleDescription = "Scene graph fractals";
   }

   protected void render(int var1) {
      float var2 = (float)var1 * 0.1F;

      for(int var3 = 0; var3 < this.iNodes.size(); ++var3) {
         Node var4 = (Node)this.iNodes.elementAt(var3);
         float[] var5 = (float[])this.iAxis.elementAt(var3);
         var4.setOrientation(var2 * var5[3], var5[0], var5[1], var5[2]);
      }

      this.iWorld.align((Node)null);
      Graphics3D.getInstance().render(this.iWorld);
   }

   protected void initialize() {
      this.iWorld = new World();
      this.iNodes = new Vector();
      this.iAxis = new Vector();
      Mesh var1 = createBox();
      Background var2 = new Background();
      var2.setColor(-14663552);
      this.iWorld.setBackground(var2);
      Camera var3 = new Camera();
      var3.setPerspective(90.0F, 1.0F, 1.0F, 100.0F);
      var3.setTranslation(0.0F, 0.0F, 30.0F);
      this.iWorld.addChild(var3);
      this.iWorld.setActiveCamera(var3);
      Light var4 = new Light();
      var4.setTranslation(0.0F, 0.0F, 30.0F);
      this.iWorld.addChild(var4);
      Node var5 = (Node)var1.duplicate();
      var5.setTranslation(0.0F, -20.0F, 0.0F);
      var5.setScale(2.0F, 0.1F, 2.0F);
      this.iWorld.addChild(var5);
      Node var6 = this.createRecursive(var1, 6);
      this.iWorld.addChild(var6);

      Node var7;
      for(var7 = var6; var7 instanceof Group; var7 = ((Group)var7).getChild((int)(random() * (double)2.0F))) {
      }

      var7.scale(3.0F, 3.0F, 3.0F);
      var3.setScale(-1.0F, 1.0F, -1.0F);
      var3.setAlignment(var7, 145, this.iWorld, 147);
   }

   private Node createRecursive(Mesh var1, int var2) {
      float var3 = 0.7F;
      float var4 = 8.0F;
      Object var5;
      if (var2 == 0) {
         var5 = (Node)var1.duplicate();
      } else {
         Node var6 = this.createRecursive(var1, var2 - 1);
         Node var7 = this.createRecursive(var1, var2 - 1);
         var6.translate(-var4, 0.0F, 0.0F);
         var6.scale(var3, var3, var3);
         var7.translate(var4, 0.0F, 0.0F);
         var7.scale(var3, var3, var3);
         Group var8 = new Group();
         var8.addChild(var6);
         var8.addChild(var7);
         var5 = var8;
      }

      this.iNodes.addElement(var5);
      float[] var9 = new float[]{(float)random() - 0.5F, (float)random() - 0.5F, (float)random() - 0.5F, (float)random()};
      this.iAxis.addElement(var9);
      return (Node)var5;
   }
}
