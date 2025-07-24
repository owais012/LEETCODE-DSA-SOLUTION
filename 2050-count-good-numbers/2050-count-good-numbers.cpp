class Solution {
public:
    int countGoodNumbers(long long n) {
        // there are two methods to solve this problem,
        // one is linear multiplication,

        // other if binary exponantiation
        // if n is odd , then count_5 be greater than count_4, by 1

        auto powMod = [&](long long a, long long b, long long m) {
            a %= m;
            long long res = 1;
            while (b > 0) {
                if (b & 1)
                    res = res * a % m;
                a = a * a % m;
                b >>= 1;
            }
            return res;
        };

        long long ways = 0;
        ways = powMod(5, (n+1)/2, 1e9+7);
        ways = (ways *  powMod(4, n/2, 1e9+7))% (long long) (1e9+7);
        
        return ways;
    }
}
;