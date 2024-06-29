class Solution {
    public int largestSumAfterKNegations(int[] nums, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int num : nums)
            pq.add(num);
        
        while(k > 0){
            int ele = pq.poll();
            if(ele < 0 || (k & 1) == 1){
                k -= 1;
                pq.add(-ele);
            }else{
                k -= 2;
                pq.add(ele);
            }
            
        }

        int sum = 0;
        while(!pq.isEmpty())
            sum += pq.poll();
        return sum;
    }
}