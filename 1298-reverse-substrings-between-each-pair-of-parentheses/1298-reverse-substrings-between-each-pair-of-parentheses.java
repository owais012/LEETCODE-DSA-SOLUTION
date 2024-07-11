class Solution{
    public String reverseParentheses(String s){
        Stack<Integer> st = new Stack<>();

        StringBuilder res = new StringBuilder();

        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(res.length());
            }else if(s.charAt(i) == ')'){
                reverse(res, st.pop(), res.length()-1);
            }else{
                res.append(s.charAt(i));
            }
        }

        return res.toString();
    }

    public void reverse(StringBuilder sb, int start, int end){
        while(start < end){
            char temp  = sb.charAt(start);
            sb.setCharAt(start++, sb.charAt(end));
            sb.setCharAt(end--, temp);
        }
    }
}