package ButtonListener;

import Canvas.Canvas;
import GUI.ToolBar;
import Image.ImageFunctions;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * 
 * The ImageFunctionListener class listens to events from the GUI's image
 * manipulation buttons.
 * It uses the ImageFunctions class to perform image manipulation on the
 * currently selected image.
 */
public class ImageFunctionListener implements ActionListener {
    Canvas can;
    ToolBar tools;
    ImageFunctions f;


    /**
     * Constructs an ImageFunctionListener object.
     * 
     * @param can   The Canvas object to manipulate the image on.
     * @param tools The ToolBar object containing the image manipulation buttons.
     */
    public ImageFunctionListener(Canvas can, ToolBar tools) {
        this.can = can;
        this.tools = tools;
        f = new ImageFunctions();
    }

    /**
     * Provides an  image when an image is selected from a user's computer.
     * 
     * @param e The ActionEvent object representing the button press event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == tools.invert) {
            if (can.resizedBufferedImage != null) {
                can.resizedBufferedImage = f.createInverted(can.resizedBufferedImage);
                can.toolIndex = 5;
                can.drawAll();
            }
        } else if (e.getSource() == tools.flip) {
            if (can.resizedBufferedImage != null) {
                can.resizedBufferedImage = f.createFlipped(can.resizedBufferedImage);
                can.toolIndex = 5;
                can.drawAll();
            }
        }
    }
}
