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
    public int GCD(int a, int b) {
        if (b == 0)
            return a;
        return GCD(b, a % b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {
        var left = head;
        var right = head.next;

        while(right != null){
            var gcd = new ListNode(GCD(left.val, right.val));
            
            // Altering the pointers between the left, right and (new Node gcd)
            gcd.next = right;
            left.next = gcd;

            // Moving the left and right pointer appropriatly 
            left= right;
            right = right.next;
        }

        return head;
    }  
}