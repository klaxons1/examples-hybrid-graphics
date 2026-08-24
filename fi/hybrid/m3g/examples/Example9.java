package fi.hybrid.m3g.examples;

import javax.microedition.m3g.Appearance;
import javax.microedition.m3g.Background;
import javax.microedition.m3g.Camera;
import javax.microedition.m3g.Graphics3D;
import javax.microedition.m3g.Group;
import javax.microedition.m3g.Light;
import javax.microedition.m3g.Material;
import javax.microedition.m3g.Node;
import javax.microedition.m3g.PolygonMode;
import javax.microedition.m3g.RayIntersection;
import javax.microedition.m3g.SkinnedMesh;
import javax.microedition.m3g.Transform;
import javax.microedition.m3g.TriangleStripArray;
import javax.microedition.m3g.VertexArray;
import javax.microedition.m3g.VertexBuffer;
import javax.microedition.m3g.World;

public class Example9 extends ExampleBase {
   private World iWorld;
   private SkinnedMesh iSkinnedMesh;
   private Light iLight;
   private Camera iCamera;
   private Background iBack;
   private int iCurrentFrame;
   private Appearance normalAppearance;
   private Appearance pickedAppearance;
   private Transform trans;
   private Transform iLightTrans;
   private Transform bone1Trans;
   private Transform bone2Trans;
   private Group bone1;
   private Group bone2;

   public Example9() {
      super(5);
      this.exampleDescription = "Skinning example";
      this.iCurrentFrame = 0;
      this.trans = new Transform();
      this.bone2Trans = new Transform();
      this.bone1Trans = new Transform();
   }

   protected void render(int var1) {
      Node var2 = null;
      RayIntersection var3 = new RayIntersection();
      float var4 = this.getMouseX();
      float var5 = this.getMouseY();
      this.iWorld.pick(-1, var4, var5, this.iWorld.getActiveCamera(), var3);
      var2 = var3.getIntersected();
      if (var4 > 0.0F && var5 > 0.0F && var2 != null && var2 instanceof SkinnedMesh) {
         this.iSkinnedMesh.setAppearance(0, this.pickedAppearance);
      } else {
         this.iSkinnedMesh.setAppearance(0, this.normalAppearance);
      }

      this.bone1Trans.setIdentity();
      this.bone1Trans.postTranslate(0.0F, 9.0F, 0.0F);
      this.bone1Trans.postRotate((float)Math.sin((double)this.iCurrentFrame / (double)30.0F * Math.PI * (double)2.0F) * 40.0F, 0.0F, 0.0F, 1.0F);
      this.bone1Trans.postTranslate(0.0F, -9.0F, 0.0F);
      this.bone1.setTransform(this.bone1Trans);
      this.bone2Trans.setIdentity();
      this.bone2Trans.postTranslate(0.0F, -9.0F, 0.0F);
      this.bone2Trans.postRotate((float)Math.sin((double)this.iCurrentFrame / (double)60.0F * Math.PI * (double)2.0F) * 40.0F, 0.0F, 0.0F, 1.0F);
      this.bone2Trans.postTranslate(0.0F, 9.0F, 0.0F);
      this.bone2.setTransform(this.bone2Trans);
      this.trans.postRotate(2.0F, 0.0F, 1.0F, 0.0F);
      Graphics3D.getInstance().render(this.iWorld);
      if ((this.iCurrentFrame + 15) % 30 == 0) {
         this.iWorld = (World)this.iWorld.duplicate();
         this.iWorld.setBackground(this.iBack);
         this.iSkinnedMesh = (SkinnedMesh)this.iWorld.getChild(0);
         this.bone1 = (Group)this.iSkinnedMesh.getSkeleton().getChild(0);
         this.bone2 = (Group)this.bone1.getChild(0);
      }

      ++this.iCurrentFrame;
   }

   protected void initialize() {
      this.iWorld = new World();
      byte var1 = 8;
      short[] var2 = new short[var1 * 8 * 3 * 3];
      short[] var3 = new short[var1 * 8 * 3 * 3];

      for(int var4 = 0; var4 < 24; ++var4) {
         for(int var5 = 0; var5 < var1; ++var5) {
            var2[3 * (var4 * var1 + var5)] = (short)((int)((double)100.0F * Math.sin((Math.PI * 2D) * (double)((float)var5 / (float)var1))));
            var2[3 * (var4 * var1 + var5) + 1] = (short)(-50 * var4 + 600);
            var2[3 * (var4 * var1 + var5) + 2] = (short)((int)((double)100.0F * Math.cos((Math.PI * 2D) * (double)((float)var5 / (float)var1))));
            var3[3 * (var4 * var1 + var5)] = (short)((int)((double)-100.0F * Math.sin((Math.PI * 2D) * (double)((float)var5 / (float)var1))));
            var3[3 * (var4 * var1 + var5) + 1] = 0;
            var3[3 * (var4 * var1 + var5) + 2] = (short)((int)((double)-100.0F * Math.cos((Math.PI * 2D) * (double)((float)var5 / (float)var1))));
         }
      }

      VertexArray var15 = new VertexArray(24 * var1, 3, 2);
      var15.set(0, 24 * var1, var3);
      VertexArray var16 = new VertexArray(24 * var1, 3, 2);
      var16.set(0, 24 * var1, var2);
      int[] var6 = new int[23 * (2 * var1 + 2)];
      int[] var7 = new int[23];

      for(int var8 = 0; var8 < 23; ++var8) {
         var6[var8 * (2 * var1 + 2)] = var8 * var1;

         for(int var9 = 1; var9 < var1 + 1; ++var9) {
            var6[var8 * (2 * var1 + 2) + var9 * 2 - 1] = var9 % var1 + var8 * var1;
            var6[var8 * (2 * var1 + 2) + var9 * 2] = var9 % var1 + (var8 + 1) * var1;
         }

         var6[var8 * (2 * var1 + 2) + var1 * 2 + 1] = (var8 + 1) * var1 + 1;
         var7[var8] = 2 * var1 + 2;
      }

      TriangleStripArray var17 = new TriangleStripArray(var6, var7);
      VertexBuffer var18 = new VertexBuffer();
      var18.setPositions(var16, 0.03F, (float[])null);
      var18.setNormals(var15);
      var18.setDefaultColor(-16023604);
      Material var10 = new Material();
      var10.setColor(1024, 1197975);
      var10.setColor(2048, -16023604);
      Material var11 = new Material();
      var11.setColor(1024, -65536);
      var11.setColor(2048, -3407872);
      PolygonMode var12 = new PolygonMode();
      var12.setCulling(162);
      var12.setTwoSidedLightingEnable(true);
      this.normalAppearance = new Appearance();
      this.normalAppearance.setMaterial(var10);
      this.normalAppearance.setPolygonMode(var12);
      this.pickedAppearance = new Appearance();
      this.pickedAppearance.setMaterial(var11);
      this.pickedAppearance.setPolygonMode(var12);
      Group var13 = new Group();
      this.bone1 = new Group();
      this.bone2 = new Group();
      var13.addChild(this.bone1);
      this.bone1.addChild(this.bone2);
      this.iSkinnedMesh = new SkinnedMesh(var18, var17, this.normalAppearance, var13);
      this.iSkinnedMesh.addTransform(this.bone1, 200, 8 * var1, 10 * var1);
      this.iSkinnedMesh.addTransform(this.bone2, 1, 16 * var1, 8 * var1);
      this.iLight = new Light();
      this.iLight.setMode(130);
      this.iLight.setAttenuation(0.001F, 0.1F, 0.0F);
      this.iLight.setIntensity(1.0F);
      this.iLight.setColor(16777215);
      this.iLightTrans = new Transform();
      this.iLightTrans.postTranslate(-5.0F, -5.0F, 16.0F);
      this.iLight.setTransform(this.iLightTrans);
      this.iCamera = new Camera();
      this.iCamera.setPerspective(90.0F, 1.0F, 1.0F, 150.0F);
      Transform var14 = new Transform();
      var14.postTranslate(0.0F, 0.0F, 26.0F);
      this.iCamera.setTransform(var14);
      this.iBack = new Background();
      this.iBack.setColor(-12566459);
      this.iBack.setDepthClearEnable(true);
      this.iWorld.setBackground(this.iBack);
      this.iWorld.addChild(this.iSkinnedMesh);
      this.iWorld.addChild(this.iLight);
      this.iWorld.addChild(this.iCamera);
      this.iWorld.setActiveCamera(this.iCamera);
   }
}
