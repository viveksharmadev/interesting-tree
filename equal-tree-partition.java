// https://leetcode.com/problems/equal-tree-partition/
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
class equal-tree-partition {
    // tc -> n, sc-> n
    public boolean checkEqualTree(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        int sum = getSum(root, map);
        if(sum==0) 
            return map.getOrDefault(sum,0)>1;
        return sum%2==0 && map.containsKey(sum/2);
    }
    
    private int getSum(TreeNode root, Map<Integer, Integer> map){
        if(root==null) return 0;                
        int left = getSum(root.left, map);
        int right = getSum(root.right, map);
        int sum = left + right + root.val;
        map.put(sum, map.getOrDefault(sum, 0)+1);
        return sum;
    }
    
    // Same code just seperate conditions for clarity
    // tc -> n, sc-> n
    public boolean checkEqualTree(TreeNode root) {
        if(root==null) return false;
        Map<Integer, Integer> countMap = new HashMap<>();
        int sum = getSum(root, countMap);
        if(sum==0) return countMap.getOrDefault(sum,0) > 1;
        if(sum%2!=0) return false;
        return countMap.containsKey(sum/2);
    }
    
    private int getSum(TreeNode root, Map<Integer, Integer> countMap){
        if(root==null) return 0;
        int left = getSum(root.left, countMap);
        int right = getSum(root.right, countMap);
        int sum = root.val + left + right;
        countMap.put(sum, countMap.getOrDefault(sum,0)+1);
        return sum;
    }
}
