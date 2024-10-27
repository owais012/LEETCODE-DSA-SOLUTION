class Solution {
    int mod = (int) 1e9 + 7;

    public int lengthAfterTransformations(String s, int t) {
        // the most important thing is that, how does it works
        // so, here the basic idea, is that, get the count of all characters
        // no, until char is <= 'y', count of character will be just transerferd from
        // it's previous to next
        // if it's z, then there will freq(z) -> new 'a', so cnt['a'] += freq[z]
        // and same for b, cnt['b'] += freq['a'], and don't forget to mod, everytime

        int[] cnt = new int[26];

        for (char c : s.toCharArray()) {
            cnt[c - 'a'] += 1;
        }

        for (int j = 1; j <= t; j += 1) {
            int[]temp = new int[26];
            for(int i = 0; i < 26; i+=1){
                if(i == 25){
                    temp[0] = (temp[0] + cnt[i])%mod;
                    temp[1] = (temp[1] + cnt[i])%mod;
                }else{
                    temp[i+1] = (cnt[i] + temp[i+1])%mod;
                }
            }

            cnt = temp;
        }

        int res = 0;
        for(var v: cnt)
            res = (res + v)%mod;

        return res;
    }
}