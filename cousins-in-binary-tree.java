// https://leetcode.com/problems/cousins-in-binary-tree/
class cousins-in-binary-tree {
    // tc -> n, sc-> n
    class Node{
        TreeNode parent;
        int depth;
    }
    public boolean isCousins(TreeNode root, int x, int y) {
        Node node1 = getNode(root, null, x, 0, new Node());
        Node node2 = getNode(root, null, y, 0, new Node());
        return node1.parent!=node2.parent && node1.depth==node2.depth;
    }
    
    private Node getNode(TreeNode root, TreeNode parent, int val, int depth,
                        Node node){
        if(root==null) return null;
        if(val==root.val){
            node.parent = parent;
            node.depth = depth;
        }
        getNode(root.left, root, val, depth+1, node);
        getNode(root.right, root, val, depth+1, node);
        return node;
    }
}
