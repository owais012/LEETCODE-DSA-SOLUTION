class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {

        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");

        Map<String, Integer> map = new HashMap<>();

        for (var s : str1)
            map.put(s, map.getOrDefault(s, 0) + 1);

        for (var s : str2)
            map.put(s, map.getOrDefault(s, 0) + 1);

        List<String> temp = new ArrayList<>();
        
        for(var v: map.entrySet()) if(v.getValue() == 1) temp.add(v.getKey());

        String[] res = new String[temp.size()];
        int i = 0; 
        for(var v: temp) res[i++] = v;
        return res; 
    }
}