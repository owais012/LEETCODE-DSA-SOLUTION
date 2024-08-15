class Solution {
    public boolean lemonadeChange(int[] b) {
        int five= 0,ten = 0, twenty = 0;
        for(int i =0; i < b.length; i++){
            if(b[i] == 5){
                five += 1;
                continue;
            }

            if(b[i] == 10){
                five -= 1;
                ten += 1;
                if(five < 0) return false;
            }
            
            if(b[i] == 20){
                twenty += 1;
                if(ten > 0 && five > 0){
                    ten--;
                    five--;
                } 
                else if(five > 2){
                    five -= 3;
                }else
                    return false;
            }
        }
        return true;
    }
}