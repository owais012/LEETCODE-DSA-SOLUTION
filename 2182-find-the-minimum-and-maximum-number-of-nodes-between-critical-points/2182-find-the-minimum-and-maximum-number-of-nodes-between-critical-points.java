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
    public int[]nodesBetweenCriticalPoints(ListNode head) {
        List<Integer> temp = new ArrayList<>();
        var cur = head.next;

        var prev = head;
        int len = 1;

        while(cur.next != null){
            if((prev.val < cur.val && cur.val > cur.next.val) ||
            (prev.val > cur.val && cur.val < cur.next.val) ){
                temp.add(len);
            }
            len += 1;
            cur = cur.next;
            prev = prev.next;
        }

        int[] res = new int[2];
        if(temp.size() <= 1){
            Arrays.fill(res, -1);
            return res;
        }
        int maxDis = temp.get(temp.size()-1)- temp.get(0);
        int minDis = Integer.MAX_VALUE;
        System.out.println(temp);
        for(int i = 1; i < temp.size(); i++){
            minDis = Math.min(minDis, temp.get(i) - temp.get(i-1));
        }
        res[0] = minDis;
        res[1] = maxDis;
        return res;
    }
}