/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> arr = new ArrayList<>();

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            long sum = 0;
            int sz = q.size();

            for (int i = 0; i < sz; i += 1) {
                var cur = q.poll();

                sum += cur.val;

                if (cur.left != null) {
                    q.add(cur.left);
                }

                if (cur.right != null) {
                    q.add(cur.right);
                }
            }

            arr.add(sum);
        }

        Collections.sort(arr);
        Collections.reverse(arr);

        return k > arr.size() ? -1 : arr.get(k-1);
    }
}