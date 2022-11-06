package uitest;

import java.util.Random;

public class gametest {
    public static void main(String[] args) {
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
        //4。创建一个二维数组
        int[][] data=new int[4][4];
        //5.给二维数组添加数据
        int shuzhi=0;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j]=tempArr[shuzhi];
                shuzhi++;
            }
        }
        //6.遍历二维数组
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j]+",");

            }
            System.out.println();

        }

    }
}
