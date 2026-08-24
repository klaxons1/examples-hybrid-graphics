package fi.hybrid.m3g.examples;

import javax.microedition.m3g.AnimationController;
import javax.microedition.m3g.AnimationTrack;
import javax.microedition.m3g.Background;
import javax.microedition.m3g.Camera;
import javax.microedition.m3g.Graphics3D;
import javax.microedition.m3g.KeyframeSequence;
import javax.microedition.m3g.Light;
import javax.microedition.m3g.Mesh;
import javax.microedition.m3g.Node;
import javax.microedition.m3g.World;

public class Example3 extends ExampleBase {
   private World iWorld;

   public Example3() {
      super(1);
      this.exampleDescription = "Rotating cube";
   }

   protected void render(int var1) {
      this.iWorld.animate(var1);
      this.iWorld.align((Node)null);
      Graphics3D.getInstance().render(this.iWorld);
   }

   protected void initialize() {
      this.iWorld = new World();
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
      var5.setTranslation(0.0F, -15.0F, 0.0F);
      var5.setScale(2.0F, 0.1F, 2.0F);
      this.iWorld.addChild(var5);

      for(int var6 = 0; var6 < 1; ++var6) {
         byte var7 = 5;
         short var8 = 3000;
         byte var9 = 4;
         Node var10 = (Node)var1.duplicate();
         var10.setScale(0.2F, 0.2F, 0.2F);
         this.iWorld.addChild(var10);
         KeyframeSequence var11 = new KeyframeSequence(var7, var9, 179);
         var11.setRepeatMode(193);
         var11.setDuration(var8);
         float[] var12 = null;

         for(int var13 = 0; var13 < var7; ++var13) {
            float[] var14 = new float[var9];

            for(int var15 = 0; var15 < var9; ++var15) {
               var14[var15] = ((float)random() - 0.5F) * 30.0F;
            }

            if (var12 != null) {
               float var19 = 0.0F;

               for(int var16 = 0; var16 < var9; ++var16) {
                  var19 += var14[var16] * var12[var16];
               }

               if (var19 < 0.0F) {
                  for(int var20 = 0; var20 < var9; ++var20) {
                     var14[var20] = -var14[var20];
                  }
               }
            }

            var11.setKeyframe(var13, (var13 * 2 + 1) * var8 / (var7 * 2), var14);
            var12 = var14;
         }

         AnimationController var17 = new AnimationController();
         AnimationTrack var18 = new AnimationTrack(var11, 268);
         var18.setController(var17);
         var10.addAnimationTrack(var18);
      }

   }
}
