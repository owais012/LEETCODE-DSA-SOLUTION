class Solution {
    public long getSum(long n) {
        return (n * (n + 1)) / 2;
    }

    public boolean isPossible(long time, long h, long[] w) {
        long height = 0;
        for (int i = 0; i < w.length; i++) {
            long st = 0, e = h; // i was making mistake here, instead of taking e = h, 
            //I was making it time , there was no need of these , I am really stupid 

            while (st <= e) {
                long mid = (st + e) / 2;
                if ((long) getSum(mid) * w[i] <= time) {
                    st = mid + 1;
                } else {
                    e = mid - 1;
                }
            }
            if (st > 0)
                height += (st - 1);
        }
        return height >= h;
    }

    public long minNumberOfSeconds(int h, int[] worker) {
        long st = 0, e = (long) 1e16 + 7;

        long[] w = new long[worker.length];
        for (int i = 0; i < worker.length; i++) {
            w[i] = worker[i];
        }

        while (st <= e) {
            long mid = (st + e) / 2;
            if (isPossible(mid, h, w)) {
                e = mid - 1;
            } else {
                st = mid + 1;
            }
        }

        return e + 1;
    }
}