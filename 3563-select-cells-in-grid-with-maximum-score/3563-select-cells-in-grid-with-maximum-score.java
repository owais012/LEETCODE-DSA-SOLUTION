class Solution {
    public int helper(int ind, int n , int mask_row, List<int[]> arr, int[][]dp){
        if(ind == n) return 0;

        if(dp[ind][mask_row] != -1) return dp[ind][mask_row];

        int curRow = arr.get(ind)[1];

        if(((1 << curRow) & mask_row) > 0 ){
            return  helper(ind+1, n, mask_row, arr, dp);
        }

        int j = ind+1;
        while(j < n && arr.get(ind)[0] == arr.get(j)[0]) j++;

        int take = arr.get(ind)[0] + helper(j, n, (mask_row | (1 << curRow)), arr, dp);
        int notTake = helper(ind+1, n, mask_row, arr, dp);        

        return dp[ind][mask_row]= Math.max(take, notTake);

    }

    public int maxScore(List<List<Integer>> grid) {
        List<int[]> a = new ArrayList<>();

        for (int i = 0; i < grid.size(); i++) {
            for (var v : grid.get(i)) {
                int[] t = new int[2];
                t[0] = v;
                t[1] = i;
                a.add(t);
            }
        }

        Collections.sort(a, (a1, a2) -> Integer.compare(a2[0], a1[0]));
      
        int n = a.size();
        // int[][] dp = new int[n][(1 << 10) + 1];

        // for (var row : dp)
        //     Arrays.fill(row, -1);
        // return helper(0, n, 0, a, dp);


        // // Tabulation format 
        // for(int i = 1; i < n; i++){
        //     for(int j = 0;)
        // }

        int maxMask = (1 << 10);
        int[][] dp = new int[n + 1][maxMask];
        
        // Initialize DP table
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], 0);
        }
        
        // Fill DP table
        for (int ind = n - 1; ind >= 0; ind--) {
            int curRow = a.get(ind)[1];
            for (int mask_row = 0; mask_row < maxMask; mask_row++) {
                if (((1 << curRow) & mask_row) > 0) {
                    dp[ind][mask_row] = dp[ind + 1][mask_row];
                } else {
                    int j = ind + 1;
                    while (j < n && a.get(ind)[0] == a.get(j)[0]) j++;
                    
                    int take = a.get(ind)[0] + dp[j][mask_row | (1 << curRow)];
                    int notTake = dp[ind + 1][mask_row];
                    
                    dp[ind][mask_row] = Math.max(take, notTake);
                }
            }
        }
        
        return dp[0][0];
    }
}