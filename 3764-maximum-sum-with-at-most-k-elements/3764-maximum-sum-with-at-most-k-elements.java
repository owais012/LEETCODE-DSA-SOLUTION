class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        // this question is pretty straight forward, just have a list of priority queue
        int n = grid.length, m = grid[0].length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for(int i = 0; i < n; i += 1){
            Arrays.sort(grid[i]);
            int cnt = 0;
            for(int j = m-1; j >=0; j -= 1){
                if(cnt == limits[i])
                    break;
                pq.add(grid[i][j]);
                cnt += 1;
            }
        }
        long sum = 0;
        while(k-- > 0 && !pq.isEmpty()){
            sum += pq.poll();
        }

        return sum;
    }
}