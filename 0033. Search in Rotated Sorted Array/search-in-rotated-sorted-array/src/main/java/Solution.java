public class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        return searchHelper(nums, target, left, right);
    }

    private int searchHelper(int[] nums, int target, int left, int right) {
        int mid = (left + right) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        if (nums[mid] > nums[right]) {
            if (target <= nums[mid] && target >= nums[left]) {
                right = mid;
                return searchHelper(nums, target, left, right);
            } else {
                left = mid + 1;
                return searchHelper(nums, target, left, right);
            }
        } else if (nums[mid] < nums[right]) {
            if (target >= nums[mid + 1] && target <= nums[right]) {
                left = mid + 1;
                return searchHelper(nums, target, left, right);
            } else {
                right = mid;
                return searchHelper(nums, target, left, right);
            }
        }
        return -1;
    }
}
