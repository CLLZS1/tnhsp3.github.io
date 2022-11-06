package uitest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class test1 {
    public static void main(String[] args) {
        JFrame jFrame=new JFrame();
        jFrame.setSize(603,680);
        jFrame.setTitle("事件演示");
        jFrame.setAlwaysOnTop(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(3);
        jFrame.setLayout(null);
        //创建一个按钮对象
        JButton jtb=new JButton("捅我");
        //设置位置和宽高
        jtb.setBounds(0,0,100,50);
        //jtb:组件对象，你要给哪个组件添加事件
        //addActionListener：表示我要给组件添加哪个事件监听（动作监听包含鼠标左键点击，空格）
        //参数：表示被触发之后要执行的代码
        //jtb.addActionListener(new MyActionListener());
        jtb.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("aaaaatengaaaaateng a e a e a e ");
            }
        });
        //把按钮添加到界面当中
        jFrame.getContentPane().add(jtb);
        jFrame.setVisible(true);
    }
}
