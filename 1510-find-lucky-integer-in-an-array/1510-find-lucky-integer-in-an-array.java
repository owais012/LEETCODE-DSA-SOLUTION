class Solution {
    public int findLucky(int[] arr) {
        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());

        for(var v : arr)
            map.put(v, map.getOrDefault(v, 0)+1);

        for(var v: map.entrySet()){
            if(v.getKey() == v.getValue())
                return v.getKey();
        }
        return -1;
    }
}