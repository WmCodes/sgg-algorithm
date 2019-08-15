package xyz.drafter.sgg.dataStructures.sort;

import java.util.Arrays;

/**
 * @author wangmeng
 * @date 2019/8/15
 * @desciption 归并排序
 */
public class MergeSort {

    public static void main(String[] args) {
        int arr[] = {8,4,5,7,1,3,6,2};
        int temp[] = new int[arr.length];
        mergeSort(arr, 0, arr.length-1, temp);
        System.out.println(Arrays.toString(arr));

    }

    public static void mergeSort(int[] arr,int left,int right,int[] temp){
        if (left < right){
            int mid = (left+right)/2;
            mergeSort(arr, left, mid, temp);
            mergeSort(arr, mid+1, right, temp);
            merger(arr, left, mid, right, temp);
        }
    }

    //合并方法
    // 原数组，左边有序序列的初始索引，中间索引，右边索引，中转数组
    public static void merger(int[] arr,int left,int mid,int right,int[] temp){
        int i = left;//左边有序序列的初始索引
        int j = mid+1;//初始化j，右边有序序列的初始索引
        int t = 0;//临时数组的索引
        while (i<=mid && j<=right){
            if (arr[i]<= arr[j]){
                temp[t] = arr[i];
                t++;
                i++;
            }else {
                temp[t] = arr[j];
                t++;
                j++;
            }

        }

        while (i<= mid){
            //右边没了，左边存在
            temp[t] = arr[i];
            t++;
            i++;
        }
        while (j<= right){
            //右边没了，左边存在
            temp[t] = arr[j];
            t++;
            j++;
        }

        t= 0;
        int tempLeft = left;
        while (tempLeft<= right){
            arr[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }

    }
}
