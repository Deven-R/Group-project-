/**
 * The ImageTool class implements the {@link Tool} interface and represents a tool used to input an Image onto the Canvas.
 */

package Tools;

import Canvas.Canvas;
import Canvas.Line;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.imageio.ImageIO;

public class ImageTool implements Tool {

    private int x, y;
    private Image image;

    /**
     * Constructs a new ImageTool object.
     */
    
    public ImageTool() {
        image = null; // temporary
    }

    /**
     * Opens an image file from a specified file path.
     * 
     * @param filePath The file path of the image file to be opened.
     */

    public void openImage(String filePath) {
        try {
            image = ImageIO.read(new File(filePath));
        } catch (IOException ex) {
            System.out.println("Error opening image file");
            ex.printStackTrace();
        }
    }

   /**
     * Does not implement the addLine method, as the Image Tool does not support
     * erasing lines.
     * 
     * @param x1    The x-coordinate of the starting point of the line
     * @param y1    The y-coordinate of the starting point of the line
     * @param x2    The x-coordinate of the ending point of the line
     * @param y2    The y-coordinate of the ending point of the line
     * @param lines The list of lines to erase the line from
     */

    @Override
    public void addLine(int x1, int y1, int x2, int y2, List<Line> lines, Color color, int thickness) {
        // Not implemented, as the Fill tool does not support drawing lines, only
        // image importing.
    }

    /**
     * Does not implement the eraseLine method, as the Image Tool tool does not support
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
        // Not implemented, as the Fill tool does not support erasing lines, only
        // image importing.
    }


    /**
     * {@inheritDoc}
     */

    @Override
    public void mousePressed(MouseEvent e, Canvas canvas) {
        x = e.getX();
        y = e.getY();
    }

    /**
     * Does not implement the mouseDragged method, as the Fill tool does not support
     * mouse dragging.
     * 
     * {@inheritDoc}
     */

    public void mouseDragged(MouseEvent e, Canvas canvas) {
        // Not implemented, as the Fill tool does not support mouse dragging
    }


    /**
     * Upon releasing the mouse, if an image has been selected, the image is drawn onto the canvas. Then, the Canvas is repainted.
     * 
     * {@inheritDoc}}
     */

    @Override
    public void mouseReleased(MouseEvent e, Canvas canvas) {
        if (image != null) {
            canvas.getGraphics().drawImage(image, x, y, null);
        }
        canvas.repaint();
    }
}
