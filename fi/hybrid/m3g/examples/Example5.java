package fi.hybrid.m3g.examples;

import javax.microedition.m3g.Appearance;
import javax.microedition.m3g.CompositingMode;
import javax.microedition.m3g.Fog;
import javax.microedition.m3g.Graphics3D;
import javax.microedition.m3g.Group;
import javax.microedition.m3g.Image2D;
import javax.microedition.m3g.Material;
import javax.microedition.m3g.Mesh;
import javax.microedition.m3g.Node;
import javax.microedition.m3g.RayIntersection;
import javax.microedition.m3g.Sprite3D;
import javax.microedition.m3g.Transform;
import javax.microedition.m3g.World;

public class Example5 extends ExampleBase {
   private static final String FILE_NAME = "pallot";
   private static final String TEXTURE_NAME = "textures/pukki_small.png";
   private Fog iFog;
   private World iWorld;
   private Appearance iPickedAppearance;
   private Mesh iPointer;
   private Group iAligner;
   private Image2D iImage;
   private Sprite3D iSprite;
   private Group iGroup;
   private Group boxGroup;
   private float[] boxSpeed = new float[]{1.0F, 1.2F, 2.1F};
   private Mesh[] box = new Mesh[3];

   public Example5() {
      super(5);
      this.exampleDescription = "Picking example";
   }

   protected void render(int var1) {
      Node var2 = null;
      Appearance var3 = null;
      RayIntersection var4 = new RayIntersection();
      this.iWorld.pick(-1, this.getMouseX(), this.getMouseY(), this.iWorld.getActiveCamera(), var4);
      if (var4.getIntersected() != null) {
         var2 = var4.getIntersected();
         if (var2 instanceof Mesh) {
            var3 = ((Mesh)var2).getAppearance(0);
            ((Mesh)var2).setAppearance(0, this.iPickedAppearance);
         } else if (var2 == this.iSprite) {
            this.boxGroup.setRenderingEnable(true);
         }

         float[] var5 = new float[6];
         float var6 = var4.getDistance();
         var4.getRay(var5);
         this.iPointer.setTranslation(var5[0] + var5[3] * var6, var5[1] + var5[4] * var6, var5[2] + var5[5] * var6);
         Transform var7 = new Transform();
         var4.getIntersected().getTransformTo(this.iWorld, var7);
         float[] var8 = new float[]{var4.getNormalX(), var4.getNormalY(), var4.getNormalZ(), 0.0F};
         var7.transform(var8);
         this.iAligner.setTranslation(var5[0] + var5[3] * var6 + var8[0], var5[1] + var5[4] * var6 + var8[1], var5[2] + var5[5] * var6 + var8[2]);
         this.iPointer.setRenderingEnable(true);
         Material var9 = this.iPointer.getAppearance(0).getMaterial();
         int var10 = (int)(var4.getTextureS(0) * 256.0F) & 255;
         int var11 = (int)(var4.getTextureT(0) * 256.0F) & 255;
         var9.setColor(1024, -11184811);
         var9.setColor(2048, -16777097 + (var10 << 16) + (var11 << 8));
      } else {
         this.iPointer.setRenderingEnable(false);
      }

      float var12 = (float)var1 * 5.0E-4F;
      float var13 = 100.0F;
      this.iGroup.setTranslation((float)Math.sin((double)var12) * var13, 0.0F, (float)Math.cos((double)var12) * var13);
      float var14 = (float)var1 * 0.003F;
      float var15 = 30.0F;
      this.box[0].setTranslation((float)Math.sin((double)(this.boxSpeed[0] * var14)) * var15, (float)Math.cos((double)(this.boxSpeed[0] * var14)) * var15, 0.0F);
      this.box[1].setTranslation((float)Math.sin((double)(this.boxSpeed[1] * var14)) * var15, 0.0F, (float)Math.cos((double)(this.boxSpeed[1] * var14)) * var15);
      this.box[2].setTranslation(0.0F, (float)Math.sin((double)(this.boxSpeed[2] * var14)) * var15, (float)Math.cos((double)(this.boxSpeed[2] * var14)) * var15);
      this.iWorld.align((Node)null);
      Graphics3D.getInstance().render(this.iWorld);
      if (var2 != null) {
         if (var2 instanceof Mesh) {
            ((Mesh)var2).setAppearance(0, var3);
         } else if (var2 == this.iSprite) {
            this.boxGroup.setRenderingEnable(false);
         }
      }

   }

   private void traverse(Node var1) {
      if (var1 instanceof Mesh) {
         Mesh var2 = (Mesh)var1;

         for(int var3 = 0; var3 < var2.getSubmeshCount(); ++var3) {
            Appearance var4 = var2.getAppearance(var3);
            var4.setFog(this.iFog);
         }
      }

      if (var1 instanceof Group) {
         Group var5 = (Group)var1;

         for(int var6 = 0; var6 < var5.getChildCount(); ++var6) {
            this.traverse(var5.getChild(var6));
         }
      }

   }

   protected void initialize() {
      this.iFog = new Fog();
      this.iFog.setColor(-14663552);
      this.iFog.setMode(81);
      this.iFog.setLinear(170.0F, 320.0F);
      this.iWorld = (World)this.load("pallot")[0];
      this.traverse(this.iWorld);
      Material var1 = new Material();
      var1.setColor(1024, -16777216);
      var1.setColor(2048, -65536);
      this.iPickedAppearance = new Appearance();
      this.iPickedAppearance.setMaterial(var1);
      this.iPickedAppearance.setFog(this.iFog);
      this.iAligner = new Group();
      this.iWorld.addChild(this.iAligner);
      this.iPointer = createBox();
      Transform var2 = new Transform();
      var2.postScale(0.3F, 0.3F, 1.5F);
      var2.postTranslate(0.0F, 0.0F, 10.0F);
      this.iPointer.setTransform(var2);
      this.iPointer.setRenderingEnable(false);
      this.iPointer.setPickingEnable(false);
      this.iPointer.setAlignment(this.iAligner, 145, this.iAligner, 147);
      this.iWorld.addChild(this.iPointer);
      this.iImage = new Image2D(100, this.platformServices.loadImage("textures/pukki_small.png"));
      Appearance var3 = new Appearance();
      var3.setCompositingMode(new CompositingMode());
      var3.getCompositingMode().setAlphaThreshold(0.5F);
      var3.setFog(this.iFog);
      this.iSprite = new Sprite3D(true, this.iImage, var3);
      this.iSprite.setScale(50.0F, 50.0F, 50.0F);
      this.iGroup = new Group();
      this.boxGroup = new Group();
      this.boxGroup.setRenderingEnable(false);
      this.iGroup.addChild(this.iSprite);

      for(int var4 = 0; var4 < this.box.length; ++var4) {
         this.box[var4] = createBox();
         this.box[var4].setScale(0.3F, 0.3F, 0.3F);
         this.box[var4].getAppearance(0).setFog(this.iFog);
         this.box[var4].setPickingEnable(false);
         this.boxGroup.addChild(this.box[var4]);
      }

      this.iGroup.addChild(this.boxGroup);
      this.iWorld.addChild(this.iGroup);
   }
}
