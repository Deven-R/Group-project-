/**
 * TextTool is a class that implements the {@link Tool} interface and provides functionality for drawing text on a Canvas.
*/

package Tools;

import Canvas.Line;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.List;
import Canvas.Canvas;
import javax.swing.*;

public class TextTool implements Tool {

    /**
     * Does not implement the addLine method, as the Text tool does not support
     * adding lines.
     * 
     * @param x1    The x-coordinate of the starting point of the line
     * @param y1    The y-coordinate of the starting point of the line
     * @param x2    The x-coordinate of the ending point of the line
     * @param y2    The y-coordinate of the ending point of the line
     * @param lines The list of lines to erase the line from
     */

    @Override
    public void addLine(int x1, int y1, int x2, int y2, List<Line> lines, Color color, int thickness) {
        // Not implemented, as the Text tool does not support drawing lines, only
        // text input.
    }

    /**
     * Does not implement the eraseLine method, as the Text tool does not support
     * erasing lines.
     * 
     * @param x1    The x-coordinate of the starting point of the line
     * @param y1    The y-coordinate of the starting point of the line
     * @param x2    The x-coordinate of the ending point of the line
     * @param y2    The y-coordinate of the ending point of the line
     * @param lines The list of lines to erase the line from
     */

    @Override
    public void eraseLine(int x1, int y1, int x2, int y2, List<Line> lines) {
        // Not implemented, as the Tect tool does not support erasing lines, only
        // text input.
    }

    /**
     * Does not implement the mouseReleased method, as the Text tool does not
     * support
     * mouse dragging.
     * 
     * {@inheritDoc}
     */
    @Override
    public void mouseReleased(MouseEvent e, Canvas canvas) {
        // Not implemented, as the Text tool does not support mouse releasing events
    }

    /**
     * Does not implement the mouseDragged method, as the Text tool does not support
     * mouse dragging.
     * 
     * {@inheritDoc}
     */

    public void mouseDragged(MouseEvent e, Canvas canvas) {
        // Not implemented, as the Text tool does not support mouse dragging
    }

    /**
     * Invoked when a mouse button has been pressed on a component. If the mouse is
     * double-clicked, the user will be shown a dialog box to ask the text input.
     * This then also records the requested font size and font type, and sets the
     * Tool Index to 12, which is the number that represents the Text Tool.
     * 
     * @param e      The MouseEvent object that describes the event.
     * @param canvas The Canvas on which the event occurred.
     */
    @Override
    public void mousePressed(MouseEvent e, Canvas canvas) {
        canvas.x = e.getX();
        canvas.y = e.getY();
        // canvas.requestFocus();
        if (e.getClickCount() == 2) {
            canvas.word = JOptionPane.showInputDialog(null, "Enter your string");
            String fonts[] = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
            String fontType = (String) JOptionPane.showInputDialog(null, "Choose your font style", "Font",
                    JOptionPane.QUESTION_MESSAGE, null, fonts, fonts[1]);
            String fontSize = JOptionPane.showInputDialog(null, "Your font size");
            int ft = Integer.parseInt(fontSize);
            canvas.font = new Font(fontType, Font.BOLD, ft);
            canvas.toolIndex = 12;
            canvas.drawAll();
        }

    }
}
