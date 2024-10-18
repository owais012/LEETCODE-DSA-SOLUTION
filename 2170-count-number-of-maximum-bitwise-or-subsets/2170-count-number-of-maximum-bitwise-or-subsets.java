class Solution {

    public int countMaxOrSubsets(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        int n = nums.length;
        int maxi = Integer.MIN_VALUE;

        System.out.println(1 << n);

        for(int i = 0; i < (1 << n); i+=1){
            int or=0;
            for(int j = 0; j < n; j+=1){
                if(((i>> j) & 1) == 1){
                    or = (or | nums[j]);
                }
            }

            maxi = Math.max(maxi, or);
            arr.add(or);
        }

        // System.out.println(arr);

        int cnt = 0; 
        for(var v: arr)
            if(v == maxi)
                cnt += 1;

        return cnt;
    }
}