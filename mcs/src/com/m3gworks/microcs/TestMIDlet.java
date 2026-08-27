package com.m3gworks.microcs; 
import javax.microedition.midlet.MIDlet;

public class TestMIDlet extends MIDlet {
   public TestMIDlet() {
      System.out.println("arccos(0.5)=" + MathUtilsArcSin.asin(0.5D));
   }

   public void startApp() {
   }

   public void pauseApp() {
   }

   public void destroyApp(boolean var1) {
   }
}
