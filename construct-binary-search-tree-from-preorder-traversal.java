// https://leetcode.com/problems/construct-binary-search-tree-from-preorder-traversal/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class construct-binary-search-tree-from-preorder-traversal {
    // tc -> n, sc-> n
    int indx;
    public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder==null) return null;
        indx = 0;
        return getBinaryTree(preorder, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    
    private TreeNode getBinaryTree(int[] preorder, int start, int end){
        if(indx==preorder.length 
           || preorder[indx]<start 
           || preorder[indx]>end) return null;
        int val = preorder[indx++];
        TreeNode root = new TreeNode(val);
        root.left = getBinaryTree(preorder, start, val);
        root.right = getBinaryTree(preorder, val, end);
        return root;
    }
}
