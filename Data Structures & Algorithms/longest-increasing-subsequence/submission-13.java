class Solution {
    Integer[][] dp;
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        dp = new Integer[n+1][n+1];
        int currIndex = 0, prevIndex = -1;
        return helperMemo(nums, currIndex, prevIndex);
    }

    private int helper(int[] nums, int currIndex, int prevIndex) {
        if(currIndex == nums.length) {
            return 0;
        }
        int take = 0, skip = 0;
        if(prevIndex == -1 || nums[currIndex] > nums[prevIndex]) {
            take = 1 + helper(nums, currIndex + 1, currIndex);
        }
        skip = helper(nums, currIndex + 1, prevIndex);
        return Math.max(take, skip);
    }

    private int helperMemo(int[] nums, int currIndex, int prevIndex) {
        if(currIndex == nums.length) {
            return 0;
        }

        if(prevIndex != -1 && dp[currIndex][prevIndex + 1] != null) {
            return dp[currIndex][prevIndex + 1];
        }
        int take = 0, skip = 0;
        if(prevIndex == -1 || nums[currIndex] > nums[prevIndex]) {
            take = 1 + helperMemo(nums, currIndex + 1, currIndex);
        }
        skip = helperMemo(nums, currIndex + 1, prevIndex);
        dp[currIndex][prevIndex + 1] = Math.max(take, skip);
        return dp[currIndex][prevIndex + 1];
    }

}
