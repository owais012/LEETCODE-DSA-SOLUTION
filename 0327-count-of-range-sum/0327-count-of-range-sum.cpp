#define ll long long 

class Solution {
public:
    ll lowerCnt = 0, upperCnt = 0, u, l;

    void merge(int start, int mid, int end, vector<ll>&prefix){
        int i = start, j = mid, k = 0;
        vector<ll>temp(end-start+1);

        while(i < mid && j <=end){        
            if(prefix[i] <= prefix[j]){
                temp[k] = prefix[i];
                i++; k++;
            }else{
                temp[k] = prefix[j];
                j++; k++;
            }
        }
        while(i < mid){
            temp[k] = prefix[i];
            i++; k++;
        }

        while(j <= end){
            temp[k] = prefix[j];
            j++; k++;
        }

        for(j=start, i = 0; i < temp.size(); i++, j++){
            prefix[j] = temp[i];
        }
    }

    void divideAndMerge(int start, int end, vector<ll>&prefix){
        
        if(start < end){
            int mid = start+(end-start)/2;
            divideAndMerge(start, mid, prefix);
            divideAndMerge(mid+1, end, prefix);
            int j = mid+1;

            for(int i = start; i <= mid; i++){
                while(j<=end && (prefix[j] - prefix[i]) <= u)
                    j++;
                upperCnt += (end-j+1);
            }
            j=mid+1;
            for(int i = start; i <= mid; i++){
                while(j<=end && (prefix[j] - prefix[i]) < l)
                    j++;
                lowerCnt += (end-j+1);
            }
            merge(start, mid+1, end, prefix);
        }
    }

    int countRangeSum(vector<int>& nums, int lower, int upper) {
        //since we are asked the count of subarray
        int n = nums.size();
        u = upper, l = lower;
        vector<ll>prefix(n+1, 0);        
        
        //comparision factor
        //you got to find out number of pairs in the left side,
        
        //cnt1 {sum > upper}
        //cnt2 {sum >= lower}
        //res = cnt2-cnt1;


        for(int i =1; i <= n; i++){
            prefix[i] = prefix[i-1]+ ((ll) nums[i-1]);
        }

        divideAndMerge(0,n,prefix);

        return lowerCnt - upperCnt;
    }       
};