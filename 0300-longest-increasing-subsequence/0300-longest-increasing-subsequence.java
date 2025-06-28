class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;

        int[]dp = new int[n];      
        Arrays.fill(dp, 1);
        // dp[0] = 0;  
        for(int i = 0; i < n; i += 1){
            for(int j = 0; j < i; j += 1){
                if(nums[j] < nums[i] && 1 + dp[j] > dp[i]){
                    dp[i] = 1 + dp[j];
                }
            }
            System.out.println(dp[i]);
        } 

        int ans = 0;
        for(int i = 0; i < n; i += 1){
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}