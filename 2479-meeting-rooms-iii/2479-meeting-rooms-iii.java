class Solution {
    public class Pair{
        long end;
        int room;
        Pair(long end, int room){
            this.end = end;
            this.room = room;
        }
    }
    public int mostBooked(int n, int[][] meetings) {
        //we can have Treeset<room_number, t - at which it will become free>
        //map<room_number, numbre of time used>
        TreeSet<Integer> set = new TreeSet<>();
        for(int i = 0; i < n; i+= 1){
            set.add(i);
        }

        int maxTime = 0;
        TreeSet<Long> time = new TreeSet<>();
        for(int i = 0; i < meetings.length; i += 1){
            time.add((long) meetings[i][0]);
            time.add((long) meetings[i][1]);
        }
        PriorityQueue<Pair>pq = new PriorityQueue<>((a,b) -> Long.compare(a.end, b.end));
        int ind = 0;
        Arrays.sort(meetings, (a,b) -> (a[0]-b[0]));

        Map<Integer, Integer> map = new HashMap<>();
        while(true){
            //get latest meeting
            Long t = time.pollFirst(); 
            if(t == null)
                break;
            while(!pq.isEmpty() && pq.peek().end <= t){
                set.add(pq.poll().room);
            }
            while(ind < meetings.length && meetings[ind][0] <= t && set.size() > 0){
                Integer room = set.size() > 0 ? set.first() : null;
                if(room != null){
                    long end = t+(meetings[ind][1]-meetings[ind][0]);
                    //System.out.println(t + " " +room + " " + ind + " " + end);   
                    map.put(room, map.getOrDefault(room, 0)+1); 
                    pq.add(new Pair(end, room));
                    time.add(end);
                    ind += 1;
                    set.remove(room);
                }
            }

        }
        System.out.println(map);
        int maxUsedRoom = -1;
        int maxFreq = 0;
        for(var v: map.entrySet()){
            if(v.getValue() > maxFreq){
                maxFreq = v.getValue();
                maxUsedRoom = v.getKey(); 
            }
            if(v.getValue() == maxFreq && v.getKey() < maxUsedRoom)
                maxUsedRoom = v.getKey();
        }

        return maxUsedRoom;
    }
}