class Solution {
    public long findMaximumScore(List<Integer> nums) {
        long[]a = new long[nums.size()];
        int n  = nums.size();

        for(int i =0; i < nums.size(); i++){
            a[i] = nums.get(i);
        }

        // long[]dp = new long[n];
        // for(int i = 0; i < n; i++){
        //     for(int j = 0; j <= i; j++){
        //         dp[i] = Math.max(dp[i], dp[j] + ((i-j)*a[j]));
        //     }
        // }

        // return dp[n-1];
        long[]preMax = new long[n];
        preMax[0] = a[0];

        for(int i = 1; i < n; i++){
            preMax[i] = Math.max(preMax[i-1], a[i]);
        }
        long res = 0;
        long prev = preMax[0];
        int idx = 0;
        for(int i = 1; i < n; i++){
            if(prev != preMax[i]){
                res += prev*(i-idx);
                prev = preMax[i];
                idx= i;
                continue;
            }
            if(i == n-1){
                res += prev*(i-idx);
            }
        }

        return res;
    }

}