package xyz.drafter.sgg.dataStructures.search;

import java.util.Arrays;

/**
 * @author wangmeng
 * @date 2019/8/16
 * @desciption 斐波那契 黄金分割法
 */
public class FibonacciSearch {

    public static int maxSize = 20;
    public static void main(String[] args) {
        int[] arr = {1,8,10,89,1000,1234};

        System.out.println(fibSearch(arr, 89));


    }
    //mid = low+F(k-1)-1 需要斐波那契数列


    public static  int[] fib(){
        int[] f = new int[maxSize];
        f[0] = 1;
        f[1] = 1;
        for (int i = 2;i<maxSize;i++){
            f[i] = f[i-1]+f[i-2];
        }
        return f;
    }
    // a,数组， key 需要查找的关键码
    public static int fibSearch(int[] a,int key){
        int low = 0;
        int hight =  a.length -1;
        int k = 0;// 斐波那契分割数值的下标
        int mid = 0;
        int[] f = fib();
        // 获取k
        while (hight > f[k] -1 ){
            k++;
        }
        // f[k] 可能大于a的长度，
        int[] temp = Arrays.copyOf(a, f[k]);// 不足的0填充
        //
        for (int i = hight+1;i<temp.length;i++){
            temp[i] = a[hight];
        }
        while (low <= hight){
            mid = low +f[k-1]-1;
            if (key<temp[mid]){
                hight = mid -1;
                // 全部元素 = 前面元素+后面元素
                // f[k] = f[k-1] + f[k-2]
                //前面有f[k-1]个元素，可以继续拆分
                // 下次循坏 mid = f[k-1-1] -1
                k--;
            }else if(key > temp[mid]) {
                low = mid+1;
                //
                k -= 2;
            }else {
                if (mid <= hight){
                    return mid;
                }else {
                    return hight;
                }

            }
        }
        return -1;
    }

}
