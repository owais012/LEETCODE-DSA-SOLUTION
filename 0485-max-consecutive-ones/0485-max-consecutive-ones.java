class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i= 0, j = 0, n = nums.length;
        int maxLen= 0;

        while(j < n){
            if(nums[j] == 1){
                j += 1;
            }else{
                maxLen = Math.max(maxLen, j-i);
                j=i;
                j++; i++;
            }
        }
        
        maxLen = Math.max(maxLen, j-i);

        return maxLen;
    }
}