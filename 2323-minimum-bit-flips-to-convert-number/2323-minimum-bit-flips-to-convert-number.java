class Solution {
    public int minBitFlips(int start, int goal) {
        int xor = start^goal;
        int cnt = 0;

        while(xor > 0){
            cnt += (xor%2);
            xor /= 2;
        }

        return cnt;
    }
}