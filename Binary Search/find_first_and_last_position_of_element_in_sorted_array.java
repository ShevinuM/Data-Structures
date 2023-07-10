/**
 * Given an array of integers nums sorted in non-decreasing order, 
 * find the starting and ending position of a given target value.
 * If target is not found in the array, return [-1, -1].
 *
 * You must write an algorithm with O(log n) runtime complexity.
 * 
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 * Example 3:
 * Input: nums = [], target = 0
 * Output: [-1,-1]
 * 
 * Constraints:
 * 0 <= nums.length <= 105
 * -109 <= nums[i] <= 109
 * nums is a non-decreasing array.
 * -109 <= target <= 109
 */
class Solution {
    /*
     * For this solution I'm using binary search. Once we find the target, we seperate the array into two parts and
     * search for the target in each part. We do this until left > right and at this point the last index is stored which is returned.
     */
    public int[] searchRange(int[] nums, int target) {
        return new int[]{binarySearch(nums, target, true), binarySearch(nums, target, false)};
    }

    public int binarySearch(int[] nums, int target, Boolean findFirst) {
        int left = 0;
        int right = nums.length-1;
        int mid;
        int index = -1;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                index = mid;
                if (findFirst) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return index;
    }
}