package Tutorial.gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/**
 * This class is responsible for providing support for the user to know how to use the zoom feature of the app.
 */
public class ZoomTutorial {

    /**
     * All elements such as Buttons, properties of the frame and text along with its language support are included in this method.
     */
    public void ZoomTutorial(){

        JFrame ZoomTut = new JFrame();
        ZoomTut.setTitle("Zoom Tool");
        ZoomTut.setSize(500,500);
        ZoomTut.setVisible(true);
        ZoomTut.setLocationRelativeTo(null);
        ZoomTut.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);


        ImageIcon ZoomIcon = new ImageIcon("Tutorial/gui/Zoom.png");

        JLabel Zlabel = new JLabel(ZoomIcon);
        JToolBar Zoomback =  new JToolBar();
        JButton turkish = new JButton("Turkish");
        JButton chinese = new JButton("Chinese");
        JButton english = new JButton("English");
        JButton back = new JButton("BACK");

        Zlabel.setText("<html> TO USE THE Zoom TOOL: <br> 1. Press 'New File' for a new canvas <br> 2. Select the Zoom tool <br> 3. One you click the zoom tool, your canvas and its components will zoom in </html>");


        ZoomTut.add(Zlabel, BorderLayout.CENTER);
        Zlabel.setBackground(Color.WHITE);
        Zlabel.setLayout(new BoxLayout(Zlabel, BoxLayout.LINE_AXIS));

        Zoomback.add(turkish);
        Zoomback.add(chinese);
        Zoomback.add(english);
        Zoomback.add(back);


        ZoomTut.add(Zlabel, BorderLayout.CENTER);
        ZoomTut.add(Zoomback, BorderLayout.NORTH);

        back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ZoomTut.setVisible(false);
                ZoomTut.dispose();
            }
        });

        turkish.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Zlabel.setText("<html> Yakınlaştırma ARACINI KULLANMAK İÇİN: <br> 1. Yeni bir tuval için 'Yeni Dosya'ya basın <br> 2. Yakınlaştırma aracını seçin <br> 3. Yakınlaştırma aracını tıkladığınızda, tuvaliniz ve bileşenleri yakınlaştırır </html>");
            }
        });

        english.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Zlabel.setText("<html> TO USE THE Zoom TOOL: <br> 1. Press 'New File' for a new canvas <br> 2. Select the Zoom tool <br> 3. One you click the zoom tool, your canvas and its components will zoom in </html>");
            }
        });

        chinese.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Zlabel.setText("\n" +
                        "<html> 使用缩放工具：<br> 1. 按“新建文件”创建新画布 <br> 2. 选择缩放工具 <br> 3. 单击缩放工具后，您的画布及其组件将放大</html>");
            }
        });



    }

}
