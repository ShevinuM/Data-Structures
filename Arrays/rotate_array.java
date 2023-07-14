/*
Given an integer array nums, the task is to rotate the array to the right by k steps, where k is non-negative.

Example 1:
----------
Input: nums = [1,2,3,4,5,6,7], k = 3
Output: [5,6,7,1,2,3,4]
Explanation:
- Rotate 1 steps to the right: [7,1,2,3,4,5,6]
- Rotate 2 steps to the right: [6,7,1,2,3,4,5]
- Rotate 3 steps to the right: [5,6,7,1,2,3,4]

Example 2:
----------
Input: nums = [-1,-100,3,99], k = 2
Output: [3,99,-1,-100]
Explanation: 
- Rotate 1 steps to the right: [99,-1,-100,3]
- Rotate 2 steps to the right: [3,99,-1,-100]

Constraints:
----------
1. 1 <= nums.length <= 105
2. -231 <= nums[i] <= 231 - 1
3. 0 <= k <= 105

Follow up:
----------
Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
Could you do it in-place with O(1) extra space?
*/

class Solution {
    /*
     * First I mod k by the length of the array because if k is greater than the length of the array, then the array will
     * rotate by the same amount as if k was k%nums.length. For example if k = 7 and nums.length = 4, then the array will
     * rotate by 3 because 7%4 = 3. If k is less than the length of the array, then the array will rotate by k. 
     * Then I reverse the array.
     *  [1,2,3,4,5,6,7] -> [7,6,5,4,3,2,1]
     * Then I reverse the first elements upto and including index k-1.
     *  [7,6,5,4,3,2,1] -> [5,6,7,4,3,2,1]
     * Then I reverse the rest of the last elements.
     *  [5,6,7,4,3,2,1] -> [5,6,7,1,2,3,4]
     * Now the array is rotated by k.
     */
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        if (nums.length <= 1) { return; }
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    public void reverse(int[] nums, int start, int end) {
        int temp;
        while (start < end) {
            temp = nums[end];
            nums[end] = nums[start];
            nums[start] = temp;
            start++;
            end--;
        }
    }
}