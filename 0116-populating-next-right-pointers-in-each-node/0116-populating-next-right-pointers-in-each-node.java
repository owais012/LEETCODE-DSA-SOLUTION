/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()){
            int sz = q.size();

            Node prev = null;
            for(int i = 0; i < sz; i++){
                Node curNode = q.poll();
                if(prev != null){
                    prev.next = curNode;
                }
                prev = curNode;
                if(curNode != null)
                    q.add(curNode.left);
                if(curNode != null)
                    q.add(curNode.right);
            }
            if(prev != null)
                prev.next = null;
        }

        return root;
    }
}