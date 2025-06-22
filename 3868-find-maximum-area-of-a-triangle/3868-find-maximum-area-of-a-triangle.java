class Pair{
    int min,max;
    Pair(int min, int max){
        this.min = min;
        this.max = max;
    }
}

class Solution {
    public long maxArea(int[][] coords) {
        TreeMap<Integer, Pair>mapX = new TreeMap<>();
        TreeMap<Integer, Pair>mapY = new TreeMap<>();

        int n = coords.length;
        int leftX = Integer.MAX_VALUE, rightX = Integer.MIN_VALUE;
        int upY = Integer.MIN_VALUE, downY = Integer.MAX_VALUE;

        for(int i = 0; i < n; i += 1){
            int x = coords[i][0];
            int y = coords[i][1];
            
            leftX = Math.min(leftX, x);
            rightX = Math.max(x, rightX);
            upY = Math.max(upY, y);
            downY = Math.min(downY, y);

            mapX.putIfAbsent(x, new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE));
            mapY.putIfAbsent(y, new Pair(Integer.MAX_VALUE, Integer.MIN_VALUE));        

            int minY = Math.min(y, mapX.get(x).min);
            int maxY = Math.max(y, mapX.get(x).max);
            mapX.put(x, new Pair(minY, maxY));

            int minX = Math.min(x, mapY.get(y).min);
            int maxX = Math.max(x, mapY.get(y).max);
            mapY.put(y, new Pair(minX, maxX));
        }

        int[] x_axis = new int[mapX.size()];
        int[] y_axis = new int[mapY.size()];
        long res = -1;

        for(var v : mapX.entrySet()){
            long dist = v.getValue().max - v.getValue().min;
            long curX = v.getKey();
            // System.out.println(curX + " " + v.getValue().max + " " + v.getValue().min);
            // System.out.println((curX-leftX )+ " " + (rightX- curX));

            res = Math.max(res, (long)dist*Math.max((curX-leftX), (rightX- curX)));
            // System.out.println(res);
        }

        for(var v : mapY.entrySet()){
            long dist = v.getValue().max - v.getValue().min;
            long curY = v.getKey();
            res = Math.max(res, (long) dist*Math.max(curY-downY, upY - curY));
        }

        return res == 0 ? -1 :res;
    }
}