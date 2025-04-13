class Solution {
    public String smallestPalindrome(String s) {
        int[]hash = new int[26];

        for(var v : s.toCharArray()){
            hash[v-'a'] += 1;
        }

        char middle = '#';
        String a = "";
        for(int i = 0; i < 26; i+= 1){
            if((hash[i] & 1) > 0 ){
                middle = (char) (i+'a');
            }

            for(int j = 0; j < hash[i]/2; j += 1){
                a += String.valueOf((char)(i+'a'));
            }
        }
        System.out.println(a);
        StringBuilder right = new StringBuilder(a);

        if(middle == '#'){            
            return a + right.reverse().toString();
        }

        return a + middle + right.reverse().toString();
    }
}