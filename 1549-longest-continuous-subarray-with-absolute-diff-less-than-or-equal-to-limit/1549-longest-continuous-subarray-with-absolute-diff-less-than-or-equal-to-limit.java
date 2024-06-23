class Pair{
    int num, ind;
    Pair(int n, int i){
        num = n;
        ind = i;
    }
}

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int left = 0, right = 0;
        int len = 0, intervalSum = 0;
        
        PriorityQueue<Pair> minHp = new PriorityQueue<>((a, b) -> ( a.num - b.num));
        PriorityQueue<Pair> maxHp = new PriorityQueue<>((a, b) -> (b.num - a.num));

        while(right < nums.length){
            minHp.add(new Pair(nums[right], right));
            maxHp.add(new Pair(nums[right], right));

            while(maxHp.peek().num - minHp.peek().num > limit){
                left = Math.min(maxHp.peek().ind, minHp.peek().ind)+1;
                while(minHp.peek().ind < left) minHp.poll();
                while(maxHp.peek().ind < left) maxHp.poll(); 
            }

            len = Math.max(len, right - left+1);
            right++;
        }

        return len;
    }
}