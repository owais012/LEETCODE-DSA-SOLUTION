class Solution{
    boolean isSubIsland;
    public void dfs(int r, int c, int vis[][], int[][] grid1, int[][] grid2){
        vis[r][c] = 1;

        if(grid1[r][c] !=  grid2[r][c]){
            isSubIsland = false;
        }
        int[] dr = new int[]{-1, 0,1,0};
        int[] dc = new int[]{0,1,0,-1};

        for(int i = 0; i < 4; i++){
            int nr = dr[i] + r;
            int nc = dc[i] + c;

            if(Math.min(nr, nc) < 0 || grid2.length <= nr || grid2[0].length <= nc || vis[nr][nc] == 1 || grid2[nr][nc] == 0)
                continue;
            dfs(nr, nc, vis, grid1, grid2);
        }
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int subIslandCnt = 0;
        int[][] vis = new int[grid2.length][grid2[0].length];

        for(int i = 0; i < grid2.length; i++){
            for(int j = 0; j < grid2[0].length; j++){
                if(grid2[i][j] == 1 &&  vis[i][j] == 0){
                    isSubIsland = true;
                    dfs(i, j, vis, grid1, grid2);
                    if(isSubIsland) subIslandCnt++;
                }
            }
        }

        return subIslandCnt;
    }
}