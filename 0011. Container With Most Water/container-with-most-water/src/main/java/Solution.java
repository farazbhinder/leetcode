public class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        int area = 0;
        while (left <= right) {
            if (height[left] <= height[right]) {
                area = height[left] * (right - left);
                if (maxArea < area) {
                    maxArea = area;
                }
                left++;
            } else if (height[left] > height[right]) {
                area = height[right] * (right - left);
                if (maxArea < area) {
                    maxArea = area;
                }
                right--;
            }
        }
        return maxArea;
    }
}
