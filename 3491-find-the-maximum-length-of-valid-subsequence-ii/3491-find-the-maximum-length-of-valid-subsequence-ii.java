class Solution{
    public int maximumLength(int[] nums, int k) {
        int[][] dp = new int[nums.length+1][k];

        int ans = 2;

        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j <= i-1; j++){
                int rem = (nums[i] + nums[j]) % k;

                dp[i][rem] = dp[j][rem] > 0 ? dp[j][rem] + 1 : 2;
                ans = Math.max(ans, dp[i][rem]);
            }
        }
        return ans;
    }
}