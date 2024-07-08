class Solution {
    static record Cell(int x, int y ){};
    public int numberOfSubmatrices(char[][] grid){
        int n = grid.length, m = grid[0].length;
        Cell[][]prefix = new Cell[n][m];
        // if(grid[0][0] != 'X') return 0;

        for(int i = 0; i < n; i++){
            int x = grid[i][0] == 'X' ? 1: 0;
            int y = grid[i][0] == 'Y' ? 1: 0;
            prefix[i][0] = new Cell(x,y);

            for(int j = 1; j < m; j++){
                x = prefix[i][j-1].x + (grid[i][j] == 'X' ? 1: 0);
                y = prefix[i][j-1].y + (grid[i][j] == 'Y' ? 1: 0);
                prefix[i][j] = new Cell(x,y);
            }
        }

        for(int i = 0; i < m; i++){
            for(int j = 1; j < n; j++){
                int x = prefix[j][i].x +  prefix[j-1][i].x;
                int y = prefix[j][i].y +  prefix[j-1][i].y;   

                prefix[j][i] = new Cell(x,y);
            }
        }

        int cnt = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(prefix[i][j].x > 0 && prefix[i][j].x == prefix[i][j].y)
                    cnt += 1;
            }
        }

        return cnt;
    }

}