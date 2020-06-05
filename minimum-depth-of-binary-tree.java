// https://leetcode.com/problems/minimum-depth-of-binary-tree/

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
    int min = Integer.MAX_VALUE;
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        int left = 1 + minDepth(root.left);
        int right = 1 + minDepth(root.right);
        if(root.left==null) return right;
        if(root.right==null) return left;
        return Math.min(left, right);
    }
    
    // Iterative - BFS
    // tc -> n, sc-> n
    public int minDepth(TreeNode root) {
        if(root==null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int depth = 0;
        while(!q.isEmpty()){
            int size = q.size();
            depth++;
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                if(node.left==null && node.right==null)
                    return depth;
                if(node.left!=null){
                    q.offer(node.left);
                }
                if(node.right!=null){
                    q.offer(node.right);
                }
            }            
        }
        return -1;
    }
}
