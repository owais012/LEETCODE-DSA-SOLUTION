class Solution{ 
    boolean isPresent = false;

    public void dfs(TreeNode root, String s, String head){
        s += String.valueOf(root.val);

        if(s.length() >= head.length()){
            String temp = "";

            for(int i = s.length()-1; i >= 0; i--){
                temp = String.valueOf(s.charAt(i)) + temp;

                if(temp.length() >= head.length() && temp.equals(head)){
                    isPresent = true;
                }

            }
        }

        if(root.left  != null){
            dfs(root.left, s, head);
        }
    
        if(root.right != null){
            dfs(root.right, s,head);
        }

    }

    public boolean isSubPath(ListNode head, TreeNode root) {
        String listHead = "";
        var temp = head;

        // 1 4 2 6 in case of second example 
        while(temp != null){
            listHead += String.valueOf(temp.val);
            temp = temp.next;
        }
        
        dfs(root, "", listHead);
        return isPresent;
    }
}