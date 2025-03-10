class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int fruitCount = fruits.length;

        for(int i = 0; i < fruits.length; i += 1){
            for(int j = 0; j < baskets.length; j += 1){
                if(baskets[j] == -1){
                    continue;
                }
                if(fruits[i] <= baskets[j]){
                    fruitCount -= 1;
                    baskets[j] = -1;
                    break;
                }
            }
        }

        return fruitCount;
    }
}