class Solution {
    public long minCost(int n, int m, int[][] waitCost) {
        long[][] dp = new long[n][m];
        dp[0][0] = 1;
        for (int i = 1; i < n; i += 1) {
            dp[i][0] = dp[i-1][0] +  (i + 1)+waitCost[i][0];
        }
        for (int j = 1; j < m; j += 1) {
            dp[0][j] = dp[0][j-1] + (j + 1) + waitCost[0][j];
        }

        for (int i = 1; i < n; i += 1) {
            for (int j = 1; j < m; j += 1) {
                dp[i][j] = (i+1)*(j+1) +  waitCost[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }
        
        return dp[n-1][m-1] - waitCost[n-1][m-1];
    }
}