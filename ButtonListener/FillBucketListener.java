package ButtonListener;

import Canvas.Canvas;
import GUI.ToolBar;
import Tools.FillBucket;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class represents an ActionListener for the Fill Bucket tool on the
 * Canvas.
 * It is responsible for filling a closed area with a color.
 */
public class FillBucketListener implements ActionListener {
    Canvas can;
    ToolBar fr;

    /**
     * Constructor for the FillBucketListener class.
     * 
     * @param can the Canvas object to use
     * @param fr  the Toolbar object to use
     */
    public FillBucketListener(Canvas can, ToolBar fr) {
        this.can = can;
        this.fr = fr;
    }

    /**
     * The actionPerformed method of the ActionListener interface.
     * This method is called when the Fill Bucket tool is clicked on the Toolbar.
     * 
     * @param e the ActionEvent object representing the click event
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fr.fill && can.pencilCol != null) {
            if (!can.fillBucketSelected) {
                can.setEraserSelected(false);
                can.setPencilSelected(false);
                can.setBrushSelected(false);
                fr.fill.setFocusPainted(true);
                can.setCurrentTool(null, new FillBucket());
                can.setFillBucketSelected(true);
                can.toolIndex = 4;
                can.drawAll();
            } else {
                can.setEraserSelected(false);
                can.setPencilSelected(false);
                can.setBrushSelected(false);
                fr.fill.setFocusPainted(false);
                can.setCurrentTool(null, null);
                can.setFillBucketSelected(false);
                can.toolIndex = 0;
            }
        }
    }
}
