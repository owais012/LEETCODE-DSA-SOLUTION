class Solution {
    public long minimumSteps(String s) {
        //if we know, how many zeros are before the one towards the right side
        // then add them we could get the answer
        int n = s.length();

        long[]suffix = new long[n];
        long cnt = s.charAt(n-1) == '0' ?1 : 0;
        for(int i = n-2; i >= 0; i--){
            if(s.charAt(i) == '0'){
                cnt+=1;
            }else{
                suffix[i] = cnt;
            }
        }

        long res = 0;
        for(var v: suffix) res+=v;
        return res;
    }
}