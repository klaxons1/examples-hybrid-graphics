package custombench;

import javax.microedition.lcdui.Image;
import javax.microedition.m3g.*;

/**
 *
 * @author Roman Lahin
 */
public class ColorsTester {
    static Image2D img2d,img2d2,img2d3;

    public static void test(Midlet mid) {
        int blueSteps = 1, redSteps = 1, greenSteps = 1;
        long rawImageHeap = 0;
        long paletteImageHeap = 0;
        long paletteImageFromJarHeap = 0;
        long freeHeap = 0;
        
        Runtime runtime = Runtime.getRuntime();
        
        try {
            Image render = Image.createImage(4,256);
            Graphics3D g3d = Graphics3D.getInstance();
            
            Image gradients = Image.createImage("/rgbw.png");
            Image2D gradientsImg2D = new Image2D(Image2D.RGB,gradients);
            
            Appearance ap = new Appearance();
            
            Transform transform = new Transform();
            transform.postTranslate(0.0f, 0.0f, 0);
            g3d.setCamera(new Camera(), transform);
            
            Sprite3D spr = new Sprite3D(false,gradientsImg2D,ap);
            
            int[] colors = new int[render.getWidth()*render.getHeight()];
            
            g3d.bindTarget(render.getGraphics(),false,Graphics3D.OVERWRITE);
            g3d.render(spr, null);
            g3d.releaseTarget();
            
            render.getRGB(colors, 0, render.getWidth(), 0, 0, render.getWidth(), render.getHeight());
            
            
            int prevR = 0, prevG = 0, prevB = 0;
            for(int i = 0;i<256;i++) {
                int r = colors[i*4]&0xff0000;
                int g = colors[i*4+1]&0xff00;
                int b = colors[i*4+2]&0xff;
                
                if(i>0) {
                    if(r!=prevR) redSteps++;
                    if(g!=prevG) greenSteps++;
                    if(b!=prevB) blueSteps++;
                }
                
                prevR = r; prevG = g; prevB = b;
            }
            
            colors = null; spr = null; transform = null; 
            ap = null; gradients = null; gradientsImg2D = null; 
            g3d = null; render = null;
            
            System.gc();
            freeHeap = runtime.freeMemory();
            
            loadRaw();
            System.gc();
            rawImageHeap = freeHeap - runtime.freeMemory();
            
            System.gc();
            freeHeap = runtime.freeMemory();
            
            loadIndexedFromCode();
            System.gc();
            paletteImageHeap =  freeHeap - runtime.freeMemory();
            
            System.gc();
            freeHeap = runtime.freeMemory();
            
            loadIndexedFromPng();
            System.gc();
            paletteImageFromJarHeap =  freeHeap - runtime.freeMemory();
            
            
        } catch(Exception e) {
            e.printStackTrace();
        }
        
        mid.openForm();
        
        int colorsCount = redSteps*greenSteps*blueSteps;
        int redBits = getBits(redSteps);
        int greenBits = getBits(greenSteps);
        int blueBits = getBits(blueSteps);
        
        mid.addText("Colors count: "+colorsCount,
                "("+String.valueOf(redBits+greenBits+blueBits)+" bits)");
        mid.addText(" ");
        
        mid.addText(redSteps+" Red steps","("+redBits+" bits)");
        mid.addText(greenSteps+" Green steps","("+greenBits+" bits)");
        mid.addText(blueSteps+" Blue steps","("+blueBits+" bits)");
        mid.addText(" ");
        
        mid.addText("Raw 256x tex heap: "+rawImageHeap/1024+" kb",
                "("+String.valueOf(rawImageHeap/256/256)+" bytes per pixel)");
        
        mid.addText("Palette 256x tex (created from code) heap: "+paletteImageHeap/1024+" kb",
                "("+String.valueOf(paletteImageHeap/256/256)+" bytes per pixel)");
        
        mid.addText("Palette 256x tex (created from png) heap: "+paletteImageFromJarHeap/1024+" kb",
                "("+String.valueOf(paletteImageFromJarHeap/256/256)+" bytes per pixel)");
        
    }
    
    public static void loadRaw() {
        byte[] image = new byte[256*256*4];
        fill(image);
        img2d = new Image2D(Image2D.RGBA,256,256,image); 
        image = null;
    }
    
    public static void loadIndexedFromCode() {
        byte[] image2 = new byte[256*256];
        byte[] palette = new byte[256*4];
        fill(image2);
        fillPalette(palette);
        img2d2 = new Image2D(Image2D.RGBA,256,256,image2,palette); 
        image2 = palette = null;
    }
    
    public static void loadIndexedFromPng() throws Exception {
        Image gimg = Image.createImage("/indexedImage.png");
        img2d3 = new Image2D(Image2D.RGBA,gimg); 
        gimg = null;
    }
    
    public static int getBits(int value) {
        for(int i=0;i<31;i++) {
            if(value<=(1<<i)) return i;
        }
        return -1;
    }
    
    public static void fill(byte[] arr) {
        for(int i=0;i<arr.length;i++) {
            arr[i]=(byte)(((i&255)*(i/256))%256);
        }
    }
    
    public static void fillPalette(byte[] arr) {
        for(int i=0;i<arr.length;i++) {
            arr[i]=(byte)((i/4)%256);
        }
    }
    
}
