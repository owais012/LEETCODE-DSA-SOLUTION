class Solution {
    public int[] constructTransformedArray(int[] nums) {
        int n = nums.length;

        int[]res = new int[n];
        for(int i = 0;  i < n; i+= 1){
            if(nums[i] > 0){
                res[i] = nums[(i + nums[i]) % n];
            }else{
                res[i] = nums[(n+i+(nums[i]%n))%n];
            }
        }

        return res;
    }
}