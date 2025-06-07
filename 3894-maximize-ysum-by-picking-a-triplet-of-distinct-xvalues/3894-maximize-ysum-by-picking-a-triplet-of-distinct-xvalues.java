class Pair {
    int x,y;
    Pair(int x, int y){
        this.x = x;
        this.y = y;
    }
}

class Solution {
    public int maxSumDistinctTriplet(int[] x, int[] y) {
        int n = x.length;
        Pair[]arr = new Pair[n];

        for(int i = 0; i < n; i += 1){
            arr[i] = new Pair(x[i], y[i]);
        }

        Arrays.sort(arr, (a,b)-> (b.y-a.y));
        long sum = 0;
        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < n; i += 1){
            if(set.contains(arr[i].x))
                continue;
            sum += arr[i].y;
            set.add(arr[i].x);
            if(set.size() == 3)
                break;
        }
        if(set.size() < 3)
            return -1;
        return (int) sum;
    }
}