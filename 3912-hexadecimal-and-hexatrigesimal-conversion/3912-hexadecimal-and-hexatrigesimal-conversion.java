class Solution {
    public String concatHex36(int n) {
        long hex = n*n;   
        long hex3 = hex*n;

        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();

        while(hex > 0){
            long cur = hex%16;
            if(cur < 10){
                sb.append(cur);
            }else{
                sb.append((char) ('A'+(cur%10)));
            }
            hex /= 16;
        }

        while(hex3 > 0){
            long cur = hex3%36;
            System.out.println(cur);
            if(cur < 10){
                sb2.append(cur);
            }else{
                cur -= 10;
                sb2.append((char) ('A'+(cur%26)));
            }
            hex3 /= 36;
        }

        return sb.reverse().toString()+sb2.reverse().toString();
    }
}