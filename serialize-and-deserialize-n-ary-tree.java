// https://leetcode.com/problems/serialize-and-deserialize-n-ary-tree/
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val,List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/
class Codec {
    // tc -> N, sc-> N
    private static final String splitter = ",";
    private static final String nullVal = "nullVal";
    // Encodes a tree to a single string.
    public String serialize(Node root) {
        StringBuilder sb = new StringBuilder();
        serialHelper(root, sb);
        return sb.toString();
    }

    private void serialHelper(Node root, StringBuilder sb){
        if(root==null){
            sb.append(nullVal).append(splitter);
        }else{
            sb.append(root.val).append(splitter);
            sb.append(root.children.size()).append(splitter);
            for(int i=0; i<root.children.size(); i++){
                serialHelper(root.children.get(i), sb);
            }
        }
    }
    
    // Decodes your encoded data to tree.
    public Node deserialize(String data) {
        Queue<String> q = new LinkedList<>();
        q.addAll(Arrays.asList(data.split(splitter)));
        return deserialHelper(q);
    }
    
    private Node deserialHelper(Queue<String> q){
        String val = q.poll();        
        if(val.equals(nullVal)){
            return null;
        }else{
            int size = Integer.parseInt(q.poll());
            Node node = new Node(Integer.parseInt(val),
                                new ArrayList<Node>());
            for(int i=0; i<size; i++){
                node.children.add(deserialHelper(q));
            }
            return node;
        }
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
