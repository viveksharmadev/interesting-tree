// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class kth-smallest-element-in-a-bst {
    // tc -> n, sc-> n
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<>();              
        while(!stack.isEmpty() || root!=null){
            while(root!=null){
                stack.push(root);
                root = root.left;
            }            
            root = stack.pop();
            if(--k ==0){
                break;
            }
            root = root.right;
        }
        return root.val;
    }
}
