// https://leetcode.com/problems/construct-binary-tree-from-string/
class Solution {
    // tc -> n, sc-> n
    public TreeNode str2tree(String s) {
        Stack<TreeNode> stack = new Stack<>();
        
        int i=0, j= 0; 
        
        while(i < s.length()){
            char c = s.charAt(i);
            
            if(!stack.isEmpty() && c==')'){
              stack.pop();  
            } 
            
            else if(c>='0' && c<='9' || c=='-'){
                
                while(i+1 < s.length() 
                      && s.charAt(i+1) >= '0'
                      && s.charAt(i+1) <= '9')
                    i++;
                
                TreeNode currNode 
                    = new TreeNode(Integer.parseInt(s.substring(j, i+1)));
                
                if(!stack.isEmpty()){
                    TreeNode parent = stack.peek();
                    
                    if(parent.left!=null) parent.right = currNode;
                    
                    else parent.left = currNode;
                }
                
                stack.push(currNode);
            }
            
            j = ++i;            
        }
        
        return stack.isEmpty() ? null : stack.pop();
    }
} 
