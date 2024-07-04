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
    public static ListNode convert(List<Integer> arr){
        if(arr.size() == 0) return null;
        ListNode head = new ListNode(arr.get(0));
        ListNode temp = head;

        for(int i = 1; i < arr.size(); i++){
            ListNode newNode = new ListNode(arr.get(i));
            temp.next = newNode;
            temp = temp.next;
        }
        return head;
    }

    public ListNode mergeNodes(ListNode head) {
        ListNode temp = head;
        List<Integer> arr = new ArrayList<>();

        int ans = 0;
        int sum = -1;

        while(temp != null){
            if(temp.val != 0){
                sum = sum + (int) temp.val;
                ans = Math.max(sum, ans);
                
            }else{
                if(sum != -1)arr.add(sum);
                sum = 0;
            }
            temp = temp.next;
        }
        return convert(arr);
    }
}