class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n = nums.length;
        HashSet<Integer> uniqueNums = new HashSet<>();

        for(var v : nums)
            uniqueNums.add(v);

        int cnt = 0;
        for(int i = 0; i < n; i += 1){
            HashSet<Integer> set = new HashSet<>();

            for(int j = i; j < n; j += 1){
                set.add(nums[j]);
                if(uniqueNums.size() == set.size())
                    cnt += 1;
            }
        }

        return cnt;
    }
}