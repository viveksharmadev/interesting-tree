// https://leetcode.com/problems/find-elements-in-a-contaminated-binary-tree/
class FindElements {

    // tc -> n, sc-> n
    private Set<Integer> visited;
    
    public FindElements(TreeNode root) {
        visited = new HashSet<>();
        buildTree(root, 0);
    }
    
    private void buildTree(TreeNode root, int val){
        if(root==null) return;
        visited.add(val);
        root.val = val;
        buildTree(root.left, 2*val+1);
        buildTree(root.right, 2*val+2);
    }
    
    public boolean find(int target) {
        return visited.contains(target);
    }
}
