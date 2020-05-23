// https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class construct-binary-tree-from-preorder-and-inorder-traversal {
    // tc -> n^2, sc-> n
    public TreeNode buildTree(int[] preorder, int[] inorder) {
      return helper(preorder, inorder, 0, 0, inorder.length - 1);    
    }
    
    TreeNode helper(int[] preorder, int[] inorder, int preorderStart, 
                    int inorderStart, int inorderEnd){
      if(preorderStart > preorder.length - 1 || inorderStart > inorderEnd) return null;
      TreeNode node = new TreeNode(preorder[preorderStart]); 
      int matchingIndex = 0;
      for(int i = inorderStart; i <= inorderEnd; i++){
        if(inorder[i] == preorder[preorderStart]) matchingIndex = i;  
      }
      node.left = helper(preorder, inorder, preorderStart + 1, inorderStart, matchingIndex - 1);
      node.right = helper(preorder, inorder, preorderStart + 1 + matchingIndex - inorderStart, matchingIndex + 1, inorderEnd);
      return node;
    }
}
