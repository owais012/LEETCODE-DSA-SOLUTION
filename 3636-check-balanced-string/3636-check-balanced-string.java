class Solution {
    public boolean isBalanced(String num) {
        int odd = 0, even = 0;
        int n  = num.length();

        for(int i = 0; i < n; i += 1){
            if((i&1) == 0){
                even += num.charAt(i)-'0';
            }else{
                odd += num.charAt(i)-'0';
            }
        }
        System.out.println(even + " "+ odd);

        return odd == even;
    }
}