package src.EverydayTest;

import java.util.Arrays;

public class solution11_9 {
    public int orderOfLargestPlusSign(int n, int[][] mines){
        int[][] dp =new int[n+10][n+10];
        for (int i=0;i<n;i++){
            Arrays.fill(dp[i], n);
        }
        for (int[] info: mines){
            dp[info[0]+1][info[1]+1] =0;
        }
        int[][] a = new int[n + 10][n + 10], b = new int[n + 10][n + 10], c = new int[n + 10][n + 10], d = new int[n + 10][n + 10];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dp[i][j] == 1) {
                    a[i][j] = a[i - 1][j] + 1;
                    b[i][j] = b[i][j - 1] + 1;
                }
                if (dp[n + 1 - i][n + 1 - j] == 1) {
                    c[n + 1 - i][n + 1 - j] = c[n + 2 - i][n + 1 - j] + 1;
                    d[n + 1 - i][n + 1 - j] = d[n + 1 - i][n + 2 - j] + 1;
                }
            }
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                ans = Math.max(ans, Math.min(Math.min(a[i][j], b[i][j]), Math.min(c[i][j], d[i][j])));
            }
        }
        return ans;


    }
}
