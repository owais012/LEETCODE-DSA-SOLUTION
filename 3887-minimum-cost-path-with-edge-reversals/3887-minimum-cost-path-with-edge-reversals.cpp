#define ll long long
#define pii pair<int, int>

class Solution {
public:
    int minCost(int n, vector<vector<int>>& edges) {
        //so aim is to maintain two distance value with and without reversal use
        //dp[i][0] = min(dp[i][0], norm wt+ dp[i][0]);
        //dp[i][1] = min(dp[i][1], reverse wt + dp[i][0] , normal wt + dp[i][1]);
        //form 2 adj list 

        vector<vector<pii>>adj(n);
        for(auto &e : edges){
            adj[e[0]].push_back({e[1],e[2]});
            adj[e[1]].push_back({e[0],2*e[2]});
        }

        vector<int>d(n, 1e9);
        d[0] = 0;
        
        priority_queue<pii, vector<pii>, greater<pii>> pq;
        pq.push({0,0});

        while(!pq.empty()){
            auto cur = pq.top();
            pq.pop();

            for(auto nb : adj[cur.second]){
                if(d[nb.first] > d[cur.second] + nb.second){
                    d[nb.first] = d[cur.second]+nb.second;
                    pq.push({d[nb.first], nb.first});
                }
            }
        }

        return d[n-1] == 1e9 ? -1 : d[n-1];
    } 
};