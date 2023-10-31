package Tools;
import Canvas.Canvas;
import Canvas.Line;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.util.List;
import java.awt.geom.AffineTransform;

public class ZoomTool implements Tool {
    int count = 0;

    private int zoomFactor = 2;
    private AffineTransform affineTransform = new AffineTransform();

    @Override
    public void addLine(int x1, int y1, int x2, int y2, List<Line> lines, Color color, int thickness) {
        // Not applicable for the ZoomTool
    }

    @Override
    public void eraseLine(int x1, int y1, int x2, int y2, List<Line> lines) {
        // Not applicable for the ZoomTool
    }

    @Override
    public void mousePressed(MouseEvent e, Canvas canvas) {
        count = count + e.getClickCount();
    }

    @Override
    public void mouseDragged(MouseEvent e, Canvas canvas) {
        // Not applicable for the ZoomTool
    }

    @Override
    public void mouseReleased(MouseEvent e, Canvas canvas) {
        System.out.println(count);
       /* zoomFactor = 2;
        Graphics g = canvas.image.getGraphics();
        Graphics2D g2 = (Graphics2D) g;*/
        if(count == 2){
            canvas.toolIndex = 9;
        }
        /*AffineTransform affineTransform = new AffineTransform();
        affineTransform.scale(2, 2);
        g2.setTransform(affineTransform);*/
    }
}

