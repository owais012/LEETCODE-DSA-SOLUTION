class Solution {
public:
    int maximumUniqueSubarray(vector<int>& nums) {
        int n = nums.size();
        int l =0, r= 0;
        unordered_map<int, int>map;
        int res = 0, sum = 0;
        while(r < n){
            map[nums[r]] += 1;
            sum += nums[r];

            while(l < r &&  map[nums[r]] > 1){
                sum -= nums[l];
                map[nums[l]]--;
                l++;
            }
            res=max(res, sum);
            r++;
        }
        return res;
    }
};