// https://leetcode.com/problems/range-sum-of-bst/
class Solution {
    // tc -> logn, sc-> logn
    int sum;
    public int rangeSumBST(TreeNode root, int L, int R) {
        sum = 0;
        rangeSumInBST(root, L, R);
        return sum;
    }
    
    private void rangeSumInBST(TreeNode root, int L, int R){
        if(root==null) return;
        if(root.val >= L && root.val <= R)
            sum += root.val;
        if(root.val > L) rangeSumInBST(root.left, L, R);
        if(root.val < R) rangeSumInBST(root.right, L, R);
    }
}

// Iterative
class Solution {
    // tc -> logn, sc-> logn
    int sum;
    public int rangeSumBST(TreeNode root, int L, int R) {
        sum = 0;
        rangeSumInBST(root, L, R);
        return sum;
    }
    
    private void rangeSumInBST(TreeNode root, int L, int R){
        if(root==null) return;
        if(root.val >= L && root.val <= R)
            sum += root.val;
        if(root.val > L) rangeSumInBST(root.left, L, R);
        if(root.val < R) rangeSumInBST(root.right, L, R);
    }
}
