class Solution {
    public long minDamage(int power, int[] d, int[] h) {
        int n = d.length;
        long[][]a = new long[n][2];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            h[i] = ((h[i] + power - 1) / power);
            a[i][0] = d[i];
            a[i][1] = h[i];
            sum += d[i];
        }

        Arrays.sort(a, (a1, a2) -> Long.compare(a2[0]*a1[1] , a1[0]*a2[1]));
        long res= 0;
        for(var v: a){
            res += v[1]*sum;
            sum -= v[0];
        }   

        return res;
    }
}