class Solution {
    public int maximumPossibleSize(int[] nums) {
        int cnt = 0, n = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < n; i += 1){
            if(max <= nums[i]){
                cnt += 1;
                max = nums[i];
            }
        }

        return cnt;
    }
}