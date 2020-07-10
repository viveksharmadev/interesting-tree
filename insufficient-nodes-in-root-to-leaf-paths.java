//https://leetcode.com/problems/insufficient-nodes-in-root-to-leaf-paths/
class insufficient-nodes-in-root-to-leaf-pathsinsufficient-nodes-in-root-to-leaf-paths {
    // tc -> n, sc-> n
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        if(root==null) return null;
        
        if(isLeaf(root)) return root.val < limit ? null : root;
        
        root.left = sufficientSubset(root.left, limit-root.val);
        root.right = sufficientSubset(root.right, limit-root.val);
        
        return isLeaf(root) ? null : root;
    }
    
    private boolean isLeaf(TreeNode root){
        return root.left==null && root.right==null;
    }
}
