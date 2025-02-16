class Solution{

    public boolean checkLeft(String s, int ind){
        if(ind-1 < 0)
            return true;
        if(s.charAt(ind) == s.charAt(ind-1))
            return false;
        return true;
    }

    public boolean checkRight(String s, int ind){
        if(ind+1 >= s.length())
            return true;
        if(s.charAt(ind) == s.charAt(ind+1))
            return false;
        return true;
    }

    public boolean hasSpecialSubstring(String s, int k) {
        //explore all the substring and then check if the condition is satisfied
        int n = s.length();
  
        for(int i = 0; i < n; i+=1){
            Map<Character, Integer> map = new HashMap<>();
            for(int j = i; j < n; j += 1){
                map.put(s.charAt(j), map.getOrDefault(s.charAt(j), 0)+1);
                if(map.size() == 1 && map.get(s.charAt(j)) == k && checkLeft(s, i) && checkRight(s, j))
                     return true;
            }
        }

        return false;
    }
}