class Solution {
    public long numberOf(String s){
        long val = 0;
        for(int i = 0; i < s.length(); i += 1){
            val += (1l << i)*(s.charAt(i)-'0');
        }
        return val;
    }

    public int longestSubsequence(String s, long k) {
        //greedy question
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int last = -1;
        for(int i = n-1; i >=0; i -= 1){
            long val = numberOf(sb.toString());
            // System.out.println(val +"/ "+i);
            if(val > k){
                last = i;
                break;
            }
            sb.append(s.charAt(i));
        }

        if(last == -1)
            return s.length();

        int cnt = n - last-2;
        for(int i = 0; i <= last; i += 1){
            if(s.charAt(i) == '0')
                cnt += 1;
        }

        return cnt;
    }
}