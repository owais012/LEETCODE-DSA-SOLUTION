class Solution {
    public int smallestNumber(int n) {
        StringBuilder bit = new StringBuilder("");

        while(n > 0){
            bit.append((n >> 1) & 1);
            n >>= 1;
        }

        int num = 0;
        for(int i = 0; i < bit.length(); i +=1 ){
            num += (1 << i);
        }
        return num;
    }
}