package xyz.drafter.sgg.dataStructures.tree;

import java.util.Arrays;

/**
 * @author wangmeng
 * @date 2019/8/18
 * @desciption 堆排序
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {4,6,8,5,9};
        heapSort(arr);

    }


    public static void heapSort(int[] arr){
        int temp = 0;
        System.out.println("堆排序");
    /*    adjustHeap(arr, 1, arr.length);
        System.out.println(Arrays.toString(arr));
        adjustHeap(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));*/

        for (int i = arr.length/2-1;i>=0;i--){
            adjustHeap(arr, i, arr.length);
        }
        System.out.println(Arrays.toString(arr));

        for (int j = arr.length -1;j>0;j--){
                temp = arr[j];
                arr[j] = arr[0];
                arr[0] = temp;
                adjustHeap(arr, 0, j);
        }
        System.out.println(Arrays.toString(arr));

    }

    // 将一个数组(二叉树)调整成一个大顶堆
    // arr ：待调整的数组   i：非叶子节点在数组中的索引  length:对多少个元素调整
    public static void adjustHeap(int[] arr,int i,int length){
        int temp = arr[i];
        for (int k = i* 2+1;k<length;k=k*2+1){
            if (k+1<length && arr[k]<arr[k+1]){
                k++;
            }
            if (arr[k] >temp){
                arr[i] = arr[k];
                i = k;
            }else {
                break;
            }
        }

        // 当for循环结束，已经将以i为父节点的树的最大值，放在最顶
        arr[i] = temp;
    }
}
