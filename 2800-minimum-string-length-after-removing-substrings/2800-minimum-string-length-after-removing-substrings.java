class Solution {
    public int minLength(String s) {
        //we will be using stack to solve this

        Stack<Character> st = new Stack<>();

        for(char  ch : s.toCharArray()){
            if(!st.isEmpty() && ((st.peek()=='C' && ch == 'D') || (st.peek() == 'A' && ch == 'B')))
                st.pop();
            else 
                st.push(ch);
        }
        // if top char + current char == "AB" || "CD" pop()

        return st.size();
    }
}