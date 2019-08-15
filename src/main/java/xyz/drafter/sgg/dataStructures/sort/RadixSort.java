package xyz.drafter.sgg.dataStructures.sort;

import java.util.Arrays;

/**
 * @author wangmeng
 * @date 2019/8/15
 * @desciption 基数排序
 */
public class RadixSort {


    public static void main(String[] args) {
        int arr[] = {53,3,542,748,14,214};
        redixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void redixSort(int[] arr){

        // 得到数组中最大数的位数
        int max = arr[0];
        for (int i=1;i<arr.length;i++){
            if (arr[i]>max){
                max = arr[i];
            }
        }
        int maxLength = (max+"").length();

        int[][] bucket = new int[10][arr.length];
        int[] bucketElmentCounts = new int[10];

        for (int i =0,n=1 ;i<maxLength;i++,n*=10){
            for (int j =0;j<arr.length;j++){
                // 每个元素对应位置的值
                int digitOfElement = arr[j]/n %10;
                bucket[digitOfElement][bucketElmentCounts[digitOfElement]] = arr[j];
                bucketElmentCounts[digitOfElement]++;
            }
            // 按照这个桶的顺序(一维数组的下标依次去除，放出原来的数组)
            int index = 0;
            for (int k = 0; k<bucketElmentCounts.length;k++){
                if (bucketElmentCounts[k] != 0){
                    for (int l = 0;l<bucketElmentCounts[k];l++){
                        arr[index++] = bucket[k][l];
                    }
                }
                bucketElmentCounts[k] = 0;
            }

        }




    /*    int[][] bucket = new int[10][arr.length];

        //记录每个桶中存放了多少个数据
        int[] bucketElmentCounts = new int[10];
        for (int j =0;j<arr.length;j++){
            // 个位的值
            int digitOfElement = arr[j] %10;
            bucket[digitOfElement][bucketElmentCounts[digitOfElement]] = arr[j];
            bucketElmentCounts[digitOfElement]++;
        }
        // 按照这个桶的顺序(一维数组的下标依次去除，放出原来的数组)
        int index = 0;
        for (int k = 0; k<bucketElmentCounts.length;k++){
            if (bucketElmentCounts[k] != 0){
                for (int l = 0;l<bucketElmentCounts[k];l++){
                    arr[index++] = bucket[k][l];
                }
            }
            bucketElmentCounts[k] = 0;
        }


        for (int j =0;j<arr.length;j++){
            // 个位的值
            int digitOfElement = arr[j] /10 %10;
            bucket[digitOfElement][bucketElmentCounts[digitOfElement]] = arr[j];
            bucketElmentCounts[digitOfElement]++;
        }
        // 按照这个桶的顺序(一维数组的下标依次去除，放出原来的数组)
        index = 0;
        for (int k = 0; k<bucketElmentCounts.length;k++){
            if (bucketElmentCounts[k] != 0){
                for (int l = 0;l<bucketElmentCounts[k];l++){
                    arr[index++] = bucket[k][l];
                }
            }
        }
*/

    }
}
