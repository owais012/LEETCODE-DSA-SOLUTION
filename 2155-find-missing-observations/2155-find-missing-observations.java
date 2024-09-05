class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        long b = 0;
        for (var r : rolls)
            b += r;

        int m = rolls.length;
        long a = (mean * (n + m)) - b;

        int[] A = new int[n];
        if (a <= 0 || a / n == 0 || (a / n > 6 || (a / n == 6 && a % n > 0)))
            return new int[] {};

        // System.out.println("a -> " + a + " b -> " + b);
        Arrays.fill(A, (int) a / n);

        int extra = (int) a % n;
        for(int i = 0; i < n; i++){
            
            int diff =  (6 - A[i]);
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


        return A;
    }
}