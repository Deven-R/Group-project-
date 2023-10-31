package ButtonListener;


import GUI.Window;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LanguageSetting implements ActionListener {
Window window;



    public LanguageSetting(Window window){
        this.window = window;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == window.subMenuItemEnglish){
            window.menuFile.setText("File");
            window.menuView.setText("View");
            window.menuEffects.setText("Effects");
            window.menuEdit.setText("Edit");
            window.menuHelp.setText("Help");
            window.HelpText.setText("<html> HELP SECTION<br> 1. To open a canvas, click File on the menubar and click New File <br> 2. Once the canvas opens, you are free to use all tools provided in the Toolbar <br> 3. You can also use additional UI features such as : <br> - Changing themes (View --> Themes) <br> - Changing Langauges (Languages --> Turkish) </html>");
            window.menuTutorial.setText("Tutorial");
            window.menuLanguages.setText("Languages");

            window.subMenuItemNew.setText("New File");
            window.subMenuItemSave.setText("Save");
            window.subMenuItemOpen.setText("Open");
            window.subMenuItemDelete.setText("Delete File");
            window.subMenuItemUndo.setText("UndoRedo");
            window.subMenuItemRedo.setText("Redo");
            window.subMenuItemTutorial.setText("Turn On Tutorial Mode");
            window.subMenuItemdefault.setText("Default");

            window.subMenuItemBlur.setText("Blur");
            window.subMenuItemSharpen.setText("Sharpen");

            window.subMenuItemaustin.setText("'Austin Powers' Theme");
            window.subMenuItemblues.setText("Beautiful Blues Theme");
            window.subMenuItemcappucino.setText("Cappucino Theme");

            window.subMenuItemEnglish.setText("English");
            window.subMenuItemTurkish.setText("Turkish");
            window.subMenuItemChinese.setText("Chinese");

        }
        else if(e.getSource() == window.subMenuItemTurkish ){
            window.menuFile.setText("Dosya");
            window.menuView.setText("Görünüm");
            window.menuEffects.setText("Efektler");
            window.menuEdit.setText("Düzenle");
            window.menuHelp.setText("Yardım");
            window.menuTutorial.setText("Eğitimci");
            window.menuLanguages.setText("Diller");

            window. subMenuItemNew.setText("Yeni Dosya");
            window.subMenuItemSave.setText("Dosya Kaydet");
            window.subMenuItemOpen.setText("Dosya Aç");
            window.subMenuItemDelete.setText("Dosya Sil");
            window.subMenuItemUndo.setText("Geri al");
            window.subMenuItemRedo.setText("Yenile");
            window.subMenuItemTutorial.setText("Eğitim Modunu Açın");
            window.subMenuItemdefault.setText("Varsayılan");

            window.subMenuItemBlur.setText("Bulanıklaştır");
            window.subMenuItemSharpen.setText("Keskinleştir");

            window.subMenuItemaustin.setText("'Austin Powers' Teması");
            window.subMenuItemblues.setText("Beautiful Blues Teması");
            window.subMenuItemcappucino.setText("Cappucino Teması");

            window.subMenuItemEnglish.setText("Ingilizce");
            window.subMenuItemTurkish.setText("Türkçe");
            window.subMenuItemChinese.setText("Çince");
        }
        else if (e.getSource() == window.subMenuItemChinese ){
            window.menuFile.setText("文件");
            window.menuView.setText("查看");
            window.menuEffects.setText("效果");
            window.menuEdit.setText("编辑");
            window.menuHelp.setText("帮助");
            window.menuTutorial.setText("教程");
            window.menuLanguages.setText("语言");

            window.subMenuItemNew.setText("新档/文件");
            window.subMenuItemSave.setText("储存");
            window.subMenuItemOpen.setText("开启");
            window. subMenuItemDelete.setText("删除");
            window.subMenuItemUndo.setText("复原");
            window.subMenuItemRedo.setText("回复");
            window.subMenuItemTutorial.setText("开启教程模式");
            window.subMenuItemdefault.setText("预设 主题");

            window.subMenuItemBlur.setText("模糊");
            window. subMenuItemSharpen.setText("锐化");

            window.subMenuItemaustin.setText("奥斯汀-鲍尔斯 主题");
            window.subMenuItemblues.setText("美丽的蓝调 主题");
            window.subMenuItemcappucino.setText("卡布奇诺 主题");

            window.subMenuItemEnglish.setText("英语");
            window.subMenuItemTurkish.setText("土耳其语");
            window.subMenuItemChinese.setText("中文");
        }
    }
}
