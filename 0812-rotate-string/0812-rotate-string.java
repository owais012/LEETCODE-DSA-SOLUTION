class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())
            return false;
        
        if(s.equals(goal))
            return true;

        int n = s.length();

        for(int i = 0; i < n-1; i += 1){
            var cur = s.substring(i+1, n) +  s.substring(0, i+1);
            if(cur.equals(goal))
                return true;
        }

        return false;
    }
}