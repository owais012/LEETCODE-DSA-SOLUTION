class Solution {
    public int longestSubarray(int[] nums){
        if(nums.length == 1)
            return 0;

        int n = nums.length;
        int[]prefix = new int[n];
        int[]suffix = new int[n];

        prefix[0] = nums[0];
        for(int i = 1; i < n; i++){
            if(nums[i] == 0)
                prefix[i] = 0;
            else
                prefix[i] = prefix[i-1] + nums[i]; 
        }   
        if(prefix[n-1] == n) return n-1;
        suffix[n-1] = nums[n-1];

        for(int i = n-2; i >= 0; i--){
            if(nums[i] == 0)
                suffix[i] = 0;
            else
                suffix[i] = suffix[i+1] + nums[i];
        }

        int maxLen = 0;
        if(nums[0] == 0)
            maxLen = Math.max(suffix[1], maxLen);
        else
            maxLen = Math.max(suffix[0], maxLen);

        if(nums[n-1] == 0)
            maxLen = Math.max(prefix[n-2], maxLen);
        else
            maxLen = Math.max(prefix[n-1], maxLen);

        for(int i = 1; i < n-1; i++){
            if(nums[i] == 0)
                maxLen = Math.max(prefix[i-1] + suffix[i+1], maxLen);
        }

        return maxLen;
    }
}