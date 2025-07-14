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
    public ListNode reverse(ListNode head){
        ListNode p = head;
        var cur = head.next;
        var q = cur != null ? cur.next : null; 
        p.next = null;

        while(cur != null){
            cur.next = p;
            p = cur;
            cur = q;
            if(q != null){
                q = q.next;
            }
        }

        return p;
    }

    public int getDecimalValue(ListNode head){
        var cur = reverse(head);
        int num = 0, i = 0;

        while(cur!= null){
            num += (1 << i)*cur.val;
            System.out.println(cur.val);
            i += 1;
            cur = cur.next;
        }

        return num;
    }
}