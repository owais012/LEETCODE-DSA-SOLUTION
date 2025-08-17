#define ll long long
class Solution {
public:
    long long perfectPairs(vector<int>& nums) {
        sort(nums.begin(), nums.end());
        ll cnt = 0;
        int i=0,j=0;
        vector<int>minus,plus;
        for(int i = 0; i <nums.size(); i++){
            if(nums[i]<0)
                minus.push_back(-nums[i]);
            else{
                plus.push_back(nums[i]);
            }
        }
        sort(minus.begin(), minus.end());

        while (j < minus.size()){
            //for current index find elements in range (n-n/2, n)
            while(i < j && minus[i] < (minus[j]-minus[j]/2))
                i++;
            cnt += (j-i);
            j++;
        }

        int left=0,right=0, pi = 0;
        j=0;
        // cout << cnt << endl;
        while(j <  plus.size()){
            //so here for each index, 
            //i need to find out the count of numbers in range(nums[i]/2, nums[i])           
            //this can be simply solved either two pointer or binary search
            while(pi < j && plus[pi] < (plus[j] - plus[j]/2))
                pi++;
            
            while(left < minus.size() && minus[left] < (plus[j]-plus[j]/2))
                left++;
            while(right < minus.size() && minus[right] <= 2*plus[j])
                right++;

            cnt += (j-pi);
            cnt += (right-left);
            j++;
        }

        return cnt;
    }
};