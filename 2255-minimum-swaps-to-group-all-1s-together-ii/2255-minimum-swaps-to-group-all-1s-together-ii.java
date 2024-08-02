class Solution {
    public int minSwaps(int[] nums) {   
        int total = 0;
        int n = nums.length;

        for(int i = 0; i < nums.length; i++){
            total += nums[i];
        }
        int mini = Integer.MAX_VALUE;

        int zeroCnt = 0;
        for(int i =0; i < total; i++){
            if(nums[i] == 0)
                zeroCnt += 1;
        }

        mini = Math.min(zeroCnt, mini);

        for(int i = total; i < 2*n; i++){
            if(nums[(i-total)%n] == 0){
                zeroCnt--;
            }
            if(nums[i%n] == 0){
                zeroCnt++;
            }

            mini = Math.min(zeroCnt, mini);
        }

        return mini;

    }

}