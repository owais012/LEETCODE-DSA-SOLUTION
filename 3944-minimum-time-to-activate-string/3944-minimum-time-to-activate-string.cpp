class Solution {
public:
    long long  getSubArrayCount(long long  n ){
        return (n*(n+1))/2;
    }

    bool canActivate(int time, string s, vector<int>& order, int k){
        for(int i = 0; i <= time; i++)
            s[order[i]] = '*';
        long long  subArr=0;
        int i = 0;
        while(i < s.size()){
            int cnt = 0;
            while(i < s.size() && s[i] !='*'){
                cnt++;
                subArr+=cnt;
                i++;
            }
            i++;   
        }
        
        return (getSubArrayCount(order.size()) - subArr) >= k;
    }

    int minTime(string s, vector<int>& order, int k) {
        //so the idea,is that i need to compute the  number of valid substring strings in <= logn time
        //if we now the length of all substrings with no *, we can compute their count 
        int n = order.size();
        if(getSubArrayCount(n) < k)
            return -1;

        int start = 0, end = n-1;
        int ans = end;
        while(start <= end){
            int mid = start + (end-start)/2;
            if(canActivate(mid, s, order, k)){
                end = mid-1;
                ans = mid;
            }else{
                start = mid+1;
            }
        }
        return ans;
    }
};