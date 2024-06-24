class Solution {
    public int minKBitFlips(int[] nums, int k) {
        int flips = 0;
        boolean[] isFlipped = new boolean[nums.length];
        Arrays.fill(isFlipped, false);

        int flipCnt = 0;
        for(int i = 0; i < nums.length; i++){
            if(i >= k && isFlipped[i-k])
                flipCnt--;
            if(flipCnt % 2 == nums[i]){
                if(i + k > nums.length) return -1;
                flipCnt++;
                flips++;
                isFlipped[i] = true;
            }
        }

        return flips;
    }
}