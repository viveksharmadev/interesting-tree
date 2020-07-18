// https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
class find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree {
    // tc -> n, sc-> n
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
        if(original==null) return null;
        if(original==target) return cloned;
        TreeNode left = getTargetCopy(original.left, cloned.left, target);
        if(left!=null) return left;
        TreeNode right = getTargetCopy(original.right, cloned.right, target);
        if(right!=null) return right;
        return null;
    }
    
     // Compact version
    // tc -> n, sc-> n	    
    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {
		if (original == null || original == target)
			return cloned;
		TreeNode res = getTargetCopy(original.left, cloned.left, target);
		if (res != null)
			return res;
		return getTargetCopy(original.right, cloned.right, target);
	}
}
