class Solution {
    public int numSubseq(int[] nums, int target) {
        int left = 0, right = nums.length-1;
        int mod = (int) 1e9+7, res = 0;
        Arrays.sort(nums);
        int[]power = new int[nums.length+1];
        power[0] = 1;
        for(int i = 1; i <= nums.length; i += 1){
            power[i] = (2*power[i-1] % mod);
        }
        while(left <= right){
            if(nums[left]+nums[right] <= target){
                res = (res + power[right-left])%mod;
                left += 1;
            }else{
                right -= 1;
            }
        }
        return  res;
    }
}