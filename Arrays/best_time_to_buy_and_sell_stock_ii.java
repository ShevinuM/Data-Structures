/**
 * You are given an integer array prices where prices[i] is the price of a given stock on the ith day.
 * On each day, you may decide to buy and/or sell the stock. You can only hold at most one share of the stock at any time.
 * However, you can buy it then immediately sell it on the same day.
 * Find and return the maximum profit you can achieve.
 * 
 * Example 1:
 * Input: prices = [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Total profit is 4 + 3 = 7.
 * 
 */

class Solution {
    /**
    7
     .             6
      .      5.   . .
       .   .   . .   4
        . .     3
         1
    So according to the explanation given in the question to the sample
    answers, maximum profit is calculated by summing the differences between
    the two values at each end of the positive slope when we plot it as
    a graph. So the question was a bit confusing initially because i 
    though they were asking for the overall maximum profit but after a while
    looking at the examples they have given i realized that this is not the
    case.
     */
    public int maxProfit(int[] prices) {
        int profit = 0;

        for (int index = 1; index < prices.length; index++) {
            if (prices[index] > prices[index-1]) {
                profit += prices[index] - prices[index-1];
            }
        }
        return profit;
    }
}