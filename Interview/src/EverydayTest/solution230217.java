package src.EverydayTest;

public class solution230217 {
    public static int largest1BorderedSquare(int[][] grid) {
        int res = 0;
        int len = grid[0].length;
        for (int i=0;i<grid.length; i++){
            for (int j=0;j<grid[i].length; j++){
                if (grid[i][j] == 0)continue;
                int temp = 1;
                for (int n = 1; n< Math.min(len-j, grid.length-i);n++){
                    if (grid[i+n][j+n] == 0)continue;
                    if (grid[i+n][j]==0 || grid[i][j+n] == 0)break;
                    for (int m=1;m<=n;m++){
                        if (grid[i+n-m][j+n]==0 || grid[i+n][j+n-m]==0)break;
                        if (m==n)temp = n+1;
                    }
                }
                res = Math.max(temp, res);
            }
        }
        return res*res;
    }

    public static void main(String[] args) {
        largest1BorderedSquare(new int[][]{new int[]{0,1,1,1}, new int[]{1,1,1,1}, new int[]{1,0,0,1}, new int[]{1,1, 1,1}, new int[]{1,0,1,1}, new int[]{1,1,0,1}});
    }
}
