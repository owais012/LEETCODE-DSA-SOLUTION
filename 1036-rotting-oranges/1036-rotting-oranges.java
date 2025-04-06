class Solution {
    class Node{
        int row, col;
        Node(int row, int col){
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting(int[][] grid) {

        Queue<Node> q = new LinkedList<>();
        int n = grid.length, m = grid[0].length;

        int fo = 0;
        for(int i =0; i < n; i+=1 ){
            for(int j= 0; j < m; j += 1){
                if(grid[i][j] == 2){
                    q.add(new Node(i,j));
                }
                if(grid[i][j] == 1){
                    fo += 1;
                }
            }
        }

        boolean visited[][] = new boolean[n][m];
        int time = 0;

        int[] delr = new int[]{-1, 0, 1, 0};
        int[] delc = new int[]{0, 1, 0, -1};   

        while(!q.isEmpty()){
            if(fo == 0)
                return time;
            int size =  q.size();

            for(int j = 0; j < size; j += 1){
                var curNode = q.poll();

                for(int i = 0; i < 4; i += 1){
                    int newRow = curNode.row + delr[i];
                    int newCol = curNode.col + delc[i];

                    if(newRow >= 0 && newRow < n && newCol >= 0 && newCol < m  && 
                        !visited[newRow][newCol] && grid[newRow][newCol] == 1){
                        
                        q.add(new Node(newRow, newCol));
                        visited[newRow][newCol] = true;
                        fo -= 1;
                    }
                }
            }

            time += 1;
        }

        if(fo > 0)
            return -1;

        return time;
    }
}