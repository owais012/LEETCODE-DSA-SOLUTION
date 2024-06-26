class Node{
    int node , cost;
    Node(int n, int c){
        node = n;
        cost = c;
    }
}

class Solution{
    List<List<Node>> adj = new ArrayList<>();
    int n;

    public int BFS(){
        int[] dis = new int[n];
        Arrays.fill(dis, -1);
        dis[0] = 0;
        Deque<Integer> dq = new ArrayDeque<>();
        dq.add(0);
        int res= 0;
        while(!dq.isEmpty()){
            int node = dq.poll();

            for(Node nb : adj.get(node)){
                int adjNode = nb.node;
                int cost = nb.cost;
                if(dis[adjNode] != -1) continue;
                dis[adjNode] = cost + dis[node];
                res += cost;
                if(cost == 0)
                    dq.addFirst(adjNode);
                else
                    dq.addLast(adjNode);
            }
        }

        return res;
    }

    public int minReorder(int n, int[][] connections){
        this.n = n;
        for(int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for(int[] connect: connections){
            int u = connect[0];
            int v = connect[1];
            adj.get(u).add(new Node(v, 1));
            adj.get(v).add(new Node(u, 0));
        }   
        return BFS();
    }
}