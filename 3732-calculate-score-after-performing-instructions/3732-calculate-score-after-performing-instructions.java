class Solution {
    public long calculateScore(String[] inst, int[] values) {
        long res = 0;
        int n = values.length;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n && i >= 0;){
            set.add(i);
            var v = inst[i];
            if(v.equals("add")){
                res += values[i];
                i += 1;
                if(set.contains(i)){
                    return res;
                }
            }else{
                i += values[i];
                if(set.contains(i)){
                    return res;
                }
            }
        }

        return res;
    }
}