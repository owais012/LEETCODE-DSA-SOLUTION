class Solution{
    public int numTeams(int[] nums) {
        int res = 0;
        int n = nums.length;
        for(int j = 1; j < n-1; j++){
            int leftCntSmall = 0, rightCntGreat = 0;
            int leftCntGreat = 0, rightCntSmall = 0;

            for(int i = 0; i < j; i++){
                if(nums[i] < nums[j]){
                    leftCntSmall += 1;
                }
                if(nums[i] > nums[j]){
                    leftCntGreat += 1;
                }
            }

            for(int i  = n-1; i > j; i--){
                if(nums[i] > nums[j]){
                    rightCntGreat += 1;
                }
                if(nums[i] < nums[j]){
                    rightCntSmall += 1;
                }
            }

            res += (leftCntSmall * rightCntGreat);
            res += (leftCntGreat * rightCntSmall);
        }

        return res;
    }
}