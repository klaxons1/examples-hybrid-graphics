package com.m3gworks.microcs; 
import javax.microedition.m3g.Node;
import javax.microedition.m3g.World;

public final class FirstPersonCameraModel extends Model3D {
   public final Node createModel(World var1) {
      super.rootNode = CameraManager.getInstance().getCamera("MAIN");
      var1.addChild(super.rootNode);
      super.meshNode = super.rootNode;
      return super.meshNode;
   }
}
