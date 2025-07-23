#define sz(x) ((int)(x.size()))
class Solution {
public:
    int solve(string& s, int x, string t) {
        int n = s.size();
        stack<char> st;
        int score=0;
        for(int i = 0; i < n; i++){
            if (!st.empty() && st.top() == t[0] && s[i] == t[1]){
                st.pop();
                score += x;
            }else{
                st.push(s[i]);
            }
        }
        string a;
        while(!st.empty()){
            a.push_back(st.top());
            st.pop();
        }
        reverse(a.begin(), a.end());
        s=a;
        return score;
    }

    int maximumGain(string s, int x, int y) {
        // idea is to split all substring with only ab
        // for each substring we apply solve twice , other time in reverse
        int score = 0;
        if (x > y) {
            score += solve(s, x, "ab");
            score += solve(s, y, "ba");
        } else {
            score += solve(s, y, "ba");
            score += solve(s, x, "ab");
        }
        return score;
    }
};