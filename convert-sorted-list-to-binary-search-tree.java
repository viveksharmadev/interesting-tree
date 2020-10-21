// https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
   // tc -> nlogn, sc-> logn
    public TreeNode sortedListToBST(ListNode head) {
        return getBSTFromSortedList(head, null);
    }
    
    private TreeNode getBSTFromSortedList(ListNode head, 
                                          ListNode tail){
        
        if(head==tail) return null;
        
        ListNode slow = head, fast = head.next; // fast = head is also fine
        
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode root = new TreeNode(slow.val);
        
        root.left = getBSTFromSortedList(head, slow);
        root.right = getBSTFromSortedList(slow.next, tail);
        
        return root;
    }
    
}


class Solution {
    // tc -> n, sc-> n
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> nums = new ArrayList<>();
        
        convertListToArray(head, nums);
        
        return getBSTFromArray(nums, 0, nums.size()-1);
    }
    
    private void convertListToArray(ListNode head, List<Integer> nums){
        
        while(head!=null){
        
            nums.add(head.val);            
            
            head = head.next;
        }
    }
    
    private TreeNode getBSTFromArray(List<Integer> nums, int start, int end){
        if(start > end) return null;
        
        int mid = start + (end-start)/2;
        
        TreeNode root = new TreeNode(nums.get(mid));
        
        root.left = getBSTFromArray(nums, start, mid-1);
        root.right = getBSTFromArray(nums, mid+1, end);
        
        return root;
    }
    
}
