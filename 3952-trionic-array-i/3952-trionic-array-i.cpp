class Solution {
public:
    bool isTrionic(vector<int>& nums) {
        int n=nums.size(),  i = 0; 
        if(n == 3)
            return false;
        while(i+1 < n && nums[i] < nums[i+1])
            i++;

        if(i==n-1 || i ==0)
            return false;

        while(i+1 < n && nums[i] > nums[i+1])
            i++;
        if(i==n-1)
            return false;
        while(i+1 < n && nums[i] < nums[i+1])
            i++;

        return i == n-1;
    }
};