class Solution {
    public class Pair {
        int val, freq;

        public Pair(int val, int freq) {
            this.val = val;
            this.freq = freq;
        }
    }

    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length, l = 0, r = 0, ind = 0;
        int[] freq = new int[51];

        int[] ans = new int[n - k + 1];
        while (r < n) {

            freq[nums[r]] += 1;
            if (r - l + 1 > k) {
                freq[nums[l]] -= 1;
                l++;
            }

            if (r - l + 1 == k) {
                int sum = 0;
                PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (b.freq == a.freq ? b.val - a.val : b.freq - a.freq));
                for (int j = 0; j <= 50; j++) {
                    if (freq[j] > 0) {
                        pq.add(new Pair(j, freq[j]));
                    }
                }

                int cnt = x;
                while (cnt-- > 0 &&  !pq.isEmpty()) {
                    sum += (pq.peek().freq  * pq.poll().val);
                }
                ans[ind++] = sum;
            }

            r++;
        }

        return ans;
    }
}