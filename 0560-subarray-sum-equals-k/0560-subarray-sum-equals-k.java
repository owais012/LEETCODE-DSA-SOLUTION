class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap <Integer, Integer> preSumCnt = new HashMap<>();
        preSumCnt.put(0, 1);

        int preSum = 0, ans = 0;

        for(int en = 0; en < nums.length; en++){
            preSum += nums[en];

            ans += preSumCnt.getOrDefault(preSum - k, 0);

            int curFreq = preSumCnt.getOrDefault(preSum, 0);

            preSumCnt.put(preSum, curFreq + 1);
        }

        return ans;
    
    }
}