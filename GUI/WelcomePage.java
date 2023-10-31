package GUI;




import Tutorial.gui.IntroTutorial;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class WelcomePage extends JFrame{

    public WelcomePage() {


        setBackground(Color.GRAY);
        Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int)screen.getWidth()/2, (int)screen.getHeight()/2);
        setLocationRelativeTo(null);

        ImageIcon backgroundIcon = new ImageIcon("GUI/icons/background.jpeg");

        Image backgroundimage = backgroundIcon.getImage(); // transform it
        Image newbackground = backgroundimage.getScaledInstance(1000, 500,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        backgroundIcon = new ImageIcon(newbackground);  // transform it back

        JLabel label = new JLabel(backgroundIcon);
        label.setPreferredSize(getSize());

        getContentPane().add(label);



        JButton editor = new JButton("Start Editor");
        editor.setFont((new Font("Courier", Font.ITALIC, 16 )));
        editor.setBounds(250,150,200, 50);


        label.add(editor);




        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        editor.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new WindowExtensionThemes();
                IntroTutorial tutorial = new IntroTutorial();
                tutorial.showLoader();
                dispose();

            }
        });









    }
}