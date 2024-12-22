class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        int cnt = 0;
        for(int i = n-1; i >= 0; i -= 1){
            if(map.getOrDefault(nums[i], 0) + 1 > 1){
                return (n-cnt+2)/3;
            }   
            map.put(nums[i], 1);
            cnt += 1;
        }

        return 0;
    }
}