
class Solution {
    static int K;

    static final long MOD = 1000000007;

    public static long mul(long a, long b) {
        return ((a % MOD) * (b % MOD)) % MOD;
    }

    public static long powUnderMod(long a, long n) {
        if (n == 0) {
            return 1;
        }
        long partialAns = powUnderMod(a, n / 2);
        partialAns = mul(partialAns, partialAns);
        if (n % 2 != 0) {
            partialAns = mul(partialAns, a);
        }
        return partialAns;
    }

    public int[] getFinalState(int[] nums, int k, int m) {
        if (m == 1)
            return nums;

        int n = nums.length;
        long[][] a = new long[n][2];
        int[] res = new int[n];

        long maxi = Integer.MIN_VALUE;
        PriorityQueue<long[]> pq = new PriorityQueue<>((a1, a2) -> {
            if (a1[0] != a2[0]) {
                return Long.compare(a1[0], a2[0]);
            } else {
                return Long.compare(a1[1], a2[1]);
            }
        });

        for (int i = 0; i < n; i++) {
            a[i][0] = nums[i];
            a[i][1] = i;
            pq.add(a[i]);
            maxi = Math.max(maxi, nums[i]);
        }

        while (k > 0 && pq.peek()[0] * m <= maxi) {
            long[] cur = pq.poll();
            cur[0] = (cur[0] * m) % MOD;
            pq.add(cur);
            k--;
        }

        System.out.println(k);
        int rep = k / n, rem = k % n;
        long pow = powUnderMod(m, rep);
        long pow_1 = powUnderMod(m, rep+1);

        while (n-- > 0) {
            var cur = pq.poll();
            var val = rem-- > 0 ? pow_1 : pow;
            val *= cur[0];
            val %= MOD;
            res[(int)cur[1]] = (int) val;
        }

        return res;
    }
}