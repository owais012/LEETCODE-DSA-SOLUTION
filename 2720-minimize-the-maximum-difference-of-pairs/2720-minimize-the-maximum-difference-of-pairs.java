class Solution {
    public boolean binary_search(int[] nums, int p, int t){
        int cnt = 0, n = nums.length;
        for(int i =0; i < n-1; i += 1){
            if(nums[i+1]-nums[i] <= t){
                cnt += 1;
                i += 1;
            }
        }
        return cnt >= p;
    }

    public int minimizeMax(int[] nums, int p) {
        //fist think of your approach of using maps
        Arrays.sort(nums);
        int st = 0, e = nums[nums.length-1] - nums[0];
        int ans = -1;

        while(st <= e){
            int mid = e + (st - e)/ 2;
            if(binary_search(nums, p, mid)){
                ans = mid;
                e = mid-1;
            }else{
                st = mid + 1;
            }
        }

        return ans;        
    }
}