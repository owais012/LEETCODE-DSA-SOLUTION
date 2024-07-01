class Solution {
    public int longestSubarray(int[] nums){
        int maxLen = 0;
        int left = 0, right = 0;

        int zeroFreq = 0;
        while(right < nums.length){
            if(nums[right] == 0)
                zeroFreq += 1;

            while(zeroFreq > 1){
                if(nums[left] == 0)
                    zeroFreq -= 1;
                left++;
            }

            if(zeroFreq == 1)
                maxLen = Math.max(maxLen, right-left);
            right++;
        }
        
        return zeroFreq == 0 ? nums.length-1 : maxLen;
    }
}