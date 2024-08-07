class Solution {
    public static boolean[] primeSieve(int n) {
        boolean isPrime[] = new boolean[n + 1]; // [0, n]
        Arrays.fill(isPrime, true);
        
        isPrime[0] = isPrime[1] = false;
        for(int i = 2; i*i <= n; ++i) {
            if(!isPrime[i])
                continue;
            for(int j = i*i; j <= n; j+=i)
                isPrime[j] = false;
        }
        return isPrime;
    }
    public int nonSpecialCount(int l, int r) {
        int st  = (int) Math.sqrt(l);
        int end = (int) Math.sqrt(r);

        boolean[] isPrime = primeSieve(end+1);
        int cnt = 0;
        System.out.print("start -> " + st);
        System.out.print("end -> " + end);

        for(int i = st; i <= end;  i++){
            if(isPrime[i] && i*i >= l && i*i <= r){
                cnt+= 1;
            } 
        }

        return (r - l + 1) - cnt;
    }
}