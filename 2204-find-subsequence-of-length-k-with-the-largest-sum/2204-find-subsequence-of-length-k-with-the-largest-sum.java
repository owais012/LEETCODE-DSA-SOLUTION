class Solution {
    public class Pair{
        int num, ind;
        Pair (int num, int ind){
            this.num = num;
            this.ind = ind;
        }
    }
    
    public int[] maxSubsequence(int[] nums, int k) {
        //Method 1 - Priority Queue 
        //Time Complexity O(logN)
/*
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

*/
        //Method II
        //Time Complexity O(n^2)
        int n = nums.length;
        boolean[] selected = new boolean[n]; 
        int dp = 0;

        for(int i = 1; i <= k; i +=1 ){
            int max = Integer.MIN_VALUE;
            int ind = -1;
            for(int j = 0; j < n; j+= 1){
                if(max < nums[j] && !selected[j]){
                    if(ind > -1){
                        selected[ind] = false;
                    }
                    selected[j] = true;
                    max = nums[j];
                    ind = j;
                }
            }
        }

        int[]ans = new int[k];
        for(int i = 0, j = 0; i < n; i+= 1){
            if(selected[i]){
                ans[j++] = nums[i];
            }
        }
        
        return ans;
    }
}