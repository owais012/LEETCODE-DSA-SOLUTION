class Solution {
    public int getNextPower(long k){
        long start = 1, end = 62;

        while(start <= end){
            long mid = start + (end-start)/2;

            if((1l << mid) >= k){
                end = mid -1;
            }else{
                start = mid + 1;
            }
        }
        return (int) end+1;
    }

    public int getPreviousPower(long k){
        long start = 1, end = 62;

        while(start <= end){
            long mid = start + (end-start)/2;

            if((1l << mid) < k){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return (int) start-1;
    }

    public char kthCharacter(long k, int[] op) {
        int n = op.length;
        
        int nextP = getNextPower(k);
    
        System.out.println(nextP);
        int cnt = 0;

        while(k > 1){
            cnt += op[nextP-1];
            k -= (1l << getPreviousPower(k));
            // System.out.println(k);
            nextP = getNextPower(k);
        }
        cnt %= 26;
        return (char) ('a'+ cnt);    

        //we have to return a + 'ideal shift' at that index - zeroCount 

        //2nd solution thought of is that , we traverse from the end , first we find the ind, k <= (1 << ind)    //then we keep decreasing  k by k -= most recent power of 2, and all doing all so , we keep count of 1, and return 'a' + count;



























        // // keep 
        // int
        // int cnt = 0;
        // long nextP = getNextSmallerPower(k);
        // int[]prefix = new int[];
        // System.out.println(nextP);

        // while(k > 1){
        //     //find next smaller power of 2
        //     k -= nextP;
        //     nextP >>= 1;  
        // }

        // return ' ';
    }
}