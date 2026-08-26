package custombench;

import javax.microedition.lcdui.Command;
import javax.microedition.lcdui.CommandListener;
import javax.microedition.lcdui.Display;
import javax.microedition.lcdui.Displayable;
import javax.microedition.lcdui.Form;
import javax.microedition.lcdui.List;
import javax.microedition.lcdui.Screen;
import javax.microedition.lcdui.StringItem;
import javax.microedition.m3g.*;
import javax.microedition.midlet.MIDlet;
import javax.microedition.midlet.MIDletStateChangeException;

/**
 *
 * @author Roman Lahin
 */
public class Midlet extends MIDlet{
    
    public List list;
    public Form form;
    Command selectCommand;
    Command closeCommand;
    CommandListener listener;
    
    protected void startApp() throws MIDletStateChangeException {
        String[] elements = {"Start","Start nearest","Start nearest no lit","Colors tester"}; //Menu items as List elements
        list = new List("Menu", List.IMPLICIT, elements, null);
        
        selectCommand = new Command("Open", Command.ITEM, 1);
        closeCommand = new Command("Close", Command.ITEM, 2);
        list.setSelectCommand(selectCommand);
        list.addCommand(closeCommand);
        
        listener = new Listener(this);
        list.setCommandListener(listener);   
        
        Display.getDisplay(this).setCurrent(list);
    }
    
    protected void pauseApp() {}

    protected void destroyApp(boolean unconditional) throws MIDletStateChangeException {}

    public void returnToList() {
        Display.getDisplay(this).setCurrent(list);
    }
    
    public void openForm() {
        form = new Form("CustomBench");
        form.addCommand(closeCommand);
        Display.getDisplay(this).setCurrent(form);
        form.setCommandListener(listener);  
    }
    
    public void addText(String text) {
        addText(text,null);
    }
    
    public void addText(String text, String text2) {
        if(form!=null) form.append(new StringItem(text,text2));
    }

}

class Listener implements CommandListener {
    Midlet mid;
    
    public Listener(Midlet mid) {
        this.mid = mid;
    }

    public void commandAction(Command c, Displayable d) {
        if(c == mid.closeCommand) {
            if(d == mid.list) mid.notifyDestroyed();
            else mid.returnToList();
        } else if(c == mid.selectCommand) {
            if(mid.list.getSelectedIndex()==3) {
                ColorsTester.test(mid);
            } else Display.getDisplay(mid).setCurrent(new CustomBench(mid,mid.list.getSelectedIndex()));
        }
                
                
    }
    
}
