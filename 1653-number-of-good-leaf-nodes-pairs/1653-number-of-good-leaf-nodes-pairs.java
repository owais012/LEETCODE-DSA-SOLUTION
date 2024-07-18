/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution{
    public void makeAdj(TreeNode root, TreeNode prev, HashSet<TreeNode> st, Map<TreeNode, List<TreeNode>> adj){
        if(root == null)
            return;

        if(root.left == null && root.right == null)
            st.add(root);

        if(prev != null){
            adj.putIfAbsent(root, new ArrayList<>());
            adj.get(root).add(prev);
            
            adj.putIfAbsent(prev, new ArrayList<>());
            adj.get(prev).add(root);
        }

        makeAdj(root.left, root, st, adj);
        makeAdj(root.right, root, st, adj);

    }

    public int countPairs(TreeNode root, int distance) {
        HashSet<TreeNode> st = new HashSet<>();
        Map<TreeNode, List<TreeNode>> adj = new HashMap<>();

        makeAdj(root, null, st, adj);
        int count = 0;
        
        for(var curLeaf : st){
            Queue<TreeNode> q = new LinkedList<>();
            HashSet<TreeNode> vis = new HashSet<>();
            q.add(curLeaf);
            vis.add(curLeaf);

            for(int i = 0; i <= distance; i++){
                int sz = q.size();

                while(sz-- > 0){
                    var cur = q.poll();

                    if(cur != curLeaf && st.contains(cur))
                        count += 1;
                    
                    for(var nb : adj.getOrDefault(cur,new ArrayList<>())){
                        if(vis.contains(nb) == false){
                            vis.add(nb);
                            q.add(nb);
                        }
                    }

                }
            }
        }

        return count/2;

       
    }
}