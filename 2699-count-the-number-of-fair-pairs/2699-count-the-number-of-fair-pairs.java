class Solution {
    public int lower_bound(int lower, int num1, int[] nums, int n) {
        int st = 0, e = n - 1;

        while (st <= e) {
            int mid = (st + e) / 2;
            if (num1 + nums[mid] < lower) {
                st = mid + 1;
            } else {
                e = mid - 1;
            }
        }

        return e + 1;
    }

    public int upper_bound(int upper, int num1, int[] nums, int n) {
        int st = 0, e = n - 1;

        while (st <= e) {
            int mid = (st + e) / 2;
            if (num1 + nums[mid] > upper) {
                e = mid - 1;
            } else {
                st = mid+1;
            }
        }

        return st - 1;
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        int n = nums.length;
        long res = 0;

        for(int i = 0; i < n-1; i += 1){
            int lb = lower_bound(lower, nums[i], nums, n);
            int ub = upper_bound(upper, nums[i], nums, n);

            if(lb >= n || ub < i)
                continue;
            if(lb <= i) lb = i+1;

            // System.out.println(i +" "+lb  + " " + ub);

            if(ub-lb > 0)
                res += ub-lb+1; 
            if(lb == ub)
                res+=1;
            
        }

        return res;
    }
}