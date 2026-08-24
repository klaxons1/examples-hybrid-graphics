package fi.hybrid.m3g.examples;

import javax.microedition.m3g.Graphics3D;
import javax.microedition.m3g.Light;
import javax.microedition.m3g.Node;
import javax.microedition.m3g.Transform;
import javax.microedition.m3g.World;

public class Example7 extends ExampleBase {
   private static final String FILE_NAME = "pallot";
   private Light iLight0;
   private World iWorld;

   public Example7() {
      super(1);
      this.exampleDescription = "Light example";
      this.iWorld = null;
   }

   protected void render(int var1) {
      Transform var2 = new Transform();
      var2.postRotate((float)var1 / 10.0F, 0.0F, 1.0F, 0.0F);
      this.iLight0.setTransform(var2);
      Graphics3D.getInstance().render(this.iWorld);
   }

   protected void initialize() {
      this.iWorld = (World)this.load("pallot")[0];
      this.iLight0 = new Light();
      this.iLight0.setMode(129);
      this.iWorld.addChild(this.iLight0);
      this.iWorld.align((Node)null);
   }
}
