package GUI;

import ButtonListener.LanguageSetting;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class WindowExtensionThemes extends Window implements ActionListener {

    /**
     * 
     */
    public WindowExtensionThemes(){
        super();
        mainPanel.add(darkMode(), BorderLayout.SOUTH);
        subMenuItemaustin.addActionListener(this);
        subMenuItemblues.addActionListener(this);
        subMenuItemcappucino.addActionListener(this);
        subMenuItemdefault.addActionListener(this);
    }
    public JPanel darkMode(){
        darkMode = new JPanel();
        FlowLayout l = new FlowLayout();
        JToggleButton modeButton = new JToggleButton("Dark");
        modeButton.setPreferredSize(new Dimension(50,15));
        modeButton.addItemListener(new ItemListener() {

            @Override
            public void itemStateChanged(ItemEvent e) {
                if(e.getStateChange() == ItemEvent.SELECTED){
                    mainPanel.setBackground(Color.DARK_GRAY);
                    darkMode.setBackground(Color.DARK_GRAY);

                    menuBar.setBackground(Color.DARK_GRAY);
                    menuBar.setForeground(Color.BLACK);

                    tools.toolbar.setBorder(BorderFactory.createLineBorder(Color.WHITE,1));
                    tools.toolbar.setForeground(Color.decode("#C1C1BD"));
                    tools.toolbar.setBackground(Color.decode("#C1C1BD"));

                    modeButton.setText("Light");
                    modeButton.setBackground(Color.decode("#C1C1BD"));
                    modeButton.setForeground(Color.white);
                    if(can != null) {
                        can.setBackground(Color.white);
                        tab.setBackground(Color.white);
                    }
                }
                else{
                    tools.toolbar.setBorder(BorderFactory.createLineBorder(Color.BLACK,1));
                    darkMode.setBackground(Color.white);
                    mainPanel.setBackground(Color.WHITE);
                    tools.toolbar.setBackground(Color.white);
                    modeButton.setText("Dark");
                    modeButton.setBackground(Color.WHITE);
                    modeButton.setForeground(Color.BLACK);
                }
            }
        });

        darkMode.add(modeButton);
        darkMode.setOpaque(true);


        return darkMode;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == subMenuItemaustin){
            tools.toolbar.setBackground(Color.yellow);
            mainPanel.setBackground(Color.decode("#D498B1"));
            tools.toolbar.setBorder(BorderFactory.createLineBorder(Color.MAGENTA,1));
            menuFile.setFont(new Font("Arial", Font.BOLD, 16 ));
            menuEdit.setFont(new Font("Arial", Font.BOLD, 16 ));
            menuView.setFont(new Font("Arial", Font.BOLD, 16 ));
            menuEffects.setFont(new Font("Arial", Font.BOLD, 16 ));
            menuHelp.setFont(new Font("Arial", Font.BOLD, 16 ));
            menuTutorial.setFont(new Font("Arial", Font.BOLD, 16 ));
            menuLanguages.setFont(new Font("Arial", Font.BOLD, 16 ));
        }
        else if(e.getSource() == subMenuItemblues){
            tools.toolbar.setBackground(Color.decode("#b3cde0"));
            mainPanel.setBackground(Color.decode("#6497b1"));
            tools.toolbar.setBorder(BorderFactory.createLineBorder(Color.decode("#011f4b"),1));
            menuFile.setFont(new Font("Courier", Font.ITALIC, 16 ));
            menuEdit.setFont(new Font("Courier", Font.ITALIC, 16 ));
            menuView.setFont(new Font("Courier", Font.ITALIC, 16 ));
            menuEffects.setFont(new Font("Courier", Font.ITALIC, 16 ));
            menuHelp.setFont(new Font("Courier", Font.ITALIC, 16 ));
            menuTutorial.setFont(new Font("Courier", Font.ITALIC, 16 ));
            menuLanguages.setFont(new Font("Courier", Font.ITALIC, 16 ));
        }
        else if(e.getSource() == subMenuItemcappucino){
            tools.toolbar.setBackground(Color.decode("#be9b7b"));
            mainPanel.setBackground(Color.decode("#fff4e6"));
            tools.toolbar.setBorder(BorderFactory.createLineBorder(Color.decode("#4b3832 "),1));
            menuFile.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 16 ));
            menuEdit.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 16 ));
            menuView.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 16 ));
            menuEffects.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 16 ));
            menuHelp.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 16 ));
            menuTutorial.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 16 ));
            menuLanguages.setFont(new Font("Times New Roman", Font.ROMAN_BASELINE, 16 ));
        }
        else if(e.getSource() == subMenuItemdefault){
            tools.toolbar.setBackground(Color.white);
            mainPanel.setBackground(Color.white);
            tools.toolbar.setBorder(BorderFactory.createLineBorder(Color.black,1));
            menuFile.setFont(new Font("", Font.PLAIN, 14 ));
            menuEdit.setFont(new Font("", Font.PLAIN, 14 ));
            menuView.setFont(new Font("", Font.PLAIN, 14 ));
            menuEffects.setFont(new Font("", Font.PLAIN, 14 ));
            menuHelp.setFont(new Font("", Font.PLAIN, 14 ));
            menuTutorial.setFont(new Font("", Font.PLAIN, 14 ));
            menuLanguages.setFont(new Font("", Font.PLAIN, 14 ));
        }
    }
}
