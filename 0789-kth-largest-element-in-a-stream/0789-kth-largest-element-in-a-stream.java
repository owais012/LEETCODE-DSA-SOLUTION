class KthLargest {
    PriorityQueue<Integer> pq;
    int K;
    public KthLargest(int k, int[] nums) {
        pq = new PriorityQueue<>();
        K = k;
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }    

        while(pq.size() > k){
            pq.poll();
        }
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > K){
            pq.poll();
        }
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */