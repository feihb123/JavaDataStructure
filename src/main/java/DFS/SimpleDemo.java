package DFS;


/**
 * 走迷宫 从左上角   ->  右下角  0表示可以走的路径
 */
public class SimpleDemo {
    /**
     * 存放走过的路径
     */
    static int[][] route = new int[99][2];
    /**
     * 路径长度
     */
    static int routeSize = 1;
    /**
     * 是否找到路径
     */
    static int goal = 0;
    /**
     * direction用来指示方向（类似坐标轴方向）
     */
    static int direction[][] = {
            // y+1 向下
            {0,1},
            // x+1 向右
            {1,0},
            // y-1 向上
            {0,-1},
            // x-1 向左
            {-1,0}
    };
    /**
     * 迷宫
     */
    static int maze[][] = {
            {0, 1, 0, 0, 0},
            {0, 1, 0, 1, 0},
            {0, 0, 0, 0, 0},
            {0, 1, 1, 1, 0},
            {0, 0, 0, 1, 0},
    };

    /**
     * 标记该点是否走过
     */
    static  int flag [][] = new int[maze.length][maze[0].length];

    public static void main(String[] args)  {

         dfs(0,0,0);

        for (int i = 0; i <= routeSize; i++) {
            System.out.println(route[i][0]+" "+route[i][1]);
        }



    }

    /**
     * 利用dfs寻找出口
     * @param x  x坐标
     * @param y  y坐标
     * @param step 当前为第step步
     */
    public static void  dfs(int x,int y,int step){
        //  排除越界
        if(x > flag.length-1 || y > flag[0].length-1 || x <0 || y< 0)
        {
            return ;
        }

        //   迷宫0代表可走      标记0表示未走过   goal = 1表示已经完成
        if(maze[x][y] == 1 || flag[x][y] == 1 ||goal == 1){
            return ;
        }

        //   找到需要的情况
        if(x == flag.length-1 && y == flag[0].length-1){
            route[step][0] = x;
            route[step][1] = y;
            routeSize = step ;
            goal = 1;
            return ;
        }
        //从下 右 上 左的顺序找出口
        for(int i = 0;i < 4;i++){
            //需要进行的操作（记录当前点）
            flag[x][y] = 1;
            route[step][0] = x;
            route[step][1] = y;
            //下一次要走的坐标
            int nextX = x + direction[i][0];
            int nextY = y + direction[i][1];

            //进行下一步
            step++;
            dfs(nextX,nextY,step);

            //回溯时覆盖不通的路径
            step--;
        }


        return ;
    }


}
