class Solution {
    public String addSpaces(String s, int[] spaces) {
        StringBuilder sb = new StringBuilder();
        int j = 0;
        if(spaces[j] == 0){
            sb.append(" ");
            j += 1;
        }
        for(int i = 0; i < s.length(); i += 1){
            sb.append(s.charAt(i));

            if(j < spaces.length && i == spaces[j]-1){
                sb.append(" ");
                j += 1;
            }
        }

        return sb.toString();
    }
}