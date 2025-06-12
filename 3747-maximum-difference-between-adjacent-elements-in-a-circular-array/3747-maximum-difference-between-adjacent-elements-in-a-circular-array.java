class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int maxDiff = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i = 0; i < n-1; i += 1){
            maxDiff = Math.max(maxDiff, Math.abs(nums[i] - nums[i+1]));
        }

        return Math.max(maxDiff, Math.abs(nums[0] - nums[n-1]));
    }
}