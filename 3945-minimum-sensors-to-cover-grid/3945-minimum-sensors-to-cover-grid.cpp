#define d double
class Solution {
public:
    int minSensors(int n, int m, int k) {
        int cell = 2*k+1;

        return (int) ceil((d)n/cell) * ceil((d)m/cell); 
    }
};