package Canvas;

import Tools.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**

 The MouseEventFrame class implements a MouseAdapter to handle mouse events on a canvas.
 It sets the current tool based on the selected tool and passes the event to the corresponding tool object
 It also sets the background color of the canvas on mouse enter event.
 */
public class MouseEventFrame extends MouseAdapter {
    Canvas canvas;
    /**
     Constructs a MouseEventFrame object with a given canvas.
     @param canvas the canvas object to handle mouse events.
     */
    public MouseEventFrame(Canvas canvas) {
        this.canvas = canvas;
    }

    /**
     Called when the mouse button is pressed.
     Sets the current tool based on the selected tool and passes the event to the corresponding tool object.
     If no tool is selected, the current tool is set to null.
     @param e the mouse event
     */
    public void mousePressed(MouseEvent e) {
        if(canvas.pencilSelected) {
            canvas.currentTool = new PencilTool();
            canvas.currentTool.mousePressed(e, canvas);
        }else if(canvas.eraserSelected) {
            canvas.currentTool = new Eraser();
            canvas.currentTool.mousePressed(e, canvas);
        }
        else if(canvas.fillBucketSelected){
            canvas.currentTool = new FillBucket();
            canvas.currentTool.mousePressed(e, canvas);
        }
        else if(canvas.brushSelected){
            canvas.currentTool = new Brush();
            canvas.currentTool.mousePressed(e, canvas);
        }
        else if(canvas.zoomSelected){
            canvas.currentTool =  new ZoomTool();
            canvas.currentTool.mousePressed(e, canvas);
        }
        else if(canvas.textToolSelected) {
            canvas.currentTool = new TextTool();
            canvas.currentTool.mousePressed(e, canvas);
        }
        else if(canvas.currentTool == null){
            canvas.currentTool.mousePressed(e, canvas);
        }
    }

    /**
     Called when the mouse is dragged.
     Passes the mouse event to the current tool object to handle the dragging.
     @param e the mouse event
     */

    public void mouseDragged(MouseEvent e) {
        canvas.currentTool.mouseDragged(e, canvas);
    }
    /**
     Called when the mouse button is released.
     Passes the mouse event to the current tool object to handle the releasing.
     @param e the mouse event
     */
    public void mouseReleased(MouseEvent e) {
        canvas.currentTool.mouseReleased(e, canvas);
    }
    /**
     Called when the mouse enters the canvas.
     Sets the background color of the canvas to white.
     @param e the mouse event
     */
    public void mouseEntered(MouseEvent e) {
        canvas.setBackground(Color.white);
    }

    public void mouseExited(MouseEvent e) {
    }

}
