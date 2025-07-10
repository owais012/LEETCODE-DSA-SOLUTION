class Solution { 
    public int maxFreeTime(int eventTime, int k, int[] start, int[] end) {
        //first we find at present all the gaps with size and start and end of the gap,
        //then for , each gap we find the longest it can be extend ,
        int n = start.length;
        int sum = 0, res = 0;
        sum += (start[0]);
        for(int i = 0; i < k; i += 1){
            if(i == n-1){
                sum += (eventTime - end[i]);
            }else{
                sum += (start[i+1]-end[i]);
            }
        }

        res = Math.max(res, sum);
        // System.out.println(res);
        for(int i = k; i < n; i += 1){
            sum -= (start[i-k]- (i-k-1 < 0 ? 0 : end[i-k-1]));
            
            if(i == n-1 ){
                sum += (eventTime - end[i]);
            }else{
                sum += (start[i+1]-end[i]);
            }
            // System.out.println(sum);
            res = Math.max(sum, res);
        }
        return res;
    }
}