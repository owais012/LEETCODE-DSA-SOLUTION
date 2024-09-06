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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();

        var cur = head;
        for(var num : nums) set.add(num);

        var dummyNode = new ListNode(-1);
        var temp = dummyNode;

        while(cur != null){
            while(cur != null && set.contains(cur.val)){
                cur = cur.next;
            }
            if(cur != null){
                temp.next = new ListNode(cur.val);
                temp = temp.next;
                cur = cur.next;
            }
        }

        return dummyNode.next;
    }   
}