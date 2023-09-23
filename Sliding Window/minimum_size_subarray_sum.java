/**
 * Given an array of positive integers nums and a positive integer target,
 * return the minimal length of a contiguous subarray whose sum is greater
 * than or equal to target. If there is no such subarray, return 0 instead.
 *
 * Example 1:
 * Input: target = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: The subarray [4,3] has the minimal length under the problem
 * constraint.
 *
 * Example 2:
 * Input: target = 4, nums = [1,4,4]
 * Output: 1
 *
 * Example 3:
 * Input: target = 11, nums = [1,1,1,1,1,1,1,1]
 * Output: 0
 *
 * Constraints:
 * 1 <= target <= 10^9
 * 1 <= nums.length <= 10^5
 * 1 <= nums[i] <= 10^4
 */

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if (nums.length == 1 && nums[0] < target) {
            return 0;
        }
        int sum = nums[0];
        int left = 0;
        int right = 0;
        int res = Integer.MAX_VALUE;
        while (right < nums.length) {
            if (sum >= target) {
                res = (right - left + 1) < res ? (right - left + 1) : res;
                if (left < right) {
                    sum -= nums[left];
                    left++;
                } else {
                    return res;
                }
            } else {
                right++;
                if (right < nums.length)
                    sum += nums[right];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;

        // target = 7, nums = [2,3,1,2,4,3], nums.length = 6
        // sum = 2
        // left = 0
        // right = 0
        // res = inf
        // 0 < 6 -> true
        // 2 >= 7 -> false
        // right = 1;
        // 1 < 7 -> true -> sum = 2 + 3 = 5
        // 1 < 6 -> true
        // 5 >= 7 -> false
        // right = 2
        // 2 < 7 -> true -> sum = 5 + 1 = 6
        // 2 < 6 -> true
        // 6 >= 7 -> false
        // right = 3
        // 3 < 7 -> true -> sum = 6 + 2 = 8
        // 3 < 6 -> true
        // 8 >= 7 -> true
        // res = 4
        // 0 < 3 -> true
        // sum = 8 - 2 = 6
        // left = 1
        // 3 < 6 -> true
        // 6 >= 7 -> false
        // right = 4
        // 4 < 6 -> true -> sum = 6 + 4 = 10
        // 4 < 6 -> true
        // 10 >= 7 -> true
        // res = 4
        // 1 < 4 -> true
        // sum = 10 - 3 = 7
        // left = 2
        // 4 < 6 -> true
        // 7 >= 7 -> true
        // res = 3
        // 2 < 4 -> true
        // sum = 7 - 1 = 6
        // left = 3
        // 4 < 6 -> true
        // 6 >= 7 -> false
        // right = 5
        // 5 < 6 -> true -> sum = 6 + 3 = 9
        // 5 < 6 -> true
        // 9 >= 7 -> true
        // res = 3
        // 3 < 5 -> true
        // sum = 9 - 2 = 7
        // left = 4
        // 5 < 6 -> true
        // 7 >= 7 -> true
        // res = 2
        // 4 < 5 -> true
        // sum = 7 - 4 = 3
        // left = 5
        // 5 < 6 -> true
        // 3 >= 7 -> false
        // right = 6
    }
}
