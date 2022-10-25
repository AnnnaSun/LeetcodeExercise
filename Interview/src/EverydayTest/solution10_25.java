package src.EverydayTest;
//1> grid 中恰有2个岛。那么对于后续我们对岛屿编号的时候，其实只需要针对1个岛屿就可以了。
//2> 将任意数量的 0 变为 1 ，以使两座岛连接起来，变成一座岛。并且返回必须翻转的 0 的最小数目。

import java.util.ArrayDeque;
import java.util.Deque;

public class solution10_25 {
    int[][] grid, coordinate={{-1,0},{1,0},{0,-1},{0,1}};//代表上下左右四个方向
    Deque<int[]> edges;//用户存储的边缘格子
    public int shortBridges(int[][] grid){
        int result = 0;
        boolean findland = false; //只要找到2个岛屿中其中的1个岛屿，就将其设置为true，并结束步骤1中的两层for循环
        edges = new ArrayDeque<>();
        this.grid = grid;
//        将其中一个岛屿打标记（val=2)，并且保存在边缘格子edge里
        for (int i=0; !findland && i< grid.length; i++){
            for (int j=0; !findland && j< grid.length; j++){
                if (findland = (grid[i][j] ==1)) markIsland(i, j);
            }
        }
        /** 步骤2：利用边界edges，一层一层扩展岛屿（val=2），直到遇到另一个岛屿（val=1）*/
        while (!edges.isEmpty()){
            result++;// 扩展层数
            int x=0, y=0, num = edges.size();
            for (int i=0; i<num; i++){
                int[] edge = edges.removeFirst();
                for (int[] c: coordinate){// 向edge的四个方向查看格子编号，并扩展岛屿边界
                    int nex = edge[0]+c[0], ney = edge[1]+c[1];
                    if (isLegal(nex, ney) && grid[nex][ney] ==0){
                        edges.addLast(new int[]{nex, ney});// 添加新的边界
                        grid[nex][ney] = 2;
                    }
                    else if (isLegal(nex, ney)&& grid[nex][ney] ==1)return result;// 与另一个岛屿相遇，则直接返回result
                }
            }
        }
        return result;
    }

    public void markIsland(int row, int coloumn){
        if (!isLegal(row, coloumn) || grid[row][coloumn] ==2) return;
        if (grid[row][coloumn] ==0){
            grid[row][coloumn] = 2;// 将边界向外扩展1层岛屿（val=2)
            edges.addLast(new int[]{row, coloumn});
            return;
        }
        grid[row][coloumn] = 2;// 为岛屿打标记（val=2）
        for (int[] c: coordinate) markIsland(row+c[0], coloumn+c[1]);// 深度遍历某个格子的四个方向
    }
    public boolean isLegal(int row, int column) {
        return row >= 0 && row < grid.length && column >= 0 && column < grid[0].length;
    }


}
