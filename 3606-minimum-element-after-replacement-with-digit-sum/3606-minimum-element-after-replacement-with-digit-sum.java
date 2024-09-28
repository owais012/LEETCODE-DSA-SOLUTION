class Solution {
    public int minElement(int[] nums) {
        int res = Integer.MAX_VALUE;
        for(var v: nums){
            int sum = 0;
            String num = String.valueOf(v);
            for(char c : num.toCharArray()){
                sum += (c-'0');
            }
            res = Math.min(sum, res);
        }

        return res;
    }
}