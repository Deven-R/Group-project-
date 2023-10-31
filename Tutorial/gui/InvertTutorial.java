package Tutorial.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * This class is responsible for providing support for the user to know how to use the invert image feature of the app.
 */
public class InvertTutorial {

    /**
     * All elements such as Buttons, properties of the frame and text along with its language support are included in this method.
     */
    public void InvertTutorial(){

        JFrame InvertTut = new JFrame();
        InvertTut.setTitle("Invert Tool");
        InvertTut.setSize(500,500);
        InvertTut.setVisible(true);
        InvertTut.setLocationRelativeTo(null);
        InvertTut.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        ImageIcon InvertIcon = new ImageIcon("Tutorial/gui/invert.png");

        Image Invertimage = InvertIcon.getImage(); // transform it
        Image newInvert = Invertimage.getScaledInstance(35, 30,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way
        InvertIcon = new ImageIcon(newInvert);  // transform it back

        JLabel ilabel = new JLabel(InvertIcon);
        JToolBar Invertback =  new JToolBar();
        JButton turkish = new JButton("Turkish");
        JButton chinese = new JButton("Chinese");
        JButton english = new JButton("English");
        JButton back = new JButton("BACK");

        ilabel.setText("<html> TO USE THE Invert TOOL: <br> 1. Import an Image from the image tool <br> 2. Select the Image <br> 3. Click on the Invert tool and see your image being Inverted </html>");


        InvertTut.add(ilabel, BorderLayout.CENTER);
        ilabel.setBackground(Color.WHITE);
        ilabel.setLayout(new BoxLayout(ilabel, BoxLayout.LINE_AXIS));

        Invertback.add(turkish);
        Invertback.add(chinese);
        Invertback.add(english);
        Invertback.add(back);


        InvertTut.add(ilabel, BorderLayout.CENTER);
        InvertTut.add(Invertback, BorderLayout.NORTH);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                InvertTut.setVisible(false);
                InvertTut.dispose();
            }
        });

        turkish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ilabel.setText("<html> Ters Çevirme Aracını Kullanmak İçin: <br> 1. İlk önce ekrana bir resim ekleyin. <br> 2. Resimi seçin <br> 3. Ters Çevirme aracına tıklayın ve görüntünüzün Ters Çevrildiğini görün </html>");
            }
        });

        english.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ilabel.setText("<html> TO USE THE Invert TOOL: <br> 1. Import an Image from the image tool <br> 2. Select the Image <br> 3. Click on the Invert tool and see your image being Inverted </html>");
            }
        });

        chinese.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                ilabel.setText("<html> 使用翻转工具：<br> 1. 从图像工具导入图像 <br> 2. 选择图像 <br> 3. 单击翻转工具，查看图像被翻转 180 度 </html >");
            }
        });



    }

}

