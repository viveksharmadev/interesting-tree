// https://leetcode.com/problems/check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree/
class check-if-a-string-is-a-valid-sequence-from-root-to-leaves-path-in-a-binary-tree {
    // tc -> n, sc-> n
    public boolean isValidSequence(TreeNode root, int[] arr) {        
        return isValidSequenceInTree(root, arr, 0);
    }
    
    private boolean isValidSequenceInTree(TreeNode root, int[] arr,
                                         int index){
        if(root==null || index > arr.length-1
           || arr[index] != root.val) return false;
        if(root.left==null && root.right==null && index == arr.length-1)
            return true;                
        boolean isLeft = isValidSequenceInTree(root.left, arr, index+1);
        boolean isRight = isValidSequenceInTree(root.right, arr, index+1);
        return isLeft || isRight;
    }
}
