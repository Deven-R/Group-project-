/**
 * This Tools interface defines the methods that any Tool object must implement to draw and erase lines on the Canvas,
 */

package Tools;

import Canvas.Canvas;
import Canvas.Line;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.List;

public interface Tool {

        /**
         * Creates a new line to add the list of lines, including the specified color and thickness.
         * 
         * @param x1        The x-coordinate of the starting point of the line
         * @param y1        The y-coordinate of the starting point of the line
         * @param x2        The x-coordinate of the ending point of the line
         * @param y2        The y-coordinate of the ending point of the line
         * @param lines     The list of lines
         * @param color     The colour of the line
         * @param thickness The thickness of the line
         */

        void addLine(int x1, int y1, int x2, int y2, List<Line> lines, Color color, int thickness);

        /**
         * Erases the line that intersects the specified coordinates from the given list
         * of lines.
         * 
         * @param x1    The x-coordinate of the starting point of the line
         * @param y1    The y-coordinate of the starting point of the line
         * @param x2    The x-coordinate of the ending point of the line
         * @param y2    The y-coordinate of the ending point of the line
         * @param lines The list of lines to erase the line from
         */

        void eraseLine(int x1, int y1, int x2, int y2, List<Line> lines);

        /**
         * Called when the mouse button is pressed on the Canvas.
         * 
         * @param e      The MouseEvent object
         * @param canvas The Canvas that the mouse event occurred on
         */

        void mousePressed(MouseEvent e, Canvas canvas);

        /**
         * Called when the mouse button is dragged on the Canvas.
         * 
         * @param e      The MouseEvent object
         * @param canvas The Canvas that the mouse event occurred on
         */

        void mouseDragged(MouseEvent e, Canvas canvas);

        /**
         * Called when the mouse button is released on the Canvas.
         * 
         * @param e      The MouseEvent object
         * @param canvas The Canvas that the mouse event occurred on
         */

        void mouseReleased(MouseEvent e, Canvas canvas);

}
