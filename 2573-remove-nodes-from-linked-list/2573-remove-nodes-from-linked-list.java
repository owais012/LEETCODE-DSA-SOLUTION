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
    public ListNode insertAtHead(int data, ListNode head){
        if(head == null){
            head = new ListNode(data);
            return head;
        }

        ListNode newHead = new ListNode(data);
        newHead.next = head;
        return newHead;
    }

    public ListNode removeNodes(ListNode head) {
        ListNode temp = head;
        Stack<Integer> st = new Stack<>();

        while(temp != null){
            while(!st.isEmpty() && st.peek() < temp.val) st.pop();
            st.push(temp.val);
            temp = temp.next;
        }

        ListNode ans = null;
        while(!st.isEmpty()){
            ans = insertAtHead(st.pop(), ans);
        }
        return ans;
    }
}