// https://leetcode.com/problems/find-all-the-lonely-nodes/
class find-all-the-lonely-nodes {
    // tc -> n, sc-> n
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left==null && node.right!=null) 
                res.add(node.right.val);
            if(node.left!=null && node.right==null)
                res.add(node.left.val);
            if(node.left!=null) q.offer(node.left);
            if(node.right!=null) q.offer(node.right);
        }
        return res;
    }
    
    // tc -> n, sc-> n
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> res = new LinkedList<>();
        if(root==null) return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            if(node.left==null && node.right!=null) 
                res.add(node.right.val);
            if(node.left!=null && node.right==null)
                res.add(node.left.val);
            if(node.left!=null) q.offer(node.left);
            if(node.right!=null) q.offer(node.right);
        }
        return res;
    }
}
