class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        int start = 0;
        backtrack(nums, target, cur, start);
        return ans;
    }

    private void backtrack(int[] nums, int target, List<Integer> cur, int i) {
        if(target == 0) {
            ans.add(new ArrayList<>(cur));
            return;
        }

        if(i >= nums.length || target < 0) {
            return;
        }

        cur.add(nums[i]);
        backtrack(nums, target-nums[i], cur, i);
        cur.remove(cur.size() - 1);
        backtrack(nums, target, cur, i+1);
    }
}
