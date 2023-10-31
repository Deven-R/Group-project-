package Tutorial.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


/**
 * This class is in charge of showing the initial Tutorial that is given to the user when the app begins.
 */
public class IntroTutorial {



    /**
     * showLoader() has all the GUI elements that have been compiled to make up the initial slide of the tutorial.
     * The frame alongside with the language setting menubar, buttons to close or proceed further with the tutorial
     * are all included in this class, alongside with each actionlistener.
     */
    public void showLoader(){

        //Getting the GIF mascot
        URL url = this.getClass().getResource("love-you.gif");
        Icon icon = new ImageIcon(url);
        JLabel label = new JLabel(icon);
        label.setBackground(Color.WHITE);

        //Initializing the frame and its properties.
        JFrame frame = new JFrame ();
        label.setText("HI EVERYONE! IM HERE TO TEACH YOU SOMETHING");
        frame.getContentPane().add(label);
        frame.setVisible(true);
        frame.setSize(1000,500);
        frame.setBackground(Color.WHITE);
        frame.setForeground(Color.WHITE);
        frame.setTitle("Tutorial");
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        label.setLayout(new BoxLayout(label, BoxLayout.LINE_AXIS));

        //Adding all the JButtons used for further actions.
        JButton close = new JButton("Close");
        JButton tutorial = new JButton("Tutorial");

        //Buttons for language setting.
        JButton turkish = new JButton("Türkçe");
        JButton english = new JButton("English");
        JButton chinese = new JButton("中国人");

        //Toolbar for language settings.
        JToolBar languages = new JToolBar();

        languages.revalidate();

        label.add(close);
        label.add(Box.createHorizontalGlue());
        label.add(tutorial);
        languages.add(turkish);
        languages.add(chinese);
        languages.add(english);

        frame.add(label, BorderLayout.CENTER);
        frame.add(languages, BorderLayout.NORTH);


        //Actionlistners for all buttons.
        close.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        tutorial.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                tutorial tutorial = new tutorial();
                tutorial.tutorial();
            }
        });

        turkish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                tutorial tuto = new tutorial();
                close.setText("kapalı");
                tutorial.setText("öğretici");
                label.setText("HERKESE SELAMLAR! SİZE BİR ŞEY ÖĞRETMEK İÇİN BURADAYIM");
                frame.setTitle("Öğretici");

            }
        });

        english.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                close.setText("close");
                tutorial.setText("Tutorial");
                label.setText("HI EVERYONE! IM HERE TO TEACH YOU SOMETHING");

            }
        });

        chinese.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                close.setText("关闭");
                tutorial.setText("教程");
                label.setText("大家好！ 我在这里教你一些东西");

            }
        });

    }


}
