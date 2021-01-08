// https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/
class Solution {
    // tc -> n, sc-> n
    public int maxLevelSum(TreeNode root) {
        int minLevel = 1, maxVal = Integer.MIN_VALUE;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int level = 1;
        
        while(!q.isEmpty()){
            
            int size = q.size();
            
            int sum = 0;
            
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                
                sum += node.val;
                
                if(node.left != null) q.offer(node.left);
                
                if(node.right!=null) q.offer(node.right);
            }
            
            if(maxVal < sum){
                maxVal = sum;
                minLevel = level;
            }
            
            level++;
        }
        
        return minLevel;
    }
}
