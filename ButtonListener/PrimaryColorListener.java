package ButtonListener;

import Canvas.Canvas;
import GUI.ToolBar;
import Tools.PencilTool;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class sets the color of the tools to primary colors.
 */
public class PrimaryColorListener implements ActionListener {
    Canvas can;
    ToolBar fr;
    PencilTool tool;

    /**
     * Constructs a ColorListener object.
     * 
     * @param can the Canvas object that the listener is attached to
     * @param fr  the ToolBar object that the listener is attached to
     */

    public PrimaryColorListener(Canvas can, ToolBar fr) {
        this.can = can;
        this.fr = fr;
        this.tool = new PencilTool();
    }

    /**
     * Changes the color of the pencil, brush, and fill to the primary color icon in
     * GUI.
     * 
     * @param e the ActionEvent object that represents the action
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        // Set the color to the color of the canvas pencilCol
        if ((e.getSource() == fr.green_circle)) {
            can.setPencilCol(Color.GREEN);
            tool.col = Color.GREEN;

        } else if ((e.getSource() == fr.red_circle)) {
            can.setPencilCol(Color.red);
            tool.col = Color.red;
        } else if ((e.getSource() == fr.yellow_circle)) {
            can.setPencilCol(Color.yellow);
            tool.col = Color.yellow;
        }
    }
}
