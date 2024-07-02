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
    public ListNode removeNodes(ListNode head) {
        Deque<ListNode> dq = new LinkedList<>();
        ListNode temp = head;
        
        while(temp != null){
            while(!dq.isEmpty() && dq.peekLast().val < temp.val)
                dq.pollLast();
            
            dq.add(temp);
            temp = temp.next;
        }
        ListNode dummyNode = new ListNode(-1);
        temp = dummyNode;
        
        while(!dq.isEmpty()){
            temp.next = dq.poll();
            temp = temp.next;
        }
        return dummyNode.next;
    }
}