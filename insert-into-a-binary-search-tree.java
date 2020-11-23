// https://leetcode.com/problems/insert-into-a-binary-search-tree/
// Recursive
class Solution {
    // tc -> logn, sc-> logn
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        
        if(val < root.val){
            root.left = insertIntoBST(root.left, val);
        }else if(val > root.val){
            root.right = insertIntoBST(root.right, val);
        }
        
        return root;
    }
}

// Iterative
class Solution {
    // tc -> logn, sc-> 1
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        
        TreeNode curr = root;
        while(curr!=null){
            
            if(curr.left==null && val < curr.val){
                curr.left = new TreeNode(val);
                return root;
            }else if(curr.right==null && val > curr.val){
                curr.right = new TreeNode(val);
                return root;
            }
            
            if(val < curr.val){
                curr = curr.left;
            }else if(val > curr.val){
                curr = curr.right;
            }
        }
        
        return root;
    }
}

// Using Stack
class Solution {
    // tc-> n, sc-> n
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while(!stack.isEmpty()){
            TreeNode node = stack.pop();
            
            if(node!=null){
                
                if(val < node.val && node.left==null)
                    node.left = new TreeNode(val);
                else if(val > node.val && node.right==null)
                    node.right = new TreeNode(val);
                
                if(val < node.val){
                    stack.push(node.left);
                }else if(val > node.val){
                    stack.push(node.right);
                }
            }
        }
        
        return root;
    }
}

// Recursive, may be easier to understand
class Solution {
    // tc -> logn, sc-> logn
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if(root==null) return new TreeNode(val);
        
        if(val < root.val) root.left = insertIntoBST(root.left, val);
        
        else if(val > root.val) root.right = insertIntoBST(root.right, val);
        
        else{
            if(root.left==null) root.left = new TreeNode(val);
            
            else if(root.right==null) root.right = new TreeNode(val);
        }
        
        return root;
    }
}
