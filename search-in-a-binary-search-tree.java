// https://leetcode.com/problems/search-in-a-binary-search-tree/
class search-in-a-binary-search-tree {
    // tc -> logn or h, sc-> 1
    public TreeNode searchBST(TreeNode root, int val) {
        while(root!=null){
            if(val < root.val){
                root = root.left;
            }else if(val > root.val){
                root = root.right;
            }else{
                return root;
            }
        }
        return null;
    }
}
