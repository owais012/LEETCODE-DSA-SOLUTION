#define ll long long
class Solution {
public:
    long long countFairPairs(vector<int>& nums, int lower, int upper) {
        ll cnt = 0;
        int n = nums.size();
        sort(nums.begin(), nums.end());
        for(int i = 0; i < n; i++){
            auto left = lower_bound(nums.begin()+i+1, nums.end(), lower-nums[i])-nums.begin();
            auto right = upper_bound(nums.begin()+i+1, nums.end(), upper-nums[i])-nums.begin();
            
            if(left==nums.size()) continue;
            cout << right << " " << left << endl;
            cnt += (right- left); 
        }

        return cnt;
    }
};