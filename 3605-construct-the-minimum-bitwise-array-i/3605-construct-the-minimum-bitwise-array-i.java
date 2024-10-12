class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        //find array ans[] such that nums[i] == ans[i]^ (ans[i]+1);
        //this can be simply done using brute force
        int n = nums.size();
        int[]ans = new int[n];
        outerLoop:
        for(int i = 0; i < n; i++){
            int cur = nums.get(i);

            for(int j = 1; j < cur; j++){
                // System.out.println((j|(j+1)) + " " + nums.get(i));
                if((j|(j+1)) == cur){
                    ans[i] = j;
                    continue outerLoop;
                }
            }
            ans[i] = -1;
        }

        return ans;
    }
}