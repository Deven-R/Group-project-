package ButtonListener;

import Canvas.Canvas;
import GUI.ToolBar;
import Tools.Brush;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is an ActionListener for the paint button in the ToolBar GUI
 * component.
 * It allows the user to select the brush tool and adjust its thickness using a
 * JSlider.
 */
public class BrushListener implements ActionListener {
    Canvas can;
    ToolBar fr;
    private ImageIcon brushIcon;

    JSlider slider;

    /**
     * Constructor for the BrushListener class.
     * 
     * @param can       the Canvas object to update the tool selection
     * @param fr        the ToolBar object containing the paint button
     * @param thickness the initial thickness of the brush tool
     * @param resize    the JSlider object to adjust the brush thickness
     */

    public BrushListener(Canvas can, ToolBar fr, int thickness, JSlider resize) {
        this.can = can;
        this.fr = fr;
        brushIcon = new ImageIcon("GUI/icons/paint.png");
        slider = resize;
    }

    /**
     * This method is called when the user clicks the paint button.
     * It sets the brush tool as the current tool, allows the user to adjust the
     * thickness using the JSlider,
     * and updates the Canvas object with the new tool selection.
     * If the brush tool is already selected, it deselects it.
     * 
     * @param e the ActionEvent object generated by the button click
     */

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fr.paint) {
            if (!can.brushSelected) {
                can.setBrushSelected(true);
                fr.paint.setFocusPainted(true);
                can.setCurrentTool(brushIcon, new Brush());
                can.setEraserSelected(false);
                can.setPencilSelected(false);
                slider.addChangeListener(new ChangeListener() {
                    public void stateChanged(ChangeEvent e) {
                        can.brushThickness = slider.getValue();
                        can.setThickness(can.brushThickness);
                    }
                });
                can.toolIndex = 10;
            } else {
                can.setCurrentTool(null, null);
                can.setEraserSelected(false);
                can.setPencilSelected(false);
                can.setBrushSelected(false);
                fr.pencil.setFocusPainted(false);
            }
        }
    }
}