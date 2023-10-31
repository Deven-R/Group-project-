package ButtonListener;

import Canvas.Canvas;
import GUI.ToolBar;
import Tools.Eraser;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * The EraserListener class is responsible for handling the actions performed by
 * the eraser tool button in the tool bar.
 */
public class EraserListener implements ActionListener {
    Canvas can;
    ToolBar fr;
    private final ImageIcon eraserIcon;

    /**
     * Constructor for the EraserListener class
     * 
     * @param can the canvas object
     * @param fr  the tool bar object
     */
    public EraserListener(Canvas can, ToolBar fr) {
        this.can = can;
        this.fr = fr;
        eraserIcon = new ImageIcon("GUI/icons/eraser.png");
    }

    /**
     * The actionPerformed method is called when the eraser tool button is clicked.
     * If the eraser is selected, it deselects the eraser; otherwise it selects the
     * eraser tool
     * 
     * @param e the ActionEvent object representing the user's action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fr.eraser) {
            if (!can.eraserSelected) {
                can.setCurrentTool(eraserIcon, new Eraser());
                can.setPencilSelected(false);
                can.setEraserSelected(true);
                can.setZoomSelected(false);
                can.setBrushSelected(false);
                can.toolIndex = 2;
                fr.eraser.setFocusPainted(true);
            } else {
                can.setCurrentTool(null, null);
                can.setPencilSelected(false);
                can.setEraserSelected(false);
                can.toolIndex = 0;
                fr.eraser.setFocusPainted(false);
            }
        }

    }
}
