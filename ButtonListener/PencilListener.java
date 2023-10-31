package ButtonListener;

import Canvas.Canvas;
import GUI.ToolBar;
import Tools.PencilTool;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * The PencilListener class implements ActionListener to handle the pencil tool
 * selection event
 */
public class PencilListener implements ActionListener {
    Canvas can;
    ToolBar fr;
    private ImageIcon pencilIcon;

    public PencilListener(Canvas can, ToolBar fr) { // edited here: changed the MouseEventPanel to ToolBar
        this.can = can;
        this.fr = fr;
        pencilIcon = new ImageIcon("GUI/icons/pencil.png");
    }

    /**
     * Handles the pencil tool selection event
     * if the pencil is selected, it sets the current tool in the canvas to pencil
     * it and vice versa.
     * 
     * @param e The ActionEvent object
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fr.pencil) {
            if (!can.pencilSelected) {
                can.setCurrentTool(pencilIcon, new PencilTool());
                can.setEraserSelected(false);
                can.setPencilSelected(true);
                fr.pencil.setFocusPainted(true);
                can.toolIndex = 1;
            } else {
                can.setCurrentTool(null, null);
                can.setEraserSelected(false);
                can.setPencilSelected(false);
                fr.pencil.setFocusPainted(false);
            }
        }
    }
}
