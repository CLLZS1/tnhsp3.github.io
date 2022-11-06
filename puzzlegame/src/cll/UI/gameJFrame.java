package cll.UI;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;

public class gameJFrame extends JFrame implements KeyListener {
    //创建一个二维数组
    int[][] data=new int[4][4];
    //记录空白方块在二维数组中的位置
    int x=0;
    int y=0;
    //定义一个新二维数组
    int[][] win=new int[][]{
            {1,2,3,4},
            {5,6,7,8},
            {9,10,11,12},
            {13,14,15,16},
    };
    public gameJFrame(){
        //初始化界面
        initJFrame();

        //初始化菜单
        initJMenuer();

        //初始化数据（打乱）
        intDate();
        //初始化图片
        initImage();


        //让显示显示出来，
        this.setVisible(true);
    }


    //初始化数据打乱
    private void intDate() {
        //1，定义一个一维数组
        int[] tempArr=new int[16];
        for (int i = 0; i < tempArr.length; i++) {
            tempArr[i]=i;
        }
        //2.打乱数组中的数据的顺序
        //遍历数组，得到每一个元素，拿着每一个数据，跟随机索引上的随机索引上的数据进行交换
        Random r=new Random();
        for (int i = 0; i < tempArr.length; i++) {
            //获取随机索引
            int indext=r.nextInt(tempArr.length);
            //拿着遍历到的每一个数据，跟随机索引上的数据进行交换
            int temp=tempArr[i];
            tempArr[i]=tempArr[indext];
            tempArr[indext]=temp;

        }

        //5.给二维数组添加数据
        int shuzhi=0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (tempArr[shuzhi]==0) {
                    x=i;
                    y=j;
                }else {
                    data[i][j] = tempArr[shuzhi];
                }
                shuzhi++;
            }
        }


        }



    private void initImage() {
        //清空原本已经出现的所有图片
        this.getContentPane().removeAll();
        if (victory()){
            JLabel winjlabel= new JLabel(new ImageIcon("E:\\Javalearn\\GAME\\puzzlegame\\image\\win.png"));
            winjlabel.setBounds(203,283,197,73);
            this.getContentPane().add(winjlabel);
            this.getContentPane().repaint();
        }


        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < 4; j++) {
                //获取二维数组的数据
                int number=data[i][j];
                //创建一个图片ImageIcon的对象
                ImageIcon icon=new ImageIcon("puzzlegame\\image\\animal\\animal3\\"+number+".jpg");
                //创建一个JLabe1的对象
                JLabel jlabel=new JLabel(icon);
                //指定图片位置
                jlabel.setBounds(105*j+83,105*i+134,105,105);
                //给图片添加边框
                jlabel.setBorder(new BevelBorder(BevelBorder.LOWERED));
                //把管理容器添加到界面中
                this.getContentPane().add(jlabel);


            }

        }
        //添加背景图片
        ImageIcon bg=new ImageIcon("puzzlegame\\image\\background.png");
        JLabel background=new JLabel(bg);
        background.setBounds(40,40,508,560);
        //把背景图片添加到界面当中
        this.getContentPane().add(background);
        //刷新一下界面
        this.getContentPane().repaint();



    }

    private void initJMenuer() {
        //创建整个的菜单对象
        JMenuBar jMenuBar=new JMenuBar();

        //创建菜单上面的两个选项的对象（功能 关于我们）
        JMenu functionJMenu=new JMenu("功能");
        JMenu aboutJMenu=new JMenu("关于我们");

        //创建选项下面的条目对象
        JMenuItem replayItem=new JMenuItem("重新游戏");
        JMenuItem reLoginItem=new JMenuItem("重新登录");
        JMenuItem closeItem=new JMenuItem("关闭游戏");

        JMenuItem accountItem=new JMenuItem("公众号");

        //将每一个选项下面的条目添加到选项当中
        functionJMenu.add(replayItem);
        functionJMenu.add(reLoginItem);
        functionJMenu.add(closeItem);

        aboutJMenu.add(accountItem);

        //将菜单里面的两个选项添加到菜单当中
        jMenuBar.add(functionJMenu);
        jMenuBar.add(aboutJMenu);

        //给整个界面设置菜单
        this.setJMenuBar(jMenuBar);
    }

    private void initJFrame() {
        //设置界面的宽高
        this.setSize(603,680);

        //设置界面的标题
        this.setTitle("拼图单机版");

        //设置界面置顶
        this.setAlwaysOnTop(true);

        //设置界面居中
        this.setLocationRelativeTo(null);

        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        //取消默认的居中放置，只有取消了才会按照XY轴的形式添加组件
        this.setLayout(null);
        //给整个界面添加键盘监听事件
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        int code=e.getKeyCode();
        if (code==65){
            //把界面所有的图片全部删除
            this.getContentPane().removeAll();
            //加载第一张完整的图片
            JLabel all=new JLabel(new ImageIcon("puzzlegame\\image\\animal\\animal3\\all.jpg"));
            all.setBounds(83,134,420,420);
            this.getContentPane().add(all);
            //添加背景图片
            ImageIcon bg=new ImageIcon("puzzlegame\\image\\background.png");
            JLabel background=new JLabel(bg);
            background.setBounds(40,40,508,560);
            //把背景图片添加到界面当中
            this.getContentPane().add(background);
            //刷新一下界面
            this.getContentPane().repaint();

        }

    }

    @Override
    public void keyReleased(KeyEvent e) {
        //对上，下，左，右进行判断
        //左：37，上：38，右：39，下：40
        int code=e.getKeyCode();
        if (code==37){
            if (y==3){
                return;
            }
            //把空白方块右方的数字赋值给空白方块
            data[x][y]=data[x][y+1];
            data[x][y+1]=0;
            y++;
            //调用方法按照最新的数字加载图片
            initImage();

        }else if (code==38){
            if (x==3){
                return;
            }
            //把空白方块下方的数字赋值给空白方块
            data[x][y]=data[x+1][y];
            data[x+1][y]=0;
            x++;
            //调用方法按照最新的数字加载图片
            initImage();


        }else if (code==39){
            if (y==0){
                return;
            }
            //把空白方块左方的数字赋值给空白方块
            data[x][y]=data[x][y-1];
            data[x][y-1]=0;
            y--;
            //调用方法按照最新的数字加载图片
            initImage();

        }else if (code==40){
            if (x==0){
                return;
            }
            //把空白方块上方的数字赋值给空白方块
            data[x][y]=data[x-1][y];
            data[x-1][y]=0;
            x--;
            //调用方法按照最新的数字加载图片
            initImage();

        }else if (code==65){
            initImage();
        }else if(code==87){
            data=new int[][]{
                    {1,2,3,4},
                    {5,6,7,8},
                    {9,10,11,12},
                    {13,14,15,0},
            };
            initImage();;
        }

    }
    public boolean victory(){
        for (int i = 0; i <data.length ; i++) {
            for (int j = 0; j <data[i].length ; j++) {
                if(data[i][j]!=win[i][j]){
                    return false;

                }

            }

        }
        return true;
    }
}
