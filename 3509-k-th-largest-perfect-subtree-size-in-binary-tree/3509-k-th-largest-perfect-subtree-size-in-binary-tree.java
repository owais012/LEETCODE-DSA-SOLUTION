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

    public int dfs(TreeNode root, List<Integer> arr) {
        if((root.left == null && root.right == null)){
            arr.add(1);
            return 1;
        }
        int left = 0, right = 0;
        if (root.left != null) {
            left = dfs(root.left, arr);
        }

        if (root.right != null) {
           right  =  dfs(root.right, arr);
        }
        if(left == right)
            arr.add(left + right + 1);
        return left == right ? left + right + 1 : -1;
    }

    public int kthLargestPerfectSubtree(TreeNode root, int k) {
        // this question is dfs + dp;
        // u need to know the size of the each sub-tree,
        // if the sub0-tree is not perfect then put
        List<Integer> arr = new ArrayList<>();
        dfs(root, arr);

        Collections.sort(arr);
        Collections.reverse(arr);
        System.out.println(arr);
        if(k > arr.size()) return -1;
        return arr.get(k-1);
    }
}