
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution{
    private int globalMaxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        recurPath(root);
        return globalMaxPath;
    }

    private int recurPath(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftPathMax = recurPath(node.left);
        int rightPathMax = recurPath(node.right);
        int curPathMax = node.val + Math.max(0, leftPathMax) + Math.max(0, rightPathMax);
        // System.out.println(curPathMax);
        globalMaxPath = Math.max(globalMaxPath, curPathMax);
        return node.val + Math.max(0, Math.max(leftPathMax, rightPathMax));
    }
}