/*
You are given an integer array coins representing coins of different denominations 
and an integer amount representing a total amount of money.

Return the fewest number of coins that you need to make up that amount. 
If that amount of money cannot be made up by any combination of the coins, return -1.

You may assume that you have an infinite number of each kind of coin.

Example 1:
Input: coins = [1,2,5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1

Example 2:
Input: coins = [2], amount = 3
Output: -1

Example 3:
Input: coins = [1], amount = 0
Output: 0

Constraints:
1 <= coins.length <= 12
1 <= coins[i] <= 2^31 - 1
0 <= amount <= 10^4
*/

// Brute Force Approach
class Solution1 {
    /*
     * I traverse every single path and add the number coins on the path to reach the target amount to a set. Then i return
     * the minimum value of the set. 
     */
    HashSet<Integer> fewestSet = new HashSet<>();
    int[] coins;
    int amount;
    public int coinChange(int[] coins, int amount) {
        this.coins = coins;
        this.amount = amount;
        traverse(0, 0);
        return fewestSet.stream().min(Integer::compareTo).orElse(-1);
    }

    public void traverse(int sum, int count) {
        if (sum == this.amount) {
            this.fewestSet.add(count);
            return;
        } 
        if (sum > this.amount) {
            return;
        }
        for (int coin:this.coins) {
            if (coin > this.amount) { return; }
            traverse(sum + coin, count + 1);
        }
    }
}

// Optimal Solution using Dynamic Programming
class Solution2 {
    /*
     * For this solution I'm using dynamic programming. I'm using bottom up construction where I'm calculating the number
     * of coins needed to reach every sum less than or equal to the amount. I'm using a 2D array to store the values. Each
     * column represents 0 -> amount. Each row from the 2nd row represents the coin. The first row is a dummy row storing
     * the maximum value to avoid errors when comparing later on. 
     * 
     * I check if the coin is greater than the sum. If so, I copy the value from the previous row to reach the same sum 
     * because there is no way we are reaching that sum with this coin so the minimum number of coins needed to reach that
     * sum is the same as the previous row.
     * 
     * If the coin is equal to the sum, then that is obviously the shortest path to reach that sum. So the dp is updated.
     * 
     * If the coin is less than the sum, then we have 2 choices. Either we can use the coin to see if it yields a shorter
     * path or we can not use the coin. If we use the coin, then we check if the value in the dp array at the index 
     * (sum - coin) is not equal to Integer.MAX_VALUE. If it is not, then we add 1 to that value and compare it with the
     * value in the previous row at the same index. If it is less than the value in the previous row, then we update the
     * dp array with the new value. If it is not, then we just copy the value from the previous row. The reason we subtract
     * the coin from the sum is because we are using the coin and we need to subtract it from the sum to get the remaining
     * sum.
     * 
     * Time Complexity: O(n*m) where n is the number of coins and m is the amount
     * Space Complexity: O(n*m) where n is the number of coins and m is the amount
     */
    public int coinChange(int[] coins, int amount) {
        if (amount == 0) { return 0; }

        // Intiializing the dynamic programming 2D array
        int[][] dp = new int[coins.length+1][amount+1];

        // Here I'm adding the first row of the dp array with the value of Integer.MAX_VALUE 
        for (int index = 0; index < amount + 1; index++){ dp[0][index] = Integer.MAX_VALUE; }

        /*
        *      0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11
        *    [[i, i, i, i, i, i, i, i, i, i,  i,  i]
        *1 -> [0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0]
        *2 -> [0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0]
        *5 -> [0, 0, 0, 0, 0, 0, 0, 0, 0, 0,  0,  0]]
        */
        int coin;
        for (int coin_count = 0; coin_count < coins.length; coin_count++) {
            coin = coins[coin_count];
            for (int sum = 0; sum <= amount; sum++) {
                if (coin > sum) {
                    dp[coin_count+1][sum] = dp[coin_count][sum];
                } else if (coin == sum) {
                    dp[coin_count+1][sum] = 1;
                } else {
                    if (dp[coin_count+1][sum-coin] != Integer.MAX_VALUE) {
                        dp[coin_count+1][sum] = Math.min(dp[coin_count][sum], dp[coin_count+1][sum-coin]+1);
                    } else {
                        dp[coin_count+1][sum] = dp[coin_count][sum];
                    }
                    
                }

            }
        }
        return dp[coins.length][amount] != Integer.MAX_VALUE ? dp[coins.length][amount] : -1;
        
    }
}