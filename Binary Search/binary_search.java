/*
Given an array of integers "nums" which is sorted in ascending order, and an integer "target", write a function to search "target" in "nums". If "target" exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.

Example 1:
Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4

Example 2:
Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1

Constraints:
1. The length of the "nums" array is between 1 and 10^4, inclusive.
2. Each element in the "nums" array and the "target" is an integer between -10^4 and 10^4, exclusive.
3. All the integers in "nums" are unique.
4. "nums" is sorted in ascending order.
*/

class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 1 && nums[0] == target) { return 0; }
        int left = 0;
        int right = nums.length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        return -1;
    }
}