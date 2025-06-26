class Solution {
    public int longestCommonSubsequence(String s, String t) {
        int[][] dp = new int[s.length() + 1][t.length() + 1];

        for (int i = 1; i <= s.length(); i += 1) {
            for (int j = 1; j <= t.length(); j += 1) {
                if(s.charAt(i-1) == t.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        return dp[s.length()][t.length()];
    }
}