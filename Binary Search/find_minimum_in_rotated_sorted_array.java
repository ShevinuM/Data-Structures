/**
 * Suppose an array of length n sorted in ascending order is rotated between 1
 * and n times. For example, the array nums = [0,1,2,4,5,6,7] might become:
 * [4,5,6,7,0,1,2] if it was rotated 4 times.
 * [0,1,2,4,5,6,7] if it was rotated 7 times.
 * Notice that rotating an array [a[0], a[1], a[2], ..., a[n-1]] 1 time results
 * in the array [a[n-1], a[0], a[1], a[2], ..., a[n-2]].
 *
 * Given the sorted rotated array nums of unique elements, return the minimum
 * element of this array.
 * You must write an algorithm that runs in O(log n) time.
 *
 * Example 1:
 * Input: nums = [3,4,5,1,2]
 * Output: 1
 * Explanation: The original array was [1,2,3,4,5] rotated 3 times.
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2]
 * Output: 0
 * Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4
 * times.
 * Example 3:
 * Input: nums = [11,13,15,17]
 * Output: 11
 * Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 5000
 * -5000 <= nums[i] <= 5000
 * All the integers of nums are unique.
 * nums is sorted and rotated between 1 and n times.
 */

class Solution {
    public int findMin(int[] nums) {
        /**
         * We first check if the current portion is sorted. If it is the left
         * most value will always be less than the right most value. If it is
         * sorted we return the left most minimum of the values we have obtained
         * so far.
         * 
         * If the current portion is not sorted. we get the mid and make it the result
         * if the
         * current mid is lower than the current result. We have to do this because mid
         * is
         * always ignored when comparing the two partitions.
         * 
         * Then we chek if nums[mid] is greater than or equal to the leftmost, if so we
         * search
         * the right side else the left side.
         */
        int left = 0;
        int right = nums.length - 1;
        int mid = 0;
        int res = nums[0];
        while (left <= right) {
            if (nums[left] < nums[right]) {
                res = Math.min(nums[left], res);
                break;
            }
            mid = left + (right - left) / 2;
            res = Math.min(nums[mid], res);
            if (nums[mid] >= nums[0]) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return res;
    }
}
