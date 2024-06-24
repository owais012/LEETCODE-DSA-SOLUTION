class Node{
    String node;
    double val;
    Node(String node, double val){
        this.node = node;
        this.val = val;
    }
}

class Solution {
    Map<String, List<Node>> adj;
    Double val;
    public void dfs(String src, String des, double curVal, HashSet<String> vis){
        if(src.equals(des)){
            val = curVal;
            return;
        }

        vis.add(src);
        for(Node nb : adj.get(src)){
            if(!vis.contains(nb.node)){
                dfs(nb.node, des, curVal*nb.val, vis);
            }
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int n = queries.size();

        adj = new HashMap<>();
        for(int i =0; i< equations.size(); i++){
            String u = equations.get(i).get(0);
            String v = equations.get(i).get(1);
            Double val = values[i];
            adj.putIfAbsent(u, new ArrayList<>());
            adj.get(u).add(new Node(v, val));
            adj.putIfAbsent(v, new ArrayList<>());
            adj.get(v).add(new Node(u, 1/val));
        }

        double[] res = new double[n];
        for(int i =0; i < n; i++){
            String u = queries.get(i).get(0);
            String v = queries.get(i).get(1);

            if(!adj.containsKey(u) || !adj.containsKey(v)){
                res[i] = -1;
                continue;
            }
            val = -1.0;
            HashSet<String> vis = new HashSet<>();
            dfs(u, v, 1, vis);
            res[i] = val;
        }

        return res;
    }
}