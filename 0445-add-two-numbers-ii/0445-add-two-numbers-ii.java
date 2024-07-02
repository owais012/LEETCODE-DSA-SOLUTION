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

class Solution{
    public ListNode helper(ListNode head, ListNode newHead){
        if(head == null) return head;
        var next = head.next;
        head.next = newHead;

        return helper(next, head);
    }
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;

        ListNode prev = null;
        var cur = head;
        var n = head.next;

        while(cur != null){
            cur.next = prev;
            prev = cur;
            cur = n;
            if(n != null)
                n  = n.next;
        }   
        return  prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        l1 = reverse(l1);
        l2 = reverse(l2);

        ListNode cur1 = l1, cur2 = l2;
        int carry = 0;

        ListNode dummyNode  = new ListNode(-1);
        var temp = dummyNode;

        while(cur1 != null && cur2 != null){
            int sum  = carry;
            sum += cur1.val;
            sum += cur2.val;

            carry = sum/10;
            ListNode newNode =  new ListNode(sum % 10);

            temp.next = newNode;
            temp = temp.next;

            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        while(cur1 != null){
            int sum = carry;
            sum += cur1.val;
            
            carry = sum/10;
            ListNode newNode =  new ListNode(sum % 10);

            temp.next = newNode;
            temp = temp.next;
            cur1 = cur1.next;        
        }
        
        while(cur2 != null){
            int sum = carry;
            sum += cur2.val;
            
            carry = sum/10;
            ListNode newNode =  new ListNode(sum % 10);

            temp.next = newNode;
            temp = temp.next;
            cur2 = cur2.next;        
        }

        if(carry > 0){
            ListNode newNode =  new ListNode(carry);
            temp.next = newNode;
            temp = temp.next;
        }

        dummyNode = reverse(dummyNode.next);
        return dummyNode;
    }
}