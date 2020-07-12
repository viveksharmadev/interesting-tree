// https://leetcode.com/problems/maximum-product-of-splitted-binary-tree/
class maximum-product-of-splitted-binary-tree {
    // tc -> n, sc-> n
    long res = 0, total = 0;
    public int maxProduct(TreeNode root) {
        total = maxProductInTree(root);
        maxProductInTree(root);
        return (int)(res % ((int)1e9 + 7));
    }
    
    private long maxProductInTree(TreeNode root){
        if(root==null) return 0;
        long left = maxProductInTree(root.left);
        long right = maxProductInTree(root.right);
        long sub = root.val + left + right;
        res = Math.max(res, sub*(total-sub));
        return sub;
    }
}
