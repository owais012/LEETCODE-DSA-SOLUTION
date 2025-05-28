class Solution {
    public long minCuttingCost(int n, int m, int k) {
        if(n <= k && m <= k)    return 0;
        
        if(n > k && m > k){
            return (long) ((n-k)*k) + (long) ((m-k)*k); 
        }
        
        if(m > n){
            int t = m;
            m = n;
            n = t;
        } 

        return (long) (n-k)*k;
    }
}