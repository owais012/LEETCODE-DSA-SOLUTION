class Solution {
    public int maxSum(int[] nums) {
        //given an array select all unique numbers and return their sum, 
        // if all negative just return the maximum number 

        int max = Integer.MIN_VALUE;
        int n = nums.length;

        for(int i = 0; i < n; i += 1){
            max = Math.max(nums[i], max);
        }

        if(max <= 0){
            return max;
        }
        int sum = 0;
        HashSet<Integer> set = new HashSet<>();


        for(var v : nums){
            if(v > 0 && !set.contains(v)){
                sum += v;
                set.add(v);
            }   
        }

        return sum;
    }
}