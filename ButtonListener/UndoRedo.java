package ButtonListener;

import Canvas.Canvas;
import GUI.ToolBar;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;

/**
 * This is an action listener class that allows for Undo & Redo functionality
 */

public class UndoRedo implements ActionListener {

    Canvas can;
    ToolBar tools;




    /**
     * Constructs a Undo & Redo object to be monitored for actions performed on it within the Toolbar
     * 
     * @param can the Canvas object that the listener is attached to
     * @param fr  the ToolBar object that the listener is attached to
     */
    public UndoRedo(Canvas can, ToolBar tools) {
        this.can = can;
        this.tools = tools;

    }

    /**
     * Handles the Undo & Redo selection event
     * If the Undo or Redo is selected, it sets the current tool to the relevant tool, that being Undo or Redo.
     * Then, if there is an action that can be un-done, or re-done, it completes the Undo or Redo action and repaints the Canvas.
     * 
     * @param e The ActionEvent object
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tools.undo) {
            if (can.undo.size() != 0) {
                can.image = (BufferedImage) can.undo.pop();

                can.repaint();
            }
        } else if (e.getSource() == tools.redo) {
            if (can.redo.size() != 0) {
                can.image = (BufferedImage) can.redo.pop();

                can.repaint();
            }
        }
    }

}
