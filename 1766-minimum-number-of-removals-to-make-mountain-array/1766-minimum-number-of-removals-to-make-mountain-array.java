class Solution{
    public int[] LIS(int[]nums){
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        int[]dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for(int i = 0; i < n; i += 1){
            for(int j = 0; j < i; j += 1){

                if(nums[j] < nums[i] && 1 + dp[j] > dp[i]){
                    dp[i] = dp[j] + 1;
                } 
            }
        }

        return dp;
    }


    public int[] LDS(int[] nums ){
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        int[]dp = new int[nums.length];
        Arrays.fill(dp, 1);

        for(int i = n-1; i >= 0; i -= 1){
            for(int j = i+1; j < n; j += 1){

                if(nums[j] < nums[i] && 1 + dp[j] > dp[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                } 
            }
        }

        return dp;
    }

    public int minimumMountainRemovals(int[] nums) {
        // observation 1) this question is very similar to long subsequence with peak;
    
        //observation 2) consider each number to be peak and try to calculate 
        // Approach 1) Brute force -> Time Complexity O(n^2.log(n))
        /*
            a)  for each index find the Longest increasing subsequence from start to current 
                and Longest Decreasing subsequence from current to end 
            b)  we can have two function  for LIS and LDS

        */

        //Approach 2) Optimal Approach
        /*
            a)  for we can calculate LIS for each index and store in dp[i]
            b)  same for LDS 
            c)  now we just need to traverse through the array and get the answer
        */

        int n = nums.length;

        int[]dpLIS = LIS(nums);
        int[]dpLDS = LDS(nums);
        int res = Integer.MAX_VALUE;

        // for(var v: dpLIS)
        //     System.out.print(v + " ");
        // System.out.println();

        //  for(var v: dpLDS)
        //     System.out.print(v + " ");
        // System.out.println();

        for(int i =1; i < n-1 ; i += 1){
            if(dpLIS[i] > 1 && dpLDS[i] > 1)
            res = Math.min(res, n - dpLIS[i]-dpLDS[i]+1);
        }
        return res;
    }
}