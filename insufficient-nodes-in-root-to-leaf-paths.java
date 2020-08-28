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

// Easier to understand
class Solution {
    // tc -> n, sc-> n
    public TreeNode sufficientSubset(TreeNode root, int limit) {
        return deleteInSufficientNodes(root, limit, 0);        
    }
    
    private TreeNode deleteInSufficientNodes(TreeNode root, int limit,
                                        int sum){
        if(root==null) return null;
        sum += root.val;
        if(root.left==null && root.right==null)
            return sum < limit ? null : root;
        root.left = deleteInSufficientNodes(root.left, limit, sum);
        root.right = deleteInSufficientNodes(root.right, limit, sum);
        return root.left==null && root.right==null ? null : root;
    }
}
