package fi.hybrid.m3g.examples;

import javax.microedition.m3g.Appearance;
import javax.microedition.m3g.Background;
import javax.microedition.m3g.Camera;
import javax.microedition.m3g.Graphics3D;
import javax.microedition.m3g.Light;
import javax.microedition.m3g.Material;
import javax.microedition.m3g.MorphingMesh;
import javax.microedition.m3g.PolygonMode;
import javax.microedition.m3g.Transform;
import javax.microedition.m3g.TriangleStripArray;
import javax.microedition.m3g.VertexArray;
import javax.microedition.m3g.VertexBuffer;

public class Example8 extends ExampleBase {
   private MorphingMesh iMorphingMesh;
   private Light iLight;
   private Camera iCamera;
   private Transform trans;
   private Transform iLightTrans;
   private float[] iWeights;

   public Example8() {
      super(1);
      this.exampleDescription = "Morphing example";
      this.trans = new Transform();
      this.iWeights = new float[2];
   }

   protected void render(int var1) {
      Background var2 = new Background();
      var2.setColor(-12566459);
      var2.setDepthClearEnable(true);
      Graphics3D.getInstance().clear(var2);
      Graphics3D.getInstance().resetLights();
      Graphics3D.getInstance().addLight(this.iLight, this.iLightTrans);

      for(int var3 = 0; var3 < this.iWeights.length; ++var3) {
         int var4 = 2000 * (var3 + 1);
         this.iWeights[var3] = (float)Math.sin((double)((float)(var1 % var4) / (float)var4) * Math.PI);
      }

      this.iMorphingMesh.setWeights(this.iWeights);
      Graphics3D.getInstance().render(this.iMorphingMesh, this.trans);
   }

   protected void initialize() {
      VertexArray var1 = new VertexArray(6, 3, 1);
      var1.set(0, 6, new byte[]{0, 0, -127, 0, 0, -127, 0, 0, -127, 0, 0, -127, 0, 0, -127, 0, 0, -127});
      VertexArray var2 = new VertexArray(6, 3, 2);
      var2.set(0, 6, new short[]{-100, -100, 0, 100, -100, 0, 100, 0, 0, 100, 100, 0, -100, 100, 0, -100, 0, 0});
      VertexArray[] var3 = new VertexArray[2];

      for(int var4 = 0; var4 < var3.length; ++var4) {
         var3[var4] = new VertexArray(6, 3, 2);
         var3[var4].set(0, 6, new short[]{-100, -100, 0, 100, -100, 0, (short)(50 * (1 - var4) + 100), 0, 0, 100, 100, 0, -100, 100, 0, (short)(-50 * var4 - 100), 0, 0});
      }

      TriangleStripArray var11 = new TriangleStripArray(new int[]{1, 0, 2, 5, 3, 4}, new int[]{6});
      VertexBuffer var5 = new VertexBuffer();
      var5.setPositions(var2, 0.1F, (float[])null);
      var5.setNormals(var1);
      var5.setDefaultColor(-16023604);
      VertexBuffer[] var6 = new VertexBuffer[2];

      for(int var7 = 0; var7 < var6.length; ++var7) {
         var6[var7] = new VertexBuffer();
         var6[var7].setPositions(var3[var7], 1.0F, (float[])null);
         if (var7 == 0) {
            var6[var7].setDefaultColor(-65536);
         } else {
            var6[var7].setDefaultColor(-16023604);
         }
      }

      Material var12 = new Material();
      var12.setVertexColorTrackingEnable(true);
      PolygonMode var8 = new PolygonMode();
      var8.setCulling(162);
      var8.setTwoSidedLightingEnable(true);
      Appearance var9 = new Appearance();
      var9.setMaterial(var12);
      var9.setPolygonMode(var8);
      this.iMorphingMesh = new MorphingMesh(var5, var6, var11, var9);
      this.iLight = new Light();
      this.iLight.setMode(129);
      this.iLight.setIntensity(0.7F);
      this.iLight.setColor(16777215);
      this.iLightTrans = new Transform();
      this.iLightTrans.postTranslate(-10.0F, -10.0F, 6.0F);
      this.iCamera = new Camera();
      this.iCamera.setPerspective(90.0F, 1.0F, 1.0F, 150.0F);
      Transform var10 = new Transform();
      var10.postTranslate(0.0F, 0.0F, 26.0F);
      Graphics3D.getInstance().setCamera(this.iCamera, var10);
   }
}
