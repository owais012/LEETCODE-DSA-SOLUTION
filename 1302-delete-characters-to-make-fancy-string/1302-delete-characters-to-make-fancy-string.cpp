class Solution {
public:
    string makeFancyString(string s) {
        string res;

        for(int i =0; i< s.size(); i++){
            if(i-1 >=0 && i-2 >= 0 && res[res.size()-2]==s[i] && res[res.size()-1]==s[i]){
                continue;
            }
            res.push_back(s[i]);
        }

        return res;
    }
};