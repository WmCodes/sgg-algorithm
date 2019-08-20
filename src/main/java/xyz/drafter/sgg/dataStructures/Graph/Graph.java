package xyz.drafter.sgg.dataStructures.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * @author wangmeng
 * @date 2019/8/19
 * @desciption
 */
public class Graph {

    private ArrayList<String> vertextList;// 顶点集合
    private int[][] edges;//存储图对应的邻结矩阵
    private int numOfEdges;//表示边的数目

    //定义数组boolean[],记录某个节点是否被访问
    private boolean[] isVisited;

    public static void main(String[] args) {
        int n = 5;
        String[] vertexValue = {"A","B","C","D","E"};
        Graph graph = new Graph(5);
        for (String value:vertexValue){
            graph.insertVertex(value);
        }
        graph.insertEdge(0, 1, 1);
        graph.insertEdge(0, 2, 1);
        graph.insertEdge(1, 2, 1);
        graph.insertEdge(1, 3, 1);
        graph.insertEdge(1, 4, 1);

        graph.showGraph();

/*        System.out.println("*******");
        graph.dfs();*/

        System.out.println("&&&&&&&&&&");
        graph.bfs();
    }


    public Graph(int n){
        edges = new int[n][n];
        vertextList = new ArrayList<>(n);
        numOfEdges = 0;
        isVisited = new boolean[n];
    }
    //得到第一个邻接结点的下标w
    public int getFirstNeighbor(int index){
        for (int j = 0;j<vertextList.size();j++){
            if (edges[index][j]>0){
                return j;
            }
        }
        return -1;
    }

    //根据前一个邻接结点的下标获取下一个邻接节点
    public int getNextNeighbor(int v1,int v2){
        for (int j = v2+1;j<vertextList.size();j++){
            if (edges[v1][j]>0){
                return j;
            }
        }
        return -1;
    }

    //深度优先遍历算法
    // i 第一次进来为0
    public void dfs(boolean[] isVisited,int i){
        System.out.println(getValueByIndex(i)+"->");
        //将节点设置为已经访问
        isVisited[i] = true;
        int w = getFirstNeighbor(i);
        while (w != -1){
            // 说明有
            if (!isVisited[w]){
                dfs(isVisited, w);
            }
            // 已经被访问
            w = getNextNeighbor(i, w);

        }
    }

    //对dfs进行重载
    public void dfs(){
        //遍历所有的节点，进行dfs
        for (int i = 0;i<getNumOfVertes();i++){
            if (!isVisited[i]){
                dfs(isVisited, i);
            }
        }
    }

    //对一个节点进行广度优秀遍历的方法
    private void bfs(boolean[] isVisited,int i){
        int u;//队列头结点对应下标
        int w;//邻结点下标
        LinkedList queue = new LinkedList();
        // 访问结点
        System.out.println(getValueByIndex(i)+"->");
        isVisited[i] = true;
        queue.addLast(i);
        while (!queue.isEmpty()){
            //取出队列的头节点下标
            u = (Integer) queue.removeFirst();
            // 得到第一个临界点的下标
            w = getFirstNeighbor(u);
            while (w != -1){
                if (!isVisited[w]){
                    System.out.println(getValueByIndex(w)+"->");
                    isVisited[w] = true;
                    queue.addLast(w);
                }
                    w = getNextNeighbor(u, w);

            }
        }
    }

    //遍历所有的节点，进行广度优先

    public void bfs(){
        for (int i = 0;i<getNumOfVertes();i++){
            if (!isVisited[i]){
                bfs(isVisited, i);
            }
        }
    }

    //返回结点的个数
    public int getNumOfVertes(){
        return vertextList.size();
    }
    //显示图对应的矩阵
    public void showGraph(){
        for (int[] link: edges){
            System.out.println(Arrays.toString(link));
        }
    }

    // 边的数目
    public int getNumOfEdges(){
        return numOfEdges;
    }

    //返回结点i对应的数据
    public String getValueByIndex(int i){
        return vertextList.get(i);
    }

    //返回 v1，v2的权值
    public int getWeight(int v1,int v2){
        return edges[v1][v2];
    }

    public void insertVertex(String vertex){
        vertextList.add(vertex);
    }

    // 点的下标
    public void insertEdge(int v1,int v2,int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        numOfEdges++;
    }
}
