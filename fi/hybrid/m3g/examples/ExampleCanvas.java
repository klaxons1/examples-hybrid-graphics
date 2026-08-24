package fi.hybrid.m3g.examples;

import java.util.Hashtable;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Graphics;

public class ExampleCanvas extends Canvas {
   private ExampleBase iExample;
   private boolean iStop = false;
   private boolean iIsRendering = false;
   private int iCounter;
   private long intervalStart;
   private long lastCursorUpdate;
   private float fps;
   private static final float CURSOR_SPEED = 20.0F;
   private float cursorX;
   private float cursorY;
   private static final int UP_PRESSED = 1;
   private static final int DOWN_PRESSED = 2;
   private static final int RIGHT_PRESSED = 4;
   private static final int LEFT_PRESSED = 8;
   private int keysPressed = 0;
   private static final int NUM_FRAMES = 10;
   private static Hashtable keymap = new Hashtable();

   public ExampleCanvas(ExampleBase aExample) {
      this.iExample = aExample;
      this.iExample.initialize();
      this.iExample.setStartTime((int)System.currentTimeMillis());
      this.lastCursorUpdate = System.currentTimeMillis();
      this.iCounter = 0;
      this.cursorX = (float)(((Displayable)this).getWidth() / 2);
      this.cursorY = (float)(((Displayable)this).getHeight() / 2);
   }

   protected void paint(Graphics aGraphics) {
      this.iIsRendering = true;
      if (!this.iStop) {
         this.iExample.render(aGraphics, ((Displayable)this).getWidth(), ((Displayable)this).getHeight());
         long now = System.currentTimeMillis();
         if ((this.iExample.getFeatures() & 4) != 0) {
            long delta = now - this.lastCursorUpdate;
            this.lastCursorUpdate = now;
            this.updateCursor(delta);
            aGraphics.setColor(-1);
            aGraphics.setStrokeStyle(0);
            aGraphics.drawLine((int)this.cursorX - 4, (int)this.cursorY, (int)this.cursorX + 4, (int)this.cursorY);
            aGraphics.drawLine((int)this.cursorX, (int)this.cursorY - 4, (int)this.cursorX, (int)this.cursorY + 4);
         }

         if ((this.iExample.getFeatures() & 1) != 0) {
            if (this.iCounter % 10 == 0) {
               if (this.iCounter > 0) {
                  long elapsed = now - this.intervalStart;
                  this.fps = 10.0F / (float)elapsed * 1000.0F;
               }

               this.intervalStart = now;
            }

            if (this.iCounter >= 10) {
               aGraphics.setColor(-1);
               String f = String.valueOf(this.fps);
               int lenMin = Math.min(f.length(), 5);
               aGraphics.drawString(String.valueOf(this.fps).substring(0, lenMin), 4, 4 + aGraphics.getFont().getHeight(), 20);
            }
         }

         ++this.iCounter;
         ((Canvas)this).repaint();
      }

      this.iIsRendering = false;
   }

   public void stopAndWait() {
      this.iStop = true;

      while(this.iIsRendering) {
         try {
            Thread.sleep(1L);
         } catch (InterruptedException var2) {
         }
      }

   }

   private void updateCursor(long delta) {
      int ydir = 0;
      int xdir = 0;
      if ((this.keysPressed & 1) != 0) {
         ydir = -1;
      } else if ((this.keysPressed & 2) != 0) {
         ydir = 1;
      }

      if ((this.keysPressed & 8) != 0) {
         xdir = -1;
      } else if ((this.keysPressed & 4) != 0) {
         xdir = 1;
      }

      if (ydir != 0) {
         this.cursorY += (float)ydir * 20.0F * ((float)delta / 1000.0F);
         this.cursorY = this.cursorY > (float)((Displayable)this).getHeight() ? (float)((Displayable)this).getHeight() : (this.cursorY < 0.0F ? 0.0F : this.cursorY);
      }

      if (xdir != 0) {
         this.cursorX += (float)xdir * 20.0F * ((float)delta / 1000.0F);
         this.cursorX = this.cursorX > (float)((Displayable)this).getWidth() ? (float)((Displayable)this).getWidth() : (this.cursorX < 0.0F ? 0.0F : this.cursorX);
      }

      if (ydir != 0 || xdir != 0) {
         this.iExample.setMousePos((this.cursorX + 0.5F) / (float)((Displayable)this).getWidth(), (this.cursorY + 0.5F) / (float)((Displayable)this).getHeight());
      }

   }

   protected void keyReleased(int key) {
      Integer exampleKey = (Integer)keymap.get(new Integer(key));
      if (exampleKey != null) {
         this.iExample.keyReleased(exampleKey);
      } else if ((this.iExample.getFeatures() & 4) != 0) {
         boolean changed = false;
         switch (((Canvas)this).getGameAction(key)) {
            case 1:
               this.keysPressed &= -2;
               changed = true;
               break;
            case 2:
               this.keysPressed &= -9;
               changed = true;
            case 3:
            case 4:
            default:
               break;
            case 5:
               this.keysPressed &= -5;
               changed = true;
               break;
            case 6:
               this.keysPressed &= -3;
               changed = true;
         }

         if (changed) {
            long now = System.currentTimeMillis();
            long delta = now - this.lastCursorUpdate;
            this.lastCursorUpdate = now;
            this.updateCursor(delta);
         }
      } else {
         switch (((Canvas)this).getGameAction(key)) {
            case 1:
               this.iExample.keyReleased(10);
               break;
            case 2:
               this.iExample.keyReleased(13);
            case 3:
            case 4:
            default:
               break;
            case 5:
               this.iExample.keyReleased(11);
               break;
            case 6:
               this.iExample.keyReleased(12);
         }
      }

   }

   protected void keyPressed(int key) {
      Integer exampleKey = (Integer)keymap.get(new Integer(key));
      if (exampleKey != null) {
         this.iExample.keyPressed(exampleKey);
      } else if ((this.iExample.getFeatures() & 4) != 0) {
         boolean changed = false;
         switch (((Canvas)this).getGameAction(key)) {
            case 1:
               this.keysPressed |= 1;
               changed = true;
               break;
            case 2:
               this.keysPressed |= 8;
               changed = true;
            case 3:
            case 4:
            default:
               break;
            case 5:
               this.keysPressed |= 4;
               changed = true;
               break;
            case 6:
               this.keysPressed |= 2;
               changed = true;
         }

         if (changed) {
            long now = System.currentTimeMillis();
            long delta = now - this.lastCursorUpdate;
            this.lastCursorUpdate = now;
            this.updateCursor(delta);
         }
      } else {
         switch (((Canvas)this).getGameAction(key)) {
            case 1:
               this.iExample.keyPressed(10);
               break;
            case 2:
               this.iExample.keyPressed(13);
            case 3:
            case 4:
            default:
               break;
            case 5:
               this.iExample.keyPressed(11);
               break;
            case 6:
               this.iExample.keyPressed(12);
         }
      }

   }

   static {
      keymap.put(new Integer(48), new Integer(9));
      keymap.put(new Integer(49), new Integer(0));
      keymap.put(new Integer(50), new Integer(1));
      keymap.put(new Integer(51), new Integer(2));
      keymap.put(new Integer(52), new Integer(3));
      keymap.put(new Integer(53), new Integer(4));
      keymap.put(new Integer(54), new Integer(5));
      keymap.put(new Integer(55), new Integer(6));
      keymap.put(new Integer(56), new Integer(7));
      keymap.put(new Integer(57), new Integer(8));
      keymap.put(new Integer(42), new Integer(15));
   }
}
