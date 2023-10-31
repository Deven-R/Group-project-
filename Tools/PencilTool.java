/**
 * The Pencil class implements the {@link Tool} interface and represents a tool used to draw lines on a Canvas.
 */

package Tools;

import Canvas.Canvas;
import Canvas.Line;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.List;

public class PencilTool implements Tool {
    int x1, y1;
    Canvas can;

    public Color col;

    /**
     * {@inheritDoc}
     */

    @Override
    public void addLine(int x1, int y1, int x2, int y2, List<Line> lines, Color color, int thickness) {
        Line line = new Line(x1, y1, x2, y2, color);
        lines.add(line);
    }

    /**
     * Does not implement the eraseLine method, as the Brush tool does not support
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
        // Not implemented, as the Brush tool does not support erasing lines, only drawing.
    }

    /**
     * {@inheritDoc}
     */

    public void mousePressed(MouseEvent e, Canvas canvas) {
        x1 = e.getX();
        y1 = e.getY();
    }

    /**
     * Gets the x and y coordinates of the MouseEvent, calls the addLine method to
     * create a new line which allows for drawing,
     * and repaints the canvas, before re-assigning the x and y coordinates to the
     * new coordinates.
     * 
     * @see #addLine()
     * 
     *      {@inheritDoc}
     */

    public void mouseDragged(MouseEvent e, Canvas canvas) {
        int x2 = e.getX();
        int y2 = e.getY();
        addLine(x1, y1, x2, y2, canvas.lines, canvas.pencilCol, canvas.thickness);
        canvas.repaint();
        x1 = x2;
        y1 = y2;
    }

    /**
     * Repaints the Canvas upon releasing the mouse
     *
     * {@inheritDoc}
     */

    public void mouseReleased(MouseEvent e, Canvas canvas) {
        canvas.repaint();
    }
}
