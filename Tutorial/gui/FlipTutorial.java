package Tutorial.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * This class is responsible for providing support for the user to know how to use the flip image feature of the app.
 */
public class FlipTutorial {

    /**
     * All elements such as Buttons, properties of the frame and text along with its language support are included in this method.
     */
    public void FlipTutorial(){

        JFrame FlipTut = new JFrame();
        FlipTut.setTitle("Flip Tool");
        FlipTut.setSize(500,500);
        FlipTut.setVisible(true);
        FlipTut.setLocationRelativeTo(null);
        FlipTut.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        ImageIcon FlipIcon = new ImageIcon("Tutorial/gui/Flip.png");

        Image flipimage = FlipIcon.getImage(); // transform it
        Image newflip = flipimage.getScaledInstance(35, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        FlipIcon = new ImageIcon(newflip);  // transform it back

        JLabel Flabel = new JLabel(FlipIcon);
        JToolBar Flipback =  new JToolBar();
        JButton turkish = new JButton("Turkish");
        JButton chinese = new JButton("Chinese");
        JButton english = new JButton("English");
        JButton back = new JButton("BACK");

        Flabel.setText("<html> TO USE THE Flip TOOL: <br> 1. Import an Image from the image tool <br> 2. Select the Image <br> 3. Click on the Flip tool and see your image being flipped 180 degrees </html>");


        FlipTut.add(Flabel, BorderLayout.CENTER);
        Flabel.setBackground(Color.WHITE);
        Flabel.setLayout(new BoxLayout(Flabel, BoxLayout.LINE_AXIS));

        Flipback.add(turkish);
        Flipback.add(chinese);
        Flipback.add(english);
        Flipback.add(back);


        FlipTut.add(Flabel, BorderLayout.CENTER);
        FlipTut.add(Flipback, BorderLayout.NORTH);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FlipTut.setVisible(false);
                FlipTut.dispose();
            }
        });

        turkish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Flabel.setText("<html> Döndürme ARACINI KULLANMAK İÇİN: <br> 1. İlk önce ekrana bir resim ekleyin. <br> 2. Resimi seçin <br> 3. Döndür aracını tıklayın ve görüntünüzün 180 derece döndürüldüğünü görün </html >");
            }
        });

        english.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Flabel.setText("<html> TO USE THE Flip TOOL: <br> 1. Import an Image from the image tool <br> 2. Select the Image <br> 3. Click on the Flip tool and see your image being flipped 180 degrees </html>");
            }
        });

        chinese.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Flabel.setText("<html> 使用翻转工具：<br> 1. 从图像工具导入图像 <br> 2. 选择图像 <br> 3. 单击翻转工具，查看图像被翻转 180 度 </html >");
            }
        });



    }

}

