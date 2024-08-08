class Solution {
    
    public int  add(int r, int c, int n , int m, int[][]res, int ind){
        if(r >= 0 && c >= 0 && r < n && c < m && ind < n*m){  
            if(ind-1 >= 0 && res[ind-1][0] == r && res[ind-1][1] == c) return ind;

            res[ind][0] = r;
            res[ind][1] = c;
            return ind + 1;
        }
        return ind;
    }

    public int[][] spiralMatrixIII(int rows, int cols, int r, int c) {
        int op = 1;
        int[][] res = new int[rows*cols][2];
        int j = 0;

        while(j < rows*cols){

            j = add(r, c, rows, cols, res, j);
            for(int i = 0; i < op; i++){
                c += 1;
                j = add(r, c, rows, cols, res, j);
            }

            for(int i = 0; i < op; i++){
                r +=1;
                j = add(r, c, rows, cols, res, j);   
            }
            op++;

            for(int i = 0; i < op; i++){
                c -= 1;
                j = add(r, c, rows, cols, res, j);
            }

            for(int i = 0; i < op; i++){
                r -= 1;
                j = add(r, c, rows, cols, res, j);
            }  
            op++; 
        }

        return res;
    }
}