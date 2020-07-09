// https://leetcode.com/problems/clone-binary-tree-with-random-pointer/
/**
 * Definition for Node.
 * public class Node {
 *     int val;
 *     Node left;
 *     Node right;
 *     Node random;
 *     Node() {}
 *     Node(int val) { this.val = val; }
 *     Node(int val, Node left, Node right, Node random) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *         this.random = random;
 *     }
 * }
 */

class clone-binary-tree-with-random-pointer {
    // tc -> n, sc-> n
    public NodeCopy copyRandomBinaryTree(Node root) {
        Map<Node, NodeCopy> cache = new HashMap<>();
        return cloneBinaryTree(root, cache);
    }
    
    private NodeCopy cloneBinaryTree(Node root, Map<Node, NodeCopy> cache){
        if(root==null) return null;
        if(cache.containsKey(root)) return cache.get(root);
        NodeCopy clone = new NodeCopy(root.val);
        cache.put(root, clone);
        clone.left = cloneBinaryTree(root.left, cache);
        clone.right = cloneBinaryTree(root.right, cache);
        clone.random = cloneBinaryTree(root.random, cache);
        return clone;
    }
}
