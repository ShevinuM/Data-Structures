/*
 * You are given an integer array nums. You are initially positioned at the array's first index, 
 * and each element in the array represents your maximum jump length at that position.
 *
 * Return true if you can reach the last index, or false otherwise.
 *
 * Example 1:
 * Input: nums = [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: nums = [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum jump length is 0, 
 * which makes it impossible to reach the last index.
 *
 * Constraints:
 * 1 <= nums.length <= 10^4
 * 0 <= nums[i] <= 10^5
 */

// Brute-Force Approach
/*
 * In this approach, I'm traversing every single path from the first index to the last index. If I reach the last index, then
 * I return true. If I can't reach the last index, then I return false. This approach is O(n^n) time complexity.
 */
class Solution1 {
    int[] nums;
    public boolean canJump(int[] nums) {
        this.nums = nums;
        return traverse(0);
    }

    public boolean traverse(int index) {
        if (index == nums.length-1) { return true; }
        if (index >= nums.length) { return false; }
        for (int count = 1; count <= nums[index]; count++) {
            if (nums[index] == 0) { return false; }
            boolean res = traverse(index+count);
            if (res == true) { return true; }
        }
        return false;
    }
}

// Optimized O(n) Approach
/*
 * In this approach, I work backwards from the last index. I keep track of the target index, which starts from the last index.
 * I compare this to the previous index and check if I can reach the target index from there. if so, I set the target index to
 * the previous index. I keep doing this until I reach the first index. If the target index is 0, then I return true else I 
 * return false.
 */
class Solution2 {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) { return true; }
        int target = nums.length-1;
        for (int pointer = target-1; pointer >= 0; pointer--) {
            if (nums[pointer] + pointer >= target) { target = pointer; }
        }
        return target == 0;
    }
}
