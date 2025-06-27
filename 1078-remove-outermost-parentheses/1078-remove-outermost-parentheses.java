class Solution {
    public String removeOuterParentheses(String s) {
        Stack<Character> st = new Stack<>();
        StringBuilder  sb = new StringBuilder();
        
        int n = s.length();        
        for(int i = 0; i < n; i += 1){
            if(s.charAt(i) == '('){
                if(!st.isEmpty()){
                    sb.append('(');
                }
                st.add('(');
            }else{
                st.pop();
                if(!st.isEmpty()){
                    sb.append(')');
                }
            }      
        }

        return sb.toString();
    }
}