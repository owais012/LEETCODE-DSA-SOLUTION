class Solution {
    public class Node {
        int r, c, w;

        Node(int r, int c, int w) {
            this.r = r;
            this.c = c;
            this.w = w;
        }
    }

    public int dijkistra(int[][]grid){
        int n = grid.length, m = grid[0].length;
        int[][]dis = new int[n][m];
        for(var row: dis)Arrays.fill(row, (int)1e9);

        dis[0][0] = grid[0][0];
        PriorityQueue<Node> pq = new PriorityQueue<>((a,b)->(a.w-b.w));
        pq.add(new Node(0,0, dis[0][0]));

        while(!pq.isEmpty()){
            var cur = pq.poll();

            int[]dr = new int[]{-1, 0, 1, 0};
            int[]dc= new int[]{0, 1, 0, -1};

            for(int i = 0; i < 4; i++){
                int nr = dr[i]+cur.r;
                int nc = dc[i]+cur.c;

                if(Math.min(nr, nc) < 0 || nr >= n || nc >= m) continue;
                if(dis[nr][nc] > grid[nr][nc] + cur.w){
                    dis[nr][nc] = grid[nr][nc] + cur.w;

                    pq.add(new Node(nr, nc, dis[nr][nc]));
                }

            }
        }
        System.out.println(dis[n-1][m-1]);
        return dis[n-1][m-1];
    }

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size(), m = grid.get(0).size();

        int[][]g = new int[n][m];
        for(int i =0; i < n; i++){
            for(int j = 0; j < m; j++){
                g[i][j]  = grid.get(i).get(j);
            }
        }

        return health - dijkistra(g) > 0;
    }
}