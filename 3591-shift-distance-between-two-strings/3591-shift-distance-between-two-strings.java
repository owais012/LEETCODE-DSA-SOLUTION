class Solution {
    public long shiftDistance(String s, String t, int[] nextCost, int[] previousCost) {
        int n = s.length();
        long[] prefix = new long[26];
        long[] suffix = new long[26];
        
        prefix[0] = nextCost[0];
        for(int i = 1; i <= 25; i += 1){
            prefix[i] = prefix[i-1] + (long)nextCost[i];
        }

        suffix[25] = previousCost[25];
        for(int i = 24; i >= 0; i -= 1){
            suffix[i] = suffix[i+1] + (long) previousCost[i];
        }

        long[]dp = new long[n];
        int ind = t.charAt(0)-'a';

        // for(var v: prefix){
        //     System.out.print(v + " ");
        // }
        // System.out.println();

        // for(var v: suffix){
        //     System.out.print(v + " ");
        // }
        // System.out.println();
        
        Arrays.fill(dp, Long.MAX_VALUE);

        for(int i = 0; i < n; i += 1){
            int target = t.charAt(i) - 'a';
            int src = s.charAt(i) - 'a';
            
            if(s.charAt(i) == t.charAt(i)){
                dp[i] = 0;

            }else if(target > src){
                dp[i] = Math.min(dp[i], prefix[target-1 < 0 ? 25: target-1] - (src-1 >= 0 ? prefix[src-1] : 0));
                
                dp[i] = Math.min(dp[i], (suffix[0] - (src+1 <26 ? suffix[src+1] : 0)) + (target +1 < 26 ? suffix[target+1] : 0));

            }else{
                dp[i] = Math.min(dp[i], suffix[target + 1] -  (src+1 <26 ? suffix[src+1] : 0));
                dp[i] = Math.min(dp[i], (prefix[25] - (src-1 >= 0 ? prefix[src-1] : 0))+  
                                            ( target-1 < 0 ? 0 : prefix[target-1] ));
            }  
        }      

        long ans = 0;
        for(var v: dp){
            ans += v;
        } 
        return ans;
    }
}