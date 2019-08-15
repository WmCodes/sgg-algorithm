package xyz.drafter.sgg.dataStructures.sort;

import java.util.Arrays;

/**
 * @author wangmeng
 * @date 2019/8/15
 * @desciption 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {-9,0,78,29,0,32,-567,0,-70};
        quickSort(arr, 0, arr.length-1);
        System.out.println(Arrays.toString(arr));

    }

    public static void quickSort(int[] arr,int left,int right){
        int l = left;//左下标
        int r = right;// 右下标
        // pivot 中轴值
        int pivot = arr[(left+right)/2];
        // 让值比pivot小的放左边，大的放右边
        int temp = 0;
        while (l < r){
            while (arr[l]<pivot){
                //在pivot左边找，直到大于等于pivot，退出
                l += 1;
            }
            while (arr[r] > pivot){
                r -= 1;
            }

            if (l >= r){
                //pivot左右值，左边全部小于等于pivot,右边大于等于pivot
                break;
            }
            temp = arr[l];
            arr[l] = arr[r];
            arr[r] = temp;

            // 如果arr[l] == pivot 相等 r--
            if (arr[l] == pivot){
                r -=1;
            }
            // 如果arr[r] == pivot 相等 l++
            if (arr[r] == pivot){
                l +=1;
            }
        }
        if ( l== r){
            l += 1;
            r -=1;
        }

        if (left < r){
            quickSort(arr, left, r);
        }
        if (right > l){
            quickSort(arr, l, right);
        }
    }
}
