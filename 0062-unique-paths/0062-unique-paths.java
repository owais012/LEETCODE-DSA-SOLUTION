class Solution {
    public int uniquePaths(int n, int m) {
        int[][]dp = new int[n+1][m+1];

        // we populate the first row of the matrix with 1, 
        // we populate the first column of the matrix with 1 
        // that all will be one

        for(int i = 0; i < m; i+= 1){
            dp[0][i] = 1;
        }
        for(int i = 0; i < n; i += 1){
            dp[i][0] = 1;
        }

        for(int i = 1; i < n; i += 1){
            for(int j = 1; j < m; j += 1){
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[n-1][m-1];
    }
}