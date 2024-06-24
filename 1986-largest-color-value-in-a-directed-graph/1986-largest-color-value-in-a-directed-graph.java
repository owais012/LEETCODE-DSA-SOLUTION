
class Solution{
    List<List<Integer>> adj;
    public int largestPathValue(String colors, int[][] edges){
        List<List<Integer>> adj = new ArrayList<>();
        int[][]dp = new int[colors.length()][26];
        int[] inDegree = new int[colors.length()];

        for(int i =0; i < colors.length(); i++)
            adj.add(new ArrayList<>());

        for(int[]edge : edges){
            int u = edge[0];
            int v= edge[1];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i =0; i < inDegree.length; i++)
            if(inDegree[i] == 0){
                q.add(i);
                dp[i][colors.charAt(i)-'a'] = 1;
            }

        int ans = 0;
        int nodeCnt =0;
        while(!q.isEmpty()){
            int node = q.poll();
            ans = Math.max(ans, dp[node][colors.charAt(node)-'a']);
            nodeCnt++;
            for(int nb : adj.get(node)){
                for(int i = 0; i <26; i++){
                    dp[nb][i] = Math.max(dp[nb][i], dp[node][i] + (i == colors.charAt(nb)-'a' ? 1 : 0));
                }

                inDegree[nb]--;
                if(inDegree[nb] == 0)
                    q.add(nb);
            }
        }
        if(nodeCnt != colors.length()) return -1;
        return ans;
    }
}