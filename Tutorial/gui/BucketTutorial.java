package Tutorial.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * This class is responsible for providing support for the user to know how to use the bucket fill tool of the app.
 */
public class BucketTutorial {

    /**
     * All elements such as Buttons, properties of the frame and text along with its language support are included in this method.
     */
    public void BucketTutorial(){

        JFrame BucketTut = new JFrame();
        BucketTut.setTitle("Bucket Tool");
        BucketTut.setSize(500,500);
        BucketTut.setVisible(true);
        BucketTut.setLocationRelativeTo(null);
        BucketTut.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        ImageIcon bucketIcon = new ImageIcon("Tutorial/gui/Bucket.png");

        JLabel Blabel = new JLabel(bucketIcon);
        JToolBar Bucketback =  new JToolBar();
        JButton turkish = new JButton("Türkçe");
        JButton chinese = new JButton("中国人");
        JButton english = new JButton("English");
        JButton back = new JButton("BACK");

        Blabel.setText("<html> TO USE THE Bucket TOOL: <br> 1. Deselect any other tool  <br>  2. Select a portion on the canvas you wish to fill by clicking on the canvas <br> 3. Select the color you want. <br> 4. Select the fill tool to fill the area! </html>");


        BucketTut.add(Blabel, BorderLayout.CENTER);
        Blabel.setBackground(Color.WHITE);
        Blabel.setLayout(new BoxLayout(Blabel, BoxLayout.LINE_AXIS));

        Bucketback.add(turkish);
        Bucketback.add(chinese);
        Bucketback.add(english);
        Bucketback.add(back);


        BucketTut.add(Blabel, BorderLayout.CENTER);
        BucketTut.add(Bucketback, BorderLayout.NORTH);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BucketTut.setVisible(false);
                BucketTut.dispose();
            }
        });

        turkish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Blabel.setText("<html> Kova Aracını Kullanmak İçin: <br> 1. Diğer herhangi bir aracın seçimini kaldırın <br> 2. Farenizi tuval üzerinde tıklayıp sürükleyerek tuval üzerinde doldurmak istediğiniz bir bölümü seçin <br> 3. İstediğiniz rengi seçin. <br> 4. Alanı doldurmak için doldurma aracını seçin! </html>");
            }
        });

        english.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Blabel.setText("<html> TO USE THE Bucket TOOL: <br> 1. Deselect any other tool  <br>  2. Select a portion on the canvas you wish to fill by clicking and dragging your mouse on the canvas <br> 3. Select the color you want. <br> 4. Select the fill tool to fill the area! </html>");
            }
        });

        chinese.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Blabel.setText("<html> 使用桶工具：<br> 1. 取消选择任何其他工具 <br> 2. 通过在画布上单击并拖动鼠标来选择要填充的画布部分 <br> 3. 选择颜色你要。 <br> 4.选择填充工具填充区域！ </html>");
            }
        });



    }

}
