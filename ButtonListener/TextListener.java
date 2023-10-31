package ButtonListener;

import Canvas.Canvas;
import GUI.ToolBar;
import Tools.TextTool;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used to select the text tool function
 */
public class TextListener implements ActionListener {
    Canvas can;
    ToolBar fr;

    /**
     *
     * @param can The Canvas object to manipulate the Text on.
     * @param fr  The ToolBar object containing the tool button.
     */
    public TextListener(Canvas can, ToolBar fr) {
        this.can = can;
        this.fr = fr;

    }

    /**
     * The actionPerformed method of the ActionListener interface.
     * This method is called when the Text tool is clicked on the Toolbar.
     * 
     * @param e the ActionEvent object representing the click event
     */
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == fr.text) {
            can.setCurrentTool(null, new TextTool());
            can.setEraserSelected(false);
            can.setPencilSelected(false);
            can.setFillBucketSelected(false);
            can.setTextTool(true);
        }
    }
}
