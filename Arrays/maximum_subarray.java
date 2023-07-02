/*
Given an integer array nums, find the contiguous subarray with the largest sum, and return its sum.

Example 1:
Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.

Example 2:
Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.

Example 3:
Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.

Constraints:
1 <= nums.length <= 10^5
-10^4 <= nums[i] <= 10^4
*/
class Solution {
    /*
     * This solution keeps track of the current sum and the maximum sum. The current sum is calculated by adding the current
     * number to the current sum if the current sum is greater than or equal to 0. If the current sum is less than 0, then
     * current sum is reset to the current number because adding the current number with a negative value will only decrease
     * the sum. The maximum sum is updated if the current sum is greater than the maximum sum.
     * 
     * Time complexity: O(n) where n is the length of the array
     */
    public int maxSubArray(int[] nums) {
        int curr_sum = 0;
        int max_sum = nums[0];
        for (int num : nums) {
            curr_sum = curr_sum >= 0 ? curr_sum + num : num;
            if (curr_sum > max_sum) { max_sum = curr_sum; }
        }
        return max_sum;
    }
}

