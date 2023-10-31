package ButtonListener;

import Canvas.Canvas;
import GUI.ToolBar;
import Tools.PencilTool;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * A class that implements the ActionListener interface and listens for color
 * change events.
 */
public class ColorListener implements ActionListener {

    Canvas can;
    ToolBar fr;
    PencilTool tool;
    private Color c;

    JColorChooser color;
    JDialog colorChooser;

    /**
     * Constructs a ColorListener object.
     * 
     * @param can the Canvas object that the listener is attached to
     * @param fr  the ToolBar object that the listener is attached to
     */

    public ColorListener(Canvas can, ToolBar fr) {
        this.can = can;
        this.fr = fr;
        this.tool = new PencilTool();
    }

    /**
     * Changes the color of the pencil, brush, and fill using JColorChooser.
     * 
     * @param e the ActionEvent object that represents the action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fr.colors) {
            color = new JColorChooser();
            color.setBounds(200, 200, 200, 250);
            colorChooser = JColorChooser.createDialog(can, "Pick a color", true, color, null, null);
            colorChooser.setVisible(true);
            c = color.getColor();
            if (c == null) {
                can.setPencilCol(Color.BLACK);
            } else {
                can.setPencilCol(c);
            }
            colorChooser.setVisible(false);
        }
    }
}
