class Solution{
    public static class Node{
        int node, wt;
        Node(int n,int w){
            node = n;
            wt= w;
        }
    }

    public int dijkistra(int src, int des, List<List<Node>> adj, int n ){
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> (a.wt - b.wt));
        int[]d = new int[n];
        
        Arrays.fill(d, (int) 1e9);
        d[src] = 0;
        pq.add(new Node(src, 0));

        while(!pq.isEmpty()){
            var cur = pq.poll();

            for(var nb : adj.get(cur.node)){
                if(d[nb.node] > d[cur.node]+ nb.wt){
                    
                    d[nb.node] = d[cur.node] + nb.wt;
                    pq.add(new Node(nb.node, d[nb.node]));
                }
            }
        } 

        return d[n-1];
    }

    public int[] shortestDistanceAfterQueries(int n, int[][] q) {
        int[] res = new int [q.length];
        List<List<Node>> adj = new ArrayList<>();

        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i = 0; i < n - 1; i++){
            adj.get(i).add(new Node(i+1, 1));
        }
        for(int i = 0; i < q.length; i++){
            int u = q[i][0];
            int v = q[i][1];
 
            adj.get(u).add(new Node(v, 1));
            res[i] = dijkistra(0, n-1,  adj, n);    
        }

        return res;
    }
}