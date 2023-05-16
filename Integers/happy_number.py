'''
Write an algorithm to determine if a number n is happy.

A happy number is a number defined by the following process:

Starting with any positive integer, replace the number by the sum of the squares of its digits.
Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
Those numbers for which this process ends in 1 are happy.
Return true if n is a happy number, and false if not.
'''

class Solution:
    def isHappy(self, n: int) -> bool:
        sum_set = set()
        while True:
            if n == 1:
                return True
            sum = 0
            while n != 0:
                sum = sum + (n%10)**2
                n = n//10
            n = sum
            if n in sum_set:
                return False
            sum_set.add(sum)
    
    def test(self, n):
        print("Input: {0}, Output: {1}".format(n, self.isHappy(n)))

sol = Solution()
sol.test(19)
sol.test(2)