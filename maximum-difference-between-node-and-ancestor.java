// https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
class Solution {
    // tc -> n, sc-> n
    public int maxAncestorDiff(TreeNode root) {
        return getMaxAncestorDiff(root, root.val, root.val);
    }
    
    private int getMaxAncestorDiff(TreeNode root, int min, int max){
        if(root==null)
            return max-min;
        max = Math.max(root.val, max);
        min = Math.min(root.val, min);
        int left = getMaxAncestorDiff(root.left, min, max);
        int right = getMaxAncestorDiff(root.right, min, max);
        return Math.max(left, right);
    }
}
