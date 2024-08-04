class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] q) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0;  i < n-1; i++){
            map.put(i, i+1);
        }
        int[] res = new int[q.length];

        for(int i = 0;  i < q.length; i++){
            int u = q[i][0], v = q[i][1];
            
            if(!map.containsKey(u) || map.get(u) >= v){
                res[i] = map.size();
                continue;
            }

            int j = map.get(u);
            int ith = u;

            while(j <= v){
                map.remove(ith);
                ith = j;
                if(!map.containsKey(ith)) break;
                j = map.get(ith);
            }

            map.put(u, v);
            res[i] = map.size();
        }
        return res;
    }
}