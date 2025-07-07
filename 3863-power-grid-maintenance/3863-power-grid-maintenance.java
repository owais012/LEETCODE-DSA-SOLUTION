class Solution{
    public static class UnionFind {
        int[] par;
        int[] size;
        int numComponents;
        
        UnionFind(int n) {
            par = new int[n+1];
            size = new int[n+1];
            numComponents = n;
            for(int i = 1; i <= n; ++i) {
                par[i] = i;
                size[i] = 1;
            }
        }
    
        int root(int i) { // find the root of the tree in which node i is present
            if(par[i] == i)
                return i;
            return par[i] = root(par[i]); // path compression
        }
    
        boolean find(int i, int j) {
            return root(i) == root(j);
        }
    
        boolean union(int n1, int n2) { // true if they were actually unioned, otherwise false
            int u = root(n1);
            int v = root(n2);
    
            if(u == v)
                return false;
            
            if(size[u] < size[v]) {
                int temp = u;
                u = v;
                v = temp;
            } // size[u] should be larger than size[v]
    
            par[v] = u; // u is the root of resultant tree
            size[u] += size[v];
            numComponents -= 1;
            return true;
        }
    } // By default, 1-based indexing (1 to n)
    

    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        UnionFind dsu = new UnionFind(c);
        Map<Integer, Integer> map = new HashMap<>();
        Map<Integer, TreeSet<Integer>> setMap = new HashMap<>();

        for(var edge: connections){
            dsu.union(edge[0], edge[1]);
        }

        for(int i = 1; i <= c; i += 1){
            //get parent
            map.put(i, dsu.root(i));
            setMap.putIfAbsent(dsu.root(i), new TreeSet<>());
            setMap.get(dsu.root(i)).add(i);
        }  
        // System.out.println(dsu.numComponents);
        // System.out.println(setMap.size());

        
        //all of the List<TreeSets>
        //for each ci, map<ci, index of the TreeSet>
        //if 1 , x, and x is in set deleted, return set.floor
        //if 2, x ,locate to the set and remove from that
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> deleted = new HashSet<>();

        for(var q : queries){
            int x = map.get(q[1]);
            // System.out.println(x);
            if(q[0] == 1){
                if(!deleted.contains(q[1])){
                    res.add(q[1]);
                    continue;
                }

                if(setMap.get(x).isEmpty()){
                    res.add(-1);
                }else{
                    res.add(setMap.get(x).first());
                }
            }else{
                // System.out.println(setMap.get(x));
                if(
                    setMap.get(x).contains(q[1])){
                    setMap.get(x).remove(q[1]);
                }
                deleted.add(q[1]);
            }
        }
        return res.stream().mapToInt(Integer::intValue).toArray();
    }
}