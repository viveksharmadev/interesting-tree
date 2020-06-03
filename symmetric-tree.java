// https://leetcode.com/problems/symmetric-tree/
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
class symmetric-tree {
    // tc -> n, sc-> n
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return isSameTree(root.left, root.right);
    }
    
    private boolean isSameTree(TreeNode root1, TreeNode root2){
        if(root1==null && root2==null) return true;
        if(root1==null || root2==null) return false;
        if(root1.val!=root2.val) return false;
        return isSameTree(root1.left, root2.right)
            && isSameTree(root1.right, root2.left);
    }
    
    // tc -> n, sc-> n
    public boolean isSymmetric(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node1 = q.poll();
            TreeNode node2 = q.poll();
            if(node1==null && node2==null) continue;
            if(node1==null || node2==null) return false;
            if(node1.val != node2.val) return false;
            q.offer(node1.left);
            q.offer(node2.right);
            q.offer(node1.right);
            q.offer(node2.left);
        }
        return true;
    }
}
