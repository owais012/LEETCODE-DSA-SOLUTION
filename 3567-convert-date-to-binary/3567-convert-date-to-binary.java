class Solution {
    public String getBit(int num){
        StringBuilder sb=  new StringBuilder();
        while(num > 0){
            sb.append(num%2);
            num /= 2;
        }
        return sb.reverse().toString();
    }
    public String convertDateToBinary(String d) {
        int year = Integer.valueOf(d.substring(0, 4));
        int m = Integer.valueOf(d.substring(5,7));
        int date = Integer.valueOf(d.substring(8, 10));

        return getBit(year) + "-"+getBit(m) + "-"+getBit(date);
    }
}