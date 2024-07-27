class Solution {
    public boolean isPossibleDivide(int[] nums, int k){

        if(nums.length % k != 0) return false;

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i =0; i < nums.length; i++){
            pq.add(nums[i]);
        }


        while(!pq.isEmpty()){
            int start = pq.poll();
            int j = 0;
            start+=1;

            while(j++ < k-1){
                if(pq.contains(start)){
                    pq.remove(start++);
                }else{
                    return false;
                }
            }
        }

        return true;
    }
}