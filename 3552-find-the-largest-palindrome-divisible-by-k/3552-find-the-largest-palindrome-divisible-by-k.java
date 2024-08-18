class Solution {
    public boolean isDivisible7(String num){
        int n = num.length();
        if (n == 0 && num.charAt(0) == '0')
            return true;
 
        // Append required 0s at the beginning.
        if (n % 3 == 1)
            num = "00" + num;
        if (n % 3 == 2)
            num = "0" + num;
        n = num.length();
 
        // add digits in group of three in gSum
        int gSum = 0, p = 1;
        for (int i = n - 1; i >= 0; i--) {
 
            // group saves 3-digit group
            int group = 0;
            group += num.charAt(i--) - '0';
            group += (num.charAt(i--) - '0') * 10;
            group += (num.charAt(i) - '0') * 100;
            gSum = gSum + group * p;
            // generate alternate series of plus and minus
            p = p * -1;
        }
 
        // calculate result till 3 digit sum
        return (gSum % 7 == 0);
    }

    public String largestPalindrome(int n, int k) {
        if(n == 1){
            if(k == 1) return "9";
            if(k == 2) return "8";
            if(k == 3) return "9";
            if(k == 4) return "8";
            if(k == 5) return "5";
            if(k == 6) return "6";
            if(k == 7) return "7";
            if(k == 8) return "8";
            if(k == 9) return "9";
        }else if (n == 2){
            if(k == 1) return "99";
            if(k == 2) return "88";
            if(k == 3) return "99";
            if(k == 4) return "88";
            if(k == 5) return "55";
            if(k == 6) return "66";
            if(k == 7) return "77";
            if(k == 8) return "88";
            if(k == 9) return "99";
        }else if (n == 3){
            if(k == 1) return "999";
            if(k == 2) return "898";
            if(k == 3) return "999";
            if(k == 4) return "888";
            if(k == 5) return "595";
            if(k == 6) return "888";
            if(k == 7) return "959";
            if(k == 8) return "888";
            if(k == 9) return "999";
        }else{
            StringBuilder res = new StringBuilder();
            for(int i = 0; i < n; i++)
                res.append("9");
            if(k == 1 || k == 3 || k == 9){
                return res.toString();

            }
            else if( k == 2){
                res.setCharAt(0, '8');
                res.setCharAt(n-1, '8');
                return res.toString();

            }else if (k == 5){
                res.setCharAt(0, '5');
                res.setCharAt(n-1, '5');
                return res.toString();

            }else if(k == 4){
                res.setCharAt(0, '8');
                res.setCharAt(1, '8');
                res.setCharAt(n-1, '8');
                res.setCharAt(n-2, '8');
                return res.toString();

            }else if( k == 8){
                res.setCharAt(0, '8');
                res.setCharAt(1, '8');
                res.setCharAt(n-1, '8');
                res.setCharAt(n-2, '8');        
                res.setCharAt(2, '8');
                res.setCharAt(n-3, '8');
                
                return res.toString();

            }
            else if(k == 6){
                res.setCharAt(0, '8');
                res.setCharAt(n-1, '8');
                if((n&1) == 1){
                    res.setCharAt(n/2, '8');
                }else{
                    res.setCharAt((n/2), '7');
                    res.setCharAt((n/2)-1, '7');
                }
                return res.toString();

            }else if (k == 7){
                for(char c = '9'; c >= '1'; c--){
                    if((n&1) == 1){
                        res.setCharAt(n/2, c);
                    }else{
                        res.setCharAt((n/2),  c);
                        res.setCharAt((n/2)-1, c);
                    }
                    System.out.println(res);
                    if(isDivisible7(res.toString())){
                        return res.toString();
                    }
                }
                return "";
            }
            
        }
        return "";
    }  
}