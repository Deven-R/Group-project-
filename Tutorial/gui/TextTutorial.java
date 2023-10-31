package Tutorial.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * This class is responsible for providing support for the user to know how to use the text tool feature of the app.
 */
public class TextTutorial {

    /**
     * All elements such as Buttons, properties of the frame and text along with its language support are included in this method.
     */
    public void TextTutorial(){

        JFrame TextTut = new JFrame();
        TextTut.setTitle("Text Tool");
        TextTut.setSize(500,500);
        TextTut.setVisible(true);
        TextTut.setLocationRelativeTo(null);
        TextTut.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        ImageIcon flipIcon = new ImageIcon("Tutorial/gui/Text.png");

        JLabel Tlabel = new JLabel(flipIcon);
        JToolBar Textback =  new JToolBar();
        JButton turkish = new JButton("Turkish");
        JButton chinese = new JButton("Chinese");
        JButton english = new JButton("English");
        JButton back = new JButton("BACK");

        Tlabel.setText("<html> TO USE THE Text TOOL: <br> 1. Select the Text Tool <br>  2. Once the red Border appears, you can start using the tool <br> 3. Simply click on the canvas where you want to write your text <br> 4. Type away! </html>");


        TextTut.add(Tlabel, BorderLayout.CENTER);
        Tlabel.setBackground(Color.WHITE);
        Tlabel.setLayout(new BoxLayout(Tlabel, BoxLayout.LINE_AXIS));

        Textback.add(turkish);
        Textback.add(chinese);
        Textback.add(english);
        Textback.add(back);


        TextTut.add(Tlabel, BorderLayout.CENTER);
        TextTut.add(Textback, BorderLayout.NORTH);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                TextTut.setVisible(false);
                TextTut.dispose();
            }
        });

        turkish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tlabel.setText("<html> Metin ARACINI KULLANMAK İÇİN: <br> 1. Metin Aracını seçin <br> 2. Kırmızı Kenarlık göründüğünde, aracı kullanmaya başlayabilirsiniz <br> 3. Tuvalde istediğiniz yere tıklayın ve metninizi yazın <br> 4. Yazın! </html>");
            }
        });

        english.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Tlabel.setText("<html> TO USE THE Text TOOL: <br> 1. Select the Text Tool <br>  2. Once the red Border appears, you can start using the tool <br> 3. Simply click on the canvas where you want to write your text <br> 4. Type away! </html>");
            }
        });

        chinese.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Tlabel.setText("<html> 使用文本工具：<br> 1. 选择文本工具 <br> 2. 红色边框出现后，您就可以开始使用该工具了 <br> 3. 只需在画布上单击您想要的位置写下您的文字 <br> 4. 打字！</html>");
            }
        });



    }

}