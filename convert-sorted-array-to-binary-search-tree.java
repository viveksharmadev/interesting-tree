// https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree/
class Solution {
    // tc -> n, sc-> n
    public TreeNode sortedArrayToBST(int[] nums) {
        return getBSTFromSortedArray(nums, 0, nums.length-1);
    }
    
    private TreeNode getBSTFromSortedArray(int[] nums, int start, int end){
        if(start>end) return null;
        
        int mid = start + (end-start)/2;
        
        TreeNode root = new TreeNode(nums[mid]);
        
        root.left = getBSTFromSortedArray(nums, start, mid-1);
        root.right = getBSTFromSortedArray(nums, mid+1, end);
        
        return root;
    }
}
