class Solution {
    public int rob(int[] nums) {
        //if you take                 where j is max till 
        //dp[i] = Math.max(dp[i-1], nums[i] + dp[j])
        int n = nums.length;
        int[]dp = new int[n+1];
    
        for(int i = 1; i <= n; i += 1){
            int take = 0;
            for(int j = 0; j < i; j += 1){
                take = Math.max(take, nums[i-1] +( j-1 >=0 ? dp[j-1]:0));
            }

            dp[i] = Math.max(dp[i-1], take);
        }

        return dp[n];
    }
}