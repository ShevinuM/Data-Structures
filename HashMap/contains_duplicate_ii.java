/*
Given an integer array nums and an integer k, return true if there are two distinct indices 
i and j in the array such that nums[i] == nums[j] and abs(i - j) <= k.

Example 1:
Input: nums = [1,2,3,1], k = 3
Output: true

Example 2:
Input: nums = [1,0,1,1], k = 1
Output: true

Example 3:
Input: nums = [1,2,3,1,2,3], k = 2
Output: false

Constraints:
1 <= nums.length <= 105
-109 <= nums[i] <= 109
0 <= k <= 105
*/
class Solution {
    /*
     * In this solution, I'm using a hashmap to keep track of the numbers in nums and their indices. I iterate through nums
     * and add the last visited index of each number to the hashmap. If the number is already in the hashmap, then I check if
     * the interval between the two indices is less than or equal to k. If so, I return true. If not, I update the index of
     * the hashmap.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums.length <= 1) { return false; }
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int index=0; index < nums.length; index++) {
            if (map.containsKey(nums[index])) {
                if (Math.abs(index - map.get(nums[index])) <= k) { return true; }
            }
            map.put(nums[index], index);
        }
        return false;
    }
}
