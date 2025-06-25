class Solution {
    public boolean canJump(int[] nums) {

        int l = 0, n = nums.length;
        int curJump = 0, maxJump = 0;

        while(l < n){
            if(maxJump < l)
                return false;
            curJump = l+nums[l];
            maxJump = Math.max(curJump, maxJump);

            if(maxJump >= nums.length-1)
                return true;
            l++;
        }

        return false;
    }
}