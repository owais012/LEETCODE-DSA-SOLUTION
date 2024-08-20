class Solution{
    int[][][]dp;
    public int helper(int alice, int i, int M, int[] piles){
        if(i >= piles.length)
            return 0;

        if(dp[alice][i][M] != -1)
            return  dp[alice][i][M];

        int result = (alice == 1) ? -1 : Integer.MAX_VALUE;
        int score = 0;
        int x = 0;

        for(x = 1; x <= Math.min(2*M, piles.length-i); x++){
            score += piles[i+x-1];
            if(alice == 1)
                result = Math.max(result, score + helper(0, i+x, Math.max(x, M), piles));
            else
                result = Math.min(result, helper(1, i+x, Math.max(x, M), piles));
        }  
        
        return dp[alice][i][M] = result;
    }
    
    public int stoneGameII(int[] piles){
        dp = new int[2][101][101];
        for(int[][] col : dp)
            for(int[] row: col)
                Arrays.fill(row, -1);

        return helper(1, 0, 1, piles);
    }
}