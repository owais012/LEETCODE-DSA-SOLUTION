class Solution {
    record Pair(int h, String n){};

    public String[] sortPeople(String[] names, int[] heights) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((a, b) -> Integer.compare(b.h, a.h));
        
        for(int i = 0; i < names.length; i++){
            pq.add(new Pair(heights[i], names[i]));
        }

        String[] res = new String[names.length];
        for(int i = 0; i < res.length; i++){
            res[i] = pq.poll().n;
        }
        return res;
    }
}