class Solution {
    public boolean rotateString(String s, String goal) {
        if(s.length() != goal.length())
            return false;
        
        if(s.equals(goal))
            return true;

        int n = s.length();

        //Time complexity for this solution is -> (O(n^2))
        //Brute force

        for(int i = 0; i < n-1; i += 1){
            var cur = s.substring(i+1, n) +  s.substring(0, i+1);
            if(cur.equals(goal))
                return true;
        }

        // return false;
        //O(n) concatenate s with as s + s
        //when a string is rotated then it always stay in that format 
        // like for abcde -> (abcde)abcde a(bcdea)bcde ab(cdeab)cde abc(deabc)de
        // abcd(eabcd)e these are all possible ways of rotation 

        s = s+s;

        return s.contains(goal);

    }
}