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
    public TreeNode findNextMin(TreeNode root){
        var cur = root;
        while(cur.left != null){
            cur = cur.left;
        }
        return cur;
    }
    
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return root;
        
        if(root.val < key){
            root.right = deleteNode(root.right, key);
            return root;
        }
        
        if(root.val > key){
            root.left = deleteNode(root.left, key);
            return root;
        } 
        
        if(root.left == null && root.right == null){
            return null;
        }
        
        if(root.left == null){
            root = root.right;
            return root;
        }
        if(root.right == null){
            root = root.left;
            return root;
        }
        var temp = findNextMin(root.right);
        System.out.println(temp.val);

        root.val = temp.val;
        root.right = deleteNode(root.right, temp.val);
        return root;
    }
}


