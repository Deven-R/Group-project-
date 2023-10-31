/**
 * The Fill class implements the {@link Tool} interface and represents a tool used to fill the Canvas in a specified colour.
 */

package Tools;
import Canvas.Line;
import Canvas.Canvas;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.List;
import java.util.*;

public class FillBucket implements Tool {

    int x, y;
    Canvas can;
    boolean checktable[][];
    int targetColor;
    //public LinkedList<String> sdas = new LinkedList<>();

    /**
     * Does not implement the addLine method, as the Fill tool does not support
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
    
    public void mousePressed(MouseEvent e, Canvas canvas){
        can = canvas;
        x = e.getX();
        y = e.getY();
        targetColor = can.image.getRGB(x,y);

        checktable = new boolean[can.image.getWidth()][can.image.getHeight()];

        for (int i=0;i<can.image.getHeight();i++)
        {
            for (int j=0;j<can.image.getWidth();j++)
            {
                checktable[j][i] = false;
            }
        }


        triggerMultiple(x, y,canvas.pencilCol);

        canvas.repaint();
    }

    public void triggerMultiple(int x, int y,Color color)
    {
        Stack<int[]> stack = new Stack<int[]>();
        stack.push(new int[]{x,y});

        while (!stack.empty())
        {
            int[] cords = stack.pop();
            x = cords[0];
            y = cords[1];

            if(x<0 || y<0 || x >= can.image.getWidth()|| y >= can.image.getHeight())
            {
                continue;
            }
            if(can.image.getRGB(x,y) != targetColor || checktable[x][y])
            {
                continue; //skips this loop
            }
            can.image.setRGB(x,y,color.getRGB());
            checktable[x][y] = true;

            stack.push(new int[]{x+1,y});
            stack.push(new int[]{x-1,y});
            stack.push(new int[]{x,y+1});
            stack.push(new int[]{x,y-1});
        }
        
    }

    public void mouseDragged(MouseEvent e, Canvas canvas){
        //We don't need this
    }

    public void mouseReleased(MouseEvent e, Canvas canvas) {
        can = canvas;
        canvas.repaint();
    }

}



