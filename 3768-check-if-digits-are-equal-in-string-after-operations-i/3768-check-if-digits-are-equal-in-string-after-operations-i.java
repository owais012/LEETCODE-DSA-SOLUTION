class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length() > 2){
            String ns = "";
            for(int i = 1; i < s.length(); i += 1){
                ns += (char) (((s.charAt(i-1) - '0' + s.charAt(i) - '0')%10) + '0');
            }
            s = ns;
        }

        return s.charAt(0) == s.charAt(1);
    }
}