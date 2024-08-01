class Solution {
    public int countSeniors(String[] s) {
        int cnt = 0;
        
        for(int i =0; i < s.length; i++){
            if(Integer.valueOf(s[i].substring(11, 13)) > 60 )
                cnt += 1;
        }

        return cnt;
    }
}