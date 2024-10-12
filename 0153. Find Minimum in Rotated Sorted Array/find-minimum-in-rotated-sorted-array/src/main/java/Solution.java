public class Solution {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        return findMinHelper(nums, left, right);
    }

    private int findMinHelper(int[] nums, int left, int right) {
        int mid = (left + right) / 2;
        if (nums[mid] > nums[right]) {
            left = mid + 1;
            return findMinHelper(nums, left, right);
        } else if (nums[mid] < nums[right]) {
            right = mid;
            return findMinHelper(nums, left, right);
        } else if (left == right) {
            return nums[left];
        }
        return nums[0];
    }
}