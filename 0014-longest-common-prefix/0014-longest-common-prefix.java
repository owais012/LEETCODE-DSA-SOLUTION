class Solution {
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        StringBuilder sb = new StringBuilder();

        //find the shortest string length
        int n = Integer.MAX_VALUE;

        for(var s : strs)
            n = Math.min(n, s.length());
        
        outerLoop:
        for(int i = 0; i < n; i += 1){
            char c = strs[0].charAt(i);
            for(int j = 1;j < strs.length; j += 1){
                if(strs[j].charAt(i) != c){
                    break outerLoop;
                }
            }
            sb.append(c);
        }    

        return sb.toString();
    }
}