// https://leetcode.com/problems/validate-binary-search-tree/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class validate-binary-search-tree {
    // tc -> n, sc-> n
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode prev = null;
        while(root!=null || !stack.isEmpty()){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            if(prev!=null && prev.val>=root.val){
                return false;
            }
            prev = root;
            root = root.right;
        }
        return true;
    }
    
    // tc -> n, sc-> n
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean isValidBST(TreeNode root, long min, long max){
        if(root==null) return true;
        if(root.val <= min || root.val >= max) return false;
        boolean isLeft = isValidBST(root.left, min, root.val);
        boolean isRight = isValidBST(root.right, root.val, max);
        return isLeft && isRight;
    }
}
