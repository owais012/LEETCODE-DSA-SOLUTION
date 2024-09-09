/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
            
            for(int i = up.col; i <= right.col; i++){
                res[up.row][i] = temp.val;
                temp = temp.next;
                if(temp == null) break outerLoop;
            }

            up.row +=1;
            right.row +=1;
            for(int i = right.row; i < down.row; i++){
                res[i][right.col] = temp.val;
                temp = temp.next;
                if(temp == null) break outerLoop;
            }

            right.col -= 1;

            for(int i = down.col; i> left.col; i--){
                res[down.row][i] = temp.val;
                temp = temp.next;
                if(temp == null) break outerLoop;

            }

            down.row -= 1;
            down.col -= 1;

            for(int i = left.row; i>= up.row; i--){
                res[i][left.col] = temp.val;
                temp = temp.next;
                if(temp == null) break outerLoop;
            }

            left.col += 1;
            left.row -= 1;
            up.col+=1;
        }

        return res;
    }
}