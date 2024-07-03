class Solution{
    public int minimize(int low, int high, int[] nums){
        if(low == -1){
            return nums[high] - nums[0];
        }
        if(high == nums.length){
            return nums[nums.length-1] - nums[low];
        }

        return nums[high] - nums[low];
    }

    public int minDifference(int[] nums){
        if(nums.length <= 4) return 0;

        int minDiff = Integer.MAX_VALUE;
        int n = nums.length-1; 

        Arrays.sort(nums);
        minDiff = Math.min(minDiff, minimize(2, n-1, nums));
        minDiff = Math.min(minDiff, minimize(1, n-2, nums));
        minDiff = Math.min(minDiff, minimize(-1, n-3, nums));
        minDiff = Math.min(minDiff, minimize(3, n+1, nums));
        
        return minDiff;   
    }
}