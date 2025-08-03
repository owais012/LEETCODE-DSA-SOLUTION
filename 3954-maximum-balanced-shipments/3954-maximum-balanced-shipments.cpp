class Solution {
public:
    int maxBalancedShipments(vector<int>& weight) {
        int cnt = 0;
        for(int i = 1; i < weight.size(); i++){
            if(weight[i-1] > weight[i]){
                cnt++;
                i++;
            }
        }
        return cnt;
    }
};