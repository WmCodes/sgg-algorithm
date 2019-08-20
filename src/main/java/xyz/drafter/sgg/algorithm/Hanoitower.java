package xyz.drafter.sgg.algorithm;

/**
 * @author wangmeng
 * @date 2019/8/20
 * @desciption 汉诺塔移动方法
 */
public class Hanoitower {

    public static void main(String[] args) {
        hanoiTower(5, 'A', 'B', 'C');


    }

    //分治算法
    public static void hanoiTower(int num,char a,char b,char c){
        // 如果只有一个盘
        if (num == 1){
            System.out.println("第一个盘:"+a +"->"+c);
        }else {
            //如果n>= 2,看成两个盘，一个是最下边的一个盘， 一个是上面的所有盘

            //1,先把最上面的所有盘 a->b,移动过程中会使用c
            hanoiTower(num-1, a, c, b);
            System.out.println("第"+num+"个盘从"+a+"->"+c);
            //把B塔所有的盘移动到C b->c,移动过程使用a塔
            hanoiTower(num-1, b, a, c);
        }
    }
}
