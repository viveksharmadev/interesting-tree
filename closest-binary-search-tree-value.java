// https://leetcode.com/problems/closest-binary-search-tree-value/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class closest-binary-search-tree-value {
    // tc -> logn, sc-> 1
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        while(root!=null){
            if(Math.abs(target-root.val) < Math.abs(target-res))
                res = root.val;
            if(target < root.val){
                root = root.left;
            }else{
                root = root.right;
            }
        }
        return res;
    }
    
    // Recursive
    // tc -> logn, sc-> logn
    int res;
    public int closestValue(TreeNode root, double target) {
        res = root.val;
        closestValueInTree(root, target);
        return res;
    }
    
    private int closestValueInTree(TreeNode root, double target){
        if(root==null) return 0;
        if(Math.abs(target-root.val) < Math.abs(target-res))
            res = root.val;
        if(target < root.val) return closestValueInTree(root.left, target);
        else return closestValueInTree(root.right, target);
    }
}
