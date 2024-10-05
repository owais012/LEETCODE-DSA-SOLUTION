class Solution {
    public int isValid(int[]h1, int[]h2){
        int len = 0;
        for(int i =0; i < 26; i++){
            if(h2[i] > h1[i] && h1[i] == 0)
                return -1;

            if(h2[i] > h1[i])
                return 0;
            len += h2[i];
        }

        return len;
    }

    public boolean checkInclusion(String s1, String s2) {
        //thoughts 
        // we can make use of sliding window,
        
        // while traversing if the window has extra element, start window from next element
        //while traversing if any char occurs which is not part of s1 , then start from next char 

        //so in order to check this , we can make use of hash table, TC -> O(26*n) < 1e8

        int[]h1 = new int[26];
        int[]h2 = new int[26];

        for(char ch: s1.toCharArray()){
            h1[ch-'a']+= 1;
        }

        int l = 0, r = 0, n = s2.length();
        while(r < n){
            h2[s2.charAt(r)-'a']++;

            //trying to check that it do not contain, any extra ele, be it same 
            int len = isValid(h1, h2);
            System.out.println(len);

            if(len == -1){
                Arrays.fill(h2, 0);
                l = r+1;
            }else if(len == s1.length()){
                return true;

            }else if(len == 0){
                while(l < r && isValid(h1, h2) == 0){
                    h2[s2.charAt(l)-'a']--;
                    l++;
                }
            }

            r++;
        }

        return false;
    }
}