class Solution {
public:
    int findPairs(vector<int>& nums, int k) {
        //this can also be solved using running pointer and prefix array
        int n = nums.size();
        map<int, int>map;
        int cnt = 0;
        set<pair<int,int>>set;
        for(int i = 0; i < n; i++){
            if(map[k+nums[i]] > 0){
                int f,s;
                if(k+nums[i] < nums[i]){
                    f = k+nums[i];
                    s = nums[i];
                } else {
                    f = nums[i];
                    s = k+nums[i];
                }
                set.insert({f,s});
            }
            if(map[-k+nums[i]] > 0){
                int f,s;
                if(-k+nums[i] < nums[i]){
                    f = -k+nums[i];
                    s = nums[i];
                } else {
                    f = nums[i];
                    s = -k+nums[i];
                }
                set.insert({f,s});
            }
            map[nums[i]]++;
        }

        return set.size();
    }
};