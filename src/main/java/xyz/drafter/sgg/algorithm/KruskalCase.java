package xyz.drafter.sgg.algorithm;

/**
 * @author wangmeng
 * @date 2019/8/20
 * @desciption
 */
public class KruskalCase {

    private int edgNum;//边个数
    private char[] vertexs;//顶点数组
    private int[][] matrix;//邻接矩阵
    // 使用INF 表示两个顶点不能联通
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        char[] vertexs = {'A','B','C','D','E','F','G'};
        int[][] matrix = {};

        KruskalCase kruskalCase = new KruskalCase(vertexs, matrix);


    }

    public KruskalCase(char[] vertexs,int[][] matrix){
        //初始化顶点数和边的个数
        int vlen = vertexs.length;
        // 初始化顶点
        this.vertexs = new char[vlen];
        for (int i=0;i<vertexs.length;i++){
            this.vertexs[i] = vertexs[i];
        }


        // 初始化边
        this.matrix = new int[vlen][vlen];
        for (int i=0;i<vlen;i++){
            for (int j=0;j<vlen;j++){
                this.matrix[i][j] = matrix[i][j];
            }
        }

        //统计边
        for (int i=0;i<vlen;i++){
            for (int j=i+1;j<vlen;j++){
                if (this.matrix[i][j] != INF){
                    edgNum ++;
                }
            }
        }

    }

    public void kruskal(){
        int index = 0;//表示最后结果数组的索引
        int[] ends = new int[edgNum];//保存已有最小生成树中的每个顶点在最小生成树的终点
        // 创建结果数组，保存最后的最小生成树
        EData[] rets = new EData[edgNum];

    }

    public void print(){
        System.out.println("邻接矩阵为:");
        for (int i=0;i<vertexs.length;i++){
            for (int j=0;j<vertexs.length;j++){
                System.out.println(" "+matrix[i][j]);
            }
            System.out.println();
        }
    }

    //对边进行排序处理
    private void sortEdges(EData[] edges){
        for (int i = 0;i<edges.length -1;i++){
            for (int j =0;j<edges.length-1-i;j++){
                if (edges[j].weight>edges[j+1].weight){
                    EData temp = edges[j];
                    edges[j] = edges[j+1];
                    edges[j+1] = temp;
                }
            }
        }
    }

    private int getPosition(char ch){
        for (int i=0;i<vertexs.length;i++){
            if (vertexs[i] == ch){
                return i;
            }

        }
        return -1;
    }

    // 获取图中边，放到Edata[] 数组中，后面我们需要遍历该数组
    private EData[] getEdges(){
        int index = 0;
        EData[] edges  = new EData[edgNum];
        for (int i =0;i<vertexs.length;i++){
            for (int j = i+1;j<vertexs.length;j++){
                if (matrix[i][j] != INF){
                    edges[index++] = new EData(vertexs[i],vertexs[j],matrix[i][j]);
                }
            }
        }

        return edges;
    }

    // 获取下标为i 的顶点的终点
    // ends 记录了各个顶点对应的终点是哪个， i 传入顶点对应的下标
    private int getEnd(int[] ends,int i){
        while (ends[i] != 0){
            i = ends[i];
        }
        return i;
    }

}

//创建一个类EData，对象的实例表示一条边
class EData{
    char start;
    char end;
    int weight;

    public EData(char start, char end, int weight) {
        this.start = start;
        this.end = end;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "EData{" +
                "start=" + start +
                ", end=" + end +
                ", weight=" + weight +
                '}';
    }
}
