// https://leetcode.com/problems/all-elements-in-two-binary-search-trees/
class all-elements-in-two-binary-search-trees {
    // tc -> (m+n)log(m+n), sc-> m+n
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new LinkedList<>();
        traverseTree(root1, res);
        traverseTree(root2, res);
        Collections.sort(res);
        return res;
    }
    
    private void traverseTree(TreeNode root, List<Integer> res){
        if(root==null) return;
        res.add(root.val);
        traverseTree(root.left, res);        
        traverseTree(root.right, res);
    }
    
     // tc -> m+n, sc-> m+n
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> res = new LinkedList<>();
        if(root1==null && root2==null)
            return res;
        
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        pushLeft(stack1, root1);
        pushLeft(stack2, root2);
        
        while(!stack1.isEmpty() || !stack2.isEmpty()){
            Stack<TreeNode> stack;
            if(stack1.isEmpty()){
                stack = stack2;
            }else if(stack2.isEmpty()){
                stack = stack1;
            }else{
                stack = stack1.peek().val < stack2.peek().val 
                    ? stack1 : stack2;
            }
            TreeNode node = stack.pop();
            res.add(node.val);
            pushLeft(stack, node.right);
        }
        return res;
    }
    
    private void pushLeft(Stack<TreeNode> stack, TreeNode root){
        while(root!=null){
            stack.push(root);
            root = root.left;
        }
    }
}
