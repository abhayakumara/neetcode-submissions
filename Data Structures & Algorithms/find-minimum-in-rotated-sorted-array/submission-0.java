class Solution {
    int min = Integer.MAX_VALUE;
    public int findMin(int[] nums) {
        int n = nums.length;
        int s = 0, e = n-1;

        while(s <= e) {
            int mid = s + (e - s)/2;
            min = Math.min(min, nums[mid]);

            if(nums[s] <= nums[mid]) {
                min = Math.min(nums[s], min);
                s = mid + 1;
            } else if(nums[mid] <= nums[e]){
                min = Math.min(nums[mid], min);
                e = mid - 1;
            }
        }
        return min;
    }
}
