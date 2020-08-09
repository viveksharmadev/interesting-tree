// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/
class Solution {
    // tc -> n, sc-> n
    public int sumEvenGrandparent(TreeNode root) {
        return getResult(root, null, null);
    }
    
    private int getResult(TreeNode node, TreeNode parent, TreeNode gParent){        
        int sum = 0;        
        if(node==null) 
            return 0;
        if(gParent!=null && gParent.val%2==0)
            sum += node.val;
        sum += getResult(node.left, node, parent);
        sum += getResult(node.right, node, parent);
        return sum;
    }
}
