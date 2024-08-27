class Pair{
    int node;
    double weight;
    Pair(int n, double w){
        node = n;
        weight = w;
    }
}

class Solution{
    List<List<Pair>> adj;
    int n;

    public double[] dijkistra(int src){
        PriorityQueue<Pair> pq = new PriorityQueue<>(n , new Comparator<Pair> (){
            public int compare(Pair a, Pair b){
                if(a.weight > b.weight) return -1;
                else if(a.weight <  b.weight) return 1;
                return 0;
            }
        });

        double[] dist = new double[n];
        Arrays.fill(dist, 0.0);

        dist[src] = 1.0;
        pq.add(new Pair(src, dist[src]));

        while(!pq.isEmpty()){
            Pair node = pq.poll();

            for(Pair nb: adj.get(node.node)){
                int curNode = nb.node;
                double wt = nb.weight;
                double newProbability = node.weight * wt;
                if(newProbability > dist[curNode]){
                    dist[curNode] = node.weight*wt;
                    pq.add(new Pair(curNode, dist[curNode]));
                }
            }
        }

        return dist;
    }

    public double maxProbability(int n, int[][] edges, double[] succProb, int start_node, int end_node) {
        this.n = n;
        adj = new ArrayList<>();
        
        for(int i= 0; i < n; i++)
            adj.add(new ArrayList<>());

        for(int i =0; i < edges.length; i++){
            int u = edges[i][0];
            int v = edges[i][1];

            adj.get(u).add(new Pair(v, succProb[i]));
            adj.get(v).add(new Pair(u, succProb[i]));
        }
        double[] dist = dijkistra(start_node);

        for(int i =0; i < dist.length; i++){
            System.out.println(dist[i]);
        }
        
        return  dist[end_node];
    }
}