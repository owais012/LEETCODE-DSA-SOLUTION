class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        
        List<List<Integer>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(var edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        for(int i = 0; i < adj.size(); i++){
            adj.get(i).add(i);
            Collections.sort(adj.get(i));
            map.put(adj.get(i), map.getOrDefault(adj.get(i), 0)+1);
        }

        int cnt = 0;
        for(var e : map.entrySet()){
            if(e.getKey().size() == e.getValue())
                cnt += 1;
        }
        return cnt;
    }
}