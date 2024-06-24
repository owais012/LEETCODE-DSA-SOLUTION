class Solution {
    public int maximumInvitations(int[] favorite) {
        int n = favorite.length;
        int[] inDegree = new int[n];
        for(int i = 0; i < n; i ++)
            inDegree[favorite[i]]++;
        
        boolean[] vis = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < inDegree.length; i++)
            if(inDegree[i] == 0){
                q.add(i);
                vis[i] = true;
            }
        int[] dp = new int [n]; // this is to store the longest length leading to node u -> v;

        while(!q.isEmpty()){
            int u = q.poll();
            int v = favorite[u];
            dp[v] = Math.max(dp[v], dp[u] + 1);
            inDegree[v]--;
            if(inDegree[v] == 0){
                q.add(v);
                vis[v] = true;
            }
        }
        for(int i =0; i < dp.length; i++)
            System.out.print(vis[i] + " ");

        int result = 0; // This will store the length of loop > 2
        int result2 = 0; // This will store the length of loop == 2 and length of path leading to either end;

        for(int i = 0; i < n; i++){
            if(vis[i] == false){
                int len = 0;
                for(int j = i; vis[j] == false; j = favorite[j]){
                    vis[j] = true;
                    len++;
                }
                if(len == 2){
                    result2 += 2 + dp[i] + dp[favorite[i]];
                }else{
                    result = Math.max(result, len);
                }
            }
        }

        return Math.max(result, result2);
    }
}