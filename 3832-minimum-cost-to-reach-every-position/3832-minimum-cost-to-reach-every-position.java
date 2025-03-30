class Solution {
    public int[] minCosts(int[] cost) {
        int n = cost.length;
        int[] preMin = new int[n];
        preMin[0] = cost[0];

        for(int i = 1; i < n; i += 1){
            preMin[i] = Math.min(preMin[i-1], cost[i]);
        } 

        return preMin;
    }
}