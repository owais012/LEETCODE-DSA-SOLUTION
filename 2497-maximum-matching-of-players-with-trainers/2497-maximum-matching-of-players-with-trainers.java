class Solution {
    public int matchPlayersAndTrainers(int[] players, int[] trainers) {
        //the solution goes, pretty straightforward,
        //1. as we just need to sort both the arrays and traverse through two point,   
        //or we can use tree Map

        Arrays.sort(players);
        Arrays.sort(trainers);

        int i = 0, j = 0,cnt = 0;
        while(i < players.length && j < trainers.length){
            if(players[i] <= trainers[j]){
                cnt += 1;
                i += 1;
                j += 1;
            }else{
                j += 1;
            }
        }

        return cnt;
    }   
}