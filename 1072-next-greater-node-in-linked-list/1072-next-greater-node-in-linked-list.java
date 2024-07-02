/**
* Definition for singly-linked list.
* public class ListNode {
*     int val;
*     ListNode next;
*     ListNode() {}
*     ListNode(int val) { this.val = val; }
*     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
*}
*/
class Solution{
    int len = 0;
    public ListNode reverse(ListNode head){
        if(head == null || head.next == null)
            return head;
        ListNode prev = null, cur = head, n = head.next;

        while(cur != null){
            cur.next = prev;
            prev = cur;
            cur = n;
            if(n != null)
                n = n.next;
            len += 1;
        }

        return prev;
    }

    public int[] nextLargerNodes(ListNode head) {
        head = reverse(head);
        if(head.next == null) 
            return new int[]{0};
        Stack<Integer> st = new Stack<>();
        int[] nextGreater = new int[len];
        var temp = head;

        for(int i = len-1; i >= 0; i--){
            while(!st.isEmpty() && st.peek() <= temp.val)
                st.pop();

            nextGreater[i] = st.isEmpty() ? 0 : st.peek();
            st.push(temp.val);
            temp = temp.next;
        }    
    
        return nextGreater;
    }
}