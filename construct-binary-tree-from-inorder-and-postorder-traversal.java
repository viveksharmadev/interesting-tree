// https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
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
class construct-binary-tree-from-inorder-and-postorder-traversal {
// tc -> n^2, sc-> n
   public TreeNode buildTree(int[] inorder, int[] postorder) {
     return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1);    
   }
   
   TreeNode helper(int[] inorder, int[] postorder, 
                   int postOrderRight, int inOrderLeft, int InOrderRight){
     if(postOrderRight >= postorder.length || inOrderLeft > InOrderRight) return null;
     TreeNode node = new TreeNode(postorder[postOrderRight]);
     int matchingIndex = 0;
     for(int i = 0; i < inorder.length; i++){
       if(inorder[i] == postorder[postOrderRight]) matchingIndex = i;  
     }
     node.left = helper(inorder, postorder, postOrderRight - 1 - InOrderRight + matchingIndex, 
                        inOrderLeft, matchingIndex - 1);
     node.right = helper(inorder, postorder, postOrderRight - 1 , 
                         matchingIndex + 1, InOrderRight);
     return node;
   }

   // tc -> n, sc-> n
   public TreeNode buildTree(int[] inorder, int[] postorder) {
     Map<Integer, Integer> cache = new HashMap<>();
       for(int i=0; i<inorder.length; i++){
           cache.put(inorder[i], i);
       }
     return helper(inorder, postorder, postorder.length - 1, 0, inorder.length - 1, cache);    
   }
   
   TreeNode helper(int[] inorder, int[] postorder, 
                   int postOrderRight, int inOrderLeft, int InOrderRight,
                  Map<Integer, Integer> cache){
     if(postOrderRight >= postorder.length || inOrderLeft > InOrderRight) return null;
     TreeNode node = new TreeNode(postorder[postOrderRight]);
     int matchingIndex = cache.get(postorder[postOrderRight]);     
     node.left = helper(inorder, postorder, postOrderRight - 1 - InOrderRight + matchingIndex, 
                        inOrderLeft, matchingIndex - 1, cache);
     node.right = helper(inorder, postorder, postOrderRight - 1 , 
                         matchingIndex + 1, InOrderRight, cache);
     return node;
   }
}
