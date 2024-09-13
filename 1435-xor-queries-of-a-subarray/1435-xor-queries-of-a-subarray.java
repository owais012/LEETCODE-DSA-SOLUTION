class Solution {
    public int[] xorQueries(int[] arr, int[][] q) {
        int n = arr.length;
        int[]prefix = new int[n];
        int[]res = new int[q.length];

        prefix[0] = arr[0];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1]^arr[i];
        }


        for(int i = 0; i < q.length; i++){
            int l = q[i][0];
            int r = q[i][1];
            if(l == 0){
                res[i] = prefix[r];
            }else{
                res[i] = prefix[r] ^ prefix[l-1];
            }
        }

        return res;
    }
}