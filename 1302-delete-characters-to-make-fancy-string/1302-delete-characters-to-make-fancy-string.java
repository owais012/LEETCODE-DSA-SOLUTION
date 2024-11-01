class Solution {
    public String makeFancyString(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        if(n == 1 || n == 2)
            return s;
        sb.append(s.charAt(0));
        sb.append(s.charAt(1));

        for(int i = 2; i < n; i += 1){
            int sz = sb.length();
            if(s.charAt(i) != sb.charAt(sz-1) || s.charAt(i) != sb.charAt(sz-2 )){
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}