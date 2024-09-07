/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
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
    boolean isPresent = false;
    public void dfs(TreeNode root, String s, String head){
        s += String.valueOf(root.val);
        System.out.println(s);
        if(s.length() >= head.length()){
            String temp = "";

            for(int i = s.length()-1; i >= 0; i--){
                temp = String.valueOf(s.charAt(i)) + temp;

                if(temp.length() >= head.length() && temp.equals(head)){
                    isPresent = true;
                }

            }
        }

        if(root.left  != null){
            dfs(root.left, s, head);
        }
    
        if(root.right != null){
            dfs(root.right, s,head);
        }

        
    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        String listHead = "";
        var temp = head;

        while(temp != null){
            listHead += String.valueOf(temp.val);
            temp = temp.next;
        }
        dfs(root, "", listHead);
        return isPresent;
    }
}