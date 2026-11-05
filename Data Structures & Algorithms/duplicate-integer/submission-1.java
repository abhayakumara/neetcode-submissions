class Solution {
    public boolean hasDuplicate(int[] nums) {
        int n = nums.length;
        var set = new HashSet<Integer>();
        for(int a : nums) set.add(a);

        return set.size() != n;
    }
}