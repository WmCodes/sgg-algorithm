package xyz.drafter.sgg.dataStructures.search;

import java.util.ArrayList;

/**
 * @author wangmeng
 * @date 2019/8/15
 * @desciption 二分查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {1,8,10,89,1000,1000,1234};

/*        int index = binarySearch(arr, 0, arr.length-1, 88);
        System.out.println(index);*/
        ArrayList list = binarySearch2(arr, 0, arr.length-1,1000);
        System.out.println(list);


    }


    public static int binarySearch(int[] arr,int left,int right,int findVal){
        if (left > right){
            return -1;
        }
        // 插值查找:
        // int mid = left +(right-left)*(findVal-arr[left])/(arr[right]-arr[left])

        int mid = (left+right)/2;
        int midVal = arr[mid];
        System.out.println("left:"+left);
        System.out.println("right:"+right);
        System.out.println("mid:"+mid);

        if (findVal > midVal){
            return binarySearch(arr, mid+1, right, findVal);
        }else if (findVal < midVal){
            return binarySearch(arr, left, mid-1, findVal);
        }else {
            return mid;
        }
    }


    // 含有多个相同值
    public static ArrayList<Integer> binarySearch2(int[] arr, int left, int right, int findVal){
        if (left > right){
            return new ArrayList<>();
        }

        int mid = (left+right)/2;
        int midVal = arr[mid];
        System.out.println("left:"+left);
        System.out.println("right:"+right);
        System.out.println("mid:"+mid);

        if (findVal > midVal){
            return binarySearch2(arr, mid+1, right, findVal);
        }else if (findVal < midVal){
            return binarySearch2(arr, left, mid-1, findVal);
        }else {
            ArrayList<Integer> resIndexList = new ArrayList<>();
            int temp = mid-1;
            while (true){
                if (temp<0 || arr[temp]!= findVal){
                    break;
                }
                resIndexList.add(temp);
                temp--;
            }
            resIndexList.add(mid);
            temp = mid+1;
            while (true){
                if (temp>arr.length-1 || arr[temp]!= findVal){
                    break;
                }
                resIndexList.add(temp);
                temp++;
            }

            return resIndexList;
        }
    }
}
