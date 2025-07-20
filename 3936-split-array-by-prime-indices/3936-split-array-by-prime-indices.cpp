#define ll long long

class Solution {
public:
    
    vector<bool> primeSieve(int n){
        vector<bool> isPrime(n + 1, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i <= n; ++i)
        {
            if (!isPrime[i] or (long long) i * i > n)
                continue;
            for (int j = i * i; j <= n; j += i) // multiples of i
                isPrime[j] = false;
        }

        return isPrime;
    }

    ll splitArray(vector<int>& nums) {
        int n = nums.size();
        vector<bool>isPrime = primeSieve(n);
        ll sumA = 0, sumB = 0;
        for(int i = 0; i < n; i++){
            if(isPrime[i])
                sumA += nums[i];
            else
                sumB += nums[i];
        }    

        return abs(sumA - sumB);
    }
};