class Solution {
    public int bfs(List<List<Integer>> adj, int src, int k){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        HashSet<Integer> visited = new HashSet<>();
        visited.add(src);

        int cnt = 1;
        while(!q.isEmpty() && k-- > 0){
            int sz = q.size();

            for(int i = 0; i < sz; i += 1){
                int var = q.poll();
                for(var nb: adj.get(var)){
                    if(!visited.contains(nb)){
                        q.add(nb);    
                        visited.add(nb);
                        cnt += 1;
                    }                
                }
            }
        }
        return  cnt;
    }

    public int[] maxTargetNodes(int[][] edges1, int[][] edges2, int k) {
        // the question look pretty simple , we just have to
        // connect to the node with maximum edges
        // traverse the tree and find out the number of
        // nodes which are at distance of k and store in
        // the dp[i]
        // step 1) you can find the number of edges connected
        // to each node and use that information to solve

        List<List<Integer>> adj1 = new ArrayList<>();
        List<List<Integer>> adj2 = new ArrayList<>();

        for (int i = 0; i < edges1.length+1; i += 1)
            adj1.add(new ArrayList<>());
        for (int i = 0; i < edges2.length+1; i += 1)
            adj2.add(new ArrayList<>());

        for (var edge : edges1) {
            adj1.get(edge[0]).add(edge[1]);
            adj1.get(edge[1]).add(edge[0]);

        }

        for (var edge : edges2) {
            adj2.get(edge[0]).add(edge[1]);
            adj2.get(edge[1]).add(edge[0]);
            
        }

        int[]dp1 = new int[edges1.length+1];
        int[]dp2 = new int[edges2.length+1];

        int maxi = 0;
        for(int i = 0; i < dp2.length; i += 1){
            dp2[i] = bfs(adj2, i, k-1);
            maxi = Math.max(maxi, dp2[i]);
        }

        int[]res = new int[dp1.length];
        if(k == 0){
            Arrays.fill(res , 1);
            return res;
        }
        for(int i = 0; i < dp1.length; i += 1){
            dp1[i] = bfs(adj1, i, k);
            System.out.println(dp1[i]);
            res[i] = dp1[i] + maxi;
                
        }

        return res;
    }
}