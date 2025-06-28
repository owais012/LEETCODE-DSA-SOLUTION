class Solution {
    public class Pair{
        int num, ind;
        Pair (int num, int ind){
            this.num = num;
            this.ind = ind;
        }
    }
    
    public int[] maxSubsequence(int[] nums, int k) {
        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b) -> Integer.compare(b.num, a.num));

        for(int i = 0; i < nums.length; i += 1){
            pq.add(new Pair(nums[i], i));
        }

        Pair[]res = new Pair[k];
        int ind = 0;
        int K = k;
        while(k-- > 0){
            res[ind++] = pq.poll();
        }
        Arrays.sort(res, (a, b) -> Integer.compare(a.ind, b.ind));

        int[]ans = new int[K];
        for(int i = 0; i < K; i += 1){
            ans[i] = res[i].num;
        }
        return ans;
    }
}