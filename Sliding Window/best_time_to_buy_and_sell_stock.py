'''
You are given an array prices where prices[i] is the price of a given stock on the ith day.

You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.

Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
'''

def maxProfit(prices):
    if len(prices) <= 1:
        return 0
    l,r,maxProfit = 0, 1, 0
    while r < len(prices):
        if prices[r] < prices[l]:
            l,r = r,r+1
        else:
            profit = prices[r]-prices[l]
            maxProfit = profit if profit > maxProfit else maxProfit
            r+=1
    return maxProfit

def test(prices):
    print("Input : prices = {0} \n"
          "Output: {1} \n".format(prices,maxProfit(prices)))

test([7,1,5,3,6,4])
test([7,6,4,3,1])