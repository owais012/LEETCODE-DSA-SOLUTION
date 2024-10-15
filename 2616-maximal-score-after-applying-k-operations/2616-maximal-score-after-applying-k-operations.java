class Solution {
    public long maxKelements(int[] nums, int k) {
        long score = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(var v: nums)
            pq.add(v);
        
        while(k-- > 0){
            int cur = pq.poll();
            score += cur;
            pq.add((cur+2)/3);
        }

        return score;
    }
}