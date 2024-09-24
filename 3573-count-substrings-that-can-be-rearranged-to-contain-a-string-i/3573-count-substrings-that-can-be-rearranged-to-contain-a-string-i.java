class Solution {
    public boolean isValid(Map<Character, Integer> map1, Map<Character, Integer> map2){
    
        for(var v: map1.entrySet()){
            if(!map2.containsKey(v.getKey()) || map2.get(v.getKey()) < v.getValue()) return false;
        }
        return true;
    }

    public long validSubstringCount(String word1, String word2) {
        Map<Character, Integer> map1 = new HashMap<>();
        Map<Character, Integer> map2 = new HashMap<>();

        for (char ch : word2.toCharArray()) {
            map1.put(ch, map1.getOrDefault(ch, 0) + 1);
        }

        int l = 0, r = 0, n = word1.length();
        long res = 0;

        while(r < word1.length()){
            char ch = word1.charAt(r);
            map2.put(ch, map2.getOrDefault(ch, 0) + 1);

            while(l <= r && isValid(map1, map2)){
                System.out.println(r);
                res += (n - r);
                map2.put(word1.charAt(l), map2.getOrDefault(word1.charAt(l), 0)-1);
                if(map2.get(word1.charAt(l)) == 0) map2.remove(word1.charAt(l));
                l++;
            }

            r++;
        }
        return res;
    }
}