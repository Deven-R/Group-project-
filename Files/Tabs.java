package Files;

import javax.swing.*;
import Canvas.Canvas;
import Canvas.MouseEventFrame;


/**

 The Tabs class extends the JTabbedPane class to provide a tabbed panel
 that allows the user to add and switch between multiple Canvas objects.
 */

public class Tabs extends JTabbedPane {
    /**
     The layerNumber is a String variable that stores the default name prefix
     for each tab. The l variable is an integer that is used to keep track of
     the number of tabs that have been added to the tabbed panel.
     */
    public String layerNumber;
    public  int l;

    //For Canvas alone
    /**
     The constructor for the Tabs class initializes the l variable to 0 and
     sets the layerNumber to "Tab ".
     */
    public Tabs(){
        l = 0;
         this.layerNumber = "Tab ";
    }
    /**
     The addNewCanvas() method creates a new Canvas object and adds it to the
     tabbed panel. It also sets up a MouseEventFrame object to handle mouse
     events for the new canvas.
     @return the new Canvas object that was added to the tabbed panel
     */
    public Canvas addNewCanvas(){
        Canvas can = new Canvas();
        MouseEventFrame fp = new MouseEventFrame(can);
        can.addMouseListener(fp);
        can.addMouseMotionListener(fp);
        l++;
        addTab(this.layerNumber+l, can);
        return can;
    }

}
