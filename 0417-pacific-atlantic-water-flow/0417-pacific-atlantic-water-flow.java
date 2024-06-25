class Solution{
    int n, m;
    public void dfs(int r, int c, boolean[][]vis, int[][] heights){
        vis[r][c] = true;
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, 1, 0, -1};

        for(int i = 0; i < 4; i++){
            int nr = dr[i] + r;
            int nc = dc[i] + c;
            if(Math.min(nr, nc) < 0 || nr >= n || nc >= m || heights[r][c] > heights[nr][nc] || vis[nr][nc] == true)
                continue;
            dfs(nr, nc, vis, heights);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        n = heights.length;
        m = heights[0].length;
        boolean[][] atlantic = new boolean[n][m];
        boolean[][] pacific = new boolean[n][m];

        for(int i = 0; i < heights[0].length; i++){
            dfs(0, i, pacific,heights);
            dfs(n-1, i, atlantic, heights);
        }

        for(int i = 0; i < n; i++){
            dfs(i,0, pacific, heights);
            dfs(i,m-1, atlantic, heights);
        }
        List<List<Integer>> res = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(atlantic[i][j] && pacific[i][j]) 
                    res.add(Arrays.asList(i,j));
            }
        }

        return res;
    }
}