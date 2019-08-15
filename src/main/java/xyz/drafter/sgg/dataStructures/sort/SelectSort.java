package xyz.drafter.sgg.dataStructures.sort;

import java.util.Arrays;

/**
 * @author wangmeng
 * @date 2019/8/15
 * @desciption 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr = {101,34,119,1,90,123};
        selectSort(arr);

    }

    public static void selectSort(int[] arr){
      /*  int minIndex =0;
        int min = arr[0];
        for (int j=0+1;j<arr.length;j++){
            if (min>arr[j]){
                min = arr[j];
                minIndex = j;
            }
        }

        arr[minIndex] = arr[0];
        arr[0] = min;

        System.out.println("***********");
        System.out.println(Arrays.toString(arr));*/


      for (int i = 0;i<arr.length - 1;i++){
          int minIndex =i;
          int min = arr[i];
          for (int j=i+1;j<arr.length;j++){
              if (min>arr[j]){
                  min = arr[j];
                  minIndex = j;
              }
          }

          if (minIndex != i) {
              // 进行交换了
              arr[minIndex] = arr[i];
              arr[i] = min;
          }
          System.out.println(Arrays.toString(arr));
      }
    }
}
