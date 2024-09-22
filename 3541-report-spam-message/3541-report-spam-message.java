class Solution {
    public boolean reportSpam(String[] message, String[] b) {
        HashSet<String> set = new HashSet<>();
        int cnt = 0;
        for(String v: b)set.add(v);
        for(var v: message){
            if(set.contains(v)){
                cnt++;
                // set.remove(v);
            }
        }

        return cnt >= 2;
    }
}