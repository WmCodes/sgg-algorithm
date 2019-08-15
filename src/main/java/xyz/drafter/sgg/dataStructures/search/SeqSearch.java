package xyz.drafter.sgg.dataStructures.search;

/**
 * @author wangmeng
 * @date 2019/8/15
 * @desciption 线性查找
 */
public class SeqSearch {


    public static void main(String[] args) {

        int[] arr = {1,9,11,-1,34,89};
        int index = seqSearch(arr,-1);
        if (index == -1){
            System.out.println("没有找到");
        }else {
            System.out.println(index);
        }

    }


    public static int seqSearch(int[] arr,int value){
        //逐一比对，相同值就返回
        for (int i = 0;i<arr.length ;i++){
            if (arr[i] == value){
                return i;
            }
        }
        return -1;

    }
}
