package xyz.drafter.sgg.algorithm;

/**
 * @author wangmeng
 * @date 2019/8/20
 * @desciption 动态算法解决背包问题
 *
 */
public class KnapsackProblem {

    public static void main(String[] args) {
        int[] w={1,4,3};//物品的重量
        int[] val = {1500,3000,2000};//物品的价值
        int m = 4;//背包的容量
        int n = val.length;//物品的个数



        //创建二维数组，
        // v[i][j] 表示在前i个物品中能够装入容量为j 的背包中的最大价值
        int[][] v = new int[n+1][m+1];
        //为了记录放入商品的情况，定一个二维数组
        int[][] path = new int[n+1][m+1];

        //初始化完成第一行第一列
        for (int i =0;i<v.length;i++){
            // 处理第一列
            v[i][0] = 0;
        }
        for (int i =0;i<v[0].length;i++){
            // 处理第一行
            v[0][i] = 0;
        }
        // 动态规划处理
        for (int i = 1;i<v.length;i++){
            for (int j =1;j<v[0].length;j++){
                if (w[i-1]>j){
                    v[i][j]= v[i-1][j];
                }else {
                   // v[i][j] = Math.max(v[i-1][j],val[i-1]+v[i-1][j-w[i-1]]);
                    //为了记录商品存放背包的情况
                    if (v[i-1][j]<(val[i-1]+v[i-1][j-w[i-1]])){
                        v[i][j] = val[i-1]+v[i-1][j-w[i-1]];
                        path[i][j] = 1;
                    }else {
                        v[i][j] = v[i-1][j];
                    }
                }
            }
        }

        for(int i=0;i<v.length;i++){
            for (int j =0;j<v[i].length;j++){
                System.out.print(v[i][j]+" ");
            }
            System.out.println();
        }


        //输出最后放入的商品
   /*     for (int i =0;i<path.length;i++){
            for (int j =0;j<path[i].length;j++){

                System.out.println(i);
            }
        }*/

   int i = path.length -1;//行的最大小标
   int j = path[0].length - 1;//列的最大下标
        while (i>0 && j>0){
            if (path[i][j] == 1){
                System.out.println("*****"+i);
                j -= w[i-1];
            }
            i--;
        }

    }
}
