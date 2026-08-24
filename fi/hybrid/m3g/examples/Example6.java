package fi.hybrid.m3g.examples;

import java.io.IOException;
import javax.microedition.m3g.Appearance;
import javax.microedition.m3g.Background;
import javax.microedition.m3g.Camera;
import javax.microedition.m3g.CompositingMode;
import javax.microedition.m3g.Graphics3D;
import javax.microedition.m3g.Image2D;
import javax.microedition.m3g.Light;
import javax.microedition.m3g.Loader;
import javax.microedition.m3g.Mesh;
import javax.microedition.m3g.PolygonMode;
import javax.microedition.m3g.Sprite3D;
import javax.microedition.m3g.World;

public class Example6 extends ExampleBase {
   private static final String TEXTURE_NAME = "textures/pukki_small_cg2.png";
   private World iWorld;
   private Background iBackground;
   private Mesh iMesh;
   private Sprite3D iSprite;
   private Image2D iImage;

   public Example6() {
      super(1);
      this.exampleDescription = "Sprite example";
   }

   protected void render(int var1) {
      this.iMesh.setOrientation((float)var1 * 0.15F, 0.0F, 1.0F, 0.0F);
      this.iMesh.preRotate((float)var1 * 0.01F, 1.0F, 0.0F, 0.0F);
      double var2 = Math.tan((double)((1.0F - (float)Math.cos((double)((float)var1 * 5.0E-4F))) * 0.5F));
      this.iSprite.setTranslation(0.0F, 0.0F, (float)(var2 * var2 * var2) * -100.0F + 30.0F);
      Graphics3D.getInstance().render(this.iWorld);
   }

   protected void initialize() {
      this.iWorld = new World();
      Mesh var1 = createBox();
      Camera var2 = new Camera();
      var2.setPerspective(70.0F, 1.0F, 1.0F, 10000.0F);
      var2.setTranslation(0.0F, 0.0F, 40.0F);
      this.iWorld.addChild(var2);
      this.iWorld.setActiveCamera(var2);
      Light var3 = new Light();
      var3.setTranslation(0.0F, 0.0F, 40.0F);
      this.iWorld.addChild(var3);

      try {
         this.iImage = (Image2D)Loader.load(this.platformServices.getResourceDir() + "textures/pukki_small_cg2.png")[0];
      } catch (IOException var7) {
         System.out.println("IOException: \"" + var7.getMessage() + "\".");
      }

      this.iMesh = (Mesh)var1.duplicate();
      Appearance var4 = new Appearance();
      CompositingMode var5 = new CompositingMode();
      var4.setCompositingMode(var5);
      var4.getCompositingMode().setAlphaThreshold(0.5F);
      PolygonMode var6 = new PolygonMode();
      var6.setPerspectiveCorrectionEnable(true);
      var4.setPolygonMode(var6);
      this.iMesh.setAppearance(0, var4);
      this.iMesh.setScale(0.3F, 0.3F, 0.3F);
      this.iBackground = new Background();
      this.iBackground.setColor(-14663552);
      this.iWorld.setBackground(this.iBackground);
      this.iSprite = new Sprite3D(true, this.iImage, var4);
      this.iSprite.setScale(20.0F, 20.0F, 20.0F);
      this.iWorld.addChild(this.iSprite);
   }
}
