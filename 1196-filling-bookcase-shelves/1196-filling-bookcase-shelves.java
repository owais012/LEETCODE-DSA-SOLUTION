class Solution{
    public int helper(int ind, int[][] books, int  shelfWidth, int[] dp){
        if(ind >= books.length)
            return 0;

        if(dp[ind] != -1)
            return dp[ind];

        int curWidth = 0;
        int minHeight = Integer.MAX_VALUE;
        int h = 0;

        for(int i = ind; i < books.length ; i++){
            curWidth += books[i][0];
            if(curWidth > shelfWidth)   
                break;
            h = Math.max(h, books[i][1]);
            int curHeight = h + helper(i+1, books, shelfWidth, dp);
            minHeight = Math.min(minHeight, curHeight);
        }

        return dp[ind] = minHeight;
    }

    public int minHeightShelves(int[][] books, int shelfWidth){
        int[] dp = new int[1001];
        Arrays.fill(dp, -1);

        return helper(0, books, shelfWidth,dp);
    }
}