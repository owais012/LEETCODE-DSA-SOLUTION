class Solution {
    public boolean checkPrimeFrequency(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;

        for(int i= 0; i < n; i += 1){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);    
        }

        outerLoop:
        for(var v : map.values()){
            if(v == 1)
                continue;
            for(int i = 2; i*i <= v; i+= 1){
                if(v%i == 0)
                    continue outerLoop;
            }
            System.out.println(v);
            return true;
        }
        return false;
    }
}