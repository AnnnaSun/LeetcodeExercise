package src.EverydayTest;

public class solution11_12 {
    private static final long MOD = (long)1e9 +7;
    public int numTilings(int n) {
        long[] dp = new long[n+1];
        if (n==1)return 1;
        if (n==2) return 2;
        if (n==3) return 5;
        if (n >3){
            dp[0] = 1;
            dp[1]=1;
            dp[2]=2;
            for (int i=3; i<=n;i++){
                dp[i] = (2*dp[n-1]+dp[n-3]) %MOD;
            }
        }
        return (int)dp[n];
    }
}
