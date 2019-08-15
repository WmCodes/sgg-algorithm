package xyz.drafter.sgg.dataStructures.sort;

import java.util.Arrays;

/**
 * @author wangmeng
 * @date 2019/8/15
 * @desciption
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {8,9,1,7,2,3,5,4,6,0};
        shellSort2(arr);
        System.out.println(Arrays.toString(arr));

    }



    // 交换法
    public static void shellSort(int[] arr){
        int temp = 0;
        for (int gap = arr.length/2;gap>0;gap /=2){
            for (int i = gap;i<arr.length;i++){
                //分成gap组，每组个元素，步长为gap
                for (int j = i-gap; j>=0;j -=gap){
                    // 步长为5
                    // 如果当前元素大于加上步长后的那个元素，说明交换
                    if (arr[j] > arr[j+gap]){
                        temp = arr[j];
                        arr[j] = arr[j+gap];
                        arr[j+gap] = temp;
                    }
                }
            }
            System.out.println("谢尔排序:= "+ Arrays.toString(arr));

        }

     /*   int temp = 0;
        // 希尔排序的第1轮排序
        for (int i = 5;i<arr.length;i++){
            //分成5组，每组2个元素，步长为5
            for (int j = i-5; j>=0;j -=5){
                // 步长为5
                // 如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j+5]){
                    temp = arr[j];
                    arr[j] = arr[j+5];
                    arr[j+5] = temp;
                }
            }
        }

        System.out.println("第一轮结果:"+ Arrays.toString(arr));

        // 希尔排序的第2轮排序
        for (int i = 2;i<arr.length;i++){

            for (int j = i-2; j>=0;j -=2){
                // 步长为5
                // 如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j+2]){
                    temp = arr[j];
                    arr[j] = arr[j+2];
                    arr[j+2] = temp;
                }
            }
        }
        System.out.println("第二轮结果:"+ Arrays.toString(arr));

        // 希尔排序的第3轮排序
        for (int i = 1;i<arr.length;i++){

            for (int j = i-1; j>=0;j -=1){
                // 步长为5
                // 如果当前元素大于加上步长后的那个元素，说明交换
                if (arr[j] > arr[j+1]){
                    temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("第三轮结果:"+ Arrays.toString(arr));*/
    }

    // 移位法 效率高
    public static void shellSort2(int[] arr){
        for (int gap = arr.length/2; gap >0 ; gap/=2){
            for (int i = gap;i<arr.length;i++){
                int j = i;
                int temp = arr[j];
                if (arr[j] < arr[ j- gap]){
                    while ( j -gap >= 0 && temp <arr[j-gap]){
                        // 移动
                        arr[j] = arr[j-gap];
                        j -=gap;
                    }
                    //退出则找到位置
                    arr[j] = temp;
                }
            }
        }
    }
}
