// https://leetcode.com/problems/binary-tree-maximum-path-sum/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class binary-tree-maximum-path-sum {
    // tc -> n, sc-> n
    int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        maxPathSumInTree(root);
        return max;
    }
    
    private int maxPathSumInTree(TreeNode root){
        if(root==null) return 0;
        int left = maxPathSumInTree(root.left);
        int right = maxPathSumInTree(root.right);
        int temp = Math.max(root.val, Math.max(left, right)+root.val);
        int res = Math.max(temp, root.val + left + right);
        max = Math.max(max, res);
        return temp;
    }
}
