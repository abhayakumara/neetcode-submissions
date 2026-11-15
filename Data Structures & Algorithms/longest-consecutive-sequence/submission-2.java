class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int a : nums) {
            set.add(a);
        }
        int globalMax = 0;
        for(int i=0; i<nums.length; i++) {
            // identify start of the seq
            // in the set does not contains the previous value, that means it's the start of the seq

            if(!set.contains(nums[i] - 1)) {
                int curr = nums[i];
                int localMax = 0;
                while(set.contains(curr)) {
                    curr++;
                    localMax++;
                }
                globalMax = Math.max(globalMax, localMax);
            }
        }

        return globalMax;
    }
}
