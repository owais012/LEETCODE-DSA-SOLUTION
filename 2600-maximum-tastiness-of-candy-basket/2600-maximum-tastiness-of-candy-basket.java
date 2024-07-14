class Solution{
    public boolean isPossible(int dis, int [] price, int k){
        int cnt = 1;
        int prev = price[0];

        for(int i = 1; i < price.length; i++){
            if(price[i] - prev >= dis){
                cnt += 1;
                prev = price[i];
            }
            if(cnt == k)
                return true;
        }

        return cnt >= k;
    } 

    public int maximumTastiness(int[] price, int k) {
        Arrays.sort(price);
        int n = price.length;

        int st = 1, e = price[n-1] - price[0];

        while(st <= e){
            int diff = (st + e)/2;

            if(isPossible(diff, price, k)){
                st = diff + 1;
            }else{
                e = diff - 1;
            }
        }

        return st - 1;
    }
}