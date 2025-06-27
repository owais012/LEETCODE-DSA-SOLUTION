class Solution {
    public boolean isIsomorphic(String s, String t) {
        Map<Character, Character> map = new HashMap<>();
        Map<Character, Character> map1 = new HashMap<>();

        for(int i = 0; i < s.length(); i+= 1){
            if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i))
                return false;
            
            if(s.charAt(i) == t.charAt(i)){
                if(map1.containsKey(t.charAt(i)) &&  map1.get(t.charAt(i)) != s.charAt(i))
                    return false;
                map.put(s.charAt(i), t.charAt(i));
                map1.put(t.charAt(i), s.charAt(i));
                continue;
            }

            // if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) == t.charAt(i))
            //     continue;;
            // d - b                                //b
            if(map1.containsKey(t.charAt(i)) &&  map1.get(t.charAt(i)) != s.charAt(i))
                return false;
            
            map.put(s.charAt(i), t.charAt(i));
            map1.put(t.charAt(i), s.charAt(i));
        }
        return true;
    }
}