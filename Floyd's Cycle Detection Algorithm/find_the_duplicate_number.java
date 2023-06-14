/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * There is only one repeated number in nums, return this repeated number.
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 * 
 * Example 1:
 * Input: nums = [1,3,4,2,2]
 * Output: 2
 * 
 * Example 2:
 * Input: nums = [3,1,3,4,2]
 * Output: 3
 * 
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem in linear runtime complexity?
 */

class Solution {
    /**
    * I initially solved this using two pointers which was O(n^2) time complexity, however my solution 
    * failed the time limit test so I had to figure out a way to do this in a better time complexity. I then
    * came across an algorithm that could do this which is Floyd's cycle detection algorithm.
    */
    public int findDuplicate(int[] nums) {
        /**
        * We treat this almost as a linked list. If I take,
        *   nums         = [1, 3, 4, 2, 2]
        *   nums_indices = [0, 1, 2, 3, 4]
        *   We start with the 0th index, we can see that the 0th index points to 1, then we move to the 1st
        *   index. we can see that the 1st index points to 3, then we move to the 3rd index. We can see that the 3rd index
        *   points to 2, then we move to the 2nd index. We can see that the 2nd index points to 4, then we move to the 4th. We
        *  can see that the 4th index points to 2. This is where the cycle happens. 
        */

        int slow1 = 0;
        int slow2 = 0;
        int fast = 0;

        /**
        * First we have a slow pointer and a fast pointer. The slow pointer moves one index at a time, while the fast pointer
        * moves two indices at a time. We can see that the slow pointer and the fast pointer will eventually meet at some
        * point. If they don't meet, in other words if the fast pointer reaches null, then there is no cycle and hence that's
        * the answer to the first question. We stop when the fast pointer is equal to the slow pointer
        */
        do {
            slow1 = nums[slow1];
            fast = nums[nums[fast]];
        } while (slow1 != fast);

        /**
         * We then take another slow pointer and move both the slow pointers one index at a time. We stop when the two slow
         * pointers are equal to each other. Now both pointers are at the start of the cycle.
         */
        do {
            slow1 = nums[slow1];
            slow2 = nums[slow2];
        } while (slow1 != slow2);
        return slow1;
    }
}