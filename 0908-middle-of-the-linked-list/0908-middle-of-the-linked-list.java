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
class Solution {
    public ListNode middleNode(ListNode head) {
        var tortoise = head;
        var rabit = head;

        while(rabit.next != null && rabit.next.next != null){
            tortoise = tortoise.next;
            rabit = rabit.next.next; 
        }
        if(rabit.next != null)
            tortoise = tortoise.next;
        return tortoise;
    }
}