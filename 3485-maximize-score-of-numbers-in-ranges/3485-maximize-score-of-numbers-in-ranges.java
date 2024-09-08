class Solution {
    public boolean isPossible(long d, int[]start, int D){
        long prev =  start[0]; 

        for(int i = 1; i < start.length; i++){
            long st = (long) start[i];
            long e =  ((long)start[i]) + D;

            if(prev+d > e){
                return false;
            }
    
            if(prev+d < st)
                prev = st;
            else prev += d;

        }

        return true;
    }
    
    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        int n = start.length;

        long st = 0, e = start[n-1]+d, res = 0;

        while(st <= e){
            long mid = (st + e)/2;
            if(isPossible(mid, start, d)){
                st = mid + 1;
                res = mid;
            }else{
                e = mid - 1;
            }
        }

        return (int) res;
    }
}