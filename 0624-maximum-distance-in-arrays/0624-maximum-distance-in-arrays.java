
class Solution {
    
    public int maxDistance(List<List<Integer>> arrays) {
        int n = arrays.size();
        int[][]a = new int[n][2];

        for(int i =0; i < n; i++){
            int mini = Integer.MAX_VALUE, maxi = Integer.MIN_VALUE;
    
            for(var v : arrays.get(i)){
                mini = Math.min(mini, v);
                maxi = Math.max(maxi, v);
            }

            a[i][0] = mini;
            a[i][1] = maxi;
        }

        if(n == 1){
            return a[0][1] - a[0][0];
        }

        Arrays.sort(a, (a1, a2) -> Integer.compare(a1[0], a2[0]));
        
        int[][] prefix = new int[n][2];
        int[][] suffix = new int[n][2]; 
        
        prefix[0][0] = a[0][0];
        prefix[0][1] = a[0][1];

        for(int i=1; i < n; i++){
            prefix[i][0] = Math.min(prefix[i-1][0], a[i][0]);
            prefix[i][1] = Math.max(prefix[i-1][1], a[i][1]);
        }

        
        suffix[n-1][0] = a[n-1][0];
        suffix[n-1][1] = a[n-1][1];

        for(int i=n-2; i  >= 0; i--){
            suffix[i][0] = Math.min(suffix[i+1][0], a[i][0]);
            suffix[i][1] = Math.max(suffix[i+1][1], a[i][1]);
        }
        int res = Integer.MIN_VALUE;
        res = Math.max(res, Math.max(suffix[1][1] - a[0][0],a[0][1] - suffix[1][0]));
        res = Math.max(res, Math.max(prefix[n-2][1] - a[n-1][0],a[n-1][1] - prefix[n-2][0]));

        for(int i = 1; i < n-1; i++){
            res = Math.max(res, Math.max(suffix[i+1][1] - a[i][0],a[i][1] - suffix[i+1][0]));
            // res = Math.max(res, Math.max(prefix[n-2][1] - a[n-1][0],a[n-1][1] - prefix[n-2][0]);
        }

        return res;
    }
}