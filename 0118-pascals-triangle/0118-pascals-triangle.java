class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<> (List.of(1)));
        while(numRows-- > 1){
            List<Integer> cur  = new ArrayList<>();
            List<Integer> prev = res.get(res.size()-1);
            cur.add(1);
            for(int i = 1; i < prev.size(); i += 1){
                int sum  = 0;
                if(i < prev.size())
                    sum += prev.get(i);
                if(i-1 < prev.size())
                    sum += prev.get(i-1);                  
                cur.add(sum);
            }
            cur.add(1);
            res.add(cur);
        }
        

        return res;
    }
}