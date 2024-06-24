class Solution {
    public List<Boolean> checkIfPrerequisite(int numCourses, int[][] prerequisites, int[][] queries) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[numCourses];

        for(int i =0; i < numCourses; i++)
            adj.add(new ArrayList<>());

        boolean[][] req = new boolean[numCourses][numCourses];
        for(int[] preReq: prerequisites){
            int u = preReq[0];
            int v = preReq[1];
            adj.get(u).add(v);
            inDegree[v]++;
            req[u][v] = true;
        }
        Queue<Integer> q = new LinkedList<>();
        
        for(int i = 0; i < inDegree.length;i++){
            if(inDegree[i] == 0)
                q.add(i);
        }

        while(!q.isEmpty()){
            int node = q.poll();

            for(int nb : adj.get(node)){
                for(int i = 0; i < numCourses; i++){
                    if(req[i][node]){
                        req[i][nb] = true;                    }
                }

                inDegree[nb]--;
                if(inDegree[nb] == 0)
                    q.add(nb);
            }
        }
        List<Boolean> res = new ArrayList<>();

        for(int[] query: queries){
            res.add(req[query[0]][query[1]]);
        }

        return res;
    }
}