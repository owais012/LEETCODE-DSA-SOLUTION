class Solution {
    public String resultingString(String s) {
        Stack<Character> st = new Stack<>();

        for(char ch : s.toCharArray()){
            if(!st.isEmpty() && (Math.abs(st.peek()-ch) == 1 || Math.abs(st.peek()-ch) == 25)){
                st.pop();
            }else{
                st.push(ch);
            }
        }

        StringBuilder res = new StringBuilder(); 

        while(!st.isEmpty()){
            res.append(st.pop());
        }

        return res.reverse().toString();
    }
}