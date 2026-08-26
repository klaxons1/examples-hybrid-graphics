package custombench;

import java.io.IOException;
import javax.microedition.lcdui.Canvas;
import javax.microedition.lcdui.Graphics;
import javax.microedition.m3g.*;

/**
 *
 * @author Roman Lahin
 */
public class CustomBench extends Canvas{

    Midlet midlet;
    int w,h;
    long beginTime,runTime,framesCount;
    Graphics3D g3d;
    Object3D[] loadedObjects;
    World world;
    Camera camera;
    int mode;
    
    public CustomBench(Midlet midlet, int selected) {
        this.midlet = midlet;
        setFullScreenMode(true);
        w = getWidth(); h = getHeight();
        
        g3d = Graphics3D.getInstance();
        mode = selected;
        try {
            loadGamingTest();
        } catch(Exception e) {e.printStackTrace();}
        
        reset();
        repaint();
    }
    
    private void loadGamingTest() throws IOException {
        loadWorld("/JBenchmarkHD/map.m3g");
        world = (World)loadedObjects[0];
        CompositingMode compositingMode = new CompositingMode();
        compositingMode.setBlending(CompositingMode.ALPHA);
        Mesh mesh = (Mesh)getObjectByID(100);
        mesh.setRenderingEnable(false);
        mesh.getAppearance(0).getTexture(0).setBlending(Texture2D.FUNC_REPLACE);
        mesh.getAppearance(0).setCompositingMode(compositingMode);
        mesh = (Mesh)getObjectByID(101);
        mesh.getAppearance(0).getTexture(0).setBlending(Texture2D.FUNC_REPLACE);
        mesh.getAppearance(0).setCompositingMode(compositingMode);
        mesh = (Mesh)getObjectByID(102);
        mesh.getAppearance(0).getTexture(0).setBlending(Texture2D.FUNC_REPLACE);
        mesh.getAppearance(0).setCompositingMode(compositingMode);
        mesh = (Mesh)getObjectByID(103);
        mesh.getAppearance(0).getTexture(0).setBlending(Texture2D.FUNC_REPLACE);
        mesh.getAppearance(0).setCompositingMode(compositingMode);
      
        for(int i=0;i<world.getChildCount() && mode>0;i++) {
            Node obj = world.getChild(i);
            if(obj == null) continue;
            if(obj instanceof Mesh) {
                Mesh mesht = (Mesh)obj;
                for(int x=0;x<mesht.getSubmeshCount();x++) {
                    Appearance ap = mesht.getAppearance(x);
                    if(ap == null) continue;
                    Texture2D tex = ap.getTexture(0);
                    if(tex != null) {
                        tex.setFiltering(Texture2D.FILTER_BASE_LEVEL,Texture2D.FILTER_NEAREST);
                        if(mode==2) tex.setBlending(Texture2D.FUNC_REPLACE);
                    }
                    if(mode!=2) continue;
                    VertexBuffer vbuf = mesht.getVertexBuffer();
                    if(vbuf != null) vbuf.setColors(null);
                    CompositingMode cmod = ap.getCompositingMode();
                    if(cmod != null) cmod.setColorWriteEnable(false);
                    
                }
            }
        }
       
        loadCamera();
        compositingMode = null;
    }
    
    private void loadWorld(String var1) throws IOException {
        loadedObjects = Loader.load(var1);
    }
    
    private Object3D getObjectByID(int id) {
        for(int i = 0; i < loadedObjects.length; i++) {
            if(loadedObjects[i].getUserID()==id) return loadedObjects[i];
        }

        return loadedObjects[loadedObjects.length - 1].find(id);
    }

    private void loadCamera() {
        if(world!=null) {
            float[] pers = new float[4];
            camera = world.getActiveCamera();
            camera.getProjection(pers);
            camera.setPerspective(pers[0], (float) getWidth() / (float) getHeight(), pers[2], pers[3]);
        }

    }
    
    private void reset() {
        runTime = framesCount = 0;
        beginTime=System.currentTimeMillis();
    }
    
    public void paint(Graphics g) {
        if(runTime>=30000) {
            float afps = framesCount/30f;
            
            midlet.openForm();
            midlet.addText("Score: "+String.valueOf(framesCount));
            midlet.addText("AFPS: "+String.valueOf(afps));
        } else {
            draw3DMap(g);
            repaint();
        }
    }
    
    

    private void draw3DMap(Graphics g) {
        g3d.bindTarget(g);
        world.animate((int)runTime);
        g3d.render(world);
        g3d.releaseTarget();
        framesCount++;
        runTime = System.currentTimeMillis() - this.beginTime;
   }
    
}
