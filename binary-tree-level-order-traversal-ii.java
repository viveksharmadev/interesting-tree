// https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
class binary-tree-level-order-traversal-ii {
    // tc -> n, sc-> n
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null) return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            int size = q.size();
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                list.add(node.val);
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            res.add(0,list);
        }
        return res;
    }
}
