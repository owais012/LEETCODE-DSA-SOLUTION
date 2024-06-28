class Solution {
    public long maximumImportance(int n, int[][] roads) {
        long ans = 0;
        int[] inDegree = new int[n];

        for(int i = 0; i < roads.length; i++){
            int u = roads[i][0];
            int v = roads[i][1];
            inDegree[v]++;
            inDegree[u]++;
        }

        Arrays.sort(inDegree);
        long num = 1;
        for(int i = 0; i < n; i++){
            ans += num*inDegree[i];
            num++;
        }
        return ans;
        
    }
}