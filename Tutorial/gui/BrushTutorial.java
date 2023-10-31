package Tutorial.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.net.URL;


/**
 * This class is responsible for providing support for the user to know how to use the brush tool of the app.
 */
public class BrushTutorial {

    /**
     * All elements such as Buttons, properties of the frame and text along with its language support are included in this method.
     */
    public void BrushTutorial(){

        JFrame BrushTut = new JFrame();
        BrushTut.setTitle("Brush Tool");
        BrushTut.setSize(500,500);
        BrushTut.setVisible(true);
        BrushTut.setLocationRelativeTo(null);
        BrushTut.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);



        URL url = this.getClass().getResource("paint.png");
        Icon icon = new ImageIcon(url);
        JLabel Brushlabel = new JLabel(icon);
        JToolBar brushback =  new JToolBar();
        JButton turkish = new JButton("Türkçe");
        JButton chinese = new JButton("中国人");

        JButton english = new JButton("English");
        JButton back = new JButton("BACK");

        Brushlabel.setText("<html> TO USE THE BRUSH TOOL: <br> 1. Select the BRUSH Tool <br>  2. Once the red Border appears, you can start using the tool <br> 3. Default color of the pencil is BLACK but use the Color Chooser tool to alter <br> 4. You can also change the thickenss of the pencil using the slider on the right </html>");


        BrushTut.add(Brushlabel, BorderLayout.CENTER);
        Brushlabel.setBackground(Color.WHITE);
        Brushlabel.setLayout(new BoxLayout(Brushlabel, BoxLayout.LINE_AXIS));

        brushback.add(turkish);
        brushback.add(chinese);
        brushback.add(english);
        brushback.add(back);


        BrushTut.add(Brushlabel, BorderLayout.CENTER);
        BrushTut.add(brushback, BorderLayout.NORTH);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BrushTut.setVisible(false);
                BrushTut.dispose();
            }
        });

        turkish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Brushlabel.setText("<html> FIRÇA ARACINI KULLANMAK İÇİN: <br> 1. FIRÇA Aracını seçin <br> 2. Kırmızı Kenarlık göründüğünde, aracı kullanmaya başlayabilirsiniz <br> 3. Kalemin varsayılan rengi SİYAH'tır ancak değiştirmek için Renk Seçiciyi aracinı kullanın <br> 4. Kalemin kalınlığını sağdaki kaydırıcıyı kullanarak değiştirebilirsiniz </html>");
            }
        });

        english.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Brushlabel.setText("<html> TO USE THE BRUSH TOOL: <br> 1. Select the BRUSH Tool <br>  2. Once the red Border appears, you can start using the tool <br> 3. Default color of the pencil is BLACK but use the Color Chooser tool to alter <br> 4. You can also change the thickenss of the pencil using the slider on the right </html>");
            }
        });

        chinese.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Brushlabel.setText("<html> 使用画笔工具：<br> 1. 选择画笔工具 <br> 2. 出现红色边框后，您就可以开始使用该工具了 <br> 3. 铅笔的默认颜色为黑色，但请使用颜色选择器工具来改变 <br> 4. 您还可以使用右侧的滑块更改铅笔的粗细 </html>");
            }
        });
    }

}
