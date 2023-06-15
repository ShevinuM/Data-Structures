/**
 * Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the
 * same color are adjacent, with the colors in the order red, white, and blue.
 * We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.
 * You must solve this problem without using the library's sort function.
 * 
 * Example 1:
 *  Input: nums = [2,0,2,1,1,0]
 *  Output: [0,0,1,1,2,2]
 * 
 * Example 2:
 *  Input: nums = [2,0,1]
 *  Output: [0,1,2]
 * 
 * Could you come up with a one-pass algorithm using only constant extra space?
 */

class Solution {
    /**
     * Time Complexity: O(n), Space Complexity: O(1). We are using 2 pointers to keep track of the left and right
     * partion of the array. The left partition contains the 0s and the right partition contains the 2s. Between
     * the left and right partition, we have the 1s.
     * 
     * First we shift the itr and left so that the left and itr is pointing to the first non-zero element. Then
     * we shift right so that it is pointing to the first non-2 element from the right. Then we iterate through
     * the array, whenever we encounter a 0, we swap with the left pointer element and increment left and itr. 
     * When we encounter a 2, we swap the right pointer element and decrement right. We don't increment itr 
     * because we don't know what element we swapped with the right pointer. This process continues untill itr
     * is less than or equal to the right pointer.
     */
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int itr = 0;
        while (left < nums.length-1 && nums[left] == 0) {
            left++;
            itr++;
        }
        while (right >= 0 && nums[right] == 2 ) {
            right--;
        }
        while (itr <= right) {
            if (nums[itr] == 2) {
                nums[itr] = nums[right];
                nums[right] = 2;
                right--;
            } else if (nums[itr] == 0) {
                nums[itr] = nums[left];
                nums[left] = 0;
                left++;
                itr++;
            } else {
                itr++;
            }
        }
    }
}