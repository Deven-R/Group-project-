package GUI;

import ButtonListener.EraserListener;
import ButtonListener.PencilListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Hashtable;

import ButtonListener.PrimaryColorListener;
import Canvas.MouseEventFrame;
import Canvas.Canvas;
import Files.Tabs;


/**
 * The class Toolbar consists of all buttons and sliders that make up the Toolbar in the XYZ editor.
 * Buttons of all tools such as pencil, colors and fill bucket are made and added to the toolbar class.
 */
public class ToolBar{

    public int thickness;
    protected final JToolBar toolbar;
    protected final JPanel toolPanel;

    protected boolean pencilSelected;

    public MouseEventFrame fp;

    public JButton flip;
    public JButton invert;

    public JButton paint;
    public JButton zoom;
    public JButton redo;
    public JButton text;
    public JButton fill;
    public  JButton eraser;
    public JButton img;
    public  JButton pencil;
    public JButton undo;
    public JButton red_circle;
    public JButton yellow_circle;
    public JButton green_circle;
    public JButton colors;
    public JSlider resize;
    public JButton textTool;

    private static Canvas canvas;

    /**
     * @param can
     * Takes the parameter canvas and is an initialization of the toolbar on the canvas.
     */
    public ToolBar(Canvas can){
        this.canvas = can;
        toolbar = new JToolBar();          //Creates Toolbar using Java swing JToolbar
        toolbar.setRollover(true);        //Setting RollOver state
        toolPanel = new JPanel();        // Using JPanel as a platform to add Toolbar on

        toolbar.setBackground(Color.white);       //Setting toolbar color = white
        toolbar.setBorder(BorderFactory.createLineBorder(Color.black,1));
        toolbar.setRollover(true);


        //Setting image icons for each Button in the toolbar
        ImageIcon colorsIcon = new ImageIcon("GUI/icons/colors.jpg");
        ImageIcon paintIcon = new ImageIcon("GUI/icons/paint.png");
        ImageIcon zoomIcon = new ImageIcon("GUI/icons/zoom.png");
        ImageIcon undoIcon    = new ImageIcon("GUI/icons/undo.png");
        ImageIcon textIcon = new ImageIcon("GUI/icons/text.png");
        ImageIcon fillIcon = new ImageIcon("GUI/icons/fill.png");
        ImageIcon eraserIcon = new ImageIcon("GUI/icons/eraser.png");
        ImageIcon imgIcon = new ImageIcon("GUI/icons/img.png");
        ImageIcon pencilIcon = new ImageIcon("GUI/icons/pencil.png");
        ImageIcon redoIcon = new ImageIcon("GUI/icons/redo.png");
        ImageIcon redIcon = new ImageIcon("GUI/icons/redcircle.png");
        ImageIcon yellowIcon = new ImageIcon("GUI/icons/yellowCircle.png");
        ImageIcon greenIcon = new ImageIcon("GUI/icons/greenCircle.png");
        ImageIcon flipIcon = new ImageIcon("GUI/icons/flip.png");

        //Setting image icon and resizing them to fit accordingly
        Image flipimage = flipIcon.getImage(); // transform it
        Image newflip = flipimage.getScaledInstance(35, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        flipIcon = new ImageIcon(newflip);  // transform it back

        ImageIcon invertIcon = new ImageIcon("GUI/icons/invert-tool.png"); // load the image to a imageIcon
        Image invertimage = invertIcon.getImage(); // transform it
        Image newinvert = invertimage.getScaledInstance(35, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        invertIcon = new ImageIcon(newinvert);  // transform it back


        //Initializing Buttons for the toolbar, adding properties such as Border Paint and ToolTipText as signifiers
        paint = new JButton(paintIcon);
        paint.setBorderPainted(false);
        paint.setToolTipText("Paint Brush");
        paint.setFocusPainted(false);

        zoom = new JButton(zoomIcon);
        zoom.setBorderPainted(false);
        zoom.setFocusPainted(false);

        undo = new JButton(undoIcon);
        undo.setBorderPainted(false);
        undo.setFocusPainted(false);

        text = new JButton(textIcon);
        text.setBorderPainted(false);
        text.setToolTipText("Add Text");
        text.setFocusPainted(false);

        fill = new JButton(fillIcon);
        fill.setFocusPainted(false);
        fill.setToolTipText("Fill Tool");
        fill.setBorderPainted(false);

        eraser = new JButton(eraserIcon);
        eraser.setBorderPainted(false);
        eraser.setToolTipText("Erase");
        eraser.setFocusPainted(false);


        img = new JButton(imgIcon);
        img.setFocusPainted(false);
        img.setToolTipText("Add Image");
        img.setBorderPainted(false);

        pencil = new JButton(pencilIcon);
        pencil.setBorderPainted(false);
        pencil.setToolTipText("Pencil");
        pencil.setFocusPainted(false);

        redo = new JButton(redoIcon);
        redo.setFocusPainted(false);
        redo.setBorderPainted(false);

        red_circle = new JButton(redIcon);
        red_circle.setBorderPainted(false);
        red_circle.setToolTipText("Color Red");
        red_circle.setFocusPainted(false);


        yellow_circle = new JButton(yellowIcon);
        yellow_circle.setFocusPainted(false);
        yellow_circle.setToolTipText("Color Yellow");
        yellow_circle.setBorderPainted(false);


        green_circle = new JButton(greenIcon);
        green_circle.setBorderPainted(false);
        green_circle.setToolTipText("Color Green");
        green_circle.setFocusPainted(false);

        colors = new JButton(colorsIcon);
        colors.setBorderPainted(false);
        colors.setToolTipText("Choose Color");
        colors.setFocusPainted(false);

        textTool = new JButton();
        textTool.setBorderPainted(false);
        textTool.setToolTipText("Add Text");
        textTool.setFocusPainted(false);

        flip =  new JButton(flipIcon);
        flip.setFocusPainted(false);
        flip.setBorderPainted(false);
        flip.setToolTipText("Flip Image");

        invert = new JButton(invertIcon);
        invert.setToolTipText("Invert Image");
        invert.setBorderPainted(false);
        invert.setFocusPainted(false);

        resize = new JSlider(5, 100, 100);
        resize.setMinorTickSpacing(5);
        resize.setMajorTickSpacing(10);
        resize.setPaintTicks(true);

        //Create a label for the slider to accommodate numbering
        Hashtable<Integer, JLabel> labels = new Hashtable<>();
        for(int i = 5; i < 105; i+=5){
            String x = Integer.toString(i);
            labels.put(i, new JLabel(x)); 
        }
        resize.setLabelTable(labels);
        resize.setPaintLabels(true);
        resize.addKeyListener(null);

        //Adding all the buttons and elements to the toolbar
        toolbar.add(paint);
        toolbar.add(pencil);
        toolbar.add(eraser);
        toolbar.add(fill);
        toolbar.add(zoom);
        toolbar.add(text);
        toolbar.add(img);
        toolbar.add(undo);
        toolbar.add(redo);
        toolbar.addSeparator();
        toolbar.add(red_circle);
        toolbar.add(yellow_circle);
        toolbar.add(green_circle);
        toolbar.add(colors);
        toolbar.addSeparator();
        toolbar.add(flip);
        toolbar.add(invert);
        toolbar.add(resize);

        toolbar.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        toolPanel.add(toolbar);



    }


    /**
     * @param can
     * To allow for the tools to interact with the canvas.
     */
    public void setCanvas(Canvas can){
        this.canvas = can;
    }

}







