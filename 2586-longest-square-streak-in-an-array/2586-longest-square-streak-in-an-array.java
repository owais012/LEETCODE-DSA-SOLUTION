class Solution {
    public int longestSquareStreak(int[] nums) {
        //bring all the number in the base form 
        int res = 0, n = nums.length;
        HashSet<Integer> set = new HashSet<>(); 

        for(var v : nums){
            set.add(v);
        }

        for(int i = 0; i < n; i +=1){
            long cur = nums[i];
            int cnt = 0;
            // System.out.println(cur);
            while(set.contains((int)cur)){
                System.out.println("hello");
                cnt += 1;
                if(cur*cur >= (long)1e6)
                    break;
                cur *= cur;
            }    
            res = Math.max(res, cnt);
        }

        return res == 1 ? - 1: res;
    }
}