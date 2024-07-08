class Solution{
    public void func(int ind, int cur, int k, List<Integer> arr){
        if(arr.size() == 1)
            return;
        if(cur == k){
            arr.remove(ind);
            func(ind, 1, k, arr);
        }
        func((ind+1) % arr.size(), cur+1, k, arr);
    }
    
    public int findTheWinner(int n, int k) {
        List<Integer> arr = new ArrayList<>();
        
        for(int i =1; i <= n; i++)
            arr.add(i);
        func(0, 1, k, arr);
        
        return arr.get(0);
    }
}