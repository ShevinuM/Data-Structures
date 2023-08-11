/**
 * Given an array nums of n integers where nums[i] is in the range [1, n],
 * return an array of all the integers in the range [1, n] that do not appear in
 * nums.
 *
 * Example 1:
 * Input: nums = [4, 3, 2, 7, 8, 2, 3, 1]
 * Output: [5, 6]
 *
 * Example 2:
 * Input: nums = [1, 1]
 * Output: [2]
 *
 * Constraints:
 * n == nums.length
 * 1 <= n <= 10^5
 * 1 <= nums[i] <= n
 *
 * Follow up: Could you do it without extra space and in O(n) runtime?
 * You may assume the returned list does not count as extra space.
 */

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int i = 0;
        int temp;
        while (i < nums.length) {
            // [2,1,2]
            if (nums[i] != i + 1) {
                // temp -> 2
                temp = nums[i];
                // nums[0] = 2
                nums[i] = nums[temp - 1] != temp ? nums[temp - 1] : -1;
                nums[temp - 1] = temp;
                // [-1, 1, 2]
                if (nums[i] == -1) {
                    i++;
                }
            } else {
                i++;
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        for (int index = 0; index < nums.length; index++) {
            if (nums[index] == -1) {
                res.add(index + 1);
            }
        }
        return res;
    }
}
