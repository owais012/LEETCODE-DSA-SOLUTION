class Solution {
    public int countOfPairs(int[] nums){
        int[][]dp = new int[nums.length][51];
        int n = nums.length;
        int mod = (int)1e9+7, res = 0;
        
        for(int i = 0; i  <= nums[0]; i++)
            dp[0][i] = 1;

        for(int i = 1; i < n; i++){
            for(int j = 0; j <= nums[i]; j++){
                int j2 = nums[i] - j;

                for(int k = 0; k <= Math.min(nums[i-1] , j); k++){
                    int k2 = nums[i-1] - k;
                    if(k2 < j2) break;
                    dp[i][j] = (dp[i-1][k] + dp[i][j])%mod;
                }
            }
        }


        for(int i = 0; i <= nums[n-1]; i++){
            res = (dp[n-1][i] + res) % mod;
        }

        System.out.println(dp[n-1][nums[n-1]]);
        return res;
    }
}