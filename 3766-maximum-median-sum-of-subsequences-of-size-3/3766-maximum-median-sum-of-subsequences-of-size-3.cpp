#define ll long long

class Solution {
public:
    long long maximumMedianSum(vector<int>& nums) {
        
        int n = nums.size(),  need = n/3;
        int cnt = 0;
        ll sum =0;
        sort(nums.begin(), nums.end());

        for(int i=n-2; i >= 0; i-= 2){
            sum += nums[i];
            cnt++;
            if(cnt == need)
                return sum;
        }

        return sum;
    }
};