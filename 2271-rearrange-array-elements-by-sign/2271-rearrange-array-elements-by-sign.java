class Solution {
    public int[] rearrangeArray(int[] nums) {
        //pretty straight forward question, 
        //story the positive and negative in two different arrays
        //then after that merge them alternativerly

        List<Integer>a = new ArrayList<>();
        List<Integer>b = new ArrayList<>();

        for(var v : nums)
            if(v < 0)
                b.add(v);
            else
                a.add(v);

        int i = 0, j = 0, k =0;
        int[]res = new int[nums.length];

        while(i < a.size() && j < b.size()){
            if((k&1) == 0)
                res[k++] = a.get(i++);
            else
                res[k++] = b.get(j++);
        }
        if(i < a.size())
            res[k++] = a.get(i++);
        if(j < b.size())
            res[k++] = b.get(j++);
        return res;
    }
}