/**
 * A peak element is an element that is strictly greater than its neighbors.
 * 
 * Given a 0-indexed integer array nums, the task is to find a peak element, and return its index. 
 * If the array contains multiple peaks, return the index to any of the peaks.
 *
 * You may imagine that nums[-1] = nums[n] = -∞. 
 * In other words, an element is always considered to be strictly greater than a neighbor that is outside the array.
 *
 * You must write an algorithm that runs in O(log n) time.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * 
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak element is 2, 
 *              or index number 5 where the peak element is 6.
 *
 * Constraints:
 *
 * 1 <= nums.length <= 1000
 * -231 <= nums[i] <= 231 - 1
 * nums[i] != nums[i + 1] for all valid i.
 */

/*
 * This solution uses binary search. We check if the middle element is a peak, if it is we return true. The peak element
 * is stored in the beak variable instead of returning it. Instead, I'm returning true or false to indicate if a peak was 
 * found. If the peak is found we can return true and stop the recursion. 
 */

class Solution {
    int[] nums;
    int peak;
    public int findPeakElement(int[] nums) {
        this.nums = nums;
        binarySearch(0, nums.length - 1);
        return peak;
    }

    public Boolean binarySearch(int left, int right) {
        if (left > right) { return false; }
        int mid = (left + right) / 2;
        int left_neighbour = mid-1 >= 0 ? nums[mid-1] : Integer.MIN_VALUE;
        int right_neighbour = mid+1 < nums.length ? nums[mid+1] : Integer.MIN_VALUE;
        if (left_neighbour < nums[mid] && right_neighbour < nums[mid]) {
            peak = mid;
            return true; 
        }
        return binarySearch(left, mid-1) || binarySearch(mid+1, right);
    }
}