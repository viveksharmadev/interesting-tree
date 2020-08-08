// https://leetcode.com/problems/path-sum-iii/
class Solution {
    // tc -> n, sc-> n
    int count = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root==null) return 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,1);
        helper(root, 0, sum, map);
        return count;
    }
    
    private void helper(TreeNode root, int sum, int target, Map<Integer, Integer> map){
        if(root==null) return;
        sum+=root.val;
        if(map.containsKey(sum-target))
            count += map.get(sum-target);
        if(!map.containsKey(sum)){
            map.put(sum, 1);
        }else{
            map.put(sum, map.get(sum)+1);
        }
        
        helper(root.left, sum, target, map);
        helper(root.right, sum, target, map);
        map.put(sum, map.get(sum)-1);
    }
}
