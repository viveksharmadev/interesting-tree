// https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class flatten-binary-tree-to-linked-list {
    // tc -> n, sc-> n
    public void flatten(TreeNode root) {
        if(root==null) return;
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            if(node.right!=null) stack.push(node.right);
            if(node.left!=null) stack.push(node.left);
            if(!stack.isEmpty()) node.right = stack.peek();
            node.left = null;
        }
    }
}
