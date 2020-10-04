// https://leetcode.com/problems/even-odd-tree/
// Brute force
class Solution {
// tc -> n, sc-> n
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        int level = 0;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            List<Integer> increasingArr = new LinkedList<>();
            List<Integer> decreasingArr = new LinkedList<>();
         
            for(int i=0; i<size; i++){                
                TreeNode node = q.poll();
                
                if(level%2==0){                  
                    if(node.val%2==0) return false;
                    
                    increasingArr.add(node.val);
                    
                    if(node.left!=null) q.offer(node.left);
                    if(node.right!=null) q.offer(node.right);                     
                }else{
                    if(node.val%2!=0) return false;
                    
                    decreasingArr.add(node.val);
                    
                    if(node.left!=null) q.offer(node.left);
                    if(node.right!=null) q.offer(node.right);                    
                }
            }
            
            if(!isIncreasing(increasingArr)) return false;
            
            if(!isDecreasing(decreasingArr)) return false;
            
            level++;
        }
        
        return true;
    }
    
    private boolean isIncreasing(List<Integer> arr){
        for(int i=0; i<arr.size()-1; i++){            
            if(arr.get(i) >= arr.get(i+1)){
                return false;
            } 
        }
        
        return true;
    }
    
    private boolean isDecreasing(List<Integer> arr){
        for(int i=0; i<arr.size()-1; i++){
            if(arr.get(i) <= arr.get(i+1)){
                return false;
            }
        }
        
        return true;
    }
}

// Better
class Solution {
    // tc -> n, sc-> n
    public boolean isEvenOddTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        
        boolean isEven = true;
        
        while(!q.isEmpty()){
            int size = q.size();
            
            int prevVal = isEven ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            
            for(int i=0; i<size; i++){
                TreeNode node = q.poll();
                
                if(isEven){
                    if(node.val%2==0 || (prevVal >= node.val)) return false;
                    
                }else{
                    if((node.val%2!=0) || prevVal <= node.val) return false;
                    
                }
                
                prevVal = node.val;
                    
                if(node.left!=null) q.offer(node.left);
                if(node.right!=null) q.offer(node.right);
            }
            
            isEven = !isEven;
        }
        
        return true;
    }
}
