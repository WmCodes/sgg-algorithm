package xyz.drafter.sgg.algorithm.kmp;

/**
 * @author wangmeng
 * @date 2019/8/20
 * @desciption 暴力匹配
 */
public class ViolenceMatch {
    public static void main(String[] args) {
        String str1 = "aaewex vgersdfxcpppowwa";
        String str2 = "vger";
        int index = violenceMatch(str1, str2);
        System.out.println(index);
    }

    public static int violenceMatch(String str1,String str2){
        char[] s1 = str1.toCharArray();
        char[] s2 = str2.toCharArray();

        int s1Len = s1.length;
        int s2Len = s2.length;

        int i = 0;//i索引指向s1
        int j = 0;//j索引指向s2
        while (i<s1Len && j<s2Len){
            //保证匹配时不越界
            if (s1[i] == s2[j]){
                j++;
                i++;
            }else {
                i = i-(j-1);
                j =0;
            }
        }
        if (j ==s2Len){
            return i-j;
        }else {
            return -1;
        }

    }
}
