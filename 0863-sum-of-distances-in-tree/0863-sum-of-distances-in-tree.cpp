#include<bits/stdc++.h>
using namespace std;
#define ll long long

class Solution {
public:
    void dfs(int node, vector<vector<int>>&adj, vector<int>&sum, vector<int>&subSum, int par){
        for(auto nb: adj[node]){
            if(nb != par){
                dfs(nb, adj, sum, subSum, node);
                subSum[node] += subSum[nb];
                sum[node] += sum[nb];
            }
        }
        sum[node] += (subSum[node]-1);
    }   

    void dfs2(int node, vector<vector<int>>&adj, vector<int>&ans, vector<int>&sum, vector<int>&subSum, int par){
        int parAns = 0;
        if(par != -1){
            parAns = ans[par]-(sum[node]+subSum[node]) + (subSum[0] - subSum[node]);
        }
        ans[node] = parAns+sum[node];
        for(auto nb: adj[node]){
            if(nb != par){
                dfs2(nb, adj, ans, sum, subSum, node);
            }
        }
    }   
    
    vector<int> sumOfDistancesInTree(int n, vector<vector<int>>& edges) {
        vector<vector<int>> adj(n);
        for(auto edge: edges){
            adj[edge[0]].push_back(edge[1]);
            adj[edge[1]].push_back(edge[0]);
        }  

        vector<int>sum(n,0);
        vector<int>ans(n,0);
        vector<int>subSum(n, 1);
        dfs(0, adj, sum, subSum, -1);
        dfs2(0, adj, ans, sum, subSum, -1);
        return ans;
    }
};