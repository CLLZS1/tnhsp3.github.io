package cll.UI;

import javax.swing.*;

public class LoginJFrame extends JFrame {
    public LoginJFrame(){
        this.setSize(488,430);
        //设置界面的标题
        this.setTitle("登录界面");
        //设置界面置顶
        this.setAlwaysOnTop(true);
        //设置界面居中
        this.setLocationRelativeTo(null);
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //让显示显示出来，
        this.setVisible(true);
    }
}
