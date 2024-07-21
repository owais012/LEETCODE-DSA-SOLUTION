class Solution {
    public long minimumOperations(int[] nums, int[] target) {
        int[]d = new int[nums.length];
        
        for(int i =0; i < nums.length; i++)
            d[i] = nums[i] - target[i];

        int pd = d[0];
        int n = nums.length;

        long ans = Math.abs(d[0]);

        for(int i = 1; i < n; i++){
            
            if(pd >= 0 && d[i] >= 0){
                ans += Math.max(d[i] - pd , 0);
            }else if(pd < 0 && d[i] < 0){
                ans += Math.max(-d[i] - (-pd), 0);
            }else{
                ans += Math.abs(d[i]);
            }
            pd = d[i];
        }
        return ans;
    }

}