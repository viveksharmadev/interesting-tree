// https://leetcode.com/problems/linked-list-in-binary-tree/
class Solution {
    // tc -> m*n, sc-> m
    public boolean isSubPath(ListNode head, TreeNode root) {
        if(head==null) return true;
        if(root==null) return false;
        return dfs(head, root) || isSubPath(head, root.left) 
                                   || isSubPath(head, root.right);
    }
    
    private boolean dfs(ListNode head, TreeNode root){
        if(head==null) return true;
        if(root==null) return false;        
        if(head.val != root.val) return false;
        return dfs(head.next, root.left) || dfs(head.next, root.right);
    }
}
