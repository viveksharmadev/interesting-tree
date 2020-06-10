// https://leetcode.com/problems/delete-nodes-and-return-forest/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    // tc -> n, sc-. n
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        Set<Integer> set = new HashSet<>();
        for(int i : to_delete) set.add(i);
        List<TreeNode> res = new LinkedList<>();
        if(!set.contains(root.val)) res.add(root);
        deleteNodes(set, res, root);
        return res;
    }
    
    private TreeNode deleteNodes(Set<Integer> set, List<TreeNode> res, 
                             TreeNode root){
        if(root==null) return null;
        root.left = deleteNodes(set, res, root.left);
        root.right = deleteNodes(set, res, root.right);
        if(set.contains(root.val)){
            if(root.left!=null) res.add(root.left);
            if(root.right!=null) res.add(root.right);
            return null;
         }
        return root;
    }
}
