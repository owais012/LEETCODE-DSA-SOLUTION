class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int n = grid.length, m = grid[0].length;
        int[][] dp = new int[n][m];

        for (int i = 0; i < m; i += 1) {
            if (grid[0][i] == 1)
                break;
            dp[0][i] = 1;
        }

        for (int i = 0; i < n; i += 1) {
            if (grid[i][0] == 1)
                break;
            dp[i][0] = 1;
        }

        for (int i = 1; i < n; i += 1) {
            for (int j = 1; j < m; j += 1) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[n-1][m-1];
    }
}