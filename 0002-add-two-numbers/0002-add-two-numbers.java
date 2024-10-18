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
  
    
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode one = l1;
        ListNode two = l2;
        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;
        int carry = 0;
        while(one != null || two != null || carry >= 1){
            int sum = 0;
            if(one != null) {
                sum += one.val;
                one = one.next;
            } 
            if(two != null){
                sum += two.val;
                two = two.next;
            }
            sum += carry;
            carry = sum / 10;
            ListNode newNode = new ListNode (sum % 10);
            temp.next = newNode;
            temp = temp.next;
        }
        return dummy.next;
    }
}