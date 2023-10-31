/**
 * The Eraser class implements the {@link Tool} interface and represents a tool used to erase drawn lines on a Canvas.
 */

package Tools;

import Canvas.Line;
import Canvas.Canvas;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;
import java.util.List;

public class Eraser implements Tool {
    int x1, y1;

    /**
     * Does not implement the addLine method, as the Eraser tool does not support
     * drawing lines.
     * 
     * @param x1    The x-coordinate of the starting point of the line
     * @param y1    The y-coordinate of the starting point of the line
     * @param x2    The x-coordinate of the ending point of the line
     * @param y2    The y-coordinate of the ending point of the line
     * @param lines The list of lines to erase the line from
     */

    @Override
    public void addLine(int x1, int y1, int x2, int y2, List<Line> lines, Color color, int thickness) {
        // Not implemented, as the Eraser tool does not support drawing lines, only
        // erasing.
    }

    /**
     * {@inheritDoc}}
     */

    @Override
    public void eraseLine(int x1, int y1, int x2, int y2, List<Line> lines) {
        for (int i = 0; i < lines.size(); i++) {
            Line line = lines.get(i);
            if (Math.min(line.x1, line.x2) <= x1 && x1 <= Math.max(line.x1, line.x2)
                    && Math.min(line.y1, line.y2) <= y1 && y1 <= Math.max(line.y1, line.y2)
                    && Math.min(line.x1, line.x2) <= x2 && x2 <= Math.max(line.x1, line.x2)
                    && Math.min(line.y1, line.y2) <= y2 && y2 <= Math.max(line.y1, line.y2)) {
                lines.remove(i);
                break;

            }
        }
    }

    /**
     * Removes all lines that are within the canvas.
     *
     * @param x      The x-coordinate of the starting point of the canvas
     * @param y      The y-coordinate of the starting point of the canvas
     * @param width  The width of the canvas
     * @param height The height of the canvas
     * @param lines  The list of lines to erase the lines from
     */

    public void eraseArea(int x, int y, int width, int height, List<Line> lines) {
        Rectangle2D area = new Rectangle2D.Double(x, y, width, height);
        Iterator<Line> it = lines.iterator();
        while (it.hasNext()) {
            Line line = it.next();
            if (lineInArea(line, area)) {
                it.remove();
            }
        }
    }

    /**
     * Checks if a given line is within a specified area.
     * 
     * @param line The line to check
     * @param area The area to check
     * @return {@code true} if the line is within the specified area, {@code false}
     *         otherwise
     */
    private boolean lineInArea(Line line, Rectangle2D area) {
        return area.contains(line.x1, line.y1) || area.contains(line.x2, line.y2) ||
                area.intersectsLine(line.x1, line.y1, line.x2, line.y2);
    }

    /**
     * {@inheritDoc}}
     */

    public void mousePressed(MouseEvent e, Canvas canvas) {
        x1 = e.getX();
        y1 = e.getY();
    }

    /**
     * Gets the x and y coordinates of the MouseEvent, calls the eraseLine method to
     * allow for erasing,
     * then repaints the canvas, before re-assigning the x and y coordinates to the
     * new coordinates.
     * 
     * @see #eraseLine()
     * 
     *      {@inheritDoc}}
     */

    public void mouseDragged(MouseEvent e, Canvas canvas) {
        int x2 = e.getX();
        int y2 = e.getY();
        eraseLine(x1, y1, x2, y2, canvas.lines);
        canvas.repaint();
        x1 = x2;
        y1 = y2;
    }

    /**
     * Repaints the Canvas upon releasing the mouse
     * 
     * {@inheritDoc}}
     */

    public void mouseReleased(MouseEvent e, Canvas canvas) {
        canvas.repaint();
    }
}
