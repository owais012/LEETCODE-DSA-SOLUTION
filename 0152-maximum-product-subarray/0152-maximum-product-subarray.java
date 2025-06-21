class Solution {
    public int maxProduct(int[] nums) {
        //The Idea of this solution is pretty straight forward
        //if(there exist a 0 or a negative integer)
        //then max would be max of product of both side 
    
        int n = nums.length;
        int[]prefix = new int[n];
        int[]suffix = new int[n];
        
        prefix[0] = nums[0];
        suffix[n-1] = nums[n-1];

        for(int i = 1; i < n; i += 1){
            prefix[i] = (prefix[i-1] == 0 ? 1 : prefix[i-1])*nums[i];
        }

        for(int i = n-2; i >= 0; i -= 1){
            suffix[i] = (suffix[i+1] == 0 ? 1 : suffix[i+1] )*nums[i];
        }
        int ans = Integer.MIN_VALUE;
        for(int i= 0; i < n; i += 1){
            ans = Math.max(ans , Math.max(prefix[i], suffix[i]));
        }

        return ans;
    }
}