class Solution {
    public boolean inRange(int a, int b){
        return a >= 0 && a <= b;
    }

    public int getCnt(int diff, int k, int[] nums){
        int i = 0, j = nums.length-1;
        int cnt = 0;
        i = 0; j = nums.length-1;
        while(i < j){
            int d  = Math.abs(nums[j] - nums[i]);
            if(d != diff){
                if(inRange(nums[j]+diff, k) || inRange(nums[j]-diff, k))
                    cnt += 1;
                else if(inRange(nums[i]+diff, k) || inRange(nums[i]-diff, k))
                    cnt += 1;
                else 
                    cnt += 2; 
            }
            i++; j--;
        }
        
        return cnt;
    }
    
    record Pair(int d, int f){};
    public int minChanges(int[] nums, int k) {
        Map<Integer, Integer> map = new LinkedHashMap<>();
        int i = 0, j = nums.length-1;

        while(i < j){
            int d  = Math.abs(nums[j] - nums[i]);
            map.put(d, map.getOrDefault(d, 0)+1);
            i++; j--;
        }
        PriorityQueue<Pair> pq  = new PriorityQueue<>((a,b) -> (b.f - a.f)); 
        
        for(var e: map.entrySet()){
            pq.add(new Pair(e.getKey(), e.getValue()));
        }
        int cnt = Integer.MAX_VALUE;
        int c = 10;
        while(c-- > 0 && !pq.isEmpty()){
            cnt = Math.min(cnt, getCnt(pq.poll().d, k, nums));
        }
        // System.out.println(getCnt(2,k,nums));
        return cnt;
    }
}