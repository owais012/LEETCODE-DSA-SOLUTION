class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        Arrays.sort(arr);

        for(int i = arr.length-1; i >= 0; i -= 1){
            int v = arr[i];

            if(set.contains(2*v)){
                return true;
            }
            set.add(v);
        }
        set.clear();
        for(int i = 0; i < arr.length; i += 1){
            int v = arr[i];

            if(set.contains(2*v)){
                return true;
            }
            set.add(v);
        }
        
        return false;
    }
}