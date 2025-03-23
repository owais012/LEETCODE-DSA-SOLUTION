class Solution {
    public int maxContainers(int n, int w, int maxWeight) {
        int maxCount = maxWeight/w;

        if(n*n < maxCount)
            return n*n;
        return maxCount;   
    }

}