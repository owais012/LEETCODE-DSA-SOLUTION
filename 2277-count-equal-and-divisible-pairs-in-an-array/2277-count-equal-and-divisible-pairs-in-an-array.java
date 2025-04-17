class Solution {
    public int countPairs(int[] nums, int k) {
        int cnt = 0, n = nums.length;
        for(int i = 0; i < n; i += 1){
            for(int j = i+1; j < n; j += 1){
                if(i == j) continue;
                if(nums[i] == nums[j] && ((i*j) % k == 0))
                    cnt += 1;
            }
        }

        return cnt;
    }
}