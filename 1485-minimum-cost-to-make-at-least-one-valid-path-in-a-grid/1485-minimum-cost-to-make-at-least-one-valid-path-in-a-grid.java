class Node{
    int row, col, cost;
    Node(int r, int c, int cost){
        row = r;
        col = c;
        this.cost = cost;
    }
}

class Solution{
    public int minCost(int[][] grid){
        int n = grid.length,  m = grid[0].length;
        int[][]dp = new int[n][m];
        int[][]vis = new int[n][m];
        for(int[] row: dp)
            Arrays.fill(row, 10000);

        Deque<Node> dq = new ArrayDeque<>();
        dq.addFirst(new Node(0,0,0));
        dp[0][0] = 0;

        while(!dq.isEmpty()){
            Node curNode = dq.poll();
            int r = curNode.row;
            int c = curNode.col;
            int cost = curNode.cost;
            if(vis[r][c] == 1) continue;
            vis[r][c] = 1;
            dp[r][c] = Math.min(dp[r][c], cost);
            int[] dr = new int[]{0, 0, 1,-1};
            int[] dc = new int[]{1,-1, 0, 0};

            for(int i = 0; i < 4; i++){
                int nr = r + dr[i];
                int nc = c + dc[i];

                if(Math.min(nr, nc) < 0 || nr >= n || nc >= m || vis[nr][nc] == 1)
                    continue;
                if(grid[r][c] == i+1)
                    dq.addFirst(new Node(nr, nc, cost));
                else
                    dq.addLast(new Node(nr, nc, cost+1));
            }
        }

        return dp[n-1][m-1];
    }
}