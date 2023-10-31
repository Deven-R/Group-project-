package Tutorial.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;


/**
 * This class is responsible for providing support for the user to know how to use the text tool feature of the app.
 */
public class PencilTutorial {

    /**
     * All elements such as Buttons, properties of the frame and text along with its language support are included in this method.
     */
    public void PencilTutorial(){

        JFrame PencilTut = new JFrame();
        PencilTut.setTitle("Pencil Tool");
        PencilTut.setSize(500,500);
        PencilTut.setVisible(true);
        PencilTut.setLocationRelativeTo(null);
        PencilTut.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);



        URL url = this.getClass().getResource("pencil.png");
        Icon icon = new ImageIcon(url);
        JLabel Plabel = new JLabel(icon);
        JToolBar pencilback =  new JToolBar();
        JButton turkish = new JButton("Turkish");
        JButton chinese = new JButton("Chinese");
        JButton english = new JButton("English");
        JButton back = new JButton("BACK");

        Plabel.setText("<html> TO USE THE PENCIL TOOL: <br> 1. Select the Pencil Tool <br>  2. Once the red Border appears, you can start using the tool <br> 3. Default color of the pencil is BLACK but use the Color Chooser tool to alter <br> 4. You can also change the thickenss of the pencil using the slider on the right </html>");


        PencilTut.add(Plabel, BorderLayout.CENTER);
        Plabel.setBackground(Color.WHITE);
        Plabel.setLayout(new BoxLayout(Plabel, BoxLayout.LINE_AXIS));

        pencilback.add(turkish);
        pencilback.add(chinese);
        pencilback.add(english);
        pencilback.add(back);


        PencilTut.add(Plabel, BorderLayout.CENTER);
        PencilTut.add(pencilback, BorderLayout.NORTH);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                PencilTut.setVisible(false);
                PencilTut.dispose();
            }
        });

        turkish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Plabel.setText("<html> KALEM ARACI KULLANMAK İÇİN: <br> 1. Kalem Aracını seçin <br> 2. Kırmızı Kenarlık göründüğünde, kalemi kullanmaya başlayabilirsiniz <br> 3. Kalemin varsayılan rengi SİYAH'tır ancak değiştirmek için Renk Seçici aracını kullanın </html>");
            }
        });

        english.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Plabel.setText("<html> TO USE THE PENCIL TOOL: <br> 1. Select the Pencil Tool <br>  2. Once the red Border appears, you can start using the tool <br> 3. Default color of the pencil is BLACK but use the Color Chooser tool to alter  </html>");
            }
        });

        chinese.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Plabel.setText("<html> 使用铅笔工具：<br> 1. 选择铅笔工具 <br> 2. 出现红色边框后，您就可以开始使用该工具了 <br> 3. 铅笔的默认颜色为黑色，但请使用颜色选择器工具来改变  </html>");
            }
        });



    }

}
