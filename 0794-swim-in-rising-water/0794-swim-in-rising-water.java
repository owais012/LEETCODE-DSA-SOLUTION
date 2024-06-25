class Node{
    int r, c, h;
    Node(int r, int c, int h){
        this.r = r;
        this.c = c;
        this.h = h;
    }
}

class Solution{
    public int swimInWater(int[][] grid) {
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b) -> (a.h - b.h));
        int[][] dis = new int[grid.length][grid[0].length];

        for(int[] row : dis)
            Arrays.fill(row, -1);

        pq.add(new Node(0,0,grid[0][0]));
        dis[0][0] = grid[0][0];

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int r = curNode.r;
            int c = curNode.c;
            int h = curNode.h;

            int[] dr = new int[]{-1, 0, 1, 0};
            int[] dc = new int[]{0, 1, 0, -1};

            for(int i = 0; i < 4; i++){
                int nr = dr[i] + r;
                int nc = dc[i] + c;
                if(Math.min(nr, nc) < 0 || nr >= grid.length || nc >= grid[0].length || dis[nr][nc] != -1)
                    continue;
                dis[nr][nc] = Math.max(grid[nr][nc], dis[r][c]);
                pq.add(new Node(nr, nc, grid[nr][nc]));
            }
        }

        return dis[grid.length-1][grid[0].length-1];
    }
}