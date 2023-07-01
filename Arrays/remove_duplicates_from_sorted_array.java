/**
 * Given an integer array nums sorted in non-decreasing order, this function removes duplicates in-place such that 
 * each unique element appears at most twice while keeping the relative order of the elements. The function places
 * the result in the first part of the array nums and returns the length (k) of the array after duplicate removal.
 * 
 * The function does not allocate extra space for another array. It modifies the input array in-place with O(1) extra memory.
 *
 * Example 1:
 *
 * Input: nums = [1,1,1,2,2,3]
 * Output: 5, nums = [1,1,2,2,3,_]
 * Explanation: The function should return k = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
 * It does not matter what values are beyond the returned k.
 *
 * Example 2:
 *
 * Input: nums = [0,0,1,1,1,1,2,3,3]
 * Output: 7, nums = [0,0,1,1,2,3,3,_,_]
 * Explanation: The function should return k = 7, with the first seven elements of nums being 0, 0, 1, 1, 2, 3 and 3 respectively.
 * It does not matter what values are beyond the returned k.
 *
 * Constraints:
 * 1 <= nums.length <= 3 * 10^4
 * -10^4 <= nums[i] <= 10^4
 * nums is sorted in non-decreasing order.
 */
class Solution {
    /*
     * For this solution, I'm using two pointers. First pointer , index , is used to indicate the current index of the array.
     * The next index, toReplace, is used to indicate the index to replace the value at the current index with.
     * When I reach an index where the value of the index is different from the value at the previous index, the counter
     * is reset to 1, then as long as the values at the current and previous indices are equal, the counter is incremented.
     * This basically calculates the number of occurences of the current value. As long as the counter is less than or equal
     * to 2, I replace the value at the current index with the value at toReplace. I then increment toReplace. if the
     * counter is greater than 2 i skip incrementing toReplace and continue to the next index.
     */
    public int removeDuplicates(int[] nums) {
        int toReplace = 1; // pointer which indicates the index to replace the current value with
        int count = 1; // number of occurences of the letter
        for (int index = 1; index < nums.length; index++) {
            if (nums[index] == nums[index-1]) {
                count++;
            } else {
                count = 1;
            }
            if (count <= 2) {
                nums[toReplace] = nums[index];
                toReplace++;
            }
        }
        return toReplace;
    }
}