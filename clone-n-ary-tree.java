// https://leetcode.com/problems/clone-n-ary-tree/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    
    public Node() {
        children = new ArrayList<Node>();
    }
    
    public Node(int _val) {
        val = _val;
        children = new ArrayList<Node>();
    }
    
    public Node(int _val,ArrayList<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class clone-n-ary-tree {
    // tc -> n, sc-> n
    Map<Node, Node> cache = new HashMap<>();
    public Node cloneTree(Node root) {
        if(root==null) return null;
        if(cache.containsKey(root)) return cache.get(root);
        else{
            Node clone = new Node(root.val, new ArrayList<>());
            cache.put(root, clone);
            for(int i=0; i<root.children.size(); i++){
                clone.children.add(cloneTree(root.children.get(i)));
            }
            return clone;
        }
    }
    
     // tc -> n, sc-> n
    public Node cloneTree(Node root) {
        if(root==null) return null;
        Node clone = new Node(root.val);
        List<Node> list = root.children;
        for(Node node : list){
            clone.children.add(cloneTree(node));
        }
        return clone;
    }
}
