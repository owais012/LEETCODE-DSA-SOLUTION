class Solution{
    HashSet<String> set;
    int[] dp;
    public int helper(int ind, String s){
        if(ind >= s.length())
            return 0;

        int minExtra = s.length();
        if(dp[ind] != -1) return dp[ind];

        for(int i = ind; i < s.length(); i++){
            int extra = 0;
            if(!set.contains(s.substring(ind, i+1))){
                extra  = i - ind + 1;
            }
            int rem_extra = helper(i+1, s);
            minExtra = Math.min(rem_extra + extra, minExtra);
        }

        return dp[ind] = minExtra;
    }

    public int minExtraChar(String s, String[] dictionary) {
        set = new HashSet<>();
        dp = new int[s.length()+1];
        Arrays.fill(dp, -1);
        
        for(String word: dictionary)
            set.add(word);
        return helper(0, s);
    }
}