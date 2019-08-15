package xyz.drafter.sgg.dataStructures.recursion;

/**
 * @author wangmeng
 * @date 2019/8/14
 * @desciption
 */
public class MiGong {

    public static void main(String[] args) {

        int[][] map = new int[8][7];
        for (int i= 0;i<7;i++){
            map[0][i] = 1;
            map[7][i] = 1;
        }
        for (int i=0;i<8;i++){
            map[i][0] = 1;
            map[i][6] = 1;
        }

        map[3][1] = 1;
        map[3][2] = 1;


        System.out.println("地图情况");
        for (int i =0;i<8;i++){
            for (int j= 0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

        setWay(map, 1, 1);
        System.out.println("标识过的地图情况");
        for (int i =0;i<8;i++){
            for (int j= 0;j<7;j++){
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }

    }

    //递归回溯来找路

    public static boolean setWay(int[][] map,int i,int j){
        // i,j 寻找的位置，终点map[6][5],map[i][j] 为0 ，没走过，1表示墙，2表示路径，3表示已走过但未走通
        // 策略 下->右->上->左  走不通，回溯

        if (map[6][5] == 2){
            return true;
        }
        if (map[i][j] == 0){
            //当前点未走过，按照策略走
            map[i][j] = 2;
            if (setWay(map, i+1, j)){// 向下走
                return true;
            }else if ( setWay(map, i,j+1)){
                return true;
            }else if (setWay(map, i-1, j)){
                return true;
            }else if (setWay(map,i, j-1)){
                return true;
            }else {
                map[i][j] = 3;
                return false;
            }
        }else {
            // map[i][j] 不为0，可能是 1,2,3
            return false;
        }

    }
}
