package GUI;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import ButtonListener.*;
import ButtonListener.TextListener;

import Canvas.Canvas; // Created Package
import Canvas.MouseEventFrame;
import Files.Tabs;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.undo.UndoManager;

import Tutorial.gui.IntroTutorial;
//import GUI.ToolBar.NewFile;


/**
 * Main class to compile the User Interface of the editor. With all elements that a user sees while using the application.
 * Important thing to note is : This application is dependent on JavaSwing and other Java API's to run.
 * Window uses JFrame of JavaSwing to display GUI.
 */
public class Window extends JFrame implements ComponentListener{


    protected JPanel mainPanel;
   protected JPanel darkMode;
    protected JMenuBar menuBar;
     protected Canvas can;
    public JMenuItem subMenuItemNew;
    protected Tabs tab;




    protected ToolBar tools;

    public JMenuItem subMenuItemEnglish;
    public JMenuItem subMenuItemTurkish;
    public JMenuItem subMenuItemChinese;
    public JMenu menuFile;
    public JMenu menuView;
    public JMenu menuEdit;
    public JMenu menuEffects;
    public JMenu menuTutorial;
    public JMenu menuLanguages;
    public JMenu menuHelp;
    public JMenuItem subMenuItemOpen;
    public JMenuItem subMenuItemSave;
    public JMenuItem subMenuItemTutorial;
    public JMenuItem subMenuItemDelete ;
    public JMenuItem subMenuItemBlur;
    public JMenuItem subMenuItemSharpen;
    public JMenuItem subMenuItemdefault ;
    public JMenuItem subMenuItemaustin ;
    public JMenuItem subMenuItemblues ;
    public JMenuItem subMenuItemcappucino ;
    public JMenuItem subMenuItemUndo;
    public JMenuItem subMenuItemRedo;

    public JLabel HelpText;



    Dimension screenSize;
    /**

     The Window class is responsible for creating the main window of the XYZ Photo Editor. It extends the JFrame class
     and contains the main components of the application, including a menu bar, a toolbar, a tabs panel, and a main panel.
     */
    public Window(){

        setTitle("XYZ Photo Editor");
        tab = new Tabs();
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        double width = screenSize.getWidth();
        double height = screenSize.getHeight();
        setSize((int) width,(int)height);
        setBackground(Color.lightGray);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        tools = new ToolBar(can);
        menuBar();
        setJMenuBar(menuBar);
        mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(tools.toolbar, BorderLayout.NORTH);
        mainPanel.add(tab,BorderLayout.CENTER);
        addComponentListener(this);
        add(mainPanel);
        setResizable(true);
        setVisible(true);
    }

    /**

     Initializes the menu bar and its sub menu items.
     File, Edit, View, Effects, Help, Tutorial, and Language are the main menus in the JMenuBar.
     The sub menu items include: New, Open, Save, Delete, Turn On Tutorial Mode, UndoRedo, Redo, Blur, Sharpen, Default,
     Austin Powers' Theme, Beautiful Blue Theme, Cappuccino Theme, English, Turkish, and Chinese.
     ActionListener and LanguageSetting classes are used to handle actions performed on the menu items.
     The HelpText JLabel provides guidance to the user on how to use the GUI.
     All sub menu items are added to their corresponding main menu items and the menu bar is added to the main window.
     */
    public void menuBar(){
        menuBar = new JMenuBar();
         menuFile=new JMenu("File");          //File,Edit,View and Help are the main menus in the JMenuBar
         menuEdit=new JMenu("Edit");
         menuView=new JMenu("View");
         menuEffects=new JMenu("Effects");
         menuHelp=new JMenu("Help");
         menuTutorial = new JMenu("Tutorial");
         menuLanguages = new JMenu("Language");

        ImageIcon newfileicon = new ImageIcon("GUI/icons/newfile.png");
        Image fileimage = newfileicon.getImage(); // transform it
        Image newfile = fileimage.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        newfileicon = new ImageIcon(newfile);  // transform it back




       // End of inner ActionListener

        ImageIcon openfileicon = new ImageIcon("GUI/icons/openfile.png");
        Image openimage = openfileicon.getImage();
        Image newopenimage = openimage.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH);
        openfileicon = new ImageIcon(newopenimage);

        ImageIcon savefileicon = new ImageIcon("GUI/icons/savefile.png");
        Image saveimage = savefileicon.getImage();
        Image newsaveimage = saveimage.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH);
        savefileicon = new ImageIcon(newsaveimage);

        ImageIcon deletefileicon = new ImageIcon("GUI/icons/deletefile.png");
        Image deleteimage = deletefileicon.getImage();
        Image newdeleteimage = deleteimage.getScaledInstance(15, 15,  java.awt.Image.SCALE_SMOOTH);
        deletefileicon = new ImageIcon(newdeleteimage);



         subMenuItemOpen=new JMenuItem("Open", openfileicon);  //Open and Exit are the sub menu items under 'File' menu item
         subMenuItemSave=new JMenuItem("Save", savefileicon);
         subMenuItemTutorial =new JMenuItem("Turn On Tutorial Mode");
         subMenuItemDelete = new JMenuItem("Delete File", deletefileicon);
        subMenuItemNew = new JMenuItem("New File",newfileicon);


        //EFFECTS (Blur...)
         subMenuItemBlur = new JMenuItem("Blur");
         subMenuItemSharpen = new JMenuItem("Sharpen");

        //THEMES Made (initial ideas) Have to make a different class for all listeners when documenting:
         subMenuItemdefault = new JMenuItem("Default");
         subMenuItemaustin = new JMenuItem("'Austin Powers'' Theme");
         subMenuItemblues = new JMenuItem("Beautiful Blue Theme");
         subMenuItemcappucino = new JMenuItem("Cappuccino Theme");

        //LANGUAGE ACCESSIBILITY:
         subMenuItemEnglish = new JMenuItem("English");
        subMenuItemTurkish = new JMenuItem("Turkish");
        subMenuItemChinese = new JMenuItem("Chinese");

        subMenuItemBlur.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                can.blurImage();
                can.drawAll();
            }
        });

        subMenuItemSharpen.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                can.sharpenImage();
                can.drawAll();
            }
        });

        subMenuItemTutorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                IntroTutorial tutorial = new IntroTutorial();
                tutorial.showLoader();
            }
        });



         subMenuItemUndo = new JMenuItem("UndoRedo");
         subMenuItemRedo = new JMenuItem("Redo");
        subMenuItemUndo.addActionListener(new UndoRedo(can, tools));


        subMenuItemSave.addActionListener(new FileListener());
        subMenuItemOpen.addActionListener(new FileListener());
       subMenuItemNew.addActionListener(new FileListener());
       subMenuItemDelete.addActionListener(new FileListener());



        subMenuItemEnglish.addActionListener(new LanguageSetting(this));
        subMenuItemTurkish.addActionListener(new LanguageSetting(this));
        subMenuItemChinese.addActionListener(new LanguageSetting(this));

       HelpText = new JLabel();
       HelpText.setText("<html> HELP SECTION<br> 1. To open a canvas, click File on the menubar and click New File <br> 2. Once the canvas opens, you are free to use all tools provided in the Toolbar <br> 3. You can also use additional UI features such as : <br> - Changing themes (View --> Themes) <br> - Changing Langauges (Languages --> Turkish) </html>");
       menuHelp.add(HelpText);



// ADDING ALL SUB MENU ITEMS TO THE MAIN WINDOW
        //Language settings added to menubar:
        menuLanguages.add(subMenuItemEnglish);
        menuLanguages.add(subMenuItemChinese);
        menuLanguages.add(subMenuItemTurkish);


        menuFile.add(subMenuItemNew);
        menuFile.add(subMenuItemOpen);
        menuFile.add(subMenuItemSave);
        menuFile.add(subMenuItemDelete);

        menuTutorial.add(subMenuItemTutorial);

        //Effects added to the 'Effects' menubar:
        menuEffects.add(subMenuItemBlur);
        menuEffects.add(subMenuItemSharpen);

        //Themes added onto 'View' menubar:
        menuView.add(subMenuItemaustin);
        menuView.add(subMenuItemblues);
        menuView.add(subMenuItemcappucino);
        menuView.add(subMenuItemdefault);


        // UndoRedo and Redo button added onto 'Edit' menubar:
        menuEdit.add(subMenuItemUndo);
        menuEdit.add(subMenuItemRedo);




        //Added all components to the menubar
        menuBar.add(menuFile);
        menuBar.add(menuEdit);
        menuBar.add(menuView);
        menuBar.add(menuEffects);
        menuBar.add(menuHelp);
        menuBar.add(menuTutorial);
        menuBar.add(menuLanguages);



    }


    /**
     * Resizes the window
     * @param e the event to be processed
     */

    @Override
    public void componentResized(ComponentEvent e) {

        mainPanel.setPreferredSize(new Dimension(getWidth(), getHeight()));

    }

    @Override
    public void componentMoved(ComponentEvent e) {

    }

    @Override
    public void componentShown(ComponentEvent e) {

    }

    @Override
    public void componentHidden(ComponentEvent e) {

    }
private class FileListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == subMenuItemNew) {
            can = tab.addNewCanvas();
            tools.setCanvas(can);
            tools.red_circle.addActionListener(new PrimaryColorListener(can, tools));
            tools.pencil.addActionListener(new PencilListener(can, tools));
            tools.eraser.addActionListener(new EraserListener(can, tools));
            tools.yellow_circle.addActionListener(new PrimaryColorListener(can, tools));
            tools.green_circle.addActionListener(new PrimaryColorListener(can, tools));
            tools.colors.addActionListener(new ColorListener(can, tools));
            tools.fill.addActionListener(new FillBucketListener(can, tools));
            tools.text.addActionListener(new TextListener(can, tools));
            tools.paint.addActionListener(new BrushListener(can, tools, tools.thickness, tools.resize));
            tools.flip.addActionListener(new ImageFunctionListener(can, tools));
            tools.invert.addActionListener(new ImageFunctionListener(can, tools));
            tools.zoom.addActionListener(new ZoomToolListener(can, tools));
            tools.text.addActionListener(new TextListener(can, tools));
            tools.undo.addActionListener(new UndoRedo(can, tools));
            tools.img.addActionListener(new imgListener(can, tools));
        } else if (e.getSource() == subMenuItemSave) {
            JFileChooser fileChooser = new JFileChooser();
            FileFilter filter = new FileNameExtensionFilter("Image files", "jpg", "jpeg", "png", "gif");
            fileChooser.setFileFilter(filter);
            fileChooser.setAcceptAllFileFilterUsed(false);
            int result = fileChooser.showSaveDialog(null);
            if (result == JFileChooser.APPROVE_OPTION) {
                File selectedFile = fileChooser.getSelectedFile();
                String path = selectedFile.getAbsolutePath();
                try {
                    if (can != null) {
                        ImageIO.write(can.image, "png", new File(path));
                    }
                } catch (IOException f) {
                    f.printStackTrace();
                }
            }
        } else if (e.getSource() == subMenuItemOpen) {
            if (can == null) {
                can = tab.addNewCanvas();
                tools.red_circle.addActionListener(new PrimaryColorListener(can, tools));
                tools.pencil.addActionListener(new PencilListener(can, tools));
                tools.eraser.addActionListener(new EraserListener(can, tools));
                tools.yellow_circle.addActionListener(new PrimaryColorListener(can, tools));
                tools.green_circle.addActionListener(new PrimaryColorListener(can, tools));
                tools.colors.addActionListener(new ColorListener(can, tools));
                tools.fill.addActionListener(new FillBucketListener(can, tools));
                tools.text.addActionListener(new TextListener(can, tools));
                tools.paint.addActionListener(new BrushListener(can, tools, tools.thickness, tools.resize));
                tools.flip.addActionListener(new ImageFunctionListener(can, tools));
                tools.invert.addActionListener(new ImageFunctionListener(can, tools));
                tools.zoom.addActionListener(new ZoomToolListener(can, tools));
                tools.text.addActionListener(new TextListener(can, tools));
                tools.img.addActionListener(new imgListener(can, tools));

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


                    Image resizedImage = can.newImage.getScaledInstance((int) screenSize.getWidth(),  screenSize.height, Image.SCALE_SMOOTH);
                    can.resizedBufferedImage = new BufferedImage((int) screenSize.getWidth(),  screenSize.height, BufferedImage.TYPE_INT_ARGB);

                    Graphics2D g2d = can.resizedBufferedImage.createGraphics();
                    g2d.drawImage(resizedImage, 0, 0, null);
                    g2d.dispose();
                }
            } else {
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

                    Image resizedImage = can.newImage.getScaledInstance((int) screenSize.getWidth(), screenSize.height, Image.SCALE_SMOOTH);
                    can.resizedBufferedImage = new BufferedImage((int) screenSize.getWidth(),  screenSize.height, BufferedImage.TYPE_INT_ARGB);

                    Graphics2D g2d = can.resizedBufferedImage.createGraphics();
                    g2d.drawImage(resizedImage, 0, 0, null);
                    g2d.dispose();
                }

            }
            can.image = can.resizedBufferedImage;
            can.toolIndex = 6;
            can.drawAll();

        }
        else if(e.getSource() == subMenuItemDelete){
            if(can != null){
                int result = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete current File",
                        null, JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE );
                if(result == JOptionPane.YES_OPTION) {
                    can.image = null;
                    can.setCurrentTool(null,null);
                   mainPanel.add(null, BorderLayout.CENTER);
                }
            }
        }
    }
}



}

