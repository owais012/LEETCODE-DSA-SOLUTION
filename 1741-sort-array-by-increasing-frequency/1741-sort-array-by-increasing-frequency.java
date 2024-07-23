class Solution {
    record Pair(int n , int freq){};

    public int[] frequencySort(int[] nums) {
        Map<Integer, Integer>map = new HashMap<>();
        for(int i =0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
        }

        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> (a.freq == b.freq ? b.n - a.n : a.freq- b.freq));
        for(var e : map.entrySet()){
            pq.add(new Pair(e.getKey(), e.getValue()));
        }

        int[] res = new int[nums.length];
        int i = 0;
        while(i < nums.length){
            Pair cur = pq.poll();
            int len = cur.freq;
            while(len-- > 0){
                res[i++] = cur.n;
            }
        }
        return res;
    }
}