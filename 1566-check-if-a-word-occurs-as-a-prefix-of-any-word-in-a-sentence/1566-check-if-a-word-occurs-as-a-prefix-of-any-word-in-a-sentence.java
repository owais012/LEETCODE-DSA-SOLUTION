class Solution {
    public int isPrefixOfWord(String sentence, String sw) {
        String[] str = sentence.split(" ");
        int ind = 1;
        for(var s : str){
            int i = 0;            
            for(; i< s.length() && i < sw.length(); i += 1){
                if(s.charAt(i) != sw.charAt(i))
                    break;
            }
            if(i == sw.length())
                return ind;
            ind  += 1;
        }
        return -1;
    }
}