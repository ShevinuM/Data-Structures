/*
You are given an integer array cost where cost[i] is the cost of the ith step on a staircase. Once you pay the cost, you can either climb one or two steps.

You can either start from the step with index 0, or the step with index 1.

Return the minimum cost to reach the top of the floor.

Example 1:

Input: cost = [10,15,20]
Output: 15
Explanation: Cheapest is to start on cost[1], pay that cost and then jump to the top.

Example 2:

Input: cost = [1,100,1,1,1,100,1,1,100,1]
Output: 6
Explanation: Cheapest is to start on cost[0], and then move to cost[2] (1), then jump to cost[4] (1), then to cost[6] (1), then to cost[7] (1), then jump to cost[9] (1), and finally to the top (1). Total cost is 6.

Constraints:

- 2 <= cost.length <= 1000
- 0 <= cost[i] <= 999
*/

class Solution {
    /**
        The problem is solved using Dynamic Programming (DP).

        1. Define a DP array: An array `dp` is defined with a size of `cost.length + 1`. This array will store the minimum cost to reach each step.

        2. Initialize base cases: The 0th and 1st step are considered as starting points, so the cost to reach these steps is 0. Hence, `dp[0]` and `dp[1]` are set to 0.

        3. Fill up the DP array: For each step starting from the 2nd step, the minimum cost to reach that step is calculated. The cost to reach the current step (`dp[index]`) is the minimum between the cost to reach the previous step (`dp[index - 1]`) plus the cost of the previous step (`cost[index - 1]`), and the cost to reach the step before the previous step (`dp[index - 2]`) plus the cost of the step before the previous step (`cost[index - 2]`).

        4. Return the final result: The minimum cost to reach the top of the floor is stored in the last cell of the DP array (`dp[dp.length - 1]`).

        The idea behind this solution is to determine at each step whether it would be cheaper to arrive there from the immediately preceding step or the one before that, and use this strategy to build up the minimum cost to reach every step, up to the top of the floor.
    **/

    class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        for (int index = 0; index < dp.length; index++) {
            if (index > 1) { dp[index] = Math.min(dp[index-1] + cost[index-1], dp[index-2] + cost[index-2]); }
        }
        return dp[dp.length - 1];
    }
}
}
