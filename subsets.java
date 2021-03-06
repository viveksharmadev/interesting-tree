// https://leetcode.com/problems/subsets/
class subsets {
    // tc -> 2^n, sc-> n
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums==null || nums.length==0) return res;
        setSubsets(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }
    
    private void setSubsets(int[] nums, List<List<Integer>> res, List<Integer> list, int index){
        res.add(new ArrayList(list));
        for(int i=index; i<nums.length; i++){
            list.add(nums[i]);
            setSubsets(nums, res, list, i+1);
            list.remove(list.size()-1);
        }        
    }
}
