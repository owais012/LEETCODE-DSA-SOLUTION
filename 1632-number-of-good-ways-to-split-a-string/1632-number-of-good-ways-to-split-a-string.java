class Solution {
    public int numSplits(String s) {
        int[] prefix = new int[s.length()];
        int[] suffix = new int[s.length()];
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            set.add(s.charAt(i));
            prefix[i] = set.size();
        }
        set.clear();
        for(int i = s.length()-1; i >= 0; i--){
            set.add(s.charAt(i));
            suffix[i] = set.size();
        }

        int cnt = 0;
        for(int i = 0; i < s.length()-1; i++){
            if(prefix[i] == suffix[i+1])
                cnt += 1;
        }
        return cnt;
    }
}