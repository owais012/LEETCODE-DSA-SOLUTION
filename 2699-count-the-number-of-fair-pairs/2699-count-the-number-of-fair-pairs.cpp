#define ll long long
class Solution {
public:
    ll findPairs(ll target, vector<int>& nums){
        int left = 0, right = nums.size()-1;
        ll cnt = 0;
        while(left < right){
            while(left<right && (nums[left]+nums[right]) <= target)
                left++;

            cout<<right << " " << left <<" " << endl;
            cnt += (right-left);
            right--;
        }

        return cnt;
    }

    long long countFairPairs(vector<int>& nums, ll lower, ll upper) {
        ll cnt = 0;
        int n = nums.size();

        //APPROACH 1. BINARY SEARCH

        sort(nums.begin(), nums.end());
        for(int i = 0; i < n; i++){
            auto left = lower_bound(nums.begin()+i+1, nums.end(), lower-nums[i])-nums.begin();
            auto right = upper_bound(nums.begin()+i+1, nums.end(), upper-nums[i])-nums.begin();
            
            if(left==nums.size()) continue;
            cnt += (right- left); 
        }

        // return cnt;

        //APPROACH 2. TWO POINTER
        return findPairs(lower-1, nums) - findPairs(upper, nums);
    }
};