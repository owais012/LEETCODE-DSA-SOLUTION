class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
        //according to the question, i am suppposed to return the lenght of longest consecutive element
        //idea is store store map<num, maxFreq>, 
        //we traverse to each nums if nums[i]+1 exist then, get count, if nums[i]-1 exist get count
        //add left+right+1 and update all three values 
        //we need to have proper count for the first and last element in the subsequeunce, no need for all
        //hence forth, all keep track of of 
        unordered_map<int, pair<int,int>> map;
        int ans = 0;
        for(auto cur : nums){
            if(map.count(cur))
                continue;
                
            auto left = map.find(cur-1);
            auto right = map.find(cur+1);

            //for left, we only consider if, cur-1 is the last element, in that subsequence
            //for righ, we only consider if , cur+1 is the first element, in that subsequence
            int leftMost = (left != map.end() && left->second.second == cur-1) ? left->second.first : cur;
            int rightMost = (right != map.end() && right->second.first == cur+1) ? right->second.second:cur;
            // cout << cur  << " " << leftMost<< " " << rightMost << endl;
            map[cur] = {leftMost, rightMost};
            map[leftMost].second = rightMost;
            map[rightMost].first = leftMost;

            ans = max(ans, rightMost-leftMost+1);
        } 

        return ans;
    }
};