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
    int sum = 0;
    public void inOrder(TreeNode root){
        if(root != null){
            inOrder(root.right);
            root.val += sum;
            sum = root.val;
            inOrder(root.left);
        }
    }

    public TreeNode bstToGst(TreeNode root) {
        inOrder(root);
        return root;
    }
}