class Node{
    int node, cost;
    Node(int n , int c){
        node = n;
        cost = c;
    }
}

class Solution{
    List<List<Node>> adj;
    public void dijkstra(int src, int[] dis){

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> (a.cost - b.cost));
        dis[src] = 0;
        pq.add(new Node(src, 0));
   
        while(!pq.isEmpty()){
            Node curNode = pq.poll();

            for(Node nb : adj.get(curNode.node)){
                int adjNode = nb.node;

                if(dis[adjNode] > curNode.cost + nb.cost){
                   dis[adjNode] =  curNode.cost + nb.cost;
                   pq.add(new Node(adjNode, dis[adjNode]));
                }
            }
        }
    }

    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        adj = new ArrayList<>();

        for(int i = 0; i < 26; i++){
            adj.add(new ArrayList<>());
        }

        for(int i = 0; i < original.length; i++){
            int u = original[i]-'a';
            int v = changed[i]-'a';
            adj.get(u).add(new Node(v, cost[i]));
        }
        int[][] dis = new int[26][26];
        for(int[] row: dis)
            Arrays.fill(row, (int) 1e9);

        for(char ch : original){
            dijkstra( ch-'a', dis[ch-'a']);
        }

        long res = 0;
        for(int i = 0; i < 26; i++){
            for(int j = 0; j < 26; j++){
                System.out.print(dis[i][j] + " ");
            }
            System.out.println();
        }

        for(int i = 0; i < source.length(); i++){
            if(source.charAt(i) == target.charAt(i)) continue;
            if(dis[source.charAt(i)-'a'][target.charAt(i)-'a'] == (int) 1e9) return -1;
            res += dis[source.charAt(i)-'a'][target.charAt(i)-'a'];
        }
        return res;

    }
}