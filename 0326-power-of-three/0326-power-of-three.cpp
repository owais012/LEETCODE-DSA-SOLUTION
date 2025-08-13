class Solution {
public:
    bool isPowerOfThree(int n) {
        //the main aim of this code, is to find out whether n is power of 3 or not 
        //so the main idea to solve this problem is to find out
        //if B is power of A, logA(B) gives the power, and 
        int e = log(INT_MAX)/log(3);
        int N = pow(3, e);
        return n> 0 &&  N%n == 0;
    }
};