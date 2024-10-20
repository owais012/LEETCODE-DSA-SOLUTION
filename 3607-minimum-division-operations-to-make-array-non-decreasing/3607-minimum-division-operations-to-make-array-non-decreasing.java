class Solution {
    public TreeMap<Integer, Integer> primeFactors(int n) {
        TreeMap<Integer, Integer> ans = new TreeMap<>();
        for (int i = 2; i * i <= n; ++i) {
            if (n % i != 0)
                continue;
            int power = 0;
            while (n % i == 0) {
                n /= i;
                power += 1;
            }
            ans.put(i, power);
        }
        return ans;
    }

    public static boolean[] primeSieve(int n) {
        boolean isPrime[] = new boolean[n + 1]; // [0, n]
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= n; ++i) {
            if (!isPrime[i])
                continue;
            for (int j = i * i; j <= n; j += i)
                isPrime[j] = false;
        }
        return isPrime;
    }

    public int minOperations(int[] nums) {
        // some how if i can find the largest divisor of nums[i]
        // then answer would be simplye
        int n = nums.length, maxi = 0;

        for (int i = 0; i < n; i += 1) {
            maxi = Math.max(maxi, nums[i]);
        }

        boolean[] isPrime = primeSieve(maxi);
        // implement sieve and than if a number is not prime
        int cnt = 0, smallest = nums[0];

        for (int i = n - 2; i >= 0; i -= 1) {
            if (isPrime[nums[i]] && nums[i] > nums[i + 1])
                return -1;

            if (!isPrime[nums[i]] && nums[i] > nums[i + 1]) {
                // System.out.println("h");
                TreeMap<Integer, Integer> map = primeFactors(nums[i]);
                int cur = 1;
                System.out.println(map);
                outerLoop: 
                for (var v : map.entrySet()) {
                    for (int j = 1; j <= v.getValue(); j += 1) {
                        cur *= v.getKey();
                        // System.out.println(cur);

                        if (cur <= nums[i + 1]) {
                            nums[i] = cur;
                            break outerLoop;
                        }
                    }
                }
                cnt += 1;
            }

            if (nums[i] > nums[i + 1])
                return -1;

        }

        return cnt;
    }
}