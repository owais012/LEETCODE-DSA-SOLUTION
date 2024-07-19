class Solution {
    public List<Integer> luckyNumbers (int[][] mat) {
        int n = mat.length, m = mat[0].length;

        int[]minOfRow = new int[n];
        int[]maxOfCol = new int[m];

        for(int i = 0;  i < n; i++){
            int mini = Integer.MAX_VALUE;
            for(int j = 0; j < m; j++){
                mini = Math.min(mini, mat[i][j]);
            }
            minOfRow[i] = mini;
        }

        for(int i = 0; i < m; i++){
            int maxi = Integer.MIN_VALUE;
            for(int j = 0; j < n; j++){
                maxi = Math.max(mat[j][i], maxi);
            }
            maxOfCol[i] = maxi;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(minOfRow[i] == maxOfCol[j])
                    set.add(minOfRow[i]);
            }
        }
        List<Integer> res = new ArrayList<>();
        
        for(var val : set)
            res.add(val);

        return res;
    }
}