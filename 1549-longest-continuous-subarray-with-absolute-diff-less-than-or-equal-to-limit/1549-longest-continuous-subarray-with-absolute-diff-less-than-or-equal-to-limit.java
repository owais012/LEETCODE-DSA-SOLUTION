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
        TreeMap<Integer, Integer> map = new TreeMap<>();

        while(right < nums.length){
            map.put(nums[right], map.getOrDefault(nums[right], 0) +1);

            while(map.lastKey() - map.firstKey() > limit){
                map.put(nums[left], map.getOrDefault(nums[left], 0) -1);
                if(map.get(nums[left]) == 0)
                    map.remove(nums[left]);
                left++;
            }

            len = Math.max(len, right - left+1);
            right++;
        }

        return len;
    }

    // 3 Approaches
    // 1) Priority Queue
    // 2) Deque
    // 3) TreeMap
}