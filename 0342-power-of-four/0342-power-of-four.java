class Solution {
    public boolean isPowerOfFour(int n) {
        if(n < 1)
            return false;

        if(n == 0x80000000)
            return false;
        //integers with odd number of 0 bit is not power of four

        StringBuilder bit = new StringBuilder();
        while(n > 0){
            bit.append(n%2);
            n /= 2;
        }

        int zero = 0, one = 0;
        System.out.println(bit);
        for(var v : bit.toString().toCharArray()){
            if(v == '1')
                one += 1;
            if(v == '0')
                zero += 1;
        }

        if((zero&1) == 1)
            return false;
        if(one > 1)
            return false;
        return true;
    }
}