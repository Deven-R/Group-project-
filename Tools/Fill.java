/**
 * The Fill class implements the {@link Tool} interface and represents a tool used to fill the Canvas in a specified colour.
 */

package Tools;

import Canvas.Canvas;
import Canvas.Line;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.List;

public class Fill implements Tool {
    int x1, y1;
    Canvas can;




    // A 2D boolean array used to keep track of the pixels that have been filled
    public boolean checktable[][];

    /**
     * Does not implement the addLine method, as the Fill tool does not support
     * drawing lines.
     * 
     */

    @Override
    public void addLine(int x1, int y1, int x2, int y2, List<Line> lines, Color color, int thickness) {
        // Not implemented, as the Fill tool does not support drawing lines, only
        // filling.
    }

    /**
     * Does not implement the eraseLine method, as the Fill tool does not support
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
        // filling.
    }

    /**
     * Initializes the checktable for the canvas width and height, and starts the
     * fill operation.
     *
     * @see #triggerMultiple()
     * 
     * {@inheritDoc}
     * 
     */

    public void mousePressed(MouseEvent e, Canvas canvas) {
        can = canvas;
        x1 = e.getX();
        y1 = e.getY();

        for (int i = 0; i < can.image.getHeight(); i++) {
            for (int j = 0; j < can.image.getWidth(); j++) {
                checktable[i][j] = false;
            }
        }

        System.out.println("I am here at Fill.java");

        triggerMultiple(x1, y1, canvas.pencilCol);

        // can.get
        // Fill should work here!!!
    }

    /**
     * This method recursively fills pixels with the given color.
     *
     * @param x     the x-coordinate of the pixel
     * @param y     the y-coordinate of the pixel
     * @param color the color to fill with
     *
     */

    public void triggerMultiple(int x, int y, Color color) {

        // If the pixel is already filled with the given color, or has been checked
        // before, return
        if (can.image.getRGB(x, y) != color.getRGB())
            return;
        if (checktable[x][y] == true)
            return;

        // Fill the pixel and mark it as checked
        paintThatPixel(x, y, color);

        // Call the function recursively on adjacent pixels
        triggerMultiple(x + 1, y + 1, color);
        triggerMultiple(x + 1, y, color);
        triggerMultiple(x + 1, y - 1, color);
        triggerMultiple(x, y + 1, color);
        triggerMultiple(x, y - 1, color);
        triggerMultiple(x - 1, y + 1, color);
        triggerMultiple(x - 1, y, color);
        triggerMultiple(x - 1, y - 1, color);
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
     * Repaints the Canvas upon releasing the mouse.
     * 
     * {@inheritDoc}}
     */

    public void mouseReleased(MouseEvent e, Canvas canvas) {
        can = canvas;
        canvas.repaint();
    }

    /**
     * 
     * This method paints a pixel on the canvas with the specified color.
     * It sets the corresponding pixel in the image of the canvas and marks it as
     * painted in the checktable 2D array.
     * 
     * @param x     the x-coordinate of the pixel
     * @param y     the y-coordinate of the pixel
     * @param color the color of the pixel
     */

    private void paintThatPixel(int x, int y, Color color) {
        can.image.setRGB(x, y, color.getRGB());
        checktable[x][y] = true;
    }

}
