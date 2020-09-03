Both questions are same:
// https://leetcode.com/problems/binary-search-tree-to-greater-sum-tree/
// https://leetcode.com/problems/convert-bst-to-greater-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    // tc -> n, sc-> n
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        if(root==null) return null;
        convertBST(root.right);
        root.val += sum;
        sum = root.val;
        convertBST(root.left);
        return root;
    }
}

// Without global variable
class Solution {
    // tc -> n, sc-> n
    public TreeNode convertBST(TreeNode root) {
        return getConvertedGreaterBST(root, new int[1]);
    }
    
    private TreeNode getConvertedGreaterBST(TreeNode root, int[] sum){
        if(root==null) return null;
        
        getConvertedGreaterBST(root.right, sum);
        
        root.val += sum[0];
        sum[0] = root.val;
        
        getConvertedGreaterBST(root.left, sum);
        
        return root;
    }
}
