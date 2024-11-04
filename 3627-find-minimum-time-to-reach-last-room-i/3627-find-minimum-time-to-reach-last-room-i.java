class Solution{ 
    public class Node{
        int row, col, dis;
        Node(int row, int col, int dis){
            this.row = row;
            this.col = col;
            this.dis = dis;
        }
    }

    public int minTimeToReach(int[][] mat) {
        //so here, we are supposed to 
        int n = mat.length;
        int m = mat[0].length;
        boolean[][] visited = new boolean[n][m];
        int[][]dis = new int[n][m];
        for(var v: dis)
            Arrays.fill(v, Integer.MAX_VALUE);
        // this question looks like dijkstra type of problem

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b)-> (a.dis - b.dis));
        pq.add(new Node(0,0,0));

        while(!pq.isEmpty()){
            var cur = pq.poll();

            int[] dr = new int[]{-1,0,1,0};
            int[] dc = new int[]{0,1,0,-1};
            //we are supposed to traverse to the nearest one ;

            for(int i = 0; i < 4; i += 1){
                int nrow = dr[i] + cur.row;
                int ncol = dc[i] + cur.col;

                if(nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && !visited[nrow][ncol]){
                    int DisToReachCurCell = mat[nrow][ncol] <= cur.dis ? 1 : mat[nrow][ncol] - cur.dis+1;
                    
                    if(dis[nrow][ncol] > cur.dis + DisToReachCurCell){
                        dis[nrow][ncol] = cur.dis + DisToReachCurCell;
                        pq.add(new Node(nrow, ncol, dis[nrow][ncol]));
                        visited[nrow][ncol] = true;
                    }
                }
            }
        }

        // for(int i )

        return dis[n-1][m-1];
    }
}