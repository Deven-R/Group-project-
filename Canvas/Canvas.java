package Canvas;

import Tools.*;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.awt.image.ConvolveOp;
import java.awt.image.Kernel;
import java.util.Stack;


/***
 * This class is a developer-created canvas that extends JPanel.
 * It represents a drawing area where user can draw various shapes using various drawing tools.
 * The class contains instances to keep tracks of the state of current tools.
 */
public class Canvas extends JPanel{

    public  int[][] pixels;

    public BufferedImage redoImage;

    private boolean pressed = false;



    public int toolIndex;
    boolean show = true;
    public int thickness = 3;
    public int brushThickness = 100;
    private char character;
    public Font font;
    String l;


    public BufferedImage image;
   public BufferedImage newImage = null;
   public BufferedImage resizedBufferedImage;
   public String word;

    public boolean eraserSelected = false;
    public boolean pencilSelected = false;

    public boolean brushSelected = false;

    public boolean fillBucketSelected = false;

    public Color pencilCol = Color.BLACK;

    private int posX, posY, endX, endY;
    public int x, y;
    private int width, height;

   public boolean newDrawing = false;
   private int newWidth = 100, newHeight = 100;
   private int oldWidth = 0, oldHeight = 0;
   public Stack undo;
   public Stack redo;
   public boolean isRedo = false;


    public List<Line> lines = new ArrayList<Line>();
    public List<Line> lines2 = new ArrayList<Line>();

    public Tool currentTool;
    public boolean textToolSelected;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();

   public double s_width = screenSize.getWidth();
    public double s_height = screenSize.getHeight();
    public boolean zoomSelected;


    public Canvas() {
        this.addKeyListener(new Key());
        this.addMouseListener(new CanvasMouseEvent());
        this.addMouseMotionListener(new CanvasMouseEvent());
        setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
        this.setBackground(Color.white);

        image = new BufferedImage((int)s_width,(int)s_height,BufferedImage.TYPE_INT_ARGB);
        redo = new Stack();
        undo = new Stack();

    }
    /**
     *
     * @param tool The icon for the currently selected tool.
     * @param currentTool The tool that is currently selected
     */
    public void setCurrentTool(ImageIcon tool,Tool currentTool) {
        this.currentTool = currentTool;
        if(currentTool instanceof PencilTool) {
            setCursor(Toolkit.getDefaultToolkit().createCustomCursor(tool.getImage().getScaledInstance(16, 16, Image.SCALE_SMOOTH), new Point(2,14), "pencil cursor"));
        }else if(currentTool instanceof Eraser){
            setCursor(Toolkit.getDefaultToolkit().createCustomCursor(tool.getImage().getScaledInstance(20,20,Image.SCALE_SMOOTH), new Point(2,14), "eraser cursor"));
        }
        else if(currentTool instanceof Brush){
            setCursor(Toolkit.getDefaultToolkit().createCustomCursor(tool.getImage().getScaledInstance(22, 20, Image.SCALE_SMOOTH), new Point(2,14), "brush cursor"));
        }
        else if(currentTool instanceof FillBucket){
            setCursor(Cursor.getPredefinedCursor(Cursor.E_RESIZE_CURSOR));
        }
        else if (currentTool instanceof TextTool){
            setCursor(Cursor.getPredefinedCursor(Cursor.TEXT_CURSOR));
        }
        else if(currentTool instanceof ZoomTool){
            setCursor(Toolkit.getDefaultToolkit().createCustomCursor(tool.getImage().getScaledInstance(22, 20, Image.SCALE_SMOOTH), new Point(2,14), "Zoom cursor"));
        }
        else if (currentTool == null){
            setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            toolIndex = 0;
        }
    }
    /**

     Overrides the paintComponent method to paint the graphics on the canvas.
     @param g The graphics object used to paint the canvas.
     */

    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        if(zoomSelected){
            AffineTransform scalingTransform =
                    AffineTransform.getScaleInstance(2,2);
            g2.transform(scalingTransform);
        }
        if(newDrawing){
            image = null;
            g2.drawImage(resizedBufferedImage, 0, 0, null);
            image = resizedBufferedImage;
        }
        if(isRedo){
            g2.drawImage(image, 0, 0, null);
        }
            g2.drawImage(image, 0, 0, null);

    }
    /**
     * Adds a line to the canvas with the given start and end coordinates, using the current tool.
     * The line is added to the list of lines in the current tool and then the canvas is repainted.
     *
     * @param x1 The x-coordinate of the starting point of the line.
     * @param y1 The y-coordinate of the starting point of the line.
     * @param x2 The x-coordinate of the ending point of the line.
     * @param y2 The y-coordinate of the ending point of the line.
     */

    public void addLine(int x1, int y1, int x2, int y2) {
        currentTool.addLine(x1, y1, x2, y2, lines, pencilCol,this.thickness);
        repaint();
    }



    public void eraseLine(int x1, int y1, int x2, int y2, List<Line> lines) {
        currentTool.eraseLine(x1, y1, x2,  y2,  lines);
    }

    /**
     *
     * @param state Sets the tool in the canvas to pencil
     */
    public void setPencilSelected(boolean state){
        this.pencilSelected = state;
    }

    /**
     *
     * @param state Sets the tool in the canvas to eraser
     */

    public void setEraserSelected(boolean state){
        this.eraserSelected = state;
    }
    /**
     *
     * @param state Sets the tool in the canvas to fillBucket
     */

    public void setFillBucketSelected(boolean state){
        this.fillBucketSelected = state;
    }
    /**
     *
     * @param col Sets the pencil tool color in the canvas
     */

    public void setPencilCol(Color col){
        this.pencilCol = col;
    }
    /**
     *
     * @param state Sets the tool in the canvas to Text Tool
     */

    public void setTextTool(boolean state){
        this.textToolSelected = state;
    }
    /**
     *
     * @param thickness is the thickness of the brush in the canvas to eraser
     */

    public void setThickness(int thickness){
        this.thickness = thickness;
    }
    /**
     *
     * @param state Sets the tool in the canvas to brush
     */
    public void setBrushSelected(boolean state){
        this.brushSelected = state;
    }
    /**
     *
     * @param state Sets the tool in the canvas to zoom
     */

    public void setZoomSelected(boolean state){this.zoomSelected = state;}

    /**Draws on the canvas based on the currently selected tool.
     Supports multiple tools such as pencil, eraser, shape drawing, image flipping, color inversion, and text drawing.
     The graphics are rendered with antialiasing and high quality rendering.
     The drawn image is pushed to the undo stack for potential later use.
     */

    public void drawAll(){
        Graphics2D g2d = (Graphics2D) image.getGraphics();
        //This vodoo makes the drawings look prettier
        g2d.setRenderingHint(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setRenderingHint(
                RenderingHints.KEY_RENDERING,
                RenderingHints.VALUE_RENDER_QUALITY);

        switch(toolIndex){
            case 4:
                if (width != 0 && height != 0){
                    g2d.setColor(pencilCol);
                    g2d.fillRect(posX, posY, width, height);
                    break;
                }
            case 5:
                g2d.drawImage(resizedBufferedImage,newWidth , newHeight, null);
                break;
            case 8:
                for (int y = 0; y < pixels.length; y++) {
                    for (int x = 0; x < pixels[y].length; x++) {
                        g2d.setColor(new Color(pixels[y][x]));
                        g2d.fillRect(500+x, 100+y, 1, 1);
                    }
                }
                break;
            case 9:
                break;
            case 14:
                g2d.setColor(Color.BLACK);
                float[] dashPattern = {10f, 5f};
                BasicStroke dashed = new BasicStroke(2f, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10f, dashPattern, 0f);
                g2d.setStroke(dashed);
                g2d.drawRect(posX,posY,width, height);
                break;
            case 15:
                g2d.setColor(Color.WHITE);
                g2d.fillRect(oldWidth, oldHeight, resizedBufferedImage.getWidth()+20, resizedBufferedImage.getHeight()+20);
                g2d.drawImage(resizedBufferedImage, newWidth, newHeight, null);
                break;
            case 11:
                Font currentFont = g2d.getFont();
                Font newFont = currentFont.deriveFont(currentFont.getSize() * 1.4F);
                g2d.setFont(newFont);
                g2d.setColor(pencilCol);
                posX += g2d.getFontMetrics().stringWidth(String.valueOf(character));
                l = l.toUpperCase();
                g2d.drawString(l,posX,posY);
                break;
            case 12:
                g2d.setColor(pencilCol);
                g2d.setFont(font);
                g2d.drawString(word,x,y);
                break;
            case 18:
                for (int y = 0; y < pixels.length; y++) {
                    for (int x = 0; x < pixels[y].length / 2; x++) {
                        int temp = pixels[y][x];
                        pixels[y][x] = pixels[y][pixels[y].length - x - 1];
                        pixels[y][pixels[y].length - x - 1] = temp;

                        // Draw the flipped pixels
                        g2d.setColor(new Color(pixels[y][pixels[y].length - x - 1]));
                        g2d.fillRect(500+pixels[y].length - x - 1, 100+y, 1, 1);
                    }
                }
                break;
            case 19:
                for (int y = 0; y < pixels.length; y++) {
                    for (int x = 0; x < pixels[y].length; x++) {
                        int pixel = pixels[y][x];
                        int alpha = (pixel >> 24) & 0xff;
                        int red = (pixel >> 16) & 0xff;
                        int green = (pixel >> 8) & 0xff;
                        int blue = pixel & 0xff;
                        red = 255 - red;
                        green = 255 - green;
                        blue = 255 - blue;
                        pixels[y][x] = (alpha << 24) | (red << 16) | (green << 8) | blue;

                        // Draw the inverted pixel at its new position
                        g2d.setColor(new Color(pixels[y][x]));
                        g2d.fillRect(500+x, 100+y, 1, 1);
                    }
                }
                break;
            case 20:
                g2d.drawOval(100, 100, 50,50);
                break;
            case 44:
                g2d.drawImage(redoImage,0,0,null);
                break;
        }
        g2d.dispose();
        repaint();
    }
    /**

     This class represents a mouse event on a canvas. It implements MouseListener and MouseMotionListener interfaces to
     capture various mouse events and trigger relevant actions in the application.
     */

    private class CanvasMouseEvent implements MouseListener, MouseMotionListener {

        /**
         Triggered when the mouse is clicked on the canvas.
         @param e MouseEvent object that contains information about the mouse event.
         */
        @Override
        public void mouseClicked(MouseEvent e) {
            if(currentTool == null) {
                posX = e.getX();
                posY = e.getY();

                toolIndex = 11;
                drawAll();


            }
        }
        /**
         * This is use to write directly on the canvas when no tool has been selected (Alternative to Text tool)
         Triggered when the mouse is pressed on the canvas.
         @param e MouseEvent object that contains information about the mouse event.
         */
        @Override
        public void mousePressed(MouseEvent e) {
            if(currentTool == null) {
                requestFocus();
                posX = e.getX();
                posY = e.getY();
            }
            pressed = true;
        }
        /**

         {@inheritDoc}
         This method is called when the mouse button is released. If the current tool is null and a mouse button has been
         previously pressed, it will draw a rectangle on the canvas using the starting and ending coordinates of the
         mouse event. The dimensions of the rectangle are calculated as the absolute difference between the starting and
         ending X and Y coordinates.
         @param e The MouseEvent that triggered the method call.
         */
        @Override
        public void mouseReleased(MouseEvent e) {
            if(currentTool == null && pressed) {
                endX = e.getX();
                endY = e.getY();
                width = Math.abs(endX - posX);
                height = Math.abs(endY - posY);
                toolIndex = 14;
                drawAll();


            }
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {

        }
        /**
         *
         * @param e use to update the position of the mouse in the canvas
         * Called when a mouse button is released on the canvas.
         * If the current tool is null and the mouse button was pressed, the endX and endY
         * variables are set to the X and Y coordinates of the mouse release, the width and height
         * are calculated from the difference between posX, posY, endX, and endY, the toolIndex is
         * set to 14 (rectangle drawing tool), drawAll() is called, and the current image is pushed
         * onto the undo stack. If the mouse button was pressed without a current tool, only the current
         * image is pushed onto the undo stack.
         */

        @Override
        public void mouseDragged(MouseEvent e) {
            if(currentTool != null) {
                Graphics2D g2d = (Graphics2D) image.getGraphics();
                //This vodoo makes the drawings look prettier
                g2d.setRenderingHint(
                        RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);
                g2d.setRenderingHint(
                        RenderingHints.KEY_RENDERING,
                        RenderingHints.VALUE_RENDER_QUALITY);

                int x = e.getX();
                int y = e.getY();


                switch (toolIndex) {
                    case 0:
                        g2d.setColor(Color.WHITE);
                        float dash1[] = {10.0f};
                        BasicStroke dashed = new BasicStroke(1.0f,
                                BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10.0f, dash1, 0.0f);
                        g2d.setStroke(dashed);
                        g2d.drawRect(posX, posY, 50, 10);
                        break;
                    case 1:
                        for (Line lines : lines) {
                            lines.drawLinePencil(g2d);
                        }
                        break;
                    case 2:
                        g2d.setColor(getBackground());
                        Eraser m = new Eraser();
                        if(!(lines.isEmpty()) || !(lines2.isEmpty())) {
                            g2d.fillRect(x, y, 20, 20);
                            m.eraseArea(e.getX(), e.getY(), 20, 20, lines);
                            }
                        if(!(lines2.isEmpty())){
                            g2d.fillOval(x,y,30,30);
                            m.eraseArea(e.getX(), e.getY(), 20, 20, lines2);
                        }
                        break;
                    case 6:
                        newDrawing = true;
                        break;
                    case 7:
                        //redo = true;
                        break;
                    case 10:
                        for (Line lines : lines2) {
                            lines.drawLineBrush(g2d, brushThickness);
                        }
                        break;
                    case 50:
                        g2d.setColor(getBackground());
                        g2d.fillRect(x, y, 20, 20);
                        Eraser f = new Eraser();
                        if(lines2 != null) {
                            f.eraseArea(e.getX(), e.getY(), 20, 20, lines2);
                        }
                        break;

                }
                g2d.dispose();
                repaint();
            }
            else{
                endX = e.getX();
                endY = e.getY();
                toolIndex = 14;
            }

        }

        @Override
        public void mouseMoved(MouseEvent e) {

        }
    }
    /**
     A private class that implements KeyListener interface to handle keyboard input
     */
    private class Key implements KeyListener{

        /**
         Invoked when a key has been typed.
         Updates the character and word fields with the key that was typed, and sets the toolIndex to 11 to enable text tool.
         Then calls the drawAll() method to update the canvas with the new text in the canvas.
         @param e the KeyEvent object that represents the key typed
         */
        @Override
        public void keyTyped(KeyEvent e) {
            character = e.getKeyChar();
           word = String.valueOf( e.getKeyChar());
           toolIndex = 11;
           drawAll();
        }
        /**

         This method is an implementation of the keyPressed method in the KeyListener interface.
         It handles user key presses and performs actions based on the keys pressed.
         @param e KeyEvent object representing the key press event.
         */
        @Override
        public void keyPressed(KeyEvent e) {
            int keyEvent = e.getKeyCode();
            if(e.getKeyCode() == 8){
                word = word.substring(0, word.length()-1);
                toolIndex = 11;
                drawAll();

            }

             if(e.getKeyCode() == 0){
                JFrame f = new JFrame("Emojis and shapes");
                f.setLayout(new GridLayout(3,5));
                f.setSize(250,450);
                f.setLocationRelativeTo(null);
                JButton button = new JButton("Circle");
                button.setFocusPainted(true);
                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        toolIndex = 20;
                        drawAll();
                    }
                });
                button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                JButton button1 = new JButton("Triangle");
                button1.setFocusPainted(true);
                button1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                JButton button2 = new JButton("Square");
                button2.setFocusPainted(true);
                button2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                JButton button3 = new JButton("Star");
                button3.setFocusPainted(true);
                button3.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                JButton button4 = new JButton(new ImageIcon("Canvas/smiley.png"));
                button4.setFocusPainted(true);
                button4.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                JButton button5 = new JButton(new ImageIcon("Canvas/angry.png"));
                button5.setFocusPainted(true);
                button5.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
                f.add(button);
                f.add(button1);
                f.add(button2);
                f.add(button3);
                f.add(button4);
                f.add(button5);
                if(show) {
                    f.setVisible(true);
                    show = false;
                }
                else{
                    f.setVisible(false);
                    show = true;
                }
            }
             switch (keyEvent){
                 case 38:
                     if(resizedBufferedImage != null){
                         oldHeight = newHeight;
                         newHeight -= 20;
                         toolIndex = 15;
                         drawAll();
                         break;
                     }
                 case 40:
                     if(resizedBufferedImage != null){
                         oldHeight = newHeight;
                         newHeight += 20;
                         toolIndex = 15;
                         drawAll();
                         break;
                     }
                 case 37:
                     if(resizedBufferedImage != null){
                         oldWidth = newWidth;
                         newWidth -= 10;
                         toolIndex = 15;
                         drawAll();
                         break;
                     }
                 case 39:
                     if(resizedBufferedImage != null){
                         oldWidth = newWidth;
                         newWidth += 10;
                         toolIndex = 15;
                         drawAll();
                         break;
                     }


             }
        }

        @Override
        public void keyReleased(KeyEvent e) {

        }
    }

    /*
     * Blurs the image then returns a bufferedimage as the result
     */
    private static BufferedImage blur(BufferedImage image)
    {
        BufferedImage result = new BufferedImage(image.getWidth(),image.getHeight(),image.getType());
        float[] data = {1,  4,  6,  4,  1,
                        4,  16, 24, 16, 4,
                        6,  24, 36, 24, 6,
                        4,  16, 24, 16, 4,
                        1,  4,  6,  4,  1};
        for(int i=0;i<data.length;i++)
        {
            data[i] = data[i]/256;
        }
        Kernel kernel = new Kernel(5,5,data);
        ConvolveOp colvolve = new ConvolveOp(kernel,ConvolveOp.EDGE_NO_OP,null);
        colvolve.filter(image, result);
        return result;
    }

    private static BufferedImage sharpen(BufferedImage image)
    {
        BufferedImage result = new BufferedImage(image.getWidth(),image.getHeight(),image.getType());
        float[] data = {0, -1,  0,
                       -1,  5, -1,
                        0, -1,  0};
        Kernel kernel = new Kernel(3,3,data);
        ConvolveOp colvolve = new ConvolveOp(kernel,ConvolveOp.EDGE_NO_OP,null);
        colvolve.filter(image, result);
        return result;
    }

    public void blurImage()
    {
        image = blur(image);
    }

    public void sharpenImage()
    {
        image = sharpen(image);
    }

}
