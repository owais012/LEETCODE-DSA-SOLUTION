class Solution {
    public class Pair {
        int row, col;

        Pair(int r, int c) {
            row = r;
            col = c;
        }
    }

    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][]res = new int[m][n];

        Pair right = new Pair(0, n-1);
        Pair down = new Pair(m-1, n-1);
        Pair left = new Pair(m-1, 0);
        Pair up = new Pair(0, 0);

        var temp = head;

        for(var row: res)Arrays.fill(row, -1);
        outerLoop:
        while(temp != null){   
            // moving from the top left corner to the top right corner
            
            for(int i = up.col; i <= right.col; i++){
                res[up.row][i] = temp.val;
                temp = temp.next;
                if(temp == null) break outerLoop;
            }


            //After traversing incrmenting up, and right 
            up.row +=1;
            right.row +=1;

            //once top left -> right is complete then we go from the top right corner to the bottom right corner 

            for(int i = right.row; i < down.row; i++){
                res[i][right.col] = temp.val;
                temp = temp.next;
                if(temp == null) break outerLoop;
            }

            //once right side traversal is done we update the  Pair  right 
            right.col -= 1;

            // now once we are done teraversing from top right to bottom right 
            // we mocve from the bottom right towards the bottom left

             for(int i = down.col; i> left.col; i--){
                res[down.row][i] = temp.val;
                temp = temp.next;
                if(temp == null) break outerLoop;

            }
            
            //now once , down row traversal is done we can update the Pair down
            down.row -= 1;
            down.col -= 1;


            //now finall we move from the bottom left to up left

            for(int i = left.row; i>= up.row; i--){
                res[i][left.col] = temp.val;
                temp = temp.next;
                if(temp == null) break outerLoop;
            }

            // once left bottom to up left is done we update the Pair left and up
            left.col += 1;
            left.row -= 1;
            up.col+=1;
        }

        return res;
    }
}