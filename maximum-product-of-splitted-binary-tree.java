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

// Cleaner

class Solution {
    // tc -> n, sc-> n
    public int maxProduct(TreeNode root) {
        long[] result = new long[1];
        
        long total = getTotal(root);
        
        maxProductInTree(root, result, total);
        
        return (int)(result[0] % ((int)1e9+7));
    }
    
    private long getTotal(TreeNode root){
        if(root==null) return 0;
        
        long left = getTotal(root.left);
        long right = getTotal(root.right);
        
        return left + right + root.val;
    }
    
    private long maxProductInTree(TreeNode root, long[] result,
                                 long total){
        if(root==null) return 0;
        
        long left = maxProductInTree(root.left, result, total);
        long right = maxProductInTree(root.right, result, total);
        
        long subSum = left + right + root.val;
        
        long product = subSum * (total-subSum);
        result[0] = Math.max(result[0], product);
        
        return subSum;
    }
}
