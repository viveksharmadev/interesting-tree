// // https://leetcode.com/problems/find-largest-value-in-each-tree-row/
class Solution {
    // tc -> n^2, sc-> n
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        
        if(root==null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        result.add(root.val);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            List<Integer> list = new ArrayList<>();
            
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                
                if(node.left!=null){
                    q.offer(node.left);
                    list.add(node.left.val);
                }
                
                if(node.right!=null){
                    q.offer(node.right);
                    list.add(node.right.val);
                }
            }
            
            if(list.size()>0){
                int max = getMax(list);            
                result.add(max);
            }
        }
        
        return result;
    }
    
    private int getMax(List<Integer> list){
        int max = Integer.MIN_VALUE;
        
        for(int i=0; i<list.size(); i++){
            if(max < list.get(i)){
                max = list.get(i);
            }
        }
        
        return max;
    }
}

class Solution {
    // tc -> n, sc-> n
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        
        if(root==null) return result;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        while(!q.isEmpty()){
            int size = q.size();
            
            int max = Integer.MIN_VALUE;
            
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                
                max = Math.max(max, node.val);
                
                if(node.left!=null){
                    q.offer(node.left);
                }
                
                if(node.right!=null){
                    q.offer(node.right);
                }
            }
            
            result.add(max);
        }
        
        return result;
    }
}
