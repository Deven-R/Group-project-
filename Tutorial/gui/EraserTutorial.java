package Tutorial.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.net.URL;


/**
 * This class is responsible for providing support for the user to know how to use the eraser tool feature of the app.
 */
public class EraserTutorial {

    /**
     * All elements such as Buttons, properties of the frame and text along with its language support are included in this method.
     */
    public void EraserTutorial(){

        JFrame EraserTut = new JFrame();
        EraserTut.setTitle("Brush Tool");
        EraserTut.setSize(500,500);
        EraserTut.setVisible(true);
        EraserTut.setLocationRelativeTo(null);
        EraserTut.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);



        URL url = this.getClass().getResource("e.jpg");
        Icon icon = new ImageIcon(url);
        JLabel EraserLabel = new JLabel(icon);
        JToolBar eraserback =  new JToolBar();
        JButton turkish = new JButton("Türkçe");
        JButton chinese = new JButton("中国人");

        JButton english = new JButton("English");
        JButton back = new JButton("BACK");

        EraserLabel.setText("<html> TO USE THE ERASER TOOL: <br> 1. Select the Eraser Tool <br>  2. Once the red Border appears, you can start using the tool <br> 3. Click and drag to any pre-drawn tools on the canvas, and the drawings should start to erase (disappear) </html>");


        EraserTut.add(EraserLabel, BorderLayout.CENTER);
        EraserLabel.setBackground(Color.WHITE);
        EraserLabel.setLayout(new BoxLayout(EraserLabel, BoxLayout.LINE_AXIS));

        eraserback.add(turkish);
        eraserback.add(english);
        eraserback.add(chinese);
        eraserback.add(back);


        EraserTut.add(EraserLabel, BorderLayout.CENTER);
        EraserTut.add(eraserback, BorderLayout.NORTH);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EraserTut.setVisible(false);
                EraserTut.dispose();
            }
        });

        turkish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EraserLabel.setText("<html> SİLGİ ARACINI KULLANMAK İÇİN: <br> 1. Silgi Aracını seçin <br> 2. Kırmızı Kenarlık göründüğünde, aracı kullanmaya başlayabilirsiniz <br> 3. Tıklayın ve herhangi bir önceden çizilmiş alana sürükleyin tuval ve çizimler silinmeye (kaybolmaya) başlamalıdır </html>");
            }
        });

        english.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                EraserLabel.setText("<html> TO USE THE ERASER TOOL: <br> 1. Select the Eraser Tool <br>  2. Once the red Border appears, you can start using the tool <br> 3. Click and drag to any pre-drawn tools on the canvas, and the drawings should start to erase (disappear) </html>\"");
            }
        });

        chinese.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                EraserLabel.setText("<html> 使用橡皮擦工具：<br> 1. 选择橡皮擦工具 <br> 2. 一旦出现红色边框，您就可以开始使用该工具 <br> 3. 单击并拖动到任何预先绘制的工具画布和绘图应该开始擦除（消失）</html>”");
            }
        });

    }



}
