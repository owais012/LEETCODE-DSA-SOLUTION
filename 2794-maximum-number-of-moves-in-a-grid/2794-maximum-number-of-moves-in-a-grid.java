class Solution {
    public class Node{
        int row, col, len;
        Node(int row, int col, int len){
            this.row = row;
            this.col = col;
            this.len = len;
        }
    }

    public boolean isValid(int r, int c, int n, int m){
        return r >= 0 && c >= 0 && r < n && c < m;
    }

    public int getMaxPath(int row, int col, int[][]grid){
        int n = grid.length, m = grid[0].length;

        Queue<Node> q = new LinkedList<>();
        q.add(new Node(row, col, 0));
        int res = 0;

        boolean[][]visited = new boolean[n][m];

        while(!q.isEmpty()){
            var cur = q.poll();
            res = Math.max(res, cur.len);

            int[]dr = new int[]{-1, 0, 1};
            int[]dc = new int[]{1, 1, 1};

            for(int i =0; i < 3; i += 1){
                int nrow = cur.row+dr[i];
                int ncol = cur.col+dc[i];

                if(isValid(nrow, ncol, n, m) && !visited[nrow][ncol] 
                    && grid[cur.row][cur.col] <grid[nrow][ncol]){
                        q.add(new Node(nrow, ncol, cur.len+1));
                    visited[nrow][ncol] = true;
                }
            }
            
        }
        
        return res;
    }

    public int maxMoves(int[][] grid) {
        //it is as simple as another graph problem 

        int res  = 0; 
        for(int i = 0; i < grid.length ; i += 1){
            res = Math.max(res, getMaxPath(i, 0, grid));
        }

        return res;
    }
}