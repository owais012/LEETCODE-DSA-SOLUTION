class Solution {                    //B  -> given and we are missing with array A  - ? ,to find this 
    public int[] missingRolls(int[] rolls, int mean, int n) {
        long b = 0;
        for (var r : rolls)
            b += r;

        int m = rolls.length;
            // mean = (a+b)/(m+n)
            //a + b = mean * (m + n)
            // 
        long a = (mean * (n + m)) - b;

        int[] A = new int[n];
        
        if ( a <= 0 ||  a / n == 0)
            return new int[] {};
        // n = 4
        // sum for the Array of all  Ai = a = 13
        // a/n = 3, 3*4 = 12 we are left with one extra 
        // a%n = 1;

        Arrays.fill(A, (int) a / n);

        int extra = (int) a % n;  // extra can be greater than 6 
        // there is possibility that after adding directly extra to any one element the observation can go out of bound 
        // so for that we are simply supposed to not add extra more than required

        for(int i = 0; i < n; i++){
            
            int diff =  (6 - A[i]);      // A[i] = 4     && extra > 4 so we can not add all the extra , we can only add 2 
                                        // diff = 2, and etxra = 1

            if(diff > extra){
                A[i] += extra;
                extra = 0;
            }else{
                A[i] += diff;
                extra -= diff;
            }

            if(extra == 0){
                break;
            }
        }

        if(extra > 0) return new int[]{};

        return A;
    }
}