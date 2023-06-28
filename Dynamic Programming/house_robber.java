/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed. The only constraint stopping you from robbing each of them is that adjacent houses have security systems connected, and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given an integer array 'nums' representing the amount of money of each house, you need to determine the maximum amount of money you can rob tonight without alerting the police.

Example 1:

Input: nums = [1,2,3,1]
Output: 4
Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
Total amount you can rob = 1 + 3 = 4.

Example 2:

Input: nums = [2,7,9,3,1]
Output: 12
Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
Total amount you can rob = 2 + 9 + 1 = 12.

Constraints:

1. The length of 'nums' array (i.e., the number of houses) is between 1 and 100, inclusive.
2. The amount of money at each house is a non-negative integer and does not exceed 400.
*/

class Solution {
    /*
     * For this solution, we will use a dynamic programming approach. We will create an array which store
     * the maximum amount of money that can be robbed up until that house. We will then iterate through
     * the array and update dp. At the end we return the last element in dp.
     */
    public int rob(int[] nums) {
         if (nums.length == 1) { return nums[0]; }
         if (nums.length == 2) { return Math.max(nums[0], nums[1]); }

         int[] dp = new int[nums.length+1];
         dp[0] = 0;
         dp[1] = nums[0];

         for (int index = 1; index < nums.length; index++) {
             dp[index+1] = Math.max(dp[index], dp[index-1]+nums[index]);
         }
         return dp[nums.length];
    }
}