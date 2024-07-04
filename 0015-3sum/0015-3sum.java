class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i = 0; i < nums.length; i++){
            int t = -nums[i];
            int l = i+1, r = nums.length-1;
            while(l < r){
                List<Integer> temp = new ArrayList<>();
                if(nums[l] + nums[r] > t){
                    r -= 1;
                }else if(nums[l] + nums[r] < t){
                    l += 1;
                }else{
                    while(l < r && nums[l] == nums[l+1]) l+= 1;
                    while(l < r && nums[r] == nums[r-1]) r-= 1;
                    temp.add(-t); temp.add(nums[l]); temp.add(nums[r]);
                    res.add(temp);
                     r--;
                }
            }
            while(i+1 < nums.length && nums[i] == nums[i+1])
                i += 1;
        }

        return res;
    }
}