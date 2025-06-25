class Solution {
    public long distributeCandies(int n, int limit) {
        long res = 0;

        for(int i = 0; i <= Math.min(limit, n); i+= 1){

            int b_start = Math.max(0, Math.min(limit, n-i-limit));

            int b_end = Math.min(limit, n-i);

            if(n-i-b_end <= limit)
                res += (b_end-b_start+1);
        }   

        return res;
    }
}