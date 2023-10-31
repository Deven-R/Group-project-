package ButtonListener;

import Canvas.Canvas;
import GUI.ToolBar;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

/**
 * 
 * ActionListener for opening an image file and converting it to pixels.
 */
public class imgListener implements ActionListener {
    Canvas can;
    ToolBar tools;
    Dimension screenSize;

    /**
     * Constructor for imgListener class.
     * 
     * @param can   the canvas to draw on
     * @param tools the toolbar containing the image button
     */
    public imgListener(Canvas can, ToolBar tools) {
        this.can = can;
        this.tools = tools;
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    }

    /**
     * Handles the opening of the file chooser and conversion of the selected image
     * to pixels.
     * 
     * @param e the action event triggered by the image button
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("PNG Images", "png", "jpeg", "jpg", "gif");
        fileChooser.setFileFilter(filter);
        int returnValue = fileChooser.showOpenDialog(null);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();

            try {
                can.newImage = ImageIO.read(selectedFile);
            } catch (IOException k) {
                k.printStackTrace();
            }
            int width = (int) (screenSize.getWidth() / 2); // the desired width of the resized image
            int height = (int) (screenSize.getHeight() / 2); // the desired height of the resized image

            Image resizedImage = can.newImage.getScaledInstance(width, height, Image.SCALE_SMOOTH);
            can.resizedBufferedImage = new BufferedImage(400, 400, BufferedImage.TYPE_INT_ARGB);
            Graphics2D g2d = can.resizedBufferedImage.createGraphics();
            g2d.drawImage(resizedImage, 0, 0, 400, 400, null);
            g2d.dispose();

           /* // Convert the image to pixels
            int imageWidth = can.resizedBufferedImage.getWidth();
            int imageHeight = can.resizedBufferedImage.getHeight();
            int[][] pixels = new int[imageHeight][imageWidth];
            for (int y = 0; y < imageHeight; y++) {
                for (int x = 0; x < imageWidth; x++) {
                    pixels[y][x] = can.resizedBufferedImage.getRGB(x, y);
                }
            }
            can.pixels = pixels;*/

        }
        tools.img.setFocusPainted(true);
        can.toolIndex = 5;
        can.drawAll();
    }

}
