class Solution {
    public int[][] restoreMatrix(int[] rowSum, int[] colSum) {
        int n = rowSum.length, m = colSum.length;
        int[][] mat = new int[n][m];
        
        for(int i = 0; i < n; i++){
            for(int j = 0;  j < m; j++){
                if(rowSum[i] < colSum[j]){
                    mat[i][j] = rowSum[i];
                    colSum[j] -= rowSum[i];
                    break;
                }else{
                    mat[i][j] = colSum[j];
                    rowSum[i] -= colSum[j];
                    colSum[j] = 0;
                }
            }
        }

        return mat;
    }
}