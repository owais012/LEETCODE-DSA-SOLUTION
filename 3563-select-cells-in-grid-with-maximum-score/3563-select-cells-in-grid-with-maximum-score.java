class Solution {
    public int helper(int ind, int n , int mask_row, List<int[]> arr, int[][]dp){
        if(ind == n) return 0;

        if(dp[ind][mask_row] != -1) return dp[ind][mask_row];

        int curRow = arr.get(ind)[1];
        int ans = 0;

        if(((1 << curRow) & mask_row) > 0 ){
            System.out.println("hellow");
            ans +=  helper(ind+1, n, mask_row, arr, dp);
        }else{
            int j = ind+1;
            while(j < n && arr.get(ind)[0] == arr.get(j)[0]) j++;

            int take = arr.get(ind)[0] + helper(j, n, (mask_row | (1 << curRow)), arr, dp);
            int notTake = helper(ind+1, n, mask_row, arr, dp);

            ans = Math.max(ans, Math.max(take, notTake));
            // System.out.println(ans);
        }

        return dp[ind][mask_row] = ans;
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
        int[][] dp = new int[n][(1 << 10) + 1];
        for (var row : dp)
            Arrays.fill(row, -1);
        return helper(0, n, 0, a, dp);
    }
}