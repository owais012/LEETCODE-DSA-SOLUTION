class Solution {
    public static void print(int... a) {
        for (var v : a)
            System.out.print(v + " ");
        System.out.println();
    }

    public int[] getBit(int num) {
        int[] bit = new int[31];
        for (int i = 0; i < 31; i++) {
            bit[i] = 1 & (num >> i);
        }
        return bit;
    }

    public int getVal(int[] bit) {
        int val = 0;
        for (int i = 0; i < 31; i++) {
            val += ((1 << i) * bit[i]);
        }
        return val;
    }


    public int[] minBitwiseArray(List<Integer> nums) {
        // is you can;t go further from current bit make it zero
        // if it is even ans[i] = -1;

        int n = nums.size();
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            if ((nums.get(i) & 1) == 0) {
                ans[i] = -1;
                continue;
            }
            
            int[] bit = getBit(nums.get(i));
            // print(bit);
            for (int j = 0; j < 30; j++) {
                if (bit[j + 1] != 1) {
                    bit[j] = 0;
                    break;
                }
            }

            // print(bit);

            ans[i] = getVal(bit);
        }

        return ans;
    }
}