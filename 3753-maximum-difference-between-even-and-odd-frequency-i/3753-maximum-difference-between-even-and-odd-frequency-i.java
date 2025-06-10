class Solution {
    public int maxDifference(String s) {
        int[]hash = new int[26];
        for(var ch : s.toCharArray())
            hash[ch-'a']+=1;
        
        List<Integer> odd = new ArrayList<>();
        List<Integer> even = new ArrayList<>();

        for(var v : hash)
            if(v > 0)
                if((v&1) > 0)
                    odd.add(v);
                else
                    even.add(v);

        Collections.sort(odd);
        Collections.sort(even);
        
        return Math.max(odd.get(0)-even.get(even.size()-1), 
                        odd.get(odd.size()-1)-even.get(0));
    }
}