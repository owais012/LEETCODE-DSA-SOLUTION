class Solution {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set  = new HashSet<>();

        for(var v: banned){
            set.add(v);
        }

        long cnt = 0, sum = 0;

        for(int i = 1; i <= n; i+= 1){
            if(set.contains(i) == false && sum + i <= maxSum){
                cnt += 1;
                sum += i;
            }
        }   

        return (int) cnt;
    }
}