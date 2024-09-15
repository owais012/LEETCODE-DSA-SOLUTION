class Solution {
    public static void print(long... a) {
        for (var v : a)
            System.out.print(v + " ");
        System.out.println();
    }

    public long maxScore(int[] a, int[] b) {
        int n = b.length;
        long[][] dp = new long[n][4];
        long res = Long.MIN_VALUE;

        dp[0][0] = a[0] * b[0];
        for (int i = 1; i < 4; i++) {
            dp[0][i] = dp[0][i - 1] + (a[i] * b[i]);
            System.out.print(dp[0][i] + " ");
        }
        
        System.out.println();
        for (int i = 1; i < n; i++) {
            // every index can be considered for 0,1,2,3
            // if considered 1 what's best for
            for (int j = 0; j < 4; j++) {
                if (j == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], (long) a[0] * (long) b[i]);
                    continue;
                }
                if (i >= j){
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i-1][j - 1] + ((long) a[j] * b[i]));
                    // System.out.println("dp[i-1][j - 1] + (a[j] * b[i]) -> " + dp[i-1][j - 1]+" " + "ai " + a[j]+ " bi "+ b[i]);
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
            // print(dp[i]);
            res = Math.max(dp[i][3], res);
        }

        return res;
    }
}