package Tutorial.gui;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


/**
 * This class is another GUI class which is shown when you click 'Tutorial' on the showLoader class.
 */
public class tutorial {

    JButton turkish;
    JButton chinese;
    JButton english;
    JButton penciltool;
    JButton brushtool;
    JButton erasertool;
    JButton texttool;
    JButton buckettool;
    JButton fliptool;
    JButton inverttool;
    JButton zoomtool;
    JFrame tutorialframe;



    /**
     * tutorial() contains all elements required to get all the buttons that link to each tools' individual tutorial.
     */
    public void tutorial() {

        //Main JFrame for the tutorial class
        tutorialframe = new JFrame();
        tutorialframe.setTitle("Select Tool to Learn");
        tutorialframe.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        tutorialframe.setSize(800, 300);
        tutorialframe.setVisible(true);
        tutorialframe.setLocationRelativeTo(null);

        //Importing the GIF used as a mascot
        URL url = this.getClass().getResource("love-you.gif");
        Icon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon);
        tutorialframe.add(label, BorderLayout.CENTER);
        label.setBackground(Color.WHITE);
        label.setLayout(new BoxLayout(label, BoxLayout.PAGE_AXIS));

        //Adding all JButtons as links for further tutorials
         penciltool = new JButton("Pencil ");
         brushtool = new JButton("Brush");
         erasertool = new JButton("Eraser");
         texttool = new JButton("TextBox");
         buckettool = new JButton("Fill Bucket");
         fliptool = new JButton("Flip image 180");
         inverttool = new JButton("Invert image");
         zoomtool = new JButton("Zoom");


        //Buttons for JToolBar to add language support.
        turkish = new JButton("Türkçe");
        chinese = new JButton("中国人");
        english = new JButton("English");
        JToolBar languages = new JToolBar();
        languages.revalidate();

       //Adding all the buttons to the frame.
        label.add(penciltool);
        label.add(brushtool);
        label.add(erasertool);
        label.add(texttool);
        label.add(buckettool);
        label.add(zoomtool);
        label.add(texttool);
        label.add(fliptool);
        label.add(inverttool);

        languages.add(turkish);
        languages.add(chinese);
        languages.add(english);

        tutorialframe.add(languages, BorderLayout.NORTH);

        //add more buttons with icons

        label.add(Box.createHorizontalGlue());


        //All ActionListeners for buttons.
        penciltool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PencilTutorial pentutorial = new PencilTutorial();
                pentutorial.PencilTutorial();
            }
        });

        brushtool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BrushTutorial brushtutorial = new BrushTutorial();
                brushtutorial.BrushTutorial();
            }
        });

        erasertool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EraserTutorial erasertutorial = new EraserTutorial();
                erasertutorial.EraserTutorial();
            }
        });

        texttool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextTutorial text = new TextTutorial();
                text.TextTutorial();
            }
        });

        buckettool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               BucketTutorial bucket = new BucketTutorial();
               bucket.BucketTutorial();
            }
        });

        fliptool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FlipTutorial flip = new FlipTutorial();
                flip.FlipTutorial();
            }
        });

        zoomtool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ZoomTutorial zoom = new ZoomTutorial();
                zoom.ZoomTutorial();
            }
        });

        inverttool.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InvertTutorial invert = new InvertTutorial();
                invert.InvertTutorial();
            }
        });

        //Language Support.
        english.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                penciltool.setText("Pencil");
                brushtool.setText("Brush");
                erasertool.setText("Eraser");
                texttool.setText("TextBox");
                tutorialframe.setTitle("Select Tool to Learn");
                buckettool.setText("Fill Bucket");
                fliptool.setText("Flip image 180");
                inverttool.setText("Invert Image");
                zoomtool.setText("Zoom");
            }
        });

        turkish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                penciltool.setText("Kalem");
                brushtool.setText("Boya Fırçası");
                erasertool.setText("Silgi");
                texttool.setText("Metin");
                tutorialframe.setTitle("Öğrenmek Için Araç Seçin");
                buckettool.setText("Kova");
                fliptool.setText("Çevir");
                inverttool.setText("Tersine Çevir");
                zoomtool.setText("Yakılaştırma");
            }
        });

        chinese.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                penciltool.setText("铅笔");
                brushtool.setText("画笔");
                erasertool.setText("橡皮擦");
                texttool.setText("文本框");
                tutorialframe.setTitle("选择要学习的工具");
                buckettool.setText("填充桶");
                fliptool.setText("翻转图像180");
                inverttool.setText("反转图像");
                zoomtool.setText("缩放");
            }
        });




            }


    }


