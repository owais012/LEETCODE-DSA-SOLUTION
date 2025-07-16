class Solution {
    public int maximumLength(int[] nums) {
        //we get the even count,
        //get the odd count
        //get the alternating count
        //return the max lenght of all;
        int n = nums.length;
        int oddCount = 0, evenCount = 0;
        for(var v: nums){
            if(v %2 == 1)
                oddCount += 1;
            else
                evenCount += 1;
        }
        int alter = 0, last = -1;
        
        for(int i = 0; i < n; i+= 1){
            if(last == -1){
                alter += 1;
                last = nums[i]%2;
            }else if(nums[i]%2 != last%2){
                alter += 1;
                last = nums[i]%2;
            }
        }

        // int alter
        return Math.max(alter, Math.max(evenCount, oddCount));
    }
}