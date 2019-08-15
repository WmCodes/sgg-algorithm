package xyz.drafter.sgg.dataStructures.recursion;

/**
 * @author wangmeng
 * @date 2019/8/15
 * @desciption 8皇后问题
 */
public class Queue8 {

    int max = 8;
    int[] array = new int[max];
    static int count =0;
    public static void main(String[] args) {
        Queue8 queue8 = new Queue8();
        queue8.check(0);
        System.out.println("一共有: "+count+"方法");


    }

    //编写一个方法，放置第n个皇后
    private void check(int n){
        if ( n == max){// n =8,8个皇后已然放好
            print();
            return;
        }
        // 依次放入皇后，并判断是否冲突
        for (int i = 0;i<max;i++){
            // 先把当前这个n，放到该行的第1列
            array[n] = i;
            //判断当前放置第n个皇后i列时，是否冲突
            if (judge(n)){
                //不冲突
                // 接着放n+1个皇后，递归
                check(n+1);

            }
            // 冲突 进行下一个for循环
        }
    }
    // 当我们放置第n个皇后，就检测该皇后是否和前面已经摆放的皇后冲突
    private boolean judge(int n){
        for (int i =0;i<n;i++){
            // array[i] == array[n]: 第n个皇后是否和前面的n-1个皇后在同一列
            // Math.abs(n-i) == Math.abs(array[n]-array[i]) 表示判断第n个皇后是否和第i皇后在同一斜线
            if (array[i] == array[n] ||Math.abs(n-i) == Math.abs(array[n]-array[i])){
                return false;
            }
        }
        return true;
    }

    // 写一个方法，将皇后摆放的位置输出
    private void print(){
        count++;
        for (int i = 0;i<array.length;i++){
            System.out.print(array[i]+" ");
        }
        System.out.println();
    }

}
