class Solution {
    public int [] getLPS(String s){
        StringBuilder sb = new StringBuilder(s);
        s = sb.reverse().toString();
        sb.reverse();
        sb.append("#" + s);
        int [] lps = new int[sb.length()];
        int j = 0;
        System.out.println(sb);
        for(int i = 1; i < sb.length(); i++){
            while(j > 0 && sb.charAt(j) != sb.charAt(i))
                j = lps[j-1];
            
            if(sb.charAt(j) == sb.charAt(i))
                j++;

            lps[i] = j;
        }
        return lps;
    }

    public String shortestPalindrome(String s) {
        int [] lps = getLPS(s);
        int start = lps[lps.length-1];
        if(start == s.length())
            return s;

        String reqStr = s.substring(start, s.length());

        StringBuilder sb = new StringBuilder(reqStr);
        sb.reverse();
        return sb + s;

    }
}