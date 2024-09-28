class Solution {
    public long maximumTotalSum(int[] a) {
        Arrays.sort(a);
        int n = a.length;
        long res = 0;

        HashSet<Integer> set = new HashSet<>();
        set.add(a[n-1]);

        for(int i = n-2; i >= 0; i--){
            if(a[i] == a[i+1])a[i]--;
            if(a[i] > a[i+1]) a[i] = a[i+1]-1;
            if(a[i] <= 0) return -1;
        }

        for(var v: a) res += v;
        return res;
    }
}