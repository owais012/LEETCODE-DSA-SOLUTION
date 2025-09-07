class Solution {
public:
    int minOperations(string s) {
        vector<int>hash(26);

        for(auto c : s)
            hash[c-'a']++;
        int ind = 1;
        while(ind < 26 && hash[ind] == 0){
            ind ++ ;
        }

        return 26- ind;
    }
};