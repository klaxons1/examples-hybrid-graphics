package fi.hybrid.m3g.examples;

import java.util.Vector;
import javax.microedition.lcdui.Alert;
import javax.microedition.lcdui.AlertType;
import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;
import javax.microedition.lcdui.Image;
import javax.microedition.lcdui.List;
import javax.microedition.midlet.MIDlet;

public class MidpStub extends MIDlet implements CommandListener {
   private ExampleCanvas iCanvas;
   private static final Command iOkCommand = new Command("Ok", 4, 1);
   private static final Command iExitCommand = new Command("Exit", 7, 1);
   private List iSelList;
   private Display iDisplay;
   private Alert iError;
   private boolean firstTime;
   private Vector exampleIndices = new Vector();
   private static final int EXAMPLE_MAX = 20;

   public MidpStub() {
      Vector exampleStrings = new Vector();

      for(int i = 1; i <= 20; ++i) {
         try {
            Class c = Class.forName("fi.hybrid.m3g.examples.Example" + i);
            ExampleBase eb = (ExampleBase)c.newInstance();
            this.exampleIndices.addElement(new Integer(i));
            exampleStrings.addElement(eb.getDescription());
         } catch (ClassNotFoundException var5) {
         } catch (IllegalAccessException var6) {
         } catch (InstantiationException var7) {
         }
      }

      this.exampleIndices.trimToSize();
      String[] labels = new String[exampleStrings.size()];
      exampleStrings.copyInto(labels);
      this.iSelList = new List("Select Example", 3, labels, (Image[])null);
      this.iSelList.addCommand(iOkCommand);
      this.iSelList.addCommand(iExitCommand);
      this.iDisplay = Display.getDisplay(this);
      this.iError = new Alert("Hybrid M3G Examples", "", (Image)null, AlertType.ERROR);
      this.iError.setTimeout(-2);
      this.firstTime = true;
   }

   protected void startApp() {
      if (this.firstTime) {
         this.iSelList.setCommandListener(this);
         this.iDisplay.setCurrent(this.iSelList);
         this.firstTime = false;
      }

   }

   public void commandAction(Command aCommand, Displayable aDisp) {
      if (aCommand == iOkCommand && aDisp == this.iSelList) {
         int selIndex = this.iSelList.getSelectedIndex();
         int exampleIndex = (Integer)this.exampleIndices.elementAt(selIndex);

         try {
            Class exampleClass = Class.forName("fi.hybrid.m3g.examples.Example" + exampleIndex);
            ExampleBase example = (ExampleBase)exampleClass.newInstance();
            example.setPlatformServices(new MidpPlatformServices());
            if (this.iCanvas != null) {
               this.iCanvas.stopAndWait();
            }

            this.iCanvas = new ExampleCanvas(example);
            this.iCanvas.setCommandListener(this);
            this.iCanvas.addCommand(iExitCommand);
            this.iDisplay.setCurrent(this.iCanvas);
         } catch (ClassNotFoundException var7) {
            Displayable temp = this.iDisplay.getCurrent();
            this.iError.setString("Class fi.hybrid.m3g.examples.Example" + exampleIndex + " not found");
            if (this.iCanvas != null) {
               this.iCanvas.stopAndWait();
            }

            this.iDisplay.setCurrent(this.iError, temp);
         } catch (Exception e) {
            Displayable temp = this.iDisplay.getCurrent();
            this.iError.setString("Unknown error (" + ((Throwable)e).getMessage() + ")");
            if (this.iCanvas != null) {
               this.iCanvas.stopAndWait();
            }

            this.iDisplay.setCurrent(this.iError, temp);
         }
      } else if (aCommand == iExitCommand && aDisp == this.iCanvas) {
         this.iDisplay.setCurrent(this.iSelList);
      } else if (aCommand == iExitCommand && aDisp == this.iSelList) {
         if (this.iCanvas != null) {
            this.iCanvas.stopAndWait();
         }

         ((MIDlet)this).notifyDestroyed();
      }

   }

   protected void pauseApp() {
   }

   protected void destroyApp(boolean aUnconditional) {
      if (this.iCanvas != null) {
         this.iCanvas.stopAndWait();
      }

   }

   public static class MidpPlatformServices implements PlatformServices {
      public Object loadImage(String name) {
         try {
            return Image.createImage(this.getResourceDir() + name);
         } catch (Exception e) {
            ((Throwable)e).printStackTrace();
            return null;
         }
      }

      public String getResourceDir() {
         return "/";
      }

      public void drawString(Object graphics, String s, int x, int y) {
         Graphics g = (Graphics)graphics;
         g.setColor(-1);
         g.drawString(s, x, y + g.getFont().getHeight(), 20);
      }
   }
}
