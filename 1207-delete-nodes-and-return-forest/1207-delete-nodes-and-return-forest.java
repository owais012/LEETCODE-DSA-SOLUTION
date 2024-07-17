class Solution{
    public TreeNode deleteHelper(TreeNode root, Set<Integer> set , List<TreeNode> res){
        if(root == null)
            return null;
        
        root.left = deleteHelper(root.left, set, res);
        root.right = deleteHelper(root.right, set, res);

        if(set.contains(root.val)){
            if(root.left != null)
                res.add(root.left);

            if(root.right != null)
                res.add(root.right);
                
            return null;
        }

        return root;
    }

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();

        for(int i = 0; i < to_delete.length; i++)
            set.add(to_delete[i]);

        List<TreeNode> res = new ArrayList<>();

        deleteHelper(root, set, res);

        if(!set.contains(root.val)){
            res.add(root);
        }

        return res;
    }
}