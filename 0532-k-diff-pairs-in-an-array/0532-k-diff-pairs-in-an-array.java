class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int cnt = 0; HashSet<Integer>set = new HashSet<>();

        for(int i = 0; i < nums.length; i++){
            int x = nums[i];
            if(set.contains(x))
                continue;
            set.add(x);
            if(Arrays.binarySearch(nums, i+1, nums.length, x+k) >= 0){
                cnt += 1;
            }
        }   

        return cnt;
    }
}