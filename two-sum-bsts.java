// https://leetcode.com/problems/two-sum-bsts/
class Solution {
    // tc -> m*n, sc-> m*n
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        if(root1==null || root2==null) return false;
        
        int sum = root1.val + root2.val;
        
        if(sum==target) return true;
        else if(sum > target)
            return twoSumBSTs(root1.left, root2, target) 
            || twoSumBSTs(root1, root2.left, target);
        else 
            return twoSumBSTs(root1, root2.right, target) 
            || twoSumBSTs(root1.right, root2, target);
    }
}

class Solution {
    // tc -> m+n, sc-> m+n
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        Stack<TreeNode> stack1 = new Stack<>();
        
        Set<Integer> set = new HashSet<>();
        
        while(!stack1.isEmpty() || root1!=null){            
            while(root1!=null){
                stack1.push(root1);
                root1 = root1.left;
            }
            
            root1 = stack1.pop();
            set.add(target-root1.val);
            root1 = root1.right;
        }
        
        Stack<TreeNode> stack2 = new Stack<>();
        
        while(!stack2.isEmpty() || root2!=null){
            while(root2!=null){
                stack2.push(root2);
                root2=root2.left;
            }
            
            root2 = stack2.pop();
            if(set.contains(root2.val)) return true;
            root2 = root2.right;
        }
        
        return false;
    }
}
