/**
 * This Line class provides methods to draw lines onto the canvas.
 */

package Canvas;

import java.awt.*;

public class Line {

        public int x1;
        public int y1;
        public int x2;
        public int y2;
        public Color color;
        private int thickness;

        /**
         * Constructs a new Line object with the given starting and ending coordinates
         * and colour.
         * 
         * @param x1    the x-coordinate of the starting point of the line
         * @param y1    the y-coordinate of the starting point of the line
         * @param x2    the x-coordinate of the ending point of the line
         * @param y2    the y-coordinate of the ending point of the line
         * @param color the colour of the line
         */

        public Line(int x1, int y1, int x2, int y2, Color color) {
                this.x1 = x1;
                this.y1 = y1;
                this.x2 = x2;
                this.y2 = y2;
                this.color = color;
        }

        /**
         * As above, constructs a new Line object with the given starting and ending coordinates, colour,
         * however also taking a parameter of thickness.
         * 
         * @param x1 the x-coordinate of the starting point of the line
         * @param y1 the y-coordinate of the starting point of the line
         * @param x2 the x-coordinate of the ending point of the line
         * @param y2 the y-coordinate of the ending point of the line
         * @param color the colour of the line
         * @param thickness the thickness of the line
         */

        public Line(int x1, int y1, int x2, int y2, Color color, int thickness) {
                this.x1 = x1;
                this.y1 = y1;
                this.x2 = x2;
                this.y2 = y2;
                this.color = color;
                this.thickness = thickness;
        }

        /**
         * Draws a line with a pencil tool on the Graphics2D object.
         * 
         * @param g2d the Graphics2D object to draw the line on
         */

        public void drawLinePencil(Graphics2D g2d) {
                g2d.setColor(color);
                g2d.setStroke(new BasicStroke(2));
                g2d.setRenderingHint(
                                RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(
                                RenderingHints.KEY_RENDERING,
                                RenderingHints.VALUE_RENDER_QUALITY);
                g2d.drawLine(x1, y1, x2, y2);
        }

        /**
         * Draws a line with a brush tool on the Graphics2D object, also using the thickness of the line.
         * 
         * @param g2d the Graphics2D object to draw the line on
         */

        public void drawLineBrush(Graphics2D g2d, int thickness) {
                g2d.setColor(color);
                g2d.setStroke(new BasicStroke(this.thickness, BasicStroke.CAP_ROUND, BasicStroke.JOIN_ROUND));
                g2d.setRenderingHint(
                                RenderingHints.KEY_ANTIALIASING,
                                RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(
                                RenderingHints.KEY_RENDERING,
                                RenderingHints.VALUE_RENDER_QUALITY);
                g2d.drawLine(x1, y1, x2, y2);
        }

        /**
         * Sets the thickness of Line to the given value.
         * 
         * @param thickness1 the new thickness value
         */ 

        public void setThickness(int thickness1) {
                this.thickness = thickness1;
        }

}
