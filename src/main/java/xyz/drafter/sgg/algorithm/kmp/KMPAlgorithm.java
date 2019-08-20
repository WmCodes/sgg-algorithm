package xyz.drafter.sgg.algorithm.kmp;

import java.util.Arrays;

/**
 * @author wangmeng
 * @date 2019/8/20
 * @desciption KMP算法
 */
public class KMPAlgorithm {

    public static void main(String[] args) {
        String str1 = "BBC ABCDAB ABCDABCDABDE";
        String str2 = "ABCDABD";

        int[] next = kmpNext("ABCDABD");
        System.out.println(Arrays.toString(next));
        int index = kmpSearch(str1, str2, next);
        System.out.println(index);

    }

    // 写出kmp搜索算法
    //str1 : 原字符串  str2: 子串   next：子串的部分匹配表， -1就是没有匹配到
    public static int kmpSearch(String str1,String str2,int[] next){
            // 遍历
        for (int i = 0,j=0;i<str1.length();i++){
            // kmp算法核心
            while (j>0&& str1.charAt(i) != str2.charAt(j)){
                j = next[j-1];
            }

            if (str1.charAt(i) == str2.charAt(j)){
                j++;
            }
            if (j == str2.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    // 获取到一个字符串(子串)的部分匹配值
    public static  int[] kmpNext(String dest){
        // 创建一个数组，保存部分匹配值
        int[] next = new int[dest.length()];
        next[0] = 0;//字符串长度为1，部分匹配值为0；
        for (int i= 1,j =0;i<dest.length();i++){

            while (j >0 &&dest.charAt(i) != dest.charAt(j) ){
                j = next[j-1];

            }
            if (dest.charAt(i) == dest.charAt(j)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
