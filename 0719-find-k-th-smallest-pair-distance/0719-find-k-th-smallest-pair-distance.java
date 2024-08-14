class Solution{
    public int getCnt(int d, int[]a){
        int cnt = 0;

        int l = 0, r= 1;
        while(r < a.length){
            while(l < r && a[r] - a[l] > d)l++;
            cnt += (r-l);
            r++;
        }
        System.out.println(cnt);
        return cnt;
    }

    public int smallestDistancePair(int[] nums, int k) {
        Arrays.sort(nums);
        
        int st = 0 , e = nums[nums.length-1] - nums[0];
        int res = 0;

        while(st <= e) {
            int mid = (st + e)/2;
            int cnt = getCnt(mid, nums);

            if(cnt >= k){
                e = mid - 1;
                res = mid;
            }else{
                st = mid + 1;
            }
        }

        return res;
    }
}