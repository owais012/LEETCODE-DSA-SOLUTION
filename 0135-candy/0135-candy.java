class Solution {
    public int candy(int[] rat) {
        //binary search question 
        if(rat.length == 1)
            return 1;

        int n = rat.length;

        int[]dp = new int[n];
        int cnt = 1;
        for(int i = 0; i < n-1; i+= 1){
            if(rat[i] < rat[i+1]){
                dp[i] = cnt++;
                if(i-1 >= 0 && rat[i-1] == rat[i]){
                    dp[i] = 1;
                    cnt = 2;
                }
            }else if(rat[i] == rat[i+1]){
                if(i-1  < 0){
                    dp[i] = 1;
                }else if(rat[i-1] == rat[i] && rat[i] ==  rat[i+1]){
                    dp[i] = 1;
                }else {
                    dp[i] = cnt++;
                }
                cnt = 2;
            }else{
                cnt = 1;
            }
        }

        if(rat[n-1] > rat[n-2]){
            dp[n-1] = 1 + dp[n-2];
        }

        if(rat[n-1] == rat[n-2]){
            dp[n-1] = 1;
        }

        cnt = 1;
        for(int i = n-1; i > 0; i -= 1){
            if(rat[i-1] > rat[i]){
                //if bottom most
                if(i+1 < n && (rat[i-1] > rat[i] && rat[i] < rat[i])){
                    dp[i] = 1;
                }else{
                    dp[i]=cnt++;
                }
            }else{
                cnt = 1;
            }
        }

        if(rat[0] > rat[1]){
            dp[0] = dp[1] + 1;
        }

        for(int i = 1; i < n-1; i += 1){
            if(rat[i] > rat[i+1] && dp[i] <= dp[i+1]){
                dp[i] = dp[i+1] + 1;
            }
            if(rat[i] > rat[i-1] && dp[i] <= dp[i-1]){
                dp[i] = dp[i-1]+1;
            }
            
        }
        
        int sum = 0;
        for(var v: dp){
            sum += v;
            System.out.print(v + " ");
        }
        System.out.println();
        return sum;
    }
}