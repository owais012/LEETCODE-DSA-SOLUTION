class KthLargest {
    PriorityQueue<Integer> pq; 
    private int kth;

    public KthLargest(int k, int[] nums) {
        kth = k;
        pq =  new PriorityQueue<>();
        for(int num : nums)
            add(num);
    }
    
    public int add(int val) {
        pq.add(val);
        if(pq.size() > kth) pq.poll();
        return pq.peek();
    }
}

// class KthLargest {


//    private PriorityQueue<Integer> pq;
//    private int size;


//    public KthLargest(int k, int[] nums) {
//        size = k;
//        pq = new PriorityQueue<>();
//        for (int num : nums) {
//            add(num);
//        }
//    }
  
//    public int add(int val) {
//        pq.offer(val);
//        if (pq.size() > size) {
//            pq.poll();
//        }
//        return pq.peek();
//    }
// }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */