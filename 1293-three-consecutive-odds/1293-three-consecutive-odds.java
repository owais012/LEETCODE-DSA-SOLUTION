class Solution {
    public boolean threeConsecutiveOdds(int[] arr) {
        int odd = 0;
        for(int num: arr){
            if((num & 1) > 0) odd += 1;
            else odd = 0;
            if(odd >= 3) return true;
        }

        return false;
    }
}