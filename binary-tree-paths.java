// https://leetcode.com/problems/binary-tree-paths/
class Solution {
    // tc -> n, sc-> n
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new LinkedList<>();
        
        if(root==null) return result;        
        
        setBinaryTreePaths(root, "", result);  
        
        return result;
    }
    
    private void setBinaryTreePaths(TreeNode root, String path,
                                   List<String> result){
        if(root==null) return;
        
        if(root.left==null && root.right==null)
            result.add(path+root.val);
        
        setBinaryTreePaths(root.left, path + root.val + "->", result);
        setBinaryTreePaths(root.right, path + root.val + "->", result);
    }
}
