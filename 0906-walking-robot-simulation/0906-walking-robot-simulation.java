class Solution {
    static class Robot{
        int x, y;
        char d;

        Robot(int x, int y, char d){
            this.x  =x;
            this.y = y;
            this.d = d;
        }
    }

    public int robotSim(int[] c, int[][] o) {

        HashSet<String> set = new HashSet<>();
        for(int i = 0;  i < o.length; i++){
            int x = o[i][0];
            int y = o[i][1];
            set.add(x+","+y);
        }

        int res = Integer.MIN_VALUE;
        Robot robot = new Robot(0,0,'N');

        for(int ind = 0; ind  < c.length; ind++){
            if(c[ind] == -1){
                if(robot.d == 'N') robot.d = 'E';
                else if(robot.d == 'E') robot.d = 'S';
                else if(robot.d == 'S') robot.d = 'W';
                else if (robot.d == 'W') robot.d = 'N';

            }else if(c[ind] == -2){
                if(robot.d == 'N') robot.d = 'W';
                else if(robot.d == 'W') robot.d = 'S';
                else if(robot.d == 'S') robot.d = 'E';
                else if(robot.d == 'E') robot.d = 'N';

            }else{
                int k = c[ind];
                if(robot.d == 'N'){
                    int y = robot.y;
                    boolean ok = true;
                    for(int i = 1; i <= k; i++){
                        if(set.contains(robot.x + "," +(y+i))){
                            robot.y = y+i-1;
                            ok = false;
                        }
                    }
                    if(ok)
                        robot.y = robot.y + k;

                }else if(robot.d == 'W'){
                    int x = robot.x;
                    boolean ok = true;

                    for(int i = 1; i <= k; i++){
                        if(set.contains((x-i) + "," +(robot.y))){
                            robot.x = x-i+1;
                            ok = false;
                        }
                    }
                    if(ok)
                        robot.x = robot.x - k;
                }

                else if(robot.d == 'S'){
                    int y = robot.y;
                    boolean ok = true;
                    for(int i = 1; i <= k; i++){
                        if(set.contains(robot.x + "," +(y-i))){
                            robot.y = y-i+1;
                            ok = false;
                        }
                    }
                    if(ok)
                        robot.y = robot.y - k;
                }
                else if(robot.d == 'E'){
                    int x = robot.x;
                    boolean ok = true;
                    for(int i = 1; i <= k; i++){
                        if(set.contains((x+i) + "," +(robot.y))){
                            robot.x = x+i-1;
                            ok = false;;
                        }
                    }
                    if(ok)
                        robot.x =robot.x + k;
                }
            }
            System.out.println(robot.x + " " + robot.y );
            int x = robot.x, y = robot.y;
            res = Math.max(res, (x*x) + (y*y));
        }

        return res;
    }
}