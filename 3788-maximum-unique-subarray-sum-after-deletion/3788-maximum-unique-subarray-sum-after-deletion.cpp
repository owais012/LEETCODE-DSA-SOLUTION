class Solution {
public:
    int maxSum(vector<int>& nums) {
        unordered_set<int>set;
        int cnt =0, mini = INT_MAX;
        for(auto val : nums){
            if(val < 0){
                cnt++;
            }else{
                set.insert(val);
            }
            mini = max(mini, val);
        }
        if(cnt == nums.size())
            return mini;
        //it is always better to consider the while array
        //delete all negatives,
        //delete all duplicates
        int sum = 0;
        for(auto val : set)
            sum += val;
        
        return sum;
    }
};