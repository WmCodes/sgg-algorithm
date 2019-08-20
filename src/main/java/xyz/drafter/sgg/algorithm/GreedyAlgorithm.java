package xyz.drafter.sgg.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

/**
 * @author wangmeng
 * @date 2019/8/20
 * @desciption 贪心算法
 */
public class GreedyAlgorithm {

    public static void main(String[] args) {
        // 创建电台，放入map
        HashMap<String, HashSet<String>> broadcasts = new HashMap<>();
        // 将各个电台放入broadcasts
        HashSet<String> hashSet1 = new HashSet<>();
        hashSet1.add("北京");
        hashSet1.add("上海");
        hashSet1.add("天津");

        HashSet<String> hashSet2 = new HashSet<>();
        hashSet2.add("广州");
        hashSet2.add("北京");
        hashSet2.add("深圳");

        HashSet<String> hashSet3 = new HashSet<>();
        hashSet3.add("成都");
        hashSet3.add("上海");
        hashSet3.add("杭州");


        HashSet<String> hashSet4 = new HashSet<>();
        hashSet4.add("天津");
        hashSet4.add("上海");

        HashSet<String> hashSet5 = new HashSet<>();
        hashSet5.add("杭州");
        hashSet5.add("大连");

        broadcasts.put("k1", hashSet1);
        broadcasts.put("k2", hashSet2);
        broadcasts.put("k3", hashSet3);
        broadcasts.put("k4", hashSet4);
        broadcasts.put("k5", hashSet5);
        
        HashSet<String> allAreas = new HashSet<>();
        allAreas.add("北京");
        allAreas.add("上海");
        allAreas.add("天津");
        allAreas.add("广州");
        allAreas.add("深圳");
        allAreas.add("成都");
        allAreas.add("杭州");
        allAreas.add("大连");
        
        
        //创建ArrayList  存放选择的电台集合
        ArrayList<String> selects = new ArrayList<>();

        //定义临时的集合，在遍历过程中，存放遍历过程中的电台覆盖的地区和当前没有覆盖地区的交集
        HashSet<String> temp = new HashSet<>();

        //定义个maxKey，保存一次遍历过程中，能够覆盖最大未覆盖地区对应的电台key
        String maxKey = null;
        while (allAreas.size() != 0){
             maxKey = null;
            // 遍历broadcasts
            for (String key:broadcasts.keySet()){
                temp.clear();
                HashSet<String> areas = broadcasts.get(key);
                temp.addAll(areas);
                // 求出temp 和 allAreas 集合的交集，会赋给temp
                //temp.retainAll(allAreas);
                if (maxKey != null) {
                    broadcasts.get(maxKey).retainAll(allAreas);
                }
                if(temp.size() >0 && (maxKey == null || temp.size()>broadcasts.get(maxKey).size())){
                    maxKey = key;
                }
            }
            if (maxKey != null){
                selects.add(maxKey);
                allAreas.removeAll(broadcasts.get(maxKey));
            }
        }

        System.out.println("得到的算着结果是: "+selects);

    }
}
