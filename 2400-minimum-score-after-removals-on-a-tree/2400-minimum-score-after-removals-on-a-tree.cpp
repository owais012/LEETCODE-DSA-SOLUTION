class Solution {
public:
    void dfs(int node, vector<vector<int>>&adj, vector<int>& nums, vector<int>&subXor, vector<int>&par, vector<bool>&visited, int p, unordered_map<int, unordered_set<int>>&map){
        par[node]=p;
        visited[node]=true;
        
        for(auto nb : adj[node]){
            if(!visited[nb]){
                dfs(nb, adj, nums, subXor, par, visited, node, map);
                if(map.count(nb)){
                    map[node].insert(map[nb].begin(), map[nb].end());
                }
                map[node].insert(nb);
                subXor[node] ^= subXor[nb];
            }
        }
    }

    int solve(vector<int>& subXor, vector<vector<int>>& edges, int x, int y, vector<int>&par, unordered_map<int, unordered_set<int>>&map){
        int n = edges.size();
        int child1=0,child2=0;

        if(par[edges[x][0]]==edges[x][1]){
            child1 = edges[x][0];
        }else if(par[edges[x][1]] == edges[x][0]){
            child1 = edges[x][1];
        }

        if(par[edges[y][0]]==edges[y][1]){
            child2 = edges[y][0];
        }else if(par[edges[y][1]] == edges[y][0]){
            child2 = edges[y][1];
        }

        vector<int>res(3);

        res[0] = subXor[child1];
        res[1] = subXor[child2];
        res[2] = subXor[0]^res[0]^res[1];

        if(map[child2].count(child1)){
            res[1] ^= res[0];
            res[2] ^= res[0];
        }       
        if(map[child1].count(child2)){
            res[0] ^= res[1];
            res[2] ^= res[1];
        }
        
        sort(res.begin(), res.end());
        
        return res[2]-res[0];
    }

    int minimumScore(vector<int>& nums, vector<vector<int>>& edges) {
        //this question can be solved using brute force , at max there can be 999 edges
        int n= nums.size();

        //1. every time we skip a pair of edge
        //2. then we aim at calculating the xor of all there component in O(1)
        //3. we can make use of sub sum tree, we store the xor of substree in its parent,
        //4. we need to know the parent in the edge, then we subXor[par], for bothe edge 
        //5. for the last one, we just do subXor[0]-subXar[edgePar1]-subXor[edgePar2]

        vector<vector<int>>adj(n);
        for(int i = 0; i < n-1; i++){
            adj[edges[i][0]].push_back(edges[i][1]);
            adj[edges[i][1]].push_back(edges[i][0]);
        }
        
        vector<int>par(n);
        vector<int>subXor(n);
        vector<bool>visited(n,0);

        for(int i = 0; i < n; i++){
            subXor[i]=nums[i];
        }

        unordered_map<int, unordered_set<int>>map;
        dfs(0, adj, nums, subXor, par,visited, -1, map);

        int res = INT_MAX;
        for(int i=0;i<n-1;i++){
            for(int j = i+1; j < n-1; j++){
                res= min(res, solve(subXor, edges, i,j, par,map));
            }
        }
        return res;
    }
};