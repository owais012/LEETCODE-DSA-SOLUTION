#define ll long long
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        int n = nums.size();
        vector<int>prefix(n);
        
        prefix[0] = nums[0];
        for(int i = 1; i < n; i++){
            prefix[i] = prefix[i-1]+nums[i];
        }
        ll sum = 0, maxSum =INT_MIN;
        int l=0, r=0;
        while(r < n){
            sum += nums[r];
            maxSum = max(maxSum, sum);
            if(sum < 0){
                sum = 0;
            }
            r++;
        }

        unordered_map<int, ll>map;
        for(int i = 0; i < n; i++){

        }

        return maxSum;
    }
};