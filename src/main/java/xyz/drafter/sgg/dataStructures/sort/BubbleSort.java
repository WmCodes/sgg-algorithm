package xyz.drafter.sgg.dataStructures.sort;

import java.util.Arrays;

/**
 * @author wangmeng
 * @date 2019/8/15
 * @desciption 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int arr1[] = {3,9,-1,10,-2};
        bubbleSort(arr1);
    }

    public static void bubbleSort(int[] arr){

        int temp = 0;
        boolean flag = false;
        for (int i =0;i<arr.length-1;i++) {
            for (int j = 0; j < arr.length - 1-i; j++) {
                if (arr[j] > arr[j + 1]) {
                    flag = true;
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
            System.out.println("*****:" + Arrays.toString(arr));
            if (flag == false){
                // 一次都没有交换过
                break;
            }else {
                flag = false;
            }

        }
        System.out.println("排序后的数组:" + Arrays.toString(arr));

    }
}
