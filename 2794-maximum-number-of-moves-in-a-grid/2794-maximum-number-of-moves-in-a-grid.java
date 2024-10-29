class Solution {
    public class Node {
        int row, col, len;

        Node(int row, int col, int len) {
            this.row = row;
            this.col = col;
            this.len = len;
        }
    }

    public boolean isValidCell(int r, int c, int n, int m) {
        return r >= 0 && c >= 0 && r < n && c < m;
    }

    public void visitAllNodes(Queue<Node> queue, Node curNode, int[][] grid, boolean visited[][]) {
        int n = grid.length, m = grid[0].length;

        int[] drow = new int[] { -1, 0, 1 };
        int[] dcol = new int[] { 1, 1, 1 };

        for (int i = 0; i < 3; i += 1) {
            int newRow = curNode.row + drow[i];
            int newCol = curNode.col + dcol[i];

            if (isValidCell(newRow, newCol, n, m) && !visited[newRow][newCol]
                    && grid[curNode.row][curNode.col] < grid[newRow][newCol]) {
                queue.add(new Node(newRow, newCol, curNode.len + 1));
                visited[newRow][newCol] = true;
            }
        }
    }

    public int getMaxPath(int row, int col, int[][] grid) {
        int n = grid.length, m = grid[0].length;

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(row, col, 0));
        int res = 0;

        boolean[][] visited = new boolean[n][m];

        while (!queue.isEmpty()) {

            var curNode = queue.poll();
            res = Math.max(res, curNode.len);
            
            visitAllNodes(queue, curNode, grid, visited);
        }

        return res;
    }

    public int maxMoves(int[][] grid) {
        // it is as simple as another graph problem

        int res = 0;
        for (int startNode = 0; startNode < grid.length; startNode += 1) {
            res = Math.max(res, getMaxPath(startNode, 0, grid));
        }

        return res;
    }
}