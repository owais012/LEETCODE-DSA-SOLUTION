class Solution {
    public int countSubarrays(int[] nums) {
        int cnt = 0, n = nums.length;

        for(int i = 1; i < n-1; i += 1){
            int first = nums[i-1];
            int second = nums[i];
            int third = nums[i+1];

            if((first+third)*2 == second)
                cnt += 1;
        }

        return cnt;
    }
}