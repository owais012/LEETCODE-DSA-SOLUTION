class Solution {

    public void add(int[] bit, int val) {
        for (int i = 0; i < 31; i += 1) {
            bit[i] += ((val >> i) & 1);
        }
    }

    public int getBitVal(int[] bit) {
        int val = 0;

        for (int i = 0; i < 31; i += 1) {
            val += (1 << i)* (bit[i] > 0 ? 1 : 0);
        }
        return val;
    }

    public void substract(int val, int[] bit) {
        for (int i = 0; i < 31; i += 1) {
            bit[i] -= ((val >> i) & 1);
        }
    }

    public int minimumSubarrayLength(int[] nums, int k) {
        int[] bit = new int[31];
        int n = nums.length;

        int l = 0, r = 0;
        int len = Integer.MAX_VALUE;

        while (r < n) {
            add(bit, nums[r]);

            while (l <= r && getBitVal(bit) >= k) {
                substract(nums[l], bit);
                len = Math.min(len, r - l + 1);
                l += 1;
            }

            r += 1;
        }

        return len == Integer.MAX_VALUE ? -1 : len;
    }

}