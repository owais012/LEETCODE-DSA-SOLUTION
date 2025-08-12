class Solution {
public:
    const int MOD = 1e9+7;
    int numberOfWays(int n, int x) {
        //question looks like dp question, sort of countinng problem
        vector<int>a;
        for(int i = 1; i <= n && (int) pow(i,x) <= n; i++)
            a.push_back((int) pow(i,x));
        int m = a.size();
        vector<vector<int>>dp(m+1, vector<int>(n+1));
        
        // for(auto &v : a)
        //     cout << v << " ";
        // cout << endl;
        for(int i = 0 ; i <= m; i++){
            dp[i][0] = 1;
        }

        for(int i = 1; i <= n; i++){
            dp[0][i] = 0;
        }

        for(int i=1; i <= m; i++){
            for(int j = 1; j <= n; j++){
                //take
                int op1 = 0;
                if(j >= a[i-1]){
                    op1 = dp[i-1][j-a[i-1]];
                }
                //not take 
                int op2 = dp[i-1][j];

                dp[i][j] = (op1 + op2)%MOD;
            }
        }
        // for(auto row: dp){
        //     for(auto c : row)
        //         cout << c << " ";
        //     cout << endl;
        // }
        return dp[m][n];
    }
};