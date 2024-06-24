class Solution {
    public int longestCycle(int[] edges){
        int n = edges.length;
        boolean[] vis = new boolean[n];
        int[] inDegree = new int[n];

        for(int i =0; i < n; i++){
            if(edges[i] == -1)
                continue;
            inDegree[edges[i]]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i < inDegree.length; i++)
            if(inDegree[i] == 0){
                q.add(i);
                vis[i] = true;
            }

        while(!q.isEmpty()){
            int u = q.poll();
            int v = edges[u];
            if(v == -1) continue;
            inDegree[v]--;
            if(inDegree[v] == 0){
                q.add(v);
                vis[v] = true;
            }
        }

        int maxLen = 0;
        for(int i = 0; i < n; i++){
            int len = 0;
            if(vis[i] == false){
                for(int j = i; vis[j] == false; j = edges[j]){
                    vis[j] = true;
                    len++; 
                }

                maxLen = Math.max(len, maxLen);
            }
        }
        
        return maxLen == 0 ? -1 : maxLen;
    }

}