package xyz.drafter.sgg.algorithm;

import java.util.Arrays;

/**
 * @author wangmeng
 * @date 2019/8/20
 * @desciption prim算法
 */
public class PrimAlgorithm {
    public static void main(String[] args) {
        char[] data = new char[]{'A','B','C','D','E','F','G'};
        int verxs = data.length;
        int[][] weight = new int[][]{




        };
        MGraph mGraph = new MGraph(verxs);
        MinTree minTree = new MinTree();
        minTree.createGraph(mGraph, verxs, data, weight);
        //输出
        minTree.showGraph(mGraph);

    }


}

//创建最小生成树->村庄的图
class MinTree{
    // 图对象，图对应的顶点个数，图的各个顶点的值，图的邻接矩阵
    public void createGraph(MGraph graph,int vers,char[] data,int[][] weight){
        int i,j;
        for ( i=0;i<vers;i++){
            graph.data[i] = data[i];
            for (j=0;j<vers;j++){
                graph.weight[i][j] = weight[i][j];
            }
        }
    }

    public void showGraph(MGraph mGraph){
        for (int[] link: mGraph.weight){
            System.out.println(Arrays.toString(link));
        }
    }

    //编写prim算法，得到最小生成树
    // 图 ，图的顶点索引
    public void prim(MGraph mGraph,int v){
        // 标记结点是否被访问过
        int[] visited = new int[mGraph.verxs];

        //
        // 把当前节点标记为已访问
        visited[v] = 1;
        // 记录两个订点的下标
        int h1 = -1;
        int h2 = -1;

        int minWeight = 1000;
        for (int k =1;k<mGraph.verxs;k++){
            // 有verxs个订单，prim算法结束后，有  verxs-1边
            for (int i = 0 ;i <mGraph.verxs;i++){
                for (int j = 0; j<mGraph.verxs;j++){
                    if (visited[i] == 1 &&visited[j] == 0 && mGraph.weight[i][j]<minWeight){
                        // 两个for循环  找所有顶点中，一个访问过的 和一个未访问过的  权值最小的路径，
                        // 这样n个顶点，遍历n-1遍 即可获得最短路径
                        minWeight = mGraph.weight[i][j];
                        h1 = i;
                        h2 = j;
                    }
                }
            }

            //找到一条边最小
            System.out.println("边<"+mGraph.data[h1]+","+mGraph.data[h2]+">权值:"+minWeight);
            visited[h2] =1;
            minWeight = 1000;

        }
    }

}

class MGraph{
    int verxs;// 表示图的节点个数
    char[] data;//节点数据
    int[][] weight;//存放边

    public MGraph(int verxs){
        this.verxs = verxs;
        data = new char[verxs];
        weight = new int[verxs][verxs];
    }


}
