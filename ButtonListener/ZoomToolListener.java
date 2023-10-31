package ButtonListener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import Canvas.Canvas;
import GUI.ToolBar;
import Tools.ZoomTool;
//import Tools.ZoomTool;

import javax.swing.*;

/**
 * This is an action listener class that sets the tool to zoom
 */
public class ZoomToolListener implements ActionListener {
    Canvas can;
    ToolBar fr;
    private ImageIcon zoomIcon;

    /**
     * Constructs a ColorListener object.
     * 
     * @param can the Canvas object that the listener is attached to
     * @param fr  the ToolBar object that the listener is attached to
     */
    public ZoomToolListener(Canvas can, ToolBar fr) {
        this.can = can;
        this.fr = fr;
        zoomIcon = new ImageIcon("GUI/icons/zoom.png");
    }

    /**
     * Handles the zoom tool selection event
     * if the zoom is selected, it sets the current tool to zoom tool it and vice
     * versa.
     * 
     * @param e The ActionEvent object
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (!can.zoomSelected) {
            can.setCurrentTool(zoomIcon, new ZoomTool());
            can.setEraserSelected(false);
            can.setPencilSelected(false);
            can.setBrushSelected(false);
            can.setZoomSelected(true);
            fr.zoom.setFocusPainted(true);
            can.toolIndex = 9;
            can.drawAll();
        } else {
            can.setCurrentTool(null, null);
            can.setEraserSelected(false);
            can.setPencilSelected(false);
            can.setBrushSelected(false);
            can.setZoomSelected(false);
            fr.zoom.setFocusPainted(false);
        }
    }
}
