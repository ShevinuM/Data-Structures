'''
Given an integer n, return true if it is a power of three. Otherwise, return false.

An integer n is a power of three, if there exists an integer x such that n == 3x.
'''

# I initially attempted doing this using log base 3, but that doesn't work because of 
# floating point precision errors. 
# This was my next solution which continuosly divides a number by 3 if the number is an 
# integer and greater than 1 and returns true if the number is 1. It multiplies the 
# number by 3 if the number is less than 1 and returns false if the number doesn't reach
# 1.
# It has a time complexity of O(log3(n)) and a space complexity of O(1).
class Solution:
    def isPowerOfThree(self, n: int) -> bool:
        isFloating = True if n > 0 and n < 1 else False
        while n > 0:
            if n == 1:
                return True
            n = n * 3 if isFloating else n / 3
        return False