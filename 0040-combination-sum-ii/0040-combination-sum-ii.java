class Solution {

    public static void helper(int i , int []arr, int T, int sumTillNow , List<Integer> Subset, List<List<Integer>> ans){
        if (sumTillNow == T) {
            ans.add(new ArrayList<>(Subset));
            return;
        }
        if (sumTillNow > T) return ;
        if(i >= arr.length) return ;
        
        // Picking
        Subset.add(arr[i]);
        sumTillNow += arr[i];
        helper(i+1, arr, T, sumTillNow, Subset, ans);
        
        Subset.remove(Subset.size()-1);
        sumTillNow -= arr[i];

        while (i+1 < arr.length && arr[i] == arr[i+1])i++;
        helper(i+1, arr, T, sumTillNow, Subset, ans);

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>>ans = new ArrayList<>();
        List<Integer>Subset = new ArrayList<>();
        helper(0, candidates, target, 0, Subset, ans);
        return ans;
    }
}