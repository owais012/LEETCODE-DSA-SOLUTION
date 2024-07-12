class Solution{
    record Pair(StringBuilder str, int score){};

    public Pair getScore(StringBuilder s, String c, int points){
        char first = c.charAt(0), second = c.charAt(1);
        Stack<Character> st = new Stack<>();

        int score = 0;
        for(int i = 0; i < s.length(); i++){
            if(!st.isEmpty() && s.charAt(i) ==  second && st.peek() == first){
                st.pop();
                score += points;
            }else{
                st.push(s.charAt(i));
            }
        }

        StringBuilder res = new StringBuilder();
        while(!st.isEmpty()){
            res.insert(0, st.pop());
        }
        return new Pair(res, score);
    }

    public int maximumGain(String s, int x, int y){
        int totalScore = 0;
        StringBuilder sb = new StringBuilder(s);

        if(x > y){
            Pair pair  = getScore(sb, "ab" , x);
            totalScore += pair.score;
            pair = getScore(pair.str, "ba", y);
            totalScore += pair.score;
        }else{
            Pair pair = getScore(sb, "ba", y);
            totalScore += pair.score;

            pair = getScore(pair.str, "ab" ,x);
            totalScore += pair.score;
        }

        return totalScore;  
    }
}