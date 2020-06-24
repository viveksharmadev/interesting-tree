// https://leetcode.com/problems/unique-binary-search-trees/
class unique-binary-search-trees {
    // tc -> n^2, sc-> n
    Map<Integer, Integer> cache = new HashMap<>();
    public int numTrees(int n) {
        if(cache.containsKey(n)) return cache.get(n);
        if(n <= 1) return 1;
        int sum = 0;
        for(int i=1; i<=n; i++){
            int left = numTrees(i-1);
            int right = numTrees(n-i);
            sum += left*right;
        }
        cache.put(n, sum);
        return sum;
    }
}
