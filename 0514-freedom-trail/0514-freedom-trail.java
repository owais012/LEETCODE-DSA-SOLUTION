class Node{
    int ki, ri,steps;
    Node(int k, int r, int s){
        ki = k;
        ri = r;
        steps = s;
    }
}

class Solution{
    public int countSteps(int i, int ri, int n){
        int clockWise = Math.abs(ri - i);
        int antiClockWise = n - clockWise;
        return Math.min(clockWise, antiClockWise);
    }

    public int findRotateSteps(String ring, String key){
        int n = ring.length();
        int m = key.length();

        Map<Character, List<Integer>> adj = new HashMap<>();

        for(int i = 0;i< ring.length(); i++){
            adj.putIfAbsent(ring.charAt(i), new ArrayList<>());
            adj.get(ring.charAt(i)).add(i);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> (a.steps - b.steps));
        pq.add(new Node(0,0,0));
        HashSet<String> vis = new HashSet<>();
        // set.add(String.valueOf(0+" "+0));
        int total_steps = 0;

        while(!pq.isEmpty()){
            Node curNode = pq.poll();
            int ri = curNode.ri;
            int ki = curNode.ki;
            total_steps = curNode.steps;

            if(ki == m) break;
            if(vis.contains(ri+" "+ki)) continue;
            vis.add(ri + " "+ki);

            for(Integer nb : adj.get(key.charAt(curNode.ki))){
                int steps = countSteps(ri, nb , n) + total_steps;
                pq.add(new Node(ki+1, nb, steps));
            }
        }

        return total_steps + m;
    }
}