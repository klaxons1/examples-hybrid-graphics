package com.m3gworks.engine;

import javax.microedition.lcdui.Display;
import javax.microedition.midlet.MIDlet;

public class GameMIDlet extends MIDlet {
   public Display var_3a = null;
   private static GameMIDlet var_98;

   public static GameMIDlet sub_f() {
      return var_98;
   }

   public GameMIDlet() {
      var_98 = this;
      this.var_3a = Display.getDisplay(this);
   }

   public void sub_35() {
   }

   public void startApp() {
      this.sub_35();
   }

   public void pauseApp() {
   }

   public void destroyApp(boolean var1) {
   }
}
