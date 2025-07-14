class Solution {
    public double helper(double x, long n){
        if(n == 0)
            return 1d;
        if(n == 1){
            return x;
        }
        double half = helper(x, n/2);
        half *= half;

        if(n%2 == 1){
            half *= x;
        }
        return half;
    }

    public double myPow(double x, long n) {
        if(n < 0)
            return (double)1/helper(x, Math.abs(n));
        return helper(x,n);
    }
}