package fi.hybrid.m3g.examples;

import java.util.Vector;
import javax.microedition.m3g.AnimationController;
import javax.microedition.m3g.AnimationTrack;
import javax.microedition.m3g.Background;
import javax.microedition.m3g.Camera;
import javax.microedition.m3g.Graphics3D;
import javax.microedition.m3g.Group;
import javax.microedition.m3g.Image2D;
import javax.microedition.m3g.KeyframeSequence;
import javax.microedition.m3g.Light;
import javax.microedition.m3g.Mesh;
import javax.microedition.m3g.Node;
import javax.microedition.m3g.World;

public class Example2 extends ExampleBase {
   private static final String BACKGROUND_TEXTURE = "textures/pukki_small_cg2.png";
   private World iWorld;
   private Vector iNodes;
   private Vector iAxis;

   public Example2() {
      super(1);
      this.exampleDescription = "Scene graph fractals with animated background";
   }

   protected void render(int var1) {
      this.iWorld.animate(var1);
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
      Image2D var3 = new Image2D(99, this.platformServices.loadImage("textures/pukki_small_cg2.png"));
      var2.setColor(-14663552);
      var2.setImage(var3);
      var2.setImageMode(32, 32);
      byte var4 = 16;
      var2.setCrop(-var4, -var4, 64 + 2 * var4, 64 + 2 * var4);
      this.iWorld.setBackground(var2);
      Camera var5 = new Camera();
      var5.setPerspective(90.0F, 1.0F, 1.0F, 100.0F);
      var5.setTranslation(0.0F, 0.0F, 30.0F);
      this.iWorld.addChild(var5);
      this.iWorld.setActiveCamera(var5);
      Light var6 = new Light();
      var6.setTranslation(0.0F, 0.0F, 30.0F);
      this.iWorld.addChild(var6);
      Node var7 = (Node)var1.duplicate();
      var7.setTranslation(0.0F, -20.0F, 0.0F);
      var7.setScale(2.0F, 0.1F, 2.0F);
      this.iWorld.addChild(var7);
      Node var8 = this.createRecursive(var1, 5);
      this.iWorld.addChild(var8);

      Node var9;
      for(var9 = var8; var9 instanceof Group; var9 = ((Group)var9).getChild((int)(random() * (double)2.0F))) {
      }

      var9.scale(3.0F, 3.0F, 3.0F);
      var5.setScale(-1.0F, 1.0F, -1.0F);
      var5.setAlignment(var9, 145, this.iWorld, 147);

      for(int var10 = 0; var10 < 1; ++var10) {
         byte var11 = 4;
         short var12 = 5000;
         byte var13 = 4;
         KeyframeSequence var14 = new KeyframeSequence(var11, var13, 178);
         var14.setRepeatMode(193);
         var14.setDuration(var12);
         byte var15 = 1;
         byte var16 = 1;
         float[] var17 = new float[var13];
         var17[2] = (float)(80 * var15);
         var17[3] = (float)(80 * var15);
         var17[0] = (float)(-50 * var16);
         var17[1] = (float)(-50 * var16);
         var14.setKeyframe(0, 1 * var12 / (var11 * 2), var17);
         var17[0] = (float)(10 * var16);
         var17[1] = (float)(-50 * var16);
         var14.setKeyframe(1, 3 * var12 / (var11 * 2), var17);
         var17[0] = (float)(10 * var16);
         var17[1] = (float)(10 * var16);
         var14.setKeyframe(2, 5 * var12 / (var11 * 2), var17);
         var17[0] = (float)(-50 * var16);
         var17[1] = (float)(10 * var16);
         var14.setKeyframe(3, 7 * var12 / (var11 * 2), var17);
         AnimationController var18 = new AnimationController();
         AnimationTrack var19 = new AnimationTrack(var14, 259);
         var19.setController(var18);
         var2.addAnimationTrack(var19);
      }

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
