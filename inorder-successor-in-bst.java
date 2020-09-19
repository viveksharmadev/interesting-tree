// https://leetcode.com/problems/inorder-successor-in-bst/
class Solution {
    // tc -> logn, sc-> logn
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        
        TreeNode prev = null;
        
        while(root!=null){
            
            if(p!=null && p.val < root.val){
                prev = root;
                
                if(p.val == root.val) return prev;
                    
                root = root.left;
            }else{
                
                root = root.right;
                
            }
            
        }
        
        return prev;
    }
}
