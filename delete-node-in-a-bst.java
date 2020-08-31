// https://leetcode.com/problems/delete-node-in-a-bst/
// tc -> logn, sc-> logn or h
class delete-node-in-a-bst {
    // tc -> logn, sc-> logn
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;
        
        if(key < root.val) {
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){
            root.right = deleteNode(root.right, key);
        }else{
            if(root.left==null){
                return root.right;
            }else if(root.right==null){
                return root.left;
            }else{
                TreeNode nextSmallest = root.right;
                while(nextSmallest.left!=null) nextSmallest = nextSmallest.left;
                nextSmallest.left = root.left;
                return root.right;
            }
        }
        
        return root;
    }
}
