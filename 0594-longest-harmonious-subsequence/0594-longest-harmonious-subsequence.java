class Solution {
    public int findLHS(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(nums);

        int res = 0;
        for(int i = 0; i < nums.length; i += 1){
            map.put(nums[i] , map.getOrDefault(nums[i], 0) + 1);  

        }

        for(var v: map.entrySet()){
            res = Math.max(res, Math.max(v.getValue() + map.getOrDefault(v.getKey()-1, Integer.MIN_VALUE),
                                         v.getValue() + map.getOrDefault(v.getKey()+1,  Integer.MIN_VALUE)));
        }
        return res;
    }
}