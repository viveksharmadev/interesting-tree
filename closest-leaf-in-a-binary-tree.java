https://leetcode.com/problems/closest-leaf-in-a-binary-tree/
class Solution {
    // tc -> n, sc-> n
    public int findClosestLeaf(TreeNode root, int k) {
        Map<TreeNode, TreeNode> parentsMap = new HashMap<>();
        
        buildParentsMap(root, null, parentsMap);
        
        TreeNode target = getTargetNode(root, k);
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        
        Set<TreeNode> visited = new HashSet<>();
        visited.add(target);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                
                if(node.left==null && node.right==null)
                    return node.val;
                
                if(node.left!=null && !visited.contains(node.left)){
                    q.offer(node.left);
                    visited.add(node.left);
                }
                
                if(node.right!=null && !visited.contains(node.right)){
                    q.offer(node.right);
                    visited.add(node.right);
                }
                
                TreeNode parent = parentsMap.get(node);
                
                if(parent != null && !visited.contains(parent)){
                    q.offer(parent);
                    visited.add(parent);
                }
            }
        }
        
        return -1;
    }
    
    private TreeNode getTargetNode(TreeNode root, int val){
        if(root==null) return null;
        
        if(root.val==val) return root;
        
        TreeNode left = getTargetNode(root.left, val);
        TreeNode right = getTargetNode(root.right, val);
        
        return left==null ? right : left;
    }
    
    private void buildParentsMap(TreeNode root, TreeNode parent,
                                Map<TreeNode, TreeNode> parentsMap){
        if(root==null) return;
        
        parentsMap.put(root, parent);
        
        buildParentsMap(root.left, root, parentsMap);
        buildParentsMap(root.right, root, parentsMap);
    }
}
