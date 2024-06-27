class Solution{
    List<List<Integer>> adj;

    public int dfs(int node, int par, List<Boolean> hasApple){
        int time = 0;
        for(int nb : adj.get(node)){
            if(nb == par) continue;
            int time_taken_by_child = dfs(nb, node, hasApple);

            if(time_taken_by_child > 0 || hasApple.get(nb)){
                time += time_taken_by_child + 2;
            }
        } 
        return time;
    }

    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        adj = new ArrayList<>();
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        return dfs(0, -1, hasApple);
    }
}