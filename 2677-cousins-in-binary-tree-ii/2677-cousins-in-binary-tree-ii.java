class Solution {

    public TreeNode replaceValueInTree(TreeNode root) {
        // this question can be solved by calculating depth for each node and mapping
        // then we just need to check whe

        // can be sovle using dfs
        // also can be solved using bfs
        Map<TreeNode, TreeNode> map = new HashMap<>();
        Map<TreeNode, Integer> map2 = new HashMap<>();
        // let's start

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int level = 1;
        while (!q.isEmpty()) {
            int sz = q.size();

            // now i am supposed to have a variable , that will sum up all the valeus of
            // nodes
            // then assign the node the value that sum of all other nodes which cousins
            int sum = 0;
            List<TreeNode> arr = new ArrayList<>();
            for (int i = 0; i < sz; i += 1) {
                var cur = q.poll();
                sum += cur.val;
                arr.add(cur);
                int childSum = 0;
                if(cur.left != null){
                    childSum += cur.left.val;
                    q.add(cur.left);
                    map.put(cur.left, cur);
                }
                if(cur.right != null){
                    childSum += cur.right.val;
                    q.add(cur.right);
                    map.put(cur.right, cur);
                }
                map2.put(cur, childSum);
            }

            // now some how i am supposed to store the parent of each node
            // for this i can make use of map and traverse the while tree once to store the
            // parents

            // now by default for the first 2 level ., the anser is going to be 0
            for (int i = 0; i < sz; i += 1) {
                if (level <= 2) {
                    arr.get(i).val = 0;
                    continue;
                }
                arr.get(i).val = sum - map2.get(map.get(arr.get(i)));
                
            }

            level += 1;
        }

        return root;
    }
}