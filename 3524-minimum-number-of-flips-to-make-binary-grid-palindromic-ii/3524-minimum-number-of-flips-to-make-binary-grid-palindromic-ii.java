class Solution {
    public int minFlips(int[][] a) {
        int ans = 0;
        int n = a.length, m = a[0].length;
        
        for(int i=0; i < n/2; i++){
            for(int j = 0; j < m/2; j++){
                int x = a[i][j];
                x += a[i][m-j-1];
                x += a[n-1-i][j];
                x += a[n-1-i][m-1-j];

                ans += Math.min(x, 4-x);
            }
        }
        int cnt = 0, c = 0;
        if((n&1) == 1){
            int i = 0 , j = m-1;
            while(i < j){
                if(a[n/2][i] != a[n/2][j]){
                    cnt += 1;
                    ans += 1;
                }
                if(a[n/2][i] == a[n/2][j] && a[n/2][i] == 1){
                    c+=1;
                }
                i++; j--;

            }
        }

        if((m&1) == 1){
            int i = 0 , j = n-1;
            while(i < j){
                if(a[i][m/2] != a[j][m/2]){
                    cnt += 1;
                    ans += 1;
                }
                if(a[i][m/2] == a[j][m/2] && a[i][m/2] == 1){
                    c+=1;
                }
                i++; j--;
            }
        }

        if((c&1)==1 && cnt ==  0) ans += 2;
        // if((c&1) == 0 && c > 0 && cnt > 0) ans += 1;  
        if(n%2 == 1 && m % 2 == 1 &&  (a[n/2][m/2]) == 1){
            ans += 1;
        }

        return ans;
    }
}