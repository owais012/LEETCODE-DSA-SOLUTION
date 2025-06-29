class Solution {
    public List<String> partitionString(String s) {
        HashSet<String> set = new HashSet<>();
        int n = s.length();
        
        List<String>res = new ArrayList<>();
        String seg = "";

        for(int i = 0; i < n; i += 1){
            seg += (s.charAt(i));
            if(!set.contains(seg)){
                set.add(seg);
                res.add(seg);
                seg = "";
            }
        }

        return res;

    }
}