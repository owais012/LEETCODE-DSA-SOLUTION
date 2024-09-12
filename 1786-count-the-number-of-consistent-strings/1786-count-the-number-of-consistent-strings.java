class Solution {
    public int countConsistentStrings(String allowed, String[] words) {
        HashSet<Character> set = new HashSet<>();
       
        for(char ch: allowed.toCharArray()){
            set.add(ch);
        }

        int cnt = 0;
        
        outerLoop:
        for(String cur: words){
            for(char ch: cur.toCharArray()){
                if(set.contains(ch) == false){
                    continue outerLoop; 
                }
            }
            
            cnt += 1;
        }

        return cnt;
    }
}