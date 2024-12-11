class Solution {
    public int minOperations(int[] nums, int k) {
        int mini = Integer.MAX_VALUE;
        HashSet<Integer> set = new HashSet<>();

        for(var v: nums){
            mini = Math.min(mini, v);
            set.add(v);
        }
    
        if(mini < k)
            return -1;

        if(mini == k)
            return set.size()-1;
        return set.size();
    }
}