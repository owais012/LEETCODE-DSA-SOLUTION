class Solution {
    public String helper(int i,int n, String s){
        if(i == n){
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for(int ind = 0; ind < s.length()-1; ind+= 1){
            cnt+=1;
            if(s.charAt(ind) != s.charAt(ind+1)){
                sb.append(cnt);
                sb.append(s.charAt(ind));
                cnt = 0;
            }
        }
        if(cnt == 0){
            sb.append(1);
            sb.append(s.charAt(s.length()-1));
        }else{
            sb.append(cnt+1);
            sb.append(s.charAt(s.length()-1));
        }

        return  helper(i+1, n, sb.toString());
    }

    public String countAndSay(int n) {
        return helper(1, n, "1");
    }
}