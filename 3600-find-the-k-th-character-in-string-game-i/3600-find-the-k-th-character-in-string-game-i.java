class Solution {
    public char kthCharacter(int k) {
        StringBuilder sb = new StringBuilder("a");

        for(int i =1; i <= 500; i+= i){
            String cur = sb.toString();
            for(char ch: cur.toCharArray()){
                sb.append((char)(ch =='z' ? 'a': (ch+1)));
            }
        }

        return sb.charAt(k-1);
    }
}