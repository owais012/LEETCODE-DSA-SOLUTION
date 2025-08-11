class Solution {
public:
    bool reorderedPowerOf2(int n) {
        //its possible to form all permutation of n, since n <= 9, and n! = 3,62,880
        string s = to_string(n);
        if((n&(n-1)) == 0)
            return true;
        sort(s.begin(), s.end());
        int num = stoi(s);
        if(s[0] !='0' && (num&(num-1))==0)    
            return true;
        while(next_permutation(s.begin(), s.end())){
            if(s[0] != '0'){
                num = stoi(s);
                cout << num << endl;
                if((num&(num-1)) == 0)    
                    return true;
            }

        }
        return false;
    }
};