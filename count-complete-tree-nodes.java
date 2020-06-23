// https://leetcode.com/problems/count-complete-tree-nodes/
class Solution {
    // tc -> n, sc-> n
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        return 1+countNodes(root.left) + countNodes(root.right);
    }
    
    // tc -> n, sc-> n
    public int countNodes(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int res = 0;
        while(!q.isEmpty() && q.peek()!=null){
            TreeNode node = q.poll();
            q.offer(node.left);
            q.offer(node.right);
            res++;
        }
        
        return res;
    }
    
    // tc -> h^2 or (logn)^2, sc-> h 
    public int countNodes(TreeNode root) {
        if(root==null) return 0;
        int left = getLeftDepth(root);
        int right = getRightDepth(root);
        // 2^depth - 1 => number of nodes for full binary tree
        // having same nodes at both(left & right) sides
        if(left==right) return (1<<left) - 1; 
        return 1 + countNodes(root.left) + countNodes(root.right);
    }
    
    private int getLeftDepth(TreeNode root){
        int depth = 0;        
        while(root!=null){
            root = root.left;
            depth++;    
        }
        return depth;
    }
    
    private int getRightDepth(TreeNode root){
        int depth = 0;        
        while(root!=null){
            root = root.right;
            depth++;    
        }
        return depth;
    }
}
