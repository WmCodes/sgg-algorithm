package xyz.drafter.sgg.dataStructures.sort;

import java.util.Arrays;

/**
 * @author wangmeng
 * @date 2019/8/15
 * @desciption 插入排序
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = {101,34,5,1};
        insertSort(arr);

    }

    // 插入排序
    public static void insertSort(int[] arr){

        for (int i = 1;i<arr.length;i++){
            int insertVal = arr[i];
            int insertIndex = i-1;
            while (insertIndex >=0 && insertVal <arr[insertIndex]){
                arr[insertIndex+1] = arr[insertIndex];
                insertIndex --;
            }
            if (insertIndex+1 != i){
                arr[insertIndex +1] = insertVal;
            }
        }
        System.out.println(Arrays.toString(arr));


        // 使用逐步推导方式
        // 定义待插入的数
   /*     int insertVal = arr[1];
        int insertIndex = 1-1;// 待插入数的索引
        // 待插入数还未找到适当位置
        // arr[insertIndex]后移
        while (insertIndex >=0 && insertVal <arr[insertIndex]){
            arr[insertIndex+1] = arr[insertIndex];
            insertIndex --;
        }
        // 退出while循环时,找到插入位置，位置为insertIndex+1
        arr[insertIndex +1] = insertVal;
        System.out.println(Arrays.toString(arr));


         insertVal = arr[2];
         insertIndex = 2-1;// 待插入数的索引
        // 待插入数还未找到适当位置
        // arr[insertIndex]后移
        while (insertIndex >=0 && insertVal <arr[insertIndex]){
            arr[insertIndex+1] = arr[insertIndex];
            insertIndex --;
        }
        // 退出while循环时,找到插入位置，位置为insertIndex+1
        arr[insertIndex +1] = insertVal;
        System.out.println(Arrays.toString(arr));*/
    }
}
