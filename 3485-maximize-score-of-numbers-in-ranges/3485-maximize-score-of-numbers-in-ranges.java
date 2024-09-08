class Solution {
    public boolean isPossible(long d, int[]start, int D){
        long prev =  start[0]; 
        // if(d > start[0] + D) return false;

        for(int i = 1; i < start.length; i++){
            long st = (long) start[i];
            long e =  ((long)start[i]) + D;
            // System.out.println(prev + d);
            // System.out.println(st + " " + e);

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

        int[][]intervals = new int[n][2];

        for(int i = 0; i < n; i++){
            intervals[i][0] = start[i];
            intervals[i][1] = start[i]+d;
        }

        Arrays.sort(intervals, (a,b )->(a[0]- b[0]));
        // System.out.println(isPossible(1000_000_000, start, d));
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