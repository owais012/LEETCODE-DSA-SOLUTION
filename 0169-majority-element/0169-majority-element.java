class Solution {
    public int majorityElement(int[] nums) {
        int count = 0, candidate = 0, n = nums.length;

        for(int i = 0; i < n; i += 1){
            if(count == 0){
                candidate = nums[i];
            }

            count += (candidate == nums[i]) ?1 : -1;
        }
        
        return candidate;
    }
}