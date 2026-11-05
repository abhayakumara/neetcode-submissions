class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        var map = new HashMap<Integer, Integer>();

        for(int i=0; i<n; i++) {
            if(map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }

        return new int[]{-1, -1};
    }
}
